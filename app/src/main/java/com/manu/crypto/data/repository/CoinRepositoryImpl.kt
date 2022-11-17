package com.manu.crypto.data.repository

import com.manu.crypto.data.remote.CoinPaprikaApi
import com.manu.crypto.data.remote.dto.CoinDetailDto
import com.manu.crypto.data.remote.dto.CoinDto
import com.manu.crypto.domain.repository.CoinRepository

class CoinRepositoryImpl(private val api: CoinPaprikaApi ): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}