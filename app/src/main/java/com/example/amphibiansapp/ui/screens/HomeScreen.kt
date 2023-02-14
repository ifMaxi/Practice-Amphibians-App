package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.AmphibiansInformation
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    amphibiansUiState: AmphibiansUiState
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Success -> AmphibianColumnsScreen(
            informations = amphibiansUiState.info,
            modifier = modifier
        )
        is AmphibiansUiState.Loading -> LoadingIcon(modifier)
        is AmphibiansUiState.Error -> ErrorIcon(modifier)
    }
}

@Composable
fun AmphibianColumnsScreen(
    modifier: Modifier = Modifier,
    informations: List<AmphibiansInformation>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items = informations) { info ->
            InformativeCard(information = info)
        }
    }
}

@Composable
fun InformativeCard(
    modifier: Modifier = Modifier,
    information: AmphibiansInformation
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = modifier
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = information.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 19.sp
                )
                Text(
                    text = ("(${information.type})"),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 19.sp
                )
            }
            Text(
                text = information.description,
                textAlign = TextAlign.Justify
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(information.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                error = painterResource(
                    R.drawable.wifi_off_fill0_wght400_grad0_opsz48
                ),
                placeholder = painterResource(
                    R.drawable.hourglass_empty_fill0_wght400_grad0_opsz48
                ),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(RoundedCornerShape(10))
            )
        }
    }
}

@Composable
fun LoadingIcon(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(200.dp),
                imageVector = Icons.Filled.HourglassEmpty,
                contentDescription = null,
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.loading),
                fontWeight = FontWeight.SemiBold,
                fontSize = 35.sp
            )
        }
    }
}

@Composable
fun ErrorIcon(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(200.dp),
                imageVector = Icons.Filled.WifiOff,
                contentDescription = null,
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.error),
                fontWeight = FontWeight.SemiBold,
                fontSize = 35.sp
            )
        }
    }
}

@Preview
@Composable
fun LoadingPreview() {
    AmphibiansAppTheme {
        LoadingIcon()
    }
}

@Preview
@Composable
fun ErrorPreview() {
    AmphibiansAppTheme {
        ErrorIcon()
    }
}