package com.example.livedataprac.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataprac.Dao.AppDatabase
import com.example.livedataprac.R
import com.example.livedataprac.factory.MailViewModelFactory
import com.example.livedataprac.model.InputMsg
import com.example.livedataprac.repository.InputMsgRepository
import com.example.livedataprac.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeUi()
    }

    fun subscribeUi() {
        val dao = AppDatabase.getInstance(this).inputMsgDao()
        val repository = InputMsgRepository.getInstance(dao)
        val factory = MailViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)

        viewModel.inputMsgs.observe(this, Observer {
            if(it==null || it.isEmpty())
                return@Observer

            var sb = StringBuffer()
            for(data in it) {
                sb.append(data.msg).append("\n")
            }

            tv_result.text = sb.toString()
        })

        btn_input.setOnClickListener {
            var input = et_input.text.toString()
            if (input == null || input.isEmpty())
                return@setOnClickListener

            et_input.setText("")
            viewModel.insertMsg(InputMsg(msg = input))
        }
    }
}
