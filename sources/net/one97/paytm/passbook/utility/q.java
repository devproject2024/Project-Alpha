package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.google.gsonhtcfix.f;
import com.paytm.utility.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;

public final class q {
    public static void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3) {
        if (str != null && context != null) {
            d.b().a(context, str, str2, arrayList, str3, "passbook");
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        d.b().b(context, str, str2, str3, str4, str5, str6);
        com.paytm.utility.q.b("EVENT LOGGED - category = " + str + ", action = " + str2 + ", label = " + str3 + ", label2 = " + str4 + ", value = " + null + ", screenName = " + str5 + ", verticalId = " + str6);
    }

    public static String a(double d2) {
        return b.a(d2, d2 - Math.floor(d2) != 0.0d ? "##,##,##,##,##0.00" : "##,##,##,##,##0.##");
    }

    public static String a() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        int length = replace.length();
        if (length >= 32) {
            replace = replace.substring(0, 32);
        } else {
            int i2 = 32 - length;
            for (int i3 = 1; i3 <= i2; i3++) {
                replace = replace + (i3 + 97);
            }
        }
        return "PTM".concat(String.valueOf(replace));
    }

    public static String a(String str, String str2, String str3) {
        try {
            Date parse = new SimpleDateFormat(str, Locale.ENGLISH).parse(str3);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(parse.getTime());
            instance.add(1, 10);
            return new SimpleDateFormat(str2).format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static <T> T a(Object obj, Class<T> cls) {
        f fVar = new f();
        return fVar.a(fVar.a(obj), cls);
    }

    public static String b(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            return new SimpleDateFormat(str3).format(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }

    public static int a(int i2) {
        if (i2 == n.PAYTM_WALLET.getValue()) {
            return R.drawable.pb_paytm_wallet_sub_new;
        }
        if (i2 == n.GIFT_VOUCHER.getValue()) {
            return R.drawable.pb_gift_voucher_new;
        }
        if (i2 == n.FOOD_WALLET.getValue()) {
            return R.drawable.pb_food_wallet_new;
        }
        if (i2 == n.GIFT_CARDS.getValue()) {
            return R.drawable.pb_gift_wallet_new;
        }
        if (i2 == n.TOLL.getValue()) {
            return R.drawable.pb_paytm_fastag_new;
        }
        if (i2 == n.SAVINGS_ACCOUNT.getValue() || i2 == n.ICA_CURRENT_ACCOUNT.getValue()) {
            return R.drawable.pass_ic_ppb;
        }
        if (i2 == n.PAYTM_POSTPAID.getValue()) {
            return R.drawable.pb_paytm_postpaid_new;
        }
        if (i2 == n.FIXED_DEPOSIT.getValue() || i2 == n.ICA_FIXED_DEPOSIT.getValue()) {
            return R.drawable.pb_fb_new;
        }
        if (i2 == n.REMITTANCE.getValue()) {
            return R.drawable.pass_remittance_subwallet;
        }
        if (i2 == n.ALLOWALANCE_WALLET.getValue()) {
            return R.drawable.pb_allowance_wallet_new;
        }
        if (i2 == n.FUEL_WALLET.getValue()) {
            return R.drawable.pb_fuel_wallet_new;
        }
        if (i2 == n.LOYALTY_WALLET.getValue()) {
            return R.drawable.pass_ic_loyalty;
        }
        if (i2 == n.UPI.getValue()) {
            return R.drawable.pass_bhim_icon;
        }
        if (i2 == n.DIGITAL_CREDIT.getValue()) {
            return R.drawable.pass_ic_digital_credit;
        }
        if (i2 == n.MERCHANT_PAYMENTS.getValue()) {
            return R.drawable.pass_ic_merchant;
        }
        if (i2 == n.COMMUNICATION_WALLET.getValue()) {
            return R.drawable.pb_communication_wallet_new;
        }
        if (i2 == n.DIGITAL_GOLD.getValue()) {
            return R.drawable.pb_paytm_gold_new;
        }
        if (i2 == n.PAYTM_MONEY.getValue()) {
            return R.drawable.pass_paytm_money_svg;
        }
        if (i2 == n.CREDIT_CARD.getValue()) {
            return R.drawable.pass_ic_digital_credit;
        }
        if (i2 == n.PAYTM_COINS.getValue()) {
            return R.drawable.pass_ic_paytm_coins;
        }
        return R.drawable.pass_default_subwallet;
    }

    public static Uri a(Context context, Bitmap bitmap) throws IOException {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(externalFilesDir, context.getString(R.string.title) + ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
        fileOutputStream.close();
        return FileProvider.getUriForFile(context, d.b().B() + ".provider", file);
    }
}
