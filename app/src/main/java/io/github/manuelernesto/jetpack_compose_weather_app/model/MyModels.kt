package io.github.manuelernesto.composeapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.github.manuelernesto.jetpack_compose_weather_app.R


class Temperature(
        val celcius: Double
)

enum class WeatherState(
        @DrawableRes val iconID: Int,
        @StringRes val descriptionID: Int
) {
    SUNNY(R.drawable.ic_sunny, R.string.state_sunny),
    RAINY(R.drawable.ic_sunny, R.string.state_rainy),
    PARTLY_CLOUDY(R.drawable.ic_sunny, R.string.state_p_cloudy),
    SNOWY(R.drawable.ic_sunny, R.string.state_snowy)

}

data class WeatherForecast(
        val maxTemperature: Temperature,
        val minTemperature: Temperature,
        val state: WeatherState
)

data class CurrentWeather(
        val locationName: String,
        val currentTemperature: Temperature,
        val forecast: WeatherForecast
)


val temp = Temperature(21.0)
val forecast = WeatherForecast(temp, temp, WeatherState.SUNNY)
val curWeather = CurrentWeather("Lubango", temp, forecast = forecast)

