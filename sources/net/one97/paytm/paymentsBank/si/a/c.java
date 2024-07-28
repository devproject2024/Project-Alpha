package net.one97.paytm.paymentsBank.si.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.si.response.SITransactionListResponse;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<SITransactionListResponse.Transaction> f18796a;

    /* renamed from: b  reason: collision with root package name */
    private Context f18797b;

    /* renamed from: c  reason: collision with root package name */
    private d f18798c;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053 A[Catch:{ Exception -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a A[Catch:{ Exception -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r13, int r14) {
        /*
            r12 = this;
            java.lang.String r0 = ""
            net.one97.paytm.paymentsBank.si.a.c$a r13 = (net.one97.paytm.paymentsBank.si.a.c.a) r13
            java.util.ArrayList<net.one97.paytm.paymentsBank.si.response.SITransactionListResponse$Transaction> r1 = r12.f18796a
            java.lang.Object r1 = r1.get(r14)
            net.one97.paytm.paymentsBank.si.response.SITransactionListResponse$Transaction r1 = (net.one97.paytm.paymentsBank.si.response.SITransactionListResponse.Transaction) r1
            android.widget.TextView r2 = r13.f18800b
            long r3 = r1.getDate()
            java.lang.String r5 = "dd MMM, yyyy"
            java.lang.String r3 = a(r5, r3)
            r2.setText(r3)
            android.content.Context r2 = r12.f18797b
            int r3 = net.one97.paytm.paymentsBank.R.string.rs_str
            java.lang.String r2 = r2.getString(r3)
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Double r5 = r1.getAmount()
            java.lang.String r5 = r5.toString()
            r6 = 0
            r4[r6] = r5
            java.lang.String r2 = java.lang.String.format(r2, r4)
            android.widget.TextView r4 = r13.f18799a
            r5 = 0
            android.graphics.Typeface r7 = r4.getTypeface()     // Catch:{ Exception -> 0x00a7 }
            if (r7 == 0) goto L_0x0047
            android.graphics.Typeface r7 = r4.getTypeface()     // Catch:{ Exception -> 0x00a7 }
            if (r7 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r7 = r5
            goto L_0x004d
        L_0x0047:
            java.lang.String r7 = "sans-serif-medium"
            android.graphics.Typeface r7 = android.graphics.Typeface.create(r7, r3)     // Catch:{ Exception -> 0x00a7 }
        L_0x004d:
            android.graphics.Typeface r8 = r4.getTypeface()     // Catch:{ Exception -> 0x00a7 }
            if (r8 == 0) goto L_0x005c
            android.graphics.Typeface r8 = r4.getTypeface()     // Catch:{ Exception -> 0x00a7 }
            if (r8 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r8 = r5
            goto L_0x0062
        L_0x005c:
            java.lang.String r8 = "sans-serif-light"
            android.graphics.Typeface r8 = android.graphics.Typeface.create(r8, r6)     // Catch:{ Exception -> 0x00a7 }
        L_0x0062:
            java.lang.String r9 = "\\."
            java.lang.String[] r9 = r2.split(r9)     // Catch:{ Exception -> 0x00a7 }
            if (r9 == 0) goto L_0x00a8
            int r10 = r9.length     // Catch:{ Exception -> 0x00a7 }
            if (r10 > 0) goto L_0x006e
            goto L_0x00a8
        L_0x006e:
            r10 = r9[r6]     // Catch:{ Exception -> 0x00a7 }
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a7 }
            int r9 = r9.length     // Catch:{ Exception -> 0x00a7 }
            if (r9 != r3) goto L_0x0088
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r9.<init>()     // Catch:{ Exception -> 0x00a7 }
            r9.append(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = ".00"
            r9.append(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x00a7 }
        L_0x0088:
            int r9 = r2.length()     // Catch:{ Exception -> 0x00a7 }
            android.text.SpannableStringBuilder r11 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x00a7 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x00a7 }
            com.paytm.utility.CustomTypefaceSpan r2 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00a7 }
            r2.<init>(r0, r7)     // Catch:{ Exception -> 0x00a7 }
            r7 = 34
            r11.setSpan(r2, r6, r10, r7)     // Catch:{ Exception -> 0x00a7 }
            com.paytm.utility.CustomTypefaceSpan r2 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00a7 }
            r2.<init>(r0, r8)     // Catch:{ Exception -> 0x00a7 }
            r11.setSpan(r2, r10, r9, r7)     // Catch:{ Exception -> 0x00a7 }
            r4.setText(r11)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00a8
        L_0x00a7:
        L_0x00a8:
            java.lang.String r2 = r1.getStatus()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x012a
            java.lang.String r0 = r1.getStatus()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r0.substring(r6, r3)
            java.lang.String r4 = r4.toUpperCase()
            r2.append(r4)
            java.lang.String r0 = r0.substring(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.widget.TextView r2 = r13.f18801c
            r2.setText(r0)
            java.lang.String r0 = r1.getStatus()
            java.lang.String r2 = "success"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00f0
            android.widget.TextView r13 = r13.f18801c
            android.content.Context r0 = r12.f18797b
            int r1 = net.one97.paytm.common.assets.R.color.color_009453
            int r0 = androidx.core.content.b.c(r0, r1)
            r13.setTextColor(r0)
            goto L_0x0117
        L_0x00f0:
            java.lang.String r0 = r1.getStatus()
            java.lang.String r1 = "failure"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x010a
            android.widget.TextView r13 = r13.f18801c
            android.content.Context r0 = r12.f18797b
            int r1 = net.one97.paytm.common.assets.R.color.color_fc3507
            int r0 = androidx.core.content.b.c(r0, r1)
            r13.setTextColor(r0)
            goto L_0x0117
        L_0x010a:
            android.widget.TextView r13 = r13.f18801c
            android.content.Context r0 = r12.f18797b
            int r1 = net.one97.paytm.common.assets.R.color.color_ffa400
            int r0 = androidx.core.content.b.c(r0, r1)
            r13.setTextColor(r0)
        L_0x0117:
            java.util.ArrayList<net.one97.paytm.paymentsBank.si.response.SITransactionListResponse$Transaction> r13 = r12.f18796a
            int r13 = r13.size()
            int r13 = r13 - r3
            if (r14 != r13) goto L_0x0129
            net.one97.paytm.bankCommon.f.d r13 = r12.f18798c
            if (r13 == 0) goto L_0x0129
            r14 = 123(0x7b, float:1.72E-43)
            r13.onFragmentAction(r14, r5)
        L_0x0129:
            return
        L_0x012a:
            android.widget.TextView r13 = r13.f18801c
            r13.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.si.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public c(Context context, ArrayList<SITransactionListResponse.Transaction> arrayList) {
        this.f18797b = context;
        this.f18796a = arrayList;
    }

    private static String a(String str, long j) {
        try {
            return new SimpleDateFormat(str).format(new Date(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public final int getItemCount() {
        ArrayList<SITransactionListResponse.Transaction> arrayList = this.f18796a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f18799a;

        /* renamed from: b  reason: collision with root package name */
        TextView f18800b;

        /* renamed from: c  reason: collision with root package name */
        TextView f18801c;

        public a(View view) {
            super(view);
            this.f18799a = (TextView) view.findViewById(R.id.transactionAmountTv);
            this.f18800b = (TextView) view.findViewById(R.id.transactionDateTv);
            this.f18801c = (TextView) view.findViewById(R.id.transactionStatusTv);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f18797b).inflate(R.layout.si_transaction_history_list_item, (ViewGroup) null));
    }
}
