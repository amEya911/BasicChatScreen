package eu.tutorials.androidinterntechnicalexercise.model

data class ChatMessage(
    val sender: String,
    val content: String,
    val timestamp: String,
    val isDummy: Boolean = false,
    var emoji: String? = null
)
