package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
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

public final class m extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse.a> f71920a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f71921b;

    /* renamed from: c  reason: collision with root package name */
    private a f71922c;

    public interface a {
        void a();
    }

    public m(Context context, a aVar) {
        this.f71921b = context;
        this.f71922c = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_group_detail_adapter, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            b bVar = (b) vVar;
            net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse.a aVar = this.f71920a.get(i2);
            if (aVar.f72239a) {
                bVar.f71923a.setVisibility(0);
                bVar.f71928f.setVisibility(8);
                bVar.f71923a.setText(aVar.f72240b);
            } else if (aVar.f72241c.getActivityType().equalsIgnoreCase("UPDATE_REQUEST")) {
                bVar.f71923a.setVisibility(8);
                bVar.f71928f.setVisibility(0);
                if (!TextUtils.isEmpty(aVar.f72241c.getMessage())) {
                    bVar.f71924b.setText(aVar.f72241c.getMessage());
                }
                bVar.f71925c.setText(net.one97.paytm.wallet.splitbill.e.b.c(aVar.f72241c.getCreateDate()));
                bVar.f71926d.setVisibility(8);
                bVar.f71927e.setVisibility(4);
            } else if (aVar.f72241c.getActivityType().equalsIgnoreCase("CREATE_REQUEST")) {
                bVar.f71923a.setVisibility(8);
                bVar.f71928f.setVisibility(0);
                if (!TextUtils.isEmpty(aVar.f72241c.getMessage())) {
                    bVar.f71924b.setText(aVar.f72241c.getMessage());
                }
                bVar.f71925c.setText(net.one97.paytm.wallet.splitbill.e.b.c(aVar.f72241c.getCreateDate()));
                bVar.f71926d.setVisibility(0);
                bVar.f71927e.setVisibility(0);
                Double valueOf = Double.valueOf(aVar.f72241c.getAmount());
                TextView textView = bVar.f71926d;
                textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(valueOf.doubleValue()))));
                if (valueOf.doubleValue() >= 0.0d) {
                    bVar.f71927e.setText("To Pay");
                    bVar.f71927e.setTextColor(Color.parseColor("#fd5c5c"));
                } else {
                    bVar.f71927e.setText("To Receive");
                    bVar.f71927e.setTextColor(Color.parseColor("#21c17a"));
                }
            } else if (aVar.f72241c.getActivityType().equalsIgnoreCase("DELETE_REQUEST")) {
                bVar.f71923a.setVisibility(8);
                bVar.f71928f.setVisibility(0);
                if (!TextUtils.isEmpty(aVar.f72241c.getMessage())) {
                    bVar.f71924b.setText(aVar.f72241c.getMessage());
                }
                bVar.f71925c.setText(net.one97.paytm.wallet.splitbill.e.b.c(aVar.f72241c.getCreateDate()));
                bVar.f71926d.setVisibility(8);
                bVar.f71927e.setVisibility(4);
            } else if (aVar.f72241c.getActivityType().equalsIgnoreCase("SETTLE_PAYMENT")) {
                bVar.f71923a.setVisibility(8);
                bVar.f71928f.setVisibility(0);
                if (!TextUtils.isEmpty(aVar.f72241c.getMessage())) {
                    bVar.f71924b.setText(aVar.f72241c.getMessage());
                }
                bVar.f71925c.setText(net.one97.paytm.wallet.splitbill.e.b.c(aVar.f72241c.getCreateDate()));
                bVar.f71926d.setVisibility(0);
                bVar.f71927e.setVisibility(0);
                Double valueOf2 = Double.valueOf(aVar.f72241c.getAmount());
                TextView textView2 = bVar.f71926d;
                textView2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(valueOf2.doubleValue()))));
                if (valueOf2.doubleValue() >= 0.0d) {
                    bVar.f71927e.setText("Paid");
                    bVar.f71927e.setTextColor(Color.parseColor("#8ba6c1"));
                } else {
                    bVar.f71927e.setText("Received");
                    bVar.f71927e.setTextColor(Color.parseColor("#8ba6c1"));
                }
            }
            if (this.f71920a.size() - i2 == 2) {
                this.f71922c.a();
            }
        }
    }

    public final int getItemCount() {
        List<net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse.a> list = this.f71920a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71923a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71924b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71925c;

        /* renamed from: d  reason: collision with root package name */
        TextView f71926d;

        /* renamed from: e  reason: collision with root package name */
        TextView f71927e;

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f71928f;

        b(View view) {
            super(view);
            this.f71925c = (TextView) view.findViewById(R.id.amount_member);
            this.f71926d = (TextView) view.findViewById(R.id.amount);
            this.f71927e = (TextView) view.findViewById(R.id.pay_rec);
            this.f71923a = (TextView) view.findViewById(R.id.month);
            this.f71928f = (RelativeLayout) view.findViewById(R.id.complete_request_detail);
            this.f71924b = (TextView) view.findViewById(R.id.bill_name);
        }
    }
}
