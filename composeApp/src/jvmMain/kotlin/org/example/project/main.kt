package org.example.project

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation3.runtime.NavKey
import io.github.kdroidfilter.platformtools.darkmodedetector.isSystemInDarkMode
import io.github.kdroidfilter.platformtools.darkmodedetector.windows.setWindowsAdaptiveTitleBar
import org.example.project.NavDisplay.NavDisplayHost
import org.example.project.NavDisplay.WelcomeNavKey
import org.example.project.Screens.WelcomeScreen
import org.example.project.Theme.DarkColors
import org.example.project.Theme.LightColors
import org.example.project.Theme.MyAppTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "HomeDashboard",
    ) {
        window.setWindowsAdaptiveTitleBar()
        val backStack = remember { mutableStateListOf<NavKey>(WelcomeNavKey) }


        val viewModelBoard = remember { ViewModelBoard() }
        MyAppTheme(
            colorScheme = if (isSystemInDarkMode()) DarkColors else LightColors
        ) {
            NavDisplayHost(
                backStack,
                viewModelBoard
            )
        }
    }
}