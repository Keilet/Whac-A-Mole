package com.whac_a_mole.menu

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        val settings: SharedPreferences = requireActivity().getSharedPreferences("Account",
            AppCompatActivity.MODE_PRIVATE)
        val bestScore: Int = settings.getInt("score", 0)
        viewBinding.bestScoreMenu.text=bestScore.toString()

        viewBinding.startButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, GameFragment())
                .addToBackStack("one").commit()
        }
    }
}