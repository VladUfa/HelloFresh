package com.example.hellofresh.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.hellofresh.R
import com.example.hellofresh.data.UiState
import com.example.hellofresh.data.difficultyImages
import com.example.hellofresh.data.getTime
import com.example.hellofresh.data.testRecipe
import com.example.hellofresh.ui.theme.firaInika
import com.example.hellofresh.ui.theme.firaItim
import com.example.hellofresh.ui.theme.firaJulius

/**
 * Second screen showing chosen recipe
 */
@Composable
fun ViewRecipeScreen(
    uiState: UiState,
    modifier: Modifier = Modifier
){
    val data = uiState.selectedRecipe
    Column(modifier = Modifier.fillMaxWidth().padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = data.name,
            fontFamily = firaJulius,
            fontSize = 30.sp,
            lineHeight = 30.sp
        )
        Text(
            text = data.headline,
            fontFamily = firaItim,
            fontSize = 20.sp,
            lineHeight = 20.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (data.image.isNotEmpty()){
                AsyncImage(
                    model = data.image,
                    contentDescription = "Recipe picture",
                    modifier = Modifier
                        .width(240.dp)
                        .height(170.dp)
                )
            }
            else {
                Spacer(modifier = Modifier
                    .width(240.dp)
                    .height(170.dp))
            }
            //Spacer(modifier = Modifier.width(4.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(
                        R.string.recipe_energy_2,
                        data.carbos,
                        data.fats,
                        data.proteins
                    ),
                    fontSize = 20.sp,
                    lineHeight = 28.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = data.calories,
                    fontSize = 20.sp,
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = getTime(data),
                    fontFamily = firaInika,
                    fontSize = 24.sp
                )
                Image(
                    painter = painterResource(difficultyImages[data.difficulty]),
                    contentDescription = "Difficulty picture",
                    modifier = Modifier.width(50.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = data.description,
            modifier = Modifier.padding(4.dp)
        )
    }
}


@Preview
@Composable
fun ViewRecipePreview(){
    ViewRecipeScreen(
        uiState = UiState(selectedRecipe = testRecipe),
        modifier = Modifier.fillMaxWidth()
    )
}
