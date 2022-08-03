package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.model.interactor.CouponsInteractorImpl
import com.example.apparquitectura.view.CouponsView

class CouponsPresenterImpl(var couponsView: CouponsView): CouponsPresenter {

    private val couponsInteractor=CouponsInteractorImpl(this)

    override fun getCoupons() {
        couponsInteractor.getCouponsAPI()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        couponsView.showCoupons(coupons)
    }

}