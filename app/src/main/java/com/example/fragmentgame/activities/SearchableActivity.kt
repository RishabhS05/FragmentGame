package com.example.fragmentgame.activities

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragmentgame.R
import com.example.fragmentgame.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_search.*


class SearchableActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var heros: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        heros = dummmyData()
        handleIntent(intent)
        //onSearchRequested()

    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                doMySearch(query)
            }
        }
    }

    private fun doMySearch(query: String) {
        getSelectedHeroes(query)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu!!.findItem(R.id.search)
        var searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Search Names"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                rv_main.layoutManager = GridLayoutManager(applicationContext, 1)
                myAdapter = MyAdapter(getSelectedHeroes(newText), applicationContext)
                rv_main.adapter = myAdapter
                (rv_main.adapter as MyAdapter).notifyDataSetChanged()
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    fun dummmyData(): List<String> {
        val allHeros = listOf("Thor", "Cap", "IronMan", "Hulk", "Vision", "Hockeye", "Black Widow")
        return allHeros
    }


    fun getSelectedHeroes(query: String): List<String>? {
        if (!TextUtils.isEmpty(query)) {
            return heros.filter { string -> string.contains(query) }
        }
        (rv_main.adapter as MyAdapter).notifyDataSetChanged()
        return null
    }
}
