package ru.super135.gitapp.ui.users

import ru.super135.gitapp.domain.UserEntity
import ru.super135.gitapp.domain.UsersRepo

class UsersPresenter(private val usersRepo: UsersRepo) : UsersContract.Presenter {

    private var view: UsersContract.View? = null
    private var usersList: List<UserEntity>? = null
    private var inProgress: Boolean = false

    override fun attach(view: UsersContract.View) {
        this.view = view
        view.showProgress(inProgress)
        usersList?.let { view.showUsers(it) }
    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadDate()
    }

    private fun loadDate() {
        view?.showProgress(true)
        inProgress = true
        usersRepo.getUsers(
            onSuccess = {
                view?.showProgress(false)
                inProgress = false
                view?.showUsers(it)
                usersList = it
            },
            onError = {
                view?.showProgress(false)
                inProgress = false
                view?.showError(it)
            }
        )
    }
}