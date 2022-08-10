package com.example.apparquitectura.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.BR
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.R
import com.example.apparquitectura.viewmodel.CouponsViewModel
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter(var couponsViewModel: CouponsViewModel, var resource: Int) : RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>()  {

    private var coupons : List<Coupon>? = null
    fun setCouponsList(coupons: List<Coupon>){

        this.coupons = coupons
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        var binding:  ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardCouponHolder(binding)
    }


    override fun getItemCount(): Int{
        return coupons?.size ?:0
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        p0.setDataCard(couponsViewModel,p1)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int):Int{
        return resource
    }
    class CardCouponHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

        private var binding: ViewDataBinding? = null
        init {
            this.binding = binding
        }

        fun setDataCard(couponsViewModel: CouponsViewModel,position: Int){

            binding?.setVariable(BR.viewmodel, couponsViewModel)
            binding?.setVariable(BR.position, position)
            binding?.setVariable(BR.imgCoupon, "http://cdn.meme.am/instances/60677654.jpg")
            /*var logoImage: ImageView? = null;
            couponsViewModel.getCouponAt(position)?.let {
                if (!it.image_url.isNullOrEmpty())
                    Picasso.get().load(it.image_url).resize(520, 520).centerCrop().into(logoImage)

            }*/



            binding?.executePendingBindings()

        }

    }

}