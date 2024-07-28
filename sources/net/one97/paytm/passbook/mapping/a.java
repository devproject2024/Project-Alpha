package net.one97.paytm.passbook.mapping;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.b;
import com.paytm.utility.n;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;

public final class a extends b {
    @Deprecated
    public static String v() {
        e.a();
        if (TextUtils.isEmpty(e.f())) {
            return "Paytm Wallet";
        }
        e.a();
        return e.f();
    }

    public static void a(e eVar, Context context, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(context, eVar, onCancelListener) {
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ e f$1;
            private final /* synthetic */ DialogInterface.OnCancelListener f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                a.a(this.f$0, this.f$1, this.f$2, dialogInterface, i2);
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, e eVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (com.paytm.utility.a.m(context)) {
            context.getApplicationContext();
            c.a();
            c.b(eVar);
            return;
        }
        a(eVar, context, onCancelListener);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        if (!TextUtils.isEmpty(str3)) {
            builder.setPositiveButton(str3, onClickListener);
        }
        if (!TextUtils.isEmpty(str4)) {
            builder.setNegativeButton(str4, onClickListener2);
        }
        builder.setCancelable(z);
        builder.show();
    }

    public static String c(Double d2) {
        if (e(d2).indexOf(AppUtility.CENTER_DOT) > 0) {
            if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
                return d(d2);
            }
            return "0" + d(d2);
        } else if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
            return e(d2);
        } else {
            return "0" + e(d2);
        }
    }

    private static String d(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    private static String e(Double d2) {
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
    }

    public static String Z(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyy", Locale.US).parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        return new SimpleDateFormat("dd MMM yyyy", Locale.US).format(date);
    }

    public static long j(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2).parse(str).getTime();
    }

    public static String a(long j, String str) {
        return new SimpleDateFormat(str).format(Long.valueOf(j));
    }

    public static String k(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
        }
        instance.add(5, 30);
        return new SimpleDateFormat(str2).format(instance.getTime());
    }

    public static String l(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            Date parse = simpleDateFormat.parse(str);
            if (parse.compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis())))) > 0) {
                return simpleDateFormat.format(simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))));
            }
            return simpleDateFormat.format(parse);
        } catch (ParseException unused) {
            return str;
        }
    }

    public static int k(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3);
        try {
            return simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(str2));
        } catch (ParseException unused) {
            return -1;
        }
    }

    public static int c(Date date, Date date2) {
        if (date == null || date2 == null) {
            return 0;
        }
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }

    public static String l(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, new Locale(n.a())).parse(str));
        } catch (Exception | ParseException unused) {
            return "";
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        try {
            Locale locale = new Locale(n.a());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, locale);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str4);
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(str3 + ", " + str4);
            Calendar instance = Calendar.getInstance(locale);
            Calendar instance2 = Calendar.getInstance(locale);
            instance2.setTimeInMillis(parse.getTime());
            if (Math.abs(instance2.get(6) - instance.get(6)) >= 2) {
                return simpleDateFormat3.format(parse);
            }
            return DateUtils.getRelativeTimeSpanString(instance2.getTimeInMillis(), instance.getTimeInMillis(), 86400000, 2).toString() + ", " + simpleDateFormat2.format(parse);
        } catch (Exception | ParseException unused) {
            return "";
        }
    }
}
