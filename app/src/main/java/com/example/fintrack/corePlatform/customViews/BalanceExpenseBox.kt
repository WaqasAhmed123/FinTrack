package com.example.fintrack.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.ProvideSpace

@Composable
fun BalanceExpenseBox(usagePercentage: Float = 0.3f) {
    Box(
//        modifier = Modifier.fillMaxWidth(0.8f)
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
                    Row(verticalAlignment = Alignment.CenterVertically) {
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
                        text = "534,544",
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

                    Row(verticalAlignment = Alignment.CenterVertically) {
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
                        text = "465,156",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            ProvideSpace(height = 0.08f)

            Row(
                modifier = Modifier
//                    .fillMaxWidth()
                    .height(27.dp)
                    .clip(RoundedCornerShape(13.5.dp))
                    .fillMaxWidth(0.8f)

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(usagePercentage)
                        .background(Color.Black), contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = "${(usagePercentage * 100).toInt()}%",
                        style = MaterialTheme.typography.headlineSmall.copy(color = MaterialTheme.colorScheme.inversePrimary)
                    )

                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f - usagePercentage)
                        .background(MaterialTheme.colorScheme.inversePrimary),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "465,156",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                        modifier = Modifier.padding(horizontal = 16.dp)

                    )
                }
            }

            ProvideSpace(height = 0.08f)

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
                        .size(26.dp)
                        .padding(5.dp)
                )

                Text(
                    text = "${(usagePercentage * 100).toInt()}% ${stringResource(id = R.string.of_your_expenses_looks_good)}",
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}
