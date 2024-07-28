package net.one97.paytm.paymentslimit.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.paymentslimit.activity.AJRPaymentLimitHomePageNew;
import net.one97.paytm.paymentslimit.activity.AJRPaymentLimitOTP;
import net.one97.paytm.paymentslimit.b.d;
import net.one97.paytm.paymentslimit.b.e;
import net.one97.paytm.paymentslimit.b.f;
import net.one97.paytm.paymentslimit.b.g;
import net.one97.paytm.paymentslimit.b.h;
import net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail;
import net.one97.paytm.paymentslimit.bean.CJRUpdateLimitResposne;
import net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView;
import net.one97.paytm.wallet.R;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements f, h.a<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    Context f59307a;

    /* renamed from: b  reason: collision with root package name */
    public int f59308b;

    /* renamed from: c  reason: collision with root package name */
    private AppCompatActivity f59309c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, EditText> f59310d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressDialog f59311e;

    /* renamed from: f  reason: collision with root package name */
    private String f59312f;

    /* renamed from: g  reason: collision with root package name */
    private CJRPaymentLimitDetail f59313g;

    public final /* synthetic */ void a(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        d();
        if (iJRPaytmDataModel instanceof CJRUpdateLimitResposne) {
            CJRUpdateLimitResposne cJRUpdateLimitResposne = (CJRUpdateLimitResposne) iJRPaytmDataModel;
            if ("OTP_1015".equalsIgnoreCase(cJRUpdateLimitResposne.statusCode)) {
                Intent intent = new Intent(this.f59307a, AJRPaymentLimitOTP.class);
                intent.putExtra("otpState", cJRUpdateLimitResposne.otpState);
                this.f59309c.startActivityForResult(intent, 0);
            } else {
                d.a((Context) (Activity) this.f59307a, (String) null, cJRUpdateLimitResposne.statusMessage);
            }
        }
        if (iJRPaytmDataModel instanceof CJRPaymentLimitDetail) {
            this.f59313g = (CJRPaymentLimitDetail) iJRPaytmDataModel;
            if (this.f59313g.userLimitConfig == null) {
                return;
            }
            if (!v.a(d.ao(this.f59307a))) {
                a(this.f59313g.userLimitConfig, this.f59313g.limitDetails);
            } else if (!this.f59309c.isFinishing()) {
                String e2 = b.e(this.f59307a, net.one97.paytm.paymentslimit.a.b.f59274a.f());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                } catch (JSONException e3) {
                    q.d(String.valueOf(e3));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f59307a));
                hashMap.put("Accept-Encoding", "gzip");
                new HashMap().put("screen_name", getClass().getSimpleName());
                new net.one97.paytm.paymentslimit.b.b(e2, this, this, new CJRCashWallet(), hashMap, jSONObject.toString(), a.c.PAYMENTSBANK, a.b.USER_FACING, "RemoteDataRepository").f59303a.a();
            }
        } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
            if (cJRCashWallet.getResponse() != null && cJRCashWallet.getResponse().getWalletGrade() != null) {
                d.z(this.f59307a, cJRCashWallet.getResponse().getWalletGrade());
                a(this.f59313g.userLimitConfig, this.f59313g.limitDetails);
            }
        }
    }

    public a(Context context, AppCompatActivity appCompatActivity) {
        this.f59307a = context;
        this.f59309c = appCompatActivity;
    }

    public final void a(Map<String, EditText> map, String str) {
        this.f59310d = map;
        this.f59312f = str;
        if (b()) {
            a(c());
        }
    }

    private boolean b() {
        try {
            if (this.f59310d.get("etDailyLimitAmountToBeSpent").getText().length() != 0 && this.f59310d.get("etMonthlyLimitAmountToBeSpent").getText().length() != 0 && Integer.parseInt(this.f59310d.get("etDailyLimitAmountToBeSpent").getText().toString()) > Integer.parseInt(this.f59310d.get("etMonthlyLimitAmountToBeSpent").getText().toString())) {
                a(this.f59307a.getString(R.string.msg_error_monthly_amount_limit));
                this.f59310d.get("etMonthlyLimitAmountToBeSpent").requestFocus();
                return false;
            } else if (this.f59310d.get("etDailyLimitNumberOfPayments").getText().length() == 0 || this.f59310d.get("etMonthlyLimitNumberOfPayments").getText().length() == 0 || Integer.parseInt(this.f59310d.get("etDailyLimitNumberOfPayments").getText().toString()) <= Integer.parseInt(this.f59310d.get("etMonthlyLimitNumberOfPayments").getText().toString())) {
                return true;
            } else {
                a(this.f59307a.getString(R.string.msg_error_monthly_transctions_limit));
                this.f59310d.get("etMonthlyLimitNumberOfPayments").requestFocus();
                return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    private void a(String str) {
        try {
            if (this.f59309c != null && this.f59309c.isFinishing()) {
                return;
            }
        } catch (ClassCastException unused) {
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f59309c);
        builder.setTitle((CharSequence) null);
        builder.setMessage(str);
        builder.setPositiveButton(Payload.RESPONSE_OK, new DialogInterface.OnClickListener() {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DialogInterface.OnClickListener f59314a = null;

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f59314a;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i2);
                }
            }
        });
        builder.create().show();
    }

    private JSONObject c() {
        String str;
        this.f59307a.getString(R.string.no_limit);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            if (this.f59310d.get("etDailyLimitAmountToBeSpent").getText().length() != 0) {
                jSONObject5.put("amount", this.f59310d.get("etDailyLimitAmountToBeSpent").getText().toString());
            }
            if (this.f59310d.get("etDailyLimitNumberOfPayments").getText().length() != 0) {
                jSONObject5.put("count", this.f59310d.get("etDailyLimitNumberOfPayments").getText().toString());
            }
            jSONObject4.put("dayPeriodLimit", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            if (this.f59310d.get("etMonthlyLimitAmountToBeSpent").getText().length() != 0) {
                jSONObject6.put("amount", this.f59310d.get("etMonthlyLimitAmountToBeSpent").getText().toString());
            }
            if (this.f59310d.get("etMonthlyLimitNumberOfPayments").getText().length() != 0) {
                jSONObject6.put("count", this.f59310d.get("etMonthlyLimitNumberOfPayments").getText().toString());
            }
            jSONObject4.put("monthPeriodLimit", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("status", 1);
            jSONObject7.put("periodLimits", jSONObject4);
            if (this.f59312f.equalsIgnoreCase("Merchants")) {
                this.f59308b = 1;
            } else if (this.f59312f.equalsIgnoreCase("Paytm Users")) {
                this.f59308b = 0;
            } else if (this.f59312f.equalsIgnoreCase("Send Money to Bank")) {
                this.f59308b = 2;
            }
            if (this.f59308b == 1) {
                str = "PURCHASE_LIMIT";
            } else {
                str = this.f59308b == 2 ? "WALLET_TO_BANK_TRANSFER_LIMIT" : "WALLET_TO_WALLET_TRANSFER_LIMIT";
            }
            jSONObject3.put(str, jSONObject7);
            jSONObject2.put(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, jSONObject3);
            jSONObject.put("request", jSONObject2);
        } catch (JSONException e2) {
            q.d(String.valueOf(e2));
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject) {
        net.one97.paytm.paymentslimit.b.b b2 = b(jSONObject);
        if (b.c(this.f59307a)) {
            Context context = this.f59307a;
            a(context, context.getString(R.string.please_wait));
            b2.f59303a.a();
            return;
        }
        a((e) b2);
    }

    private void a(Context context, String str) {
        AppCompatActivity appCompatActivity;
        if (context != null || (appCompatActivity = this.f59309c) == null || appCompatActivity.isFinishing()) {
            ProgressDialog progressDialog = this.f59311e;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f59311e = new ProgressDialog(this.f59309c);
                try {
                    this.f59311e.setProgressStyle(0);
                    this.f59311e.setMessage(str);
                    this.f59311e.setCancelable(false);
                    this.f59311e.setCanceledOnTouchOutside(false);
                    this.f59311e.show();
                } catch (IllegalArgumentException e2) {
                    if (b.v) {
                        q.d(String.valueOf(e2));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private void d() {
        try {
            if (this.f59311e != null && this.f59311e.isShowing() && this.f59309c != null && !this.f59309c.isFinishing()) {
                this.f59311e.dismiss();
                this.f59311e = null;
            }
        } catch (Exception unused) {
        }
    }

    private void a(e eVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f59307a);
        builder.setTitle(this.f59307a.getResources().getString(R.string.no_connection));
        builder.setMessage(this.f59307a.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(this.f59307a.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(eVar) {
            private final /* synthetic */ e f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                a.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e eVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (b.c(this.f59307a)) {
            Context context = this.f59307a;
            a(context, context.getString(R.string.please_wait));
            eVar.f59303a.a();
            return;
        }
        a(eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05d3  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0821  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail.LimitConfig r25, net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail.LimitDetails r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            boolean r3 = r3.isFinishing()
            if (r3 == 0) goto L_0x000f
            return
        L_0x000f:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r3 = r1.PURCHASE_LIMIT
            r4 = 3
            r5 = 0
            r6 = 8
            if (r3 != 0) goto L_0x001b
            boolean r3 = r3.status
            if (r3 == 0) goto L_0x0023
        L_0x001b:
            net.one97.paytm.paymentslimit.a.a r3 = net.one97.paytm.paymentslimit.a.b.f59274a
            boolean r3 = r3.g()
            if (r3 != 0) goto L_0x0030
        L_0x0023:
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r4 = net.one97.paytm.wallet.R.id.compound_view_merchants
            android.view.View r3 = r3.findViewById(r4)
            r3.setVisibility(r6)
            r4 = 2
            goto L_0x003b
        L_0x0030:
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r7 = net.one97.paytm.wallet.R.id.compound_view_merchants
            android.view.View r3 = r3.findViewById(r7)
            r3.setVisibility(r5)
        L_0x003b:
            net.one97.paytm.paymentslimit.a.a r3 = net.one97.paytm.paymentslimit.a.b.f59274a
            boolean r3 = r3.i()
            if (r3 != 0) goto L_0x0051
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r7 = net.one97.paytm.wallet.R.id.compound_view_send_money_to_bank
            android.view.View r3 = r3.findViewById(r7)
            r3.setVisibility(r6)
            int r4 = r4 + -1
            goto L_0x005c
        L_0x0051:
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r7 = net.one97.paytm.wallet.R.id.compound_view_send_money_to_bank
            android.view.View r3 = r3.findViewById(r7)
            r3.setVisibility(r5)
        L_0x005c:
            net.one97.paytm.paymentslimit.a.a r3 = net.one97.paytm.paymentslimit.a.b.f59274a
            boolean r3 = r3.h()
            if (r3 != 0) goto L_0x0072
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r7 = net.one97.paytm.wallet.R.id.compound_view_paytm_users
            android.view.View r3 = r3.findViewById(r7)
            r3.setVisibility(r6)
            int r4 = r4 + -1
            goto L_0x007d
        L_0x0072:
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r7 = net.one97.paytm.wallet.R.id.compound_view_paytm_users
            android.view.View r3 = r3.findViewById(r7)
            r3.setVisibility(r5)
        L_0x007d:
            if (r4 != 0) goto L_0x0097
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r4 = net.one97.paytm.wallet.R.id.error_msg
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.content.Context r4 = r0.f59307a
            int r7 = net.one97.paytm.wallet.R.string.no_payment_type_supported
            java.lang.String r4 = r4.getString(r7)
            r3.setText(r4)
            r3.setVisibility(r5)
        L_0x0097:
            androidx.appcompat.app.AppCompatActivity r3 = r0.f59309c
            int r4 = net.one97.paytm.wallet.R.id.compound_view_merchants
            android.view.View r3 = r3.findViewById(r4)
            net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView r3 = (net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView) r3
            androidx.appcompat.app.AppCompatActivity r4 = r0.f59309c
            int r7 = net.one97.paytm.wallet.R.id.compound_view_send_money_to_bank
            android.view.View r4 = r4.findViewById(r7)
            net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView r4 = (net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView) r4
            androidx.appcompat.app.AppCompatActivity r7 = r0.f59309c
            int r8 = net.one97.paytm.wallet.R.id.compound_view_paytm_users
            android.view.View r7 = r7.findViewById(r8)
            net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView r7 = (net.one97.paytm.paymentslimit.utility.PaymentLimitsCompoundView) r7
            java.lang.String r8 = "PURCHASE_LIMIT"
            boolean r8 = a((net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail.LimitDetails) r2, (java.lang.String) r8)
            java.lang.String r9 = "Available: ₹"
            java.lang.String r10 = "Spent: ₹"
            java.lang.String r11 = "Remaining: "
            java.lang.String r12 = "Payment Completed: "
            java.lang.String r13 = "Limit Not Set"
            java.lang.String r15 = "0"
            if (r8 == 0) goto L_0x0339
            android.widget.RelativeLayout r8 = r3.f59330a     // Catch:{ Exception -> 0x032e }
            r8.setVisibility(r6)     // Catch:{ Exception -> 0x032e }
            androidx.constraintlayout.widget.ConstraintLayout r8 = r3.f59331b     // Catch:{ Exception -> 0x032e }
            r8.setVisibility(r6)     // Catch:{ Exception -> 0x032e }
            androidx.constraintlayout.widget.ConstraintLayout r8 = r3.f59332c     // Catch:{ Exception -> 0x032e }
            r8.setVisibility(r5)     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r8 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r8 = r8.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r8 = r8.dayProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r8 = r8.countConsumed     // Catch:{ Exception -> 0x032e }
            if (r8 == 0) goto L_0x00eb
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r8 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r8 = r8.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r8 = r8.dayProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r8 = r8.countConsumed     // Catch:{ Exception -> 0x032e }
            goto L_0x00ec
        L_0x00eb:
            r8 = r15
        L_0x00ec:
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r6 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r6 = r6.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r6 = r6.dayProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r6 = r6.amountConsumed     // Catch:{ Exception -> 0x032e }
            if (r6 == 0) goto L_0x0103
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r6 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r6 = r6.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r6 = r6.dayProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r6 = r6.amountConsumed     // Catch:{ Exception -> 0x032e }
            goto L_0x0104
        L_0x0103:
            r6 = r15
        L_0x0104:
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r5 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r5 = r5.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r5 = r5.monthProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r5 = r5.countConsumed     // Catch:{ Exception -> 0x032e }
            if (r5 == 0) goto L_0x011b
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r5 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r5 = r5.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r5 = r5.monthProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r5 = r5.countConsumed     // Catch:{ Exception -> 0x032e }
            goto L_0x011c
        L_0x011b:
            r5 = r15
        L_0x011c:
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r14 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r14 = r14.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r14 = r14.monthProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r14 = r14.amountConsumed     // Catch:{ Exception -> 0x032e }
            if (r14 == 0) goto L_0x0133
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r14 = r2.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r14 = r14.properties     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r14 = r14.monthProperties     // Catch:{ Exception -> 0x032e }
            java.lang.String r14 = r14.amountConsumed     // Catch:{ Exception -> 0x032e }
            goto L_0x0134
        L_0x0133:
            r14 = r15
        L_0x0134:
            float r14 = java.lang.Float.parseFloat(r14)     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r0 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r0 = r0.periodLimits     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r0 = r0.dayPeriodLimit     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r0.count     // Catch:{ Exception -> 0x032e }
            if (r0 == 0) goto L_0x014b
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r0 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r0 = r0.periodLimits     // Catch:{ Exception -> 0x032e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r0 = r0.dayPeriodLimit     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r0.count     // Catch:{ Exception -> 0x032e }
            goto L_0x014c
        L_0x014b:
            r0 = r15
        L_0x014c:
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x032e }
            r19 = r15
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r15 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0327 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r15 = r15.periodLimits     // Catch:{ Exception -> 0x0327 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r15 = r15.dayPeriodLimit     // Catch:{ Exception -> 0x0327 }
            java.lang.String r15 = r15.amount     // Catch:{ Exception -> 0x0327 }
            if (r15 == 0) goto L_0x0165
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r15 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0327 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r15 = r15.periodLimits     // Catch:{ Exception -> 0x0327 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r15 = r15.dayPeriodLimit     // Catch:{ Exception -> 0x0327 }
            java.lang.String r15 = r15.amount     // Catch:{ Exception -> 0x0327 }
            goto L_0x0167
        L_0x0165:
            r15 = r19
        L_0x0167:
            float r15 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0327 }
            r20 = r7
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r7 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r7 = r7.periodLimits     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r7 = r7.monthPeriodLimit     // Catch:{ Exception -> 0x0323 }
            java.lang.String r7 = r7.count     // Catch:{ Exception -> 0x0323 }
            if (r7 == 0) goto L_0x0180
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r7 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r7 = r7.periodLimits     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r7 = r7.monthPeriodLimit     // Catch:{ Exception -> 0x0323 }
            java.lang.String r7 = r7.count     // Catch:{ Exception -> 0x0323 }
            goto L_0x0182
        L_0x0180:
            r7 = r19
        L_0x0182:
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ Exception -> 0x0323 }
            r21 = r4
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r4 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0321 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r4 = r4.periodLimits     // Catch:{ Exception -> 0x0321 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r4 = r4.monthPeriodLimit     // Catch:{ Exception -> 0x0321 }
            java.lang.String r4 = r4.amount     // Catch:{ Exception -> 0x0321 }
            if (r4 == 0) goto L_0x019b
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r4 = r1.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0321 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r4 = r4.periodLimits     // Catch:{ Exception -> 0x0321 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r4 = r4.monthPeriodLimit     // Catch:{ Exception -> 0x0321 }
            java.lang.String r4 = r4.amount     // Catch:{ Exception -> 0x0321 }
            goto L_0x019d
        L_0x019b:
            r4 = r19
        L_0x019d:
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ Exception -> 0x0321 }
            android.widget.ProgressBar r2 = r3.w     // Catch:{ Exception -> 0x0321 }
            float r22 = r8 / r0
            r18 = 1120403456(0x42c80000, float:100.0)
            float r22 = r22 * r18
            r23 = r13
            int r13 = java.lang.Math.round(r22)     // Catch:{ Exception -> 0x031d }
            r2.setProgress(r13)     // Catch:{ Exception -> 0x031d }
            android.widget.ProgressBar r2 = r3.x     // Catch:{ Exception -> 0x031d }
            float r13 = r6 / r15
            float r13 = r13 * r18
            int r13 = java.lang.Math.round(r13)     // Catch:{ Exception -> 0x031d }
            r2.setProgress(r13)     // Catch:{ Exception -> 0x031d }
            android.widget.ProgressBar r2 = r3.y     // Catch:{ Exception -> 0x031d }
            float r13 = r5 / r7
            float r13 = r13 * r18
            int r13 = java.lang.Math.round(r13)     // Catch:{ Exception -> 0x031d }
            r2.setProgress(r13)     // Catch:{ Exception -> 0x031d }
            android.widget.ProgressBar r2 = r3.z     // Catch:{ Exception -> 0x031d }
            float r13 = r14 / r4
            float r13 = r13 * r18
            int r13 = java.lang.Math.round(r13)     // Catch:{ Exception -> 0x031d }
            r2.setProgress(r13)     // Catch:{ Exception -> 0x031d }
            android.widget.TextView r2 = r3.j     // Catch:{ Exception -> 0x031d }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031d }
            r13.<init>(r12)     // Catch:{ Exception -> 0x031d }
            java.lang.String r1 = a((float) r8)     // Catch:{ Exception -> 0x031a }
            r13.append(r1)     // Catch:{ Exception -> 0x031a }
            java.lang.String r1 = r13.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x031a }
            r2.setText(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.TextView r1 = r3.k     // Catch:{ Exception -> 0x031a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r2.<init>(r11)     // Catch:{ Exception -> 0x031a }
            float r0 = r0 - r8
            java.lang.String r0 = a((float) r0)     // Catch:{ Exception -> 0x031a }
            r2.append(r0)     // Catch:{ Exception -> 0x031a }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r0 = b((java.lang.String) r0)     // Catch:{ Exception -> 0x031a }
            r1.setText(r0)     // Catch:{ Exception -> 0x031a }
            android.widget.TextView r0 = r3.l     // Catch:{ Exception -> 0x031a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r1.<init>(r10)     // Catch:{ Exception -> 0x031a }
            int r2 = java.lang.Math.round(r6)     // Catch:{ Exception -> 0x031a }
            float r2 = (float) r2     // Catch:{ Exception -> 0x031a }
            java.lang.String r2 = a((float) r2)     // Catch:{ Exception -> 0x031a }
            r1.append(r2)     // Catch:{ Exception -> 0x031a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x031a }
            r0.setText(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.TextView r0 = r3.m     // Catch:{ Exception -> 0x031a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r1.<init>(r9)     // Catch:{ Exception -> 0x031a }
            float r15 = r15 - r6
            java.lang.String r2 = a((float) r15)     // Catch:{ Exception -> 0x031a }
            r1.append(r2)     // Catch:{ Exception -> 0x031a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x031a }
            r0.setText(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.TextView r0 = r3.n     // Catch:{ Exception -> 0x031a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r1.<init>(r12)     // Catch:{ Exception -> 0x031a }
            java.lang.String r2 = a((float) r5)     // Catch:{ Exception -> 0x031a }
            r1.append(r2)     // Catch:{ Exception -> 0x031a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x031a }
            r0.setText(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.TextView r0 = r3.o     // Catch:{ Exception -> 0x031a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r1.<init>(r11)     // Catch:{ Exception -> 0x031a }
            float r7 = r7 - r5
            java.lang.String r2 = a((float) r7)     // Catch:{ Exception -> 0x031a }
            r1.append(r2)     // Catch:{ Exception -> 0x031a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x031a }
            r0.setText(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.TextView r0 = r3.p     // Catch:{ Exception -> 0x031a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r1.<init>(r10)     // Catch:{ Exception -> 0x031a }
            java.lang.String r2 = a((float) r14)     // Catch:{ Exception -> 0x031a }
            r1.append(r2)     // Catch:{ Exception -> 0x031a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x031a }
            r0.setText(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.TextView r0 = r3.q     // Catch:{ Exception -> 0x031a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031a }
            r1.<init>(r9)     // Catch:{ Exception -> 0x031a }
            float r4 = r4 - r14
            java.lang.String r2 = a((float) r4)     // Catch:{ Exception -> 0x031a }
            r1.append(r2)     // Catch:{ Exception -> 0x031a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031a }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x031a }
            r0.setText(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r0 = r3.w     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r1 = r3.w     // Catch:{ Exception -> 0x031a }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x031a }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r0 = r3.x     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r1 = r3.x     // Catch:{ Exception -> 0x031a }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x031a }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r0 = r3.y     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r1 = r3.y     // Catch:{ Exception -> 0x031a }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x031a }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r0 = r3.z     // Catch:{ Exception -> 0x031a }
            android.widget.ProgressBar r1 = r3.z     // Catch:{ Exception -> 0x031a }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x031a }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x031a }
            r0 = r25
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r1 = r0.PURCHASE_LIMIT     // Catch:{ Exception -> 0x031e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r1 = r1.periodLimits     // Catch:{ Exception -> 0x031e }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r1 = r1.dayPeriodLimit     // Catch:{ Exception -> 0x031e }
            java.lang.String r1 = r1.count     // Catch:{ Exception -> 0x031e }
            if (r1 != 0) goto L_0x02ea
            android.widget.TextView r1 = r3.k     // Catch:{ Exception -> 0x031e }
            r2 = r23
            r1.setText(r2)     // Catch:{ Exception -> 0x0336 }
            goto L_0x02ec
        L_0x02ea:
            r2 = r23
        L_0x02ec:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r1 = r0.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r1 = r1.periodLimits     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r1 = r1.dayPeriodLimit     // Catch:{ Exception -> 0x0336 }
            java.lang.String r1 = r1.amount     // Catch:{ Exception -> 0x0336 }
            if (r1 != 0) goto L_0x02fb
            android.widget.TextView r1 = r3.m     // Catch:{ Exception -> 0x0336 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0336 }
        L_0x02fb:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r1 = r0.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r1 = r1.periodLimits     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r1 = r1.monthPeriodLimit     // Catch:{ Exception -> 0x0336 }
            java.lang.String r1 = r1.count     // Catch:{ Exception -> 0x0336 }
            if (r1 != 0) goto L_0x030a
            android.widget.TextView r1 = r3.o     // Catch:{ Exception -> 0x0336 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0336 }
        L_0x030a:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r1 = r0.PURCHASE_LIMIT     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r1 = r1.periodLimits     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r1 = r1.monthPeriodLimit     // Catch:{ Exception -> 0x0336 }
            java.lang.String r1 = r1.amount     // Catch:{ Exception -> 0x0336 }
            if (r1 != 0) goto L_0x0336
            android.widget.TextView r1 = r3.q     // Catch:{ Exception -> 0x0336 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0336 }
            goto L_0x0336
        L_0x031a:
            r0 = r25
            goto L_0x031e
        L_0x031d:
            r0 = r1
        L_0x031e:
            r2 = r23
            goto L_0x0336
        L_0x0321:
            r0 = r1
            goto L_0x032c
        L_0x0323:
            r0 = r1
            r21 = r4
            goto L_0x032c
        L_0x0327:
            r0 = r1
            r21 = r4
            r20 = r7
        L_0x032c:
            r2 = r13
            goto L_0x0336
        L_0x032e:
            r0 = r1
            r21 = r4
            r20 = r7
            r2 = r13
            r19 = r15
        L_0x0336:
            r4 = 8
            goto L_0x0353
        L_0x0339:
            r0 = r1
            r21 = r4
            r20 = r7
            r2 = r13
            r19 = r15
            android.widget.RelativeLayout r1 = r3.f59330a
            r4 = 0
            r1.setVisibility(r4)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r3.f59331b
            r4 = 8
            r1.setVisibility(r4)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r3.f59332c
            r1.setVisibility(r4)
        L_0x0353:
            java.lang.String r1 = "WALLET_TO_BANK_TRANSFER_LIMIT"
            r3 = r26
            boolean r1 = a((net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail.LimitDetails) r3, (java.lang.String) r1)
            if (r1 == 0) goto L_0x05b4
            r1 = r21
            android.widget.RelativeLayout r5 = r1.f59330a     // Catch:{ Exception -> 0x05b0 }
            r5.setVisibility(r4)     // Catch:{ Exception -> 0x05b0 }
            androidx.constraintlayout.widget.ConstraintLayout r5 = r1.f59331b     // Catch:{ Exception -> 0x05b0 }
            r5.setVisibility(r4)     // Catch:{ Exception -> 0x05b0 }
            androidx.constraintlayout.widget.ConstraintLayout r4 = r1.f59332c     // Catch:{ Exception -> 0x05b0 }
            r5 = 0
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r4 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r4 = r4.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r4 = r4.dayProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = r4.countConsumed     // Catch:{ Exception -> 0x05b0 }
            if (r4 == 0) goto L_0x0382
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r4 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r4 = r4.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r4 = r4.dayProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r4.countConsumed     // Catch:{ Exception -> 0x05b0 }
            goto L_0x0384
        L_0x0382:
            r15 = r19
        L_0x0384:
            float r4 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r5 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r5 = r5.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r5 = r5.dayProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r5 = r5.amountConsumed     // Catch:{ Exception -> 0x05b0 }
            if (r5 == 0) goto L_0x039b
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r5 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r5 = r5.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r5 = r5.dayProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r5.amountConsumed     // Catch:{ Exception -> 0x05b0 }
            goto L_0x039d
        L_0x039b:
            r15 = r19
        L_0x039d:
            float r5 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r6 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r6 = r6.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r6 = r6.monthProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r6 = r6.countConsumed     // Catch:{ Exception -> 0x05b0 }
            if (r6 == 0) goto L_0x03b4
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r6 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r6 = r6.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r6 = r6.monthProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r6.countConsumed     // Catch:{ Exception -> 0x05b0 }
            goto L_0x03b6
        L_0x03b4:
            r15 = r19
        L_0x03b6:
            float r6 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r7 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r7 = r7.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r7 = r7.monthProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r7 = r7.amountConsumed     // Catch:{ Exception -> 0x05b0 }
            if (r7 == 0) goto L_0x03cd
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r7 = r3.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r7 = r7.properties     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r7 = r7.monthProperties     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r7.amountConsumed     // Catch:{ Exception -> 0x05b0 }
            goto L_0x03cf
        L_0x03cd:
            r15 = r19
        L_0x03cf:
            float r7 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r8 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r8 = r8.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r8 = r8.dayPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r8 = r8.count     // Catch:{ Exception -> 0x05b0 }
            if (r8 == 0) goto L_0x03e6
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r8 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r8 = r8.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r8 = r8.dayPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r8.count     // Catch:{ Exception -> 0x05b0 }
            goto L_0x03e8
        L_0x03e6:
            r15 = r19
        L_0x03e8:
            float r8 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r13 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r13 = r13.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r13 = r13.dayPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = r13.amount     // Catch:{ Exception -> 0x05b0 }
            if (r13 == 0) goto L_0x03ff
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r13 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r13 = r13.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r13 = r13.dayPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r13.amount     // Catch:{ Exception -> 0x05b0 }
            goto L_0x0401
        L_0x03ff:
            r15 = r19
        L_0x0401:
            float r13 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r14 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r14 = r14.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r14 = r14.monthPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r14 = r14.count     // Catch:{ Exception -> 0x05b0 }
            if (r14 == 0) goto L_0x0418
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r14 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r14 = r14.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r14 = r14.monthPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r14.count     // Catch:{ Exception -> 0x05b0 }
            goto L_0x041a
        L_0x0418:
            r15 = r19
        L_0x041a:
            float r14 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r15 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r15 = r15.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r15 = r15.monthPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r15.amount     // Catch:{ Exception -> 0x05b0 }
            if (r15 == 0) goto L_0x0431
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r15 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r15 = r15.periodLimits     // Catch:{ Exception -> 0x05b0 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r15 = r15.monthPeriodLimit     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = r15.amount     // Catch:{ Exception -> 0x05b0 }
            goto L_0x0433
        L_0x0431:
            r15 = r19
        L_0x0433:
            float r15 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x05b0 }
            android.widget.ProgressBar r3 = r1.w     // Catch:{ Exception -> 0x05b0 }
            float r21 = r4 / r8
            r18 = 1120403456(0x42c80000, float:100.0)
            float r21 = r21 * r18
            r23 = r2
            int r2 = java.lang.Math.round(r21)     // Catch:{ Exception -> 0x05ad }
            r3.setProgress(r2)     // Catch:{ Exception -> 0x05ad }
            android.widget.ProgressBar r2 = r1.x     // Catch:{ Exception -> 0x05ad }
            float r3 = r5 / r13
            float r3 = r3 * r18
            int r3 = java.lang.Math.round(r3)     // Catch:{ Exception -> 0x05ad }
            r2.setProgress(r3)     // Catch:{ Exception -> 0x05ad }
            android.widget.ProgressBar r2 = r1.y     // Catch:{ Exception -> 0x05ad }
            float r3 = r6 / r14
            float r3 = r3 * r18
            int r3 = java.lang.Math.round(r3)     // Catch:{ Exception -> 0x05ad }
            r2.setProgress(r3)     // Catch:{ Exception -> 0x05ad }
            android.widget.ProgressBar r2 = r1.z     // Catch:{ Exception -> 0x05ad }
            float r3 = r7 / r15
            float r3 = r3 * r18
            int r3 = java.lang.Math.round(r3)     // Catch:{ Exception -> 0x05ad }
            r2.setProgress(r3)     // Catch:{ Exception -> 0x05ad }
            android.widget.TextView r2 = r1.j     // Catch:{ Exception -> 0x05ad }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ad }
            r3.<init>(r12)     // Catch:{ Exception -> 0x05ad }
            java.lang.String r0 = a((float) r4)     // Catch:{ Exception -> 0x05ab }
            r3.append(r0)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r0 = b((java.lang.String) r0)     // Catch:{ Exception -> 0x05ab }
            r2.setText(r0)     // Catch:{ Exception -> 0x05ab }
            android.widget.TextView r0 = r1.k     // Catch:{ Exception -> 0x05ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ab }
            r2.<init>(r11)     // Catch:{ Exception -> 0x05ab }
            float r8 = r8 - r4
            java.lang.String r3 = a((float) r8)     // Catch:{ Exception -> 0x05ab }
            r2.append(r3)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r2 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.TextView r0 = r1.l     // Catch:{ Exception -> 0x05ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ab }
            r2.<init>(r10)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r3 = a((float) r5)     // Catch:{ Exception -> 0x05ab }
            r2.append(r3)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r2 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.TextView r0 = r1.m     // Catch:{ Exception -> 0x05ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ab }
            r2.<init>(r9)     // Catch:{ Exception -> 0x05ab }
            float r13 = r13 - r5
            java.lang.String r3 = a((float) r13)     // Catch:{ Exception -> 0x05ab }
            r2.append(r3)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r2 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.TextView r0 = r1.n     // Catch:{ Exception -> 0x05ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ab }
            r2.<init>(r12)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r3 = a((float) r6)     // Catch:{ Exception -> 0x05ab }
            r2.append(r3)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r2 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.TextView r0 = r1.o     // Catch:{ Exception -> 0x05ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ab }
            r2.<init>(r11)     // Catch:{ Exception -> 0x05ab }
            float r14 = r14 - r6
            java.lang.String r3 = a((float) r14)     // Catch:{ Exception -> 0x05ab }
            r2.append(r3)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r2 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.TextView r0 = r1.p     // Catch:{ Exception -> 0x05ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ab }
            r2.<init>(r10)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r3 = a((float) r7)     // Catch:{ Exception -> 0x05ab }
            r2.append(r3)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r2 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x05ab }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ab }
            r2.<init>(r9)     // Catch:{ Exception -> 0x05ab }
            float r15 = r15 - r7
            java.lang.String r3 = a((float) r15)     // Catch:{ Exception -> 0x05ab }
            r2.append(r3)     // Catch:{ Exception -> 0x05ab }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ab }
            android.text.SpannableStringBuilder r2 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r0 = r1.w     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r2 = r1.w     // Catch:{ Exception -> 0x05ab }
            android.graphics.drawable.Drawable r2 = a((android.widget.ProgressBar) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setProgressDrawable(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r0 = r1.x     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r2 = r1.x     // Catch:{ Exception -> 0x05ab }
            android.graphics.drawable.Drawable r2 = a((android.widget.ProgressBar) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setProgressDrawable(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r0 = r1.y     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r2 = r1.y     // Catch:{ Exception -> 0x05ab }
            android.graphics.drawable.Drawable r2 = a((android.widget.ProgressBar) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setProgressDrawable(r2)     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r0 = r1.z     // Catch:{ Exception -> 0x05ab }
            android.widget.ProgressBar r2 = r1.z     // Catch:{ Exception -> 0x05ab }
            android.graphics.drawable.Drawable r2 = a((android.widget.ProgressBar) r2)     // Catch:{ Exception -> 0x05ab }
            r0.setProgressDrawable(r2)     // Catch:{ Exception -> 0x05ab }
            r0 = r25
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r2 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05ad }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r2 = r2.periodLimits     // Catch:{ Exception -> 0x05ad }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r2 = r2.dayPeriodLimit     // Catch:{ Exception -> 0x05ad }
            java.lang.String r2 = r2.count     // Catch:{ Exception -> 0x05ad }
            if (r2 != 0) goto L_0x057b
            android.widget.TextView r2 = r1.k     // Catch:{ Exception -> 0x05ad }
            r3 = r23
            r2.setText(r3)     // Catch:{ Exception -> 0x05b1 }
            goto L_0x057d
        L_0x057b:
            r3 = r23
        L_0x057d:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r2 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b1 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r2 = r2.periodLimits     // Catch:{ Exception -> 0x05b1 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r2 = r2.dayPeriodLimit     // Catch:{ Exception -> 0x05b1 }
            java.lang.String r2 = r2.amount     // Catch:{ Exception -> 0x05b1 }
            if (r2 != 0) goto L_0x058c
            android.widget.TextView r2 = r1.m     // Catch:{ Exception -> 0x05b1 }
            r2.setText(r3)     // Catch:{ Exception -> 0x05b1 }
        L_0x058c:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r2 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b1 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r2 = r2.periodLimits     // Catch:{ Exception -> 0x05b1 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r2 = r2.monthPeriodLimit     // Catch:{ Exception -> 0x05b1 }
            java.lang.String r2 = r2.count     // Catch:{ Exception -> 0x05b1 }
            if (r2 != 0) goto L_0x059b
            android.widget.TextView r2 = r1.o     // Catch:{ Exception -> 0x05b1 }
            r2.setText(r3)     // Catch:{ Exception -> 0x05b1 }
        L_0x059b:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r2 = r0.WALLET_TO_BANK_TRANSFER_LIMIT     // Catch:{ Exception -> 0x05b1 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r2 = r2.periodLimits     // Catch:{ Exception -> 0x05b1 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r2 = r2.monthPeriodLimit     // Catch:{ Exception -> 0x05b1 }
            java.lang.String r2 = r2.amount     // Catch:{ Exception -> 0x05b1 }
            if (r2 != 0) goto L_0x05b1
            android.widget.TextView r1 = r1.q     // Catch:{ Exception -> 0x05b1 }
            r1.setText(r3)     // Catch:{ Exception -> 0x05b1 }
            goto L_0x05b1
        L_0x05ab:
            r0 = r25
        L_0x05ad:
            r3 = r23
            goto L_0x05b1
        L_0x05b0:
            r3 = r2
        L_0x05b1:
            r4 = 8
            goto L_0x05c9
        L_0x05b4:
            r3 = r2
            r1 = r21
            android.widget.RelativeLayout r2 = r1.f59330a
            r4 = 0
            r2.setVisibility(r4)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r1.f59331b
            r4 = 8
            r2.setVisibility(r4)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.f59332c
            r1.setVisibility(r4)
        L_0x05c9:
            java.lang.String r1 = "WALLET_TO_WALLET_TRANSFER_LIMIT"
            r2 = r26
            boolean r1 = a((net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail.LimitDetails) r2, (java.lang.String) r1)
            if (r1 == 0) goto L_0x0821
            r7 = r20
            android.widget.RelativeLayout r1 = r7.f59330a     // Catch:{ Exception -> 0x0820 }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0820 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r7.f59331b     // Catch:{ Exception -> 0x0820 }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0820 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r7.f59332c     // Catch:{ Exception -> 0x0820 }
            r4 = 0
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r1 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r1 = r1.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r1 = r1.dayProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.countConsumed     // Catch:{ Exception -> 0x0820 }
            if (r1 == 0) goto L_0x05f8
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r1 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r1 = r1.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r1 = r1.dayProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r1.countConsumed     // Catch:{ Exception -> 0x0820 }
            goto L_0x05fa
        L_0x05f8:
            r15 = r19
        L_0x05fa:
            float r1 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r4 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r4 = r4.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r4 = r4.dayProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r4 = r4.amountConsumed     // Catch:{ Exception -> 0x0820 }
            if (r4 == 0) goto L_0x0611
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r4 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r4 = r4.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r4 = r4.dayProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r4.amountConsumed     // Catch:{ Exception -> 0x0820 }
            goto L_0x0613
        L_0x0611:
            r15 = r19
        L_0x0613:
            float r4 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r5 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r5 = r5.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r5 = r5.monthProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r5 = r5.countConsumed     // Catch:{ Exception -> 0x0820 }
            if (r5 == 0) goto L_0x062a
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r5 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r5 = r5.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r5 = r5.monthProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r5.countConsumed     // Catch:{ Exception -> 0x0820 }
            goto L_0x062c
        L_0x062a:
            r15 = r19
        L_0x062c:
            float r5 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r6 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r6 = r6.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r6 = r6.monthProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r6 = r6.amountConsumed     // Catch:{ Exception -> 0x0820 }
            if (r6 == 0) goto L_0x0643
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsItem r2 = r2.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsProperties r2 = r2.properties     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetailsInfo r2 = r2.monthProperties     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r2.amountConsumed     // Catch:{ Exception -> 0x0820 }
            goto L_0x0645
        L_0x0643:
            r15 = r19
        L_0x0645:
            float r2 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r6 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r6 = r6.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r6 = r6.dayPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r6 = r6.count     // Catch:{ Exception -> 0x0820 }
            if (r6 == 0) goto L_0x065c
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r6 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r6 = r6.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r6 = r6.dayPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r6.count     // Catch:{ Exception -> 0x0820 }
            goto L_0x065e
        L_0x065c:
            r15 = r19
        L_0x065e:
            float r6 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r8 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r8 = r8.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r8 = r8.dayPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r8 = r8.amount     // Catch:{ Exception -> 0x0820 }
            if (r8 == 0) goto L_0x0675
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r8 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r8 = r8.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r8 = r8.dayPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r8.amount     // Catch:{ Exception -> 0x0820 }
            goto L_0x0677
        L_0x0675:
            r15 = r19
        L_0x0677:
            float r8 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r13 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r13 = r13.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r13 = r13.monthPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r13 = r13.count     // Catch:{ Exception -> 0x0820 }
            if (r13 == 0) goto L_0x068e
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r13 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r13 = r13.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r13 = r13.monthPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r13.count     // Catch:{ Exception -> 0x0820 }
            goto L_0x0690
        L_0x068e:
            r15 = r19
        L_0x0690:
            float r13 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r14 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r14 = r14.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r14 = r14.monthPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r14 = r14.amount     // Catch:{ Exception -> 0x0820 }
            if (r14 == 0) goto L_0x06a7
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r14 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r14 = r14.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r14 = r14.monthPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r14.amount     // Catch:{ Exception -> 0x0820 }
            goto L_0x06a9
        L_0x06a7:
            r15 = r19
        L_0x06a9:
            float r14 = java.lang.Float.parseFloat(r15)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r15 = r7.w     // Catch:{ Exception -> 0x0820 }
            float r16 = r1 / r6
            r17 = 1120403456(0x42c80000, float:100.0)
            float r16 = r16 * r17
            r23 = r3
            int r3 = java.lang.Math.round(r16)     // Catch:{ Exception -> 0x0820 }
            r15.setProgress(r3)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r3 = r7.x     // Catch:{ Exception -> 0x0820 }
            float r15 = r4 / r8
            float r15 = r15 * r17
            int r15 = java.lang.Math.round(r15)     // Catch:{ Exception -> 0x0820 }
            r3.setProgress(r15)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r3 = r7.y     // Catch:{ Exception -> 0x0820 }
            float r15 = r5 / r13
            float r15 = r15 * r17
            int r15 = java.lang.Math.round(r15)     // Catch:{ Exception -> 0x0820 }
            r3.setProgress(r15)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r3 = r7.z     // Catch:{ Exception -> 0x0820 }
            float r15 = r2 / r14
            float r15 = r15 * r17
            int r15 = java.lang.Math.round(r15)     // Catch:{ Exception -> 0x0820 }
            r3.setProgress(r15)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r3 = r7.j     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r15.<init>(r12)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r0 = a((float) r1)     // Catch:{ Exception -> 0x0820 }
            r15.append(r0)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r0 = b((java.lang.String) r0)     // Catch:{ Exception -> 0x0820 }
            r3.setText(r0)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r0 = r7.k     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x0820 }
            float r6 = r6 - r1
            java.lang.String r1 = a((float) r6)     // Catch:{ Exception -> 0x0820 }
            r3.append(r1)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r0 = r7.l     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r3 = a((float) r4)     // Catch:{ Exception -> 0x0820 }
            r1.append(r3)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r0 = r7.m     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x0820 }
            float r8 = r8 - r4
            java.lang.String r3 = a((float) r8)     // Catch:{ Exception -> 0x0820 }
            r1.append(r3)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r0 = r7.n     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r3 = a((float) r5)     // Catch:{ Exception -> 0x0820 }
            r1.append(r3)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r0 = r7.o     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x0820 }
            float r13 = r13 - r5
            java.lang.String r3 = a((float) r13)     // Catch:{ Exception -> 0x0820 }
            r1.append(r3)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r0 = r7.p     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r3 = a((float) r2)     // Catch:{ Exception -> 0x0820 }
            r1.append(r3)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.TextView r0 = r7.q     // Catch:{ Exception -> 0x0820 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0820 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x0820 }
            float r14 = r14 - r2
            java.lang.String r2 = a((float) r14)     // Catch:{ Exception -> 0x0820 }
            r1.append(r2)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0820 }
            android.text.SpannableStringBuilder r1 = b((java.lang.String) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r0 = r7.w     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r1 = r7.w     // Catch:{ Exception -> 0x0820 }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r0 = r7.x     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r1 = r7.x     // Catch:{ Exception -> 0x0820 }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r0 = r7.y     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r1 = r7.y     // Catch:{ Exception -> 0x0820 }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r0 = r7.z     // Catch:{ Exception -> 0x0820 }
            android.widget.ProgressBar r1 = r7.z     // Catch:{ Exception -> 0x0820 }
            android.graphics.drawable.Drawable r1 = a((android.widget.ProgressBar) r1)     // Catch:{ Exception -> 0x0820 }
            r0.setProgressDrawable(r1)     // Catch:{ Exception -> 0x0820 }
            r0 = r25
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r1 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r1 = r1.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r1 = r1.dayPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.count     // Catch:{ Exception -> 0x0820 }
            if (r1 != 0) goto L_0x07f1
            android.widget.TextView r1 = r7.k     // Catch:{ Exception -> 0x0820 }
            r2 = r23
            r1.setText(r2)     // Catch:{ Exception -> 0x0820 }
            goto L_0x07f3
        L_0x07f1:
            r2 = r23
        L_0x07f3:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r1 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r1 = r1.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r1 = r1.dayPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.amount     // Catch:{ Exception -> 0x0820 }
            if (r1 != 0) goto L_0x0802
            android.widget.TextView r1 = r7.m     // Catch:{ Exception -> 0x0820 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0820 }
        L_0x0802:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r1 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r1 = r1.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r1 = r1.monthPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r1 = r1.count     // Catch:{ Exception -> 0x0820 }
            if (r1 != 0) goto L_0x0811
            android.widget.TextView r1 = r7.o     // Catch:{ Exception -> 0x0820 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0820 }
        L_0x0811:
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$Item r0 = r0.WALLET_TO_WALLET_TRANSFER_LIMIT     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$PeriodLimit r0 = r0.periodLimits     // Catch:{ Exception -> 0x0820 }
            net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitInfo r0 = r0.monthPeriodLimit     // Catch:{ Exception -> 0x0820 }
            java.lang.String r0 = r0.amount     // Catch:{ Exception -> 0x0820 }
            if (r0 != 0) goto L_0x0820
            android.widget.TextView r0 = r7.q     // Catch:{ Exception -> 0x0820 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0820 }
        L_0x0820:
            return
        L_0x0821:
            r7 = r20
            android.widget.RelativeLayout r0 = r7.f59330a
            r1 = 0
            r0.setVisibility(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r7.f59331b
            r1 = 8
            r0.setVisibility(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r7.f59332c
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentslimit.c.a.a(net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitConfig, net.one97.paytm.paymentslimit.bean.CJRPaymentLimitDetail$LimitDetails):void");
    }

    private static boolean a(CJRPaymentLimitDetail.LimitDetails limitDetails, String str) {
        try {
            if (str.equals("PURCHASE_LIMIT")) {
                if (!(limitDetails.PURCHASE_LIMIT.properties.dayProperties.countConsumed == null && limitDetails.PURCHASE_LIMIT.properties.dayProperties.amountConsumed == null && limitDetails.PURCHASE_LIMIT.properties.monthProperties.countConsumed == null && limitDetails.PURCHASE_LIMIT.properties.monthProperties.amountConsumed == null)) {
                    return true;
                }
            } else if (str.equals("WALLET_TO_BANK_TRANSFER_LIMIT")) {
                if (!(limitDetails.WALLET_TO_BANK_TRANSFER_LIMIT.properties.dayProperties.countConsumed == null && limitDetails.WALLET_TO_BANK_TRANSFER_LIMIT.properties.dayProperties.amountConsumed == null && limitDetails.WALLET_TO_BANK_TRANSFER_LIMIT.properties.monthProperties.countConsumed == null && limitDetails.WALLET_TO_BANK_TRANSFER_LIMIT.properties.monthProperties.amountConsumed == null)) {
                    return true;
                }
            } else if (!(limitDetails.WALLET_TO_WALLET_TRANSFER_LIMIT.properties.dayProperties.countConsumed == null && limitDetails.WALLET_TO_WALLET_TRANSFER_LIMIT.properties.dayProperties.amountConsumed == null && limitDetails.WALLET_TO_WALLET_TRANSFER_LIMIT.properties.monthProperties.countConsumed == null && limitDetails.WALLET_TO_WALLET_TRANSFER_LIMIT.properties.monthProperties.amountConsumed == null)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static Drawable a(ProgressBar progressBar) {
        LayerDrawable layerDrawable = (LayerDrawable) progressBar.getProgressDrawable();
        Drawable drawable = layerDrawable.getDrawable(0);
        Drawable drawable2 = layerDrawable.getDrawable(1);
        drawable.setColorFilter(Color.rgb(232, 237, 241), PorterDuff.Mode.SRC_IN);
        int progress = progressBar.getProgress();
        if (progress >= 0 && progress <= 50) {
            drawable2.setColorFilter(Color.rgb(33, 193, 122), PorterDuff.Mode.SRC_IN);
        } else if (progress < 51 || progress > 75) {
            drawable2.setColorFilter(Color.rgb(PriceRangeSeekBar.INVALID_POINTER_ID, 75, 85), PorterDuff.Mode.SRC_IN);
        } else {
            drawable2.setColorFilter(Color.rgb(245, Constants.ACTION_NB_WV_LOGIN_CLICKED, 9), PorterDuff.Mode.SRC_IN);
        }
        return layerDrawable;
    }

    private static SpannableStringBuilder b(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new StyleSpan(1), str.lastIndexOf(" "), str.length(), 18);
        return spannableStringBuilder;
    }

    private static String a(float f2) {
        Math.round(f2);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 < 1000.0f) {
            return a("###", (Object) Float.valueOf(f2));
        }
        return a(",##", (Object) Integer.valueOf((int) (f2 / 1000.0f))) + ',' + a("000", (Object) Float.valueOf(f2 % 1000.0f));
    }

    private static String a(String str, Object obj) {
        return new DecimalFormat(str).format(obj);
    }

    public final void a(PaymentLimitsCompoundView paymentLimitsCompoundView, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (str.equalsIgnoreCase("Merchants")) {
            str2 = this.f59313g.userLimitConfig.PURCHASE_LIMIT.periodLimits.dayPeriodLimit.count;
            str5 = this.f59313g.userLimitConfig.PURCHASE_LIMIT.periodLimits.dayPeriodLimit.amount;
            str4 = this.f59313g.userLimitConfig.PURCHASE_LIMIT.periodLimits.monthPeriodLimit.count;
            str3 = this.f59313g.userLimitConfig.PURCHASE_LIMIT.periodLimits.monthPeriodLimit.amount;
        } else if (str.equalsIgnoreCase("Paytm Users")) {
            str2 = this.f59313g.userLimitConfig.WALLET_TO_WALLET_TRANSFER_LIMIT.periodLimits.dayPeriodLimit.count;
            str5 = this.f59313g.userLimitConfig.WALLET_TO_WALLET_TRANSFER_LIMIT.periodLimits.dayPeriodLimit.amount;
            str4 = this.f59313g.userLimitConfig.WALLET_TO_WALLET_TRANSFER_LIMIT.periodLimits.monthPeriodLimit.count;
            str3 = this.f59313g.userLimitConfig.WALLET_TO_WALLET_TRANSFER_LIMIT.periodLimits.monthPeriodLimit.amount;
        } else {
            str2 = this.f59313g.userLimitConfig.WALLET_TO_BANK_TRANSFER_LIMIT.periodLimits.dayPeriodLimit.count;
            str5 = this.f59313g.userLimitConfig.WALLET_TO_BANK_TRANSFER_LIMIT.periodLimits.dayPeriodLimit.amount;
            str4 = this.f59313g.userLimitConfig.WALLET_TO_BANK_TRANSFER_LIMIT.periodLimits.monthPeriodLimit.count;
            str3 = this.f59313g.userLimitConfig.WALLET_TO_BANK_TRANSFER_LIMIT.periodLimits.monthPeriodLimit.amount;
        }
        paymentLimitsCompoundView.s.setText(str2);
        paymentLimitsCompoundView.t.setText(str5);
        paymentLimitsCompoundView.u.setText(str4);
        paymentLimitsCompoundView.v.setText(str3);
    }

    public final void a(NetworkCustomError networkCustomError) {
        d();
        net.one97.paytm.paymentslimit.utility.b.a(this.f59309c, networkCustomError, getClass().getSimpleName());
    }

    private net.one97.paytm.paymentslimit.b.b b(JSONObject jSONObject) {
        String e2 = net.one97.paytm.paymentslimit.a.b.f59274a.e();
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(this.f59307a));
        hashMap.put("Content-Type", "application/json");
        new HashMap().put("screen_name", a.class.getSimpleName());
        return new net.one97.paytm.paymentslimit.b.b(e2, this, this, new CJRUpdateLimitResposne(), hashMap, jSONObject.toString(), a.c.PAYMENTSBANK, a.b.USER_FACING, "RemoteDataRepository");
    }

    public final void a() {
        String s = b.s(this.f59307a, net.one97.paytm.paymentslimit.a.b.f59274a.c());
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(this.f59307a));
        new HashMap().put("screen_name", AJRPaymentLimitHomePageNew.class.getName());
        CJRPaymentLimitDetail cJRPaymentLimitDetail = new CJRPaymentLimitDetail();
        g.a aVar = g.a.PAYMENTS_LIMIT;
        net.one97.paytm.paymentslimit.b.a aVar2 = new net.one97.paytm.paymentslimit.b.a(s, this, this, cJRPaymentLimitDetail, hashMap, a.b.USER_FACING, a.class.getSimpleName());
        if (b.c(this.f59307a)) {
            Context context = this.f59307a;
            a(context, context.getString(R.string.please_wait));
            aVar2.f59303a.a();
            return;
        }
        a((e) aVar2);
    }
}
