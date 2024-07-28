package net.one97.paytm.impsRefund.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail;
import net.one97.paytm.impsRefund.a.c;
import net.one97.paytm.paytm_finance.R;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRRefundAccountDetail> f50671a;

    /* renamed from: b  reason: collision with root package name */
    Fragment f50672b;

    public d(ArrayList<CJRRefundAccountDetail> arrayList, Fragment fragment) {
        k.c(fragment, "fragment");
        this.f50671a = arrayList;
        this.f50672b = fragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        r3 = r0.getBankName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r13, int r14) {
        /*
            r12 = this;
            net.one97.paytm.impsRefund.view.d$a r13 = (net.one97.paytm.impsRefund.view.d.a) r13
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r13, r0)
            java.util.ArrayList<net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail> r0 = r12.f50671a
            if (r0 == 0) goto L_0x010a
            java.lang.Object r0 = r0.get(r14)
            net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail r0 = (net.one97.paytm.common.entity.impsdatamodel.CJRRefundAccountDetail) r0
            android.widget.TextView r1 = r13.f50673a
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0028
            if (r0 == 0) goto L_0x0022
            java.lang.String r3 = r0.getBankName()
            if (r3 == 0) goto L_0x0022
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x0025
        L_0x0022:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
        L_0x0025:
            r1.setText(r3)
        L_0x0028:
            android.widget.TextView r1 = r13.f50674b
            r3 = 2131957980(0x7f1318dc, float:1.955256E38)
            java.lang.String r4 = "itemView.context"
            java.lang.String r5 = "itemView"
            r6 = 0
            r7 = 1
            if (r1 == 0) goto L_0x005b
            android.view.View r8 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            android.content.Context r8 = r8.getContext()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            android.content.res.Resources r8 = r8.getResources()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            if (r0 == 0) goto L_0x004f
            java.lang.String r10 = r0.getMaskedAccountNumber()
            if (r10 != 0) goto L_0x0050
        L_0x004f:
            r10 = r2
        L_0x0050:
            r9[r6] = r10
            java.lang.String r8 = r8.getString(r3, r9)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
        L_0x005b:
            r1 = 0
            if (r0 == 0) goto L_0x0063
            java.lang.String r8 = r0.getAssetId()
            goto L_0x0064
        L_0x0063:
            r8 = r1
        L_0x0064:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0074
            android.widget.RadioButton r8 = r13.f50675c
            if (r8 == 0) goto L_0x007b
            r8.setChecked(r7)
            goto L_0x007b
        L_0x0074:
            android.widget.RadioButton r8 = r13.f50675c
            if (r8 == 0) goto L_0x007b
            r8.setChecked(r6)
        L_0x007b:
            android.widget.TextView r8 = r13.f50674b     // Catch:{ Exception -> 0x00f6 }
            if (r8 == 0) goto L_0x00fe
            android.view.View r9 = r13.itemView     // Catch:{ Exception -> 0x00f6 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r5)     // Catch:{ Exception -> 0x00f6 }
            android.content.Context r5 = r9.getContext()     // Catch:{ Exception -> 0x00f6 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)     // Catch:{ Exception -> 0x00f6 }
            android.content.res.Resources r4 = r5.getResources()     // Catch:{ Exception -> 0x00f6 }
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00f6 }
            if (r0 == 0) goto L_0x0099
            java.lang.String r0 = r0.getMaskedAccountNumber()     // Catch:{ Exception -> 0x00f6 }
            if (r0 != 0) goto L_0x009a
        L_0x0099:
            r0 = r2
        L_0x009a:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x00f6 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00f6 }
            if (r2 != 0) goto L_0x00ea
            if (r0 == 0) goto L_0x00aa
            int r2 = r0.length()     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00ab
        L_0x00aa:
            r2 = 0
        L_0x00ab:
            r9 = 4
            if (r2 <= r9) goto L_0x00ea
            if (r0 == 0) goto L_0x00b5
            int r2 = r0.length()     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00b6
        L_0x00b5:
            r2 = 0
        L_0x00b6:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f6 }
            r10.<init>()     // Catch:{ Exception -> 0x00f6 }
            int r2 = r2 - r9
            if (r2 <= 0) goto L_0x00c8
        L_0x00be:
            java.lang.String r11 = "X"
            r10.append(r11)     // Catch:{ Exception -> 0x00f6 }
            if (r7 == r2) goto L_0x00c8
            int r7 = r7 + 1
            goto L_0x00be
        L_0x00c8:
            if (r0 == 0) goto L_0x00e3
            int r1 = r0.length()     // Catch:{ Exception -> 0x00f6 }
            int r1 = r1 - r9
            if (r0 == 0) goto L_0x00db
            java.lang.String r1 = r0.substring(r1)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.b(r1, r0)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00e3
        L_0x00db:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)     // Catch:{ Exception -> 0x00f6 }
            throw r0     // Catch:{ Exception -> 0x00f6 }
        L_0x00e3:
            r10.append(r1)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x00f6 }
        L_0x00ea:
            r5[r6] = r0     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r0 = r4.getString(r3, r5)     // Catch:{ Exception -> 0x00f6 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00f6 }
            r8.setText(r0)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00fe
        L_0x00f6:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x00fe:
            android.view.View r0 = r13.itemView
            net.one97.paytm.impsRefund.view.d$a$a r1 = new net.one97.paytm.impsRefund.view.d$a$a
            r1.<init>(r13, r14)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.impsRefund.view.d.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.refund_account_list_item, viewGroup, false));
    }

    public final int getItemCount() {
        ArrayList<CJRRefundAccountDetail> arrayList = this.f50671a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f50673a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f50674b;

        /* renamed from: c  reason: collision with root package name */
        final RadioButton f50675c;

        /* renamed from: e  reason: collision with root package name */
        private final ImageView f50677e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f50678f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            RadioButton radioButton;
            if (view == null) {
                k.a();
            }
            this.f50677e = (ImageView) view.findViewById(R.id.bank_iv);
            this.f50673a = (TextView) view.findViewById(R.id.bank_name_tv);
            this.f50674b = (TextView) view.findViewById(R.id.bank_acc_no_tv);
            this.f50678f = (TextView) view.findViewById(R.id.bank_ifsc_tv);
            this.f50675c = (RadioButton) view.findViewById(R.id.rb_bank_select);
            if (d.this.getItemCount() > 1 && (radioButton = this.f50675c) != null) {
                radioButton.setVisibility(0);
            }
        }

        /* renamed from: net.one97.paytm.impsRefund.view.d$a$a  reason: collision with other inner class name */
        static final class C0922a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f50679a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f50680b;

            C0922a(a aVar, int i2) {
                this.f50679a = aVar;
                this.f50680b = i2;
            }

            public final void onClick(View view) {
                RadioButton radioButton = this.f50679a.f50675c;
                if (radioButton != null && !radioButton.isChecked()) {
                    Fragment fragment = d.this.f50672b;
                    if (fragment != null) {
                        c cVar = (c) fragment;
                        int i2 = this.f50680b;
                        cVar.f50654d = cVar.f50653c;
                        cVar.f50655e = i2;
                        if (cVar.f50654d != -1) {
                            ArrayList<CJRRefundAccountDetail> arrayList = cVar.f50651a;
                            if (arrayList == null) {
                                k.a("bankList");
                            }
                            CJRRefundAccountDetail cJRRefundAccountDetail = arrayList.get(cVar.f50654d);
                            k.a((Object) cJRRefundAccountDetail, "bankList[mAccountToBeRemoved]");
                            CharSequence assetId = cJRRefundAccountDetail.getAssetId();
                            if (!(assetId == null || assetId.length() == 0)) {
                                c.a aVar = cVar.f50652b;
                                if (aVar == null) {
                                    k.a("mPresenter");
                                }
                                ArrayList<CJRRefundAccountDetail> arrayList2 = cVar.f50651a;
                                if (arrayList2 == null) {
                                    k.a("bankList");
                                }
                                CJRRefundAccountDetail cJRRefundAccountDetail2 = arrayList2.get(cVar.f50654d);
                                k.a((Object) cJRRefundAccountDetail2, "bankList[mAccountToBeRemoved]");
                                String assetId2 = cJRRefundAccountDetail2.getAssetId();
                                k.a((Object) assetId2, "bankList[mAccountToBeRemoved].assetId");
                                aVar.a(assetId2);
                                return;
                            }
                            return;
                        }
                        cVar.b();
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.impsRefund.view.RefundBankListFragment");
                }
            }
        }
    }
}
