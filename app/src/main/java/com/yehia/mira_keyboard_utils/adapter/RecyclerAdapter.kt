//package com.yehia.mira_keyboard_utils.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.yehia.mira_keyboard_utils.databinding.ItemSpinnerBinding
//
//class RecyclerAdapter(private val context: Context, private val dataList: ArrayList<String>) :
//    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//
//
//        val binding = ItemSpinnerBinding.inflate(layoutInflater, parent, false)
//
//        return ViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//    }
//
//    class ViewHolder(val binding: ItemSpinnerBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(orderViewModel: ItemSpinnerBinding) {
//            binding.executePendingBindings()
//        }
//
//    }
//}
