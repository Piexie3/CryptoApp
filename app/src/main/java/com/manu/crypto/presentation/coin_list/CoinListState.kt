package com.manu.crypto.presentation.coin_list

import com.manu.crypto.domain.models.Coin
import com.manu.crypto.domain.models.CoinDetail

data class CoinListState(
    val isLoading: Boolean=false,
    val coins: List<Coin> = emptyList(),
    val coin: CoinDetail?=null,
    val error: String=""
)
