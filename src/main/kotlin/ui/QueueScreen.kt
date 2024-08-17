package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import datastructures.CustomQueue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QueueScreen() {

    var inputText by remember { mutableStateOf("") }
    val queue by remember { mutableStateOf(CustomQueue<String>()) }

    Column(Modifier.padding(16.dp))
    {
        Text(
            "Queue",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter element") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            if (inputText.isNotBlank()) queue.enqueue(inputText)
            inputText = ""
        }) {
            Text("Enqueue")
        }

        Text("Queue Size: ${queue.size()}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Queue Elements:")
        Spacer(modifier = Modifier.height(8.dp))

        for(i in 0..queue.size()){
            queue.peek(i)?.let { Text(it) }
        }
    }
}