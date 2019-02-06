package com.tarasmorskyi.uicore.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RadioButton
import android.widget.TableLayout
import android.widget.TableRow


class ToggleButtonGroupTableLayout : TableLayout, View.OnClickListener {

    private var activeRadioButton: RadioButton? = null
    private var radioButtonChecked: RadioButtonChecked? = null

    constructor(context: Context) : super(context) {
        // TODO Auto-generated constructor stub
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        // TODO Auto-generated constructor stub
    }

    override fun onClick(v: View) {
        val rb = v as RadioButton
        if (activeRadioButton != null) {
            activeRadioButton!!.isChecked = false
        }
        rb.isChecked = true
        activeRadioButton = rb
        radioButtonChecked?.onRadioButtonChecked(v)
    }

    fun onRadioButtonChecked(radioButtonChecked: RadioButtonChecked) {
        this.radioButtonChecked = radioButtonChecked
    }

    override fun addView(
        child: View, index: Int,
        params: android.view.ViewGroup.LayoutParams
    ) {
        super.addView(child, index, params)
        setChildrenOnClickListener(child as TableRow)
    }

    override fun addView(child: View, params: android.view.ViewGroup.LayoutParams) {
        super.addView(child, params)
        setChildrenOnClickListener(child as TableRow)
    }

    private fun setChildrenOnClickListener(tr: TableRow) {
        val c = tr.childCount
        for (i in 0 until c) {
            val v = tr.getChildAt(i)
            if (v is RadioButton) {
                v.setOnClickListener(this)
            }
        }
    }

    interface RadioButtonChecked {
        fun onRadioButtonChecked(view: View)
    }

    companion object {

        private const val TAG = "ToggleButtonGroupTableLayout"
    }
}