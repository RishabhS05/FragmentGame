package com.example.fragmentgame.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.fragmentgame.interfaces.DataCenter
import com.example.fragmentgame.R
import com.example.fragmentgame.fragments.AddFragment
import com.example.fragmentgame.fragments.SubtractFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DataCenter {

    private var addFragment: AddFragment? = null
    private var subFragment: SubtractFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        addFragment = AddFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_1, addFragment!!)
            .commit()


        subFragment = SubtractFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_2, subFragment!!)
            .commit()
    }

    override fun fragmentSubstractResponse(data: String) {
        addFragment!!.updateResult(data)
    }

    override fun fragmentAddResponse(data: String) {
        subFragment!!.updateResult(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logo -> {
                val intent = Intent(this, SearchableActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }


}
