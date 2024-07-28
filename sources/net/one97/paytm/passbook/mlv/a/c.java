package net.one97.paytm.passbook.mlv.a;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<MLVUserCardDetail> f58024a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public b f58025b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f58026c;

    /* renamed from: d  reason: collision with root package name */
    private final int f58027d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f58028e = 2;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.passbook.mgv.a.a f58029f;

    public interface b {
        void b(int i2);
    }

    public c(net.one97.paytm.passbook.mgv.a.a aVar) {
        k.c(aVar, "listener");
        this.f58029f = aVar;
    }

    public final int getItemCount() {
        if (this.f58024a.size() != 0 || !this.f58026c) {
            return this.f58024a.size();
        }
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00aa, code lost:
        if (r9 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007a, code lost:
        r16 = r7.getTotalAmount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r23, int r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "d MMM yyyy"
            java.lang.String r4 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r5 = "holder"
            kotlin.g.b.k.c(r1, r5)
            boolean r5 = r1 instanceof net.one97.paytm.passbook.mlv.a.c.C1105c
            r6 = 1
            if (r5 == 0) goto L_0x02f9
            r5 = r1
            net.one97.paytm.passbook.mlv.a.c$c r5 = (net.one97.paytm.passbook.mlv.a.c.C1105c) r5
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail> r7 = r0.f58024a
            java.lang.Object r7 = r7.get(r2)
            net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail r7 = (net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail) r7
            int r8 = r5.getAdapterPosition()
            net.one97.paytm.passbook.mlv.a.c r9 = r5.f58031a
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail> r9 = r9.f58024a
            int r9 = r9.size()
            int r9 = r9 - r6
            java.lang.String r10 = "itemView.seprator_view"
            r11 = 8
            java.lang.String r12 = "itemView"
            r13 = 0
            if (r8 != r9) goto L_0x0047
            android.view.View r8 = r5.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r12)
            int r9 = net.one97.paytm.passbook.R.id.seprator_view
            android.view.View r8 = r8.findViewById(r9)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            r8.setVisibility(r11)
            goto L_0x0058
        L_0x0047:
            android.view.View r8 = r5.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r12)
            int r9 = net.one97.paytm.passbook.R.id.seprator_view
            android.view.View r8 = r8.findViewById(r9)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            r8.setVisibility(r13)
        L_0x0058:
            android.view.View r8 = r5.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r12)
            int r9 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "itemView.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            android.view.View r9 = r5.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r12)
            android.content.Context r9 = r9.getContext()
            int r10 = net.one97.paytm.passbook.R.string.rs_balance_without_space
            java.lang.Object[] r14 = new java.lang.Object[r6]
            r15 = 0
            if (r7 == 0) goto L_0x0085
            net.one97.paytm.passbook.beans.mlv.MLVAmount r16 = r7.getTotalAmount()
            if (r16 == 0) goto L_0x0085
            java.lang.String r16 = r16.getAmount()
            goto L_0x0087
        L_0x0085:
            r16 = r15
        L_0x0087:
            java.lang.String r16 = net.one97.paytm.passbook.utility.c.b((java.lang.String) r16)
            r14[r13] = r16
            java.lang.String r9 = r9.getString(r10, r14)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            if (r7 == 0) goto L_0x00a2
            net.one97.paytm.passbook.beans.mlv.MLVAmount r8 = r7.getAvailableAmount()
            if (r8 == 0) goto L_0x00a2
            java.lang.String r15 = r8.getAmount()
        L_0x00a2:
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x00ac
            java.lang.String r9 = r7.getExpiredTime()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r9 != 0) goto L_0x00ad
        L_0x00ac:
            r9 = r8
        L_0x00ad:
            long r9 = net.one97.paytm.passbook.mapping.a.j(r9, r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r7 == 0) goto L_0x00b9
            java.lang.String r7 = r7.getCreateTime()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r7 != 0) goto L_0x00ba
        L_0x00b9:
            r7 = r8
        L_0x00ba:
            long r7 = net.one97.paytm.passbook.mapping.a.j(r7, r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r5.itemView     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r12)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.content.Context r4 = r4.getContext()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r14 = "itemView.context"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r14)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r14 = r5.itemView     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r12)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r16 = net.one97.paytm.passbook.mapping.a.a(r9, r3)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r19 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r19 <= 0) goto L_0x010a
            int r9 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r9 = r14.findViewById(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r9 == 0) goto L_0x00ea
            r9.setVisibility(r13)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x00ea:
            int r9 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r9 = r14.findViewById(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r9 == 0) goto L_0x0103
            int r10 = net.one97.paytm.passbook.R.string.expired_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r11[r13] = r16     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r4 = r4.getString(r10, r11)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r9.setText(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x0103:
            net.one97.paytm.passbook.mlv.a.c.C1105c.a(r6, r14)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x0106:
            r20 = r7
            goto L_0x02bb
        L_0x010a:
            net.one97.paytm.passbook.mlv.a.c.C1105c.a(r13, r14)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            boolean r16 = android.text.format.DateUtils.isToday(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r17 = 0
            if (r16 == 0) goto L_0x0186
            r9 = r15
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r9 != 0) goto L_0x0167
            if (r15 == 0) goto L_0x0125
            long r9 = java.lang.Long.parseLong(r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x0127
        L_0x0125:
            r9 = r17
        L_0x0127:
            int r16 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r16 <= 0) goto L_0x0167
            android.content.Context r9 = r14.getContext()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r10 = net.one97.paytm.passbook.R.string.rs_balance_without_space     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r15 = net.one97.paytm.passbook.utility.c.b((java.lang.String) r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r11[r13] = r15     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r9 = r9.getString(r10, r11)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r10 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r10 = r14.findViewById(r10)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r10 == 0) goto L_0x014a
            r10.setVisibility(r13)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x014a:
            int r10 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r10 = r14.findViewById(r10)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r10 == 0) goto L_0x0163
            int r11 = net.one97.paytm.passbook.R.string.amount__expires_today     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.Object[] r15 = new java.lang.Object[r6]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r15[r13] = r9     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r4 = r4.getString(r11, r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r10.setText(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x0163:
            net.one97.paytm.passbook.mlv.a.c.C1105c.a(r13, r14)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x0174
        L_0x0167:
            int r4 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r14.findViewById(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r4 == 0) goto L_0x0174
            r4.setVisibility(r11)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x0174:
            int r4 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r14.findViewById(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r9 = "#fd5c5c"
            int r9 = android.graphics.Color.parseColor(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r4.setTextColor(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x0106
        L_0x0186:
            java.util.Calendar r11 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r13 = "cal"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r13)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r11.setTimeInMillis(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r9 = 11
            r10 = 23
            r11.set(r9, r10)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r9 = 12
            r10 = 59
            r11.set(r9, r10)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r9 = 13
            r11.set(r9, r10)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            long r9 = r11.getTimeInMillis()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            long r20 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            long r9 = r9 - r20
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.DAYS     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r20 = r7
            r6 = 1
            long r6 = r11.toMillis(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            long r9 = r9 / r6
            int r6 = (int) r9     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r7 = 1
            if (r6 != r7) goto L_0x0237
            r6 = r15
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r6 != 0) goto L_0x0211
            if (r15 == 0) goto L_0x01ce
            long r6 = java.lang.Long.parseLong(r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x01d0
        L_0x01ce:
            r6 = r17
        L_0x01d0:
            int r8 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x0211
            android.content.Context r6 = r14.getContext()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r7 = net.one97.paytm.passbook.R.string.rs_balance_without_space     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r8 = net.one97.paytm.passbook.utility.c.b((java.lang.String) r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r10 = 0
            r9[r10] = r8     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r6 = r6.getString(r7, r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r7 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r7 = r14.findViewById(r7)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r7 == 0) goto L_0x01f5
            r7.setVisibility(r10)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x01f5:
            int r7 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r7 = r14.findViewById(r7)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r7 == 0) goto L_0x0220
            int r8 = net.one97.paytm.passbook.R.string.amount__expires_tomorrow     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r9 = 0
            r10[r9] = r6     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r4 = r4.getString(r8, r10)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r7.setText(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x0220
        L_0x0211:
            int r4 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r14.findViewById(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r4 == 0) goto L_0x0220
            r6 = 8
            r4.setVisibility(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x0220:
            r4 = 0
            net.one97.paytm.passbook.mlv.a.c.C1105c.a(r4, r14)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r4 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r14.findViewById(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r6 = "#ffad00"
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r4.setTextColor(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x02bb
        L_0x0237:
            r7 = 7
            r8 = 2
            if (r8 <= r6) goto L_0x023d
            goto L_0x02ac
        L_0x023d:
            if (r7 < r6) goto L_0x02ac
            r7 = r15
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r7 != 0) goto L_0x0298
            if (r15 == 0) goto L_0x024f
            long r9 = java.lang.Long.parseLong(r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x0251
        L_0x024f:
            r9 = r17
        L_0x0251:
            int r7 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r7 <= 0) goto L_0x0298
            android.content.Context r7 = r14.getContext()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r9 = net.one97.paytm.passbook.R.string.rs_balance_without_space     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r10 = 1
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r10 = net.one97.paytm.passbook.utility.c.b((java.lang.String) r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r15 = 0
            r11[r15] = r10     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r7 = r7.getString(r9, r11)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r9 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r9 = r14.findViewById(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r9 == 0) goto L_0x0276
            r9.setVisibility(r15)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x0276:
            int r9 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r9 = r14.findViewById(r9)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r9 == 0) goto L_0x02a7
            int r10 = net.one97.paytm.passbook.R.string.amount_expires_in_days     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r11 = 0
            r8[r11] = r7     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r7 = 1
            r8[r7] = r6     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r4 = r4.getString(r10, r8)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r9.setText(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x02a7
        L_0x0298:
            int r4 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r14.findViewById(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r4 == 0) goto L_0x02a7
            r6 = 8
            r4.setVisibility(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x02a7:
            r4 = 0
            net.one97.paytm.passbook.mlv.a.c.C1105c.a(r4, r14)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            goto L_0x02bb
        L_0x02ac:
            int r4 = net.one97.paytm.passbook.R.id.tv_date_expire_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r14.findViewById(r4)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            if (r4 == 0) goto L_0x02bb
            r6 = 8
            r4.setVisibility(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x02bb:
            r6 = r20
            java.lang.String r3 = net.one97.paytm.passbook.mapping.a.a(r6, r3)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r5.itemView     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r12)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r6 = net.one97.paytm.passbook.R.id.tv_date_earned_text     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r4 = r4.findViewById(r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r6 = "itemView.tv_date_earned_text"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.view.View r5 = r5.itemView     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            android.content.Context r5 = r5.getContext()     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            int r6 = net.one97.paytm.passbook.R.string.earned_text_without_colon     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r7 = 0
            r8[r7] = r3     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.String r3 = r5.getString(r6, r8)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
            r4.setText(r3)     // Catch:{ NumberFormatException | ParseException -> 0x02ed }
        L_0x02ed:
            android.view.View r1 = r1.itemView
            net.one97.paytm.passbook.mlv.a.c$d r3 = new net.one97.paytm.passbook.mlv.a.c$d
            r3.<init>(r0, r2)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x02f9:
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail> r1 = r0.f58024a
            int r1 = r1.size()
            r3 = 1
            int r1 = r1 - r3
            if (r2 != r1) goto L_0x030a
            if (r2 == 0) goto L_0x030a
            net.one97.paytm.passbook.mgv.a.a r1 = r0.f58029f
            r1.b()
        L_0x030a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mlv.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58032a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58033b;

        d(c cVar, int i2) {
            this.f58032a = cVar;
            this.f58033b = i2;
        }

        public final void onClick(View view) {
            b bVar = this.f58032a.f58025b;
            if (bVar != null) {
                bVar.b(this.f58033b);
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f58027d) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_ml_adpater_row, viewGroup, false);
            k.a((Object) inflate, "view");
            return new C1105c(this, inflate);
        } else if (i2 == this.f58028e) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_layout_mgv_no_data, viewGroup, false);
            k.a((Object) inflate2, "view");
            return new a(this, inflate2);
        } else {
            throw new RuntimeException("Invalid view type");
        }
    }

    /* renamed from: net.one97.paytm.passbook.mlv.a.c$c  reason: collision with other inner class name */
    public final class C1105c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58031a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1105c(c cVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f58031a = cVar;
        }

        static void a(boolean z, View view) {
            if (z) {
                ((TextView) view.findViewById(R.id.tv_date_expire_text)).setTextColor(Color.parseColor("#501d252d"));
                ((TextView) view.findViewById(R.id.tv_date_earned_text)).setTextColor(Color.parseColor("#501d252d"));
                ((TextView) view.findViewById(R.id.tvAmount)).setTextColor(Color.parseColor("#501d252d"));
                ((TextView) view.findViewById(R.id.tv_date_expire_text)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.pass_mlv_txn_circle_disabled, 0, 0, 0);
                return;
            }
            ((TextView) view.findViewById(R.id.tv_date_expire_text)).setTextColor(Color.parseColor("#8ba6c1"));
            ((TextView) view.findViewById(R.id.tv_date_earned_text)).setTextColor(Color.parseColor("#8ba6c1"));
            ((TextView) view.findViewById(R.id.tvAmount)).setTextColor(Color.parseColor("#1d252d"));
            ((TextView) view.findViewById(R.id.tv_date_expire_text)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.pass_mgv_txn_circle, 0, 0, 0);
        }
    }

    public final void a(ArrayList<MLVUserCardDetail> arrayList) {
        k.c(arrayList, "cardList");
        this.f58024a.clear();
        this.f58024a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58030a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f58030a = cVar;
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f58026c) {
            return this.f58028e;
        }
        return this.f58027d;
    }
}
