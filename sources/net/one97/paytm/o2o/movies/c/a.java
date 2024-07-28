package net.one97.paytm.o2o.movies.c;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.d.i;
import net.one97.paytm.o2o.movies.d.j;

public final class a extends RecyclerView.v implements j {

    /* renamed from: a  reason: collision with root package name */
    i f74940a;

    /* renamed from: b  reason: collision with root package name */
    private Context f74941b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f74942c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f74943d;

    public a(Context context, View view, i iVar) {
        super(view);
        this.f74941b = context;
        this.f74940a = iVar;
        int g2 = b.g(this.f74941b);
        this.f74943d = (TextView) view.findViewById(R.id.paytm_contact_us);
        this.f74942c = (TextView) view.findViewById(R.id.paytm_trust_text);
        this.f74942c.setPadding(0, 0, g2, g2);
        this.f74942c.setTextSize(2, 11.0f);
        view.setPadding(0, 0, 0, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r2 = r3.getContactUsItem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r2, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2 r2 = r3.getContactUsItem()
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            android.widget.TextView r3 = r1.f74942c
            if (r3 == 0) goto L_0x0021
            java.lang.String r3 = r2.getName()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0021
            android.widget.TextView r3 = r1.f74942c
            java.lang.String r0 = r2.getName()
            r3.setText(r0)
        L_0x0021:
            r2.getOrderSummary()
            android.widget.TextView r3 = r1.f74943d
            net.one97.paytm.o2o.movies.c.a$1 r0 = new net.one97.paytm.o2o.movies.c.a$1
            r0.<init>(r2)
            r3.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.c.a.a(android.content.Context, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem):void");
    }
}
