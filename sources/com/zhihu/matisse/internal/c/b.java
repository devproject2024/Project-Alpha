package com.zhihu.matisse.internal.c;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.paytm.utility.q;

public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public a f45737a;

    /* renamed from: b  reason: collision with root package name */
    public View f45738b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45739c = false;

    /* renamed from: d  reason: collision with root package name */
    private Window f45740d;

    public interface a {
        void a(boolean z, int i2);
    }

    public static b a(Activity activity) {
        return new b(activity);
    }

    private b(Object obj) {
        if (obj == null) {
            q.d("contextObj is null");
            return;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            this.f45738b = activity.findViewById(16908290);
            this.f45740d = activity.getWindow();
        }
        View view = this.f45738b;
        if (view != null && this.f45740d != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    public final void onGlobalLayout() {
        View view = this.f45738b;
        if (view != null && this.f45740d != null) {
            if (view.getHeight() == 0) {
                q.d("currHeight is 0");
                return;
            }
            Display defaultDisplay = this.f45740d.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            int i2 = point.y;
            Rect rect = new Rect();
            this.f45740d.getDecorView().getWindowVisibleDisplayFrame(rect);
            int i3 = rect.bottom;
            int i4 = i2 - i3;
            q.d("onGlobalLayout() called  screenHeight " + i2 + " VisibleDisplayHeight " + i3);
            if (this.f45737a != null) {
                boolean z = i4 > 300;
                if (this.f45739c != z) {
                    this.f45739c = z;
                    this.f45737a.a(z, i4);
                }
            }
        }
    }
}
