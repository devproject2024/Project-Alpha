package com.zhihu.matisse.internal.b;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.loader.a.a;
import androidx.loader.b.c;
import java.lang.ref.WeakReference;

public final class a implements a.C0056a<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f45725a;

    /* renamed from: b  reason: collision with root package name */
    public androidx.loader.a.a f45726b;

    /* renamed from: c  reason: collision with root package name */
    public C0763a f45727c;

    /* renamed from: d  reason: collision with root package name */
    public int f45728d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45729e;

    /* renamed from: com.zhihu.matisse.internal.b.a$a  reason: collision with other inner class name */
    public interface C0763a {
        void a();

        void a(Cursor cursor);
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        Cursor cursor = (Cursor) obj;
        if (((Context) this.f45725a.get()) != null && !this.f45729e) {
            this.f45729e = true;
            this.f45727c.a(cursor);
        }
    }

    public final c<Cursor> a(Bundle bundle) {
        Context context = (Context) this.f45725a.get();
        if (context == null) {
            return null;
        }
        this.f45729e = false;
        return com.zhihu.matisse.internal.a.a.a(context);
    }

    public final void a(c<Cursor> cVar) {
        if (((Context) this.f45725a.get()) != null) {
            this.f45727c.a();
        }
    }

    public final void a() {
        this.f45726b.a(1, (Bundle) null, this);
    }
}
