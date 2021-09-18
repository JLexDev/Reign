package com.jlexdev.reign.ui

import androidx.lifecycle.*
import com.jlexdev.domain.entity.HitsEntity
import com.jlexdev.domain.entity.ReignEntity
import com.jlexdev.domain.usecase.GetReignUseCase
import com.jlexdev.reign.base.BaseViewModel
import com.jlexdev.reign.mapper.ReignModelMapper
import com.jlexdev.reign.model.HitsModel
import com.jlexdev.reign.model.ReignModel
import kotlinx.coroutines.Dispatchers

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class MainViewModel (private val getReignUseCase: GetReignUseCase,
                     private val mapper: ReignModelMapper) : BaseViewModel<MainNavigator>() {

    private var _query = ""

    private val _reign = MutableLiveData<ReignEntity>()

    val reign: LiveData<ReignModel> = _reign.switchMap {
        liveData(Dispatchers.IO) {
            emit(mapper.hitsDomainToApp(it))
        }
    }

    init {
        executeGetReignUseCase()
    }

    private fun executeGetReignUseCase() {
        showLoading(true)
        _query = "mobile"
        val params = GetReignUseCase.Params(_query)
        getReignUseCase.invoke(viewModelScope, params) {
            it.either(::handleUseCaseFailureFromBase, ::handleUseCaseSuccess)
        }
    }

    private fun handleUseCaseSuccess(reign: ReignEntity) {
        _reign.value = reign
    }
}


