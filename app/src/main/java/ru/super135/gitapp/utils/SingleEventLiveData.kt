package ru.super135.gitapp.utils


import androidx.lifecycle.MutableLiveData


class SingleEventLiveData<T> : MutableLiveData<T>() {


    override fun getValue(): T? {
        val currentValue = super.getValue()
        if (currentValue != null) {
            postValue(null)
        }
        return currentValue
    }

}