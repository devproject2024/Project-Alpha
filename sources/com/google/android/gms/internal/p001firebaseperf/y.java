package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.y  reason: invalid package */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final hq<String, String> f9733a = new ht().a("trace_sampling_rate", "sampling").a("network_sampling_rate", "sampling").a();

    /* renamed from: b  reason: collision with root package name */
    private static final hq<String, String> f9734b = new ht().a("sessions_sampling_percentage", "fpr_vc_session_sampling_rate").a("trace_sampling_rate", "fpr_vc_trace_sampling_rate").a("network_sampling_rate", "fpr_vc_network_request_sampling_rate").a();

    public static String a(String str) {
        return f9733a.getOrDefault(str, str);
    }

    public static String b(String str) {
        return f9734b.getOrDefault(str, str);
    }
}
