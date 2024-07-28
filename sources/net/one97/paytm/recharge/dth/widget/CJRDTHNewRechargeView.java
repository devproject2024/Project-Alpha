package net.one97.paytm.recharge.dth.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class CJRDTHNewRechargeView extends LinearLayout {

    public interface a {
        void b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRDTHNewRechargeView(Context context, final a aVar) {
        super(context);
        k.c(context, "context");
        k.c(aVar, "onClickListener");
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dth_new_recharge, (ViewGroup) null, false);
        addView(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }
}
