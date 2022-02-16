package com.whac_a_mole.game

import android.os.Bundle
import android.os.CountDownTimer
import com.whac_a_mole.R
import com.whac_a_mole._base.ViewBindingFragment
import com.whac_a_mole.databinding.FragmentGameBinding
import com.whac_a_mole.result.ResultFragment

class GameFragment : ViewBindingFragment<FragmentGameBinding>(
    FragmentGameBinding::inflate
) {

    override fun onViewBindingCreated(
        viewBinding: FragmentGameBinding,
        savedInstanceState: Bundle?
    ) {
        super.onViewBindingCreated(viewBinding, savedInstanceState)

        object : CountDownTimer(31000, 1000) {
            override fun onTick(timeS: Long) {
                viewBinding.timer.text = "${timeS / 1000}"
                if (timeS / 1000 < 11) viewBinding.timer.setTextColor(
                    resources.getColor(
                        R.color.red,
                        null
                    )
                )
            }

            override fun onFinish() {
                parentFragmentManager.beginTransaction().replace(R.id.container, ResultFragment())
                    .commit()
            }

        }.start()
    }
}