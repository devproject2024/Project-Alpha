package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.a.c;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class i extends j {

    /* renamed from: g  reason: collision with root package name */
    String f2339g = null;

    /* renamed from: h  reason: collision with root package name */
    int f2340h = f2299a;

    /* renamed from: i  reason: collision with root package name */
    int f2341i = 0;
    float j = Float.NaN;
    float k = Float.NaN;
    float l = Float.NaN;
    float m = Float.NaN;
    float n = Float.NaN;
    float o = Float.NaN;
    int p = 0;
    private float r = Float.NaN;
    private float s = Float.NaN;

    public final void a(HashMap<String, r> hashMap) {
    }

    public i() {
        this.f2303e = 2;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2342a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2342a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f2342a.append(R.styleable.KeyPosition_framePosition, 2);
            f2342a.append(R.styleable.KeyPosition_transitionEasing, 3);
            f2342a.append(R.styleable.KeyPosition_curveFit, 4);
            f2342a.append(R.styleable.KeyPosition_drawPath, 5);
            f2342a.append(R.styleable.KeyPosition_percentX, 6);
            f2342a.append(R.styleable.KeyPosition_percentY, 7);
            f2342a.append(R.styleable.KeyPosition_keyPositionType, 9);
            f2342a.append(R.styleable.KeyPosition_sizePercent, 8);
            f2342a.append(R.styleable.KeyPosition_percentWidth, 11);
            f2342a.append(R.styleable.KeyPosition_percentHeight, 12);
            f2342a.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        static /* synthetic */ void a(i iVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f2342a.get(index)) {
                    case 1:
                        if (!MotionLayout.f2249a) {
                            if (typedArray.peekValue(index).type != 3) {
                                iVar.f2301c = typedArray.getResourceId(index, iVar.f2301c);
                                break;
                            } else {
                                iVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        } else {
                            iVar.f2301c = typedArray.getResourceId(index, iVar.f2301c);
                            if (iVar.f2301c != -1) {
                                break;
                            } else {
                                iVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        iVar.f2300b = typedArray.getInt(index, iVar.f2300b);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            iVar.f2339g = c.f2208c[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            iVar.f2339g = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        iVar.q = typedArray.getInteger(index, iVar.q);
                        break;
                    case 5:
                        iVar.f2341i = typedArray.getInt(index, iVar.f2341i);
                        break;
                    case 6:
                        iVar.l = typedArray.getFloat(index, iVar.l);
                        break;
                    case 7:
                        iVar.m = typedArray.getFloat(index, iVar.m);
                        break;
                    case 8:
                        float f2 = typedArray.getFloat(index, iVar.k);
                        iVar.j = f2;
                        iVar.k = f2;
                        break;
                    case 9:
                        iVar.p = typedArray.getInt(index, iVar.p);
                        break;
                    case 10:
                        iVar.f2340h = typedArray.getInt(index, iVar.f2340h);
                        break;
                    case 11:
                        iVar.j = typedArray.getFloat(index, iVar.j);
                        break;
                    case 12:
                        iVar.k = typedArray.getFloat(index, iVar.k);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(f2342a.get(index));
                        break;
                }
            }
        }
    }
}
