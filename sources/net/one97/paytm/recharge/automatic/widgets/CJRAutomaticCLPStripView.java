package net.one97.paytm.recharge.automatic.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class CJRAutomaticCLPStripView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f60296a;

    public final View a(int i2) {
        if (this.f60296a == null) {
            this.f60296a = new HashMap();
        }
        View view = (View) this.f60296a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f60296a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRAutomaticCLPStripView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
        setBackgroundResource(R.drawable.automatic_clp_banner_background);
        LayoutInflater.from(context).inflate(R.layout.automatic_subscription_text, this, true);
    }
}
