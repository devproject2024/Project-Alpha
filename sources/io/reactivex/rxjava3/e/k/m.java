package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.a.w;
import java.io.Serializable;
import java.util.Objects;

public enum m {
    COMPLETE;

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public final String toString() {
        return "NotificationLite.Complete";
    }

    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e  reason: collision with root package name */
        final Throwable f47737e;

        b(Throwable th) {
            this.f47737e = th;
        }

        public final String toString() {
            return "NotificationLite.Error[" + this.f47737e + "]";
        }

        public final int hashCode() {
            return this.f47737e.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                return Objects.equals(this.f47737e, ((b) obj).f47737e);
            }
            return false;
        }
    }

    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final org.a.c upstream;

        c(org.a.c cVar) {
            this.upstream = cVar;
        }

        public final String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final io.reactivex.rxjava3.b.c upstream;

        a(io.reactivex.rxjava3.b.c cVar) {
            this.upstream = cVar;
        }

        public final String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static Object subscription(org.a.c cVar) {
        return new c(cVar);
    }

    public static Object disposable(io.reactivex.rxjava3.b.c cVar) {
        return new a(cVar);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f47737e;
    }

    public static org.a.c getSubscription(Object obj) {
        return ((c) obj).upstream;
    }

    public static io.reactivex.rxjava3.b.c getDisposable(Object obj) {
        return ((a) obj).upstream;
    }

    public static <T> boolean accept(Object obj, org.a.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            bVar.onError(((b) obj).f47737e);
            return true;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, w<? super T> wVar) {
        if (obj == COMPLETE) {
            wVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            wVar.onError(((b) obj).f47737e);
            return true;
        } else {
            wVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, org.a.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            bVar.onError(((b) obj).f47737e);
            return true;
        } else if (obj instanceof c) {
            bVar.onSubscribe(((c) obj).upstream);
            return false;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, w<? super T> wVar) {
        if (obj == COMPLETE) {
            wVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            wVar.onError(((b) obj).f47737e);
            return true;
        } else if (obj instanceof a) {
            wVar.onSubscribe(((a) obj).upstream);
            return false;
        } else {
            wVar.onNext(obj);
            return false;
        }
    }
}
