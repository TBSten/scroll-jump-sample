# リスト画面に移動した時に初期位置を設定するサンプル

```kt
var selectedHelpItemId by remember { mutableStateOf<String?>(initialItemId) }
val listState = rememberLazyListState(
    initialFirstVisibleItemIndex = initialItemId?.let {
        items.indexOfFirst { it.id == initialItemId }
    }
        ?: 0,
)

LazyColumn(modifier = modifier, state = listState) { ... }
```

<video src="./docs/サンプル動画.webm" controls="true"></video>

---

ちょっとずらして上にも項目あるよ！的なのもできる

```kt
var selectedHelpItemId by remember { mutableStateOf<String?>(initialItemId) }
val listState = rememberLazyListState(
    initialFirstVisibleItemIndex = initialItemId?.let {
        items.indexOfFirst { it.id == initialItemId }
    } ?: 0,
    initialFirstVisibleItemScrollOffset = -100,
)

LazyColumn(modifier = modifier, state = listState) { ... }
```

<video src="./docs/スクロール位置をちょっとずらす.webm" controls="true"></video>
