package ru.super135.gitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import ru.super135.gitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter: UsersAdapter = UsersAdapter()
    private val usersRepo: UsersRepo = FakeUsersRepoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showProgress(false)

        binding.refreshButton.setOnClickListener {
            showProgress(true)
            usersRepo.getUsers(
                onSuccess = {
                    showProgress(false)
                    adapter.setDate(it)
                },
                onError = {
                    showProgress(false)
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            )
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter
    }

    private fun showProgress(inProgress: Boolean) {
        binding.progressBar.isVisible = inProgress
        binding.usersRecyclerView.isVisible = !inProgress
    }
}