package com.paytm.android.chat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.c;

public class TwoButtonDialogUtil {
    public static void showSystemDialog(Context context, int i2, int i3, DialogInterface.OnClickListener onClickListener, int i4, DialogInterface.OnClickListener onClickListener2) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        c.a aVar = new c.a(context);
        aVar.b((CharSequence) context.getString(i2));
        aVar.a((CharSequence) context.getString(i3), onClickListener);
        aVar.b((CharSequence) context.getString(i4), onClickListener2);
        aVar.a().show();
    }

    public static void showSystemDialog(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        c.a aVar = new c.a(context);
        aVar.b((CharSequence) str);
        aVar.a((CharSequence) str2, onClickListener);
        aVar.b((CharSequence) str3, onClickListener2);
        if (onDismissListener != null) {
            aVar.f1095a.t = onDismissListener;
        }
        c a2 = aVar.a();
        a2.setCanceledOnTouchOutside(true);
        a2.show();
    }
}
