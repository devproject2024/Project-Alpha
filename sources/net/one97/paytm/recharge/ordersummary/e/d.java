package net.one97.paytm.recharge.ordersummary.e;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.f.b;

public final class d extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f64284a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f64285b;

    /* renamed from: c  reason: collision with root package name */
    private final View f64286c;

    /* renamed from: d  reason: collision with root package name */
    private final b f64287d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, b bVar) {
        super(view);
        k.c(view, "itemView");
        this.f64287d = bVar;
        this.f64284a = (TextView) view.findViewById(R.id.meter_recharge_code_title);
        this.f64285b = (TextView) view.findViewById(R.id.operator_code);
        this.f64286c = view.findViewById(R.id.divider);
    }

    public final void a(String str, String str2, boolean z) {
        k.c(str, "voucherCodeTitle");
        k.c(str2, "voucherCode");
        TextView textView = this.f64284a;
        k.a((Object) textView, "titleTextView");
        textView.setText(str);
        TextView textView2 = this.f64285b;
        k.a((Object) textView2, "voucherCodeTextView");
        textView2.setText(str2);
        if (z) {
            View view = this.f64286c;
            k.a((Object) view, "divider");
            view.setVisibility(8);
        } else {
            View view2 = this.f64286c;
            k.a((Object) view2, "divider");
            view2.setVisibility(0);
        }
        this.itemView.setOnClickListener(this);
    }

    public final void onClick(View view) {
        b bVar = this.f64287d;
        if (bVar != null) {
            bVar.p();
        }
    }
}
