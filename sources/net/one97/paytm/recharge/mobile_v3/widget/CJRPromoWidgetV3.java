package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class CJRPromoWidgetV3 extends ViewFlipper {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRPromoWidgetV3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(R.layout.v3_content_widget_promo, this, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRPromoWidgetV3(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void setEnabled(boolean z) {
        if (z) {
            setDisplayedChild(indexOfChild(findViewById(R.id.lyt_promo_enabled)));
        } else {
            setDisplayedChild(indexOfChild(findViewById(R.id.lyt_promo_disabled)));
        }
        super.setEnabled(z);
    }

    public final void setEnabled(boolean z, View.OnClickListener onClickListener) {
        k.c(onClickListener, "clickListener");
        setEnabled(z);
        if (z) {
            ((TextView) getChildAt(getDisplayedChild()).findViewById(R.id.txt_promo_enabled)).setOnClickListener(onClickListener);
        }
    }

    public final void a(String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        k.c(str, "promo");
        k.c(onClickListener, "removePromoClickListener");
        View findViewById = findViewById(R.id.lyt_promo_applied);
        setDisplayedChild(indexOfChild(findViewById));
        TextView textView = (TextView) findViewById.findViewById(R.id.txt_promo_applied);
        k.a((Object) textView, "promoView");
        textView.setText(getContext().getString(R.string.promo_applied_text, new Object[]{str}));
        textView.setVisibility(0);
        findViewById.findViewById(R.id.lyt_remove_promo).setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener2);
    }
}
