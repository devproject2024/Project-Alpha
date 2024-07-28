package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b.g;
import androidx.core.h.u;
import androidx.transition.Transition;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4626a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> o = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {

        /* renamed from: a  reason: collision with root package name */
        private Rect f4627a = new Rect();

        public final /* synthetic */ Object get(Object obj) {
            ((Drawable) obj).copyBounds(this.f4627a);
            return new PointF((float) this.f4627a.left, (float) this.f4627a.top);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            Drawable drawable = (Drawable) obj;
            PointF pointF = (PointF) obj2;
            drawable.copyBounds(this.f4627a);
            this.f4627a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f4627a);
        }
    };
    private static final Property<a, PointF> p = new Property<a, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            a aVar = (a) obj;
            PointF pointF = (PointF) obj2;
            aVar.f4646a = Math.round(pointF.x);
            aVar.f4647b = Math.round(pointF.y);
            aVar.f4650e++;
            if (aVar.f4650e == aVar.f4651f) {
                aVar.a();
            }
        }
    };
    private static final Property<a, PointF> q = new Property<a, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            a aVar = (a) obj;
            PointF pointF = (PointF) obj2;
            aVar.f4648c = Math.round(pointF.x);
            aVar.f4649d = Math.round(pointF.y);
            aVar.f4651f++;
            if (aVar.f4650e == aVar.f4651f) {
                aVar.a();
            }
        }
    };
    private static final Property<View, PointF> r = new Property<View, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            aj.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> s = new Property<View, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            aj.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> t = new Property<View, PointF>(PointF.class, CLPConstants.ARGUMENT_KEY_POSITION) {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            aj.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static o x = new o();
    private int[] u = new int[2];
    private boolean v = false;
    private boolean w = false;

    public ChangeBounds() {
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f4828d);
        boolean a2 = g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.v = a2;
    }

    public final String[] a() {
        return f4626a;
    }

    private void d(y yVar) {
        View view = yVar.f4851b;
        if (u.J(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            yVar.f4850a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            yVar.f4850a.put("android:changeBounds:parent", yVar.f4851b.getParent());
            if (this.w) {
                yVar.f4851b.getLocationInWindow(this.u);
                yVar.f4850a.put("android:changeBounds:windowX", Integer.valueOf(this.u[0]));
                yVar.f4850a.put("android:changeBounds:windowY", Integer.valueOf(this.u[1]));
            }
            if (this.v) {
                yVar.f4850a.put("android:changeBounds:clip", u.L(view));
            }
        }
    }

    public final void a(y yVar) {
        d(yVar);
    }

    public final void b(y yVar) {
        d(yVar);
    }

    public final Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        boolean z;
        int i2;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator2;
        y c2;
        y yVar3 = yVar;
        y yVar4 = yVar2;
        if (yVar3 == null || yVar4 == null) {
            return null;
        }
        Map<String, Object> map = yVar3.f4850a;
        Map<String, Object> map2 = yVar4.f4850a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = yVar4.f4851b;
        if (!this.w || ((c2 = c(viewGroup2, true)) != null ? viewGroup3 == c2.f4851b : viewGroup2 == viewGroup3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Rect rect2 = (Rect) yVar3.f4850a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) yVar4.f4850a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            View view3 = view2;
            Rect rect4 = (Rect) yVar3.f4850a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) yVar4.f4850a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.v) {
                view = view3;
                aj.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        animator = l.a(view, t, this.n.a((float) i4, (float) i6, (float) i5, (float) i7));
                    } else {
                        final a aVar = new a(view);
                        ObjectAnimator a2 = l.a(aVar, p, this.n.a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator a3 = l.a(aVar, q, this.n.a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            private a mViewBounds = aVar;
                        });
                        animator = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    animator = l.a(view, r, this.n.a((float) i8, (float) i10, (float) i9, (float) i11));
                } else {
                    animator = l.a(view, s, this.n.a((float) i4, (float) i6, (float) i5, (float) i7));
                }
            } else {
                view = view3;
                aj.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                if (i4 == i5 && i6 == i7) {
                    objectAnimator = null;
                } else {
                    objectAnimator = l.a(view, t, this.n.a((float) i4, (float) i6, (float) i5, (float) i7));
                }
                if (rect7 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i3, i3, i14, i15) : rect6;
                if (!rect.equals(rect8)) {
                    u.a(view, rect);
                    o oVar = x;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect8;
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", oVar, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect6;
                    final int i16 = i5;
                    final int i17 = i7;
                    final int i18 = i9;
                    final int i19 = i11;
                    objectAnimator2.addListener(new AnimatorListenerAdapter() {

                        /* renamed from: h  reason: collision with root package name */
                        private boolean f4645h;

                        public final void onAnimationCancel(Animator animator) {
                            this.f4645h = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (!this.f4645h) {
                                u.a(view4, rect9);
                                aj.a(view4, i16, i17, i18, i19);
                            }
                        }
                    });
                } else {
                    objectAnimator2 = null;
                }
                animator = x.a(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ae.a(viewGroup4, true);
                a((Transition.d) new u() {

                    /* renamed from: a  reason: collision with root package name */
                    boolean f4628a = false;

                    public final void a() {
                        ae.a(viewGroup4, false);
                        this.f4628a = true;
                    }

                    public final void a(Transition transition) {
                        if (!this.f4628a) {
                            ae.a(viewGroup4, false);
                        }
                        transition.b((Transition.d) this);
                    }

                    public final void b() {
                        ae.a(viewGroup4, false);
                    }

                    public final void c() {
                        ae.a(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) yVar3.f4850a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) yVar3.f4850a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) yVar4.f4850a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) yVar4.f4850a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.u);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c3 = aj.c(view2);
        aj.a(view2, 0.0f);
        aj.a(viewGroup).a(bitmapDrawable);
        PathMotion pathMotion = this.n;
        int[] iArr = this.u;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{n.a(o, pathMotion.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f2 = c3;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                aj.a(viewGroup5).b(bitmapDrawable2);
                aj.a(view5, f2);
            }
        });
        return ofPropertyValuesHolder;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f4646a;

        /* renamed from: b  reason: collision with root package name */
        int f4647b;

        /* renamed from: c  reason: collision with root package name */
        int f4648c;

        /* renamed from: d  reason: collision with root package name */
        int f4649d;

        /* renamed from: e  reason: collision with root package name */
        int f4650e;

        /* renamed from: f  reason: collision with root package name */
        int f4651f;

        /* renamed from: g  reason: collision with root package name */
        private View f4652g;

        a(View view) {
            this.f4652g = view;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            aj.a(this.f4652g, this.f4646a, this.f4647b, this.f4648c, this.f4649d);
            this.f4650e = 0;
            this.f4651f = 0;
        }
    }
}
