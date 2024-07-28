package com.paytmmall.artifact.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    static boolean f15731a;

    /* renamed from: b  reason: collision with root package name */
    public static a f15732b;

    public interface a {
        void onOkClick();
    }

    public static void a(Context context, String str, String str2) {
        if (!f15731a && !((Activity) context).isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str).setMessage(str2).setCancelable(false);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (n.f15732b != null) {
                        n.f15732b.onOkClick();
                        n.f15732b = null;
                    }
                    dialogInterface.cancel();
                    n.f15731a = false;
                }
            });
            builder.show();
            f15731a = true;
        }
    }

    public static void a(FragmentActivity fragmentActivity) {
        x.a().show(fragmentActivity.getSupportFragmentManager(), "dialog");
    }
}
