package ru.super135.gitapp.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.super135.gitapp.domain.UserEntity

interface UsersContract {

//    interface View {
//        fun showUsers(users: List<UserEntity>)
//        fun showError(throwable: Throwable)
//        fun showProgress(inProgress: Boolean)
//    }

    interface ViewModel {
        val usersLiveData: LiveData<List<UserEntity>>
        val errorLiveData: LiveData<Throwable?>
        val progressLiveData: LiveData<Boolean>
        fun onRefresh()

//        fun <T> LiveData<T>.post(value: T) {
//            val mutable = this as? MutableLiveData<T> ?: throw IllegalStateException("It is not MutableLivedata o_O")
//            mutable.postValue(value)
//        }
    }
}