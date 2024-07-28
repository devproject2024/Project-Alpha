package com.business.common_module.utilities;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.business.common_module.R;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import net.one97.paytm.upi.util.UpiContract;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7365a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static String a(Context context, TelephonyManager telephonyManager) {
            k.d(context, "incontext");
            k.d(telephonyManager, "inTelephonyManger");
            String str = null;
            try {
                str = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") == 0) {
                    str = telephonyManager.getDeviceId();
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") == 0) {
                    str = telephonyManager.getSubscriberId();
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                return UUID.randomUUID().toString();
            } catch (Exception e5) {
                e5.printStackTrace();
                return str;
            }
        }

        public static String a(Context context) {
            k.d(context, "context");
            Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (systemService != null) {
                return a(context, (TelephonyManager) systemService);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }

        public static String b(Context context) {
            k.d(context, "context");
            Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (systemService != null) {
                String str = Build.MANUFACTURER + "-" + Build.MODEL + "-" + a(context, (TelephonyManager) systemService);
                k.a((Object) str);
                String replace = new l(" ").replace((CharSequence) str, "");
                try {
                    replace = URLEncoder.encode(replace, AppConstants.UTF_8);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                StringBuilder sb = new StringBuilder("Device identifier is : ");
                k.a((Object) replace);
                sb.append(replace);
                LogUtility.d("TAG", sb.toString());
                return replace;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }

        public static boolean c(Context context) {
            k.d(context, "context");
            try {
                Object systemService = context.getSystemService("keyguard");
                if (systemService != null) {
                    KeyguardManager keyguardManager = (KeyguardManager) systemService;
                    if (Build.VERSION.SDK_INT >= 23) {
                        return keyguardManager.isDeviceSecure();
                    }
                    return keyguardManager.isKeyguardSecure();
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
            } catch (Exception unused) {
                return false;
            }
        }

        public static void a(View view, Context context) {
            k.d(view, "containerView");
            k.d(context, "context");
            ObjectAnimator ofInt = ObjectAnimator.ofInt(view, "backgroundColor", new int[]{Color.argb(100, 0, 133, 119)});
            ofInt.setDuration(500);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.setRepeatMode(2);
            ofInt.setRepeatCount(5);
            ofInt.addListener(new b(view, context));
            ofInt.start();
        }

        public static final class b implements Animator.AnimatorListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f7368a = false;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f7369b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f7370c;

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }

            b(View view, Context context) {
                this.f7369b = view;
                this.f7370c = context;
            }

            public final void onAnimationEnd(Animator animator) {
                if (this.f7368a) {
                    this.f7369b.setBackgroundColor(this.f7370c.getResources().getColor(R.color.light_grey));
                }
            }
        }

        public static void a(View view, Context context, boolean z) {
            k.d(view, "containerView");
            k.d(context, "context");
            ObjectAnimator ofInt = ObjectAnimator.ofInt(view, "backgroundColor", new int[]{Color.argb(100, 0, 133, 119)});
            ofInt.setDuration(500);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.setRepeatMode(2);
            ofInt.setRepeatCount(5);
            ofInt.addListener(new C0105a(z, view));
            ofInt.start();
        }

        /* renamed from: com.business.common_module.utilities.c$a$a  reason: collision with other inner class name */
        public static final class C0105a implements Animator.AnimatorListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f7366a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f7367b;

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            C0105a(boolean z, View view) {
                this.f7366a = z;
                this.f7367b = view;
            }

            public final void onAnimationEnd(Animator animator) {
                if (this.f7366a) {
                    this.f7367b.setVisibility(8);
                }
            }

            public final void onAnimationStart(Animator animator) {
                this.f7367b.setVisibility(0);
            }
        }
    }

    public static final boolean a(String str) {
        k.d(str, "url");
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (p.b(lowerCase, "paytmba://", false)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(String str) {
        k.d(str, "url");
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (p.b(lowerCase, "http://pytm.biz", false)) {
                return true;
            }
            String lowerCase2 = str.toLowerCase();
            k.b(lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (p.b(lowerCase2, "https://pytm.biz", false) || p.b(str, "http://b.paytm.me", false) || p.b(str, "https://b.paytm.me", false)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(String str) {
        k.d(str, "url");
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (p.b(lowerCase, "paytmmp://", false)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(String str) {
        k.d(str, "url");
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (!p.b(lowerCase, "http://p-y.tm", false)) {
                String lowerCase2 = str.toLowerCase();
                k.b(lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (p.b(lowerCase2, "https://p-y.tm", false) || p.b(str, "https://m.p-y.tm", true) || p.b(str, "http://m.paytm.me", true) || p.b(str, "https://m.paytm.me", true)) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public static final void a(String str, Context context) {
        k.d(context, "context");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static final void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && context.getPackageManager() != null) {
            Uri parse = Uri.parse(str);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setAction("android.intent.action.VIEW");
                launchIntentForPackage.setData(parse);
                context.startActivity(launchIntentForPackage);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm"));
            context.startActivity(intent);
        }
    }

    public static final void a(Context context, String[] strArr) {
        k.d(context, "context");
        k.d(strArr, "emails");
        k.d("", "subject");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", strArr);
        intent.putExtra("android.intent.extra.SUBJECT", "");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Unable to perform this action", 1).show();
        }
    }
}
