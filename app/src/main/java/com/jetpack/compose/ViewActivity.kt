package com.jetpack.compose
import android.os.Bundle
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
/**
 * Created by JAI on 29,November,2019
 * JAI KHAMBHAYTA
 */
class ViewActivity : BaseActivity() {
    var username: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // sertup app layout
                appBar(title = "Jetpack Compose View ")
            }
        }
    }

    @Composable
    override fun setupView() {
        // get intent
        username = intent.getStringExtra("username")
       // set text view in center
        Center {
            Column(Spacing(10.dp)) {
                Text(text = "Welcome $username")
            }
        }
    }
}