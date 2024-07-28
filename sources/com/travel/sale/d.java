package com.travel.sale;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25743a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String[] f25744b = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static int f25745c = 200;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean a(String[] strArr, int[] iArr) {
            k.c(strArr, "permissions");
            k.c(iArr, "grantResults");
            return strArr[0].equals("android.permission.READ_CALENDAR") && iArr[0] == 0 && strArr[1].equals("android.permission.WRITE_CALENDAR") && iArr[1] == 0;
        }

        public static boolean a(Activity activity, String str) {
            k.c(activity, "activity");
            k.c(str, "permission");
            return !activity.shouldShowRequestPermissionRationale(str);
        }

        public static boolean a(Context context) {
            k.c(context, "context");
            return androidx.core.app.a.a(context, "android.permission.READ_CALENDAR") == 0 && androidx.core.app.a.a(context, "android.permission.WRITE_CALENDAR") == 0;
        }

        /* renamed from: com.travel.sale.d$a$a  reason: collision with other inner class name */
        public static final class C0482a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ kotlin.g.a.a f25746a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f25747b;

            C0482a(kotlin.g.a.a aVar, Context context) {
                this.f25746a = aVar;
                this.f25747b = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f25746a.invoke();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", com.paytm.utility.b.B(this.f25747b), (String) null));
                this.f25747b.startActivity(intent);
            }
        }

        public static final class b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ kotlin.g.a.a f25748a;

            b(kotlin.g.a.a aVar) {
                this.f25748a = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f25748a.invoke();
            }
        }
    }
}
