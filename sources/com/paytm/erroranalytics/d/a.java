package com.paytm.erroranalytics.d;

import com.paytm.erroranalytics.b.c;
import com.paytm.erroranalytics.c.a.b;
import com.paytm.erroranalytics.e;

public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private b f42776a;

    /* renamed from: b  reason: collision with root package name */
    private com.paytm.erroranalytics.a.b f42777b;

    /* renamed from: c  reason: collision with root package name */
    private com.paytm.erroranalytics.a.a f42778c;

    public a(b bVar, com.paytm.erroranalytics.a.b bVar2, com.paytm.erroranalytics.a.a aVar) {
        this.f42776a = bVar;
        this.f42777b = bVar2;
        this.f42778c = aVar;
    }

    public final void run() {
        try {
            if (this.f42776a != null) {
                if (this.f42776a.f42744d != null) {
                    com.paytm.erroranalytics.c.b.a a2 = c.a(this.f42776a, this.f42778c.a(), this.f42777b.f42699a.e());
                    this.f42777b.f42699a.a(a2);
                    String str = e.f42808a;
                    String str2 = e.f42808a;
                    new StringBuilder("Event added to local db ").append(a2.f42766e);
                    this.f42777b.f42699a.b();
                    return;
                }
            }
            String str3 = e.f42808a;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                e2.getMessage();
            }
            String str4 = e.f42808a;
        }
    }
}
