package net.one97.paytm.wallet.newdesign.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.paytm.utility.h;
import com.paytm.utility.q;
import net.one97.paytm.wallet.R;

public class CustomDialog {
    /* access modifiers changed from: private */
    public static boolean isDialogShowing;
    /* access modifiers changed from: private */
    public static OkClickListener okClickListener;

    public interface OkClickListener {
        void onOkClick();
    }

    public interface OnDialogClickListener {
        void onDialogNegativeClick();

        void onDialogPositiveClick();
    }

    public interface OnDialogDismissListener {
        void onDialogDismissed();
    }

    public static void showAlert(Context context, String str, String str2) {
        showAlert(context, str, str2, false);
    }

    public static void showReviewAlert(Context context, String str, String str2) {
        if (!isDialogShowing && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    hVar.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            hVar.show();
            if (dialogLayoutParams != null) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void disableDialog() {
        isDialogShowing = false;
    }

    private static WindowManager.LayoutParams getDialogLayoutParams(Dialog dialog) {
        WindowManager.LayoutParams layoutParams;
        try {
            layoutParams = new WindowManager.LayoutParams();
            try {
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            layoutParams = null;
            q.d(String.valueOf(e));
            return layoutParams;
        }
        return layoutParams;
    }

    public static void initListener(OkClickListener okClickListener2) {
        okClickListener = okClickListener2;
    }

    public static void showReportErrorDialog(Context context, String str, String str2, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-1, context.getString(R.string.string_report_error), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            hVar.a(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                }
            });
            hVar.show();
            if (dialogLayoutParams != null) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void showErrorDialogWithSingleButton(Context context, String str, String str2, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            hVar.show();
            if (dialogLayoutParams != null) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void showAlert(Context context, String str, String str2, boolean z) {
        showAlert(context, str, str2, z, false);
    }

    public static void showAlert(Context context, String str, String str2, boolean z, boolean z2) {
        boolean z3 = context instanceof Activity;
        if (z3 && !isDialogShowing && z3 && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.f43822b = z2;
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(z);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    hVar.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            hVar.show();
            if (!(dialogLayoutParams == null || hVar.getWindow() == null)) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
            hVar.setOnDismissListener($$Lambda$CustomDialog$W_UfaI76MDho316_zgP_ppIavyk.INSTANCE);
        }
    }

    public static void showAlertWithCTA(final Context context, String str, String str2, boolean z, boolean z2, String str3, final Intent intent) {
        boolean z3 = context instanceof Activity;
        if (z3 && !isDialogShowing && z3 && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.f43822b = z2;
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(z);
            if (TextUtils.isEmpty(str3)) {
                str3 = context.getString(R.string.ok);
            }
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-3, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    hVar.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                    Intent intent = intent;
                    if (intent != null) {
                        context.startActivity(intent);
                    }
                }
            });
            hVar.show();
            if (!(dialogLayoutParams == null || hVar.getWindow() == null)) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
            hVar.setOnDismissListener($$Lambda$CustomDialog$1_atYzcOZGwrdfHw7o14pmrNHw8.INSTANCE);
        }
    }

    public static void showAlertWithCTA(final Context context, String str, String str2, String str3, final Intent intent) {
        boolean z = context instanceof Activity;
        if (z && !isDialogShowing && z && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.setTitle(str);
            hVar.a(str2);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-3, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    hVar.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                    Intent intent = intent;
                    if (intent != null) {
                        context.startActivity(intent);
                    }
                }
            });
            hVar.show();
            if (!(dialogLayoutParams == null || hVar.getWindow() == null)) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
            hVar.setOnDismissListener($$Lambda$CustomDialog$emFt1_oB7zmpUGfLFSUqDR9VbjE.INSTANCE);
        }
    }

    public static void showAlertWithoutTitle(Context context, String str, boolean z, boolean z2) {
        boolean z3 = context instanceof Activity;
        if (z3 && !isDialogShowing && z3 && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.f43822b = z2;
            hVar.a(str);
            hVar.setCancelable(z);
            hVar.a();
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    hVar.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            hVar.show();
            if (!(dialogLayoutParams == null || hVar.getWindow() == null)) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
            hVar.setOnDismissListener($$Lambda$CustomDialog$KeMRthQ5hjTtQdMVm56gE4Mwppw.INSTANCE);
        }
    }

    public static void showErrorDialog(Context context, String str, String str2, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-1, context.getString(R.string.ok_text), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            hVar.a(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                }
            });
            hVar.show();
            if (dialogLayoutParams != null) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void showAlert(Context context, String str, String str2, boolean z, final OnDialogDismissListener onDialogDismissListener) {
        boolean z2 = context instanceof Activity;
        if (z2 && z2 && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(z);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-3, context.getString(R.string.open_settings), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    hVar.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            hVar.show();
            hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    onDialogDismissListener.onDialogDismissed();
                }
            });
            if (dialogLayoutParams != null) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
        }
    }

    public static void showAlert(Context context, String str, String str2, boolean z, String str3, String str4, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-1, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                    }
                }
            });
            hVar.a(-2, str4, new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            hVar.show();
            if (dialogLayoutParams != null) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void showConfirmationDialog(Context context, String str, String str2, final OnDialogClickListener onDialogClickListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(hVar);
            hVar.a(-1, context.getString(R.string.ok_text), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogClickListener onDialogClickListener = onDialogClickListener;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onDialogPositiveClick();
                    }
                }
            });
            hVar.a(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogClickListener onDialogClickListener = onDialogClickListener;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onDialogNegativeClick();
                    }
                }
            });
            hVar.show();
            if (dialogLayoutParams != null) {
                hVar.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }
}
