package com.example.composedesign.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedesign.R
import com.example.composedesign.data.model.MessageModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenCardPreview()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ScreenCardPreview() {
    HomePage()
}