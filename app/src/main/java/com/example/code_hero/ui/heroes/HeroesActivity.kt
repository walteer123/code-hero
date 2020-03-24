package com.example.code_hero.ui.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.code_hero.R
import com.example.code_hero.model.Connection
import com.example.code_hero.model.data.Character
import com.example.code_hero.model.data.CharacterDataWrapper
import com.example.code_hero.ui.recyclerview.adapter.HeroesAdapter
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

        viewModel.getHeroes().observe(this, Observer {
            handleData(it)
        })

    }

    private fun handleData(result: CharacterDataWrapper?) {
        if (result?.code ==  200) {
            val data = result.data
            adapter.updateList(data.results.toMutableList())
        }
    }
}
