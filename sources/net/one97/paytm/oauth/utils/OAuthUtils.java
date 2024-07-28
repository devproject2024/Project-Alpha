package net.one97.paytm.oauth.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.auth.api.a;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.c;
import com.google.android.gms.common.internal.s;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.v;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytm.utility.q;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.oauth.fragment.IvrBottomFragment;
import net.one97.paytm.oauth.fragment.bh;
import net.one97.paytm.oauth.fragment.bp;
import net.one97.paytm.oauth.fragment.i;
import net.one97.paytm.oauth.models.OperatorIconsModel;
import net.one97.paytm.oauth.models.TelcoIcons;

public class OAuthUtils {

    /* renamed from: a  reason: collision with root package name */
    public static InputFilter f56746a = $$Lambda$OAuthUtils$TBje2fOLcMjwyBaB2wKt1jLNeo4.INSTANCE;

    public interface a {
        void onNetWorkAvailable();
    }

    public enum b {
        SESSION_TIME_OUT,
        SET_PASSWORD,
        DEFAULT
    }

    public static void a(EditText editText) {
        try {
            editText.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) OauthModule.b().getApplicationContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void a(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static void a(Fragment fragment) {
        if (fragment.getActivity() != null && fragment.getView().getRootView() != null) {
            ((InputMethodManager) fragment.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(fragment.getView().getRootView().getWindowToken(), 0);
        }
    }

    public static boolean a(String str) {
        if (OauthModule.a().f52577d) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile(SDKConstants.MOB_NO_REG_EX).matcher(str).find();
        }
        return false;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(AppConstants.EMAIL_REG_EX).matcher(str).find();
    }

    public static boolean c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 5) {
            return true;
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        return str.equals(str2);
    }

    public static void a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setCancelable(false);
        builder.setNegativeButton(context.getString(R.string.dismiss), $$Lambda$OAuthUtils$KiE5qXZdVEiGSQYqxXRgzyIwKbY.INSTANCE);
        builder.setPositiveButton(context.getString(R.string.network_try_again), new DialogInterface.OnClickListener(onClickListener) {
            private final /* synthetic */ DialogInterface.OnClickListener f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                OAuthUtils.a(this.f$0, dialogInterface, i2);
            }
        });
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        onClickListener.onClick(dialogInterface, i2);
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 6;
    }

    public static void a(j jVar) {
        String ab = com.paytm.utility.b.ab(OauthModule.b().getApplicationContext());
        if (TextUtils.isEmpty(ab)) {
            ab = com.paytm.utility.b.l(OauthModule.b().getApplicationContext());
        }
        if (!com.paytm.utility.b.r(OauthModule.b().getApplicationContext()) && TextUtils.isEmpty(ab)) {
            q qVar = q.f56798a;
            if (q.a() == -1) {
                q qVar2 = q.f56798a;
                q.a(System.currentTimeMillis());
                q qVar3 = q.f56798a;
                q.a(0);
                return;
            }
            net.one97.paytm.oauth.a.a();
            if (!TextUtils.isEmpty(net.one97.paytm.oauth.a.a("signUpPopUpIntervals"))) {
                net.one97.paytm.oauth.a.a();
                String[] split = net.one97.paytm.oauth.a.a("signUpPopUpIntervals").split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                q qVar4 = q.f56798a;
                int b2 = q.b();
                if (b2 >= split.length) {
                    b2 = split.length - 1;
                }
                long currentTimeMillis = System.currentTimeMillis();
                q qVar5 = q.f56798a;
                if (currentTimeMillis - q.a() > ((long) (Integer.parseInt(split[b2]) * 24 * 60 * 60 * 1000))) {
                    androidx.fragment.app.q a2 = jVar.a();
                    bp.a aVar = bp.f56503b;
                    a2.a((Fragment) new bp(), bp.class.getName());
                    a2.c();
                    q qVar6 = q.f56798a;
                    q.a(System.currentTimeMillis());
                    q qVar7 = q.f56798a;
                    q qVar8 = q.f56798a;
                    q.a(q.b() + 1);
                }
            }
        }
    }

    public static void a(final Context context, final a aVar) {
        if (!com.paytm.network.b.b.a(context)) {
            a(context, context.getString(R.string.no_connection), context.getString(R.string.no_internet), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    OAuthUtils.a(context, aVar);
                }
            });
        } else {
            aVar.onNetWorkAvailable();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ CharSequence a(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (charSequence == null || !charSequence.toString().equals(" ")) {
            return null;
        }
        return "";
    }

    public static void a(NetworkCustomError networkCustomError, AppCompatActivity appCompatActivity, String str) {
        if (networkCustomError != null && !a((Activity) appCompatActivity, (Fragment) null, networkCustomError)) {
            if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410) {
                OauthModule.b().handleSessionTimeOut(appCompatActivity, networkCustomError, str, (Bundle) null, true, false);
            } else if (networkCustomError.getErrorType() == NetworkCustomError.ErrorType.ParsingError) {
                com.paytm.utility.b.d((Context) appCompatActivity, networkCustomError.getUrl(), networkCustomError.getUniqueReference());
            } else if (networkCustomError.getAlertMessage() == null || networkCustomError.getAlertTitle() == null) {
                com.paytm.utility.b.b((Context) appCompatActivity, appCompatActivity.getString(R.string.network_error_heading), appCompatActivity.getString(R.string.network_error_message));
            } else {
                com.paytm.utility.b.b((Context) appCompatActivity, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            }
        }
    }

    public static String e(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.length() > 5) {
            String substring = str.substring(0, 5);
            String substring2 = str.substring(5);
            sb.append(substring);
            sb.append(" ");
            sb.append(substring2);
        }
        return sb.toString();
    }

    public static void a(j jVar, String str) {
        IvrBottomFragment.a aVar = IvrBottomFragment.f56136a;
        k.c(str, "mobileNo");
        Bundle bundle = new Bundle();
        bundle.putString("login_mobile", str);
        IvrBottomFragment ivrBottomFragment = new IvrBottomFragment();
        ivrBottomFragment.setArguments(bundle);
        androidx.fragment.app.q a2 = jVar.a();
        a2.a((Fragment) ivrBottomFragment, IvrBottomFragment.class.getName());
        a2.c();
    }

    public static boolean a(Activity activity, Fragment fragment, NetworkCustomError networkCustomError) {
        if (networkCustomError == null || networkCustomError.getNetworkResponse() == null || networkCustomError.getNetworkResponse().statusCode != 403 || !"AkamaiGHost".equals(networkCustomError.getNetworkResponse().headers.get("Server"))) {
            return false;
        }
        g.f43805b = new g.a(activity, fragment) {
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ Fragment f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onOkClick() {
                OAuthUtils.a(this.f$0, this.f$1);
            }
        };
        com.paytm.utility.b.b((Context) activity, "", activity.getString(R.string.msg_ip_blocked));
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, Fragment fragment) {
        if (activity instanceof OAuthMainActivity) {
            Intent intent = new Intent(activity, OAuthMainActivity.class);
            intent.addFlags(536870912);
            intent.putExtra("login", true);
            intent.putExtra(p.f56797b, "/ip-blacklist-pop-up");
            activity.startActivity(intent);
            return;
        }
        if (fragment instanceof androidx.fragment.app.b) {
            ((androidx.fragment.app.b) fragment).dismissAllowingStateLoss();
        }
        if (com.paytm.utility.b.r((Context) activity)) {
            OauthModule.b().onLogout(activity, false, (VolleyError) null);
        }
        if (b(activity)) {
            activity.finish();
        }
        OauthModule.b().openHomePage(activity, false, "/ip-blacklist-pop-up", true);
    }

    public static boolean b(Activity activity) {
        try {
            return Class.forName("net.one97.paytm.auth.activity.AJRAuthActivity").isInstance(activity);
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public static boolean c(Activity activity) {
        try {
            return Class.forName("net.one97.paytm.landingpage.activity.AJRMainActivity").isInstance(activity);
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        android.widget.Toast.makeText(r7, r7.getString(net.one97.paytm.oauth.R.string.lbl_email_app_not_installed), 0).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ ActivityNotFoundException -> 0x009a }
            r1.<init>()     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x009a }
            java.lang.String r3 = "android.intent.action.SENDTO"
            java.lang.String r4 = "mailto"
            java.lang.String r5 = ""
            r6 = 0
            android.net.Uri r4 = android.net.Uri.fromParts(r4, r5, r6)     // Catch:{ ActivityNotFoundException -> 0x009a }
            r2.<init>(r3, r4)     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch:{ ActivityNotFoundException -> 0x009a }
            java.util.List r2 = r3.queryIntentActivities(r2, r0)     // Catch:{ ActivityNotFoundException -> 0x009a }
            boolean r4 = r2.isEmpty()     // Catch:{ ActivityNotFoundException -> 0x009a }
            if (r4 != 0) goto L_0x008c
            java.util.Iterator r2 = r2.iterator()     // Catch:{ ActivityNotFoundException -> 0x009a }
        L_0x0028:
            boolean r4 = r2.hasNext()     // Catch:{ ActivityNotFoundException -> 0x009a }
            if (r4 == 0) goto L_0x0049
            java.lang.Object r4 = r2.next()     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.content.pm.ActivityInfo r4 = r4.activityInfo     // Catch:{ ActivityNotFoundException -> 0x009a }
            java.lang.String r4 = r4.packageName     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.content.Intent r4 = r3.getLaunchIntentForPackage(r4)     // Catch:{ NullPointerException -> 0x0040 }
            r1.add(r4)     // Catch:{ NullPointerException -> 0x0040 }
            goto L_0x0028
        L_0x0040:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()     // Catch:{ ActivityNotFoundException -> 0x009a }
            com.paytm.utility.q.b(r4)     // Catch:{ ActivityNotFoundException -> 0x009a }
            goto L_0x0028
        L_0x0049:
            java.util.Collections.reverse(r1)     // Catch:{ ActivityNotFoundException -> 0x009a }
            int r2 = r1.size()     // Catch:{ ActivityNotFoundException -> 0x009a }
            r3 = 1
            if (r2 != r3) goto L_0x0063
            java.lang.Object r8 = r1.get(r0)     // Catch:{ ActivityNotFoundException -> 0x009a }
            if (r8 == 0) goto L_0x0099
            java.lang.Object r8 = r1.get(r0)     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.content.Intent r8 = (android.content.Intent) r8     // Catch:{ ActivityNotFoundException -> 0x009a }
            r7.startActivity(r8)     // Catch:{ ActivityNotFoundException -> 0x009a }
            return
        L_0x0063:
            java.lang.Object r2 = r1.remove(r0)     // Catch:{ NullPointerException -> 0x007e }
            android.content.Intent r2 = (android.content.Intent) r2     // Catch:{ NullPointerException -> 0x007e }
            android.content.Intent r8 = android.content.Intent.createChooser(r2, r8)     // Catch:{ NullPointerException -> 0x007e }
            java.lang.String r2 = "android.intent.extra.INITIAL_INTENTS"
            android.os.Parcelable[] r3 = new android.os.Parcelable[r0]     // Catch:{ NullPointerException -> 0x007e }
            java.lang.Object[] r1 = r1.toArray(r3)     // Catch:{ NullPointerException -> 0x007e }
            android.os.Parcelable[] r1 = (android.os.Parcelable[]) r1     // Catch:{ NullPointerException -> 0x007e }
            r8.putExtra(r2, r1)     // Catch:{ NullPointerException -> 0x007e }
            r7.startActivity(r8)     // Catch:{ NullPointerException -> 0x007e }
            return
        L_0x007e:
            int r8 = net.one97.paytm.oauth.R.string.lbl_email_app_not_installed     // Catch:{ ActivityNotFoundException -> 0x009a }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r8, r0)     // Catch:{ ActivityNotFoundException -> 0x009a }
            r8.show()     // Catch:{ ActivityNotFoundException -> 0x009a }
            return
        L_0x008c:
            int r8 = net.one97.paytm.oauth.R.string.lbl_email_app_not_installed     // Catch:{ ActivityNotFoundException -> 0x009a }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ ActivityNotFoundException -> 0x009a }
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r8, r0)     // Catch:{ ActivityNotFoundException -> 0x009a }
            r8.show()     // Catch:{ ActivityNotFoundException -> 0x009a }
        L_0x0099:
            return
        L_0x009a:
            int r8 = net.one97.paytm.oauth.R.string.lbl_email_app_not_installed
            java.lang.String r8 = r7.getString(r8)
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r8, r0)
            r7.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.utils.OAuthUtils.a(android.content.Context, java.lang.String):void");
    }

    public static void a(Activity activity, Fragment fragment, boolean z) {
        String str;
        HintRequest.a aVar = new HintRequest.a();
        if (z) {
            aVar.f8156b = true;
        } else {
            aVar.f8155a = true;
        }
        com.google.android.gms.auth.api.credentials.b bVar = new com.google.android.gms.auth.api.credentials.b(activity, c.f8164e);
        if (aVar.f8157c == null) {
            aVar.f8157c = new String[0];
        }
        if (aVar.f8155a || aVar.f8156b || aVar.f8157c.length != 0) {
            HintRequest hintRequest = new HintRequest(aVar, (byte) 0);
            Context applicationContext = bVar.getApplicationContext();
            a.C0117a aVar2 = (a.C0117a) bVar.getApiOptions();
            String str2 = ((a.C0117a) bVar.getApiOptions()).f8082d;
            s.a(applicationContext, (Object) "context must not be null");
            s.a(hintRequest, (Object) "request must not be null");
            String str3 = aVar2 == null ? null : aVar2.f8080b;
            if (TextUtils.isEmpty(str2)) {
                str = com.google.android.gms.internal.p000authapi.a.a();
            } else {
                str = (String) s.a(str2);
            }
            Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", str3);
            putExtra.putExtra("logSessionId", str);
            Parcel obtain = Parcel.obtain();
            hintRequest.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            putExtra.putExtra("com.google.android.gms.credentials.HintRequest", marshall);
            PendingIntent activity2 = PendingIntent.getActivity(applicationContext, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY, putExtra, 134217728);
            if (activity2 != null && activity2.getIntentSender() != null) {
                if (fragment != null) {
                    try {
                        fragment.startIntentSenderForResult(activity2.getIntentSender(), 1094, (Intent) null, 0, 0, 0, (Bundle) null);
                    } catch (IntentSender.SendIntentException e2) {
                        q.b(e2.getMessage());
                    } catch (ActivityNotFoundException e3) {
                        q.b(e3.getMessage());
                    }
                } else {
                    activity.startIntentSenderForResult(activity2.getIntentSender(), 1094, (Intent) null, 0, 0, 0);
                }
            }
        } else {
            throw new IllegalStateException("At least one authentication method must be specified");
        }
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public static void b(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public static String f(String str) {
        try {
            if (str.length() > 16) {
                return str.substring(0, 4) + "  " + str.substring(4, 8) + "  " + str.substring(8, 12) + "  " + str.substring(12, 16) + "  " + str.substring(16);
            } else if (str.length() > 12) {
                return str.substring(0, 4) + "  " + str.substring(4, 8) + "  " + str.substring(8, 12) + "  " + str.substring(12);
            } else {
                return str.substring(0, 4) + "  " + str.substring(4, 8) + "  " + str.substring(8);
            }
        } catch (IndexOutOfBoundsException e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    public static void a(j jVar, View.OnClickListener onClickListener) {
        bh.a aVar = bh.f56434a;
        k.c(onClickListener, "listener");
        bh bhVar = new bh(onClickListener);
        bhVar.setCancelable(false);
        androidx.fragment.app.q a2 = jVar.a();
        a2.a((Fragment) bhVar, bh.class.getName());
        a2.c();
    }

    public static List<SubscriptionInfo> a() {
        Context applicationContext = OauthModule.b().getApplicationContext();
        List<SubscriptionInfo> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 22) {
            int a2 = androidx.core.content.b.a(applicationContext, "android.permission.READ_PHONE_STATE");
            if (Build.VERSION.SDK_INT >= 23 && a2 != 0) {
                return arrayList;
            }
            arrayList = ((SubscriptionManager) applicationContext.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
        }
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public static String a(List<SubscriptionInfo> list, Context context) {
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 22) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2).getIccId());
                if (i2 < list.size() - 1) {
                    sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                }
            }
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
            sb.append(telephonyManager.getSimSerialNumber() != null ? telephonyManager.getSimSerialNumber() : "");
        }
        return sb.toString();
    }

    public static boolean a(Context context) {
        net.one97.paytm.oauth.a.a();
        return b(context, net.one97.paytm.oauth.a.a("deviceBindingVersionName")) && !OauthModule.a().f52579f;
    }

    public static boolean b(Context context, String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList(Arrays.asList(com.paytm.utility.b.Q(context).trim().split("\\.")));
            ArrayList arrayList2 = new ArrayList(Arrays.asList(str.trim().split("\\.")));
            if (arrayList.size() < 3) {
                arrayList.add("0");
            }
            if (arrayList2.size() < 3) {
                arrayList2.add("0");
            }
            if (Integer.parseInt((String) arrayList.get(0)) <= Integer.parseInt((String) arrayList2.get(0))) {
                if (Integer.parseInt((String) arrayList.get(0)) != Integer.parseInt((String) arrayList2.get(0))) {
                    return false;
                }
                if (Integer.parseInt((String) arrayList.get(1)) <= Integer.parseInt((String) arrayList2.get(1))) {
                    if (Integer.parseInt((String) arrayList.get(1)) != Integer.parseInt((String) arrayList2.get(1))) {
                        return false;
                    }
                    String str2 = (String) arrayList.get(2);
                    String str3 = (String) arrayList2.get(2);
                    if (str2.length() > 2) {
                        str2 = str2.substring(0, 2);
                        str3 = str3 + "0";
                    } else if (str2.length() > 1) {
                        str3 = str3 + "0";
                    }
                    if (Integer.parseInt(str2) < Integer.parseInt(str3)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String g(String str) {
        TelcoIcons telcoIcons;
        try {
            f fVar = new f();
            net.one97.paytm.oauth.a.a();
            telcoIcons = ((OperatorIconsModel) fVar.a(net.one97.paytm.oauth.a.a("operator_icons_mapping"), OperatorIconsModel.class)).getTelcoIcons();
        } catch (v e2) {
            q.b(e2.getMessage());
            telcoIcons = null;
        }
        if (telcoIcons == null) {
            return "";
        }
        if (str.contains("airtel")) {
            return telcoIcons.getAirtel();
        }
        if (str.contains("vodafone")) {
            return telcoIcons.getVodafone();
        }
        if (str.contains("jio")) {
            return telcoIcons.getJio();
        }
        if (str.contains("idea")) {
            return telcoIcons.getIdea();
        }
        if (str.contains("mtnl")) {
            return telcoIcons.getMtnl();
        }
        if (str.contains("bsnl")) {
            return telcoIcons.getBsnl();
        }
        if (str.contains("rcom")) {
            return telcoIcons.getRcom();
        }
        return "";
    }

    public static int a(String str, List<SubscriptionInfo> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str.equalsIgnoreCase(list.get(i2).getIccId())) {
                return i2;
            }
        }
        return 0;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String replaceAll = str.replaceAll("\\s", "");
        if (replaceAll.length() >= 10) {
            return replaceAll.substring(replaceAll.length() - 10);
        }
        return str.replace("+91", "");
    }

    public static void a(String str, Context context) {
        net.one97.paytm.oauth.d.a aVar = new net.one97.paytm.oauth.d.a(context);
        aVar.setCancelable(false);
        aVar.setTitle(context.getString(R.string.lbl_account_blocked));
        aVar.a(str);
        aVar.a(-2, (CharSequence) context.getString(R.string.lbl_need_help), (View.OnClickListener) new View.OnClickListener(context, aVar) {
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ net.one97.paytm.oauth.d.a f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                OAuthUtils.a(this.f$0, this.f$1, view);
            }
        });
        aVar.a(-1, (CharSequence) context.getString(R.string.ok), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.oauth.d.a.this.dismiss();
            }
        });
        aVar.show();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, net.one97.paytm.oauth.d.a aVar, View view) {
        OauthModule.b().checkDeepLinking(context, "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
        aVar.dismiss();
    }

    public static String b(String str, String str2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePublic);
        return new String(Base64.encode(instance.doFinal(str2.getBytes()), 0));
    }

    public static void a(j jVar, Bundle bundle) {
        i.a aVar = i.f56596a;
        k.c(bundle, "bundle");
        i iVar = new i();
        iVar.setArguments(bundle);
        androidx.fragment.app.q a2 = jVar.a();
        a2.a((Fragment) iVar, i.class.getName());
        a2.c();
    }

    public static void a(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(R.string.some_went_wrong);
        }
        net.one97.paytm.oauth.d.a.a((Context) activity, str, (View.OnClickListener) null);
    }

    public static boolean b() {
        q qVar = q.f56798a;
        if ("device_binding".equalsIgnoreCase(q.A())) {
            return true;
        }
        q qVar2 = q.f56798a;
        return "device_binding_otp".equalsIgnoreCase(q.A());
    }

    public static List<String> c() {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthDebSenderIdAutoReadOtp");
        ArrayList arrayList = new ArrayList(Arrays.asList(a2.substring(1, a2.length() - 1).trim().split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA)));
        q.d(String.valueOf(arrayList.size()));
        return arrayList;
    }
}
