package com.google.android.exoplayer2.source.dash.a;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final EventMessage[] f32928a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f32929b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32930c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32931d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32932e;

    public e(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        this.f32930c = str;
        this.f32931d = str2;
        this.f32932e = j;
        this.f32929b = jArr;
        this.f32928a = eventMessageArr;
    }

    public final String a() {
        return this.f32930c + "/" + this.f32931d;
    }
}
