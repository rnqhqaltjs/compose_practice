package com.example.compose_practice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.compose_practice.ui.theme.Compose_practiceTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_practiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimationEx()
                }
            }
        }
    }

    companion object {
        val cardData = CardData(
            imageUri = "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
            imageDescription = "cat image",
            author = "집사",
            description = "안녕하세요! 귀여운 고양이의 사진을 찍어보았습니다."
        )
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        color = Color.Red,
        text = "Hello $name!\nHello $name!\nHello $name!",
        modifier = Modifier.size(300.dp),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.End
    )
}

@Composable
fun SurfaceEx(name: String) {
    Surface(
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.error
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }
}


@Composable
fun ButtonEx(onButtonClicked: () -> Unit) {
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(10.dp, Color.Magenta),
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Send")
    }
}

@Composable
fun ModifierEx() {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = Color.Cyan
        ),
        onClick = {},
        modifier = Modifier
            .size(200.dp)
            .padding(30.dp),
        shape = RectangleShape

    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier
                .size(ButtonDefaults.IconSpacing)
                .background(Color.Blue)
        )
        Text(
            "Search",
            modifier = Modifier
                .offset(x = 10.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun BoxEx() {
    Box(modifier = Modifier.size(100.dp)) {
//        Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
//        Text(text = "Jetpack", modifier = Modifier.align(Alignment.CenterEnd))
//        Text(text = "Compose", modifier = Modifier.align(Alignment.TopStart))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .align(Alignment.CenterStart)
        )
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Yellow)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun RowEx() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)
    ) {

        Text(
            text = "첫번째!",
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.Top)
                .weight(3f)
                .background(Color.Magenta)
        )
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "추가",
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
        )
        Text(
            text = "세번째!",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(3f)
                .background(Color.Blue)
        )
    }
}

@Composable
fun ColumnEx() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.size(100.dp)
    ) {
        Text(
            text = "첫 번째",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "두 번째")
        Text(
            text = "세 번째",
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

@Composable
fun Outer() {
    Column(modifier = Modifier.width(150.dp)) {
        Inner(
            modifier = Modifier
                .width(200.dp)
                .height(160.dp)
        )
        Inner(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        )
    }
}

@Composable
private fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        if (maxHeight > 150.dp) {
            Text(
                text = "여기 꽤 길군요!",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text("maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH:$minHeight")
    }
}

@Composable
fun ImageEx() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.grandcanyon),
            contentDescription = "그랜드 캐년"
        )

        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )
    }
}

@Composable
fun CoilEx() {
    Column {
        AsyncImage(
            model = "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
            contentDescription = "cat image"
        )
        AsyncImage(
            model = "https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?w=2000",
            contentDescription = "cat image"
        )
    }
}

@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = cardData.imageUri,
                contentScale = ContentScale.Crop,
                contentDescription = cardData.imageDescription,
                placeholder = ColorPainter(placeHolderColor),
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(
                    text = cardData.author
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = cardData.description
                )
            }
        }
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)

@Composable
fun CheckBoxEx() {
    Row(verticalAlignment = Alignment.CenterVertically) {
//        var checked = remember { mutableStateOf(false) }

//        var checked by remember { mutableStateOf(false) }

        val (getter, setter) = remember { mutableStateOf(false) }
        Checkbox(
            checked = getter,
            onCheckedChange = setter
        )
        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                setter(!getter)
            }
        )
    }
}

@Composable
fun TextFieldEx() {
    var name by remember { mutableStateOf("Tom") }
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            label = {
                Text("이름")
            },
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = "Hello $name")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarEx(name: String) {
    Column {
        TopAppBar(
            title = { Text("TopAppBar") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )

        Text(text = "Hello $name!")
    }
}

@Composable
fun CheckboxWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }
}

@Composable
fun SlotEx() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Checkbox(
//                checked = checked1.value,
//                onCheckedChange = { checked1.value = it }
//            )
//            Text(
//                text = "텍스트 1",
//                modifier = Modifier.clickable { checked1.value = !checked1.value }
//            )
//        }

//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Checkbox(
//                checked = checked2.value,
//                onCheckedChange = { checked2.value = it }
//            )
//            Text(
//                text = "텍스트 2",
//                modifier = Modifier.clickable { checked2.value = !checked2.value }
//            )
//        }

        CheckboxWithSlot(
            checked = checked1,
            onCheckedChanged = { checked1 = !checked1 }
        ) {
            Text("텍스트 1")
        }
        CheckboxWithSlot(
            checked = checked2,
            onCheckedChanged = { checked2 = !checked2 }
        ) {
            Text("텍스트 2")
        }
    }
}

