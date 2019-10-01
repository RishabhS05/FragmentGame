package com.example.fragmentgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentgame.interfaces.DataCenter
import com.example.fragmentgame.R
import kotlinx.android.synthetic.main.add_frag.view.*

public class AddFragment : Fragment() {
    lateinit var dataCenter: DataCenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.add_frag, container, false)

        dataCenter = activity as DataCenter
        view.bt_add.setOnClickListener {
            val value = view.tv_result.text.toString().toInt() + 1
            updateResult(value.toString())
            dataCenter.fragmentAddResponse(value.toString())
        }
        return view
    }
    fun updateResult(data : String){
        view!!.tv_result.text = data
    }

}