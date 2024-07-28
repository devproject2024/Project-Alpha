package com.arthurivanets.arvi.b.a;

import com.arthurivanets.arvi.model.PlaybackInfo;

public final class e implements a<String, PlaybackInfo> {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f30996a;

    /* renamed from: b  reason: collision with root package name */
    private final a<String, PlaybackInfo> f30997b = b.IN_MEMORY.create(true);

    public static e a() {
        if (f30996a == null) {
            synchronized (e.class) {
                if (f30996a == null) {
                    f30996a = new e();
                }
            }
        }
        return f30996a;
    }

    private e() {
    }

    public final PlaybackInfo a(String str, PlaybackInfo playbackInfo) {
        return this.f30997b.a(str, playbackInfo);
    }

    public final PlaybackInfo b(String str, PlaybackInfo playbackInfo) {
        return this.f30997b.b(str, playbackInfo);
    }

    public final PlaybackInfo a(String str) {
        return this.f30997b.a(str);
    }
}
