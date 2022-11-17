package com.manu.crypto.presentation.coin_details

import com.manu.crypto.domain.models.Coin
import com.manu.crypto.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean=false,
    val coin: CoinDetail?= null,
    val error: String=""
)
