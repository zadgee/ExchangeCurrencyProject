package screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import repository.Repository
import retrofit.Cashmoney
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CashViewModel@Inject constructor(private val repository: Repository):ViewModel() {
   private val _cashMoney  = MutableLiveData<Response<Cashmoney>>()
   val cashMoney :LiveData<Response<Cashmoney>> = _cashMoney

    fun getCashMoney(){
        viewModelScope.launch {
            _cashMoney.value = repository.getCash()
        }
    }
}