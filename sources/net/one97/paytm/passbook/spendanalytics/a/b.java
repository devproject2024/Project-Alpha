package net.one97.paytm.passbook.spendanalytics.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.spendanalytics.activities.SpendsByCategoryActivity;
import net.one97.paytm.passbook.spendanalytics.model.Response;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f58489a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<Response> f58490b;

    /* renamed from: c  reason: collision with root package name */
    final String f58491c;

    public b(Context context, ArrayList<Response> arrayList, String str) {
        k.c(context, "context");
        k.c(arrayList, "spendsByCategoryList");
        k.c(str, "selectedMonth");
        this.f58489a = context;
        this.f58490b = arrayList;
        this.f58491c = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r1 = r1.getDistribution();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r8, int r9) {
        /*
            r7 = this;
            net.one97.paytm.passbook.spendanalytics.a.b$a r8 = (net.one97.paytm.passbook.spendanalytics.a.b.a) r8
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r8, r0)
            com.paytm.utility.RoboTextView r0 = r8.f58493b
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r1 = r7.f58490b
            java.lang.Object r1 = r1.get(r9)
            net.one97.paytm.passbook.spendanalytics.model.Response r1 = (net.one97.paytm.passbook.spendanalytics.model.Response) r1
            r2 = 0
            if (r1 == 0) goto L_0x001f
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r1 = r1.getDistribution()
            if (r1 == 0) goto L_0x001f
            java.lang.String r1 = r1.getKey()
            goto L_0x0020
        L_0x001f:
            r1 = r2
        L_0x0020:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r0 = r7.f58490b
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.passbook.spendanalytics.model.Response r0 = (net.one97.paytm.passbook.spendanalytics.model.Response) r0
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r0 = r0.getDistribution()
            if (r0 == 0) goto L_0x0052
            java.lang.String r0 = r0.getCnt()
            if (r0 == 0) goto L_0x0052
            java.lang.String r1 = "1"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r0 == 0) goto L_0x004a
            boolean r0 = r0.contentEquals(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0053
        L_0x004a:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r9)
            throw r8
        L_0x0052:
            r0 = r2
        L_0x0053:
            if (r0 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0082
            com.paytm.utility.RoboTextView r0 = r8.f58494c
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r1 = r7.f58490b
            java.lang.Object r1 = r1.get(r9)
            net.one97.paytm.passbook.spendanalytics.model.Response r1 = (net.one97.paytm.passbook.spendanalytics.model.Response) r1
            if (r1 == 0) goto L_0x0075
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r1 = r1.getDistribution()
            if (r1 == 0) goto L_0x0075
            java.lang.String r1 = r1.getCnt()
            goto L_0x0076
        L_0x0075:
            r1 = r2
        L_0x0076:
            java.lang.String r3 = " Payment"
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x00a5
        L_0x0082:
            com.paytm.utility.RoboTextView r0 = r8.f58494c
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r1 = r7.f58490b
            java.lang.Object r1 = r1.get(r9)
            net.one97.paytm.passbook.spendanalytics.model.Response r1 = (net.one97.paytm.passbook.spendanalytics.model.Response) r1
            if (r1 == 0) goto L_0x0099
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r1 = r1.getDistribution()
            if (r1 == 0) goto L_0x0099
            java.lang.String r1 = r1.getCnt()
            goto L_0x009a
        L_0x0099:
            r1 = r2
        L_0x009a:
            java.lang.String r3 = " Payments"
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00a5:
            com.paytm.utility.RoboTextView r0 = r8.f58495d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "₹"
            r1.<init>(r3)
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r3 = r7.f58490b
            java.lang.Object r3 = r3.get(r9)
            net.one97.paytm.passbook.spendanalytics.model.Response r3 = (net.one97.paytm.passbook.spendanalytics.model.Response) r3
            if (r3 == 0) goto L_0x00c3
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r3 = r3.getDistribution()
            if (r3 == 0) goto L_0x00c3
            java.lang.String r3 = r3.getSum()
            goto L_0x00c4
        L_0x00c3:
            r3 = r2
        L_0x00c4:
            java.lang.String r3 = net.one97.paytm.passbook.utility.c.c(r3)
            java.lang.String r4 = "CJRAppUtils.getFormatted…tion]?.distribution?.sum)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r4 = 0
            java.lang.String r5 = ".00"
            java.lang.String r6 = ""
            java.lang.String r3 = kotlin.m.p.a(r3, r5, r6, r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r0 = r7.f58490b
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.passbook.spendanalytics.model.Response r0 = (net.one97.paytm.passbook.spendanalytics.model.Response) r0
            if (r0 == 0) goto L_0x00f7
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r0 = r0.getDistribution()
            if (r0 == 0) goto L_0x00f7
            java.lang.String r0 = r0.getLogo()
            goto L_0x00f8
        L_0x00f7:
            r0 = r2
        L_0x00f8:
            if (r0 == 0) goto L_0x011b
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r1 = r7.f58490b
            java.lang.Object r1 = r1.get(r9)
            net.one97.paytm.passbook.spendanalytics.model.Response r1 = (net.one97.paytm.passbook.spendanalytics.model.Response) r1
            if (r1 == 0) goto L_0x0112
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r1 = r1.getDistribution()
            if (r1 == 0) goto L_0x0112
            java.lang.String r2 = r1.getLogo()
        L_0x0112:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r2)
            android.widget.ImageView r1 = r8.f58496e
            r0.a((android.widget.ImageView) r1)
        L_0x011b:
            androidx.constraintlayout.widget.ConstraintLayout r8 = r8.f58492a
            net.one97.paytm.passbook.spendanalytics.a.b$c r0 = new net.one97.paytm.passbook.spendanalytics.a.b$c
            r0.<init>(r7, r9)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.a.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_item_row_spends_by_category, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public final int getItemCount() {
        return this.f58490b.size();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58498a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58499b;

        c(b bVar, int i2) {
            this.f58498a = bVar;
            this.f58499b = i2;
        }

        public final void onClick(View view) {
            b bVar = this.f58498a;
            Response response = bVar.f58490b.get(this.f58499b);
            k.a((Object) response, "spendsByCategoryList[position]");
            Response response2 = response;
            if (response2.getSubDistrubution() != null) {
                Intent intent = new Intent(bVar.f58489a, SpendsByCategoryActivity.class);
                intent.putExtra("spends_by_category_item", response2);
                intent.putExtra("view_pager_selected_month", bVar.f58491c);
                bVar.f58489a.startActivity(intent);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(bVar.f58489a);
            builder.setMessage("Uh-oh, we were unable to fetch details. We are looking into it.").setCancelable(false).setPositiveButton("OK, I understand.", C1130b.f58497a);
            builder.create().show();
        }
    }

    /* renamed from: net.one97.paytm.passbook.spendanalytics.a.b$b  reason: collision with other inner class name */
    static final class C1130b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C1130b f58497a = new C1130b();

        C1130b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f58492a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f58493b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f58494c;

        /* renamed from: d  reason: collision with root package name */
        RoboTextView f58495d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f58496e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clRoot);
            k.a((Object) constraintLayout, "itemView.clRoot");
            this.f58492a = constraintLayout;
            RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.tvCategoryName);
            k.a((Object) roboTextView, "itemView.tvCategoryName");
            this.f58493b = roboTextView;
            RoboTextView roboTextView2 = (RoboTextView) view.findViewById(R.id.tvCategoryTotalPayments);
            k.a((Object) roboTextView2, "itemView.tvCategoryTotalPayments");
            this.f58494c = roboTextView2;
            RoboTextView roboTextView3 = (RoboTextView) view.findViewById(R.id.tvAmount);
            k.a((Object) roboTextView3, "itemView.tvAmount");
            this.f58495d = roboTextView3;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivSpendsByCateogry);
            k.a((Object) imageView, "itemView.ivSpendsByCateogry");
            this.f58496e = imageView;
        }
    }
}
