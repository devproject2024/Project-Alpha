package net.one97.paytm.passbook.spendanalytics.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.spendanalytics.model.Response;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final C1129a f58479a;

    /* renamed from: b  reason: collision with root package name */
    final String f58480b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Response> f58481c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<String> f58482d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f58483e;

    /* renamed from: net.one97.paytm.passbook.spendanalytics.a.a$a  reason: collision with other inner class name */
    public interface C1129a {
        void a(int i2, String str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        r5 = r5.getDistribution();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r7, int r8) {
        /*
            r6 = this;
            net.one97.paytm.passbook.spendanalytics.a.a$b r7 = (net.one97.paytm.passbook.spendanalytics.a.a.b) r7
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = r6.f58480b
            java.lang.String r1 = "money_spent_chart"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            if (r0 == 0) goto L_0x0121
            boolean r0 = r0.contentEquals(r1)
            java.lang.String r1 = "%</b>"
            java.lang.String r3 = " <b>"
            r4 = 0
            if (r0 == 0) goto L_0x0086
            com.paytm.utility.RoboTextView r0 = r7.f58485b
            net.one97.paytm.passbook.spendanalytics.a r2 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r5 = r6.f58481c
            java.lang.Object r5 = r5.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r5 = (net.one97.paytm.passbook.spendanalytics.model.Response) r5
            if (r5 == 0) goto L_0x003a
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r5 = r5.getDistribution()
            if (r5 == 0) goto L_0x003a
            java.lang.String r5 = r5.getKey()
            goto L_0x003b
        L_0x003a:
            r5 = r4
        L_0x003b:
            r2.append(r5)
            r2.append(r3)
            java.util.ArrayList<java.lang.String> r3 = r6.f58482d
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.text.Spanned r1 = net.one97.paytm.passbook.spendanalytics.a.h(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r7.f58484a
            net.one97.paytm.passbook.spendanalytics.a r1 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r1 = r6.f58481c
            java.lang.Object r1 = r1.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r1 = (net.one97.paytm.passbook.spendanalytics.model.Response) r1
            if (r1 == 0) goto L_0x0074
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r1 = r1.getDistribution()
            if (r1 == 0) goto L_0x0074
            java.lang.String r4 = r1.getKey()
        L_0x0074:
            java.lang.Integer r1 = net.one97.paytm.passbook.spendanalytics.a.d(r4)
            if (r1 != 0) goto L_0x007d
            kotlin.g.b.k.a()
        L_0x007d:
            int r1 = r1.intValue()
            r0.setTextColor(r1)
            goto L_0x010a
        L_0x0086:
            java.lang.String r0 = r6.f58480b
            java.lang.String r5 = "money_received_chart"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r0 == 0) goto L_0x011b
            boolean r0 = r0.contentEquals(r5)
            if (r0 == 0) goto L_0x010a
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r0 = r6.f58481c
            int r0 = r0.size()
            if (r8 >= r0) goto L_0x010a
            com.paytm.utility.RoboTextView r0 = r7.f58485b
            net.one97.paytm.passbook.spendanalytics.a r2 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            net.one97.paytm.passbook.spendanalytics.a r5 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r5 = r6.f58481c
            java.lang.Object r5 = r5.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r5 = (net.one97.paytm.passbook.spendanalytics.model.Response) r5
            if (r5 == 0) goto L_0x00bc
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r5 = r5.getDistribution()
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = r5.getKey()
            goto L_0x00bd
        L_0x00bc:
            r5 = r4
        L_0x00bd:
            java.lang.String r5 = net.one97.paytm.passbook.spendanalytics.a.e(r5)
            r2.append(r5)
            r2.append(r3)
            java.util.ArrayList<java.lang.String> r3 = r6.f58482d
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.text.Spanned r1 = net.one97.paytm.passbook.spendanalytics.a.h(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r7.f58484a
            net.one97.paytm.passbook.spendanalytics.a r1 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r1 = r6.f58481c
            java.lang.Object r1 = r1.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r1 = (net.one97.paytm.passbook.spendanalytics.model.Response) r1
            if (r1 == 0) goto L_0x00fa
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r1 = r1.getDistribution()
            if (r1 == 0) goto L_0x00fa
            java.lang.String r4 = r1.getKey()
        L_0x00fa:
            java.lang.Integer r1 = net.one97.paytm.passbook.spendanalytics.a.g(r4)
            if (r1 != 0) goto L_0x0103
            kotlin.g.b.k.a()
        L_0x0103:
            int r1 = r1.intValue()
            r0.setTextColor(r1)
        L_0x010a:
            boolean r0 = r6.f58483e
            if (r0 != 0) goto L_0x011a
            androidx.constraintlayout.widget.ConstraintLayout r7 = r7.f58486c
            net.one97.paytm.passbook.spendanalytics.a.a$c r0 = new net.one97.paytm.passbook.spendanalytics.a.a$c
            r0.<init>(r6, r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x011a:
            return
        L_0x011b:
            kotlin.u r7 = new kotlin.u
            r7.<init>(r2)
            throw r7
        L_0x0121:
            kotlin.u r7 = new kotlin.u
            r7.<init>(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_item_row_money_spent_received, viewGroup, false);
        k.a((Object) inflate, "view");
        return new b(inflate);
    }

    public a(ArrayList<Response> arrayList, ArrayList<String> arrayList2, C1129a aVar, String str, boolean z) {
        k.c(arrayList, "moneySpentList");
        k.c(arrayList2, "percentList");
        k.c(aVar, "listener");
        k.c(str, "chartType");
        this.f58481c = arrayList;
        this.f58482d = arrayList2;
        this.f58479a = aVar;
        this.f58480b = str;
        this.f58483e = z;
    }

    public final int getItemCount() {
        return this.f58481c.size();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58487a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58488b;

        c(a aVar, int i2) {
            this.f58487a = aVar;
            this.f58488b = i2;
        }

        public final void onClick(View view) {
            this.f58487a.f58479a.a(this.f58488b, this.f58487a.f58480b);
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f58484a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f58485b;

        /* renamed from: c  reason: collision with root package name */
        final ConstraintLayout f58486c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            TextView textView = (TextView) view.findViewById(R.id.tvItemColor);
            k.a((Object) textView, "itemView.tvItemColor");
            this.f58484a = textView;
            RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.tvChartCategoryName);
            k.a((Object) roboTextView, "itemView.tvChartCategoryName");
            this.f58485b = roboTextView;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clChartItem);
            k.a((Object) constraintLayout, "itemView.clChartItem");
            this.f58486c = constraintLayout;
        }
    }
}
