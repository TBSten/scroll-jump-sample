package me.tbsten.prac.scrolljump

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.tbsten.prac.scrolljump.ui.theme.ScrollJumpPracTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollJumpPracTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.systemBarsPadding()
                ) {
                    composable("home") {
                        HomeScreen(
                            gotoListScreen = { navController.navigate("list") },
                            gotoListScreenWithItem = { navController.navigate("list?initialItemId=$it") },
                        )
                    }

                    composable("list?initialItemId={initialItemId}") {
                        val initialItemId = it.arguments?.getString("initialItemId")
                        ListScreen(
                            initialItemId = initialItemId,
                        )
                    }
                }
            }
        }
    }
}
