package com.travel.flight.seatancillary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public a f25456a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f25457b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f25458c;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f25459d;

    public interface a {
        void a();
    }

    public CustomScrollView(Context context) {
        this(context, (AttributeSet) null, 0);
        a();
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a();
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25457b = -1;
        this.f25458c = 100;
        a();
    }

    private void a() {
        this.f25459d = new Runnable() {
            public final void run() {
                if (System.currentTimeMillis() - CustomScrollView.this.f25457b > ((long) CustomScrollView.this.f25458c)) {
                    long unused = CustomScrollView.this.f25457b = -1;
                    return;
                }
                CustomScrollView customScrollView = CustomScrollView.this;
                customScrollView.postDelayed(this, (long) customScrollView.f25458c);
            }
        };
    }

    public void setOnScrollChangedListener(a aVar) {
        this.f25456a = aVar;
    }

    public void setScrollTaskInterval(int i2) {
        this.f25458c = i2;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f25456a;
        if (aVar != null) {
            if (this.f25457b == -1) {
                aVar.a();
                postDelayed(this.f25459d, (long) this.f25458c);
            }
            this.f25457b = System.currentTimeMillis();
        }
    }
}
