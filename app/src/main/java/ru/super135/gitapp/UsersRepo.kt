package ru.super135.gitapp

interface UsersRepo {
    // C_R_U_D

    // (-)Create
    // (-)Update
    // (-)Delete

   // Read
    fun getUsers(
       onSuccess: (List<UserEntity>) -> Unit,
       onError: ((Throwable) -> Unit)? = null
   )
}