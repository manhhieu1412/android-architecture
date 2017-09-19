package vn.com.vng.todoapp.provider

import android.content.Context
import android.support.v7.app.AlertDialog

/**
 * Created by hieuvm on 9/17/17.
 * *
 */
interface DialogProvider {
    fun yesNo(activityContext: Context): AlertDialog
}