package com.example.carworth.uix.view.fonk

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.double
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive


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
    val client = HttpClient(CIO)
    try {
        val response: HttpResponse = client.get("https://carworth-vhir.onrender.com/araba") {
            contentType(ContentType.Application.Json)
            setBody(araba)
        }

        if (response.status.value in 200..299) {
            val jsonString = response.bodyAsText()
            val jsonElement = Json.parseToJsonElement(jsonString)
            val fiyat = jsonElement.jsonObject["fiyat"]?.jsonPrimitive?.double
            return fiyat
        } else {
            println("Backend hata verdi: ${response.status}")
            return null
        }
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    } finally {
        client.close()
    }
}
