package com.example.code_hero.presentation.heroes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.code_hero.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_heroes.*

@AndroidEntryPoint
class HeroesActivity : AppCompatActivity() {

    private val viewModel : HeroesViewModel by viewModels()

    val adapter by lazy { HeroesAdapter(this) }

    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        recycler_heroes.adapter = adapter

        viewModel.characters.observe(this, Observer {
            adapter.updateList(it.data.results.toMutableList())
        })

        viewModel.getCharactersList()

    }

}
