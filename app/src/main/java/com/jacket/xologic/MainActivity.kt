package com.jacket.xologic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import com.jacket.xologic.ui.theme.XoLogicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XoLogicTheme {
                Text(
                    text = "Bienvenido a XoLogic"
                )
            }
        }
    }
}