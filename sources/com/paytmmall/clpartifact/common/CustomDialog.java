package com.paytmmall.clpartifact.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.gson.o;

public class CustomDialog {
    public void open(Context context, o oVar) {
    }

    public static void showPrompt(Activity activity, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(str).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = builder.create();
        create.setCancelable(true);
        create.show();
    }
}
