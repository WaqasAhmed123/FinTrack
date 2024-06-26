package com.example.fintrack.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = MainGreen,
    onPrimary = DarkModeLettersandIcons,      // Text color for primary background
    secondary = Background,
    onSecondary = DarkModeLettersandIcons,    // Text color for secondary background
    tertiary = LightGreen,
    onTertiary = DarkModeLettersandIcons,     // Text color for tertiary background
    surface = MainGreen,
    onSurface = DarkModeLettersandIcons,      // Text color for surface background
    background = Background,
    onBackground = DarkModeLettersandIcons    // Text color for background
)

private val LightColorScheme = lightColorScheme(
    primary = MainGreen,
    onPrimary = Color.Black,      // Text color for primary background
    secondary = Background,
    onSecondary = Color.White,    // Text color for secondary background
    tertiary = LightGreen,
    onTertiary = Color.Black,     // Text color for tertiary background
    surface = MainGreen,
    onSurface = Color.Black,      // Text color for surface background
    background = MainGreen,
    onBackground = Color.Black,    // Text color for background
    scrim = LettersandIcons,
    inversePrimary = BackgroundGreenWhite,
    outline = BlueButton


)



    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */


@Composable
fun FinTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}