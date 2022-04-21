package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.gumtreetechtest.R

@Composable
fun SmallSpacer(modifier: Modifier = Modifier){
    Spacer(modifier = modifier
        .fillMaxWidth()
        .height(dimensionResource(id = R.dimen.medium_padding))
    )
}
@Composable
fun LargeSpacer(modifier: Modifier = Modifier){
    Spacer(modifier = modifier
        .fillMaxWidth()
        .height(dimensionResource(id = R.dimen.large_padding))
    )
}

@Composable
fun FullSpacer(modifier: Modifier = Modifier){
    Spacer(modifier = modifier
        .fillMaxSize(0.7f)
    )
}