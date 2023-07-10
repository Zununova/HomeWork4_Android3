package com.example.homework4_android3.ui.fragments.home.characters

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework4_android3.R
import com.example.homework4_android3.base.BaseFragment
import com.example.homework4_android3.data.models.QueryModel
import com.example.homework4_android3.databinding.FragmentCharacterBinding
import com.example.homework4_android3.ui.adapters.CharacterAdapter
import com.example.homework4_android3.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter(this::onCLick)
    private var model = QueryModel()

    private fun onCLick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDetailFragment(id)
        )
    }

    override fun initialize() = with(binding.characterRecyclerView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = characterAdapter
    }

    override fun setupListeners() = with(binding) {

        btnSearch.setOnClickListener {
            model = QueryModel(
                etName.text.toString(),
                etStatus.text.toString(),
                etSpecies.text.toString(),
                etGender.text.toString(),
                etType.text.toString()
            )
            fetchCharacters(model)
            btnShowLinerLayout.isVisible = true
            linerLayout.isGone = true
        }

        btnShowLinerLayout.setOnClickListener {
            linerLayout.isVisible = true
            btnShowLinerLayout.isGone = true
        }
    }

    override fun setupSubscribes() {
        fetchCharacters(model)
    }

    private fun fetchCharacters(model: QueryModel) {

        lifecycleScope.launch {
            viewModel.fetchCharacters(model).collect() {
                when (it) {
                    is Resource.Error -> Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Loading -> Toast.makeText(
                        requireContext(),
                        "Loading...",
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Success -> characterAdapter.submitList(it.data?.results)
                }
            }
        }
    }
}