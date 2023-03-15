package ru.super135.gitapp.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.super135.gitapp.domain.UserEntity
import ru.super135.gitapp.domain.UsersRepo
import ru.super135.gitapp.utils.SingleEventLiveData

class UsersViewModel(private val usersRepo: UsersRepo) : UsersContract.ViewModel {

//    private val _usersLiveData = MutableLiveData<List<UserEntity>>()
//    override val usersLiveData: LiveData<List<UserEntity>>
//        get() = _usersLiveData
//
//    private val _errorLiveData = MutableLiveData<Throwable>()
//    override val errorLiveData: LiveData<Throwable>
//        get() = _errorLiveData
//
//    private val _progressLiveData = MutableLiveData<Boolean>()
//    override val progressLiveData: LiveData<Boolean>
//        get() = _progressLiveData
    override val usersLiveData: LiveData<List<UserEntity>> = MutableLiveData<List<UserEntity>>()
    override val errorLiveData: LiveData<Throwable?> = SingleEventLiveData() //single event
    override val progressLiveData: LiveData<Boolean> = MutableLiveData<Boolean>()

    override fun onRefresh() {
        loadDate()
    }

    private fun loadDate() {
        progressLiveData.mutable().postValue(true)
        usersRepo.getUsers(
            onSuccess = {
                progressLiveData.mutable().postValue(false)
                usersLiveData.mutable().postValue(it)
            },
            onError = {
                progressLiveData.mutable().postValue(false)
                errorLiveData.mutable().postValue(it)
            }
        )
    }

    private fun <T> LiveData<T>.mutable(): MutableLiveData<T> {
        return this as? MutableLiveData<T> ?: throw IllegalStateException("It is not MutableLivedata o_O")
    }
}