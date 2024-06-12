package com.example.fintrack.corePlatform.customViews

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {
//    val containerColor = FilledTextFieldTokens.ContainerColor.toColor()
    TextField(

        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyMedium,
//                color = Color.Gray
            )
        },
        modifier = modifier
            .width(356.dp)
            .height(50.dp),
        shape = RoundedCornerShape(41.dp),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium,
        colors = TextFieldDefaults.colors(

//            focusedContainerColor = containerColor,
//            unfocusedContainerColor = containerColor,
//            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent, // Remove underline when focused
            unfocusedIndicatorColor = Color.Transparent, // Remove underline when unfocused
            disabledIndicatorColor = Color.Transparent, // Remove underline when disabled
            focusedContainerColor = MaterialTheme.colorScheme.tertiary,
            unfocusedContainerColor = MaterialTheme.colorScheme.tertiary
        )
    )

}
