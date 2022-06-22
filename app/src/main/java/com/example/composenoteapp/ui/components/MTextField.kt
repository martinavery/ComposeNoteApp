package com.example.composenoteapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun MTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    onValueChange: (value: String) -> Unit
) {
    TextField(
        value = value,
        label = { Text(text = label) },
        onValueChange = onValueChange,
        modifier = modifier
    )
}