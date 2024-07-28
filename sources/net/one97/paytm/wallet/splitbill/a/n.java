package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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

public final class n extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public String f71930a;

    /* renamed from: b  reason: collision with root package name */
    public String f71931b;

    /* renamed from: c  reason: collision with root package name */
    public List<net.one97.paytm.wallet.splitbill.model.b> f71932c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Context f71933d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f71934e;

    /* renamed from: f  reason: collision with root package name */
    private a f71935f;

    public interface a {
        void a();
    }

    public n(Context context, a aVar) {
        this.f71933d = context;
        this.f71934e = this.f71933d.getResources();
        this.f71935f = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_group_detail_adapter, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            b bVar = (b) vVar;
            net.one97.paytm.wallet.splitbill.model.b bVar2 = this.f71932c.get(i2);
            if (bVar2.f72245a) {
                bVar.f71936a.setVisibility(0);
                bVar.f71941f.setVisibility(8);
                bVar.f71936a.setText(bVar2.f72246b);
            } else if (bVar2.f72247c.getRequestType().equalsIgnoreCase("REQUEST")) {
                bVar.f71936a.setVisibility(8);
                bVar.f71941f.setVisibility(0);
                bVar.f71937b.setText(bVar2.f72247c.getRequestName());
                if (Double.parseDouble(bVar2.f72247c.getAmount()) <= 0.0d || this.f71930a == null) {
                    TextView textView = bVar.f71938c;
                    textView.setText("Bill Amount: ₹" + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getTotalAmount())))));
                } else {
                    TextView textView2 = bVar.f71938c;
                    textView2.setText("Bill Amount: ₹" + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getTotalAmount())))));
                }
                if (Double.parseDouble(bVar2.f72247c.getAmount()) > 0.0d) {
                    TextView textView3 = bVar.f71939d;
                    textView3.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())))));
                    bVar.f71940e.setText("To Pay");
                    bVar.f71940e.setTextColor(this.f71934e.getColor(R.color.color_fd5c5c));
                } else {
                    Double valueOf = Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())));
                    TextView textView4 = bVar.f71939d;
                    textView4.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(valueOf));
                    bVar.f71940e.setText("To Receive");
                    bVar.f71940e.setTextColor(this.f71934e.getColor(R.color.color_21c17a));
                }
            } else if (bVar2.f72247c.getRequestType().equalsIgnoreCase("PAYMENT_DETAIL")) {
                bVar.f71936a.setVisibility(8);
                bVar.f71941f.setVisibility(0);
                if (this.f71931b.equalsIgnoreCase(bVar2.f72247c.getPayeeId())) {
                    TextView textView5 = bVar.f71937b;
                    textView5.setText("You paid " + net.one97.paytm.wallet.splitbill.e.b.d(this.f71930a));
                    TextView textView6 = bVar.f71938c;
                    textView6.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())))) + " paid by You");
                    TextView textView7 = bVar.f71939d;
                    textView7.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())))));
                    bVar.f71940e.setText("Paid");
                    bVar.f71940e.setTextColor(Color.parseColor("#8ba6c1"));
                } else {
                    TextView textView8 = bVar.f71937b;
                    textView8.setText(net.one97.paytm.wallet.splitbill.e.b.d(this.f71930a) + " paid You");
                    TextView textView9 = bVar.f71938c;
                    textView9.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())))) + " paid by " + net.one97.paytm.wallet.splitbill.e.b.d(this.f71930a));
                    Double valueOf2 = Double.valueOf(Math.abs(Double.parseDouble(bVar2.f72247c.getAmount())));
                    TextView textView10 = bVar.f71939d;
                    textView10.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(valueOf2));
                    bVar.f71940e.setText("Received");
                    bVar.f71940e.setTextColor(Color.parseColor("#8ba6c1"));
                }
            }
            if (this.f71932c.size() - i2 == 2) {
                this.f71935f.a();
            }
        }
    }

    public final int getItemCount() {
        List<net.one97.paytm.wallet.splitbill.model.b> list = this.f71932c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71936a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71937b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71938c = ((TextView) this.itemView.findViewById(R.id.amount_member));

        /* renamed from: d  reason: collision with root package name */
        TextView f71939d = ((TextView) this.itemView.findViewById(R.id.amount));

        /* renamed from: e  reason: collision with root package name */
        TextView f71940e = ((TextView) this.itemView.findViewById(R.id.pay_rec));

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f71941f;

        b(View view) {
            super(view);
            this.f71936a = (TextView) view.findViewById(R.id.month);
            this.f71941f = (RelativeLayout) view.findViewById(R.id.complete_request_detail);
            this.f71937b = (TextView) view.findViewById(R.id.bill_name);
        }
    }
}
