package com.manu.crypto.domain.use_case.get_coins


import com.manu.crypto.common.Resource
import com.manu.crypto.data.remote.dto.toCoin
import com.manu.crypto.data.repository.CoinRepositoryImpl
import com.manu.crypto.domain.models.Coin
import com.manu.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins(). map { it.toCoin()}
            emit(Resource.Success<List<Coin>>(coins))
            
        }catch(e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"An  unexpected Error occurred!"))
            
        }catch(e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Please check your Internet Connections "))
        }

    }
}