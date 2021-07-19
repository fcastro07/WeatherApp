package com.example.weatherapp.data.model

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

//{
//    "lat": 33.44,
//    "lon": -94.04,
//    "timezone": "America/Chicago",
//    "timezone_offset": -18000,
//    "current": {
//    "dt": 1626495600,
//    "sunrise": 1626434278,
//    "sunset": 1626485167,
//    "temp": 23.65,
//    "feels_like": 24.16,
//    "pressure": 1016,
//    "humidity": 80,
//    "dew_point": 20,
//    "uvi": 0,
//    "clouds": 1,
//    "visibility": 10000,
//    "wind_speed": 1.34,
//    "wind_deg": 122,
//    "wind_gust": 2.68,
//    "weather": [
//    {
//        "id": 800,
//        "main": "Clear",
//        "description": "clear sky",
//        "icon": "01n"
//    }
//    ]
//},
//    "daily": [
//    {
//        "dt": 1626458400,
//        "sunrise": 1626434278,
//        "sunset": 1626485167,
//        "moonrise": 1626457620,
//        "moonset": 1626412680,
//        "moon_phase": 0.22,
//        "temp": {
//        "day": 30.38,
//        "min": 22,
//        "max": 30.89,
//        "night": 23.65,
//        "eve": 27.21,
//        "morn": 22
//    },
//        "feels_like": {
//        "day": 34.02,
//        "night": 24.16,
//        "eve": 29.7,
//        "morn": 22.81
//    },
//        "pressure": 1016,
//        "humidity": 62,
//        "dew_point": 22.38,
//        "wind_speed": 4.55,
//        "wind_deg": 220,
//        "wind_gust": 10.38,
//        "weather": [
//        {
//            "id": 501,
//            "main": "Rain",
//            "description": "moderate rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 100,
//        "pop": 0.93,
//        "rain": 7.8,
//        "uvi": 9.62
//    },
//    {
//        "dt": 1626544800,
//        "sunrise": 1626520716,
//        "sunset": 1626571540,
//        "moonrise": 1626547980,
//        "moonset": 1626500940,
//        "moon_phase": 0.25,
//        "temp": {
//        "day": 31.34,
//        "min": 22,
//        "max": 32.88,
//        "night": 26.65,
//        "eve": 29.49,
//        "morn": 22.22
//    },
//        "feels_like": {
//        "day": 34.8,
//        "night": 26.65,
//        "eve": 33.62,
//        "morn": 22.98
//    },
//        "pressure": 1018,
//        "humidity": 57,
//        "dew_point": 21.99,
//        "wind_speed": 3.47,
//        "wind_deg": 250,
//        "wind_gust": 5.72,
//        "weather": [
//        {
//            "id": 501,
//            "main": "Rain",
//            "description": "moderate rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 31,
//        "pop": 1,
//        "rain": 9.89,
//        "uvi": 10.48
//    },
//    {
//        "dt": 1626631200,
//        "sunrise": 1626607154,
//        "sunset": 1626657911,
//        "moonrise": 1626638460,
//        "moonset": 1626589380,
//        "moon_phase": 0.3,
//        "temp": {
//        "day": 33.06,
//        "min": 22.94,
//        "max": 33.84,
//        "night": 24.01,
//        "eve": 30.29,
//        "morn": 22.97
//    },
//        "feels_like": {
//        "day": 35.85,
//        "night": 24.71,
//        "eve": 35,
//        "morn": 23.54
//    },
//        "pressure": 1018,
//        "humidity": 48,
//        "dew_point": 20.66,
//        "wind_speed": 2.42,
//        "wind_deg": 193,
//        "wind_gust": 4.91,
//        "weather": [
//        {
//            "id": 500,
//            "main": "Rain",
//            "description": "light rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 87,
//        "pop": 0.62,
//        "rain": 1.65,
//        "uvi": 10.12
//    },
//    {
//        "dt": 1626717600,
//        "sunrise": 1626693593,
//        "sunset": 1626744281,
//        "moonrise": 1626729060,
//        "moonset": 1626677940,
//        "moon_phase": 0.33,
//        "temp": {
//        "day": 25.16,
//        "min": 21.92,
//        "max": 29.29,
//        "night": 25.03,
//        "eve": 28.22,
//        "morn": 22.13
//    },
//        "feels_like": {
//        "day": 25.85,
//        "night": 25.52,
//        "eve": 30.82,
//        "morn": 22.93
//    },
//        "pressure": 1017,
//        "humidity": 81,
//        "dew_point": 21.62,
//        "wind_speed": 3.24,
//        "wind_deg": 322,
//        "wind_gust": 7.55,
//        "weather": [
//        {
//            "id": 501,
//            "main": "Rain",
//            "description": "moderate rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 96,
//        "pop": 1,
//        "rain": 12.2,
//        "uvi": 10.34
//    },
//    {
//        "dt": 1626804000,
//        "sunrise": 1626780032,
//        "sunset": 1626830649,
//        "moonrise": 1626819780,
//        "moonset": 1626766860,
//        "moon_phase": 0.37,
//        "temp": {
//        "day": 26.73,
//        "min": 21.83,
//        "max": 27.53,
//        "night": 21.83,
//        "eve": 25.53,
//        "morn": 22.19
//    },
//        "feels_like": {
//        "day": 28.77,
//        "night": 22.5,
//        "eve": 26.31,
//        "morn": 22.97
//    },
//        "pressure": 1014,
//        "humidity": 75,
//        "dew_point": 22.04,
//        "wind_speed": 2.49,
//        "wind_deg": 81,
//        "wind_gust": 6,
//        "weather": [
//        {
//            "id": 501,
//            "main": "Rain",
//            "description": "moderate rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 100,
//        "pop": 0.92,
//        "rain": 11.59,
//        "uvi": 8.7
//    },
//    {
//        "dt": 1626890400,
//        "sunrise": 1626866472,
//        "sunset": 1626917016,
//        "moonrise": 1626910320,
//        "moonset": 1626856320,
//        "moon_phase": 0.41,
//        "temp": {
//        "day": 29.67,
//        "min": 20.25,
//        "max": 31.17,
//        "night": 25.53,
//        "eve": 28.11,
//        "morn": 20.6
//    },
//        "feels_like": {
//        "day": 32.4,
//        "night": 26.18,
//        "eve": 30.61,
//        "morn": 21.25
//    },
//        "pressure": 1016,
//        "humidity": 61,
//        "dew_point": 21.27,
//        "wind_speed": 2.78,
//        "wind_deg": 203,
//        "wind_gust": 7.39,
//        "weather": [
//        {
//            "id": 500,
//            "main": "Rain",
//            "description": "light rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 98,
//        "pop": 0.47,
//        "rain": 0.11,
//        "uvi": 0.04
//    },
//    {
//        "dt": 1626976800,
//        "sunrise": 1626952912,
//        "sunset": 1627003381,
//        "moonrise": 1627000620,
//        "moonset": 1626946140,
//        "moon_phase": 0.45,
//        "temp": {
//        "day": 30.43,
//        "min": 22.18,
//        "max": 31.67,
//        "night": 24.91,
//        "eve": 28.83,
//        "morn": 22.24
//    },
//        "feels_like": {
//        "day": 33.67,
//        "night": 25.52,
//        "eve": 32.01,
//        "morn": 22.97
//    },
//        "pressure": 1020,
//        "humidity": 60,
//        "dew_point": 21.63,
//        "wind_speed": 3.98,
//        "wind_deg": 247,
//        "wind_gust": 6.04,
//        "weather": [
//        {
//            "id": 500,
//            "main": "Rain",
//            "description": "light rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 67,
//        "pop": 0.71,
//        "rain": 1.37,
//        "uvi": 1
//    },
//    {
//        "dt": 1627063200,
//        "sunrise": 1627039353,
//        "sunset": 1627089745,
//        "moonrise": 1627090380,
//        "moonset": 1627036500,
//        "moon_phase": 0.5,
//        "temp": {
//        "day": 32.91,
//        "min": 22.5,
//        "max": 32.91,
//        "night": 27.51,
//        "eve": 29.97,
//        "morn": 23.06
//    },
//        "feels_like": {
//        "day": 35.83,
//        "night": 29.86,
//        "eve": 34.73,
//        "morn": 23.85
//    },
//        "pressure": 1019,
//        "humidity": 49,
//        "dew_point": 21.06,
//        "wind_speed": 3.29,
//        "wind_deg": 241,
//        "wind_gust": 5.37,
//        "weather": [
//        {
//            "id": 500,
//            "main": "Rain",
//            "description": "light rain",
//            "icon": "10d"
//        }
//        ],
//        "clouds": 97,
//        "pop": 0.68,
//        "rain": 1.18,
//        "uvi": 1
//    }
//    ]
//}