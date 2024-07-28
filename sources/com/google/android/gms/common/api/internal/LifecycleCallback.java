package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    protected final j f8394a;

    private static j getChimeraLifecycleFragmentImpl(i iVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void b() {
    }

    public void b(Bundle bundle) {
    }

    public void c() {
    }

    public void d() {
    }

    public static j a(Activity activity) {
        return a(new i(activity));
    }

    protected LifecycleCallback(j jVar) {
        this.f8394a = jVar;
    }

    public final Activity a() {
        return this.f8394a.a();
    }

    protected static j a(i iVar) {
        if (iVar.f8616a instanceof FragmentActivity) {
            return dc.a((FragmentActivity) iVar.f8616a);
        }
        if (iVar.f8616a instanceof Activity) {
            return db.a((Activity) iVar.f8616a);
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
