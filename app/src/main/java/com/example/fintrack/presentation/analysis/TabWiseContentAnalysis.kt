package com.example.fintrack.presentation.analysis

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fintrack.R
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottomAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStartAxis
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberColumnCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.common.component.rememberLineComponent
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.CartesianValueFormatter
import com.patrykandpatrick.vico.core.cartesian.data.columnSeries
import com.patrykandpatrick.vico.core.cartesian.layer.ColumnCartesianLayer

@SuppressLint("RestrictedApi")
@Composable
fun TabWiseContentAnalysis(
    isDaily: Boolean = false,
    isWeekly: Boolean = false,
    isMonthly: Boolean = false,
    isYearly: Boolean = false
) {
    // Define custom colors
    val customColors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.outline)

    // Create the column layer with custom colors
    val columnLayer = rememberColumnCartesianLayer(
        columnProvider = ColumnCartesianLayer.ColumnProvider.series(customColors.map { color ->
            rememberLineComponent(
                color = color,
                thickness = 1.dp,
                shape = com.patrykandpatrick.vico.core.common.shape.Shape.Pill // Rounded corners
            )
        }), spacing = 8.dp, // Spacing between columns
        innerSpacing = 4.dp // Spacing within grouped columns
    )

    // X-axis labels based on the current mode
    val xLabels = when {
        isDaily -> listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        isWeekly -> listOf("Week 1", "Week 2", "Week 3", "Week 4")
        isMonthly -> listOf(
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        )

        else -> listOf()
    }

    // Create the Cartesian chart
    val cartesianChart = rememberCartesianChart(
        columnLayer,
        startAxis = rememberStartAxis(),
        bottomAxis = rememberBottomAxis(valueFormatter = CartesianValueFormatter { value, _, _ ->
            xLabels.getOrElse(value.toInt()) { value.toString() }
        })
    )

    // Update the data
    val modelProducer = remember { CartesianChartModelProducer.build() }
    modelProducer.tryRunTransaction {
        columnSeries {
            series(y = listOf(1, 8, 3, 7))   // First series
            series(y = listOf(6, 1, 9, 3))   // Second series
        }
    }

    // Host the Cartesian chart
    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(50.dp)
            )
            .background(color = MaterialTheme.colorScheme.tertiary)
    ) {
        Column (modifier = Modifier.padding(20.dp)){
            Row {
                Text(
                    text = stringResource(id = R.string.income_and_expense),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            CartesianChartHost(
                chart = cartesianChart, modelProducer = modelProducer
            )

        }
    }
}

