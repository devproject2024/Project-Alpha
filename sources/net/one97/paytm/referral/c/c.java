package net.one97.paytm.referral.c;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.vipcashback.R;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f20029a = new c();

    private c() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[Catch:{ Exception -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ Exception -> 0x006a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r1, java.lang.String r2, android.content.Context r3) {
        /*
            java.lang.String r0 = "invite_link"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x006a }
            if (r0 == 0) goto L_0x0018
            int r0 = r0.length()     // Catch:{ Exception -> 0x006a }
            if (r0 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            if (r0 == 0) goto L_0x0020
            java.lang.String r1 = c(r2, r3)     // Catch:{ Exception -> 0x006a }
            goto L_0x0040
        L_0x0020:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006a }
            r0.<init>()     // Catch:{ Exception -> 0x006a }
            r0.append(r1)     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = " "
            r0.append(r1)     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x006a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006a }
            r0.<init>()     // Catch:{ Exception -> 0x006a }
            r0.append(r1)     // Catch:{ Exception -> 0x006a }
            r0.append(r2)     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x006a }
        L_0x0040:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x006a }
            r2.<init>()     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "android.intent.action.SEND"
            r2.setAction(r0)     // Catch:{ Exception -> 0x006a }
            java.lang.String r0 = "android.intent.extra.TEXT"
            r2.putExtra(r0, r1)     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = "text/plain"
            r2.setType(r1)     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = "Share via"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x006a }
            android.content.Intent r1 = android.content.Intent.createChooser(r2, r1)     // Catch:{ Exception -> 0x006a }
            java.lang.String r2 = "shareIntent"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x006a }
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.setFlags(r2)     // Catch:{ Exception -> 0x006a }
            r3.startActivity(r1)     // Catch:{ Exception -> 0x006a }
            return
        L_0x006a:
            r1 = move-exception
            r1.getMessage()
            com.paytm.utility.b.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.c.c.a(java.lang.String, java.lang.String, android.content.Context):void");
    }

    public static boolean b(String str, String str2, Context context) {
        String str3;
        k.c(str2, "invite_link");
        k.c(context, "context");
        boolean z = false;
        if (!b("com.twitter.android", context)) {
            return false;
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            str3 = c(str2, context);
        } else {
            str3 = (str + " ") + str2;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.setType("text/plain");
        intent.setFlags(268435456);
        intent.setPackage("com.twitter.android");
        context.startActivity(intent);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[Catch:{ ActivityNotFoundException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ ActivityNotFoundException -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.lang.String r1, java.lang.String r2, android.content.Context r3) {
        /*
            java.lang.String r0 = "invite_link"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ ActivityNotFoundException -> 0x005e }
            if (r0 == 0) goto L_0x0018
            int r0 = r0.length()     // Catch:{ ActivityNotFoundException -> 0x005e }
            if (r0 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            if (r0 == 0) goto L_0x0020
            java.lang.String r1 = c(r2, r3)     // Catch:{ ActivityNotFoundException -> 0x005e }
            goto L_0x0040
        L_0x0020:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x005e }
            r0.<init>()     // Catch:{ ActivityNotFoundException -> 0x005e }
            r0.append(r1)     // Catch:{ ActivityNotFoundException -> 0x005e }
            java.lang.String r1 = " "
            r0.append(r1)     // Catch:{ ActivityNotFoundException -> 0x005e }
            java.lang.String r1 = r0.toString()     // Catch:{ ActivityNotFoundException -> 0x005e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x005e }
            r0.<init>()     // Catch:{ ActivityNotFoundException -> 0x005e }
            r0.append(r1)     // Catch:{ ActivityNotFoundException -> 0x005e }
            r0.append(r2)     // Catch:{ ActivityNotFoundException -> 0x005e }
            java.lang.String r1 = r0.toString()     // Catch:{ ActivityNotFoundException -> 0x005e }
        L_0x0040:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x005e }
            java.lang.String r0 = "android.intent.action.VIEW"
            r2.<init>(r0)     // Catch:{ ActivityNotFoundException -> 0x005e }
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r2.setFlags(r0)     // Catch:{ ActivityNotFoundException -> 0x005e }
            java.lang.String r0 = "sms:"
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ ActivityNotFoundException -> 0x005e }
            r2.setData(r0)     // Catch:{ ActivityNotFoundException -> 0x005e }
            java.lang.String r0 = "sms_body"
            r2.putExtra(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x005e }
            r3.startActivity(r2)     // Catch:{ ActivityNotFoundException -> 0x005e }
            return
        L_0x005e:
            r1 = move-exception
            r1.getMessage()
            com.paytm.utility.b.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.c.c.c(java.lang.String, java.lang.String, android.content.Context):void");
    }

    public static void d(String str, String str2, Context context) {
        String str3;
        k.c(str2, "invite_link");
        k.c(context, "context");
        if (b(AppConstants.WHATS_APP, context)) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                str3 = c(str2, context);
            } else {
                str3 = (str + " ") + str2;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setFlags(268435456);
            intent.putExtra("android.intent.extra.TEXT", str3);
            intent.setType(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            intent.setPackage(AppConstants.WHATS_APP);
            context.startActivity(intent);
        }
    }

    public static void a(String str, Context context) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        k.c(context, "context");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
            Toast.makeText(context, context.getString(R.string.copy_to_clipboard_text), 1).show();
            return;
        }
        throw new u("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    private static String c(String str, Context context) {
        return (context.getString(R.string.referral_share_prefix) + " ") + str;
    }

    public static boolean b(String str, Context context) {
        k.c(str, "uri");
        k.c(context, "context");
        PackageManager packageManager = context.getPackageManager();
        k.a((Object) packageManager, "context.packageManager");
        try {
            packageManager.getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
