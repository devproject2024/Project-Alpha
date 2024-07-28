package com.business.merchant_payments.notificationsettings;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.databinding.MpCustomAlertDialogBinding;
import kotlin.g.a.a;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.x;

public final class CustomDialogUtils {
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void showCustomActionDialog(Context context, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, a<x> aVar, a<x> aVar2) {
            Context context2 = context;
            String str7 = str;
            String str8 = str2;
            String str9 = str3;
            String str10 = str4;
            k.d(context2, "context");
            k.d(str8, "message");
            k.d(str9, "positiveText");
            k.d(str5, "gaEventAction");
            k.d(str6, "gaEventCategory");
            k.d(aVar, "positiveAction");
            k.d(aVar2, "negativeAction");
            Dialog dialog = new Dialog(context2);
            dialog.requestWindowFeature(1);
            ViewDataBinding a2 = f.a(LayoutInflater.from(context), R.layout.mp_custom_alert_dialog, (ViewGroup) null, false);
            if (a2 != null) {
                MpCustomAlertDialogBinding mpCustomAlertDialogBinding = (MpCustomAlertDialogBinding) a2;
                dialog.setContentView(mpCustomAlertDialogBinding.getRoot());
                if (str7 != null) {
                    mpCustomAlertDialogBinding.setMTitle(str7);
                    mpCustomAlertDialogBinding.setIsTitleVisible(Boolean.TRUE);
                } else {
                    mpCustomAlertDialogBinding.setIsTitleVisible(Boolean.FALSE);
                }
                mpCustomAlertDialogBinding.setMessage(str8);
                mpCustomAlertDialogBinding.setPositiveText(str9);
                if (str10 != null) {
                    mpCustomAlertDialogBinding.setNegativeText(str10);
                    mpCustomAlertDialogBinding.setIsNegativeBtnVisible(Boolean.TRUE);
                } else {
                    mpCustomAlertDialogBinding.setIsNegativeBtnVisible(Boolean.FALSE);
                }
                Dialog dialog2 = dialog;
                boolean z3 = z2;
                String str11 = str6;
                String str12 = str5;
                mpCustomAlertDialogBinding.setOnPositiveClick(new CustomDialogUtils$Companion$showCustomActionDialog$5(aVar, dialog2, z3, str11, str12, str3));
                mpCustomAlertDialogBinding.setOnNegativeClick(new CustomDialogUtils$Companion$showCustomActionDialog$6(aVar2, dialog2, z3, str11, str12, str4));
                dialog.setCanceledOnTouchOutside(false);
                Window window = dialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawableResource(R.drawable.mp_dialog_background);
                }
                dialog.setCancelable(z);
                dialog.show();
                Window window2 = dialog.getWindow();
                if (window2 != null) {
                    window2.setLayout(-1, -2);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.databinding.MpCustomAlertDialogBinding");
        }
    }
}
