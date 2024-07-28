package io.branch.referral.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import io.branch.referral.c;
import io.branch.referral.m;
import java.lang.ref.WeakReference;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<Activity> f46448a;

    public static void a(WeakReference<Activity> weakReference) {
        String str;
        AlertDialog.Builder builder;
        AlertDialog.Builder builder2;
        f46448a = weakReference;
        if (c.a() == null || c.a().g() == null) {
            str = "";
        } else {
            JSONObject g2 = c.a().g();
            str = g2.optString("~" + m.a.ReferringLink.getKey());
        }
        if (!TextUtils.isEmpty(str) && weakReference != null) {
            final JSONObject g3 = c.a().g();
            if (g3.optInt("_branch_validate") == 60514) {
                if (g3.optBoolean(m.a.Clicked_Branch_Link.getKey())) {
                    if (f46448a.get() != null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            builder2 = new AlertDialog.Builder((Context) f46448a.get(), 16974374);
                        } else {
                            builder2 = new AlertDialog.Builder((Context) f46448a.get());
                        }
                        builder2.setTitle("Branch Deeplinking Routing").setMessage("Good news - we got link data. Now a question for you, astute developer: did the app deep link to the specific piece of content you expected to see?").setPositiveButton(CommonPayParams.Builder.YES, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                a.a(a.b(g3, "g"));
                            }
                        }).setNegativeButton(CommonPayParams.Builder.NO, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                a.a(a.b(g3, "r"));
                            }
                        }).setNeutralButton(17039360, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).setCancelable(false).setIcon(17301651).show();
                    }
                } else if (f46448a.get() != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        builder = new AlertDialog.Builder((Context) f46448a.get(), 16974374);
                    } else {
                        builder = new AlertDialog.Builder((Context) f46448a.get());
                    }
                    builder.setTitle("Branch Deeplink Routing Support").setMessage("Bummer. It seems like +clicked_branch_link is false - we didn't deep link.  Double check that the link you're clicking has the same branch_key that is being used in your Manifest file. Return to Chrome when you're ready to test again.").setNeutralButton("Got it", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).setCancelable(false).setIcon(17301651).show();
                }
            } else if (g3.optBoolean("bnc_validate")) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        a.a(a.b(g3, ""));
                    }
                }, 500);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052 A[SYNTHETIC, Splitter:B:12:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(org.json.JSONObject r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "t5"
            java.lang.String r1 = "t4"
            java.lang.String r2 = "t3"
            java.lang.String r3 = "t2"
            java.lang.String r4 = "t1"
            java.lang.String r5 = "ct"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            java.lang.String r7 = "~"
            r6.<init>(r7)     // Catch:{ Exception -> 0x0034 }
            io.branch.referral.m$a r7 = io.branch.referral.m.a.ReferringLink     // Catch:{ Exception -> 0x0034 }
            java.lang.String r7 = r7.getKey()     // Catch:{ Exception -> 0x0034 }
            r6.append(r7)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r6 = r10.getString(r6)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r7 = "\\?"
            java.lang.String[] r7 = r6.split(r7)     // Catch:{ Exception -> 0x0036 }
            r8 = 0
            r6 = r7[r8]     // Catch:{ Exception -> 0x0036 }
            goto L_0x003b
        L_0x0034:
            java.lang.String r6 = ""
        L_0x0036:
            java.lang.String r7 = "Failed to get referring link"
            io.branch.referral.q.h(r7)
        L_0x003b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = "?validate=true"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            boolean r7 = android.text.TextUtils.isEmpty(r11)
            if (r7 != 0) goto L_0x0167
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0163 }
            r7.<init>()     // Catch:{ Exception -> 0x0163 }
            r7.append(r6)     // Catch:{ Exception -> 0x0163 }
            java.lang.String r8 = r10.getString(r5)     // Catch:{ Exception -> 0x0163 }
            boolean r8 = r8.equals(r4)     // Catch:{ Exception -> 0x0163 }
            java.lang.String r9 = "&t1="
            if (r8 == 0) goto L_0x006f
            java.lang.String r4 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0163 }
            java.lang.String r4 = r9.concat(r4)     // Catch:{ Exception -> 0x0163 }
            goto L_0x007f
        L_0x006f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0163 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0163 }
            java.lang.String r4 = r10.getString(r4)     // Catch:{ Exception -> 0x0163 }
            r8.append(r4)     // Catch:{ Exception -> 0x0163 }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x0163 }
        L_0x007f:
            r7.append(r4)     // Catch:{ Exception -> 0x0163 }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x0163 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0160 }
            r6.<init>()     // Catch:{ Exception -> 0x0160 }
            r6.append(r4)     // Catch:{ Exception -> 0x0160 }
            java.lang.String r7 = r10.getString(r5)     // Catch:{ Exception -> 0x0160 }
            boolean r7 = r7.equals(r3)     // Catch:{ Exception -> 0x0160 }
            java.lang.String r8 = "&t2="
            if (r7 == 0) goto L_0x00a3
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0160 }
            java.lang.String r3 = r8.concat(r3)     // Catch:{ Exception -> 0x0160 }
            goto L_0x00b3
        L_0x00a3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0160 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0160 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x0160 }
            r7.append(r3)     // Catch:{ Exception -> 0x0160 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x0160 }
        L_0x00b3:
            r6.append(r3)     // Catch:{ Exception -> 0x0160 }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x0160 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015d }
            r4.<init>()     // Catch:{ Exception -> 0x015d }
            r4.append(r3)     // Catch:{ Exception -> 0x015d }
            java.lang.String r6 = r10.getString(r5)     // Catch:{ Exception -> 0x015d }
            boolean r6 = r6.equals(r2)     // Catch:{ Exception -> 0x015d }
            java.lang.String r7 = "&t3="
            if (r6 == 0) goto L_0x00d7
            java.lang.String r2 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x015d }
            java.lang.String r2 = r7.concat(r2)     // Catch:{ Exception -> 0x015d }
            goto L_0x00e7
        L_0x00d7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015d }
            r6.<init>(r7)     // Catch:{ Exception -> 0x015d }
            java.lang.String r2 = r10.getString(r2)     // Catch:{ Exception -> 0x015d }
            r6.append(r2)     // Catch:{ Exception -> 0x015d }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x015d }
        L_0x00e7:
            r4.append(r2)     // Catch:{ Exception -> 0x015d }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x015d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015a }
            r3.<init>()     // Catch:{ Exception -> 0x015a }
            r3.append(r2)     // Catch:{ Exception -> 0x015a }
            java.lang.String r4 = r10.getString(r5)     // Catch:{ Exception -> 0x015a }
            boolean r4 = r4.equals(r1)     // Catch:{ Exception -> 0x015a }
            java.lang.String r6 = "&t4="
            if (r4 == 0) goto L_0x010b
            java.lang.String r1 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x015a }
            java.lang.String r1 = r6.concat(r1)     // Catch:{ Exception -> 0x015a }
            goto L_0x011b
        L_0x010b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015a }
            r4.<init>(r6)     // Catch:{ Exception -> 0x015a }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ Exception -> 0x015a }
            r4.append(r1)     // Catch:{ Exception -> 0x015a }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x015a }
        L_0x011b:
            r3.append(r1)     // Catch:{ Exception -> 0x015a }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x015a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0157 }
            r2.<init>()     // Catch:{ Exception -> 0x0157 }
            r2.append(r1)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r3 = r10.getString(r5)     // Catch:{ Exception -> 0x0157 }
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r4 = "&t5="
            if (r3 == 0) goto L_0x013f
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r10 = r4.concat(r10)     // Catch:{ Exception -> 0x0157 }
            goto L_0x014f
        L_0x013f:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0157 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r10 = r10.getString(r0)     // Catch:{ Exception -> 0x0157 }
            r11.append(r10)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x0157 }
        L_0x014f:
            r2.append(r10)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x0157 }
            goto L_0x0167
        L_0x0157:
            r10 = move-exception
            r6 = r1
            goto L_0x0164
        L_0x015a:
            r10 = move-exception
            r6 = r2
            goto L_0x0164
        L_0x015d:
            r10 = move-exception
            r6 = r3
            goto L_0x0164
        L_0x0160:
            r10 = move-exception
            r6 = r4
            goto L_0x0164
        L_0x0163:
            r10 = move-exception
        L_0x0164:
            r10.printStackTrace()
        L_0x0167:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            java.lang.String r11 = "&os=android"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.b.a.b(org.json.JSONObject, java.lang.String):java.lang.String");
    }

    static /* synthetic */ void a(String str) {
        if (f46448a.get() != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).buildUpon().appendQueryParameter("$uri_redirect_mode", "2").build());
            intent.addFlags(268435456);
            intent.setPackage("com.android.chrome");
            ((Activity) f46448a.get()).getPackageManager().queryIntentActivities(intent, 0);
            try {
                ((Activity) f46448a.get()).startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                intent.setPackage((String) null);
                ((Activity) f46448a.get()).startActivity(intent);
            }
        }
    }
}
