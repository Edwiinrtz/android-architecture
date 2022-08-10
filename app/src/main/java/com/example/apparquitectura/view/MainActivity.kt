package com.example.apparquitectura.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.R
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.viewmodel.CouponsViewModel
import com.example.apparquitectura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private var couponViewModel: CouponsViewModel? = null
    //private var couponsPresenter: CouponsPresenter? = null
    //private lateinit var rvCoupons: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //couponsPresenter = CouponsPresenterImpl(this)

        //view
        //rvCoupons = findViewById(R.id.rvCoupons)
        //rvCoupons.layoutManager = LinearLayoutManager(this)

        setupBinding(savedInstanceState)

    }

    private fun setupBinding(savedInstanceState: Bundle?){
        val activityMainBinding: ActivityMainBinding
        = DataBindingUtil.setContentView(this,R.layout.activity_main)

        couponViewModel = ViewModelProvider.NewInstanceFactory().create(CouponsViewModel::class.java)
        activityMainBinding.viewmodel =couponViewModel
        setListUpdate()
    }

    private fun setListUpdate(){
        //call coupons
        couponViewModel?.callCoupons()
        //getCoupons
        couponViewModel?.getCoupons()?.observe(this, Observer { coupons: List<Coupon> ->
            //Log.w("COUPON", coupons[0].title)
            couponViewModel?.setCouponsInRecyclerAdaptar(coupons)

        })
    }

}