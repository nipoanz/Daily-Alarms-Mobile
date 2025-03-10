package com.miso.dailyalarms.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.miso.dailyalarms.ui.DailyAlarmsScreen
import com.miso.dailyalarms.ui.composables.CustomDialog

@Composable
fun GroupListScreen(navController: NavController? = null) {

    var showDialog by remember { mutableStateOf(false) }
    var showDialogLogout by remember { mutableStateOf(false) }

    CustomDialog(
        showDialog = showDialogLogout,
        onDismiss = { showDialogLogout = false; navigateTo(navController, DailyAlarmsScreen.Login.route)},
        title = "Cerrar Sesión",
        message = "¿Está seguro de cerrar la sesión?",
        confirmText = "Cerra",
        onConfirm = { showDialogLogout = false }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Daily Alarms",
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                        },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF2A638B)),

                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .shadow(elevation = 8.dp),
                actions = {
                    IconButton(onClick = { showDialogLogout = true }) {
                        Icon(
                            imageVector = Icons.Filled.Logout,
                            contentDescription = "Salir",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color(0xFF2A638B),
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Agregar Equipo",
                    tint = Color.White
                )
            }

            CustomDialog(
                showDialog = showDialog,
                onDismiss = { showDialog = false },
                title = "Vincular a Equipo",
                message = "El equipo ha sido vinculado correctamente a su cuenta",
                confirmText = "Vincular",
                onConfirm = { showDialog = false }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Mis Equipos",
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.height(16.dp))

            val teams = listOf("Equipo A", "Equipo B", "Equipo C", "Equipo D")

            teams.forEach { team ->
                TeamItem(teamName = team) { /* Acción al hacer clic */ }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun TeamItem(teamName: String, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = teamName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xFF2A638B)
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDownCircle,
                modifier = Modifier.rotate(-90f),
                contentDescription = "Ir a equipo",
                tint = Color(0xFF2A638B)
            )
        }
    }
}



private fun navigateTo(navController: NavController?, route: String) {
    navController?.navigate(route) {
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
    }
}

@Preview(showBackground = true)
@Composable
fun GroupListScreenPreview() {
    AppTheme (darkTheme = false) {
        GroupListScreen()
    }
}