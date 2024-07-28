package net.one97.paytm.recharge.legacy.catalog.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class CheckableLayout extends RelativeLayout implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f62984a = {16842912, 16842911};

    /* renamed from: b  reason: collision with root package name */
    private boolean f62985b;

    /* renamed from: c  reason: collision with root package name */
    private List<Checkable> f62986c;

    /* renamed from: d  reason: collision with root package name */
    private a f62987d;

    public interface a {
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + f62984a.length);
        if (this.f62985b) {
            mergeDrawableStates(onCreateDrawableState, f62984a);
        }
        return onCreateDrawableState;
    }

    public CheckableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public CheckableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.f62987d = aVar;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            a(getChildAt(i2));
        }
    }

    private void a() {
        this.f62985b = false;
        this.f62986c = new ArrayList(5);
    }

    private void a(View view) {
        if (view instanceof Checkable) {
            this.f62986c.add((Checkable) view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(viewGroup.getChildAt(i2));
            }
        }
    }

    public boolean isChecked() {
        return this.f62985b;
    }

    public void setChecked(boolean z) {
        this.f62985b = z;
        for (Checkable checked : this.f62986c) {
            checked.setChecked(z);
        }
    }

    public void toggle() {
        this.f62985b = !this.f62985b;
        for (Checkable checkable : this.f62986c) {
            checkable.toggle();
        }
    }
}
