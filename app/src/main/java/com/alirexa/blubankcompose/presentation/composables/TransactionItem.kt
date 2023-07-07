package com.alirexa.blubankcompose.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alirexa.blubankcompose.R

@Composable
fun TransactionItem(state: TransactionItemView) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_16))
    ) {
        Image(
            painter = state.painter, contentDescription = null, modifier = Modifier.size(
                dimensionResource(id = R.dimen.size_48)
            )
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_16)))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = state.title,
                fontSize = 18.sp,
                color = colorResource(id = R.color.transactions_title)
            )
            Text(
                text = state.date,
                fontSize = 16.sp,
                color = colorResource(id = R.color.transactions_description)
            )
        }
        Text(
            text = state.amount,
            fontSize = 18.sp,
            color = colorResource(id = R.color.transactions_price),
            modifier = if (state.isHighlighted) Modifier.background(
                color = colorResource(
                    id = R.color.transactions_highlights_tint
                )
            ) else Modifier,
        )
    }
}

data class TransactionItemView(
    val painter: Painter,
    val title: String,
    val date: String,
    val amount: String,
    val isHighlighted: Boolean,
)