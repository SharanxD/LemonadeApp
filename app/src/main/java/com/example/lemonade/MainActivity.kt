package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(){

    WelcomeScreen()
}
@Composable
fun WelcomeScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){


            var a by remember{
                mutableStateOf(1)
            }
            Column(modifier=Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(text = stringResource(id = R.string.welcome), fontSize = 45.sp, color = Color(0xFF3ddc84), fontWeight = FontWeight.Bold)
                Text(text = stringResource(id = R.string.to), fontSize = 45.sp, color = Color(0xFF3ddc84),fontWeight = FontWeight.Bold)
                Text(text = stringResource(id = R.string.lemonademaker), fontSize = 45.sp, color = Color(0xFF3ddc84),fontWeight = FontWeight.Bold)
                Spacer(modifier=Modifier.height(20.dp))
                Button(onClick = {a=0} ){
                    Text(text = stringResource(id = R.string.button), fontSize = 20.sp, color = Color.Black)
                }
            }
            if(a==0) LemonadeMaking()



    }

}
@Composable
fun LemonadeMaking() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){


            var exit by remember{
                mutableStateOf(0)
            }
            var screen by remember {
                mutableStateOf(1)
            }
            var displayText = when (screen) {
                1 -> R.string.tree
                2 -> R.string.squeeze
                3 -> R.string.drink
                else -> R.string.restart
            }
            var ImageResource = when (screen) {
                1 -> R.drawable.lemon_tree
                2 -> R.drawable.lemon_squeeze
                3 -> R.drawable.lemon_drink
                else -> R.drawable.lemon_restart
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = displayText), fontSize = 24.sp, color = Color(0xFF3ddc84))
                Spacer(modifier = Modifier.height(20.dp))

                Image(modifier= Modifier
                    .border(width = 2.dp, color = Color(0xFF3ddc84), shape = RoundedCornerShape(10.dp))
                    .clickable {
                        when (screen) {
                            in 1..3 -> screen++
                            else -> screen = 1
                        }
                    },
                    painter = painterResource(id = ImageResource),
                    contentDescription = "Image to display"
                )

            }

            Column(modifier=Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End){
                Button(onClick = { exit=1 },modifier=Modifier
                    .padding(bottom=50.dp,end=50.dp)
                ) {
                    Text(text= stringResource(id = R.string.exit),)
                }


            }
            if(exit==1) WelcomeScreen()


    }

}