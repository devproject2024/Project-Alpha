package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.i;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {

    /* renamed from: a  reason: collision with root package name */
    private View[] f2480a = null;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, String> f2481b = new HashMap<>();
    protected int[] j = new int[32];
    protected int k;
    protected Context l;
    protected i m;
    protected boolean n = false;
    protected String o;
    protected String p;

    public void a() {
    }

    public void a(e eVar, boolean z) {
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void onDraw(Canvas canvas) {
    }

    public ConstraintHelper(Context context) {
        super(context);
        this.l = context;
        a((AttributeSet) null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = context;
        a(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = context;
        a(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.o = obtainStyledAttributes.getString(index);
                    setIds(this.o);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    this.p = obtainStyledAttributes.getString(index);
                    setReferenceTags(this.p);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.o;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.p;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.j, this.k);
    }

    public void setReferencedIds(int[] iArr) {
        this.o = null;
        this.k = 0;
        for (int a2 : iArr) {
            a(a2);
        }
    }

    private void a(int i2) {
        if (i2 != getId()) {
            int i3 = this.k + 1;
            int[] iArr = this.j;
            if (i3 > iArr.length) {
                this.j = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.j;
            int i4 = this.k;
            iArr2[i4] = i2;
            this.k = i4 + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.n) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public final void b() {
        if (this.m != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).an = (e) this.m;
            }
        }
    }

    private void a(String str) {
        if (str != null && str.length() != 0 && this.l != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                getParent();
            }
            int c2 = c(trim);
            if (c2 != 0) {
                this.f2481b.put(Integer.valueOf(c2), trim);
                a(c2);
                return;
            }
            StringBuilder sb = new StringBuilder("Could not find id of \"");
            sb.append(trim);
            sb.append("\"");
        }
    }

    private void b(String str) {
        if (str != null && str.length() != 0 && this.l != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout != null) {
                int childCount = constraintLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = constraintLayout.getChildAt(i2);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).V)) {
                        if (childAt.getId() == -1) {
                            StringBuilder sb = new StringBuilder("to use ConstraintTag view ");
                            sb.append(childAt.getClass().getSimpleName());
                            sb.append(" must have an ID");
                        } else {
                            a(childAt.getId());
                        }
                    }
                }
            }
        }
    }

    private int c(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i2 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i2 = ((Integer) designInformation).intValue();
            }
        }
        if (i2 == 0 && constraintLayout != null) {
            i2 = a(constraintLayout, str);
        }
        if (i2 == 0) {
            try {
                i2 = R.id.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? this.l.getResources().getIdentifier(str, "id", this.l.getPackageName()) : i2;
    }

    private int a(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.l.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.o = str;
        if (str != null) {
            int i2 = 0;
            this.k = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    a(str.substring(i2));
                    return;
                } else {
                    a(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setReferenceTags(String str) {
        this.p = str;
        if (str != null) {
            int i2 = 0;
            this.k = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    b(str.substring(i2));
                    return;
                } else {
                    b(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.k; i2++) {
                View viewById = constraintLayout.getViewById(this.j[i2]);
                if (viewById != null) {
                    viewById.setVisibility(visibility);
                    if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.f2481b.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.o
            r5.setIds(r0)
        L_0x000b:
            androidx.constraintlayout.a.a.i r0 = r5.m
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.g()
            r0 = 0
        L_0x0014:
            int r1 = r5.k
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.j
            r1 = r1[r0]
            android.view.View r2 = r6.getViewById(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.f2481b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.a((androidx.constraintlayout.widget.ConstraintLayout) r6, (java.lang.String) r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.j
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.f2481b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.getViewById(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            androidx.constraintlayout.a.a.i r1 = r5.m
            androidx.constraintlayout.a.a.e r2 = r6.getViewWidget(r2)
            r1.a(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            androidx.constraintlayout.a.a.i r6 = r5.m
            r6.b_()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.b(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public final void a(i iVar, SparseArray<e> sparseArray) {
        iVar.g();
        for (int i2 = 0; i2 < this.k; i2++) {
            iVar.a(sparseArray.get(this.j[i2]));
        }
    }

    /* access modifiers changed from: protected */
    public final View[] c(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f2480a;
        if (viewArr == null || viewArr.length != this.k) {
            this.f2480a = new View[this.k];
        }
        for (int i2 = 0; i2 < this.k; i2++) {
            this.f2480a[i2] = constraintLayout.getViewById(this.j[i2]);
        }
        return this.f2480a;
    }

    public void a(c.a aVar, j jVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<e> sparseArray) {
        if (aVar.f2541d.ae != null) {
            setReferencedIds(aVar.f2541d.ae);
        } else if (aVar.f2541d.af != null && aVar.f2541d.af.length() > 0) {
            c.b bVar = aVar.f2541d;
            String[] split = aVar.f2541d.af.split(AppConstants.COMMA);
            getContext();
            int[] iArr = new int[split.length];
            int i2 = 0;
            for (String trim : split) {
                int c2 = c(trim.trim());
                if (c2 != 0) {
                    iArr[i2] = c2;
                    i2++;
                }
            }
            if (i2 != split.length) {
                iArr = Arrays.copyOf(iArr, i2);
            }
            bVar.ae = iArr;
        }
        jVar.g();
        if (aVar.f2541d.ae != null) {
            for (int i3 : aVar.f2541d.ae) {
                e eVar = sparseArray.get(i3);
                if (eVar != null) {
                    jVar.a(eVar);
                }
            }
        }
    }

    public void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.o == null) {
            a(i2);
        }
    }
}
