package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.h.u;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.List;

public final class l extends RecyclerView.h implements RecyclerView.i {
    private List<Integer> A;
    private RecyclerView.d B = null;
    private b C;
    private final RecyclerView.k D = new RecyclerView.k() {
        public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            l.this.r.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            c cVar = null;
            if (actionMasked == 0) {
                l.this.f4314i = motionEvent.getPointerId(0);
                l.this.f4308c = motionEvent.getX();
                l.this.f4309d = motionEvent.getY();
                l lVar = l.this;
                if (lVar.o != null) {
                    lVar.o.recycle();
                }
                lVar.o = VelocityTracker.obtain();
                if (l.this.f4307b == null) {
                    l lVar2 = l.this;
                    if (!lVar2.l.isEmpty()) {
                        View a2 = lVar2.a(motionEvent);
                        int size = lVar2.l.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            c cVar2 = lVar2.l.get(size);
                            if (cVar2.f4333h.itemView == a2) {
                                cVar = cVar2;
                                break;
                            }
                            size--;
                        }
                    }
                    if (cVar != null) {
                        l.this.f4308c -= cVar.m;
                        l.this.f4309d -= cVar.n;
                        l.this.a(cVar.f4333h, true);
                        if (l.this.f4306a.remove(cVar.f4333h.itemView)) {
                            l.this.j.c(cVar.f4333h);
                        }
                        l.this.a(cVar.f4333h, cVar.f4334i);
                        l lVar3 = l.this;
                        lVar3.a(motionEvent, lVar3.k, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                l lVar4 = l.this;
                lVar4.f4314i = -1;
                lVar4.a((RecyclerView.v) null, 0);
            } else if (l.this.f4314i != -1 && (findPointerIndex = motionEvent.findPointerIndex(l.this.f4314i)) >= 0) {
                l.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            if (l.this.o != null) {
                l.this.o.addMovement(motionEvent);
            }
            return l.this.f4307b != null;
        }

        public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            l.this.r.a(motionEvent);
            if (l.this.o != null) {
                l.this.o.addMovement(motionEvent);
            }
            if (l.this.f4314i != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(l.this.f4314i);
                if (findPointerIndex >= 0) {
                    l.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.v vVar = l.this.f4307b;
                if (vVar != null) {
                    int i2 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == l.this.f4314i) {
                                        if (actionIndex == 0) {
                                            i2 = 1;
                                        }
                                        l.this.f4314i = motionEvent.getPointerId(i2);
                                        l lVar = l.this;
                                        lVar.a(motionEvent, lVar.k, actionIndex);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else if (l.this.o != null) {
                                l.this.o.clear();
                            }
                        } else if (findPointerIndex >= 0) {
                            l lVar2 = l.this;
                            lVar2.a(motionEvent, lVar2.k, findPointerIndex);
                            l.this.a(vVar);
                            l.this.m.removeCallbacks(l.this.n);
                            l.this.n.run();
                            l.this.m.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.this.a((RecyclerView.v) null, 0);
                    l.this.f4314i = -1;
                }
            }
        }

        public final void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                l.this.a((RecyclerView.v) null, 0);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final List<View> f4306a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    RecyclerView.v f4307b = null;

    /* renamed from: c  reason: collision with root package name */
    float f4308c;

    /* renamed from: d  reason: collision with root package name */
    float f4309d;

    /* renamed from: e  reason: collision with root package name */
    float f4310e;

    /* renamed from: f  reason: collision with root package name */
    float f4311f;

    /* renamed from: g  reason: collision with root package name */
    float f4312g;

    /* renamed from: h  reason: collision with root package name */
    float f4313h;

    /* renamed from: i  reason: collision with root package name */
    int f4314i = -1;
    a j;
    int k;
    List<c> l = new ArrayList();
    RecyclerView m;
    final Runnable n = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cc, code lost:
            if (r2 > 0) goto L_0x00d0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0111  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r16 = this;
                r0 = r16
                androidx.recyclerview.widget.l r1 = androidx.recyclerview.widget.l.this
                androidx.recyclerview.widget.RecyclerView$v r1 = r1.f4307b
                if (r1 == 0) goto L_0x013d
                androidx.recyclerview.widget.l r1 = androidx.recyclerview.widget.l.this
                androidx.recyclerview.widget.RecyclerView$v r2 = r1.f4307b
                r3 = 0
                r4 = -9223372036854775808
                if (r2 == 0) goto L_0x011a
                long r6 = java.lang.System.currentTimeMillis()
                long r8 = r1.t
                int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x001e
                r8 = 0
                goto L_0x0022
            L_0x001e:
                long r8 = r1.t
                long r8 = r6 - r8
            L_0x0022:
                androidx.recyclerview.widget.RecyclerView r2 = r1.m
                androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
                android.graphics.Rect r10 = r1.s
                if (r10 != 0) goto L_0x0033
                android.graphics.Rect r10 = new android.graphics.Rect
                r10.<init>()
                r1.s = r10
            L_0x0033:
                androidx.recyclerview.widget.RecyclerView$v r10 = r1.f4307b
                android.view.View r10 = r10.itemView
                android.graphics.Rect r11 = r1.s
                r2.calculateItemDecorationsForChild(r10, r11)
                boolean r10 = r2.canScrollHorizontally()
                r11 = 0
                if (r10 == 0) goto L_0x0086
                float r10 = r1.f4312g
                float r12 = r1.f4310e
                float r10 = r10 + r12
                int r10 = (int) r10
                android.graphics.Rect r12 = r1.s
                int r12 = r12.left
                int r12 = r10 - r12
                androidx.recyclerview.widget.RecyclerView r13 = r1.m
                int r13 = r13.getPaddingLeft()
                int r12 = r12 - r13
                float r13 = r1.f4310e
                int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r13 >= 0) goto L_0x0060
                if (r12 >= 0) goto L_0x0060
                r13 = r12
                goto L_0x0087
            L_0x0060:
                float r12 = r1.f4310e
                int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
                if (r12 <= 0) goto L_0x0086
                androidx.recyclerview.widget.RecyclerView$v r12 = r1.f4307b
                android.view.View r12 = r12.itemView
                int r12 = r12.getWidth()
                int r10 = r10 + r12
                android.graphics.Rect r12 = r1.s
                int r12 = r12.right
                int r10 = r10 + r12
                androidx.recyclerview.widget.RecyclerView r12 = r1.m
                int r12 = r12.getWidth()
                androidx.recyclerview.widget.RecyclerView r13 = r1.m
                int r13 = r13.getPaddingRight()
                int r12 = r12 - r13
                int r10 = r10 - r12
                if (r10 <= 0) goto L_0x0086
                r13 = r10
                goto L_0x0087
            L_0x0086:
                r13 = 0
            L_0x0087:
                boolean r2 = r2.canScrollVertically()
                if (r2 == 0) goto L_0x00cf
                float r2 = r1.f4313h
                float r10 = r1.f4311f
                float r2 = r2 + r10
                int r2 = (int) r2
                android.graphics.Rect r10 = r1.s
                int r10 = r10.top
                int r10 = r2 - r10
                androidx.recyclerview.widget.RecyclerView r12 = r1.m
                int r12 = r12.getPaddingTop()
                int r10 = r10 - r12
                float r12 = r1.f4311f
                int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
                if (r12 >= 0) goto L_0x00aa
                if (r10 >= 0) goto L_0x00aa
                r2 = r10
                goto L_0x00d0
            L_0x00aa:
                float r10 = r1.f4311f
                int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
                if (r10 <= 0) goto L_0x00cf
                androidx.recyclerview.widget.RecyclerView$v r10 = r1.f4307b
                android.view.View r10 = r10.itemView
                int r10 = r10.getHeight()
                int r2 = r2 + r10
                android.graphics.Rect r10 = r1.s
                int r10 = r10.bottom
                int r2 = r2 + r10
                androidx.recyclerview.widget.RecyclerView r10 = r1.m
                int r10 = r10.getHeight()
                androidx.recyclerview.widget.RecyclerView r11 = r1.m
                int r11 = r11.getPaddingBottom()
                int r10 = r10 - r11
                int r2 = r2 - r10
                if (r2 <= 0) goto L_0x00cf
                goto L_0x00d0
            L_0x00cf:
                r2 = 0
            L_0x00d0:
                if (r13 == 0) goto L_0x00e8
                androidx.recyclerview.widget.l$a r10 = r1.j
                androidx.recyclerview.widget.RecyclerView r11 = r1.m
                androidx.recyclerview.widget.RecyclerView$v r12 = r1.f4307b
                android.view.View r12 = r12.itemView
                int r12 = r12.getWidth()
                androidx.recyclerview.widget.RecyclerView r14 = r1.m
                r14.getWidth()
                r14 = r8
                int r13 = r10.a((androidx.recyclerview.widget.RecyclerView) r11, (int) r12, (int) r13, (long) r14)
            L_0x00e8:
                r14 = r13
                if (r2 == 0) goto L_0x0106
                androidx.recyclerview.widget.l$a r10 = r1.j
                androidx.recyclerview.widget.RecyclerView r11 = r1.m
                androidx.recyclerview.widget.RecyclerView$v r12 = r1.f4307b
                android.view.View r12 = r12.itemView
                int r12 = r12.getHeight()
                androidx.recyclerview.widget.RecyclerView r13 = r1.m
                r13.getHeight()
                r13 = r2
                r2 = r14
                r14 = r8
                int r8 = r10.a((androidx.recyclerview.widget.RecyclerView) r11, (int) r12, (int) r13, (long) r14)
                r13 = r2
                r2 = r8
                goto L_0x0107
            L_0x0106:
                r13 = r14
            L_0x0107:
                if (r13 != 0) goto L_0x010b
                if (r2 == 0) goto L_0x011a
            L_0x010b:
                long r8 = r1.t
                int r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x0113
                r1.t = r6
            L_0x0113:
                androidx.recyclerview.widget.RecyclerView r1 = r1.m
                r1.scrollBy(r13, r2)
                r3 = 1
                goto L_0x011c
            L_0x011a:
                r1.t = r4
            L_0x011c:
                if (r3 == 0) goto L_0x013d
                androidx.recyclerview.widget.l r1 = androidx.recyclerview.widget.l.this
                androidx.recyclerview.widget.RecyclerView$v r1 = r1.f4307b
                if (r1 == 0) goto L_0x012b
                androidx.recyclerview.widget.l r1 = androidx.recyclerview.widget.l.this
                androidx.recyclerview.widget.RecyclerView$v r2 = r1.f4307b
                r1.a((androidx.recyclerview.widget.RecyclerView.v) r2)
            L_0x012b:
                androidx.recyclerview.widget.l r1 = androidx.recyclerview.widget.l.this
                androidx.recyclerview.widget.RecyclerView r1 = r1.m
                androidx.recyclerview.widget.l r2 = androidx.recyclerview.widget.l.this
                java.lang.Runnable r2 = r2.n
                r1.removeCallbacks(r2)
                androidx.recyclerview.widget.l r1 = androidx.recyclerview.widget.l.this
                androidx.recyclerview.widget.RecyclerView r1 = r1.m
                androidx.core.h.u.a((android.view.View) r1, (java.lang.Runnable) r0)
            L_0x013d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.l.AnonymousClass1.run():void");
        }
    };
    VelocityTracker o;
    View p = null;
    int q = -1;
    androidx.core.h.d r;
    Rect s;
    long t;
    private final float[] u = new float[2];
    private float v;
    private float w;
    private int x = 0;
    private int y;
    private List<RecyclerView.v> z;

