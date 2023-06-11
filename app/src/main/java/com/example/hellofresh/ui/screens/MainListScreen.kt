package com.example.hellofresh.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.hellofresh.R
import com.example.hellofresh.data.Recipe
import com.example.hellofresh.data.difficultyImages
import com.example.hellofresh.data.firaInika
import com.example.hellofresh.data.firaItim
import com.example.hellofresh.data.firaJulius
import com.example.hellofresh.data.getTime
import com.example.hellofresh.data.testDataList
import com.example.hellofresh.ui.theme.HelloFreshTheme


/**
 * Main screen with recipes list
 */
@Composable
fun StartHelloFreshScreen(
    helloFreshResults: List<Recipe>,
    onNextButtonClicked: (Recipe) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        for (data in helloFreshResults) {
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(240,240,250))
                    .padding(4.dp).clickable { onNextButtonClicked(data) }
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (data.thumb.isNotEmpty()){
                        AsyncImage(
                            model = data.thumb,
                            contentDescription = "Recipe picture",
                            modifier = Modifier.width(100.dp).height(70.dp)
                        )
                    }
                    else {
                        Spacer(modifier = Modifier.width(100.dp).height(70.dp))
                    }
                    Text(
                        text = getTime(data),
                        fontFamily = firaInika,
                        fontSize = 20.sp
                    )
                    Image(
                        painter = painterResource(difficultyImages[data.difficulty]),
                        contentDescription = "Difficulty picture",
                        modifier = Modifier.width(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = data.name,
                        fontFamily = firaJulius,
                        fontSize = 20.sp
                    )
                    Text(
                        text = data.headline,
                        fontFamily = firaItim,
                        fontSize = 16.sp,
                        lineHeight = 14.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(
                            R.string.recipe_energy_1,
                            data.carbos,
                            data.fats,
                            data.proteins
                        ),
                        fontSize = 14.sp,
                        lineHeight = 25.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = data.calories,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipePreview() {
    HelloFreshTheme {
        StartHelloFreshScreen(
            testDataList,
            onNextButtonClicked = {},
            modifier = Modifier.fillMaxSize().padding(16.dp)
        )
    }
}





