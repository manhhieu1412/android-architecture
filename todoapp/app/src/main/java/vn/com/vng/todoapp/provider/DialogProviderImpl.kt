package vn.com.vng.todoapp.provider

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AlertDialog

/**
 * Created by hieuvm on 9/17/17.
 * *
 */
class DialogProviderImpl : DialogProvider {

    override fun yesNo(activityContext: Context): Dialog {
       return AlertDialog.Builder(activityContext).create()
    }

    override fun progressDialog(activityContext: Context): Dialog {
        return ProgressDialog(activityContext)
    }
}