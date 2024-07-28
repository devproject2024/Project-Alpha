package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBUserToUserDetailActivity;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse.SBSubRequest;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: f  reason: collision with root package name */
    private static DecimalFormat f71766f = new DecimalFormat("0.00");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f71767a;

    /* renamed from: b  reason: collision with root package name */
    private Resources f71768b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<SBSubRequest> f71769c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f71770d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f71771e = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    public c(ArrayList<SBSubRequest> arrayList, Context context, String str) {
        this.f71769c = arrayList;
        this.f71767a = context;
        this.f71768b = context.getResources();
        this.f71770d = str;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_item_bill_detail_adapter, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            aVar.f71778e.setBackgroundColor(Color.parseColor(this.f71771e.get(i2 % 10)));
            aVar.f71778e.setText(net.one97.paytm.wallet.utility.a.d(this.f71769c.get(i2).getName()));
            aVar.f71774a.setText(this.f71769c.get(i2).getName());
            String amount = this.f71769c.get(i2).getAmount();
            String share = this.f71769c.get(i2).getShare();
            if (Double.valueOf(amount).doubleValue() > 0.0d) {
                TextView textView = aVar.f71775b;
                textView.setText("Paid ₹" + b.a(Double.valueOf(Double.parseDouble(amount))));
                aVar.f71775b.setVisibility(0);
            } else {
                aVar.f71775b.setVisibility(4);
            }
            if (Double.valueOf(share).doubleValue() > 0.0d) {
                TextView textView2 = aVar.f71776c;
                textView2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + b.a(Double.valueOf(Double.parseDouble(share))));
                aVar.f71777d.setText("To Pay");
                aVar.f71777d.setTextColor(this.f71768b.getColor(R.color.color_fd5c5c));
            } else {
                TextView textView3 = aVar.f71776c;
                textView3.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + b.a(Double.valueOf(Double.parseDouble(share))));
                aVar.f71777d.setText("To Receive");
                aVar.f71777d.setTextColor(this.f71768b.getColor(R.color.color_21c17a));
            }
            aVar.f71779f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!((SBSubRequest) c.this.f71769c.get(i2)).getName().equalsIgnoreCase("You")) {
                        Intent intent = new Intent(c.this.f71767a, SBUserToUserDetailActivity.class);
                        intent.putExtra("user_id", ((SBSubRequest) c.this.f71769c.get(i2)).getUserId());
                        intent.putExtra("your_id", c.this.f71770d);
                        c.this.f71767a.startActivity(intent);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("billDetails");
                        arrayList.add(((SBSubRequest) c.this.f71769c.get(i2)).getUserId());
                        b.a(c.this.f71767a, "split_bill", "splitbill_user2user", arrayList, "", "/splitbill/user2user", "split_bill");
                    }
                }
            });
        }
    }

    public final int getItemCount() {
        ArrayList<SBSubRequest> arrayList = this.f71769c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71774a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71775b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71776c;

        /* renamed from: d  reason: collision with root package name */
        TextView f71777d;

        /* renamed from: e  reason: collision with root package name */
        TextView f71778e;

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f71779f;

        public a(View view) {
            super(view);
            this.f71778e = (TextView) view.findViewById(R.id.billmembername);
            this.f71775b = (TextView) view.findViewById(R.id.bill_status);
            this.f71776c = (TextView) view.findViewById(R.id.ad_bill_amount);
            this.f71777d = (TextView) view.findViewById(R.id.bill_pay_rec);
            this.f71774a = (TextView) view.findViewById(R.id.bill_contact_name);
            this.f71779f = (RelativeLayout) view.findViewById(R.id.lyt_container);
        }
    }
}
