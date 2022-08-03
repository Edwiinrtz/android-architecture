package com.example.apparquitectura.view

import com.example.apparquitectura.model.Coupon

interface CouponsView {
    fun getCoupons()
    fun showCoupons(couponsList: ArrayList<Coupon>)
}