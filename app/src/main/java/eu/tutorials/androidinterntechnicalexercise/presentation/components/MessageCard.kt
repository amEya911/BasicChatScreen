package eu.tutorials.androidinterntechnicalexercise.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.sp
import eu.tutorials.androidinterntechnicalexercise.model.ChatMessage
import eu.tutorials.androidinterntechnicalexercise.presentation.components.dialog.EditDeleteDialog
import eu.tutorials.androidinterntechnicalexercise.presentation.components.dialog.ReactionDialog
import eu.tutorials.androidinterntechnicalexercise.ui.spacing

@Composable
fun MessageCard(
    message: ChatMessage,
    onEditMessage: (ChatMessage) -> Unit,
    onDeleteMessage: () -> Unit
) {
    var showEditAndDeleteDialog by remember { mutableStateOf(false) }
    var showReactionDialog by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    var editText by remember { mutableStateOf(message.content) }

    val alignment = if (message.isDummy) Alignment.Start else Alignment.End

    Row(
        modifier = Modifier
            .fillMaxWidth().padding(start = MaterialTheme.spacing.medium),
        horizontalArrangement = if (alignment == Alignment.End) Arrangement.End else Arrangement.Start
    ) {
        Card(
            modifier = Modifier
                .padding(MaterialTheme.spacing.small)
                .width(MaterialTheme.spacing.largest)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = {
                            showEditAndDeleteDialog = true
                        },
                        onDoubleTap = {
                            showReactionDialog = true
                        }
                    )
                },
            shape = RoundedCornerShape(MaterialTheme.spacing.medium),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Column(modifier = Modifier.padding(MaterialTheme.spacing.small)) {
                if (isEditing) {
                    TextField(
                        modifier = Modifier
                            .padding(MaterialTheme.spacing.small),
                        value = editText,
                        onValueChange = { editText = it }
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(MaterialTheme.spacing.small)
                    ) {
                        Button(onClick = {
                            onEditMessage(message.copy(content = editText))
                            isEditing = false
                        }) {
                            Text("Save")
                        }
                        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                        Button(onClick = {
                            isEditing = false
                            editText = message.content
                        }) {
                            Text("Cancel")
                        }
                    }
                } else {
                    Text(
                        text = message.sender,
                        color = if (message.isDummy) Color(0xFF06cb99) else Color(0xFF4cb4eb),
                        fontSize = 17.sp,
                    )
                    Text(text = message.content, color = MaterialTheme.colorScheme.onPrimary)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = MaterialTheme.spacing.extraSmall)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.BottomEnd),
                            text = message.timestamp,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                    Box(
                        modifier = Modifier
                            .offset(y = MaterialTheme.spacing.small)
                            .fillMaxWidth()
                            .background(Color.Transparent)
                    ) {
                        message.emoji?.let { emoji ->
                            Text(
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .align(Alignment.BottomEnd),
                                text = emoji
                            )
                        }
                    }
                }
            }
        }
    }

    if (showEditAndDeleteDialog) {
        EditDeleteDialog(
            onDismissRequest = { showEditAndDeleteDialog = false },
            onEdit = {
                isEditing = true
                showEditAndDeleteDialog = false
                     },
            onDelete = {
                onDeleteMessage()
                showEditAndDeleteDialog = false
            }
        )
    }

    if (showReactionDialog) {
        ReactionDialog(
            onDismissRequest = { showReactionDialog = false },
            onRemoveEmoji = {
                message.emoji = null
                showReactionDialog = false
                            },
            onEmojiSelected = { emoji ->
                showReactionDialog = false
                message.emoji = emoji
            },
            message = message
        )
    }
}