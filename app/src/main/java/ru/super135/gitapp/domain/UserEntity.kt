package ru.super135.gitapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * ru.super135.gitapp.domain
 *
 *
 * @author Ilja
 * 13.03.2023
 */
@Parcelize
data class UserEntity(
    val login: String,
    val id: Long,
    val avatarUrl: String
) : Parcelable