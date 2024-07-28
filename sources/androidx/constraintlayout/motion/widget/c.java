package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.a;
import java.util.HashMap;
import java.util.HashSet;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f2299a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f2300b;

    /* renamed from: c  reason: collision with root package name */
    int f2301c;

    /* renamed from: d  reason: collision with root package name */
    String f2302d = null;

    /* renamed from: e  reason: collision with root package name */
    protected int f2303e;

    /* renamed from: f  reason: collision with root package name */
    HashMap<String, a> f2304f;

    /* access modifiers changed from: package-private */
    public abstract void a(Context context, AttributeSet attributeSet);

    public abstract void a(HashMap<String, r> hashMap);

    /* access modifiers changed from: package-private */
    public abstract void a(HashSet<String> hashSet);

    public void b(HashMap<String, Integer> hashMap) {
    }

    public c() {
        int i2 = f2299a;
        this.f2300b = i2;
        this.f2301c = i2;
    }
}
