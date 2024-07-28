package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.b;
import com.google.android.gms.common.internal.s;

public class j extends b {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f8880a = null;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f8881b = null;

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f8880a == null) {
            setShowsDialog(false);
        }
        return this.f8880a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f8881b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static j a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        j jVar = new j();
        Dialog dialog2 = (Dialog) s.a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        jVar.f8880a = dialog2;
        if (onCancelListener != null) {
            jVar.f8881b = onCancelListener;
        }
        return jVar;
    }

    public void show(androidx.fragment.app.j jVar, String str) {
        super.show(jVar, str);
    }
}
