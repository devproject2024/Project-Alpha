package androidx.work;

import androidx.lifecycle.LiveData;

public interface o {

    /* renamed from: a  reason: collision with root package name */
    public static final a.c f5507a = new a.c((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public static final a.b f5508b = new a.b((byte) 0);

    LiveData<a> a();

    public static abstract class a {
        a() {
        }

        public static final class c extends a {
            public final String toString() {
                return "SUCCESS";
            }

            /* synthetic */ c(byte b2) {
                this();
            }

            private c() {
            }
        }

        public static final class b extends a {
            public final String toString() {
                return "IN_PROGRESS";
            }

            /* synthetic */ b(byte b2) {
                this();
            }

            private b() {
            }
        }

        /* renamed from: androidx.work.o$a$a  reason: collision with other inner class name */
        public static final class C0079a extends a {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f5509a;

            public C0079a(Throwable th) {
                this.f5509a = th;
            }

            public final String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.f5509a.getMessage()});
            }
        }
    }
}
