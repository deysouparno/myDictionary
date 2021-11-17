package com.example.mydictionary.feature_dictionary.data

import com.example.mydictionary.core.utils.Resource
import com.example.mydictionary.feature_dictionary.data.local.WordInfoDao
import com.example.mydictionary.feature_dictionary.data.remote.DictionariApi
import com.example.mydictionary.feature_dictionary.domain.model.WordInfo
import com.example.mydictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordInfoRepositoryImpl(
    private val api: DictionariApi,
    private val dao: WordInfoDao
): WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word = word).map {
            it.toWordInfo()
        }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfo = api.getWordInfo(word = word)
            dao.deleteWordInfos(remoteWordInfo.map { it.word })
            dao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })
        }
        catch (e: Exception) {
            emit(Resource.Error(message = e.message, data = wordInfos))
        }

        val newWordInfos = dao.getWordInfos(word = word).map {
            it.toWordInfo()
        }

        emit(Resource.Success(newWordInfos))
    }

}