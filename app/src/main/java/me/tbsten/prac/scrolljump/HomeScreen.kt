package me.tbsten.prac.scrolljump

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    gotoListScreen: () -> Unit,
    gotoListScreenWithItem: (itemId: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text("HomeScreen")
        Button(onClick = gotoListScreen) {
            Text("goto ListScreen")
        }
        Button(onClick = { gotoListScreenWithItem("item-1") }) {
            Text("goto ListScreen item-1")
        }
        Button(onClick = { gotoListScreenWithItem("item-15") }) {
            Text("goto ListScreen item-15")
        }
    }
}