# WeatherApp
<img src="../main/screenshots/my_location.png" width="35%" height="35%"> <img src="../main/screenshots/map_location.png" width="35%" height="35%">


## Description

WeatherApp is just an Android simple weather app developed in Kotlin using OpenWeatherMap's One Call API.

### Highlights
* Current location weather for today and next week
* Show weather in any location tapping in a map
* Flat icons from [here](https://www.flaticon.com/packs/weather-161)
* Kotlin
* [Retrofit](https://github.com/square/retrofit) to do API calls
* OpenWeatherMap [One Call API](https://openweathermap.org/api/one-call-api) to get current weather
* [Maps SDK for Android](https://developers.google.com/maps/documentation/android-sdk/overview)
* MVVM architecture
* Coroutines

### Requirements
* Android 5.0 (API 21)

## Getting Started

To be able to build you must get the following api keys
* [OpenWeatherMap](https://home.openweathermap.org/users/sign_up)
* [Maps SDK for Android](https://developers.google.com/maps/documentation/android-sdk/cloud-setup)


The build uses [Secrets Gradle Plugin](https://github.com/google/secrets-gradle-plugin) to hide the API keys in the repository.
So, you should add the two api keys to the `local.properties` file as follows
```
OPENWEATHERMAP_API_KEY=<YOUR_OPENWEATHERMAP_API_KEY>
MAPS_API_KEY=<YOUR_MAPS_API_KEY>
```
