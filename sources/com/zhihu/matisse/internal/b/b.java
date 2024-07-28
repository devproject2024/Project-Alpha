package com.zhihu.matisse.internal.b;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.loader.a.a;
import androidx.loader.b.c;
import com.zhihu.matisse.internal.entity.Album;
import java.lang.ref.WeakReference;

public final class b implements a.C0056a<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f45730a;

    /* renamed from: b  reason: collision with root package name */
    public androidx.loader.a.a f45731b;

    /* renamed from: c  reason: collision with root package name */
    public a f45732c;

    public interface a {
        void a();

        void a(Cursor cursor);
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        Cursor cursor = (Cursor) obj;
        if (((Context) this.f45730a.get()) != null) {
            this.f45732c.a(cursor);
        }
    }

    public final c<Cursor> a(Bundle bundle) {
        Album album;
        Context context = (Context) this.f45730a.get();
        if (context == null || (album = (Album) bundle.getParcelable("args_album")) == null) {
            return null;
        }
        boolean z = false;
        if (album.b() && bundle.getBoolean("args_enable_capture", false)) {
            z = true;
        }
        return com.zhihu.matisse.internal.a.b.a(context, album, z);
    }

    public final void a(c<Cursor> cVar) {
        if (((Context) this.f45730a.get()) != null) {
            this.f45732c.a();
        }
    }
}
