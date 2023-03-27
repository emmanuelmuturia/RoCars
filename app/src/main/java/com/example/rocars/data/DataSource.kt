package com.example.rocars.data

import com.example.rocars.R
import com.example.rocars.model.RoCar

object DataSource {
    val myRoCars: List<RoCar> = listOf(
        RoCar(R.drawable.maserati_granturismo_trofeo, R.string.maserati_granturismo_trofeo, R.string.day1_engine, R.string.day1_top_speed, R.string.day1_carAcceleration)
    )
}