package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.material.h.d;
import com.google.android.material.h.f;
import java.lang.ref.WeakReference;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f36480a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public boolean f36481b = true;

    /* renamed from: c  reason: collision with root package name */
    WeakReference<a> f36482c = new WeakReference<>((Object) null);

    /* renamed from: d  reason: collision with root package name */
    public d f36483d;

    /* renamed from: e  reason: collision with root package name */
    private final f f36484e = new f() {
        public final void a(Typeface typeface, boolean z) {
            if (!z) {
                i iVar = i.this;
                iVar.f36481b = true;
                a aVar = (a) iVar.f36482c.get();
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        public final void a(int i2) {
            i iVar = i.this;
            iVar.f36481b = true;
            a aVar = (a) iVar.f36482c.get();
            if (aVar != null) {
                aVar.a();
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private float f36485f;

    public interface a {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public i(a aVar) {
        this.f36482c = new WeakReference<>(aVar);
    }

    public final float a(String str) {
        if (!this.f36481b) {
            return this.f36485f;
        }
        this.f36485f = a((CharSequence) str);
        this.f36481b = false;
        return this.f36485f;
    }

    private float a(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f36480a.measureText(charSequence, 0, charSequence.length());
    }

    public final void a(d dVar, Context context) {
        if (this.f36483d != dVar) {
            this.f36483d = dVar;
            if (dVar != null) {
                dVar.b(context, this.f36480a, this.f36484e);
                a aVar = (a) this.f36482c.get();
                if (aVar != null) {
                    this.f36480a.drawableState = aVar.getState();
                }
                dVar.a(context, this.f36480a, this.f36484e);
                this.f36481b = true;
            }
            a aVar2 = (a) this.f36482c.get();
            if (aVar2 != null) {
                aVar2.a();
                aVar2.onStateChange(aVar2.getState());
            }
        }
    }

    public final void a(Context context) {
        this.f36483d.a(context, this.f36480a, this.f36484e);
    }
}
