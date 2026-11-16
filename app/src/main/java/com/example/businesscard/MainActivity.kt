package com.example.businesscard

import android.R.attr.logo
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()

    ){
        Spacer(
            Modifier.weight(.7f)
        )
        Profile(
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
           Modifier.weight(.5f)
        )
        Contacts()
        Spacer(
            Modifier.weight(.1f)
        )
    }

}

@Preview(showBackground=true)
@Composable
fun BusinessCardPreview(){
    BusinessCardTheme() {
        BusinessCard()
    }
}

@Composable
fun Profile (modifier: Modifier = Modifier){
    Box(modifier = modifier){
        val painter = painterResource(R.drawable.whatsapp_image_2025_09_04_at_16_19_02)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box (
                Modifier.size(250.dp)
//                    .background(color = Color(0xFF001532))
            ){
                Image(painter = painter, contentDescription = stringResource(R.string.main_image), contentScale = ContentScale.Fit, modifier = Modifier.fillMaxSize())
            }
            Spacer(Modifier.height( 20.dp))
            Text(stringResource(R.string.name), fontSize = 20.sp)
            Spacer(Modifier.height(5.dp))
            Text(stringResource(R.string.android_title), fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF3DDC84))
        }
    }
}

@Preview(showBackground=true)
@Composable
fun ProfilePreview() {
    BusinessCardTheme{
        Profile()
    }
}


@Composable
fun Contacts (){
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ){

        LineItem(id = R.drawable.phone_icon, logoDesc = "Phone", text = stringResource(R.string.number))
        LineItem(id = R.drawable.octicons_mark_github, logoDesc = "Git Hub OctoCat", text = stringResource(
            R.string.github_link
        ))
        LineItem(id = R.drawable.mail_icon, logoDesc="Email", text= stringResource(R.string.email))
        LineItem(id = R.drawable.share_icon, logoDesc = "Share", text = "@AndroidDev")
        LineItem(
            id = R.drawable.linkedin_icon,
            logoDesc = "LinkedIn",
            text = stringResource(R.string.linkedIn_profile)
        )
    }
}


@Composable
fun LineItem(id: Int, logoDesc: String, text: String) {

    Row(
    ) {
        Spacer(Modifier.width(70.dp))
        Icon(painter = painterResource(id,), contentDescription=logoDesc,  modifier = Modifier.size(size = 16.dp), tint = Color.Unspecified)
        Spacer(Modifier.width(20.dp))
        Text(text)
    }
}

@Preview(showBackground=true)
@Composable
fun ContactsPreview(){
    BusinessCardTheme{
        Contacts()
    }
}
