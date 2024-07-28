package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.h.u;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.mapqr.vision.ViewFinder;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

final class j extends RecyclerView.h implements RecyclerView.k {
    private static final int[] r = {16842919};
    private static final int[] s = new int[0];
    private int A = 0;
    private final int[] B = new int[2];
    private final int[] C = new int[2];
    private final Runnable D = new Runnable() {
        public final void run() {
            j jVar = j.this;
            int i2 = jVar.q;
            if (i2 == 1) {
                jVar.p.cancel();
            } else if (i2 != 2) {
                return;
            }
            jVar.q = 3;
            jVar.p.setFloatValues(new float[]{((Float) jVar.p.getAnimatedValue()).floatValue(), 0.0f});
            jVar.p.setDuration(500);
            jVar.p.start();
        }
    };
    private final RecyclerView.l E = new RecyclerView.l() {
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            j jVar = j.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = jVar.l.computeVerticalScrollRange();
            int i4 = jVar.k;
            jVar.m = computeVerticalScrollRange - i4 > 0 && jVar.k >= jVar.f4277a;
            int computeHorizontalScrollRange = jVar.l.computeHorizontalScrollRange();
            int i5 = jVar.j;
            jVar.n = computeHorizontalScrollRange - i5 > 0 && jVar.j >= jVar.f4277a;
            if (jVar.m || jVar.n) {
                if (jVar.m) {
                    float f2 = (float) i4;
                    jVar.f4281e = (int) ((f2 * (((float) computeVerticalScrollOffset) + (f2 / 2.0f))) / ((float) computeVerticalScrollRange));
                    jVar.f4280d = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
                }
                if (jVar.n) {
                    float f3 = (float) computeHorizontalScrollOffset;
                    float f4 = (float) i5;
                    jVar.f4284h = (int) ((f4 * (f3 + (f4 / 2.0f))) / ((float) computeHorizontalScrollRange));
                    jVar.f4283g = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
                }
                if (jVar.o == 0 || jVar.o == 1) {
                    jVar.a(1);
                }
            } else if (jVar.o != 0) {
                jVar.a(0);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f4277a;

    /* renamed from: b  reason: collision with root package name */
    final StateListDrawable f4278b;

    /* renamed from: c  reason: collision with root package name */
    final Drawable f4279c;

    /* renamed from: d  reason: collision with root package name */
    int f4280d;

    /* renamed from: e  reason: collision with root package name */
    int f4281e;

    /* renamed from: f  reason: collision with root package name */
    float f4282f;

    /* renamed from: g  reason: collision with root package name */
    int f4283g;

    /* renamed from: h  reason: collision with root package name */
    int f4284h;

    /* renamed from: i  reason: collision with root package name */
    float f4285i;
    int j = 0;
    int k = 0;
    RecyclerView l;
    boolean m = false;
    boolean n = false;
    int o = 0;
    final ValueAnimator p = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    int q = 0;
    private final int t;
    private final int u;
    private final int v;
    private final StateListDrawable w;
    private final Drawable x;
    private final int y;
    private final int z;

    public final void onRequestDisallowInterceptTouchEvent(boolean z2) {
    }

    j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        this.f4278b = stateListDrawable;
        this.f4279c = drawable;
        this.w = stateListDrawable2;
        this.x = drawable2;
        this.u = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.v = Math.max(i2, drawable.getIntrinsicWidth());
        this.y = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.z = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f4277a = i3;
        this.t = i4;
        this.f4278b.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
        this.f4279c.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
        this.p.addListener(new a());
        this.p.addUpdateListener(new b());
        RecyclerView recyclerView2 = this.l;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.l.removeOnItemTouchListener(this);
                this.l.removeOnScrollListener(this.E);
                c();
            }
            this.l = recyclerView;
            RecyclerView recyclerView3 = this.l;
            if (recyclerView3 != null) {
                recyclerView3.addItemDecoration(this);
                this.l.addOnItemTouchListener(this);
                this.l.addOnScrollListener(this.E);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (i2 == 2 && this.o != 2) {
            this.f4278b.setState(r);
            c();
        }
        if (i2 == 0) {
            this.l.invalidate();
        } else {
            b();
        }
        if (this.o == 2 && i2 != 2) {
            this.f4278b.setState(s);
            b(ViewFinder.MAX_FRAME_WIDTH);
        } else if (i2 == 1) {
            b(1500);
        }
        this.o = i2;
    }

    private boolean a() {
        return u.j(this.l) == 1;
    }

    private void b() {
        int i2 = this.q;
        if (i2 != 0) {
            if (i2 == 3) {
                this.p.cancel();
            } else {
                return;
            }
        }
        this.q = 1;
        ValueAnimator valueAnimator = this.p;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.p.setDuration(500);
        this.p.setStartDelay(0);
        this.p.start();
    }

    private void c() {
        this.l.removeCallbacks(this.D);
    }

    private void b(int i2) {
        c();
        this.l.postDelayed(this.D, (long) i2);
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (this.j != this.l.getWidth() || this.k != this.l.getHeight()) {
            this.j = this.l.getWidth();
            this.k = this.l.getHeight();
            a(0);
        } else if (this.q != 0) {
            if (this.m) {
                int i2 = this.j;
                int i3 = this.u;
                int i4 = i2 - i3;
                int i5 = this.f4281e;
                int i6 = this.f4280d;
                int i7 = i5 - (i6 / 2);
                this.f4278b.setBounds(0, 0, i3, i6);
                this.f4279c.setBounds(0, 0, this.v, this.k);
                if (a()) {
                    this.f4279c.draw(canvas);
                    canvas.translate((float) this.u, (float) i7);
                    canvas.scale(-1.0f, 1.0f);
                    this.f4278b.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate((float) (-this.u), (float) (-i7));
                } else {
                    canvas.translate((float) i4, 0.0f);
                    this.f4279c.draw(canvas);
                    canvas.translate(0.0f, (float) i7);
                    this.f4278b.draw(canvas);
                    canvas.translate((float) (-i4), (float) (-i7));
                }
            }
            if (this.n) {
                int i8 = this.k;
                int i9 = this.y;
                int i10 = i8 - i9;
                int i11 = this.f4284h;
                int i12 = this.f4283g;
                int i13 = i11 - (i12 / 2);
                this.w.setBounds(0, 0, i12, i9);
                this.x.setBounds(0, 0, this.j, this.z);
                canvas.translate(0.0f, (float) i10);
                this.x.draw(canvas);
                canvas.translate((float) i13, 0.0f);
                this.w.draw(canvas);
                canvas.translate((float) (-i13), (float) (-i10));
            }
        }
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.o;
        if (i2 == 1) {
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!a2 && !b2) {
                return false;
            }
            if (b2) {
                this.A = 1;
                this.f4285i = (float) ((int) motionEvent.getX());
            } else if (a2) {
                this.A = 2;
                this.f4282f = (float) ((int) motionEvent.getY());
            }
            a(2);
        } else if (i2 == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.o != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a2 = a(motionEvent.getX(), motionEvent.getY());
                boolean b2 = b(motionEvent.getX(), motionEvent.getY());
                if (a2 || b2) {
                    if (b2) {
                        this.A = 1;
                        this.f4285i = (float) ((int) motionEvent.getX());
                    } else if (a2) {
                        this.A = 2;
                        this.f4282f = (float) ((int) motionEvent.getY());
                    }
                    a(2);
                }
            } else if (motionEvent.getAction() == 1 && this.o == 2) {
                this.f4282f = 0.0f;
                this.f4285i = 0.0f;
                a(1);
                this.A = 0;
            } else if (motionEvent.getAction() == 2 && this.o == 2) {
                b();
                if (this.A == 1) {
                    float x2 = motionEvent.getX();
                    int[] iArr = this.C;
                    int i2 = this.t;
                    iArr[0] = i2;
                    iArr[1] = this.j - i2;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x2));
                    if (Math.abs(((float) this.f4284h) - max) >= 2.0f) {
                        int a3 = a(this.f4285i, max, iArr, this.l.computeHorizontalScrollRange(), this.l.computeHorizontalScrollOffset(), this.j);
                        if (a3 != 0) {
                            this.l.scrollBy(a3, 0);
                        }
                        this.f4285i = max;
                    }
                }
                if (this.A == 2) {
                    float y2 = motionEvent.getY();
                    int[] iArr2 = this.B;
                    int i3 = this.t;
                    iArr2[0] = i3;
                    iArr2[1] = this.k - i3;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y2));
                    if (Math.abs(((float) this.f4281e) - max2) >= 2.0f) {
                        int a4 = a(this.f4282f, max2, iArr2, this.l.computeVerticalScrollRange(), this.l.computeVerticalScrollOffset(), this.k);
                        if (a4 != 0) {
                            this.l.scrollBy(0, a4);
                        }
                        this.f4282f = max2;
                    }
                }
            }
        }
    }

    private static int a(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private boolean a(float f2, float f3) {
        if (a()) {
            if (f2 > ((float) (this.u / 2))) {
                return false;
            }
        } else if (f2 < ((float) (this.j - this.u))) {
            return false;
        }
        int i2 = this.f4281e;
        int i3 = this.f4280d;
        return f3 >= ((float) (i2 - (i3 / 2))) && f3 <= ((float) (i2 + (i3 / 2)));
    }

    private boolean b(float f2, float f3) {
        if (f3 < ((float) (this.k - this.y))) {
            return false;
        }
        int i2 = this.f4284h;
        int i3 = this.f4283g;
        return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) (i2 + (i3 / 2)));
    }

    class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f4289b = false;

        a() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.f4289b) {
                this.f4289b = false;
            } else if (((Float) j.this.p.getAnimatedValue()).floatValue() == 0.0f) {
                j jVar = j.this;
                jVar.q = 0;
                jVar.a(0);
            } else {
                j jVar2 = j.this;
                jVar2.q = 2;
                jVar2.l.invalidate();
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f4289b = true;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            j.this.f4278b.setAlpha(floatValue);
            j.this.f4279c.setAlpha(floatValue);
            j.this.l.invalidate();
        }
    }
}
