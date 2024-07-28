package net.one97.paytm.common.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.core.h.u;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CJRHorizontalListView extends AdapterView<ListAdapter> {
    /* access modifiers changed from: private */
    public boolean A = false;
    private boolean B = false;
    /* access modifiers changed from: private */
    public View.OnClickListener C;
    private DataSetObserver D = new DataSetObserver() {
        public final void onChanged() {
            boolean unused = CJRHorizontalListView.this.f49717i = true;
            boolean unused2 = CJRHorizontalListView.this.u = false;
            CJRHorizontalListView.this.d();
            CJRHorizontalListView.this.invalidate();
            CJRHorizontalListView.this.requestLayout();
        }

        public final void onInvalidated() {
            boolean unused = CJRHorizontalListView.this.u = false;
            CJRHorizontalListView.this.d();
            CJRHorizontalListView.this.b();
            CJRHorizontalListView.this.invalidate();
            CJRHorizontalListView.this.requestLayout();
        }
    };
    private Runnable E = new Runnable() {
        public final void run() {
            CJRHorizontalListView.this.requestLayout();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected Scroller f49709a = new Scroller(getContext());

    /* renamed from: b  reason: collision with root package name */
    protected ListAdapter f49710b;

    /* renamed from: c  reason: collision with root package name */
    protected int f49711c;

    /* renamed from: d  reason: collision with root package name */
    protected int f49712d;

    /* renamed from: e  reason: collision with root package name */
    private final a f49713e = new a(this, (byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f49714f;

    /* renamed from: g  reason: collision with root package name */
    private int f49715g;

    /* renamed from: h  reason: collision with root package name */
    private List<Queue<View>> f49716h = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f49717i = false;
    private Rect j = new Rect();
    private View k = null;
    private int l = 0;
    private Drawable m = null;
    private Integer n = null;
    private int o = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public int p;
    private int q;
    private int r;
    private e s = null;
    private int t = 0;
    /* access modifiers changed from: private */
    public boolean u = false;
    private d v = null;
    private d.a w = d.a.SCROLL_STATE_IDLE;
    private androidx.core.widget.d x;
    private androidx.core.widget.d y;
    private int z;

    public interface d {

        public enum a {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }
    }

    public interface e {
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z2) {
    }

    public CJRHorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new androidx.core.widget.d(context);
        this.y = new androidx.core.widget.d(context);
        this.f49714f = new GestureDetector(context, this.f49713e);
        setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CJRHorizontalListView.this.f49714f.onTouchEvent(motionEvent);
            }
        });
        a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CJRHorizontalListView);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CJRHorizontalListView_android_divider);
            if (drawable != null) {
                setDivider(drawable);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CJRHorizontalListView_dividerWidth, 0);
            if (dimensionPixelSize != 0) {
                setDividerWidth(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            b.a(this.f49709a);
        }
    }

    /* access modifiers changed from: private */
    public void a(Boolean bool) {
        if (this.B != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.B = bool.booleanValue();
                    return;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.f49711c);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.n = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    public void setDivider(Drawable drawable) {
        this.m = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i2) {
        this.l = i2;
        requestLayout();
        invalidate();
    }

    private void a() {
        this.p = -1;
        this.q = -1;
        this.f49715g = 0;
        this.f49711c = 0;
        this.f49712d = 0;
        this.o = Integer.MAX_VALUE;
        setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
    }

    /* access modifiers changed from: private */
    public void b() {
        a();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i2) {
        this.r = i2;
    }

    public View getSelectedView() {
        int i2 = this.r;
        int i3 = this.p;
        if (i2 < i3 || i2 > this.q) {
            return null;
        }
        return getChildAt(i2 - i3);
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f49710b;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.D);
        }
        if (listAdapter != null) {
            this.u = false;
            this.f49710b = listAdapter;
            this.f49710b.registerDataSetObserver(this.D);
        }
        int viewTypeCount = this.f49710b.getViewTypeCount();
        this.f49716h.clear();
        for (int i2 = 0; i2 < viewTypeCount; i2++) {
            this.f49716h.add(new LinkedList());
        }
        b();
    }

    public ListAdapter getAdapter() {
        return this.f49710b;
    }

    private View a(int i2) {
        int itemViewType = this.f49710b.getItemViewType(i2);
        if (b(itemViewType)) {
            return (View) this.f49716h.get(itemViewType).poll();
        }
        return null;
    }

    private void a(int i2, View view) {
        int itemViewType = this.f49710b.getItemViewType(i2);
        if (b(itemViewType)) {
            this.f49716h.get(itemViewType).offer(view);
        }
    }

    private boolean b(int i2) {
        return i2 < this.f49716h.size();
    }

    private void a(View view, int i2) {
        int i3;
        addViewInLayout(view, i2, a(view), true);
        ViewGroup.LayoutParams a2 = a(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.z, getPaddingTop() + getPaddingBottom(), a2.height);
        if (a2.width > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(a2.width, 1073741824);
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i3, childMeasureSpec);
    }

    private static ViewGroup.LayoutParams a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        View rightmostChild;
        int i8;
        ListAdapter listAdapter;
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.f49710b != null) {
            invalidate();
            boolean z3 = false;
            if (this.f49717i) {
                int i9 = this.f49711c;
                a();
                removeAllViewsInLayout();
                this.f49712d = i9;
                this.f49717i = false;
            }
            Integer num = this.n;
            if (num != null) {
                this.f49712d = num.intValue();
                this.n = null;
            }
            if (this.f49709a.computeScrollOffset()) {
                this.f49712d = this.f49709a.getCurrX();
            }
            int i10 = this.f49712d;
            if (i10 < 0) {
                this.f49712d = 0;
                if (this.x.f3191a.isFinished()) {
                    this.x.a((int) c());
                }
                this.f49709a.forceFinished(true);
                setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
            } else {
                int i11 = this.o;
                if (i10 > i11) {
                    this.f49712d = i11;
                    if (this.y.f3191a.isFinished()) {
                        this.y.a((int) c());
                    }
                    this.f49709a.forceFinished(true);
                    setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
                }
            }
            int i12 = this.f49711c - this.f49712d;
            View leftmostChild = getLeftmostChild();
            while (leftmostChild != null && leftmostChild.getRight() + i12 <= 0) {
                this.f49715g += c(this.p) ? leftmostChild.getMeasuredWidth() : this.l + leftmostChild.getMeasuredWidth();
                a(this.p, leftmostChild);
                removeViewInLayout(leftmostChild);
                this.p++;
                leftmostChild = getLeftmostChild();
            }
            while (true) {
                View rightmostChild2 = getRightmostChild();
                if (rightmostChild2 == null || rightmostChild2.getLeft() + i12 < getWidth()) {
                    View rightmostChild3 = getRightmostChild();
                } else {
                    a(this.q, rightmostChild2);
                    removeViewInLayout(rightmostChild2);
                    this.q--;
                }
            }
            View rightmostChild32 = getRightmostChild();
            if (rightmostChild32 != null) {
                i6 = rightmostChild32.getRight();
            } else {
                i6 = 0;
            }
            while (i6 + i12 + this.l < getWidth() && this.q + 1 < this.f49710b.getCount()) {
                this.q++;
                if (this.p < 0) {
                    this.p = this.q;
                }
                try {
                    View view = this.f49710b.getView(this.q, a(this.q), this);
                    a(view, -1);
                    i6 += (this.q == 0 ? 0 : this.l) + view.getMeasuredWidth();
                } catch (IndexOutOfBoundsException e2) {
                    q.b(e2.getMessage());
                }
                if (this.s != null && (listAdapter = this.f49710b) != null && listAdapter.getCount() - (this.q + 1) < this.t && !this.u) {
                    this.u = true;
                }
            }
            View leftmostChild2 = getLeftmostChild();
            if (leftmostChild2 != null) {
                i7 = leftmostChild2.getLeft();
            } else {
                i7 = 0;
            }
            while ((i7 + i12) - this.l > 0 && (i8 = this.p) > 0) {
                this.p = i8 - 1;
                try {
                    View view2 = this.f49710b.getView(this.p, a(this.p), this);
                    a(view2, 0);
                    i7 -= this.p == 0 ? view2.getMeasuredWidth() : this.l + view2.getMeasuredWidth();
                    this.f49715g -= i7 + i12 == 0 ? view2.getMeasuredWidth() : view2.getMeasuredWidth() + this.l;
                } catch (IndexOutOfBoundsException e3) {
                    q.b(e3.getMessage());
                }
            }
            int childCount = getChildCount();
            if (childCount > 0) {
                this.f49715g += i12;
                int i13 = this.f49715g;
                for (int i14 = 0; i14 < childCount; i14++) {
                    View childAt = getChildAt(i14);
                    int paddingLeft = getPaddingLeft() + i13;
                    int paddingTop = getPaddingTop();
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    i13 += childAt.getMeasuredWidth() + this.l;
                }
            }
            this.f49711c = this.f49712d;
            if (c(this.q) && (rightmostChild = getRightmostChild()) != null) {
                int i15 = this.o;
                this.o = (this.f49711c + (rightmostChild.getRight() - getPaddingLeft())) - getRenderWidth();
                if (this.o < 0) {
                    this.o = 0;
                }
                if (this.o != i15) {
                    z3 = true;
                }
            }
            if (z3) {
                onLayout(z2, i2, i3, i4, i5);
            } else if (!this.f49709a.isFinished()) {
                u.a((View) this, this.E);
            } else if (this.w == d.a.SCROLL_STATE_FLING) {
                setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.f49711c;
        if (i2 == 0) {
            return 0.0f;
        }
        if (i2 < horizontalFadingEdgeLength) {
            return ((float) i2) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.f49711c;
        int i3 = this.o;
        if (i2 == i3) {
            return 0.0f;
        }
        if (i3 - i2 < horizontalFadingEdgeLength) {
            return ((float) (i3 - i2)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    private float c() {
        if (Build.VERSION.SDK_INT >= 14) {
            return c.a(this.f49709a);
        }
        return 30.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.z = i3;
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    /* access modifiers changed from: private */
    public int a(int i2, int i3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).getHitRect(this.j);
            if (this.j.contains(i2, i3)) {
                return i4;
            }
        }
        return -1;
    }

    private boolean c(int i2) {
        return i2 == this.f49710b.getCount() - 1;
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getFirstVisiblePosition() {
        return this.p;
    }

    public int getLastVisiblePosition() {
        return this.q;
    }

    private void a(Canvas canvas, Rect rect) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(rect);
            this.m.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.j;
        rect.top = getPaddingTop();
        Rect rect2 = this.j;
        rect2.bottom = rect2.top + getRenderHeight();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i2 != childCount - 1 || !c(this.q)) {
                View childAt = getChildAt(i2);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.l;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i2 == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        androidx.core.widget.d dVar = this.x;
        if (dVar == null || dVar.f3191a.isFinished() || !f()) {
            androidx.core.widget.d dVar2 = this.y;
            if (dVar2 != null && !dVar2.f3191a.isFinished() && f()) {
                int save = canvas.save();
                int width = getWidth();
                canvas.rotate(90.0f, 0.0f, 0.0f);
                canvas.translate((float) getPaddingTop(), (float) (-width));
                this.y.a(getRenderHeight(), getRenderWidth());
                if (this.y.a(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
                return;
            }
            return;
        }
        int save2 = canvas.save();
        int height = getHeight();
        canvas.rotate(-90.0f, 0.0f, 0.0f);
        canvas.translate((float) ((-height) + getPaddingBottom()), 0.0f);
        this.x.a(getRenderHeight(), getRenderWidth());
        if (this.x.a(canvas)) {
            invalidate();
        }
        canvas.restoreToCount(save2);
    }

    /* access modifiers changed from: protected */
    public final boolean a(float f2) {
        this.f49709a.fling(this.f49712d, 0, (int) (-f2), 0, 0, this.o, 0, 0);
        setCurrentScrollState(d.a.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean a(MotionEvent motionEvent) {
        int a2;
        this.A = !this.f49709a.isFinished();
        this.f49709a.forceFinished(true);
        setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
        d();
        if (!this.A && (a2 = a((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            this.k = getChildAt(a2);
            View view = this.k;
            if (view != null) {
                view.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void d() {
        View view = this.k;
        if (view != null) {
            view.setPressed(false);
            refreshDrawableState();
            this.k = null;
        }
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(CJRHorizontalListView cJRHorizontalListView, byte b2) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return CJRHorizontalListView.this.a(motionEvent);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return CJRHorizontalListView.this.a(f2);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            CJRHorizontalListView.this.a(Boolean.TRUE);
            CJRHorizontalListView.this.setCurrentScrollState(d.a.SCROLL_STATE_TOUCH_SCROLL);
            CJRHorizontalListView.this.d();
            CJRHorizontalListView.this.f49712d += (int) f2;
            CJRHorizontalListView.a(CJRHorizontalListView.this, Math.round(f2));
            CJRHorizontalListView.this.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            CJRHorizontalListView.this.d();
            AdapterView.OnItemClickListener onItemClickListener = CJRHorizontalListView.this.getOnItemClickListener();
            int a2 = CJRHorizontalListView.this.a((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a2 >= 0 && !CJRHorizontalListView.this.A) {
                View childAt = CJRHorizontalListView.this.getChildAt(a2);
                int g2 = CJRHorizontalListView.this.p + a2;
                if (onItemClickListener != null) {
                    CJRHorizontalListView cJRHorizontalListView = CJRHorizontalListView.this;
                    onItemClickListener.onItemClick(cJRHorizontalListView, childAt, g2, cJRHorizontalListView.f49710b.getItemId(g2));
                    return true;
                }
            }
            if (CJRHorizontalListView.this.C == null || CJRHorizontalListView.this.A) {
                return false;
            }
            CJRHorizontalListView.this.C.onClick(CJRHorizontalListView.this);
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            CJRHorizontalListView.this.d();
            int a2 = CJRHorizontalListView.this.a((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a2 >= 0 && !CJRHorizontalListView.this.A) {
                View childAt = CJRHorizontalListView.this.getChildAt(a2);
                AdapterView.OnItemLongClickListener onItemLongClickListener = CJRHorizontalListView.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int g2 = CJRHorizontalListView.this.p + a2;
                    CJRHorizontalListView cJRHorizontalListView = CJRHorizontalListView.this;
                    if (onItemLongClickListener.onItemLongClick(cJRHorizontalListView, childAt, g2, cJRHorizontalListView.f49710b.getItemId(g2))) {
                        CJRHorizontalListView.this.performHapticFeedback(0);
                    }
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Scroller scroller = this.f49709a;
            if (scroller == null || scroller.isFinished()) {
                setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
            }
            a(Boolean.FALSE);
            e();
        } else if (motionEvent.getAction() == 3) {
            d();
            e();
            a(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void e() {
        androidx.core.widget.d dVar = this.x;
        if (dVar != null) {
            dVar.a();
        }
        androidx.core.widget.d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.a();
        }
    }

    public void setRunningOutOfDataListener(e eVar, int i2) {
        this.s = eVar;
        this.t = i2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public void setOnScrollStateChangedListener(d dVar) {
        this.v = dVar;
    }

    /* access modifiers changed from: private */
    public void setCurrentScrollState(d.a aVar) {
        this.w = aVar;
    }

    private boolean f() {
        ListAdapter listAdapter = this.f49710b;
        if (listAdapter == null || listAdapter.isEmpty() || this.o <= 0) {
            return false;
        }
        return true;
    }

    static final class b {
        static {
            if (Build.VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller) {
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
        }
    }

    static final class c {
        static {
            if (Build.VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        public static float a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    static /* synthetic */ void a(CJRHorizontalListView cJRHorizontalListView, int i2) {
        if (cJRHorizontalListView.x != null && cJRHorizontalListView.y != null) {
            int i3 = cJRHorizontalListView.f49711c + i2;
            Scroller scroller = cJRHorizontalListView.f49709a;
            if (scroller != null && !scroller.isFinished()) {
                return;
            }
            if (i3 < 0) {
                cJRHorizontalListView.x.a(((float) Math.abs(i2)) / ((float) cJRHorizontalListView.getRenderWidth()));
                if (!cJRHorizontalListView.y.f3191a.isFinished()) {
                    cJRHorizontalListView.y.a();
                }
            } else if (i3 > cJRHorizontalListView.o) {
                cJRHorizontalListView.y.a(((float) Math.abs(i2)) / ((float) cJRHorizontalListView.getRenderWidth()));
                if (!cJRHorizontalListView.x.f3191a.isFinished()) {
                    cJRHorizontalListView.x.a();
                }
            }
        }
    }
}
