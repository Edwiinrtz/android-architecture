package com.example.apparquitectura.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.R
import com.example.apparquitectura.model.Coupon

class MainActivity : AppCompatActivity(){

    //private var couponsPresenter: CouponsPresenter? = null
    private lateinit var rvCoupons: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //couponsPresenter = CouponsPresenterImpl(this)

        //view
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons.layoutManager = LinearLayoutManager(this)

    }

}