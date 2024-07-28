package net.one97.paytm.recharge.mobile.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRFastForwardWidgetV8;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRMobileFastForwardWidgetV8 extends CJRFastForwardWidgetV8 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f63709a;

    public final View a(int i2) {
        if (this.f63709a == null) {
            this.f63709a = new HashMap();
        }
        View view = (View) this.f63709a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63709a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMobileFastForwardWidgetV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRMobileFastForwardWidgetV8(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void a(Map<String, String> map) {
        k.c(map, "deepLinkParams");
        if (map.containsKey("ff")) {
            String str = map.get("ff");
            map.remove("ff");
            if (!TextUtils.isEmpty(str)) {
                if (str == null) {
                    k.a();
                }
                if (p.a(str, "Y", true)) {
                    CheckBox checkBox = (CheckBox) a(R.id.radio_fast_forward);
                    k.a((Object) checkBox, "radio_fast_forward");
                    checkBox.setChecked(true);
                } else if (p.a(str, UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true)) {
                    CheckBox checkBox2 = (CheckBox) a(R.id.radio_fast_forward);
                    k.a((Object) checkBox2, "radio_fast_forward");
                    checkBox2.setChecked(false);
                }
            }
        }
    }
}
