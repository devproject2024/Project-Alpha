package net.one97.paytm.passbook.transactionDetail.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.transactionDetail.c.e;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRTransaction> f59019a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    e.a f59020b;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0059 A[Catch:{ Exception -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            net.one97.paytm.passbook.transactionDetail.a.c$a r10 = (net.one97.paytm.passbook.transactionDetail.a.c.a) r10
            java.util.ArrayList<net.one97.paytm.passbook.beans.CJRTransaction> r1 = r9.f59019a
            java.lang.Object r11 = r1.get(r11)
            net.one97.paytm.passbook.beans.CJRTransaction r11 = (net.one97.paytm.passbook.beans.CJRTransaction) r11
            android.widget.TextView r1 = r10.f59021a
            java.lang.String r2 = r11.getNarration()
            r1.setText(r2)
            java.lang.String r1 = r11.getTxnAmount()
            java.lang.String r1 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r1)
            android.view.View r2 = r10.itemView
            android.content.Context r2 = r2.getContext()
            int r3 = net.one97.paytm.passbook.R.string.recharge_rs
            java.lang.String r2 = r2.getString(r3)
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r1
            java.lang.String r1 = java.lang.String.format(r2, r4)
            android.widget.TextView r2 = r10.f59024d
            android.graphics.Typeface r4 = r2.getTypeface()     // Catch:{ Exception -> 0x0082 }
            r6 = 0
            if (r4 == 0) goto L_0x0045
            android.graphics.Typeface r4 = r2.getTypeface()     // Catch:{ Exception -> 0x0082 }
            if (r4 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r3 = r6
            goto L_0x0051
        L_0x0045:
            java.lang.String r4 = "sans-serif-light"
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r4, r5)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r4 = "sans-serif-medium"
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r4, r3)     // Catch:{ Exception -> 0x0082 }
        L_0x0051:
            java.lang.String r4 = " "
            java.lang.String[] r4 = r1.split(r4)     // Catch:{ Exception -> 0x0082 }
            if (r4 == 0) goto L_0x0083
            int r7 = r4.length     // Catch:{ Exception -> 0x0082 }
            if (r7 > 0) goto L_0x005d
            goto L_0x0083
        L_0x005d:
            r4 = r4[r5]     // Catch:{ Exception -> 0x0082 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x0082 }
            int r7 = r1.length()     // Catch:{ Exception -> 0x0082 }
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x0082 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0082 }
            com.paytm.utility.CustomTypefaceSpan r1 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x0082 }
            r1.<init>(r0, r6)     // Catch:{ Exception -> 0x0082 }
            r6 = 34
            r8.setSpan(r1, r5, r4, r6)     // Catch:{ Exception -> 0x0082 }
            com.paytm.utility.CustomTypefaceSpan r1 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x0082 }
            r1.<init>(r0, r3)     // Catch:{ Exception -> 0x0082 }
            r8.setSpan(r1, r4, r7, r6)     // Catch:{ Exception -> 0x0082 }
            r2.setText(r8)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0083
        L_0x0082:
        L_0x0083:
            java.lang.String r0 = r11.getTxnDate()
            java.lang.String r1 = "yyyy-MM-dd hh:mm:ss"
            java.lang.String r2 = "dd MMM,"
            java.lang.String r0 = net.one97.paytm.passbook.transactionDetail.a.c.a.a(r0, r1, r2)
            android.widget.TextView r1 = r10.f59022b
            r1.setText(r0)
            java.lang.String r0 = r11.getTxnDate()
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r2 = "hh:mm a"
            java.lang.String r0 = net.one97.paytm.passbook.transactionDetail.a.c.a.a(r0, r1, r2)
            android.widget.TextView r1 = r10.f59023c
            r1.setText(r0)
            android.widget.TextView r0 = r10.f59025e
            java.lang.String r1 = r11.getTxnStatus()
            java.lang.String r2 = "FAILURE"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00b6
            goto L_0x00b8
        L_0x00b6:
            r5 = 8
        L_0x00b8:
            r0.setVisibility(r5)
            android.view.View r0 = r10.itemView
            net.one97.paytm.passbook.transactionDetail.a.c$a$1 r1 = new net.one97.paytm.passbook.transactionDetail.a.c$a$1
            r1.<init>(r11)
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public c(e.a aVar) {
        this.f59020b = aVar;
    }

    public final int getItemCount() {
        ArrayList<CJRTransaction> arrayList = this.f59019a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f59021a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f59022b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f59023c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f59024d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f59025e;

        public a(View view) {
            super(view);
            this.f59021a = (TextView) view.findViewById(R.id.title_tv);
            this.f59022b = (TextView) view.findViewById(R.id.date_tv);
            this.f59023c = (TextView) view.findViewById(R.id.time_tv);
            this.f59024d = (TextView) view.findViewById(R.id.amount_tv);
            this.f59025e = (TextView) view.findViewById(R.id.failed_tv);
        }

        public static String a(String str, String str2, String str3) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
            try {
                return new SimpleDateFormat(str3).format(simpleDateFormat.parse(str));
            } catch (ParseException unused) {
                return "";
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_item_transaction_recent_history, (ViewGroup) null));
    }
}
