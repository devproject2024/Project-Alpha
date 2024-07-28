package net.one97.paytm.addmoney.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import net.one97.paytm.addmoney.R;

public class ReactivateUPICardView extends LinearLayout {
    public ReactivateUPICardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ReactivateUPICardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ReactivateUPICardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_reactivate_card_addmoney, this, false);
        removeAllViews();
        addView(inflate);
    }
}
