package com.example.fintrack.presentation.customViews

import TabItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PeriodSelectionTab(
    selectedTabIndex: Int, onTabSelected: (Int) -> Unit, tabsTitles: List<String>
) {
    TabRow(modifier = Modifier
        .clip(RoundedCornerShape(22.dp))
        .background(MaterialTheme.colorScheme.tertiary),
        selectedTabIndex = selectedTabIndex,
        containerColor = MaterialTheme.colorScheme.tertiary,
        divider = {},
        indicator = {}) {
        tabsTitles.forEachIndexed { index, tabItem ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = if (selectedTabIndex == index) MaterialTheme.colorScheme.primary else Color.Transparent,
                            shape = RoundedCornerShape(19.dp)
                        )
                        .padding(
                            horizontal = 8.dp, vertical = 4.dp
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = tabItem,
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Normal),
                        color = if (selectedTabIndex == index) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
