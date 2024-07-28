package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.s;

public final class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f8643a = null;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f8644b = null;

    public final Dialog onCreateDialog(Bundle bundle) {
        if (this.f8643a == null) {
            setShowsDialog(false);
        }
        return this.f8643a;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f8644b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        Dialog dialog2 = (Dialog) s.a(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        bVar.f8643a = dialog2;
        if (onCancelListener != null) {
            bVar.f8644b = onCancelListener;
        }
        return bVar;
    }

    public final void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
