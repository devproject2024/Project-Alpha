package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.b.a.c;
import androidx.core.h.x;
import androidx.core.widget.f;
import java.lang.reflect.Field;

public class DropDownListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    b f1529a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f1530b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private int f1531c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1532d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1533e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1534f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f1535g;

    /* renamed from: h  reason: collision with root package name */
    private Field f1536h;

    /* renamed from: i  reason: collision with root package name */
    private a f1537i;
    private boolean j;
    private boolean k;
    private boolean l;
    private x m;
    private f n;

    DropDownListView(Context context, boolean z) {
        super(context, (AttributeSet) null, R.attr.dropDownListViewStyle);
        this.k = z;
        setCacheColorHint(0);
        try {
            this.f1536h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1536h.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public boolean isInTouchMode() {
        return (this.k && this.j) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.k || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.k || super.isFocused();
    }

    public boolean hasFocus() {
        return this.k || super.hasFocus();
    }

    public void setSelector(Drawable drawable) {
        this.f1537i = drawable != null ? new a(drawable) : null;
        super.setSelector(this.f1537i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1531c = rect.left;
        this.f1532d = rect.top;
        this.f1533e = rect.right;
        this.f1534f = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1529a == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1535g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f1529a;
        if (bVar != null) {
            DropDownListView.this.f1529a = null;
            DropDownListView.this.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i8 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i9 = i8;
        View view = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < count) {
            int itemViewType = adapter.getItemViewType(i10);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(i10, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                i7 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                i7 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i2, i7);
            view.forceLayout();
            if (i10 > 0) {
                i9 += dividerHeight;
            }
            i9 += view.getMeasuredHeight();
            if (i9 >= i5) {
                return (i6 < 0 || i10 <= i6 || i12 <= 0 || i9 == i5) ? i5 : i12;
            }
            if (i6 >= 0 && i10 >= i6) {
                i12 = i9;
            }
            i10++;
        }
        return i9;
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.f1537i;
        if (aVar != null) {
            aVar.f1538b = z;
        }
    }

    static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        boolean f1538b = true;

        a(Drawable drawable) {
            super(drawable);
        }

        public final boolean setState(int[] iArr) {
            if (this.f1538b) {
                return super.setState(iArr);
            }
            return false;
        }

        public final void draw(Canvas canvas) {
            if (this.f1538b) {
                super.draw(canvas);
            }
        }

        public final void setHotspot(float f2, float f3) {
            if (this.f1538b) {
                super.setHotspot(f2, f3);
            }
        }

        public final void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f1538b) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        public final boolean setVisible(boolean z, boolean z2) {
            if (this.f1538b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1529a == null) {
            this.f1529a = new b();
            b bVar = this.f1529a;
            DropDownListView.this.post(bVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                a();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1529a = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r3 != 3) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            int r3 = r17.getActionMasked()
            r4 = 1
            r5 = 0
            if (r3 == r4) goto L_0x001a
            r0 = 2
            if (r3 == r0) goto L_0x0018
            r0 = 3
            if (r3 == r0) goto L_0x0016
        L_0x0012:
            r0 = 1
        L_0x0013:
            r4 = 0
            goto L_0x012f
        L_0x0016:
            r0 = 0
            goto L_0x0013
        L_0x0018:
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            int r6 = r17.findPointerIndex(r18)
            if (r6 >= 0) goto L_0x0022
            goto L_0x0016
        L_0x0022:
            float r7 = r2.getX(r6)
            int r7 = (int) r7
            float r6 = r2.getY(r6)
            int r6 = (int) r6
            int r8 = r1.pointToPosition(r7, r6)
            r9 = -1
            if (r8 != r9) goto L_0x0035
            goto L_0x012f
        L_0x0035:
            int r0 = r16.getFirstVisiblePosition()
            int r0 = r8 - r0
            android.view.View r10 = r1.getChildAt(r0)
            float r7 = (float) r7
            float r6 = (float) r6
            r1.l = r4
            int r0 = android.os.Build.VERSION.SDK_INT
            r11 = 21
            if (r0 < r11) goto L_0x004c
            r1.drawableHotspotChanged(r7, r6)
        L_0x004c:
            boolean r0 = r16.isPressed()
            if (r0 != 0) goto L_0x0055
            r1.setPressed(r4)
        L_0x0055:
            r16.layoutChildren()
            int r0 = r1.f1535g
            if (r0 == r9) goto L_0x0072
            int r12 = r16.getFirstVisiblePosition()
            int r0 = r0 - r12
            android.view.View r0 = r1.getChildAt(r0)
            if (r0 == 0) goto L_0x0072
            if (r0 == r10) goto L_0x0072
            boolean r12 = r0.isPressed()
            if (r12 == 0) goto L_0x0072
            r0.setPressed(r5)
        L_0x0072:
            r1.f1535g = r8
            int r0 = r10.getLeft()
            float r0 = (float) r0
            float r0 = r7 - r0
            int r12 = r10.getTop()
            float r12 = (float) r12
            float r12 = r6 - r12
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r11) goto L_0x0089
            r10.drawableHotspotChanged(r0, r12)
        L_0x0089:
            boolean r0 = r10.isPressed()
            if (r0 != 0) goto L_0x0092
            r10.setPressed(r4)
        L_0x0092:
            android.graphics.drawable.Drawable r11 = r16.getSelector()
            if (r11 == 0) goto L_0x009c
            if (r8 == r9) goto L_0x009c
            r12 = 1
            goto L_0x009d
        L_0x009c:
            r12 = 0
        L_0x009d:
            if (r12 == 0) goto L_0x00a2
            r11.setVisible(r5, r5)
        L_0x00a2:
            android.graphics.Rect r0 = r1.f1530b
            int r13 = r10.getLeft()
            int r14 = r10.getTop()
            int r15 = r10.getRight()
            int r4 = r10.getBottom()
            r0.set(r13, r14, r15, r4)
            int r4 = r0.left
            int r13 = r1.f1531c
            int r4 = r4 - r13
            r0.left = r4
            int r4 = r0.top
            int r13 = r1.f1532d
            int r4 = r4 - r13
            r0.top = r4
            int r4 = r0.right
            int r13 = r1.f1533e
            int r4 = r4 + r13
            r0.right = r4
            int r4 = r0.bottom
            int r13 = r1.f1534f
            int r4 = r4 + r13
            r0.bottom = r4
            java.lang.reflect.Field r0 = r1.f1536h     // Catch:{ IllegalAccessException -> 0x00f3 }
            boolean r0 = r0.getBoolean(r1)     // Catch:{ IllegalAccessException -> 0x00f3 }
            boolean r4 = r10.isEnabled()     // Catch:{ IllegalAccessException -> 0x00f3 }
            if (r4 == r0) goto L_0x00f7
            java.lang.reflect.Field r4 = r1.f1536h     // Catch:{ IllegalAccessException -> 0x00f3 }
            if (r0 != 0) goto L_0x00e5
            r0 = 1
            goto L_0x00e6
        L_0x00e5:
            r0 = 0
        L_0x00e6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ IllegalAccessException -> 0x00f3 }
            r4.set(r1, r0)     // Catch:{ IllegalAccessException -> 0x00f3 }
            if (r8 == r9) goto L_0x00f7
            r16.refreshDrawableState()     // Catch:{ IllegalAccessException -> 0x00f3 }
            goto L_0x00f7
        L_0x00f3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00f7:
            if (r12 == 0) goto L_0x0112
            android.graphics.Rect r0 = r1.f1530b
            float r4 = r0.exactCenterX()
            float r0 = r0.exactCenterY()
            int r12 = r16.getVisibility()
            if (r12 != 0) goto L_0x010b
            r12 = 1
            goto L_0x010c
        L_0x010b:
            r12 = 0
        L_0x010c:
            r11.setVisible(r12, r5)
            androidx.core.graphics.drawable.a.a(r11, r4, r0)
        L_0x0112:
            android.graphics.drawable.Drawable r0 = r16.getSelector()
            if (r0 == 0) goto L_0x011d
            if (r8 == r9) goto L_0x011d
            androidx.core.graphics.drawable.a.a(r0, r7, r6)
        L_0x011d:
            r1.setSelectorEnabled(r5)
            r16.refreshDrawableState()
            r4 = 1
            if (r3 != r4) goto L_0x0012
            long r3 = r1.getItemIdAtPosition(r8)
            r1.performItemClick(r10, r8, r3)
            goto L_0x0012
        L_0x012f:
            if (r0 == 0) goto L_0x0133
            if (r4 == 0) goto L_0x0155
        L_0x0133:
            r1.l = r5
            r1.setPressed(r5)
            r16.drawableStateChanged()
            int r3 = r1.f1535g
            int r4 = r16.getFirstVisiblePosition()
            int r3 = r3 - r4
            android.view.View r3 = r1.getChildAt(r3)
            if (r3 == 0) goto L_0x014b
            r3.setPressed(r5)
        L_0x014b:
            androidx.core.h.x r3 = r1.m
            if (r3 == 0) goto L_0x0155
            r3.b()
            r3 = 0
            r1.m = r3
        L_0x0155:
            if (r0 == 0) goto L_0x016e
            androidx.core.widget.f r3 = r1.n
            if (r3 != 0) goto L_0x0162
            androidx.core.widget.f r3 = new androidx.core.widget.f
            r3.<init>(r1)
            r1.n = r3
        L_0x0162:
            androidx.core.widget.f r3 = r1.n
            r4 = 1
            r3.a((boolean) r4)
            androidx.core.widget.f r3 = r1.n
            r3.onTouch(r1, r2)
            goto L_0x0175
        L_0x016e:
            androidx.core.widget.f r2 = r1.n
            if (r2 == 0) goto L_0x0175
            r2.a((boolean) r5)
        L_0x0175:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.a(android.view.MotionEvent, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.j = z;
    }

    private void a() {
        Drawable selector = getSelector();
        if (selector != null && this.l && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1529a = null;
            dropDownListView.drawableStateChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.f1530b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1530b);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }
}
