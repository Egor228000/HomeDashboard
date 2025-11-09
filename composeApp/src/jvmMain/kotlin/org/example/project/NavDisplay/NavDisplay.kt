package org.example.project.NavDisplay

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import org.example.project.Screens.MainScreen
import org.example.project.Screens.WelcomeScreen
import org.example.project.ViewModelBoard


@Serializable
data object WelcomeNavKey: NavKey

@Serializable
data object MainNavKey: NavKey

@Composable
fun NavDisplayHost(
    backStack: SnapshotStateList<NavKey>,
    viewModelBoard: ViewModelBoard
) {
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<WelcomeNavKey> {
                WelcomeScreen(viewModelBoard, backStack)
            }
            entry<MainNavKey> {
                MainScreen(viewModelBoard, backStack)
            }

        }
    )
}