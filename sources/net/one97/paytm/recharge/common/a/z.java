package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.widgets.c.d;

public final class z extends aa {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(View view, Context context) {
        super(view, context);
        k.c(view, "view");
        k.c(context, "context");
    }

    public final void a(CJRCartProduct cJRCartProduct) {
        k.c(cJRCartProduct, "item");
        String price = cJRCartProduct.getPrice();
        k.a((Object) price, "item.price");
        double parseDouble = Double.parseDouble(price);
        TextView textView = this.f60433b;
        k.a((Object) textView, "price");
        Resources resources = this.f60434c.getResources();
        int i2 = R.string.price_container_re;
        d dVar = d.f64967a;
        textView.setText(resources.getString(i2, new Object[]{d.e(String.valueOf(parseDouble))}));
        if (parseDouble == 0.0d) {
            TextView textView2 = this.f60433b;
            k.a((Object) textView2, "price");
            textView2.setText(this.f60434c.getResources().getString(R.string.free));
        }
        TextView textView3 = this.f60432a;
        k.a((Object) textView3, "title");
        textView3.setText(cJRCartProduct.getBrand());
    }
}
