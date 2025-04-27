package com.finance.tracker.finance.presentation.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.tracker.finance.data.dto.onboarding.OnBoardModel
import com.finance.tracker.finance.presentation.onboarding.components.OnBoardItem
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreenRoot(
    pages: List<OnBoardModel>,
    onFinish: () -> Unit
) {

    OnBoardingScreen(
        pages,
        onFinish
    )
}

@Composable
fun OnBoardingScreen(
    pages: List<OnBoardModel>,
    onFinish: () -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pages.size }
    )

    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) { page ->
                OnBoardItem(page = pages[page])
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (pagerState.currentPage < pages.size - 1) {
                    Button(onClick = { onFinish() }) {
                        Text(text = "Skip")
                    }
                    Button(onClick = {
                        coroutineScope.launch {
                            val nextPage = pagerState.currentPage + 1
                            pagerState.animateScrollToPage(nextPage)
                        }
                    }) {
                        Text(text = "Next")
                    }
                } else {
                    Button(
                        onClick = { onFinish() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Get Started")
                    }
                }
            }
        }
    }
}
