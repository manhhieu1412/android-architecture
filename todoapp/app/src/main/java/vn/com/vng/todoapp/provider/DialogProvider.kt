package vn.com.vng.todoapp.provider

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context

/**
 * Created by hieuvm on 9/17/17.
 * *
 */
interface DialogProvider {
    fun yesNo(activityContext: Context): Dialog

    fun progressDialog(activityContext: Context): Dialog
}