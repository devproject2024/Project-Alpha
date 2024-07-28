package net.one97.paytm.o2o.movies.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import java.util.Arrays;

public final class ViewTooltip {

    /* renamed from: a  reason: collision with root package name */
    public View f76166a;

    /* renamed from: b  reason: collision with root package name */
    public final View f76167b;

    /* renamed from: c  reason: collision with root package name */
    public final TooltipView f76168c;

    public enum a {
        START,
        CENTER,
        END
    }

    public interface c {
        void a();
    }

    public interface d {
    }

    public enum f {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    public interface g {
        void a(View view, Animator.AnimatorListener animatorListener);

        void b(View view, Animator.AnimatorListener animatorListener);
    }

    public ViewTooltip(e eVar, View view) {
        Context context;
        this.f76167b = view;
        if (eVar.f76194b != null) {
            context = eVar.f76194b;
        } else {
            context = eVar.f76193a.getActivity();
        }
        this.f76168c = new TooltipView(context);
        NestedScrollView a2 = a(view);
        if (a2 != null) {
            a2.setOnScrollChangeListener(new NestedScrollView.b() {
                public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                    ViewTooltip.this.a(nestedScrollView, i2, i3, i4, i5);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        TooltipView tooltipView = this.f76168c;
        tooltipView.setTranslationY(tooltipView.getTranslationY() - ((float) (i3 - i5)));
    }

    private static NestedScrollView a(View view) {
        while (view.getParent() != null && (view.getParent() instanceof View)) {
            if (view.getParent() instanceof NestedScrollView) {
                return (NestedScrollView) view.getParent();
            }
            view = (View) view.getParent();
        }
        return null;
    }

    public static class b implements g {

        /* renamed from: a  reason: collision with root package name */
        private long f76192a = 400;

        public final void a(View view, Animator.AnimatorListener animatorListener) {
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(this.f76192a).setListener(animatorListener);
        }

        public final void b(View view, Animator.AnimatorListener animatorListener) {
            view.animate().alpha(0.0f).setDuration(this.f76192a).setListener(animatorListener);
        }
    }

    public static class TooltipView extends FrameLayout {
        private int A = Color.parseColor("#aaaaaa");

        /* renamed from: a  reason: collision with root package name */
        protected View f76175a;

        /* renamed from: b  reason: collision with root package name */
        int f76176b = 4;

        /* renamed from: c  reason: collision with root package name */
        int f76177c = 8;

        /* renamed from: d  reason: collision with root package name */
        private int f76178d = 15;

        /* renamed from: e  reason: collision with root package name */
        private int f76179e = 15;

        /* renamed from: f  reason: collision with root package name */
        private int f76180f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f76181g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f76182h = Color.parseColor("#1F7C82");

        /* renamed from: i  reason: collision with root package name */
        private Path f76183i;
        private Paint j;
        private Paint k;
        private f l = f.BOTTOM;
        private a m = a.CENTER;
        /* access modifiers changed from: private */
        public boolean n;
        private boolean o = true;
        private long p = 4000;
        /* access modifiers changed from: private */
        public c q;
        /* access modifiers changed from: private */
        public d r;
        private g s = new b();
        private int t = 30;
        private int u = 20;
        private int v = 30;
        private int w = 30;
        private int x = 30;
        private Rect y;
        private int z = 0;

        public TooltipView(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f76175a = new TextView(context);
            ((TextView) this.f76175a).setTextColor(-1);
            addView(this.f76175a, -2, -2);
            this.f76175a.setPadding(0, 0, 0, 0);
            this.j = new Paint(1);
            this.j.setColor(this.f76182h);
            this.j.setStyle(Paint.Style.FILL);
            this.k = null;
            setLayerType(1, this.j);
            setWithShadow(true);
        }

        public void setCustomView(View view) {
            removeView(this.f76175a);
            this.f76175a = view;
            addView(this.f76175a, -2, -2);
            this.f76183i = null;
        }

        public void setColor(int i2) {
            this.f76182h = i2;
            this.j.setColor(i2);
            postInvalidate();
        }

        public void setShadowColor(int i2) {
            this.A = i2;
            postInvalidate();
        }

        public void setPaint(Paint paint) {
            this.j = paint;
            setLayerType(1, paint);
            postInvalidate();
        }

        public void setPosition(f fVar) {
            this.l = fVar;
            int i2 = AnonymousClass2.f76173a[fVar.ordinal()];
            if (i2 == 1) {
                setPadding(this.x, this.u, this.w, this.v + this.f76178d);
            } else if (i2 == 2) {
                setPadding(this.x, this.u + this.f76178d, this.w, this.v);
            } else if (i2 == 3) {
                setPadding(this.x, this.u, this.w + this.f76178d, this.v);
            } else if (i2 == 4) {
                setPadding(this.x + this.f76178d, this.u, this.w, this.v);
            }
            postInvalidate();
        }

        public void setAlign(a aVar) {
            this.m = aVar;
            postInvalidate();
        }

        public void setText(String str) {
            View view = this.f76175a;
            if (view instanceof TextView) {
                ((TextView) view).setText(Html.fromHtml(str));
            }
            postInvalidate();
        }

        public void setText(int i2) {
            View view = this.f76175a;
            if (view instanceof TextView) {
                ((TextView) view).setText(i2);
            }
            postInvalidate();
        }

        public void setTextColor(int i2) {
            View view = this.f76175a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(i2);
            }
            postInvalidate();
        }

        public int getArrowHeight() {
            return this.f76178d;
        }

        public void setArrowHeight(int i2) {
            this.f76178d = i2;
            postInvalidate();
        }

        public int getArrowWidth() {
            return this.f76179e;
        }

        public void setArrowWidth(int i2) {
            this.f76179e = i2;
            postInvalidate();
        }

        public int getArrowSourceMargin() {
            return this.f76180f;
        }

        public void setArrowSourceMargin(int i2) {
            this.f76180f = i2;
            postInvalidate();
        }

        public int getArrowTargetMargin() {
            return this.f76181g;
        }

        public void setArrowTargetMargin(int i2) {
            this.f76181g = i2;
            postInvalidate();
        }

        public void setTextTypeFace(Typeface typeface) {
            View view = this.f76175a;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(typeface);
            }
            postInvalidate();
        }

        public void setTextSize(int i2, float f2) {
            View view = this.f76175a;
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(i2, f2);
            }
            postInvalidate();
        }

        public void setTextGravity(int i2) {
            View view = this.f76175a;
            if (view instanceof TextView) {
                ((TextView) view).setGravity(i2);
            }
            postInvalidate();
        }

        public void setClickToHide(boolean z2) {
            this.n = z2;
        }

        public void setCorner(int i2) {
            this.t = i2;
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            int i6 = this.f76176b;
            RectF rectF = new RectF((float) i6, (float) i6, (float) (i2 - (i6 * 2)), (float) (i3 - (i6 * 2)));
            int i7 = this.t;
            this.f76183i = a(rectF, (float) i7, (float) i7, (float) i7, (float) i7);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Path path = this.f76183i;
            if (path != null) {
                canvas.drawPath(path, this.j);
                Paint paint = this.k;
                if (paint != null) {
                    canvas.drawPath(this.f76183i, paint);
                }
            }
        }

        public void setListenerDisplay(c cVar) {
            this.q = cVar;
        }

        public void setListenerHide(d dVar) {
            this.r = dVar;
        }

        public void setTooltipAnimation(g gVar) {
            this.s = gVar;
        }

        public final void a() {
            final AnonymousClass5 r0 = new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    TooltipView tooltipView = TooltipView.this;
                    if (tooltipView.getParent() != null) {
                        ((ViewGroup) tooltipView.getParent()).removeView(tooltipView);
                    }
                }
            };
            this.s.b(this, new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    r0.onAnimationEnd(animator);
                    if (TooltipView.this.r != null) {
                        d unused = TooltipView.this.r;
                    }
                }
            });
        }

        public void setDuration(long j2) {
            this.p = j2;
        }

        public void setAutoHide(boolean z2) {
            this.o = z2;
        }

        public void setupPosition(Rect rect) {
            int i2;
            int i3;
            int i4;
            if (this.l == f.LEFT || this.l == f.RIGHT) {
                if (this.l == f.LEFT) {
                    i4 = (rect.left - getWidth()) - this.z;
                } else {
                    i4 = rect.right + this.z;
                }
                i2 = i4;
                i3 = rect.top + a(getHeight(), rect.height());
            } else {
                if (this.l == f.BOTTOM) {
                    i3 = rect.bottom + this.z;
                } else {
                    i3 = (rect.top - getHeight()) - this.z;
                }
                i2 = rect.left + a(getWidth(), rect.width());
            }
            setTranslationX((float) i2);
            setTranslationY((float) i3);
        }

        private int a(int i2, int i3) {
            int i4 = AnonymousClass2.f76174b[this.m.ordinal()];
            if (i4 == 1) {
                return i3 - i2;
            }
            if (i4 != 2) {
                return 0;
            }
            return (i3 - i2) / 2;
        }

        private Path a(RectF rectF, float f2, float f3, float f4, float f5) {
            float f6;
            float f7;
            RectF rectF2 = rectF;
            Path path = new Path();
            if (this.y == null) {
                return path;
            }
            float f8 = 0.0f;
            float f9 = f2 < 0.0f ? 0.0f : f2;
            float f10 = f3 < 0.0f ? 0.0f : f3;
            float f11 = f5 < 0.0f ? 0.0f : f5;
            float f12 = f4 < 0.0f ? 0.0f : f4;
            float f13 = this.l == f.RIGHT ? (float) this.f76178d : 0.0f;
            float f14 = this.l == f.BOTTOM ? (float) this.f76178d : 0.0f;
            float f15 = this.l == f.LEFT ? (float) this.f76178d : 0.0f;
            if (this.l == f.TOP) {
                f8 = (float) this.f76178d;
            }
            float f16 = f13 + rectF2.left;
            float f17 = f14 + rectF2.top;
            float f18 = rectF2.right - f15;
            float f19 = rectF2.bottom - f8;
            float centerX = ((float) this.y.centerX()) - getX();
            float f20 = Arrays.asList(new f[]{f.TOP, f.BOTTOM}).contains(this.l) ? ((float) this.f76180f) + centerX : centerX;
            if (Arrays.asList(new f[]{f.TOP, f.BOTTOM}).contains(this.l)) {
                centerX += (float) this.f76181g;
            }
            float f21 = Arrays.asList(new f[]{f.RIGHT, f.LEFT}).contains(this.l) ? (f19 / 2.0f) - ((float) this.f76180f) : f19 / 2.0f;
            if (Arrays.asList(new f[]{f.RIGHT, f.LEFT}).contains(this.l)) {
                f6 = (f19 / 2.0f) - ((float) this.f76181g);
                f7 = 2.0f;
            } else {
                f7 = 2.0f;
                f6 = f19 / 2.0f;
            }
            float f22 = f9 / f7;
            float f23 = f16 + f22;
            path.moveTo(f23, f17);
            float f24 = f23;
            float f25 = f22;
            if (this.l == f.BOTTOM) {
                path.lineTo(f20 - ((float) this.f76179e), f17);
                path.lineTo(centerX, rectF2.top);
                path.lineTo(((float) this.f76179e) + f20, f17);
            }
            float f26 = f10 / 2.0f;
            path.lineTo(f18 - f26, f17);
            path.quadTo(f18, f17, f18, f26 + f17);
            if (this.l == f.LEFT) {
                path.lineTo(f18, f21 - ((float) this.f76179e));
                path.lineTo(rectF2.right, f6);
                path.lineTo(f18, ((float) this.f76179e) + f21);
            }
            float f27 = f12 / 2.0f;
            path.lineTo(f18, f19 - f27);
            path.quadTo(f18, f19, f18 - f27, f19);
            if (this.l == f.TOP) {
                path.lineTo(((float) this.f76179e) + f20, f19);
                path.lineTo(centerX, rectF2.bottom);
                path.lineTo(f20 - ((float) this.f76179e), f19);
            }
            float f28 = f11 / 2.0f;
            path.lineTo(f16 + f28, f19);
            path.quadTo(f16, f19, f16, f19 - f28);
            if (this.l == f.RIGHT) {
                path.lineTo(f16, ((float) this.f76179e) + f21);
                path.lineTo(rectF2.left, f6);
                path.lineTo(f16, f21 - ((float) this.f76179e));
            }
            path.lineTo(f16, f17 + f25);
            path.quadTo(f16, f17, f24, f17);
            path.close();
            return path;
        }

        /* access modifiers changed from: private */
        public void a(Rect rect) {
            setupPosition(rect);
            int i2 = this.f76176b;
            RectF rectF = new RectF((float) i2, (float) i2, ((float) getWidth()) - (((float) this.f76176b) * 2.0f), ((float) getHeight()) - (((float) this.f76176b) * 2.0f));
            int i3 = this.t;
            this.f76183i = a(rectF, (float) i3, (float) i3, (float) i3, (float) i3);
            this.s.a(this, new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (TooltipView.this.q != null) {
                        TooltipView.this.q.a();
                    }
                }
            });
            if (this.n) {
                setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (TooltipView.this.n) {
                            TooltipView.this.a();
                        }
                    }
                });
            }
            if (this.o) {
                postDelayed(new Runnable() {
                    public final void run() {
                        TooltipView.this.a();
                    }
                }, this.p);
            }
        }

        public void setup(Rect rect, int i2) {
            this.y = new Rect(rect);
            final Rect rect2 = new Rect(rect);
            getGlobalVisibleRect(new Rect());
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            boolean z2 = true;
            if (this.l == f.LEFT && getWidth() > rect2.left) {
                layoutParams.width = (rect2.left - 30) - this.z;
            } else if (this.l == f.RIGHT && rect2.right + getWidth() > i2) {
                layoutParams.width = ((i2 - rect2.right) - 30) - this.z;
            } else if (this.l == f.TOP || this.l == f.BOTTOM) {
                int i3 = rect2.left;
                int i4 = rect2.right;
                float f2 = (float) i2;
                if (((float) rect2.centerX()) + (((float) getWidth()) / 2.0f) > f2) {
                    float centerX = (((float) rect2.centerX()) + (((float) getWidth()) / 2.0f)) - f2;
                    i3 = (int) (((float) i3) - centerX);
                    i4 = (int) (((float) i4) - centerX);
                    setAlign(a.CENTER);
                } else if (((float) rect2.centerX()) - (((float) getWidth()) / 2.0f) < 0.0f) {
                    float f3 = -(((float) rect2.centerX()) - (((float) getWidth()) / 2.0f));
                    i3 = (int) (((float) i3) + f3);
                    i4 = (int) (((float) i4) + f3);
                    setAlign(a.CENTER);
                } else {
                    z2 = false;
                }
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i4 <= i2) {
                    i2 = i4;
                }
                rect2.left = i3;
                rect2.right = i2;
            } else {
                z2 = false;
            }
            setLayoutParams(layoutParams);
            postInvalidate();
            if (!z2) {
                a(rect2);
            } else {
                getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        TooltipView.this.a(rect2);
                        TooltipView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        return false;
                    }
                });
            }
        }

        public void setWithShadow(boolean z2) {
            if (z2) {
                this.j.setShadowLayer((float) this.f76177c, 0.0f, 0.0f, this.A);
            } else {
                this.j.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }

        public void setDistanceWithView(int i2) {
            this.z = i2;
        }

        public void setBorderPaint(Paint paint) {
            this.k = paint;
            postInvalidate();
        }
    }

    /* renamed from: net.one97.paytm.o2o.movies.widget.ViewTooltip$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f76173a = new int[f.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f76174b = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        static {
            /*
                net.one97.paytm.o2o.movies.widget.ViewTooltip$a[] r0 = net.one97.paytm.o2o.movies.widget.ViewTooltip.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f76174b = r0
                r0 = 1
                int[] r1 = f76174b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.o2o.movies.widget.ViewTooltip$a r2 = net.one97.paytm.o2o.movies.widget.ViewTooltip.a.END     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f76174b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.o2o.movies.widget.ViewTooltip$a r3 = net.one97.paytm.o2o.movies.widget.ViewTooltip.a.CENTER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                net.one97.paytm.o2o.movies.widget.ViewTooltip$f[] r2 = net.one97.paytm.o2o.movies.widget.ViewTooltip.f.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f76173a = r2
                int[] r2 = f76173a     // Catch:{ NoSuchFieldError -> 0x0032 }
                net.one97.paytm.o2o.movies.widget.ViewTooltip$f r3 = net.one97.paytm.o2o.movies.widget.ViewTooltip.f.TOP     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f76173a     // Catch:{ NoSuchFieldError -> 0x003c }
                net.one97.paytm.o2o.movies.widget.ViewTooltip$f r2 = net.one97.paytm.o2o.movies.widget.ViewTooltip.f.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = f76173a     // Catch:{ NoSuchFieldError -> 0x0047 }
                net.one97.paytm.o2o.movies.widget.ViewTooltip$f r1 = net.one97.paytm.o2o.movies.widget.ViewTooltip.f.LEFT     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f76173a     // Catch:{ NoSuchFieldError -> 0x0052 }
                net.one97.paytm.o2o.movies.widget.ViewTooltip$f r1 = net.one97.paytm.o2o.movies.widget.ViewTooltip.f.RIGHT     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.widget.ViewTooltip.AnonymousClass2.<clinit>():void");
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        Fragment f76193a;

        /* renamed from: b  reason: collision with root package name */
        Activity f76194b;

        public e(Activity activity) {
            this.f76194b = activity;
        }
    }
}
