package dev.munderstand.tp1_epsi_mspr_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import dev.munderstand.tp1_epsi_mspr_app.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AcceuilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AcceuilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_acceuil, container, false)

        val addressButton: Button = view.findViewById(R.id.addressButton)
        val emailButton: Button = view.findViewById(R.id.emailButton)
        val plant1Button: Button = view.findViewById(R.id.plant1Button)
        val plant2Button: Button = view.findViewById(R.id.plant2Button)

        addressButton.setOnClickListener {
            changeFragment(BotanistesFragment())
        }

        emailButton.setOnClickListener {
            changeFragment(RechercheBotanistFragment())
        }

        plant1Button.setOnClickListener {
            changeFragment(MapFragment())
        }

        plant2Button.setOnClickListener {
            changeFragment(AccountFragment())
        }


        val searchBar = view.findViewById<EditText>(R.id.searchBar)
        searchBar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val searchText = searchBar.text.toString()
                performSearch(searchText)
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        return view
    }



    fun performSearch(query: String) {
        // Implement your search logic here
        Toast.makeText(context, "Searching for: $query", Toast.LENGTH_SHORT).show()
    }

    private fun changeFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.content, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AcceuilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AcceuilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}