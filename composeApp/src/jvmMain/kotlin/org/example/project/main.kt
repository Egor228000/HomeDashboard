package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.kdroidfilter.platformtools.darkmodedetector.isSystemInDarkMode
import io.github.kdroidfilter.platformtools.darkmodedetector.windows.setWindowsAdaptiveTitleBar
import org.example.project.Theme.DarkColors
import org.example.project.Theme.LightColors
import org.example.project.Theme.MyAppTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "HomeDashboard",
    ) {
        window.setWindowsAdaptiveTitleBar()
        MyAppTheme(
            colorScheme = if (isSystemInDarkMode()) DarkColors else LightColors
        ) {
            App()
        }
    }
}