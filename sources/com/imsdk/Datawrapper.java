package com.imsdk;

import kotlin.g.b.g;
import kotlin.g.b.k;

public abstract class Datawrapper<Type> {

    public static final class Success<Type> extends Datawrapper<Type> {
        private final Type data;

        public static /* synthetic */ Success copy$default(Success success, Type type, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                type = success.data;
            }
            return success.copy(type);
        }

        public final Type component1() {
            return this.data;
        }

        public final Success<Type> copy(Type type) {
            return new Success<>(type);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Success) && k.a((Object) this.data, (Object) ((Success) obj).data);
            }
            return true;
        }

        public final int hashCode() {
            Type type = this.data;
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Success(data=" + this.data + ")";
        }

        public Success(Type type) {
            super((g) null);
            this.data = type;
        }

        public final Type getData() {
            return this.data;
        }
    }

    private Datawrapper() {
    }

    public /* synthetic */ Datawrapper(g gVar) {
        this();
    }

    public static final class Failure<Type> extends Datawrapper<Type> {
        private final Throwable failure;

        public Failure() {
            this((Throwable) null, 1, (g) null);
        }

        public static /* synthetic */ Failure copy$default(Failure failure2, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                th = failure2.failure;
            }
            return failure2.copy(th);
        }

        public final Throwable component1() {
            return this.failure;
        }

        public final Failure<Type> copy(Throwable th) {
            return new Failure<>(th);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Failure) && k.a((Object) this.failure, (Object) ((Failure) obj).failure);
            }
            return true;
        }

        public final int hashCode() {
            Throwable th = this.failure;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Failure(failure=" + this.failure + ")";
        }

        public Failure(Throwable th) {
            super((g) null);
            this.failure = th;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Failure(Throwable th, int i2, g gVar) {
            this((i2 & 1) != 0 ? null : th);
        }

        public final Throwable getFailure() {
            return this.failure;
        }
    }
}