@Composable
fun CheckBoxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            toggleState()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { toggleState() }
        )
        content()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldEx() {
    var checked by remember { mutableStateOf(false) }

    Scaffold(topBar = {

        TopAppBar(
            navigationIcon = {
                IconButton(onClick = {}) {
                    Image(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "뒤로가기"
                    )
                }
            },
            title = {
                Text(text = "Scaffold App")
            }
        )
    },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {

            }
        }
    ) {
        Surface(modifier = Modifier.padding(8.dp)) {
            CheckBoxWithContent(
                checked = checked,
                toggleState = { checked = !checked }
            ) {
                Text(text = "컴포즈를 좋아합니다.")
            }
        }
    }
}

@Composable
fun Item(itemData: ItemData) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = itemData.title
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Text(
                text = itemData.title
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Text(
                text = itemData.description,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}


@Composable
fun CatalogEx(itemList: List<ItemData>) {
    LazyColumn {

        items(itemList) { item ->
            Item(item)
        }
    }
}

data class ItemData(
    val imageId: Int,
    val title: String,
    val description: String
)

val items = listOf(
    ItemData(
        imageId = R.drawable.grandcanyon,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. "
    ),
    ItemData(
        imageId = R.drawable.grandcanyon,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. "
    ),
    ItemData(
        imageId = R.drawable.grandcanyon,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. "
    ),
    ItemData(
        imageId = R.drawable.grandcanyon,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. "
    ),
    ItemData(
        imageId = R.drawable.grandcanyon,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. "
    ),
    ItemData(
        imageId = R.drawable.grandcanyon,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. "
    ),
    ItemData(
        imageId = R.drawable.grandcanyon,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. "
    )
)

@Composable
fun ConstraintLayoutEx() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
                    centerTo(parent)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )
    }
}

@Composable
fun ConstraintSetEx() {
    val constraintSet = ConstraintSet {

        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox) {
            bottom.linkTo(parent.bottom, margin = 10.dp)
            end.linkTo(parent.end, margin = 30.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(greenBox) {
            centerTo(parent)
        }

        constrain(yellowBox) {
            start.linkTo(magentaBox.end)
            top.linkTo(magentaBox.bottom)
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
        )
    }
}

@Composable
fun ConstraintLayoutEx2() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (redBox, magentaBox, yellowBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    start.linkTo(parent.start, margin = 18.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(parent.start, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start, margin = 50.dp)
                }
        )


//        createVerticalChain(redBox, yellowBox, magentaBox)
        createVerticalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)

        val barrier = createEndBarrier(redBox, yellowBox, magentaBox)

        Text(
            text = "나라말슴이 듕귁에 달아 어린 백성이 나라말슴이 듕귁에 달아 어린 백성이 나라말슴이 듕귁에 달아 어린 백성이",
            modifier = Modifier
                .width(100.dp)
                .constrainAs(text) {
                    start.linkTo(barrier)
                    top.linkTo(magentaBox.bottom)
                }
        )
    }
}

@Composable
fun CardEx2(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (profileImage, author, description) = createRefs()
            AsyncImage(
                model = cardData.imageUri,
                contentScale = ContentScale.Crop,
                contentDescription = cardData.imageDescription,
                placeholder = ColorPainter(placeHolderColor),
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
            )
            Text(
                text = cardData.author,
                modifier = Modifier.constrainAs(author) {
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = cardData.description,
                modifier = Modifier.constrainAs(description) {
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints
                }
            )

            val chain = createVerticalChain(
                author,
                description,
                chainStyle = ChainStyle.Packed
            )

            constrain(chain) {
                top.linkTo(parent.top, margin = 8.dp)
                bottom.linkTo(parent.bottom, margin = 8.dp)
            }
        }
    }
}

@Composable
fun CanvasEx() {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawLine(Color.Red, Offset(20f, 10f), Offset(50f, 40f))

        drawCircle(Color.Yellow, 10f, Offset(15f, 40f))

        drawRect(Color.Magenta, Offset(30f, 30f), Size(10f, 10f))

        drawLine(Color.Green, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Green, Offset(23.0f, 12.0f), Offset(2.01f, 3.0f))
        drawLine(Color.Green, Offset(2.01f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Green, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Green, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Green, Offset(2.0f, 14.0f), Offset(2.01f, 21.0f))
    }
}

@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(onDismissRequest = {
            openDialog = false
        }, confirmButton = {
            Button(onClick = {
                counter++
                openDialog = false
            }) {
                Text("더하기")
            }

        }, dismissButton = {
            Button(onClick = {
                openDialog = false
            }) {
                Text("취소")
            }

        }, title = {
            Text("더하기")

        }, text = {
            Text("더하기 버튼을 누르면 카운터를 증가합니다.\n버튼을 눌러주세요.")

        })
    }
}

@Composable
fun CustomDialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        Dialog(onDismissRequest = {
            openDialog = false
        }) {
            Surface {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("버튼을 클릭해주세요.\n * +1을 누르면 값이 증가됩니다.\n * -1을 누르면 값이 감소합니다.")
                    Row(modifier = Modifier.align(Alignment.End)) {
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text("취소")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter++
                        }) {
                            Text("+1")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter--
                        }) {
                            Text("-1")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DropDownMenuEx() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = true }) {
            Text("드롭다운 메뉴 열기")
        }
        Text("카운터: $counter")
    }

    DropdownMenu(expanded = expandDropDownMenu,
        onDismissRequest = {
            expandDropDownMenu = false
        }
    ) {
        DropdownMenuItem(text = { Text(text = "증가") }, onClick = {
            counter++
        })

        DropdownMenuItem(text = { Text(text = "감소") }, onClick = {
            counter--
        })
    }
}

