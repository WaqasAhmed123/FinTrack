package com.example.fintrack.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fintrack.R

@Composable
fun BalanceExpenseBox() {
    Box(
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painterResource(id = R.drawable.ic_income),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(5.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.total_balance),
                            style = MaterialTheme.typography.headlineSmall
                        )

                    }
                    Text(
                        text ="123455",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxHeight(0.25f)
                        .width(1.dp)
                        .background(MaterialTheme.colorScheme.outline)
                )

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row (verticalAlignment = Alignment.CenterVertically){
                        Image(
                            painterResource(id = R.drawable.ic_expense),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(5.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.total_expense),
                            style = MaterialTheme.typography.headlineSmall
                        )

                    }
                    Text(
                        text ="123455",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Placeholder for a graph
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp)
//                    .background(
//                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
//                        shape = RoundedCornerShape(8.dp)
//                    ), contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Graph Placeholder",
//                    style = MaterialTheme.typography.bodyMedium,
//                    color = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))

            // Bottom section with an icon and text
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(id = R.drawable.ic_check),
                    contentDescription = null,
                    modifier = Modifier
                        .size(12.dp)
                        .padding(8.dp)
                )

                Text(
                    text = stringResource(id = R.string.of_your_expenses_looks_good),
                    style = MaterialTheme.typography.bodySmall
                )
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.of_your_expenses_looks_good),
//                        style = MaterialTheme.typography.headlineSmall
//                    )
//                    Text(
//                        text = stringResource(id = R.string.of_your_expenses_looks_good),
//                        style = MaterialTheme.typography.bodySmall,
//                    )
//                }
            }
        }
    }
}
