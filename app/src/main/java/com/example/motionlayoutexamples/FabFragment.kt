package com.example.motionlayoutexamples

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fab.*

/**
 * A simple [Fragment] subclass.
 * Use the [FabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FabFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        menuFab.setOnClickListener {
            //            motionLayout.progress = 100f
            Log.d("FabFragment", "Tap")
        }

    }
}