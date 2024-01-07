package com.example.rulegame.rule_screen

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rulegame.R
import com.example.rulegame.ui.theme.MyBlackGreen
import com.example.rulegame.ui.theme.MyGreen
import com.example.rulegame.ui.theme.MyRed
import com.example.rulegame.utils.NumberUtil
import kotlin.math.roundToInt

@Composable
fun RuleScreen() {
    var rotationValue by remember {
        mutableFloatStateOf(0f)
    }

    var number by remember {
        mutableIntStateOf(0)
    }

    var index by remember {
        mutableFloatStateOf(0f)
    }

    val angle: Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(
            durationMillis = 5000,
        ),
        finishedListener = {
            index = (360f - (it % 360)) / (360f / NumberUtil.list.size)
            number = NumberUtil.list[index.roundToInt()]
        },
        label = ""
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 50.dp,
                    start = 150.dp,
                    end = 150.dp
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(30)
                ),
            text = number.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = when {
                index.roundToInt() == 0 -> MyGreen
                index.roundToInt() % 2 == 0 -> Color.Black
                index.roundToInt() % 2 != 0 -> MyRed
                else -> throw Exception("Error!")
            },
            textAlign = TextAlign.Center
        )
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Ruleta",
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(angle)
            )
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Flecha",
                modifier = Modifier.fillMaxSize()
            )
        }
        Button(
            onClick = {
                rotationValue = (1080..1440).random().toFloat() + angle
            },
            colors = ButtonDefaults.buttonColors(containerColor = MyRed),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 50.dp
                ),
            shape = RoundedCornerShape(30)
        ) {
            Text(
                text = "Start",
                color = Color.White
            )
        }
    }
}