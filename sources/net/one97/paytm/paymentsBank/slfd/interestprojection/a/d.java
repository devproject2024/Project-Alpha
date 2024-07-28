package net.one97.paytm.paymentsBank.slfd.interestprojection.a;

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

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19184a;

    /* renamed from: b  reason: collision with root package name */
    private List<FDProjectionListModel.FdInterestProjectionDtoList> f19185b = new ArrayList();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        if (this.f19185b.size() > 0) {
            aVar.f19187b.setText(this.f19184a.getString(R.string.pb_interest_amount));
            aVar.f19188c.setText(this.f19184a.getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(this.f19185b.get(i2).getInterestEarned()))}));
            aVar.f19189d.setText(this.f19184a.getString(R.string.pb_interest_rate, new Object[]{this.f19185b.get(i2).getInterestRate()}));
            aVar.f19190e.setText(this.f19185b.get(i2).getDisplayName());
            aVar.j.setVisibility(8);
            if (this.f19185b.get(i2).getLabel().equalsIgnoreCase("_CURRENT_DATE")) {
                aVar.f19191f.setVisibility(0);
                aVar.f19186a.setBackground(this.f19184a.getResources().getDrawable(R.drawable.pb_green_ball));
            } else {
                aVar.f19191f.setVisibility(4);
                aVar.f19186a.setBackground(this.f19184a.getResources().getDrawable(R.drawable.pb_grey_ball));
            }
            if (this.f19185b.get(i2).getLabel().equalsIgnoreCase("_MATURITY_DATE")) {
                aVar.j.setVisibility(0);
                aVar.j.setText(this.f19184a.getString(R.string.pb_fd_maturity_date, new Object[]{this.f19185b.get(i2).getDate()}));
            }
            if (i2 == 0) {
                aVar.f19192g.setVisibility(8);
                aVar.f19194i.setVisibility(8);
                aVar.f19193h.setVisibility(0);
            } else if (i2 == this.f19185b.size() - 1) {
                aVar.f19192g.setVisibility(8);
                aVar.f19194i.setVisibility(0);
                aVar.f19193h.setVisibility(8);
            } else {
                aVar.f19192g.setVisibility(0);
                aVar.f19194i.setVisibility(8);
                aVar.f19193h.setVisibility(8);
            }
        }
    }

    public d(Context context, List<FDProjectionListModel.FdInterestProjectionDtoList> list) {
        this.f19184a = context;
        this.f19185b.addAll(list);
    }

    public final int getItemCount() {
        return this.f19185b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        View f19186a;

        /* renamed from: b  reason: collision with root package name */
        TextView f19187b;

        /* renamed from: c  reason: collision with root package name */
        TextView f19188c;

        /* renamed from: d  reason: collision with root package name */
        TextView f19189d;

        /* renamed from: e  reason: collision with root package name */
        TextView f19190e;

        /* renamed from: f  reason: collision with root package name */
        TextView f19191f;

        /* renamed from: g  reason: collision with root package name */
        View f19192g;

        /* renamed from: h  reason: collision with root package name */
        View f19193h;

        /* renamed from: i  reason: collision with root package name */
        View f19194i;
        TextView j;

        public a(View view) {
            super(view);
            this.f19187b = (TextView) view.findViewById(R.id.tv_hd_interest_amount);
            this.f19188c = (TextView) view.findViewById(R.id.tv_interest_amount);
            this.f19189d = (TextView) view.findViewById(R.id.tv_interest_rate);
            this.f19190e = (TextView) view.findViewById(R.id.tv_days);
            this.f19186a = view.findViewById(R.id.v_gb_1);
            this.f19191f = (TextView) view.findViewById(R.id.tv_you_are_here);
            this.f19192g = view.findViewById(R.id.v_line_mid);
            this.f19193h = view.findViewById(R.id.v_line_below);
            this.f19194i = view.findViewById(R.id.v_line_above);
            this.j = (TextView) view.findViewById(R.id.tv_maturity_date);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_projection_interest, viewGroup, false));
    }
}
