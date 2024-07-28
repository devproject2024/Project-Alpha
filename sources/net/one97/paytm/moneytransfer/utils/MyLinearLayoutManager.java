package net.one97.paytm.moneytransfer.utils;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f54141a;

    /* renamed from: b  reason: collision with root package name */
    private int f54142b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f54143c;

    public void onMeasure(RecyclerView.n nVar, RecyclerView.s sVar, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode == 1073741824;
        boolean z2 = mode2 == 1073741824;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (!z || !z2) {
            boolean z3 = getOrientation() == 1;
            int[] iArr = this.f54141a;
            if (iArr[0] == 0 && iArr[1] == 0) {
                if (z3) {
                    iArr[0] = size;
                    iArr[1] = this.f54142b;
                } else {
                    iArr[0] = this.f54142b;
                    iArr[1] = size2;
                }
            }
            nVar.a();
            int a2 = sVar.a();
            int itemCount = getItemCount();
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i8 >= itemCount) {
                    i4 = i9;
                    break;
                }
                if (!z3) {
                    i7 = i8;
                    i6 = itemCount;
                    if (!this.f54143c && i7 < a2) {
                        a(nVar, i7, makeMeasureSpec, i3, this.f54141a);
                    }
                    int[] iArr2 = this.f54141a;
                    i4 = i9 + iArr2[0];
                    if (i7 == 0) {
                        i10 = iArr2[1];
                    }
                    if (i4 >= size) {
                        break;
                    }
                    i9 = i4;
                } else {
                    if (this.f54143c || i8 >= a2) {
                        i7 = i8;
                        i6 = itemCount;
                    } else {
                        i7 = i8;
                        i6 = itemCount;
                        a(nVar, i8, i2, makeMeasureSpec, this.f54141a);
                    }
                    int[] iArr3 = this.f54141a;
                    i5 = i10 + iArr3[1];
                    if (i7 == 0) {
                        i9 = iArr3[0];
                    }
                    if (i5 >= size2) {
                        i4 = i9;
                        break;
                    }
                    i10 = i5;
                }
                i8 = i7 + 1;
                itemCount = i6;
            }
            i5 = i10;
            if ((!z3 || i5 >= size2) && (z3 || i4 >= size)) {
                super.onMeasure(nVar, sVar, i2, i3);
                return;
            }
            if (!z) {
                size = i4 + getPaddingLeft() + getPaddingRight();
            }
            if (!z2) {
                size2 = i5 + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(size, size2);
            return;
        }
        super.onMeasure(nVar, sVar, i2, i3);
    }

    public void setOrientation(int i2) {
        if (!(this.f54141a == null || getOrientation() == i2)) {
            int[] iArr = this.f54141a;
            iArr[0] = 0;
            iArr[1] = 0;
        }
        super.setOrientation(i2);
    }

    private void a(RecyclerView.n nVar, int i2, int i3, int i4, int[] iArr) {
        View b2 = nVar.b(i2);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) b2.getLayoutParams();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i5 = layoutParams.leftMargin + layoutParams.rightMargin;
        int i6 = layoutParams.topMargin + layoutParams.bottomMargin;
        b2.measure(getChildMeasureSpec(i3, paddingLeft + i5 + getRightDecorationWidth(b2) + getLeftDecorationWidth(b2), layoutParams.width, canScrollHorizontally()), getChildMeasureSpec(i4, paddingTop + i6 + getTopDecorationHeight(b2) + getBottomDecorationHeight(b2), layoutParams.height, canScrollVertically()));
        iArr[0] = getDecoratedMeasuredWidth(b2) + layoutParams.leftMargin + layoutParams.rightMargin;
        iArr[1] = getDecoratedMeasuredHeight(b2) + layoutParams.bottomMargin + layoutParams.topMargin;
        nVar.a(b2);
    }
}
