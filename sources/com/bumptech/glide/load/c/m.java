package com.bumptech.glide.load.c;

import com.bumptech.glide.g.g;
import com.bumptech.glide.g.k;
import java.util.Queue;

public final class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final g<a<A>, B> f7047a;

    public m() {
        this(250);
    }

    public m(long j) {
        this.f7047a = new g<a<A>, B>(j) {
            public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
                ((a) obj).a();
            }
        };
    }

    public final B a(A a2) {
        a a3 = a.a(a2);
        B b2 = this.f7047a.b(a3);
        a3.a();
        return b2;
    }

    public static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<a<?>> f7049a = k.a(0);

        /* renamed from: b  reason: collision with root package name */
        private int f7050b;

        /* renamed from: c  reason: collision with root package name */
        private int f7051c;

        /* renamed from: d  reason: collision with root package name */
        private A f7052d;

        public static <A> a<A> a(A a2) {
            a<A> poll;
            synchronized (f7049a) {
                poll = f7049a.poll();
            }
            if (poll == null) {
                poll = new a<>();
            }
            poll.f7052d = a2;
            poll.f7051c = 0;
            poll.f7050b = 0;
            return poll;
        }

        private a() {
        }

        public final void a() {
            synchronized (f7049a) {
                f7049a.offer(this);
            }
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f7051c == aVar.f7051c && this.f7050b == aVar.f7050b && this.f7052d.equals(aVar.f7052d)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return (((this.f7050b * 31) + this.f7051c) * 31) + this.f7052d.hashCode();
        }
    }
}
