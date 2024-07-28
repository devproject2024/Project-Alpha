package net.one97.paytm.passbook.paytmBalance.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRActionUrlRequest;
import net.one97.paytm.passbook.beans.CJRBusInvoiceModel;
import net.one97.paytm.passbook.beans.CJRButton;
import net.one97.paytm.passbook.beans.CJRLedgerResponse;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.customview.a;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.search.b.a;
import net.one97.paytm.passbook.subWallet.WalletLandingPageActivity;
import net.one97.paytm.passbook.subWallet.model.TransactionHeader;
import net.one97.paytm.passbook.utility.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends RecyclerView.a<RecyclerView.v> implements a.C1128a {

    /* renamed from: a  reason: collision with root package name */
    Boolean f58150a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRTransaction> f58151b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.passbook.customview.d f58152c = new net.one97.paytm.passbook.customview.d();

    /* renamed from: d  reason: collision with root package name */
    c f58153d;

    /* renamed from: e  reason: collision with root package name */
    int f58154e;

    /* renamed from: f  reason: collision with root package name */
    private final int f58155f;

    /* renamed from: g  reason: collision with root package name */
    private final int f58156g = 1;

    /* renamed from: h  reason: collision with root package name */
    private final int f58157h = 2;

    /* renamed from: i  reason: collision with root package name */
    private LayoutInflater f58158i;
    private net.one97.paytm.passbook.genericPassbook.b.c j;

    public interface c {
        void a(int i2, CJRTransaction cJRTransaction);

        void a(CJRTransaction cJRTransaction);

        void b(CJRTransaction cJRTransaction);

        void c(CJRTransaction cJRTransaction);
    }

    public a(net.one97.paytm.passbook.genericPassbook.b.c cVar, c cVar2, int i2) {
        k.c(cVar, "listener");
        k.c(cVar2, "itemOperationsListener");
        this.j = cVar;
        this.f58153d = cVar2;
        this.f58154e = i2;
        this.f58152c.a();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        C1115a aVar;
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.f58158i = from;
        if (i2 == this.f58155f) {
            LayoutInflater layoutInflater = this.f58158i;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            View inflate = layoutInflater.inflate(R.layout.pass_new_search_header_item, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…ader_item, parent, false)");
            aVar = new d(inflate);
        } else {
            LayoutInflater layoutInflater2 = this.f58158i;
            if (layoutInflater2 == null) {
                k.a("mInflater");
            }
            View inflate2 = layoutInflater2.inflate(R.layout.pass_subwallet_txn_item_layout, (ViewGroup) null);
            k.a((Object) inflate2, "mInflater.inflate(R.layo…et_txn_item_layout, null)");
            aVar = new b(this, inflate2);
        }
        return aVar;
    }

    public final int getItemCount() {
        ArrayList<CJRTransaction> arrayList = this.f58151b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f58151b.get(i2) instanceof TransactionHeader) {
            return this.f58155f;
        }
        return this.f58156g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x089f, code lost:
        if (kotlin.m.p.a(r3.getTxnStatus(), "REFUNDED_BACK", true) == false) goto L_0x08a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x093c  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0a96  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0ab4  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0afa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "baseTransactionsHolder"
            kotlin.g.b.k.c(r1, r3)
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r3 = r0.f58151b
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r4 = "mTransactionList[position]"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.passbook.beans.CJRTransaction r3 = (net.one97.paytm.passbook.beans.CJRTransaction) r3
            boolean r4 = r1 instanceof net.one97.paytm.passbook.paytmBalance.a.a.b
            if (r4 == 0) goto L_0x0b77
            r4 = r1
            net.one97.paytm.passbook.paytmBalance.a.a$b r4 = (net.one97.paytm.passbook.paytmBalance.a.a.b) r4
            java.lang.String r6 = "transaction"
            kotlin.g.b.k.c(r3, r6)
            android.view.View r6 = r4.itemView
            java.lang.String r7 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.content.Context r6 = r6.getContext()
            r4.f58159a = r3
            net.one97.paytm.passbook.paytmBalance.a.a r8 = r4.f58161c
            java.lang.Boolean r8 = r8.f58150a
            if (r8 != 0) goto L_0x004d
            net.one97.paytm.passbook.paytmBalance.a.a r8 = r4.f58161c
            net.one97.paytm.passbook.mapping.e r9 = net.one97.paytm.passbook.mapping.e.a()
            java.lang.String r10 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            boolean r9 = net.one97.paytm.passbook.mapping.e.c()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r8.f58150a = r9
        L_0x004d:
            java.lang.String r8 = r3.getPaymentsThemeId()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x008e
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            java.lang.String r9 = r3.getPaymentsThemeId()
            net.one97.paytm.p2p.theme.ThemeData r8 = r8.a((android.content.Context) r6, (java.lang.String) r9)
            if (r8 == 0) goto L_0x008e
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            java.lang.String r8 = r8.getImagerURL()
            com.squareup.picasso.aa r8 = r9.a((java.lang.String) r8)
            net.one97.paytm.passbook.customview.b r9 = new net.one97.paytm.passbook.customview.b
            r9.<init>()
            com.squareup.picasso.ah r9 = (com.squareup.picasso.ah) r9
            com.squareup.picasso.aa r8 = r8.a((com.squareup.picasso.ah) r9)
            android.view.View r9 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            int r10 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r9 = r9.findViewById(r10)
            net.one97.paytm.passbook.customview.CircularImageView r9 = (net.one97.paytm.passbook.customview.CircularImageView) r9
            r8.a((android.widget.ImageView) r9)
        L_0x008e:
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r9 = net.one97.paytm.passbook.R.id.passbook_send_receive_type_tv
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "itemView.passbook_send_receive_type_tv"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r9 = "context"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            if (r3 == 0) goto L_0x00ac
            java.lang.String r10 = r3.getmListingNarration()
            goto L_0x00ad
        L_0x00ac:
            r10 = 0
        L_0x00ad:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            java.lang.String r11 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r12 = "DR"
            if (r10 == 0) goto L_0x00f8
            if (r3 == 0) goto L_0x00f8
            java.lang.String r10 = r3.getTxnType()
            if (r10 == 0) goto L_0x00f8
            java.lang.String r13 = "CR"
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r10 == 0) goto L_0x00f2
            boolean r13 = r10.contentEquals(r13)
            if (r13 == 0) goto L_0x00d7
            int r10 = net.one97.paytm.passbook.R.string.money_received
            java.lang.String r10 = r6.getString(r10)
            r3.setmListingNarration(r10)
            goto L_0x00f8
        L_0x00d7:
            r13 = r12
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r10 == 0) goto L_0x00ec
            boolean r10 = r10.contentEquals(r13)
            if (r10 == 0) goto L_0x00f8
            int r10 = net.one97.paytm.passbook.R.string.money_sent
            java.lang.String r10 = r6.getString(r10)
            r3.setmListingNarration(r10)
            goto L_0x00f8
        L_0x00ec:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r11)
            throw r1
        L_0x00f2:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r11)
            throw r1
        L_0x00f8:
            if (r3 == 0) goto L_0x00ff
            java.lang.String r10 = r3.getmListingNarration()
            goto L_0x0100
        L_0x00ff:
            r10 = 0
        L_0x0100:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r8.setText(r10)
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r10 = net.one97.paytm.passbook.R.id.passbook_send_receive_time
            android.view.View r8 = r8.findViewById(r10)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.String r10 = "itemView.passbook_send_receive_time"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.lang.String r10 = r3.getTxnDate()
            android.view.View r13 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r7)
            r13.getContext()
            java.lang.String r13 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r14 = "dd MMM"
            java.lang.String r15 = "hh:mm a"
            java.lang.String r10 = net.one97.paytm.passbook.mapping.a.a(r10, r13, r14, r15)
            java.lang.String r10 = r10.toString()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r8.setText(r10)
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r10 = net.one97.paytm.passbook.R.id.passbook_closing_balance
            android.view.View r8 = r8.findViewById(r10)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.String r10 = "itemView.passbook_closing_balance"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.lang.String r13 = ""
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r8.setText(r13)
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r13 = net.one97.paytm.passbook.R.id.passbook_txn_status_rl
            android.view.View r8 = r8.findViewById(r13)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            java.lang.String r13 = "itemView.passbook_txn_status_rl"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r13)
            r14 = 8
            r8.setVisibility(r14)
            java.lang.String r8 = r3.getTxnAmount()
            java.lang.String r15 = "transaction.txnAmount"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r15)
            java.util.ArrayList r15 = r3.getExtendedTxnInfo()
            if (r15 == 0) goto L_0x01ca
            java.util.ArrayList r15 = r3.getExtendedTxnInfo()
            int r15 = r15.size()
            if (r15 <= 0) goto L_0x01ca
            java.util.ArrayList r15 = r3.getExtendedTxnInfo()
            int r15 = r15.size()
            r14 = 0
        L_0x018a:
            if (r14 >= r15) goto L_0x01ca
            net.one97.paytm.passbook.paytmBalance.a.a r9 = r4.f58161c
            int r9 = r9.f58154e
            java.util.ArrayList r5 = r3.getExtendedTxnInfo()
            java.lang.Object r5 = r5.get(r14)
            r18 = r8
            java.lang.String r8 = "transaction.extendedTxnInfo[i]"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r5 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r5
            java.lang.String r5 = r5.getSubWalletType()
            java.lang.String r8 = "transaction.extendedTxnInfo[i].subWalletType"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            int r5 = java.lang.Integer.parseInt(r5)
            if (r9 != r5) goto L_0x01cd
            java.util.ArrayList r5 = r3.getExtendedTxnInfo()
            java.lang.Object r5 = r5.get(r14)
            java.lang.String r8 = "transaction.extendedTxnInfo[i]"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r5 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r5
            double r8 = r5.getAmount()
            java.lang.String r8 = java.lang.String.valueOf(r8)
        L_0x01ca:
            r18 = r8
            goto L_0x01d2
        L_0x01cd:
            int r14 = r14 + 1
            r8 = r18
            goto L_0x018a
        L_0x01d2:
            java.text.DecimalFormat r5 = new java.text.DecimalFormat
            java.lang.String r8 = r4.f58160b
            java.util.Locale r9 = java.util.Locale.ENGLISH
            java.text.DecimalFormatSymbols r9 = java.text.DecimalFormatSymbols.getInstance(r9)
            r5.<init>(r8, r9)
            double r8 = java.lang.Double.parseDouble(r18)
            java.lang.String r5 = r5.format(r8)
            java.lang.String r8 = "strTotalBalance"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            r8 = r5
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r9 = ".00"
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, false)
            if (r9 == 0) goto L_0x020b
            r9 = 6
            java.lang.String r14 = "."
            r15 = 0
            int r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.String) r14, (int) r15, (boolean) r15, (int) r9)
            java.lang.String r5 = r5.substring(r15, r8)
            java.lang.String r8 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
        L_0x020b:
            java.lang.String r8 = r3.getTxnType()
            java.lang.String r9 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r9 = r12
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r8 == 0) goto L_0x0b70
            boolean r8 = r8.contentEquals(r9)
            java.lang.String r9 = "</b>"
            java.lang.String r14 = "itemView.passbook_sender_receiver_amount_tv"
            if (r8 == 0) goto L_0x0287
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "<b>-</b>  ₹<b>"
            r8.<init>(r11)
            r8.append(r5)
            r8.append(r9)
            java.lang.String r5 = r8.toString()
            int r8 = android.os.Build.VERSION.SDK_INT
            r11 = 24
            if (r8 < r11) goto L_0x0257
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r8 = r8.findViewById(r11)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)
            r11 = 63
            android.text.Spanned r5 = android.text.Html.fromHtml(r5, r11)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r8.setText(r5)
            goto L_0x0270
        L_0x0257:
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r8 = r8.findViewById(r11)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r8.setText(r5)
        L_0x0270:
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r5 = r5.findViewById(r8)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r8 = net.one97.paytm.passbook.R.color.color_222222
            int r8 = androidx.core.content.b.c(r6, r8)
            r5.setTextColor(r8)
            goto L_0x02ff
        L_0x0287:
            java.lang.String r8 = r3.getTxnType()
            java.lang.String r15 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r15)
            java.lang.String r15 = "CR"
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            if (r8 == 0) goto L_0x0b69
            boolean r8 = r8.contentEquals(r15)
            if (r8 == 0) goto L_0x02ff
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "<b>+</b>  ₹<b>"
            r8.<init>(r11)
            r8.append(r5)
            r8.append(r9)
            java.lang.String r5 = r8.toString()
            int r8 = android.os.Build.VERSION.SDK_INT
            r11 = 24
            if (r8 < r11) goto L_0x02d0
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r8 = r8.findViewById(r11)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)
            r11 = 63
            android.text.Spanned r5 = android.text.Html.fromHtml(r5, r11)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r8.setText(r5)
            goto L_0x02e9
        L_0x02d0:
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r8 = r8.findViewById(r11)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r8.setText(r5)
        L_0x02e9:
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r5 = r5.findViewById(r8)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r8 = net.one97.paytm.passbook.R.color.color_21c17a
            int r8 = androidx.core.content.b.c(r6, r8)
            r5.setTextColor(r8)
        L_0x02ff:
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r8)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r8 = 0
            r5.setImageDrawable(r8)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r8)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            java.lang.String r8 = "itemView.passbook_payer_or_payee_icons_iv"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            r11 = 8
            r5.setVisibility(r11)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r15 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r5 = r5.findViewById(r15)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.String r15 = "itemView.payer_payee_icon_with_text"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r15)
            r5.setVisibility(r11)
            r5 = 4
            java.lang.Integer[] r5 = new java.lang.Integer[r5]
            int r11 = net.one97.paytm.passbook.R.color.color_ffc756
            int r11 = androidx.core.content.b.c(r6, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r17 = 0
            r5[r17] = r11
            int r11 = net.one97.paytm.passbook.R.color.color_5697ff
            int r11 = androidx.core.content.b.c(r6, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r16 = 1
            r5[r16] = r11
            int r11 = net.one97.paytm.passbook.R.color.color_7ae3b4
            int r11 = androidx.core.content.b.c(r6, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r17 = 2
            r5[r17] = r11
            int r11 = net.one97.paytm.passbook.R.color.color_ffa67a
            int r11 = androidx.core.content.b.c(r6, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r17 = 3
            r5[r17] = r11
            java.lang.String r11 = r3.getType()
            java.lang.String r1 = "transaction.narration"
            if (r11 == 0) goto L_0x0469
            java.lang.String r11 = r3.getType()
            java.lang.String r0 = "5"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0398
            java.lang.String r0 = r3.getType()
            java.lang.String r11 = "69"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r11)
            if (r0 == 0) goto L_0x0469
        L_0x0398:
            java.lang.String r0 = r3.getPayeeInitials()
            if (r0 == 0) goto L_0x040d
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r0 = r0.findViewById(r11)
            net.one97.paytm.passbook.customview.CircularImageView r0 = (net.one97.paytm.passbook.customview.CircularImageView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            r11 = 8
            r0.setVisibility(r11)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r0 = r0.findViewById(r11)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r15)
            r11 = 0
            r0.setVisibility(r11)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r0 = r0.findViewById(r11)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r15)
            java.lang.String r11 = r3.getPayeeInitials()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.setText(r11)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r0 = r0.findViewById(r11)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r15)
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0405
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            int r11 = r2 % 4
            r5 = r5[r11]
            int r5 = r5.intValue()
            r0.setColor(r5)
            goto L_0x05a1
        L_0x0405:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r0.<init>(r1)
            throw r0
        L_0x040d:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r15)
            r5 = 8
            r0.setVisibility(r5)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r0 = r0.findViewById(r5)
            net.one97.paytm.passbook.customview.CircularImageView r0 = (net.one97.paytm.passbook.customview.CircularImageView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            r5 = 0
            r0.setVisibility(r5)
            java.lang.String r0 = r3.getImageUrl()
            boolean r0 = android.webkit.URLUtil.isValidUrl(r0)
            if (r0 == 0) goto L_0x05a1
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.lang.String r5 = r3.getImageUrl()
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r5)
            net.one97.paytm.passbook.customview.b r5 = new net.one97.paytm.passbook.customview.b
            r5.<init>()
            com.squareup.picasso.ah r5 = (com.squareup.picasso.ah) r5
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r5)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r11)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r0.a((android.widget.ImageView) r5)
            goto L_0x05a1
        L_0x0469:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r15)
            r5 = 8
            r0.setVisibility(r5)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r0 = r0.findViewById(r5)
            net.one97.paytm.passbook.customview.CircularImageView r0 = (net.one97.paytm.passbook.customview.CircularImageView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            r5 = 0
            r0.setVisibility(r5)
            java.lang.String r0 = r3.getImageUrl()
            boolean r0 = android.webkit.URLUtil.isValidUrl(r0)
            if (r0 == 0) goto L_0x04c5
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.lang.String r5 = r3.getImageUrl()
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r5)
            net.one97.paytm.passbook.customview.b r5 = new net.one97.paytm.passbook.customview.b
            r5.<init>()
            com.squareup.picasso.ah r5 = (com.squareup.picasso.ah) r5
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r5)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r11)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r0.a((android.widget.ImageView) r5)
            goto L_0x05a1
        L_0x04c5:
            java.lang.String r0 = r3.getTxnType()
            if (r0 == 0) goto L_0x0534
            java.lang.String r5 = "CR"
            r11 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r11)
            if (r5 == 0) goto L_0x0534
            java.lang.String r0 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r5 = "Added "
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r5, false)
            if (r0 == 0) goto L_0x050e
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.lang.String r5 = "https://assetscdn.paytm.com/images/catalog/pg/Add-money.jpg"
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r5)
            net.one97.paytm.passbook.customview.b r5 = new net.one97.paytm.passbook.customview.b
            r5.<init>()
            com.squareup.picasso.ah r5 = (com.squareup.picasso.ah) r5
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r5)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r11)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r0.a((android.widget.ImageView) r5)
            goto L_0x05a1
        L_0x050e:
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.lang.String r5 = "https://assetscdn.paytm.com/images/catalog/pg/Cashback.jpg"
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r5)
            net.one97.paytm.passbook.customview.b r5 = new net.one97.paytm.passbook.customview.b
            r5.<init>()
            com.squareup.picasso.ah r5 = (com.squareup.picasso.ah) r5
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r5)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r11)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r0.a((android.widget.ImageView) r5)
            goto L_0x05a1
        L_0x0534:
            if (r0 == 0) goto L_0x05a1
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r12, (boolean) r5)
            if (r0 == 0) goto L_0x05a1
            java.lang.String r0 = r3.getType()
            java.lang.String r11 = "22"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r11, (boolean) r5)
            if (r0 == 0) goto L_0x057c
            java.lang.String r0 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.content.res.Resources r5 = r6.getResources()
            int r11 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r5 = r5.getString(r11)
            java.lang.String r11 = "context.resources.getString(R.string.auth)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r5, false)
            if (r0 == 0) goto L_0x057c
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r0 = r0.findViewById(r5)
            net.one97.paytm.passbook.customview.CircularImageView r0 = (net.one97.paytm.passbook.customview.CircularImageView) r0
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_on_hold_txn
            r0.setImageResource(r5)
            goto L_0x05a1
        L_0x057c:
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.lang.String r5 = "https://assetscdn.paytm.com/images/catalog/pg/Paytm-cash-sent.jpg"
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r5)
            net.one97.paytm.passbook.customview.b r5 = new net.one97.paytm.passbook.customview.b
            r5.<init>()
            com.squareup.picasso.ah r5 = (com.squareup.picasso.ah) r5
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r5)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r11)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r0.a((android.widget.ImageView) r5)
        L_0x05a1:
            net.one97.paytm.passbook.mapping.e r0 = net.one97.paytm.passbook.mapping.e.a()
            java.lang.String r5 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            boolean r0 = net.one97.paytm.passbook.mapping.e.t()
            if (r0 == 0) goto L_0x0615
            java.lang.String r0 = r3.getPaymentsThemeId()
            if (r0 == 0) goto L_0x0615
            java.lang.String r0 = r3.getPaymentsThemeId()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0615
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r5 = r3.getPaymentsThemeId()
            net.one97.paytm.p2p.theme.ThemeData r0 = r0.a((android.content.Context) r6, (java.lang.String) r5)
            if (r0 == 0) goto L_0x0615
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r11)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            r8 = 0
            r5.setVisibility(r8)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r5 = r5.findViewById(r8)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r15)
            r8 = 8
            r5.setVisibility(r8)
            com.squareup.picasso.w r5 = com.squareup.picasso.w.a()
            java.lang.String r0 = r0.getImagerURL()
            com.squareup.picasso.aa r0 = r5.a((java.lang.String) r0)
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r5 = r5.findViewById(r8)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r0.a((android.widget.ImageView) r5)
        L_0x0615:
            net.one97.paytm.passbook.paytmBalance.a.a r0 = r4.f58161c
            java.lang.Boolean r0 = r0.f58150a
            if (r0 != 0) goto L_0x061e
            kotlin.g.b.k.a()
        L_0x061e:
            boolean r0 = r0.booleanValue()
            r4.a((net.one97.paytm.passbook.beans.CJRTransaction) r3, (android.content.Context) r6, (boolean) r0)
            net.one97.paytm.passbook.paytmBalance.a.a r0 = r4.f58161c
            java.lang.Boolean r0 = r0.f58150a
            if (r0 != 0) goto L_0x062e
            kotlin.g.b.k.a()
        L_0x062e:
            boolean r0 = r0.booleanValue()
            java.lang.String r5 = r3.getTxnType()
            java.lang.String r8 = r3.getTxnStatus()
            java.lang.String r11 = "itemView.passbook_sender_receiver_txn_status_tv"
            if (r8 == 0) goto L_0x073f
            java.lang.String r8 = r3.getTxnStatus()
            java.lang.String r15 = "SUCCESS"
            r2 = 1
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r15, (boolean) r2)
            if (r8 == 0) goto L_0x073f
            java.lang.String r8 = "all"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r2)
            if (r5 == 0) goto L_0x06fb
            java.lang.String r5 = r3.getTxnType()
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r12, (boolean) r2)
            if (r5 == 0) goto L_0x06fb
            java.lang.String r5 = r3.getType()
            java.lang.String r8 = "22"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r2)
            if (r5 == 0) goto L_0x06fb
            java.lang.String r2 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r5 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r5 = r6.getString(r5)
            java.lang.String r8 = "context.getString(R.string.auth)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, false)
            if (r2 == 0) goto L_0x06fb
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            int r2 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r2 = r6.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r2 = net.one97.paytm.passbook.R.color.status_pending
            int r2 = androidx.core.content.b.c(r6, r2)
            r0.setTextColor(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_send_receive_time
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r2 = "itemView.passbook_send_receive_time"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r2 = r3.getTxnDesc2()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_closing_balance
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            r2 = 8
            r0.setVisibility(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r0.setVisibility(r2)
            goto L_0x08c7
        L_0x06fb:
            if (r0 == 0) goto L_0x0711
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_closing_balance
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            r2 = 0
            r0.setVisibility(r2)
        L_0x0711:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r2 = 8
            r0.setVisibility(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.String r2 = ""
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            goto L_0x07bc
        L_0x073f:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x07c0
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r2 = "PENDING"
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r5)
            if (r0 == 0) goto L_0x07c0
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_txn_status_rl
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            r2 = 0
            r0.setVisibility(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r0.setVisibility(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.String r2 = "Pending"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r2 = net.one97.paytm.passbook.R.color.status_pending
            int r2 = androidx.core.content.b.c(r6, r2)
            r0.setTextColor(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_txn_status_icon
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r2 = net.one97.paytm.passbook.R.drawable.pass_txn_status_pending
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r6, (int) r2)
            r0.setImageDrawable(r2)
        L_0x07bc:
            r2 = 8
            goto L_0x08c7
        L_0x07c0:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x088e
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r2 = "FAILURE"
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r5)
            if (r0 == 0) goto L_0x088e
            int r0 = net.one97.paytm.passbook.R.string.wallet_rs_new
            java.lang.String r0 = r6.getString(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r8 = "₹<b>"
            r2.<init>(r8)
            kotlin.g.b.aa r8 = kotlin.g.b.aa.f47921a
            java.lang.String r8 = "rsformat"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r15 = r3.getTxnAmount()
            r16 = 0
            r8[r16] = r15
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r5)
            java.lang.String r0 = java.lang.String.format(r0, r8)
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            android.view.View r2 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_txn_status_rl
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            r2 = 0
            r0.setVisibility(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r0.setVisibility(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.String r2 = "Failure"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r2 = net.one97.paytm.passbook.R.color.status_failure
            int r2 = androidx.core.content.b.c(r6, r2)
            r0.setTextColor(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_txn_status_icon
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r2 = net.one97.paytm.passbook.R.drawable.pass_txn_status_failure
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r6, (int) r2)
            r0.setImageDrawable(r2)
            goto L_0x07bc
        L_0x088e:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x08a2
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r2 = "REFUNDED_BACK"
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r5)
            if (r0 != 0) goto L_0x08b2
            goto L_0x08a3
        L_0x08a2:
            r5 = 1
        L_0x08a3:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x08b2
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r2 = "REFUND_SUCCESS"
            kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r5)
        L_0x08b2:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_txn_status_rl
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            r2 = 8
            r0.setVisibility(r2)
        L_0x08c7:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.on_hold_pause_iv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r5 = "itemView.on_hold_pause_iv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_entry_row_detail_rl
            android.view.View r0 = r0.findViewById(r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            int r2 = net.one97.paytm.passbook.R.color.white
            int r2 = androidx.core.content.b.c(r6, r2)
            r0.setBackgroundColor(r2)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_extrainfo_btn_need_help_tv
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            net.one97.paytm.passbook.paytmBalance.a.a$b$g r2 = new net.one97.paytm.passbook.paytmBalance.a.a$b$g
            r2.<init>(r3, r6)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            java.lang.String r0 = r3.getTxnType()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r12)
            if (r0 == 0) goto L_0x0a1e
            java.lang.String r0 = r3.getType()
            java.lang.String r2 = "22"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0a1e
            java.lang.String r0 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r1 = r6.getString(r1)
            java.lang.String r2 = "context.getString(R.string.auth)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r1, (boolean) r2)
            if (r0 == 0) goto L_0x0a1e
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_extrainfo_btn_need_help_tv
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "itemView.passbook_extrainfo_btn_need_help_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_extrainfo_btn_need_help_tv
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "itemView.passbook_extrainfo_btn_need_help_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.res.Resources r1 = r6.getResources()
            int r2 = net.one97.paytm.passbook.R.string.passbook_on_hold_txn_text
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_entry_row_detail_rl
            android.view.View r0 = r0.findViewById(r1)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            int r1 = net.one97.paytm.passbook.R.color.color_fafbfb
            int r1 = androidx.core.content.b.c(r6, r1)
            r0.setBackgroundColor(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.passbook.R.color.color_b8c2cb
            int r1 = androidx.core.content.b.c(r6, r1)
            r0.setTextColor(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.on_hold_pause_iv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = "itemView.on_hold_pause_iv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_closing_balance
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            r1 = 8
            r0.setVisibility(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "₹<b>"
            r0.<init>(r1)
            java.lang.String r1 = r3.getTxnAmount()
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L_0x0a02
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            r2 = 63
            android.text.Spanned r0 = android.text.Html.fromHtml(r0, r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x0a1b
        L_0x0a02:
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x0a1b:
            r1 = 8
            goto L_0x0a35
        L_0x0a1e:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_extrainfo_btn_need_help_tv
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "itemView.passbook_extrainfo_btn_need_help_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 8
            r0.setVisibility(r1)
        L_0x0a35:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_bus_view_receipt_ll
            android.view.View r0 = r0.findViewById(r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r2 = "itemView.passbook_bus_view_receipt_ll"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
            android.view.View r0 = r0.findViewById(r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "itemView.passbook_send_receive_lyt_buttons_ll"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            r0 = r21
            r4.a((int) r0, (net.one97.paytm.passbook.beans.CJRTransaction) r3, (android.content.Context) r6)
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_entry_row_detail_rl
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            net.one97.paytm.passbook.paytmBalance.a.a$b$k r2 = new net.one97.paytm.passbook.paytmBalance.a.a$b$k
            r2.<init>(r4, r0, r3)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.bottom_separator
            android.view.View r1 = r1.findViewById(r2)
            java.lang.String r2 = "itemView.bottom_separator"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = 0
            r1.setVisibility(r2)
            boolean r1 = net.one97.paytm.passbook.paytmBalance.a.a.b.a((net.one97.paytm.passbook.beans.CJRTransaction) r3)
            if (r1 == 0) goto L_0x0ab4
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.tagTv
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "itemView.tagTv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r2 = net.one97.paytm.passbook.R.string.edit_tag
            java.lang.String r2 = r6.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            goto L_0x0ad1
        L_0x0ab4:
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.tagTv
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "itemView.tagTv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r2 = net.one97.paytm.passbook.R.string.tag_this_payment
            java.lang.String r2 = r6.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0ad1:
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.tagDetailTv
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "itemView.tagDetailTv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = 8
            r1.setVisibility(r2)
            net.one97.paytm.passbook.beans.CJRTransaction$TagInfo r1 = r3.getTagInfo()
            if (r1 == 0) goto L_0x0b20
            java.lang.String r1 = r1.tag
            if (r1 == 0) goto L_0x0b20
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0b20
            android.view.View r2 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            int r3 = net.one97.paytm.passbook.R.id.tagDetailTv
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "itemView.tagDetailTv"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 0
            r2.setVisibility(r3)
            android.view.View r2 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            int r3 = net.one97.paytm.passbook.R.id.tagDetailTv
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setText(r1)
        L_0x0b20:
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_closing_balance
            android.view.View r1 = r1.findViewById(r2)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r10)
            r2 = 8
            r1.setVisibility(r2)
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r3 = net.one97.paytm.passbook.R.id.bottom_separator
            android.view.View r1 = r1.findViewById(r3)
            java.lang.String r3 = "itemView.bottom_separator"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r1.setVisibility(r2)
            r1 = r19
            net.one97.paytm.passbook.customview.d r2 = r1.f58152c
            r5 = r20
            android.view.View r3 = r5.itemView
            java.lang.String r5 = "baseTransactionsHolder.itemView"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.swipeBgLayout
            android.view.View r3 = r3.findViewById(r5)
            net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook r3 = (net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook) r3
            int r4 = r4.getAdapterPosition()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r2.a((net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook) r3, (java.lang.String) r4)
            goto L_0x0b96
        L_0x0b69:
            r1 = r0
            kotlin.u r0 = new kotlin.u
            r0.<init>(r11)
            throw r0
        L_0x0b70:
            r1 = r0
            kotlin.u r0 = new kotlin.u
            r0.<init>(r11)
            throw r0
        L_0x0b77:
            r5 = r1
            r1 = r0
            r0 = r2
            boolean r2 = r5 instanceof net.one97.paytm.passbook.paytmBalance.a.a.d
            if (r2 == 0) goto L_0x0b96
            r2 = r5
            net.one97.paytm.passbook.paytmBalance.a.a$d r2 = (net.one97.paytm.passbook.paytmBalance.a.a.d) r2
            java.lang.String r4 = "transaction"
            kotlin.g.b.k.c(r3, r4)
            boolean r4 = r3 instanceof net.one97.paytm.passbook.subWallet.model.TransactionHeader
            if (r4 == 0) goto L_0x0b96
            android.widget.TextView r2 = r2.f58190a
            net.one97.paytm.passbook.subWallet.model.TransactionHeader r3 = (net.one97.paytm.passbook.subWallet.model.TransactionHeader) r3
            java.lang.String r3 = r3.txnDate
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x0b96:
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r2 = r1.f58151b
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            int r3 = r1.f58157h
            int r2 = r2 - r3
            if (r0 != r2) goto L_0x0ba8
            net.one97.paytm.passbook.genericPassbook.b.c r0 = r1.j
            r0.c()
        L_0x0ba8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final class b extends C1115a implements a.C1069a {

        /* renamed from: a  reason: collision with root package name */
        public CJRTransaction f58159a;

        /* renamed from: b  reason: collision with root package name */
        final String f58160b = "##,##,##,##,##,##,##0.00";

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f58161c;

        /* renamed from: d  reason: collision with root package name */
        private final int f58162d;

        static final class d<T> implements i.a<IJRDataModel> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f58171a;

            d(Context context) {
                this.f58171a = context;
            }

            public final /* synthetic */ void onResponse(Object obj) {
                IJRDataModel iJRDataModel = (IJRDataModel) obj;
                if (iJRDataModel instanceof CJRBusInvoiceModel) {
                    CJRBusInvoiceModel cJRBusInvoiceModel = (CJRBusInvoiceModel) iJRDataModel;
                    if (p.a(cJRBusInvoiceModel.getStatusCode(), "SUCCESS", true)) {
                        net.one97.paytm.passbook.d.b();
                        if (this.f58171a == null) {
                            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        }
                        return;
                    }
                    Context context = this.f58171a;
                    com.paytm.utility.g.c(context, context.getString(R.string.error), cJRBusInvoiceModel.getmStatusMessage(), AnonymousClass1.f58172a);
                }
            }
        }

        static final class h<T> implements i.a<IJRDataModel> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58180a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f58181b;

            h(b bVar, int i2) {
                this.f58180a = bVar;
                this.f58181b = i2;
            }

            public final /* synthetic */ void onResponse(Object obj) {
                IJRDataModel iJRDataModel = (IJRDataModel) obj;
                if (iJRDataModel != null) {
                    CJRLedgerResponse cJRLedgerResponse = (CJRLedgerResponse) iJRDataModel;
                    if (cJRLedgerResponse != null) {
                        if (!kotlin.g.b.k.a((Object) cJRLedgerResponse.getTxnStatus(), (Object) "WM_1006")) {
                            this.f58180a.f58161c.f58151b.get(this.f58181b).setmIsBtnEnabled(false);
                            this.f58180a.f58161c.notifyItemChanged(this.f58181b);
                        }
                        View view = this.f58180a.itemView;
                        kotlin.g.b.k.a((Object) view, "itemView");
                        net.one97.paytm.passbook.mapping.c.a(view.getContext(), (String) null, cJRLedgerResponse.getDisplayMessage());
                        net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                        net.one97.paytm.passbook.genericPassbook.d.a.f.a();
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.CJRLedgerResponse");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "itemView");
            this.f58161c = aVar;
            this.f58162d = net.one97.paytm.passbook.utility.c.a(15.0f, view.getContext());
            ((TextView) view.findViewById(R.id.tagTv)).setOnTouchListener(new View.OnTouchListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f58163a;

                {
                    this.f58163a = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    kotlin.g.b.k.c(view, "v");
                    kotlin.g.b.k.c(motionEvent, "m");
                    if (motionEvent.getAction() == 0) {
                        if (b.a(this.f58163a.a())) {
                            c cVar = this.f58163a.f58161c.f58153d;
                            this.f58163a.getPosition();
                            cVar.c(this.f58163a.a());
                        } else {
                            c cVar2 = this.f58163a.f58161c.f58153d;
                            this.f58163a.getPosition();
                            cVar2.b(this.f58163a.a());
                        }
                        this.f58163a.f58161c.f58152c.b(String.valueOf(this.f58163a.getPosition()));
                    }
                    return true;
                }
            });
            ((TextView) view.findViewById(R.id.historyTv)).setOnTouchListener(new View.OnTouchListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f58164a;

                {
                    this.f58164a = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    kotlin.g.b.k.c(view, "v");
                    kotlin.g.b.k.c(motionEvent, "m");
                    if (motionEvent.getAction() != 0) {
                        return true;
                    }
                    this.f58164a.f58161c.f58153d.a(this.f58164a.getPosition(), this.f58164a.a());
                    this.f58164a.f58161c.f58152c.b(String.valueOf(this.f58164a.getPosition()));
                    return true;
                }
            });
        }

        public final CJRTransaction a() {
            CJRTransaction cJRTransaction = this.f58159a;
            if (cJRTransaction == null) {
                kotlin.g.b.k.a("transaction");
            }
            return cJRTransaction;
        }

        static final class k implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58187a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f58188b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CJRTransaction f58189c;

            k(b bVar, int i2, CJRTransaction cJRTransaction) {
                this.f58187a = bVar;
                this.f58188b = i2;
                this.f58189c = cJRTransaction;
            }

            public final void onClick(View view) {
                this.f58187a.f58161c.f58153d.a(this.f58189c);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r1 = r1.tag;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static boolean a(net.one97.paytm.passbook.beans.CJRTransaction r1) {
            /*
                net.one97.paytm.passbook.beans.CJRTransaction$TagInfo r1 = r1.getTagInfo()
                r0 = 0
                if (r1 == 0) goto L_0x0015
                java.lang.String r1 = r1.tag
                if (r1 == 0) goto L_0x0015
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0015
                r1 = 1
                return r1
            L_0x0015:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.a.a.b.a(net.one97.paytm.passbook.beans.CJRTransaction):boolean");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0137  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(net.one97.paytm.passbook.beans.CJRTransaction r8, android.content.Context r9, boolean r10) {
            /*
                r7 = this;
                android.content.res.Resources r9 = r9.getResources()
                int r0 = net.one97.paytm.passbook.R.string.closing_balance_rs
                java.lang.String r9 = r9.getString(r0)
                java.util.ArrayList r0 = r8.getExtendedTxnInfo()
                r1 = 0
                if (r0 == 0) goto L_0x00a5
                java.util.ArrayList r0 = r8.getExtendedTxnInfo()
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x00a5
                if (r10 == 0) goto L_0x00a5
                java.util.ArrayList r0 = r8.getExtendedTxnInfo()
                int r0 = r0.size()
                r2 = 0
            L_0x0026:
                if (r2 >= r0) goto L_0x00a5
                net.one97.paytm.passbook.paytmBalance.a.a r3 = r7.f58161c
                int r3 = r3.f58154e
                java.util.ArrayList r4 = r8.getExtendedTxnInfo()
                java.lang.Object r4 = r4.get(r2)
                java.lang.String r5 = "transaction.extendedTxnInfo[i]"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                net.one97.paytm.passbook.beans.ExtendedTxnInfo r4 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r4
                java.lang.String r4 = r4.getSubWalletType()
                int r4 = java.lang.Integer.parseInt(r4)
                if (r3 != r4) goto L_0x00a2
                java.util.ArrayList r3 = r8.getExtendedTxnInfo()
                java.lang.Object r3 = r3.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
                net.one97.paytm.passbook.beans.ExtendedTxnInfo r3 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r3
                java.lang.String r3 = r3.getClosingBalance()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x00a2
                java.text.DecimalFormat r0 = new java.text.DecimalFormat
                java.util.ArrayList r3 = r8.getExtendedTxnInfo()
                java.lang.Object r3 = r3.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
                net.one97.paytm.passbook.beans.ExtendedTxnInfo r3 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r3
                java.lang.String r3 = r3.getClosingBalance()
                double r3 = java.lang.Double.parseDouble(r3)
                java.lang.String r3 = net.one97.paytm.passbook.utility.q.a((double) r3)
                java.util.Locale r4 = java.util.Locale.ENGLISH
                java.text.DecimalFormatSymbols r4 = java.text.DecimalFormatSymbols.getInstance(r4)
                r0.<init>(r3, r4)
                java.util.ArrayList r8 = r8.getExtendedTxnInfo()
                java.lang.Object r8 = r8.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
                net.one97.paytm.passbook.beans.ExtendedTxnInfo r8 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r8
                java.lang.String r8 = r8.getClosingBalance()
                double r2 = java.lang.Double.parseDouble(r8)
                java.lang.String r8 = r0.format(r2)
                java.lang.String r0 = "DecimalFormat(Util.getFo…nInfo[i].closingBalance))"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
                goto L_0x00a7
            L_0x00a2:
                int r2 = r2 + 1
                goto L_0x0026
            L_0x00a5:
                java.lang.String r8 = ""
            L_0x00a7:
                java.lang.String r0 = "itemView.passbook_closing_balance"
                java.lang.String r2 = "itemView"
                if (r10 == 0) goto L_0x0137
                r10 = r8
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                boolean r10 = android.text.TextUtils.isEmpty(r10)
                java.lang.String r3 = "java.lang.String.format(format, *args)"
                java.lang.String r4 = "closingBalanceFormat"
                r5 = 1
                if (r10 != 0) goto L_0x00f8
                android.view.View r10 = r7.itemView
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
                int r6 = net.one97.paytm.passbook.R.id.passbook_closing_balance
                android.view.View r10 = r10.findViewById(r6)
                com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
                r10.setVisibility(r1)
                kotlin.g.b.aa r10 = kotlin.g.b.aa.f47921a
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                java.lang.Object[] r10 = new java.lang.Object[r5]
                r10[r1] = r8
                java.lang.Object[] r8 = java.util.Arrays.copyOf(r10, r5)
                java.lang.String r8 = java.lang.String.format(r9, r8)
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
                android.view.View r9 = r7.itemView
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
                int r10 = net.one97.paytm.passbook.R.id.passbook_closing_balance
                android.view.View r9 = r9.findViewById(r10)
                com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r9.setText(r8)
                return
            L_0x00f8:
                android.view.View r8 = r7.itemView
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
                int r10 = net.one97.paytm.passbook.R.id.passbook_closing_balance
                android.view.View r8 = r8.findViewById(r10)
                com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
                r8.setVisibility(r1)
                kotlin.g.b.aa r8 = kotlin.g.b.aa.f47921a
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                java.lang.Object[] r8 = new java.lang.Object[r5]
                java.lang.String r10 = "--.--"
                r8[r1] = r10
                java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r5)
                java.lang.String r8 = java.lang.String.format(r9, r8)
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
                android.view.View r9 = r7.itemView
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
                int r10 = net.one97.paytm.passbook.R.id.passbook_closing_balance
                android.view.View r9 = r9.findViewById(r10)
                com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r9.setText(r8)
                return
            L_0x0137:
                android.view.View r8 = r7.itemView
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
                int r9 = net.one97.paytm.passbook.R.id.passbook_closing_balance
                android.view.View r8 = r8.findViewById(r9)
                com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
                r9 = 8
                r8.setVisibility(r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.a.a.b.a(net.one97.paytm.passbook.beans.CJRTransaction, android.content.Context, boolean):void");
        }

        static final class g implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRTransaction f58178a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f58179b;

            g(CJRTransaction cJRTransaction, Context context) {
                this.f58178a = cJRTransaction;
                this.f58179b = context;
            }

            public final void onClick(View view) {
                if (kotlin.g.b.k.a((Object) this.f58178a.getTxnType(), (Object) "DR") && kotlin.g.b.k.a((Object) this.f58178a.getType(), (Object) "22")) {
                    String narration = this.f58178a.getNarration();
                    kotlin.g.b.k.a((Object) narration, "transaction.narration");
                    String string = this.f58179b.getString(R.string.auth);
                    kotlin.g.b.k.a((Object) string, "context.getString(R.string.auth)");
                    if (p.a((CharSequence) narration, (CharSequence) string, true)) {
                        Context context = this.f58179b;
                        context.startActivity(new Intent(context, WalletLandingPageActivity.class));
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ac, code lost:
            if (net.one97.paytm.passbook.mapping.c.ao(r19) == false) goto L_0x0167;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r17, net.one97.paytm.passbook.beans.CJRTransaction r18, android.content.Context r19) {
            /*
                r16 = this;
                r0 = r16
                r2 = r19
                int r1 = com.paytm.utility.b.f((android.content.Context) r19)
                int r3 = r1 / 2
                double r4 = (double) r1
                r6 = 4615063718147915776(0x400c000000000000, double:3.5)
                double r4 = r4 * r6
                int r1 = (int) r4
                if (r2 == 0) goto L_0x0206
                r4 = r2
                android.app.Activity r4 = (android.app.Activity) r4
                int r4 = com.paytm.utility.b.a((android.app.Activity) r4)
                int r5 = r3 * 2
                int r5 = r5 + r1
                int r5 = r5 + r3
                int r6 = r4 - r5
                java.util.ArrayList r1 = r18.getButtonList()
                android.view.View r3 = r0.itemView
                java.lang.String r4 = "itemView"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                int r5 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
                android.view.View r3 = r3.findViewById(r5)
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                r3.removeAllViews()
                android.view.View r3 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                int r5 = net.one97.paytm.passbook.R.id.passbook_bus_view_receipt_ll
                android.view.View r3 = r3.findViewById(r5)
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                r3.removeAllViews()
                java.lang.String r3 = "itemView.passbook_send_receive_lyt_buttons_ll"
                if (r1 == 0) goto L_0x01f0
                int r7 = r1.size()
                if (r7 <= 0) goto L_0x01f0
                android.view.View r7 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
                int r8 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
                android.view.View r7 = r7.findViewById(r8)
                android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
                r8 = 0
                r7.setVisibility(r8)
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r9 = r1
                java.util.Collection r9 = (java.util.Collection) r9
                int r9 = r9.size()
                r10 = 0
            L_0x0070:
                if (r10 >= r9) goto L_0x01b2
                java.lang.Object r11 = r1.get(r10)
                net.one97.paytm.passbook.beans.CJRButton r11 = (net.one97.paytm.passbook.beans.CJRButton) r11
                boolean r12 = r18.isBtnEnabled()
                java.lang.String r13 = "null cannot be cast to non-null type java.lang.String"
                java.lang.String r14 = "refundtopg"
                java.lang.String r15 = "(this as java.lang.String).toLowerCase()"
                java.lang.String r5 = "button.actionUrl"
                java.lang.String r8 = "button"
                if (r12 == 0) goto L_0x016b
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r8)
                java.lang.String r8 = r11.getActionUrl()
                if (r8 == 0) goto L_0x00b5
                java.lang.String r8 = r11.getActionUrl()
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
                if (r8 == 0) goto L_0x00af
                java.lang.String r5 = r8.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r15)
                r8 = 0
                boolean r5 = kotlin.m.p.c(r5, r14, r8)
                if (r5 == 0) goto L_0x00b5
                boolean r5 = net.one97.paytm.passbook.mapping.c.ao(r19)
                if (r5 == 0) goto L_0x0167
                goto L_0x00b5
            L_0x00af:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r13)
                throw r1
            L_0x00b5:
                java.lang.String r5 = r11.getActionUrl()
                if (r5 != 0) goto L_0x0156
                java.lang.String r5 = r18.getType()
                r8 = 1
                java.lang.String r12 = "1"
                boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r12, (boolean) r8)
                if (r5 == 0) goto L_0x0156
                java.lang.String r5 = r18.getLabel()
                java.lang.String r12 = "UTS"
                boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r12, (boolean) r8)
                if (r5 == 0) goto L_0x0156
                android.view.View r5 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
                int r8 = net.one97.paytm.passbook.R.id.passbook_bus_view_receipt_ll
                android.view.View r5 = r5.findViewById(r8)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                java.lang.String r8 = "itemView.passbook_bus_view_receipt_ll"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
                r8 = 0
                r5.setVisibility(r8)
                android.view.View r5 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
                int r8 = net.one97.paytm.passbook.R.id.passbook_bus_view_receipt_ll
                android.view.View r5 = r5.findViewById(r8)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                java.lang.String r8 = r11.getButtonName()
                java.lang.String r11 = "button.buttonName"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r11)
                java.lang.String r11 = r18.getWalletOrderId()
                java.lang.String r12 = "transaction.walletOrderId"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
                android.widget.Button r12 = new android.widget.Button
                r12.<init>(r2)
                r13 = r8
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                r12.setText(r13)
                r12.setTag(r8)
                android.content.res.Resources r8 = r19.getResources()
                int r13 = net.one97.paytm.passbook.R.color.paytm_blue
                int r8 = r8.getColor(r13)
                r12.setTextColor(r8)
                r8 = 1095761920(0x41500000, float:13.0)
                r13 = 2
                r12.setTextSize(r13, r8)
                r8 = 8
                r13 = 0
                r12.setPadding(r8, r13, r8, r13)
                r12.setBackgroundColor(r13)
                int r8 = net.one97.paytm.passbook.R.color.color_blue_passbook_action
                int r8 = androidx.core.content.b.c(r2, r8)
                r12.setTextColor(r8)
                java.lang.String r8 = "Roboto-Medium.ttf"
                android.graphics.Typeface r8 = com.paytm.utility.w.a(r2, r8)
                r12.setTypeface(r8)
                net.one97.paytm.passbook.paytmBalance.a.a$b$a r8 = new net.one97.paytm.passbook.paytmBalance.a.a$b$a
                r8.<init>(r0, r2, r11)
                android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
                r12.setOnClickListener(r8)
                android.view.View r12 = (android.view.View) r12
                r5.addView(r12)
                goto L_0x0167
            L_0x0156:
                boolean r5 = r18.isInvoiceProcessed()
                if (r5 == 0) goto L_0x0169
                java.lang.String r5 = r11.getActionUrl()
                boolean r5 = com.paytm.utility.v.a((java.lang.String) r5)
                if (r5 == 0) goto L_0x0167
                goto L_0x0169
            L_0x0167:
                r8 = 0
                goto L_0x01a8
            L_0x0169:
                r8 = 0
                goto L_0x019a
            L_0x016b:
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r8)
                java.lang.String r8 = r11.getActionUrl()
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
                if (r8 == 0) goto L_0x01ac
                java.lang.String r5 = r8.toLowerCase()
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r15)
                r8 = 0
                boolean r5 = kotlin.m.p.c(r5, r14, r8)
                if (r5 == 0) goto L_0x019a
                android.view.View r5 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
                int r12 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
                android.view.View r5 = r5.findViewById(r12)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
                r12 = 8
                r5.setVisibility(r12)
            L_0x019a:
                int r5 = r7.size()
                java.lang.String r12 = r11.getButtonName()
                r7.add(r12)
                r11.setButtonTag(r5)
            L_0x01a8:
                int r10 = r10 + 1
                goto L_0x0070
            L_0x01ac:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r13)
                throw r1
            L_0x01b2:
                int r1 = r7.size()
                if (r1 <= 0) goto L_0x01da
                net.one97.paytm.passbook.customview.a r1 = new net.one97.paytm.passbook.customview.a
                r3 = r0
                net.one97.paytm.passbook.customview.a$a r3 = (net.one97.paytm.passbook.customview.a.C1069a) r3
                android.view.View r5 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
                int r4 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
                android.view.View r4 = r5.findViewById(r4)
                r5 = r4
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                r8 = r18
                net.one97.paytm.passbook.mapping.IJRDataModel r8 = (net.one97.paytm.passbook.mapping.IJRDataModel) r8
                java.lang.String r9 = ""
                r2 = r19
                r4 = r7
                r7 = r17
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                return
            L_0x01da:
                android.view.View r1 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                int r2 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
                android.view.View r1 = r1.findViewById(r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                r2 = 8
                r1.setVisibility(r2)
                return
            L_0x01f0:
                r2 = 8
                android.view.View r1 = r0.itemView
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                int r4 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
                android.view.View r1 = r1.findViewById(r4)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                r1.setVisibility(r2)
                return
            L_0x0206:
                kotlin.u r1 = new kotlin.u
                java.lang.String r2 = "null cannot be cast to non-null type android.app.Activity"
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.a.a.b.a(int, net.one97.paytm.passbook.beans.CJRTransaction, android.content.Context):void");
        }

        /* renamed from: net.one97.paytm.passbook.paytmBalance.a.a$b$a  reason: collision with other inner class name */
        static final class C1116a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58165a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f58166b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f58167c;

            C1116a(b bVar, Context context, String str) {
                this.f58165a = bVar;
                this.f58166b = context;
                this.f58167c = str;
            }

            public final void onClick(View view) {
                com.paytm.utility.b.k(this.f58166b, "Please wait");
                String str = this.f58167c;
                Context context = this.f58166b;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("systemTxnId", str);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "192.168.1.100");
                    jSONObject.put("channel", "WEB");
                    jSONObject.put("version", "1.0");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "WITHDRAW_MONEY");
                } catch (JSONException unused) {
                }
                String a2 = net.one97.paytm.passbook.d.b().a("utsGetInvoiceUrl");
                if (a2 != null) {
                    String e2 = com.paytm.utility.b.e(context, a2);
                    Map hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    String a3 = net.one97.paytm.passbook.mapping.b.a(context);
                    kotlin.g.b.k.a((Object) a3, "CJRServerUtility.getSSOToken(context)");
                    hashMap.put("ssotoken", a3);
                    hashMap.put("Accept-Encoding", "gzip");
                    if (com.paytm.utility.b.c(context)) {
                        net.one97.paytm.passbook.mapping.a.c.a();
                        net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(e2, b.a(context), b.b(context), new CJRBusInvoiceModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, net.one97.paytm.passbook.subWallet.b.d.class.getName()));
                        return;
                    }
                    net.one97.paytm.passbook.mapping.a.a(new net.one97.paytm.passbook.mapping.a.b(e2, b.a(context), b.b(context), new CJRBusInvoiceModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, net.one97.paytm.passbook.search.e.class.getName()), context, c.f58170a);
                }
            }
        }

        static final class c implements DialogInterface.OnCancelListener {

            /* renamed from: a  reason: collision with root package name */
            public static final c f58170a = new c();

            c() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }

        static i.a<IJRDataModel> a(Context context) {
            return new d<>(context);
        }

        /* renamed from: net.one97.paytm.passbook.paytmBalance.a.a$b$b  reason: collision with other inner class name */
        static final class C1117b implements net.one97.paytm.passbook.mapping.a.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f58168a;

            C1117b(Context context) {
                this.f58168a = context;
            }

            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                Context context = this.f58168a;
                com.paytm.utility.g.c(context, context.getString(R.string.error), this.f58168a.getString(R.string.some_went_wrong), AnonymousClass1.f58169a);
            }
        }

        static net.one97.paytm.passbook.mapping.a.g b(Context context) {
            return new C1117b(context);
        }

        public final void a(int i2, int i3) {
            CJRButton buttonWithTag = this.f58161c.f58151b.get(i3).getButtonWithTag(i2);
            CJRTransaction cJRTransaction = this.f58161c.f58151b.get(i3);
            kotlin.g.b.k.a((Object) cJRTransaction, "mTransactionList[listItemIndex]");
            String txnAmount = cJRTransaction.getTxnAmount();
            if (buttonWithTag != null) {
                try {
                    CJRTransaction cJRTransaction2 = this.f58161c.f58151b.get(i3);
                    kotlin.g.b.k.a((Object) cJRTransaction2, "mTransactionList[listItemIndex]");
                    if (p.a("20", cJRTransaction2.getType(), true)) {
                        View view = this.itemView;
                        kotlin.g.b.k.a((Object) view, "itemView");
                        Dialog dialog = new Dialog(view.getContext());
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.pass_dialog_return_to_bank);
                        aa aaVar = aa.f47921a;
                        View view2 = this.itemView;
                        kotlin.g.b.k.a((Object) view2, "itemView");
                        Context context = view2.getContext();
                        kotlin.g.b.k.a((Object) context, "itemView.context");
                        String string = context.getResources().getString(R.string.wallet_rs);
                        kotlin.g.b.k.a((Object) string, "itemView.context.resourc…tring(R.string.wallet_rs)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{txnAmount}, 1));
                        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                        TextView textView = (TextView) dialog.findViewById(R.id.dialog_returntobank_amount);
                        kotlin.g.b.k.a((Object) textView, "amountTV");
                        textView.setText(format);
                        ((Button) dialog.findViewById(R.id.dialog_returntobank_positive_action)).setOnClickListener(new e(this, buttonWithTag, i3, dialog));
                        ((TextView) dialog.findViewById(R.id.dialog_returntobank_negative_action)).setOnClickListener(new f(dialog));
                        dialog.show();
                    }
                } catch (Exception unused) {
                }
            } else {
                com.paytm.utility.b.j();
            }
        }

        static final class e implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58173a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRButton f58174b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f58175c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Dialog f58176d;

            e(b bVar, CJRButton cJRButton, int i2, Dialog dialog) {
                this.f58173a = bVar;
                this.f58174b = cJRButton;
                this.f58175c = i2;
                this.f58176d = dialog;
            }

            public final void onClick(View view) {
                net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                View view2 = this.f58173a.itemView;
                kotlin.g.b.k.a((Object) view2, "itemView");
                Context context = view2.getContext();
                kotlin.g.b.k.a((Object) context, "itemView.context");
                net.one97.paytm.passbook.genericPassbook.d.a.f.a(context);
                JSONObject a2 = b.a(this.f58174b.getActionUrlRequest());
                b bVar = this.f58173a;
                String actionUrl = this.f58174b.getActionUrl();
                kotlin.g.b.k.a((Object) actionUrl, "buttonObj.actionUrl");
                int i2 = this.f58175c;
                View view3 = bVar.itemView;
                kotlin.g.b.k.a((Object) view3, "itemView");
                if (com.paytm.utility.b.c(view3.getContext())) {
                    m.a aVar = m.f59265a;
                    View view4 = bVar.itemView;
                    kotlin.g.b.k.a((Object) view4, "itemView");
                    Context context2 = view4.getContext();
                    kotlin.g.b.k.a((Object) context2, "itemView.context");
                    Context applicationContext = context2.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext, "itemView.context.applicationContext");
                    if (!TextUtils.isEmpty(m.a.a(applicationContext).b("sso_token=", "", true))) {
                        net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                        View view5 = bVar.itemView;
                        kotlin.g.b.k.a((Object) view5, "itemView");
                        Context context3 = view5.getContext();
                        if (context3 != null) {
                            b2.a((Activity) context3, (com.paytm.network.listener.b) new j(bVar, actionUrl, a2, i2), a.c.PASSBOOK);
                        } else {
                            throw new u("null cannot be cast to non-null type android.app.Activity");
                        }
                    } else {
                        net.one97.paytm.passbook.genericPassbook.d.a.f fVar2 = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                        net.one97.paytm.passbook.genericPassbook.d.a.f.a();
                    }
                } else {
                    View view6 = bVar.itemView;
                    kotlin.g.b.k.a((Object) view6, "itemView");
                    Context context4 = view6.getContext();
                    View view7 = bVar.itemView;
                    kotlin.g.b.k.a((Object) view7, "itemView");
                    String string = view7.getContext().getString(R.string.no_connection);
                    View view8 = bVar.itemView;
                    kotlin.g.b.k.a((Object) view8, "itemView");
                    net.one97.paytm.passbook.mapping.c.a(context4, string, view8.getContext().getString(R.string.no_internet));
                    net.one97.paytm.passbook.genericPassbook.d.a.f fVar3 = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                    net.one97.paytm.passbook.genericPassbook.d.a.f.a();
                }
                this.f58176d.dismiss();
            }
        }

        static final class f implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Dialog f58177a;

            f(Dialog dialog) {
                this.f58177a = dialog;
            }

            public final void onClick(View view) {
                this.f58177a.dismiss();
            }
        }

        static JSONObject a(CJRActionUrlRequest cJRActionUrlRequest) {
            if (cJRActionUrlRequest == null) {
                return null;
            }
            HashMap<Object, Object> request = cJRActionUrlRequest.getRequest();
            JSONObject jSONObject = new JSONObject();
            if (request != null) {
                try {
                    jSONObject.put("request", new JSONObject(request));
                } catch (JSONException unused) {
                }
            }
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, cJRActionUrlRequest.getIpAddress());
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, cJRActionUrlRequest.getPlatformName());
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, cJRActionUrlRequest.getOperationType());
            jSONObject.put("metadata", cJRActionUrlRequest.getMetadata());
            return jSONObject;
        }

        public static final class j implements com.paytm.network.listener.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58183a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f58184b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ JSONObject f58185c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f58186d;

            j(b bVar, String str, JSONObject jSONObject, int i2) {
                this.f58183a = bVar;
                this.f58184b = str;
                this.f58185c = jSONObject;
                this.f58186d = i2;
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                net.one97.paytm.passbook.genericPassbook.d.a.f.a();
                View view = this.f58183a.itemView;
                kotlin.g.b.k.a((Object) view, "itemView");
                Context context = view.getContext();
                if (context != null) {
                    getClass().getName();
                    net.one97.paytm.passbook.utility.j.a((Activity) context, (Throwable) networkCustomError);
                    View view2 = this.f58183a.itemView;
                    kotlin.g.b.k.a((Object) view2, "itemView");
                    Toast.makeText(view2.getContext(), "Error", 0).show();
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel != null) {
                    b bVar = this.f58183a;
                    String str = this.f58184b;
                    JSONObject jSONObject = this.f58185c;
                    int i2 = this.f58186d;
                    String a2 = net.one97.paytm.passbook.d.b().a((CJRPGTokenList) iJRPaytmDataModel);
                    "walletSSOToken :: ".concat(String.valueOf(a2));
                    com.paytm.utility.b.j();
                    if (!TextUtils.isEmpty(a2)) {
                        kotlin.g.b.k.a((Object) a2, "walletSSOToken");
                        kotlin.g.b.k.c(str, "url");
                        kotlin.g.b.k.c(a2, "walletSsoToken");
                        View view = bVar.itemView;
                        kotlin.g.b.k.a((Object) view, "itemView");
                        String b2 = com.paytm.utility.b.b(view.getContext(), str);
                        kotlin.g.b.k.a((Object) b2, "CJRAppCommonUtility.addS…ms(itemView.context, url)");
                        Map hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        hashMap.put("ssotoken", a2);
                        hashMap.put("Accept-Encoding", "gzip");
                        String str2 = null;
                        if (jSONObject != null) {
                            str2 = jSONObject.toString();
                        }
                        String str3 = str2;
                        "----> URL ::".concat(String.valueOf(b2));
                        com.paytm.utility.b.j();
                        StringBuilder sb = new StringBuilder("----> JSON ::");
                        if (str3 == null) {
                            kotlin.g.b.k.a();
                        }
                        sb.append(str3);
                        com.paytm.utility.b.j();
                        if (URLUtil.isValidUrl(b2)) {
                            View view2 = bVar.itemView;
                            kotlin.g.b.k.a((Object) view2, "itemView");
                            if (com.paytm.utility.b.c(view2.getContext())) {
                                View view3 = bVar.itemView;
                                kotlin.g.b.k.a((Object) view3, "itemView");
                                view3.getContext();
                                net.one97.paytm.passbook.mapping.a.c.a();
                                net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(b2, new h(bVar, i2), new i(bVar), new CJRLedgerResponse(), hashMap, str3, a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, net.one97.paytm.passbook.subWallet.c.c.class.getName()));
                                return;
                            }
                            View view4 = bVar.itemView;
                            kotlin.g.b.k.a((Object) view4, "itemView");
                            Context context = view4.getContext();
                            View view5 = bVar.itemView;
                            kotlin.g.b.k.a((Object) view5, "itemView");
                            String string = view5.getContext().getString(R.string.no_connection);
                            View view6 = bVar.itemView;
                            kotlin.g.b.k.a((Object) view6, "itemView");
                            net.one97.paytm.passbook.mapping.c.a(context, string, view6.getContext().getString(R.string.no_internet));
                            net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                            net.one97.paytm.passbook.genericPassbook.d.a.f.a();
                            return;
                        }
                        return;
                    }
                    net.one97.paytm.passbook.genericPassbook.d.a.f fVar2 = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                    net.one97.paytm.passbook.genericPassbook.d.a.f.a();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRPGTokenList");
            }
        }

        static final class i implements net.one97.paytm.passbook.mapping.a.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58182a;

            i(b bVar) {
                this.f58182a = bVar;
            }

            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                View view = this.f58182a.itemView;
                kotlin.g.b.k.a((Object) view, "itemView");
                Context context = view.getContext();
                if (context != null) {
                    this.f58182a.getClass().getName();
                    net.one97.paytm.passbook.utility.j.a((Activity) context, (Throwable) networkCustomError);
                    net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                    net.one97.paytm.passbook.genericPassbook.d.a.f.a();
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    public static final class d extends C1115a {

        /* renamed from: a  reason: collision with root package name */
        final TextView f58190a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.date);
            k.a((Object) findViewById, "itemView.findViewById(R.id.date)");
            this.f58190a = (TextView) findViewById;
        }
    }

    /* renamed from: net.one97.paytm.passbook.paytmBalance.a.a$a  reason: collision with other inner class name */
    public static class C1115a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1115a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }

    public final int a(int i2) {
        while (!c(i2)) {
            i2--;
            if (i2 < 0) {
                return 0;
            }
        }
        return i2;
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58191a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58192b;

        public e(a aVar, x.e eVar) {
            this.f58191a = aVar;
            this.f58192b = eVar;
        }

        public final void run() {
            this.f58191a.f58152c.a((String) this.f58192b.element);
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58193a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58194b;

        public f(a aVar, x.e eVar) {
            this.f58193a = aVar;
            this.f58194b = eVar;
        }

        public final void run() {
            this.f58193a.f58152c.b((String) this.f58194b.element);
        }
    }

    public final int b(int i2) {
        if (this.f58151b.get(i2) instanceof TransactionHeader) {
            return R.layout.pass_new_search_header_item;
        }
        return R.layout.pass_subwallet_txn_item_layout;
    }

    public final void a(View view, int i2) {
        k.c(view, H5Logger.HEADER);
        TextView textView = (TextView) view.findViewById(R.id.date);
        CJRTransaction cJRTransaction = this.f58151b.get(i2);
        if (cJRTransaction != null) {
            k.a((Object) textView, "tvHeader");
            textView.setText(((TransactionHeader) cJRTransaction).txnDate);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.subWallet.model.TransactionHeader");
    }

    public final boolean c(int i2) {
        try {
            return this.f58151b.get(i2) instanceof TransactionHeader;
        } catch (Exception unused) {
            return false;
        }
    }
}
