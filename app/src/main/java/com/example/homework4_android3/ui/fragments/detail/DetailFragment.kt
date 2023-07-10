package com.example.homework4_android3.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.homework4_android3.R
import com.example.homework4_android3.base.BaseFragment
import com.example.homework4_android3.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail) {

    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: DetailViewModel by viewModels()


    override fun setupSubscribes() {
        val args by navArgs<DetailFragmentArgs>()
        lifecycleScope.launch {
            viewModel.fetchCharacterById(args.id).collect {
                Glide.with(binding.ivHeroImage).load(it.data?.image).into(binding.ivHeroImage)
                binding.tvCharacterName.text = it.data?.name
                binding.tvSpecies.text = it.data?.species
                binding.tvStatus.text = it.data?.status
                binding.tvLocationName.text = it.data?.location?.name
                binding.tvType.text = it.data?.type
                binding.tvGender.text = it.data?.gender
            }
        }
    }
}