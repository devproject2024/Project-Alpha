package com.paytm.android.chat.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import androidx.core.h.u;
import com.paytm.utility.q;

public class ChatSwipeRefreshLayout extends ViewGroup {
    private static final int[] s = {16842766};
    private Animation A;
    /* access modifiers changed from: private */
    public float B;
    /* access modifiers changed from: private */
    public boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    /* access modifiers changed from: private */
    public boolean H;
    private boolean I;
    /* access modifiers changed from: private */
    public int J;
    /* access modifiers changed from: private */
    public CircleProgressView K;
    /* access modifiers changed from: private */
    public boolean L;
    /* access modifiers changed from: private */
    public float M;
    /* access modifiers changed from: private */
    public boolean N;
    private Animation.AnimationListener O;
    private final Animation P;
    private final Animation Q;

    /* renamed from: a  reason: collision with root package name */
    protected int f42448a;

    /* renamed from: b  reason: collision with root package name */
    protected int f42449b;

    /* renamed from: c  reason: collision with root package name */
    private View f42450c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b f42451d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public c f42452e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f42453f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f42454g;

    /* renamed from: h  reason: collision with root package name */
    private int f42455h;

    /* renamed from: i  reason: collision with root package name */
    private float f42456i;
    private int j;
    /* access modifiers changed from: private */
    public int k;
    private boolean l;
    private float m;
    private boolean n;
    private int o;
    /* access modifiers changed from: private */
    public boolean p;
    private boolean q;
    private final DecelerateInterpolator r;
    /* access modifiers changed from: private */
    public a t;
    private RelativeLayout u;
    private int v;
    private int w;
    /* access modifiers changed from: private */
    public float x;
    private Animation y;
    private Animation z;

    public interface b {
        void a();

        void b();
    }

    public interface c {
        void a();

        void b();
    }

    /* access modifiers changed from: private */
    public void b() {
        int height = this.k + this.t.getHeight();
        if (this.L && this.N) {
            this.K.setPullDistance(height);
        }
    }

