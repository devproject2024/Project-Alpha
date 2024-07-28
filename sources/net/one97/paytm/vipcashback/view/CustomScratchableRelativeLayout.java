package net.one97.paytm.vipcashback.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.jackpocket.scratchoff.views.ScratchableRelativeLayout;

public class CustomScratchableRelativeLayout extends ScratchableRelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f21034a;

    /* renamed from: b  reason: collision with root package name */
    private long f21035b;

    /* renamed from: c  reason: collision with root package name */
    private long f21036c;

    /* renamed from: d  reason: collision with root package name */
    private int f21037d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21038e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21039f = false;

    public interface a {
        void a();
    }

    public CustomScratchableRelativeLayout(Context context) {
        super(context);
    }

    public CustomScratchableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomScratchableRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f21035b = System.currentTimeMillis();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            if (getHeight() <= rect.height()) {
                this.f21039f = true;
                setEnabled(this.f21039f);
                getParent().requestDisallowInterceptTouchEvent(this.f21038e);
            } else {
                setEnabled(this.f21039f);
            }
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 3) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            if ((System.currentTimeMillis() - this.f21035b) + this.f21036c >= 2000) {
                b();
            }
        } else {
            this.f21037d++;
            this.f21036c += System.currentTimeMillis() - this.f21035b;
            if (this.f21036c >= 1500 && this.f21037d > 2) {
                b();
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setScratchLister(a aVar) {
        this.f21034a = aVar;
    }

    private void b() {
        a aVar = this.f21034a;
        if (aVar != null) {
            aVar.a();
            this.f21034a = null;
        }
    }

    public final void a() {
        this.f21038e = false;
    }
}
