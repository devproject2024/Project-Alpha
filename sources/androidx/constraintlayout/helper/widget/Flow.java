package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.g;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.a.a.l;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.c;

public class Flow extends VirtualLayout {

    /* renamed from: a  reason: collision with root package name */
    private g f2184a;

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void a(e eVar, boolean z) {
        g gVar = this.f2184a;
        if (gVar.be <= 0 && gVar.bf <= 0) {
            return;
        }
        if (z) {
            gVar.bg = gVar.bf;
            gVar.bh = gVar.be;
            return;
        }
        gVar.bg = gVar.be;
        gVar.bh = gVar.bf;
    }

    public void onMeasure(int i2, int i3) {
        a(this.f2184a, i2, i3);
    }

    public final void a(l lVar, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (lVar != null) {
            lVar.a(mode, size, mode2, size2);
            setMeasuredDimension(lVar.bj, lVar.bk);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final void a(c.a aVar, j jVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<e> sparseArray) {
        super.a(aVar, jVar, layoutParams, sparseArray);
        if (jVar instanceof g) {
            g gVar = (g) jVar;
            if (layoutParams.S != -1) {
                gVar.aZ = layoutParams.S;
            }
        }
    }

    public final void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f2184a = new g();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f2184a.aZ = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.f2184a.p(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        g gVar = this.f2184a;
                        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                        gVar.be = dimensionPixelSize;
                        gVar.bg = dimensionPixelSize;
                        gVar.bh = dimensionPixelSize;
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.f2184a.bf = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f2184a.q(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f2184a.bc = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f2184a.r(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f2184a.bd = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f2184a.aX = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f2184a.f2107a = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f2184a.f2108b = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f2184a.f2109c = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f2184a.aL = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f2184a.f2110d = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f2184a.aM = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f2184a.aN = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f2184a.aP = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f2184a.aR = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f2184a.aQ = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f2184a.aS = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f2184a.aO = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f2184a.aV = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f2184a.aW = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f2184a.aT = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f2184a.aU = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f2184a.aY = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.m = this.f2184a;
        b();
    }

    public void setOrientation(int i2) {
        this.f2184a.aZ = i2;
        requestLayout();
    }

    public void setPadding(int i2) {
        this.f2184a.p(i2);
        requestLayout();
    }

    public void setPaddingLeft(int i2) {
        this.f2184a.q(i2);
        requestLayout();
    }

    public void setPaddingTop(int i2) {
        this.f2184a.bc = i2;
        requestLayout();
    }

    public void setPaddingRight(int i2) {
        this.f2184a.r(i2);
        requestLayout();
    }

    public void setPaddingBottom(int i2) {
        this.f2184a.bd = i2;
        requestLayout();
    }

    public void setWrapMode(int i2) {
        this.f2184a.aX = i2;
        requestLayout();
    }

    public void setHorizontalStyle(int i2) {
        this.f2184a.f2107a = i2;
        requestLayout();
    }

    public void setVerticalStyle(int i2) {
        this.f2184a.f2108b = i2;
        requestLayout();
    }

    public void setHorizontalBias(float f2) {
        this.f2184a.aN = f2;
        requestLayout();
    }

    public void setVerticalBias(float f2) {
        this.f2184a.aO = f2;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i2) {
        this.f2184a.f2109c = i2;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i2) {
        this.f2184a.f2110d = i2;
        requestLayout();
    }

    public void setFirstHorizontalBias(float f2) {
        this.f2184a.aP = f2;
        requestLayout();
    }

    public void setFirstVerticalBias(float f2) {
        this.f2184a.aQ = f2;
        requestLayout();
    }

    public void setHorizontalAlign(int i2) {
        this.f2184a.aV = i2;
        requestLayout();
    }

    public void setVerticalAlign(int i2) {
        this.f2184a.aW = i2;
        requestLayout();
    }

    public void setHorizontalGap(int i2) {
        this.f2184a.aT = i2;
        requestLayout();
    }

    public void setVerticalGap(int i2) {
        this.f2184a.aU = i2;
        requestLayout();
    }

    public void setMaxElementsWrap(int i2) {
        this.f2184a.aY = i2;
        requestLayout();
    }
}
