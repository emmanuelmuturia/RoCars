package com.example.rocars.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RoCar(
    @DrawableRes val carImage: Int,
    @StringRes val carTitle: Int,
    @StringRes val carEngine: Int,
    @StringRes val carTopSpeed: Int,
    @StringRes val carAcceleration: Int,
    @StringRes val carDate: Int
)
