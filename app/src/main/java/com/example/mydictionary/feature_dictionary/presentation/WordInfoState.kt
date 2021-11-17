package com.example.mydictionary.feature_dictionary.presentation

import com.example.mydictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    private val wordinfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false

)
