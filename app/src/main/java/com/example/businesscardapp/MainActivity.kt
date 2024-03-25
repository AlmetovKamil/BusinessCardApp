package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        MainTitle()
        Column(
            modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 15.dp)) {
            ContactInfoTile(icon = Icons.Rounded.Call, text = "+7-(917)-091-91-84")
            ContactInfoTile(icon = Icons.Rounded.Share, text = "@almetov_kamil")
            ContactInfoTile(icon = Icons.Rounded.Email, text = "almetov.kamil@gmail.com")
        }

    }
}

@Composable
fun MainTitle(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .background(Color.Blue)
                .size(100.dp)
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(painter = image, contentDescription = null, modifier = modifier.fillMaxSize())
        }

        Text(
            text = "Kamil Almetov",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(bottom = 5.dp)
        )
        Text(
            text = "Android & Flutter developer",
            style = MaterialTheme.typography.labelSmall,
        )
    }
}


@Composable
fun ContactInfoTile(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(3.dp)) {
        Icon(icon, contentDescription = null)
        Spacer(modifier.width(8.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}