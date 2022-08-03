package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon

interface CouponsPresenter {
    fun getCoupons() //interactor

    fun showCoupons(couponsList: ArrayList<Coupon>) //view
}