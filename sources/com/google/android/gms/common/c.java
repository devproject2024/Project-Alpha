package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.h;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.bj;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.i;
import com.google.android.gms.common.util.n;
import com.google.android.gms.internal.base.k;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f8646a = d.f8658b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f8647c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final c f8648d = new c();

    /* renamed from: e  reason: collision with root package name */
    private String f8649e;

    public static c a() {
        return f8648d;
    }

    class a extends k {

        /* renamed from: a  reason: collision with root package name */
        private final Context f8652a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f8652a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            if (message.what != 1) {
                int i2 = message.what;
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                return;
            }
            int a2 = c.this.a(this.f8652a);
            if (c.this.a(a2)) {
                c cVar = c.this;
                Context context = this.f8652a;
                cVar.a(context, a2, cVar.a(context, a2, 0, "n"));
            }
        }
    }

    public final Dialog a(Activity activity, int i2, int i3) {
        return b(activity, i2, i3, (DialogInterface.OnCancelListener) null);
    }

    public final boolean a(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog b2 = b(activity, i2, i3, onCancelListener);
        if (b2 == null) {
            return false;
        }
        a(activity, b2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public static Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(e.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        a(activity, (Dialog) create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public static zabq a(Context context, bj bjVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabq zabq = new zabq(bjVar);
        context.registerReceiver(zabq, intentFilter);
        zabq.f8641a = context;
        if (h.a(context, "com.google.android.gms")) {
            return zabq;
        }
        bjVar.a();
        zabq.a();
        return null;
    }

    private final String c() {
        String str;
        synchronized (f8647c) {
            str = this.f8649e;
        }
        return str;
    }

    public final int a(Context context) {
        return super.a(context);
    }

    public final int a(Context context, int i2) {
        return super.a(context, i2);
    }

    public final boolean a(int i2) {
        return super.a(i2);
    }

    public final Intent a(Context context, int i2, String str) {
        return super.a(context, i2, str);
    }

    public final PendingIntent a(Context context, int i2, int i3) {
        return super.a(context, i2, i3);
    }

    public final String b(int i2) {
        return super.b(i2);
    }

    private static Dialog a(Context context, int i2, f fVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(e.c(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String e2 = e.e(context, i2);
        if (e2 != null) {
            builder.setPositiveButton(e2, fVar);
        }
        String a2 = e.a(context, i2);
        if (a2 != null) {
            builder.setTitle(a2);
        }
        return builder.create();
    }

    private static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            j.a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, int i2, PendingIntent pendingIntent) {
        int i3;
        if (i2 == 18) {
            e(context);
        } else if (pendingIntent != null) {
            String b2 = e.b(context, i2);
            String d2 = e.d(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            h.e eVar = new h.e(context);
            eVar.x = true;
            h.e a2 = eVar.a(true).a((CharSequence) b2).a((h.C0039h) new h.c().a((CharSequence) d2));
            if (i.a(context.getPackageManager())) {
                s.a(n.c());
                a2.a(context.getApplicationInfo().icon).l = 2;
                if (i.a(context)) {
                    a2.a(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    a2.f2723f = pendingIntent;
                }
            } else {
                h.e a3 = a2.a(17301642).d(resources.getString(R.string.common_google_play_services_notification_ticker)).a(System.currentTimeMillis());
                a3.f2723f = pendingIntent;
                a3.b((CharSequence) d2);
            }
            if (n.f()) {
                s.a(n.f());
                String c2 = c();
                if (c2 == null) {
                    c2 = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(c2);
                    String a4 = e.a(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(c2, a4, 4));
                    } else if (!a4.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(a4);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                a2.I = c2;
            }
            Notification d3 = a2.d();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = 10436;
                h.f8689c.set(false);
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, d3);
        }
    }

    private void e(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000);
    }

    private Dialog b(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return a((Context) activity, i2, f.a(activity, super.a((Context) activity, i2, "d"), i3), onCancelListener);
    }

    public final boolean a(Activity activity, j jVar, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a((Context) activity, i2, f.a(jVar, super.a((Context) activity, i2, "d")), onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean a(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent pendingIntent;
        if (connectionResult.a()) {
            pendingIntent = connectionResult.f8335c;
        } else {
            pendingIntent = super.a(context, connectionResult.f8334b, 0);
        }
        if (pendingIntent == null) {
            return false;
        }
        a(context, connectionResult.f8334b, GoogleApiActivity.a(context, pendingIntent, i2));
        return true;
    }
}
