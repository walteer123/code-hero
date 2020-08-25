package com.example.code_hero.presentation.heroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.code_hero.R
import kotlinx.android.synthetic.main.activity_heroes.*

class HeroesActivity : AppCompatActivity() {

    private lateinit var viewModel : HeroesViewModel

    val adapter by lazy {
        HeroesAdapter(this)
    }

    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        viewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        recycler_heroes.adapter = adapter

        viewModel.heroes.observe(this, Observer {
            adapter.updateList(it.data.results.toMutableList())
        })

    }

}
