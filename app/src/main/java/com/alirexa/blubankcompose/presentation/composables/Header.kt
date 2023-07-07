package com.alirexa.blubankcompose.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alirexa.blubankcompose.R
import com.alirexa.blubankcompose.domain.entity.AccountBalanceEntity
import com.alirexa.blubankcompose.presentation.mappers.toAccountBalanceView


@Composable
fun Header(accountBalance: AccountBalanceEntity, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.bg_header),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(
                    top = dimensionResource(id = R.dimen.padding_16),
                    bottom = dimensionResource(id = R.dimen.padding_32),
                ),
        ) {
            BlubankToolbar()
            AccountBalance(accountBalance.toAccountBalanceView())
            HeaderActions()
        }
    }
}

@Composable
fun BlubankToolbar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.padding_8)),
    ) {
        ToolbarActionButton(painter = painterResource(id = R.drawable.search))
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_24)))
        ToolbarActionButton(painter = painterResource(id = R.drawable.download))
        Text(
            text = stringResource(R.string.home),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.header_text),
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )
        ToolbarActionButton(painter = painterResource(id = R.drawable.notification))
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_24)))
        ToolbarActionButton(painter = painterResource(id = R.drawable.support))
    }
}

@Composable
fun ToolbarActionButton(painter: Painter) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(dimensionResource(id = R.dimen.size_24))
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = colorResource(id = R.color.header_icon_tint)
        )
    }
}

@Composable
fun AccountBalance(state: AccountBalanceView) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = state.amount,
            color = colorResource(id = R.color.header_text),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.account_balance),
            color = colorResource(id = R.color.header_text),
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun HeaderActions() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        HeaderAction(
            painter = painterResource(id = R.drawable.add),
            title = stringResource(R.string.add_to_account),
            background = colorResource(
                id = R.color.header_action_background_special,
            ),
            iconTint = colorResource(id = R.color.header_action_icon_special),
        )
        HeaderAction(
            painter = painterResource(id = R.drawable.spaces),
            title = stringResource(R.string.spaces),
            background = colorResource(
                id = R.color.header_action_background,
            ),
            iconTint = colorResource(id = R.color.header_icon_tint),
        )
        HeaderAction(
            painter = painterResource(id = R.drawable.chart),
            title = stringResource(R.string.economic_management),
            background = colorResource(
                id = R.color.header_action_background,
            ),
            iconTint = colorResource(id = R.color.header_icon_tint),
        )
    }
}

@Composable
fun HeaderAction(painter: Painter, title: String, background: Color, iconTint: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = { /*TODO*/ }, modifier = Modifier
                .background(color = background, shape = CircleShape)
                .size(dimensionResource(id = R.dimen.size_72))
        ) {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(dimensionResource(id = R.dimen.size_32)),
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_8)))
        Text(text = title, color = colorResource(id = R.color.header_text), fontSize = 18.sp)
    }
}

data class AccountBalanceView(
    val amount: String,
)