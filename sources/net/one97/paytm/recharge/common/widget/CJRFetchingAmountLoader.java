package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.paytm.utility.b;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;

public final class CJRFetchingAmountLoader extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f61889a;

    public final View a(int i2) {
        if (this.f61889a == null) {
            this.f61889a = new HashMap();
        }
        View view = (View) this.f61889a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61889a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRFetchingAmountLoader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(b.c(20), b.c(13), b.c(20), 0);
            LayoutInflater.from(context).inflate(R.layout.layout_fetching_amount_loader, this, true);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRFetchingAmountLoader(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }
}
