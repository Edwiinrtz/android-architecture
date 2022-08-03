package com.example.apparquitectura.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.R
import com.example.apparquitectura.model.ApiAdarter
import com.example.apparquitectura.presenter.CouponsPresenter
import com.example.apparquitectura.presenter.CouponsPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity(), CouponsView{

    private var couponsPresenter: CouponsPresenter? = null
    private lateinit var rvCoupons: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponsPresenter = CouponsPresenterImpl(this)

        //view
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons.layoutManager = LinearLayoutManager(this)

        getCoupons()


    }

    override fun getCoupons() {
        try {
            couponsPresenter!!.getCoupons()
        }catch (e: Exception){
            print(e)
        }

    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
    }

}