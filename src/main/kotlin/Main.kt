import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.compose.AppTheme
import datastructures.CustomQueue
import datastructures.SinglyLinkedList
import datastructures.customQueueOf
import ui.LinkedListScreen
import ui.MenuItem
import ui.QueueScreen
import ui.StackScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {

    var selectedMenuItem by remember { mutableStateOf<MenuItem?>(null) }
    val queue by remember { mutableStateOf(CustomQueue<String>()) }
    val singlyLL by remember { mutableStateOf(SinglyLinkedList<String>()) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Menu") },
                actions = {
                    IconButton(onClick = { selectedMenuItem = MenuItem.Stacks }) {
                        Row() {
                            Icon(
                                imageVector = Icons.Default.List,
                                contentDescription = "Stacks"
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text("Stacks", modifier = Modifier.padding(top = 2.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    IconButton(onClick = { selectedMenuItem = MenuItem.SinglyLL }) {
                        Row() {
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = "Singly Linked List"
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text("Singly LL", modifier = Modifier.padding(top = 2.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(64.dp))
                    IconButton(onClick = { selectedMenuItem = MenuItem.Queue }) {
                        Row() {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Queue"
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text("Queue", modifier = Modifier.padding(top = 2.dp))
                        }
                    }
                }
            )
        },
        content = {
            when (selectedMenuItem) {
                MenuItem.Stacks -> StackScreen()
                MenuItem.Queue -> QueueScreen(queue)
                MenuItem.SinglyLL -> LinkedListScreen(singlyLL)
                else -> StackScreen()
            }
        }
    )
}

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "Custom Data Structures"
    ) {
        AppTheme (){
            App()
        }
    }
}