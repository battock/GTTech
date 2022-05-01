package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import com.example.gumtreetechtest.ui.viewmodels.SearchInput
import java.util.*

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    label: String,
    onTxtChange: (selectedItem: String) -> Unit,
    selectedItem: State<SearchInput>? = null
) {
    var mSelectedText by remember { mutableStateOf("") }
    var mIsError by remember { mutableStateOf(false) }

    mSelectedText = selectedItem?.value?.data?:""
    mIsError = selectedItem?.value?.invalidText?.let {true } ?: false

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.standard_padding)),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor =MaterialTheme.colors.primary,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = Color.White,
                    textColor = Color.White,
                    disabledLabelColor = Color.White,
                    errorLabelColor = Color.Red
                ),
                isError = mIsError,
                value = mSelectedText,
                singleLine = true,
                onValueChange = {
                    mSelectedText = it
                    onTxtChange(it)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                label = {
                    val color = if(mIsError){Color.Red} else {Color.White}
                    DescriptionText(label,color = color)
                }
            )
            if (mIsError) {
                ErrorText(modifier = Modifier.semantics {
                        contentDescription = INPUT_VALIDATION_ERROR_TEXT
                    },
                    text = selectedItem?.value?.invalidText?.title?: stringResource(R.string.generic_invalid_txt_message))
            }
        }
    }
}


@Preview
@Composable
fun StandardDropDownPreview() {
    SearchTextField(label = "", onTxtChange = {})
}

const val INPUT_VALIDATION_ERROR_TEXT = "input_validation_error_txt"
