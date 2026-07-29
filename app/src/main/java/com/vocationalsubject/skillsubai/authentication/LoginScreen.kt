package com.vocationalsubject.skillsubai.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vocationalsubject.skillsubai.ui.navigation.Screen

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Skill Sub AI", modifier = Modifier.padding(bottom = 32.dp))
        Button(onClick = { navController.navigate(Screen.Setup.route) }) {
            Text(text = "Continue with Google")
        }
    }
}
