package ru.super135.gitapp.data

import android.os.Handler
import android.os.Looper
import ru.super135.gitapp.domain.UserEntity
import ru.super135.gitapp.domain.UsersRepo

private const val DATA_LOADING_FAKE_DELAY = 2_000L

class FakeUsersRepoImpl : UsersRepo {
    private val data: List<UserEntity> = listOf(
        UserEntity("mojombo", 1, "https://avatars.githubusercontent.com/u/1?v=4"),
        UserEntity("defunkt", 2, "https://avatars.githubusercontent.com/u/2?v=4"),
        UserEntity("pjhyett", 3, "https://avatars.githubusercontent.com/u/3?v=4")
    )

    override fun getUsers(onSuccess: (List<UserEntity>) -> Unit, onError: ((Throwable) -> Unit)?) {
        Handler(Looper.getMainLooper()).postDelayed({
            onSuccess(data)
//            onError?.invoke(IllegalStateException("Я ошибка!"))
        }, DATA_LOADING_FAKE_DELAY)

    }
}