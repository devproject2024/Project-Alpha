package net.one97.paytm.passbook.transactionHistory.fragments;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse;
import net.one97.paytm.passbook.mapping.a.f;

public final class TransactionHistoryFragment extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.passbook.transactionHistory.a.b f59180a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.passbook.transactionHistory.b f59181b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f59182c = new b(this);

    /* renamed from: d  reason: collision with root package name */
    private HashMap f59183d;

    public final View a(int i2) {
        if (this.f59183d == null) {
            this.f59183d = new HashMap();
        }
        View view = (View) this.f59183d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f59183d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<f<? extends PassbookTransactionHistoryResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TransactionHistoryFragment f59184a;

        a(TransactionHistoryFragment transactionHistoryFragment) {
            this.f59184a = transactionHistoryFragment;
        }

        /* JADX WARNING: type inference failed for: r0v18, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r14) {
            /*
                r13 = this;
                net.one97.paytm.passbook.mapping.a.f r14 = (net.one97.paytm.passbook.mapping.a.f) r14
                net.one97.paytm.passbook.mapping.a.j r0 = r14.f57886a
                net.one97.paytm.passbook.mapping.a.j r1 = net.one97.paytm.passbook.mapping.a.j.SUCCESS
                java.lang.String r2 = "transactionHistoryFragment.tvErrorMsg"
                r3 = 401(0x191, float:5.62E-43)
                java.lang.String r4 = "transactionHistoryFragment.rvHeader"
                java.lang.String r5 = "transactionHistoryFragment.share_imv"
                r6 = 8
                java.lang.String r7 = "transactionHistoryFragment.ilError"
                r8 = 1
                r9 = 0
                r10 = 0
                if (r0 != r1) goto L_0x03dc
                T r0 = r14.f57887b
                net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse r0 = (net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse) r0
                if (r0 == 0) goto L_0x0022
                java.lang.String r1 = r0.getStatus()
                goto L_0x0023
            L_0x0022:
                r1 = r9
            L_0x0023:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0148
                if (r0 == 0) goto L_0x0032
                java.lang.String r1 = r0.getStatus()
                goto L_0x0033
            L_0x0032:
                r1 = r9
            L_0x0033:
                java.lang.String r11 = "failure"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r11, (boolean) r8)
                if (r1 == 0) goto L_0x0148
                if (r0 == 0) goto L_0x0042
                java.lang.String r1 = r0.getResponseCode()
                goto L_0x0043
            L_0x0042:
                r1 = r9
            L_0x0043:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0148
                T r14 = r14.f57887b
                net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse r14 = (net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse) r14
                if (r14 == 0) goto L_0x0056
                java.lang.String r14 = r14.getMessage()
                goto L_0x0057
            L_0x0056:
                r14 = r9
            L_0x0057:
                r1 = r14
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0068
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r14 = r13.f59184a
                int r1 = net.one97.paytm.passbook.R.string.pass_payment_history_list_default_failure_msg
                java.lang.String r14 = r14.getString(r1)
            L_0x0068:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r13.f59184a
                net.one97.paytm.passbook.transactionHistory.b r1 = net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment.a((net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment) r1)
                if (r0 == 0) goto L_0x0075
                java.lang.String r11 = r0.getResponseCode()
                goto L_0x0076
            L_0x0075:
                r11 = r9
            L_0x0076:
                if (r0 == 0) goto L_0x007c
                java.lang.Integer r9 = r0.getHttpCode()
            L_0x007c:
                if (r11 == 0) goto L_0x00b1
                if (r9 == 0) goto L_0x00b1
                int r0 = r9.intValue()
                r12 = 200(0xc8, float:2.8E-43)
                if (r0 != r12) goto L_0x00a2
                java.lang.String r0 = "4013"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
                if (r0 != 0) goto L_0x00b1
                java.lang.String r0 = "4014"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x0099
                goto L_0x00b1
            L_0x0099:
                java.lang.String r0 = "4015"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x00b1
                goto L_0x00b0
            L_0x00a2:
                int r0 = r9.intValue()
                if (r0 != r3) goto L_0x00b1
                java.lang.String r0 = "4012"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x00b1
            L_0x00b0:
                r8 = 0
            L_0x00b1:
                java.lang.String r0 = "transactionHistoryFragment.ilError.btnRetry"
                if (r8 == 0) goto L_0x00d3
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r3 = r1.f59178b
                int r8 = net.one97.paytm.passbook.R.id.ilError
                android.view.View r3 = r3.a((int) r8)
                android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
                android.view.View r3 = (android.view.View) r3
                int r8 = net.one97.paytm.passbook.R.id.btnRetry
                android.view.View r3 = r3.findViewById(r8)
                android.widget.TextView r3 = (android.widget.TextView) r3
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                r3.setVisibility(r10)
                goto L_0x00f0
            L_0x00d3:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r3 = r1.f59178b
                int r8 = net.one97.paytm.passbook.R.id.ilError
                android.view.View r3 = r3.a((int) r8)
                android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
                android.view.View r3 = (android.view.View) r3
                int r8 = net.one97.paytm.passbook.R.id.btnRetry
                android.view.View r3 = r3.findViewById(r8)
                android.widget.TextView r3 = (android.widget.TextView) r3
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                r3.setVisibility(r6)
            L_0x00f0:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r1.f59178b
                int r3 = net.one97.paytm.passbook.R.id.ilError
                android.view.View r0 = r0.a((int) r3)
                android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
                r0.setVisibility(r10)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r1.f59178b
                int r3 = net.one97.paytm.passbook.R.id.share_imv
                android.view.View r0 = r0.a((int) r3)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
                r0.setVisibility(r6)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r1.f59178b
                int r3 = net.one97.paytm.passbook.R.id.toolbar
                android.view.View r0 = r0.a((int) r3)
                android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r3 = r1.f59178b
                int r5 = net.one97.paytm.passbook.R.id.rvHeader
                android.view.View r3 = r3.a((int) r5)
                android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                android.content.Context r3 = r3.getContext()
                int r4 = net.one97.paytm.passbook.R.color.white
                int r3 = androidx.core.content.b.c(r3, r4)
                r0.setBackgroundColor(r3)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r1.f59178b
                int r1 = net.one97.paytm.passbook.R.id.tvErrorMsg
                android.view.View r0 = r0.a((int) r1)
                android.widget.TextView r0 = (android.widget.TextView) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                r0.setText(r14)
                goto L_0x04a0
            L_0x0148:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r13.f59184a
                net.one97.paytm.passbook.transactionHistory.b r0 = net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment.a((net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment) r0)
                T r14 = r14.f57887b
                if (r14 == 0) goto L_0x03d4
                net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse r14 = (net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse) r14
                java.lang.String r1 = "response"
                kotlin.g.b.k.c(r14, r1)
                net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
                java.lang.String r2 = "passOnusTxnEnabled"
                boolean r1 = r1.a((java.lang.String) r2, (boolean) r8)
                java.lang.String r2 = r14.getMerchantType()
                if (r1 == 0) goto L_0x0196
                r1 = r2
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0196
                java.lang.String r1 = "ONUS"
                boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r8)
                if (r1 == 0) goto L_0x0196
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.tvNeedHelp
                android.view.View r1 = r1.a((int) r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r2 = "transactionHistoryFragment.tvNeedHelp"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r2 = r0.f59178b
                int r3 = net.one97.paytm.passbook.R.string.pass_view_order_details
                java.lang.String r2 = r2.getString(r3)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
            L_0x0196:
                r0.f59177a = r14
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.ilError
                android.view.View r1 = r1.a((int) r2)
                android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
                r1.setVisibility(r6)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.tvStatus
                android.view.View r1 = r1.a((int) r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r2 = "transactionHistoryFragment.tvStatus"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                java.lang.String r2 = r14.getDetailNarration()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.share_imv
                android.view.View r1 = r1.a((int) r2)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r10)
                java.lang.String r1 = r14.getAmount()
                if (r1 == 0) goto L_0x01f4
                double r1 = java.lang.Double.parseDouble(r1)
                java.lang.String r1 = net.one97.paytm.passbook.utility.f.c((double) r1)
                if (r1 == 0) goto L_0x01f4
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r2 = r0.f59178b
                int r3 = net.one97.paytm.passbook.R.id.tvAmount
                android.view.View r2 = r2.a((int) r3)
                androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
                java.lang.String r3 = "transactionHistoryFragment.tvAmount"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                android.widget.TextView r2 = (android.widget.TextView) r2
                net.one97.paytm.passbook.utility.f.a(r2, r1)
            L_0x01f4:
                java.lang.String r1 = r14.getDateTime()
                if (r1 == 0) goto L_0x022f
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.tvDateTime
                android.view.View r1 = r1.a((int) r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r2 = "transactionHistoryFragment.tvDateTime"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                java.lang.String r2 = r14.getDateTime()
                java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
                java.lang.String r5 = "dd MMM yyyy, hh:mm a"
                java.lang.String r2 = net.one97.paytm.passbook.mapping.a.l(r2, r3, r5)
                java.lang.String r3 = "CJRAppUtility.formatDate…, \"dd MMM yyyy, hh:mm a\")"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r3 = "am"
                java.lang.String r5 = "AM"
                java.lang.String r2 = kotlin.m.p.a(r2, r3, r5, r10)
                java.lang.String r3 = "pm"
                java.lang.String r5 = "PM"
                java.lang.String r2 = kotlin.m.p.a(r2, r3, r5, r10)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
            L_0x022f:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.toolbar
                android.view.View r1 = r1.a((int) r2)
                android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r2 = r0.f59178b
                int r3 = net.one97.paytm.passbook.R.id.rvHeader
                android.view.View r2 = r2.a((int) r3)
                android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                android.content.Context r2 = r2.getContext()
                int r3 = net.one97.paytm.passbook.R.color.color_f3f7f8
                int r2 = androidx.core.content.b.c(r2, r3)
                r1.setBackgroundColor(r2)
                java.util.ArrayList r1 = r14.getReferenceIds()
                if (r1 == 0) goto L_0x02e9
                int r2 = r1.size()
                java.lang.String r3 = ""
                r4 = r3
                r3 = 0
            L_0x0261:
                if (r3 >= r2) goto L_0x029a
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r4)
                int r4 = r1.size()
                int r4 = r4 - r8
                if (r3 != r4) goto L_0x0279
                java.lang.Object r4 = r1.get(r3)
                java.lang.String r4 = (java.lang.String) r4
                goto L_0x0290
            L_0x0279:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.Object r7 = r1.get(r3)
                java.lang.String r7 = (java.lang.String) r7
                r4.append(r7)
                r7 = 10
                r4.append(r7)
                java.lang.String r4 = r4.toString()
            L_0x0290:
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                int r3 = r3 + 1
                goto L_0x0261
            L_0x029a:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.tvReferenceIds
                android.view.View r1 = r1.a((int) r2)
                androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
                java.lang.String r2 = "transactionHistoryFragment.tvReferenceIds"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                r2 = r4
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                if (r4 == 0) goto L_0x02e1
                java.lang.CharSequence r1 = kotlin.m.p.b(r2)
                java.lang.String r1 = r1.toString()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                java.lang.String r2 = "transactionHistoryFragment.seperator"
                if (r1 != 0) goto L_0x02d2
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r3 = net.one97.paytm.passbook.R.id.seperator
                android.view.View r1 = r1.a((int) r3)
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                r1.setVisibility(r10)
                goto L_0x02e9
            L_0x02d2:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r3 = net.one97.paytm.passbook.R.id.seperator
                android.view.View r1 = r1.a((int) r3)
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                r1.setVisibility(r6)
                goto L_0x02e9
            L_0x02e1:
                kotlin.u r14 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
                r14.<init>(r0)
                throw r14
            L_0x02e9:
                java.util.ArrayList r1 = r14.getFirstInstrument()
                r0.a(r1, r8)
                java.util.ArrayList r1 = r14.getSecondInstrument()
                r0.a(r1, r10)
                com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
                java.lang.String r2 = r14.getStatusLogoUrl()
                com.squareup.picasso.aa r1 = r1.a((java.lang.String) r2)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r2 = r0.f59178b
                int r3 = net.one97.paytm.passbook.R.id.ivStatus
                android.view.View r2 = r2.a((int) r3)
                android.widget.ImageView r2 = (android.widget.ImageView) r2
                r1.a((android.widget.ImageView) r2)
                net.one97.paytm.passbook.beans.RepeatPayment r1 = r14.getRepeatPayment()
                if (r1 == 0) goto L_0x034a
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r2 = r0.f59178b
                int r3 = net.one97.paytm.passbook.R.id.tvRepeatPayment
                android.view.View r2 = r2.a((int) r3)
                androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
                java.lang.String r3 = "transactionHistoryFragment.tvRepeatPayment"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r10)
                java.lang.String r2 = r1.getName()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x034a
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r2 = r0.f59178b
                int r4 = net.one97.paytm.passbook.R.id.tvRepeatPayment
                android.view.View r2 = r2.a((int) r4)
                androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r1 = r1.getName()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2.setText(r1)
            L_0x034a:
                java.lang.String r1 = r14.getStatus()
                if (r1 != 0) goto L_0x0352
                goto L_0x04a0
            L_0x0352:
                int r2 = r1.hashCode()
                r3 = -368591510(0xffffffffea07bd6a, float:-4.1024867E25)
                java.lang.String r4 = "transactionHistoryFragment.tvNotes"
                if (r2 == r3) goto L_0x0398
                r14 = 35394935(0x21c1577, float:1.146723E-37)
                if (r2 == r14) goto L_0x0364
                goto L_0x04a0
            L_0x0364:
                java.lang.String r14 = "PENDING"
                boolean r14 = r1.equals(r14)
                if (r14 == 0) goto L_0x04a0
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r14 = r0.f59178b
                int r1 = net.one97.paytm.passbook.R.id.tvNotes
                android.view.View r14 = r14.a((int) r1)
                androidx.appcompat.widget.AppCompatTextView r14 = (androidx.appcompat.widget.AppCompatTextView) r14
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
                r14.setVisibility(r10)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r14 = r0.f59178b
                int r1 = net.one97.paytm.passbook.R.id.tvNotes
                android.view.View r14 = r14.a((int) r1)
                androidx.appcompat.widget.AppCompatTextView r14 = (androidx.appcompat.widget.AppCompatTextView) r14
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r0.f59178b
                int r1 = net.one97.paytm.passbook.R.string.pass_payment_hist_pending_msg
                java.lang.String r0 = r0.getString(r1)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r14.setText(r0)
                goto L_0x04a0
            L_0x0398:
                java.lang.String r2 = "FAILURE"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x04a0
                java.lang.String r1 = r14.getNotes()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x04a0
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r0.f59178b
                int r2 = net.one97.paytm.passbook.R.id.tvNotes
                android.view.View r1 = r1.a((int) r2)
                androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                r1.setVisibility(r10)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r0.f59178b
                int r1 = net.one97.paytm.passbook.R.id.tvNotes
                android.view.View r0 = r0.a((int) r1)
                androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
                java.lang.String r14 = r14.getNotes()
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                r0.setText(r14)
                goto L_0x04a0
            L_0x03d4:
                kotlin.u r14 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse"
                r14.<init>(r0)
                throw r14
            L_0x03dc:
                net.one97.paytm.passbook.mapping.a.j r0 = r14.f57886a
                net.one97.paytm.passbook.mapping.a.j r1 = net.one97.paytm.passbook.mapping.a.j.ERROR
                if (r0 != r1) goto L_0x04a0
                net.one97.paytm.passbook.mapping.a.d<? extends T> r14 = r14.f57888c
                if (r14 == 0) goto L_0x03e9
                com.paytm.network.model.NetworkCustomError r14 = r14.f57879a
                goto L_0x03ea
            L_0x03e9:
                r14 = r9
            L_0x03ea:
                if (r14 == 0) goto L_0x03f3
                int r0 = r14.getStatusCode()
                r1 = -1
                if (r0 == r1) goto L_0x03fd
            L_0x03f3:
                if (r14 == 0) goto L_0x03fd
                int r0 = r14.getStatusCode()
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L_0x040f
            L_0x03fd:
                if (r14 == 0) goto L_0x0405
                int r0 = r14.getStatusCode()
                if (r0 == r3) goto L_0x040f
            L_0x0405:
                if (r14 == 0) goto L_0x0427
                int r0 = r14.getStatusCode()
                r1 = 403(0x193, float:5.65E-43)
                if (r0 != r1) goto L_0x0427
            L_0x040f:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r13.f59184a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.app.Activity r0 = (android.app.Activity) r0
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r13.f59184a
                java.lang.Class r1 = r1.getClass()
                r1.getName()
                java.lang.Exception r14 = (java.lang.Exception) r14
                net.one97.paytm.passbook.utility.j.a(r0, r14, r10, r8)
                goto L_0x04a0
            L_0x0427:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r14 = r13.f59184a
                net.one97.paytm.passbook.transactionHistory.b r14 = net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment.a((net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment) r14)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r14.f59178b
                int r1 = net.one97.paytm.passbook.R.id.ilError
                android.view.View r0 = r0.a((int) r1)
                android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
                r0.setVisibility(r10)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r14.f59178b
                int r1 = net.one97.paytm.passbook.R.id.share_imv
                android.view.View r0 = r0.a((int) r1)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
                r0.setVisibility(r6)
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r14.f59178b
                int r1 = net.one97.paytm.passbook.R.id.toolbar
                android.view.View r0 = r0.a((int) r1)
                android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r1 = r14.f59178b
                int r3 = net.one97.paytm.passbook.R.id.rvHeader
                android.view.View r1 = r1.a((int) r3)
                android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                android.content.Context r1 = r1.getContext()
                int r3 = net.one97.paytm.passbook.R.color.white
                int r1 = androidx.core.content.b.c(r1, r3)
                r0.setBackgroundColor(r1)
                boolean r0 = android.text.TextUtils.isEmpty(r9)
                if (r0 != 0) goto L_0x047f
                java.lang.String r0 = "null"
                boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r8)
                if (r0 == 0) goto L_0x048e
            L_0x047f:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r0 = r14.f59178b
                android.content.Context r0 = r0.getContext()
                if (r0 == 0) goto L_0x048e
                int r1 = net.one97.paytm.passbook.R.string.pass_payment_history_details_default_failure_msg
                java.lang.String r0 = r0.getString(r1)
                r9 = r0
            L_0x048e:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment r14 = r14.f59178b
                int r0 = net.one97.paytm.passbook.R.id.tvErrorMsg
                android.view.View r14 = r14.a((int) r0)
                android.widget.TextView r14 = (android.widget.TextView) r14
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r14.setText(r9)
            L_0x04a0:
                net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment.a()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment.a.onChanged(java.lang.Object):void");
        }
    }

    public static final /* synthetic */ net.one97.paytm.passbook.transactionHistory.b a(TransactionHistoryFragment transactionHistoryFragment) {
        net.one97.paytm.passbook.transactionHistory.b bVar = transactionHistoryFragment.f59181b;
        if (bVar == null) {
            k.a("uiHandler");
        }
        return bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_fragment_transaction_history, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.transactionHistory.a.b.class);
        k.a((Object) a2, "ViewModelProviders.of(th…oryViewModel::class.java)");
        this.f59180a = (net.one97.paytm.passbook.transactionHistory.a.b) a2;
        this.f59181b = new net.one97.paytm.passbook.transactionHistory.b(this);
        b();
        net.one97.paytm.passbook.transactionHistory.a.b bVar = this.f59180a;
        if (bVar == null) {
            k.a("viewModel");
        }
        bVar.f59166a.observe(this, new a(this));
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.ivBack)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.share_imv)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.btnRetry)).setOnClickListener(onClickListener);
        ((RelativeLayout) a(R.id.rlNeedHelp)).setOnClickListener(onClickListener);
        ((AppCompatTextView) a(R.id.tvRepeatPayment)).setOnClickListener(onClickListener);
    }

    private final void b() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            c();
            net.one97.paytm.passbook.transactionHistory.a.b bVar = this.f59180a;
            if (bVar == null) {
                k.a("viewModel");
            }
            bVar.a(intent.getStringExtra("txnId"), intent.getStringExtra("stream_source"));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x000c
            int r10 = r10.getId()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x000d
        L_0x000c:
            r10 = r0
        L_0x000d:
            int r1 = net.one97.paytm.passbook.R.id.ivBack
            if (r10 != 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            int r2 = r10.intValue()
            if (r2 != r1) goto L_0x0022
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x0021
            r10.onBackPressed()
        L_0x0021:
            return
        L_0x0022:
            int r1 = net.one97.paytm.passbook.R.id.share_imv
            if (r10 != 0) goto L_0x0027
            goto L_0x0076
        L_0x0027:
            int r2 = r10.intValue()
            if (r2 != r1) goto L_0x0076
            boolean r10 = r9.isAdded()
            if (r10 == 0) goto L_0x0075
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 != 0) goto L_0x003a
            goto L_0x0075
        L_0x003a:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            boolean r10 = r10 instanceof net.one97.paytm.passbook.transactionHistory.activity.TransactionHistoryActivity
            if (r10 == 0) goto L_0x0075
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x006d
            net.one97.paytm.passbook.transactionHistory.activity.TransactionHistoryActivity r10 = (net.one97.paytm.passbook.transactionHistory.activity.TransactionHistoryActivity) r10
            if (r10 == 0) goto L_0x0075
            java.lang.Runnable r0 = r9.f59182c
            java.lang.String r1 = "taskRunnable"
            kotlin.g.b.k.c(r0, r1)
            r10.f59173a = r0
            boolean r0 = com.paytm.utility.s.a()
            if (r0 == 0) goto L_0x0069
            r0 = r10
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r1 = com.paytm.utility.s.c((android.app.Activity) r0)
            if (r1 != 0) goto L_0x0069
            com.paytm.utility.s.b((android.app.Activity) r0)
            return
        L_0x0069:
            r10.a()
            return
        L_0x006d:
            kotlin.u r10 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.passbook.transactionHistory.activity.TransactionHistoryActivity"
            r10.<init>(r0)
            throw r10
        L_0x0075:
            return
        L_0x0076:
            int r1 = net.one97.paytm.passbook.R.id.btnRetry
            if (r10 != 0) goto L_0x007b
            goto L_0x00a6
        L_0x007b:
            int r2 = r10.intValue()
            if (r2 != r1) goto L_0x00a6
            android.content.Context r10 = r9.getContext()
            if (r10 == 0) goto L_0x00a5
            java.lang.String r0 = "it"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            boolean r0 = net.one97.paytm.passbook.utility.f.a((android.content.Context) r10)
            if (r0 == 0) goto L_0x0096
            r9.b()
            return
        L_0x0096:
            int r0 = net.one97.paytm.passbook.R.string.no_connection
            java.lang.String r0 = r9.getString(r0)
            int r1 = net.one97.paytm.passbook.R.string.no_internet_body
            java.lang.String r1 = r9.getString(r1)
            net.one97.paytm.passbook.mapping.c.a((android.content.Context) r10, (java.lang.String) r0, (java.lang.String) r1)
        L_0x00a5:
            return
        L_0x00a6:
            int r1 = net.one97.paytm.passbook.R.id.rlNeedHelp
            java.lang.String r2 = "viewModel"
            if (r10 != 0) goto L_0x00af
            goto L_0x01cd
        L_0x00af:
            int r3 = r10.intValue()
            if (r3 != r1) goto L_0x01cd
            net.one97.paytm.passbook.mapping.f r10 = net.one97.paytm.passbook.d.b()
            r1 = 1
            java.lang.String r3 = "passOnusTxnEnabled"
            boolean r10 = r10.a((java.lang.String) r3, (boolean) r1)
            net.one97.paytm.passbook.transactionHistory.a.b r3 = r9.f59180a
            if (r3 != 0) goto L_0x00c7
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00c7:
            if (r3 == 0) goto L_0x00e0
            androidx.lifecycle.y<net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse>> r3 = r3.f59166a
            if (r3 == 0) goto L_0x00e0
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.passbook.mapping.a.f r3 = (net.one97.paytm.passbook.mapping.a.f) r3
            if (r3 == 0) goto L_0x00e0
            T r3 = r3.f57887b
            net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse r3 = (net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse) r3
            if (r3 == 0) goto L_0x00e0
            java.lang.String r3 = r3.getMerchantType()
            goto L_0x00e1
        L_0x00e0:
            r3 = r0
        L_0x00e1:
            net.one97.paytm.passbook.transactionHistory.a.b r4 = r9.f59180a     // Catch:{ Exception -> 0x0127 }
            if (r4 != 0) goto L_0x00e8
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0127 }
        L_0x00e8:
            if (r4 == 0) goto L_0x0100
            androidx.lifecycle.y<net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse>> r4 = r4.f59166a     // Catch:{ Exception -> 0x0127 }
            if (r4 == 0) goto L_0x0100
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x0127 }
            net.one97.paytm.passbook.mapping.a.f r4 = (net.one97.paytm.passbook.mapping.a.f) r4     // Catch:{ Exception -> 0x0127 }
            if (r4 == 0) goto L_0x0100
            T r4 = r4.f57887b     // Catch:{ Exception -> 0x0127 }
            net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse r4 = (net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse) r4     // Catch:{ Exception -> 0x0127 }
            if (r4 == 0) goto L_0x0100
            java.lang.Object r0 = r4.getCstorderItem()     // Catch:{ Exception -> 0x0127 }
        L_0x0100:
            java.lang.String r4 = "null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<kotlin.String, kotlin.String>"
            if (r0 == 0) goto L_0x0121
            com.google.gsonhtcfix.b.g r0 = (com.google.gsonhtcfix.b.g) r0     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = "pgParams"
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x0127 }
            if (r0 == 0) goto L_0x011b
            com.google.gsonhtcfix.b.g r0 = (com.google.gsonhtcfix.b.g) r0     // Catch:{ Exception -> 0x0127 }
            java.lang.String r4 = "orderId"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0127 }
            goto L_0x0129
        L_0x011b:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0127 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0127 }
            throw r0     // Catch:{ Exception -> 0x0127 }
        L_0x0121:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0127 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0127 }
            throw r0     // Catch:{ Exception -> 0x0127 }
        L_0x0127:
            java.lang.String r0 = ""
        L_0x0129:
            if (r10 == 0) goto L_0x017e
            r10 = r3
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x017e
            java.lang.String r10 = "ONUS"
            boolean r10 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r10, (boolean) r1)
            if (r10 == 0) goto L_0x017e
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x017e
            android.content.Intent r10 = new android.content.Intent
            android.content.Context r1 = r9.getContext()
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()
            java.lang.String r3 = "PassbookHelper.getImplListener()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Class r2 = r2.i()
            r10.<init>(r1, r2)
            java.lang.String r1 = "From"
            java.lang.String r2 = "Order_history"
            r10.putExtra(r1, r2)
            java.lang.String r1 = "order_id"
            r10.putExtra(r1, r0)
            r9.startActivity(r10)
            android.content.Context r2 = r9.getContext()
            r5 = 0
            r6 = 0
            java.lang.String r3 = "uth_passbook"
            java.lang.String r4 = "uth_detail_view_order_clicked"
            java.lang.String r7 = "/uth_passbook_myaccounts/uth_details"
            java.lang.String r8 = "PASSBOOK"
            net.one97.paytm.passbook.utility.q.a(r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x017e:
            net.one97.paytm.passbook.transactionHistory.a.b r10 = r9.f59180a
            if (r10 != 0) goto L_0x0185
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0185:
            if (r10 == 0) goto L_0x01cc
            androidx.lifecycle.y<net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse>> r10 = r10.f59166a
            if (r10 == 0) goto L_0x01cc
            java.lang.Object r10 = r10.getValue()
            net.one97.paytm.passbook.mapping.a.f r10 = (net.one97.paytm.passbook.mapping.a.f) r10
            if (r10 == 0) goto L_0x01cc
            T r10 = r10.f57887b
            net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse r10 = (net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse) r10
            if (r10 == 0) goto L_0x01cc
            java.lang.Object r10 = r10.getCstorderItem()
            if (r10 == 0) goto L_0x01cc
            com.google.gson.f r0 = new com.google.gson.f
            r0.<init>()
            java.lang.String r10 = r0.b(r10)
            java.lang.String r10 = r10.toString()
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            r0.a((androidx.appcompat.app.AppCompatActivity) r1, (java.lang.String) r10)
            android.content.Context r2 = r9.getContext()
            r5 = 0
            r6 = 0
            java.lang.String r3 = "uth_passbook"
            java.lang.String r4 = "uth_detail_need_help_clicked"
            java.lang.String r7 = "/uth_passbook_myaccounts/uth_details"
            java.lang.String r8 = "PASSBOOK"
            net.one97.paytm.passbook.utility.q.a(r2, r3, r4, r5, r6, r7, r8)
        L_0x01cc:
            return
        L_0x01cd:
            int r1 = net.one97.paytm.passbook.R.id.tvRepeatPayment
            if (r10 != 0) goto L_0x01d2
            return
        L_0x01d2:
            int r10 = r10.intValue()
            if (r10 != r1) goto L_0x0226
            net.one97.paytm.passbook.transactionHistory.a.b r10 = r9.f59180a
            if (r10 != 0) goto L_0x01df
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01df:
            if (r10 == 0) goto L_0x01fd
            androidx.lifecycle.y<net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse>> r10 = r10.f59166a
            if (r10 == 0) goto L_0x01fd
            java.lang.Object r10 = r10.getValue()
            net.one97.paytm.passbook.mapping.a.f r10 = (net.one97.paytm.passbook.mapping.a.f) r10
            if (r10 == 0) goto L_0x01fd
            T r10 = r10.f57887b
            net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse r10 = (net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse) r10
            if (r10 == 0) goto L_0x01fd
            net.one97.paytm.passbook.beans.RepeatPayment r10 = r10.getRepeatPayment()
            if (r10 == 0) goto L_0x01fd
            java.lang.String r0 = r10.getUrl()
        L_0x01fd:
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0213
            net.one97.paytm.passbook.mapping.f r10 = net.one97.paytm.passbook.d.b()
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()
            android.app.Activity r1 = (android.app.Activity) r1
            r10.a((java.lang.String) r0, (android.app.Activity) r1)
        L_0x0213:
            android.content.Context r2 = r9.getContext()
            r5 = 0
            r6 = 0
            java.lang.String r3 = "uth_passbook"
            java.lang.String r4 = "uth_detail_repeat_payment_clicked"
            java.lang.String r7 = "/uth_passbook_myaccounts/uth_details"
            java.lang.String r8 = "PASSBOOK"
            net.one97.paytm.passbook.utility.q.a(r2, r3, r4, r5, r6, r7, r8)
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionHistory.fragments.TransactionHistoryFragment.onClick(android.view.View):void");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TransactionHistoryFragment f59185a;

        b(TransactionHistoryFragment transactionHistoryFragment) {
            this.f59185a = transactionHistoryFragment;
        }

        public final void run() {
            View findViewById;
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", this.f59185a.getString(R.string.post_payment_share_subject));
                View view = this.f59185a.getView();
                if (view != null && (findViewById = view.findViewById(R.id.svContent)) != null) {
                    Bitmap a2 = TransactionHistoryFragment.a(findViewById);
                    FragmentActivity activity = this.f59185a.getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    k.a((Object) activity, "activity!!");
                    ContentResolver contentResolver = activity.getContentResolver();
                    String insertImage = MediaStore.Images.Media.insertImage(contentResolver, a2, this.f59185a.getString(R.string.title) + '-' + System.currentTimeMillis(), (String) null);
                    if (insertImage != null) {
                        Uri parse = Uri.parse(insertImage);
                        k.a((Object) parse, "Uri.parse(pathofBmp)");
                        intent.putExtra("android.intent.extra.STREAM", parse);
                        Intent createChooser = Intent.createChooser(intent, this.f59185a.getString(R.string.post_payment_share_title));
                        Context context = this.f59185a.getContext();
                        if (context == null) {
                            k.a();
                        }
                        k.a((Object) context, "context!!");
                        if (createChooser.resolveActivity(context.getPackageManager()) != null) {
                            this.f59185a.startActivity(createChooser);
                        } else {
                            Toast.makeText(this.f59185a.getActivity(), this.f59185a.getString(R.string.no_app_found), 1).show();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static Bitmap a(View view) {
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.rlNeedHelp);
        k.a((Object) findViewById, "view.findViewById<View>(R.id.rlNeedHelp)");
        int visibility = findViewById.getVisibility();
        View findViewById2 = view.findViewById(R.id.rlNeedHelp);
        k.a((Object) findViewById2, "view.findViewById<View>(R.id.rlNeedHelp)");
        findViewById2.setVisibility(8);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        View findViewById3 = view.findViewById(R.id.rlNeedHelp);
        k.a((Object) findViewById3, "view.findViewById<View>(R.id.rlNeedHelp)");
        findViewById3.setVisibility(visibility);
        k.a((Object) createBitmap, "bitmap");
        return createBitmap;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3 && i3 == -1) {
            b();
        }
    }

    private void c() {
        Context context = getContext();
        if (context != null) {
            net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
            k.a((Object) context, "it");
            net.one97.paytm.passbook.genericPassbook.d.a.f.a(context);
        }
    }

    public static void a() {
        net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
        net.one97.paytm.passbook.genericPassbook.d.a.f.a();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f59183d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
