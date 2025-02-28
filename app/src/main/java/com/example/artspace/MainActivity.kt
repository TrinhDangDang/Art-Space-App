package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                    ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var currentIndex by remember{mutableStateOf(1)}
    Surface(

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentIndex) {
                1 -> {
                    ArtworkWall()
                    ArtworkDescriptor()
                    DisplayController()
                }

                2 -> ArtworkWall()
                3 -> ArtworkWall()
            }
        }
    }

}

@Composable
fun ArtworkWall(modifier: Modifier = Modifier){
    Surface (
        modifier = modifier
            .padding(16.dp)
            .shadow(8.dp),
    ) {
        Image (
            painter = painterResource(R.drawable.guernica),
            contentDescription = "guernica painting",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier){
    Surface (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = Color.LightGray
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp)
        ){
            Text(
                text = "Guernica",
                fontSize = 20.sp
            )
            Text(
                text = "Pablo Picasso",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }

    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Button(onClick = {}) {
            Text("Previous")
        }

        Button(onClick = {}) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}