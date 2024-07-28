package net.one97.paytm.recharge.automatic.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.a.b;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.widgets.c.d;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    AdapterView.OnItemClickListener f60228a;

    /* renamed from: b  reason: collision with root package name */
    private final int f60229b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f60230c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f60231d = 3;

    /* renamed from: e  reason: collision with root package name */
    private final int f60232e = 4;

    /* renamed from: f  reason: collision with root package name */
    private final Context f60233f;

    /* renamed from: g  reason: collision with root package name */
    private final List<CJRAutomaticSubscriptionItemModel> f60234g;

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r12, int r13) {
        /*
            r11 = this;
            net.one97.paytm.recharge.automatic.a.a r12 = (net.one97.paytm.recharge.automatic.a.a) r12
            androidx.databinding.ViewDataBinding r0 = r12.f60227a
            int r1 = r11.getItemCount()
            r2 = 1
            int r1 = r1 - r2
            if (r13 >= r1) goto L_0x0172
            java.util.List<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel> r1 = r11.f60234g
            java.lang.Object r1 = r1.get(r13)
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r1 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel) r1
            int r3 = net.one97.paytm.recharge.a.f60180a
            r0.setVariable(r3, r1)
            int r3 = r1.getPaymentStatusCode()
            int r13 = r11.getItemViewType(r13)
            r4 = 0
            r5 = 3
            if (r5 != r13) goto L_0x0153
            r13 = 0
            r6 = 2
            if (r3 != r5) goto L_0x0052
            android.view.View r12 = r12.itemView
            int r3 = net.one97.paytm.recharge.R.id.txt_last_bill_paid
            android.view.View r12 = r12.findViewById(r3)
            android.widget.TextView r12 = (android.widget.TextView) r12
            android.content.Context r3 = r11.f60233f
            int r5 = net.one97.paytm.recharge.R.string.automatic_subscription_success_msg
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = r1.getLastBillPaidAmount()
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7, (boolean) r2)
            r6[r13] = r7
            java.lang.String r13 = r1.getLastBillPaidDate()
            r6[r2] = r13
            java.lang.String r13 = r3.getString(r5, r6)
            r12.setText(r13)
            goto L_0x0153
        L_0x0052:
            r5 = 4
            if (r3 == r5) goto L_0x00a6
            if (r3 != r6) goto L_0x0058
            goto L_0x00a6
        L_0x0058:
            if (r3 != r2) goto L_0x007d
            android.view.View r12 = r12.itemView
            int r3 = net.one97.paytm.recharge.R.id.txt_last_bill_paid
            android.view.View r12 = r12.findViewById(r3)
            android.widget.TextView r12 = (android.widget.TextView) r12
            android.content.Context r3 = r11.f60233f
            int r5 = net.one97.paytm.recharge.R.string.automatic_subscription_pending_msg
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r7 = r1.getLastBillPaidAmount()
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7, (boolean) r2)
            r6[r13] = r2
            java.lang.String r13 = r3.getString(r5, r6)
            r12.setText(r13)
            goto L_0x0153
        L_0x007d:
            android.view.View r12 = r12.itemView
            int r3 = net.one97.paytm.recharge.R.id.txt_last_bill_paid
            android.view.View r12 = r12.findViewById(r3)
            android.widget.TextView r12 = (android.widget.TextView) r12
            android.content.Context r3 = r11.f60233f
            int r5 = net.one97.paytm.recharge.R.string.last_bill_paid_amount_on_date
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = r1.getLastBillPaidAmount()
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r7, (boolean) r2)
            r6[r13] = r7
            java.lang.String r13 = r1.getLastBillPaidDate()
            r6[r2] = r13
            java.lang.String r13 = r3.getString(r5, r6)
            r12.setText(r13)
            goto L_0x0153
        L_0x00a6:
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            java.util.Date r3 = r3.getTime()
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            java.lang.String r7 = "dd MMM yyyy"
            r5.<init>(r7)
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ Exception | ParseException -> 0x0129 }
            java.lang.String r8 = "yyyy-MM-dd'T'HH:mm:ss"
            r7.<init>(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.lang.String r3 = r5.format(r3)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.util.Date r3 = r5.parse(r3)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.lang.String r8 = r1.getDueDate()     // Catch:{ Exception | ParseException -> 0x0129 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            if (r8 != 0) goto L_0x0129
            java.lang.String r8 = "UTC"
            java.util.TimeZone r8 = java.util.TimeZone.getTimeZone(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            r7.setTimeZone(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.lang.String r8 = r1.getDueDate()     // Catch:{ Exception | ParseException -> 0x0129 }
            java.util.Date r8 = r7.parse(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.lang.String r8 = r5.format(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.util.Date r8 = r5.parse(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.lang.String r9 = r7.format(r8)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.util.Date r7 = r7.parse(r9)     // Catch:{ Exception | ParseException -> 0x0129 }
            java.lang.String r5 = r5.format(r7)     // Catch:{ Exception | ParseException -> 0x0129 }
            if (r3 == 0) goto L_0x012a
            if (r8 == 0) goto L_0x012a
            int r3 = r3.compareTo(r8)     // Catch:{ Exception | ParseException -> 0x0127 }
            if (r3 <= 0) goto L_0x012a
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception | ParseException -> 0x0127 }
            if (r3 != 0) goto L_0x012a
            android.view.View r3 = r12.itemView     // Catch:{ Exception | ParseException -> 0x0127 }
            int r7 = net.one97.paytm.recharge.R.id.txt_last_bill_paid     // Catch:{ Exception | ParseException -> 0x0127 }
            android.view.View r3 = r3.findViewById(r7)     // Catch:{ Exception | ParseException -> 0x0127 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception | ParseException -> 0x0127 }
            android.content.Context r7 = r11.f60233f     // Catch:{ Exception | ParseException -> 0x0127 }
            int r8 = net.one97.paytm.recharge.R.string.automatic_subscription_late_payment_failed_msg     // Catch:{ Exception | ParseException -> 0x0127 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ Exception | ParseException -> 0x0127 }
            java.lang.String r10 = r1.getLastBillPaidAmount()     // Catch:{ Exception | ParseException -> 0x0127 }
            java.lang.String r10 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r10, (boolean) r2)     // Catch:{ Exception | ParseException -> 0x0127 }
            r9[r13] = r10     // Catch:{ Exception | ParseException -> 0x0127 }
            r9[r2] = r5     // Catch:{ Exception | ParseException -> 0x0127 }
            java.lang.String r7 = r7.getString(r8, r9)     // Catch:{ Exception | ParseException -> 0x0127 }
            r3.setText(r7)     // Catch:{ Exception | ParseException -> 0x0127 }
            return
        L_0x0127:
            goto L_0x012a
        L_0x0129:
            r5 = r4
        L_0x012a:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 != 0) goto L_0x0153
            android.view.View r12 = r12.itemView
            int r3 = net.one97.paytm.recharge.R.id.txt_last_bill_paid
            android.view.View r12 = r12.findViewById(r3)
            android.widget.TextView r12 = (android.widget.TextView) r12
            android.content.Context r3 = r11.f60233f
            int r7 = net.one97.paytm.recharge.R.string.automatic_subscription_payment_failed_msg
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r8 = r1.getLastBillPaidAmount()
            java.lang.String r8 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r8, (boolean) r2)
            r6[r13] = r8
            r6[r2] = r5
            java.lang.String r13 = r3.getString(r7, r6)
            r12.setText(r13)
        L_0x0153:
            com.squareup.picasso.w r12 = com.squareup.picasso.w.a()
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel r13 = r1.getProduct()
            java.lang.String r13 = r13.getThumbnail()
            com.squareup.picasso.aa r12 = r12.a((java.lang.String) r13)
            android.view.View r13 = r0.getRoot()
            int r0 = net.one97.paytm.recharge.R.id.icon
            android.view.View r13 = r13.findViewById(r0)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            r12.a((android.widget.ImageView) r13, (com.squareup.picasso.e) r4)
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.automatic.a.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public b(Context context, List<CJRAutomaticSubscriptionItemModel> list, AdapterView.OnItemClickListener onItemClickListener) {
        this.f60233f = context;
        this.f60234g = list;
        this.f60228a = onItemClickListener;
    }

    public final int getItemViewType(int i2) {
        if (i2 == this.f60234g.size()) {
            return 4;
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f60234g.get(i2);
        if (!(cJRAutomaticSubscriptionItemModel.getDueDate() == null || cJRAutomaticSubscriptionItemModel.getPaymentDate() == null || TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel.getDueAmt()))) {
            d dVar = d.f64967a;
            if (d.g(cJRAutomaticSubscriptionItemModel.getDueAmt())) {
                return 2;
            }
        }
        return cJRAutomaticSubscriptionItemModel.getHistory().size() == 0 ? 1 : 3;
    }

    public final int getItemCount() {
        return this.f60234g.size() + 1;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = R.layout.utility_automatic_list_item_to_be_generated;
        } else if (i2 == 2) {
            i3 = R.layout.utility_automatic_list_item_due_date;
        } else if (i2 != 3) {
            i3 = i2 != 4 ? 0 : R.layout.utility_automatic_list_item_add_new;
        } else {
            i3 = R.layout.utility_automatic_list_item_last_bill_paid;
        }
        return new a(f.a(LayoutInflater.from(this.f60233f), i3, viewGroup, false)) {
            /* access modifiers changed from: private */
            public /* synthetic */ void a(View view) {
                if (b.this.f60228a != null) {
                    b.this.f60228a.onItemClick((AdapterView) null, (View) null, getAdapterPosition(), 0);
                }
            }

            /* access modifiers changed from: protected */
            public final void a() {
                this.f60227a.getRoot().setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        b.AnonymousClass1.this.a(view);
                    }
                });
            }
        };
    }
}
