package com.jhonjto.thecatapi.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhonjto.thecatapi.databinding.ActivityMainBinding
import com.jhonjto.thecatapi.ui.MainViewModel.UiModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CatListAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this)
        binding.recycler.layoutManager = manager
        binding.recycler.setHasFixedSize(true)
        adapter = CatListAdapter()
        binding.recycler.adapter = adapter
        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: UiModel) {
        binding.progress.visibility = if (model is UiModel.Loading) View.VISIBLE else View.GONE

        when(model) {
            is UiModel.Content -> adapter.cats = model.cats
            else -> {}
        }
    }
}