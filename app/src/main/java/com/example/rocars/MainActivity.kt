package com.example.rocars

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rocars.data.DataSource
import com.example.rocars.model.RoCar
import com.example.rocars.ui.theme.RoCarsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoCarsTheme {
                // A surface container using the 'background' color from the theme
                Box {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(R.drawable.background),
                        contentDescription = "background_image",
                        contentScale = ContentScale.FillBounds
                    )
                    RoCarApp()
                }
            }
        }
    }
}


@Composable
fun RoCarApp() {
    Scaffold(
        topBar = { RoCarAppBar() }
    ) { it
        LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.primary).fillMaxSize()) {
            items(DataSource.myRoCars) { cars ->
                RoCard(roCar = cars)
            }
        }
    }
}


@Composable
fun RoCard(roCar: RoCar, modifier: Modifier = Modifier) {
    Card(elevation = 7.dp, modifier = Modifier.padding(7.dp)) {
        /*Image(
            painter = painterResource(id = R.drawable.canvas),
            contentDescription = null,
            modifier = modifier
                .fillMaxSize()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )*/
        Column(modifier = Modifier.background(color = MaterialTheme.colors.surface)) {
            Image(
                painter = painterResource(id = roCar.carImage),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(id = roCar.carTitle), style = MaterialTheme.typography.h1)
            }
            Spacer(modifier = Modifier.height(7.dp))
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Engine: ", style = MaterialTheme.typography.h2, modifier = Modifier.padding(start = 7.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = stringResource(id = roCar.carEngine), style = MaterialTheme.typography.h3)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Top Speed: ", style = MaterialTheme.typography.h2, modifier = Modifier.padding(start = 7.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = stringResource(id = roCar.carTopSpeed), style = MaterialTheme.typography.h3)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Acceleration: ", style = MaterialTheme.typography.h2, modifier = Modifier.padding(start = 7.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = stringResource(id = roCar.carAcceleration), style = MaterialTheme.typography.h3)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Date: ", style = MaterialTheme.typography.h2, modifier = Modifier.padding(start = 7.dp, bottom = 7.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = stringResource(id = R.string.day_1), style = MaterialTheme.typography.h3)
            }
        }
    }
}


@Composable
fun RoCarAppBar() {
    Row(
        modifier = Modifier.background(color = MaterialTheme.colors.background).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.f1), contentDescription = null, modifier = Modifier.size(width = 63.dp, height = 63.dp).padding(7.dp))
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.h1, fontSize = 28.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun RoCardPreview() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        RoCard(roCar = RoCar(R.drawable.maserati_granturismo_trofeo, R.string.maserati_granturismo_trofeo, R.string.day1_engine, R.string.day1_top_speed, R.string.day1_carAcceleration, R.string.day_1))
    }
}