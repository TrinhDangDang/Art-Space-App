package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun ArtSpaceApp() {
    var currentIndex by remember { mutableStateOf(1) }

    // Root Box that fills the screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 1) Artwork in the middle
        Column(
            modifier = Modifier.align(Alignment.Center), // Centered vertically & horizontally
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentIndex) {
                1 -> ArtworkWall(R.drawable.guernica)
                2 -> ArtworkWall(R.drawable.mona_lisa)
                3 -> ArtworkWall(R.drawable.the_kiss)
                4 -> ArtworkWall(R.drawable.thescream)
                5 -> ArtworkWall(R.drawable.the_starry_night)
            }
        }

        // 2) Descriptor and buttons near the bottom
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Anchors near the bottom
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentIndex) {
                1 -> ArtworkDescriptor(
                    paintingRes = R.string.guernica_artist,
                    artistRes = R.string.guernica_artist,
                    yearRes = R.string.guernica_year
                )
                2 -> ArtworkDescriptor(
                    paintingRes = R.string.Mona_Lisa_painting,
                    artistRes = R.string.mona_lisa_artist,
                    yearRes = R.string.mona_lisa_year
                )
                3 -> ArtworkDescriptor(
                    paintingRes = R.string.the_kiss_painting,
                    artistRes = R.string.the_kiss_artist,
                    yearRes = R.string.the_kiss_year
                )
                4 -> ArtworkDescriptor(
                    paintingRes = R.string.the_scream,
                    artistRes = R.string.the_scream_artist,
                    yearRes = R.string.the_scream_year
                )
                5 -> ArtworkDescriptor(
                    paintingRes = R.string.the_starry_night,
                    artistRes = R.string.the_starry_night_artist,
                    yearRes = R.string.the_starry_night_year
                )
            }

            DisplayController(
                imageIndex = currentIndex,
                imageNext = { if (currentIndex < 5) currentIndex++ },
                imagePrev = { if (currentIndex > 1) currentIndex-- }
            )
        }
    }
}




@Composable
fun ArtworkWall(@DrawableRes imageRes: Int,  modifier: Modifier = Modifier){
    Surface (
        modifier = modifier
            .padding(16.dp)
            .shadow(8.dp),
    ) {
        Image (
            painter = painterResource(imageRes),
            contentDescription = "famous painting",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(@StringRes paintingRes: Int, @StringRes artistRes: Int, @StringRes yearRes: Int,modifier: Modifier = Modifier){
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
                text = stringResource(paintingRes),
                fontSize = 20.sp
            )
            Text(
                text = "${stringResource(artistRes)} (${stringResource(yearRes)})",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }

    }
}

@Composable
fun DisplayController(imageIndex: Int,imageNext: () -> Unit, imagePrev: () -> Unit, modifier: Modifier = Modifier){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Button(
            onClick = imagePrev,
            modifier = Modifier.height(40.dp).width(120.dp) ) {
            Text("Previous")
        }

        Button(
            onClick = imageNext,
            modifier = Modifier.height(40.dp).width(120.dp) ) {
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