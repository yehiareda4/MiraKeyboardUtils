//package com.yehia.mira_keyboard_utils.adapter
//
//import DataSourceData
//import android.annotation.SuppressLint
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import com.yehia.mira_keyboard_utils.databinding.ItemSpinnerBinding
//
//class SpinnerAdapter() : BaseAdapter() {
//
//    lateinit var layoutInflater: LayoutInflater
//    lateinit var context: Context;
//    lateinit var dataList: List<DataSourceData>
//
//    constructor(context: Context) : this() {
//        this.context = context
//        this.dataList = dataList
//        layoutInflater = LayoutInflater.from(context)
//    }
//
//    fun setData(dataList: List<DataSourceData>?, hint: String) {
//        this.dataList = ArrayList()
//        this.dataList.map { DataSourceData(0, 0, hint, hint, 0.0, 0.0, "", "", null) }
//        if (dataList != null) {
//            this.dataList.flatMap { dataList }
//        }
//    }
//
//    override fun getCount(): Int {
//        return dataList.size
//    }
//
//    override fun getItem(position: Int): Any? {
//        return null
//    }
//
//    override fun getItemId(position: Int): Long {
//        return 0
//    }
//
//    @SuppressLint("ViewHolder")
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val binding = ItemSpinnerBinding.inflate(layoutInflater, parent, false)
//
//        binding.itemSpinnerTvTitle.text = dataList.get(position).name_en
//
//        return binding.root
//    }
//}