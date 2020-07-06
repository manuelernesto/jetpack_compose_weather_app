package io.github.manuelernesto.jetpack_compose_weather_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.graphics.ImageAsset
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import io.github.manuelernesto.composeapp.model.curWeather
import io.github.manuelernesto.jetpack_compose_weather_app.ui.Weather_appTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather_appTheme(darkTheme = false) {
                App()
            }
        }
    }
}


@Composable
fun App() {
    Scaffold(
        topAppBar = {
            TopAppBar(
                elevation = 0.dp,
                title = { Text(text = "COMPOSE WEATHER UI") },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(imageResource(R.drawable.menu))
                    }
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(imageResource(R.drawable.settings))
                    }
                }
            )
        },
        bodyContent = { MainScreen() }
    )
}

@Composable
fun MainScreen() {
    VerticalScroller {
        ConstraintLayout(constraintSet = ConstraintSet {
            tag("WeatherBgImage").apply {
                top constrainTo parent.top
                right constrainTo parent.right
                bottom constrainTo parent.bottom
                left constrainTo parent.left
            }

            val weatherLocation = tag("WeatherLocation").apply {
                right constrainTo parent.right
                left constrainTo parent.left
            }


            val weatherEfect = tag("WeatherEfect").apply {
                top constrainTo weatherLocation.bottom
                right constrainTo parent.right
                left constrainTo parent.left
            }

            tag("WeatherIcon").apply {
                top constrainTo weatherLocation.bottom
                right constrainTo parent.right
                left constrainTo parent.left
            }

            val weatherTem = tag("WeatherTemp").apply {
                top constrainTo weatherEfect.bottom
                bottom constrainTo weatherEfect.bottom
                right constrainTo parent.right
                left constrainTo parent.left
            }

            val weatherType = tag("WeatherType").apply {
                left constrainTo weatherTem.right
                top constrainTo weatherTem.top

            }

            val weatherStatus = tag("WeatherStatus").apply {
                top constrainTo weatherTem.bottom
                right constrainTo parent.right
                left constrainTo parent.left
            }
            val weatherDate = tag("weatherDate").apply {
                top constrainTo weatherStatus.bottom
                right constrainTo parent.right
                left constrainTo parent.left
            }

            val weatherOther = tag("weatherOther").apply {
                top constrainTo weatherDate.bottom
                right constrainTo parent.right
                left constrainTo parent.left
            }
        })
        {
            DrawBackground(
                R.drawable.clear_bg,
                modifier = Modifier.tag("WeatherBgImage").fillMaxSize()
            )
            Title(
                txt = curWeather.locationName,
                size = TextUnit.Companion.Sp(25),
                modifier = Modifier.tag("WeatherLocation")
                    .padding(16.dp)
            )
            DrawBackground(R.drawable.clear_efect, modifier = Modifier.tag("WeatherEfect"))
            DrawBackground(R.drawable.empire_state_building, modifier = Modifier.tag("WeatherIcon"))

            Title(
                txt = curWeather.currentTemperature.celcius.toString(),
                size = TextUnit.Companion.Sp(80),
                modifier = Modifier.tag("WeatherTemp")
            )
            Title(
                txt = "o",
                size = TextUnit.Companion.Sp(20),
                modifier = Modifier.tag("WeatherType").padding(top = 20.dp)
            )

            Title(
                txt = curWeather.forecast.state.name,
                size = TextUnit.Companion.Sp(20),
                modifier = Modifier.tag("WeatherStatus")
                    .padding(8.dp)
            )

            Title(
                txt = "Monday, 6 July 2020",
                size = TextUnit.Companion.Sp(18),
                modifier = Modifier.tag("weatherDate")
                    .padding(8.dp)
            )


            HorizontalScroller(
                modifier = Modifier.tag("weatherOther").fillMaxWidth().wrapContentSize(
                    Alignment.TopCenter
                )
            ) {
                var image: ImageAsset

                Row(modifier = Modifier.padding(8.dp)) {

                    repeat(20) {

                        image =
                            if (it % 2 == 0) imageResource(id = R.drawable.ic_cloud) else imageResource(
                                id = R.drawable.ic_sun
                            )

                        Column(
                            modifier = Modifier.padding(
                                start = 8.dp,
                                top = 16.dp,
                                end = 8.dp,
                                bottom = 16.dp
                            ),
                            horizontalGravity = Alignment.CenterHorizontally
                        ) {
                            Text(text = "${it + 1} PM", color = Color.White)
                            Spacer(modifier = Modifier.preferredHeight(16.dp))
                            Image(image, modifier = Modifier.size(24.dp))
                            Spacer(modifier = Modifier.preferredHeight(16.dp))
                            Text(text = "6", color = Color.White)
                        }
                        Spacer(modifier = Modifier.preferredHeight(16.dp))
                    }
                }


            }
        }
    }
}

@Composable
fun DrawBackground(img: Int, modifier: Modifier) {
    val image = imageResource(id = img)
    Image(
        image,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}


@Composable
fun Title(txt: String, size: TextUnit, modifier: Modifier) {
    Text(
        text = txt,
        color = Color.White,
        fontSize = size,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Weather_appTheme {
        App()
    }
}