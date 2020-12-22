package com.ashhalan.bitary.util

import android.content.Context
import android.graphics.Color
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.yanzhenjie.album.Action
import com.yanzhenjie.album.Album
import com.yanzhenjie.album.AlbumConfig
import com.yanzhenjie.album.AlbumFile
import com.yanzhenjie.album.api.widget.Widget
import com.yehia.mira_keyboard_utils.R
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.MultipartBody.Part.Companion.createFormData
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.util.*


class HelperMethod {
    companion object {

        fun hiddenKeyBord(view: View, context: Context) {
            val imm =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun editHeight(view: View, SubView: RelativeLayout?, open: Boolean, context: Context) {
            if (open) {
                TransitionManager.beginDelayedTransition(SubView)
                val appear = view.layoutParams
                appear.width = ViewGroup.LayoutParams.MATCH_PARENT
                appear.height = ViewGroup.LayoutParams.MATCH_PARENT
                view.layoutParams = appear
            } else {
                val appear = view.layoutParams
                appear.height = context.resources.getDimension(R.dimen._530sdp).toInt()
                appear.width = context.resources.getDimension(R.dimen._250sdp).toInt()
                view.layoutParams = appear
            }
        }

        fun editHeight(
            view: View,
            SubView: ConstraintLayout?,
            open: Boolean,
            height: Int,
            width: Int
        ) {
            if (open) {
                TransitionManager.beginDelayedTransition(SubView)
                val appear = view.layoutParams
                appear.width = ViewGroup.LayoutParams.MATCH_PARENT
                appear.height = ViewGroup.LayoutParams.MATCH_PARENT
                view.layoutParams = appear
            } else {
                val appear = view.layoutParams
                appear.height = height
                appear.width = width
                view.layoutParams = appear
            }
        }

        fun onLoadImageFromUrl(imageView: ImageView?, URl: String?, context: Context?) {
            Glide.with(context!!)
                .load(URl)
                .into(imageView!!)
        }

        fun openAlbum(
            Counter: Int,
            context: Context,
            ImagesFiles: ArrayList<AlbumFile?>?,
            action: Action<ArrayList<AlbumFile?>?>
        ) {
            Album.initialize(
                AlbumConfig.newBuilder(context)
                    .setAlbumLoader(MediaLoader())
                    .setLocale(Locale.ENGLISH).build()
            )
            Album.image(context) // Image and video mix options.
                .multipleChoice() // Multi-Mode, Single-Mode: singleChoice().
                .columnCount(3) // The number of columns in the page list.
                .selectCount(Counter) // Choose up to a few images.
                .camera(true) // Whether the camera appears in the Item.
                .checkedList(ImagesFiles) // To reverse the list.
                .widget(
                    Widget.newLightBuilder(context)
                        .title("")
                        .statusBarColor(context.resources.getColor(R.color.colorPrimary))
                        .toolBarColor(context.resources.getColor(R.color.colorPrimary))
                        .navigationBarColor(context.resources.getColor(R.color.colorPrimary))
                        .mediaItemCheckSelector(
                            Color.BLUE,
                            Color.GREEN
                        ) // Image or video selection box.
                        .bucketItemCheckSelector(
                            Color.RED,
                            Color.YELLOW
                        ) // Select the folder selection box.
                        .build()
                )
                .onResult(action)
                .onCancel {
                    // The Client canceled the operation.
                }
                .start()
        }

        fun openAlbum(context: Context, action: Action<ArrayList<AlbumFile?>?>) {
            Album.initialize(
                AlbumConfig.newBuilder(context)
                    .setAlbumLoader(MediaLoader())
                    .setLocale(Locale.ENGLISH).build()
            )
            Album.image(context) // Image and video mix options.
                .singleChoice() // Multi-Mode, Single-Mode: singleChoice().
                .columnCount(3) // The number of columns in the page list.
                .camera(true) // Whether the camera appears in the Item.
                .widget(
                    Widget.newLightBuilder(context)
                        .title("")
                        .statusBarColor(context.resources.getColor(R.color.colorPrimary))
                        .toolBarColor(context.resources.getColor(R.color.colorPrimary))
                        .navigationBarColor(context.resources.getColor(R.color.colorPrimary))
                        .mediaItemCheckSelector(
                            Color.BLUE,
                            Color.GREEN
                        ) // Image or video selection box.
                        .bucketItemCheckSelector(
                            Color.RED,
                            Color.YELLOW
                        ) // Select the folder selection box.
                        .build()
                )
                .onResult(action)
                .onCancel {
                    // The Client canceled the operation.
                }
                .start()
        }

        fun convertToRequestBody(part: String): RequestBody? {
            if (part != "") {
                return part.toRequestBody(MultipartBody.FORM)
            } else {
                return null
            }
        }

        fun convertFileToMultipart(path: String?, key: String): MultipartBody.Part? {
            if (path != null) {
                val file = File(path)
                val requestBody: RequestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
                val body: MultipartBody.Part =
                    createFormData(key, file.name, requestBody)

                return body
            } else {
                return null
            }
        }

    }
}