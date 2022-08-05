package com.example.apparquitectura.model.repository

import android.util.Log
import com.example.apparquitectura.model.ApiAdarter
import com.example.apparquitectura.model.Coupon
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponsRepositoryImpl() : CouponsRepository {

    private var coupons = ArrayList<Coupon>()
    override fun getCouponsAPI() {
        //controller
        val apiAdapter = ApiAdarter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    if (coupon.image_url.isNotEmpty()) {
                        coupons.add(coupon)
                    }
                }
                //couponsPresenter.showCoupons(coupons)

                //
            }
        })

    }

}