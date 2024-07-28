package com.travel.citybus.brts.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.paytm.utility.h;
import com.travel.citybus.R;
import com.travel.citybus.brts.utils.d;

public final class c {
    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            String string = activity.getResources().getString(R.string.no_connection);
            String string2 = activity.getResources().getString(R.string.no_internet);
            if (activity != null) {
                try {
                    if (!activity.isFinishing()) {
                        if (string == null) {
                            string = "";
                        }
                        if (string2 == null) {
                            string2 = "";
                        }
                        final h hVar = new h(activity);
                        hVar.setTitle(string);
                        hVar.a(string2);
                        hVar.a(-3, activity.getResources().getString(R.string.brts_ok), new View.OnClickListener() {
                            public final void onClick(View view) {
                                hVar.cancel();
                            }
                        });
                        hVar.setCancelable(true);
                        if (!activity.isFinishing()) {
                            hVar.show();
                        }
                    }
                } catch (Exception e2) {
                    if (b.v) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private static String a(Context context) {
        d.a aVar = d.f23400a;
        return d.a.a(context).b("wallet_sso_token=", "", true);
    }

    private static long b(Context context) {
        d.a aVar = d.f23400a;
        return d.a.a(context).b("wallet_token_expire=", 0, true);
    }

    public static void a(final a aVar, final Context context, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (b.c(context)) {
                    aVar.a();
                } else {
                    c.a(aVar, context, (DialogInterface.OnCancelListener) null);
                }
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r6, android.app.Activity r7, com.paytm.network.listener.b r8) {
        /*
            android.content.Context r0 = r7.getApplicationContext()
            java.lang.String r0 = a((android.content.Context) r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            if (r0 != 0) goto L_0x0021
            android.content.Context r0 = r7.getApplicationContext()
            long r2 = b(r0)
            long r4 = java.lang.System.currentTimeMillis()
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0021
            r0 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x006e
            net.one97.paytm.common.entity.CJRPGToken r6 = new net.one97.paytm.common.entity.CJRPGToken
            r6.<init>()
            android.content.Context r0 = r7.getApplicationContext()
            java.lang.String r0 = a((android.content.Context) r0)
            r6.setToken(r0)
            android.content.Context r0 = r7.getApplicationContext()
            long r2 = b(r0)
            r6.setExpires(r2)
            java.lang.String r0 = "wallet"
            r6.setScopes(r0)
            android.content.Context r7 = r7.getApplicationContext()
            com.travel.citybus.brts.utils.d$a r0 = com.travel.citybus.brts.utils.d.f23400a
            com.paytm.b.a.a r7 = com.travel.citybus.brts.utils.d.a.a(r7)
            java.lang.String r0 = "resId"
            java.lang.String r2 = ""
            java.lang.String r7 = r7.b((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            r6.setResourceOwnerId(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r7.add(r6)
            net.one97.paytm.common.entity.CJRPGTokenList r6 = new net.one97.paytm.common.entity.CJRPGTokenList
            r6.<init>()
            r6.setPGTokenList(r7)
            r8.onApiSuccess(r6)
            return
        L_0x006e:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = com.paytm.utility.b.m()
            java.lang.String r2 = "Authorization"
            r0.put(r2, r1)
            java.lang.String r1 = "access_token"
            r0.put(r1, r6)
            com.travel.citybus.brts.f.d()
            com.travel.citybus.brts.f r6 = com.travel.citybus.brts.f.d()
            java.lang.String r6 = r6.a()
            boolean r1 = android.webkit.URLUtil.isValidUrl(r6)
            if (r1 != 0) goto L_0x00a2
            int r6 = com.travel.citybus.R.string.brts_error
            java.lang.String r6 = r7.getString(r6)
            int r8 = com.travel.citybus.R.string.msg_invalid_url
            java.lang.String r8 = r7.getString(r8)
            com.paytm.utility.b.b((android.content.Context) r7, (java.lang.String) r6, (java.lang.String) r8)
            return
        L_0x00a2:
            android.content.Context r1 = r7.getApplicationContext()
            java.lang.String r6 = com.paytm.utility.b.e((android.content.Context) r1, (java.lang.String) r6)
            boolean r1 = r7 instanceof com.travel.citybus.brts.CJRActionBarBaseActivity
            if (r1 == 0) goto L_0x00c4
            com.travel.citybus.brts.b.a.a()
            android.content.Context r1 = r7.getApplicationContext()
            net.one97.paytm.common.entity.CJRPGTokenList r2 = new net.one97.paytm.common.entity.CJRPGTokenList
            r2.<init>()
            com.paytm.network.a r6 = com.travel.citybus.brts.b.a.b(r1, r6, r0, r2, r8)
            com.travel.citybus.brts.CJRActionBarBaseActivity r7 = (com.travel.citybus.brts.CJRActionBarBaseActivity) r7
            r7.showNetworkDialog(r6)
            return
        L_0x00c4:
            android.content.res.Resources r6 = r7.getResources()
            int r8 = com.travel.citybus.R.string.no_connection
            java.lang.String r6 = r6.getString(r8)
            android.content.res.Resources r8 = r7.getResources()
            int r0 = com.travel.citybus.R.string.no_internet
            java.lang.String r8 = r8.getString(r0)
            com.paytm.utility.b.b((android.content.Context) r7, (java.lang.String) r6, (java.lang.String) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.utils.c.a(java.lang.String, android.app.Activity, com.paytm.network.listener.b):void");
    }
}
