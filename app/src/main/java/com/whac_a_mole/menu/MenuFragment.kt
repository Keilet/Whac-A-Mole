package com.whac_a_mole.menu

import android.os.Bundle
import com.whac_a_mole._base.ViewBindingFragment
import com.whac_a_mole.databinding.FragmentMenuBinding

class MenuFragment : ViewBindingFragment<FragmentMenuBinding>(
    FragmentMenuBinding::inflate
) {
    override fun onViewBindingCreated(
        viewBinding: FragmentMenuBinding,
        savedInstanceState: Bundle?
    ) {
        super.onViewBindingCreated(viewBinding, savedInstanceState)

    }
}