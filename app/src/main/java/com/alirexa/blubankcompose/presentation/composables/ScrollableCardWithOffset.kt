package com.alirexa.blubankcompose.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import com.alirexa.blubankcompose.R
import kotlin.math.min

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollableCardWithOffset(
    maxOffset: Float,
    minOffset: Float,
    cardBackground: Color,
    content: LazyListScope.() -> Unit
) {
    val lazyListState = rememberLazyListState()
    var offset by remember(maxOffset) {
        mutableStateOf(maxOffset)
    }
    val nestedScroll = remember(maxOffset, minOffset) {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                return if (available.y >= 0) {
                    if (lazyListState.canScrollBackward) {
                        return Offset.Zero
                    }
                    val remainingOffset = java.lang.Float.max(maxOffset - offset, 0f)
                    val consumed = min(available.y, remainingOffset)
                    offset += consumed
                    Offset(0f, consumed)
                } else {
                    val remainingOffset = java.lang.Float.max(offset - minOffset, 0f)
                    val consumed = java.lang.Float.max(available.y, -remainingOffset)
                    offset += consumed
                    Offset(0f, consumed)
                }
            }
        }
    }
    Card(
        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.size_12),
            topEnd = dimensionResource(id = R.dimen.size_12),
        ),
        modifier = Modifier.offset { IntOffset(0, offset.toInt()) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(
                color = cardBackground,
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bottom_sheet_grapple),
                contentDescription = null,
                modifier = Modifier.height(dimensionResource(id = R.dimen.scrollable_card_grapple_height))
            )
            CompositionLocalProvider(
                LocalOverscrollConfiguration provides null
            ) {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .nestedScroll(nestedScroll),
                    content = content,
                )
            }
        }
    }
}