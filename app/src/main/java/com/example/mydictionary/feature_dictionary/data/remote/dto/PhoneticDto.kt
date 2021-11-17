package com.example.mydictionary.feature_dictionary.data.remote.dto

import com.example.mydictionary.feature_dictionary.domain.model.Phonetic

data class PhoneticDto(
    val audio: String,
    val text: String
) {
    fun toPhotenic(): Phonetic {
        return Phonetic(
            audio = audio,
            text = text
        )
    }
}