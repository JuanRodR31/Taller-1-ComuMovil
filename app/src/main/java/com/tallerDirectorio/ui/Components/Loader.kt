package com.tallerDirectorio.ui.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme


@Composable
fun Loader(modifier: Modifier = Modifier){
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .aspectRatio(1f),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}


@Preview(showBackground = true, widthDp = 400, heightDp = 200)
@Composable
fun LoaderPreview() {
    AppTheme {
        Loader()
    }
}
