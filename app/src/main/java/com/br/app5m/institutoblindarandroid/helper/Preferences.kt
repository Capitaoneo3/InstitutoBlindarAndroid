package com.br.app5m.institutoblindarandroid.helper

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Preferences(context: Context?) /*{

    *//**
     * Preferences
     *
     * @author Android version: Wesley Costa
     * @since Version 1.0.3
     * @Created  06/2020 - 02/2021
     *//*

    private var preferences = context?.getSharedPreferences("high.preference", 0)
    private var editor = preferences?.edit()

    fun setUserData(user: User?) {
        val data = Gson().toJson(user)
        editor!!.putString("getUserData", data)
        editor!!.commit()
    }
    fun setPropostacomercialData(propostacomercial: Propostacomercial?) {
        val data = Gson().toJson(propostacomercial)
        editor!!.putString("getPropostacomercialData", data)
        editor!!.commit()
    }
    fun setListItemCartData(list: List<ItemCart?>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        set("arrayItemCart", json)
    }
    fun getListItemCartData(): List<ItemCart?>? {
        var arrayItems: List<ItemCart?>? = null
        val serializedObject = preferences!!.getString("arrayItemCart", "")
        if (serializedObject != null) {
            val gson = Gson()
            val type = object : TypeToken<List<ItemCart?>?>() {}.type
            arrayItems = gson.fromJson<List<ItemCart?>>(serializedObject, type)
        }
        return arrayItems
    }
    fun clearListItemCartData() {
        editor?.remove("arrayItemCart")
        editor!!.commit()
    }
  *//*  fun setItemCartData(itemCartArray: ItemCartArray?) {
        val data = Gson().toJson(itemCartArray)
        editor!!.putString("ItemCartData", data)
        editor!!.commit()
    }*//*

    fun setRequirimentsDetailData(requirimentsDetail: RequirimentsDetail?) {
        val data = Gson().toJson(requirimentsDetail)
        editor!!.putString("RequirimentsDetailData", data)
        editor!!.commit()
    }
    fun setProposalDetailData(proposalDetail: ProposalDetail?) {
        val data = Gson().toJson(proposalDetail)
        editor!!.putString("ProposalDetailData", data)
        editor!!.commit()
    }
    fun setProposalListAllData(proposalListAll: ProposalListAll?) {
        val data = Gson().toJson(proposalListAll)
        editor!!.putString("ProposalListAll", data)
        editor!!.commit()
    }

    fun setRequirimentsListAllData(requirimentsListAll: RequirimentsListAll?) {
        val data = Gson().toJson(requirimentsListAll)
        editor!!.putString("RequirimentsListAllData", data)
        editor!!.commit()
    }
    fun setBillssListAllData(contasReceberAll: ContasReceberAll?) {
        val data = Gson().toJson(contasReceberAll)
        editor!!.putString("ContasReceberAllListAllData", data)
        editor!!.commit()
    }

    fun setProductListAllData(productListAll: ProductListAll?) {
        val data = Gson().toJson(productListAll)
        editor!!.putString("ProductPostData", data)
        editor!!.commit()
    }
    fun setProductDetailData(productDetail: ProductDetail?) {
        val data = Gson().toJson(productDetail)
        editor!!.putString("ProductDetailData", data)
        editor!!.commit()
    }
    fun setCategoryData(category: Category?) {
        val data = Gson().toJson(category)
        editor!!.putString("CategoryData", data)
        editor!!.commit()
    }

    operator fun set(key: String?, value: String?) {
        editor!!.putString(key, value)
        editor!!.commit()
    }
   *//* fun getItemCartData(): ItemCartArray? {
        val product: ItemCartArray
        val gson = Gson()
        val data = preferences!!.getString("ItemCartData", "")
        return if (data != null && data.isNotEmpty()) {
            product = gson.fromJson(data, ItemCartArray::class.java)
            product
        } else null
    }*//*

    fun getContasReceberAll(): ContasReceberAll? {
        val product: ContasReceberAll
        val gson = Gson()
        val data = preferences!!.getString("ProductDetailData", "")
        return if (data != null && data.isNotEmpty()) {
            product = gson.fromJson(data, ContasReceberAll::class.java)
            product
        } else null
    }
    fun getProposalListAllData(): ProposalListAll? {
        val product: ProposalListAll
        val gson = Gson()
        val data = preferences!!.getString("ProposalListAllData", "")
        return if (data != null && data.isNotEmpty()) {
            product = gson.fromJson(data, ProposalListAll::class.java)
            product
        } else null
    }
   fun getProposalDetailData(): ProposalDetail? {
       val product: ProposalDetail
       val gson = Gson()
       val data = preferences!!.getString("ProposalDetailData", "")
       return if (data != null && data.isNotEmpty()) {
           product = gson.fromJson(data, ProposalDetail::class.java)
           product
       } else null
   }
   fun getPropostacomercialData(): Propostacomercial? {
       val product: Propostacomercial
       val gson = Gson()
       val data = preferences!!.getString("getPropostacomercialData", "")
       return if (data != null && data.isNotEmpty()) {
           product = gson.fromJson(data, Propostacomercial::class.java)
           product
       } else null
   }
    fun getRequirimentsDetailData(): RequirimentsDetail? {
        val product: RequirimentsDetail
        val gson = Gson()
        val data = preferences!!.getString("RequirimentsDetailData", "")
        return if (data != null && data.isNotEmpty()) {
            product = gson.fromJson(data, RequirimentsDetail::class.java)
            product
        } else null
    }
    fun getRequirimentsListAllData(): RequirimentsListAll? {
        val product: RequirimentsListAll
        val gson = Gson()
        val data = preferences!!.getString("RequirimentsListAllData", "")
        return if (data != null && data.isNotEmpty()) {
            product = gson.fromJson(data, RequirimentsListAll::class.java)
            product
        } else null
    }

    fun getProductDetailData(): ProductDetail? {
        val product: ProductDetail
        val gson = Gson()
        val data = preferences!!.getString("ProductDetailData", "")
        return if (data != null && data.isNotEmpty()) {
            product = gson.fromJson(data, ProductDetail::class.java)
            product
        } else null
    }
    fun getProductListAllData(): ProductListAll? {
        val product: ProductListAll
        val gson = Gson()
        val data = preferences!!.getString("ProductPostData", "")
        return if (data != null && data.isNotEmpty()) {
            product = gson.fromJson(data, ProductListAll::class.java)
            product
        } else null
    }

    fun getUserData(): User? {
        val user: User
        val gson = Gson()
        val data = preferences!!.getString("getUserData", "")
        return if (data != null && data.isNotEmpty()) {
            user = gson.fromJson(data, User::class.java)
            user
        } else null
    }
    fun getCategoryData(): Category? {
        val category: Category
        val gson = Gson()
        val data = preferences!!.getString("CategoryData", "")
        return if (data != null && data.isNotEmpty()) {
            category = gson.fromJson(data, Category::class.java)
            category
        } else null
    }


    fun setLogin(enable: Boolean){
        editor!!.putBoolean("login", enable)
        editor!!.commit()
    }


    fun getLogin(): Boolean{
        return preferences?.getBoolean("login", false)!!
    }
  *//*  fun clearItemCartData(){
        editor!!.remove("ItemCartData")
        editor!!.commit()
    }
*//*

    fun clearProposalListAllData(){
        editor!!.remove("ProposalListAllData")
        editor!!.commit()
    }

    fun clearRequirimentsDetailData(){
        editor!!.remove("RequirimentsDetailData")
        editor!!.commit()
    }
    fun clearReceberAllListAllData(){
        editor!!.remove("ContasReceberAllList")
        editor!!.commit()
    }
    fun clearRequirimentsListAllData(){
        editor!!.remove("RequirimentsListAllData")
        editor!!.commit()
    }
    fun clearProposalDetailData(){
        editor!!.remove("ProposalDetailData")
        editor!!.commit()
    }
    fun clearProductDetailData(){
        editor!!.remove("ProductDetailData")
        editor!!.commit()
    }

    fun clearProductListAllData(){
        editor!!.remove("ProductPostData")
        editor!!.commit()
    }
    fun clearPropostacomercialData(){
        editor!!.remove("getPropostacomercialData")
        editor!!.commit()
    }

    fun clearUserData(){
        editor!!.remove("getUserData")
        editor!!.remove("login")

        editor!!.commit()
    }
    fun clearCategoryData(){
        editor!!.remove("CategoryData")
        editor!!.commit()
    }



    fun firstUser(): String? {
        return preferences!!.getString("user", "0")
    }









}*/