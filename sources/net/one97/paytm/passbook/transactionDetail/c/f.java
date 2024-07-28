package net.one97.paytm.passbook.transactionDetail.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;

public final class f extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRTransaction f59134a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f59135b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f59136c = new c(this);

    /* renamed from: d  reason: collision with root package name */
    private HashMap f59137d;

    public final View a(int i2) {
        if (this.f59137d == null) {
            this.f59137d = new HashMap();
        }
        View view = (View) this.f59137d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f59137d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_txn_detail_generic, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0262 A[Catch:{ Exception -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019c A[Catch:{ Exception -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f5 A[Catch:{ Exception -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01fa A[Catch:{ Exception -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0212 A[SYNTHETIC, Splitter:B:81:0x0212] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.String r0 = "mTransactionInstance!!.e…TxnInfo[i].closingBalance"
            java.lang.String r1 = "date_time_tv"
            java.lang.String r2 = "mTransactionInstance!!.extendedTxnInfo[i]"
            java.lang.String r3 = "view"
            kotlin.g.b.k.c(r10, r3)
            super.onViewCreated(r10, r11)
            android.os.Bundle r10 = r9.getArguments()
            r11 = 0
            if (r10 == 0) goto L_0x001c
            java.lang.String r3 = "passbook_detail_data"
            java.io.Serializable r3 = r10.getSerializable(r3)
            goto L_0x001d
        L_0x001c:
            r3 = r11
        L_0x001d:
            boolean r4 = r3 instanceof net.one97.paytm.passbook.beans.CJRTransaction
            if (r4 != 0) goto L_0x0022
            r3 = r11
        L_0x0022:
            net.one97.paytm.passbook.beans.CJRTransaction r3 = (net.one97.paytm.passbook.beans.CJRTransaction) r3
            r9.f59134a = r3
            if (r10 == 0) goto L_0x0034
            r3 = -1
            java.lang.String r4 = "sub_wallet_type"
            int r10 = r10.getInt(r4, r3)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x0035
        L_0x0034:
            r10 = r11
        L_0x0035:
            r9.f59135b = r10
            int r10 = net.one97.paytm.passbook.R.id.share_imv
            android.view.View r10 = r9.a((int) r10)
            androidx.appcompat.widget.AppCompatImageView r10 = (androidx.appcompat.widget.AppCompatImageView) r10
            net.one97.paytm.passbook.transactionDetail.c.f$a r3 = new net.one97.paytm.passbook.transactionDetail.c.f$a
            r3.<init>(r9)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r10.setOnClickListener(r3)
            int r10 = net.one97.paytm.passbook.R.id.status_tv     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            java.lang.String r3 = "status_tv"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r3 == 0) goto L_0x005f
            java.lang.String r3 = r3.getmNarration2()     // Catch:{ Exception -> 0x02db }
            goto L_0x0060
        L_0x005f:
            r3 = r11
        L_0x0060:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02db }
            r10.setText(r3)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r10 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x006e
            java.lang.String r10 = r10.getTxnAmount()     // Catch:{ Exception -> 0x02db }
            goto L_0x006f
        L_0x006e:
            r10 = r11
        L_0x006f:
            java.lang.String r10 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.a((java.lang.String) r10)     // Catch:{ Exception -> 0x02db }
            int r3 = net.one97.paytm.passbook.R.id.amount_tv     // Catch:{ Exception -> 0x02db }
            android.view.View r3 = r9.a((int) r3)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.mapping.a.a((java.lang.String) r10, (android.widget.TextView) r3)     // Catch:{ Exception -> 0x02db }
            int r10 = net.one97.paytm.passbook.R.id.date_time_tv     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ Exception -> 0x02db }
            androidx.fragment.app.FragmentActivity r3 = r9.getActivity()     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity r3 = (net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity) r3     // Catch:{ Exception -> 0x02db }
            if (r3 == 0) goto L_0x0098
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            java.lang.String r3 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.b((net.one97.paytm.passbook.beans.CJRTransaction) r3)     // Catch:{ Exception -> 0x02db }
            goto L_0x0099
        L_0x0098:
            r3 = r11
        L_0x0099:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02db }
            r10.setText(r3)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r10 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x00bb
            java.lang.String r10 = r10.getStatusIcon()     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x00bb
            com.squareup.picasso.w r3 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x02db }
            com.squareup.picasso.aa r10 = r3.a((java.lang.String) r10)     // Catch:{ Exception -> 0x02db }
            int r3 = net.one97.paytm.passbook.R.id.status_icon     // Catch:{ Exception -> 0x02db }
            android.view.View r3 = r9.a((int) r3)     // Catch:{ Exception -> 0x02db }
            androidx.appcompat.widget.AppCompatImageView r3 = (androidx.appcompat.widget.AppCompatImageView) r3     // Catch:{ Exception -> 0x02db }
            r10.a((android.widget.ImageView) r3)     // Catch:{ Exception -> 0x02db }
        L_0x00bb:
            int r10 = net.one97.paytm.passbook.R.string.closing_balance_rs     // Catch:{ Exception -> 0x02db }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x02db }
            java.lang.String r3 = "getString(R.string.closing_balance_rs)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            r4 = 0
            if (r3 == 0) goto L_0x0192
            java.util.ArrayList r3 = r3.getExtendedTxnInfo()     // Catch:{ Exception -> 0x02db }
            if (r3 == 0) goto L_0x0192
            int r3 = r3.size()     // Catch:{ Exception -> 0x02db }
            if (r3 <= 0) goto L_0x0192
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r3 != 0) goto L_0x00de
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02db }
        L_0x00de:
            java.util.ArrayList r3 = r3.getExtendedTxnInfo()     // Catch:{ Exception -> 0x02db }
            java.lang.String r5 = "mTransactionInstance!!.extendedTxnInfo"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x02db }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x02db }
            int r3 = r3.size()     // Catch:{ Exception -> 0x02db }
            r5 = 0
        L_0x00ee:
            if (r5 >= r3) goto L_0x0192
            net.one97.paytm.passbook.beans.CJRTransaction r6 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r6 != 0) goto L_0x00f7
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02db }
        L_0x00f7:
            java.util.ArrayList r6 = r6.getExtendedTxnInfo()     // Catch:{ Exception -> 0x02db }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r6 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r6     // Catch:{ Exception -> 0x02db }
            java.lang.String r6 = r6.getClosingBalance()     // Catch:{ Exception -> 0x02db }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02db }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02db }
            if (r6 != 0) goto L_0x018e
            java.lang.Integer r6 = r9.f59135b     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r7 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r7 != 0) goto L_0x0119
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02db }
        L_0x0119:
            java.util.ArrayList r7 = r7.getExtendedTxnInfo()     // Catch:{ Exception -> 0x02db }
            java.lang.Object r7 = r7.get(r5)     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r7 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r7     // Catch:{ Exception -> 0x02db }
            java.lang.String r7 = r7.getSubWalletType()     // Catch:{ Exception -> 0x02db }
            java.lang.String r8 = "mTransactionInstance!!.e…dTxnInfo[i].subWalletType"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x02db }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x02db }
            if (r6 != 0) goto L_0x0136
            goto L_0x018e
        L_0x0136:
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x02db }
            if (r6 != r7) goto L_0x018e
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r3 != 0) goto L_0x0143
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02db }
        L_0x0143:
            java.util.ArrayList r3 = r3.getExtendedTxnInfo()     // Catch:{ Exception -> 0x02db }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r3 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r3     // Catch:{ Exception -> 0x02db }
            java.lang.String r3 = r3.getClosingBalance()     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x02db }
            double r6 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x02db }
            java.lang.String r3 = net.one97.paytm.passbook.utility.q.a((double) r6)     // Catch:{ Exception -> 0x02db }
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x02db }
            java.text.DecimalFormatSymbols r6 = java.text.DecimalFormatSymbols.getInstance(r6)     // Catch:{ Exception -> 0x02db }
            java.text.DecimalFormat r7 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x02db }
            r7.<init>(r3, r6)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r3 != 0) goto L_0x0171
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02db }
        L_0x0171:
            java.util.ArrayList r3 = r3.getExtendedTxnInfo()     // Catch:{ Exception -> 0x02db }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.ExtendedTxnInfo r3 = (net.one97.paytm.passbook.beans.ExtendedTxnInfo) r3     // Catch:{ Exception -> 0x02db }
            java.lang.String r2 = r3.getClosingBalance()     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x02db }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x02db }
            java.lang.String r0 = r7.format(r2)     // Catch:{ Exception -> 0x02db }
            goto L_0x0193
        L_0x018e:
            int r5 = r5 + 1
            goto L_0x00ee
        L_0x0192:
            r0 = r11
        L_0x0193:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x02db }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x02db }
            if (r2 != 0) goto L_0x01e4
            int r2 = net.one97.paytm.passbook.R.id.date_time_tv     // Catch:{ Exception -> 0x02db }
            android.view.View r2 = r9.a((int) r2)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x02db }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02db }
            r1.<init>()     // Catch:{ Exception -> 0x02db }
            androidx.fragment.app.FragmentActivity r3 = r9.getActivity()     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity r3 = (net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity) r3     // Catch:{ Exception -> 0x02db }
            if (r3 == 0) goto L_0x01bb
            net.one97.paytm.passbook.beans.CJRTransaction r3 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            java.lang.String r3 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.b((net.one97.paytm.passbook.beans.CJRTransaction) r3)     // Catch:{ Exception -> 0x02db }
            goto L_0x01bc
        L_0x01bb:
            r3 = r11
        L_0x01bc:
            r1.append(r3)     // Catch:{ Exception -> 0x02db }
            java.lang.String r3 = " | "
            r1.append(r3)     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.aa r3 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x02db }
            r3 = 1
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02db }
            r5[r4] = r0     // Catch:{ Exception -> 0x02db }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r5, r3)     // Catch:{ Exception -> 0x02db }
            java.lang.String r10 = java.lang.String.format(r10, r0)     // Catch:{ Exception -> 0x02db }
            java.lang.String r0 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x02db }
            r1.append(r10)     // Catch:{ Exception -> 0x02db }
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x02db }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x02db }
            r2.setText(r10)     // Catch:{ Exception -> 0x02db }
        L_0x01e4:
            int r10 = net.one97.paytm.passbook.R.id.title1_tv     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            java.lang.String r0 = "title1_tv"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r0 == 0) goto L_0x01fa
            java.lang.String r0 = r0.getTxnHeading1()     // Catch:{ Exception -> 0x02db }
            goto L_0x01fb
        L_0x01fa:
            r0 = r11
        L_0x01fb:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02db }
            r10.setText(r0)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r10 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x0268
            java.lang.String r10 = r10.getTxnType()     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x0268
            java.lang.String r0 = "CR"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02db }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            if (r10 == 0) goto L_0x0262
            boolean r0 = r10.contentEquals(r0)     // Catch:{ Exception -> 0x02db }
            java.lang.String r2 = "txt1"
            if (r0 == 0) goto L_0x0235
            int r10 = net.one97.paytm.passbook.R.id.txt1     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r0 == 0) goto L_0x022e
            java.lang.String r0 = r0.getTxnFrom()     // Catch:{ Exception -> 0x02db }
            goto L_0x022f
        L_0x022e:
            r0 = r11
        L_0x022f:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02db }
            r10.setText(r0)     // Catch:{ Exception -> 0x02db }
            goto L_0x0268
        L_0x0235:
            java.lang.String r0 = "DR"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x025c
            boolean r10 = r10.contentEquals(r0)     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x0268
            int r10 = net.one97.paytm.passbook.R.id.txt1     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r0 == 0) goto L_0x0255
            java.lang.String r0 = r0.getTxnTo()     // Catch:{ Exception -> 0x02db }
            goto L_0x0256
        L_0x0255:
            r0 = r11
        L_0x0256:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02db }
            r10.setText(r0)     // Catch:{ Exception -> 0x02db }
            goto L_0x0268
        L_0x025c:
            kotlin.u r10 = new kotlin.u     // Catch:{ Exception -> 0x02db }
            r10.<init>(r1)     // Catch:{ Exception -> 0x02db }
            throw r10     // Catch:{ Exception -> 0x02db }
        L_0x0262:
            kotlin.u r10 = new kotlin.u     // Catch:{ Exception -> 0x02db }
            r10.<init>(r1)     // Catch:{ Exception -> 0x02db }
            throw r10     // Catch:{ Exception -> 0x02db }
        L_0x0268:
            int r10 = net.one97.paytm.passbook.R.id.txt3     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            java.lang.String r0 = "txt3"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r0 == 0) goto L_0x027e
            java.lang.String r0 = r0.getTxnDesc1()     // Catch:{ Exception -> 0x02db }
            goto L_0x027f
        L_0x027e:
            r0 = r11
        L_0x027f:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02db }
            r10.setText(r0)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r10 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x02a1
            java.lang.String r10 = r10.getImageUrl()     // Catch:{ Exception -> 0x02db }
            if (r10 == 0) goto L_0x02a1
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x02db }
            com.squareup.picasso.aa r10 = r0.a((java.lang.String) r10)     // Catch:{ Exception -> 0x02db }
            int r0 = net.one97.paytm.passbook.R.id.imv1     // Catch:{ Exception -> 0x02db }
            android.view.View r0 = r9.a((int) r0)     // Catch:{ Exception -> 0x02db }
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0     // Catch:{ Exception -> 0x02db }
            r10.a((android.widget.ImageView) r0)     // Catch:{ Exception -> 0x02db }
        L_0x02a1:
            int r10 = net.one97.paytm.passbook.R.id.title2_tv     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            java.lang.String r0 = "title2_tv"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r0 == 0) goto L_0x02b7
            java.lang.String r0 = r0.getTxnHeading2()     // Catch:{ Exception -> 0x02db }
            goto L_0x02b8
        L_0x02b7:
            r0 = r11
        L_0x02b8:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02db }
            r10.setText(r0)     // Catch:{ Exception -> 0x02db }
            r9.a()     // Catch:{ Exception -> 0x02db }
            int r10 = net.one97.paytm.passbook.R.id.txt7     // Catch:{ Exception -> 0x02db }
            android.view.View r10 = r9.a((int) r10)     // Catch:{ Exception -> 0x02db }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x02db }
            java.lang.String r0 = "txt7"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x02db }
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r9.f59134a     // Catch:{ Exception -> 0x02db }
            if (r0 == 0) goto L_0x02d5
            java.lang.String r11 = r0.getTxnHeading3()     // Catch:{ Exception -> 0x02db }
        L_0x02d5:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x02db }
            r10.setText(r11)     // Catch:{ Exception -> 0x02db }
            goto L_0x02ea
        L_0x02db:
            r10 = move-exception
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            net.one97.paytm.common.utility.l.a((java.lang.Throwable) r10)
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x02ea
            r10.finish()
        L_0x02ea:
            int r10 = net.one97.paytm.passbook.R.id.need_help_rl
            android.view.View r10 = r9.a((int) r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            net.one97.paytm.passbook.transactionDetail.c.f$b r11 = new net.one97.paytm.passbook.transactionDetail.c.f$b
            r11.<init>(r9)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r10.setOnClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.c.f.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f59138a;

        a(f fVar) {
            this.f59138a = fVar;
        }

        public final void onClick(View view) {
            f.a(this.f59138a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f59139a;

        b(f fVar) {
            this.f59139a = fVar;
        }

        public final void onClick(View view) {
            f.b(this.f59139a);
        }
    }

    private final void a() {
        ArrayList<ExtendedTxnInfo> extendedTxnInfo;
        String walletLogo;
        CJRTransaction cJRTransaction = this.f59134a;
        if (cJRTransaction != null && (extendedTxnInfo = cJRTransaction.getExtendedTxnInfo()) != null && (!extendedTxnInfo.isEmpty())) {
            if (extendedTxnInfo.size() == 1) {
                ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.extendedTxnInfoLayout1);
                k.a((Object) constraintLayout, "extendedTxnInfoLayout1");
                constraintLayout.setVisibility(0);
                TextView textView = (TextView) a(R.id.extendedInfoText);
                k.a((Object) textView, "extendedInfoText");
                ExtendedTxnInfo extendedTxnInfo2 = extendedTxnInfo.get(0);
                k.a((Object) extendedTxnInfo2, "it[0]");
                textView.setText(extendedTxnInfo2.getDisplayName());
                ExtendedTxnInfo extendedTxnInfo3 = extendedTxnInfo.get(0);
                if (extendedTxnInfo3 != null && (walletLogo = extendedTxnInfo3.getWalletLogo()) != null) {
                    w.a().a(walletLogo).a((ImageView) (AppCompatImageView) a(R.id.extendedInfoIcon));
                }
            } else if (extendedTxnInfo.size() > 1) {
                LinearLayout linearLayout = (LinearLayout) a(R.id.extendedTxnInfoLayout2);
                k.a((Object) linearLayout, "extendedTxnInfoLayout2");
                linearLayout.setVisibility(0);
                for (ExtendedTxnInfo extendedTxnInfo4 : extendedTxnInfo) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_extended_txn_info_layout, (LinearLayout) a(R.id.extendedTxnInfoLayout2), false);
                    k.a((Object) inflate, "extendedInfoItem");
                    TextView textView2 = (TextView) inflate.findViewById(R.id.extendedInfoText2);
                    k.a((Object) textView2, "extendedInfoItem.extendedInfoText2");
                    k.a((Object) extendedTxnInfo4, "extendedTxnInfo");
                    textView2.setText(extendedTxnInfo4.getDisplayName());
                    TextView textView3 = (TextView) inflate.findViewById(R.id.extendedInfoAmount);
                    k.a((Object) textView3, "extendedInfoItem.extendedInfoAmount");
                    aa aaVar = aa.f47921a;
                    String string = getString(R.string.pass_rupee);
                    k.a((Object) string, "getString(R.string.pass_rupee)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{net.one97.paytm.passbook.utility.f.a(extendedTxnInfo4.getAmount())}, 1));
                    k.a((Object) format, "java.lang.String.format(format, *args)");
                    textView3.setText(format);
                    ((LinearLayout) a(R.id.extendedTxnInfoLayout2)).addView(inflate);
                }
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f59140a;

        c(f fVar) {
            this.f59140a = fVar;
        }

        public final void run() {
            Bitmap bitmap;
            PassbookTransactionDetailsActivity passbookTransactionDetailsActivity;
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", this.f59140a.getString(R.string.post_payment_share_subject));
                String str = "";
                if (this.f59140a.f59134a != null) {
                    CJRTransaction c2 = this.f59140a.f59134a;
                    str = k.a(c2 != null ? c2.getTxnDesc1() : null, (Object) str);
                }
                intent.putExtra("android.intent.extra.TEXT", str);
                View view = this.f59140a.getView();
                if (view != null) {
                    f fVar = this.f59140a;
                    k.a((Object) view, "it");
                    k.c(view, "view");
                    AppCompatImageView appCompatImageView = (AppCompatImageView) fVar.a(R.id.back_arrow_imv);
                    k.a((Object) appCompatImageView, "back_arrow_imv");
                    appCompatImageView.setVisibility(8);
                    TextView textView = (TextView) fVar.a(R.id.deviderClosingBalance);
                    k.a((Object) textView, "deviderClosingBalance");
                    int visibility = textView.getVisibility();
                    TextView textView2 = (TextView) fVar.a(R.id.deviderClosingBalance);
                    k.a((Object) textView2, "deviderClosingBalance");
                    textView2.setVisibility(8);
                    TextView textView3 = (TextView) fVar.a(R.id.tvClosingBalance);
                    k.a((Object) textView3, "tvClosingBalance");
                    int visibility2 = textView3.getVisibility();
                    TextView textView4 = (TextView) fVar.a(R.id.tvClosingBalance);
                    k.a((Object) textView4, "tvClosingBalance");
                    textView4.setVisibility(8);
                    View findViewById = view.findViewById(R.id.share_imv);
                    k.a((Object) findViewById, "view.findViewById<View>(R.id.share_imv)");
                    int visibility3 = findViewById.getVisibility();
                    View findViewById2 = view.findViewById(R.id.share_imv);
                    k.a((Object) findViewById2, "view.findViewById<View>(R.id.share_imv)");
                    findViewById2.setVisibility(8);
                    View findViewById3 = view.findViewById(R.id.bottom_btn_ll);
                    k.a((Object) findViewById3, "view.findViewById<View>(R.id.bottom_btn_ll)");
                    int visibility4 = findViewById3.getVisibility();
                    View findViewById4 = view.findViewById(R.id.bottom_btn_ll);
                    k.a((Object) findViewById4, "view.findViewById<View>(R.id.bottom_btn_ll)");
                    findViewById4.setVisibility(8);
                    bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                    view.draw(new Canvas(bitmap));
                    View findViewById5 = view.findViewById(R.id.share_imv);
                    k.a((Object) findViewById5, "view.findViewById<View>(R.id.share_imv)");
                    findViewById5.setVisibility(visibility3);
                    View findViewById6 = view.findViewById(R.id.bottom_btn_ll);
                    k.a((Object) findViewById6, "view.findViewById<View>(R.id.bottom_btn_ll)");
                    findViewById6.setVisibility(visibility4);
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) fVar.a(R.id.back_arrow_imv);
                    k.a((Object) appCompatImageView2, "back_arrow_imv");
                    appCompatImageView2.setVisibility(0);
                    TextView textView5 = (TextView) fVar.a(R.id.deviderClosingBalance);
                    k.a((Object) textView5, "deviderClosingBalance");
                    textView5.setVisibility(visibility);
                    TextView textView6 = (TextView) fVar.a(R.id.tvClosingBalance);
                    k.a((Object) textView6, "tvClosingBalance");
                    textView6.setVisibility(visibility2);
                    if (!(fVar.getActivity() == null || !(fVar.getActivity() instanceof PassbookTransactionDetailsActivity) || (passbookTransactionDetailsActivity = (PassbookTransactionDetailsActivity) fVar.getActivity()) == null)) {
                        passbookTransactionDetailsActivity.b();
                    }
                    k.a((Object) bitmap, "bitmap");
                } else {
                    bitmap = null;
                }
                FragmentActivity activity = this.f59140a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                ContentResolver contentResolver = activity.getContentResolver();
                String insertImage = MediaStore.Images.Media.insertImage(contentResolver, bitmap, this.f59140a.getString(R.string.title) + '-' + System.currentTimeMillis(), (String) null);
                if (insertImage != null) {
                    Uri parse = Uri.parse(insertImage);
                    k.a((Object) parse, "Uri.parse(pathofBmp)");
                    intent.putExtra("android.intent.extra.STREAM", parse);
                    Intent createChooser = Intent.createChooser(intent, this.f59140a.getString(R.string.post_payment_share_title));
                    Context context = this.f59140a.getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    if (createChooser.resolveActivity(context.getPackageManager()) != null) {
                        this.f59140a.startActivity(createChooser);
                    } else {
                        Toast.makeText(this.f59140a.getActivity(), this.f59140a.getString(R.string.no_app_found), 1).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        if (fVar.isAdded() && fVar.getActivity() != null && (fVar.getActivity() instanceof PassbookTransactionDetailsActivity)) {
            FragmentActivity activity = fVar.getActivity();
            if (!(activity instanceof PassbookTransactionDetailsActivity)) {
                activity = null;
            }
            PassbookTransactionDetailsActivity passbookTransactionDetailsActivity = (PassbookTransactionDetailsActivity) activity;
            if (passbookTransactionDetailsActivity != null) {
                passbookTransactionDetailsActivity.a(fVar.f59136c);
            }
        }
    }

    public static final /* synthetic */ void b(f fVar) {
        if (fVar.getActivity() != null && (fVar.getActivity() instanceof PassbookTransactionDetailsActivity) && fVar.isAdded()) {
            FragmentActivity activity = fVar.getActivity();
            if (!(activity instanceof PassbookTransactionDetailsActivity)) {
                activity = null;
            }
            PassbookTransactionDetailsActivity passbookTransactionDetailsActivity = (PassbookTransactionDetailsActivity) activity;
            if (passbookTransactionDetailsActivity != null) {
                passbookTransactionDetailsActivity.c();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f59137d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
