package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public final class c {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f2532e = {0, 4, 8};

    /* renamed from: f  reason: collision with root package name */
    private static SparseIntArray f2533f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2534a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2535b = true;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, a> f2536c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, a> f2537d = new HashMap<>();

    private static String f(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2533f = sparseIntArray;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f2533f.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f2533f.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f2533f.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f2533f.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f2533f.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f2533f.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f2533f.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f2533f.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f2533f.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        f2533f.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        f2533f.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        f2533f.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        f2533f.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        f2533f.append(R.styleable.Constraint_android_orientation, 27);
        f2533f.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f2533f.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f2533f.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f2533f.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f2533f.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        f2533f.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        f2533f.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        f2533f.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        f2533f.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        f2533f.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        f2533f.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        f2533f.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f2533f.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f2533f.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f2533f.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f2533f.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        f2533f.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        f2533f.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        f2533f.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        f2533f.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        f2533f.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        f2533f.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        f2533f.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        f2533f.append(R.styleable.Constraint_android_layout_marginRight, 28);
        f2533f.append(R.styleable.Constraint_android_layout_marginStart, 31);
        f2533f.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        f2533f.append(R.styleable.Constraint_android_layout_marginTop, 34);
        f2533f.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        f2533f.append(R.styleable.Constraint_android_layout_width, 23);
        f2533f.append(R.styleable.Constraint_android_layout_height, 21);
        f2533f.append(R.styleable.Constraint_android_visibility, 22);
        f2533f.append(R.styleable.Constraint_android_alpha, 43);
        f2533f.append(R.styleable.Constraint_android_elevation, 44);
        f2533f.append(R.styleable.Constraint_android_rotationX, 45);
        f2533f.append(R.styleable.Constraint_android_rotationY, 46);
        f2533f.append(R.styleable.Constraint_android_rotation, 60);
        f2533f.append(R.styleable.Constraint_android_scaleX, 47);
        f2533f.append(R.styleable.Constraint_android_scaleY, 48);
        f2533f.append(R.styleable.Constraint_android_transformPivotX, 49);
        f2533f.append(R.styleable.Constraint_android_transformPivotY, 50);
        f2533f.append(R.styleable.Constraint_android_translationX, 51);
        f2533f.append(R.styleable.Constraint_android_translationY, 52);
        f2533f.append(R.styleable.Constraint_android_translationZ, 53);
        f2533f.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        f2533f.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        f2533f.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        f2533f.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        f2533f.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        f2533f.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        f2533f.append(R.styleable.Constraint_layout_constraintCircle, 61);
        f2533f.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        f2533f.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        f2533f.append(R.styleable.Constraint_animate_relativeTo, 64);
        f2533f.append(R.styleable.Constraint_transitionEasing, 65);
        f2533f.append(R.styleable.Constraint_drawPath, 66);
        f2533f.append(R.styleable.Constraint_transitionPathRotate, 67);
        f2533f.append(R.styleable.Constraint_motionStagger, 79);
        f2533f.append(R.styleable.Constraint_android_id, 38);
        f2533f.append(R.styleable.Constraint_motionProgress, 68);
        f2533f.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        f2533f.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        f2533f.append(R.styleable.Constraint_chainUseRtl, 71);
        f2533f.append(R.styleable.Constraint_barrierDirection, 72);
        f2533f.append(R.styleable.Constraint_barrierMargin, 73);
        f2533f.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        f2533f.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f2533f.append(R.styleable.Constraint_pathMotionArc, 76);
        f2533f.append(R.styleable.Constraint_layout_constraintTag, 77);
        f2533f.append(R.styleable.Constraint_visibilityMode, 78);
        f2533f.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        f2533f.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    public final void a(c cVar) {
        for (Integer next : cVar.f2536c.keySet()) {
            int intValue = next.intValue();
            a aVar = cVar.f2536c.get(next);
            if (!this.f2536c.containsKey(Integer.valueOf(intValue))) {
                this.f2536c.put(Integer.valueOf(intValue), new a());
            }
            a aVar2 = this.f2536c.get(Integer.valueOf(intValue));
            if (!aVar2.f2541d.f2545b) {
                aVar2.f2541d.a(aVar.f2541d);
            }
            if (!aVar2.f2539b.f2561a) {
                aVar2.f2539b.a(aVar.f2539b);
            }
            if (!aVar2.f2542e.f2566a) {
                aVar2.f2542e.a(aVar.f2542e);
            }
            if (!aVar2.f2540c.f2554a) {
                aVar2.f2540c.a(aVar.f2540c);
            }
            for (String next2 : aVar.f2543f.keySet()) {
                if (!aVar2.f2543f.containsKey(next2)) {
                    aVar2.f2543f.put(next2, aVar.f2543f.get(next2));
                }
            }
        }
    }

    public final void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f2535b || id != -1) {
                if (!this.f2536c.containsKey(Integer.valueOf(id))) {
                    this.f2536c.put(Integer.valueOf(id), new a());
                }
                a aVar = this.f2536c.get(Integer.valueOf(id));
                if (!aVar.f2541d.f2545b) {
                    aVar.a(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.f2541d.ae = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f2541d.aj = barrier.f2477a.f2001b;
                            aVar.f2541d.ab = barrier.getType();
                            aVar.f2541d.ac = barrier.getMargin();
                        }
                    }
                    aVar.f2541d.f2545b = true;
                }
                if (!aVar.f2539b.f2561a) {
                    aVar.f2539b.f2562b = childAt.getVisibility();
                    aVar.f2539b.f2564d = childAt.getAlpha();
                    aVar.f2539b.f2561a = true;
                }
                if (Build.VERSION.SDK_INT >= 17 && !aVar.f2542e.f2566a) {
                    aVar.f2542e.f2566a = true;
                    aVar.f2542e.f2567b = childAt.getRotation();
                    aVar.f2542e.f2568c = childAt.getRotationX();
                    aVar.f2542e.f2569d = childAt.getRotationY();
                    aVar.f2542e.f2570e = childAt.getScaleX();
                    aVar.f2542e.f2571f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        aVar.f2542e.f2572g = pivotX;
                        aVar.f2542e.f2573h = pivotY;
                    }
                    aVar.f2542e.f2574i = childAt.getTranslationX();
                    aVar.f2542e.j = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar.f2542e.k = childAt.getTranslationZ();
                        if (aVar.f2542e.l) {
                            aVar.f2542e.m = childAt.getElevation();
                        }
                    }
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public static class b {
        private static SparseIntArray ak;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2544a = false;
        public float aa = 1.0f;
        public int ab = -1;
        public int ac = 0;
        public int ad = -1;
        public int[] ae;
        public String af;
        public String ag;
        public boolean ah = false;
        public boolean ai = false;
        public boolean aj = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2545b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2546c;

        /* renamed from: d  reason: collision with root package name */
        public int f2547d;

        /* renamed from: e  reason: collision with root package name */
        public int f2548e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2549f = -1;

        /* renamed from: g  reason: collision with root package name */
        public float f2550g = -1.0f;

        /* renamed from: h  reason: collision with root package name */
        public int f2551h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f2552i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = 0.0f;

        public final void a(b bVar) {
            this.f2544a = bVar.f2544a;
            this.f2546c = bVar.f2546c;
            this.f2545b = bVar.f2545b;
            this.f2547d = bVar.f2547d;
            this.f2548e = bVar.f2548e;
            this.f2549f = bVar.f2549f;
            this.f2550g = bVar.f2550g;
            this.f2551h = bVar.f2551h;
            this.f2552i = bVar.f2552i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            this.w = bVar.w;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.aa = bVar.aa;
            this.ab = bVar.ab;
            this.ac = bVar.ac;
            this.ad = bVar.ad;
            this.ag = bVar.ag;
            int[] iArr = bVar.ae;
            if (iArr != null) {
                this.ae = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.ae = null;
            }
            this.af = bVar.af;
            this.ah = bVar.ah;
            this.ai = bVar.ai;
            this.aj = bVar.aj;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            ak = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            ak.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            ak.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            ak.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            ak.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            ak.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            ak.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            ak.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            ak.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            ak.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            ak.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            ak.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            ak.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            ak.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            ak.append(R.styleable.Layout_android_orientation, 26);
            ak.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            ak.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            ak.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            ak.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            ak.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            ak.append(R.styleable.Layout_layout_goneMarginTop, 16);
            ak.append(R.styleable.Layout_layout_goneMarginRight, 14);
            ak.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            ak.append(R.styleable.Layout_layout_goneMarginStart, 15);
            ak.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            ak.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            ak.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            ak.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            ak.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            ak.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            ak.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            ak.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            ak.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            ak.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            ak.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            ak.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            ak.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            ak.append(R.styleable.Layout_android_layout_marginLeft, 23);
            ak.append(R.styleable.Layout_android_layout_marginRight, 27);
            ak.append(R.styleable.Layout_android_layout_marginStart, 30);
            ak.append(R.styleable.Layout_android_layout_marginEnd, 8);
            ak.append(R.styleable.Layout_android_layout_marginTop, 33);
            ak.append(R.styleable.Layout_android_layout_marginBottom, 2);
            ak.append(R.styleable.Layout_android_layout_width, 22);
            ak.append(R.styleable.Layout_android_layout_height, 21);
            ak.append(R.styleable.Layout_layout_constraintCircle, 61);
            ak.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            ak.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            ak.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            ak.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            ak.append(R.styleable.Layout_chainUseRtl, 71);
            ak.append(R.styleable.Layout_barrierDirection, 72);
            ak.append(R.styleable.Layout_barrierMargin, 73);
            ak.append(R.styleable.Layout_constraint_referenced_ids, 74);
            ak.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        /* access modifiers changed from: package-private */
        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.f2545b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = ak.get(index);
                if (i3 == 80) {
                    this.ah = obtainStyledAttributes.getBoolean(index, this.ah);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            this.p = c.b(obtainStyledAttributes, index, this.p);
                            break;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        case 3:
                            this.o = c.b(obtainStyledAttributes, index, this.o);
                            break;
                        case 4:
                            this.n = c.b(obtainStyledAttributes, index, this.n);
                            break;
                        case 5:
                            this.w = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            break;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            break;
                        case 8:
                            if (Build.VERSION.SDK_INT < 17) {
                                break;
                            } else {
                                this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                                break;
                            }
                        case 9:
                            this.t = c.b(obtainStyledAttributes, index, this.t);
                            break;
                        case 10:
                            this.s = c.b(obtainStyledAttributes, index, this.s);
                            break;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        case 17:
                            this.f2548e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2548e);
                            break;
                        case 18:
                            this.f2549f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2549f);
                            break;
                        case 19:
                            this.f2550g = obtainStyledAttributes.getFloat(index, this.f2550g);
                            break;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            break;
                        case 21:
                            this.f2547d = obtainStyledAttributes.getLayoutDimension(index, this.f2547d);
                            break;
                        case 22:
                            this.f2546c = obtainStyledAttributes.getLayoutDimension(index, this.f2546c);
                            break;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            break;
                        case 24:
                            this.f2551h = c.b(obtainStyledAttributes, index, this.f2551h);
                            break;
                        case 25:
                            this.f2552i = c.b(obtainStyledAttributes, index, this.f2552i);
                            break;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            break;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            break;
                        case 28:
                            this.j = c.b(obtainStyledAttributes, index, this.j);
                            break;
                        case 29:
                            this.k = c.b(obtainStyledAttributes, index, this.k);
                            break;
                        case 30:
                            if (Build.VERSION.SDK_INT < 17) {
                                break;
                            } else {
                                this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                                break;
                            }
                        case 31:
                            this.q = c.b(obtainStyledAttributes, index, this.q);
                            break;
                        case 32:
                            this.r = c.b(obtainStyledAttributes, index, this.r);
                            break;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            break;
                        case 34:
                            this.m = c.b(obtainStyledAttributes, index, this.m);
                            break;
                        case 35:
                            this.l = c.b(obtainStyledAttributes, index, this.l);
                            break;
                        case 36:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            break;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            break;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            break;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            break;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            break;
                        default:
                            switch (i3) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    break;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    break;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    break;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    break;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    break;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    break;
                                default:
                                    switch (i3) {
                                        case 61:
                                            this.x = c.b(obtainStyledAttributes, index, this.x);
                                            break;
                                        case 62:
                                            this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                                            break;
                                        case 63:
                                            this.z = obtainStyledAttributes.getFloat(index, this.z);
                                            break;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.aa = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    break;
                                                case 72:
                                                    this.ab = obtainStyledAttributes.getInt(index, this.ab);
                                                    break;
                                                case 73:
                                                    this.ac = obtainStyledAttributes.getDimensionPixelSize(index, this.ac);
                                                    break;
                                                case 74:
                                                    this.af = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.aj = obtainStyledAttributes.getBoolean(index, this.aj);
                                                    break;
                                                case 76:
                                                    StringBuilder sb = new StringBuilder("unused attribute 0x");
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(ak.get(index));
                                                    break;
                                                case 77:
                                                    this.ag = obtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                                                    sb2.append(Integer.toHexString(index));
                                                    sb2.append("   ");
                                                    sb2.append(ak.get(index));
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    this.ai = obtainStyledAttributes.getBoolean(index, this.ai);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {
        private static SparseIntArray n;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2566a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f2567b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f2568c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f2569d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f2570e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f2571f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f2572g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f2573h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f2574i = 0.0f;
        public float j = 0.0f;
        public float k = 0.0f;
        public boolean l = false;
        public float m = 0.0f;

        public final void a(e eVar) {
            this.f2566a = eVar.f2566a;
            this.f2567b = eVar.f2567b;
            this.f2568c = eVar.f2568c;
            this.f2569d = eVar.f2569d;
            this.f2570e = eVar.f2570e;
            this.f2571f = eVar.f2571f;
            this.f2572g = eVar.f2572g;
            this.f2573h = eVar.f2573h;
            this.f2574i = eVar.f2574i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            n.append(R.styleable.Transform_android_rotationX, 2);
            n.append(R.styleable.Transform_android_rotationY, 3);
            n.append(R.styleable.Transform_android_scaleX, 4);
            n.append(R.styleable.Transform_android_scaleY, 5);
            n.append(R.styleable.Transform_android_transformPivotX, 6);
            n.append(R.styleable.Transform_android_transformPivotY, 7);
            n.append(R.styleable.Transform_android_translationX, 8);
            n.append(R.styleable.Transform_android_translationY, 9);
            n.append(R.styleable.Transform_android_translationZ, 10);
            n.append(R.styleable.Transform_android_elevation, 11);
        }

        /* access modifiers changed from: package-private */
        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.f2566a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (n.get(index)) {
                    case 1:
                        this.f2567b = obtainStyledAttributes.getFloat(index, this.f2567b);
                        break;
                    case 2:
                        this.f2568c = obtainStyledAttributes.getFloat(index, this.f2568c);
                        break;
                    case 3:
                        this.f2569d = obtainStyledAttributes.getFloat(index, this.f2569d);
                        break;
                    case 4:
                        this.f2570e = obtainStyledAttributes.getFloat(index, this.f2570e);
                        break;
                    case 5:
                        this.f2571f = obtainStyledAttributes.getFloat(index, this.f2571f);
                        break;
                    case 6:
                        this.f2572g = obtainStyledAttributes.getDimension(index, this.f2572g);
                        break;
                    case 7:
                        this.f2573h = obtainStyledAttributes.getDimension(index, this.f2573h);
                        break;
                    case 8:
                        this.f2574i = obtainStyledAttributes.getDimension(index, this.f2574i);
                        break;
                    case 9:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.k = obtainStyledAttributes.getDimension(index, this.k);
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.l = true;
                            this.m = obtainStyledAttributes.getDimension(index, this.m);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2561a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2562b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f2563c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f2564d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f2565e = Float.NaN;

        public final void a(d dVar) {
            this.f2561a = dVar.f2561a;
            this.f2562b = dVar.f2562b;
            this.f2564d = dVar.f2564d;
            this.f2565e = dVar.f2565e;
            this.f2563c = dVar.f2563c;
        }

        /* access modifiers changed from: package-private */
        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.f2561a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.f2564d = obtainStyledAttributes.getFloat(index, this.f2564d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.f2562b = obtainStyledAttributes.getInt(index, this.f2562b);
                    this.f2562b = c.f2532e[this.f2562b];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.f2563c = obtainStyledAttributes.getInt(index, this.f2563c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.f2565e = obtainStyledAttributes.getFloat(index, this.f2565e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c  reason: collision with other inner class name */
    public static class C0036c {

        /* renamed from: h  reason: collision with root package name */
        private static SparseIntArray f2553h;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2554a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2555b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f2556c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f2557d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f2558e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f2559f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public float f2560g = Float.NaN;

        public final void a(C0036c cVar) {
            this.f2554a = cVar.f2554a;
            this.f2555b = cVar.f2555b;
            this.f2556c = cVar.f2556c;
            this.f2557d = cVar.f2557d;
            this.f2558e = cVar.f2558e;
            this.f2560g = cVar.f2560g;
            this.f2559f = cVar.f2559f;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2553h = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            f2553h.append(R.styleable.Motion_pathMotionArc, 2);
            f2553h.append(R.styleable.Motion_transitionEasing, 3);
            f2553h.append(R.styleable.Motion_drawPath, 4);
            f2553h.append(R.styleable.Motion_animate_relativeTo, 5);
            f2553h.append(R.styleable.Motion_motionStagger, 6);
        }

        /* access modifiers changed from: package-private */
        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.f2554a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f2553h.get(index)) {
                    case 1:
                        this.f2560g = obtainStyledAttributes.getFloat(index, this.f2560g);
                        break;
                    case 2:
                        this.f2557d = obtainStyledAttributes.getInt(index, this.f2557d);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.f2556c = androidx.constraintlayout.motion.a.c.f2208c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.f2556c = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.f2558e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f2555b = c.b(obtainStyledAttributes, index, this.f2555b);
                        break;
                    case 6:
                        this.f2559f = obtainStyledAttributes.getFloat(index, this.f2559f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2538a;

        /* renamed from: b  reason: collision with root package name */
        public final d f2539b = new d();

        /* renamed from: c  reason: collision with root package name */
        public final C0036c f2540c = new C0036c();

        /* renamed from: d  reason: collision with root package name */
        public final b f2541d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f2542e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, a> f2543f = new HashMap<>();

        /* access modifiers changed from: package-private */
        public final void a(int i2, Constraints.LayoutParams layoutParams) {
            a(i2, (ConstraintLayout.LayoutParams) layoutParams);
            this.f2539b.f2564d = layoutParams.ap;
            this.f2542e.f2567b = layoutParams.as;
            this.f2542e.f2568c = layoutParams.at;
            this.f2542e.f2569d = layoutParams.au;
            this.f2542e.f2570e = layoutParams.av;
            this.f2542e.f2571f = layoutParams.aw;
            this.f2542e.f2572g = layoutParams.ax;
            this.f2542e.f2573h = layoutParams.ay;
            this.f2542e.f2574i = layoutParams.az;
            this.f2542e.j = layoutParams.aA;
            this.f2542e.k = layoutParams.aB;
            this.f2542e.m = layoutParams.ar;
            this.f2542e.l = layoutParams.aq;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, ConstraintLayout.LayoutParams layoutParams) {
            this.f2538a = i2;
            this.f2541d.f2551h = layoutParams.f2486d;
            this.f2541d.f2552i = layoutParams.f2487e;
            this.f2541d.j = layoutParams.f2488f;
            this.f2541d.k = layoutParams.f2489g;
            this.f2541d.l = layoutParams.f2490h;
            this.f2541d.m = layoutParams.f2491i;
            this.f2541d.n = layoutParams.j;
            this.f2541d.o = layoutParams.k;
            this.f2541d.p = layoutParams.l;
            this.f2541d.q = layoutParams.p;
            this.f2541d.r = layoutParams.q;
            this.f2541d.s = layoutParams.r;
            this.f2541d.t = layoutParams.s;
            this.f2541d.u = layoutParams.z;
            this.f2541d.v = layoutParams.A;
            this.f2541d.w = layoutParams.B;
            this.f2541d.x = layoutParams.m;
            this.f2541d.y = layoutParams.n;
            this.f2541d.z = layoutParams.o;
            this.f2541d.A = layoutParams.Q;
            this.f2541d.B = layoutParams.R;
            this.f2541d.C = layoutParams.S;
            this.f2541d.f2550g = layoutParams.f2485c;
            this.f2541d.f2548e = layoutParams.f2483a;
            this.f2541d.f2549f = layoutParams.f2484b;
            this.f2541d.f2546c = layoutParams.width;
            this.f2541d.f2547d = layoutParams.height;
            this.f2541d.D = layoutParams.leftMargin;
            this.f2541d.E = layoutParams.rightMargin;
            this.f2541d.F = layoutParams.topMargin;
            this.f2541d.G = layoutParams.bottomMargin;
            this.f2541d.P = layoutParams.F;
            this.f2541d.Q = layoutParams.E;
            this.f2541d.S = layoutParams.H;
            this.f2541d.R = layoutParams.G;
            this.f2541d.ah = layoutParams.T;
            this.f2541d.ai = layoutParams.U;
            this.f2541d.T = layoutParams.I;
            this.f2541d.U = layoutParams.J;
            this.f2541d.V = layoutParams.M;
            this.f2541d.W = layoutParams.N;
            this.f2541d.X = layoutParams.K;
            this.f2541d.Y = layoutParams.L;
            this.f2541d.Z = layoutParams.O;
            this.f2541d.aa = layoutParams.P;
            this.f2541d.ag = layoutParams.V;
            this.f2541d.K = layoutParams.u;
            this.f2541d.M = layoutParams.w;
            this.f2541d.J = layoutParams.t;
            this.f2541d.L = layoutParams.v;
            this.f2541d.O = layoutParams.x;
            this.f2541d.N = layoutParams.y;
            if (Build.VERSION.SDK_INT >= 17) {
                this.f2541d.H = layoutParams.getMarginEnd();
                this.f2541d.I = layoutParams.getMarginStart();
            }
        }

        public final void a(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.f2486d = this.f2541d.f2551h;
            layoutParams.f2487e = this.f2541d.f2552i;
            layoutParams.f2488f = this.f2541d.j;
            layoutParams.f2489g = this.f2541d.k;
            layoutParams.f2490h = this.f2541d.l;
            layoutParams.f2491i = this.f2541d.m;
            layoutParams.j = this.f2541d.n;
            layoutParams.k = this.f2541d.o;
            layoutParams.l = this.f2541d.p;
            layoutParams.p = this.f2541d.q;
            layoutParams.q = this.f2541d.r;
            layoutParams.r = this.f2541d.s;
            layoutParams.s = this.f2541d.t;
            layoutParams.leftMargin = this.f2541d.D;
            layoutParams.rightMargin = this.f2541d.E;
            layoutParams.topMargin = this.f2541d.F;
            layoutParams.bottomMargin = this.f2541d.G;
            layoutParams.x = this.f2541d.O;
            layoutParams.y = this.f2541d.N;
            layoutParams.u = this.f2541d.K;
            layoutParams.w = this.f2541d.M;
            layoutParams.z = this.f2541d.u;
            layoutParams.A = this.f2541d.v;
            layoutParams.m = this.f2541d.x;
            layoutParams.n = this.f2541d.y;
            layoutParams.o = this.f2541d.z;
            layoutParams.B = this.f2541d.w;
            layoutParams.Q = this.f2541d.A;
            layoutParams.R = this.f2541d.B;
            layoutParams.F = this.f2541d.P;
            layoutParams.E = this.f2541d.Q;
            layoutParams.H = this.f2541d.S;
            layoutParams.G = this.f2541d.R;
            layoutParams.T = this.f2541d.ah;
            layoutParams.U = this.f2541d.ai;
            layoutParams.I = this.f2541d.T;
            layoutParams.J = this.f2541d.U;
            layoutParams.M = this.f2541d.V;
            layoutParams.N = this.f2541d.W;
            layoutParams.K = this.f2541d.X;
            layoutParams.L = this.f2541d.Y;
            layoutParams.O = this.f2541d.Z;
            layoutParams.P = this.f2541d.aa;
            layoutParams.S = this.f2541d.C;
            layoutParams.f2485c = this.f2541d.f2550g;
            layoutParams.f2483a = this.f2541d.f2548e;
            layoutParams.f2484b = this.f2541d.f2549f;
            layoutParams.width = this.f2541d.f2546c;
            layoutParams.height = this.f2541d.f2547d;
            if (this.f2541d.ag != null) {
                layoutParams.V = this.f2541d.ag;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.f2541d.I);
                layoutParams.setMarginEnd(this.f2541d.H);
            }
            layoutParams.a();
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = new a();
            aVar.f2541d.a(this.f2541d);
            aVar.f2540c.a(this.f2540c);
            aVar.f2539b.a(this.f2539b);
            aVar.f2542e.a(this.f2542e);
            aVar.f2538a = this.f2538a;
            return aVar;
        }
    }

    public final void a(Context context, int i2) {
        b((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public final void b(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f2536c.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f2535b || id != -1) {
                if (!this.f2536c.containsKey(Integer.valueOf(id))) {
                    this.f2536c.put(Integer.valueOf(id), new a());
                }
                a aVar = this.f2536c.get(Integer.valueOf(id));
                aVar.f2543f = a.a(this.f2537d, childAt);
                aVar.a(id, layoutParams);
                aVar.f2539b.f2562b = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    aVar.f2539b.f2564d = childAt.getAlpha();
                    aVar.f2542e.f2567b = childAt.getRotation();
                    aVar.f2542e.f2568c = childAt.getRotationX();
                    aVar.f2542e.f2569d = childAt.getRotationY();
                    aVar.f2542e.f2570e = childAt.getScaleX();
                    aVar.f2542e.f2571f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        aVar.f2542e.f2572g = pivotX;
                        aVar.f2542e.f2573h = pivotY;
                    }
                    aVar.f2542e.f2574i = childAt.getTranslationX();
                    aVar.f2542e.j = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar.f2542e.k = childAt.getTranslationZ();
                        if (aVar.f2542e.l) {
                            aVar.f2542e.m = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f2541d.aj = barrier.f2477a.f2001b;
                    aVar.f2541d.ae = barrier.getReferencedIds();
                    aVar.f2541d.ab = barrier.getType();
                    aVar.f2541d.ac = barrier.getMargin();
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final void c(ConstraintLayout constraintLayout) {
        e(constraintLayout);
        constraintLayout.setConstraintSet((c) null);
        constraintLayout.requestLayout();
    }

    public final void d(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f2536c.containsKey(Integer.valueOf(id))) {
                new StringBuilder("id unknown ").append(androidx.constraintlayout.motion.widget.a.a(childAt));
            } else if (this.f2535b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.f2536c.containsKey(Integer.valueOf(id))) {
                a.a(childAt, this.f2536c.get(Integer.valueOf(id)).f2543f);
            }
        }
    }

    public final void a(ConstraintHelper constraintHelper, androidx.constraintlayout.a.a.e eVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<androidx.constraintlayout.a.a.e> sparseArray) {
        int id = constraintHelper.getId();
        if (this.f2536c.containsKey(Integer.valueOf(id))) {
            a aVar = this.f2536c.get(Integer.valueOf(id));
            if (eVar instanceof j) {
                constraintHelper.a(aVar, (j) eVar, layoutParams, sparseArray);
            }
        }
    }

    public final void a(int i2, ConstraintLayout.LayoutParams layoutParams) {
        if (this.f2536c.containsKey(Integer.valueOf(i2))) {
            this.f2536c.get(Integer.valueOf(i2)).a(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f2536c.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f2536c.containsKey(Integer.valueOf(id))) {
                new StringBuilder("id unknown ").append(androidx.constraintlayout.motion.widget.a.a(childAt));
            } else if (this.f2535b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.f2536c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = this.f2536c.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    aVar.f2541d.ad = 1;
                }
                if (aVar.f2541d.ad != -1 && aVar.f2541d.ad == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(aVar.f2541d.ab);
                    barrier.setMargin(aVar.f2541d.ac);
                    barrier.setAllowsGoneWidget(aVar.f2541d.aj);
                    if (aVar.f2541d.ae != null) {
                        barrier.setReferencedIds(aVar.f2541d.ae);
                    } else if (aVar.f2541d.af != null) {
                        aVar.f2541d.ae = a((View) barrier, aVar.f2541d.af);
                        barrier.setReferencedIds(aVar.f2541d.ae);
                    }
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.a();
                aVar.a(layoutParams);
                a.a(childAt, aVar.f2543f);
                childAt.setLayoutParams(layoutParams);
                if (aVar.f2539b.f2563c == 0) {
                    childAt.setVisibility(aVar.f2539b.f2562b);
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.f2539b.f2564d);
                    childAt.setRotation(aVar.f2542e.f2567b);
                    childAt.setRotationX(aVar.f2542e.f2568c);
                    childAt.setRotationY(aVar.f2542e.f2569d);
                    childAt.setScaleX(aVar.f2542e.f2570e);
                    childAt.setScaleY(aVar.f2542e.f2571f);
                    if (!Float.isNaN(aVar.f2542e.f2572g)) {
                        childAt.setPivotX(aVar.f2542e.f2572g);
                    }
                    if (!Float.isNaN(aVar.f2542e.f2573h)) {
                        childAt.setPivotY(aVar.f2542e.f2573h);
                    }
                    childAt.setTranslationX(aVar.f2542e.f2574i);
                    childAt.setTranslationY(aVar.f2542e.j);
                    if (Build.VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.f2542e.k);
                        if (aVar.f2542e.l) {
                            childAt.setElevation(aVar.f2542e.m);
                        }
                    }
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            a aVar2 = this.f2536c.get(num);
            if (aVar2.f2541d.ad != -1 && aVar2.f2541d.ad == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                if (aVar2.f2541d.ae != null) {
                    barrier2.setReferencedIds(aVar2.f2541d.ae);
                } else if (aVar2.f2541d.af != null) {
                    aVar2.f2541d.ae = a((View) barrier2, aVar2.f2541d.af);
                    barrier2.setReferencedIds(aVar2.f2541d.ae);
                }
                barrier2.setType(aVar2.f2541d.ab);
                barrier2.setMargin(aVar2.f2541d.ac);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.b();
                aVar2.a(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (aVar2.f2541d.f2544a) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.a(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public final void a(int i2, int i3, int i4, int i5, int i6) {
        if (!this.f2536c.containsKey(Integer.valueOf(i2))) {
            this.f2536c.put(Integer.valueOf(i2), new a());
        }
        a aVar = this.f2536c.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    aVar.f2541d.f2551h = i4;
                    aVar.f2541d.f2552i = -1;
                } else if (i5 == 2) {
                    aVar.f2541d.f2552i = i4;
                    aVar.f2541d.f2551h = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + f(i5) + " undefined");
                }
                aVar.f2541d.D = i6;
                return;
            case 2:
                if (i5 == 1) {
                    aVar.f2541d.j = i4;
                    aVar.f2541d.k = -1;
                } else if (i5 == 2) {
                    aVar.f2541d.k = i4;
                    aVar.f2541d.j = -1;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
                aVar.f2541d.E = i6;
                return;
            case 3:
                if (i5 == 3) {
                    aVar.f2541d.l = i4;
                    aVar.f2541d.m = -1;
                    aVar.f2541d.p = -1;
                } else if (i5 == 4) {
                    aVar.f2541d.m = i4;
                    aVar.f2541d.l = -1;
                    aVar.f2541d.p = -1;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
                aVar.f2541d.F = i6;
                return;
            case 4:
                if (i5 == 4) {
                    aVar.f2541d.o = i4;
                    aVar.f2541d.n = -1;
                    aVar.f2541d.p = -1;
                } else if (i5 == 3) {
                    aVar.f2541d.n = i4;
                    aVar.f2541d.o = -1;
                    aVar.f2541d.p = -1;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
                aVar.f2541d.G = i6;
                return;
            case 5:
                if (i5 == 5) {
                    aVar.f2541d.p = i4;
                    aVar.f2541d.o = -1;
                    aVar.f2541d.n = -1;
                    aVar.f2541d.l = -1;
                    aVar.f2541d.m = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + f(i5) + " undefined");
            case 6:
                if (i5 == 6) {
                    aVar.f2541d.r = i4;
                    aVar.f2541d.q = -1;
                } else if (i5 == 7) {
                    aVar.f2541d.q = i4;
                    aVar.f2541d.r = -1;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
                aVar.f2541d.I = i6;
                return;
            case 7:
                if (i5 == 7) {
                    aVar.f2541d.t = i4;
                    aVar.f2541d.s = -1;
                } else if (i5 == 6) {
                    aVar.f2541d.s = i4;
                    aVar.f2541d.t = -1;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
                aVar.f2541d.H = i6;
                return;
            default:
                throw new IllegalArgumentException(f(i3) + " to " + f(i5) + " unknown");
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        if (!this.f2536c.containsKey(Integer.valueOf(i2))) {
            this.f2536c.put(Integer.valueOf(i2), new a());
        }
        a aVar = this.f2536c.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    aVar.f2541d.f2551h = i4;
                    aVar.f2541d.f2552i = -1;
                    return;
                } else if (i5 == 2) {
                    aVar.f2541d.f2552i = i4;
                    aVar.f2541d.f2551h = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + f(i5) + " undefined");
                }
            case 2:
                if (i5 == 1) {
                    aVar.f2541d.j = i4;
                    aVar.f2541d.k = -1;
                    return;
                } else if (i5 == 2) {
                    aVar.f2541d.k = i4;
                    aVar.f2541d.j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
            case 3:
                if (i5 == 3) {
                    aVar.f2541d.l = i4;
                    aVar.f2541d.m = -1;
                    aVar.f2541d.p = -1;
                    return;
                } else if (i5 == 4) {
                    aVar.f2541d.m = i4;
                    aVar.f2541d.l = -1;
                    aVar.f2541d.p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
            case 4:
                if (i5 == 4) {
                    aVar.f2541d.o = i4;
                    aVar.f2541d.n = -1;
                    aVar.f2541d.p = -1;
                    return;
                } else if (i5 == 3) {
                    aVar.f2541d.n = i4;
                    aVar.f2541d.o = -1;
                    aVar.f2541d.p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
            case 5:
                if (i5 == 5) {
                    aVar.f2541d.p = i4;
                    aVar.f2541d.o = -1;
                    aVar.f2541d.n = -1;
                    aVar.f2541d.l = -1;
                    aVar.f2541d.m = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + f(i5) + " undefined");
            case 6:
                if (i5 == 6) {
                    aVar.f2541d.r = i4;
                    aVar.f2541d.q = -1;
                    return;
                } else if (i5 == 7) {
                    aVar.f2541d.q = i4;
                    aVar.f2541d.r = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
            case 7:
                if (i5 == 7) {
                    aVar.f2541d.t = i4;
                    aVar.f2541d.s = -1;
                    return;
                } else if (i5 == 6) {
                    aVar.f2541d.s = i4;
                    aVar.f2541d.t = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + f(i5) + " undefined");
                }
            default:
                throw new IllegalArgumentException(f(i3) + " to " + f(i5) + " unknown");
        }
    }

    public final void a(int i2, int i3, int i4) {
        a e2 = e(i2);
        switch (i3) {
            case 1:
                e2.f2541d.D = i4;
                return;
            case 2:
                e2.f2541d.E = i4;
                return;
            case 3:
                e2.f2541d.F = i4;
                return;
            case 4:
                e2.f2541d.G = i4;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                e2.f2541d.I = i4;
                return;
            case 7:
                e2.f2541d.H = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public final void a(int i2, float f2) {
        e(i2).f2541d.v = f2;
    }

    public final void a(int i2, String str) {
        e(i2).f2541d.w = str;
    }

    public final int a(int i2) {
        return e(i2).f2539b.f2563c;
    }

    public final int b(int i2) {
        return e(i2).f2539b.f2562b;
    }

    public final int c(int i2) {
        return e(i2).f2541d.f2547d;
    }

    public final int d(int i2) {
        return e(i2).f2541d.f2546c;
    }

    public final void a(int i2, int i3) {
        e(i2).f2541d.f2547d = i3;
    }

    public final a e(int i2) {
        if (!this.f2536c.containsKey(Integer.valueOf(i2))) {
            this.f2536c.put(Integer.valueOf(i2), new a());
        }
        return this.f2536c.get(Integer.valueOf(i2));
    }

    public final void b(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a a2 = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.f2541d.f2544a = true;
                    }
                    this.f2536c.put(Integer.valueOf(a2.f2538a), a2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x016d, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x0173
            if (r0 == 0) goto L_0x016a
            java.lang.String r4 = "Constraint"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x0036
            if (r0 == r5) goto L_0x0015
            goto L_0x016d
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.String r3 = "ConstraintSet"
            boolean r3 = r3.equals(r0)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r3 == 0) goto L_0x0022
            return
        L_0x0022:
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x016d
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.c$a> r0 = r9.f2536c     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            int r3 = r2.f2538a     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r2 = r1
            goto L_0x016d
        L_0x0036:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r7 = -1
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            switch(r8) {
                case -2025855158: goto L_0x0087;
                case -1984451626: goto L_0x007d;
                case -1269513683: goto L_0x0073;
                case -1238332596: goto L_0x0069;
                case -71750448: goto L_0x005f;
                case 1331510167: goto L_0x0055;
                case 1791837707: goto L_0x004b;
                case 1803088381: goto L_0x0043;
                default: goto L_0x0042;
            }     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x0042:
            goto L_0x0091
        L_0x0043:
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 0
            goto L_0x0092
        L_0x004b:
            java.lang.String r4 = "CustomAttribute"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 7
            goto L_0x0092
        L_0x0055:
            java.lang.String r4 = "Barrier"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 2
            goto L_0x0092
        L_0x005f:
            java.lang.String r4 = "Guideline"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 1
            goto L_0x0092
        L_0x0069:
            java.lang.String r4 = "Transform"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 4
            goto L_0x0092
        L_0x0073:
            java.lang.String r4 = "PropertySet"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 3
            goto L_0x0092
        L_0x007d:
            java.lang.String r4 = "Motion"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 6
            goto L_0x0092
        L_0x0087:
            java.lang.String r4 = "Layout"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            if (r0 == 0) goto L_0x0091
            r0 = 5
            goto L_0x0092
        L_0x0091:
            r0 = -1
        L_0x0092:
            java.lang.String r4 = "XML parser error must be within a Constraint "
            switch(r0) {
                case 0: goto L_0x0160;
                case 1: goto L_0x014f;
                case 2: goto L_0x0142;
                case 3: goto L_0x0120;
                case 4: goto L_0x00fe;
                case 5: goto L_0x00db;
                case 6: goto L_0x00b8;
                case 7: goto L_0x0099;
                default: goto L_0x0097;
            }
        L_0x0097:
            goto L_0x016d
        L_0x0099:
            if (r2 == 0) goto L_0x00a2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r0 = r2.f2543f     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            androidx.constraintlayout.widget.a.a(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x016d
        L_0x00a2:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x00b8:
            if (r2 == 0) goto L_0x00c5
            androidx.constraintlayout.widget.c$c r0 = r2.f2540c     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x016d
        L_0x00c5:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x00db:
            if (r2 == 0) goto L_0x00e8
            androidx.constraintlayout.widget.c$b r0 = r2.f2541d     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x016d
        L_0x00e8:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x00fe:
            if (r2 == 0) goto L_0x010a
            androidx.constraintlayout.widget.c$e r0 = r2.f2542e     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x016d
        L_0x010a:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x0120:
            if (r2 == 0) goto L_0x012c
            androidx.constraintlayout.widget.c$d r0 = r2.f2539b     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x016d
        L_0x012c:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x0142:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            androidx.constraintlayout.widget.c$a r0 = a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            androidx.constraintlayout.widget.c$b r2 = r0.f2541d     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r2.ad = r3     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x0168
        L_0x014f:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            androidx.constraintlayout.widget.c$a r0 = a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            androidx.constraintlayout.widget.c$b r2 = r0.f2541d     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r2.f2544a = r3     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            androidx.constraintlayout.widget.c$b r2 = r0.f2541d     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            r2.f2545b = r3     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x0168
        L_0x0160:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            androidx.constraintlayout.widget.c$a r0 = a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x0168:
            r2 = r0
            goto L_0x016d
        L_0x016a:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
        L_0x016d:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x0179, IOException -> 0x0174 }
            goto L_0x0006
        L_0x0173:
            return
        L_0x0174:
            r10 = move-exception
            r10.printStackTrace()
            return
        L_0x0179:
            r10 = move-exception
            r10.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* access modifiers changed from: private */
    public static int b(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private static a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Constraint);
        a(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private static void a(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (!(index == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == index || R.styleable.Constraint_android_layout_marginEnd == index)) {
                aVar.f2540c.f2554a = true;
                aVar.f2541d.f2545b = true;
                aVar.f2539b.f2561a = true;
                aVar.f2542e.f2566a = true;
            }
            switch (f2533f.get(index)) {
                case 1:
                    aVar.f2541d.p = b(typedArray, index, aVar.f2541d.p);
                    break;
                case 2:
                    aVar.f2541d.G = typedArray.getDimensionPixelSize(index, aVar.f2541d.G);
                    break;
                case 3:
                    aVar.f2541d.o = b(typedArray, index, aVar.f2541d.o);
                    break;
                case 4:
                    aVar.f2541d.n = b(typedArray, index, aVar.f2541d.n);
                    break;
                case 5:
                    aVar.f2541d.w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.f2541d.A = typedArray.getDimensionPixelOffset(index, aVar.f2541d.A);
                    break;
                case 7:
                    aVar.f2541d.B = typedArray.getDimensionPixelOffset(index, aVar.f2541d.B);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        aVar.f2541d.H = typedArray.getDimensionPixelSize(index, aVar.f2541d.H);
                        break;
                    }
                case 9:
                    aVar.f2541d.t = b(typedArray, index, aVar.f2541d.t);
                    break;
                case 10:
                    aVar.f2541d.s = b(typedArray, index, aVar.f2541d.s);
                    break;
                case 11:
                    aVar.f2541d.M = typedArray.getDimensionPixelSize(index, aVar.f2541d.M);
                    break;
                case 12:
                    aVar.f2541d.N = typedArray.getDimensionPixelSize(index, aVar.f2541d.N);
                    break;
                case 13:
                    aVar.f2541d.J = typedArray.getDimensionPixelSize(index, aVar.f2541d.J);
                    break;
                case 14:
                    aVar.f2541d.L = typedArray.getDimensionPixelSize(index, aVar.f2541d.L);
                    break;
                case 15:
                    aVar.f2541d.O = typedArray.getDimensionPixelSize(index, aVar.f2541d.O);
                    break;
                case 16:
                    aVar.f2541d.K = typedArray.getDimensionPixelSize(index, aVar.f2541d.K);
                    break;
                case 17:
                    aVar.f2541d.f2548e = typedArray.getDimensionPixelOffset(index, aVar.f2541d.f2548e);
                    break;
                case 18:
                    aVar.f2541d.f2549f = typedArray.getDimensionPixelOffset(index, aVar.f2541d.f2549f);
                    break;
                case 19:
                    aVar.f2541d.f2550g = typedArray.getFloat(index, aVar.f2541d.f2550g);
                    break;
                case 20:
                    aVar.f2541d.u = typedArray.getFloat(index, aVar.f2541d.u);
                    break;
                case 21:
                    aVar.f2541d.f2547d = typedArray.getLayoutDimension(index, aVar.f2541d.f2547d);
                    break;
                case 22:
                    aVar.f2539b.f2562b = typedArray.getInt(index, aVar.f2539b.f2562b);
                    aVar.f2539b.f2562b = f2532e[aVar.f2539b.f2562b];
                    break;
                case 23:
                    aVar.f2541d.f2546c = typedArray.getLayoutDimension(index, aVar.f2541d.f2546c);
                    break;
                case 24:
                    aVar.f2541d.D = typedArray.getDimensionPixelSize(index, aVar.f2541d.D);
                    break;
                case 25:
                    aVar.f2541d.f2551h = b(typedArray, index, aVar.f2541d.f2551h);
                    break;
                case 26:
                    aVar.f2541d.f2552i = b(typedArray, index, aVar.f2541d.f2552i);
                    break;
                case 27:
                    aVar.f2541d.C = typedArray.getInt(index, aVar.f2541d.C);
                    break;
                case 28:
                    aVar.f2541d.E = typedArray.getDimensionPixelSize(index, aVar.f2541d.E);
                    break;
                case 29:
                    aVar.f2541d.j = b(typedArray, index, aVar.f2541d.j);
                    break;
                case 30:
                    aVar.f2541d.k = b(typedArray, index, aVar.f2541d.k);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        aVar.f2541d.I = typedArray.getDimensionPixelSize(index, aVar.f2541d.I);
                        break;
                    }
                case 32:
                    aVar.f2541d.q = b(typedArray, index, aVar.f2541d.q);
                    break;
                case 33:
                    aVar.f2541d.r = b(typedArray, index, aVar.f2541d.r);
                    break;
                case 34:
                    aVar.f2541d.F = typedArray.getDimensionPixelSize(index, aVar.f2541d.F);
                    break;
                case 35:
                    aVar.f2541d.m = b(typedArray, index, aVar.f2541d.m);
                    break;
                case 36:
                    aVar.f2541d.l = b(typedArray, index, aVar.f2541d.l);
                    break;
                case 37:
                    aVar.f2541d.v = typedArray.getFloat(index, aVar.f2541d.v);
                    break;
                case 38:
                    aVar.f2538a = typedArray.getResourceId(index, aVar.f2538a);
                    break;
                case 39:
                    aVar.f2541d.Q = typedArray.getFloat(index, aVar.f2541d.Q);
                    break;
                case 40:
                    aVar.f2541d.P = typedArray.getFloat(index, aVar.f2541d.P);
                    break;
                case 41:
                    aVar.f2541d.R = typedArray.getInt(index, aVar.f2541d.R);
                    break;
                case 42:
                    aVar.f2541d.S = typedArray.getInt(index, aVar.f2541d.S);
                    break;
                case 43:
                    aVar.f2539b.f2564d = typedArray.getFloat(index, aVar.f2539b.f2564d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        aVar.f2542e.l = true;
                        aVar.f2542e.m = typedArray.getDimension(index, aVar.f2542e.m);
                        break;
                    }
                case 45:
                    aVar.f2542e.f2568c = typedArray.getFloat(index, aVar.f2542e.f2568c);
                    break;
                case 46:
                    aVar.f2542e.f2569d = typedArray.getFloat(index, aVar.f2542e.f2569d);
                    break;
                case 47:
                    aVar.f2542e.f2570e = typedArray.getFloat(index, aVar.f2542e.f2570e);
                    break;
                case 48:
                    aVar.f2542e.f2571f = typedArray.getFloat(index, aVar.f2542e.f2571f);
                    break;
                case 49:
                    aVar.f2542e.f2572g = typedArray.getDimension(index, aVar.f2542e.f2572g);
                    break;
                case 50:
                    aVar.f2542e.f2573h = typedArray.getDimension(index, aVar.f2542e.f2573h);
                    break;
                case 51:
                    aVar.f2542e.f2574i = typedArray.getDimension(index, aVar.f2542e.f2574i);
                    break;
                case 52:
                    aVar.f2542e.j = typedArray.getDimension(index, aVar.f2542e.j);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        aVar.f2542e.k = typedArray.getDimension(index, aVar.f2542e.k);
                        break;
                    }
                case 54:
                    aVar.f2541d.T = typedArray.getInt(index, aVar.f2541d.T);
                    break;
                case 55:
                    aVar.f2541d.U = typedArray.getInt(index, aVar.f2541d.U);
                    break;
                case 56:
                    aVar.f2541d.V = typedArray.getDimensionPixelSize(index, aVar.f2541d.V);
                    break;
                case 57:
                    aVar.f2541d.W = typedArray.getDimensionPixelSize(index, aVar.f2541d.W);
                    break;
                case 58:
                    aVar.f2541d.X = typedArray.getDimensionPixelSize(index, aVar.f2541d.X);
                    break;
                case 59:
                    aVar.f2541d.Y = typedArray.getDimensionPixelSize(index, aVar.f2541d.Y);
                    break;
                case 60:
                    aVar.f2542e.f2567b = typedArray.getFloat(index, aVar.f2542e.f2567b);
                    break;
                case 61:
                    aVar.f2541d.x = b(typedArray, index, aVar.f2541d.x);
                    break;
                case 62:
                    aVar.f2541d.y = typedArray.getDimensionPixelSize(index, aVar.f2541d.y);
                    break;
                case 63:
                    aVar.f2541d.z = typedArray.getFloat(index, aVar.f2541d.z);
                    break;
                case 64:
                    aVar.f2540c.f2555b = b(typedArray, index, aVar.f2540c.f2555b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        aVar.f2540c.f2556c = androidx.constraintlayout.motion.a.c.f2208c[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        aVar.f2540c.f2556c = typedArray.getString(index);
                        break;
                    }
                case 66:
                    aVar.f2540c.f2558e = typedArray.getInt(index, 0);
                    break;
                case 67:
                    aVar.f2540c.f2560g = typedArray.getFloat(index, aVar.f2540c.f2560g);
                    break;
                case 68:
                    aVar.f2539b.f2565e = typedArray.getFloat(index, aVar.f2539b.f2565e);
                    break;
                case 69:
                    aVar.f2541d.Z = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f2541d.aa = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    aVar.f2541d.ab = typedArray.getInt(index, aVar.f2541d.ab);
                    break;
                case 73:
                    aVar.f2541d.ac = typedArray.getDimensionPixelSize(index, aVar.f2541d.ac);
                    break;
                case 74:
                    aVar.f2541d.af = typedArray.getString(index);
                    break;
                case 75:
                    aVar.f2541d.aj = typedArray.getBoolean(index, aVar.f2541d.aj);
                    break;
                case 76:
                    aVar.f2540c.f2557d = typedArray.getInt(index, aVar.f2540c.f2557d);
                    break;
                case 77:
                    aVar.f2541d.ag = typedArray.getString(index);
                    break;
                case 78:
                    aVar.f2539b.f2563c = typedArray.getInt(index, aVar.f2539b.f2563c);
                    break;
                case 79:
                    aVar.f2540c.f2559f = typedArray.getFloat(index, aVar.f2540c.f2559f);
                    break;
                case 80:
                    aVar.f2541d.ah = typedArray.getBoolean(index, aVar.f2541d.ah);
                    break;
                case 81:
                    aVar.f2541d.ai = typedArray.getBoolean(index, aVar.f2541d.ai);
                    break;
                case 82:
                    StringBuilder sb = new StringBuilder("unused attribute 0x");
                    sb.append(Integer.toHexString(index));
                    sb.append("   ");
                    sb.append(f2533f.get(index));
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(f2533f.get(index));
                    break;
            }
        }
    }

    private static int[] a(View view, String str) {
        int i2;
        Object designInformation;
        String[] split = str.split(AppConstants.COMMA);
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R.id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i2 = ((Integer) designInformation).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    public final int[] a() {
        Integer[] numArr = (Integer[]) this.f2536c.keySet().toArray(new Integer[0]);
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }
}
