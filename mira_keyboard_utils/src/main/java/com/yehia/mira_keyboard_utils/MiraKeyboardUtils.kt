//package com.yehia.mira_keyboard_utils
//
//import android.app.Activity
//import android.content.Context
//import android.graphics.Rect
//import android.view.View
//import android.view.ViewGroup
//import android.view.ViewTreeObserver
//import android.view.inputmethod.InputMethodManager
//import java.util.HashMap
//
//
//class MiraKeyboardUtils: ViewTreeObserver.OnGlobalLayoutListener {
//
//    private val MAGIC_NUMBER = 200
//    private val sListenerMap: HashMap<SoftKeyboardToggleListener, MiraKeyboardUtils> =
//        HashMap<SoftKeyboardToggleListener, MiraKeyboardUtils>()
//    var mCallback: SoftKeyboardToggleListener? = null
//    var mRootView: View? = null
//    var prevValue: Boolean? = null
//    var mScreenDensity = 0f
//
//    open fun MiraKeyboardUtils(act: Activity, listener: SoftKeyboardToggleListener) {
//        mCallback = listener
//        mRootView = (act.findViewById<View>(R.id.content) as ViewGroup).getChildAt(0)
//        mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this)
//        mScreenDensity = act.resources.displayMetrics.density
//    }
//
//    /**
//     * Add a new keyboard listener
//     *
//     * @param act      calling activity
//     * @param listener callback
//     */
//    fun addKeyboardToggleListener(act: Activity, listener: SoftKeyboardToggleListener) {
//        removeKeyboardToggleListener(listener)
//        sListenerMap[listener] = MiraKeyboardUtils(act, listener)
//    }
//
//    /**
//     * Remove a registered listener
//     *
//     * @param listener [SoftKeyboardToggleListener]
//     */
//    fun removeKeyboardToggleListener(listener: SoftKeyboardToggleListener) {
//        if (sListenerMap.containsKey(listener)) {
//            val k = sListenerMap[listener]
//            k!!.removeListener()
//            sListenerMap.remove(listener)
//        }
//    }
//
//    /**
//     * Remove all registered keyboard listeners
//     */
//    fun removeAllKeyboardToggleListeners() {
//        for (l in sListenerMap.keys) sListenerMap[l]!!.removeListener()
//        sListenerMap.clear()
//    }
//
//    /**
//     * Manually toggle soft keyboard visibility
//     *
//     * @param context calling context
//     */
//    fun toggleKeyboardVisibility(context: Context) {
//        val inputMethodManager =
//            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
//    }
//
//    /**
//     * Force closes the soft keyboard
//     *
//     * @param activeView the view with the keyboard focus
//     */
//    fun forceCloseKeyboard(activeView: View) {
//        val inputMethodManager =
//            activeView.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager?.hideSoftInputFromWindow(activeView.windowToken, 0)
//    }
//
//    fun onGlobalLayout() {
//        val r = Rect()
//        mRootView!!.getWindowVisibleDisplayFrame(r)
//        val heightDiff = mRootView!!.rootView.height - (r.bottom - r.top)
//        val dp = heightDiff / mScreenDensity
//        val isVisible = dp > MAGIC_NUMBER
//        if (mCallback != null && (prevValue == null || isVisible != prevValue)) {
//            prevValue = isVisible
//            mCallback.onToggleSoftKeyboard(isVisible)
//        }
//    }
//
//    open fun removeListener() {
//        mCallback = null
//        mRootView!!.viewTreeObserver.removeOnGlobalLayoutListener(this)
//    }
//
//    interface SoftKeyboardToggleListener {
//        fun onToggleSoftKeyboard(isVisible: Boolean)
//    }
//
//}
