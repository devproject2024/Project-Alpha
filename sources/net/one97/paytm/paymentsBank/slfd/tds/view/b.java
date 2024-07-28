package net.one97.paytm.paymentsBank.slfd.tds.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.tds.view.b;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    int f19363a = -1;

    /* renamed from: b  reason: collision with root package name */
    String f19364b;

    /* renamed from: c  reason: collision with root package name */
    d f19365c;

    /* renamed from: d  reason: collision with root package name */
    int f19366d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f19367e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f19368f;

    /* renamed from: g  reason: collision with root package name */
    private Context f19369g;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        TextView textView = aVar.f19370a;
        int c2 = net.one97.paytm.bankCommon.mapping.a.c(16);
        int c3 = net.one97.paytm.bankCommon.mapping.a.c(10);
        if (this.f19363a == i2 || this.f19367e.get(i2).equalsIgnoreCase(this.f19364b)) {
            if (this.f19366d == 100) {
                textView.setBackgroundResource(R.drawable.pb_si_blue_back_circular);
            } else {
                textView.setBackgroundResource(R.drawable.pb_fg_blue_back_radious);
                textView.setPadding(c2, c3, c2, c3);
            }
            textView.setTextColor(this.f19369g.getResources().getColor(R.color.white));
        } else {
            if (this.f19366d == 100) {
                textView.setBackgroundResource(R.drawable.pb_si_white_back_circular);
            } else {
                textView.setBackgroundResource(R.drawable.pb_fg_white_back_radious);
                textView.setPadding(c2, c3, c2, c3);
            }
            textView.setTextColor(this.f19369g.getResources().getColor(R.color.blue_dot));
        }
        aVar.f19370a.setText(this.f19367e.get(i2));
    }

    b(Context context, ArrayList<String> arrayList, d dVar, String str) {
        this.f19368f = LayoutInflater.from(context);
        this.f19365c = dVar;
        this.f19369g = context;
        this.f19367e = arrayList;
        this.f19364b = str;
    }

    public final int getItemCount() {
        return this.f19367e.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f19370a;

        a(View view) {
            super(view);
            this.f19370a = (TextView) view.findViewById(R.id.tv_financial_year);
            this.f19370a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.a.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            b.this.f19364b = ((TextView) view).getText().toString();
            b.this.f19363a = getAdapterPosition();
            b.this.notifyDataSetChanged();
            if (b.this.f19365c != null) {
                b.this.f19365c.onFragmentAction(109, b.this.f19364b);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f19368f.inflate(R.layout.pb_tds_fy_item, viewGroup, false));
    }
}
