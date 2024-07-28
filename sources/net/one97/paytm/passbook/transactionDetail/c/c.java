package net.one97.paytm.passbook.transactionDetail.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import com.paytm.utility.v;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.a;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.utility.InteractiveScrollView;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.UpiConstants;

public class c extends h {
    private RelativeLayout A;
    private TextView B;
    private TextView C;
    private int D;
    private TextView E;
    private RelativeLayout F;
    private ImageView G;
    private Runnable H = new Runnable() {
        public final void run() {
            c.this.m();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private TextView f59105a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f59106b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f59107c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f59108d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f59109e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f59110f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f59111g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f59112h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f59113i;
    private ImageView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private CJRTransaction q;
    private String r;
    private LinearLayout s;
    private LinearLayout t;
    private InteractiveScrollView u;
    private TextView v;
    private View w;
    private RelativeLayout x;
    private RelativeLayout y;
    private TextView z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void n() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pass_fragment_transaction_offline_payment, (ViewGroup) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.back_arrow_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.f(view);
            }
        });
        view.findViewById(R.id.share_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.e(view);
            }
        });
        Bundle arguments = getArguments();
        this.q = (CJRTransaction) arguments.getSerializable("passbook_detail_data");
        this.r = (String) arguments.getSerializable("EXTENDED_TXN_INFO");
        this.D = arguments.getInt("sub_wallet_type", -1);
        this.f59111g = (TextView) view.findViewById(R.id.status_tv);
        this.f59112h = (TextView) view.findViewById(R.id.amount_tv);
        this.f59113i = (TextView) view.findViewById(R.id.date_time_tv);
        this.E = (TextView) view.findViewById(R.id.tagTv);
        this.j = (ImageView) view.findViewById(R.id.status_icon);
        this.l = (ImageView) view.findViewById(R.id.imv1);
        this.k = (TextView) view.findViewById(R.id.title1_tv);
        this.m = (ImageView) view.findViewById(R.id.imv2);
        this.n = (ImageView) view.findViewById(R.id.imv3);
        this.o = (TextView) view.findViewById(R.id.title2_tv);
        this.y = (RelativeLayout) view.findViewById(R.id.need_help_rl);
        this.p = (TextView) view.findViewById(R.id.repeat_payment_tv);
        this.v = (TextView) view.findViewById(R.id.on_hold_tv);
        this.F = (RelativeLayout) view.findViewById(R.id.repeat_payment_rl);
        this.v.setVisibility(8);
        this.G = (ImageView) view.findViewById(R.id.back_arrow_imv);
        this.z = (TextView) view.findViewById(R.id.recent_transaction_tv);
        this.A = (RelativeLayout) view.findViewById(R.id.recent_transaction_rl);
        this.u = (InteractiveScrollView) view.findViewById(R.id.scroll_view);
        this.u.setOnBottomReachedListener($$Lambda$c$cEwv62k07h5QNpUwnwSzOFJ3Q.INSTANCE);
        this.f59105a = (TextView) view.findViewById(R.id.txt1);
        this.f59106b = (TextView) view.findViewById(R.id.txt2);
        this.f59107c = (TextView) view.findViewById(R.id.txt3);
        this.f59108d = (TextView) view.findViewById(R.id.txt4);
        this.f59109e = (TextView) view.findViewById(R.id.txt5);
        this.f59110f = (TextView) view.findViewById(R.id.txt6);
        this.w = view.findViewById(R.id.seprator_view);
        this.x = (RelativeLayout) view.findViewById(R.id.top_container_rl);
        this.s = (LinearLayout) view.findViewById(R.id.transaction_details_layout);
        this.t = (LinearLayout) view.findViewById(R.id.txnReversalLayout);
        this.y.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.d(view);
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.c(view);
            }
        });
        this.B = (TextView) view.findViewById(R.id.tvClosingBalance);
        this.C = (TextView) view.findViewById(R.id.deviderClosingBalance);
        try {
            if (!TextUtils.isEmpty(this.q.getmNarration2())) {
                str = this.q.getmNarration2();
            } else if ("CR".equalsIgnoreCase(this.q.getTxnType())) {
                str = getString(R.string.money_received);
            } else {
                str = getString(R.string.money_sent);
            }
            this.f59111g.setText(str);
            String string = getString(R.string.closing_balance_rs);
            String str2 = null;
            String txnStatus = this.q.getTxnStatus();
            if ("SUCCESS".equalsIgnoreCase(txnStatus)) {
                this.j.setImageResource(R.drawable.pass_ic_tick);
                this.j.setVisibility(8);
            } else {
                if (!"PENDING".equalsIgnoreCase(txnStatus)) {
                    if (!"REFUNDED_BACK".equalsIgnoreCase(txnStatus)) {
                        this.j.setImageResource(R.drawable.pass_ic_failed1);
                    }
                }
                this.j.setImageResource(R.drawable.pass_ic_pending_copy);
            }
            e.a();
            boolean c2 = e.c();
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0 && c2) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.q.getExtendedTxnInfo().size()) {
                        if (!TextUtils.isEmpty(this.q.getExtendedTxnInfo().get(i2).getClosingBalance()) && this.D == Integer.parseInt(this.q.getExtendedTxnInfo().get(i2).getSubWalletType())) {
                            str2 = new DecimalFormat(q.a(Double.parseDouble(this.q.getExtendedTxnInfo().get(i2).getClosingBalance())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.q.getExtendedTxnInfo().get(i2).getClosingBalance()));
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            if (!c2 || this.D == -1) {
                this.B.setVisibility(8);
                this.C.setVisibility(8);
            } else {
                this.B.setVisibility(0);
                this.C.setVisibility(0);
                if (!TextUtils.isEmpty(str2)) {
                    this.B.setText(String.format(string, new Object[]{str2}));
                } else {
                    this.B.setText(String.format(string, new Object[]{"--.--"}));
                }
            }
            if (this.q.getTagInfo() != null && !TextUtils.isEmpty(this.q.getTagInfo().tag)) {
                this.E.setText(this.q.getTagInfo().tag);
                this.E.setVisibility(0);
            }
            a.a(PassbookTransactionDetailsActivity.a(this.q.getTxnAmount()), this.f59112h);
            TextView textView = this.f59113i;
            getActivity();
            textView.setText(PassbookTransactionDetailsActivity.b(this.q));
            if ("1".equalsIgnoreCase(this.q.getType())) {
                j();
            } else if ("72".equalsIgnoreCase(this.q.getType())) {
                i();
            } else if ("22".equalsIgnoreCase(this.q.getType())) {
                g();
            } else if ("8".equalsIgnoreCase(this.q.getType())) {
                h();
            } else if ("13".equalsIgnoreCase(this.q.getType())) {
                c();
            } else if ("14".equalsIgnoreCase(this.q.getType())) {
                f();
            } else if ("15".equalsIgnoreCase(this.q.getType())) {
                b();
            } else if ("47".equalsIgnoreCase(this.q.getType())) {
                d();
            } else if ("16".equalsIgnoreCase(this.q.getType())) {
                a();
            }
            this.A.setVisibility(0);
            this.A.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    c.this.a(view);
                }
            });
            net.one97.paytm.passbook.transactionDetail.a aVar = net.one97.paytm.passbook.transactionDetail.a.f59009a;
            this.z.setText(net.one97.paytm.passbook.transactionDetail.a.a(getContext(), this.q));
            if (!TextUtils.isEmpty(this.q.getRecentName()) && "1".equalsIgnoreCase(this.q.getType())) {
                this.z.setText(getString(R.string.recent_transaction_with_, this.q.getRecentName()));
            }
        } catch (Exception unused) {
        }
        if (!"1".equalsIgnoreCase(this.q.getType()) || TextUtils.isEmpty(this.q.getQrId()) || this.q.getTxnRepeatBtnEnable() == null || !this.q.getTxnRepeatBtnEnable().booleanValue()) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
        }
        this.F.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        if (isAdded()) {
            getActivity().finish();
        }
    }

    private void a() {
        this.p.setVisibility(8);
        if (!v.a(this.q.getTxnDesc1())) {
            this.k.setText(R.string.by1);
            this.f59105a.setText(R.string.f57071paytm);
            this.f59107c.setText(this.q.getTxnDesc1());
            this.f59106b.setVisibility(8);
        } else {
            this.k.setVisibility(8);
        }
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.in_your);
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 1) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
        } else {
            this.f59108d.setVisibility(8);
            this.f59109e.setVisibility(8);
            this.m.setVisibility(8);
            for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
                a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
            }
            this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        }
        this.v.setVisibility(8);
    }

    private void b() {
        this.p.setVisibility(8);
        this.k.setText(R.string.by1);
        this.f59105a.setText(R.string.f57071paytm);
        this.f59107c.setText(this.q.getTxnDesc1());
        this.f59106b.setVisibility(8);
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.in_your);
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 0) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
        } else {
            this.f59108d.setVisibility(8);
            this.f59109e.setVisibility(8);
            this.m.setVisibility(8);
            for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
                a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
            }
            this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        }
        this.v.setVisibility(8);
    }

    private void c() {
        this.p.setVisibility(8);
        this.k.setText(R.string.gv_to);
        this.f59106b.setVisibility(8);
        this.f59105a.setText(R.string.f57071paytm);
        this.f59107c.setText(this.q.getNarration());
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.pass_from_your);
        e();
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 0) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
        } else {
            this.f59108d.setVisibility(8);
            this.f59109e.setVisibility(8);
            this.m.setVisibility(8);
            for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
                a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
            }
            this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        }
        this.f59109e.setVisibility(0);
        if (!TextUtils.isEmpty(a.l(getContext()))) {
            this.f59109e.setText(a.l(getContext()));
        }
        this.v.setVisibility(8);
    }

    private void d() {
        this.p.setVisibility(8);
        this.k.setText(R.string.from1);
        this.f59106b.setVisibility(8);
        this.f59105a.setText(R.string.f57071paytm);
        this.f59107c.setText(this.q.getNarration());
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.pass_to_your);
        e();
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 0) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
        } else {
            this.f59108d.setVisibility(8);
            this.f59109e.setVisibility(8);
            this.m.setVisibility(8);
            for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
                a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
            }
            this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        }
        this.f59109e.setVisibility(0);
        if (!TextUtils.isEmpty(a.l(getContext()))) {
            this.f59109e.setText(a.l(getContext()));
        }
        this.v.setVisibility(8);
    }

    private void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_txn_against_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tvAgainst);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tvReversalReq);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tvTxnId);
        textView.setVisibility(0);
        textView.setText(R.string.pass_against);
        textView2.setVisibility(0);
        textView2.setText(R.string.pass_txn_rev_req);
        textView3.setVisibility(0);
        textView3.setText(String.format(getString(R.string.pass_txn_id), new Object[]{this.q.getTxnDescription1()}));
        this.t.setVisibility(0);
        this.t.addView(inflate);
    }

    private void f() {
        this.p.setVisibility(8);
        String txnStatus = this.q.getTxnStatus();
        if ("SUCCESS".equalsIgnoreCase(txnStatus)) {
            this.j.setImageResource(R.drawable.pass_ic_pending_copy);
            this.j.setVisibility(8);
        } else {
            "PENDING".equalsIgnoreCase(txnStatus);
        }
        if (!v.a(this.q.getTxnDesc1())) {
            this.k.setText(R.string.by1);
            this.f59105a.setText(R.string.f57071paytm);
            this.f59107c.setText(this.q.getTxnDesc1());
            this.f59106b.setVisibility(8);
        } else {
            this.k.setVisibility(8);
        }
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.in_your);
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 1) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
        } else {
            this.f59108d.setVisibility(8);
            this.f59109e.setVisibility(8);
            this.m.setVisibility(8);
            for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
                a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
            }
            this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        }
        this.v.setVisibility(8);
    }

    private void g() {
        this.p.setVisibility(8);
        String txnStatus = this.q.getTxnStatus();
        if ("SUCCESS".equalsIgnoreCase(txnStatus)) {
            this.j.setVisibility(0);
            this.j.setImageResource(R.drawable.pass_ic_pending_copy);
        } else if ("AWAITING_CONFIRMATION".equalsIgnoreCase(txnStatus)) {
            this.j.setVisibility(0);
            this.j.setImageResource(R.drawable.pass_ic_pending_copy);
        } else if ("PENDING".equalsIgnoreCase(txnStatus)) {
            this.j.setImageResource(R.drawable.pass_ic_pending_copy);
        } else if (!"REFUNDED_BACK".equalsIgnoreCase(txnStatus)) {
            this.j.setImageResource(R.drawable.pass_ic_failed1);
        }
        if (!v.a(this.q.getTxnDesc1())) {
            this.k.setText(R.string.by1);
            this.f59105a.setText(R.string.f57071paytm);
            TextView textView = this.f59107c;
            textView.setText("For " + this.q.getTxnDesc1());
            this.f59106b.setVisibility(8);
        } else {
            this.k.setVisibility(8);
        }
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.in_your);
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 1) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
        } else {
            this.f59108d.setVisibility(8);
            this.f59109e.setVisibility(8);
            this.m.setVisibility(8);
            for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
                a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
            }
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        }
        this.v.setVisibility(8);
    }

    private void h() {
        this.p.setVisibility(8);
        this.k.setText(R.string.for1);
        if (!v.a(this.q.getTxnDesc1())) {
            this.f59107c.setText(this.q.getTxnDesc1());
        } else {
            this.f59107c.setText(this.q.getTxnDesc3());
        }
        this.f59105a.setVisibility(8);
        this.f59106b.setVisibility(8);
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.in_your);
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 1) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setText(this.q.getTxnDesc1());
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
        } else {
            this.f59108d.setVisibility(8);
            this.f59109e.setVisibility(8);
            this.m.setVisibility(8);
            for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
                a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
            }
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        }
        this.v.setVisibility(8);
    }

    private void i() {
        this.p.setVisibility(8);
        String txnStatus = this.q.getTxnStatus();
        if ("SUCCESS".equalsIgnoreCase(txnStatus)) {
            this.j.setImageResource(R.drawable.pass_ic_pending_copy);
        } else {
            "PENDING".equalsIgnoreCase(txnStatus);
        }
        this.k.setText(R.string.by1);
        this.f59105a.setText(getString(R.string.pb_paytm_payments_bank));
        this.f59106b.setVisibility(8);
        TextView textView = this.f59107c;
        textView.setText(this.q.getNarration());
        w.a().a(this.q.getImageUrl()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.from_your);
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 1) {
            String string = getString(R.string.pass_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            this.f59109e.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59110f.setText(String.format(getString(R.string.gv_wallet_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
            return;
        }
        this.f59108d.setVisibility(8);
        this.f59109e.setVisibility(8);
        this.m.setVisibility(8);
        for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
            a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
        }
        if (this.D == n.GIFT_VOUCHER.getValue()) {
            this.f59110f.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
        } else {
            this.f59110f.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
        }
        PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59110f, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
    }

    private void j() {
        this.p.setVisibility(8);
        String txnStatus = this.q.getTxnStatus();
        if (!"SUCCESS".equalsIgnoreCase(txnStatus) && !"PENDING".equalsIgnoreCase(txnStatus)) {
            if ("REFUNDED_BACK".equalsIgnoreCase(txnStatus)) {
                this.j.setImageResource(R.drawable.pass_ic_failed1);
            } else if ("AWAITING_CONFIRMATION".equalsIgnoreCase(txnStatus)) {
                this.j.setImageResource(R.drawable.pass_ic_pending_copy);
            }
        }
        if (this.q.getType().equals("1")) {
            this.k.setText(R.string.to);
        } else {
            this.k.setText(R.string.at);
        }
        this.f59105a.setText(this.q.getTxnTo());
        String txnDescription1 = this.q.getTxnDescription1();
        this.f59106b.setText(String.format(getString(R.string.order_id_with_value_and_colon), new Object[]{txnDescription1}));
        if (!TextUtils.isEmpty(this.q.getTxnDesc1()) && this.q.getTxnDesc1().startsWith("Paytm")) {
            this.f59106b.setTextColor(b.c(getContext(), R.color.paytm_blue));
            this.f59106b.setOnClickListener(new View.OnClickListener(txnDescription1) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    c.this.a(this.f$1, view);
                }
            });
        }
        if (!TextUtils.isEmpty(this.q.getTxnDesc3())) {
            this.f59107c.setVisibility(0);
            this.f59107c.setText(this.q.getTxnDesc3());
            this.f59106b.setTypeface(Typeface.create("sans-serif-light", 0));
            this.n.setVisibility(0);
            this.l.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 10, 0, 0);
            this.f59106b.setLayoutParams(layoutParams);
            w.a().a(this.q.getImageUrl()).a(this.n, (com.squareup.picasso.e) null);
        } else {
            this.f59107c.setVisibility(8);
        }
        w.a().a(this.q.getImageUrl()).a((ah) new net.one97.paytm.passbook.customview.b()).a(this.l, (com.squareup.picasso.e) null);
        this.o.setText(R.string.from_your);
        if (this.q.getExtendedTxnInfo() == null || this.q.getExtendedTxnInfo().size() <= 1) {
            String string = getString(R.string.your_paytm_wallet);
            if (this.q.getExtendedTxnInfo() != null && this.q.getExtendedTxnInfo().size() > 0) {
                string = this.q.getExtendedTxnInfo().get(0).getDisplayName();
            }
            this.f59108d.setText(string);
            if (n.GIFT_VOUCHER.getValue() == Integer.parseInt(this.q.getExtendedTxnInfo().get(0).getSubWalletType())) {
                this.f59108d.setText(String.format(getString(R.string.gv_id), new Object[]{string, this.q.getExtendedTxnInfo().get(0).getWalletId()}));
            } else {
                this.f59108d.setText(string);
            }
            this.f59110f.setVisibility(8);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.f59109e.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
            } else {
                this.f59109e.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59109e, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.m.setImageDrawable(b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.m.setBackground(b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
            return;
        }
        this.f59108d.setVisibility(8);
        this.m.setVisibility(8);
        for (int i2 = 0; i2 < this.q.getExtendedTxnInfo().size(); i2++) {
            a(this.q.getExtendedTxnInfo().get(i2), this.q.getExtendedTxnInfo().size() > 1);
        }
        if (this.D == n.GIFT_VOUCHER.getValue()) {
            this.f59109e.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.q.getWalletOrderId()}));
        } else {
            this.f59109e.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.q.getWalletOrderId()}));
        }
        PassbookTransactionDetailsActivity.a(getContext(), (View) this.f59109e, this.q.getWalletOrderId(), getString(R.string.transaction_id_copied));
        this.f59110f.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        Intent intent = new Intent(getContext(), d.b().i());
        intent.putExtra(UpiConstants.FROM, "Order_history");
        intent.putExtra("order_id", str);
        startActivity(intent);
    }

    private void a(ExtendedTxnInfo extendedTxnInfo, boolean z2) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_transaction_breakups_layout, (ViewGroup) null);
        this.s.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.transaction_type_name_tv);
        if (n.GIFT_VOUCHER.getValue() == Integer.parseInt(extendedTxnInfo.getSubWalletType())) {
            textView.setText(String.format(getString(R.string.gv_id), new Object[]{extendedTxnInfo.getDisplayName(), extendedTxnInfo.getWalletId()}));
        } else {
            textView.setText(extendedTxnInfo.getDisplayName());
        }
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

    /* access modifiers changed from: private */
    public /* synthetic */ void m() {
        String str;
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            if (this.q != null) {
                str = this.q.getTxnDesc1();
            } else {
                str = "";
            }
            intent.putExtra("android.intent.extra.TEXT", str);
            View view = getView();
            this.G.setVisibility(8);
            int visibility = this.C.getVisibility();
            this.C.setVisibility(8);
            int visibility2 = this.B.getVisibility();
            this.B.setVisibility(8);
            int visibility3 = view.findViewById(R.id.share_imv).getVisibility();
            view.findViewById(R.id.share_imv).setVisibility(8);
            int visibility4 = view.findViewById(R.id.bottom_btn_ll).getVisibility();
            view.findViewById(R.id.bottom_btn_ll).setVisibility(8);
            int visibility5 = this.A.getVisibility();
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            view.findViewById(R.id.share_imv).setVisibility(visibility3);
            view.findViewById(R.id.bottom_btn_ll).setVisibility(visibility4);
            this.A.setVisibility(visibility5);
            this.G.setVisibility(0);
            this.C.setVisibility(visibility);
            this.B.setVisibility(visibility2);
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
                c.this.l();
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
            ((PassbookTransactionDetailsActivity) getActivity()).b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k();
    }

    private void k() {
        if (com.paytm.utility.b.c((Context) getActivity())) {
            Intent intent = new Intent(getContext(), RecentTransactionsActivity.class);
            intent.putExtra("data", this.q);
            startActivity(intent);
            if (this.D == n.GIFT_VOUCHER.getValue()) {
                q.a(getContext(), "gift_voucher", "gv_added_recent_link_clicked", (String) null, (String) null, "/passbook/gift-voucher", "gift_voucher");
                return;
            }
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.no_connection));
        builder.setMessage(getString(R.string.no_internet));
        builder.setPositiveButton(getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                c.this.a(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity) && isAdded()) {
            f b2 = d.b();
            b2.a("https://qr.paytm.in/" + this.q.getQrId(), (Activity) getActivity());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        d.b().a((Context) getActivity(), "https://paytm.com/offer/uber-introduces-a-new-feature-on-paytm/", getContext().getString(R.string.passbook_on_hold_txn_text));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity) && isAdded()) {
            ((PassbookTransactionDetailsActivity) getActivity()).c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        if (isAdded() && getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
            ((PassbookTransactionDetailsActivity) getActivity()).a(this.H);
        }
    }
}
