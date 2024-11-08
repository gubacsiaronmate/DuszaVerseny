package com.gubo.duszaverseny.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gubo.duszaverseny.ui.theme.DuszaVersenyTheme
import com.gubo.duszaverseny.ui.theme.darkPrimary

@Composable
fun LandingPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = darkPrimary)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun LandingPagePreview() {
    DuszaVersenyTheme {
        LandingPage()
    }
}
