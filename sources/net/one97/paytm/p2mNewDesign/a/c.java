package net.one97.paytm.p2mNewDesign.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.wallet.R;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    b f13142a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<net.one97.paytm.p2mNewDesign.models.a> f13143b;

    /* renamed from: c  reason: collision with root package name */
    private Context f13144c;

    /* renamed from: d  reason: collision with root package name */
    private String f13145d;

    public interface b {
        void a(net.one97.paytm.p2mNewDesign.models.a aVar);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        net.one97.paytm.p2mNewDesign.models.a aVar2 = this.f13143b.get(i2);
        TextView textView = aVar.f13151b;
        textView.setText(aVar2.a() + " Months");
        TextView textView2 = aVar.f13152c;
        textView2.setText("₹ " + net.one97.paytm.wallet.utility.a.a(aVar2.f56919b.doubleValue()));
        TextView textView3 = aVar.f13153d;
        textView3.setText(aVar2.f56920c + "%");
        TextView textView4 = aVar.f13154e;
        textView4.setText("₹ " + net.one97.paytm.wallet.utility.a.a(aVar2.f56921d.doubleValue()));
        if (this.f13145d.equalsIgnoreCase(aVar2.f56918a)) {
            aVar.f13150a.setChecked(true);
            aVar.f13151b.setTypeface(Typeface.DEFAULT_BOLD);
            aVar.f13152c.setTypeface(Typeface.DEFAULT_BOLD);
            aVar.f13153d.setTypeface(Typeface.DEFAULT_BOLD);
            aVar.f13154e.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            aVar.f13150a.setChecked(false);
            aVar.f13151b.setTypeface(Typeface.DEFAULT);
            aVar.f13152c.setTypeface(Typeface.DEFAULT);
            aVar.f13153d.setTypeface(Typeface.DEFAULT);
            aVar.f13154e.setTypeface(Typeface.DEFAULT);
        }
        if (i2 % 2 == 1) {
            aVar.f13155f.setBackgroundColor(Color.parseColor("#f9fafb"));
        } else {
            aVar.f13155f.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        aVar.f13155f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.p2mNewDesign.models.a aVar = c.this.f13143b.get(i2);
                if (aVar != null) {
                    c.this.f13142a.a(aVar);
                }
            }
        });
        aVar.f13150a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.p2mNewDesign.models.a aVar = c.this.f13143b.get(i2);
                if (aVar != null) {
                    c.this.f13142a.a(aVar);
                }
            }
        });
    }

    public c(Context context, b bVar, ArrayList<net.one97.paytm.p2mNewDesign.models.a> arrayList, String str) {
        this.f13144c = context;
        this.f13142a = bVar;
        this.f13143b = arrayList;
        this.f13145d = str;
    }

    public final int getItemCount() {
        if (this.f13143b.size() > 0) {
            return this.f13143b.size();
        }
        return 0;
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RadioButton f13150a;

        /* renamed from: b  reason: collision with root package name */
        TextView f13151b;

        /* renamed from: c  reason: collision with root package name */
        TextView f13152c;

        /* renamed from: d  reason: collision with root package name */
        TextView f13153d;

        /* renamed from: e  reason: collision with root package name */
        TextView f13154e;

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f13155f;

        public a(View view) {
            super(view);
            this.f13150a = (RadioButton) view.findViewById(R.id.radio_button_selector);
            this.f13151b = (TextView) view.findViewById(R.id.tv_duration);
            this.f13152c = (TextView) view.findViewById(R.id.tv_emi_per_month);
            this.f13153d = (TextView) view.findViewById(R.id.tv_interest_per_annum);
            this.f13154e = (TextView) view.findViewById(R.id.tv_total);
            this.f13155f = (RelativeLayout) view.findViewById(R.id.rl_container);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emi_plan_item, viewGroup, false));
    }
}
