package net.one97.paytm.passbook.spendanalytics.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.customview.b;
import net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsTransactionDetailActivity;
import net.one97.paytm.passbook.spendanalytics.model.Response;
import net.one97.paytm.passbook.spendanalytics.model.Subdistribution;
import net.one97.paytm.passbook.utility.c;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Response f58501a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Subdistribution> f58502b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f58503c;

    /* renamed from: d  reason: collision with root package name */
    private String f58504d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        Subdistribution subdistribution = this.f58501a.getSubDistrubution().get(i2);
        aVar.f58507c.setText(subdistribution.getDistribution().getMdn());
        if (subdistribution.getDistribution().getCnt().equals("1")) {
            TextView textView = aVar.f58508d;
            textView.setText(subdistribution.getDistribution().getCnt() + " Payment");
        } else {
            TextView textView2 = aVar.f58508d;
            textView2.setText(subdistribution.getDistribution().getCnt() + " Payments");
        }
        TextView textView3 = aVar.f58509e;
        textView3.setText(this.f58503c.getString(R.string.pass_rs_symbol) + c.c(subdistribution.getDistribution().getSum()).replace(".00", ""));
        w.a().a(subdistribution.getDistribution().getLogo()).a((ah) new b()).a(aVar.f58506b, (e) null);
        if (subdistribution.getDistribution().getKey().equalsIgnoreCase("others")) {
            aVar.f58507c.setText("Others");
            w.a().a("https://s3.ap-south-1.amazonaws.com/paytm-wallet-images/Wallet_Images/icOthers.png").a((ah) new b()).a(aVar.f58506b, (e) null);
        }
        aVar.f58505a.setVisibility(getItemCount() + -1 == i2 ? 8 : 0);
        aVar.f58510f.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                d.this.a(this.f$1, view);
            }
        });
    }

    public d(Context context, Response response, String str) {
        this.f58503c = context;
        this.f58501a = response;
        this.f58504d = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        net.one97.paytm.passbook.spendanalytics.model.a aVar = new net.one97.paytm.passbook.spendanalytics.model.a(this.f58501a.getSubDistrubution().get(i2).getDistribution().getCnt(), this.f58501a.getSubDistrubution().get(i2).getDistribution().getKey(), this.f58501a.getSubDistrubution().get(i2).getDistribution().getLogo(), this.f58501a.getSubDistrubution().get(i2).getDistribution().getMdn(), this.f58501a.getSubDistrubution().get(i2).getDistribution().getSum(), this.f58504d);
        Intent intent = new Intent(this.f58503c, SpendAnalyticsTransactionDetailActivity.class);
        intent.putExtra("request_store_history", aVar);
        this.f58503c.startActivity(intent);
    }

    public final int getItemCount() {
        if (this.f58501a.getSubDistrubution() == null) {
            return 0;
        }
        return this.f58501a.getSubDistrubution().size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final View f58505a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f58506b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58507c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58508d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58509e;

        /* renamed from: f  reason: collision with root package name */
        public ConstraintLayout f58510f;

        public a(View view) {
            super(view);
            this.f58510f = (ConstraintLayout) view.findViewById(R.id.clRoot);
            this.f58506b = (ImageView) view.findViewById(R.id.categoryIcon);
            this.f58507c = (TextView) view.findViewById(R.id.categoryName);
            this.f58508d = (TextView) view.findViewById(R.id.noOfPayments);
            this.f58509e = (TextView) view.findViewById(R.id.amount);
            this.f58505a = view.findViewById(R.id.separator);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_item_row_spends_by_category_l2, viewGroup, false));
    }
}
