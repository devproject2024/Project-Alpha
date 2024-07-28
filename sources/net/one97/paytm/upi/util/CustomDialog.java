package net.one97.paytm.upi.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CustomDialog;

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

    public static void showCustomAlert(Context context, String str, String str2) {
        if (!isDialogShowing && !((Activity) context).isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str).setMessage(str2).setCancelable(false);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                }
            });
            builder.show();
            isDialogShowing = true;
        }
    }

    public static void showReviewAlert(Context context, String str, String str2) {
        if (!isDialogShowing && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            customWalletAlertDialog.setTitle(str);
            customWalletAlertDialog.setMessage(str2);
            customWalletAlertDialog.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    customWalletAlertDialog.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            customWalletAlertDialog.show();
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
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
            e.printStackTrace();
            return layoutParams;
        }
        return layoutParams;
    }

    public static void initListener(OkClickListener okClickListener2) {
        okClickListener = okClickListener2;
    }

    public static void showReportErrorDialog(Context context, String str, String str2, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            if (str != null) {
                customWalletAlertDialog.setTitle(str);
            }
            if (str2 != null) {
                customWalletAlertDialog.setMessage(str2);
            }
            customWalletAlertDialog.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-1, context.getString(R.string.string_report_error), new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            customWalletAlertDialog.setButton(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                }
            });
            customWalletAlertDialog.show();
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void showErrorDialogWithSingleButton(Context context, String str, String str2, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            if (str != null) {
                customWalletAlertDialog.setTitle(str);
            }
            if (str2 != null) {
                customWalletAlertDialog.setMessage(str2);
            }
            customWalletAlertDialog.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            customWalletAlertDialog.show();
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
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
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            customWalletAlertDialog.setTomatoMode(z2);
            customWalletAlertDialog.setTitle(str);
            customWalletAlertDialog.setMessage(str2);
            customWalletAlertDialog.setCancelable(z);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    customWalletAlertDialog.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            customWalletAlertDialog.show();
            if (!(dialogLayoutParams == null || customWalletAlertDialog.getWindow() == null)) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
            customWalletAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = CustomDialog.isDialogShowing = false;
                }
            });
        }
    }

    public static void showErrorDialog(Context context, String str, String str2, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            if (str != null) {
                customWalletAlertDialog.setTitle(str);
            }
            if (str2 != null) {
                customWalletAlertDialog.setMessage(str2);
            }
            customWalletAlertDialog.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-1, context.getString(R.string.ok_text), new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            customWalletAlertDialog.setButton(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                }
            });
            customWalletAlertDialog.show();
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void showAlert(Context context, String str, String str2, boolean z, final OnDialogDismissListener onDialogDismissListener) {
        boolean z2 = context instanceof Activity;
        if (z2 && z2 && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            customWalletAlertDialog.setTitle(str);
            customWalletAlertDialog.setMessage(str2);
            customWalletAlertDialog.setCancelable(z);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-3, context.getString(R.string.open_settings), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    customWalletAlertDialog.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            customWalletAlertDialog.show();
            customWalletAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    onDialogDismissListener.onDialogDismissed();
                }
            });
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
        }
    }

    public static void showAlert(Context context, String str, String str2, boolean z, String str3, final OnDialogDismissListener onDialogDismissListener) {
        boolean z2 = context instanceof Activity;
        if (z2 && z2 && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            customWalletAlertDialog.setTitle(str);
            customWalletAlertDialog.setMessage(str2);
            customWalletAlertDialog.setCancelable(z);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-3, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                        OkClickListener unused = CustomDialog.okClickListener = null;
                    }
                    customWalletAlertDialog.cancel();
                    boolean unused2 = CustomDialog.isDialogShowing = false;
                }
            });
            customWalletAlertDialog.show();
            customWalletAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    onDialogDismissListener.onDialogDismissed();
                }
            });
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
        }
    }

    public static void showAlert(Context context, String str, String str2, boolean z, String str3, OkClickListener okClickListener2, OnDialogDismissListener onDialogDismissListener) {
        boolean z2 = context instanceof Activity;
        if (z2 && z2 && !((Activity) context).isFinishing()) {
            CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            customWalletAlertDialog.setTitle(str);
            customWalletAlertDialog.setMessage(str2);
            customWalletAlertDialog.setCancelable(z);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-3, str3, new View.OnClickListener(customWalletAlertDialog) {
                private final /* synthetic */ CustomWalletAlertDialog f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CustomDialog.lambda$showAlert$0(CustomDialog.OkClickListener.this, this.f$1, view);
                }
            });
            customWalletAlertDialog.show();
            customWalletAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    CustomDialog.OnDialogDismissListener.this.onDialogDismissed();
                }
            });
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
        }
    }

    static /* synthetic */ void lambda$showAlert$0(OkClickListener okClickListener2, CustomWalletAlertDialog customWalletAlertDialog, View view) {
        okClickListener2.onOkClick();
        customWalletAlertDialog.dismiss();
        isDialogShowing = false;
    }

    public static void showAlert(Context context, String str, String str2, boolean z, String str3, String str4, final OnDialogDismissListener onDialogDismissListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            if (str != null) {
                customWalletAlertDialog.setTitle(str);
            }
            if (str2 != null) {
                customWalletAlertDialog.setMessage(str2);
            }
            customWalletAlertDialog.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-1, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    if (CustomDialog.okClickListener != null) {
                        CustomDialog.okClickListener.onOkClick();
                    }
                }
            });
            customWalletAlertDialog.setButton(-2, str4, new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogDismissListener onDialogDismissListener = onDialogDismissListener;
                    if (onDialogDismissListener != null) {
                        onDialogDismissListener.onDialogDismissed();
                    }
                }
            });
            customWalletAlertDialog.show();
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }

    public static void showConfirmationDialog(Context context, String str, String str2, final OnDialogClickListener onDialogClickListener) {
        if (!isDialogShowing && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(context);
            if (str != null) {
                customWalletAlertDialog.setTitle(str);
            }
            if (str2 != null) {
                customWalletAlertDialog.setMessage(str2);
            }
            customWalletAlertDialog.setCancelable(false);
            WindowManager.LayoutParams dialogLayoutParams = getDialogLayoutParams(customWalletAlertDialog);
            customWalletAlertDialog.setButton(-1, context.getString(R.string.ok_text), new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogClickListener onDialogClickListener = onDialogClickListener;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onDialogPositiveClick();
                    }
                }
            });
            customWalletAlertDialog.setButton(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    customWalletAlertDialog.cancel();
                    boolean unused = CustomDialog.isDialogShowing = false;
                    OnDialogClickListener onDialogClickListener = onDialogClickListener;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onDialogNegativeClick();
                    }
                }
            });
            customWalletAlertDialog.show();
            if (dialogLayoutParams != null) {
                customWalletAlertDialog.getWindow().setAttributes(dialogLayoutParams);
            }
            isDialogShowing = true;
        }
    }
}
