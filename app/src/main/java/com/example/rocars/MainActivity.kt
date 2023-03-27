package com.example.rocars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rocars.data.DataSource
import com.example.rocars.model.RoCar
import com.example.rocars.ui.theme.RoCarsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoCarsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RoCarApp()
                }
            }
        }
    }
}


@Composable
fun RoCarApp() {
    LazyColumn {
        items(DataSource.myRoCars) { cars ->
            RoCard(roCar = cars)
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
        Column {
            Image(
                painter = painterResource(id = roCar.carImage),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(id = roCar.carTitle), fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(7.dp))
            Row {
                Text(text = "Engine: ", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 7.dp))
                Spacer(modifier = Modifier.width(7.dp))
                Text(text = stringResource(id = roCar.carEngine))
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(text = "Top Speed: ", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 7.dp))
                Spacer(modifier = Modifier.width(7.dp))
                Text(text = stringResource(id = roCar.carTopSpeed))
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(text = "Acceleration: ", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 7.dp))
                Spacer(modifier = Modifier.width(7.dp))
                Text(text = stringResource(id = roCar.carAcceleration))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RoCardPreview() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        RoCard(roCar = RoCar(R.drawable.maserati_granturismo_trofeo, R.string.maserati_granturismo_trofeo, R.string.day1_engine, R.string.day1_top_speed, R.string.day1_carAcceleration))
    }
}