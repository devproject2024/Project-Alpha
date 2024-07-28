package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.b.cc;
import com.google.android.play.core.e.p;
import java.util.List;

class n<T> extends cc {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f37229a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ s f37230b;

    n(s sVar, p<T> pVar) {
        this.f37230b = sVar;
        this.f37229a = pVar;
    }

    n(s sVar, p pVar, byte b2) {
        this(sVar, pVar);
    }

    n(s sVar, p pVar, char c2) {
        this(sVar, pVar);
    }

    n(s sVar, p pVar, short s) {
        this(sVar, pVar);
    }

    public final void a() {
        this.f37230b.f37241e.a();
        s.f37237a.d("onRequestDownloadInfo()", new Object[0]);
    }

    public final void a(int i2) {
        this.f37230b.f37241e.a();
        s.f37237a.d("onStartDownload(%d)", Integer.valueOf(i2));
    }

    public void a(Bundle bundle) {
        this.f37230b.f37241e.a();
        int i2 = bundle.getInt("error_code");
        s.f37237a.b("onError(%d)", Integer.valueOf(i2));
        this.f37229a.b((Exception) new a(i2));
    }

    public void a(Bundle bundle, Bundle bundle2) {
        this.f37230b.f37242f.a();
        s.f37237a.d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    public void a(List<Bundle> list) {
        this.f37230b.f37241e.a();
        s.f37237a.d("onGetSessionStates", new Object[0]);
    }

    public final void b() {
        this.f37230b.f37241e.a();
        s.f37237a.d("onCancelDownloads()", new Object[0]);
    }

    public final void b(int i2) {
        this.f37230b.f37241e.a();
        s.f37237a.d("onCancelDownload(%d)", Integer.valueOf(i2));
    }

    public final void b(Bundle bundle) {
        this.f37230b.f37241e.a();
        s.f37237a.d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    public void b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f37230b.f37241e.a();
        s.f37237a.d("onGetChunkFileDescriptor", new Object[0]);
    }

    public final void c() {
        this.f37230b.f37241e.a();
        s.f37237a.d("onRemoveModule()", new Object[0]);
    }

    public final void c(int i2) {
        this.f37230b.f37241e.a();
        s.f37237a.d("onGetSession(%d)", Integer.valueOf(i2));
    }

    public final void c(Bundle bundle) {
        this.f37230b.f37241e.a();
        s.f37237a.d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    public final void d(Bundle bundle) {
        this.f37230b.f37241e.a();
        s.f37237a.d("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }
}
