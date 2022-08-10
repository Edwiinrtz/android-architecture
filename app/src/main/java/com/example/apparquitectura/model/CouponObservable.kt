package com.example.apparquitectura.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.apparquitectura.model.repository.CouponsRepository
import com.example.apparquitectura.model.repository.CouponsRepositoryImpl

class CouponObservable: BaseObservable(){

    //repository
    private var couponsRepository: CouponsRepository = CouponsRepositoryImpl()
    fun callCoupons(){
        couponsRepository.callCouponsAPI()
    }

    fun getCoupons():MutableLiveData<List<Coupon>>{
        return couponsRepository.getCoupons()
    }
    //viewModel

}