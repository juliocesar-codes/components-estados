package com.example.componentesestado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
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
    var corFundo by remember {
        mutableStateOf(Color(54, 132, 45))
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nome by remember {
            mutableStateOf(value = "")
        }
        var idade by remember {
            mutableStateOf(value = "")
        }
        var email by remember {
            mutableStateOf(value = "")
        }
        var xml by remember {
            mutableStateOf(value = false)
        }
            var jetpackCompose by remember {
            mutableStateOf(value = false)
          }

        var sOperacional by remember {
            mutableStateOf(value = "")
        }

        var favoritado by remember {
            mutableStateOf(value = false)
        }

        Spacer(modifier = Modifier. height(16.dp))

        TextField(
            value = nome,
            onValueChange = {
                novovalor ->
                Log.i("Teste", novovalor)

                nome = novovalor
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
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.Blue,
                focusedPlaceholderColor = Color.Yellow
            )
        )

        TextField(
            value = idade,
            onValueChange = {
                    novovalor ->
                Log.i("Teste", novovalor)

                idade = novovalor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters
            ),
            placeholder = {
                Text("Digite sua idade:")
            },
            label = {
                Text("Idade")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icone Pessoa",
                    tint = Color(8,68,17)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.Blue,
                focusedPlaceholderColor = Color.Yellow
            )
        )

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            singleLine = true,
            placeholder = {Text(text = "Digite o seu email")},
            label = {
                Text(text = "Email")
            },
            shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Magenta,
                unfocusedTextColor = Color.Blue,
                focusedPlaceholderColor = Color.Yellow,
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Yellow
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = jetpackCompose,
                onCheckedChange = {
                    jetpackCompose = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "Jetpack Compose")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = xml,
                onCheckedChange = {
                    xml = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "XML")
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
        RadioButton(
            selected = sOperacional == "ios",
            onClick = {
                sOperacional = "ios"
            }
        )

        Text(text = "IOS")}

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
        RadioButton(
            selected = sOperacional == "android",
            onClick = {
                sOperacional = "android"
            }
        )

        Text(text = "Android")}

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
        RadioButton(
            selected = sOperacional == "wPhone",
            onClick = {
                sOperacional = "wPhone"
            }
        )
        Text(text = "wPhone")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    corFundo = Color.White
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.Black
                ),
                border = BorderStroke(width = 4.dp, Color.Gray),
                shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp)
            ) {
                Text(text = "Clique aqui")
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Icon"
                )
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color.Cyan
                }
            ) {
                Text(text = "Não, clique aqui!")
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            if (favoritado){
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable{
                            favoritado = false
                        },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Icon Favorite"
                )
            }else{
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable{
                            favoritado = true
                        },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Icon border Favorite"
                )
            }
        }


    }
}