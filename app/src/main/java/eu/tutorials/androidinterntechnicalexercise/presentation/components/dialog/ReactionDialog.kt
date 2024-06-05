package eu.tutorials.androidinterntechnicalexercise.presentation.components.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import eu.tutorials.androidinterntechnicalexercise.model.ChatMessage
import eu.tutorials.androidinterntechnicalexercise.ui.spacing

@Composable
fun ReactionDialog(
    onDismissRequest: () -> Unit,
    onRemoveEmoji: () -> Unit,
    onEmojiSelected: (String) -> Unit,
    emojis: List<String> = EMOJI_LIST,
    message: ChatMessage
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("Add Reaction") },
        confirmButton = {
            if (message.emoji?.isNotEmpty() == true) {
                Button(
                    onClick = onRemoveEmoji,
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                ) {
                    Text(text = "Remove Emoji")
                }
            }
        },
        text = {
            LazyRow(Modifier.padding(MaterialTheme.spacing.default)) {
                items(emojis) { emoji ->
                    Text(
                        modifier = Modifier
                            .padding(MaterialTheme.spacing.small)
                            .clickable {
                                onEmojiSelected(emoji)
                                onDismissRequest()
                            },
                        text = emoji,
                        fontSize = 24.sp,
                    )
                }
            }
        }
    )
}

private val EMOJI_LIST = listOf("👍", "👎", "😄", "😢", "😡", "😆", "😯", "😕", "😍", "🤔", "🙄", "🤩", "😎", "😴", "😋", "😬", "😇", "😈", "🤗", "🤔")
