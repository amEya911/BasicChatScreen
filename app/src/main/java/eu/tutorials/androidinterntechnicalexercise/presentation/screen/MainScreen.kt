package eu.tutorials.androidinterntechnicalexercise.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.tutorials.androidinterntechnicalexercise.model.ChatMessage
import eu.tutorials.androidinterntechnicalexercise.presentation.components.MessageCard
import eu.tutorials.androidinterntechnicalexercise.presentation.components.MessageInput
import eu.tutorials.androidinterntechnicalexercise.presentation.components.TopBar
import eu.tutorials.androidinterntechnicalexercise.presentation.viewModel.ChatViewModel
import eu.tutorials.androidinterntechnicalexercise.ui.spacing
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(viewModel: ChatViewModel = viewModel()) {

    val focusManager = LocalFocusManager.current
    val keyBoardController = LocalSoftwareKeyboardController.current
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = MaterialTheme.spacing.medium)
    ) {
        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(
                    top = MaterialTheme.spacing.medium,
                    start = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.small
                )
        )

        if (viewModel.errorMessage.isNotBlank()) {
            Text(
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.medium),
                text = viewModel.errorMessage,
                color = Color.Red
            )
        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            clearFocus(focusManager, keyBoardController)
                        }
                    )
                },
            reverseLayout = true
        ) {
            items(viewModel.messages.asReversed()) { message ->
                MessageCard(
                    message = message,
                    onEditMessage = { updatedMessage ->
                        viewModel.updateMessage(message, updatedMessage)
                    },
                    onDeleteMessage = {
                        viewModel.deleteMessage(message)
                    }
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            MessageInput(
                inputText = viewModel.inputText,
                onInputTextChanged = { viewModel.inputText = it },
                onSendClick = {
                    if (viewModel.inputText.isNotBlank()) {
                        viewModel.addMessage(
                            ChatMessage("You", viewModel.inputText, viewModel.getCurrentTimestamp(), false)
                        )
                        viewModel.inputText = ""
                        coroutineScope.launch {
                            delay(100)
                            listState.scrollToItem(0)
                        }
                    }
                }
            )
        }
    }
}

private fun clearFocus(focusManager: FocusManager, keyBoardController: SoftwareKeyboardController?) {
    focusManager.clearFocus()
    keyBoardController?.hide()
}
