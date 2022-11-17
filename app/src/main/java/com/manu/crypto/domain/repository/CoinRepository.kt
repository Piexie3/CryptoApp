package com.manu.crypto.domain.repository

import com.manu.crypto.data.remote.dto.CoinDetailDto
import com.manu.crypto.data.remote.dto.CoinDto

interface CoinRepository  {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}