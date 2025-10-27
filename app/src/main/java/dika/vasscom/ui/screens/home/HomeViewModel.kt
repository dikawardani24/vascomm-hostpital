package dika.vasscom.ui.screens.home

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import dika.vasscom.core.domain.model.HealthInfo.Companion.toTips
import dika.vasscom.core.domain.model.HealthServiceOffer.Companion.toBanner
import dika.vasscom.core.domain.useCase.GetHealthInformationsUseCase
import dika.vasscom.core.domain.useCase.GetHealthServiceOfferUseCase
import dika.vasscom.utils.executeIO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val getHealthInformationsUseCase: GetHealthInformationsUseCase,
    private val getHealthServiceOfferUseCase: GetHealthServiceOfferUseCase
): ViewModel() {
    private val _state = MutableStateFlow<HomeState>(HomeState.Idle)
    val state: StateFlow<HomeState> = _state

    fun getData() {
        _state.value = HomeState.Loading
        executeIO {
            val tips = getHealthInformationsUseCase.execute()
                .map { it.toTips() }
            val banners = getHealthServiceOfferUseCase.execute()
                .map { it.toBanner() }
            _state.value = HomeState.ShowData(
                tips = tips,
                banners = banners
            )
        }
    }
}