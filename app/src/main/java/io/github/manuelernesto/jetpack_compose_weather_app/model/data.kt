package io.github.manuelernesto.composeapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.github.manuelernesto.jetpack_compose_weather_app.R


data class WeatherInfo(
    @StringRes val city: Int,
    @StringRes val temperature: Int,
    @StringRes val forecast: Int,
    @StringRes val data: Int,
    @DrawableRes val bgEffect: Int,
    @DrawableRes val bgCity: Int,
    @DrawableRes val bgColor: Int
)

val listWeatherInfo = listOf(
    WeatherInfo(
        R.string.city_ny,
        R.string.temp_ny,
        R.string.state_clear,
        R.string.data_ny,
        R.drawable.snow_efect,
        R.drawable.empire_state_building,
        R.drawable.snowy_bg
    ),
    WeatherInfo(
        R.string.city_paris,
        R.string.temp_paris,
        R.string.state_sunny,
        R.string.data_paris,
        R.drawable.sunny_bg,
        R.drawable.empire_state_building,
        R.drawable.sunny_bg
    ),WeatherInfo(
        R.string.city_sf,
        R.string.temp_sf,
        R.string.state_clear,
        R.string.data_sf,
        R.drawable.clear_bg,
        R.drawable.golden_gate_bridge,
        R.drawable.clear_bg
    )
)

