package com.manu.crypto.presentation.coin_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.manu.crypto.presentation.coin_list.components.CoinDetailViewModel
import com.manu.crypto.ui.theme.Purple200

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin->
            LazyColumn(
                modifier=Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style= MaterialTheme.typography.h4,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text =if(coin.is_active) "active" else "inactive",
                            color=if(coin.is_active) Color.Green else Color.Red,
                            modifier = Modifier
                                .weight(2f)
                                .align(CenterVertically),
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description,
                        style= MaterialTheme.typography.body2,
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text= "Tags",
                        style= MaterialTheme.typography.h5
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag= tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text= "Team Members",
                        style= MaterialTheme.typography.h5
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(coin.team){ teamMember ->
                    TeamListItem(teamMember = teamMember,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                    )
                    Divider(color = Purple200)
                }

            }
        }

        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier=Modifier.align(Alignment.Center))
        }
    }
}