package com.example.fintrack.corePlatform.customViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.fintrack.R
import com.example.fintrack.presentation.customViews.InputField
import com.example.fintrack.presentation.customViews.SubmitButton

@Composable
fun CategoryDialog(
    isDialogOpen: MutableState<Boolean>,
    onSave: (TextFieldValue) -> Unit,
    onCancel: () -> Unit
) {
    val categoryName = remember { mutableStateOf(TextFieldValue("")) }

    if (isDialogOpen.value) {
        Dialog(
            onDismissRequest = { isDialogOpen.value = false },
            properties = DialogProperties(dismissOnClickOutside = true)
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
//                        .background(MaterialTheme.colorScheme.background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.new_category),
                        style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.scrim),
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    InputField(
                        value = categoryName.value,
                        onValueChange = { categoryName.value = it },
                        placeholder = stringResource(id = R.string.enter_category_name)
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    // Custom submit button
                    SubmitButton(onClick = { onSave(categoryName.value) }, buttonTitle = stringResource(id = R.string.save))

                    Spacer(modifier = Modifier.size(16.dp))

                    SubmitButton(onClick = { onCancel() }, buttonTitle = stringResource(id = R.string.cancel), color = MaterialTheme.colorScheme.tertiary)
                }
            }
        }
    }
}
