package com.example.mydictionary.feature_dictionary.domain.model


data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
//    val phonetics: List<Phonetic>,
    val word: String
)