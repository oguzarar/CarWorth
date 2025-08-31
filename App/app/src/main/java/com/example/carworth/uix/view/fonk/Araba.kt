package com.example.carworth.uix.view.fonk

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json



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
    val boya: String,
    val degisen: String,
    val tramer: Double
)

suspend fun sendAraba(araba: Araba) {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { prettyPrint = true; isLenient = true })
        }
    }

    val response: HttpResponse = client.post("http://your-fastapi-url/araba") {
        contentType(io.ktor.http.ContentType.Application.Json)
        setBody(araba)
    }

    println(response.status)
    client.close()
}
