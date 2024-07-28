package net.one97.paytm.p2b.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gson.f;
import com.paytm.network.h;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList;
import net.one97.paytm.p2b.R;
import net.one97.paytm.upi.util.UpiUtils;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static int f12722a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static String f12723b = "##,##,##,##,###";

    /* renamed from: c  reason: collision with root package name */
    private static String f12724c = "##,##,##,##,###.";

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

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.trim().length() >= 6 && str.trim().length() <= 18;
    }

    public static void a(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static void a(final EditText editText, final Activity activity) {
        editText.postDelayed(new Runnable() {
            public final void run() {
                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                    if (inputMethodManager != null && !inputMethodManager.isActive()) {
                        inputMethodManager.showSoftInput(editText, 1);
                    }
                } catch (Exception unused) {
                }
            }
        }, 200);
    }

    public static double a(double d2, double d3) {
        try {
            double a2 = (a(d3, 0) * d2) / 100.0d;
            double a3 = a(a2, 2);
            StringBuilder sb = new StringBuilder("Entered Amount : ");
            sb.append(d2);
            sb.append(" ,Commission :");
            sb.append(a2);
            sb.append(" ,After round : ");
            sb.append(a3);
            b.j();
            return a3;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private static double a(double d2, int i2) {
        if (i2 < 0) {
            return d2;
        }
        return new BigDecimal(d2).setScale(i2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double b(double d2, double d3) {
        double d4 = d3 + d2;
        try {
            double a2 = a(d4, 2);
            StringBuilder sb = new StringBuilder("Entered Amount : ");
            sb.append(d2);
            sb.append(" ,Total amt :");
            sb.append(d4);
            sb.append(" ,After round : ");
            sb.append(a2);
            b.j();
            return a2;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static String a(double d2) {
        try {
            Double valueOf = Double.valueOf(d2);
            if (a(valueOf).indexOf(AppUtility.CENTER_DOT) > 0) {
                if (valueOf.doubleValue() >= 1.0d || valueOf.doubleValue() <= 0.0d) {
                    return b(valueOf);
                }
                return "0" + b(valueOf);
            } else if (valueOf.doubleValue() >= 1.0d || valueOf.doubleValue() <= 0.0d) {
                return a(valueOf);
            } else {
                return "0" + a(valueOf);
            }
        } catch (Exception unused) {
            return "0";
        }
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    private static String a(Double d2) {
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
    }

    private static String b(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    public static int b(Context context) {
        return (int) ((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 150.0f);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return c(str, str2);
    }

    private static String c(String str, String str2) {
        String format;
        String replaceAll = str.replaceAll("[" + str2 + ", ]", "").trim().replaceAll("^\\s+", "");
        try {
            if (TextUtils.isEmpty(replaceAll)) {
                return "";
            }
            if (!replaceAll.contains(AppUtility.CENTER_DOT) || !e(replaceAll)) {
                return new DecimalFormat(str2 + f12723b, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            }
            if (replaceAll.equals(AppUtility.CENTER_DOT)) {
                format = str2 + AppUtility.CENTER_DOT;
            } else {
                format = new DecimalFormat(str2 + f12724c + f(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            }
            return format;
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    private static boolean e(String str) {
        try {
            double parseDouble = Double.parseDouble(str);
            return Math.floor(parseDouble) != parseDouble;
        } catch (Exception unused) {
            return true;
        }
    }

    private static String f(String str) {
        int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
        String str2 = "";
        if (length == 0) {
            return str2 + "00";
        }
        int i2 = 0;
        while (i2 < length && i2 < f12722a) {
            str2 = str2 + "0";
            i2++;
        }
        return str2;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (String str2 : str.split(" ")) {
            if (!str2.isEmpty()) {
                sb.append(Character.toUpperCase(str2.charAt(0)));
                sb.append(str2.substring(1).toLowerCase());
            }
            if (sb.length() != str.length()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String a(String str, int i2) {
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append("X");
            i3++;
            if (i3 == 2) {
                sb.append(" ");
                i3 = 0;
            }
        }
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        return f.a(str);
    }

    public static String a(String str, String str2, String str3) {
        String a2 = !TextUtils.isEmpty(str3) ? a(str3, 4) : "";
        if (d(str2)) {
            return a2;
        }
        return str2 + " " + str + a2;
    }

    public static boolean d(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    public static String b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                double parseDouble = Double.parseDouble(str);
                double parseDouble2 = Double.parseDouble(str2);
                if (parseDouble >= 0.0d) {
                    double d2 = parseDouble2 - parseDouble;
                    if (d2 >= 0.0d) {
                        return Double.toString(Math.ceil(d2));
                    }
                }
            }
        } catch (Exception unused) {
            boolean z = b.v;
        }
        return str2;
    }

    public static void a(Activity activity, String str, String str2) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    if (str == null) {
                        str = "";
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    h hVar = new h(activity);
                    hVar.setTitle(str);
                    hVar.f42948a.setText(str2);
                    hVar.setCancelable(true);
                    if (!activity.isFinishing()) {
                        hVar.show();
                    }
                }
            } catch (Exception unused) {
                boolean z = b.v;
            }
        }
    }

    public static void a(Context context, ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("ICIC")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.p2b_icici_bank_logo));
        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.p2b_ic_bhim));
        } else if (!TextUtils.isEmpty(str)) {
            w.a().a(h.b().b(context.getApplicationContext(), str)).a(R.drawable.p2b_ic_default_bank).b(R.drawable.p2b_ic_default_bank).a(imageView, (e) null);
        }
    }

    public static void a(final Activity activity, Handler handler) {
        if (activity != null) {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    k.a(activity);
                }
            }, c.af);
        }
    }

    public static void a(Activity activity, NetworkCustomError networkCustomError, String str) {
        if (activity != null) {
            try {
                if (!activity.isFinishing() && networkCustomError != null) {
                    if (networkCustomError.getMessage() != null && (networkCustomError.getMessage().equals(UpiUtils.AUTHENTICATION_FAILURE_401) || networkCustomError.getMessage().equals("410") || networkCustomError.getMessage().equals("403"))) {
                        h.b().a(activity, str, true);
                    } else if (networkCustomError != null && (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403)) {
                        h.b().a(activity, str, true);
                    } else if (networkCustomError.networkResponse != null && (networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 410)) {
                    } else {
                        if (networkCustomError.getMessage() != null) {
                            if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equals("parsing_error")) {
                                b.b((Context) activity, activity.getResources().getString(R.string.network_error_heading), activity.getResources().getString(R.string.network_error_message));
                                return;
                            }
                            String url = networkCustomError.getUrl();
                            StringBuilder sb = new StringBuilder();
                            sb.append(networkCustomError.networkResponse.statusCode);
                            b.d((Context) activity, url, sb.toString());
                        } else if (networkCustomError.getAlertMessage() != null) {
                            b.a((Context) activity, networkCustomError.getAlertMessage(), true);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static Uri a(Context context, Bitmap bitmap) throws IOException {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(externalFilesDir, context.getString(R.string.title) + ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
        fileOutputStream.close();
        return FileProvider.getUriForFile(context, h.b().p() + ".provider", file);
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
        } catch (Exception | NumberFormatException unused) {
            return "";
        }
    }

    public static <T> T a(String str, Class<T> cls) {
        return new f().a(str, cls);
    }
}
