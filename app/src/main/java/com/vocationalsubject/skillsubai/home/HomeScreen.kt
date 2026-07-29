package com.vocationalsubject.skillsubai.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vocationalsubject.skillsubai.ui.navigation.Screen

data class HomeAction(val title: String, val icon: ImageVector, val route: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val actions = listOf(
        HomeAction("AI Tutor", Icons.Default.Chat, Screen.Chat.route),
        HomeAction("My Books", Icons.Default.Book, Screen.Home.route),
        HomeAction("Notes", Icons.Default.Note, Screen.Home.route),
        HomeAction("Quiz", Icons.Default.Quiz, Screen.Home.route),
        HomeAction("Progress", Icons.Default.Analytics, Screen.Home.route),
        HomeAction("Resources", Icons.Default.LibraryBooks, Screen.Home.route)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Skill Sub AI") },
                actions = {
                    IconButton(onClick = { /* Profile */ }) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text(
                text = "Welcome, Student!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(actions) { action ->
                    HomeCard(action) {
                        navController.navigate(action.route)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeCard(action: HomeAction, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = action.icon,
                contentDescription = action.title,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = action.title, style = MaterialTheme.typography.titleMedium)
        }
    }
}
