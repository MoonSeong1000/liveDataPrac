package com.example.livedataprac.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.livedataprac.repository.InputMsgRepository
import com.example.livedataprac.viewModel.MainViewModel

class MailViewModelFactory(private val inputMsgRepository: InputMsgRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(inputMsgRepository) as T
    }

}