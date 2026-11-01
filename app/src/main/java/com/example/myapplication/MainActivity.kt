package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        // Задание 1. Запуск 1: с именем
                        Hello("Android")
                        // Запуск 2: заменить строку выше на Hello(null)

                        GreenItalicText()
                        EllipsisText()
                        IndentedText()
                        GrayButton()
                        InitialsBanner()
                    }
                }
            }
        }
    }
}

/* ===================== Задание 1 ===================== */

@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        modifier = modifier
    )
}

/* ===================== Задание 2 ===================== */

@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=portrait"
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=landscape"
)
@Preview(
    name = "round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00,
    device = "spec:width=200dp,height=200dp,isRound=true"
)
@Composable
fun HelloPreview() {
    MyApplicationTheme {
        Hello("Android")
    }
}

/* ===================== Задание 3 ===================== */
// В res/values/strings.xml должна быть строка compose_description

@Composable
fun GreenItalicText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier.fillMaxWidth(),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Composable
fun EllipsisText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun IndentedText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier.background(Color.Green),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp))
    )
}

@Preview(name = "green italic center", showBackground = true)
@Composable
fun GreenItalicTextPreview() {
    MyApplicationTheme { GreenItalicText() }
}

@Preview(name = "ellipsis", showBackground = true)
@Composable
fun EllipsisTextPreview() {
    MyApplicationTheme { EllipsisText() }
}

@Preview(name = "indent", showBackground = true)
@Composable
fun IndentedTextPreview() {
    MyApplicationTheme { IndentedText() }
}

/* ===================== Задание 4 ===================== */

@Composable
fun GrayButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text("Нажми на меня")
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ButtonPreview() {
    MyApplicationTheme { GrayButton() }
}

/* ===================== Задание 5 ===================== */

@Composable
fun InitialsBanner(initials: String = "АБ", modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 16.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color(0xFFFF5722)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = initials, color = Color.Black)
        }
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun Task5Preview() {
    MyApplicationTheme { InitialsBanner() }
}

/* ===================== Задание 6 ===================== */
// Файл res/drawable/circle.xml — см. circle.xml

// 1) Круг исходного размера в правом верхнем углу, чёрный фон 240dp x 120dp
@Composable
fun CircleTopEnd() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

// 2) Синий фон, круг по центру, растянут по размерам, фиолетовый (через colorFilter)
@Composable
fun CircleCenterPurple() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

@Preview(name = "circle top end", showSystemUi = true)
@Composable
fun CircleTopEndPreview() {
    CircleTopEnd()
}

@Preview(name = "circle center purple", showSystemUi = true)
@Composable
fun CircleCenterPurplePreview() {
    CircleCenterPurple()
}

/* ===================== Задание 7 ===================== */

data class Contact(
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val phone: String,
    val address: String
)

private val sampleContacts = listOf(
    Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95",
        "г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
    Contact("Василий", "Егорович", "Кузякин", "---",
        "Ивановская область, дер. Крутово, д. 4"),
    Contact("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78",
        "Москва, Большая Никитская, д. 43, кв. 290")
)

// Рисунок 1: простой Column, текст слева
@Composable
fun ContactColumn(contact: Contact, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Имя: ${contact.firstName}")
        Text("Отчество: ${contact.middleName}")
        Text("Фамилия: ${contact.lastName}")
        Text("Мобильный телефон: ${contact.phone}")
        Text("Адрес: ${contact.address}")
    }
}

// Серая карточка с текстом по центру (используется в списке и в Row)
@Composable
private fun ContactCard(contact: Contact, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val center = TextAlign.Center
        Text("Имя: ${contact.firstName}", textAlign = center)
        Text("Отчество: ${contact.middleName}", textAlign = center)
        Text("Фамилия: ${contact.lastName}", textAlign = center)
        Text("Мобильный телефон: ${contact.phone}", textAlign = center)
        Text("Адрес: ${contact.address}", textAlign = center)
    }
}

// Рисунок 2: список карточек в Column с отступами между ними
@Composable
fun ContactList(contacts: List<Contact>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        contacts.forEach { ContactCard(it, Modifier.fillMaxWidth()) }
    }
}

// Рисунок 3: Row — карточка и иконка-звезда справа
@Composable
fun ContactRow(contact: Contact, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val center = TextAlign.Center
            Text("Имя: ${contact.firstName}", textAlign = center)
            Text("Отчество: ${contact.middleName}", textAlign = center)
            Text("Фамилия: ${contact.lastName}", textAlign = center)
            Text("Мобильный телефон: ${contact.phone}", textAlign = center)
            Text("Адрес: ${contact.address}", textAlign = center)
        }
        Text(
            text = "★",
            color = Color(0xFFFF9800),
            fontSize = 24.sp
        )
    }
}

@Preview(name = "ContactColumn", showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    ContactColumn(sampleContacts[0])
}

@Preview(name = "List", showSystemUi = true)
@Composable
fun ListPreview() {
    ContactList(sampleContacts)
}

@Preview(name = "ContactRow", showSystemUi = true)
@Composable
fun ContactRowPreview() {
    ContactRow(sampleContacts[0])
}

/* ===================== Задание 8 ===================== */

private val primaryColor = Color(0xFF3F5F94)
private val secondaryColor = Color(0xFF555F70)
private val buttonTextColor = Color.White

@Composable
fun WaterTracker() {
    // by + getValue/setValue — иначе делегат не работает
    var waterCount by remember { mutableIntStateOf(0) }
    var daysStreak by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += 250 }
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = {
                daysStreak = if (waterCount >= 1500) daysStreak + 1 else 0
                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Дней подряд (1500 мл и больше): $daysStreak",
            fontSize = 18.sp,
            color = secondaryColor
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun WaterTrackerPreview() {
    WaterTracker()
}

/* ===================== Задание 10 ===================== */

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

/*
 * Исправления:
 * 1. totalSum и productSize были полями Activity и увеличивались прямо в композиции
 *    при каждой перерисовке -> сумма росла. Теперь сумма и количество считаются
 *    из состояния (cart.products) и не хранятся отдельно.
 * 2. Toast вызывался прямо в композиции (при каждой перерисовке). Теперь он
 *    показывается один раз при нажатии на «Добавить товар».
 * 3. Кнопка «Удалить товар» зависела от productSize, а не от списка. Теперь
 *    показывается по условию cart.products.isNotEmpty().
 * 4. id нового товара брался как products.size, после удаления получались
 *    дубликаты. Теперь используется счётчик nextId.
 * 5. Composable-функции вынесены из Activity, теперь они обычные top-level.
 *
 * Использование: в MainActivity вызвать ShoppingCartScreen() внутри setContent.
 */
@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current

    var cart by remember {
        mutableStateOf(
            Cart(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        )
    }
    var nextId by remember { mutableIntStateOf(3) }

    val totalSum = cart.products.sumOf { it.price }

    Column {
        for (product in cart.products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        AddProductSection {
            val newProduct = Product(
                id = nextId,
                name = "Товар #${nextId + 1}",
                price = Random.nextInt(0, 100)
            )
            nextId++
            cart = Cart(cart.products + newProduct)

            // Если сумма заказа больше 500, показываем сообщение о бесплатной доставке
            if (cart.products.sumOf { it.price } > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }

        // Кнопка «Удалить товар» только при наличии товаров
        if (cart.products.isNotEmpty()) {
            RemoveProductSection {
                cart = Cart(cart.products.dropLast(1))
            }
        }
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(onRemove: () -> Unit) {
    Button(onClick = onRemove) {
        Text(text = "Удалить товар")
    }
}