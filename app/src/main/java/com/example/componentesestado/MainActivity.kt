package com.example.componentesestado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Oswald

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                   BasicComponentsScreen(modifier = Modifier.padding(innerPadding))
                    ComponentesEstadoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(247, 139, 255))
    ){
        Text(
            text = "Aulas Android",
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 32.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "Com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66,133,244),
            fontFamily = Oswald
        )
    }
}


@Composable
fun ComponentesEstadoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nome = remember {
            mutableStateOf(value = "")
        }
        var idade = remember {
            mutableStateOf(value = "")
        }
        var senha = remember {
            mutableStateOf(value = "")
        }
        var senhaNumerico = remember {
            mutableStateOf(value = "")
        }

        TextField(
            value = nome.value,
            onValueChange = {
                novovalor ->
                Log.i("Teste", novovalor)

                nome.value = novovalor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            placeholder = {
                Text("Digite seu nome:")
            },
            label = {
                Text("Nome")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icone Pessoa",
                    tint = Color(8,68,17)
                )
            }
        )
        TextField(
            value = idade.value,
            onValueChange = {
                novovalor ->
                Log.i("Teste", novovalor)

                idade.value = novovalor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters)
        )
        TextField(
            value = senha.value,
            onValueChange = {
                novovalor ->
                Log.i("Teste", novovalor)

                senha.value = novovalor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None)
        )
        TextField(
            value = senhaNumerico.value,
            onValueChange = {
                novovalor ->
                Log.i("Teste", novovalor)

                senhaNumerico.value = novovalor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences)
        )
    }
}