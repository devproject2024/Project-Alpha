package net.one97.paytm.passbook.mgv.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo;
import net.one97.paytm.passbook.beans.mgv.UserCardDetail;
import net.one97.paytm.passbook.beans.mgv.UserTemplateDetail;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<AccountTransactionInfo> f57894a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public C1099b f57895b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57896c;

    /* renamed from: d  reason: collision with root package name */
    private final int f57897d;

    /* renamed from: e  reason: collision with root package name */
    private final int f57898e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final int f57899f = 2;

    /* renamed from: g  reason: collision with root package name */
    private UserTemplateDetail f57900g;

    /* renamed from: h  reason: collision with root package name */
    private UserCardDetail f57901h;

    /* renamed from: i  reason: collision with root package name */
    private a f57902i;

    /* renamed from: net.one97.paytm.passbook.mgv.a.b$b  reason: collision with other inner class name */
    public interface C1099b {
        void a(int i2, int i3);
    }

    public b(UserTemplateDetail userTemplateDetail, UserCardDetail userCardDetail, a aVar) {
        k.c(userTemplateDetail, "mUserTemplateDetail");
        k.c(userCardDetail, "mUserCardDetail");
        k.c(aVar, "loadMoreListener");
        this.f57900g = userTemplateDetail;
        this.f57901h = userCardDetail;
        this.f57902i = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f57897d) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_layout_voucher_detail, viewGroup, false);
            k.a((Object) inflate, "view");
            return new d(inflate);
        } else if (i2 == this.f57898e) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_mgv_transaction_item, viewGroup, false);
            k.a((Object) inflate2, "view");
            return new c(this, inflate2);
        } else if (i2 == this.f57899f) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_layout_mgv_no_data, viewGroup, false);
            k.a((Object) inflate3, "view");
            return new a(inflate3);
        } else {
            throw new RuntimeException("Invalid view type");
        }
    }

    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return this.f57897d;
        }
        if (this.f57896c) {
            return this.f57899f;
        }
        return this.f57898e;
    }

    public final int getItemCount() {
        if (this.f57894a.size() != 0 || !this.f57896c) {
            return this.f57894a.size() + 1;
        }
        return 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r12, int r13) {
        /*
            r11 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r12, r0)
            boolean r0 = r12 instanceof net.one97.paytm.passbook.mgv.a.b.c
            r1 = 0
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mm:ss"
            r3 = 1
            java.lang.String r4 = "itemView"
            if (r0 == 0) goto L_0x0188
            r0 = r12
            net.one97.paytm.passbook.mgv.a.b$c r0 = (net.one97.paytm.passbook.mgv.a.b.c) r0
            android.view.View r5 = r0.itemView
            int r6 = net.one97.paytm.passbook.R.id.title1
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.view.View r6 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            int r7 = net.one97.paytm.passbook.R.id.line1
            android.view.View r6 = r6.findViewById(r7)
            java.lang.String r7 = "itemView.line1"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r8 = 0
            r6.setVisibility(r8)
            android.view.View r6 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            int r9 = net.one97.paytm.passbook.R.id.line2
            android.view.View r6 = r6.findViewById(r9)
            java.lang.String r9 = "itemView.line2"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            r6.setVisibility(r8)
            r6 = 8
            if (r13 != r3) goto L_0x005a
            android.view.View r8 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            int r10 = net.one97.paytm.passbook.R.id.line1
            android.view.View r8 = r8.findViewById(r10)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            r8.setVisibility(r6)
            goto L_0x0074
        L_0x005a:
            net.one97.paytm.passbook.mgv.a.b r7 = r0.f57903a
            int r7 = r7.getItemCount()
            int r7 = r7 - r3
            if (r7 != r13) goto L_0x0074
            android.view.View r7 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            int r8 = net.one97.paytm.passbook.R.id.line2
            android.view.View r7 = r7.findViewById(r8)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r7.setVisibility(r6)
        L_0x0074:
            net.one97.paytm.passbook.mgv.a.b r7 = r0.f57903a
            net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo r7 = r7.a(r13)
            net.one97.paytm.passbook.mgv.a.b r8 = r0.f57903a
            java.util.ArrayList<net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo> r8 = r8.f57894a
            if (r8 == 0) goto L_0x0088
            int r1 = r8.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0088:
            if (r1 == 0) goto L_0x00a1
            int r1 = r1.intValue()
            if (r1 != r3) goto L_0x00a1
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            int r8 = net.one97.paytm.passbook.R.id.line2
            android.view.View r1 = r1.findViewById(r8)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            r1.setVisibility(r6)
        L_0x00a1:
            java.lang.String r1 = r7.getAccountingTimestamp()
            long r1 = net.one97.paytm.passbook.mapping.a.j(r1, r2)
            android.view.View r6 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            int r8 = net.one97.paytm.passbook.R.id.dateTv
            android.view.View r6 = r6.findViewById(r8)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r8 = 19800000(0x12e1fc0, double:9.7825E-317)
            long r1 = r1 + r8
            java.lang.String r8 = "dd MMM yyyy, hh:mm a"
            java.lang.String r1 = net.one97.paytm.passbook.mapping.a.a(r1, r8)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
            java.lang.String r1 = r7.getTransactionType()
            java.lang.String r2 = "pay"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            java.lang.String r2 = "orderTypeTv"
            if (r1 != 0) goto L_0x0119
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            int r6 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r1 = r1.findViewById(r6)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r6 = "#21c17a"
            int r6 = android.graphics.Color.parseColor(r6)
            r1.setTextColor(r6)
            java.lang.String r1 = r7.getTransactionType()
            java.lang.String r6 = "PURCHASED"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r1 == 0) goto L_0x0111
            boolean r1 = r1.contentEquals(r6)
            if (r1 == 0) goto L_0x0104
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            java.lang.String r1 = "Purchased Gift Voucher"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
            goto L_0x010e
        L_0x0104:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            java.lang.String r1 = "Refund for Order"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
        L_0x010e:
            java.lang.String r1 = ""
            goto L_0x013b
        L_0x0111:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type java.lang.String"
            r12.<init>(r13)
            throw r12
        L_0x0119:
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            int r6 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r1 = r1.findViewById(r6)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r6 = "#222222"
            int r6 = android.graphics.Color.parseColor(r6)
            r1.setTextColor(r6)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            java.lang.String r1 = "Paid for Order"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
            java.lang.String r1 = "-  "
        L_0x013b:
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            int r5 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            android.view.View r0 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r0 = r0.getContext()
            int r1 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r0 = r0.getString(r1)
            r5.append(r0)
            net.one97.paytm.passbook.beans.mgv.MGVAmount r0 = r7.getChangeAmount()
            java.lang.String r0 = r0.getAmountInRs()
            java.lang.String r0 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r0)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            android.view.View r12 = r12.itemView
            net.one97.paytm.passbook.mgv.a.b$e r0 = new net.one97.paytm.passbook.mgv.a.b$e
            r0.<init>(r11, r13)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r12.setOnClickListener(r0)
            goto L_0x027c
        L_0x0188:
            boolean r0 = r12 instanceof net.one97.paytm.passbook.mgv.a.b.d
            if (r0 == 0) goto L_0x027c
            net.one97.paytm.passbook.mgv.a.b$d r12 = (net.one97.paytm.passbook.mgv.a.b.d) r12
            net.one97.paytm.passbook.beans.mgv.UserTemplateDetail r0 = r11.f57900g
            net.one97.paytm.passbook.beans.mgv.UserCardDetail r5 = r11.f57901h
            java.lang.String r6 = "userTemplateDetail"
            kotlin.g.b.k.c(r0, r6)
            java.lang.String r6 = "userCardDetail"
            kotlin.g.b.k.c(r5, r6)
            android.view.View r6 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            int r7 = net.one97.paytm.passbook.R.id.availableAmountTv
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.view.View r8 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            android.content.Context r8 = r8.getContext()
            int r9 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r8 = r8.getString(r9)
            r7.append(r8)
            net.one97.paytm.passbook.beans.mgv.MGVAmount r8 = r5.getAvailableAmount()
            java.lang.String r8 = r8.getAmountInRs()
            java.lang.String r8 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r8)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            android.view.View r6 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            int r7 = net.one97.paytm.passbook.R.id.voucherWorthAmountTv
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.view.View r8 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            android.content.Context r8 = r8.getContext()
            int r9 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r8 = r8.getString(r9)
            r7.append(r8)
            net.one97.paytm.passbook.beans.mgv.MGVAmount r8 = r5.getTotalAmount()
            java.lang.String r8 = r8.getAmountInRs()
            java.lang.String r8 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r8)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            java.lang.String r6 = r5.getExpiredTime()
            long r6 = net.one97.paytm.passbook.mapping.a.j(r6, r2)
            android.view.View r8 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            int r9 = net.one97.paytm.passbook.R.id.expiredOnTv
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "dd MMM’yy"
            java.lang.String r6 = net.one97.paytm.passbook.mapping.a.a(r6, r9)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r8.setText(r6)
            java.lang.String r5 = r5.getCreateTime()
            long r5 = net.one97.paytm.passbook.mapping.a.j(r5, r2)
            android.view.View r2 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            int r7 = net.one97.paytm.passbook.R.id.purchasedOnTv
            android.view.View r2 = r2.findViewById(r7)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = net.one97.paytm.passbook.mapping.a.a(r5, r9)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            net.one97.paytm.passbook.beans.mgv.CardTemplate r0 = r0.getCardTemplate()
            if (r0 == 0) goto L_0x0268
            net.one97.paytm.passbook.beans.mgv.MerchantLogoInfo r0 = r0.getMerchantLogoInfo()
            if (r0 == 0) goto L_0x0268
            java.lang.String r1 = r0.getMerchantImageName()
        L_0x0268:
            com.squareup.picasso.aa r0 = r2.a((java.lang.String) r1)
            android.view.View r12 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            int r1 = net.one97.paytm.passbook.R.id.iconImv
            android.view.View r12 = r12.findViewById(r1)
            net.one97.paytm.passbook.customview.CircularImageView r12 = (net.one97.paytm.passbook.customview.CircularImageView) r12
            r0.a((android.widget.ImageView) r12)
        L_0x027c:
            java.util.ArrayList<net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo> r12 = r11.f57894a
            int r12 = r12.size()
            int r12 = r12 - r3
            if (r13 != r12) goto L_0x028c
            if (r13 == 0) goto L_0x028c
            net.one97.paytm.passbook.mgv.a.a r12 = r11.f57902i
            r12.b()
        L_0x028c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mgv.a.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57904a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f57905b;

        e(b bVar, int i2) {
            this.f57904a = bVar;
            this.f57905b = i2;
        }

        public final void onClick(View view) {
            C1099b bVar = this.f57904a.f57895b;
            if (bVar != null) {
                bVar.a(this.f57905b, this.f57904a.f57894a.size());
            }
        }
    }

    public final AccountTransactionInfo a(int i2) {
        AccountTransactionInfo accountTransactionInfo = this.f57894a.get(i2 - 1);
        k.a((Object) accountTransactionInfo, "accountTransactionInfoList.get(index - 1)");
        return accountTransactionInfo;
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57903a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f57903a = bVar;
        }
    }

    public static final class d extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }

    public static final class a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
