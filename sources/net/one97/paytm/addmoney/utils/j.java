package net.one97.paytm.addmoney.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.h;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.common.entity.wallet.CJRSubWallet;
import net.one97.paytm.helper.a;
import net.one97.paytm.wallet.newdesign.addmoney.c.c;
import org.json.JSONObject;

public final class j {
    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            b(activity, activity.getResources().getString(R.string.no_connection), activity.getResources().getString(R.string.no_internet));
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = h.a(context.getApplicationContext()).b("pref_key_wallet_balance", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = h.a(context.getApplicationContext()).b("pref_new_balance_wallet", "", false);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = h.a(context.getApplicationContext()).b("pref_key_voucher_balance", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static double a(CJRCashWalletResponse cJRCashWalletResponse) {
        String f2 = a.b().f("wallet_balance_list");
        if (f2 == null) {
            return cJRCashWalletResponse.getPaytmWalletBalance();
        }
        List<CJRSubWallet> subWalletDetailList = cJRCashWalletResponse.getSubWalletDetailList();
        double d2 = 0.0d;
        for (int i2 = 0; i2 < subWalletDetailList.size(); i2++) {
            CJRSubWallet cJRSubWallet = subWalletDetailList.get(i2);
            if (f2.contains(cJRSubWallet.getSubWalletName())) {
                d2 += cJRSubWallet.getBalance();
            }
        }
        return d2;
    }

    public static double b(CJRCashWalletResponse cJRCashWalletResponse) {
        List<CJRSubWallet> subWalletDetailList = cJRCashWalletResponse.getSubWalletDetailList();
        double d2 = 0.0d;
        for (int i2 = 0; i2 < subWalletDetailList.size(); i2++) {
            CJRSubWallet cJRSubWallet = subWalletDetailList.get(i2);
            if ("MAIN,GIFT_VOUCHER".contains(cJRSubWallet.getSubWalletName())) {
                d2 += cJRSubWallet.getBalance();
            }
        }
        return d2;
    }

    public static void a(Context context, double d2) {
        try {
            b(context, b.b(Double.valueOf(d2)));
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Context context, double d2) {
        try {
            d(context, b.b(Double.valueOf(d2)));
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    private static void b(Context context, String str) {
        if (context != null) {
            h.a(context.getApplicationContext()).a("pref_key_wallet_balance", str, true);
        }
    }

    private static void c(Context context, String str) {
        if (context != null) {
            h.a(context.getApplicationContext()).a("pref_new_balance_wallet_Gv", str, false);
        }
    }

    private static void d(Context context, String str) {
        if (context != null) {
            h.a(context.getApplicationContext()).a("pref_key_voucher_balance", str, true);
        }
    }

    public static Dialog b(Activity activity) {
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
                    hVar.a(str2);
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

    private static void b(Activity activity, String str, String str2) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    if (str == null) {
                        str = "";
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle(str);
                    builder.setMessage(str2);
                    builder.setPositiveButton(activity.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null);
                    builder.setCancelable(false);
                    builder.show();
                }
            } catch (Exception e2) {
                if (b.v) {
                    e2.printStackTrace();
                }
            }
        }
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

    public static double a(double d2, double d3, double d4) {
        double d5 = ((d3 + d2) * d4) / (100.0d - d4);
        try {
            double a2 = a(d5);
            StringBuilder sb = new StringBuilder("Entered Amount : ");
            sb.append(d2);
            sb.append(" ,Commission :");
            sb.append(d5);
            sb.append(" ,After round : ");
            sb.append(a2);
            b.j();
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static double a(double d2) {
        return new BigDecimal(d2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static void a(final Context context, final c cVar) {
        try {
            String f2 = a.b().f("check_user_balance_service");
            if (f2 == null) {
                return;
            }
            if (URLUtil.isValidUrl(f2)) {
                String e2 = b.e(context, f2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(context));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(context));
                b.j();
                if (b.c(context)) {
                    com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                    b2.f42880d = e2;
                    b2.f42882f = hashMap;
                    b2.f42884h = jSONObject.toString();
                    b2.f42885i = new CJRCashWallet();
                    b2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                            if (cJRCashWallet.getResponse() == null || !cJRCashWallet.getStatusMessage().equalsIgnoreCase("SUCCESS")) {
                                if (TextUtils.isEmpty(cJRCashWallet.getStatusMessage())) {
                                    context.getString(R.string.fallback_message_check_balance);
                                } else {
                                    cJRCashWallet.getStatusMessage();
                                }
                                context.getString(R.string.wallet_balance_status);
                                return;
                            }
                            j.a(context, j.a(cJRCashWallet.getResponse()));
                            j.c(context, cJRCashWallet.getResponse().getPaytmWalletBalance());
                            cVar.a();
                            j.d(context, j.b(cJRCashWallet.getResponse()));
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            context.getString(R.string.data_display_error);
                            context.getString(R.string.we_faced_an_issue_in_displaying_correct_data);
                        }
                    };
                    b2.l().a();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void c(Context context, double d2) {
        try {
            String b2 = b.b(Double.valueOf(d2));
            if (context != null) {
                h.a(context.getApplicationContext()).a("pref_new_balance_wallet", b2, false);
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(Context context, double d2) {
        try {
            c(context, b.b(Double.valueOf(d2)));
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str) {
        h.a(context.getApplicationContext()).a("kyc_state", str, true);
    }

    public static String d(Context context) {
        return h.a(context.getApplicationContext()).b("kyc_state", "", true);
    }

    public static boolean a() {
        return a.b().g("isToUseDeferedFlowForAddMoney");
    }
}
