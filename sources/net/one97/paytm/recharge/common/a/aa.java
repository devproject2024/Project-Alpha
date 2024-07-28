package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.widgets.c.d;

public class aa extends ag {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f60432a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f60433b;

    /* renamed from: c  reason: collision with root package name */
    final Context f60434c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aa(View view, Context context) {
        super(view);
        k.c(view, "view");
        k.c(context, "context");
        this.f60434c = context;
        this.f60432a = (TextView) view.findViewById(R.id.title);
        this.f60433b = (TextView) view.findViewById(R.id.price);
    }

    public void a(CJRCartProduct cJRCartProduct) {
        k.c(cJRCartProduct, "item");
        TextView textView = this.f60432a;
        k.a((Object) textView, "title");
        textView.setText(cJRCartProduct.getName());
        TextView textView2 = this.f60433b;
        k.a((Object) textView2, "price");
        Resources resources = this.f60434c.getResources();
        int i2 = R.string.price_container_re;
        d dVar = d.f64967a;
        String price = cJRCartProduct.getPrice();
        k.a((Object) price, "item.price");
        textView2.setText(resources.getString(i2, new Object[]{d.e(String.valueOf(Double.parseDouble(price)))}));
    }
}
