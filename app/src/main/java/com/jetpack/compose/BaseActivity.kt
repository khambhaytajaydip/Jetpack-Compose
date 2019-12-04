package com.jetpack.compose

import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.EditorStyle
import androidx.ui.layout.*
import androidx.ui.material.TopAppBar
import androidx.ui.material.surface.Card
import androidx.ui.text.TextStyle
/**
 * Created by JAI on 29,November,2019
 * JAI KHAMBHAYTA
 */
abstract class BaseActivity : AppCompatActivity() {

    @Composable
    fun appBar(title: String) {
        FlexColumn {
            inflexible {
                TopAppBar(title = {
                    Center {
                        // add text in center
                        Text(
                            text = title,
                            style = TextStyle(color = Color.White)
                        )
                    }
                })
            }
            setupView()
        }
    }


    /**
     * @author https://developer.android.com/reference/kotlin/androidx/ui/layout/package-summary.html#FlexColumn(androidx.ui.core.Modifier,%20androidx.ui.layout.MainAxisAlignment,%20androidx.ui.layout.LayoutSize,%20androidx.ui.layout.CrossAxisAlignment,%20androidx.ui.layout.LayoutSize,%20kotlin.Function1)
    inflexible -> meaning that the child is not flex, and it should be measured with loose constraints to determine its preferred height
    expanded   ->meaning that the child is flexible, and it should be assigned a height according to its flex weight relative to its flexible children. The child is forced to occupy the entire height assigned by the parent
    flexible   ->similar to expanded, but the child can leave unoccupied height.

     */
    @Composable
    abstract fun setupView()

}