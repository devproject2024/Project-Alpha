package kotlinx.coroutines.channels;

import kotlin.d.d;
import kotlin.x;

public interface SendChannel<E> {
    boolean close(Throwable th);

    Object send(E e2, d<? super x> dVar);

    public static final class DefaultImpls {
        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }
}
