package com.pince.pokexactivity.base

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import androidx.databinding.library.baseAdapters.BR

/**
 * @Author Yu
 * @Date 2021/7/14 10:51
 * @Description TODO
 */
class BindingInitProvider : ContentProvider() {
    companion object {
        private const val TAG = "BindingInitProvider"
        private const val MIN_FIELD_SIZE = 1
    }
    override fun onCreate(): Boolean {
        val fieldSize = BindingManager.bind<BR>()
        if (fieldSize <= MIN_FIELD_SIZE) {
            Log.i(TAG, "BindingManager initialization successful, but there is no `@Bindable` field.")
        } else {
            Log.i(TAG, "BindingManager initialization successful. Size: $fieldSize")
        }
        return false
    }

    override fun getType(uri: Uri): String? = null
    override fun insert(uri: Uri, values: ContentValues?): Uri? = null
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int = 0
    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? = null

}