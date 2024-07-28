package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public UUID f5510a;

    /* renamed from: b  reason: collision with root package name */
    public a f5511b;

    /* renamed from: c  reason: collision with root package name */
    private e f5512c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f5513d;

    /* renamed from: e  reason: collision with root package name */
    private e f5514e;

    /* renamed from: f  reason: collision with root package name */
    private int f5515f;

    public u(UUID uuid, a aVar, e eVar, List<String> list, e eVar2, int i2) {
        this.f5510a = uuid;
        this.f5511b = aVar;
        this.f5512c = eVar;
        this.f5513d = new HashSet(list);
        this.f5514e = eVar2;
        this.f5515f = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f5515f == uVar.f5515f && this.f5510a.equals(uVar.f5510a) && this.f5511b == uVar.f5511b && this.f5512c.equals(uVar.f5512c) && this.f5513d.equals(uVar.f5513d)) {
            return this.f5514e.equals(uVar.f5514e);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f5510a.hashCode() * 31) + this.f5511b.hashCode()) * 31) + this.f5512c.hashCode()) * 31) + this.f5513d.hashCode()) * 31) + this.f5514e.hashCode()) * 31) + this.f5515f;
    }

    public final String toString() {
        return "WorkInfo{mId='" + this.f5510a + '\'' + ", mState=" + this.f5511b + ", mOutputData=" + this.f5512c + ", mTags=" + this.f5513d + ", mProgress=" + this.f5514e + '}';
    }

    public enum a {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public final boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }
}
