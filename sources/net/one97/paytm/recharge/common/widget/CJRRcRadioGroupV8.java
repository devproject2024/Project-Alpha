package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.widget.RadioButton;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8;

public final class CJRRcRadioGroupV8<T> extends CJRMobileRadioGroupV8<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CJRRcRadioGroupV8(Context context, List<? extends T> list) {
        super(context, list);
        k.c(list, "radioButtons");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRRcRadioGroupV8(Context context, List<? extends T> list, byte b2) {
        this(context, list);
        k.c(list, "radioButtons");
    }

    public final void a(RadioButton radioButton, int i2) {
        k.c(radioButton, "radioButton");
        radioButton.setPadding(i2 / 2, 0, (int) ba.a(48.0f), 0);
    }
}
