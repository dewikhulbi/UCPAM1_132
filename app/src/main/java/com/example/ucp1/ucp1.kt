package com.example.ucp1

import android.preference.PreferenceActivity.Header
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Biodata(modifier: Modifier = Modifier) {

    var Email by remember { mutableStateOf("") }
    var noTelp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var Tahunmasuk by remember { mutableStateOf("") }

    var datatahun = listOf("2020", "2021", "2022")
    var confemail by remember { mutableStateOf("") }
    var confnotelepon by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var conftahun by remember { mutableStateOf("") }

    Column(

        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection()
        Text(
            text = "Masukan Biodata Kamu",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
        Text(text = "silahkan isi dengan sebenar-benarnya", style = TextStyle(fontSize = 20.sp))

        Box(
            modifier = Modifier.fillMaxWidth().background(Color.Gray)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = Email,
                    onValueChange = { Email = it },
                    label = {
                        Text(text = "Email")
                    },
                    placeholder = {
                        Text(text = "Isi email anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    datatahun.forEach { selectedTahun ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = Tahunmasuk == selectedTahun,
                                onClick = { Tahunmasuk = selectedTahun }
                            )
                            Text(text = selectedTahun)
                        }
                    }
                }
                TextField(
                    value = noTelp,
                    onValueChange = { noTelp = it },
                    label = {
                        Text(text = "No Telepon")
                    },
                    placeholder = {
                        Text(text = "Isi no telepon anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                TextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = {
                        Text(text = "Alamat")
                    },
                    placeholder = {
                        Text(text = "Isi alamat anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                )
                Button(modifier = Modifier.fillMaxWidth().padding(5.dp),
                    onClick = {
                        confemail = Email
                        confnotelepon = noTelp
                        confalamat = alamat
                        conftahun = Tahunmasuk
                    }) {
                    Text(text = "Submit")
                }
                TampilData(
                    param = "Email",
                    argu = confemail
                )
                TampilData(
                    param = "No Telepon",
                    argu = confnotelepon
                )
                TampilData(
                    param = "Alamat",
                    argu = confalamat
                )
                TampilData(
                    param = "Tahun Masuk",
                    argu = conftahun
                )
            }
        }
    }
}
@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.Blue)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kucing),
                    contentDescription = null,
                    modifier = Modifier.clip(CircleShape).size(16.dp)
                )
                Icon(
                    Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(text = "Halo,")
                Text(text = "Muhamad Adri")
            }
        }
    }
}

@Composable
fun TampilData ( param:String, argu:String) {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.Gray)
    ) {
        Column(
            modifier = Modifier.padding((16.dp))
        ) {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
              Text(text = param,
                  modifier = Modifier.weight(0.8f))
                Text(text = ": ",
                    modifier = Modifier.weight(0.2f))
                Text(text = argu,
                    modifier = Modifier.weight(2f))
            }
        }
    }
}