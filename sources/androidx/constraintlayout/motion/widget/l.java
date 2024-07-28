package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class l extends c {
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public String f2347g = null;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public int f2348h = f2299a;
    /* access modifiers changed from: package-private */

    /* renamed from: i  reason: collision with root package name */
    public String f2349i = null;
    /* access modifiers changed from: package-private */
    public String j = null;
    /* access modifiers changed from: package-private */
    public int k = f2299a;
    /* access modifiers changed from: package-private */
    public int l = f2299a;
    View m = null;
    float n = 0.1f;
    boolean o = true;
    boolean p = true;
    boolean q = true;
    /* access modifiers changed from: package-private */
    public float r = Float.NaN;
    Method s;
    Method t;
    Method u;
    float v;
    /* access modifiers changed from: package-private */
    public boolean w = false;
    RectF x = new RectF();
    RectF y = new RectF();
    private int z = -1;

    public final void a(HashMap<String, r> hashMap) {
    }

    public final void a(HashSet<String> hashSet) {
    }

    public l() {
        this.f2303e = 5;
        this.f2304f = new HashMap();
    }

    public final void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger));
    }

    static void a(RectF rectF, View view, boolean z2) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z2) {
            view.getMatrix().mapRect(rectF);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2350a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2350a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            f2350a.append(R.styleable.KeyTrigger_onCross, 4);
            f2350a.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            f2350a.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            f2350a.append(R.styleable.KeyTrigger_motionTarget, 7);
            f2350a.append(R.styleable.KeyTrigger_triggerId, 6);
            f2350a.append(R.styleable.KeyTrigger_triggerSlack, 5);
            f2350a.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f2350a.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f2350a.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        public static void a(l lVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f2350a.get(index)) {
                    case 1:
                        String unused = lVar.f2349i = typedArray.getString(index);
                        continue;
                    case 2:
                        String unused2 = lVar.j = typedArray.getString(index);
                        continue;
                    case 4:
                        String unused3 = lVar.f2347g = typedArray.getString(index);
                        continue;
                    case 5:
                        lVar.n = typedArray.getFloat(index, lVar.n);
                        continue;
                    case 6:
                        int unused4 = lVar.k = typedArray.getResourceId(index, lVar.k);
                        continue;
                    case 7:
                        if (!MotionLayout.f2249a) {
                            if (typedArray.peekValue(index).type != 3) {
                                lVar.f2301c = typedArray.getResourceId(index, lVar.f2301c);
                                break;
                            } else {
                                lVar.f2302d = typedArray.getString(index);
                                break;
                            }
                        } else {
                            lVar.f2301c = typedArray.getResourceId(index, lVar.f2301c);
                            if (lVar.f2301c == -1) {
                                lVar.f2302d = typedArray.getString(index);
                                break;
                            } else {
                                continue;
                            }
                        }
                    case 8:
                        lVar.f2300b = typedArray.getInteger(index, lVar.f2300b);
                        float unused5 = lVar.r = (((float) lVar.f2300b) + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        int unused6 = lVar.l = typedArray.getResourceId(index, lVar.l);
                        continue;
                    case 10:
                        boolean unused7 = lVar.w = typedArray.getBoolean(index, lVar.w);
                        continue;
                    case 11:
                        int unused8 = lVar.f2348h = typedArray.getResourceId(index, lVar.f2348h);
                        break;
                }
                StringBuilder sb = new StringBuilder("unused attribute 0x");
                sb.append(Integer.toHexString(index));
                sb.append("   ");
                sb.append(f2350a.get(index));
            }
        }
    }
}
