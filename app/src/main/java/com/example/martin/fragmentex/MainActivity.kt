package com.example.martin.fragmentex

import android.os.Bundle
import android.support.v4.app.FragmentActivity

class MainActivity : FragmentActivity(), ToolbarFragment.ToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onButtonClick(fontsize: Int, text: String) {
        val textFragment = supportFragmentManager.findFragmentById(R.id.fragment2) as TextFragment
        textFragment.changeText(fontsize, text)
    }
}
