package com.example.martin.fragmentex

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.toolbar_fragment.*

class ToolbarFragment: Fragment(), SeekBar.OnSeekBarChangeListener {
    var seekvalue =12
    var activityCallback: ToolbarFragment.ToolbarListener? = null
    interface ToolbarListener {
        fun onButtonClick(position: Int, text: String)
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString()
                    + " must implement ToolbarListener")
        }
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.toolbar_fragment,
            container, false)
        val seekBar: SeekBar? = view?.findViewById(R.id.seekBar)
        val button: Button? = view?.findViewById(R.id.but)

        seekBar?.setOnSeekBarChangeListener(this)
        button?.setOnClickListener { v: View -> buttonClicked(v)}
        return view
    }
    private fun buttonClicked(view: View) {
        activityCallback?.onButtonClick(seekvalue,
            editText.text.toString())
    }
    override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                   fromUser: Boolean) {
        seekvalue = progress
    }
    override fun onStartTrackingTouch(arg0: SeekBar) {
    }
    override fun onStopTrackingTouch(arg0: SeekBar) {
    }
}