package com.paytm.erroranalytics.data.b;

import android.content.Context;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f42793a;

    /* renamed from: b  reason: collision with root package name */
    protected String f42794b = null;

    /* renamed from: c  reason: collision with root package name */
    protected String f42795c;

    /* renamed from: d  reason: collision with root package name */
    protected String f42796d;

    public b(Context context) {
        if (context != null) {
            this.f42793a = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
    }
}
