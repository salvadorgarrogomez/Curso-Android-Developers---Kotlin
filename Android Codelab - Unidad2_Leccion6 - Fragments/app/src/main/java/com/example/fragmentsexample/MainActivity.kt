package com.example.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragmentsexample.FirstFragment.Companion.ADDRESS_BUNDLE
import com.example.fragmentsexample.FirstFragment.Companion.NAME_BUNDLE

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            val bundle = bundleOf(NAME_BUNDLE to "Salva",
                ADDRESS_BUNDLE to "Direccion")

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragmentContainer, args = bundle)
            }
        }
    }
}