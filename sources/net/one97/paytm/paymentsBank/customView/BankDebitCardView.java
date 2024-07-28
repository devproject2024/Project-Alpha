package net.one97.paytm.paymentsBank.customView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.k;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.PBBlockUnblockCardResponse;
import net.one97.paytm.bankCommon.model.PBCardDetailModel;
import net.one97.paytm.bankCommon.model.PBVerifyPasscodeResponse;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.bankCommon.utils.c;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.customView.a;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;

public class BankDebitCardView extends LinearLayout implements g.a, g.b<IJRPaytmDataModel>, PinEntryView.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f18204a;

    /* renamed from: b  reason: collision with root package name */
    public PinEntryView f18205b;

    /* renamed from: c  reason: collision with root package name */
    public int f18206c = 0;

    /* renamed from: d  reason: collision with root package name */
    public c f18207d;

    /* renamed from: e  reason: collision with root package name */
    private CustProductList f18208e;

    /* renamed from: f  reason: collision with root package name */
    private InputMethodManager f18209f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18210g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f18211h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressDialog f18212i;
    private ViewFlipper j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private LinearLayout o;
    private RelativeLayout p;
    private a q;
    private PBCardDetailModel r;
    private ImageView s;
    private TextView t;
    private b u;

    public interface a {
        void a(String str);

        void a(c cVar);

        void g();

        void h();
    }

    public interface b {
        void onClickForgotPassword();
    }

    public void setPasscodeStatus(boolean z) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        c(false);
        if (iJRPaytmDataModel instanceof PBVerifyPasscodeResponse) {
            PBVerifyPasscodeResponse pBVerifyPasscodeResponse = (PBVerifyPasscodeResponse) iJRPaytmDataModel;
            if (pBVerifyPasscodeResponse.getError() == null) {
                b(false);
                int i2 = this.f18206c;
                if (i2 == 1) {
                    d(pBVerifyPasscodeResponse.getAccessToken());
                } else if (i2 == 2) {
                    e(pBVerifyPasscodeResponse.getAccessToken());
                } else {
                    b(pBVerifyPasscodeResponse.getAccessToken());
                }
            } else {
                this.f18211h.setText(pBVerifyPasscodeResponse.getErrorDescription());
                b(true);
            }
        } else if (iJRPaytmDataModel instanceof PBCardDetailModel) {
            this.r = (PBCardDetailModel) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(this.r.getErrorMessage())) {
                this.f18211h.setText(this.r.getErrorMessage());
                b(true);
                a(true);
                return;
            }
            b();
            setPasscodeStatus(false);
            a(c.FULL_CARD);
        } else if (iJRPaytmDataModel instanceof PBBlockUnblockCardResponse) {
            PBBlockUnblockCardResponse pBBlockUnblockCardResponse = (PBBlockUnblockCardResponse) iJRPaytmDataModel;
            if (TextUtils.isEmpty(pBBlockUnblockCardResponse.getErrorMessage())) {
                g();
                int i3 = this.f18206c;
                if (i3 == 1) {
                    a aVar = this.q;
                    if (aVar != null) {
                        aVar.a(c.MASKED_CARD);
                    }
                    b();
                    setPasscodeStatus(false);
                    a(c.MASKED_CARD);
                    Intent intent = new Intent("card_changed");
                    intent.putExtra("cardState", c.MASKED_CARD.ordinal());
                    androidx.localbroadcastmanager.a.a.a(this.f18204a).a(intent);
                } else if (i3 == 2) {
                    a aVar2 = this.q;
                    if (aVar2 != null) {
                        aVar2.a(c.BLOCK_CARD);
                    }
                    b();
                    setPasscodeStatus(false);
                    a(c.BLOCK_CARD);
                    Intent intent2 = new Intent("card_changed");
                    intent2.putExtra("cardState", c.BLOCK_CARD.ordinal());
                    androidx.localbroadcastmanager.a.a.a(this.f18204a).a(intent2);
                }
                this.f18206c = 0;
                return;
            }
            b(true);
            Context context = this.f18204a;
            com.paytm.utility.b.b(context, context.getString(R.string.error), pBBlockUnblockCardResponse.getErrorMessage());
        }
    }

    public BankDebitCardView(Context context) {
        super(context);
        this.f18204a = context;
        f();
    }

    public BankDebitCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18204a = context;
        f();
    }

    public void setBankCardListener(a aVar) {
        this.q = aVar;
    }

    public c getDebitCardState() {
        return this.f18207d;
    }

    public void setDebitCardState(c cVar) {
        this.f18207d = cVar;
    }

    public void setCardDetails(PBCardDetailModel pBCardDetailModel) {
        this.r = pBCardDetailModel;
    }

    public void setPasscodeTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.t.setText(str);
        }
    }

    public void setPasscodeTitle(SpannableStringBuilder spannableStringBuilder) {
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            this.t.setText(spannableStringBuilder);
        }
    }

    public final void a(CustProductList custProductList) {
        this.f18208e = custProductList;
        if (a.a() == c.FULL_CARD) {
            this.r = a.b();
            a(this.r);
        } else if (custProductList != null) {
            if (TextUtils.isEmpty(custProductList.getVdcStatus()) || !custProductList.getVdcStatus().equalsIgnoreCase("ISSUED")) {
                setVisibility(8);
            } else if (TextUtils.isEmpty(custProductList.getVdcCardStatus())) {
                setVisibility(8);
            } else if (H5ThreadType.NORMAL.equalsIgnoreCase(custProductList.getVdcCardStatus())) {
                if (this.f18207d == c.FULL_CARD) {
                    a(this.r);
                } else {
                    a(c.MASKED_CARD);
                }
            } else if ("RESTRICTED_BLOCK".equalsIgnoreCase(custProductList.getVdcCardStatus())) {
                a(c.RESTRICTED_BLOCK);
            } else {
                a(c.BLOCK_CARD);
            }
        }
        o.a().getNameFromKyc(this.f18204a, new d() {
            public final void onFragmentAction(int i2, Object obj) {
                BankDebitCardView.this.a(i2, obj);
            }
        });
        if (custProductList == null || custProductList.getVdc() == null) {
            this.n.setVisibility(8);
            return;
        }
        setCardTypeLogo(custProductList.getVdcCardType());
        this.n.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        String str = (String) obj;
        ((TextView) findViewById(R.id.tv_card_holder_name)).setText(str);
        a aVar = this.q;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    private void setCardTypeLogo(String str) {
        if (c.C0228c.RUPAY.stringValue.startsWith(str)) {
            this.n.setImageResource(R.drawable.pb_ic_rupay_logo);
        } else if (c.C0228c.VISA_PLATINUM.stringValue.startsWith(str)) {
            this.n.setImageResource(R.drawable.pb_vdc_ic_visa_logo);
        } else if (c.C0228c.VISA_CLASSIC.stringValue.startsWith(str)) {
            this.n.setImageResource(R.drawable.pb_vdc_ic_visa_logo);
        } else if (c.C0228c.MASTER_PLATINUM.stringValue.startsWith(str)) {
            this.n.setImageResource(R.drawable.pb_vdc_ic_master_logo);
        } else if (c.C0228c.MASTER_CLASSIC.stringValue.startsWith(str)) {
            this.n.setImageResource(R.drawable.pb_vdc_ic_master_logo);
        }
    }

    private void f() {
        inflate(this.f18204a, R.layout.view_bank_debit_card, this);
        this.f18209f = (InputMethodManager) this.f18204a.getSystemService("input_method");
        this.f18210g = (TextView) findViewById(R.id.tv_card_action);
        this.s = (ImageView) findViewById(R.id.iv_copy);
        this.s.setVisibility(8);
        this.p = (RelativeLayout) findViewById(R.id.rl_blocked_card_mask);
        this.f18205b = (PinEntryView) findViewById(R.id.otpView);
        this.f18205b.setOnPinEnteredListener(this);
        TextView textView = (TextView) findViewById(R.id.tv_forgot_passcode);
        this.f18211h = (TextView) findViewById(R.id.tv_passcode_error);
        this.j = (ViewFlipper) findViewById(R.id.vf_view_manage_cards);
        this.k = (TextView) findViewById(R.id.tv_expiry_date);
        this.l = (TextView) findViewById(R.id.tv_cvv);
        this.m = (TextView) findViewById(R.id.tv_card_number);
        this.n = (ImageView) findViewById(R.id.iv_card_type_logo);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.o = (LinearLayout) findViewById(R.id.ll_card_details);
        this.t = (TextView) findViewById(R.id.passcodeTitle);
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankDebitCardView.this.e(view);
            }
        });
        this.f18212i = new ProgressDialog(this.f18204a);
        this.f18210g.setText(R.string.action_view_details);
        this.f18210g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankDebitCardView.this.d(view);
            }
        });
        if (k.b()) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BankDebitCardView.this.c(view);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankDebitCardView.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        if (this.f18207d != c.BLOCK_CARD && this.f18207d != c.RESTRICTED_BLOCK && this.f18207d != c.MASKED_CARD) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f18204a, "bank_saving_account", "copy_icon_used", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            h();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (!com.paytm.utility.b.c(this.f18204a)) {
            Context context = this.f18204a;
            com.paytm.utility.b.a(context, context.getString(R.string.pb_check_your_network));
        } else if (!net.one97.paytm.bankCommon.h.b.a(this.f18204a)) {
            a();
        } else {
            this.f18206c = 0;
            g();
            b();
            setPasscodeStatus(true);
            setPasscodeTitle(this.f18204a.getString(R.string.debit_view_details));
            a aVar = this.q;
            if (aVar != null) {
                aVar.g();
            }
            a(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.u.onClickForgotPassword();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(false);
        b();
        setPasscodeStatus(false);
        b(false);
        a aVar = this.q;
        if (aVar != null) {
            aVar.h();
        }
    }

    public final void a() {
        this.f18204a.startActivity(new Intent(this.f18204a, o.a().getAJRSetPasscodeClass()));
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (com.paytm.utility.b.c(this.f18204a)) {
            c(true);
            b(false);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            Context context = this.f18204a;
            String vdcCardAlias = this.f18208e.getVdcCardAlias();
            a.c cVar = a.c.PAYMENTSBANK;
            a.b bVar = a.b.SILENT;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("User-Token", str);
            hashMap2.put("Content-Type", "application/json");
            hashMap2.put("channel", UpiConstants.B2C_ANDROID);
            net.one97.paytm.bankCommon.mapping.g.a();
            net.one97.paytm.bankCommon.g.a aVar = new net.one97.paytm.bankCommon.g.a(j.a(com.paytm.utility.b.e(context, net.one97.paytm.bankCommon.utils.d.a(UpiConstantServiceApi.KEY_PPB_CARD_DETAILS).replace("{cardNumberAlias}", vdcCardAlias)), new boolean[0]), (g.b) this, (g.a) this, (IJRPaytmDataModel) new PBCardDetailModel(), (Map<String, String>) null, (Map<String, String>) hashMap2, cVar, bVar, (HashMap<String, String>) hashMap);
            this.f18204a.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(aVar);
        }
    }

    public final void b() {
        net.one97.paytm.common.widgets.a.a(this.j, a.C0884a.LEFT_RIGHT);
    }

    public final void a(boolean z) {
        View currentFocus;
        if (getActivity() != null && (currentFocus = getActivity().getCurrentFocus()) != null) {
            if (z) {
                this.f18209f.showSoftInput(currentFocus, 0);
            } else {
                this.f18209f.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c(false);
        this.f18206c = 0;
        this.f18211h.setText(networkCustomError.getAlertMessage());
        b(true);
        f.a((Context) getActivity(), networkCustomError, i2);
    }

    private void g() {
        this.f18205b.setText("");
        this.f18205b.requestFocus();
    }

    public final void b(boolean z) {
        if (z) {
            g();
            this.f18211h.setVisibility(0);
        } else {
            this.f18211h.setVisibility(4);
        }
        this.f18205b.setDigitBackground(z ? net.one97.paytm.bankOpen.R.drawable.pin_view_red_bg : R.drawable.pin_view_gray_bg);
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        if (z) {
            try {
                if (!this.f18212i.isShowing()) {
                    this.f18212i = ProgressDialog.show(this.f18204a, "", this.f18204a.getString(R.string.pb_please_wait_progress_msg), true);
                }
            } catch (Exception unused) {
            }
        } else if (this.f18212i.isShowing()) {
            this.f18212i.dismiss();
        }
    }

    private static String c(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "-");
        String substring = stringTokenizer.nextToken().substring(2);
        String nextToken = stringTokenizer.nextToken();
        return nextToken + "/" + substring;
    }

    public final void a(c cVar) {
        setVisibility(0);
        this.f18207d = cVar;
        a.a(cVar);
        if (cVar == c.MASKED_CARD) {
            this.s.setVisibility(8);
            this.p.setVisibility(8);
            this.o.setVisibility(4);
            this.f18210g.setVisibility(0);
            CustProductList custProductList = this.f18208e;
            if (custProductList != null && !TextUtils.isEmpty(custProductList.getVdcMaskedCardNum())) {
                this.m.setText(this.f18208e.getVdcMaskedCardNum().replace("-", "  "));
            }
        } else if (cVar == c.FULL_CARD) {
            this.s.setVisibility(0);
            this.p.setVisibility(8);
            this.o.setVisibility(0);
            this.f18210g.setVisibility(8);
            a.a((a.C0308a) new a.C0308a() {
                public final void onCardTimerFinish() {
                    BankDebitCardView.this.i();
                }
            });
            PBCardDetailModel pBCardDetailModel = this.r;
            if (pBCardDetailModel != null) {
                a.a(pBCardDetailModel);
                if (!TextUtils.isEmpty(this.r.getExpiration())) {
                    this.k.setText(c(this.r.getExpiration()));
                }
                if (!TextUtils.isEmpty(this.r.getCvv())) {
                    this.l.setText(this.r.getCvv());
                }
                if (!TextUtils.isEmpty(this.r.getPan())) {
                    this.m.setText(com.paytm.utility.b.i("  ", this.r.getPan()));
                    if (this.s.getVisibility() == 0) {
                        this.m.setOnLongClickListener(new View.OnLongClickListener() {
                            public final boolean onLongClick(View view) {
                                return BankDebitCardView.this.a(view);
                            }
                        });
                    } else {
                        this.m.setOnLongClickListener((View.OnLongClickListener) null);
                    }
                }
            }
        } else if (cVar == c.BLOCK_CARD || cVar == c.RESTRICTED_BLOCK) {
            a.c();
            this.o.setVisibility(8);
            this.s.setVisibility(8);
            this.p.setVisibility(0);
            this.f18210g.setVisibility(4);
            CustProductList custProductList2 = this.f18208e;
            if (custProductList2 != null && !TextUtils.isEmpty(custProductList2.getVdcMaskedCardNum())) {
                this.m.setText(this.f18208e.getVdcMaskedCardNum().replace("-", "  "));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        g();
        a(c.MASKED_CARD);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        h();
        return false;
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        if (com.paytm.utility.b.c(this.f18204a)) {
            c(true);
            b(false);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f c2 = net.one97.paytm.paymentsBank.b.a.c(this.f18204a, str, this.f18208e.getVdcCardAlias(), this, this, a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
            this.f18204a.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(c2);
        }
    }

    private void a(PBCardDetailModel pBCardDetailModel) {
        if (pBCardDetailModel != null) {
            if (!TextUtils.isEmpty(pBCardDetailModel.getErrorMessage())) {
                this.f18211h.setText(pBCardDetailModel.getErrorMessage());
                b(true);
                a(true);
                return;
            }
            a(c.FULL_CARD);
        }
    }

    private void h() {
        ((ClipboardManager) this.f18204a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("account", this.m.getText().toString()));
        Context context = this.f18204a;
        Toast.makeText(context, context.getString(R.string.card_num_copied_clipboard), 0).show();
    }

    public final void d() {
        if (!net.one97.paytm.bankCommon.h.b.a(this.f18204a)) {
            a();
            return;
        }
        this.f18206c = 2;
        g();
        String string = this.f18204a.getString(R.string.enter_passcode_to_block_card);
        String string2 = this.f18204a.getString(R.string.pb_pdc_temp_block);
        int indexOf = string.indexOf(string2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, string2.length() + indexOf, 33);
        }
        setPasscodeTitle(spannableStringBuilder);
        b();
        setPasscodeStatus(true);
        a(true);
    }

    public final boolean e() {
        try {
            if (this.j == null || this.j.getDisplayedChild() != 1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        if (com.paytm.utility.b.c(this.f18204a)) {
            c(true);
            b(false);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f b2 = net.one97.paytm.paymentsBank.b.a.b(this.f18204a, str, this.f18208e.getVdcCardAlias(), this, this, a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
            this.f18204a.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(b2);
        }
    }

    public Bitmap getBitmap() {
        findViewById(R.id.db_card_layout_root).setDrawingCacheEnabled(true);
        return findViewById(R.id.db_card_layout_root).getDrawingCache();
    }

    public final void af_() {
        b(false);
    }

    public void setForgotPasswordCallback(b bVar) {
        this.u = bVar;
    }

    public final void a(String str) {
        try {
            net.one97.paytm.bankCommon.utils.g gVar = net.one97.paytm.bankCommon.utils.g.f16329a;
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.bankCommon.utils.g.a(this.f18204a, this.f18205b.getText().toString(), new net.one97.paytm.bankCommon.f.b<String>() {
                public final void a(String str, String str2) {
                    if (!(BankDebitCardView.this.f18204a instanceof Activity) || !((Activity) BankDebitCardView.this.f18204a).isFinishing()) {
                        BankDebitCardView.this.c(false);
                        if (!TextUtils.isEmpty(str)) {
                            BankDebitCardView.this.b(false);
                            if (BankDebitCardView.this.f18206c == 1) {
                                BankDebitCardView.this.d(str);
                            } else if (BankDebitCardView.this.f18206c == 2) {
                                BankDebitCardView.this.e(str);
                            } else {
                                BankDebitCardView.this.b(str);
                            }
                        } else {
                            BankDebitCardView.this.f18211h.setText(str2);
                            BankDebitCardView.this.b(true);
                        }
                    }
                }

                public final void a(int i2, NetworkCustomError networkCustomError) {
                    try {
                        BankDebitCardView.this.c(false);
                        f.a((Context) BankDebitCardView.this.getActivity(), networkCustomError, i2);
                    } catch (Exception unused) {
                    }
                }
            });
            if (a2 == null) {
                return;
            }
            if (com.paytm.utility.b.c(this.f18204a)) {
                c(true);
                b(false);
                a(false);
                this.f18204a.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a2);
                return;
            }
            com.paytm.utility.b.a(this.f18204a, this.f18204a.getString(R.string.pb_check_your_network));
            if (this.q != null) {
                this.q.h();
            }
            b();
            setPasscodeStatus(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
