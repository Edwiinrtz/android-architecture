package com.example.apparquitectura.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.apparquitectura.model.Coupon

interface CouponsRepository {
    fun getCoupons():MutableLiveData<List<Coupon>>
    fun callCouponsAPI()
}