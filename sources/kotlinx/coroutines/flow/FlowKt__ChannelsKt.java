package kotlinx.coroutines.flow;

import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.x;
import kotlinx.coroutines.channels.ReceiveChannel;

final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, d<? super x> dVar) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, dVar);
        return emitAllImpl$FlowKt__ChannelsKt == a.COROUTINE_SUSPENDED ? emitAllImpl$FlowKt__ChannelsKt : x.f47997a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a6, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a7, code lost:
        if (r8 != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a9, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ac, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071 A[Catch:{ all -> 0x00a6 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e A[Catch:{ all -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008c A[SYNTHETIC, Splitter:B:33:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d A[Catch:{ all -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ <T> java.lang.Object emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector<? super T> r7, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r8, boolean r9, kotlin.d.d<? super kotlin.x> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r7 = r0.L$2
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r8 = r0.Z$0
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.a((java.lang.Object) r10)     // Catch:{ all -> 0x00a4 }
            r10 = r7
            goto L_0x005f
        L_0x003a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0042:
            java.lang.Object r7 = r0.L$2
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            boolean r8 = r0.Z$0
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.a((java.lang.Object) r10)     // Catch:{ all -> 0x00a4 }
            r6 = r10
            r10 = r7
            r7 = r6
            goto L_0x0072
        L_0x0057:
            kotlin.ResultKt.a((java.lang.Object) r10)
            r10 = 0
            r2 = r7
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005f:
            r0.L$0 = r2     // Catch:{ all -> 0x00a4 }
            r0.L$1 = r9     // Catch:{ all -> 0x00a4 }
            r0.Z$0 = r8     // Catch:{ all -> 0x00a4 }
            r0.L$2 = r10     // Catch:{ all -> 0x00a4 }
            r0.L$3 = r2     // Catch:{ all -> 0x00a4 }
            r0.label = r4     // Catch:{ all -> 0x00a4 }
            java.lang.Object r7 = r9.receiveOrClosed(r0)     // Catch:{ all -> 0x00a4 }
            if (r7 != r1) goto L_0x0072
            return r1
        L_0x0072:
            kotlinx.coroutines.channels.ValueOrClosed r7 = (kotlinx.coroutines.channels.ValueOrClosed) r7     // Catch:{ all -> 0x00a4 }
            java.lang.Object r7 = r7.m548unboximpl()     // Catch:{ all -> 0x00a4 }
            boolean r5 = kotlinx.coroutines.channels.ValueOrClosed.m546isClosedimpl(r7)     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x008d
            java.lang.Throwable r7 = kotlinx.coroutines.channels.ValueOrClosed.m543getCloseCauseimpl(r7)     // Catch:{ all -> 0x00a4 }
            if (r7 != 0) goto L_0x008c
            if (r8 == 0) goto L_0x0089
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r10)
        L_0x0089:
            kotlin.x r7 = kotlin.x.f47997a
            return r7
        L_0x008c:
            throw r7     // Catch:{ all -> 0x00a4 }
        L_0x008d:
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m544getValueimpl(r7)     // Catch:{ all -> 0x00a4 }
            r0.L$0 = r2     // Catch:{ all -> 0x00a4 }
            r0.L$1 = r9     // Catch:{ all -> 0x00a4 }
            r0.Z$0 = r8     // Catch:{ all -> 0x00a4 }
            r0.L$2 = r10     // Catch:{ all -> 0x00a4 }
            r0.L$3 = r7     // Catch:{ all -> 0x00a4 }
            r0.label = r3     // Catch:{ all -> 0x00a4 }
            java.lang.Object r7 = r2.emit(r5, r0)     // Catch:{ all -> 0x00a4 }
            if (r7 != r1) goto L_0x005f
            return r1
        L_0x00a4:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r10 = move-exception
            if (r8 == 0) goto L_0x00ac
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r7)
        L_0x00ac:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.d.d):java.lang.Object");
    }
}
