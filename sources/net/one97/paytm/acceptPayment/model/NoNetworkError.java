package net.one97.paytm.acceptPayment.model;

import kotlin.g.b.g;

public final class NoNetworkError extends RequestStatus {
    public static final NoNetworkError INSTANCE = new NoNetworkError();

    private NoNetworkError() {
        super((g) null);
    }
}
