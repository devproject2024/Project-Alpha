package kotlinx.coroutines.channels;

final /* synthetic */ class ChannelsKt__Channels_commonKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.util.concurrent.CancellationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.util.concurrent.CancellationException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void cancelConsumed(kotlinx.coroutines.channels.ReceiveChannel<?> r2, java.lang.Throwable r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0014
            boolean r1 = r3 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L_0x0008
            goto L_0x0009
        L_0x0008:
            r0 = r3
        L_0x0009:
            java.util.concurrent.CancellationException r0 = (java.util.concurrent.CancellationException) r0
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = "Channel was consumed, consumer had failed"
            java.util.concurrent.CancellationException r3 = kotlinx.coroutines.ExceptionsKt.CancellationException(r0, r3)
            r0 = r3
        L_0x0014:
            r2.cancel(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.cancelConsumed(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void");
    }
}
