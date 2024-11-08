package com.gubo.duszaverseny.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LandingPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF002366)), // A sötétkék háttérszín
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // Logó rész
            Text(
                text = "DUSZA",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "VERSENY JELENTKEZÉSI FELÜLET",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Legördülő menü placeholder
            // DropdownMenu()

            Spacer(modifier = Modifier.height(16.dp))

            // Bejelentkezés gomb
            Button(
                onClick = { /* Function meghívás */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004B87)), // Kék szín
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
            ) {
                Text(text = "Bejelentkezés", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Regisztráció gomb
            Button(
                onClick = { /* Function meghívás */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004B87)), // Kék szín
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
            ) {
                Text(text = "Regisztráció", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
