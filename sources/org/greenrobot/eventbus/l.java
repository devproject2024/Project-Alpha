package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    final Method f72890a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f72891b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f72892c;

    /* renamed from: d  reason: collision with root package name */
    final int f72893d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f72894e;

    /* renamed from: f  reason: collision with root package name */
    String f72895f;

    public l(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.f72890a = method;
        this.f72891b = threadMode;
        this.f72892c = cls;
        this.f72893d = i2;
        this.f72894e = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f72895f.equals(lVar.f72895f);
    }

    private synchronized void a() {
        if (this.f72895f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f72890a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f72890a.getName());
            sb.append('(');
            sb.append(this.f72892c.getName());
            this.f72895f = sb.toString();
        }
    }

    public final int hashCode() {
        return this.f72890a.hashCode();
    }
}
