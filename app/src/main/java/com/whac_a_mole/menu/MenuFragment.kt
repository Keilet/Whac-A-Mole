package com.whac_a_mole.menu

import android.os.Bundle
import com.whac_a_mole.R
import com.whac_a_mole._base.ViewBindingFragment
import com.whac_a_mole.databinding.FragmentMenuBinding
import com.whac_a_mole.game.GameFragment

class MenuFragment : ViewBindingFragment<FragmentMenuBinding>(
    FragmentMenuBinding::inflate
) {
    override fun onViewBindingCreated(
        viewBinding: FragmentMenuBinding,
        savedInstanceState: Bundle?
    ) {
        super.onViewBindingCreated(viewBinding, savedInstanceState)

        viewBinding.startButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, GameFragment())
                .addToBackStack("one").commit()
        }
    }
}