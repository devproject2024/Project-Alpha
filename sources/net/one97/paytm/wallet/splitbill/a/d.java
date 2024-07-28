package net.one97.paytm.wallet.splitbill.a;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupSnapshot;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<SBGroupSnapshot> f71781a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f71782b;

    /* renamed from: c  reason: collision with root package name */
    private int f71783c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f71784d = new ArrayList<String>() {
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

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        aVar.f71785a.setText(this.f71781a.get(i2).getPayeeId());
        aVar.f71786b.setBackgroundColor(Color.parseColor(this.f71784d.get(i2 % 10)));
        String a2 = b.a(this.f71781a.get(i2).getPayeeId());
        TextView textView = aVar.f71786b;
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        textView.setText(a2);
        aVar.f71787c.setText(String.valueOf(Math.abs(Float.parseFloat(this.f71781a.get(i2).getAmount()))));
    }

    public d(Activity activity, int i2) {
        this.f71782b = activity;
        this.f71783c = i2;
    }

    public final int getItemCount() {
        if (this.f71781a.size() > 0) {
            return this.f71781a.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71785a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71786b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71787c;

        public a(View view) {
            super(view);
            this.f71785a = (TextView) view.findViewById(R.id.name);
            this.f71786b = (TextView) view.findViewById(R.id.mp_initial_name_tv);
            this.f71787c = (TextView) view.findViewById(R.id.amount);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_bill_settlement_item, (ViewGroup) null));
    }
}
