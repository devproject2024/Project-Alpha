package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    long f3151a;

    /* renamed from: b  reason: collision with root package name */
    boolean f3152b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3153c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3154d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f3155e;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f3156f;

    public ContentLoadingProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3151a = -1;
        this.f3152b = false;
        this.f3153c = false;
        this.f3154d = false;
        this.f3155e = new Runnable() {
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.f3152b = false;
                contentLoadingProgressBar.f3151a = -1;
                contentLoadingProgressBar.setVisibility(8);
            }
        };
        this.f3156f = new Runnable() {
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.f3153c = false;
                if (!contentLoadingProgressBar.f3154d) {
                    ContentLoadingProgressBar.this.f3151a = System.currentTimeMillis();
                    ContentLoadingProgressBar.this.setVisibility(0);
                }
            }
        };
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    private void a() {
        removeCallbacks(this.f3155e);
        removeCallbacks(this.f3156f);
    }
}
