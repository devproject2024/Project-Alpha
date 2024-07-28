package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class e extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    ViewPager2.e f5023a;

    /* renamed from: b  reason: collision with root package name */
    int f5024b;

    /* renamed from: c  reason: collision with root package name */
    boolean f5025c;

    /* renamed from: d  reason: collision with root package name */
    boolean f5026d;

    /* renamed from: e  reason: collision with root package name */
    private final ViewPager2 f5027e;

    /* renamed from: f  reason: collision with root package name */
    private final RecyclerView f5028f = this.f5027e.f4987d;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayoutManager f5029g = ((LinearLayoutManager) this.f5028f.getLayoutManager());

    /* renamed from: h  reason: collision with root package name */
    private int f5030h;

    /* renamed from: i  reason: collision with root package name */
    private a f5031i = new a();
    private int j;
    private int k;
    private boolean l;
    private boolean m;

    e(ViewPager2 viewPager2) {
        this.f5027e = viewPager2;
        c();
    }

    private void c() {
        this.f5030h = 0;
        this.f5024b = 0;
        this.f5031i.a();
        this.j = -1;
        this.k = -1;
        this.l = false;
        this.m = false;
        this.f5026d = false;
        this.f5025c = false;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        boolean z = true;
        if (!(this.f5030h == 1 && this.f5024b == 1) && i2 == 1) {
            this.f5026d = false;
            this.f5030h = 1;
            int i3 = this.k;
            if (i3 != -1) {
                this.j = i3;
                this.k = -1;
            } else if (this.j == -1) {
                this.j = this.f5029g.findFirstVisibleItemPosition();
            }
            a(1);
        } else if (!e() || i2 != 2) {
            if (e() && i2 == 0) {
                d();
                if (!this.m) {
                    if (this.f5031i.f5032a != -1) {
                        a(this.f5031i.f5032a, 0.0f, 0);
                    }
                } else if (this.f5031i.f5034c != 0) {
                    z = false;
                } else if (this.j != this.f5031i.f5032a) {
                    b(this.f5031i.f5032a);
                }
                if (z) {
                    a(0);
                    c();
                }
            }
            if (this.f5030h == 2 && i2 == 0 && this.f5025c) {
                d();
                if (this.f5031i.f5034c == 0) {
                    if (this.k != this.f5031i.f5032a) {
                        b(this.f5031i.f5032a == -1 ? 0 : this.f5031i.f5032a);
                    }
                    a(0);
                    c();
                }
            }
        } else if (this.m) {
            a(2);
            this.l = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.f5027e.b()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.m = r4
            r3.d()
            boolean r0 = r3.l
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x0041
            r3.l = r2
            if (r6 > 0) goto L_0x0022
            if (r6 != 0) goto L_0x0020
            if (r5 >= 0) goto L_0x0016
            r5 = 1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f5027e
            boolean r6 = r6.b()
            if (r5 != r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = 0
            goto L_0x0023
        L_0x0022:
            r5 = 1
        L_0x0023:
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5034c
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5032a
            int r5 = r5 + r4
            goto L_0x0035
        L_0x0031:
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5032a
        L_0x0035:
            r3.k = r5
            int r5 = r3.j
            int r6 = r3.k
            if (r5 == r6) goto L_0x004f
            r3.b(r6)
            goto L_0x004f
        L_0x0041:
            int r5 = r3.f5030h
            if (r5 != 0) goto L_0x004f
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5032a
            if (r5 != r1) goto L_0x004c
            r5 = 0
        L_0x004c:
            r3.b(r5)
        L_0x004f:
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5032a
            if (r5 != r1) goto L_0x0057
            r5 = 0
            goto L_0x005b
        L_0x0057:
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5032a
        L_0x005b:
            androidx.viewpager2.widget.e$a r6 = r3.f5031i
            float r6 = r6.f5033b
            androidx.viewpager2.widget.e$a r0 = r3.f5031i
            int r0 = r0.f5034c
            r3.a(r5, r6, r0)
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5032a
            int r6 = r3.k
            if (r5 == r6) goto L_0x0070
            if (r6 != r1) goto L_0x0080
        L_0x0070:
            androidx.viewpager2.widget.e$a r5 = r3.f5031i
            int r5 = r5.f5034c
            if (r5 != 0) goto L_0x0080
            int r5 = r3.f5024b
            if (r5 == r4) goto L_0x0080
            r3.a(r2)
            r3.c()
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void d() {
        int i2;
        float f2;
        a aVar = this.f5031i;
        aVar.f5032a = this.f5029g.findFirstVisibleItemPosition();
        if (aVar.f5032a == -1) {
            aVar.a();
            return;
        }
        View findViewByPosition = this.f5029g.findViewByPosition(aVar.f5032a);
        if (findViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.f5029g.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f5029g.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f5029g.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f5029g.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + findViewByPosition.getWidth() + leftDecorationWidth;
        if (this.f5029g.getOrientation() == 0) {
            i2 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f5028f.getPaddingLeft();
            if (this.f5027e.b()) {
                i2 = -i2;
            }
        } else {
            i2 = (findViewByPosition.getTop() - topDecorationHeight) - this.f5028f.getPaddingTop();
            width = height;
        }
        aVar.f5034c = -i2;
        if (aVar.f5034c >= 0) {
            if (width == 0) {
                f2 = 0.0f;
            } else {
                f2 = ((float) aVar.f5034c) / ((float) width);
            }
            aVar.f5033b = f2;
        } else if (new a(this.f5029g).a()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(aVar.f5034c)}));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, boolean z) {
        this.f5030h = z ? 2 : 3;
        boolean z2 = false;
        this.f5026d = false;
        if (this.k != i2) {
            z2 = true;
        }
        this.k = i2;
        a(2);
        if (z2) {
            b(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f5024b == 0;
    }

    private boolean e() {
        int i2 = this.f5030h;
        return i2 == 1 || i2 == 4;
    }

    /* access modifiers changed from: package-private */
    public final double b() {
        d();
        return ((double) this.f5031i.f5032a) + ((double) this.f5031i.f5033b);
    }

    private void a(int i2) {
        if ((this.f5030h != 3 || this.f5024b != 0) && this.f5024b != i2) {
            this.f5024b = i2;
            ViewPager2.e eVar = this.f5023a;
            if (eVar != null) {
                eVar.b(i2);
            }
        }
    }

    private void b(int i2) {
        ViewPager2.e eVar = this.f5023a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    private void a(int i2, float f2, int i3) {
        ViewPager2.e eVar = this.f5023a;
        if (eVar != null) {
            eVar.a(i2, f2, i3);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f5032a;

        /* renamed from: b  reason: collision with root package name */
        float f5033b;

        /* renamed from: c  reason: collision with root package name */
        int f5034c;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f5032a = -1;
            this.f5033b = 0.0f;
            this.f5034c = 0;
        }
    }
}
