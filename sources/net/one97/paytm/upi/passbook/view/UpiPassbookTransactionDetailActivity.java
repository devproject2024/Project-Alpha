package net.one97.paytm.upi.passbook.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.e;
import androidx.lifecycle.k;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.h;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CJRReplacementReason;
import net.one97.paytm.upi.common.upi.MandateDetails;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.f.a;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.e.f;
import net.one97.paytm.upi.mandate.view.MandateListActivity;
import net.one97.paytm.upi.passbook.a.b;
import net.one97.paytm.upi.passbook.c.c;
import net.one97.paytm.upi.util.AnimationUtils;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.upi.util.UpiWebViewActivity;

public class UpiPassbookTransactionDetailActivity extends PaytmActivity implements b.C1378b {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private LinearLayout M;
    private TextView N;
    private ImageView O;
    /* access modifiers changed from: private */
    public UpiTransactionModelV2 P;
    private UpiPendingRequestModel Q;
    private RelativeLayout R;
    private b.a S;
    private Dialog T;
    private String U;
    private ConstraintLayout V;
    private ThemeData W;
    private LinearLayout X;
    private TextView Y;

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<String> f67724a = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private Context f67725b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f67726c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f67727d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f67728e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f67729f;

    /* renamed from: g  reason: collision with root package name */
    private ConstraintLayout f67730g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f67731h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f67732i;
    private Group j;
    private Group k;
    private Group l;
    private Group m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.S = (b.a) obj;
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getResources().getColor(R.color.color_f3f7f8));
        setContentView(R.layout.activity_upi_passbook_transaction_detail_v2);
        this.f67725b = this;
        this.Y = (TextView) findViewById(R.id.umnTextView);
        this.X = (LinearLayout) findViewById(R.id.viewHistory);
        this.r = (ImageView) findViewById(R.id.iv_payee_icon);
        this.p = (ImageView) findViewById(R.id.iv_status_icon);
        this.n = (ImageView) findViewById(R.id.iv_back_arrow);
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiPassbookTransactionDetailActivity.this.finish();
            }
        });
        this.o = (ImageView) findViewById(R.id.iv_share);
        this.q = (ImageView) findViewById(R.id.sender_icon_iv);
        this.w = (TextView) findViewById(R.id.tv_amount);
        this.y = (TextView) findViewById(R.id.tv_name_header);
        this.z = (TextView) findViewById(R.id.tv_vpa);
        this.B = (TextView) findViewById(R.id.tv_date);
        this.D = (TextView) findViewById(R.id.tv_note);
        this.R = (RelativeLayout) findViewById(R.id.btn_need_help);
        this.f67726c = (TextView) findViewById(R.id.repeat_payment_tv);
        this.E = (TextView) findViewById(R.id.sent_to_label_tv);
        this.F = (TextView) findViewById(R.id.sent_from_label_tv);
        this.G = (TextView) findViewById(R.id.tv_sender_source);
        this.H = (TextView) findViewById(R.id.tv_sender_bank);
        this.I = (TextView) findViewById(R.id.tv_status);
        this.f67730g = (ConstraintLayout) findViewById(R.id.main_content_layout);
        this.V = (ConstraintLayout) findViewById(R.id.timeline_layout);
        this.j = (Group) findViewById(R.id.message_group);
        this.J = (TextView) findViewById(R.id.tv_message_text);
        this.K = (TextView) findViewById(R.id.tv_reference_id);
        this.C = (TextView) findViewById(R.id.tv_transaction_id);
        this.V = (ConstraintLayout) findViewById(R.id.timeline_layout);
        this.M = (LinearLayout) findViewById(R.id.ll_mandate_status);
        this.O = (ImageView) findViewById(R.id.iv_mandate_status);
        this.N = (TextView) findViewById(R.id.tv_mandate_status);
        this.s = (ImageView) findViewById(R.id.iv_timeline_1);
        this.t = (ImageView) findViewById(R.id.iv_timeline_2);
        this.u = (ImageView) findViewById(R.id.iv_timeline_3);
        this.f67727d = (TextView) findViewById(R.id.tv_timeline_1);
        this.f67728e = (TextView) findViewById(R.id.tv_timeline_2);
        this.f67729f = (TextView) findViewById(R.id.tv_timeline_3);
        this.k = (Group) findViewById(R.id.timeline_group_1);
        this.l = (Group) findViewById(R.id.timeline_group_2);
        this.m = (Group) findViewById(R.id.timeline_group_3);
        this.f67731h = (RelativeLayout) findViewById(R.id.order_detail_rl);
        this.f67732i = (RelativeLayout) findViewById(R.id.recent_txn_rl);
        this.L = (TextView) findViewById(R.id.recent_txn_tv);
        if (getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            this.f67730g.setVisibility(8);
            this.U = getIntent().getStringExtra("EXTRA_DEEP_LINK_DATA");
        } else {
            this.P = (UpiTransactionModelV2) getIntent().getSerializableExtra("transaction");
            this.Q = (UpiPendingRequestModel) getIntent().getSerializableExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST);
        }
        this.S = new c(this, this.U, g.b());
        this.S.e();
    }

    public final void a(UpiTransactionModelV2 upiTransactionModelV2) {
        this.P = upiTransactionModelV2;
        this.f67730g.setVisibility(0);
    }

    private void a(int i2) {
        Window window = getWindow();
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

    public final void a() {
        String str;
        String str2;
        a aVar;
        UpiTransactionModelV2 upiTransactionModelV2 = this.P;
        if (upiTransactionModelV2 != null) {
            String themeId = upiTransactionModelV2.getThemeId();
            if (!TextUtils.isEmpty(themeId) && j() && (aVar = i.a().l) != null) {
                this.W = aVar.a(getApplicationContext(), themeId);
                ThemeData themeData = this.W;
                if (themeData != null && !TextUtils.isEmpty(themeData.getColor()) && !TextUtils.isEmpty(this.W.getBgcolor())) {
                    int parseColor = Color.parseColor(this.W.getColor());
                    int parseColor2 = Color.parseColor(this.W.getBgcolor());
                    e.a((ImageView) findViewById(R.id.iv_back_arrow), ColorStateList.valueOf(parseColor));
                    e.a((ImageView) findViewById(R.id.iv_share), ColorStateList.valueOf(parseColor));
                    this.I.setTextColor(parseColor);
                    ((TextView) findViewById(R.id.tv_rupee)).setTextColor(parseColor);
                    this.w.setTextColor(parseColor);
                    this.B.setTextColor(parseColor);
                    this.J.setTextColor(parseColor);
                    this.E.setTextColor(parseColor);
                    this.y.setTextColor(parseColor);
                    this.z.setTextColor(parseColor);
                    this.D.setTextColor(parseColor);
                    this.F.setTextColor(parseColor);
                    this.G.setTextColor(parseColor);
                    this.H.setTextColor(parseColor);
                    findViewById(R.id.blue_bg_1).setBackgroundColor(parseColor2);
                    findViewById(R.id.blue_bg_2).setBackgroundColor(parseColor2);
                    this.f67730g.setBackgroundColor(parseColor2);
                    String jsonData = this.W.getJsonData();
                    if (!TextUtils.isEmpty(jsonData)) {
                        AnimationUtils.setJsonLottieAnimation((LottieAnimationView) findViewById(R.id.lottieAnimationView), jsonData);
                    }
                    this.p.setVisibility(8);
                    a(parseColor2);
                }
            }
            TextView textView = this.L;
            int i2 = R.string.upi_recent_payments_with;
            Object[] objArr = new Object[1];
            String e2 = e();
            if (!TextUtils.isEmpty(e2) && e2.indexOf(32) > 0) {
                e2 = e2.substring(0, e2.indexOf(32));
            }
            objArr[0] = e2;
            textView.setText(getString(i2, objArr));
            this.w.setText(f.b(UpiAppUtils.priceToString(this.P.getAmount())));
            if ("CREDIT".equalsIgnoreCase(this.P.getTxnType())) {
                if (j()) {
                    this.p.setImageDrawable(androidx.core.content.b.a(this.f67725b, R.drawable.ic_tick));
                    this.I.setText(this.P.getDetailNarration());
                } else if ("REJECT".equalsIgnoreCase(this.P.getStatus()) || "FAILURE".equalsIgnoreCase(this.P.getStatus())) {
                    this.p.setImageResource(R.drawable.upi_txn_failed);
                    this.I.setText(this.P.getDetailNarration());
                } else {
                    this.p.setImageDrawable(androidx.core.content.b.a(this.f67725b, R.drawable.ic_pending_copy));
                }
                this.y.setText(this.P.getPayer().getmName());
                TextView textView2 = this.z;
                String str3 = this.P.getPayer().getmBankAccount();
                if (!TextUtils.isEmpty(str3)) {
                    str2 = getString(R.string.upi_account_no, new Object[]{UpiUtils.getFormattedMaskedAcc(str3)});
                } else {
                    str2 = getString(R.string.upi_address_value, new Object[]{this.P.getPayer().getmVpa()});
                }
                textView2.setText(str2);
                if (!TextUtils.isEmpty(this.P.getPayer().getmIfsc())) {
                    a(this.r, this.P.getPayer().getmIfsc());
                } else {
                    int convertDpToPixel = UpiAppUtils.convertDpToPixel(10.0f, this.f67725b);
                    this.r.setPadding(convertDpToPixel, convertDpToPixel, convertDpToPixel, convertDpToPixel);
                    this.r.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.ic_bhim));
                }
                a(this.q, this.P.getPayee().getmIfsc());
                this.B.setText(this.P.getDate());
                this.K.setText(String.format(getString(R.string.upi_rrn), new Object[]{this.P.getRrn()}));
                this.C.setText(String.format(getString(R.string.upi_address_value), new Object[]{this.P.getTxnId()}));
                if (!"COLLECT".equalsIgnoreCase(this.P.getPayer().getmIfsc()) || (!"REJECT".equalsIgnoreCase(this.P.getStatus()) && !"FAILURE".equalsIgnoreCase(this.P.getStatus()))) {
                    this.F.setText(getString(R.string.upi_received_in));
                    this.E.setText(getString(R.string.upi_from_caps));
                    this.f67726c.setText(getString(R.string.send_money));
                } else {
                    this.F.setText(getString(R.string.upi_from_caps));
                    this.E.setText(getString(R.string.upi_by));
                    this.f67726c.setText(getString(R.string.request_money));
                }
                UpiTransactionModelV2 upiTransactionModelV22 = this.P;
                if (upiTransactionModelV22 != null && "CASHBACK".equalsIgnoreCase(upiTransactionModelV22.getCategory())) {
                    this.f67726c.setVisibility(8);
                }
                this.G.setText(this.P.getPayee().getmBankName());
                this.H.setText(getString(R.string.upi_account_no, new Object[]{UpiUtils.getFormattedMaskedAcc(this.P.getPayee().getmBankAccount())}));
                if ("MANDATE".equalsIgnoreCase(this.P.getBusinessType())) {
                    c();
                    this.M.setVisibility(0);
                    this.X.setVisibility(0);
                    this.O.setImageResource(R.drawable.upi_ic_recurring);
                    this.N.setText(getString(R.string.upi_recurring_payment));
                    this.p.setVisibility(4);
                } else {
                    findViewById(R.id.divider).setVisibility(8);
                }
            } else {
                if (j()) {
                    this.p.setImageDrawable(androidx.core.content.b.a(this.f67725b, R.drawable.ic_tick));
                    this.I.setText(this.P.getDetailNarration());
                } else if ("REJECT".equalsIgnoreCase(this.P.getStatus()) || "FAILURE".equalsIgnoreCase(this.P.getStatus())) {
                    this.p.setImageResource(R.drawable.upi_txn_failed);
                    this.f67726c.setText(getString(R.string.upi_retry_payment));
                    this.I.setText(this.P.getDetailNarration());
                    UpiTransactionModelV2 upiTransactionModelV23 = this.P;
                    if (upiTransactionModelV23 != null && "P2M".equals(upiTransactionModelV23.getCategory())) {
                        this.f67726c.setVisibility(8);
                    }
                    String string = getString(R.string.upi_passbook_failed_text);
                    String string2 = getString(R.string.upi_passbook_failed_text);
                    new SpannableString(string).setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this, R.color.color_222222)), 0, !TextUtils.isEmpty(string2) ? string2.indexOf(" ") : 0, 33);
                } else if ("DEEMED".equalsIgnoreCase(this.P.getStatus())) {
                    this.p.setImageDrawable(androidx.core.content.b.a(this.f67725b, R.drawable.ic_tick));
                    this.I.setText(this.P.getDetailNarration());
                } else {
                    this.p.setImageDrawable(androidx.core.content.b.a(this.f67725b, R.drawable.ic_pending_copy));
                    this.I.setText(this.P.getDetailNarration());
                    UpiTransactionModelV2 upiTransactionModelV24 = this.P;
                    if (upiTransactionModelV24 != null && "P2M".equals(upiTransactionModelV24.getCategory())) {
                        this.f67726c.setVisibility(8);
                    }
                }
                this.F.setText(getString(R.string.upi_from_caps));
                this.E.setText(getString(R.string.to_camel));
                this.y.setText(this.P.getPayee().getmName());
                TextView textView3 = this.z;
                String str4 = this.P.getPayee().getmBankAccount();
                if (!TextUtils.isEmpty(str4)) {
                    str = getString(R.string.upi_account_no, new Object[]{UpiUtils.getFormattedMaskedAcc(str4)});
                } else {
                    str = getString(R.string.upi_address_value, new Object[]{this.P.getPayee().getmVpa()});
                }
                textView3.setText(str);
                if (!TextUtils.isEmpty(this.P.getPayee().getmIfsc())) {
                    a(this.r, this.P.getPayee().getmIfsc());
                } else if (!TextUtils.isEmpty(this.P.getLogoUrl())) {
                    w.a().a(this.P.getLogoUrl()).a(R.drawable.upi_merchant_icon).b(R.drawable.upi_merchant_icon).a(this.r, (com.squareup.picasso.e) null);
                } else {
                    int convertDpToPixel2 = UpiAppUtils.convertDpToPixel(10.0f, this.f67725b);
                    this.r.setPadding(convertDpToPixel2, convertDpToPixel2, convertDpToPixel2, convertDpToPixel2);
                    this.r.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.ic_bhim));
                }
                a(this.q, this.P.getPayer().getmIfsc());
                this.B.setText(this.P.getDate());
                this.K.setText(String.format(getString(R.string.upi_rrn), new Object[]{this.P.getRrn()}));
                this.C.setText(String.format(getString(R.string.upi_address_value), new Object[]{this.P.getTxnId()}));
                this.G.setText(this.P.getPayer().getmBankName());
                this.H.setText(getString(R.string.upi_account_no, new Object[]{UpiUtils.getFormattedMaskedAcc(this.P.getPayer().getmBankAccount())}));
                if ((!TextUtils.isEmpty(g()) && UpiAppUtils.isValidAadhaar(g())) || "p2m".equalsIgnoreCase(this.P.getCategory())) {
                    this.f67726c.setVisibility(8);
                }
                if ("MANDATE".equalsIgnoreCase(this.P.getBusinessType())) {
                    c();
                    this.M.setVisibility(0);
                    this.X.setVisibility(0);
                    this.O.setImageResource(R.drawable.upi_ic_recurring);
                    this.N.setText(getString(R.string.upi_recurring_payment));
                    this.p.setVisibility(4);
                } else {
                    findViewById(R.id.divider).setVisibility(8);
                }
            }
            if ("02".equals(this.P.getmRefCategory()) && !TextUtils.isEmpty(this.P.getmRefUrl())) {
                this.f67731h.setVisibility(0);
            }
        } else if (this.Q != null) {
            UpiAppUtils.updateAmount(String.format(getString(R.string.rs_str), new Object[]{UpiAppUtils.priceToString(this.Q.getAmount())}), this.w);
            if ("RECEIVED".equalsIgnoreCase(this.Q.getDirection())) {
                this.x.setText(getString(R.string.upi_transaction_received_from_success));
                this.y.setText(this.Q.getPayerVa());
                this.y.setVisibility(8);
                this.z.setText(getString(R.string.upi_address_value, new Object[]{this.Q.getPayerVa()}));
                this.A.setText(getString(R.string.upi_transaction_added_to));
                this.v.setText(getString(R.string.upi_request_received));
                this.r.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.ic_bhim));
            } else {
                this.x.setText(getString(R.string.upi_transaction_transferred_successfully));
                this.y.setText(this.Q.getPayeeVa());
                this.y.setVisibility(8);
                this.z.setText(getString(R.string.upi_address_value, new Object[]{this.Q.getPayeeVa()}));
                this.A.setText(getString(R.string.upi_transaction_transferred_using));
                this.v.setText(getString(R.string.upi_request_sent));
                this.r.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.ic_bhim));
            }
            this.B.setText(this.Q.getDate());
            this.C.setText(String.format(getString(R.string.upi_address_value), new Object[]{this.Q.getSeqNo()}));
        }
        if (TextUtils.isEmpty(this.P.getNote()) || "NA".equalsIgnoreCase(this.P.getNote())) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
            TextView textView4 = this.D;
            textView4.setText("\" " + this.P.getNote() + " \"");
        }
        this.R.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!UpiPassbookTransactionDetailActivity.this.j() || !UpiPassbookTransactionDetailActivity.this.P.isOnUsMerchant() || UpiPassbookTransactionDetailActivity.this.P.getMerchantOrderId() == null || UpiPassbookTransactionDetailActivity.this.P.getMerchantOrderId().isEmpty()) {
                    UpiPassbookTransactionDetailActivity.c(UpiPassbookTransactionDetailActivity.this);
                    return;
                }
                UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity = UpiPassbookTransactionDetailActivity.this;
                UpiPassbookTransactionDetailActivity.a(upiPassbookTransactionDetailActivity, upiPassbookTransactionDetailActivity.P.getMerchantOrderId());
            }
        });
        this.f67726c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiPassbookTransactionDetailActivity.d(UpiPassbookTransactionDetailActivity.this);
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiPassbookTransactionDetailActivity.e(UpiPassbookTransactionDetailActivity.this);
            }
        });
        this.f67731h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiWebViewActivity.Companion companion = UpiWebViewActivity.Companion;
                UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity = UpiPassbookTransactionDetailActivity.this;
                companion.startActivity(upiPassbookTransactionDetailActivity, upiPassbookTransactionDetailActivity.P.getmRefUrl());
            }
        });
        this.f67732i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (UpiPassbookTransactionDetailActivity.this.P.getMandateDetails() == null) {
                    UpiPassbookTransactionDetailActivity.f(UpiPassbookTransactionDetailActivity.this);
                } else {
                    UpiPassbookTransactionDetailActivity.this.startActivity(new Intent(UpiPassbookTransactionDetailActivity.this, MandateListActivity.class));
                }
            }
        });
        this.K.setOnLongClickListener(new View.OnLongClickListener() {
            public final boolean onLongClick(View view) {
                ((ClipboardManager) UpiPassbookTransactionDetailActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, UpiPassbookTransactionDetailActivity.this.P.getRrn()));
                UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity = UpiPassbookTransactionDetailActivity.this;
                Toast.makeText(upiPassbookTransactionDetailActivity, upiPassbookTransactionDetailActivity.getString(R.string.upi_ref_id_copy_text), 0).show();
                return true;
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiPassbookTransactionDetailActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        MandateDetails mandateDetails = this.P.getMandateDetails();
        if (mandateDetails != null) {
            f.a aVar = net.one97.paytm.upi.mandate.e.f.f67183a;
            String str = this.P.getPayee().getmName();
            boolean isRecurring = mandateDetails.isRecurring();
            String umn = mandateDetails.getUmn();
            k.c(str, "payeeName");
            k.c(umn, "umn");
            Bundle bundle = new Bundle();
            bundle.putString("payee_name", str);
            bundle.putString("umn", umn);
            bundle.putBoolean("is_recurring", isRecurring);
            net.one97.paytm.upi.mandate.e.f fVar = new net.one97.paytm.upi.mandate.e.f();
            fVar.setArguments(bundle);
            fVar.show(getSupportFragmentManager(), "");
        }
    }

    private void c() {
        this.f67726c.setVisibility(8);
        this.Y.setVisibility(0);
        this.Y.setText(getString(R.string.upi_umn_no, new Object[]{this.P.getMandateDetails().getUmn()}));
        this.L.setText(getString(R.string.upi_mandate_scheduled_payment_details));
        ((ImageView) findViewById(R.id.icon4)).setImageResource(R.drawable.upi_ic_payment_details);
    }

    private String d() {
        if ("Credit".equalsIgnoreCase(this.P.getTxnType())) {
            String str = this.P.getPayer().getmBankAccount();
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return this.P.getPayer().getmVpa();
        }
        String str2 = this.P.getPayee().getmBankAccount();
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return this.P.getPayee().getmVpa();
    }

    private String e() {
        if ("Credit".equalsIgnoreCase(this.P.getTxnType())) {
            return this.P.getPayer().getmName();
        }
        return this.P.getPayee().getmName();
    }

    private String f() {
        if ("Credit".equalsIgnoreCase(this.P.getTxnType())) {
            return this.P.getPayer().getmIfsc();
        }
        return this.P.getPayee().getmIfsc();
    }

    private String g() {
        String str = this.P.getPayee().getmBankAccount();
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return getString(R.string.upi_address_value, new Object[]{this.P.getPayer().getmVpa()});
    }

    private void h() {
        UpiUtils.shareSuccessfulTransaction(this, this.f67730g, getString(R.string.post_payment_share_subject), "", getString(R.string.post_payment_share_title), 0);
        CJRSendGTMTag.sendNewCustomGTMEvents(this, "mt_p2p_new_v1", "share_clicked", "", "", "", CJRGTMConstants.MT_V4_UPI_PASSBOOK_SCREEN_NAME, "");
        a("share");
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 48) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                CustomDialog.showAlert(this.f67725b, "", "Please go to Settings and give Paytm app Storage permission.");
            } else {
                h();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onDestroy() {
        super.onDestroy();
        b.a aVar = this.S;
        if (aVar != null) {
            aVar.f();
        }
    }

    private void a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("ICIC")) {
            imageView.setImageDrawable(androidx.core.content.b.a(this.f67725b, R.drawable.icici_bank_logo));
        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.ic_bhim));
        } else if (!TextUtils.isEmpty(str)) {
            w.a().a(UpiRequestBuilder.getBankIconUrl(getApplicationContext(), str)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (com.squareup.picasso.e) null);
        }
    }

    public final void a(boolean z2) {
        if (!i()) {
            return;
        }
        if (z2) {
            if (this.T == null) {
                this.T = UpiAppUtils.getWalletStyleProgressDialog(this);
            }
            Dialog dialog = this.T;
            if (dialog != null && !dialog.isShowing()) {
                this.T.show();
                return;
            }
            return;
        }
        Dialog dialog2 = this.T;
        if (dialog2 != null && dialog2.isShowing()) {
            this.T.dismiss();
        }
    }

    public final void b() {
        if (i()) {
            Toast.makeText(this, getResources().getString(R.string.upi_some_went_wrong), 0).show();
            finish();
        }
    }

    private boolean i() {
        return getLifecycle().a().isAtLeast(k.b.RESUMED);
    }

    /* access modifiers changed from: private */
    public boolean j() {
        return "SUCCESS".equalsIgnoreCase(this.P.getStatus());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, String str, View view) {
        hVar.cancel();
        Intent intent = new Intent(this, i.a().m.e());
        intent.putExtra(UpiConstants.FROM, "UPI");
        intent.putExtra("order_id", str);
        startActivity(intent);
    }

    private void a(String str) {
        CJRSendGTMTag.sendNewCustomGTMEvents(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_HISTORY_ITEM_CLICKED, str, "", "", CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "");
    }

    static /* synthetic */ void a(UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity, String str) {
        h hVar = new h(upiPassbookTransactionDetailActivity);
        hVar.setTitle(upiPassbookTransactionDetailActivity.getString(R.string.needhelp_dialog_title));
        hVar.a(upiPassbookTransactionDetailActivity.getString(R.string.upi_contact_us_order_history));
        hVar.a(-3, upiPassbookTransactionDetailActivity.getResources().getString(R.string.upi_passbook_go_to_order_history), new View.OnClickListener(hVar, str) {
            private final /* synthetic */ h f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                UpiPassbookTransactionDetailActivity.this.a(this.f$1, this.f$2, view);
            }
        });
        hVar.setCancelable(true);
        hVar.show();
    }

    static /* synthetic */ void c(UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity) {
        CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
        cJRReplacementReason.setIssueText("UPI");
        cJRReplacementReason.setId(UpiConstants.CST_UPI_ID);
        i.a().m.a((Activity) upiPassbookTransactionDetailActivity, (Object) upiPassbookTransactionDetailActivity.P, cJRReplacementReason);
        CJRSendGTMTag.sendNewCustomGTMEvents(upiPassbookTransactionDetailActivity, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_NEED_HELP_CLICKED, "", "", "", CJRGTMConstants.MT_V4_UPI_PASSBOOK_SCREEN_NAME, "");
        upiPassbookTransactionDetailActivity.a("need help");
    }

    static /* synthetic */ void d(UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity) {
        String str;
        if (upiPassbookTransactionDetailActivity.f67726c.getText().toString().equalsIgnoreCase(upiPassbookTransactionDetailActivity.getString(R.string.upi_retry_payment))) {
            upiPassbookTransactionDetailActivity.a("retry payment");
            str = "retry_payment_clicked";
        } else if (upiPassbookTransactionDetailActivity.f67726c.getText().toString().equalsIgnoreCase(upiPassbookTransactionDetailActivity.getString(R.string.send_money))) {
            str = "send_money_clicked";
        } else if (upiPassbookTransactionDetailActivity.f67726c.getText().toString().equalsIgnoreCase(upiPassbookTransactionDetailActivity.getString(R.string.repeat_payment))) {
            upiPassbookTransactionDetailActivity.a("repeat payments");
            str = "repeat_payment_clicked";
        } else {
            str = "";
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(upiPassbookTransactionDetailActivity, "mt_p2p_new_v1", str, "", "", "", CJRGTMConstants.MT_V4_UPI_PASSBOOK_SCREEN_NAME, "");
        if (TextUtils.isEmpty(upiPassbookTransactionDetailActivity.d()) || !upiPassbookTransactionDetailActivity.d().contains("@")) {
            i.a().m.a((Activity) upiPassbookTransactionDetailActivity, UpiAppUtils.getMoneyTransferDeeplink() + "&account=" + upiPassbookTransactionDetailActivity.d() + "&pn=" + upiPassbookTransactionDetailActivity.e() + "&ifsc=" + upiPassbookTransactionDetailActivity.f());
        } else {
            i.a().m.a((Activity) upiPassbookTransactionDetailActivity, UpiAppUtils.getMoneyTransferDeeplink() + "&pa=" + upiPassbookTransactionDetailActivity.d() + "&pn=" + upiPassbookTransactionDetailActivity.e());
        }
        upiPassbookTransactionDetailActivity.finish();
    }

    static /* synthetic */ void e(UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity) {
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a(upiPassbookTransactionDetailActivity.f67725b, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            upiPassbookTransactionDetailActivity.h();
        } else {
            upiPassbookTransactionDetailActivity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 48);
        }
    }

    static /* synthetic */ void f(UpiPassbookTransactionDetailActivity upiPassbookTransactionDetailActivity) {
        String str;
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.EXTRA_ACCOUNT_NAME, upiPassbookTransactionDetailActivity.e());
        if ("Credit".equalsIgnoreCase(upiPassbookTransactionDetailActivity.P.getTxnType())) {
            str = upiPassbookTransactionDetailActivity.P.getPayer().getmBankName();
        } else {
            str = upiPassbookTransactionDetailActivity.P.getPayee().getmBankName();
        }
        bundle.putString(UpiConstants.EXTRA_BANK_NAME, str);
        bundle.putString(UpiConstants.EXTRA_IFSC, upiPassbookTransactionDetailActivity.f());
        bundle.putString(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, upiPassbookTransactionDetailActivity.d());
        i.a().m.b((Context) upiPassbookTransactionDetailActivity, bundle);
        CJRSendGTMTag.sendNewCustomGTMEvents(upiPassbookTransactionDetailActivity, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RECENT_PAYMENT_BENEFICIARY_CLICKED, "", "", "", CJRGTMConstants.MT_V4_UPI_PASSBOOK_SCREEN_NAME, "");
        upiPassbookTransactionDetailActivity.a("recent payments");
    }
}
