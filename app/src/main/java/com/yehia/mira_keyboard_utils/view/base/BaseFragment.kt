package com.yehia.mira_keyboard_utils.view.base

import android.app.Dialog
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import com.yehia.mira_keyboard_utils.data.network.login_models.DataSource
import kotlinx.coroutines.Deferred

open class BaseFragment : Fragment() {

    lateinit var baseActivity: BaseActivity
    protected lateinit var dialog: Dialog

    open fun setUp() {
        baseActivity = activity as BaseActivity;
        baseActivity.baseFragment = this
    }

    open fun setOnClick(view: View) {
        view.setOnClickListener { onViewClicked(view) }
    }

    open fun onViewClicked(view: View) {
//        HelperMethod.hiddenKeyBord(view, requireActivity())
    }

    open fun onBack() {
        baseActivity.superBackPressed()
    }


    fun getLang(): String {
        return "en"
    }

    fun Boolean.showAlertDialog() {
//        dialog = Dialog(requireActivity())
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(false)
//        val binding: DialogProgressBinding =
//            DataBindingUtil.setContentView(requireActivity(), R.layout.dialog_progress)
//        dialog.setContentView(binding.root)
//        dialog.setCancelable(this)
//        dialog.show()
    }

//    fun getDataSource(
//        viewModel: BaseViewModel,
//        deferred: Deferred<DataSource>,
//        spinner: Spinner,
//        adapter: SpinnerAdapter,
//        hint: String
//    ) {
//        viewModel.dataSource(deferred)
//        viewModel.dataSource.observe(viewLifecycleOwner, {
//            if (it.success) {
//                adapter.setData(it.data, hint)
//                spinner.adapter = adapter
//            }
//        })
//    }
//
//    fun getDataSource(
//        viewModel: BaseViewModel,
//        deferred: Deferred<DataSource>,
//        spinner: Spinner,
//        adapter: SpinnerAdapter,
//        hint: String,
//        onItemSelectedListener: AdapterView.OnItemSelectedListener?
//    ) {
//        viewModel.dataSource(deferred)
//        viewModel.dataSource.observe(viewLifecycleOwner, {
//            if (it.success) {
//                adapter.setData(it.data, hint)
//                spinner.adapter = adapter
//                spinner.onItemSelectedListener = onItemSelectedListener
//            }
//        })
//    }

}