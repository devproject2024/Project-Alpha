package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f5014a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayoutManager f5015b;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f5014a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f5015b = linearLayoutManager;
    }

    private boolean b() {
        int childCount = this.f5015b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (a(this.f5015b.getChildAt(i2))) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        if (r4[r0 - 1][1] >= r3) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r11 = this;
            androidx.recyclerview.widget.LinearLayoutManager r0 = r11.f5015b
            int r0 = r0.getChildCount()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00a0
            androidx.recyclerview.widget.LinearLayoutManager r3 = r11.f5015b
            int r3 = r3.getOrientation()
            if (r3 != 0) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            r4 = 2
            int[] r4 = new int[]{r0, r4}
            java.lang.Class<int> r5 = int.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r5, r4)
            int[][] r4 = (int[][]) r4
            r5 = 0
        L_0x0023:
            if (r5 >= r0) goto L_0x006d
            androidx.recyclerview.widget.LinearLayoutManager r6 = r11.f5015b
            android.view.View r6 = r6.getChildAt(r5)
            if (r6 == 0) goto L_0x0065
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            boolean r8 = r7 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r8 == 0) goto L_0x0038
            android.view.ViewGroup$MarginLayoutParams r7 = (android.view.ViewGroup.MarginLayoutParams) r7
            goto L_0x003a
        L_0x0038:
            android.view.ViewGroup$MarginLayoutParams r7 = f5014a
        L_0x003a:
            r8 = r4[r5]
            if (r3 == 0) goto L_0x0045
            int r9 = r6.getLeft()
            int r10 = r7.leftMargin
            goto L_0x004b
        L_0x0045:
            int r9 = r6.getTop()
            int r10 = r7.topMargin
        L_0x004b:
            int r9 = r9 - r10
            r8[r1] = r9
            r8 = r4[r5]
            if (r3 == 0) goto L_0x0059
            int r6 = r6.getRight()
            int r7 = r7.rightMargin
            goto L_0x005f
        L_0x0059:
            int r6 = r6.getBottom()
            int r7 = r7.bottomMargin
        L_0x005f:
            int r6 = r6 + r7
            r8[r2] = r6
            int r5 = r5 + 1
            goto L_0x0023
        L_0x0065:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "null view contained in the view hierarchy"
            r0.<init>(r1)
            throw r0
        L_0x006d:
            androidx.viewpager2.widget.a$1 r3 = new androidx.viewpager2.widget.a$1
            r3.<init>()
            java.util.Arrays.sort(r4, r3)
            r3 = 1
        L_0x0076:
            if (r3 >= r0) goto L_0x0088
            int r5 = r3 + -1
            r5 = r4[r5]
            r5 = r5[r2]
            r6 = r4[r3]
            r6 = r6[r1]
            if (r5 == r6) goto L_0x0085
            goto L_0x009e
        L_0x0085:
            int r3 = r3 + 1
            goto L_0x0076
        L_0x0088:
            r3 = r4[r1]
            r3 = r3[r2]
            r5 = r4[r1]
            r5 = r5[r1]
            int r3 = r3 - r5
            r5 = r4[r1]
            r5 = r5[r1]
            if (r5 > 0) goto L_0x009e
            int r0 = r0 - r2
            r0 = r4[r0]
            r0 = r0[r2]
            if (r0 >= r3) goto L_0x00a0
        L_0x009e:
            r0 = 0
            goto L_0x00a1
        L_0x00a0:
            r0 = 1
        L_0x00a1:
            if (r0 == 0) goto L_0x00ab
            androidx.recyclerview.widget.LinearLayoutManager r0 = r11.f5015b
            int r0 = r0.getChildCount()
            if (r0 > r2) goto L_0x00b2
        L_0x00ab:
            boolean r0 = r11.b()
            if (r0 == 0) goto L_0x00b2
            return r2
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.a.a():boolean");
    }
}
