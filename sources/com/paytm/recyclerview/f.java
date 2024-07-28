package com.paytm.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.paytm.recyclerview.RecyclerView;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f15353a;

    /* renamed from: b  reason: collision with root package name */
    final a f15354b = new a() {
        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            if (!f.this.a() && f.this.f15353a.getLayoutManager() != null) {
                RecyclerView.LayoutManager layoutManager = f.this.f15353a.getLayoutManager();
                RecyclerView.q b2 = RecyclerView.b(view);
                if (b2 != null && !b2.n() && !layoutManager.f15223h.d(b2.f15282a)) {
                    cVar.b((Object) c.C0046c.a(layoutManager.d() ? RecyclerView.LayoutManager.a(view) : 0, 1, layoutManager.c() ? RecyclerView.LayoutManager.a(view) : 0, 1, false, false));
                }
            }
        }

        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            if (!f.this.a() && f.this.f15353a.getLayoutManager() != null) {
                f.this.f15353a.getLayoutManager();
            }
            return false;
        }
    };

    public f(RecyclerView recyclerView) {
        this.f15353a = recyclerView;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        RecyclerView recyclerView = this.f15353a;
        return !recyclerView.f15212g || recyclerView.f15213h || recyclerView.f15208c.d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performAccessibilityAction(android.view.View r4, int r5, android.os.Bundle r6) {
        /*
            r3 = this;
            boolean r4 = super.performAccessibilityAction(r4, r5, r6)
            r6 = 1
            if (r4 == 0) goto L_0x0008
            return r6
        L_0x0008:
            boolean r4 = r3.a()
            r0 = 0
            if (r4 != 0) goto L_0x0090
            com.paytm.recyclerview.RecyclerView r4 = r3.f15353a
            com.paytm.recyclerview.RecyclerView$LayoutManager r4 = r4.getLayoutManager()
            if (r4 == 0) goto L_0x0090
            com.paytm.recyclerview.RecyclerView r4 = r3.f15353a
            com.paytm.recyclerview.RecyclerView$LayoutManager r4 = r4.getLayoutManager()
            com.paytm.recyclerview.RecyclerView r1 = r4.f15224i
            if (r1 != 0) goto L_0x0022
            return r0
        L_0x0022:
            r1 = 4096(0x1000, float:5.74E-42)
            if (r5 == r1) goto L_0x005b
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r5 == r1) goto L_0x002d
            r5 = 0
        L_0x002b:
            r1 = 0
            goto L_0x0085
        L_0x002d:
            com.paytm.recyclerview.RecyclerView r5 = r4.f15224i
            r1 = -1
            boolean r5 = androidx.core.h.u.b((android.view.View) r5, (int) r1)
            if (r5 == 0) goto L_0x0044
            int r5 = r4.o
            int r2 = r4.j()
            int r5 = r5 - r2
            int r2 = r4.l()
            int r5 = r5 - r2
            int r5 = -r5
            goto L_0x0045
        L_0x0044:
            r5 = 0
        L_0x0045:
            com.paytm.recyclerview.RecyclerView r2 = r4.f15224i
            boolean r1 = androidx.core.h.u.a((android.view.View) r2, (int) r1)
            if (r1 == 0) goto L_0x002b
            int r1 = r4.n
            int r2 = r4.i()
            int r1 = r1 - r2
            int r2 = r4.k()
            int r1 = r1 - r2
            int r1 = -r1
            goto L_0x0085
        L_0x005b:
            com.paytm.recyclerview.RecyclerView r5 = r4.f15224i
            boolean r5 = androidx.core.h.u.b((android.view.View) r5, (int) r6)
            if (r5 == 0) goto L_0x0070
            int r5 = r4.o
            int r1 = r4.j()
            int r5 = r5 - r1
            int r1 = r4.l()
            int r5 = r5 - r1
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            com.paytm.recyclerview.RecyclerView r1 = r4.f15224i
            boolean r1 = androidx.core.h.u.a((android.view.View) r1, (int) r6)
            if (r1 == 0) goto L_0x002b
            int r1 = r4.n
            int r2 = r4.i()
            int r1 = r1 - r2
            int r2 = r4.k()
            int r1 = r1 - r2
        L_0x0085:
            if (r5 != 0) goto L_0x008a
            if (r1 != 0) goto L_0x008a
            return r0
        L_0x008a:
            com.paytm.recyclerview.RecyclerView r4 = r4.f15224i
            r4.scrollBy(r1, r5)
            return r6
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.f.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        cVar.b((CharSequence) RecyclerView.class.getName());
        if (!a() && this.f15353a.getLayoutManager() != null) {
            RecyclerView.LayoutManager layoutManager = this.f15353a.getLayoutManager();
            int i2 = 1;
            if (u.b((View) layoutManager.f15224i, -1) || u.a((View) layoutManager.f15224i, -1)) {
                cVar.a((int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                cVar.j(true);
            }
            if (u.b((View) layoutManager.f15224i, 1) || u.a((View) layoutManager.f15224i, 1)) {
                cVar.a(4096);
                cVar.j(true);
            }
            int c2 = (layoutManager.f15224i == null || layoutManager.f15224i.y == null || !layoutManager.d()) ? 1 : layoutManager.f15224i.y.c();
            if (!(layoutManager.f15224i == null || layoutManager.f15224i.y == null || !layoutManager.c())) {
                i2 = layoutManager.f15224i.y.c();
            }
            cVar.a((Object) c.b.a(c2, i2, false, 0));
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }
}
