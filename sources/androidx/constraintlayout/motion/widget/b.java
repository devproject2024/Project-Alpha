package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import java.util.HashMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final HashMap<Pair<Integer, Integer>, String> f2292a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    static final HashMap<String, String> f2293b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final MotionLayout f2294c;

    /* renamed from: d  reason: collision with root package name */
    private String f2295d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f2296e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f2297f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f2298g = -1;

    public b(MotionLayout motionLayout) {
        this.f2294c = motionLayout;
    }

    static {
        f2292a.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        f2292a.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        f2292a.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        f2292a.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        f2292a.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        f2292a.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        f2292a.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        f2292a.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        f2292a.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        f2292a.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        f2292a.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        f2292a.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        f2292a.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        f2293b.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        f2293b.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        f2293b.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        f2293b.put("layout_constraintTop_toTopOf", "layout_marginTop");
        f2293b.put("layout_constraintStart_toStartOf", "layout_marginStart");
        f2293b.put("layout_constraintStart_toEndOf", "layout_marginStart");
        f2293b.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        f2293b.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        f2293b.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        f2293b.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        f2293b.put("layout_constraintRight_toRightOf", "layout_marginRight");
        f2293b.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }
}
