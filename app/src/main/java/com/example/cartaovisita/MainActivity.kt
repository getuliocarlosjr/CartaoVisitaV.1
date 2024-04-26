package com.example.cartaovisita

import androidx.compose.foundation.Image
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaovisita.ui.theme.CartaoVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaoVisitaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Adicionando a imagem na tela icone persona
        val image = painterResource(R.drawable.baseline_person_black_48)
        Image(
            painter = image,
            contentDescription = null,
            //Ajustando tamanho da imagem
            modifier = Modifier
                //Altura
                .height(150.dp)
                //Largura
                .width(150.dp))
        Row {
            BusinessInfoCard(
                fullName = "Getúlio Carlos de Souza Junior",
                title = "Analista de Teste - Senior"
            )
        }

        Row{
            BusinessCardContact(
                telefone = "+55 (31) 9999 9999",
                email = "teste@contato.com.br",
                homepage = "@testeAndroid"
            )
        }
    }
}

@Composable
private fun BusinessInfoCard(
    fullName: String,
    title : String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = fullName,
            //Alterando o tamanho da fonte
            fontSize = 24.sp,
            //Adiciando o espaço superior entre a imagem e o texto
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
        )
        Text(
            text = title,
            //Alterando o tamanho da fonte
            fontSize = 16.sp
        )

    }

}

@Composable
private fun BusinessCardContact(
    telefone : String,
    email : String,
    homepage : String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start){

        Text(
            text = telefone,
            //Alterando o tamanho da fonte
            fontSize = 16.sp,
            //Alterando cor do text
            color = Color(0xFF08497E),

        )
        Text(
            text = email,
            //Alterando o tamanho da fonte
            fontSize = 16.sp
        )
        Text(
            text = homepage,
            //Alterando o tamanho da fonte
            fontSize = 16.sp
        )
    }

}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    CartaoVisitaTheme {
        BusinessCardApp()
    }
}