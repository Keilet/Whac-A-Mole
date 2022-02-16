package com.whac_a_mole.result

import android.os.Bundle
import com.whac_a_mole._base.ViewBindingFragment
import com.whac_a_mole.databinding.FragmentResultBinding

class ResultFragment : ViewBindingFragment<FragmentResultBinding>(
    FragmentResultBinding::inflate
) {
    override fun onViewBindingCreated(
        viewBinding: FragmentResultBinding,
        savedInstanceState: Bundle?
    ) {
        super.onViewBindingCreated(viewBinding, savedInstanceState)
    }
}