package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gumtreetechtest.R

@Composable
fun StandardDropDown(
    label: String,
    onClick: (selectedItem: String) -> Unit,
    listItems: List<String> = emptyList(),
    icon: ImageVector? = null
) {
    var mExpanded by remember { mutableStateOf(false) }
    var mSelectedText by remember { mutableStateOf(label) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.standard_padding)),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = { DescriptionText("") },
            trailingIcon = {
                icon?.let {
                    Icon(icon, "contentDescription",
                        Modifier.clickable { mExpanded = !mExpanded })
                }
            }
        )
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.standard_padding))
        ) {
            listItems.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        mSelectedText = label
                        onClick(label)
                        mExpanded = false
                    },
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.small_padding))
                )

                {
                    DescriptionText(text = label)
                }
            }
        }
    }

}


@Preview
@Composable
fun StandardDropDownPreview() {
    StandardDropDown("", {})
}