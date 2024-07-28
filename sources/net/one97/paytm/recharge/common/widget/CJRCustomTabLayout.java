package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.q;
import java.lang.reflect.Field;
import net.one97.paytm.recharge.common.utils.bh;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public class CJRCustomTabLayout extends TabLayout {
    private static int y = 4;
    private int z;

    public CJRCustomTabLayout(Context context) {
        super(context);
        d();
    }

    public CJRCustomTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public void setNumberOfTabs(int i2) {
        this.z = i2;
        d();
    }

    public CJRCustomTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d();
    }

    private void d() {
        if (this.z != 0) {
            int i2 = bh.a(getContext())[0] / this.z;
            try {
                Field declaredField = TabLayout.class.getDeclaredField("p");
                declaredField.setAccessible(true);
                declaredField.set(this, Integer.valueOf(i2));
            } catch (NoSuchFieldException e2) {
                q.d(e2.getMessage());
            } catch (IllegalAccessException e3) {
                q.d(e3.getMessage());
            }
        }
    }

    public final TabLayout.f a() {
        try {
            getChildAt(0);
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
        return super.a();
    }
}
