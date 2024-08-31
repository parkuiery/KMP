package org.uiel.todos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.koin.mp.KoinPlatform.getKoin
import org.uiel.todos.component.TodosIcon
import org.uiel.todos.data.TodoObject

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateDetail: () -> Unit,
    onNavigateWrite: () -> Unit,
) {
    val viewModel: HomeViewModel = getKoin().get()
    val homeScreenState by viewModel.homeViewState.collectAsState()
    println(homeScreenState)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
        ) {
            Text(
                text = "오늘",
                fontSize = 40.sp,
            )
            LazyColumn {
                items(homeScreenState.todos) {
                    TodoLayout(
                        todo = it
                    )
                }
            }
        }
        IconButton(
            modifier = Modifier
                .padding(20.dp)
                .background(Color.Blue, CircleShape)
                .align(Alignment.BottomEnd),
            onClick = onNavigateWrite,
        ) {
            Icon(
                painterResource(TodosIcon.Add),
                tint = Color.White,
                contentDescription = "add",
            )
        }
    }
}

@Composable
fun TodoLayout(
    modifier: Modifier = Modifier,
    todo: TodoObject,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var isChecked by remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = !isChecked },
        )
        Text(todo.title)
        Spacer(Modifier.weight(1f))
        IconButton(
            onClick = { }
        ) {
            Icon(
                painterResource(TodosIcon.Delete),
                contentDescription = "delete"
            )
        }
    }
}
