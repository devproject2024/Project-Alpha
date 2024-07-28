package io.reactivex.rxjava3.i;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f47781a;

    /* renamed from: b  reason: collision with root package name */
    public final long f47782b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47783c;

    public b(T t, long j, TimeUnit timeUnit) {
        this.f47781a = Objects.requireNonNull(t, "value is null");
        this.f47782b = j;
        this.f47783c = (TimeUnit) Objects.requireNonNull(timeUnit, "unit is null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (!Objects.equals(this.f47781a, bVar.f47781a) || this.f47782b != bVar.f47782b || !Objects.equals(this.f47783c, bVar.f47783c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f47782b;
        return (((this.f47781a.hashCode() * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f47783c.hashCode();
    }

    public final String toString() {
        return "Timed[time=" + this.f47782b + ", unit=" + this.f47783c + ", value=" + this.f47781a + "]";
    }
}
