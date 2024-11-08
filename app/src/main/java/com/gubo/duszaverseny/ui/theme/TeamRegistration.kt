package com.gubo.duszaverseny.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TeamRegistrationScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var teamName by remember { mutableStateOf("") }
    var schoolName by remember { mutableStateOf("") }
    var member1Name by remember { mutableStateOf("") }
    var member1Grade by remember { mutableStateOf("") }
    var member2Name by remember { mutableStateOf("") }
    var member2Grade by remember { mutableStateOf("") }
    var member3Name by remember { mutableStateOf("") }
    var member3Grade by remember { mutableStateOf("") }
    var substituteName by remember { mutableStateOf("") }
    var substituteGrade by remember { mutableStateOf("") }
    var coachName by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("") }
    var selectedLanguage by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text("Team Registration", style = MaterialTheme.typography.headlineMedium)
        }

        item {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        item {
            OutlinedTextField(
                value = teamName,
                onValueChange = { teamName = it },
                label = { Text("Team Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = schoolName,
                onValueChange = { schoolName = it },
                label = { Text("School Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Team Member 1
        item {
            Text("Team Member 1")
        }
        item {
            OutlinedTextField(
                value = member1Name,
                onValueChange = { member1Name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = member1Grade,
                onValueChange = { member1Grade = it },
                label = { Text("Grade") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        // Team Member 2
        item {
            Text("Team Member 2")
        }
        item {
            OutlinedTextField(
                value = member2Name,
                onValueChange = { member2Name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = member2Grade,
                onValueChange = { member2Grade = it },
                label = { Text("Grade") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        // Team Member 3
        item {
            Text("Team Member 3")
        }
        item {
            OutlinedTextField(
                value = member3Name,
                onValueChange = { member3Name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = member3Grade,
                onValueChange = { member3Grade = it },
                label = { Text("Grade") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        // Substitute Member (optional)
        item {
            Text("Substitute Member (Optional)")
        }
        item {
            OutlinedTextField(
                value = substituteName,
                onValueChange = { substituteName = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = substituteGrade,
                onValueChange = { substituteGrade = it },
                label = { Text("Grade") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        item {
            OutlinedTextField(
                value = coachName,
                onValueChange = { coachName = it },
                label = { Text("Coach Name(s)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = selectedCategory,
                onValueChange = { selectedCategory = it },
                label = { Text("Category") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = selectedLanguage,
                onValueChange = { selectedLanguage = it },
                label = { Text("Programming Language") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Column {
                Button(
                    onClick = { /* Handle form submission */ },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Submit Registration")
                }
            }
        }
    }
}