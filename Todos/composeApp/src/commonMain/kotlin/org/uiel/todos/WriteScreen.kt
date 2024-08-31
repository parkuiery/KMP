package org.uiel.todos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.uiel.todos.component.TodosIcon

@Composable
fun WriteScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("할 일 작성")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack,
                    ) {
                        Icon(
                            painter = painterResource(TodosIcon.Back),
                            contentDescription = "",
                        )
                    }
                },
                actions = {
                    Text("완료")
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(20.dp)
        ) {
            var title by remember { mutableStateOf("") }
            var content by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { title = it},
                placeholder = { Text("제목") }
            )
            Spacer(Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                value = content,
                onValueChange = { content = it },
                placeholder = { Text("내용") }
            )
        }
    }
}