package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.Symbol;

public final class AbstractChannelKt {
    public static final Object ENQUEUE_FAILED = new Symbol("ENQUEUE_FAILED");
    public static final Object HANDLER_INVOKED = new Symbol("ON_CLOSE_HANDLER_INVOKED");
    public static final Object OFFER_FAILED = new Symbol("OFFER_FAILED");
    public static final Object OFFER_SUCCESS = new Symbol("OFFER_SUCCESS");
    public static final Object POLL_FAILED = new Symbol("POLL_FAILED");
}
