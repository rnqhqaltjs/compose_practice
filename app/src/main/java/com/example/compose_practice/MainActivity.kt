package com.example.compose_practice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import coil.compose.AsyncImage
import com.example.compose_practice.ui.theme.Compose_practiceTheme

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
                    ConstraintSetEx()
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
    Text(color = Color.Red,
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
    Surface (
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
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .align(Alignment.CenterStart))
        Box(modifier = Modifier
            .size(70.dp)
            .background(Color.Yellow)
            .align(Alignment.Center))
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
        if(maxHeight > 150.dp) {
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
        ConstraintSetEx()
    }
}



