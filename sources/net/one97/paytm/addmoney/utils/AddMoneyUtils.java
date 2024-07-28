package net.one97.paytm.addmoney.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.k;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gson.b.a;
import com.google.gson.f;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import easypay.manager.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.b;
import net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList;
import net.one97.paytm.helper.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.newaddmoney.utils.d;
import net.one97.paytm.newaddmoney.utils.e;
import net.one97.paytm.upi.util.UpiUtils;

public final class AddMoneyUtils {
    public static int a() {
        return (int) (Resources.getSystem().getDisplayMetrics().density * -6.0f);
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public static void b(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public static HashMap<String, String> a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", str3);
        hashMap.put("orderId", str4);
        hashMap.put("channelId", SDKConstants.WAP);
        if (str != null) {
            hashMap.put(PayUtility.AUTH_MODE, str);
        }
        hashMap.put("txnToken", str2);
        hashMap.put("paymentMode", str5);
        hashMap.put(PayUtility.CARD_INFO, str6);
        hashMap.put(PayUtility.STORE_INSTRUMENT, str7);
        return hashMap;
    }

    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase(SDKConstants.VISA)) {
                return R.drawable.visa_logo_addmoney;
            }
            if (str.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                return R.drawable.maestro_icon_addmoney;
            }
            if (str.equalsIgnoreCase(SDKConstants.MASTER)) {
                return R.drawable.ic_mastercard_logo_addmoney;
            }
            if (str.equalsIgnoreCase(SDKConstants.AMEX)) {
                return R.drawable.amex_addmoney;
            }
            if (str.equalsIgnoreCase("RUPAY")) {
                return R.drawable.rupay_addmoney;
            }
            if (str.equalsIgnoreCase(SDKConstants.DINERS)) {
                return R.drawable.diners_addmoney;
            }
        }
        return 0;
    }

    public static String b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return new SimpleDateFormat("dd MMM yyyy, hh:mm a").format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return new SimpleDateFormat(str2).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date parse = simpleDateFormat.parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.add(1, 10);
            return new SimpleDateFormat("dd MMM yyyy").format(instance.getTime());
        } catch (ParseException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String a(Object obj) {
        return new f().a(obj, new a<Object>() {
        }.getType());
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("client_id", b.k());
        hashMap.put("client_secret", b.l());
        hashMap.put("session_token", com.paytm.utility.a.q(context));
        hashMap.put("Authorization", b.m());
        if (b(context) != null) {
            hashMap.put("cart_id", b(context));
        }
        return hashMap;
    }

    private static String b(Context context) {
        String b2 = h.a(context.getApplicationContext()).b("cart_id", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static <T> T a(Object obj, Class<T> cls) {
        com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
        return fVar.a(fVar.a(obj), cls);
    }

    public static void a(Activity activity, NetworkCustomError networkCustomError, String str, Boolean bool) {
        a(activity, networkCustomError, str, (Bundle) null, bool, true, false);
    }

    public static void a(Activity activity, NetworkCustomError networkCustomError, String str, Bundle bundle, Boolean bool, boolean z, boolean z2) {
        if (activity != null) {
            try {
                if (!activity.isFinishing() && networkCustomError != null) {
                    if (networkCustomError.getMessage() != null && (networkCustomError.getMessage().equals(UpiUtils.AUTHENTICATION_FAILURE_401) || networkCustomError.getMessage().equals("410") || networkCustomError.getMessage().equals("403"))) {
                        net.one97.paytm.helper.a.b().a(activity, str, bundle, Boolean.valueOf(z), Boolean.valueOf(z2));
                    } else if (networkCustomError != null && (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403)) {
                        net.one97.paytm.helper.a.b().a(activity, str, bundle, Boolean.valueOf(z), Boolean.valueOf(z2));
                    } else if (networkCustomError.networkResponse == null || !(networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 410)) {
                        if (networkCustomError.getMessage() != null) {
                            c b2 = net.one97.paytm.helper.a.b();
                            bool.booleanValue();
                            if (!b2.a(activity, networkCustomError)) {
                                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equals("parsing_error")) {
                                    b.b((Context) activity, activity.getResources().getString(R.string.network_error_heading), activity.getResources().getString(R.string.network_error_message));
                                    return;
                                }
                                String url = networkCustomError.getUrl();
                                StringBuilder sb = new StringBuilder();
                                sb.append(networkCustomError.networkResponse.statusCode);
                                b.d((Context) activity, url, sb.toString());
                                return;
                            }
                        }
                        if (networkCustomError.getAlertMessage() != null && networkCustomError.getAlertTitle() != null) {
                            b.b((Context) activity, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                        }
                    } else {
                        net.one97.paytm.helper.a.b().a(activity, str, bundle, Boolean.valueOf(z), Boolean.valueOf(z2));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return b.b(str, str.contains(AppUtility.CENTER_DOT) ? "##,##,##,##,###.00" : AppConstants.PRICE_PATTERN);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static void a(TextView textView) {
        SpannableString spannableString = new SpannableString(textView.getText());
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            int spanStart = spannableString.getSpanStart(uRLSpan);
            int spanEnd = spannableString.getSpanEnd(uRLSpan);
            spannableString.removeSpan(uRLSpan);
            spannableString.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
        textView.setText(spannableString);
    }

    public static boolean a(Fragment fragment) {
        return fragment.getLifecycle().a().isAtLeast(k.b.RESUMED);
    }

    public static String e(String str) {
        try {
            return new DecimalFormat("##,###").format(Double.valueOf(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static Uri a(Context context, Bitmap bitmap) throws IOException {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(externalFilesDir, context.getString(R.string.title) + ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
        fileOutputStream.close();
        return FileProvider.getUriForFile(context, net.one97.paytm.helper.a.b().b() + ".provider", file);
    }

    static class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String str) {
            super(str);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public static String f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return str.substring(0, 2) + " XX " + str.substring(4, str.length());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static void a(EditText editText, Activity activity) {
        editText.requestFocus();
        editText.postDelayed(new Runnable(activity, editText) {
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ EditText f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                AddMoneyUtils.a(this.f$0, this.f$1);
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
                activity.getWindow().setSoftInputMode(16);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b() {
        Class[] clsArr = new Class[0];
        try {
            Class<?> cls = Class.forName("net.one97.paytm.deeplink.AddmoneyDeepLinkHandler");
            cls.getDeclaredMethod("reInitialize", clsArr).invoke(cls.newInstance(), (Object[]) null);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        } catch (InstantiationException e6) {
            e6.printStackTrace();
            e6.printStackTrace();
        }
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2144) {
            if (hashCode != 2175) {
                if (hashCode != 2484) {
                    if (hashCode != 84238) {
                        if (hashCode == 499571735 && str.equals("LOYALTY_POINT")) {
                            c2 = 4;
                        }
                    } else if (str.equals("UPI")) {
                        c2 = 3;
                    }
                } else if (str.equals("NB")) {
                    c2 = 2;
                }
            } else if (str.equals(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                c2 = 1;
            }
        } else if (str.equals(Constants.EASYPAY_PAYTYPE_CREDIT_CARD)) {
            c2 = 0;
        }
        if (c2 == 0) {
            return context.getString(R.string.credit_card);
        }
        if (c2 == 1) {
            return context.getString(R.string.debit_card);
        }
        if (c2 == 2) {
            return context.getString(R.string.net_banking);
        }
        if (c2 == 3) {
            return "UPI";
        }
        if (c2 != 4) {
            return "";
        }
        return "LOYALTY_POINT";
    }

    public static String g(String str) {
        try {
            if (e.a()) {
                return d.NO_KYC.toString();
            }
            String str2 = null;
            for (b.a aVar : b.a.values()) {
                if (str != null && str.equalsIgnoreCase(aVar.getWalletUserState())) {
                    str2 = aVar.getv2UserState();
                }
            }
            return str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2) {
        String h2 = !TextUtils.isEmpty(str2) ? h(str2) : "";
        if (i(str)) {
            return h2;
        }
        return str + " " + h2;
    }

    private static String h(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            sb.append("X");
            i2++;
            if (i2 == 2) {
                sb.append(" ");
                i2 = 0;
            }
        }
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    private static boolean i(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    public static String a(Context context, List<FeeDetailsBreakupList> list) {
        try {
            Double.valueOf(0.0d);
            Double.valueOf(0.0d);
            Double.valueOf(0.0d);
            if (context == null) {
                return "";
            }
            Double d2 = null;
            Double d3 = null;
            Double d4 = null;
            for (int i2 = 0; i2 < 2; i2++) {
                FeeDetailsBreakupList feeDetailsBreakupList = list.get(i2);
                if (i2 == 0) {
                    d3 = feeDetailsBreakupList.getSlabEndIndex();
                    d2 = feeDetailsBreakupList.getSlabFeePercentage();
                } else {
                    d4 = feeDetailsBreakupList.getSlabFeePercentage();
                }
            }
            return context.getString(R.string.p2b_slab_charge_text, new Object[]{String.valueOf(d2), String.valueOf(d3), String.valueOf(d4), String.valueOf(d3)});
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }
}