    public void setHeaderView(View view) {
        a aVar;
        if (view != null && (aVar = this.t) != null) {
            this.L = true;
            aVar.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.D, this.F);
            layoutParams.addRule(12);
            this.t.addView(view, layoutParams);
        }
    }

    public void setFooterView(View view) {
        RelativeLayout relativeLayout;
        if (view != null && (relativeLayout = this.u) != null) {
            relativeLayout.removeAllViews();
            this.u.addView(view, new RelativeLayout.LayoutParams(this.E, this.G));
        }
    }

    public ChatSwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ChatSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42453f = false;
        this.f42454g = false;
        this.f42456i = -1.0f;
        this.l = false;
        this.o = -1;
        this.v = -1;
        this.w = -1;
        this.I = true;
        this.J = 0;
        this.K = null;
        this.L = true;
        this.M = 1.0f;
        this.N = true;
        this.O = new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                boolean unused = ChatSwipeRefreshLayout.this.N = false;
            }

            public final void onAnimationEnd(Animation animation) {
                boolean unused = ChatSwipeRefreshLayout.this.N = true;
                if (!ChatSwipeRefreshLayout.this.f42453f) {
                    ChatSwipeRefreshLayout.this.t.setVisibility(8);
                    if (ChatSwipeRefreshLayout.this.p) {
                        ChatSwipeRefreshLayout.this.setAnimationProgress(0.0f);
                    } else {
                        ChatSwipeRefreshLayout chatSwipeRefreshLayout = ChatSwipeRefreshLayout.this;
                        chatSwipeRefreshLayout.a(chatSwipeRefreshLayout.f42449b - ChatSwipeRefreshLayout.this.k, true);
                    }
                } else if (ChatSwipeRefreshLayout.this.C) {
                    if (ChatSwipeRefreshLayout.this.L) {
                        u.c((View) ChatSwipeRefreshLayout.this.K, 1.0f);
                        ChatSwipeRefreshLayout.this.K.setOnDraw(true);
                        new Thread(ChatSwipeRefreshLayout.this.K).start();
                    }
                    if (ChatSwipeRefreshLayout.this.f42451d != null) {
                        ChatSwipeRefreshLayout.this.f42451d.a();
                    }
                }
                ChatSwipeRefreshLayout chatSwipeRefreshLayout2 = ChatSwipeRefreshLayout.this;
                int unused2 = chatSwipeRefreshLayout2.k = chatSwipeRefreshLayout2.t.getTop();
                ChatSwipeRefreshLayout.this.b();
            }
        };
        this.P = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                float f3;
                if (!ChatSwipeRefreshLayout.this.H) {
                    f3 = ChatSwipeRefreshLayout.this.B - ((float) Math.abs(ChatSwipeRefreshLayout.this.f42449b));
                } else {
                    f3 = ChatSwipeRefreshLayout.this.B;
                }
                ChatSwipeRefreshLayout.this.a((ChatSwipeRefreshLayout.this.f42448a + ((int) (((float) (((int) f3) - ChatSwipeRefreshLayout.this.f42448a)) * f2))) - ChatSwipeRefreshLayout.this.t.getTop(), false);
            }

            public final void setAnimationListener(Animation.AnimationListener animationListener) {
                super.setAnimationListener(animationListener);
            }
        };
        this.Q = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                ChatSwipeRefreshLayout.b(ChatSwipeRefreshLayout.this, f2);
            }
        };
        this.f42455h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.j = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.r = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.D = defaultDisplay.getWidth();
        this.E = defaultDisplay.getWidth();
        this.F = (int) (displayMetrics.density * 50.0f);
        this.G = (int) (displayMetrics.density * 50.0f);
        this.K = new CircleProgressView(getContext());
        int i2 = this.F;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) i2) * 0.8d), (int) (((double) i2) * 0.8d));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.t = new a(getContext());
        this.t.setVisibility(8);
        this.K.setVisibility(0);
        this.K.setOnDraw(false);
        this.t.addView(this.K, layoutParams);
        addView(this.t);
        this.u = new RelativeLayout(getContext());
        this.u.setVisibility(8);
        addView(this.u);
        u.a((ViewGroup) this);
        this.B = displayMetrics.density * 64.0f;
        this.M = displayMetrics.density;
        this.f42456i = this.B;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.v < 0 && this.w < 0) {
            return i3;
        }
        if (i3 == i2 - 2) {
            return this.v;
        }
        if (i3 == i2 - 1) {
            return this.w;
        }
        int i4 = this.w;
        int i5 = this.v;
        if (i4 <= i5) {
            i4 = i5;
        }
        int i6 = this.w;
        int i7 = this.v;
        if (i6 >= i7) {
            i6 = i7;
        }
        if (i3 < i6 || i3 >= i4 - 1) {
            return (i3 >= i4 || i3 == i4 + -1) ? i3 + 2 : i3;
        }
        return i3 + 1;
    }

    public void setOnPullRefreshListener(b bVar) {
        this.f42451d = bVar;
    }

    public void setHeaderViewBackgroundColor(int i2) {
        this.t.setBackgroundColor(i2);
    }

    public void setOnPushLoadMoreListener(c cVar) {
        this.f42452e = cVar;
    }

    public void setRefreshing(boolean z2) {
        float f2;
        if (!z2 || this.f42453f == z2) {
            a(z2, false);
            if (this.L) {
                this.K.setOnDraw(false);
                return;
            }
            return;
        }
        this.f42453f = z2;
        if (!this.H) {
            f2 = this.B + ((float) this.f42449b);
        } else {
            f2 = this.B;
        }
        a(((int) f2) - this.k, true);
        this.C = false;
        Animation.AnimationListener animationListener = this.O;
        this.t.setVisibility(0);
        this.y = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                ChatSwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.y.setDuration((long) this.j);
        if (animationListener != null) {
            this.t.f42477a = animationListener;
        }
        this.t.clearAnimation();
        this.t.startAnimation(this.y);
    }

    /* access modifiers changed from: private */
    public void setAnimationProgress(float f2) {
        if (!this.L) {
            f2 = 1.0f;
        }
        u.e((View) this.t, f2);
        u.f((View) this.t, f2);
    }

    private void a(boolean z2, boolean z3) {
        if (this.f42453f != z2) {
            this.C = z3;
            c();
            this.f42453f = z2;
            if (this.f42453f) {
                a(this.k, this.O);
            } else {
                b(this.k, this.O);
            }
        }
    }

    private void c() {
        if (this.f42450c == null) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt.equals(this.t) || childAt.equals(this.u)) {
                    i2++;
                } else {
                    this.f42450c = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f42456i = (float) i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f42450c == null) {
                c();
            }
            if (this.f42450c != null) {
                int measuredHeight2 = this.k + this.t.getMeasuredHeight();
                if (!this.I) {
                    measuredHeight2 = 0;
                }
                View view = this.f42450c;
                int paddingLeft = getPaddingLeft();
                int paddingTop = (getPaddingTop() + measuredHeight2) - this.J;
                int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
                int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
                q.d("debug:onLayout childHeight = ".concat(String.valueOf(paddingTop2)));
                view.layout(paddingLeft, paddingTop, paddingLeft2 + paddingLeft, paddingTop2 + paddingTop);
                int measuredWidth2 = this.t.getMeasuredWidth();
                int measuredHeight3 = this.t.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.k;
                this.t.layout(i6 - i7, i8, i7 + i6, measuredHeight3 + i8);
                int measuredWidth3 = this.u.getMeasuredWidth();
                int measuredHeight4 = this.u.getMeasuredHeight();
                int i9 = measuredWidth3 / 2;
                int i10 = this.J;
                this.u.layout(i6 - i9, measuredHeight - i10, i6 + i9, (measuredHeight + measuredHeight4) - i10);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f42450c == null) {
            c();
        }
        View view = this.f42450c;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.t.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.F * 3, 1073741824));
            this.u.measure(View.MeasureSpec.makeMeasureSpec(this.E, 1073741824), View.MeasureSpec.makeMeasureSpec(this.G, 1073741824));
            if (!this.H && !this.l) {
                this.l = true;
                int i4 = -this.t.getMeasuredHeight();
                this.f42449b = i4;
                this.k = i4;
                b();
            }
            this.v = -1;
            int i5 = 0;
            while (true) {
                if (i5 >= getChildCount()) {
                    break;
                } else if (getChildAt(i5) == this.t) {
                    this.v = i5;
                    break;
                } else {
                    i5++;
                }
            }
            this.w = -1;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                if (getChildAt(i6) == this.u) {
                    this.w = i6;
                    return;
                }
            }
        }
    }

    private boolean d() {
        if (Build.VERSION.SDK_INT >= 14) {
            return !u.b(this.f42450c, -1);
        }
        View view = this.f42450c;
        if (!(view instanceof AbsListView)) {
            return view.getScrollY() <= 0;
        }
        AbsListView absListView = (AbsListView) view;
        return absListView.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getPaddingTop());
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0103 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e() {
        /*
            r9 = this;
            boolean r0 = r9.d()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.view.View r0 = r9.f42450c
            boolean r2 = r0 instanceof androidx.recyclerview.widget.RecyclerView
            r3 = 1
            if (r2 == 0) goto L_0x008d
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r0.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
            int r0 = r0.getItemCount()
            boolean r4 = r2 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r4 == 0) goto L_0x002d
            if (r0 <= 0) goto L_0x002d
            androidx.recyclerview.widget.LinearLayoutManager r2 = (androidx.recyclerview.widget.LinearLayoutManager) r2
            int r2 = r2.findLastCompletelyVisibleItemPosition()
            int r0 = r0 - r3
            if (r2 != r0) goto L_0x008c
            return r3
        L_0x002d:
            boolean r4 = r2 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r4 == 0) goto L_0x008c
            androidx.recyclerview.widget.StaggeredGridLayoutManager r2 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r2
            r4 = 2
            int[] r5 = new int[r4]
            int r6 = r2.f4106a
            if (r4 < r6) goto L_0x0071
            r4 = 0
        L_0x003b:
            int r6 = r2.f4106a
            if (r4 >= r6) goto L_0x0065
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r6 = r2.f4107b
            r6 = r6[r4]
            androidx.recyclerview.widget.StaggeredGridLayoutManager r7 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            boolean r7 = r7.f4111f
            if (r7 == 0) goto L_0x0054
            java.util.ArrayList<android.view.View> r7 = r6.f4140a
            int r7 = r7.size()
            int r6 = r6.a(r1, r7, r3)
            goto L_0x0060
        L_0x0054:
            java.util.ArrayList<android.view.View> r7 = r6.f4140a
            int r7 = r7.size()
            int r7 = r7 - r3
            r8 = -1
            int r6 = r6.a(r7, r8, r3)
        L_0x0060:
            r5[r4] = r6
            int r4 = r4 + 1
            goto L_0x003b
        L_0x0065:
            r2 = r5[r1]
            r4 = r5[r3]
            int r2 = java.lang.Math.max(r2, r4)
            int r0 = r0 - r3
            if (r2 != r0) goto L_0x008c
            return r3
        L_0x0071:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Provided int[]'s size must be more than or equal to span count. Expected:"
            r1.<init>(r3)
            int r2 = r2.f4106a
            r1.append(r2)
            java.lang.String r2 = ", array size:2"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008c:
            return r1
        L_0x008d:
            boolean r2 = r0 instanceof android.widget.AbsListView
            if (r2 == 0) goto L_0x00bf
            android.widget.AbsListView r0 = (android.widget.AbsListView) r0
            android.widget.Adapter r2 = r0.getAdapter()
            android.widget.ListAdapter r2 = (android.widget.ListAdapter) r2
            int r2 = r2.getCount()
            int r4 = r0.getFirstVisiblePosition()
            if (r4 != 0) goto L_0x00b2
            android.view.View r4 = r0.getChildAt(r1)
            int r4 = r4.getTop()
            int r5 = r0.getPaddingTop()
            if (r4 < r5) goto L_0x00b2
            return r1
        L_0x00b2:
            int r0 = r0.getLastVisiblePosition()
            if (r0 <= 0) goto L_0x00be
            if (r2 <= 0) goto L_0x00be
            int r2 = r2 - r3
            if (r0 != r2) goto L_0x00be
            return r3
        L_0x00be:
            return r1
        L_0x00bf:
            boolean r2 = r0 instanceof android.widget.ScrollView
            if (r2 == 0) goto L_0x00e1
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r3
            android.view.View r2 = r0.getChildAt(r2)
            if (r2 == 0) goto L_0x0103
            int r2 = r2.getBottom()
            int r4 = r0.getHeight()
            int r0 = r0.getScrollY()
            int r4 = r4 + r0
            int r2 = r2 - r4
            if (r2 != 0) goto L_0x0103
            return r3
        L_0x00e1:
            boolean r2 = r0 instanceof androidx.core.widget.NestedScrollView
            if (r2 == 0) goto L_0x0103
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r3
            android.view.View r2 = r0.getChildAt(r2)
            if (r2 == 0) goto L_0x0103
            int r2 = r2.getBottom()
            int r4 = r0.getHeight()
            int r0 = r0.getScrollY()
            int r4 = r4 + r0
            int r2 = r2 - r4
            if (r2 != 0) goto L_0x0103
            return r3
        L_0x0103:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.ChatSwipeRefreshLayout.e():boolean");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c();
        int actionMasked = motionEvent.getActionMasked();
        if (this.q && actionMasked == 0) {
            this.q = false;
        }
        if (!isEnabled() || this.q || this.f42453f || this.f42454g || (!d() && !e())) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            a(motionEvent);
                        }
                        return this.n;
                    }
                }
            }
            this.n = false;
            this.o = -1;
            return this.n;
        }
        a(this.f42449b - this.t.getTop(), true);
        this.o = motionEvent.getPointerId(0);
        this.n = false;
        float a2 = a(motionEvent, this.o);
        if (a2 == -1.0f) {
            return false;
        }
        this.m = a2;
        int i2 = this.o;
        if (i2 == -1) {
            q.b("Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
        }
        float a3 = a(motionEvent, i2);
        if (a3 == -1.0f) {
            return false;
        }
        if (e()) {
            if (this.m - a3 > ((float) this.f42455h) && !this.n) {
                this.n = true;
            }
        } else if (a3 - this.m > ((float) this.f42455h) && !this.n) {
            this.n = true;
        }
        return this.n;
    }

    private void a(int i2, final int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.setDuration(150);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = ChatSwipeRefreshLayout.this.J = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ChatSwipeRefreshLayout.this.g();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                if (i3 <= 0 || ChatSwipeRefreshLayout.this.f42452e == null) {
                    ChatSwipeRefreshLayout.this.a();
                    boolean unused = ChatSwipeRefreshLayout.this.f42454g = false;
                    return;
                }
                boolean unused2 = ChatSwipeRefreshLayout.this.f42454g = true;
                ChatSwipeRefreshLayout.this.f42452e.a();
            }
        });
        ofInt.setInterpolator(this.r);
        ofInt.start();
    }

    public void setLoadMore(boolean z2) {
        if (!z2 && this.f42454g) {
            if (Build.VERSION.SDK_INT < 11) {
                this.f42454g = false;
                this.J = 0;
                g();
                return;
            }
            a(this.G, 0);
        }
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.f42448a = i2;
        this.P.reset();
        this.P.setDuration(200);
        this.P.setInterpolator(this.r);
        if (animationListener != null) {
            this.t.f42477a = animationListener;
        }
        this.t.clearAnimation();
        this.t.startAnimation(this.P);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.p) {
            c(i2, animationListener);
        } else {
            this.f42448a = i2;
            this.Q.reset();
            this.Q.setDuration(200);
            this.Q.setInterpolator(this.r);
            if (animationListener != null) {
                this.t.f42477a = animationListener;
            }
            this.t.clearAnimation();
            this.t.startAnimation(this.Q);
        }
        f();
    }

    private void f() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                ChatSwipeRefreshLayout.this.a();
            }
        }, 200);
    }

    public final void a() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        View view = this.f42450c;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((view.getWidth() - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((view.getHeight() - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.t.getMeasuredWidth();
        int i2 = measuredWidth / 2;
        int i3 = measuredWidth2 / 2;
        this.t.layout(i2 - i3, -this.t.getMeasuredHeight(), i3 + i2, 0);
        int measuredWidth3 = this.u.getMeasuredWidth();
        int i4 = measuredWidth3 / 2;
        this.u.layout(i2 - i4, measuredHeight, i2 + i4, this.u.getMeasuredHeight() + measuredHeight);
    }

    private void c(int i2, Animation.AnimationListener animationListener) {
        this.f42448a = i2;
        this.x = u.t(this.t);
        this.A = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                ChatSwipeRefreshLayout.this.setAnimationProgress(ChatSwipeRefreshLayout.this.x + ((-ChatSwipeRefreshLayout.this.x) * f2));
                ChatSwipeRefreshLayout.b(ChatSwipeRefreshLayout.this, f2);
            }
        };
        this.A.setDuration(150);
        if (animationListener != null) {
            this.t.f42477a = animationListener;
        }
        this.t.clearAnimation();
        this.t.startAnimation(this.A);
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        this.t.bringToFront();
        this.t.offsetTopAndBottom(i2);
        this.k = this.t.getTop();
        if (z2 && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
        b();
    }

    /* access modifiers changed from: private */
    public void g() {
        this.u.setVisibility(0);
        this.u.bringToFront();
        if (Build.VERSION.SDK_INT < 19) {
            this.u.getParent().requestLayout();
        }
        this.u.offsetTopAndBottom(-this.J);
    }

    class a extends RelativeLayout {

        /* renamed from: a  reason: collision with root package name */
        Animation.AnimationListener f42477a;

        public a(Context context) {
            super(context);
        }

        public final void onAnimationStart() {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.f42477a;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        public final void onAnimationEnd() {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.f42477a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }
    }

    public void setTargetScrollWithLayout(boolean z2) {
        this.I = z2;
    }

    public void setDefaultCircleProgressColor(int i2) {
        if (this.L) {
            this.K.setProgressColor(i2);
        }
    }

    public void setDefaultCircleBackgroundColor(int i2) {
        if (this.L) {
            this.K.setCircleBackgroundColor(i2);
        }
    }

    public void setDefaultCircleShadowColor(int i2) {
        if (this.L) {
            this.K.setShadowColor(i2);
        }
    }

    public class CircleProgressView extends View implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Paint f42469b;

        /* renamed from: c  reason: collision with root package name */
        private Paint f42470c;

        /* renamed from: d  reason: collision with root package name */
        private int f42471d;

        /* renamed from: e  reason: collision with root package name */
        private int f42472e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f42473f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f42474g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f42475h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f42476i = 8;
        private RectF j = null;
        private RectF k = null;
        private int l;
        private int m = -3355444;
        private int n = -1;
        private int o = -6710887;

        public CircleProgressView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            RectF bgRect = getBgRect();
            if (this.f42470c == null) {
                this.f42470c = new Paint();
                this.f42470c.setColor(this.n);
                this.f42470c.setStyle(Paint.Style.FILL);
                this.f42470c.setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    setLayerType(1, this.f42470c);
                }
                this.f42470c.setShadowLayer(4.0f, 0.0f, 2.0f, this.o);
            }
            canvas.drawArc(bgRect, 0.0f, 360.0f, false, this.f42470c);
            int i2 = this.f42475h;
            if ((i2 / 360) % 2 == 0) {
                this.l = (i2 % 720) / 2;
            } else {
                this.l = 360 - ((i2 % 720) / 2);
            }
            RectF ovalRect = getOvalRect();
            float f2 = (float) this.f42475h;
            float f3 = (float) this.l;
            if (this.f42469b == null) {
                this.f42469b = new Paint();
                this.f42469b.setStrokeWidth((float) ((int) (ChatSwipeRefreshLayout.this.M * 3.0f)));
                this.f42469b.setStyle(Paint.Style.STROKE);
                this.f42469b.setAntiAlias(true);
            }
            this.f42469b.setColor(this.m);
            canvas.drawArc(ovalRect, f2, f3, false, this.f42469b);
        }

        private RectF getBgRect() {
            this.f42471d = getWidth();
            this.f42472e = getHeight();
            if (this.k == null) {
                int p = (int) (ChatSwipeRefreshLayout.this.M * 2.0f);
                float f2 = (float) p;
                this.k = new RectF(f2, f2, (float) (this.f42471d - p), (float) (this.f42472e - p));
            }
            return this.k;
        }

        private RectF getOvalRect() {
            this.f42471d = getWidth();
            this.f42472e = getHeight();
            if (this.j == null) {
                int p = (int) (ChatSwipeRefreshLayout.this.M * 8.0f);
                float f2 = (float) p;
                this.j = new RectF(f2, f2, (float) (this.f42471d - p), (float) (this.f42472e - p));
            }
            return this.j;
        }

        public void setProgressColor(int i2) {
            this.m = i2;
        }

        public void setCircleBackgroundColor(int i2) {
            this.n = i2;
        }

        public void setShadowColor(int i2) {
            this.o = i2;
        }

        public void setPullDistance(int i2) {
            this.f42475h = i2 * 2;
            postInvalidate();
        }

        public void run() {
            while (this.f42473f) {
                this.f42474g = true;
                long currentTimeMillis = System.currentTimeMillis();
                this.f42475h += this.f42476i;
                postInvalidate();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 < 16) {
                    try {
                        Thread.sleep(16 - currentTimeMillis2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        public void setOnDraw(boolean z) {
            this.f42473f = z;
        }

        public void setSpeed(int i2) {
            this.f42476i = i2;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            this.f42473f = false;
            super.onDetachedFromWindow();
        }
    }

    private static float a(MotionEvent motionEvent, int i2) {
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return motionEvent.getY(findPointerIndex);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        if (this.q && actionMasked == 0) {
            this.q = false;
        }
        if (!isEnabled() || this.q || (!d() && !e())) {
            return false;
        }
        if (e()) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.o);
                        if (findPointerIndex < 0) {
                            q.b("Got ACTION_MOVE event but have an invalid active pointer id.");
                            return false;
                        }
                        float y2 = (this.m - motionEvent.getY(findPointerIndex)) * 0.5f;
                        if (this.n) {
                            this.J = (int) y2;
                            g();
                            c cVar2 = this.f42452e;
                            if (cVar2 != null) {
                                cVar2.b();
                            }
                        }
                    } else if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            this.o = motionEvent.getPointerId(motionEvent.getActionIndex());
                        } else if (actionMasked == 6) {
                            a(motionEvent);
                        }
                    }
                }
                int i2 = this.o;
                if (i2 == -1) {
                    if (actionMasked == 1) {
                        q.b("Got ACTION_UP event but don't have an active pointer id.");
                    }
                    return false;
                }
                float y3 = (this.m - motionEvent.getY(motionEvent.findPointerIndex(i2))) * 0.5f;
                this.n = false;
                this.o = -1;
                int i3 = this.G;
                if (y3 < ((float) i3) || this.f42452e == null) {
                    this.J = 0;
                } else {
                    this.J = i3;
                }
                if (Build.VERSION.SDK_INT < 11) {
                    g();
                    if (this.J == this.G && (cVar = this.f42452e) != null) {
                        this.f42454g = true;
                        cVar.a();
                    }
                } else {
                    a((int) y3, this.J);
                }
                return false;
            }
            this.o = motionEvent.getPointerId(0);
            this.n = false;
            q.d("debug:onTouchEvent ACTION_DOWN");
            return true;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.o);
                    if (findPointerIndex2 < 0) {
                        q.b("Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float y4 = (motionEvent.getY(findPointerIndex2) - this.m) * 0.5f;
                    if (this.n) {
                        float f2 = y4 / this.f42456i;
                        if (f2 < 0.0f) {
                            return false;
                        }
                        float min = Math.min(1.0f, Math.abs(f2));
                        float abs = Math.abs(y4) - this.f42456i;
                        float f3 = this.H ? this.B - ((float) this.f42449b) : this.B;
                        double max = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
                        int pow = this.f42449b + ((int) ((f3 * min) + (((float) (max - Math.pow(max, 2.0d))) * 2.0f * f3 * 2.0f)));
                        if (this.t.getVisibility() != 0) {
                            this.t.setVisibility(0);
                        }
                        if (!this.p) {
                            u.e((View) this.t, 1.0f);
                            u.f((View) this.t, 1.0f);
                        }
                        if (this.L) {
                            float f4 = y4 / this.f42456i;
                            if (f4 >= 1.0f) {
                                f4 = 1.0f;
                            }
                            u.e((View) this.K, f4);
                            u.f((View) this.K, f4);
                            u.c((View) this.K, f4);
                        }
                        float f5 = this.f42456i;
                        if (y4 < f5) {
                            if (this.p) {
                                setAnimationProgress(y4 / f5);
                            }
                            b bVar = this.f42451d;
                            if (bVar != null) {
                                bVar.b();
                            }
                        } else {
                            b bVar2 = this.f42451d;
                            if (bVar2 != null) {
                                bVar2.b();
                            }
                        }
                        a(pow - this.k, true);
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.o = motionEvent.getPointerId(motionEvent.getActionIndex());
                    } else if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            int i4 = this.o;
            if (i4 == -1) {
                if (actionMasked == 1) {
                    q.b("Got ACTION_UP event but don't have an active pointer id.");
                }
                return false;
            }
            this.n = false;
            if ((motionEvent.getY(motionEvent.findPointerIndex(i4)) - this.m) * 0.5f > this.f42456i) {
                a(true, true);
            } else {
                this.f42453f = false;
                AnonymousClass5 r13 = null;
                if (!this.p) {
                    r13 = new Animation.AnimationListener() {
                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            if (!ChatSwipeRefreshLayout.this.p) {
                                ChatSwipeRefreshLayout.j(ChatSwipeRefreshLayout.this);
                            }
                        }
                    };
                }
                b(this.k, (Animation.AnimationListener) r13);
            }
            this.o = -1;
            return false;
        }
        this.o = motionEvent.getPointerId(0);
        this.n = false;
        return true;
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.o) {
            this.o = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    static /* synthetic */ void j(ChatSwipeRefreshLayout chatSwipeRefreshLayout) {
        chatSwipeRefreshLayout.z = new Animation() {
            public final void applyTransformation(float f2, Transformation transformation) {
                ChatSwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        chatSwipeRefreshLayout.z.setDuration(150);
        a aVar = chatSwipeRefreshLayout.t;
        aVar.f42477a = null;
        aVar.clearAnimation();
        chatSwipeRefreshLayout.t.startAnimation(chatSwipeRefreshLayout.z);
    }

    static /* synthetic */ void b(ChatSwipeRefreshLayout chatSwipeRefreshLayout, float f2) {
        int i2 = chatSwipeRefreshLayout.f42448a;
        chatSwipeRefreshLayout.a((i2 + ((int) (((float) (chatSwipeRefreshLayout.f42449b - i2)) * f2))) - chatSwipeRefreshLayout.t.getTop(), false);
    }
}
