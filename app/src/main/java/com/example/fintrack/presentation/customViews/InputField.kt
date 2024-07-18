package com.example.fintrack.presentation.customViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fintrack.R

@Composable
fun InputField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String = "",
    isPassword: Boolean = false,
    isSingleLine: Boolean = true,
    isDate: Boolean = false,
    onDateClick: () -> Unit = {},
    modifier: Modifier = Modifier.padding(vertical = 8.dp)
) {
    var passwordVisible by remember { mutableStateOf(false) }

    BasicTextField(value = value,
        onValueChange = onValueChange,
        modifier = modifier
//            .width(356.dp)
            .height(if (isSingleLine) 41.dp else 166.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(41.dp))
            .background(MaterialTheme.colorScheme.tertiary, RoundedCornerShape(41.dp))
            .padding(horizontal = 16.dp),
        singleLine = isSingleLine,
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.scrim),
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = if (isSingleLine) 0.dp else 8.dp),
                verticalAlignment = if (isSingleLine) Alignment.CenterVertically else Alignment.Top

            ) {
                Box(
                    modifier = Modifier.weight(1f), contentAlignment = Alignment.TopStart
                ) {
                    if (value.text.isEmpty()) {
                        Text(
                            text = if (isPassword) "••••••••" else placeholder,
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.scrim)
                        )
                    }
                    innerTextField()
                }
                if (isPassword) {
                    Icon(painter = if (passwordVisible) {
                        painterResource(id = R.drawable.ic_hide_password) // Use your drawable for "hide password"
                    } else {
                        painterResource(id = R.drawable.ic_show_password) // Use your drawable for "show password"
                    },
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickable { passwordVisible = !passwordVisible })
                } else if (isDate) {

                    Image(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = stringResource(
                            id = R.string.date
                        ),
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { onDateClick() },
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)

                    )
                }
            }
        })
}
