package me.tbsten.prac.scrolljump

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ListItem(
    val id: String,
    val title: String,
    val details: String,
)

private val items = List(30) {
    ListItem(
        id = "item-$it",
        title = "項目 $it",
        details = "項目 $it".repeat(30),
    )
}

@Composable
fun ListScreen(
    initialItemId: String?,
    modifier: Modifier = Modifier,
) {
    var selectedHelpItemId by remember { mutableStateOf<String?>(initialItemId) }

    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = initialItemId?.let{ items.indexOfFirst { it.id == initialItemId } } ?: 0,
//        initialFirstVisibleItemScrollOffset = -100,
    )

    LazyColumn(modifier = modifier, state = listState) {
        items(items) {
            Column {
                Row(
                    modifier = Modifier
                        .clickable {
                            selectedHelpItemId = if (selectedHelpItemId != it.id) it.id else null
                        }
                        .padding(16.dp)
                        .fillParentMaxWidth(),
                ) {
                    Text(text = it.title, fontSize = 24.sp)
                }
                HorizontalDivider()
                AnimatedVisibility(selectedHelpItemId == it.id) {
                    Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                        Text(it.details)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    ListScreen(null)
}
