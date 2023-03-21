package screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import repository.Repository
import retrofit.WithOutCash
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class WithOutCashViewModel@Inject constructor(
    private val repository: Repository
):ViewModel() {
     private val _listwithoutcash = MutableLiveData<Response<WithOutCash>> ()
    val listwithoutcash:LiveData<Response<WithOutCash>> = _listwithoutcash

    fun getMoneyWithOutCash(){
        viewModelScope.launch {
            _listwithoutcash.value = repository.getWithOutMoney()
        }
    }
}