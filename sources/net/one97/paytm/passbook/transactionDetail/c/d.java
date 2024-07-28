package net.one97.paytm.passbook.transactionDetail.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.paytm.network.f;
import com.paytm.utility.v;
import com.squareup.picasso.w;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.one97.paytm.i.h;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;
import net.one97.paytm.passbook.mapping.a;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.utility.InteractiveScrollView;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class d extends h {
    private RelativeLayout A;
    private RelativeLayout B;
    private RelativeLayout C;
    private TextView D;
    private TextView E;
    private TextView F;
    private int G;
    private RelativeLayout H;
    /* access modifiers changed from: private */
    public LottieAnimationView I;
    private View J;
    private View K;
    private View L;
    private View M;
    private View N;
    private View O;
    private View P;
    private RelativeLayout Q;
    private RelativeLayout R;
    private TextView S;
    private TextView T;
    private TextView U;
    private Context V;
    private String W = "#000000";
    private TextView X;
    private Runnable Y = new Runnable() {
        public final void run() {
            d.this.d();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private TextView f59114a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f59115b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f59116c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f59117d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f59118e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f59119f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f59120g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f59121h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f59122i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private CJRTransaction s;
    private String t;
    private LinearLayout u;
    private LinearLayout v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private InteractiveScrollView z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void e() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pass_fragment_transaction_detail_p2p, (ViewGroup) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        String str3;
        View view2 = view;
        String str4 = "SUCCESS";
        super.onViewCreated(view, bundle);
        view2.findViewById(R.id.back_arrow_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.e(view);
            }
        });
        view2.findViewById(R.id.share_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.d(view);
            }
        });
        Bundle arguments = getArguments();
        this.s = (CJRTransaction) arguments.getSerializable("passbook_detail_data");
        this.t = (String) arguments.getSerializable("EXTENDED_TXN_INFO");
        this.G = arguments.getInt("sub_wallet_type", -1);
        this.f59122i = (TextView) view2.findViewById(R.id.status_tv);
        this.j = (TextView) view2.findViewById(R.id.amount_tv);
        this.k = (TextView) view2.findViewById(R.id.date_time_tv);
        this.X = (TextView) view2.findViewById(R.id.tagTv);
        this.l = (ImageView) view2.findViewById(R.id.status_icon);
        this.n = (ImageView) view2.findViewById(R.id.imv1);
        this.m = (TextView) view2.findViewById(R.id.title1_tv);
        this.o = (ImageView) view2.findViewById(R.id.imv2);
        this.p = (TextView) view2.findViewById(R.id.title2_tv);
        this.q = (TextView) view2.findViewById(R.id.need_help_tv);
        this.A = (RelativeLayout) view2.findViewById(R.id.need_help_rl);
        this.r = (TextView) view2.findViewById(R.id.repeat_payment_tv);
        this.v = (LinearLayout) view2.findViewById(R.id.pending_transaction_state_ll);
        this.w = (ImageView) view2.findViewById(R.id.tick_1);
        this.x = (ImageView) view2.findViewById(R.id.tick_2);
        this.y = (ImageView) view2.findViewById(R.id.tick_3);
        this.H = (RelativeLayout) view2.findViewById(R.id.topLayout);
        this.I = (LottieAnimationView) view2.findViewById(R.id.theme_animation);
        this.J = view2.findViewById(R.id.seprator_view);
        this.K = view2.findViewById(R.id.separator_view_2);
        this.L = view2.findViewById(R.id.view1);
        this.M = view2.findViewById(R.id.view2);
        this.N = view2.findViewById(R.id.view3);
        this.O = view2.findViewById(R.id.view4);
        this.Q = (RelativeLayout) view2.findViewById(R.id.rl_paytmwallet_info);
        this.R = (RelativeLayout) view2.findViewById(R.id.rl_sent_received_info);
        this.P = view2.findViewById(R.id.bottom_view);
        this.U = (TextView) view2.findViewById(R.id.rupee_sign);
        this.S = (TextView) view2.findViewById(R.id.back_arrow_imv);
        Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "font/back_android.ttf");
        this.S.setText("B");
        this.S.setTypeface(createFromAsset);
        this.T = (TextView) view2.findViewById(R.id.share_imv);
        Typeface createFromAsset2 = Typeface.createFromAsset(getActivity().getAssets(), "font/share_android.ttf");
        this.T.setText("S");
        this.T.setTypeface(createFromAsset2);
        this.z = (InteractiveScrollView) view2.findViewById(R.id.scroll_view);
        this.z.setOnBottomReachedListener($$Lambda$d$Tjfj8mBmtojQpZwHPdjGPMlvvM.INSTANCE);
        this.f59114a = (TextView) view2.findViewById(R.id.txt1);
        this.f59115b = (TextView) view2.findViewById(R.id.txt2);
        this.f59116c = (TextView) view2.findViewById(R.id.txt3);
        this.f59117d = (TextView) view2.findViewById(R.id.txt4);
        this.f59118e = (TextView) view2.findViewById(R.id.txt5);
        this.f59119f = (TextView) view2.findViewById(R.id.txt6);
        this.f59120g = (TextView) view2.findViewById(R.id.txt7);
        this.f59121h = (TextView) view2.findViewById(R.id.txt8);
        this.D = (TextView) view2.findViewById(R.id.recent_transaction_tv);
        this.B = (RelativeLayout) view2.findViewById(R.id.recent_transaction_rl);
        this.C = (RelativeLayout) view2.findViewById(R.id.repeat_payment_rl);
        this.u = (LinearLayout) view2.findViewById(R.id.transaction_details_layout);
        this.E = (TextView) view2.findViewById(R.id.tvClosingBalance);
        this.F = (TextView) view2.findViewById(R.id.deviderClosingBalance);
        try {
            if (!TextUtils.isEmpty(this.s.getmNarration2())) {
                str = this.s.getmNarration2();
            } else if ("CR".equalsIgnoreCase(this.s.getTxnType())) {
                str = getString(R.string.money_received);
            } else {
                str = getString(R.string.money_sent);
            }
            this.f59122i.setText(str);
            String string = getString(R.string.closing_balance_rs);
            String txnStatus = this.s.getTxnStatus();
            if (str4.equalsIgnoreCase(txnStatus)) {
                this.l.setImageResource(R.drawable.pass_ic_tick);
                this.l.setVisibility(8);
            } else if ("PENDING".equalsIgnoreCase(txnStatus)) {
                this.l.setImageResource(R.drawable.pass_ic_pending_copy);
            } else {
                this.l.setImageResource(R.drawable.pass_ic_failed1);
            }
            a.a(PassbookTransactionDetailsActivity.a(this.s.getTxnAmount()), this.j);
            TextView textView = this.k;
            getActivity();
            textView.setText(PassbookTransactionDetailsActivity.b(this.s));
            if (this.s.getTagInfo() != null && !TextUtils.isEmpty(this.s.getTagInfo().tag)) {
                this.X.setText(this.s.getTagInfo().tag);
                this.X.setVisibility(0);
            }
            e.a();
            boolean c2 = e.c();
            if (this.s.getExtendedTxnInfo() != null && this.s.getExtendedTxnInfo().size() > 0 && c2) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.s.getExtendedTxnInfo().size()) {
                        if (!TextUtils.isEmpty(this.s.getExtendedTxnInfo().get(i2).getClosingBalance()) && this.G == Integer.parseInt(this.s.getExtendedTxnInfo().get(i2).getSubWalletType())) {
                            str2 = str4;
                            str3 = new DecimalFormat(q.a(Double.parseDouble(this.s.getExtendedTxnInfo().get(i2).getClosingBalance())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.s.getExtendedTxnInfo().get(i2).getClosingBalance()));
                            break;
                        }
                        i2++;
                        str4 = str4;
                    } else {
                        break;
                    }
                }
            }
            str2 = str4;
            str3 = null;
            if (!c2 || this.G == -1) {
                this.E.setVisibility(8);
                this.F.setVisibility(8);
            } else {
                this.E.setVisibility(0);
                this.F.setVisibility(0);
                if (!TextUtils.isEmpty(str3)) {
                    this.E.setText(String.format(string, new Object[]{str3}));
                } else {
                    this.E.setText(String.format(string, new Object[]{"--.--"}));
                }
            }
            String type = this.s.getType();
            if ("69".equalsIgnoreCase(type)) {
                e.a();
                if (e.t()) {
                    a();
                }
                if ("CR".equalsIgnoreCase(this.s.getTxnType())) {
                    this.r.setVisibility(8);
                    this.m.setText(R.string.from1);
                    String txnDesc1 = this.s.getTxnDesc1();
                    if (txnDesc1.startsWith("From:")) {
                        txnDesc1 = txnDesc1.replace("From:", "").trim();
                    }
                    this.f59114a.setText(txnDesc1);
                    this.f59115b.setText(R.string.paytm_wallet_linked_to);
                    this.f59116c.setText(this.s.getTxnDescription1());
                    this.f59117d.setText(this.s.getmTxnDescription3());
                    w.a().a(R.drawable.pass_ic_default_user).a(this.n, (com.squareup.picasso.e) null);
                    this.u.setVisibility(8);
                    this.p.setText(R.string.in_your);
                    this.f59118e.setText(R.string.pass_paytm_wallet);
                    this.f59119f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.s.getWalletOrderId()}));
                    PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59119f, this.s.getWalletOrderId(), getString(R.string.transaction_id_copied));
                    this.f59120g.setVisibility(8);
                    this.o.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
                    this.o.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
                } else {
                    b();
                }
            } else if ("5".equalsIgnoreCase(type)) {
                e.a();
                if (e.t()) {
                    a();
                }
                this.r.setVisibility(8);
                this.s.getTxnStatus();
                if ("DR".equalsIgnoreCase(this.s.getTxnType())) {
                    this.m.setText(R.string.pass_to);
                    String txnDesc12 = this.s.getTxnDesc1();
                    if (txnDesc12.toLowerCase().startsWith("to:")) {
                        txnDesc12 = txnDesc12.substring(4);
                    }
                    this.f59114a.setText(txnDesc12);
                    this.f59115b.setVisibility(8);
                    this.f59116c.setText(this.s.getTxnDescription1());
                    this.f59117d.setText(this.s.getmTxnDescription3());
                    w.a().a(R.drawable.pass_ic_default_user).a(this.n, (com.squareup.picasso.e) null);
                    this.p.setText(R.string.from_your);
                    this.f59118e.setText(R.string.pass_paytm_wallet);
                    this.f59119f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.s.getWalletOrderId()}));
                    PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59119f, this.s.getWalletOrderId(), getString(R.string.transaction_id_copied));
                    this.f59120g.setVisibility(8);
                    this.u.setVisibility(8);
                    this.o.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
                    this.o.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
                } else {
                    this.m.setText(R.string.from1);
                    String txnDesc13 = this.s.getTxnDesc1();
                    if (txnDesc13.startsWith("From:")) {
                        txnDesc13 = txnDesc13.replace("From:", "").trim();
                    }
                    this.f59114a.setText(txnDesc13);
                    this.f59115b.setVisibility(8);
                    this.f59116c.setText(this.s.getTxnDescription1());
                    this.f59117d.setText(this.s.getmTxnDescription3());
                    w.a().a(R.drawable.pass_ic_default_user).a(this.n, (com.squareup.picasso.e) null);
                    this.p.setText(R.string.in_your);
                    this.f59118e.setText(R.string.pass_paytm_wallet);
                    this.f59119f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.s.getWalletOrderId()}));
                    PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59119f, this.s.getWalletOrderId(), getString(R.string.transaction_id_copied));
                    this.f59120g.setVisibility(8);
                    this.u.setVisibility(8);
                    this.o.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
                    this.o.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
                }
            } else if ("29".equalsIgnoreCase(type)) {
                this.r.setVisibility(8);
                String txnStatus2 = this.s.getTxnStatus();
                if (!str2.equalsIgnoreCase(txnStatus2)) {
                    if ("PENDING".equalsIgnoreCase(txnStatus2)) {
                        this.v.setVisibility(8);
                        w.a().a(R.drawable.pass_ic_pending_copy).a(this.x, (com.squareup.picasso.e) null);
                        w.a().a(R.drawable.pass_ic_pending_copy).a(this.y, (com.squareup.picasso.e) null);
                    } else {
                        this.v.setVisibility(8);
                    }
                }
                this.m.setText(R.string.to_camel);
                this.f59114a.setText(this.s.getTxnDesc4());
                TextView textView2 = this.f59115b;
                textView2.setText(getString(R.string.ac_no) + " - " + this.s.getTxnDesc3());
                this.f59116c.setVisibility(8);
                this.f59117d.setVisibility(8);
                w.a().a(this.s.getImageUrl()).a(this.n, (com.squareup.picasso.e) null);
                this.p.setText(R.string.from_your);
                this.f59118e.setText(getString(R.string.pass_paytm_wallet));
                this.f59119f.setText(this.s.getTxnDesc1());
                this.f59120g.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.s.getWalletOrderId()}));
                PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59120g, this.s.getWalletOrderId(), getString(R.string.transaction_id_copied));
                this.f59121h.setVisibility(8);
                this.o.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
                this.o.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
            } else if ("11".equalsIgnoreCase(type)) {
                this.r.setVisibility(8);
                if ("REFUNDED_BACK".equalsIgnoreCase(this.s.getTxnStatus())) {
                    this.l.setImageResource(R.drawable.pass_ic_failed1);
                }
                this.m.setText(R.string.to_camel);
                this.f59114a.setText(R.string.refunded_back_to_source);
                this.f59115b.setVisibility(8);
                this.f59116c.setVisibility(8);
                this.f59117d.setVisibility(8);
                w.a().a(this.s.getImageUrl()).a(this.n, (com.squareup.picasso.e) null);
                this.u.setVisibility(8);
                this.p.setText(R.string.from_your);
                this.f59118e.setText(getString(R.string.pass_paytm_wallet));
                this.f59119f.setVisibility(8);
                this.f59120g.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.s.getWalletOrderId()}));
                PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59120g, this.s.getWalletOrderId(), getString(R.string.transaction_id_copied));
                this.f59121h.setVisibility(8);
                this.o.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
                this.o.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
            }
            this.B.setVisibility(0);
            this.B.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.a(view);
                }
            });
            net.one97.paytm.passbook.transactionDetail.a aVar = net.one97.paytm.passbook.transactionDetail.a.f59009a;
            this.D.setText(net.one97.paytm.passbook.transactionDetail.a.a(getContext(), this.s));
        } catch (Exception unused) {
        }
        this.A.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.c(view);
            }
        });
        if ((this.s.getType().equalsIgnoreCase("5") || this.s.getType().equalsIgnoreCase("69")) && this.s.getTxnType().equalsIgnoreCase("DR")) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        this.C.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        if (isAdded()) {
            getActivity().finish();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.V = context;
    }

    private void a() {
        ThemeData a2;
        if (!TextUtils.isEmpty(this.s.getPaymentsThemeId()) && (a2 = net.one97.paytm.passbook.d.b().a((Context) getActivity(), this.s.getPaymentsThemeId())) != null) {
            this.l.setVisibility(8);
            if (a2.getBgcolor() != null && !TextUtils.isEmpty(a2.getBgcolor())) {
                this.H.setBackgroundColor(Color.parseColor(a2.getBgcolor()));
                this.P.setVisibility(8);
                this.Q.setBackgroundColor(Color.parseColor(a2.getBgcolor()));
                this.R.setBackgroundColor(Color.parseColor(a2.getBgcolor()));
                this.J.setBackgroundColor(Color.parseColor(a2.getBgcolor()));
                this.K.setBackgroundColor(Color.parseColor(a2.getBgcolor()));
                a(Color.parseColor(a2.getBgcolor()));
            }
            if (a2.getJsonData() != null) {
                this.I.setVisibility(0);
                this.I.cancelAnimation();
                b(a2.getJsonData());
            } else if (a2.getThemeId() != null && !TextUtils.isEmpty(a2.getThemeId())) {
                a(a2.getThemeId());
            }
            if (a2.getColor() != null && !TextUtils.isEmpty(a2.getColor())) {
                this.W = a2.getColor();
                this.f59122i.setTextColor(Color.parseColor(a2.getColor()));
                this.k.setTextColor(Color.parseColor(a2.getColor()));
                this.m.setTextColor(Color.parseColor(a2.getColor()));
                this.f59114a.setTextColor(Color.parseColor(a2.getColor()));
                this.f59115b.setTextColor(Color.parseColor(a2.getColor()));
                this.f59116c.setTextColor(Color.parseColor(a2.getColor()));
                this.f59117d.setTextColor(Color.parseColor(a2.getColor()));
                this.p.setTextColor(Color.parseColor(a2.getColor()));
                this.f59118e.setTextColor(Color.parseColor(a2.getColor()));
                this.f59119f.setTextColor(Color.parseColor(a2.getColor()));
                this.f59120g.setTextColor(Color.parseColor(a2.getColor()));
                this.f59121h.setTextColor(Color.parseColor(a2.getColor()));
                this.j.setTextColor(Color.parseColor(a2.getColor()));
                this.E.setTextColor(Color.parseColor(a2.getColor()));
                this.T.setTextColor(Color.parseColor(a2.getColor()));
                this.S.setTextColor(Color.parseColor(a2.getColor()));
                this.F.setTextColor(Color.parseColor(a2.getColor()));
                this.U.setTextColor(Color.parseColor(a2.getColor()));
            }
            if (a2.getWhiteNavText() != null && a2.getWhiteNavText().equalsIgnoreCase("0") && getActivity() != null) {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
        }
    }

    private void a(String str) {
        String str2;
        e.a();
        if (e.u() != null) {
            e.a();
            if (!e.u().isEmpty()) {
                StringBuilder sb = new StringBuilder();
                e.a();
                sb.append(e.u());
                sb.append(str);
                sb.append(".json");
                str2 = sb.toString();
                f.b(this.V).add(new StringRequest(0, str2, new Response.Listener<String>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        d.this.I.setVisibility(0);
                        d.this.I.cancelAnimation();
                        d.this.b((String) obj);
                    }
                }, new Response.ErrorListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                    }
                }));
            }
        }
        str2 = "https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/catalog/wallet/" + str + ".json";
        f.b(this.V).add(new StringRequest(0, str2, new Response.Listener<String>() {
            public final /* synthetic */ void onResponse(Object obj) {
                d.this.I.setVisibility(0);
                d.this.I.cancelAnimation();
                d.this.b((String) obj);
            }
        }, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
            }
        }));
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        LottieAnimationView lottieAnimationView = this.I;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimationFromJson(str, (String) null);
            this.I.setRepeatCount(-1);
            this.I.playAnimation();
        }
    }

    private void b() {
        this.r.setVisibility(8);
        this.m.setText(R.string.pass_to);
        String txnDesc1 = this.s.getTxnDesc1();
        if (txnDesc1.toLowerCase().startsWith("to:")) {
            txnDesc1 = txnDesc1.substring(4);
        }
        this.f59114a.setText(txnDesc1);
        this.f59115b.setVisibility(8);
        this.f59116c.setText(this.s.getTxnDescription1());
        if (!v.a(this.s.getmTxnDescription3())) {
            this.f59117d.setText(this.s.getmTxnDescription3());
        } else {
            this.f59117d.setVisibility(8);
        }
        w.a().a(R.drawable.pass_ic_default_user).a(this.n, (com.squareup.picasso.e) null);
        this.p.setText(R.string.from_your);
        if (this.s.getExtendedTxnInfo() == null || this.s.getExtendedTxnInfo().size() <= 0) {
            this.o.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            this.o.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
            this.f59118e.setText(R.string.your_paytm_wallet);
            if (this.G == n.GIFT_VOUCHER.getValue()) {
                this.f59119f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.s.getWalletOrderId()}));
            } else {
                this.f59119f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.s.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59119f, this.s.getWalletOrderId(), getString(R.string.transaction_id_copied));
            this.f59120g.setVisibility(8);
            return;
        }
        this.f59118e.setVisibility(8);
        this.f59119f.setVisibility(8);
        this.o.setVisibility(8);
        for (int i2 = 0; i2 < this.s.getExtendedTxnInfo().size(); i2++) {
            ExtendedTxnInfo extendedTxnInfo = this.s.getExtendedTxnInfo().get(i2);
            boolean z2 = this.s.getExtendedTxnInfo().size() > 1;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_transaction_breakups_layout, (ViewGroup) null);
            this.u.addView(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.transaction_type_name_tv);
            if (n.GIFT_VOUCHER.getValue() == Integer.parseInt(extendedTxnInfo.getSubWalletType())) {
                textView.setText(String.format(getString(R.string.gv_id), new Object[]{extendedTxnInfo.getDisplayName(), extendedTxnInfo.getWalletId()}));
            } else {
                textView.setText(extendedTxnInfo.getDisplayName());
            }
            textView.setTextColor(Color.parseColor(this.W));
            TextView textView2 = (TextView) inflate.findViewById(R.id.amount_tv);
            if (z2) {
                textView2.setVisibility(0);
                try {
                    textView2.setText(String.format(getString(R.string.rupee), new Object[]{com.paytm.utility.b.a(extendedTxnInfo.getAmount())}));
                } catch (NumberFormatException unused) {
                    String string = getString(R.string.rupee);
                    StringBuilder sb = new StringBuilder();
                    sb.append(extendedTxnInfo.getAmount());
                    textView2.setText(String.format(string, new Object[]{sb.toString()}));
                }
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = this.f59120g;
        textView3.setText(getString(R.string.transaction_id_success) + " " + this.s.getWalletOrderId());
        PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59120g, this.s.getWalletOrderId(), getString(R.string.transaction_id_copied));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        String str;
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            if (this.s != null) {
                str = this.s.getTxnDesc1();
            } else {
                str = "";
            }
            intent.putExtra("android.intent.extra.TEXT", str);
            View view = getView();
            int visibility = this.F.getVisibility();
            this.F.setVisibility(8);
            int visibility2 = this.E.getVisibility();
            this.E.setVisibility(8);
            int visibility3 = view.findViewById(R.id.share_imv).getVisibility();
            view.findViewById(R.id.share_imv).setVisibility(8);
            int visibility4 = view.findViewById(R.id.bottom_btn_ll).getVisibility();
            view.findViewById(R.id.bottom_btn_ll).setVisibility(8);
            int visibility5 = view.findViewById(R.id.back_arrow_imv).getVisibility();
            view.findViewById(R.id.back_arrow_imv).setVisibility(8);
            int visibility6 = this.B.getVisibility();
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            view.findViewById(R.id.share_imv).setVisibility(visibility3);
            view.findViewById(R.id.bottom_btn_ll).setVisibility(visibility4);
            view.findViewById(R.id.back_arrow_imv).setVisibility(visibility5);
            this.B.setVisibility(visibility6);
            this.F.setVisibility(visibility);
            this.E.setVisibility(visibility2);
            if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
                ((PassbookTransactionDetailsActivity) getActivity()).b();
            }
            String insertImage = MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), createBitmap, getString(R.string.title) + "-" + System.currentTimeMillis(), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.post_payment_share_title));
                if (createChooser.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(getActivity(), getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        super.onPause();
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                d.this.c();
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
            ((PassbookTransactionDetailsActivity) getActivity()).b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent(this.V, RecentTransactionsActivity.class);
        intent.putExtra("data", this.s);
        startActivity(intent);
        if (this.G == n.GIFT_VOUCHER.getValue()) {
            q.a(getContext(), "gift_voucher", "gv_added_recent_link_clicked", (String) null, (String) null, "/passbook/gift-voucher", "gift_voucher");
        }
    }

    private void a(int i2) {
        Window window;
        if (getActivity() != null && (window = getActivity().getWindow()) != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    decorView.setSystemUiVisibility(0);
                }
                window.setStatusBarColor(i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity) && isAdded()) {
            if (TextUtils.isEmpty(this.s.getTxnDescription1())) {
                Toast.makeText(this.V, getString(R.string.pass_repeat_payment_error_msg), 0).show();
                return;
            }
            net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
            b2.a("paytmmp://cash_wallet?featuretype=sendmoneymobile$recipient=" + this.s.getTxnDescription1(), (Activity) getActivity());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity) && isAdded()) {
            ((PassbookTransactionDetailsActivity) getActivity()).c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (isAdded() && getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
            ((PassbookTransactionDetailsActivity) getActivity()).a(this.Y);
        }
    }
}
