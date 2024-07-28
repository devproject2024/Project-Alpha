package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.a.a.a;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;

public class Barrier extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    a f2477a;

    /* renamed from: b  reason: collision with root package name */
    private int f2478b;

    /* renamed from: c  reason: collision with root package name */
    private int f2479c;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f2478b;
    }

    public void setType(int i2) {
        this.f2478b = i2;
    }

    private void a(e eVar, int i2, boolean z) {
        this.f2479c = i2;
        if (Build.VERSION.SDK_INT < 17) {
            int i3 = this.f2478b;
            if (i3 == 5) {
                this.f2479c = 0;
            } else if (i3 == 6) {
                this.f2479c = 1;
            }
        } else if (z) {
            int i4 = this.f2478b;
            if (i4 == 5) {
                this.f2479c = 1;
            } else if (i4 == 6) {
                this.f2479c = 0;
            }
        } else {
            int i5 = this.f2478b;
            if (i5 == 5) {
                this.f2479c = 0;
            } else if (i5 == 6) {
                this.f2479c = 1;
            }
        }
        if (eVar instanceof a) {
            ((a) eVar).f2000a = this.f2479c;
        }
    }

    public final void a(e eVar, boolean z) {
        a(eVar, this.f2478b, z);
    }

    /* access modifiers changed from: protected */
    public final void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f2477a = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2477a.f2001b = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f2477a.f2002c = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.m = this.f2477a;
        b();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2477a.f2001b = z;
    }

    public void setDpMargin(int i2) {
        this.f2477a.f2002c = (int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getMargin() {
        return this.f2477a.f2002c;
    }

    public void setMargin(int i2) {
        this.f2477a.f2002c = i2;
    }

    public final void a(c.a aVar, j jVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<e> sparseArray) {
        super.a(aVar, jVar, layoutParams, sparseArray);
        if (jVar instanceof a) {
            a aVar2 = (a) jVar;
            a(aVar2, aVar.f2541d.ab, ((f) jVar.V).f2106d);
            aVar2.f2001b = aVar.f2541d.aj;
            aVar2.f2002c = aVar.f2541d.ac;
        }
    }
}