@Composable
fun SnackbarEx() {
    var counter by remember { mutableStateOf(0) }

    val corountineScope = rememberCoroutineScope()

    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) {
        Button(onClick = {
            counter++
            corountineScope.launch {
                snackbarHostState.showSnackbar(
                    message = "카운터는 ${counter}입니다.",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )
//                when (result) {
//                    SnackbarResult.Dismissed -> {}
//                    SnackbarResult.ActionPerformed -> {}
//                }
            }
        }) {
            Text("더하기")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarEx() {
    val snackbarHostState = remember { SnackbarHostState() }
    val corountineScope = rememberCoroutineScope()
    var counter by remember { mutableStateOf(0) }

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            BottomAppBar() {
                Text("헬로")
                Button(onClick = {
                    corountineScope.launch {
                        snackbarHostState.showSnackbar("안녕하세요")
                    }
                }) {
                    Text("인사하기")
                }
                Button(
                    onClick = {
                        counter++
                        corountineScope.launch {
                            snackbarHostState.showSnackbar("${counter}입니다.")
                        }
                    }
                ) {
                    Text("더하기")

                }
                Button(
                    onClick = {
                        counter--
                        corountineScope.launch {
                            snackbarHostState.showSnackbar("${counter}입니다.")
                        }
                    }
                ) {
                    Text("빼기")
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "카운터는 ${counter}회입니다.",
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}

@Composable
fun PyeongToSquareMeter() {
    var pyeong by rememberSaveable {
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }

//    Column(modifier = Modifier.padding(16.dp)) {
//        OutlinedTextField(value = pyeong,
//            onValueChange = {
//                if (it.isBlank()) {
//                    pyeong = ""
//                    squaremeter = ""
//                    return@OutlinedTextField
//                }
//                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
//                pyeong = it
//                squaremeter = (numericValue * 3.306).toString()
//            }, label = {
//                Text("평")
//            })
//
//        OutlinedTextField(value = squaremeter,
//            onValueChange = {},
//            label = {
//                Text("제곱미터")
//            })
//    }

    PyeongToSquareMeterStateless(pyeong = pyeong, squareMeter = squaremeter) {
        if (it.isBlank()) {
            pyeong = ""
            squaremeter = ""
            return@PyeongToSquareMeterStateless
        }
        val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
        pyeong = it
        squaremeter = (numericValue * 3.306).toString()
    }
}

@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange,
            label = {
                Text("평")
            })

        OutlinedTextField(
            value = squareMeter,
            onValueChange = {},
            label = {
                Text("제곱미터")
            })
    }
}

@Composable
fun AnimationEx() {
    var helloWorldVisible by remember { mutableStateOf(true) }
    var isRed by remember { mutableStateOf(false) }

//    val backgroundColor = Color.LightGray
    val backgroundColor by animateColorAsState(
        targetValue = if(isRed) Color.Red else Color.White,
        label = "backgroundColor"
    )

    val alpha by animateFloatAsState(
        targetValue = if(isRed) 1.0f else 0.5f, label = "alpha"
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(backgroundColor)
            .alpha(alpha)
    ) {

        AnimatedVisibility(
            visible = helloWorldVisible,
            enter = fadeIn() + expandHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Text(text = "Hello World!")
        }

        Row(
            Modifier.selectable(
                selected = helloWorldVisible,
                onClick = {
                    helloWorldVisible = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = helloWorldVisible,
                onClick = { helloWorldVisible = true }
            )
            Text(
                text = "Hello World 보이기"
            )
        }

        Row(
            Modifier.selectable(
                selected = !helloWorldVisible,
                onClick = {
                    helloWorldVisible = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !helloWorldVisible,
                onClick = { helloWorldVisible = false }
            )
            Text(
                text = "Hello World 감추기"
            )
        }

        Text(text = "배경 색을 바꾸어봅시다.")

        Row(
            Modifier.selectable(
                selected = !isRed,
                onClick = {
                    isRed = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !isRed,
                onClick = { isRed = false }
            )
            Text(
                text = "흰색"
            )
        }

        Row(
            Modifier.selectable(
                selected = isRed,
                onClick = {
                    isRed = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isRed,
                onClick = { isRed = true }
            )
            Text(
                text = "빨간색"
            )
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun ItemPreview() {
//    Compose_practiceTheme {
//        Item(
//            ItemData(
//                imageId = R.drawable.grandcanyon,
//                title = "해변 놀이 공원",
//                description = "해변 놀이 공원 설명입니다. "
//            )
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_practiceTheme {
        AnimationEx()
    }
}



