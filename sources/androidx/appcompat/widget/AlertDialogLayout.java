package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.h.u;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            r9 = this;
            int r10 = r9.getPaddingLeft()
            int r13 = r13 - r11
            int r11 = r9.getPaddingRight()
            int r11 = r13 - r11
            int r13 = r13 - r10
            int r0 = r9.getPaddingRight()
            int r13 = r13 - r0
            int r0 = r9.getMeasuredHeight()
            int r1 = r9.getChildCount()
            int r2 = r9.getGravity()
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L_0x0039
            r4 = 80
            if (r3 == r4) goto L_0x0030
            int r12 = r9.getPaddingTop()
            goto L_0x0043
        L_0x0030:
            int r3 = r9.getPaddingTop()
            int r3 = r3 + r14
            int r3 = r3 - r12
            int r12 = r3 - r0
            goto L_0x0043
        L_0x0039:
            int r3 = r9.getPaddingTop()
            int r14 = r14 - r12
            int r14 = r14 - r0
            int r14 = r14 / 2
            int r12 = r3 + r14
        L_0x0043:
            android.graphics.drawable.Drawable r14 = r9.getDividerDrawable()
            r0 = 0
            if (r14 != 0) goto L_0x004c
            r14 = 0
            goto L_0x0050
        L_0x004c:
            int r14 = r14.getIntrinsicHeight()
        L_0x0050:
            if (r0 >= r1) goto L_0x00ae
            android.view.View r3 = r9.getChildAt(r0)
            if (r3 == 0) goto L_0x00ab
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 == r5) goto L_0x00ab
            int r4 = r3.getMeasuredWidth()
            int r5 = r3.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r6 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r6
            int r7 = r6.f1552h
            if (r7 >= 0) goto L_0x0073
            r7 = r2
        L_0x0073:
            int r8 = androidx.core.h.u.j(r9)
            int r7 = androidx.core.h.e.a(r7, r8)
            r7 = r7 & 7
            r8 = 1
            if (r7 == r8) goto L_0x008c
            r8 = 5
            if (r7 == r8) goto L_0x0087
            int r7 = r6.leftMargin
            int r7 = r7 + r10
            goto L_0x0097
        L_0x0087:
            int r7 = r11 - r4
            int r8 = r6.rightMargin
            goto L_0x0096
        L_0x008c:
            int r7 = r13 - r4
            int r7 = r7 / 2
            int r7 = r7 + r10
            int r8 = r6.leftMargin
            int r7 = r7 + r8
            int r8 = r6.rightMargin
        L_0x0096:
            int r7 = r7 - r8
        L_0x0097:
            boolean r8 = r9.a((int) r0)
            if (r8 == 0) goto L_0x009e
            int r12 = r12 + r14
        L_0x009e:
            int r8 = r6.topMargin
            int r12 = r12 + r8
            int r4 = r4 + r7
            int r8 = r12 + r5
            r3.layout(r7, r12, r4, r8)
            int r3 = r6.bottomMargin
            int r5 = r5 + r3
            int r12 = r12 + r5
        L_0x00ab:
            int r0 = r0 + 1
            goto L_0x0050
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int childCount = getChildCount();
        boolean z = false;
        View view = null;
        View view2 = null;
        View view3 = null;
        int i10 = 0;
        while (true) {
            if (i10 < childCount) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    int id = childAt.getId();
                    if (id == R.id.topPanel) {
                        view = childAt;
                    } else if (id == R.id.buttonPanel) {
                        view2 = childAt;
                    } else if ((id == R.id.contentPanel || id == R.id.customPanel) && view3 == null) {
                        view3 = childAt;
                    }
                }
                i10++;
            } else {
                int mode = View.MeasureSpec.getMode(i3);
                int size = View.MeasureSpec.getSize(i3);
                int mode2 = View.MeasureSpec.getMode(i2);
                int paddingTop = getPaddingTop() + getPaddingBottom();
                if (view != null) {
                    view.measure(i9, 0);
                    paddingTop += view.getMeasuredHeight();
                    i4 = View.combineMeasuredStates(0, view.getMeasuredState());
                } else {
                    i4 = 0;
                }
                if (view2 != null) {
                    view2.measure(i9, 0);
                    View view4 = view2;
                    while (true) {
                        i5 = u.r(view4);
                        if (i5 <= 0) {
                            if (!(view4 instanceof ViewGroup)) {
                                break;
                            }
                            ViewGroup viewGroup = (ViewGroup) view4;
                            if (viewGroup.getChildCount() != 1) {
                                break;
                            }
                            view4 = viewGroup.getChildAt(0);
                        } else {
                            break;
                        }
                    }
                    i5 = 0;
                    i6 = view2.getMeasuredHeight() - i5;
                    paddingTop += i5;
                    i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
                } else {
                    i6 = 0;
                    i5 = 0;
                }
                if (view3 != null) {
                    if (mode == 0) {
                        i8 = 0;
                    } else {
                        i8 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
                    }
                    view3.measure(i9, i8);
                    i7 = view3.getMeasuredHeight();
                    paddingTop += i7;
                    i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
                } else {
                    i7 = 0;
                }
                int i11 = size - paddingTop;
                if (view2 != null) {
                    int i12 = paddingTop - i5;
                    int min = Math.min(i11, i6);
                    if (min > 0) {
                        i11 -= min;
                        i5 += min;
                    }
                    view2.measure(i9, View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                    paddingTop = i12 + view2.getMeasuredHeight();
                    i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
                }
                if (view3 != null && i11 > 0) {
                    view3.measure(i9, View.MeasureSpec.makeMeasureSpec(i7 + i11, mode));
                    paddingTop = (paddingTop - i7) + view3.getMeasuredHeight();
                    i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
                }
                int i13 = 0;
                for (int i14 = 0; i14 < childCount; i14++) {
                    View childAt2 = getChildAt(i14);
                    if (childAt2.getVisibility() != 8) {
                        i13 = Math.max(i13, childAt2.getMeasuredWidth());
                    }
                }
                setMeasuredDimension(View.resolveSizeAndState(i13 + getPaddingLeft() + getPaddingRight(), i9, i4), View.resolveSizeAndState(paddingTop, i3, 0));
                if (mode2 != 1073741824) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    for (int i15 = 0; i15 < childCount; i15++) {
                        View childAt3 = getChildAt(i15);
                        if (childAt3.getVisibility() != 8) {
                            LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt3.getLayoutParams();
                            if (layoutParams.width == -1) {
                                int i16 = layoutParams.height;
                                layoutParams.height = childAt3.getMeasuredHeight();
                                measureChildWithMargins(childAt3, makeMeasureSpec, 0, i3, 0);
                                layoutParams.height = i16;
                            }
                        }
                    }
                }
                z = true;
            }
        }
        int i17 = i3;
        if (!z) {
            super.onMeasure(i2, i3);
        }
    }
}
