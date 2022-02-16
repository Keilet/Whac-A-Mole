package com.whac_a_mole.game

import android.os.Bundle
import com.whac_a_mole._base.ViewBindingFragment
import com.whac_a_mole.databinding.FragmentGameBinding

class GameFragment : ViewBindingFragment<FragmentGameBinding>(
    FragmentGameBinding::inflate
) {

    override fun onViewBindingCreated(
        viewBinding: FragmentGameBinding,
        savedInstanceState: Bundle?
    ) {
        super.onViewBindingCreated(viewBinding, savedInstanceState)

    }
}