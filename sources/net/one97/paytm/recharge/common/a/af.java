package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.widgets.c.d;

public final class af extends aa {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public af(View view, Context context) {
        super(view, context);
        k.c(view, "view");
        k.c(context, "context");
    }

    public final void a(CJRCartProduct cJRCartProduct) {
        k.c(cJRCartProduct, "item");
        CJRProductAttributes cJRProductAttributes = cJRCartProduct.getmProductAttrubutes();
        String str = null;
        String feeType = cJRProductAttributes != null ? cJRProductAttributes.getFeeType() : null;
        CJRProductAttributes cJRProductAttributes2 = cJRCartProduct.getmProductAttrubutes();
        String challanType = cJRProductAttributes2 != null ? cJRProductAttributes2.getChallanType() : null;
        CharSequence charSequence = feeType;
        if ((charSequence == null || p.a(charSequence)) || p.a(feeType, "N/A", true)) {
            CharSequence charSequence2 = challanType;
            if ((charSequence2 == null || p.a(charSequence2)) || p.a(challanType, "N/A", true)) {
                CJRProductAttributes cJRProductAttributes3 = cJRCartProduct.getmProductAttrubutes();
                String operatorDisplayLabel = cJRProductAttributes3 != null ? cJRProductAttributes3.getOperatorDisplayLabel() : null;
                CJRProductAttributes cJRProductAttributes4 = cJRCartProduct.getmProductAttrubutes();
                if (cJRProductAttributes4 != null) {
                    str = cJRProductAttributes4.getPaytTypeDisplayLabel();
                }
                TextView textView = this.f60432a;
                k.a((Object) textView, "title");
                textView.setText(operatorDisplayLabel + ' ' + str);
            } else {
                TextView textView2 = this.f60432a;
                k.a((Object) textView2, "title");
                textView2.setText(charSequence2);
            }
        } else {
            TextView textView3 = this.f60432a;
            k.a((Object) textView3, "title");
            textView3.setText(charSequence);
        }
        TextView textView4 = this.f60433b;
        k.a((Object) textView4, "price");
        Resources resources = this.f60434c.getResources();
        int i2 = R.string.price_container_re;
        d dVar = d.f64967a;
        String price = cJRCartProduct.getPrice();
        k.a((Object) price, "item.price");
        textView4.setText(resources.getString(i2, new Object[]{d.e(String.valueOf(Double.parseDouble(price)))}));
    }
}
