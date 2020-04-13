package com.holiday.planner.calendarAPI

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.calendar.Calendar
import com.google.api.services.calendar.model.Events
import com.google.auth.oauth2.AccessToken
import com.google.auth.oauth2.GoogleCredentials
import org.springframework.core.io.ClassPathResource
import java.io.FileReader


class CalendarAPI {

    private val APPLICATION_NAME = "Google Calendar API Java Quickstart"

    private val CREDENTIALS_FILE_PATH = "credentials.json"


    private fun getCredentials(): GoogleCredential {

        val result = ClassPathResource(CREDENTIALS_FILE_PATH).file.bufferedReader()
        val clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), FileReader(CREDENTIALS_FILE_PATH))
        val tokenResponse = GoogleAuthorizationCodeTokenRequest(NetHttpTransport(),
                JacksonFactory.getDefaultInstance(), "https://oauth2.googleapis.com/token", clientSecrets.details.clientId, clientSecrets.details.clientSecret, "", "")
                .execute()

        val accessToken = tokenResponse.accessToken

        return GoogleCredential().setAccessToken(accessToken)

    }

    fun test()  {

        val credentials: GoogleCredential = getCredentials()

        val service: Calendar = Calendar.Builder(NetHttpTransport(), JacksonFactory.getDefaultInstance(), credentials)
                .setApplicationName(APPLICATION_NAME)
                .build()


        val result : Events = service.events().list("primary").setMaxResults(10).setSingleEvents(true).execute()

    }
}