package com.example.fintrack.presentation.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.CategoryBox
import com.example.fintrack.corePlatform.customViews.CategoryDialog
import com.example.fintrack.corePlatform.customViews.IncomeExpenseBox
import com.example.fintrack.corePlatform.customViews.NotificationIcon
import com.example.fintrack.corePlatform.customViews.PeriodSelectionTab
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.corePlatform.customViews.TitleRow
import com.example.fintrack.presentation.analysis.TabWiseContentAnalysis
import com.example.fintrack.presentation.components.BalanceExpenseBox
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun CategoryView(navController: NavController, viewModel: CategoryViewModel = hiltViewModel()) {
    val isDialogOpen = remember { mutableStateOf(false) }
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                // Upper section

                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(0.3f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        ProvideSpace(height = 0.06f)

                        TitleRow(
                            title = stringResource(id = R.string.categories),
                            onBackPressClick = {})

                        ProvideSpace(height = 0.06f)

                        BalanceExpenseBox(usagePercentage = 0.465f)
                    }

                }

                // Lower section

                BackgroundContainer() {

                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        // LazyVerticalGrid to display categories
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            content = {
                                items(viewModel.categoriesList.size + 1) { index ->
                                    if (index == viewModel.categoriesList.size) {
                                        Box(
                                            modifier = Modifier
                                                .height(97.dp)
                                                .width(105.dp)
                                                .clip(RoundedCornerShape(22.dp))
                                                .background(MaterialTheme.colorScheme.outline)
                                                .clickable { isDialogOpen.value = true },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Image(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = stringResource(
                                                    id = R.string.add
                                                ),
                                                modifier = Modifier.size(39.dp),
                                                colorFilter = ColorFilter.tint(Color.White)
                                            )
                                        }
                                    } else CategoryBox(category = viewModel.categoriesList[index],
                                        onClick = { navController.navigate("category_detail_screen/${viewModel.categoriesList[index]}") })
                                }
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }

    // Display the dialog when `isDialogOpen` is true
    CategoryDialog(isDialogOpen = isDialogOpen, onSave = { categoryName ->
        // Handle the confirmed category addition logic here
        // For example, you might add the new category to the viewModel's list
//            viewModel.addCategory(categoryName)
    }, onCancel = {
        // Handle cancellation logic if needed
    })

}