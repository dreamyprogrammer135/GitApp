package ru.super135.gitapp.ui.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import ru.super135.gitapp.app
import ru.super135.gitapp.domain.UserEntity
import ru.super135.gitapp.domain.UsersRepo
import ru.super135.gitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UsersContract.View {
    private lateinit var binding: ActivityMainBinding
    private val adapter: UsersAdapter = UsersAdapter()
//    private val usersRepo: UsersRepo by lazy { app.usersRepo }

    private lateinit var presenter: UsersContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        presenter = UsersPresenter(app.usersRepo)
        presenter.attach(this)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    private fun initView() {
        binding.refreshButton.setOnClickListener {
            presenter.onRefresh()
        }
        initRecyclerView()
        showProgress(false)
    }



    override fun showUsers(users: List<UserEntity>) {
        adapter.setDate(users)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress(inProgress: Boolean) {
        binding.progressBar.isVisible = inProgress
        binding.usersRecyclerView.isVisible = !inProgress
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter
    }

}