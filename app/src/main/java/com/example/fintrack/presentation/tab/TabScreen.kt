package com.example.easyshop.view.tab_view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
//import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.presentation.analysis.AnalysisView
import com.example.fintrack.presentation.category.CategoryView
import com.example.fintrack.presentation.home.HomeView
import com.example.fintrack.presentation.profile.ProfileView
import com.example.fintrack.presentation.tab.BottomNavigationItemsData
import com.example.fintrack.presentation.transaction.TransactionView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabScreen(
    navController: NavController,
) {


    val bottomNavItems = listOf<BottomNavigationItemsData>(
        BottomNavigationItemsData("home_view", icon = painterResource(id = R.drawable.ic_home)),
        BottomNavigationItemsData("home_view", icon = painterResource(id = R.drawable.ic_analysis)),
        BottomNavigationItemsData(
            "home_view", icon = painterResource(id = R.drawable.ic_transaction)
        ),
        BottomNavigationItemsData("home_view", icon = painterResource(id = R.drawable.ic_category)),
        BottomNavigationItemsData("home_view", icon = painterResource(id = R.drawable.ic_person)),
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val scope = rememberCoroutineScope()


    Scaffold(bottomBar = {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.inversePrimary)
                .height(108.dp),
        ) {
            TabRow(

                modifier = Modifier
                    .clip(RoundedCornerShape(41.dp, 41.dp, 0.dp, 0.dp))
                    .height(108.dp),
                indicator = {},
                containerColor = MaterialTheme.colorScheme.tertiary, // Opt
                selectedTabIndex = selectedItemIndex,
                divider = {
                    // Empty composable to remove the default divider
                }) {
                bottomNavItems.forEachIndexed { index, tabItem ->
                    Tab(selected = selectedItemIndex == index, onClick = {
                        selectedItemIndex = index
//                                  navController.navigate(HomeViewModel.bottomNavItems[index].route)
                    }, icon = {
                        Image(
                            painter = bottomNavItems[index].icon,
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(
                                if (selectedItemIndex == index) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    Color.Black

                                }
                            ),
                            modifier = Modifier.size(23.dp)


                        )
//                            tint = if (selectedItemIndex == index) {
//                                MaterialTheme.colorScheme.primary
//                            } else {
//                                Color(0xFF9E9E9E)
//
//                            }

                    }


                    )


                }

            }

        }


    }) { innerPadding ->
        // Content based on selected index
        when (selectedItemIndex) {

            0 -> Box(modifier = Modifier.padding(innerPadding)) {
                HomeView(
                    navController = navController,
                )
            }

            1 -> Box(modifier = Modifier.padding(innerPadding)) {
                AnalysisView(
                    navController = navController,
                )
            }

            2 -> Box(modifier = Modifier.padding(innerPadding)) {
                TransactionView(navController = navController)
            }

            3 -> Box(modifier = Modifier.padding(innerPadding)) {
                CategoryView(navController = navController)

            }

            4 -> Box(modifier = Modifier.padding(innerPadding)) {
                ProfileView(navController = navController)

            }
        }
    }

}