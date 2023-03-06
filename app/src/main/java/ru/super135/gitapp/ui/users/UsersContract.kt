package ru.super135.gitapp.ui.users

import ru.super135.gitapp.domain.UserEntity

interface UsersContract {

    interface View {
        fun showUsers(users: List<UserEntity>)
        fun showError(throwable: Throwable)
        fun showProgress(inProgress: Boolean)
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()
        fun onRefresh()
    }
}