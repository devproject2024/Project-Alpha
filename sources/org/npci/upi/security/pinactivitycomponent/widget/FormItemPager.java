package org.npci.upi.security.pinactivitycomponent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.u;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.R;

public class FormItemPager extends FrameLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f73023a;

    /* renamed from: b  reason: collision with root package name */
    private int f73024b;

    /* renamed from: c  reason: collision with root package name */
    private int f73025c;

    /* renamed from: d  reason: collision with root package name */
    private Object f73026d;

    public FormItemPager(Context context) {
        super(context);
    }

    public FormItemPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FormItemPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void a(View view) {
        if (Build.VERSION.SDK_INT >= 12) {
            view.animate().x(0.0f);
        } else {
            u.d(view, 0.0f);
        }
    }

    private void a(View view, boolean z) {
        int i2 = z ? this.f73025c * -1 : this.f73025c;
        if (Build.VERSION.SDK_INT >= 12) {
            view.animate().x((float) i2);
        } else {
            u.d(view, (float) i2);
        }
    }

    private void e() {
        for (int i2 = 0; i2 < this.f73023a.size(); i2++) {
            ((FormItemView) this.f73023a.get(i2)).setText("");
        }
        d();
    }

    public void a(String str, Drawable drawable, View.OnClickListener onClickListener, int i2, boolean z, boolean z2) {
        for (int i3 = 0; i3 < this.f73023a.size(); i3++) {
            ((FormItemView) this.f73023a.get(i3)).a(str, drawable, onClickListener, i2, z, z2);
        }
    }

    public void a(ArrayList arrayList, m mVar) {
        this.f73023a = arrayList;
        addView((View) this.f73023a.get(0));
        ((FormItemView) this.f73023a.get(0)).setFormItemListener(mVar);
        this.f73024b = 0;
        this.f73025c = getResources().getDisplayMetrics().widthPixels;
        for (int i2 = 1; i2 < this.f73023a.size(); i2++) {
            FormItemView formItemView = (FormItemView) this.f73023a.get(i2);
            formItemView.setFormItemListener(mVar);
            u.d((View) formItemView, (float) this.f73025c);
            addView(formItemView);
        }
    }

    public boolean a() {
        String inputValue = ((FormItemView) this.f73023a.get(this.f73024b)).getInputValue();
        if (((FormItemView) this.f73023a.get(this.f73024b)).getInputLength() != inputValue.length()) {
            ((FormItemView) this.f73023a.get(this.f73024b)).requestFocus();
            return false;
        } else if (this.f73024b != this.f73023a.size() - 1) {
            return !c();
        } else {
            ((FormItemView) this.f73023a.get(this.f73024b)).requestFocus();
            for (int i2 = 0; i2 < this.f73023a.size(); i2++) {
                if (!((FormItemView) this.f73023a.get(i2)).getInputValue().equals(inputValue)) {
                    e();
                    ((FormItemView) this.f73023a.get(i2)).getFormItemListener().a((View) this, getContext().getString(R.string.info_pins_dont_match));
                    return false;
                }
            }
            return true;
        }
    }

    public boolean b() {
        return ((FormItemView) this.f73023a.get(this.f73024b)).b();
    }

    public boolean c() {
        if (this.f73024b >= this.f73023a.size() - 1) {
            return false;
        }
        a((View) (FormItemView) this.f73023a.get(this.f73024b), true);
        a((FormItemView) this.f73023a.get(this.f73024b + 1));
        this.f73024b++;
        ((FormItemView) this.f73023a.get(this.f73024b)).requestFocus();
        return true;
    }

    public boolean d() {
        int i2 = this.f73024b;
        if (i2 == 0) {
            return false;
        }
        a((View) (FormItemView) this.f73023a.get(i2), false);
        a((FormItemView) this.f73023a.get(this.f73024b - 1));
        this.f73024b--;
        ((FormItemView) this.f73023a.get(this.f73024b)).requestFocus();
        return true;
    }

    public Object getFormDataTag() {
        Object obj = this.f73026d;
        return obj == null ? ((FormItemView) this.f73023a.get(0)).getFormDataTag() : obj;
    }

    public String getInputValue() {
        return ((FormItemView) this.f73023a.get(0)).getInputValue();
    }

    public void setFormDataTag(Object obj) {
        this.f73026d = obj;
    }

    public void setText(String str) {
        for (int i2 = 0; i2 < this.f73023a.size(); i2++) {
            ((FormItemView) this.f73023a.get(i2)).setText(str);
        }
    }
}
