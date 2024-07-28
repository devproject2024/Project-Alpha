package kotlinx.coroutines.channels;

public final class ChannelKt {
    public static final <E> Channel<E> Channel(int i2) {
        if (i2 == -2) {
            return new ArrayChannel<>(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
        }
        if (i2 == -1) {
            return new ConflatedChannel<>();
        }
        if (i2 == 0) {
            return new RendezvousChannel<>();
        }
        if (i2 != Integer.MAX_VALUE) {
            return new ArrayChannel<>(i2);
        }
        return new LinkedListChannel<>();
    }
}
