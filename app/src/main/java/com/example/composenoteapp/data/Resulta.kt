package com.example.composenoteapp.data

import androidx.annotation.Nullable

class Resulta<T> private constructor(
    val status: Status, val data: T? = null,
    @field:Nullable @param:Nullable val message: String?
) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T? = null): Resulta<T> {
            return Resulta(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?, data: T? = null): Resulta<T> {
            return Resulta(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T? = null): Resulta<T> {
            return Resulta(Status.LOADING, data, null)
        }
    }
}