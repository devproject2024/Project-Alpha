package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.o2o.amusementpark.a.e;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    e.d f73087a;

    /* renamed from: b  reason: collision with root package name */
    public String f73088b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f73089c;

    /* renamed from: d  reason: collision with root package name */
    private Context f73090d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f73091e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final a aVar = (a) vVar;
        String str = this.f73091e.get(i2);
        if (this.f73088b.equals(str)) {
            aVar.f73094a.setTextColor(-1);
            aVar.f73094a.setBackgroundResource(R.drawable.blue_filter_button);
        } else {
            aVar.f73094a.setTextColor(this.f73090d.getResources().getColor(net.one97.paytm.o2o.amusementpark.R.color.paytm_blue));
            aVar.f73094a.setBackgroundResource(R.drawable.blue_border_filter_button);
        }
        aVar.f73094a.setText(str);
        aVar.f73094a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.f73087a.a(aVar.f73094a.getText().toString());
            }
        });
    }

    public c(Context context, List<String> list, e.d dVar, String str) {
        this.f73090d = context;
        this.f73091e = list;
        Context context2 = this.f73090d;
        if (context2 != null) {
            this.f73089c = (LayoutInflater) context2.getSystemService("layout_inflater");
        }
        this.f73087a = dVar;
        this.f73088b = str;
    }

    public final int getItemCount() {
        List<String> list = this.f73091e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f73094a;

        /* renamed from: c  reason: collision with root package name */
        private LinearLayout f73096c;

        public a(View view) {
            super(view);
            this.f73094a = (TextView) view.findViewById(net.one97.paytm.o2o.amusementpark.R.id.event_category_name);
            this.f73096c = (LinearLayout) view.findViewById(net.one97.paytm.o2o.amusementpark.R.id.event_category_lyt);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f73089c.inflate(net.one97.paytm.o2o.amusementpark.R.layout.ampark_category_layout, viewGroup, false));
    }
}
