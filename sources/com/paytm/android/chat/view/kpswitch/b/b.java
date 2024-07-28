package com.paytm.android.chat.view.kpswitch.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.paytm.utility.q;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    View f42605a;

    /* renamed from: b  reason: collision with root package name */
    int f42606b;

    /* renamed from: c  reason: collision with root package name */
    a f42607c;

    public interface a {
        void a();

        void b();
    }

    private b(Activity activity) {
        this.f42605a = activity.getWindow().getDecorView();
        this.f42605a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.f42605a.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                q.a(String.valueOf(height));
                if (b.this.f42606b == 0) {
                    b.this.f42606b = height;
                } else if (b.this.f42606b != height) {
                    if (b.this.f42606b - height > 400) {
                        if (b.this.f42607c != null) {
                            b.this.f42607c.a();
                        }
                        b.this.f42606b = height;
                    } else if (height - b.this.f42606b > 400) {
                        if (b.this.f42607c != null) {
                            b.this.f42607c.b();
                        }
                        b.this.f42606b = height;
                    }
                }
            }
        });
    }

    public static void a(Activity activity, a aVar) {
        new b(activity).f42607c = aVar;
    }
}
