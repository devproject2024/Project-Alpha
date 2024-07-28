package com.jackpocket.scratchoff.a;

public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Thread f40775a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40776b = false;

    /* access modifiers changed from: protected */
    public abstract void a() throws Exception;

    public void b() {
        d();
        this.f40776b = true;
        this.f40775a = new Thread(this);
        this.f40775a.start();
    }

    public void run() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f40776b = false;
        this.f40775a = null;
    }

    public void c() {
        this.f40776b = false;
        d();
    }

    private void d() {
        try {
            if (this.f40775a != null) {
                this.f40775a.stop();
            }
        } catch (Exception unused) {
        }
        this.f40775a = null;
    }
}
