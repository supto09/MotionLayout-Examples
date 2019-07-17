package com.example.motionlayoutexamples


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_parallax.*

/**
 * A simple [Fragment] subclass.
 */
class ParallaxFragment : Fragment() {

    private lateinit var adapter: MyRcAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parallax, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val languageList = listOf(
            "Godzilla: King of the Monsters",
            "Toy Story 4",
            "Captain Marvel",
            "Aladdin",
            "John Wick: Chapter 3 – Parabellum",
            "Shazam!",
            "Annabelle Comes Home",
            "Crawl",
            "Pet Sematary",
            "Hellboy",
            "Alita: Battle Angel",
            "Ad Astra",
            "Joker",
            "Avengers: Endgame"
        )

        adapter = MyRcAdapter(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        adapter.submitList(languageList)
    }

}
