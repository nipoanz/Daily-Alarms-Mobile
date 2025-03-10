package com.miso.dailyalarms.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.miso.dailyalarms.R

/**
 * The home screen displaying the loading message.
 */
@Composable
fun SpinnerScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues = PaddingValues()
) {
    val loadingDescription = stringResource(R.string.loading_data)
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .align(Alignment.Center)
                .semantics {
                    contentDescription = loadingDescription
                },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SpinnerPreview() {
    AppTheme(darkTheme = false) {
        SpinnerScreen()
    }
}
