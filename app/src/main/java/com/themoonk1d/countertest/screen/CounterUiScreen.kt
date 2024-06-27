package com.themoonk1d.countertest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.themoonk1d.countertest.R
import com.themoonk1d.countertest.model.CounterViewModel

@Composable
fun CounterLayout(modifier: Modifier = Modifier){
    val counterViewModel : CounterViewModel = viewModel()
    val uiState by counterViewModel.uiState.collectAsState()
    Column(
        modifier = modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CounterCard(
            counter = uiState.counter.toString()
        )
        CounterButtonRow(
            viewModel = counterViewModel
        )
    }
}

@Composable
fun CounterCard(
    modifier: Modifier = Modifier,
    counter : String
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(500.dp)
        .clip(RoundedCornerShape(30.dp))
        .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = counter,
                style = TextStyle(
                    fontSize = 200.sp,
                    fontWeight = FontWeight.Black
                ),
                color = MaterialTheme.colorScheme.surface
            )
            Text(
                text = "Counter App",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light
                ),
                color = MaterialTheme.colorScheme.surface
            )
        }
    }
}

@Composable
fun CounterButtonRow(
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        IconButton(
            onClick = { viewModel.incCounter() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_exposure_plus_1_24),
                contentDescription = "Add One",
            )
        }
        IconButton(
            onClick = { viewModel.rstCounter() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_refresh_24),
                contentDescription = "Add One",
            )
        }
        IconButton(
            onClick = { viewModel.decCounter() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_exposure_neg_1_24),
                contentDescription = "Add One",
            )
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun CounterLayoutPreview(){
    CounterLayout()
}