package com.paytm.android.chat.view.kpswitch.a;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.android.chat.view.kpswitch.a;
import com.paytm.utility.q;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f42596a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final View f42597b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42598c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f42599d;

    /* renamed from: e  reason: collision with root package name */
    private a f42600e;

    public c(View view) {
        this.f42597b = view;
        this.f42598c = com.paytm.android.chat.view.kpswitch.b.c.a(view.getContext());
        Activity activity = (Activity) view.getContext();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & 67108864) != 0) {
            z = true;
        }
        this.f42599d = z;
    }

    public final void a(int i2, int i3) {
        if (this.f42599d && Build.VERSION.SDK_INT >= 16 && this.f42597b.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.f42597b.getWindowVisibleDisplayFrame(rect);
            i3 = rect.bottom - rect.top;
        }
        q.d("onMeasure, width: " + i2 + " height: " + i3);
        if (i3 >= 0) {
            int i4 = this.f42596a;
            if (i4 < 0) {
                this.f42596a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                q.d(i5 + " == 0 break;");
            } else if (Math.abs(i5) == this.f42598c) {
                String.format("offset just equal statusBar height %d", new Object[]{Integer.valueOf(i5)});
                q.c();
            } else {
                this.f42596a = i3;
                a a2 = a(this.f42597b);
                if (a2 == null) {
                    q.c();
                } else if (Math.abs(i5) < com.paytm.android.chat.view.kpswitch.b.a.a(this.f42597b.getContext())) {
                    q.c();
                } else if (i5 > 0) {
                    a2.d();
                } else if (a2.a() && a2.b()) {
                    a2.c();
                }
            }
        }
    }

    private a a(View view) {
        a aVar = this.f42600e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof a) {
            this.f42600e = (a) view;
            return this.f42600e;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    return null;
                }
                a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f42600e = a2;
                    return this.f42600e;
                }
                i2++;
            }
        }
    }
}
