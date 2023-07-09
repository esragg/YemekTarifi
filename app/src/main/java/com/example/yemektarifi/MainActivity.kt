package com.example.yemektarifi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yemektarifi.ui.theme.YemekTarifiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YemekTarifiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Yazi(icerik = "Yemek Tarifi")},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.anaRenk)
                )
            )
        },
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(painter = painterResource(id = R.drawable.yemekresim),
                    contentDescription = "Yemek resmi")
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { Log.e("Button","Begenildi") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.anaRenk)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Yazi(icerik = "Begen")
                    }
                    Button(onClick = { Log.e("Button","Yorum Yapildi") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.alternatifRenk)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Yazi(icerik = "Yorum Yap")
                    }
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)) {
                    Text(text = "Kofte",
                        color = colorResource(id = R.color.alternatifRenk),
                        fontSize = 18.sp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Yazi(icerik = "Izgaraya Uygun")
                        Yazi(icerik = "7 Haziran")
                    }
                }
                Text(text = "Köfte harcını hazırlamak için, soğanları rendeleyin ve maydanozları ince ince kıyın. İsterseniz, bir diş sarımsak da ekleyebilirsiniz.",
                    modifier = Modifier.padding(all = 10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}

@Composable
fun Yazi(icerik:String) {
    Text(text = icerik)
}

@Preview(showBackground = true)
@Composable
fun SayfaPreview() {
    YemekTarifiTheme {
        Sayfa()
    }
}