    public interface e {
        void prepareForDrop(View view, View view2, int i2, int i3);
    }

    public final void a(View view) {
    }

    public l(a aVar) {
        this.j = aVar;
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    public final void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.m;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.m.removeOnItemTouchListener(this.D);
                this.m.removeOnChildAttachStateChangeListener(this);
                int size = this.l.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    this.j.c(this.l.get(0).f4333h);
                }
                this.l.clear();
                this.p = null;
                this.q = -1;
                a();
                b bVar = this.C;
                if (bVar != null) {
                    bVar.f4327a = false;
                    this.C = null;
                }
                if (this.r != null) {
                    this.r = null;
                }
            }
            this.m = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.v = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.w = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                this.y = ViewConfiguration.get(this.m.getContext()).getScaledTouchSlop();
                this.m.addItemDecoration(this);
                this.m.addOnItemTouchListener(this.D);
                this.m.addOnChildAttachStateChangeListener(this);
                this.C = new b();
                this.r = new androidx.core.h.d(this.m.getContext(), this.C);
            }
        }
    }

    private void a(float[] fArr) {
        if ((this.k & 12) != 0) {
            fArr[0] = (this.f4312g + this.f4310e) - ((float) this.f4307b.itemView.getLeft());
        } else {
            fArr[0] = this.f4307b.itemView.getTranslationX();
        }
        if ((this.k & 3) != 0) {
            fArr[1] = (this.f4313h + this.f4311f) - ((float) this.f4307b.itemView.getTop());
        } else {
            fArr[1] = this.f4307b.itemView.getTranslationY();
        }
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (this.f4307b != null) {
            a(this.u);
        }
        a aVar = this.j;
        RecyclerView.v vVar = this.f4307b;
        List<c> list = this.l;
        int size = list.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2);
            int save = canvas.save();
            aVar.a();
            canvas.restoreToCount(save);
        }
        if (vVar != null) {
            int save2 = canvas.save();
            aVar.a();
            canvas.restoreToCount(save2);
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            c cVar = list.get(i3);
            if (cVar.p && !cVar.l) {
                list.remove(i3);
            } else if (!cVar.p) {
                z2 = true;
            }
        }
        if (z2) {
            recyclerView.invalidate();
        }
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        float f2;
        float f3;
        Canvas canvas2 = canvas;
        this.q = -1;
        if (this.f4307b != null) {
            a(this.u);
            float[] fArr = this.u;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        a aVar = this.j;
        RecyclerView.v vVar = this.f4307b;
        List<c> list = this.l;
        int i2 = this.x;
        int i3 = 0;
        for (int size = list.size(); i3 < size; size = size) {
            c cVar = list.get(i3);
            if (cVar.f4329d == cVar.f4331f) {
                cVar.m = cVar.f4333h.itemView.getTranslationX();
            } else {
                cVar.m = cVar.f4329d + (cVar.q * (cVar.f4331f - cVar.f4329d));
            }
            if (cVar.f4330e == cVar.f4332g) {
                cVar.n = cVar.f4333h.itemView.getTranslationY();
            } else {
                cVar.n = cVar.f4330e + (cVar.q * (cVar.f4332g - cVar.f4330e));
            }
            int save = canvas.save();
            RecyclerView.v vVar2 = cVar.f4333h;
            float f5 = cVar.m;
            float f6 = cVar.n;
            int i4 = save;
            float f7 = f6;
            int i5 = i3;
            aVar.a(canvas, recyclerView, vVar2, f5, f7, cVar.f4334i, false);
            canvas2.restoreToCount(i4);
            i3 = i5 + 1;
        }
        if (vVar != null) {
            int save2 = canvas.save();
            aVar.a(canvas, recyclerView, vVar, f3, f2, i2, true);
            canvas2.restoreToCount(save2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
        if (r0 > 0) goto L_0x00a8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.recyclerview.widget.RecyclerView.v r21, int r22) {
        /*
            r20 = this;
            r11 = r20
            r12 = r21
            r13 = r22
            androidx.recyclerview.widget.RecyclerView$v r0 = r11.f4307b
            if (r12 != r0) goto L_0x000f
            int r0 = r11.x
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.t = r0
            int r4 = r11.x
            r14 = 1
            r11.a((androidx.recyclerview.widget.RecyclerView.v) r12, (boolean) r14)
            r11.x = r13
            r15 = 2
            if (r13 != r15) goto L_0x0045
            if (r12 == 0) goto L_0x003d
            android.view.View r0 = r12.itemView
            r11.p = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x0045
            androidx.recyclerview.widget.RecyclerView$d r0 = r11.B
            if (r0 != 0) goto L_0x0035
            androidx.recyclerview.widget.l$5 r0 = new androidx.recyclerview.widget.l$5
            r0.<init>()
            r11.B = r0
        L_0x0035:
            androidx.recyclerview.widget.RecyclerView r0 = r11.m
            androidx.recyclerview.widget.RecyclerView$d r1 = r11.B
            r0.setChildDrawingOrderCallback(r1)
            goto L_0x0045
        L_0x003d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0045:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$v r9 = r11.f4307b
            r8 = 0
            if (r9 == 0) goto L_0x0169
            android.view.View r0 = r9.itemView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0156
            if (r4 == r15) goto L_0x00c8
            int r0 = r11.x
            if (r0 == r15) goto L_0x00c8
            androidx.recyclerview.widget.l$a r0 = r11.j
            androidx.recyclerview.widget.RecyclerView r1 = r11.m
            int r0 = r0.a((androidx.recyclerview.widget.RecyclerView) r1, (androidx.recyclerview.widget.RecyclerView.v) r9)
            androidx.recyclerview.widget.l$a r1 = r11.j
            androidx.recyclerview.widget.RecyclerView r2 = r11.m
            int r2 = androidx.core.h.u.j(r2)
            int r1 = r1.c(r0, r2)
            r2 = 65280(0xff00, float:9.1477E-41)
            r1 = r1 & r2
            int r1 = r1 >> r10
            if (r1 == 0) goto L_0x00c8
            r0 = r0 & r2
            int r0 = r0 >> r10
            float r2 = r11.f4310e
            float r2 = java.lang.Math.abs(r2)
            float r3 = r11.f4311f
            float r3 = java.lang.Math.abs(r3)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x00aa
            int r2 = r11.a((int) r1)
            if (r2 <= 0) goto L_0x00a2
            r0 = r0 & r2
            if (r0 != 0) goto L_0x00b0
            androidx.recyclerview.widget.RecyclerView r0 = r11.m
            int r0 = androidx.core.h.u.j(r0)
            int r0 = androidx.recyclerview.widget.l.a.a((int) r2, (int) r0)
            goto L_0x00a8
        L_0x00a2:
            int r0 = r11.b((int) r1)
            if (r0 <= 0) goto L_0x00c8
        L_0x00a8:
            r7 = r0
            goto L_0x00c9
        L_0x00aa:
            int r2 = r11.b((int) r1)
            if (r2 <= 0) goto L_0x00b2
        L_0x00b0:
            r7 = r2
            goto L_0x00c9
        L_0x00b2:
            int r1 = r11.a((int) r1)
            if (r1 <= 0) goto L_0x00c8
            r0 = r0 & r1
            if (r0 != 0) goto L_0x00c6
            androidx.recyclerview.widget.RecyclerView r0 = r11.m
            int r0 = androidx.core.h.u.j(r0)
            int r0 = androidx.recyclerview.widget.l.a.a((int) r1, (int) r0)
            goto L_0x00a8
        L_0x00c6:
            r7 = r1
            goto L_0x00c9
        L_0x00c8:
            r7 = 0
        L_0x00c9:
            r20.a()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x00f5
            if (r7 == r15) goto L_0x00f5
            if (r7 == r0) goto L_0x00e3
            if (r7 == r10) goto L_0x00e3
            r2 = 16
            if (r7 == r2) goto L_0x00e3
            r2 = 32
            if (r7 == r2) goto L_0x00e3
            r17 = 0
        L_0x00e0:
            r18 = 0
            goto L_0x0108
        L_0x00e3:
            float r2 = r11.f4310e
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.m
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r2
            goto L_0x00e0
        L_0x00f5:
            float r2 = r11.f4311f
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.m
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r2
            r17 = 0
        L_0x0108:
            if (r4 != r15) goto L_0x010d
            r6 = 8
            goto L_0x0112
        L_0x010d:
            if (r7 <= 0) goto L_0x0111
            r6 = 2
            goto L_0x0112
        L_0x0111:
            r6 = 4
        L_0x0112:
            float[] r0 = r11.u
            r11.a((float[]) r0)
            float[] r0 = r11.u
            r5 = r0[r8]
            r19 = r0[r14]
            androidx.recyclerview.widget.l$3 r3 = new androidx.recyclerview.widget.l$3
            r0 = r3
            r1 = r20
            r2 = r9
            r14 = r3
            r3 = r6
            r15 = r6
            r6 = r19
            r19 = r7
            r7 = r17
            r13 = 0
            r8 = r18
            r17 = r9
            r9 = r19
            r18 = 8
            r10 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.RecyclerView r0 = r11.m
            long r0 = androidx.recyclerview.widget.l.a.a((androidx.recyclerview.widget.RecyclerView) r0, (int) r15)
            android.animation.ValueAnimator r2 = r14.j
            r2.setDuration(r0)
            java.util.List<androidx.recyclerview.widget.l$c> r0 = r11.l
            r0.add(r14)
            androidx.recyclerview.widget.RecyclerView$v r0 = r14.f4333h
            r0.setIsRecyclable(r13)
            android.animation.ValueAnimator r0 = r14.j
            r0.start()
            r8 = 1
            goto L_0x0165
        L_0x0156:
            r0 = r9
            r13 = 0
            r18 = 8
            android.view.View r1 = r0.itemView
            r11.c(r1)
            androidx.recyclerview.widget.l$a r1 = r11.j
            r1.c(r0)
            r8 = 0
        L_0x0165:
            r0 = 0
            r11.f4307b = r0
            goto L_0x016d
        L_0x0169:
            r13 = 0
            r18 = 8
            r8 = 0
        L_0x016d:
            if (r12 == 0) goto L_0x01a0
            androidx.recyclerview.widget.l$a r0 = r11.j
            androidx.recyclerview.widget.RecyclerView r1 = r11.m
            int r0 = r0.b((androidx.recyclerview.widget.RecyclerView) r1, (androidx.recyclerview.widget.RecyclerView.v) r12)
            r0 = r0 & r16
            int r1 = r11.x
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.k = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.f4312g = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.f4313h = r0
            r11.f4307b = r12
            r0 = r22
            r1 = 2
            if (r0 != r1) goto L_0x01a0
            androidx.recyclerview.widget.RecyclerView$v r0 = r11.f4307b
            android.view.View r0 = r0.itemView
            r0.performHapticFeedback(r13)
        L_0x01a0:
            androidx.recyclerview.widget.RecyclerView r0 = r11.m
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x01b0
            androidx.recyclerview.widget.RecyclerView$v r1 = r11.f4307b
            if (r1 == 0) goto L_0x01ad
            r13 = 1
        L_0x01ad:
            r0.requestDisallowInterceptTouchEvent(r13)
        L_0x01b0:
            if (r8 != 0) goto L_0x01bb
            androidx.recyclerview.widget.RecyclerView r0 = r11.m
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r0.requestSimpleAnimationsInNextLayout()
        L_0x01bb:
            androidx.recyclerview.widget.l$a r0 = r11.j
            androidx.recyclerview.widget.RecyclerView$v r1 = r11.f4307b
            r0.b((androidx.recyclerview.widget.RecyclerView.v) r1)
            androidx.recyclerview.widget.RecyclerView r0 = r11.m
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.l.a(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(RecyclerView.v vVar) {
        int i2;
        int i3;
        RecyclerView.v vVar2 = vVar;
        if (!this.m.isLayoutRequested() && this.x == 2) {
            int i4 = (int) (this.f4312g + this.f4310e);
            int i5 = (int) (this.f4313h + this.f4311f);
            if (((float) Math.abs(i5 - vVar2.itemView.getTop())) >= ((float) vVar2.itemView.getHeight()) * 0.5f || ((float) Math.abs(i4 - vVar2.itemView.getLeft())) >= ((float) vVar2.itemView.getWidth()) * 0.5f) {
                List<RecyclerView.v> list = this.z;
                if (list == null) {
                    this.z = new ArrayList();
                    this.A = new ArrayList();
                } else {
                    list.clear();
                    this.A.clear();
                }
                int round = Math.round(this.f4312g + this.f4310e) - 0;
                int round2 = Math.round(this.f4313h + this.f4311f) - 0;
                int width = vVar2.itemView.getWidth() + round + 0;
                int height = vVar2.itemView.getHeight() + round2 + 0;
                int i6 = (round + width) / 2;
                int i7 = (round2 + height) / 2;
                RecyclerView.LayoutManager layoutManager = this.m.getLayoutManager();
                int childCount = layoutManager.getChildCount();
                int i8 = 0;
                while (i8 < childCount) {
                    View childAt = layoutManager.getChildAt(i8);
                    if (childAt == vVar2.itemView || childAt.getBottom() < round2 || childAt.getTop() > height || childAt.getRight() < round || childAt.getLeft() > width) {
                        i3 = round;
                        i2 = round2;
                    } else {
                        RecyclerView.v childViewHolder = this.m.getChildViewHolder(childAt);
                        int abs = Math.abs(i6 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i7 - ((childAt.getTop() + childAt.getBottom()) / 2));
                        int i9 = (abs * abs) + (abs2 * abs2);
                        int size = this.z.size();
                        i3 = round;
                        i2 = round2;
                        int i10 = 0;
                        int i11 = 0;
                        while (i10 < size) {
                            int i12 = size;
                            if (i9 <= this.A.get(i10).intValue()) {
                                break;
                            }
                            i11++;
                            i10++;
                            size = i12;
                        }
                        this.z.add(i11, childViewHolder);
                        this.A.add(i11, Integer.valueOf(i9));
                    }
                    i8++;
                    round = i3;
                    round2 = i2;
                }
                List<RecyclerView.v> list2 = this.z;
                if (list2.size() != 0) {
                    RecyclerView.v a2 = a.a(vVar2, list2, i4, i5);
                    if (a2 == null) {
                        this.z.clear();
                        this.A.clear();
                        return;
                    }
                    int adapterPosition = a2.getAdapterPosition();
                    vVar.getAdapterPosition();
                    if (this.j.a(this.m, vVar2, a2)) {
                        a.a(this.m, vVar, a2, adapterPosition, i4, i5);
                    }
                }
            }
        }
    }

    public final void b(View view) {
        c(view);
        RecyclerView.v childViewHolder = this.m.getChildViewHolder(view);
        if (childViewHolder != null) {
            RecyclerView.v vVar = this.f4307b;
            if (vVar == null || childViewHolder != vVar) {
                a(childViewHolder, false);
                if (this.f4306a.remove(childViewHolder.itemView)) {
                    this.j.c(childViewHolder);
                    return;
                }
                return;
            }
            a((RecyclerView.v) null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(RecyclerView.v vVar, boolean z2) {
        for (int size = this.l.size() - 1; size >= 0; size--) {
            c cVar = this.l.get(size);
            if (cVar.f4333h == vVar) {
                cVar.o |= z2;
                if (!cVar.p) {
                    cVar.j.cancel();
                }
                this.l.remove(size);
                return;
            }
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        rect.setEmpty();
    }

    private void a() {
        VelocityTracker velocityTracker = this.o;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.o = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, MotionEvent motionEvent, int i3) {
        int b2;
        View a2;
        if (this.f4307b == null && i2 == 2 && this.x != 2 && this.m.getScrollState() != 1) {
            RecyclerView.LayoutManager layoutManager = this.m.getLayoutManager();
            int i4 = this.f4314i;
            RecyclerView.v vVar = null;
            if (i4 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i4);
                float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f4308c);
                float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f4309d);
                int i5 = this.y;
                if ((abs >= ((float) i5) || abs2 >= ((float) i5)) && ((abs <= abs2 || !layoutManager.canScrollHorizontally()) && ((abs2 <= abs || !layoutManager.canScrollVertically()) && (a2 = a(motionEvent)) != null))) {
                    vVar = this.m.getChildViewHolder(a2);
                }
            }
            if (vVar != null && (b2 = (this.j.b(this.m, vVar) & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) >> 8) != 0) {
                float x2 = motionEvent.getX(i3);
                float y2 = motionEvent.getY(i3);
                float f2 = x2 - this.f4308c;
                float f3 = y2 - this.f4309d;
                float abs3 = Math.abs(f2);
                float abs4 = Math.abs(f3);
                int i6 = this.y;
                if (abs3 >= ((float) i6) || abs4 >= ((float) i6)) {
                    if (abs3 > abs4) {
                        if (f2 < 0.0f && (b2 & 4) == 0) {
                            return;
                        }
                        if (f2 > 0.0f && (b2 & 8) == 0) {
                            return;
                        }
                    } else if (f3 < 0.0f && (b2 & 1) == 0) {
                        return;
                    } else {
                        if (f3 > 0.0f && (b2 & 2) == 0) {
                            return;
                        }
                    }
                    this.f4311f = 0.0f;
                    this.f4310e = 0.0f;
                    this.f4314i = motionEvent.getPointerId(0);
                    a(vVar, 1);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final View a(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.v vVar = this.f4307b;
        if (vVar != null) {
            View view = vVar.itemView;
            if (a(view, x2, y2, this.f4312g + this.f4310e, this.f4313h + this.f4311f)) {
                return view;
            }
        }
        for (int size = this.l.size() - 1; size >= 0; size--) {
            c cVar = this.l.get(size);
            View view2 = cVar.f4333h.itemView;
            if (a(view2, x2, y2, cVar.m, cVar.n)) {
                return view2;
            }
        }
        return this.m.findChildViewUnder(x2, y2);
    }

    /* access modifiers changed from: package-private */
    public final void a(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        this.f4310e = x2 - this.f4308c;
        this.f4311f = y2 - this.f4309d;
        if ((i2 & 4) == 0) {
            this.f4310e = Math.max(0.0f, this.f4310e);
        }
        if ((i2 & 8) == 0) {
            this.f4310e = Math.min(0.0f, this.f4310e);
        }
        if ((i2 & 1) == 0) {
            this.f4311f = Math.max(0.0f, this.f4311f);
        }
        if ((i2 & 2) == 0) {
            this.f4311f = Math.min(0.0f, this.f4311f);
        }
    }

    private int a(int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 8;
        int i4 = this.f4310e > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.o;
        if (velocityTracker != null && this.f4314i >= 0) {
            velocityTracker.computeCurrentVelocity(1000, a.b(this.w));
            float xVelocity = this.o.getXVelocity(this.f4314i);
            float yVelocity = this.o.getYVelocity(this.f4314i);
            if (xVelocity <= 0.0f) {
                i3 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3 && abs >= a.a(this.v) && abs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = ((float) this.m.getWidth()) * 0.5f;
        if ((i2 & i4) == 0 || Math.abs(this.f4310e) <= width) {
            return 0;
        }
        return i4;
    }

    private int b(int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 2;
        int i4 = this.f4311f > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.o;
        if (velocityTracker != null && this.f4314i >= 0) {
            velocityTracker.computeCurrentVelocity(1000, a.b(this.w));
            float xVelocity = this.o.getXVelocity(this.f4314i);
            float yVelocity = this.o.getYVelocity(this.f4314i);
            if (yVelocity <= 0.0f) {
                i3 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4 && abs >= a.a(this.v) && abs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = ((float) this.m.getHeight()) * 0.5f;
        if ((i2 & i4) == 0 || Math.abs(this.f4311f) <= height) {
            return 0;
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final void c(View view) {
        if (view == this.p) {
            this.p = null;
            if (this.B != null) {
                this.m.setChildDrawingOrderCallback((RecyclerView.d) null);
            }
        }
    }

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Interpolator f4324a = new Interpolator() {
            public final float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Interpolator f4325b = new Interpolator() {
            public final float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private int f4326c = -1;

        public static float a(float f2) {
            return f2;
        }

        public static int a(int i2, int i3) {
            int i4;
            int i5 = i2 & 789516;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= -789517 & i7;
                i4 = (i7 & 789516) << 2;
            }
            return i6 | i4;
        }

        public static float b(float f2) {
            return f2;
        }

        public static int b(int i2, int i3) {
            return (i2 << 16) | (i3 << 8) | ((i3 | i2) << 0);
        }

        public abstract int a(RecyclerView recyclerView, RecyclerView.v vVar);

        public abstract void a(RecyclerView.v vVar);

        public abstract boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2);

        public int c(int i2, int i3) {
            int i4;
            int i5 = i2 & 3158064;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= -3158065 & i7;
                i4 = (i7 & 3158064) >> 2;
            }
            return i6 | i4;
        }

        /* access modifiers changed from: package-private */
        public final int b(RecyclerView recyclerView, RecyclerView.v vVar) {
            return c(a(recyclerView, vVar), u.j(recyclerView));
        }

        public static RecyclerView.v a(RecyclerView.v vVar, List<RecyclerView.v> list, int i2, int i3) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = vVar.itemView.getWidth() + i2;
            int height = vVar.itemView.getHeight() + i3;
            int left2 = i2 - vVar.itemView.getLeft();
            int top2 = i3 - vVar.itemView.getTop();
            int size = list.size();
            RecyclerView.v vVar2 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.v vVar3 = list.get(i5);
                if (left2 > 0 && (right = vVar3.itemView.getRight() - width) < 0 && vVar3.itemView.getRight() > vVar.itemView.getRight() && (abs4 = Math.abs(right)) > i4) {
                    vVar2 = vVar3;
                    i4 = abs4;
                }
                if (left2 < 0 && (left = vVar3.itemView.getLeft() - i2) > 0 && vVar3.itemView.getLeft() < vVar.itemView.getLeft() && (abs3 = Math.abs(left)) > i4) {
                    vVar2 = vVar3;
                    i4 = abs3;
                }
                if (top2 < 0 && (top = vVar3.itemView.getTop() - i3) > 0 && vVar3.itemView.getTop() < vVar.itemView.getTop() && (abs2 = Math.abs(top)) > i4) {
                    vVar2 = vVar3;
                    i4 = abs2;
                }
                if (top2 > 0 && (bottom = vVar3.itemView.getBottom() - height) < 0 && vVar3.itemView.getBottom() > vVar.itemView.getBottom() && (abs = Math.abs(bottom)) > i4) {
                    vVar2 = vVar3;
                    i4 = abs;
                }
            }
            return vVar2;
        }

        public void b(RecyclerView.v vVar) {
            if (vVar != null) {
                m mVar = n.f4338a;
            }
        }

        private int a(RecyclerView recyclerView) {
            if (this.f4326c == -1) {
                this.f4326c = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f4326c;
        }

        public static void a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof e) {
                ((e) layoutManager).prepareForDrop(vVar.itemView, vVar2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(vVar2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(vVar2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(vVar2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(vVar2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void c(RecyclerView.v vVar) {
            n.f4338a.a(vVar.itemView);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
            n.f4338a.a(recyclerView, vVar.itemView, f2, f3, z);
        }

        public void a() {
            m mVar = n.f4338a;
        }

        public static long a(RecyclerView recyclerView, int i2) {
            RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i2 == 8 ? 200 : 250;
            }
            if (i2 == 8) {
                return itemAnimator.k;
            }
            return itemAnimator.j;
        }

        public final int a(RecyclerView recyclerView, int i2, int i3, long j) {
            float f2 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i3)) * a(recyclerView))) * f4325b.getInterpolation(Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) i2))));
            if (j <= 2000) {
                f2 = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f4324a.getInterpolation(f2));
            if (interpolation == 0) {
                return i3 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f4327a = true;

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        b() {
        }

        public final void onLongPress(MotionEvent motionEvent) {
            View a2;
            RecyclerView.v childViewHolder;
            if (this.f4327a && (a2 = l.this.a(motionEvent)) != null && (childViewHolder = l.this.m.getChildViewHolder(a2)) != null) {
                if (((l.this.j.b(l.this.m, childViewHolder) & 16711680) != 0) && motionEvent.getPointerId(0) == l.this.f4314i) {
                    int findPointerIndex = motionEvent.findPointerIndex(l.this.f4314i);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    l lVar = l.this;
                    lVar.f4308c = x;
                    lVar.f4309d = y;
                    lVar.f4311f = 0.0f;
                    lVar.f4310e = 0.0f;
                    lVar.a(childViewHolder, 2);
                }
            }
        }
    }

    static class c implements Animator.AnimatorListener {

        /* renamed from: d  reason: collision with root package name */
        final float f4329d;

        /* renamed from: e  reason: collision with root package name */
        final float f4330e;

        /* renamed from: f  reason: collision with root package name */
        final float f4331f;

        /* renamed from: g  reason: collision with root package name */
        final float f4332g;

        /* renamed from: h  reason: collision with root package name */
        final RecyclerView.v f4333h;

        /* renamed from: i  reason: collision with root package name */
        final int f4334i;
        final ValueAnimator j;
        final int k;
        boolean l;
        float m;
        float n;
        boolean o = false;
        boolean p = false;
        float q;

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        c(RecyclerView.v vVar, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f4334i = i3;
            this.k = i2;
            this.f4333h = vVar;
            this.f4329d = f2;
            this.f4330e = f3;
            this.f4331f = f4;
            this.f4332g = f5;
            this.j = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.q = valueAnimator.getAnimatedFraction();
                }
            });
            this.j.setTarget(vVar.itemView);
            this.j.addListener(this);
            this.q = 0.0f;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.p) {
                this.f4333h.setIsRecyclable(true);
            }
            this.p = true;
        }

        public void onAnimationCancel(Animator animator) {
            this.q = 1.0f;
        }
    }

    public static abstract class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f4336a = 4;

        /* renamed from: b  reason: collision with root package name */
        private int f4337b = 0;

        public final int a(RecyclerView recyclerView, RecyclerView.v vVar) {
            return b(this.f4337b, this.f4336a);
        }
    }
}
