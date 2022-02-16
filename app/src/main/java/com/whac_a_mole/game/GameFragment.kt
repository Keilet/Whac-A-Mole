package com.whac_a_mole.game

import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity
import com.whac_a_mole.R
import com.whac_a_mole._base.ViewBindingFragment
import com.whac_a_mole.databinding.FragmentGameBinding
import com.whac_a_mole.result.ResultFragment
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class GameFragment : ViewBindingFragment<FragmentGameBinding>(
    FragmentGameBinding::inflate
) {

    lateinit var tableLayout: TableLayout
    var images: ArrayList<ImageView> = arrayListOf()

    override fun onViewBindingCreated(
        viewBinding: FragmentGameBinding,
        savedInstanceState: Bundle?
    ) {
        super.onViewBindingCreated(viewBinding, savedInstanceState)

        val settings: SharedPreferences = requireActivity().getSharedPreferences("Account",
            AppCompatActivity.MODE_PRIVATE)
        val scoreSP: SharedPreferences.Editor=settings.edit()

        var newScore = 0
        val FIELD_ROWS = 3
        val FIELD_COLUMNS = 3

        tableLayout = viewBinding.tableLayout

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
                val bestScore: Int = settings.getInt("score", 0)
                if (bestScore<newScore)scoreSP.putInt("score",newScore).apply()
                parentFragmentManager.beginTransaction().replace(R.id.container, ResultFragment(newScore))
                    .commit()
            }

        }.start()

        for (i in 0 until FIELD_ROWS) {
            val tableRow = TableRow(context)
            tableRow.setLayoutParams(
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                )
            )
            for (j in 0 until FIELD_COLUMNS) {
                val imageView = ImageView(context)
                images.add(imageView)
                imageView.setImageResource(R.drawable.ic_hole)
                tableRow.addView(imageView, j)

            }
            tableLayout.addView(tableRow, i)
        }

        Timer().schedule(100, 500) {
            moveMole()
        }

        images.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val imageViewDrawable = imageView.getDrawable().constantState

                val fromResourcesDrawable = getResources().getDrawable(R.drawable.ic_mole,null).constantState

                if (imageViewDrawable!! == fromResourcesDrawable){
                    newScore++
                    imageView.setImageResource(
                        R.drawable.ic_dead_mole
                    )
                    viewBinding.score.text = newScore.toString()
                }
            }
        }
    }

    fun moveMole(){
        images.forEach { i -> i.setImageResource(R.drawable.ic_hole) }
        val rnd = (0..8).random()
        images.forEachIndexed { index, imageView ->
            if (index == rnd) imageView.setImageResource(
                R.drawable.ic_mole
            )
        }
    }
}