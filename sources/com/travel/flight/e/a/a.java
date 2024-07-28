package com.travel.flight.e.a;

import android.view.View;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C0456a f24070a;

    /* renamed from: b  reason: collision with root package name */
    final int f24071b;

    /* renamed from: com.travel.flight.e.a.a$a  reason: collision with other inner class name */
    public interface C0456a {
        void a(int i2, View view);
    }

    public a(C0456a aVar, int i2) {
        this.f24070a = aVar;
        this.f24071b = i2;
    }

    public final void onClick(View view) {
        this.f24070a.a(this.f24071b, view);
    }
}
