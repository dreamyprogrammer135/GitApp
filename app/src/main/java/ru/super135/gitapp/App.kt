package ru.super135.gitapp

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import ru.super135.gitapp.data.FakeUsersRepoImpl
import ru.super135.gitapp.domain.UsersRepo

class App : Application() {
    val usersRepo: UsersRepo by lazy { FakeUsersRepoImpl() }

    override fun onCreate() {
        super.onCreate()
        //todo
    }
}


val Context.app: App get() = applicationContext as App
val Fragment.app: App get() = requireContext().applicationContext as App