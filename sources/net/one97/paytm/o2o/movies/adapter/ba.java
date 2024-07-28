package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.a.d;
import net.one97.paytm.o2o.movies.common.a.e;
import net.one97.paytm.o2o.movies.widget.bottom_sheet_views.WebViewBS;

public final class ba extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    WebViewBS f74532a;

    /* renamed from: b  reason: collision with root package name */
    final List<net.one97.paytm.o2o.movies.common.movies.foodbeverage.a> f74533b;

    public ba(List<net.one97.paytm.o2o.movies.common.movies.foodbeverage.a> list) {
        k.c(list, "list");
        this.f74533b = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005f, code lost:
        r4 = "Valid till ".concat(java.lang.String.valueOf((r4 = net.one97.paytm.o2o.movies.common.a.d.b(r4))));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r3, int r4) {
        /*
            r2 = this;
            net.one97.paytm.o2o.movies.adapter.ba$a r3 = (net.one97.paytm.o2o.movies.adapter.ba.a) r3
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r3, r0)
            net.one97.paytm.o2o.movies.adapter.ba r0 = r3.f74535b
            java.util.List<net.one97.paytm.o2o.movies.common.movies.foodbeverage.a> r0 = r0.f74533b
            java.lang.Object r4 = kotlin.a.k.a(r0, (int) r4)
            net.one97.paytm.o2o.movies.common.movies.foodbeverage.a r4 = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.a) r4
            if (r4 == 0) goto L_0x0075
            android.view.View r0 = r3.f74534a
            int r1 = net.one97.paytm.o2o.movies.R.id.txt_food_voucher_name
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "view.txt_food_voucher_name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r4.f75147a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r0 = r3.f74534a
            int r1 = net.one97.paytm.o2o.movies.R.id.txt_food_voucher_coupon
            android.view.View r0 = r0.findViewById(r1)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "view.txt_food_voucher_coupon"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r4.f75148b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.view.View r3 = r3.f74534a
            int r0 = net.one97.paytm.o2o.movies.R.id.txt_food_voucher_expiry
            android.view.View r3 = r3.findViewById(r0)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            java.lang.String r0 = "view.txt_food_voucher_expiry"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            java.lang.String r4 = r4.f75149c
            java.lang.String r4 = a(r4)
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.a.d.b(r4)
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = "Valid till "
            java.lang.String r4 = r0.concat(r4)
            if (r4 == 0) goto L_0x006e
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            goto L_0x0072
        L_0x006e:
            java.lang.String r4 = ""
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        L_0x0072:
            r3.setText(r4)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.ba.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_food_voucher_oc, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…oucher_oc, parent, false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f74533b.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f74534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ba f74535b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ba baVar, View view) {
            super(view);
            k.c(view, "view");
            this.f74535b = baVar;
            this.f74534a = view;
            this.f74534a.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f74536a;

                {
                    this.f74536a = r1;
                }

                public final void onClick(View view) {
                    net.one97.paytm.o2o.movies.common.movies.foodbeverage.a aVar;
                    String str;
                    String b2;
                    e.b(view);
                    k.a((Object) view, "it");
                    Context context = view.getContext();
                    if (context != null && (aVar = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.a) kotlin.a.k.a(this.f74536a.f74535b.f74533b, this.f74536a.getAdapterPosition())) != null && (str = aVar.f75150d) != null && (b2 = d.b(str)) != null) {
                        WebViewBS webViewBS = this.f74536a.f74535b.f74532a;
                        if (webViewBS != null) {
                            webViewBS.f76195a.dismiss();
                        }
                        this.f74536a.f74535b.f74532a = null;
                        this.f74536a.f74535b.f74532a = new WebViewBS(context);
                        WebViewBS webViewBS2 = this.f74536a.f74535b.f74532a;
                        if (webViewBS2 != null) {
                            webViewBS2.a(b2);
                        }
                    }
                }
            });
        }
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (d.b(str) == null) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
            Date parse = simpleDateFormat.parse(str);
            if (parse != null) {
                return simpleDateFormat2.format(parse);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
