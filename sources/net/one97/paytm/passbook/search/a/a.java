package net.one97.paytm.passbook.search.a;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import com.paytm.utility.w;
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

public final class a extends RecyclerView.a<C1125a> implements a.C1128a {

    /* renamed from: a  reason: collision with root package name */
    Boolean f58349a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRTransaction> f58350b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.passbook.customview.d f58351c = new net.one97.paytm.passbook.customview.d();

    /* renamed from: d  reason: collision with root package name */
    d f58352d;

    /* renamed from: e  reason: collision with root package name */
    int f58353e;

    /* renamed from: f  reason: collision with root package name */
    private final int f58354f;

    /* renamed from: g  reason: collision with root package name */
    private final int f58355g = 1;

    /* renamed from: h  reason: collision with root package name */
    private final int f58356h = 2;

    /* renamed from: i  reason: collision with root package name */
    private LayoutInflater f58357i;
    private c j;

    public interface c {
        void c();
    }

    public interface d {
        void a(int i2, CJRTransaction cJRTransaction);

        void a(CJRTransaction cJRTransaction);

        void b(int i2, CJRTransaction cJRTransaction);

        void c(int i2, CJRTransaction cJRTransaction);
    }

    public a(c cVar, d dVar, int i2) {
        k.c(cVar, "listener");
        k.c(dVar, "itemOperationsListener");
        this.j = cVar;
        this.f58352d = dVar;
        this.f58353e = i2;
        this.f58351c.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0882, code lost:
        if (kotlin.m.p.a(r3.getTxnStatus(), "REFUNDED_BACK", true) == false) goto L_0x0886;
     */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0a64  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0a82  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0ac8  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0afc  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0b0a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r19
            net.one97.paytm.passbook.search.a.a$a r2 = (net.one97.paytm.passbook.search.a.a.C1125a) r2
            java.lang.String r3 = "baseTransactionsHolder"
            kotlin.g.b.k.c(r2, r3)
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r3 = r0.f58350b
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r4 = "mTransactionList[position]"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.passbook.beans.CJRTransaction r3 = (net.one97.paytm.passbook.beans.CJRTransaction) r3
            boolean r4 = r2 instanceof net.one97.paytm.passbook.search.a.a.b
            if (r4 == 0) goto L_0x0b42
            r4 = r2
            net.one97.paytm.passbook.search.a.a$b r4 = (net.one97.paytm.passbook.search.a.a.b) r4
            java.lang.String r6 = "transaction"
            kotlin.g.b.k.c(r3, r6)
            android.view.View r6 = r4.itemView
            java.lang.String r7 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.content.Context r6 = r6.getContext()
            r4.f58358a = r3
            net.one97.paytm.passbook.search.a.a r8 = r4.f58360c
            java.lang.Boolean r8 = r8.f58349a
            if (r8 != 0) goto L_0x004e
            net.one97.paytm.passbook.search.a.a r8 = r4.f58360c
            net.one97.paytm.passbook.mapping.e r9 = net.one97.paytm.passbook.mapping.e.a()
            java.lang.String r10 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            boolean r9 = net.one97.paytm.passbook.mapping.e.c()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r8.f58349a = r9
        L_0x004e:
            java.lang.String r8 = r3.getPaymentsThemeId()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x008f
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            java.lang.String r9 = r3.getPaymentsThemeId()
            net.one97.paytm.p2p.theme.ThemeData r8 = r8.a((android.content.Context) r6, (java.lang.String) r9)
            if (r8 == 0) goto L_0x008f
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
        L_0x008f:
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r9 = net.one97.paytm.passbook.R.id.passbook_send_receive_type_tv
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "itemView.passbook_send_receive_type_tv"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r9 = "context"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            if (r3 == 0) goto L_0x00ad
            java.lang.String r10 = r3.getmListingNarration()
            goto L_0x00ae
        L_0x00ad:
            r10 = 0
        L_0x00ae:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            java.lang.String r11 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r12 = "DR"
            if (r10 == 0) goto L_0x00f9
            if (r3 == 0) goto L_0x00f9
            java.lang.String r10 = r3.getTxnType()
            if (r10 == 0) goto L_0x00f9
            java.lang.String r13 = "CR"
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r10 == 0) goto L_0x00f3
            boolean r13 = r10.contentEquals(r13)
            if (r13 == 0) goto L_0x00d8
            int r10 = net.one97.paytm.passbook.R.string.money_received
            java.lang.String r10 = r6.getString(r10)
            r3.setmListingNarration(r10)
            goto L_0x00f9
        L_0x00d8:
            r13 = r12
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r10 == 0) goto L_0x00ed
            boolean r10 = r10.contentEquals(r13)
            if (r10 == 0) goto L_0x00f9
            int r10 = net.one97.paytm.passbook.R.string.money_sent
            java.lang.String r10 = r6.getString(r10)
            r3.setmListingNarration(r10)
            goto L_0x00f9
        L_0x00ed:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r11)
            throw r1
        L_0x00f3:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r11)
            throw r1
        L_0x00f9:
            if (r3 == 0) goto L_0x0100
            java.lang.String r10 = r3.getmListingNarration()
            goto L_0x0101
        L_0x0100:
            r10 = 0
        L_0x0101:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r8.setText(r10)
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r10 = net.one97.paytm.passbook.R.id.passbook_send_receive_time
            android.view.View r8 = r8.findViewById(r10)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.String r10 = "itemView.passbook_send_receive_time"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.lang.String r10 = r3.getFormattedTxnTime()
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
            java.util.ArrayList r8 = r3.getExtendedTxnInfo()
            if (r8 == 0) goto L_0x01b3
            java.util.ArrayList r8 = r3.getExtendedTxnInfo()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x01b3
            java.util.ArrayList r8 = r3.getExtendedTxnInfo()
            int r8 = r8.size()
            r5 = 0
            r16 = 0
        L_0x0175:
            if (r5 >= r8) goto L_0x01b5
            net.one97.paytm.passbook.search.a.a r14 = r4.f58360c
            int r14 = r14.f58353e
            java.util.ArrayList r9 = r3.getExtendedTxnInfo()
            java.lang.Object r9 = r9.get(r5)
            java.lang.String r15 = "transaction.extendedTxnInfo[i]"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r15)
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r9 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r9
            java.lang.String r9 = r9.getSubWalletType()
            java.lang.String r15 = "transaction.extendedTxnInfo[i].subWalletType"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r15)
            int r9 = java.lang.Integer.parseInt(r9)
            if (r14 != r9) goto L_0x01ae
            java.util.ArrayList r9 = r3.getExtendedTxnInfo()
            java.lang.Object r9 = r9.get(r5)
            java.lang.String r14 = "transaction.extendedTxnInfo[i]"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r14)
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r9 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r9
            double r14 = r9.getAmount()
            double r16 = r16 + r14
        L_0x01ae:
            int r5 = r5 + 1
            r14 = 8
            goto L_0x0175
        L_0x01b3:
            r16 = 0
        L_0x01b5:
            java.lang.String r5 = java.lang.String.valueOf(r16)
            java.text.DecimalFormat r8 = new java.text.DecimalFormat
            java.lang.String r9 = r4.f58359b
            java.util.Locale r14 = java.util.Locale.ENGLISH
            java.text.DecimalFormatSymbols r14 = java.text.DecimalFormatSymbols.getInstance(r14)
            r8.<init>(r9, r14)
            double r14 = java.lang.Double.parseDouble(r5)
            java.lang.String r5 = r8.format(r14)
            java.lang.String r8 = "strTotalBalance"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            r8 = r5
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r9 = ".00"
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, false)
            if (r9 == 0) goto L_0x01f1
            r9 = 6
            java.lang.String r14 = "."
            r15 = 0
            int r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.String) r14, (int) r15, (boolean) r15, (int) r9)
            java.lang.String r5 = r5.substring(r15, r8)
            java.lang.String r8 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
        L_0x01f1:
            java.lang.String r8 = r3.getTxnType()
            java.lang.String r9 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r9 = r12
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r8 == 0) goto L_0x0b3b
            boolean r8 = r8.contentEquals(r9)
            java.lang.String r9 = "</b>"
            java.lang.String r14 = "itemView.passbook_sender_receiver_amount_tv"
            if (r8 == 0) goto L_0x026c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "<b>-</b>  ₹<b>"
            r8.<init>(r11)
            r8.append(r5)
            r8.append(r9)
            java.lang.String r5 = r8.toString()
            int r8 = android.os.Build.VERSION.SDK_INT
            r11 = 24
            if (r8 < r11) goto L_0x023c
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
            goto L_0x0255
        L_0x023c:
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r8 = r8.findViewById(r11)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r8.setText(r5)
        L_0x0255:
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r5 = r5.findViewById(r8)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r8 = net.one97.paytm.passbook.R.color.color_222222
            int r8 = androidx.core.content.b.c(r6, r8)
            r5.setTextColor(r8)
            goto L_0x02e3
        L_0x026c:
            java.lang.String r8 = r3.getTxnType()
            java.lang.String r15 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r15)
            java.lang.String r15 = "CR"
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            if (r8 == 0) goto L_0x0b34
            boolean r8 = r8.contentEquals(r15)
            if (r8 == 0) goto L_0x02e3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "<b>+</b>  ₹<b>"
            r8.<init>(r11)
            r8.append(r5)
            r8.append(r9)
            java.lang.String r5 = r8.toString()
            int r8 = android.os.Build.VERSION.SDK_INT
            r11 = 24
            if (r8 < r11) goto L_0x02b4
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
            goto L_0x02cd
        L_0x02b4:
            android.view.View r8 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r11 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r8 = r8.findViewById(r11)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r14)
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r8.setText(r5)
        L_0x02cd:
            android.view.View r5 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r8 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r5 = r5.findViewById(r8)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r8 = net.one97.paytm.passbook.R.color.color_21c17a
            int r8 = androidx.core.content.b.c(r6, r8)
            r5.setTextColor(r8)
        L_0x02e3:
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
            r16 = 0
            r5[r16] = r11
            int r11 = net.one97.paytm.passbook.R.color.color_5697ff
            int r11 = androidx.core.content.b.c(r6, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r16 = 1
            r5[r16] = r11
            int r11 = net.one97.paytm.passbook.R.color.color_7ae3b4
            int r11 = androidx.core.content.b.c(r6, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r16 = 2
            r5[r16] = r11
            int r11 = net.one97.paytm.passbook.R.color.color_ffa67a
            int r11 = androidx.core.content.b.c(r6, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r16 = 3
            r5[r16] = r11
            java.lang.String r11 = r3.getType()
            r16 = r2
            java.lang.String r2 = "transaction.narration"
            if (r11 == 0) goto L_0x044e
            java.lang.String r11 = r3.getType()
            java.lang.String r0 = "5"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x037d
            java.lang.String r0 = r3.getType()
            java.lang.String r11 = "69"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r11)
            if (r0 == 0) goto L_0x044e
        L_0x037d:
            java.lang.String r0 = r3.getPayeeInitials()
            if (r0 == 0) goto L_0x03f2
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
            if (r0 == 0) goto L_0x03ea
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            int r11 = r1 % 4
            r5 = r5[r11]
            int r5 = r5.intValue()
            r0.setColor(r5)
            goto L_0x0586
        L_0x03ea:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r0.<init>(r1)
            throw r0
        L_0x03f2:
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
            if (r0 == 0) goto L_0x0586
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
            goto L_0x0586
        L_0x044e:
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
            if (r0 == 0) goto L_0x04aa
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
            goto L_0x0586
        L_0x04aa:
            java.lang.String r0 = r3.getTxnType()
            if (r0 == 0) goto L_0x0519
            java.lang.String r5 = "CR"
            r11 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r11)
            if (r5 == 0) goto L_0x0519
            java.lang.String r0 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r5 = "Added "
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r5, false)
            if (r0 == 0) goto L_0x04f3
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
            goto L_0x0586
        L_0x04f3:
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
            goto L_0x0586
        L_0x0519:
            if (r0 == 0) goto L_0x0586
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r12, (boolean) r5)
            if (r0 == 0) goto L_0x0586
            java.lang.String r0 = r3.getType()
            java.lang.String r11 = "22"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r11, (boolean) r5)
            if (r0 == 0) goto L_0x0561
            java.lang.String r0 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.content.res.Resources r5 = r6.getResources()
            int r11 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r5 = r5.getString(r11)
            java.lang.String r11 = "context.resources.getString(R.string.auth)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r5, false)
            if (r0 == 0) goto L_0x0561
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_payer_or_payee_icons_iv
            android.view.View r0 = r0.findViewById(r5)
            net.one97.paytm.passbook.customview.CircularImageView r0 = (net.one97.paytm.passbook.customview.CircularImageView) r0
            int r5 = net.one97.paytm.passbook.R.drawable.pass_ic_on_hold_txn
            r0.setImageResource(r5)
            goto L_0x0586
        L_0x0561:
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
        L_0x0586:
            net.one97.paytm.passbook.mapping.e r0 = net.one97.paytm.passbook.mapping.e.a()
            java.lang.String r5 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            boolean r0 = net.one97.paytm.passbook.mapping.e.t()
            if (r0 == 0) goto L_0x05fa
            java.lang.String r0 = r3.getPaymentsThemeId()
            if (r0 == 0) goto L_0x05fa
            java.lang.String r0 = r3.getPaymentsThemeId()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x05fa
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r5 = r3.getPaymentsThemeId()
            net.one97.paytm.p2p.theme.ThemeData r0 = r0.a((android.content.Context) r6, (java.lang.String) r5)
            if (r0 == 0) goto L_0x05fa
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
        L_0x05fa:
            net.one97.paytm.passbook.search.a.a r0 = r4.f58360c
            java.lang.Boolean r0 = r0.f58349a
            if (r0 != 0) goto L_0x0603
            kotlin.g.b.k.a()
        L_0x0603:
            boolean r0 = r0.booleanValue()
            r4.a((net.one97.paytm.passbook.beans.CJRTransaction) r3, (android.content.Context) r6, (boolean) r0)
            net.one97.paytm.passbook.search.a.a r0 = r4.f58360c
            java.lang.Boolean r0 = r0.f58349a
            if (r0 != 0) goto L_0x0613
            kotlin.g.b.k.a()
        L_0x0613:
            boolean r0 = r0.booleanValue()
            java.lang.String r5 = r3.getTxnType()
            java.lang.String r8 = r3.getTxnStatus()
            java.lang.String r11 = "itemView.passbook_sender_receiver_txn_status_tv"
            if (r8 == 0) goto L_0x0724
            java.lang.String r8 = r3.getTxnStatus()
            java.lang.String r15 = "SUCCESS"
            r1 = 1
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r15, (boolean) r1)
            if (r8 == 0) goto L_0x0724
            java.lang.String r8 = "all"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r1)
            if (r5 == 0) goto L_0x06e0
            java.lang.String r5 = r3.getTxnType()
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r12, (boolean) r1)
            if (r5 == 0) goto L_0x06e0
            java.lang.String r5 = r3.getType()
            java.lang.String r8 = "22"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r1)
            if (r5 == 0) goto L_0x06e0
            java.lang.String r1 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r5 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r5 = r6.getString(r5)
            java.lang.String r8 = "context.getString(R.string.auth)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r5, false)
            if (r1 == 0) goto L_0x06e0
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            int r1 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r1 = r6.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.passbook.R.color.status_pending
            int r1 = androidx.core.content.b.c(r6, r1)
            r0.setTextColor(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_send_receive_time
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "itemView.passbook_send_receive_time"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r3.getTxnDesc2()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_closing_balance
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            r1 = 8
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r0.setVisibility(r1)
            goto L_0x08aa
        L_0x06e0:
            if (r0 == 0) goto L_0x06f6
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_closing_balance
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            r1 = 0
            r0.setVisibility(r1)
        L_0x06f6:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r1 = 8
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.String r1 = ""
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x07a1
        L_0x0724:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x07a5
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r1 = "PENDING"
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)
            if (r0 == 0) goto L_0x07a5
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_txn_status_rl
            android.view.View r0 = r0.findViewById(r1)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            r1 = 0
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.String r1 = "Pending"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.passbook.R.color.status_pending
            int r1 = androidx.core.content.b.c(r6, r1)
            r0.setTextColor(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_txn_status_icon
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r1 = net.one97.paytm.passbook.R.drawable.pass_txn_status_pending
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r6, (int) r1)
            r0.setImageDrawable(r1)
        L_0x07a1:
            r1 = 8
            goto L_0x08aa
        L_0x07a5:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x0871
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r1 = "FAILURE"
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)
            if (r0 == 0) goto L_0x0871
            int r0 = net.one97.paytm.passbook.R.string.wallet_rs_new
            java.lang.String r0 = r6.getString(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r8 = "₹<b>"
            r1.<init>(r8)
            kotlin.g.b.aa r8 = kotlin.g.b.aa.f47921a
            java.lang.String r8 = "rsformat"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r10 = r3.getTxnAmount()
            r15 = 0
            r8[r15] = r10
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r5)
            java.lang.String r0 = java.lang.String.format(r0, r8)
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1.append(r0)
            r1.append(r9)
            java.lang.String r0 = r1.toString()
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r1 = r1.findViewById(r5)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_txn_status_rl
            android.view.View r0 = r0.findViewById(r1)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            r1 = 0
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            java.lang.String r1 = "Failure"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_txn_status_tv
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.passbook.R.color.status_failure
            int r1 = androidx.core.content.b.c(r6, r1)
            r0.setTextColor(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_txn_status_icon
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r1 = net.one97.paytm.passbook.R.drawable.pass_txn_status_failure
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r6, (int) r1)
            r0.setImageDrawable(r1)
            goto L_0x07a1
        L_0x0871:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x0885
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r1 = "REFUNDED_BACK"
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)
            if (r0 != 0) goto L_0x0895
            goto L_0x0886
        L_0x0885:
            r5 = 1
        L_0x0886:
            java.lang.String r0 = r3.getTxnStatus()
            if (r0 == 0) goto L_0x0895
            java.lang.String r0 = r3.getTxnStatus()
            java.lang.String r1 = "REFUND_SUCCESS"
            kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)
        L_0x0895:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_txn_status_rl
            android.view.View r0 = r0.findViewById(r1)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            r1 = 8
            r0.setVisibility(r1)
        L_0x08aa:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.on_hold_pause_iv
            android.view.View r0 = r0.findViewById(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r5 = "itemView.on_hold_pause_iv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_entry_row_detail_rl
            android.view.View r0 = r0.findViewById(r1)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            int r1 = net.one97.paytm.passbook.R.color.white
            int r1 = androidx.core.content.b.c(r6, r1)
            r0.setBackgroundColor(r1)
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_extrainfo_btn_need_help_tv
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            net.one97.paytm.passbook.search.a.a$b$g r1 = new net.one97.paytm.passbook.search.a.a$b$g
            r1.<init>(r3, r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            java.lang.String r0 = r3.getTxnType()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r12)
            if (r0 == 0) goto L_0x09ec
            java.lang.String r0 = r3.getType()
            java.lang.String r1 = "22"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x09ec
            java.lang.String r0 = r3.getNarration()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r1 = r6.getString(r1)
            java.lang.String r2 = "context.getString(R.string.auth)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r1, false)
            if (r0 == 0) goto L_0x09ec
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
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "₹<b>"
            r0.<init>(r1)
            java.lang.String r1 = r3.getTxnAmount()
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L_0x09ce
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
            goto L_0x09e7
        L_0x09ce:
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_sender_receiver_amount_tv
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r14)
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x09e7:
            r0 = r20
            r1 = 8
            goto L_0x0a05
        L_0x09ec:
            android.view.View r0 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            int r1 = net.one97.paytm.passbook.R.id.passbook_extrainfo_btn_need_help_tv
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "itemView.passbook_extrainfo_btn_need_help_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 8
            r0.setVisibility(r1)
            r0 = r20
        L_0x0a05:
            r4.a((int) r0, (net.one97.paytm.passbook.beans.CJRTransaction) r3, (android.content.Context) r6)
            android.view.View r2 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            int r5 = net.one97.paytm.passbook.R.id.passbook_bus_view_receipt_ll
            android.view.View r2 = r2.findViewById(r5)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            java.lang.String r5 = "itemView.passbook_bus_view_receipt_ll"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r2.setVisibility(r1)
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_send_receive_lyt_buttons_ll
            android.view.View r1 = r1.findViewById(r2)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            java.lang.String r2 = "itemView.passbook_send_receive_lyt_buttons_ll"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = 0
            r1.setVisibility(r2)
            android.view.View r1 = r4.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r2 = net.one97.paytm.passbook.R.id.passbook_entry_row_detail_rl
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            net.one97.paytm.passbook.search.a.a$b$k r2 = new net.one97.paytm.passbook.search.a.a$b$k
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
            boolean r1 = net.one97.paytm.passbook.search.a.a.b.a((net.one97.paytm.passbook.beans.CJRTransaction) r3)
            if (r1 == 0) goto L_0x0a82
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
            goto L_0x0a9f
        L_0x0a82:
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
        L_0x0a9f:
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
            if (r1 == 0) goto L_0x0aee
            java.lang.String r1 = r1.tag
            if (r1 == 0) goto L_0x0aee
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0aee
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
        L_0x0aee:
            int r1 = r0 + 1
            r2 = r18
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r3 = r2.f58350b
            int r3 = r3.size()
            r5 = 1
            int r3 = r3 - r5
            if (r1 >= r3) goto L_0x0b0a
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r3 = r2.f58350b
            java.lang.Object r1 = r3.get(r1)
            boolean r1 = r1 instanceof net.one97.paytm.passbook.subWallet.model.TransactionHeader
            if (r1 == 0) goto L_0x0b15
            r4.b()
            goto L_0x0b15
        L_0x0b0a:
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r3 = r2.f58350b
            int r3 = r3.size()
            if (r1 != r3) goto L_0x0b15
            r4.b()
        L_0x0b15:
            net.one97.paytm.passbook.customview.d r1 = r2.f58351c
            r5 = r16
            android.view.View r3 = r5.itemView
            java.lang.String r5 = "baseTransactionsHolder.itemView"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.swipeBgLayout
            android.view.View r3 = r3.findViewById(r5)
            net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook r3 = (net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook) r3
            int r4 = r4.getAdapterPosition()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.a((net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook) r3, (java.lang.String) r4)
            goto L_0x0b60
        L_0x0b34:
            r2 = r0
            kotlin.u r0 = new kotlin.u
            r0.<init>(r11)
            throw r0
        L_0x0b3b:
            r2 = r0
            kotlin.u r0 = new kotlin.u
            r0.<init>(r11)
            throw r0
        L_0x0b42:
            r5 = r2
            r2 = r0
            r0 = r1
            boolean r1 = r5 instanceof net.one97.paytm.passbook.search.a.a.e
            if (r1 == 0) goto L_0x0b60
            r1 = r5
            net.one97.paytm.passbook.search.a.a$e r1 = (net.one97.paytm.passbook.search.a.a.e) r1
            java.lang.String r4 = "transaction"
            kotlin.g.b.k.c(r3, r4)
            boolean r4 = r3 instanceof net.one97.paytm.passbook.subWallet.model.TransactionHeader
            if (r4 == 0) goto L_0x0b60
            android.widget.TextView r1 = r1.f58387a
            net.one97.paytm.passbook.subWallet.model.TransactionHeader r3 = (net.one97.paytm.passbook.subWallet.model.TransactionHeader) r3
            java.lang.String r3 = r3.txnDate
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x0b60:
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r1 = r2.f58350b
            int r1 = r1.size()
            r3 = 1
            int r1 = r1 - r3
            int r3 = r2.f58356h
            int r1 = r1 - r3
            if (r0 != r1) goto L_0x0b72
            net.one97.paytm.passbook.search.a.a$c r0 = r2.j
            r0.c()
        L_0x0b72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.search.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        C1125a aVar;
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.f58357i = from;
        if (i2 == this.f58354f) {
            LayoutInflater layoutInflater = this.f58357i;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            View inflate = layoutInflater.inflate(R.layout.pass_new_search_header_item, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…ader_item, parent, false)");
            aVar = new e(inflate);
        } else {
            LayoutInflater layoutInflater2 = this.f58357i;
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
        ArrayList<CJRTransaction> arrayList = this.f58350b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f58350b.get(i2) instanceof TransactionHeader) {
            return this.f58354f;
        }
        return this.f58355g;
    }

    public final class b extends C1125a implements a.C1069a {

        /* renamed from: a  reason: collision with root package name */
        public CJRTransaction f58358a;

        /* renamed from: b  reason: collision with root package name */
        final String f58359b = "##,##,##,##,##,##,##0.00";

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f58360c;

        /* renamed from: d  reason: collision with root package name */
        private final int f58361d;

        static final class i implements net.one97.paytm.passbook.mapping.a.g {

            /* renamed from: a  reason: collision with root package name */
            public static final i f58380a = new i();

            i() {
            }

            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            }
        }

        static final class d<T> implements i.a<IJRDataModel> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f58370a;

            d(Context context) {
                this.f58370a = context;
            }

            public final /* synthetic */ void onResponse(Object obj) {
                IJRDataModel iJRDataModel = (IJRDataModel) obj;
                if (iJRDataModel instanceof CJRBusInvoiceModel) {
                    CJRBusInvoiceModel cJRBusInvoiceModel = (CJRBusInvoiceModel) iJRDataModel;
                    if (p.a(cJRBusInvoiceModel.getStatusCode(), "SUCCESS", true)) {
                        net.one97.paytm.passbook.d.b();
                        if (this.f58370a == null) {
                            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        }
                        return;
                    }
                    Context context = this.f58370a;
                    com.paytm.utility.g.c(context, context.getString(R.string.error), cJRBusInvoiceModel.getmStatusMessage(), AnonymousClass1.f58371a);
                }
            }
        }

        static final class h<T> implements i.a<IJRDataModel> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58379a;

            h(b bVar) {
                this.f58379a = bVar;
            }

            public final /* synthetic */ void onResponse(Object obj) {
                IJRDataModel iJRDataModel = (IJRDataModel) obj;
                if (iJRDataModel != null) {
                    CJRLedgerResponse cJRLedgerResponse = (CJRLedgerResponse) iJRDataModel;
                    if (cJRLedgerResponse != null) {
                        View view = this.f58379a.itemView;
                        kotlin.g.b.k.a((Object) view, "itemView");
                        net.one97.paytm.passbook.mapping.c.a(view.getContext(), (String) null, cJRLedgerResponse.getDisplayMessage());
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
            this.f58360c = aVar;
            this.f58361d = net.one97.paytm.passbook.utility.c.a(15.0f, view.getContext());
            ((TextView) view.findViewById(R.id.tagTv)).setOnTouchListener(new View.OnTouchListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f58362a;

                {
                    this.f58362a = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    kotlin.g.b.k.c(view, "v");
                    kotlin.g.b.k.c(motionEvent, "m");
                    if (motionEvent.getAction() == 0) {
                        if (b.a(this.f58362a.a())) {
                            this.f58362a.f58360c.f58352d.b(this.f58362a.getPosition(), this.f58362a.a());
                        } else {
                            this.f58362a.f58360c.f58352d.a(this.f58362a.getPosition(), this.f58362a.a());
                        }
                        this.f58362a.f58360c.f58351c.b(String.valueOf(this.f58362a.getPosition()));
                    }
                    return true;
                }
            });
            ((TextView) view.findViewById(R.id.historyTv)).setOnTouchListener(new View.OnTouchListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f58363a;

                {
                    this.f58363a = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    kotlin.g.b.k.c(view, "v");
                    kotlin.g.b.k.c(motionEvent, "m");
                    if (motionEvent.getAction() != 0) {
                        return true;
                    }
                    this.f58363a.f58360c.f58352d.c(this.f58363a.getPosition(), this.f58363a.a());
                    this.f58363a.f58360c.f58351c.b(String.valueOf(this.f58363a.getPosition()));
                    return true;
                }
            });
        }

        public final CJRTransaction a() {
            CJRTransaction cJRTransaction = this.f58358a;
            if (cJRTransaction == null) {
                kotlin.g.b.k.a("transaction");
            }
            return cJRTransaction;
        }

        static final class k implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58384a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f58385b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CJRTransaction f58386c;

            k(b bVar, int i2, CJRTransaction cJRTransaction) {
                this.f58384a = bVar;
                this.f58385b = i2;
                this.f58386c = cJRTransaction;
            }

            public final void onClick(View view) {
                this.f58384a.f58360c.f58352d.a(this.f58386c);
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
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.search.a.a.b.a(net.one97.paytm.passbook.beans.CJRTransaction):boolean");
        }

        public final void b() {
            View view = this.itemView;
            kotlin.g.b.k.a((Object) view, "itemView");
            View findViewById = view.findViewById(R.id.bottom_separator);
            kotlin.g.b.k.a((Object) findViewById, "itemView.bottom_separator");
            findViewById.setVisibility(8);
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
                net.one97.paytm.passbook.search.a.a r3 = r7.f58360c
                int r3 = r3.f58353e
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
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.search.a.a.b.a(net.one97.paytm.passbook.beans.CJRTransaction, android.content.Context, boolean):void");
        }

        static final class g implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRTransaction f58377a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f58378b;

            g(CJRTransaction cJRTransaction, Context context) {
                this.f58377a = cJRTransaction;
                this.f58378b = context;
            }

            public final void onClick(View view) {
                if (kotlin.g.b.k.a((Object) this.f58377a.getTxnType(), (Object) "DR") && kotlin.g.b.k.a((Object) this.f58377a.getType(), (Object) "22")) {
                    String narration = this.f58377a.getNarration();
                    kotlin.g.b.k.a((Object) narration, "transaction.narration");
                    String string = this.f58378b.getString(R.string.auth);
                    kotlin.g.b.k.a((Object) string, "context.getString(R.string.auth)");
                    if (p.a((CharSequence) narration, (CharSequence) string, false)) {
                        Context context = this.f58378b;
                        context.startActivity(new Intent(context, WalletLandingPageActivity.class));
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, CJRTransaction cJRTransaction, Context context) {
            Context context2 = context;
            int f2 = com.paytm.utility.b.f(context);
            int i3 = f2 / 2;
            int i4 = (int) (((double) f2) * 3.5d);
            if (context2 != null) {
                int a2 = com.paytm.utility.b.a((Activity) context2) - (((i3 * 2) + i4) + i3);
                ArrayList<CJRButton> buttonList = cJRTransaction.getButtonList();
                View view = this.itemView;
                kotlin.g.b.k.a((Object) view, "itemView");
                ((LinearLayout) view.findViewById(R.id.passbook_send_receive_lyt_buttons_ll)).removeAllViews();
                View view2 = this.itemView;
                kotlin.g.b.k.a((Object) view2, "itemView");
                ((LinearLayout) view2.findViewById(R.id.passbook_bus_view_receipt_ll)).removeAllViews();
                if (buttonList == null || buttonList.size() <= 0) {
                    View view3 = this.itemView;
                    kotlin.g.b.k.a((Object) view3, "itemView");
                    LinearLayout linearLayout = (LinearLayout) view3.findViewById(R.id.passbook_send_receive_lyt_buttons_ll);
                    kotlin.g.b.k.a((Object) linearLayout, "itemView.passbook_send_receive_lyt_buttons_ll");
                    linearLayout.setVisibility(8);
                    return;
                }
                View view4 = this.itemView;
                kotlin.g.b.k.a((Object) view4, "itemView");
                LinearLayout linearLayout2 = (LinearLayout) view4.findViewById(R.id.passbook_send_receive_lyt_buttons_ll);
                kotlin.g.b.k.a((Object) linearLayout2, "itemView.passbook_send_receive_lyt_buttons_ll");
                linearLayout2.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                int size = buttonList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    CJRButton cJRButton = buttonList.get(i5);
                    if (cJRTransaction.isBtnEnabled()) {
                        kotlin.g.b.k.a((Object) cJRButton, "button");
                        if (cJRButton.getActionUrl() != null) {
                            String actionUrl = cJRButton.getActionUrl();
                            kotlin.g.b.k.a((Object) actionUrl, "button.actionUrl");
                            if (actionUrl != null) {
                                String lowerCase = actionUrl.toLowerCase();
                                kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                                if (p.c(lowerCase, "refundtopg", false) && !net.one97.paytm.passbook.mapping.c.ao(context)) {
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        if (cJRButton.getActionUrl() == null && p.a(cJRTransaction.getType(), "1", true) && p.a(cJRTransaction.getLabel(), "UTS", true)) {
                            View view5 = this.itemView;
                            kotlin.g.b.k.a((Object) view5, "itemView");
                            LinearLayout linearLayout3 = (LinearLayout) view5.findViewById(R.id.passbook_bus_view_receipt_ll);
                            kotlin.g.b.k.a((Object) linearLayout3, "itemView.passbook_bus_view_receipt_ll");
                            linearLayout3.setVisibility(0);
                            View view6 = this.itemView;
                            kotlin.g.b.k.a((Object) view6, "itemView");
                            String buttonName = cJRButton.getButtonName();
                            kotlin.g.b.k.a((Object) buttonName, "button.buttonName");
                            String walletOrderId = cJRTransaction.getWalletOrderId();
                            kotlin.g.b.k.a((Object) walletOrderId, "transaction.walletOrderId");
                            Button button = new Button(context2);
                            button.setText(buttonName);
                            button.setTag(buttonName);
                            button.setTextColor(context.getResources().getColor(R.color.paytm_blue));
                            button.setTextSize(2, 13.0f);
                            button.setPadding(8, 0, 8, 0);
                            button.setBackgroundColor(0);
                            button.setTextColor(androidx.core.content.b.c(context2, R.color.color_blue_passbook_action));
                            button.setTypeface(w.a(context2, "Roboto-Medium.ttf"));
                            button.setOnClickListener(new C1126a(this, context2, walletOrderId));
                            ((LinearLayout) view6.findViewById(R.id.passbook_bus_view_receipt_ll)).addView(button);
                        } else if (cJRTransaction.isInvoiceProcessed() && !v.a(cJRButton.getActionUrl())) {
                        }
                    }
                    int size2 = arrayList.size();
                    kotlin.g.b.k.a((Object) cJRButton, "button");
                    arrayList.add(cJRButton.getButtonName());
                    cJRButton.setButtonTag(size2);
                }
                if (arrayList.size() > 0) {
                    View view7 = this.itemView;
                    kotlin.g.b.k.a((Object) view7, "itemView");
                    new net.one97.paytm.passbook.customview.a(context, this, arrayList, (LinearLayout) view7.findViewById(R.id.passbook_send_receive_lyt_buttons_ll), a2, i2, cJRTransaction, "");
                    return;
                }
                View view8 = this.itemView;
                kotlin.g.b.k.a((Object) view8, "itemView");
                LinearLayout linearLayout4 = (LinearLayout) view8.findViewById(R.id.passbook_send_receive_lyt_buttons_ll);
                kotlin.g.b.k.a((Object) linearLayout4, "itemView.passbook_send_receive_lyt_buttons_ll");
                linearLayout4.setVisibility(8);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }

        /* renamed from: net.one97.paytm.passbook.search.a.a$b$a  reason: collision with other inner class name */
        static final class C1126a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58364a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f58365b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f58366c;

            C1126a(b bVar, Context context, String str) {
                this.f58364a = bVar;
                this.f58365b = context;
                this.f58366c = str;
            }

            public final void onClick(View view) {
                com.paytm.utility.b.k(this.f58365b, "Please wait");
                String str = this.f58366c;
                Context context = this.f58365b;
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
                    net.one97.paytm.passbook.mapping.a.a(new net.one97.paytm.passbook.mapping.a.b(e2, b.a(context), b.b(context), new CJRBusInvoiceModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, net.one97.paytm.passbook.search.e.class.getName()), context, c.f58369a);
                }
            }
        }

        static final class c implements DialogInterface.OnCancelListener {

            /* renamed from: a  reason: collision with root package name */
            public static final c f58369a = new c();

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

        /* renamed from: net.one97.paytm.passbook.search.a.a$b$b  reason: collision with other inner class name */
        static final class C1127b implements net.one97.paytm.passbook.mapping.a.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f58367a;

            C1127b(Context context) {
                this.f58367a = context;
            }

            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                Context context = this.f58367a;
                com.paytm.utility.g.c(context, context.getString(R.string.error), this.f58367a.getString(R.string.some_went_wrong), AnonymousClass1.f58368a);
            }
        }

        static net.one97.paytm.passbook.mapping.a.g b(Context context) {
            return new C1127b(context);
        }

        public final void a(int i2, int i3) {
            CJRButton buttonWithTag = this.f58360c.f58350b.get(i3).getButtonWithTag(i2);
            CJRTransaction cJRTransaction = this.f58360c.f58350b.get(i3);
            kotlin.g.b.k.a((Object) cJRTransaction, "mTransactionList[listItemIndex]");
            String txnAmount = cJRTransaction.getTxnAmount();
            if (buttonWithTag != null) {
                try {
                    CJRTransaction cJRTransaction2 = this.f58360c.f58350b.get(i3);
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
            final /* synthetic */ b f58372a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRButton f58373b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f58374c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Dialog f58375d;

            e(b bVar, CJRButton cJRButton, int i2, Dialog dialog) {
                this.f58372a = bVar;
                this.f58373b = cJRButton;
                this.f58374c = i2;
                this.f58375d = dialog;
            }

            public final void onClick(View view) {
                JSONObject a2 = b.a(this.f58373b.getActionUrlRequest());
                b bVar = this.f58372a;
                String actionUrl = this.f58373b.getActionUrl();
                kotlin.g.b.k.a((Object) actionUrl, "buttonObj.actionUrl");
                kotlin.g.b.k.a((Object) this.f58372a.f58360c.f58350b.get(this.f58374c), "mTransactionList[listItemIndex]");
                m.a aVar = m.f59265a;
                net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                kotlin.g.b.k.a((Object) b2, "PassbookHelper.getImplListener()");
                Context b3 = b2.b();
                kotlin.g.b.k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
                if (!TextUtils.isEmpty(m.a.a(b3).b("sso_token=", "", true))) {
                    net.one97.paytm.passbook.mapping.f b4 = net.one97.paytm.passbook.d.b();
                    View view2 = bVar.itemView;
                    kotlin.g.b.k.a((Object) view2, "itemView");
                    Context context = view2.getContext();
                    if (context != null) {
                        b4.a((Activity) context, (com.paytm.network.listener.b) new j(bVar, actionUrl, a2), a.c.PASSBOOK);
                    } else {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                this.f58375d.dismiss();
            }
        }

        static final class f implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Dialog f58376a;

            f(Dialog dialog) {
                this.f58376a = dialog;
            }

            public final void onClick(View view) {
                this.f58376a.dismiss();
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
            final /* synthetic */ b f58381a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f58382b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ JSONObject f58383c;

            j(b bVar, String str, JSONObject jSONObject) {
                this.f58381a = bVar;
                this.f58382b = str;
                this.f58383c = jSONObject;
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                View view = this.f58381a.itemView;
                kotlin.g.b.k.a((Object) view, "itemView");
                Toast.makeText(view.getContext(), "Errror", 0).show();
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel != null) {
                    b bVar = this.f58381a;
                    String str = this.f58382b;
                    JSONObject jSONObject = this.f58383c;
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
                                net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(b2, new h(bVar), i.f58380a, new CJRLedgerResponse(), hashMap, str3, a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, net.one97.paytm.passbook.subWallet.c.c.class.getName()));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRPGTokenList");
            }
        }
    }

    public static final class e extends C1125a {

        /* renamed from: a  reason: collision with root package name */
        final TextView f58387a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.date);
            k.a((Object) findViewById, "itemView.findViewById(R.id.date)");
            this.f58387a = (TextView) findViewById;
        }
    }

    /* renamed from: net.one97.paytm.passbook.search.a.a$a  reason: collision with other inner class name */
    public static class C1125a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1125a(View view) {
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

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58388a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58389b;

        public f(a aVar, x.e eVar) {
            this.f58388a = aVar;
            this.f58389b = eVar;
        }

        public final void run() {
            this.f58388a.f58351c.a((String) this.f58389b.element);
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58390a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58391b;

        public g(a aVar, x.e eVar) {
            this.f58390a = aVar;
            this.f58391b = eVar;
        }

        public final void run() {
            this.f58390a.f58351c.b((String) this.f58391b.element);
        }
    }

    public final int b(int i2) {
        if (this.f58350b.get(i2) instanceof TransactionHeader) {
            return R.layout.pass_new_search_header_item;
        }
        return R.layout.pass_subwallet_txn_item_layout;
    }

    public final void a(View view, int i2) {
        k.c(view, H5Logger.HEADER);
        TextView textView = (TextView) view.findViewById(R.id.date);
        CJRTransaction cJRTransaction = this.f58350b.get(i2);
        if (cJRTransaction != null) {
            k.a((Object) textView, "tvHeader");
            textView.setText(((TransactionHeader) cJRTransaction).txnDate);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.subWallet.model.TransactionHeader");
    }

    public final boolean c(int i2) {
        try {
            return this.f58350b.get(i2) instanceof TransactionHeader;
        } catch (Exception unused) {
            return false;
        }
    }
}
