package com.example.rulegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.rulegame.rule_screen.RuleScreen
import com.example.rulegame.ui.theme.MyBlackGreen
import com.example.rulegame.ui.theme.MyGreen
import com.example.rulegame.ui.theme.RuleGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RuleGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MyBlackGreen
                ) {
                    RuleScreen()
                }
            }
        }
    }
}