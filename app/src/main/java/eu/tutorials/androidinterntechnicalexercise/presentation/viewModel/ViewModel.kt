package eu.tutorials.androidinterntechnicalexercise.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.androidinterntechnicalexercise.model.ChatMessage
import eu.tutorials.androidinterntechnicalexercise.api.RetrofitInstance
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ChatViewModel : ViewModel() {
    var messages by mutableStateOf<List<ChatMessage>>(emptyList())
    var errorMessage by mutableStateOf("")
    var inputText by mutableStateOf("")

    init {
        fetchMessages()
    }

    private fun fetchMessages() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getMessages()
                messages = response.map {
                    ChatMessage("User ${it.userId}", it.title, getCurrentTimestamp(), true)
                }
            } catch (e: Exception) {
                errorMessage = "Error Loading Messages. Please try again."
            }
        }
    }

    fun addMessage(message: ChatMessage) {
        messages = messages + message
    }

    fun updateMessage(oldMessage: ChatMessage, newMessage: ChatMessage) {
        messages = messages.map {
            if (it == oldMessage) newMessage else it
        }
    }

    fun deleteMessage(message: ChatMessage) {
        messages = messages - message
    }

    fun getCurrentTimestamp(): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(Date())
    }
}
