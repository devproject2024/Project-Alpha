package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.b.g;
import androidx.core.h.u;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final TimeInterpolator o = new DecelerateInterpolator();
    private static final TimeInterpolator p = new AccelerateInterpolator();
    private static final a s = new b() {
        public final float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final a t = new b() {
        public final float a(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (u.j(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final a u = new c() {
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    private static final a v = new b() {
        public final float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final a w = new b() {
        public final float a(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (u.j(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final a x = new c() {
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };
    private a q = x;
    private int r = 80;

    interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    static abstract class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    static abstract class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        c(80);
    }

    public Slide(byte b2) {
        c(8388613);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f4832h);
        int a2 = g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        c(a2);
    }

    private static void d(y yVar) {
        int[] iArr = new int[2];
        yVar.f4851b.getLocationOnScreen(iArr);
        yVar.f4850a.put("android:slide:screenPosition", iArr);
    }

    public final void a(y yVar) {
        super.a(yVar);
        d(yVar);
    }

    public final void b(y yVar) {
        super.b(yVar);
        d(yVar);
    }

    private void c(int i2) {
        if (i2 == 3) {
            this.q = s;
        } else if (i2 == 5) {
            this.q = v;
        } else if (i2 == 48) {
            this.q = u;
        } else if (i2 == 80) {
            this.q = x;
        } else if (i2 == 8388611) {
            this.q = t;
        } else if (i2 == 8388613) {
            this.q = w;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.r = i2;
        q qVar = new q();
        qVar.f4823a = i2;
        a((w) qVar);
    }

    public final Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) yVar2.f4850a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return aa.a(view, yVar2, iArr[0], iArr[1], this.q.a(viewGroup, view), this.q.b(viewGroup, view), translationX, translationY, o, this);
    }

    public final Animator a(ViewGroup viewGroup, View view, y yVar) {
        if (yVar == null) {
            return null;
        }
        int[] iArr = (int[]) yVar.f4850a.get("android:slide:screenPosition");
        return aa.a(view, yVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.q.a(viewGroup, view), this.q.b(viewGroup, view), p, this);
    }
}
