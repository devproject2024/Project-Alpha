package net.one97.paytm.nativesdk.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.android.volley.Request;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.listeners.SetOnAlertButtonListeners;

public class DialogUtility {
    private static final String LOG_TAG = DialogUtility.class.getSimpleName();

    public static ProgressDialog showProgressDialog(Context context, String str, boolean z) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            ProgressDialog progressDialog = new ProgressDialog(context, R.style.PaytmProgressDialogAppCompatLightStyle);
            try {
                progressDialog.setProgressStyle(0);
                progressDialog.setMessage(str);
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(z);
                progressDialog.show();
                return progressDialog;
            } catch (Exception e2) {
                LogUtility.e(LOG_TAG, "Error showing progress dialog");
                LogUtility.printStackTrace(e2);
            }
        }
        return null;
    }

    public static ProgressDialog showProgressDialog(Context context, String str) {
        return showProgressDialog(context, str, false);
    }

    public static void showDialog(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            try {
                c.a aVar = new c.a(context);
                aVar.a((CharSequence) str);
                aVar.b((CharSequence) str2);
                aVar.a((CharSequence) context.getString(R.string.ok), onClickListener);
                aVar.b();
            } catch (Exception e2) {
                LogUtility.e(LOG_TAG, "error showing dialog");
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public static void showTwoButtonDialog(Context context, String str, String str2, String str3, String str4, final SetOnAlertButtonListeners setOnAlertButtonListeners) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            try {
                c.a aVar = new c.a(context);
                if (!TextUtils.isEmpty(str)) {
                    aVar.a((CharSequence) str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    aVar.b((CharSequence) str2);
                }
                aVar.a((CharSequence) str3, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        setOnAlertButtonListeners.onPositiveClicked();
                    }
                });
                aVar.b((CharSequence) str4, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        setOnAlertButtonListeners.onNegativeClicked();
                    }
                });
                aVar.b();
            } catch (Exception e2) {
                LogUtility.e(LOG_TAG, "error showing dialog");
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public static void showTwoButtonDialogNew(Context context, String str, String str2, String str3, String str4, final SetOnAlertButtonListeners setOnAlertButtonListeners) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            try {
                View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_back_press, (ViewGroup) null, false);
                final c a2 = new c.a(context).a(inflate).a();
                TextView textView = (TextView) inflate.findViewById(R.id.tv_backPressTitle);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_backPressMsg);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_yes);
                TextView textView4 = (TextView) inflate.findViewById(R.id.tv_no);
                if (!TextUtils.isEmpty(str)) {
                    textView.setText(str);
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str2)) {
                    textView2.setText(str2);
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str3)) {
                    textView3.setText(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    textView4.setText(str4);
                }
                inflate.findViewById(R.id.tv_yes).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        setOnAlertButtonListeners.onPositiveClicked();
                        a2.dismiss();
                    }
                });
                inflate.findViewById(R.id.tv_no).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        setOnAlertButtonListeners.onNegativeClicked();
                        a2.dismiss();
                    }
                });
                a2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                a2.getWindow().setLayout((int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.7d), -2);
                a2.show();
            } catch (WindowManager.BadTokenException | NullPointerException unused) {
            } catch (Exception e2) {
                LogUtility.e(LOG_TAG, "error showing twoButtonDialog");
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public static void showNoInternetDialog(Context context, final DialogInterface.OnClickListener onClickListener) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            try {
                View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_retry, (ViewGroup) null, false);
                ((TextView) inflate.findViewById(R.id.tv_transactionFailed)).setText(context.getResources().getString(R.string.no_connection));
                ((TextView) inflate.findViewById(R.id.tv_rejection)).setText(context.getResources().getString(R.string.no_internet));
                inflate.findViewById(R.id.v_underline).setVisibility(8);
                inflate.findViewById(R.id.iv_tip).setVisibility(8);
                inflate.findViewById(R.id.tv_retry).setVisibility(8);
                final AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
                inflate.findViewById(R.id.tv_okGotIt).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        onClickListener.onClick(create, 0);
                    }
                });
                if (create.getWindow() != null) {
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                create.show();
                create.getWindow().setLayout(getDialogWidth(context), -2);
            } catch (Exception e2) {
                LogUtility.e(LOG_TAG, "error showing dialog");
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public static c showDialog(Context context, String str, final DialogInterface.OnClickListener onClickListener) {
        boolean z = context instanceof Activity;
        if (z) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                try {
                    c.a aVar = new c.a(context);
                    View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_retry, (ViewGroup) null, false);
                    aVar.a(inflate);
                    aVar.a(false);
                    ((TextView) inflate.findViewById(R.id.tv_rejection)).setText(str);
                    inflate.findViewById(R.id.tv_transactionFailed).setVisibility(8);
                    inflate.findViewById(R.id.iv_tip).setVisibility(8);
                    inflate.findViewById(R.id.tv_retry).setVisibility(8);
                    inflate.findViewById(R.id.v_underline).setVisibility(8);
                    View findViewById = inflate.findViewById(R.id.tv_okGotIt);
                    final c b2 = aVar.b();
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            b2.dismiss();
                            DialogInterface.OnClickListener onClickListener = onClickListener;
                            if (onClickListener != null) {
                                onClickListener.onClick(b2, 1);
                            }
                        }
                    });
                    try {
                        b2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        b2.getWindow().setLayout((int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.7d), -2);
                    } catch (NullPointerException unused) {
                    }
                    return b2;
                } catch (Exception e2) {
                    LogUtility.e(LOG_TAG, "error showing dialog");
                    LogUtility.printStackTrace(e2);
                    if (z) {
                        SDKUtility.hideKeyboard(activity);
                    }
                }
            }
        }
        return null;
    }

    public static void showNetworkDialog(final Request<Object> request, final Context context) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.no_connection));
            builder.setMessage(context.getResources().getString(R.string.no_internet));
            builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (SDKUtility.isNetworkAvailable(context)) {
                        VolleyRequestQueue.getInstance(context).getRequestQueue().add(request);
                    } else {
                        DialogUtility.showNetworkDialog(request, context);
                    }
                }
            });
            try {
                builder.show();
            } catch (Exception e2) {
                LogUtility.e(LOG_TAG, "error showing dialog");
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public static void showErrorInstrumentDialog(String str, String str2, Context context) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.dialog_lyt_error_instrument);
            ((TextView) dialog.findViewById(R.id.txt_title)).setText(str);
            ((TextView) dialog.findViewById(R.id.txt_desc)).setText(str2);
            dialog.findViewById(R.id.btn_okey).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            try {
                dialog.show();
            } catch (Exception e2) {
                LogUtility.e(LOG_TAG, "error showing dialog");
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public static int getDialogWidth(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return (int) (((float) rect.width()) * 0.85f);
    }
}
