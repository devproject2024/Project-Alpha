package com.paytm.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;

public final class g {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43804a;

    /* renamed from: b  reason: collision with root package name */
    public static a f43805b;

    public interface a {
        void onOkClick();
    }

    public interface b {
        void a();
    }

    public interface c {
        void onDialogDismissed();
    }

    public static void a(Context context, String str, String str2) {
        if (!f43804a && !((Activity) context).isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str).setMessage(str2).setCancelable(false);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    g.f43804a = false;
                }
            });
            builder.show();
            f43804a = true;
        }
    }

    public static void a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (!f43804a && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(str).setCancelable(false);
            builder.setPositiveButton(str2, onClickListener);
            builder.setNegativeButton(str3, onClickListener2);
            builder.show();
            f43804a = true;
        }
    }

    public static void a() {
        f43804a = false;
    }

    static WindowManager.LayoutParams a(Dialog dialog) {
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
            q.b(e.getMessage());
            return layoutParams;
        }
        return layoutParams;
    }

    public static void a(a aVar) {
        f43805b = aVar;
    }

    public static void a(Context context, String str, String str2, final c cVar) {
        if (!f43804a && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-1, context.getString(R.string.string_report_error), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    g.f43804a = false;
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.onDialogDismissed();
                    }
                }
            });
            hVar.a(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    g.f43804a = false;
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
            f43804a = true;
        }
    }

    public static void b(Context context, String str, String str2, final c cVar) {
        if (!f43804a && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    g.f43804a = false;
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.onDialogDismissed();
                    }
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
            f43804a = true;
        }
    }

    public static void c(Context context, String str, String str2) {
        a(context, str, str2, true);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (context == null || str2 == null || Looper.myLooper() != Looper.getMainLooper()) {
            q.b("Non-UI Thread" + Thread.currentThread());
            com.google.firebase.crashlytics.c.a().a("CustomDialog Thread : " + Thread.currentThread() + " : " + str2);
            com.google.firebase.crashlytics.c.a().a((Throwable) new Exception());
            return;
        }
        boolean z2 = context instanceof Activity;
        if (z2 && !f43804a && z2) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                final h hVar = new h(context);
                hVar.f43822b = false;
                hVar.setTitle(str);
                hVar.a(str2);
                hVar.setCancelable(z);
                WindowManager.LayoutParams a2 = a((Dialog) hVar);
                hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (g.f43805b != null) {
                            g.f43805b.onOkClick();
                            g.f43805b = null;
                        }
                        hVar.cancel();
                        g.f43804a = false;
                    }
                });
                if (z2 && !activity.isFinishing() && !activity.isDestroyed()) {
                    hVar.show();
                    if (!(a2 == null || hVar.getWindow() == null)) {
                        hVar.getWindow().setAttributes(a2);
                    }
                    f43804a = true;
                    hVar.setOnDismissListener($$Lambda$g$csNXfdZVB_TPUMjaxjTJCq2ieE.INSTANCE);
                }
            }
        }
    }

    public static void a(Context context, String str, boolean z) {
        boolean z2 = context instanceof Activity;
        if (z2 && !f43804a && z2 && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.f43822b = false;
            hVar.a(str);
            hVar.setCancelable(z);
            hVar.a();
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (g.f43805b != null) {
                        g.f43805b.onOkClick();
                        g.f43805b = null;
                    }
                    hVar.cancel();
                    g.f43804a = false;
                }
            });
            hVar.show();
            if (!(a2 == null || hVar.getWindow() == null)) {
                hVar.getWindow().setAttributes(a2);
            }
            f43804a = true;
            hVar.setOnDismissListener($$Lambda$g$UzVwPrW40tYygjNgvZ8LhkwUBgw.INSTANCE);
        }
    }

    public static void c(Context context, String str, String str2, final c cVar) {
        if (!f43804a && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-1, context.getString(R.string.ok_text), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    g.f43804a = false;
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.onDialogDismissed();
                    }
                }
            });
            hVar.a(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    g.f43804a = false;
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
            f43804a = true;
        }
    }

    public static void a(Context context, String str, String str2, final b bVar) {
        if (!f43804a && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-1, context.getString(R.string.ok_text), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    g.f43804a = false;
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            });
            hVar.a(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    g.f43804a = false;
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
            f43804a = true;
        }
    }

    public static void b(Context context, String str, String str2) {
        a(context, str, str2, false);
    }
}
