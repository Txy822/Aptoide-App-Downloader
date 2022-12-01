package com.tes.apps.development.aptoideappdownloader.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tes.apps.development.aptoideappdownloader.domain.model.AppInfo
import com.tes.apps.development.aptoideappdownloader.R.drawable as AppIcon
import com.tes.apps.development.aptoideappdownloader.R.string as AppText

@Composable
fun AptoideMainScreen(
) {

    val navigator: NavController
    val viewModel: AptoideViewModel = hiltViewModel()
    val state = viewModel.state



    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(
            modifier = Modifier.padding(
                horizontal = 16.dp
            )
        )
        ActionToolbar(
            title = AppText.title,
            modifier = Modifier.wrapContentSize(Alignment.TopEnd),
            endActionIcon = AppIcon.ic_baseline_account_circle_24,
            endAction = { }
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))


        Row(
            modifier = Modifier
                .padding(12.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Editors Choice", style = TextStyle(color = Color.Black, fontSize = 16.sp))
            Spacer(Modifier.weight(1f))
            Text(text = "More", style = TextStyle(color = Color.Red, fontSize = 16.sp))
        }

        //Spacer(modifier = Modifier.padding(vertical = 2.dp))
        LazyRow(
            modifier = Modifier
                .padding(12.dp)
        ) {
            items(state.apps.size) { i ->
                val app = state.apps[i]
                ShowItem(
                    app = app,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                        }
                        .padding(16.dp)
                )
                if (i < state.apps.size) {
                    Divider(
                        modifier = Modifier.padding(
                            horizontal = 16.dp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        Row(
            modifier = Modifier
                .padding(12.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Local top apps", style = TextStyle(color = Color.Black, fontSize = 16.sp))
            Spacer(Modifier.weight(1f))
            Text(text = "More", style = TextStyle(color = Color.Red, fontSize = 16.sp))
        }
        LazyRow(
            modifier = Modifier
                .padding(12.dp)
        ) {
            items(state.apps.size) { i ->
                val app = state.apps[i]
                ShowSmallItem(
                    app = app,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                        }
                        .padding(16.dp)
                )
                if (i < state.apps.size) {
                    Divider(
                        modifier = Modifier.padding(
                            horizontal = 8.dp
                        )
                    )
                }
            }
        }

    }
}


@Composable
fun ShowItem(
    app: AppInfo,
    modifier: Modifier = Modifier
) {
    val imagePainter = rememberAsyncImagePainter(app.graphic)

    val description = app.storeName
    val title = app.name
    val rating = app.rating

    ImageCard(
        painter = imagePainter,
        contentDescription = description!!,
        title = title!!,
        rating = rating!!
    )

}

@Composable
fun ShowSmallItem(
    app: AppInfo,
    modifier: Modifier = Modifier
) {
    val imagePainter = rememberAsyncImagePainter(app.icon)

    val description = app.storeName

    SmallImageCard(
        painter = imagePainter,
        rating = app.rating!!,
        contentDescription = description!!,
    )

}


@Composable
fun ActionToolbar(
    @StringRes title: Int,
    @DrawableRes endActionIcon: Int,
    modifier: Modifier,
    endAction: () -> Unit
) {
    TopAppBar(
        title = { Text(stringResource(title)) },
        backgroundColor = toolbarColor(),
        actions = {
            Box(modifier) {
                IconButton(onClick = endAction) {
                    Icon(painter = painterResource(endActionIcon), contentDescription = "Action")
                }
            }
        }
    )
}

@Composable
private fun toolbarColor(darkTheme: Boolean = isSystemInDarkTheme()): Color {
    return if (darkTheme) MaterialTheme.colors.secondary else MaterialTheme.colors.primaryVariant
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    rating: Double,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(300.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column() {

                    Text(text = title, style = TextStyle(color = Color.White, fontSize = 20.sp))

                    Row() {
                        Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = Color.White)
                        Text(
                            text = rating.toString(),
                            style = TextStyle(color = Color.White, fontSize = 20.sp)
                        )
                    }
                }

            }

        }

    }
}


@Composable
fun SmallImageCard(
    painter: Painter,
    contentDescription: String,
    rating: Double,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .height(220.dp)
                .width(150.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center
            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = contentDescription, style = TextStyle(color = Color.Black, fontSize = 16.sp))
                Row() {
                    Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = Color.Black)
                    Text(
                        text = rating.toString(),
                        style = TextStyle(color = Color.Black, fontSize = 16.sp)
                    )
                }

            }

        }

    }
}

