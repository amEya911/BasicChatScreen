package eu.tutorials.androidinterntechnicalexercise.api

import eu.tutorials.androidinterntechnicalexercise.model.DummyMessage
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getMessages(): List<DummyMessage>
}