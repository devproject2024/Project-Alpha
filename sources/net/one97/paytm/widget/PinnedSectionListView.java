package net.one97.paytm.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.paytm.utility.q;
import net.one97.paytm.utils.l;

public class PinnedSectionListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    AbsListView.OnScrollListener f72355a;

    /* renamed from: b  reason: collision with root package name */
    a f72356b;

    /* renamed from: c  reason: collision with root package name */
    a f72357c;

    /* renamed from: d  reason: collision with root package name */
    int f72358d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f72359e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final PointF f72360f = new PointF();

    /* renamed from: g  reason: collision with root package name */
    private int f72361g;

    /* renamed from: h  reason: collision with root package name */
    private View f72362h;

    /* renamed from: i  reason: collision with root package name */
    private MotionEvent f72363i;
    private GradientDrawable j;
    private int k;
    private int l;
    private final AbsListView.OnScrollListener m = new AbsListView.OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (PinnedSectionListView.this.f72355a != null) {
                PinnedSectionListView.this.f72355a.onScrollStateChanged(absListView, i2);
            }
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (PinnedSectionListView.this.f72355a != null) {
                PinnedSectionListView.this.f72355a.onScroll(absListView, i2, i3, i4);
            }
            ListAdapter adapter = PinnedSectionListView.this.getAdapter();
            if (adapter != null && i3 != 0) {
                adapter.getItemViewType(i2);
                if (!PinnedSectionListView.a(adapter)) {
                    int a2 = PinnedSectionListView.this.a(i2);
                    if (a2 >= 0) {
                        PinnedSectionListView.this.a(a2, i2, i3);
                        return;
                    }
                } else if (PinnedSectionListView.this.getChildAt(0).getTop() != PinnedSectionListView.this.getPaddingTop()) {
                    PinnedSectionListView.this.a(i2, i2, i3);
                    return;
                }
                PinnedSectionListView.this.a();
            }
        }
    };
    private final DataSetObserver n = new DataSetObserver() {
        public final void onChanged() {
            PinnedSectionListView.this.b();
        }

        public final void onInvalidated() {
            PinnedSectionListView.this.b();
        }
    };

    public interface b extends ListAdapter {
        boolean a();
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f72367a;

        /* renamed from: b  reason: collision with root package name */
        public int f72368b;

        /* renamed from: c  reason: collision with root package name */
        public long f72369c;

        a() {
        }
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        setOnScrollListener(this.m);
        this.f72361g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        a(true);
    }

    public void setShadowVisible(boolean z) {
        a(z);
        a aVar = this.f72357c;
        if (aVar != null) {
            View view = aVar.f72367a;
            invalidate(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() + this.l);
        }
    }

    private void a(boolean z) {
        if (z) {
            if (this.j == null) {
                this.j = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0")});
                this.l = (int) (getResources().getDisplayMetrics().density * 8.0f);
            }
        } else if (this.j != null) {
            this.j = null;
            this.l = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a aVar = this.f72357c;
        if (aVar != null) {
            this.f72356b = aVar;
            this.f72357c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4) {
        if (i4 < 2) {
            a();
            return;
        }
        a aVar = this.f72357c;
        if (!(aVar == null || aVar.f72368b == i2)) {
            a();
        }
        if (this.f72357c == null) {
            try {
                a aVar2 = this.f72356b;
                this.f72356b = null;
                if (aVar2 == null) {
                    aVar2 = new a();
                }
                View view = getAdapter().getView(i2, aVar2.f72367a, this);
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    if (generateDefaultLayoutParams() instanceof AbsListView.LayoutParams) {
                        layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
                    } else {
                        layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
                    }
                    view.setLayoutParams(layoutParams);
                }
                int mode = View.MeasureSpec.getMode(layoutParams.height);
                int size = View.MeasureSpec.getSize(layoutParams.height);
                if (mode == 0) {
                    mode = 1073741824;
                }
                int height = (getHeight() - getListPaddingTop()) - getListPaddingBottom();
                if (size > height) {
                    size = height;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec((getWidth() - getListPaddingLeft()) - getListPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(size, mode));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                this.f72358d = 0;
                aVar2.f72367a = view;
                aVar2.f72368b = i2;
                aVar2.f72369c = getAdapter().getItemId(i2);
                this.f72357c = aVar2;
            } catch (IndexOutOfBoundsException e2) {
                q.b(e2.getMessage());
                l.a(getClass().getName(), "headerView_ensureShadowForPosition", (Throwable) e2);
            }
        }
        int i5 = i2 + 1;
        if (i5 < getCount()) {
            int a2 = a(i5, i4 - (i5 - i3));
            if (a2 >= 0) {
                this.k = getChildAt(a2 - i3).getTop() - (this.f72357c.f72367a.getBottom() + getPaddingTop());
                int i6 = this.k;
                if (i6 < 0) {
                    this.f72358d = i6;
                } else {
                    this.f72358d = 0;
                }
            } else {
                this.f72358d = 0;
                this.k = Integer.MAX_VALUE;
            }
        }
    }

    private int a(int i2, int i3) {
        ListAdapter adapter = getAdapter();
        int count = adapter.getCount();
        if (getLastVisiblePosition() >= count) {
            return -1;
        }
        if (i2 + i3 >= count) {
            i3 = count - i2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 + i4;
            adapter.getItemViewType(i5);
            if (a(adapter)) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2) {
        ListAdapter adapter = getAdapter();
        if (i2 >= adapter.getCount()) {
            return -1;
        }
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i2));
            adapter.getItemViewType(positionForSection);
            if (a(adapter)) {
                return positionForSection;
            }
        }
        while (i2 >= 0) {
            adapter.getItemViewType(i2);
            if (a(adapter)) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = getFirstVisiblePosition();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            r3.a()
            android.widget.ListAdapter r0 = r3.getAdapter()
            if (r0 == 0) goto L_0x0023
            int r0 = r0.getCount()
            if (r0 <= 0) goto L_0x0023
            int r0 = r3.getFirstVisiblePosition()
            int r1 = r3.a((int) r0)
            r2 = -1
            if (r1 != r2) goto L_0x001b
            return
        L_0x001b:
            int r2 = r3.getLastVisiblePosition()
            int r2 = r2 - r0
            r3.a((int) r1, (int) r0, (int) r2)
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.widget.PinnedSectionListView.b():void");
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener == this.m) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.f72355a = onScrollListener;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() {
            public final void run() {
                PinnedSectionListView.this.b();
            }
        });
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterDataSetObserver(this.n);
        }
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.n);
        }
        if (adapter != listAdapter) {
            a();
        }
        super.setAdapter(listAdapter);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f72357c != null && ((i4 - i2) - getPaddingLeft()) - getPaddingRight() != this.f72357c.f72367a.getWidth()) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i2;
        super.dispatchDraw(canvas);
        if (this.f72357c != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.f72357c.f72367a;
            canvas.save();
            int height = view.getHeight();
            if (this.j == null) {
                i2 = 0;
            } else {
                i2 = Math.min(this.l, this.k);
            }
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, height + i2 + listPaddingTop);
            canvas.translate((float) listPaddingLeft, (float) (listPaddingTop + this.f72358d));
            drawChild(canvas, this.f72357c.f72367a, getDrawingTime());
            GradientDrawable gradientDrawable = this.j;
            if (gradientDrawable != null && this.k > 0) {
                gradientDrawable.setBounds(this.f72357c.f72367a.getLeft(), this.f72357c.f72367a.getBottom(), this.f72357c.f72367a.getRight(), this.f72357c.f72367a.getBottom() + this.l);
                this.j.draw(canvas);
            }
            canvas.restore();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AdapterView.OnItemClickListener onItemClickListener;
        a aVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.f72362h == null && (aVar = this.f72357c) != null && a(aVar.f72367a, x, y)) {
            this.f72362h = this.f72357c.f72367a;
            PointF pointF = this.f72360f;
            pointF.x = x;
            pointF.y = y;
            this.f72363i = MotionEvent.obtain(motionEvent);
        }
        View view = this.f72362h;
        if (view == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (a(view, x, y)) {
            this.f72362h.dispatchTouchEvent(motionEvent);
        }
        if (action == 1) {
            super.dispatchTouchEvent(motionEvent);
            if (!(this.f72357c == null || (onItemClickListener = getOnItemClickListener()) == null || !getAdapter().isEnabled(this.f72357c.f72368b))) {
                View view2 = this.f72357c.f72367a;
                playSoundEffect(0);
                if (view2 != null) {
                    view2.sendAccessibilityEvent(1);
                }
                onItemClickListener.onItemClick(this, view2, this.f72357c.f72368b, this.f72357c.f72369c);
            }
            d();
        } else if (action == 3) {
            d();
        } else if (action == 2 && Math.abs(y - this.f72360f.y) > ((float) this.f72361g)) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.f72362h.dispatchTouchEvent(obtain);
            obtain.recycle();
            super.dispatchTouchEvent(this.f72363i);
            super.dispatchTouchEvent(motionEvent);
            d();
        }
        return true;
    }

    private boolean a(View view, float f2, float f3) {
        view.getHitRect(this.f72359e);
        this.f72359e.top += this.f72358d;
        this.f72359e.bottom += this.f72358d + getPaddingTop();
        this.f72359e.left += getPaddingLeft();
        this.f72359e.right -= getPaddingRight();
        return this.f72359e.contains((int) f2, (int) f3);
    }

    private void d() {
        this.f72362h = null;
        MotionEvent motionEvent = this.f72363i;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f72363i = null;
        }
    }

    public static boolean a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((b) listAdapter).a();
    }
}
