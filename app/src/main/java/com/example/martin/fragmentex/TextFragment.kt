package com.example.martin.fragmentex

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.text_fragment.*

class TextFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.text_fragment,
            container, false)
    }
    fun changeText(fontsize: Int, text: String)
    {
        textView.textSize = fontsize.toFloat()
        textView.text = text
    }
}