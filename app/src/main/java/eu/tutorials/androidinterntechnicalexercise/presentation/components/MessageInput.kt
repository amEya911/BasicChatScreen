package eu.tutorials.androidinterntechnicalexercise.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import eu.tutorials.androidinterntechnicalexercise.ui.spacing
import eu.tutorials.androidinterntechnicalexercise.ui.theme.Green

@Composable
fun MessageInput(
    inputText: String,
    onInputTextChanged: (String) -> Unit,
    onSendClick: () -> Unit
) {

    val lineHeight = MaterialTheme.spacing.extraLarge / 2
    val lines = inputText.split("\n").size
    val textFieldHeight = when (lines) {
        1 -> MaterialTheme.spacing.extraLarge
        2 ->  MaterialTheme.spacing.extraLarge * 3/2
        else -> lineHeight * lines
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .weight(1f)
                .heightIn(
                    min = MaterialTheme.spacing.extraLarge,
                    max =  MaterialTheme.spacing.largest / 2
                )
                .height(textFieldHeight.coerceIn(
                    MaterialTheme.spacing.extraLarge,
                    MaterialTheme.spacing.largest / 2
                ))
                .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(25)),
            value = inputText,
            onValueChange = { onInputTextChanged(it) },
            shape = RoundedCornerShape(43),
            placeholder = { Text("Enter message") },
            singleLine = false,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary,
                cursorColor = MaterialTheme.colorScheme.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        IconButton(onClick = onSendClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Send",
                tint = Green
            )
        }
    }
}