package br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.R
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.databinding.ActivityMainBinding
import br.com.mizaeldouglas.app_dummy_json_mvvm_hilt.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //    private val usersViewModel: UsersViewModel by viewModels()
    private val usersViewModel by viewModels<UsersViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        usersViewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        usersViewModel.user.observe(this) { listUser ->
            var listResult = ""
            listUser.forEach { user ->
                listResult += "Nome: ${user.firstName} ${user.lastName} \nIdade: ${user.age} \nEmail: ${user.email} \nTelefone: ${user.phone} \n--------------------------------------------------------------------------\n"
            }
            binding.txtResult.text = listResult
        }


    }
}