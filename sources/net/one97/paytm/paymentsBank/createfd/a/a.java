package net.one97.paytm.paymentsBank.createfd.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;

public final class a extends RecyclerView.a<C0299a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f18056a;

    /* renamed from: b  reason: collision with root package name */
    private List<FDProjectionListModel.FdInterestProjectionDtoList> f18057b = new ArrayList();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0299a aVar = (C0299a) vVar;
        if (this.f18057b.size() > 0) {
            aVar.f18058a.setText(this.f18056a.getString(R.string.pb_interest_amount));
            aVar.f18059b.setText(this.f18056a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(this.f18057b.get(i2).getInterestEarned()))}));
            aVar.f18060c.setText(this.f18056a.getString(R.string.pb_interest_rate, new Object[]{this.f18057b.get(i2).getInterestRate()}));
            aVar.f18061d.setText(this.f18057b.get(i2).getDisplayName());
            aVar.f18065h.setVisibility(8);
            if (this.f18057b.get(i2).getLabel().equalsIgnoreCase("_MATURITY_DATE")) {
                aVar.f18065h.setVisibility(0);
                aVar.f18065h.setText(this.f18056a.getString(R.string.pb_fd_maturity_date, new Object[]{this.f18057b.get(i2).getDate()}));
            }
            if (i2 == 0) {
                aVar.f18062e.setVisibility(8);
                aVar.f18064g.setVisibility(8);
                aVar.f18063f.setVisibility(0);
            } else if (i2 == this.f18057b.size() - 1) {
                aVar.f18062e.setVisibility(8);
                aVar.f18064g.setVisibility(0);
                aVar.f18063f.setVisibility(8);
            } else {
                aVar.f18062e.setVisibility(0);
                aVar.f18064g.setVisibility(8);
                aVar.f18063f.setVisibility(8);
            }
        }
    }

    public a(Context context, List<FDProjectionListModel.FdInterestProjectionDtoList> list) {
        this.f18056a = context;
        this.f18057b.addAll(list);
    }

    public final int getItemCount() {
        return this.f18057b.size();
    }

    /* renamed from: net.one97.paytm.paymentsBank.createfd.a.a$a  reason: collision with other inner class name */
    public class C0299a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f18058a;

        /* renamed from: b  reason: collision with root package name */
        TextView f18059b;

        /* renamed from: c  reason: collision with root package name */
        TextView f18060c;

        /* renamed from: d  reason: collision with root package name */
        TextView f18061d;

        /* renamed from: e  reason: collision with root package name */
        View f18062e;

        /* renamed from: f  reason: collision with root package name */
        View f18063f;

        /* renamed from: g  reason: collision with root package name */
        View f18064g;

        /* renamed from: h  reason: collision with root package name */
        TextView f18065h;

        public C0299a(View view) {
            super(view);
            this.f18058a = (TextView) view.findViewById(R.id.tv_hd_interest_amount);
            this.f18059b = (TextView) view.findViewById(R.id.tv_interest_amount);
            this.f18060c = (TextView) view.findViewById(R.id.tv_interest_rate);
            this.f18061d = (TextView) view.findViewById(R.id.tv_days);
            view.findViewById(R.id.v_gb_1);
            this.f18062e = view.findViewById(R.id.v_line_mid);
            this.f18063f = view.findViewById(R.id.v_line_below);
            this.f18064g = view.findViewById(R.id.v_line_above);
            this.f18065h = (TextView) view.findViewById(R.id.tv_maturity_date);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0299a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.interest_table_row_projection_interest, viewGroup, false));
    }
}
