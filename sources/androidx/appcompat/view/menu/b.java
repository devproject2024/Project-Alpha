package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1288a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f1289b;

    /* renamed from: c  reason: collision with root package name */
    public g f1290c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f1291d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f1292e;

    /* renamed from: f  reason: collision with root package name */
    public m.a f1293f;

    /* renamed from: g  reason: collision with root package name */
    public n f1294g;

    /* renamed from: h  reason: collision with root package name */
    public int f1295h;

    /* renamed from: i  reason: collision with root package name */
    private int f1296i;
    private int j;

    public abstract void a(i iVar, n.a aVar);

    public boolean a() {
        return false;
    }

    public boolean a(i iVar) {
        return true;
    }

    public final boolean b(i iVar) {
        return false;
    }

    public final boolean c(i iVar) {
        return false;
    }

    public b(Context context, int i2, int i3) {
        this.f1288a = context;
        this.f1291d = LayoutInflater.from(context);
        this.f1296i = i2;
        this.j = i3;
    }

    public void a(Context context, g gVar) {
        this.f1289b = context;
        this.f1292e = LayoutInflater.from(this.f1289b);
        this.f1290c = gVar;
    }

    public n a(ViewGroup viewGroup) {
        if (this.f1294g == null) {
            this.f1294g = (n) this.f1291d.inflate(this.f1296i, viewGroup, false);
            this.f1294g.a(this.f1290c);
            a(true);
        }
        return this.f1294g;
    }

    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1294g;
        if (viewGroup != null) {
            g gVar = this.f1290c;
            int i2 = 0;
            if (gVar != null) {
                gVar.j();
                ArrayList<i> i3 = this.f1290c.i();
                int size = i3.size();
                int i4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    i iVar = i3.get(i5);
                    if (a(iVar)) {
                        View childAt = viewGroup.getChildAt(i4);
                        i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View a2 = a(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a2);
                            }
                            ((ViewGroup) this.f1294g).addView(a2, i4);
                        }
                        i4++;
                    }
                }
                i2 = i4;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!a(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public final void a(m.a aVar) {
        this.f1293f = aVar;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = (n.a) this.f1291d.inflate(this.j, viewGroup, false);
        }
        a(iVar, aVar);
        return (View) aVar;
    }

    public void a(g gVar, boolean z) {
        m.a aVar = this.f1293f;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(androidx.appcompat.view.menu.r r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.m$a r0 = r1.f1293f
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.g r2 = r1.f1290c
        L_0x0009:
            boolean r2 = r0.a(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.a(androidx.appcompat.view.menu.r):boolean");
    }

    public final int b() {
        return this.f1295h;
    }
}
