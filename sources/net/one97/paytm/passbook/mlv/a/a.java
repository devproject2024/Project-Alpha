package net.one97.paytm.passbook.mlv.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<MLVAccountTransactionInfo> f57996a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public b f57997b;

    /* renamed from: c  reason: collision with root package name */
    final UserMLVTemplateDetail f57998c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f57999d;

    /* renamed from: e  reason: collision with root package name */
    private final int f58000e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final int f58001f = 2;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.passbook.mgv.a.a f58002g;

    public interface b {
        void a(int i2);
    }

    public a(net.one97.paytm.passbook.mgv.a.a aVar, UserMLVTemplateDetail userMLVTemplateDetail) {
        k.c(aVar, "listener");
        this.f58002g = aVar;
        this.f57998c = userMLVTemplateDetail;
    }

    public final int getItemCount() {
        if (this.f57996a.size() != 0 || !this.f57999d) {
            return this.f57996a.size();
        }
        return 1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0086, code lost:
        r8 = r5.getChangeAmount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01a1, code lost:
        if (r11.equals("PAY") != false) goto L_0x0292;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0290, code lost:
        if (r11.equals("REDEEM") != false) goto L_0x0292;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0292, code lost:
        ((android.widget.TextView) r6.findViewById(net.one97.paytm.passbook.R.id.amountTv)).setTextColor(androidx.core.content.b.c(r12, net.one97.paytm.passbook.R.color.color_1d252d));
        r4 = (android.widget.TextView) r6.findViewById(net.one97.paytm.passbook.R.id.title1);
        kotlin.g.b.k.a((java.lang.Object) r4, "itemView.title1");
        r4.setText(r12.getText(net.one97.paytm.passbook.R.string.paid_for_order_new));
        r4 = (android.widget.TextView) r6.findViewById(net.one97.paytm.passbook.R.id.amountTv);
        kotlin.g.b.k.a((java.lang.Object) r4, "itemView.amountTv");
        r4.setText(r12.getString(net.one97.paytm.passbook.R.string.minus_amount, new java.lang.Object[]{r8}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x02d8, code lost:
        if (r4 == null) goto L_0x02da;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "holder"
            kotlin.g.b.k.c(r1, r3)
            boolean r3 = r1 instanceof net.one97.paytm.passbook.mlv.a.a.c
            r4 = 1
            if (r3 == 0) goto L_0x030b
            r3 = r1
            net.one97.paytm.passbook.mlv.a.a$c r3 = (net.one97.paytm.passbook.mlv.a.a.c) r3
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo> r5 = r0.f57996a
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo r5 = (net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo) r5
            int r6 = r3.getAdapterPosition()
            r7 = 8
            java.lang.String r8 = "itemView.line1"
            java.lang.String r9 = "itemView"
            r10 = 0
            if (r6 != 0) goto L_0x003a
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            int r11 = net.one97.paytm.passbook.R.id.line1
            android.view.View r6 = r6.findViewById(r11)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            r6.setVisibility(r7)
            goto L_0x004b
        L_0x003a:
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            int r11 = net.one97.paytm.passbook.R.id.line1
            android.view.View r6 = r6.findViewById(r11)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            r6.setVisibility(r10)
        L_0x004b:
            int r6 = r3.getAdapterPosition()
            net.one97.paytm.passbook.mlv.a.a r8 = r3.f58004a
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo> r8 = r8.f57996a
            int r8 = r8.size()
            int r8 = r8 - r4
            java.lang.String r11 = "itemView.line2"
            if (r6 != r8) goto L_0x006e
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            int r8 = net.one97.paytm.passbook.R.id.line2
            android.view.View r6 = r6.findViewById(r8)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r11)
            r6.setVisibility(r7)
            goto L_0x007f
        L_0x006e:
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            int r7 = net.one97.paytm.passbook.R.id.line2
            android.view.View r6 = r6.findViewById(r7)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r11)
            r6.setVisibility(r10)
        L_0x007f:
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            if (r5 == 0) goto L_0x0091
            net.one97.paytm.passbook.beans.mgv.MGVAmount r8 = r5.getChangeAmount()
            if (r8 == 0) goto L_0x0091
            java.lang.String r8 = r8.getAmount()
            goto L_0x0092
        L_0x0091:
            r8 = 0
        L_0x0092:
            java.lang.String r8 = net.one97.paytm.passbook.utility.c.b((java.lang.String) r8)
            android.content.Context r11 = r6.getContext()
            int r12 = net.one97.paytm.passbook.R.string.rs_balance_without_space
            java.lang.Object[] r13 = new java.lang.Object[r4]
            r13[r10] = r8
            java.lang.String r8 = r11.getString(r12, r13)
            if (r5 == 0) goto L_0x00ab
            java.lang.String r11 = r5.getTransactionType()
            goto L_0x00ac
        L_0x00ab:
            r11 = 0
        L_0x00ac:
            android.content.Context r12 = r6.getContext()
            if (r11 == 0) goto L_0x02d2
            int r13 = r11.hashCode()
            java.lang.String r14 = "java.lang.String.format(format, *args)"
            java.lang.String r15 = "itemView.amountTv"
            java.lang.String r7 = "itemView.title1"
            switch(r13) {
                case -1881559652: goto L_0x028a;
                case -1881484424: goto L_0x021d;
                case -1880997073: goto L_0x01a5;
                case 78984: goto L_0x019b;
                case 1817829058: goto L_0x012e;
                case 2059137311: goto L_0x00c1;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            goto L_0x02d2
        L_0x00c1:
            java.lang.String r13 = "EXPIRE"
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x02d2
            int r11 = net.one97.paytm.passbook.R.id.title1
            android.view.View r11 = r6.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            kotlin.g.b.aa r7 = kotlin.g.b.aa.f47921a
            int r7 = net.one97.paytm.passbook.R.string.loyality_cash_expired
            java.lang.String r7 = r12.getString(r7)
            java.lang.String r13 = "context.getString(R.string.loyality_cash_expired)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r13)
            java.lang.Object[] r13 = new java.lang.Object[r4]
            net.one97.paytm.passbook.mlv.d.a$a r17 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.mlv.a.a r4 = r3.f58004a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r4 = r4.f57998c
            if (r4 == 0) goto L_0x00f2
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r4 = r4.getMlvCardTemplate()
            r16 = r4
            goto L_0x00f4
        L_0x00f2:
            r16 = 0
        L_0x00f4:
            java.lang.String r4 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r16)
            r13[r10] = r4
            r4 = 1
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r13, r4)
            java.lang.String r4 = java.lang.String.format(r7, r10)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r14)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11.setText(r4)
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r15)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r6 = net.one97.paytm.passbook.R.color.color_8ba6c1
            int r6 = androidx.core.content.b.c(r12, r6)
            r4.setTextColor(r6)
            goto L_0x02d2
        L_0x012e:
            java.lang.String r4 = "REVERSE"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x02d2
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r15)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r8 = net.one97.paytm.passbook.R.color.color_1d252d
            int r8 = androidx.core.content.b.c(r12, r8)
            r4.setTextColor(r8)
            int r4 = net.one97.paytm.passbook.R.id.title1
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            kotlin.g.b.aa r6 = kotlin.g.b.aa.f47921a
            int r6 = net.one97.paytm.passbook.R.string.loyality_cash_reversed
            java.lang.String r6 = r12.getString(r6)
            java.lang.String r7 = "context.getString(R.string.loyality_cash_reversed)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            net.one97.paytm.passbook.mlv.d.a$a r11 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.mlv.a.a r11 = r3.f58004a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r11 = r11.f57998c
            if (r11 == 0) goto L_0x0181
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r11 = r11.getMlvCardTemplate()
            r16 = r11
            goto L_0x0183
        L_0x0181:
            r16 = 0
        L_0x0183:
            java.lang.String r11 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r16)
            r8[r10] = r11
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r7)
            java.lang.String r6 = java.lang.String.format(r6, r8)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r14)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            goto L_0x02d2
        L_0x019b:
            java.lang.String r4 = "PAY"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x02d2
            goto L_0x0292
        L_0x01a5:
            java.lang.String r4 = "REWARD"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x02d2
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r11 = net.one97.paytm.passbook.R.color.color_26d07c
            int r11 = androidx.core.content.b.c(r12, r11)
            r4.setTextColor(r11)
            int r4 = net.one97.paytm.passbook.R.id.title1
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            kotlin.g.b.aa r7 = kotlin.g.b.aa.f47921a
            int r7 = net.one97.paytm.passbook.R.string.loyality_cash_earned_unformatted
            java.lang.String r7 = r12.getString(r7)
            java.lang.String r11 = "context.getString(R.stri…_cash_earned_unformatted)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            r11 = 1
            java.lang.Object[] r13 = new java.lang.Object[r11]
            net.one97.paytm.passbook.mlv.d.a$a r17 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.mlv.a.a r11 = r3.f58004a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r11 = r11.f57998c
            if (r11 == 0) goto L_0x01e8
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r11 = r11.getMlvCardTemplate()
            r16 = r11
            goto L_0x01ea
        L_0x01e8:
            r16 = 0
        L_0x01ea:
            java.lang.String r11 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r16)
            r13[r10] = r11
            r11 = 1
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r11)
            java.lang.String r7 = java.lang.String.format(r7, r13)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r14)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r15)
            int r6 = net.one97.paytm.passbook.R.string.plus_amount
            java.lang.Object[] r7 = new java.lang.Object[r11]
            r7[r10] = r8
            java.lang.String r6 = r12.getString(r6, r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            goto L_0x02d2
        L_0x021d:
            java.lang.String r4 = "REFUND"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x02d2
            int r4 = net.one97.paytm.passbook.R.id.title1
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            kotlin.g.b.aa r7 = kotlin.g.b.aa.f47921a
            int r7 = net.one97.paytm.passbook.R.string.loyality_cash_refunded
            java.lang.String r7 = r12.getString(r7)
            java.lang.String r11 = "context.getString(R.string.loyality_cash_refunded)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            r11 = 1
            java.lang.Object[] r13 = new java.lang.Object[r11]
            net.one97.paytm.passbook.mlv.d.a$a r17 = net.one97.paytm.passbook.mlv.d.a.f58098a
            net.one97.paytm.passbook.mlv.a.a r11 = r3.f58004a
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r11 = r11.f57998c
            if (r11 == 0) goto L_0x024f
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r11 = r11.getMlvCardTemplate()
            r16 = r11
            goto L_0x0251
        L_0x024f:
            r16 = 0
        L_0x0251:
            java.lang.String r11 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r16)
            r13[r10] = r11
            r10 = 1
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r13, r10)
            java.lang.String r7 = java.lang.String.format(r7, r11)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r14)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r15)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r6 = net.one97.paytm.passbook.R.color.color_1d252d
            int r6 = androidx.core.content.b.c(r12, r6)
            r4.setTextColor(r6)
            goto L_0x02d2
        L_0x028a:
            java.lang.String r4 = "REDEEM"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x02d2
        L_0x0292:
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r11 = net.one97.paytm.passbook.R.color.color_1d252d
            int r11 = androidx.core.content.b.c(r12, r11)
            r4.setTextColor(r11)
            int r4 = net.one97.paytm.passbook.R.id.title1
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            int r7 = net.one97.paytm.passbook.R.string.paid_for_order_new
            java.lang.CharSequence r7 = r12.getText(r7)
            r4.setText(r7)
            int r4 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r4 = r6.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r15)
            int r6 = net.one97.paytm.passbook.R.string.minus_amount
            r7 = 1
            java.lang.Object[] r11 = new java.lang.Object[r7]
            r11[r10] = r8
            java.lang.String r6 = r12.getString(r6, r11)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
        L_0x02d2:
            if (r5 == 0) goto L_0x02da
            java.lang.String r4 = r5.getAccountingTimestamp()     // Catch:{ ParseException -> 0x02ff }
            if (r4 != 0) goto L_0x02dc
        L_0x02da:
            java.lang.String r4 = ""
        L_0x02dc:
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            long r4 = net.one97.paytm.passbook.mapping.a.j(r4, r5)     // Catch:{ ParseException -> 0x02ff }
            java.lang.String r6 = "dd MMM yyyy, hh:mm a"
            java.lang.String r4 = net.one97.paytm.passbook.mapping.a.a(r4, r6)     // Catch:{ ParseException -> 0x02ff }
            android.view.View r3 = r3.itemView     // Catch:{ ParseException -> 0x02ff }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r9)     // Catch:{ ParseException -> 0x02ff }
            int r5 = net.one97.paytm.passbook.R.id.dateTv     // Catch:{ ParseException -> 0x02ff }
            android.view.View r3 = r3.findViewById(r5)     // Catch:{ ParseException -> 0x02ff }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ ParseException -> 0x02ff }
            java.lang.String r5 = "itemView.dateTv"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ ParseException -> 0x02ff }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ ParseException -> 0x02ff }
            r3.setText(r4)     // Catch:{ ParseException -> 0x02ff }
        L_0x02ff:
            android.view.View r1 = r1.itemView
            net.one97.paytm.passbook.mlv.a.a$d r3 = new net.one97.paytm.passbook.mlv.a.a$d
            r3.<init>(r0, r2)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x030b:
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo> r1 = r0.f57996a
            int r1 = r1.size()
            r3 = 1
            int r1 = r1 - r3
            if (r2 != r1) goto L_0x031c
            if (r2 == 0) goto L_0x031c
            net.one97.paytm.passbook.mgv.a.a r1 = r0.f58002g
            r1.b()
        L_0x031c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mlv.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58005a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58006b;

        d(a aVar, int i2) {
            this.f58005a = aVar;
            this.f58006b = i2;
        }

        public final void onClick(View view) {
            b bVar = this.f58005a.f57997b;
            if (bVar != null) {
                bVar.a(this.f58006b);
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f58000e) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_mlv_transaction_item, viewGroup, false);
            k.a((Object) inflate, "view");
            return new c(this, inflate);
        } else if (i2 == this.f58001f) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_layout_mgv_no_data, viewGroup, false);
            k.a((Object) inflate2, "view");
            return new C1103a(this, inflate2);
        } else {
            throw new RuntimeException("Invalid view type");
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58004a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f58004a = aVar;
        }
    }

    public final void a(ArrayList<MLVAccountTransactionInfo> arrayList) {
        k.c(arrayList, "transactionList");
        this.f57996a = arrayList;
        notifyDataSetChanged();
    }

    /* renamed from: net.one97.paytm.passbook.mlv.a.a$a  reason: collision with other inner class name */
    public final class C1103a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58003a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1103a(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f58003a = aVar;
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f57999d) {
            return this.f58001f;
        }
        return this.f58000e;
    }
}
