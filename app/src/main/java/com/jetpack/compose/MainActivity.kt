package com.jetpack.compose

import android.content.Intent
import android.os.Bundle
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.EditorStyle
import androidx.ui.input.ImeAction
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.ButtonStyle
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.text.TextStyle
/**
 * Created by JAI on 29,November,2019
 * JAI KHAMBHAYTA
 */
class MainActivity : BaseActivity() {
    var strPassword: String = ""
    var strUserName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // sertup app layout
                appBar(title = "Jetpack Compose")
            }
        }
    }

    @Composable
    override fun setupView() {
        Center {
            Column(Spacing(10.dp)) {
                for (i in 0..1) {
                    HeightSpacer(10.dp)
                    if (i == 0)
                        Text(text = "Enter Username")
                    else
                        Text(text = "Enter Password")
                    HeightSpacer(3.dp)
                    setEditText(i)
                }

                HeightSpacer(20.dp)
                // set submit button
                Center {
                    FlexRow(crossAxisSize = LayoutSize.Expand, mainAxisSize = LayoutSize.Expand) {
                        expanded(1f)
                        {
                            Button(
                                text = "submit",
                                style = ButtonStyle(
                                    textStyle = TextStyle(fontSize = (15.sp)),
                                    elevation = 5.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(8.dp),
                                    border = Border(color = Color.Gray, width = 1.dp)
                                ),
                                onClick = {
                                    val viewIntent =
                                        Intent(this@MainActivity, ViewActivity::class.java)
                                    viewIntent.putExtra("username", strUserName)
                                    startActivity(viewIntent)
                                })
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun setEditText(isPassword: Int) {
        Center {
            Card(
                shape = RoundedCornerShape(size = 8.dp),
                border = Border(color = Color.Gray, width = 1.dp)
            ) {
                Column(
                    mainAxisSize = LayoutSize.Expand,
                    mainAxisAlignment = MainAxisAlignment.Center,
                    modifier = Spacing(10.dp)
                ) {
                    val state = +state { EditorModel("") }
                    TextField(
                        imeAction = ImeAction.Next,
                        value = state.value,
                        onValueChange = {
                            state.value = it
                            if (isPassword == 0) {
                                strUserName = state.value.text
                            } else {
                                strPassword = state.value.text
                            }
                        },
                        editorStyle = EditorStyle(
                            textStyle = TextStyle(
                                fontSize = (15.sp)
                            )
                        )
                    )
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Column(Spacing(top = 16.dp)) {
            Text(text = "Hello $name!")
        }
    }
}


