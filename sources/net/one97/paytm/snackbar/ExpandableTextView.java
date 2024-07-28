package net.one97.paytm.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ExpandableTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f65088a;

    /* renamed from: b  reason: collision with root package name */
    TimeInterpolator f65089b;

    /* renamed from: c  reason: collision with root package name */
    public TimeInterpolator f65090c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65091d;

    /* renamed from: e  reason: collision with root package name */
    public long f65092e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65093f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65094g;

    /* renamed from: h  reason: collision with root package name */
    public int f65095h;

    public interface a {
        void a();

        void b();
    }

    public ExpandableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f65092e = 750;
        this.f65091d = getMaxLines();
        this.f65088a = new ArrayList();
        this.f65089b = new AccelerateDecelerateInterpolator();
        this.f65090c = new AccelerateDecelerateInterpolator();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f65091d == 0 && !this.f65094g && !this.f65093f) {
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setAnimationDuration(long j) {
        this.f65092e = j;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.f65089b = timeInterpolator;
        this.f65090c = timeInterpolator;
    }

    public void setExpandInterpolator(TimeInterpolator timeInterpolator) {
        this.f65089b = timeInterpolator;
    }

    public TimeInterpolator getExpandInterpolator() {
        return this.f65089b;
    }

    public void setCollapseInterpolator(TimeInterpolator timeInterpolator) {
        this.f65090c = timeInterpolator;
    }

    public TimeInterpolator getCollapseInterpolator() {
        return this.f65090c;
    }
}
