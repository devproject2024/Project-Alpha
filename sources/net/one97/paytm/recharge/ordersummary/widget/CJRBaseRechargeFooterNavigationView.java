package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.paytm.utility.b;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public final class CJRBaseRechargeFooterNavigationView extends LinearLayout implements View.OnClickListener {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargeFooterNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        setOrientation(1);
        setBackgroundColor(-1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, b.c(61)));
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.b.c(context, R.color.separators));
        addView(view, new LinearLayout.LayoutParams(-1, b.c(1)));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setId(R.id.parent_layout_bottom);
        linearLayout.setBackgroundColor(-1);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, b.c(60)));
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        Context context2 = getContext();
        k.a((Object) context2, "context");
        cJRRechargeUtilities.setupBottomTabs(context2, this, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargeFooterNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargeFooterNavigationView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void onClick(View view) {
        k.c(view, "view");
        if (!view.isSelected()) {
            CJRBaseRechargeFooterNavigationView.class.getName();
            q.c();
        }
    }
}
