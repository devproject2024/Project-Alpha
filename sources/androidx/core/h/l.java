package androidx.core.h;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3109a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f3110b;

    /* renamed from: c  reason: collision with root package name */
    private ViewParent f3111c;

    /* renamed from: d  reason: collision with root package name */
    private final View f3112d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f3113e;

    public l(View view) {
        this.f3112d = view;
    }

    public final void a(boolean z) {
        if (this.f3109a) {
            u.H(this.f3112d);
        }
        this.f3109a = z;
    }

    public final boolean a(int i2) {
        return c(i2) != null;
    }

    public final boolean a(int i2, int i3) {
        if (a(i3)) {
            return true;
        }
        if (!this.f3109a) {
            return false;
        }
        View view = this.f3112d;
        for (ViewParent parent = this.f3112d.getParent(); parent != null; parent = parent.getParent()) {
            if (w.a(parent, view, this.f3112d, i2, i3)) {
                a(i3, parent);
                View view2 = this.f3112d;
                if (parent instanceof n) {
                    ((n) parent).b(view, view2, i2, i3);
                } else if (i3 == 0) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        try {
                            parent.onNestedScrollAccepted(view, view2, i2);
                        } catch (AbstractMethodError unused) {
                            StringBuilder sb = new StringBuilder("ViewParent ");
                            sb.append(parent);
                            sb.append(" does not implement interface method onNestedScrollAccepted");
                        }
                    } else if (parent instanceof m) {
                        ((m) parent).onNestedScrollAccepted(view, view2, i2);
                    }
                }
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public final void b(int i2) {
        ViewParent c2 = c(i2);
        if (c2 != null) {
            View view = this.f3112d;
            if (c2 instanceof n) {
                ((n) c2).a(view, i2);
            } else if (i2 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        c2.onStopNestedScroll(view);
                    } catch (AbstractMethodError unused) {
                        StringBuilder sb = new StringBuilder("ViewParent ");
                        sb.append(c2);
                        sb.append(" does not implement interface method onStopNestedScroll");
                    }
                } else if (c2 instanceof m) {
                    ((m) c2).onStopNestedScroll(view);
                }
            }
            a(i2, (ViewParent) null);
        }
    }

    public final boolean a(int i2, int i3, int i4, int i5, int[] iArr) {
        return b(i2, i3, i4, i5, iArr, 0, (int[]) null);
    }

    public final void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        b(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public final boolean a(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    private ViewParent c(int i2) {
        if (i2 == 0) {
            return this.f3110b;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f3111c;
    }

    private void a(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f3110b = viewParent;
        } else if (i2 == 1) {
            this.f3111c = viewParent;
        }
    }

    private int[] a() {
        if (this.f3113e == null) {
            this.f3113e = new int[2];
        }
        return this.f3113e;
    }

    public final boolean b(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent c2;
        int i7;
        int i8;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!this.f3109a || (c2 = c(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f3112d.getLocationInWindow(iArr4);
            i8 = iArr4[0];
            i7 = iArr4[1];
        } else {
            i8 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] a2 = a();
            a2[0] = 0;
            a2[1] = 0;
            iArr3 = a2;
        } else {
            iArr3 = iArr2;
        }
        w.a(c2, this.f3112d, i2, i3, i4, i5, i6, iArr3);
        if (iArr4 != null) {
            this.f3112d.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i8;
            iArr4[1] = iArr4[1] - i7;
        }
        return true;
    }

    public final boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent c2;
        int i5;
        int i6;
        if (!this.f3109a || (c2 = c(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f3112d.getLocationInWindow(iArr2);
            i6 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i6 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            iArr = a();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        w.a(c2, this.f3112d, i2, i3, iArr, i4);
        if (iArr2 != null) {
            this.f3112d.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i6;
            iArr2[1] = iArr2[1] - i5;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public final boolean a(float f2, float f3, boolean z) {
        ViewParent c2;
        if (!this.f3109a || (c2 = c(0)) == null) {
            return false;
        }
        return w.a(c2, this.f3112d, f2, f3, z);
    }

    public final boolean a(float f2, float f3) {
        ViewParent c2;
        if (!this.f3109a || (c2 = c(0)) == null) {
            return false;
        }
        return w.a(c2, this.f3112d, f2, f3);
    }
}
