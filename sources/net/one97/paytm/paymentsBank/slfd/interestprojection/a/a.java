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
import net.one97.paytm.paymentsBank.slfd.interestprojection.c.c;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.ViewHistoryModel;

public final class a extends RecyclerView.a<C0335a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19153a;

    /* renamed from: b  reason: collision with root package name */
    private List<ViewHistoryModel.a> f19154b = new ArrayList();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0335a aVar = (C0335a) vVar;
        List<ViewHistoryModel.a> list = this.f19154b;
        if (list != null && list.size() > 0) {
            ViewHistoryModel.a aVar2 = this.f19154b.get(i2);
            aVar.f19155a.setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("hh:mm a, dd MMM yyyy", "dd MMM, yyyy", aVar2.f19224b));
            if (c.RENEW_FD.toString().equalsIgnoreCase(aVar2.f19225c)) {
                aVar.f19156b.setText(this.f19153a.getString(R.string.pb_fd_auto_renewal));
                TextView textView = aVar.f19157c;
                textView.setText("+ " + this.f19153a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(aVar2.f19226d)}));
                aVar.f19157c.setTextColor(this.f19153a.getResources().getColor(net.one97.paytm.common.assets.R.color.color_21c17a));
            } else if (c.IBL_FD_CREATION.toString().equalsIgnoreCase(aVar2.f19225c)) {
                aVar.f19156b.setText(this.f19153a.getString(R.string.pb_fd_fixed_deposit_created));
                aVar.f19157c.setText(this.f19153a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar2.f19223a))}));
            } else if (c.IBL_FD_REDEMPTION.toString().equalsIgnoreCase(aVar2.f19225c)) {
                aVar.f19156b.setText(this.f19153a.getString(R.string.pb_transferred));
                TextView textView2 = aVar.f19157c;
                textView2.setText("- " + this.f19153a.getString(net.one97.paytm.common.assets.R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar2.f19223a))}));
            }
        }
    }

    public a(Context context, List<ViewHistoryModel.a> list) {
        this.f19153a = context;
        this.f19154b.addAll(list);
    }

    public final int getItemCount() {
        return this.f19154b.size();
    }

    /* renamed from: net.one97.paytm.paymentsBank.slfd.interestprojection.a.a$a  reason: collision with other inner class name */
    public class C0335a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f19155a;

        /* renamed from: b  reason: collision with root package name */
        TextView f19156b;

        /* renamed from: c  reason: collision with root package name */
        TextView f19157c;

        public C0335a(View view) {
            super(view);
            this.f19155a = (TextView) view.findViewById(R.id.tv_date);
            this.f19156b = (TextView) view.findViewById(R.id.tv_transferred);
            this.f19157c = (TextView) view.findViewById(R.id.tv_transferred_amount);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0335a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_fd_history, viewGroup, false));
    }
}
