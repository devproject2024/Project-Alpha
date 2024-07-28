package net.one97.paytm.recharge.mobile_v3.c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class a extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f63883a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f63884b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f63885c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f63886d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f63887e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f63888f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "itemView");
        this.f63883a = (TextView) view.findViewById(R.id.txt_bill_date_label);
        this.f63884b = (TextView) view.findViewById(R.id.txt_bill_date_value);
        this.f63885c = (TextView) view.findViewById(R.id.txt_due_date_label);
        this.f63886d = (TextView) view.findViewById(R.id.txt_due_date_value);
        this.f63887e = (TextView) view.findViewById(R.id.txt_due_date_label_2);
        this.f63888f = (TextView) view.findViewById(R.id.txt_due_date_value_2);
    }

    public final void a(Map<String, String> map) {
        k.c(map, "values");
        TextView textView = this.f63887e;
        k.a((Object) textView, "txt_due_date_label2");
        textView.setVisibility(8);
        TextView textView2 = this.f63888f;
        k.a((Object) textView2, "txt_due_date_value2");
        textView2.setVisibility(8);
        int i2 = 0;
        for (Object next : map.entrySet()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.k.a();
            }
            Map.Entry entry = (Map.Entry) next;
            if (i2 == 0) {
                TextView textView3 = this.f63883a;
                k.a((Object) textView3, "txt_bill_date_label");
                textView3.setText((CharSequence) entry.getKey());
                TextView textView4 = this.f63884b;
                k.a((Object) textView4, "txt_bill_date_value");
                textView4.setText((CharSequence) entry.getValue());
            } else if (i2 == 1) {
                TextView textView5 = this.f63885c;
                k.a((Object) textView5, "txt_due_date_label");
                textView5.setText((CharSequence) entry.getKey());
                TextView textView6 = this.f63886d;
                k.a((Object) textView6, "txt_due_date_value");
                textView6.setText((CharSequence) entry.getValue());
            } else if (i2 == 2) {
                TextView textView7 = this.f63887e;
                k.a((Object) textView7, "txt_due_date_label2");
                textView7.setText((CharSequence) entry.getKey());
                TextView textView8 = this.f63887e;
                k.a((Object) textView8, "txt_due_date_label2");
                textView8.setVisibility(0);
                TextView textView9 = this.f63888f;
                k.a((Object) textView9, "txt_due_date_value2");
                textView9.setText((CharSequence) entry.getValue());
                TextView textView10 = this.f63888f;
                k.a((Object) textView10, "txt_due_date_value2");
                textView10.setVisibility(0);
            }
            i2 = i3;
        }
    }
}
