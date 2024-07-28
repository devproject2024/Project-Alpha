package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBBillDetailActivity;

public final class j extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f71842a;

    /* renamed from: b  reason: collision with root package name */
    public List<net.one97.paytm.wallet.splitbill.model.b> f71843b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Resources f71844c;

    /* renamed from: d  reason: collision with root package name */
    private a f71845d;

    public interface a {
        void a();
    }

    public j(Context context, a aVar) {
        this.f71842a = context;
        this.f71844c = this.f71842a.getResources();
        this.f71845d = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_group_detail_adapter, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            b bVar = (b) vVar;
            final net.one97.paytm.wallet.splitbill.model.b bVar2 = this.f71843b.get(i2);
            if (bVar2.f72245a) {
                bVar.f71848a.setVisibility(0);
                bVar.f71853f.setVisibility(8);
                bVar.f71848a.setText(bVar2.f72246b);
            } else {
                bVar.f71848a.setVisibility(8);
                bVar.f71853f.setVisibility(0);
                bVar.f71849b.setText(bVar2.f72247c.getRequestName());
                if (bVar2.f72247c.getMessage() != null) {
                    bVar.f71850c.setText(bVar2.f72247c.getMessage());
                }
                if (Double.parseDouble(bVar2.f72247c.getAmount()) > 0.0d) {
                    TextView textView = bVar.f71851d;
                    textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())))));
                    bVar.f71852e.setText("To Pay");
                    bVar.f71852e.setTextColor(this.f71844c.getColor(R.color.color_fd5c5c));
                } else {
                    Double valueOf = Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())));
                    TextView textView2 = bVar.f71851d;
                    textView2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(valueOf));
                    bVar.f71852e.setText("To Receive");
                    bVar.f71852e.setTextColor(this.f71844c.getColor(R.color.color_21c17a));
                }
                bVar.itemView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent(j.this.f71842a, SBBillDetailActivity.class);
                        intent.putExtra("bill_id", bVar2.f72247c.getRequestId());
                        j.this.f71842a.startActivity(intent);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("viewBills");
                        net.one97.paytm.wallet.splitbill.e.b.a(j.this.f71842a, "split_bill", "splitbill_detail", arrayList, "", "/splitbill/selectbill", "split_bill");
                    }
                });
            }
            if (this.f71843b.size() - i2 == 2) {
                this.f71845d.a();
            }
        }
    }

    public final int getItemCount() {
        List<net.one97.paytm.wallet.splitbill.model.b> list = this.f71843b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71848a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71849b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71850c = ((TextView) this.itemView.findViewById(R.id.amount_member));

        /* renamed from: d  reason: collision with root package name */
        TextView f71851d = ((TextView) this.itemView.findViewById(R.id.amount));

        /* renamed from: e  reason: collision with root package name */
        TextView f71852e = ((TextView) this.itemView.findViewById(R.id.pay_rec));

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f71853f;

        public b(View view) {
            super(view);
            this.f71848a = (TextView) view.findViewById(R.id.month);
            this.f71853f = (RelativeLayout) view.findViewById(R.id.complete_request_detail);
            this.f71849b = (TextView) view.findViewById(R.id.bill_name);
        }
    }
}
