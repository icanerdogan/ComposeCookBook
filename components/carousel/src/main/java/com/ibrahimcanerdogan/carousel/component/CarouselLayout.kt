package com.ibrahimcanerdogan.carousel.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.ibrahimcanerdogan.carousel.data.DemoDataProvider
import com.ibrahimcanerdogan.carousel.data.model.Item
import com.ibrahimcanerdogan.carousel.ui.theme.Green200

@Composable
fun CarouselLayout() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        val items = remember { DemoDataProvider.itemList.take(5) }
        val pagerState: PagerState = run {
            remember { PagerState(1, 0, items.size - 1) }
        }
        val selectedPage = remember { mutableIntStateOf(2) }

        PrepareFirstPager(pagerState, items, selectedPage)
        PrepareSecondPager(pagerState, items, selectedPage)
        PrepareThirdPager(pagerState, items, selectedPage)
        PrepareFourthPager(items)
    }
}

@Composable
fun CarouselItem(item: Item) {
    Box {
        Image(
            painter = painterResource(id = item.imageId),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineSmall.copy(color = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.BottomStart),
        )
    }
}

@Composable
fun CarouselItemCircle(item: Item) {
    Image(
        painter = painterResource(id = item.imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(16.dp)
            .size(160.dp)
            .clip(CircleShape)
    )
}

@Composable
fun CarouselItemCard(item: Item, pagerState: PagerState, selectedPage: MutableState<Int>) {
    val isSelected = selectedPage.value == pagerState.currentPage
    val animateSize = if (isSelected) 320.dp else 180.dp
    val animateElevation = if (isSelected) 12.dp else 2.dp
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            animateDpAsState(animateElevation).value
        ),
        modifier = Modifier
            .size(animateDpAsState(animateSize).value)
            .padding(24.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Green200,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Column {
            Text(
                text = item.title,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Image(
                painter = painterResource(id = item.imageId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(100.dp)
                    .clip(CircleShape)
            )
        }
    }

}

@Composable
private fun ColumnScope.PrepareFirstPager(
    pagerState: PagerState,
    items: List<Item>,
    selectedPage: MutableState<Int>
) {
    Pager(
        state = pagerState,
        modifier = Modifier.height(200.dp)
    ) {
        val item = items[commingPage]
        selectedPage.value = pagerState.currentPage
        CarouselItem(item)
    }

    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        items.forEachIndexed { index, _ ->
            CarouselDot(
                selected = index == selectedPage.value,
                MaterialTheme.colorScheme.primary,
                Icons.Filled.Star
            )
        }
    }

    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
private fun ColumnScope.PrepareSecondPager(
    pagerState: PagerState,
    items: List<Item>,
    selectedPage: MutableState<Int>
) {
    Pager(state = pagerState, modifier = Modifier.height(200.dp)) {
        val item = items[commingPage]
        selectedPage.value = pagerState.currentPage
        CarouselItemCircle(item)
    }
    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        items.forEachIndexed { index, _ ->
            CarouselDot(
                selected = index == selectedPage.value,
                MaterialTheme.colorScheme.error,
                Icons.Filled.Favorite
            )
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
private fun ColumnScope.PrepareThirdPager(
    pagerState: PagerState,
    items: List<Item>,
    selectedPage: MutableState<Int>
) {
    Pager(state = pagerState, modifier = Modifier.height(350.dp)) {
        val item = items[commingPage]
        selectedPage.value = pagerState.currentPage
        CarouselItemCard(item, pagerState, selectedPage)
    }
    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        items.forEachIndexed { index, _ ->
            CarouselDot(
                selected = index == selectedPage.value,
                MaterialTheme.colorScheme.secondary,
                Icons.Filled.Lock
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrepareFourthPager(
    items: List<Item>
) {
    HorizontalUncontainedCarousel(
        state = rememberCarouselState { items.count() },
        itemWidth = 250.dp,
        itemSpacing = 12.dp,
        contentPadding = PaddingValues(start = 12.dp),
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 10.dp, bottom = 12.dp)
    ) { itemIndex ->
        val value = items[itemIndex]
        Image(
            painter = rememberAsyncImagePainter(model = value.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(350.dp)
                .fillMaxWidth()
                .maskClip(shape = MaterialTheme.shapes.extraLarge)
        )
    }
}

@Preview
@Composable
fun PreviewCarouselLayout() {
    CarouselLayout()
}

@Preview
@Composable
fun PreviewCarouselItem() {
    val item = DemoDataProvider.item
    CarouselItem(item = item)
}

@Preview
@Composable
fun PreviewCarouselItemCircle() {
    val item = DemoDataProvider.item
    CarouselItemCircle(item = item)
}
