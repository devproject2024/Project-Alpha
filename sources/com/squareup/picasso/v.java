package com.squareup.picasso;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class v implements j {

    /* renamed from: a  reason: collision with root package name */
    final Call.Factory f45441a;

    /* renamed from: b  reason: collision with root package name */
    private final Cache f45442b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45443c;

    public v(Context context) {
        this(ai.a(context));
    }

    private v(File file) {
        this(file, ai.a(file));
    }

    public v(Context context, long j) {
        this(ai.a(context), j);
    }

    private v(File file, long j) {
        this(new OkHttpClient.Builder().cache(new Cache(file, j)).build());
        this.f45443c = false;
    }

    private v(OkHttpClient okHttpClient) {
        this.f45443c = true;
        this.f45441a = okHttpClient;
        this.f45442b = okHttpClient.cache();
    }

    public final Response a(Request request) throws IOException {
        return FirebasePerfOkHttpClient.execute(this.f45441a.newCall(request));
    }
}
