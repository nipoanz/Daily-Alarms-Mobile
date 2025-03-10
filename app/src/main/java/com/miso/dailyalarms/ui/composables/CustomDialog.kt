package com.miso.dailyalarms.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.compose.AppTheme
import com.miso.dailyalarms.ui.screens.GroupListScreen

@Composable
fun CustomDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    title: String,
    message: String,
    confirmText: String = "Aceptar",
    onConfirm: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .shadow(12.dp, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFCDE4F8), RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = message,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 16.dp, 0.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .shadow(8.dp, shape = RoundedCornerShape(50.dp))
                        ) {
                            Button(
                                onClick = onDismiss,
                                border = BorderStroke(3.dp, Color.White),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2A638B),
                                    contentColor = Color.White,

                                    ),
                                modifier = Modifier.padding(bottom = 8.dp)
                            ) {
                                Text("CERRAR", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomDialogPreview() {
    AppTheme (darkTheme = false) {
        CustomDialog(
            showDialog = true,
            onDismiss = {},
            title = "Vincular a Equipo",
            message = "Ingrese el código de vinculación para unirse a un equipo",
            confirmText = "Vincular",
            onConfirm = {}
        )
    }
}
