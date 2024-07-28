package net.one97.paytm.passbook.transactionDetail.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;
import net.one97.paytm.passbook.beans.postcard.ReceivedLifafaDetailsResponse;
import net.one97.paytm.passbook.beans.postcard.SentLifafaDetailsResponse;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.transactionDetail.b.d;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends h {
    private TextView A;
    private TextView B;
    private TextView C;
    private RelativeLayout D;
    private TextView E;
    private LinearLayout F;
    private TextView G;
    private TextView H;
    private TextView I;
    private View J;
    private LinearLayout K;
    private String L;
    private View M;
    private RelativeLayout N;
    private TextView O;
    private TextView P;
    private TextView Q;
    private int R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private View W;
    private ImageView X;
    private Runnable Y = new Runnable() {
        public final void run() {
            b.this.d();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRTransaction f59085a;

    /* renamed from: b  reason: collision with root package name */
    private String f59086b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f59087c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f59088d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f59089e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f59090f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f59091g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f59092h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f59093i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private String w = "SENT";
    private RelativeLayout x;
    private RelativeLayout y;
    private RelativeLayout z;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pass_fragment_transaction_detail_add_money, (ViewGroup) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x04cb, code lost:
        switch(r1) {
            case 0: goto L_0x0ff6;
            case 1: goto L_0x0ea0;
            case 2: goto L_0x0ea0;
            case 3: goto L_0x0dd1;
            case 4: goto L_0x0c91;
            case 5: goto L_0x0b51;
            case 6: goto L_0x0b4c;
            case 7: goto L_0x0a7c;
            case 8: goto L_0x09c3;
            case 9: goto L_0x09c3;
            case 10: goto L_0x09c3;
            case 11: goto L_0x09c3;
            case 12: goto L_0x09c3;
            case 13: goto L_0x09c3;
            case 14: goto L_0x09c3;
            case 15: goto L_0x0805;
            case 16: goto L_0x04d0;
            default: goto L_0x04ce;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r1 = r0.f59085a.getTxnStatus();
        r3 = net.one97.paytm.passbook.d.b();
        getActivity();
        r0.L = r3.x();
        r0.M.setVisibility(0);
        r0.m.setText(r0.f59085a.getTxnDesc2());
        r0.f59092h.setText(r0.f59085a.getTxnFrom());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0508, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getTxnDesc4()) != false) goto L_0x0521;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x050a, code lost:
        r3 = r0.n;
        r3.setText(r0.f59085a.getTxnDesc4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0521, code lost:
        r0.o.setVisibility(8);
        r3 = r0.f59085a.getImageUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0538, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getTxnHeading2()) == false) goto L_0x0575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x053e, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x0554;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0540, code lost:
        r0.k.setPadding(0, 0, 0, 0);
        com.squareup.picasso.w.a().a(r3).a(r0.k, (com.squareup.picasso.e) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x055e, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getmTxnFromImageUrl()) != false) goto L_0x0595;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0560, code lost:
        r0.t.setVisibility(0);
        r0.t.setText(r0.f59085a.getmTxnFromImageUrl().toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x057f, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getmTxnFromImageUrl()) != false) goto L_0x0595;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0581, code lost:
        r0.t.setVisibility(0);
        r0.t.setText(r0.f59085a.getmTxnFromImageUrl().toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0595, code lost:
        r0.p.setText(r0.f59085a.getTxnDesc3());
        r3 = r0.f59085a.getTxnTo();
        r0.f59093i.setVisibility(0);
        r0.f59093i.setText(java.lang.String.format(r3, new java.lang.Object[]{r0.L}));
        r0.q.setText(r0.f59085a.getTxnDesc1());
        r0.f59090f.setVisibility(8);
        r0.r.setVisibility(8);
        r3 = r0.f59085a.getmTxnToImageUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x05db, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x05dd, code lost:
        r0.l.setPadding(0, 0, 0, 0);
        com.squareup.picasso.w.a().a(r3).a(r0.l, (com.squareup.picasso.e) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x05f1, code lost:
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_gift_voucher_success_icon));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x060f, code lost:
        r0.D.setVisibility(0);
        r0.H.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0621, code lost:
        if ("FAILURE".equalsIgnoreCase(r1) == false) goto L_0x0629;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0623, code lost:
        r0.r.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0629, code lost:
        r0.r.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x062e, code lost:
        r0.G.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x063f, code lost:
        if (r0.f59085a.getExtendedTxnInfo().size() <= 0) goto L_0x0672;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0641, code lost:
        r1 = r0.f59085a.getExtendedTxnInfo().get(0).getExpiryTimeStamp();
        r0.r.setVisibility(0);
        r0.r.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.gv_expiry), new java.lang.Object[]{net.one97.paytm.passbook.utility.q.b(r1, "yyyy-MM-dd", "dd MMM yyyy")}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x067c, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getTxnHeading2()) == false) goto L_0x0689;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x067e, code lost:
        r0.s.setOnClickListener(new net.one97.paytm.passbook.transactionDetail.c.b.AnonymousClass6(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0689, code lost:
        r0.s.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0690, code lost:
        r0.N.setVisibility(0);
        r1 = java.lang.String.format(getString(net.one97.paytm.passbook.R.string.gv_order_id), new java.lang.Object[]{r0.f59085a.getTxnDescription1()});
        r3 = r0.f59085a.getTxnDescription1();
        r5 = r1.indexOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x06bd, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getTxnHeading2()) == false) goto L_0x06f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x06bf, code lost:
        r6 = new android.text.SpannableString(r1);
        r6.setSpan(new android.text.style.StyleSpan(1), r5, r3.length() + r5, 0);
        r6.setSpan(new android.text.style.ForegroundColorSpan(getResources().getColor(net.one97.paytm.passbook.R.color.color_00b9f5)), r5, r3.length() + r5, 0);
        r0.q.setText(r6);
        r0.q.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x06f7, code lost:
        r0.q.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x06fe, code lost:
        r0.O.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x070d, code lost:
        if (r0.f59085a.getExtendedTxnInfo().size() > 1) goto L_0x0759;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0723, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getExtendedTxnInfo().get(0).getWalletId()) != false) goto L_0x0751;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0725, code lost:
        r0.O.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.giftv_id), new java.lang.Object[]{r0.f59085a.getTxnHeading1(), r0.f59085a.getExtendedTxnInfo().get(0).getWalletId()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0751, code lost:
        r0.O.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0759, code lost:
        r1 = net.one97.paytm.passbook.d.b();
        getContext();
        r1 = r1.x();
        r3 = r0.O;
        r3.setText(getString(net.one97.paytm.passbook.R.string.no_of) + " " + r1 + ": " + r0.f59085a.getExtendedTxnInfo().size());
        r0.S.setVisibility(0);
        r0.S.setOnClickListener(new net.one97.paytm.passbook.transactionDetail.c.$$Lambda$b$khTg3QSlOLgCTtDdnE3uEQBg_N0(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x07ac, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getTxnHeading2()) == false) goto L_0x07b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x07ae, code lost:
        r0.q.setOnClickListener(new net.one97.paytm.passbook.transactionDetail.c.b.AnonymousClass7(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x07c0, code lost:
        if (r0.R != net.one97.paytm.passbook.utility.n.GIFT_VOUCHER.getValue()) goto L_0x07dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x07c2, code lost:
        r0.P.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.gv_wallet_tran_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x07dc, code lost:
        r0.P.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.gv_wallet_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x07f5, code lost:
        r0.Q.setText(r0.f59085a.getTxnDesc1());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x080f, code lost:
        if (android.text.TextUtils.isEmpty(r0.f59085a.getTxnDesc4()) != false) goto L_0x081b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0817, code lost:
        if (r0.f59085a.getThemeInfo() == null) goto L_0x081b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0819, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x081b, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x081c, code lost:
        if (r1 == false) goto L_0x091f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x081e, code lost:
        r1 = r0.f59085a.getType();
        r3 = r1.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x082a, code lost:
        if (r3 == 53) goto L_0x0847;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x082e, code lost:
        if (r3 == 56) goto L_0x083d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0832, code lost:
        if (r3 == 1691) goto L_0x0835;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0839, code lost:
        if (r1.equals("50") == false) goto L_0x0850;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x083b, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0843, code lost:
        if (r1.equals("8") == false) goto L_0x0850;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0845, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x084d, code lost:
        if (r1.equals("5") == false) goto L_0x0850;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x084f, code lost:
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0850, code lost:
        if (r6 == 0) goto L_0x0861;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0852, code lost:
        if (r6 == 1) goto L_0x085c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0854, code lost:
        if (r6 == 2) goto L_0x0857;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0857, code lost:
        r0.w = "RECEIVED";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x085c, code lost:
        r0.w = "SENT";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0861, code lost:
        r0.w = "RECEIVED";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0865, code lost:
        r0.v.setVisibility(0);
        r0.v.setOnClickListener(new net.one97.paytm.passbook.transactionDetail.c.b.AnonymousClass5(r0));
        r0.m.setText(net.one97.paytm.passbook.R.string.sent_to);
        r0.f59092h.setText(r0.f59085a.getTxnDesc1());
        r0.n.setText(r0.f59085a.getTxnDesc3());
        r1 = r0.f59085a.getImageUrl();
        r0.k.setPadding(0, 0, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x08a0, code lost:
        if (a() != false) goto L_0x08b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x08a2, code lost:
        com.squareup.picasso.w.a().a(r1).a(r0.k, (com.squareup.picasso.e) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x08b0, code lost:
        r0.o.setVisibility(8);
        r0.p.setText(net.one97.paytm.passbook.R.string.sent_from1);
        r0.f59093i.setText(net.one97.paytm.passbook.R.string.your_paytm_wallet);
        r0.q.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.q, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.r.setVisibility(8);
        r0.f59090f.setVisibility(8);
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x091f, code lost:
        r0.m.setText(net.one97.paytm.passbook.R.string.to);
        r0.f59092h.setText(r0.f59085a.getTxnFrom() + " " + getString(net.one97.paytm.passbook.R.string.wallet));
        r0.n.setVisibility(8);
        r0.o.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.o, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.k.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.k.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
        r0.p.setText(net.one97.paytm.passbook.R.string.from_your);
        r0.f59093i.setText(net.one97.paytm.passbook.R.string.pass_paytm_wallet);
        r0.q.setText(r0.f59085a.getTxnDesc1());
        r0.r.setVisibility(8);
        r0.f59090f.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x09c3, code lost:
        r0.m.setText(getString(net.one97.paytm.passbook.R.string.issued_by));
        r0.f59092h.setText(r0.f59085a.getTxnFrom());
        r0.n.setVisibility(8);
        r0.o.setText(r0.f59085a.getTxnDescription1());
        r0.f59090f.setVisibility(8);
        r0.k.setPadding(0, 0, 0, 0);
        com.squareup.picasso.w.a().a(r0.f59085a.getImageUrl()).a(r0.k, (com.squareup.picasso.e) null);
        r0.p.setText(net.one97.paytm.passbook.R.string.in_your);
        r0.f59093i.setText(r0.f59085a.getNarration().replace("Added to", "").trim());
        r0.q.setVisibility(8);
        r0.r.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.r, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0a7c, code lost:
        r0.u.setVisibility(8);
        r0.m.setText(net.one97.paytm.passbook.R.string.from);
        r0.f59092h.setText(r0.f59085a.getTxnDescription1());
        r0.n.setText(r0.f59085a.getTxnDesc2());
        r0.o.setText(r0.f59085a.getTxnDesc4());
        r0.f59090f.setVisibility(8);
        r1 = r0.f59085a.getImageUrl();
        r0.k.setPadding(0, 0, 0, 0);
        com.squareup.picasso.w.a().a(r1).a(r0.k, (com.squareup.picasso.e) null);
        r0.p.setText(net.one97.paytm.passbook.R.string.in_your);
        r0.f59093i.setText(net.one97.paytm.passbook.R.string.pass_paytm_wallet);
        r0.q.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        r0.r.setText(getString(net.one97.paytm.passbook.R.string.bank_txn_id_text) + ": " + r0.f59085a.getmTxnDescription3());
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.r, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0b4c, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0b51, code lost:
        r0.u.setVisibility(8);
        r1 = r0.f59085a.getImageUrl();
        r0.l.setPadding(0, 0, 0, 0);
        com.squareup.picasso.w.a().a(r1).a(r0.l, (com.squareup.picasso.e) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0b7b, code lost:
        if (com.paytm.utility.v.a(r0.f59085a.getTxnDescription1()) != false) goto L_0x0ba6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0b7d, code lost:
        r0.r.setText(getString(net.one97.paytm.passbook.R.string.for_order_id) + " " + r0.f59085a.getTxnDescription1());
        r0.r.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0ba6, code lost:
        r0.r.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0bad, code lost:
        r0.f59093i.setText(r0.f59085a.getTxnTo());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0bc2, code lost:
        if ("wallet".equalsIgnoreCase(r0.f59085a.getTxnTo()) == false) goto L_0x0be2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0bc4, code lost:
        r0.k.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.k.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0be2, code lost:
        r0.m.setText(getString(net.one97.paytm.passbook.R.string.from));
        r0.f59092h.setText(r0.f59085a.getTxnFrom());
        r0.n.setVisibility(8);
        r1 = r0.o;
        r1.setText(getString(net.one97.paytm.passbook.R.string.for_order_id) + " " + r0.f59085a.getTxnDescription1());
        r0.q.setVisibility(8);
        r0.f59090f.setVisibility(0);
        r0.f59090f.setText(r0.f59085a.getmTxnDescription2());
        r0.p.setText(net.one97.paytm.passbook.R.string.in_your);
        r0.f59093i.setText(net.one97.paytm.passbook.R.string.pass_paytm_wallet);
        r0.q.setText(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id, r0.f59085a.getWalletOrderId()));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.q, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0c9b, code lost:
        if ("SUCCESS".equalsIgnoreCase(r0.f59085a.getTxnStatus()) == false) goto L_0x0ca4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0c9d, code lost:
        r0.j.setImageResource(net.one97.paytm.passbook.R.drawable.pass_ic_pending_copy);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0ca4, code lost:
        r0.u.setVisibility(8);
        r0.m.setText(net.one97.paytm.passbook.R.string.to);
        r0.f59092h.setText(r0.f59085a.getTxnTo());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0cc7, code lost:
        if (com.paytm.utility.v.a(r0.f59085a.getTxnDescription1()) != false) goto L_0x0cf2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0cc9, code lost:
        r0.n.setText(getString(net.one97.paytm.passbook.R.string.for_order_id) + " " + r0.f59085a.getTxnDescription1());
        r0.n.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0cf2, code lost:
        r0.n.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0cf9, code lost:
        r1 = r0.f59085a.getImageUrl();
        r0.k.setPadding(0, 0, 0, 0);
        com.squareup.picasso.w.a().a(r1).a(r0.k, (com.squareup.picasso.e) null);
        r0.o.setVisibility(0);
        r0.o.setText(r0.f59085a.getmTxnDescription2());
        r0.p.setText(getString(net.one97.paytm.passbook.R.string.from_your));
        r0.f59093i.setText(net.one97.paytm.passbook.R.string.pass_paytm_wallet);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0d3e, code lost:
        if ("wallet".equalsIgnoreCase(r0.f59085a.getTxnTo()) == false) goto L_0x0d5e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0d40, code lost:
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0d68, code lost:
        if ("wallet".equalsIgnoreCase(r0.f59085a.getTxnTo()) == false) goto L_0x0d75;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0d6a, code lost:
        r0.f59093i.setText(getString(net.one97.paytm.passbook.R.string.pass_paytm_wallet));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0d75, code lost:
        r0.q.setVisibility(8);
        r0.r.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.r, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.f59090f.setVisibility(8);
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0dd1, code lost:
        r0.u.setVisibility(8);
        r0.m.setText(net.one97.paytm.passbook.R.string.from);
        r0.f59092h.setText(r0.f59085a.getTxnFrom());
        r0.n.setVisibility(8);
        r0.o.setText(r0.f59085a.getmTxnDescription2());
        r1 = r0.f59085a.getImageUrl();
        r0.k.setPadding(0, 0, 0, 0);
        com.squareup.picasso.w.a().a(r1).a(r0.k, (com.squareup.picasso.e) null);
        r0.p.setText(net.one97.paytm.passbook.R.string.in_your);
        r1 = r0.f59085a.getTxnTo();
        r0.f59093i.setText(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0e31, code lost:
        if ("wallet".equalsIgnoreCase(r0.f59085a.getTxnTo()) == false) goto L_0x0e3e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0e33, code lost:
        r0.f59093i.setText(getString(net.one97.paytm.passbook.R.string.accept_payment_paytm_wallet));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0e3e, code lost:
        r0.q.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.q, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.r.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0e77, code lost:
        if ("wallet".equalsIgnoreCase(r1) == false) goto L_0x0e97;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0e79, code lost:
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0e97, code lost:
        r0.f59090f.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0ea0, code lost:
        r1 = r0.f59085a.getTxnStatus();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0eaa, code lost:
        if ("SUCCESS".equalsIgnoreCase(r1) != false) goto L_0x0ef0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0eb0, code lost:
        if ("PENDING".equalsIgnoreCase(r1) != false) goto L_0x0ef0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0eb8, code lost:
        if ("REFUNDED_INIT".equalsIgnoreCase(r1) == false) goto L_0x0ec2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0eba, code lost:
        r0.j.setImageResource(net.one97.paytm.passbook.R.drawable.pass_ic_pending_copy);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0ec8, code lost:
        if ("REFUNDED_PENDING".equalsIgnoreCase(r1) != false) goto L_0x0ee9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0ece, code lost:
        if (com.business.merchant_payments.common.utility.AppConstants.TRANSACTION_STATUS_REFUND_PENDING.equalsIgnoreCase(r1) == false) goto L_0x0ed1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0ed7, code lost:
        if ("REFUNDED_SUCCESS".equalsIgnoreCase(r1) == false) goto L_0x0ee1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0ed9, code lost:
        r0.j.setImageResource(net.one97.paytm.passbook.R.drawable.pass_ic_tick);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0ee1, code lost:
        r0.j.setImageResource(net.one97.paytm.passbook.R.drawable.pass_ic_failed1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0ee9, code lost:
        r0.j.setImageResource(net.one97.paytm.passbook.R.drawable.pass_ic_pending_copy);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0ef0, code lost:
        r0.u.setVisibility(8);
        r0.m.setText(net.one97.paytm.passbook.R.string.from);
        r1 = r0.f59085a.getTxnDesc1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0f04, code lost:
        if (r1 != null) goto L_0x0f26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0f10, code lost:
        if ("20".equalsIgnoreCase(r0.f59085a.getType()) == false) goto L_0x0f1e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0f12, code lost:
        r0.f59092h.setText(getString(net.one97.paytm.passbook.R.string.upi1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0f1e, code lost:
        r0.f59092h.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0f2c, code lost:
        if (r1.startsWith("From:") == false) goto L_0x0f38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0f2e, code lost:
        r1 = r1.replace("From:", "").trim();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0f38, code lost:
        r0.f59092h.setText(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0f3d, code lost:
        r1 = r0.f59085a.getTxnDesc2();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0f43, code lost:
        if (r1 != null) goto L_0x0f4d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0f45, code lost:
        r0.n.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0f53, code lost:
        if (r1.startsWith("Bank Txn ID:") == false) goto L_0x0f5f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0f55, code lost:
        r1 = r1.replace("Bank Txn ID:", "").trim();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0f5f, code lost:
        r0.n.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.bank_id_with_value), new java.lang.Object[]{r1}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.n, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.o.setVisibility(8);
        r0.f59090f.setVisibility(8);
        r0.p.setText(net.one97.paytm.passbook.R.string.in_your);
        r0.f59093i.setText(net.one97.paytm.passbook.R.string.pass_paytm_wallet);
        r0.q.setVisibility(8);
        r0.r.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.r, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0ff6, code lost:
        r0.u.setVisibility(8);
        r0.m.setText(net.one97.paytm.passbook.R.string.from);
        r1 = r0.f59085a.getTxnFrom();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x100a, code lost:
        if (r1 == null) goto L_0x1011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x100c, code lost:
        r0.f59092h.setText(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x1011, code lost:
        r0.n.setText(r0.f59085a.getTxnDesc1());
        r0.o.setVisibility(8);
        r0.p.setText(net.one97.paytm.passbook.R.string.in_your);
        r0.f59093i.setText(net.one97.paytm.passbook.R.string.pass_paytm_wallet);
        r0.q.setVisibility(8);
        r0.r.setText(java.lang.String.format(getString(net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id), new java.lang.Object[]{r0.f59085a.getWalletOrderId()}));
        net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a(getContext(), (android.view.View) r0.r, r0.f59085a.getWalletOrderId(), getString(net.one97.paytm.passbook.R.string.transaction_id_copied));
        r0.l.setImageDrawable(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_ic_wallet));
        r0.l.setBackground(androidx.core.content.b.a(getContext(), net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg));
        r0.f59090f.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x108b, code lost:
        r0.y.setVisibility(0);
        r0.y.setOnClickListener(new net.one97.paytm.passbook.transactionDetail.c.$$Lambda$b$biQJJkesJ1e10u1EhOJYBhbG_Y(r0));
        r1 = net.one97.paytm.passbook.transactionDetail.a.f59009a;
        r0.A.setText(net.one97.paytm.passbook.transactionDetail.a.a(getContext(), r0.f59085a));
        r1 = net.one97.paytm.passbook.d.b();
        r3 = net.one97.paytm.passbook.utility.k.f59256a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x10b9, code lost:
        if (r1.a(net.one97.paytm.passbook.utility.k.b(), true) == false) goto L_0x10ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x10c5, code lost:
        if (r0.f59085a.getType().equalsIgnoreCase("20") == false) goto L_0x10ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x10c7, code lost:
        r0.z.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x10cd, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x10d8, code lost:
        if (r0.f59085a.getType().equalsIgnoreCase("20") == false) goto L_0x10f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x10e6, code lost:
        r0.U.setVisibility(0);
        r0.U.setText(r0.f59085a.getTxnHeading3());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x10f7, code lost:
        r0.U.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x10fe, code lost:
        r0.U.setOnClickListener(new net.one97.paytm.passbook.transactionDetail.c.$$Lambda$b$1CnDdkVdvg_H1rWaWOSP5YNYj10(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x1112, code lost:
        if (r0.f59085a.getType().equalsIgnoreCase(r2) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x1120, code lost:
        r0.V.setVisibility(0);
        r0.W.setVisibility(0);
        r0.V.setText(r0.f59085a.getmTxnDescription4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x039e, code lost:
        r13 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1 = new java.text.DecimalFormat(net.one97.paytm.passbook.utility.q.a(java.lang.Double.parseDouble(r0.f59085a.getExtendedTxnInfo().get(r9).getClosingBalance())), java.text.DecimalFormatSymbols.getInstance(java.util.Locale.ENGLISH)).format(java.lang.Double.parseDouble(r0.f59085a.getExtendedTxnInfo().get(r9).getClosingBalance()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0401, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x043a, code lost:
        r2 = r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r18, android.os.Bundle r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "53"
            java.lang.String r3 = "SUCCESS"
            java.lang.String r4 = "20"
            super.onViewCreated(r18, r19)
            int r5 = net.one97.paytm.passbook.R.id.back_arrow_imv
            android.view.View r5 = r1.findViewById(r5)
            net.one97.paytm.passbook.transactionDetail.c.b$1 r6 = new net.one97.paytm.passbook.transactionDetail.c.b$1
            r6.<init>()
            r5.setOnClickListener(r6)
            net.one97.paytm.passbook.mapping.f r5 = net.one97.paytm.passbook.d.b()
            r17.getActivity()
            java.lang.String r5 = r5.x()
            r0.L = r5
            android.os.Bundle r5 = r17.getArguments()
            java.lang.String r6 = "passbook_detail_data"
            java.io.Serializable r6 = r5.getSerializable(r6)
            net.one97.paytm.passbook.beans.CJRTransaction r6 = (net.one97.paytm.passbook.beans.CJRTransaction) r6
            r0.f59085a = r6
            java.lang.String r6 = "EXTENDED_TXN_INFO"
            java.io.Serializable r6 = r5.getSerializable(r6)
            java.lang.String r6 = (java.lang.String) r6
            r0.f59086b = r6
            r6 = -1
            java.lang.String r7 = "sub_wallet_type"
            int r5 = r5.getInt(r7, r6)
            r0.R = r5
            int r5 = net.one97.paytm.passbook.R.id.status_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.f59087c = r5
            int r5 = net.one97.paytm.passbook.R.id.amount_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.f59088d = r5
            int r5 = net.one97.paytm.passbook.R.id.date_time_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.f59089e = r5
            int r5 = net.one97.paytm.passbook.R.id.tagTv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.T = r5
            int r5 = net.one97.paytm.passbook.R.id.desc_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.f59090f = r5
            int r5 = net.one97.paytm.passbook.R.id.txt3
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.f59091g = r5
            int r5 = net.one97.paytm.passbook.R.id.status_icon
            android.view.View r5 = r1.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0.j = r5
            int r5 = net.one97.paytm.passbook.R.id.title1_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.m = r5
            int r5 = net.one97.paytm.passbook.R.id.title2_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.p = r5
            int r5 = net.one97.paytm.passbook.R.id.gvidDevider
            android.view.View r5 = r1.findViewById(r5)
            r0.M = r5
            int r5 = net.one97.paytm.passbook.R.id.recent_transaction_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.A = r5
            int r5 = net.one97.paytm.passbook.R.id.recent_transaction_rl
            android.view.View r5 = r1.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r0.y = r5
            int r5 = net.one97.paytm.passbook.R.id.rlAutoAddMoney
            android.view.View r5 = r1.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r0.z = r5
            int r5 = net.one97.paytm.passbook.R.id.share_imv
            android.view.View r5 = r1.findViewById(r5)
            net.one97.paytm.passbook.transactionDetail.c.b$2 r7 = new net.one97.paytm.passbook.transactionDetail.c.b$2
            r7.<init>()
            r5.setOnClickListener(r7)
            int r5 = net.one97.paytm.passbook.R.id.imv1Text
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.t = r5
            int r5 = net.one97.paytm.passbook.R.id.imv1
            android.view.View r5 = r1.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0.k = r5
            int r5 = net.one97.paytm.passbook.R.id.imv2
            android.view.View r5 = r1.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0.l = r5
            int r5 = net.one97.paytm.passbook.R.id.txt1
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.f59092h = r5
            int r5 = net.one97.paytm.passbook.R.id.txt2
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.n = r5
            int r5 = net.one97.paytm.passbook.R.id.txt3
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.o = r5
            int r5 = net.one97.paytm.passbook.R.id.txt4
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.f59093i = r5
            int r5 = net.one97.paytm.passbook.R.id.txt5
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.q = r5
            int r5 = net.one97.paytm.passbook.R.id.txt6
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.r = r5
            int r5 = net.one97.paytm.passbook.R.id.tvPreviewLifafa
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.v = r5
            int r5 = net.one97.paytm.passbook.R.id.gvDetailLayout
            android.view.View r5 = r1.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r0.D = r5
            int r5 = net.one97.paytm.passbook.R.id.gv_number
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.E = r5
            int r5 = net.one97.paytm.passbook.R.id.llGvNumberLayout
            android.view.View r5 = r1.findViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r0.F = r5
            int r5 = net.one97.paytm.passbook.R.id.gv_separator
            android.view.View r5 = r1.findViewById(r5)
            r0.J = r5
            int r5 = net.one97.paytm.passbook.R.id.gv_expiry
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.G = r5
            int r5 = net.one97.paytm.passbook.R.id.tv_buy_gv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.s = r5
            android.widget.TextView r5 = r0.s
            int r7 = net.one97.paytm.passbook.R.string.gv_buy
            java.lang.String r7 = r0.getString(r7)
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.String r10 = r0.L
            r11 = 0
            r9[r11] = r10
            java.lang.String r7 = java.lang.String.format(r7, r9)
            r5.setText(r7)
            int r5 = net.one97.paytm.passbook.R.id.singleGvId
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.H = r5
            int r5 = net.one97.paytm.passbook.R.id.multipleGvHeader
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.I = r5
            android.widget.TextView r5 = r0.I
            int r7 = net.one97.paytm.passbook.R.string.gv_number
            java.lang.String r7 = r0.getString(r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.String r10 = r0.L
            r9[r11] = r10
            java.lang.String r7 = java.lang.String.format(r7, r9)
            r5.setText(r7)
            int r5 = net.one97.paytm.passbook.R.id.gvOrderDetailLayout
            android.view.View r5 = r1.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r0.N = r5
            int r5 = net.one97.paytm.passbook.R.id.tvGvTxnId
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.O = r5
            int r5 = net.one97.paytm.passbook.R.id.gvTxnViewAllTv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.S = r5
            int r5 = net.one97.paytm.passbook.R.id.tvWalletTranId
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.P = r5
            int r5 = net.one97.paytm.passbook.R.id.tvGvIssuedBy
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.Q = r5
            int r5 = net.one97.paytm.passbook.R.id.need_help_rl
            android.view.View r5 = r1.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r0.x = r5
            int r5 = net.one97.paytm.passbook.R.id.repeat_payment_tv
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.u = r5
            int r5 = net.one97.paytm.passbook.R.id.tvClosingBalance
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.B = r5
            int r5 = net.one97.paytm.passbook.R.id.deviderClosingBalance
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.C = r5
            int r5 = net.one97.paytm.passbook.R.id.transaction_details_layout
            android.view.View r5 = r1.findViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r0.K = r5
            int r5 = net.one97.paytm.passbook.R.id.tvCCFeeNote
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.U = r5
            int r5 = net.one97.paytm.passbook.R.id.tvTxnDescription4
            android.view.View r5 = r1.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0.V = r5
            int r5 = net.one97.paytm.passbook.R.id.separator_view_top
            android.view.View r5 = r1.findViewById(r5)
            r0.W = r5
            int r5 = net.one97.paytm.passbook.R.id.back_arrow_imv
            android.view.View r1 = r1.findViewById(r5)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.X = r1
            android.widget.RelativeLayout r1 = r0.x
            net.one97.paytm.passbook.transactionDetail.c.b$3 r5 = new net.one97.paytm.passbook.transactionDetail.c.b$3
            r5.<init>()
            r1.setOnClickListener(r5)
            android.widget.RelativeLayout r1 = r0.z
            net.one97.paytm.passbook.transactionDetail.c.b$4 r5 = new net.one97.paytm.passbook.transactionDetail.c.b$4
            r5.<init>()
            r1.setOnClickListener(r5)
            r1 = 8
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getmNarration2()     // Catch:{ Exception -> 0x0802 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0802 }
            if (r5 == 0) goto L_0x027e
            java.lang.String r5 = "CR"
            net.one97.paytm.passbook.beans.CJRTransaction r7 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r7 = r7.getTxnType()     // Catch:{ Exception -> 0x0802 }
            boolean r5 = r5.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0802 }
            if (r5 == 0) goto L_0x0277
            int r5 = net.one97.paytm.passbook.R.string.money_received     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0284
        L_0x0277:
            int r5 = net.one97.paytm.passbook.R.string.money_sent     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0284
        L_0x027e:
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getmNarration2()     // Catch:{ Exception -> 0x0802 }
        L_0x0284:
            android.widget.TextView r7 = r0.f59087c     // Catch:{ Exception -> 0x0802 }
            r7.setText(r5)     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.string.closing_balance_rs     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r7 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r7 = r7.getTxnStatus()     // Catch:{ Exception -> 0x0802 }
            boolean r9 = r3.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r10 = "REFUND_PENDING"
            java.lang.String r12 = "PENDING"
            if (r9 == 0) goto L_0x02ac
            android.widget.ImageView r7 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r9 = net.one97.paytm.passbook.R.drawable.pass_ic_tick     // Catch:{ Exception -> 0x0802 }
            r7.setImageResource(r9)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r7 = r0.j     // Catch:{ Exception -> 0x0802 }
            r7.setVisibility(r1)     // Catch:{ Exception -> 0x0802 }
            goto L_0x02d0
        L_0x02ac:
            boolean r9 = r12.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0802 }
            if (r9 != 0) goto L_0x02c9
            java.lang.String r9 = "REFUNDED_BACK"
            boolean r9 = r9.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0802 }
            if (r9 != 0) goto L_0x02c9
            boolean r7 = r10.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0802 }
            if (r7 == 0) goto L_0x02c1
            goto L_0x02c9
        L_0x02c1:
            android.widget.ImageView r7 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r9 = net.one97.paytm.passbook.R.drawable.pass_ic_failed1     // Catch:{ Exception -> 0x0802 }
            r7.setImageResource(r9)     // Catch:{ Exception -> 0x0802 }
            goto L_0x02d0
        L_0x02c9:
            android.widget.ImageView r7 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r9 = net.one97.paytm.passbook.R.drawable.pass_ic_pending_copy     // Catch:{ Exception -> 0x0802 }
            r7.setImageResource(r9)     // Catch:{ Exception -> 0x0802 }
        L_0x02d0:
            net.one97.paytm.passbook.beans.CJRTransaction r7 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r7 = r7.getTxnAmount()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r7 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((java.lang.String) r7)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r9 = r0.f59088d     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.mapping.a.a((java.lang.String) r7, (android.widget.TextView) r9)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r7 = r0.f59089e     // Catch:{ Exception -> 0x0802 }
            r17.getActivity()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r9 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r9 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.b((net.one97.paytm.passbook.beans.CJRTransaction) r9)     // Catch:{ Exception -> 0x0802 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r7 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction$TagInfo r7 = r7.getTagInfo()     // Catch:{ Exception -> 0x0802 }
            if (r7 == 0) goto L_0x0315
            net.one97.paytm.passbook.beans.CJRTransaction r7 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction$TagInfo r7 = r7.getTagInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r7 = r7.tag     // Catch:{ Exception -> 0x0802 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0802 }
            if (r7 != 0) goto L_0x0315
            android.widget.TextView r7 = r0.T     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r9 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction$TagInfo r9 = r9.getTagInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r9 = r9.tag     // Catch:{ Exception -> 0x0802 }
            r7.setText(r9)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r7 = r0.T     // Catch:{ Exception -> 0x0802 }
            r7.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
        L_0x0315:
            net.one97.paytm.passbook.mapping.e.a()     // Catch:{ Exception -> 0x0802 }
            boolean r7 = net.one97.paytm.passbook.mapping.e.c()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r9 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r9 = r9.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            if (r9 == 0) goto L_0x03af
            net.one97.paytm.passbook.beans.CJRTransaction r9 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r9 = r9.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            int r9 = r9.size()     // Catch:{ Exception -> 0x0802 }
            if (r9 <= 0) goto L_0x03af
            r9 = 0
        L_0x0331:
            net.one97.paytm.passbook.beans.CJRTransaction r14 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r14 = r14.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            int r14 = r14.size()     // Catch:{ Exception -> 0x0802 }
            if (r9 >= r14) goto L_0x03af
            net.one97.paytm.passbook.beans.CJRTransaction r14 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r14 = r14.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.Object r14 = r14.get(r9)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r14 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r14     // Catch:{ Exception -> 0x0802 }
            java.lang.String r14 = r14.getClosingBalance()     // Catch:{ Exception -> 0x0802 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0802 }
            if (r14 != 0) goto L_0x03a8
            int r14 = r0.R     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r15 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r15 = r15.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.Object r15 = r15.get(r9)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r15 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r15     // Catch:{ Exception -> 0x0802 }
            java.lang.String r15 = r15.getSubWalletType()     // Catch:{ Exception -> 0x0802 }
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ Exception -> 0x0802 }
            if (r14 != r15) goto L_0x03a8
            java.text.DecimalFormat r14 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r15 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r15 = r15.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.Object r15 = r15.get(r9)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r15 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r15     // Catch:{ Exception -> 0x0802 }
            java.lang.String r15 = r15.getClosingBalance()     // Catch:{ Exception -> 0x0802 }
            double r15 = java.lang.Double.parseDouble(r15)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r15 = net.one97.paytm.passbook.utility.q.a((double) r15)     // Catch:{ Exception -> 0x0802 }
            java.util.Locale r16 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0802 }
            java.text.DecimalFormatSymbols r13 = java.text.DecimalFormatSymbols.getInstance(r16)     // Catch:{ Exception -> 0x0802 }
            r14.<init>(r15, r13)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r13 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r13 = r13.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.Object r9 = r13.get(r9)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r9 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r9     // Catch:{ Exception -> 0x0802 }
            java.lang.String r9 = r9.getClosingBalance()     // Catch:{ Exception -> 0x0802 }
            r13 = r2
            double r1 = java.lang.Double.parseDouble(r9)     // Catch:{ Exception -> 0x10cd }
            java.lang.String r1 = r14.format(r1)     // Catch:{ Exception -> 0x10cd }
            goto L_0x03b1
        L_0x03a8:
            r13 = r2
            int r9 = r9 + 1
            r2 = r13
            r1 = 8
            goto L_0x0331
        L_0x03af:
            r13 = r2
            r1 = 0
        L_0x03b1:
            if (r7 == 0) goto L_0x03e5
            int r2 = r0.R     // Catch:{ Exception -> 0x10cd }
            if (r2 == r6) goto L_0x03e5
            android.widget.TextView r2 = r0.B     // Catch:{ Exception -> 0x10cd }
            r2.setVisibility(r11)     // Catch:{ Exception -> 0x10cd }
            android.widget.TextView r2 = r0.C     // Catch:{ Exception -> 0x10cd }
            r2.setVisibility(r11)     // Catch:{ Exception -> 0x10cd }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x10cd }
            if (r2 != 0) goto L_0x03d5
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x10cd }
            r2[r11] = r1     // Catch:{ Exception -> 0x10cd }
            java.lang.String r1 = java.lang.String.format(r5, r2)     // Catch:{ Exception -> 0x10cd }
            android.widget.TextView r2 = r0.B     // Catch:{ Exception -> 0x10cd }
            r2.setText(r1)     // Catch:{ Exception -> 0x10cd }
            goto L_0x03f1
        L_0x03d5:
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x10cd }
            java.lang.String r2 = "--.--"
            r1[r11] = r2     // Catch:{ Exception -> 0x10cd }
            java.lang.String r1 = java.lang.String.format(r5, r1)     // Catch:{ Exception -> 0x10cd }
            android.widget.TextView r2 = r0.B     // Catch:{ Exception -> 0x10cd }
            r2.setText(r1)     // Catch:{ Exception -> 0x10cd }
            goto L_0x03f1
        L_0x03e5:
            android.widget.TextView r1 = r0.C     // Catch:{ Exception -> 0x10cd }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x10cd }
            android.widget.TextView r1 = r0.B     // Catch:{ Exception -> 0x10cd }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x10cd }
        L_0x03f1:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x10cd }
            java.lang.String r1 = r1.getType()     // Catch:{ Exception -> 0x10cd }
            int r2 = r1.hashCode()     // Catch:{ Exception -> 0x10cd }
            java.lang.String r5 = "50"
            r7 = 2
            switch(r2) {
                case 50: goto L_0x04b8;
                case 52: goto L_0x04ad;
                case 55: goto L_0x04a2;
                case 1598: goto L_0x0499;
                case 1606: goto L_0x048e;
                case 1635: goto L_0x0483;
                case 1664: goto L_0x0478;
                case 1665: goto L_0x046c;
                case 1666: goto L_0x045f;
                case 1669: goto L_0x0452;
                case 1691: goto L_0x0447;
                case 1694: goto L_0x043d;
                case 1696: goto L_0x0430;
                case 1697: goto L_0x0425;
                case 1698: goto L_0x041a;
                case 1730: goto L_0x040f;
                case 1756: goto L_0x0404;
                default: goto L_0x0401;
            }
        L_0x0401:
            r2 = r13
            goto L_0x04c3
        L_0x0404:
            java.lang.String r2 = "73"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x10cd }
            if (r1 == 0) goto L_0x0401
            r1 = 14
            goto L_0x043a
        L_0x040f:
            java.lang.String r2 = "68"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x10cd }
            if (r1 == 0) goto L_0x0401
            r1 = 16
            goto L_0x043a
        L_0x041a:
            java.lang.String r2 = "57"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x10cd }
            if (r1 == 0) goto L_0x0401
            r1 = 12
            goto L_0x043a
        L_0x0425:
            java.lang.String r2 = "56"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x10cd }
            if (r1 == 0) goto L_0x0401
            r1 = 11
            goto L_0x043a
        L_0x0430:
            java.lang.String r2 = "55"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x10cd }
            if (r1 == 0) goto L_0x0401
            r1 = 10
        L_0x043a:
            r2 = r13
            goto L_0x04c4
        L_0x043d:
            r2 = r13
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 7
            goto L_0x04c4
        L_0x0447:
            r2 = r13
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 15
            goto L_0x04c4
        L_0x0452:
            r2 = r13
            java.lang.String r9 = "49"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 13
            goto L_0x04c4
        L_0x045f:
            r2 = r13
            java.lang.String r9 = "46"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 9
            goto L_0x04c4
        L_0x046c:
            r2 = r13
            java.lang.String r9 = "45"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 8
            goto L_0x04c4
        L_0x0478:
            r2 = r13
            java.lang.String r9 = "44"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 5
            goto L_0x04c4
        L_0x0483:
            r2 = r13
            java.lang.String r9 = "36"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 0
            goto L_0x04c4
        L_0x048e:
            r2 = r13
            java.lang.String r9 = "28"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 4
            goto L_0x04c4
        L_0x0499:
            r2 = r13
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 1
            goto L_0x04c4
        L_0x04a2:
            r2 = r13
            java.lang.String r9 = "7"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 3
            goto L_0x04c4
        L_0x04ad:
            r2 = r13
            java.lang.String r9 = "4"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 2
            goto L_0x04c4
        L_0x04b8:
            r2 = r13
            java.lang.String r9 = "2"
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x04c3
            r1 = 6
            goto L_0x04c4
        L_0x04c3:
            r1 = -1
        L_0x04c4:
            java.lang.String r9 = ""
            java.lang.String r13 = "wallet"
            java.lang.String r14 = " "
            switch(r1) {
                case 0: goto L_0x0ff6;
                case 1: goto L_0x0ea0;
                case 2: goto L_0x0ea0;
                case 3: goto L_0x0dd1;
                case 4: goto L_0x0c91;
                case 5: goto L_0x0b51;
                case 6: goto L_0x0b4c;
                case 7: goto L_0x0a7c;
                case 8: goto L_0x09c3;
                case 9: goto L_0x09c3;
                case 10: goto L_0x09c3;
                case 11: goto L_0x09c3;
                case 12: goto L_0x09c3;
                case 13: goto L_0x09c3;
                case 14: goto L_0x09c3;
                case 15: goto L_0x0805;
                case 16: goto L_0x04d0;
                default: goto L_0x04ce;
            }
        L_0x04ce:
            goto L_0x108b
        L_0x04d0:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnStatus()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.mapping.f r3 = net.one97.paytm.passbook.d.b()     // Catch:{ Exception -> 0x0802 }
            r17.getActivity()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.x()     // Catch:{ Exception -> 0x0802 }
            r0.L = r3     // Catch:{ Exception -> 0x0802 }
            android.view.View r3 = r0.M     // Catch:{ Exception -> 0x0802 }
            r3.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.m     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getTxnDesc2()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getTxnFrom()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDesc4()     // Catch:{ Exception -> 0x0802 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0802 }
            if (r3 != 0) goto L_0x0521
            android.widget.TextView r3 = r0.n     // Catch:{ Exception -> 0x0802 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0802 }
            r5.<init>()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getTxnDesc4()     // Catch:{ Exception -> 0x0802 }
            r5.append(r6)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
        L_0x0521:
            android.widget.TextView r3 = r0.o     // Catch:{ Exception -> 0x0802 }
            r5 = 8
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getImageUrl()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getTxnHeading2()     // Catch:{ Exception -> 0x0802 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0802 }
            if (r5 == 0) goto L_0x0575
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0802 }
            if (r5 != 0) goto L_0x0554
            android.widget.ImageView r5 = r0.k     // Catch:{ Exception -> 0x0802 }
            r5.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.w r5 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r3 = r5.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r5 = r0.k     // Catch:{ Exception -> 0x0802 }
            r6 = 0
            r3.a((android.widget.ImageView) r5, (com.squareup.picasso.e) r6)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0595
        L_0x0554:
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getmTxnFromImageUrl()     // Catch:{ Exception -> 0x0802 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0802 }
            if (r3 != 0) goto L_0x0595
            android.widget.TextView r3 = r0.t     // Catch:{ Exception -> 0x0802 }
            r3.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.t     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getmTxnFromImageUrl()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.toUpperCase()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0595
        L_0x0575:
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getmTxnFromImageUrl()     // Catch:{ Exception -> 0x0802 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0802 }
            if (r3 != 0) goto L_0x0595
            android.widget.TextView r3 = r0.t     // Catch:{ Exception -> 0x0802 }
            r3.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.t     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getmTxnFromImageUrl()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.toUpperCase()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
        L_0x0595:
            android.widget.TextView r3 = r0.p     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getTxnDesc3()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r5 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            r5.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r5 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            java.lang.String r9 = r0.L     // Catch:{ Exception -> 0x0802 }
            r6[r11] = r9     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = java.lang.String.format(r3, r6)     // Catch:{ Exception -> 0x0802 }
            r5.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.q     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getTxnDesc1()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r5 = 8
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getmTxnToImageUrl()     // Catch:{ Exception -> 0x0802 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0802 }
            if (r5 != 0) goto L_0x05f1
            android.widget.ImageView r5 = r0.l     // Catch:{ Exception -> 0x0802 }
            r5.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.w r5 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r3 = r5.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r5 = r0.l     // Catch:{ Exception -> 0x0802 }
            r6 = 0
            r3.a((android.widget.ImageView) r5, (com.squareup.picasso.e) r6)     // Catch:{ Exception -> 0x0802 }
            goto L_0x060f
        L_0x05f1:
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r5 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.drawable.pass_gift_voucher_success_icon     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r5 = androidx.core.content.b.a((android.content.Context) r5, (int) r6)     // Catch:{ Exception -> 0x0802 }
            r3.setImageDrawable(r5)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r5 = r0.l     // Catch:{ Exception -> 0x0802 }
            r5.setBackground(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x060f:
            android.widget.RelativeLayout r3 = r0.D     // Catch:{ Exception -> 0x0802 }
            r3.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.H     // Catch:{ Exception -> 0x0802 }
            r5 = 8
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = "FAILURE"
            boolean r1 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0629
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r5)     // Catch:{ Exception -> 0x0802 }
            goto L_0x062e
        L_0x0629:
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
        L_0x062e:
            android.widget.TextView r1 = r0.G     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r1 = r1.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0802 }
            if (r1 <= 0) goto L_0x0672
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r1 = r1.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.Object r1 = r1.get(r11)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r1 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r1     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getExpiryTimeStamp()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.string.gv_expiry     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            java.lang.String r9 = "yyyy-MM-dd"
            java.lang.String r10 = "dd MMM yyyy"
            java.lang.String r1 = net.one97.paytm.passbook.utility.q.b(r1, r9, r10)     // Catch:{ Exception -> 0x0802 }
            r6[r11] = r1     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
        L_0x0672:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnHeading2()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0689
            android.widget.TextView r1 = r0.s     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.c.b$6 r3 = new net.one97.paytm.passbook.transactionDetail.c.b$6     // Catch:{ Exception -> 0x0802 }
            r3.<init>()     // Catch:{ Exception -> 0x0802 }
            r1.setOnClickListener(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0690
        L_0x0689:
            android.widget.TextView r1 = r0.s     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x0690:
            android.widget.RelativeLayout r1 = r0.N     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            int r1 = net.one97.paytm.passbook.R.string.gv_order_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            r3[r11] = r5     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            int r5 = r1.indexOf(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getTxnHeading2()     // Catch:{ Exception -> 0x0802 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0802 }
            if (r6 == 0) goto L_0x06f7
            android.text.SpannableString r6 = new android.text.SpannableString     // Catch:{ Exception -> 0x0802 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0802 }
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan     // Catch:{ Exception -> 0x0802 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0802 }
            int r9 = r3.length()     // Catch:{ Exception -> 0x0802 }
            int r9 = r9 + r5
            r6.setSpan(r1, r5, r9, r11)     // Catch:{ Exception -> 0x0802 }
            android.text.style.ForegroundColorSpan r1 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0802 }
            android.content.res.Resources r9 = r17.getResources()     // Catch:{ Exception -> 0x0802 }
            int r10 = net.one97.paytm.passbook.R.color.color_00b9f5     // Catch:{ Exception -> 0x0802 }
            int r9 = r9.getColor(r10)     // Catch:{ Exception -> 0x0802 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x0802 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0802 }
            int r3 = r3 + r5
            r6.setSpan(r1, r5, r3, r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            r1.setText(r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x0802 }
            r1.setMovementMethod(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x06fe
        L_0x06f7:
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x06fe:
            android.widget.TextView r1 = r0.O     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r1 = r1.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0802 }
            if (r1 > r8) goto L_0x0759
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r1 = r1.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.Object r1 = r1.get(r11)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r1 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r1     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getWalletId()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 != 0) goto L_0x0751
            android.widget.TextView r1 = r0.O     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.giftv_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getTxnHeading1()     // Catch:{ Exception -> 0x0802 }
            r5[r11] = r6     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r6 = r6.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            java.lang.Object r6 = r6.get(r11)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r6 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletId()     // Catch:{ Exception -> 0x0802 }
            r5[r8] = r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x07a2
        L_0x0751:
            android.widget.TextView r1 = r0.O     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x07a2
        L_0x0759:
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()     // Catch:{ Exception -> 0x0802 }
            r17.getContext()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.x()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.O     // Catch:{ Exception -> 0x0802 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0802 }
            r5.<init>()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.no_of     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            r5.append(r6)     // Catch:{ Exception -> 0x0802 }
            r5.append(r14)     // Catch:{ Exception -> 0x0802 }
            r5.append(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = ": "
            r5.append(r1)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.util.ArrayList r1 = r1.getExtendedTxnInfo()     // Catch:{ Exception -> 0x0802 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0802 }
            r5.append(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.S     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.S     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.c.-$$Lambda$b$khTg3QSlOLgCTtDdnE3uEQBg_N0 r3 = new net.one97.paytm.passbook.transactionDetail.c.-$$Lambda$b$khTg3QSlOLgCTtDdnE3uEQBg_N0     // Catch:{ Exception -> 0x0802 }
            r3.<init>()     // Catch:{ Exception -> 0x0802 }
            r1.setOnClickListener(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x07a2:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnHeading2()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x07b8
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.c.b$7 r3 = new net.one97.paytm.passbook.transactionDetail.c.b$7     // Catch:{ Exception -> 0x0802 }
            r3.<init>()     // Catch:{ Exception -> 0x0802 }
            r1.setOnClickListener(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x07b8:
            int r1 = r0.R     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.utility.n r3 = net.one97.paytm.passbook.utility.n.GIFT_VOUCHER     // Catch:{ Exception -> 0x0802 }
            int r3 = r3.getValue()     // Catch:{ Exception -> 0x0802 }
            if (r1 != r3) goto L_0x07dc
            android.widget.TextView r1 = r0.P     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.gv_wallet_tran_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r5[r11] = r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x07f5
        L_0x07dc:
            android.widget.TextView r1 = r0.P     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.gv_wallet_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r5[r11] = r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x07f5:
            android.widget.TextView r1 = r0.Q     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDesc1()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0802:
            goto L_0x10ce
        L_0x0805:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnDesc4()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 != 0) goto L_0x081b
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook r1 = r1.getThemeInfo()     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x081b
            r1 = 1
            goto L_0x081c
        L_0x081b:
            r1 = 0
        L_0x081c:
            if (r1 == 0) goto L_0x091f
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getType()     // Catch:{ Exception -> 0x0802 }
            int r3 = r1.hashCode()     // Catch:{ Exception -> 0x0802 }
            r9 = 53
            if (r3 == r9) goto L_0x0847
            r9 = 56
            if (r3 == r9) goto L_0x083d
            r9 = 1691(0x69b, float:2.37E-42)
            if (r3 == r9) goto L_0x0835
            goto L_0x0850
        L_0x0835:
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0850
            r6 = 1
            goto L_0x0850
        L_0x083d:
            java.lang.String r3 = "8"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0850
            r6 = 0
            goto L_0x0850
        L_0x0847:
            java.lang.String r3 = "5"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0850
            r6 = 2
        L_0x0850:
            if (r6 == 0) goto L_0x0861
            if (r6 == r8) goto L_0x085c
            if (r6 == r7) goto L_0x0857
            goto L_0x0865
        L_0x0857:
            java.lang.String r1 = "RECEIVED"
            r0.w = r1     // Catch:{ Exception -> 0x0802 }
            goto L_0x0865
        L_0x085c:
            java.lang.String r1 = "SENT"
            r0.w = r1     // Catch:{ Exception -> 0x0802 }
            goto L_0x0865
        L_0x0861:
            java.lang.String r1 = "RECEIVED"
            r0.w = r1     // Catch:{ Exception -> 0x0802 }
        L_0x0865:
            android.widget.TextView r1 = r0.v     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.v     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.c.b$5 r3 = new net.one97.paytm.passbook.transactionDetail.c.b$5     // Catch:{ Exception -> 0x0802 }
            r3.<init>()     // Catch:{ Exception -> 0x0802 }
            r1.setOnClickListener(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.sent_to     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDesc1()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDesc3()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r3.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            boolean r3 = r17.a()     // Catch:{ Exception -> 0x0802 }
            if (r3 != 0) goto L_0x08b0
            com.squareup.picasso.w r3 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r1 = r3.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r5 = 0
            r1.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r5)     // Catch:{ Exception -> 0x0802 }
        L_0x08b0:
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.sent_from1     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.your_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            int r1 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r3[r11] = r5     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.q     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x091f:
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.to     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0802 }
            r1.<init>()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnFrom()     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            r1.append(r14)     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.wallet     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            int r1 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r3[r11] = r5     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.o     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.o     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.k     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.from_your     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.pass_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDesc1()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x09c3:
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.issued_by     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnFrom()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.k     // Catch:{ Exception -> 0x0802 }
            r1.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.w r3 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r1 = r3.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r5 = 0
            r1.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.in_your     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getNarration()     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = "Added to"
            java.lang.String r1 = r1.replace(r3, r9)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            int r1 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r3[r11] = r5     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0a7c:
            android.widget.TextView r1 = r0.u     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.from     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDesc2()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDesc4()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r3.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.w r3 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r1 = r3.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r5 = 0
            r1.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.in_your     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.pass_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            int r1 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r3[r11] = r5     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0802 }
            r1.<init>()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.bank_txn_id_text     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = ": "
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getmTxnDescription3()     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0b4c:
            r17.b()     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0b51:
            android.widget.TextView r1 = r0.u     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.w r3 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r1 = r3.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r5 = 0
            r1.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r5)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = com.paytm.utility.v.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 != 0) goto L_0x0ba6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0802 }
            r1.<init>()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.for_order_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            r1.append(r14)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0bad
        L_0x0ba6:
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x0bad:
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0be2
            android.widget.ImageView r1 = r0.k     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
        L_0x0be2:
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.from     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnFrom()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0802 }
            r3.<init>()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.string.for_order_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            r3.append(r5)     // Catch:{ Exception -> 0x0802 }
            r3.append(r14)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            r3.append(r5)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getmTxnDescription2()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.in_your     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.pass_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r5[r11] = r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3, r5)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.q     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0c91:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnStatus()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0ca4
            android.widget.ImageView r1 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_ic_pending_copy     // Catch:{ Exception -> 0x0802 }
            r1.setImageResource(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x0ca4:
            android.widget.TextView r1 = r0.u     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.to     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = com.paytm.utility.v.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 != 0) goto L_0x0cf2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0802 }
            r1.<init>()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.for_order_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            r1.append(r14)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnDescription1()     // Catch:{ Exception -> 0x0802 }
            r1.append(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.n     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0cf9
        L_0x0cf2:
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x0cf9:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r3.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.w r3 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r1 = r3.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r5 = 0
            r1.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getmTxnDescription2()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.from_your     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.pass_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0d5e
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
        L_0x0d5e:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0d75
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.pass_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x0d75:
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r5[r11] = r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0dd1:
            android.widget.TextView r1 = r0.u     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.from     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnFrom()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getmTxnDescription2()     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r3.setPadding(r11, r11, r11, r11)     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.w r3 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0802 }
            com.squareup.picasso.aa r1 = r3.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.k     // Catch:{ Exception -> 0x0802 }
            r5 = 0
            r1.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r5)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.in_your     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getTxnTo()     // Catch:{ Exception -> 0x0802 }
            boolean r3 = r13.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0802 }
            if (r3 == 0) goto L_0x0e3e
            android.widget.TextView r3 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.string.accept_payment_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
        L_0x0e3e:
            android.widget.TextView r3 = r0.q     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r7 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r7 = r7.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r6[r11] = r7     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0802 }
            r3.setText(r5)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r5 = r0.q     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r7 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r7 = r0.getString(r7)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r3, (android.view.View) r5, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            r5 = 8
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r13.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0e97
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
        L_0x0e97:
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0ea0:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnStatus()     // Catch:{ Exception -> 0x0802 }
            boolean r3 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r3 != 0) goto L_0x0ef0
            boolean r3 = r12.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r3 != 0) goto L_0x0ef0
            java.lang.String r3 = "REFUNDED_INIT"
            boolean r3 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r3 == 0) goto L_0x0ec2
            android.widget.ImageView r1 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_ic_pending_copy     // Catch:{ Exception -> 0x0802 }
            r1.setImageResource(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0ef0
        L_0x0ec2:
            java.lang.String r3 = "REFUNDED_PENDING"
            boolean r3 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r3 != 0) goto L_0x0ee9
            boolean r3 = r10.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r3 == 0) goto L_0x0ed1
            goto L_0x0ee9
        L_0x0ed1:
            java.lang.String r3 = "REFUNDED_SUCCESS"
            boolean r1 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0ee1
            android.widget.ImageView r1 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_ic_tick     // Catch:{ Exception -> 0x0802 }
            r1.setImageResource(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0ef0
        L_0x0ee1:
            android.widget.ImageView r1 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_ic_failed1     // Catch:{ Exception -> 0x0802 }
            r1.setImageResource(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0ef0
        L_0x0ee9:
            android.widget.ImageView r1 = r0.j     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_ic_pending_copy     // Catch:{ Exception -> 0x0802 }
            r1.setImageResource(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x0ef0:
            android.widget.TextView r1 = r0.u     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.from     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnDesc1()     // Catch:{ Exception -> 0x0802 }
            if (r1 != 0) goto L_0x0f26
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getType()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r4.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x0f1e
            android.widget.TextView r1 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.upi1     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0f3d
        L_0x0f1e:
            android.widget.TextView r1 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0f3d
        L_0x0f26:
            java.lang.String r3 = "From:"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x0802 }
            if (r3 == 0) goto L_0x0f38
            java.lang.String r3 = "From:"
            java.lang.String r1 = r1.replace(r3, r9)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x0802 }
        L_0x0f38:
            android.widget.TextView r3 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
        L_0x0f3d:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnDesc2()     // Catch:{ Exception -> 0x0802 }
            if (r1 != 0) goto L_0x0f4d
            android.widget.TextView r3 = r0.n     // Catch:{ Exception -> 0x0802 }
            r5 = 8
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x0802 }
            goto L_0x0f5f
        L_0x0f4d:
            java.lang.String r3 = "Bank Txn ID:"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x0802 }
            if (r3 == 0) goto L_0x0f5f
            java.lang.String r3 = "Bank Txn ID:"
            java.lang.String r1 = r1.replace(r3, r9)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x0802 }
        L_0x0f5f:
            android.widget.TextView r3 = r0.n     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.string.bank_id_with_value     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            r6[r11] = r1     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.n     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.in_your     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.pass_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r5[r11] = r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            goto L_0x108b
        L_0x0ff6:
            android.widget.TextView r1 = r0.u     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.from     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnFrom()     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x1011
            android.widget.TextView r3 = r0.f59092h     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
        L_0x1011:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getTxnDesc1()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.n     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.o     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.p     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.in_your     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59093i     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.pass_paytm_wallet     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.q     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0802 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r6.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            r5[r11] = r6     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x0802 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.r     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r5 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r5 = r5.getWalletOrderId()     // Catch:{ Exception -> 0x0802 }
            int r6 = net.one97.paytm.passbook.R.string.transaction_id_copied     // Catch:{ Exception -> 0x0802 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((android.content.Context) r1, (android.view.View) r3, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r1 = r0.l     // Catch:{ Exception -> 0x0802 }
            android.content.Context r3 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_wallet     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r5)     // Catch:{ Exception -> 0x0802 }
            r1.setImageDrawable(r3)     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            int r3 = net.one97.paytm.passbook.R.drawable.pass_passbook_summary_item_icon_bg     // Catch:{ Exception -> 0x0802 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.ImageView r3 = r0.l     // Catch:{ Exception -> 0x0802 }
            r3.setBackground(r1)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r1 = r0.f59090f     // Catch:{ Exception -> 0x0802 }
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0802 }
        L_0x108b:
            android.widget.RelativeLayout r1 = r0.y     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            android.widget.RelativeLayout r1 = r0.y     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.c.-$$Lambda$b$biQ-JJkesJ1e10u1EhOJYBhbG_Y r3 = new net.one97.paytm.passbook.transactionDetail.c.-$$Lambda$b$biQ-JJkesJ1e10u1EhOJYBhbG_Y     // Catch:{ Exception -> 0x0802 }
            r3.<init>()     // Catch:{ Exception -> 0x0802 }
            r1.setOnClickListener(r3)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.transactionDetail.a r1 = net.one97.paytm.passbook.transactionDetail.a.f59009a     // Catch:{ Exception -> 0x0802 }
            android.content.Context r1 = r17.getContext()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = net.one97.paytm.passbook.transactionDetail.a.a(r1, r3)     // Catch:{ Exception -> 0x0802 }
            android.widget.TextView r3 = r0.A     // Catch:{ Exception -> 0x0802 }
            r3.setText(r1)     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()     // Catch:{ Exception -> 0x0802 }
            net.one97.paytm.passbook.utility.k r3 = net.one97.paytm.passbook.utility.k.f59256a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = net.one97.paytm.passbook.utility.k.b()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r1.a((java.lang.String) r3, (boolean) r8)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x10ce
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a     // Catch:{ Exception -> 0x0802 }
            java.lang.String r1 = r1.getType()     // Catch:{ Exception -> 0x0802 }
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0802 }
            if (r1 == 0) goto L_0x10ce
            android.widget.RelativeLayout r1 = r0.z     // Catch:{ Exception -> 0x0802 }
            r1.setVisibility(r11)     // Catch:{ Exception -> 0x0802 }
            goto L_0x10ce
        L_0x10cd:
            r2 = r13
        L_0x10ce:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a
            java.lang.String r1 = r1.getType()
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x10f7
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a
            java.lang.String r1 = r1.getTxnHeading3()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x10f7
            android.widget.TextView r1 = r0.U
            r1.setVisibility(r11)
            android.widget.TextView r1 = r0.U
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r0.f59085a
            java.lang.String r3 = r3.getTxnHeading3()
            r1.setText(r3)
            goto L_0x10fe
        L_0x10f7:
            android.widget.TextView r1 = r0.U
            r3 = 8
            r1.setVisibility(r3)
        L_0x10fe:
            android.widget.TextView r1 = r0.U
            net.one97.paytm.passbook.transactionDetail.c.-$$Lambda$b$1CnDdkVdvg_H1rWaWOSP5YNYj10 r3 = new net.one97.paytm.passbook.transactionDetail.c.-$$Lambda$b$1CnDdkVdvg_H1rWaWOSP5YNYj10
            r3.<init>()
            r1.setOnClickListener(r3)
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a
            java.lang.String r1 = r1.getType()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x1135
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f59085a
            java.lang.String r1 = r1.getmTxnDescription4()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x1135
            android.widget.TextView r1 = r0.V
            r1.setVisibility(r11)
            android.view.View r1 = r0.W
            r1.setVisibility(r11)
            android.widget.TextView r1 = r0.V
            net.one97.paytm.passbook.beans.CJRTransaction r2 = r0.f59085a
            java.lang.String r2 = r2.getmTxnDescription4()
            r1.setText(r2)
        L_0x1135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.c.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        String str;
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            if (this.f59085a != null) {
                str = this.f59085a.getTxnDesc1();
            } else {
                str = "";
            }
            intent.putExtra("android.intent.extra.TEXT", str);
            View view = getView();
            this.X.setVisibility(8);
            int visibility = this.C.getVisibility();
            this.C.setVisibility(8);
            int visibility2 = this.B.getVisibility();
            this.B.setVisibility(8);
            int visibility3 = view.findViewById(R.id.share_imv).getVisibility();
            view.findViewById(R.id.share_imv).setVisibility(8);
            int visibility4 = view.findViewById(R.id.bottom_btn_ll).getVisibility();
            view.findViewById(R.id.bottom_btn_ll).setVisibility(8);
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            view.findViewById(R.id.share_imv).setVisibility(visibility3);
            view.findViewById(R.id.bottom_btn_ll).setVisibility(visibility4);
            this.X.setVisibility(0);
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
                b.this.c();
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (getActivity() != null && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
            ((PassbookTransactionDetailsActivity) getActivity()).b();
        }
    }

    private boolean a() {
        try {
            w.a().a(this.f59085a.getThemeInfo().getThemes().getThumbnailView().get(4).getUrl1()).a(this.k, (e) null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        new net.one97.paytm.passbook.transactionDetail.b.e(this.f59085a.getExtendedTxnInfo()).show(getChildFragmentManager().a(), net.one97.paytm.passbook.transactionDetail.b.e.class.getSimpleName());
    }

    private void b() {
        this.u.setVisibility(8);
        this.m.setText(R.string.from);
        this.f59092h.setText(this.f59085a.getTxnFrom());
        this.n.setText(String.format(getString(R.string.order_id_merchant), new Object[]{this.f59085a.getTxnDescription1()}));
        this.o.setVisibility(8);
        this.f59090f.setVisibility(8);
        String imageUrl = this.f59085a.getImageUrl();
        this.k.setPadding(0, 0, 0, 0);
        w.a().a(imageUrl).a(this.k, (e) null);
        this.p.setText(R.string.in_your);
        this.f59093i.setText(R.string.pass_paytm_wallet);
        if (this.f59085a.getExtendedTxnInfo() == null || this.f59085a.getExtendedTxnInfo().size() <= 1) {
            this.q.setVisibility(8);
            this.f59093i.setText(this.f59085a.getExtendedTxnInfo().get(0).getDisplayName());
            if (n.GIFT_VOUCHER.getValue() == Integer.parseInt(this.f59085a.getExtendedTxnInfo().get(0).getSubWalletType())) {
                this.r.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.f59085a.getWalletOrderId()}));
                this.f59093i.setText(String.format(getString(R.string.gv_id), new Object[]{this.f59085a.getExtendedTxnInfo().get(0).getDisplayName(), this.f59085a.getExtendedTxnInfo().get(0).getWalletId()}));
            } else {
                this.f59093i.setText(this.f59085a.getExtendedTxnInfo().get(0).getDisplayName());
                this.r.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.f59085a.getWalletOrderId()}));
            }
            PassbookTransactionDetailsActivity.a(getContext(), (View) this.r, this.f59085a.getWalletOrderId(), getString(R.string.transaction_id_copied));
            if (n.GIFT_VOUCHER.getValue() == Integer.parseInt(this.f59085a.getExtendedTxnInfo().get(0).getSubWalletType())) {
                this.l.setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.pass_gift_voucher_success_icon));
            } else {
                this.l.setImageDrawable(androidx.core.content.b.a(getContext(), R.drawable.pass_ic_wallet));
            }
            this.l.setBackground(androidx.core.content.b.a(getContext(), R.drawable.pass_passbook_summary_item_icon_bg));
            return;
        }
        this.f59093i.setVisibility(8);
        this.l.setVisibility(8);
        for (int i2 = 0; i2 < this.f59085a.getExtendedTxnInfo().size(); i2++) {
            ExtendedTxnInfo extendedTxnInfo = this.f59085a.getExtendedTxnInfo().get(i2);
            boolean z2 = this.f59085a.getExtendedTxnInfo().size() > 1;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_transaction_breakups_layout, (ViewGroup) null);
            this.K.addView(inflate);
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
        if (this.R == n.GIFT_VOUCHER.getValue()) {
            this.q.setText(String.format(getString(R.string.gv_wallet_tran_id), new Object[]{this.f59085a.getWalletOrderId()}));
        } else {
            this.q.setText(String.format(getString(R.string.psbk_dtl_wallet_txn_id), new Object[]{this.f59085a.getWalletOrderId()}));
        }
        PassbookTransactionDetailsActivity.a(getContext(), (View) this.q, this.f59085a.getWalletOrderId(), getString(R.string.transaction_id_copied));
        this.r.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent(getContext(), RecentTransactionsActivity.class);
        intent.putExtra("data", this.f59085a);
        startActivity(intent);
        if (this.R == n.GIFT_VOUCHER.getValue()) {
            q.a(getContext(), "gift_voucher", "gv_added_recent_link_clicked", (String) null, (String) null, "/passbook/gift-voucher", "gift_voucher");
        }
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        try {
            Long.parseLong(str);
            return str;
        } catch (Exception unused) {
            return str.substring(str.indexOf("-") + 1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        new d(this.f59085a).show(getChildFragmentManager().a(), "");
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.isAdded() && bVar.getActivity() != null && (bVar.getActivity() instanceof PassbookTransactionDetailsActivity)) {
            ((PassbookTransactionDetailsActivity) bVar.getActivity()).a(bVar.Y);
        }
    }

    static /* synthetic */ void b(b bVar) {
        if (bVar.getActivity() != null && (bVar.getActivity() instanceof PassbookTransactionDetailsActivity) && bVar.isAdded()) {
            ((PassbookTransactionDetailsActivity) bVar.getActivity()).c();
        }
    }

    static /* synthetic */ void c(b bVar) {
        if (bVar.isAdded() && bVar.getActivity() != null && (bVar.getActivity() instanceof PassbookTransactionDetailsActivity)) {
            final PassbookTransactionDetailsActivity passbookTransactionDetailsActivity = (PassbookTransactionDetailsActivity) bVar.getActivity();
            passbookTransactionDetailsActivity.a();
            String a2 = net.one97.paytm.passbook.d.b().a("lifafaEventDetailURL");
            if (URLUtil.isValidUrl(a2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("lifafaKey", bVar.f59085a.getTxnDesc4());
                    jSONObject.put("startOffset", "0");
                    jSONObject.put("limit", "100");
                } catch (JSONException unused) {
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", a.q(passbookTransactionDetailsActivity));
                hashMap.put("Content-Type", "application/json");
                IJRDataModel iJRDataModel = null;
                if (bVar.w.equalsIgnoreCase("RECEIVED")) {
                    iJRDataModel = new ReceivedLifafaDetailsResponse();
                } else if (bVar.w.equalsIgnoreCase("SENT")) {
                    iJRDataModel = new SentLifafaDetailsResponse();
                }
                net.one97.paytm.passbook.mapping.a.b bVar2 = new net.one97.paytm.passbook.mapping.a.b(a2, new i.a<IJRDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        SentLifafaDetailsResponse sentLifafaDetailsResponse;
                        IJRDataModel iJRDataModel = (IJRDataModel) obj;
                        passbookTransactionDetailsActivity.b();
                        if (iJRDataModel == null) {
                            return;
                        }
                        if (iJRDataModel instanceof ReceivedLifafaDetailsResponse) {
                            ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse = (ReceivedLifafaDetailsResponse) iJRDataModel;
                            if (receivedLifafaDetailsResponse == null) {
                                return;
                            }
                            if (receivedLifafaDetailsResponse.getStatusCode() != null && receivedLifafaDetailsResponse.getStatusCode().equals("FE_0000")) {
                                net.one97.paytm.passbook.d.b().a(iJRDataModel, b.this.getContext());
                            } else if ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("EV_0014")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0001")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0002")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0003")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0004")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_1000")) && (receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_1001")))))))) {
                                c.a((Context) passbookTransactionDetailsActivity, b.this.getString(R.string.error), b.this.getString(R.string.some_went_wrong));
                            } else {
                                c.a((Context) passbookTransactionDetailsActivity, b.this.getString(R.string.error), receivedLifafaDetailsResponse.getStatusMessage());
                            }
                        } else if ((iJRDataModel instanceof SentLifafaDetailsResponse) && (sentLifafaDetailsResponse = (SentLifafaDetailsResponse) iJRDataModel) != null) {
                            if (sentLifafaDetailsResponse.getStatusCode() != null && sentLifafaDetailsResponse.getStatusCode().equals("FE_0000")) {
                                net.one97.paytm.passbook.d.b().a(iJRDataModel, b.this.getContext());
                            } else if ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("EV_0014")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0001")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0002")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0003")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0004")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_1000")) && (sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_1001")))))))) {
                                c.a((Context) passbookTransactionDetailsActivity, b.this.getString(R.string.error), b.this.getString(R.string.some_went_wrong));
                            } else {
                                c.a((Context) passbookTransactionDetailsActivity, b.this.getString(R.string.error), sentLifafaDetailsResponse.getStatusMessage());
                            }
                        }
                    }
                }, new g() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        passbookTransactionDetailsActivity.b();
                        PassbookTransactionDetailsActivity passbookTransactionDetailsActivity = passbookTransactionDetailsActivity;
                        b.class.getSimpleName();
                        j.a((Activity) passbookTransactionDetailsActivity, (Throwable) networkCustomError);
                    }
                }, iJRDataModel, hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, b.class.getName());
                if (com.paytm.utility.b.c((Context) passbookTransactionDetailsActivity)) {
                    net.one97.paytm.passbook.mapping.a.c.a();
                    net.one97.paytm.passbook.mapping.a.c.b(bVar2);
                }
            }
        }
    }
}
