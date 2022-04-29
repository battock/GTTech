package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import java.util.*

@Composable
fun SearchTextField(
    label: String,
    onTxtChange: (selectedItem: String) -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
) {
    var mSelectedText by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.standard_padding)),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        OutlinedTextField(
            value = mSelectedText,
            singleLine = true,
            onValueChange = {
                mSelectedText = it
                onTxtChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            label = { DescriptionText(label) })

    }
}



@Preview
@Composable
fun StandardDropDownPreview() {
    SearchTextField("", {})
}