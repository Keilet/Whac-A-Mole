package com.whac_a_mole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.whac_a_mole.databinding.ActivityMainBinding
import com.whac_a_mole.menu.MenuFragment

class MainActivity : AppCompatActivity() {

    private var viewBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        this.viewBinding = viewBinding
        setContentView(viewBinding.root)
        supportFragmentManager
            .beginTransaction()
            .add(
                viewBinding.container.id,
                MenuFragment()
            )
            .commit()
    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}