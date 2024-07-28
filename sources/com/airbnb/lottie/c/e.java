package com.airbnb.lottie.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public f f5964a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f5965b;

    public e(String... strArr) {
        this.f5965b = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.f5965b = new ArrayList(eVar.f5965b);
        this.f5964a = eVar.f5964a;
    }

    public final e a(String str) {
        e eVar = new e(this);
        eVar.f5965b.add(str);
        return eVar;
    }

    public final e a(f fVar) {
        e eVar = new e(this);
        eVar.f5964a = fVar;
        return eVar;
    }

    public final boolean c(String str, int i2) {
        if (i2 >= this.f5965b.size()) {
            return false;
        }
        boolean z = i2 == this.f5965b.size() - 1;
        String str2 = this.f5965b.get(i2);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if ((z || (i2 == this.f5965b.size() - 2 && a())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.f5965b.get(i2 + 1).equals(str)) {
            if (i2 == this.f5965b.size() - 2 || (i2 == this.f5965b.size() - 3 && a())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i3 = i2 + 1;
            if (i3 < this.f5965b.size() - 1) {
                return false;
            }
            return this.f5965b.get(i3).equals(str);
        }
    }

    public final boolean d(String str, int i2) {
        if (!"__container".equals(str) && i2 >= this.f5965b.size() - 1 && !this.f5965b.get(i2).equals("**")) {
            return false;
        }
        return true;
    }

    private boolean a() {
        List<String> list = this.f5965b;
        return list.get(list.size() - 1).equals("**");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.f5965b);
        sb.append(",resolved=");
        sb.append(this.f5964a != null);
        sb.append('}');
        return sb.toString();
    }

    public final boolean a(String str, int i2) {
        if ("__container".equals(str)) {
            return true;
        }
        if (i2 >= this.f5965b.size()) {
            return false;
        }
        return this.f5965b.get(i2).equals(str) || this.f5965b.get(i2).equals("**") || this.f5965b.get(i2).equals("*");
    }

    public final int b(String str, int i2) {
        if ("__container".equals(str)) {
            return 0;
        }
        if (!this.f5965b.get(i2).equals("**")) {
            return 1;
        }
        if (i2 != this.f5965b.size() - 1 && this.f5965b.get(i2 + 1).equals(str)) {
            return 2;
        }
        return 0;
    }
}
