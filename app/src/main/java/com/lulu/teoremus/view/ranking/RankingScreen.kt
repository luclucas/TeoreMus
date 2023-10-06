package com.lulu.teoremus.view.ranking

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.lulu.teoremus.R
import com.lulu.teoremus.fontes.Typography
import com.lulu.teoremus.model.User
import com.lulu.teoremus.utils.Titulo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RankingScreen : ComponentActivity() {

    private lateinit var viewModel: RankingViewModel
    var isOk = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel = ViewModelProvider(this)[RankingViewModel::class.java]

        GlobalScope.launch {
            isOk = viewModel.getUsers()
            Log.d("lulutag", isOk.toString())
        }



        setContent {
            var userList = remember { mutableStateListOf<User?>() }
            val db = FirebaseFirestore.getInstance()
            db.collection("Usuarios").get().addOnSuccessListener {
                if (!it.isEmpty) {
                    val list = it.documents
                    list.forEach {
                        val user: User? = it.toObject(User::class.java)
                        userList.add(user)
                    }
                } else {
                    Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(
                    this,
                    "Fail to get the data.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Tela(userList)
        }
    }

}


@Composable
private fun Tela(userList: SnapshotStateList<User?>) {
    val context = LocalContext.current as Activity

    if (!userList.isNullOrEmpty()) {
        Column(
            Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


        Row(Modifier.padding(10.dp).fillMaxWidth().fillMaxHeight(0.1f), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,

                    contentDescription = "",
                    tint = colorResource(
                        id = R.color.card_tela_principal
                    ),
                    modifier = Modifier.padding(end = 20.dp).size(40.dp).clickable {
                        context.finish()
                    }
                )
                Text(
                    text = "Placar",
                    style = Typography.h1,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.card_tela_principal)
                )
            }

            LazyColumn {

                itemsIndexed(userList) { index, item ->
                    Card(
                        Modifier
                            .padding(horizontal = 30.dp, vertical = 20.dp)
                            .fillMaxWidth()
                            .align(CenterHorizontally),
                        backgroundColor = colorResource(id = R.color.cor_botoes_modulo)
                    ) {
                        Row(
                            Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "$index",
                                Modifier.padding(
                                    top = 20.dp,
                                    bottom = 20.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                ),
                                color = Color.Yellow,
                                fontSize = 30.sp
                            )
                            Text(
                                text = "${item!!.nome}",
                                Modifier.padding(
                                    top = 20.dp,
                                    bottom = 20.dp,
                                    start = 10.dp,
                                    end = 10.dp
                                ),
                                color = Color.White,
                                fontSize = 30.sp
                            )
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {


                                Image(
                                    painter = painterResource(id = R.drawable.pontos_cheio),
                                    contentDescription = "",
                                    Modifier
                                        .size(80.dp)
                                        .padding(
                                            top = 20.dp,
                                            bottom = 20.dp,
                                            start = 10.dp,
                                        )
                                )
                                Text(
                                    text = "= ${item!!.total}",
                                    Modifier.padding(
                                        top = 20.dp,
                                        bottom = 20.dp,
                                        end = 10.dp
                                    ),
                                    color = Color.White,
                                    fontSize = 30.sp
                                )
                            }
                        }
                    }
                }

            }
        }
    }

}