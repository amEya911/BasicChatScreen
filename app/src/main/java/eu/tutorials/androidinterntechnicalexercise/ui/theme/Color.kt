package eu.tutorials.androidinterntechnicalexercise.ui.theme

import androidx.compose.ui.graphics.Color

//val Purple80 = Color(0xFFD0BCFF)
//val PurpleGrey80 = Color(0xFFCCC2DC)
//val Pink80 = Color(0xFFEFB8C8)
//
//val Purple40 = Color(0xFF6650a4)
//val PurpleGrey40 = Color(0xFF625b71)
//val Pink40 = Color(0xFF7D5260)

val Green = Color(0xFF06cb99)
val Blue = Color(0xFF4cb4eb)

sealed class ThemeColors(
    val background: Color,
    val messageCard: Color,
    val topBar: Color,
    val textField: Color,
    val text: Color

) {
    object Night: ThemeColors(
        background = Color(0xFF1d1b23),
        messageCard = Color(0xFF202c33),
        topBar = Color(0xFF3a3c3b),
        textField = Color(0xFF3a3c3b),
        text = Color.White
    )

    object Day: ThemeColors(
        background = Color(0xFFEFE6DD),
        messageCard = Color(0xFFffffff),
        topBar = Color(0xFF075e55),
        textField = Color(0xFFffffff),
        text = Color.Black
    )
}