package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.internal.b.n;
import com.google.android.gms.tasks.Task;

public abstract class b extends d<Object> {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g<n> f8184a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    private static final a.C0125a<n, Object> f8185b = new c();

    /* renamed from: c  reason: collision with root package name */
    private static final a<Object> f8186c = new a<>("SmsRetriever.API", f8185b, f8184a);

    public b(Context context) {
        super(context, f8186c, null, d.a.f8368a);
    }

    public abstract Task<Void> a();

    public abstract Task<Void> b();

    public b(Activity activity) {
        super(activity, f8186c, null, d.a.f8368a);
    }
}
