package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StackScreen() {
    Column(Modifier.padding(16.dp)) {
        Text("Stack",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary)
    }
}