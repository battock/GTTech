package com.example.gumtreetechtest.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gumtreetechtest.ui.components.ScrollingList
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme

@Composable
fun ResultsScreen(
    navController: NavController,
    resultsScreenTitleTxt: String = "RESULTS",
    modifier: Modifier = Modifier
) {
    val listOfDummyData = List(100){i->"Header $i"}
    ScrollingList(listOfDummyData)
}

@Preview(showBackground = true)
@Composable
fun DefaultResultsPreview() {
    GumTreeAppTheme {
        //ResultsScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkResultsPreview() {
    GumTreeAppTheme {
        //ResultsScreen()
    }
}