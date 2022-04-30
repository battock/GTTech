package com.example.gumtreetechtest.ui.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.*
import com.example.gumtreetechtest.ui.themes.Purple200
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import java.lang.Exception
import java.lang.NumberFormatException

@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .border(
                2.dp,
                color = Color.LightGray,
                RectangleShape
            )
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(dimensionResource(id = R.dimen.standard_padding)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {

            HeaderText(text = "Motors.co.uk")
            SearchTextField(
                "Make",
                onTxtChange = { viewModel.setMake(it) },
            )
            SearchTextField(
                "Model",
                onTxtChange = { viewModel.setModel(it) },
            )
            SearchTextField(
                "Year",
                onTxtChange = { viewModel.setYear(it.validate()) },
            )
            StandardButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                "Update results",
                onClick = {viewModel.upDateResults()}
            )
        }
    }
}

/*
Just a basic try catch but in a real application this would be more considered
 */
private fun String.validate(): String {
    var isValid = true
    try{
        if(this.length!=4){ isValid = false}
        val intVal = this.toInt()
        if(intVal<1900||intVal>2022){isValid = false}
    }
    catch(ex:NumberFormatException){
        error("year format invalid failed with ex $ex")
        isValid = false
    }
    return if(isValid) {this} else {""}
}
