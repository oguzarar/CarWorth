package com.example.carworth.uix.view.fonk

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.doubleOrNull


@Serializable
data class Araba(
    val sehir: String,
    val marka: String,
    val seri: String,
    val model: String,
    val yil: Int,
    val kilometre: Int,
    val renk: String,
    val vitesTipi: String,
    val yakitTipi: String,
    val kasaTipi: String,
    val motorHacmi: Double,
    val motorGucu: Double,
    val cekis: String,
    val ortYakit: Double,
    val yakitDeposu: Double,
    val boya: Int,
    val degisen: Int,
    val tramer: Double
)
suspend fun getArabaFiyati(araba: Araba): Double? {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    return try {
        val response = client.post("https://carworth-vhir.onrender.com/araba") {
            contentType(ContentType.Application.Json)
            setBody(araba)
        }

        if (!response.status.isSuccess()) return null

        val jsonString = response.bodyAsText()
        val jsonElement = Json.parseToJsonElement(jsonString)
        jsonElement.jsonObject["fiyat"]?.jsonPrimitive?.doubleOrNull

    } catch (e: Exception) {
        println("Hata: ${e.message}")
        null
    } finally {
        client.close()
    }
}



