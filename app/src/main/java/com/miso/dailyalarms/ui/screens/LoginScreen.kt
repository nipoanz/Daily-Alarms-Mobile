package com.miso.dailyalarms.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.miso.dailyalarms.R
import com.miso.dailyalarms.ui.DailyAlarmsScreen
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import com.example.compose.accentLight
import com.example.compose.secondaryContainerLight
import com.example.compose.secondaryLight

@Composable
fun LoginScreen(navController: NavController? = null) {
    val image = painterResource(R.drawable.backgroud)
    val logo = painterResource(R.drawable.logo)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = "Fondo para autenticacion",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = logo,
                contentDescription = "Logo",
                modifier = Modifier.size(450.dp, 110.dp)
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text = "Iniciar Sesión",
                fontSize = 18.sp,
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.height(36.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.height(120.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = secondaryContainerLight,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .padding(horizontal = 4.dp),
                    border = BorderStroke(3.dp, Color.White),
                    onClick = { navigateTo(navController, DailyAlarmsScreen.SignUp.route) },
                )
                {
                    Text("REGISTRAR", fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = { navigateTo(navController, DailyAlarmsScreen.GroupsList.route) },
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(3.dp, Color.White),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2A638B),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .height(48.dp)
                        .padding(horizontal = 4.dp)
                    )
                {
                    Text("INGRESAR", fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "OLVIDÓ CONTRASEÑA",
                fontSize = 14.sp,
                color = accentLight,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { navigateTo(navController, DailyAlarmsScreen.ForgotPasswrod.route) }
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
fun LoginScreenPreview() {
    AppTheme (darkTheme = false) {
        LoginScreen()
    }
}