package com.manu.crypto.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manu.crypto.common.Resource
import com.manu.crypto.domain.use_case.get_coin.GetCoinUseCase
import com.manu.crypto.domain.use_case.get_coins.GetCoinsUseCase
import com.manu.crypto.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel(){
    private val _state= mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }


    private  fun getCoins(){
        getCoinsUseCase().onEach { result->
            when (result) {
                is Resource.Success -> {
                    _state.value=CoinListState(coins= result.data?: emptyList())
                }
                is Resource.Error->{
                    _state.value=CoinListState(error= result.message?:
                    "An unexpected error occurred"
                    )
                }
                is Resource.Loading->{
                    _state.value= CoinListState(isLoading = true)
                }

            }

        }.launchIn(viewModelScope)
    }
}