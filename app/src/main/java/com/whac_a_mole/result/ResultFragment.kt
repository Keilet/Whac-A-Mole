package com.whac_a_mole.result

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.whac_a_mole._base.ViewBindingFragment
import com.whac_a_mole.databinding.FragmentResultBinding


class ResultFragment(val score:Int): ViewBindingFragment<FragmentResultBinding>(
    FragmentResultBinding::inflate
) {
    override fun onViewBindingCreated(
        viewBinding: FragmentResultBinding,
        savedInstanceState: Bundle?
    ) {
        super.onViewBindingCreated(viewBinding, savedInstanceState)

        val settings: SharedPreferences = requireActivity().getSharedPreferences("Account",
            AppCompatActivity.MODE_PRIVATE)
        val bestScore: Int = settings.getInt("score", 0)
        viewBinding.bestScoreResult.text=bestScore.toString()
        viewBinding.scoreResult.text=score.toString()

        if (bestScore!=score) viewBinding.newRecord.visibility= View.GONE

    }
}