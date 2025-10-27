package dika.vasscom.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

@Suppress("unused")
object JSonHelper {
    val gson: Gson = GsonBuilder()
        .disableHtmlEscaping()
        .create()

    fun <T> fromJson(kClass: Class<T>, strJson: String): T {
        return gson.fromJson(strJson, kClass)
    }

    fun <T> fromJson(type: Type, strJson: String): T {
        return gson.fromJson(strJson, type)
    }

    fun <T> toJson(kClass: Class<T>, obj: T): String {
        return gson.toJson(obj, kClass)
    }

    fun <T> toJson(obj: T): String {
        return gson.toJson(obj)
    }
}