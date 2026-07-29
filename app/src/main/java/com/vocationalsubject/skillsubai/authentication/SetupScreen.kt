package com.vocationalsubject.skillsubai.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vocationalsubject.skillsubai.ui.navigation.Screen

@Composable
fun SetupScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val profile by viewModel.studentProfile.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Complete Your Profile",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = profile.name,
            onValueChange = viewModel::updateName,
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = profile.school,
            onValueChange = viewModel::updateSchool,
            label = { Text("School Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = profile.studentClass,
            onValueChange = viewModel::updateClass,
            label = { Text("Class (IX-XII)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = profile.language,
            onValueChange = viewModel::updateLanguage,
            label = { Text("Language (English/Assamese)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = profile.trade ?: "",
            onValueChange = viewModel::updateTrade,
            label = { Text("Trade (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.saveProfile()
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Setup.route) { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Finish Setup")
        }
    }
}
