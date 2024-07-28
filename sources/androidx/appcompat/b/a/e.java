package androidx.appcompat.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.appcompat.b.a.b;

class e extends b {

    /* renamed from: c  reason: collision with root package name */
    private a f1206c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1207d;

    public boolean isStateful() {
        return true;
    }

    e() {
        this((a) null, (Resources) null);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b2 = this.f1206c.b(iArr);
        if (b2 < 0) {
            b2 = this.f1206c.b(StateSet.WILD_CARD);
        }
        return a(b2) || onStateChange;
    }

    public Drawable mutate() {
        if (!this.f1207d && super.mutate() == this) {
            this.f1206c.a();
            this.f1207d = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public a b() {
        return new a(this.f1206c, this, (Resources) null);
    }

    static class a extends b.C0023b {
        int[][] L;

        a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[this.f1195i.length][];
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[][] iArr = this.L;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.L = iArr2;
        }

        /* access modifiers changed from: package-private */
        public final int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int i2 = this.j;
            for (int i3 = 0; i3 < i2; i3++) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    return i3;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new e(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }

        public final void b(int i2, int i3) {
            super.b(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.L, 0, iArr, 0, i2);
            this.L = iArr;
        }
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public void a(b.C0023b bVar) {
        super.a(bVar);
        if (bVar instanceof a) {
            this.f1206c = (a) bVar;
        }
    }

    e(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    e(byte b2) {
    }
}
