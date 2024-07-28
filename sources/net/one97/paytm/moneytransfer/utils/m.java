package net.one97.paytm.moneytransfer.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytm.b.a.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.g;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransfer.view.fragments.n;
import net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity;
import net.one97.paytm.moneytransferv4.invite.InviteContactActivity;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static int[] f54177a = {R.color.color_2cce86, R.color.color_6c7cff, R.color.color_ffa400, R.color.color_b069ec, R.color.color_40cdd8, R.color.color_fd5c7f, R.color.color_f2c110, R.color.color_f36bb4, R.color.color_3ab6f4, R.color.color_a6b7be};

    /* renamed from: b  reason: collision with root package name */
    private static int[] f54178b = {Color.parseColor("#2cce86"), Color.parseColor("#6c7cff"), Color.parseColor("#ffa400"), Color.parseColor("#b069ec"), Color.parseColor("#40cdd8"), Color.parseColor("#fd5c7f"), Color.parseColor("#f2c110"), Color.parseColor("#f36bb4"), Color.parseColor("#3ab6f4"), Color.parseColor("#a6b7be")};

    public static String a() {
        return "Use Paytm UPI for Instant Money Transfers at 0% fee.";
    }

    public static boolean a(int i2) {
        return i2 == 401 || i2 == 403 || i2 == 410;
    }

    public static boolean b() {
        return false;
    }

    public static boolean a(String str, double d2, double d3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            double parseDouble = Double.parseDouble(str);
            if (d3 <= 0.0d) {
                return true;
            }
            return parseDouble >= d2 && parseDouble <= d3;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                return String.valueOf(trim.toUpperCase().charAt(0));
            }
            return null;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.trim().length() >= 6 && str.trim().length() <= 50 && str.trim().replaceAll("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789]", "").length() == 0;
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.trim().replaceAll("[^\\d+]", "").replaceAll(" ", "");
        }
        return "";
    }

    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        int i2 = 0;
        String replaceAll = str.trim().replaceAll("[^\\d+]", "");
        if (replaceAll.startsWith(context.getString(R.string.mobile_number_prefix_91))) {
            i2 = 3;
        } else if (replaceAll.startsWith(context.getString(R.string.mobile_number_prefix_91_without_plus))) {
            i2 = 2;
        } else if (replaceAll.startsWith(context.getString(R.string.mobile_number_prefix_0))) {
            i2 = 1;
        }
        return replaceAll.substring(i2, replaceAll.length()).trim().replaceAll(" ", "");
    }

    public static Dialog a(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.lyt_progress_bar);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && Character.isLetter(str.charAt(0));
    }

    public static void a(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            UpiAppUtils.hideKeyboard(fragmentActivity);
            fragmentActivity.getSupportFragmentManager().d();
        }
    }

    public static void a(Bundle bundle, j jVar, int i2) {
        a(bundle, jVar, i2, true);
    }

    public static void a(Bundle bundle, j jVar, int i2, boolean z) {
        q a2 = jVar.a();
        if (z) {
            a2.a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out);
        }
        n.a aVar = n.f54547c;
        a2.a(i2, n.a.a(bundle), n.class.getSimpleName()).a(n.class.getSimpleName());
        a2.c();
    }

    public static String f(String str) {
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

    public static void a(int i2, Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(i2);
            }
        }
    }

    public static String g(String str) {
        return str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return str + "   XX " + str2.substring(str2.length() - 4);
    }

    public static void a(Context context) {
        a a2 = l.a(context.getApplicationContext());
        a2.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN, true);
        a2.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN_CREATION_TIME, true);
    }

    public static void a(ImageView imageView, String str, Context context) {
        if (!TextUtils.isEmpty(str) && str.contains("ICIC")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.icici_bank_logo));
        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_bhim));
        } else if (URLUtil.isValidUrl(str)) {
            w.a().a(str).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        } else if (!TextUtils.isEmpty(str)) {
            w.a().a(UpiRequestBuilder.getBankIconUrl(context.getApplicationContext(), str)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Double.parseDouble(str) > 0.0d) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
        }
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
                m.b(this.f$0, this.f$1);
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Activity activity, EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
                activity.getWindow().setSoftInputMode(20);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(EditText editText, Activity activity) {
        editText.requestFocus();
        editText.postDelayed(new Runnable(activity, editText) {
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ EditText f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                m.a(this.f$0, this.f$1);
            }
        }, 350);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
                activity.getWindow().setSoftInputMode(20);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(EditText editText) {
        editText.requestFocus();
    }

    public static boolean b(Context context) {
        return l.a(context.getApplicationContext()).b("is_upi_user", false, true);
    }

    public static boolean c(Context context) {
        return l.a(context.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_BANK_ACCOUNT_ADDED, false, true);
    }

    public static boolean d(Context context) {
        return l.a(context.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true);
    }

    public static String i(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (i2 < str.length() - 1) {
                char charAt = str.charAt(i2);
                char charAt2 = str.charAt(i2 + 1);
                if (charAt != '%' || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt);
                } else {
                    sb.append(" ");
                }
            } else {
                sb.append(str.charAt(i2));
            }
        }
        return sb.toString();
    }

    public static void b(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            net.one97.paytm.moneytransfer.d.a c2 = d.c();
            new NetworkCustomError();
            c2.a(activity, (String) null, true);
        }
    }

    public static void c(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            net.one97.paytm.moneytransfer.d.a c2 = d.c();
            new NetworkCustomError();
            c2.a(activity, (String) null, false);
        }
    }

    public static void d(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            b.b((Context) activity, "No Internet Connection", "We can not detect any internet connectivity. Please check your internet connection and try again.");
        }
    }

    public static void e(Context context) {
        SQLiteDatabase sQLiteDatabase;
        a aVar;
        Context applicationContext;
        new j();
        net.one97.paytm.upi.database.a a2 = net.one97.paytm.upi.database.a.a(context);
        if (!a2.b()) {
            sQLiteDatabase = a2.a();
        } else {
            sQLiteDatabase = a2.f66667a;
        }
        sQLiteDatabase.execSQL("delete from mt_saved_beneficiaries");
        g.a aVar2 = g.f54162a;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            aVar = null;
        } else {
            l.a aVar3 = l.f54175a;
            aVar = l.a.a(applicationContext);
        }
        if (aVar != null) {
            aVar.a("selected_account_ifsc", false);
        }
        if (aVar != null) {
            aVar.a("selected_account_number", false);
        }
    }

    public static void a(Activity activity, String str, String str2) {
        if (activity != null && !activity.isFinishing()) {
            ((ClipboardManager) activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
        }
    }

    public static UpiProfileDefaultBank a(Context context, PPBCurrentAccountModel pPBCurrentAccountModel) {
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
        bankAccount.setAccount(pPBCurrentAccountModel.getIca().getAccountNumber());
        bankAccount.setIfsc(pPBCurrentAccountModel.getIca().getIfscCode());
        bankAccount.setBankName(context.getString(R.string.money_tranfer_balance_paytm_bank_string));
        bankAccount.setMbeba("Y");
        bankAccount.setAccountType("CURRENT");
        upiProfileDefaultBank.setPaymentMode(UpiProfileDefaultBank.PAYMENT_MODE.IMPS);
        upiProfileDefaultBank.setDebitBank(bankAccount);
        return upiProfileDefaultBank;
    }

    public static void f(Context context) {
        MediaPlayer create = MediaPlayer.create(context, R.raw.payment_success);
        if (!create.isPlaying()) {
            create.start();
        }
        create.setOnCompletionListener($$Lambda$E7FaxYylohOwFmBzAjza06XyF8.INSTANCE);
    }

    public static long j(String str) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(str).getTime();
    }

    public static void a(ImageView imageView, int i2) {
        if (imageView != null) {
            androidx.core.widget.e.a(imageView, ColorStateList.valueOf(i2));
        }
    }

    public static int[] c() {
        return f54178b;
    }

    public static String k(String str) {
        return new DecimalFormat("0.##").format(Double.parseDouble(str));
    }

    public static void a(int i2, Fragment fragment, String str, j jVar) {
        if (jVar != null) {
            jVar.a().a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out).a(i2, fragment).a(str).b();
        }
    }

    public static void a(int i2, Fragment fragment, j jVar) {
        if (jVar != null) {
            jVar.a().a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out).a(i2, fragment).b();
        }
    }

    public static String a(BeneficiaryEntity beneficiaryEntity) {
        if (beneficiaryEntity.instrumentPreferences.upi != null) {
            return beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.vpa;
        }
        return beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber;
    }

    public static String b(BeneficiaryEntity beneficiaryEntity) {
        if (beneficiaryEntity.instrumentPreferences.upi != null) {
            return beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.accountHolderName;
        }
        return beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountHolderName;
    }

    public static String c(BeneficiaryEntity beneficiaryEntity) {
        return beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.logoUrl;
    }

    public static String d(BeneficiaryEntity beneficiaryEntity) {
        return beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.ifscCode;
    }

    public static void e(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            i.a().m.a(activity, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000520");
        }
    }

    public static void a(Context context, int i2, IJRDataModel iJRDataModel) {
        context.startActivity(MoneyTransferV4Activity.a(context, i2, iJRDataModel));
    }

    public static void a(Activity activity, int i2, IJRDataModel iJRDataModel) {
        activity.startActivityForResult(MoneyTransferV4Activity.a(activity, i2, iJRDataModel), 2001);
    }

    public static void a(Activity activity, int i2, IJRDataModel iJRDataModel, int i3) {
        activity.startActivityForResult(MoneyTransferV4Activity.a(activity, i2, iJRDataModel), i3);
    }

    public static void a(Context context, String str, String str2) {
        context.startActivity(InviteContactActivity.a(context, str, str2));
    }

    public static String l(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str, AppConstants.UTF_8);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static void a(TextView textView, String str) {
        Context context = textView.getContext();
        if (!TextUtils.isEmpty(str)) {
            textView.setText(context.getString(R.string.upi_collect_request_pay, new Object[]{str}));
            return;
        }
        textView.setText(context.getString(R.string.upi_pay));
    }

    public static void a(TextView textView, String str, String str2) {
        try {
            Context context = textView.getContext();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                a(textView, str);
                return;
            }
            Double valueOf = Double.valueOf(Double.parseDouble(str2));
            Double valueOf2 = Double.valueOf(Double.parseDouble(UpiAppUtils.getCleanString(str)));
            if (valueOf2.doubleValue() > valueOf.doubleValue()) {
                String valueOf3 = String.valueOf(new DecimalFormat("#.##").format(valueOf2.doubleValue() - valueOf.doubleValue()));
                textView.setText(context.getString(R.string.mt_v4_add_and_pay, new Object[]{valueOf3}));
                return;
            }
            a(textView, str);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            a(textView, str);
        }
    }

    public static boolean b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            if (Double.parseDouble(UpiAppUtils.getCleanString(str)) > Double.valueOf(Double.parseDouble(str2)).doubleValue()) {
                return true;
            }
            return false;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean m(String str) {
        try {
            return !TextUtils.isEmpty(str) && 1.0d == Double.valueOf(Double.parseDouble(str)).doubleValue();
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static void b(Context context, int i2, IJRDataModel iJRDataModel) {
        context.startActivity(MoneyTransferV4Activity.b(context, i2, iJRDataModel));
    }

    public static void c(Context context, int i2, IJRDataModel iJRDataModel) {
        context.startActivity(MoneyTransferV4Activity.c(context, i2, iJRDataModel));
    }

    public static void d(Context context, int i2, IJRDataModel iJRDataModel) {
        context.startActivity(MoneyTransferV4Activity.d(context, i2, iJRDataModel));
    }

    public static void b(Activity activity, int i2, IJRDataModel iJRDataModel, int i3) {
        activity.startActivityForResult(MoneyTransferV4Activity.b(activity, i2, iJRDataModel), i3);
    }
}
