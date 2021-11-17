package com.example.mydictionary.feature_dictionary.domain.model

import com.example.mydictionary.feature_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)