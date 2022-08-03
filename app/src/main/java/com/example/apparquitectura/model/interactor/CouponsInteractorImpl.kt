package com.example.apparquitectura.model.interactor

import com.example.apparquitectura.model.repository.CouponsRepositoryImpl
import com.example.apparquitectura.presenter.CouponsPresenter

class CouponsInteractorImpl(var couponsPresenter: CouponsPresenter): CouponsInteractor{

    private var couponsRepository = CouponsRepositoryImpl(couponsPresenter)

    override fun getCouponsAPI() {
        couponsRepository.getCouponsAPI()
    }
}