package com.example.myapplication.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAllDishesBinding
import com.example.myapplication.view.activity.AddUpdateDishActivity
import com.example.myapplication.viewmodel.HomeViewModel
import android.annotation.SuppressLint
import android.util.Log

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MyApplication
import com.example.myapplication.view.PersonAdapter
import com.example.myapplication.viewmodel.PersonViewModalFactory
import com.example.myapplication.viewmodel.PersonViewModel

class AllDishesFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: PersonAdapter

    private var _binding: FragmentAllDishesBinding? = null

    private val mPersonViewModal: PersonViewModel by viewModels {
        PersonViewModalFactory((requireActivity().application as MyApplication).reposatory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentAllDishesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        adapter = PersonAdapter(this@AllDishesFragment)

        binding.recyclerViewPerson.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerViewPerson.adapter = adapter;

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPersonViewModal.allPersons.observe(viewLifecycleOwner) { persons ->
            persons.let {
                adapter.personList(persons)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_dishes, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_dish -> {
                startActivity(Intent(requireActivity(), AddUpdateDishActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}