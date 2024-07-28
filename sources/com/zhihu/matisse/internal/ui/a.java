package com.zhihu.matisse.internal.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.zhihu.matisse.internal.b.b;
import com.zhihu.matisse.internal.b.c;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.c;
import com.zhihu.matisse.internal.ui.a.a;
import com.zhihu.matisse.internal.ui.widget.d;
import java.lang.ref.WeakReference;
import net.one97.paytm.i.h;

public class a extends h implements b.a, a.b, a.d {

    /* renamed from: a  reason: collision with root package name */
    public com.zhihu.matisse.internal.ui.a.a f45808a;

    /* renamed from: b  reason: collision with root package name */
    private final b f45809b = new b();

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f45810c;

    /* renamed from: d  reason: collision with root package name */
    private C0764a f45811d;

    /* renamed from: e  reason: collision with root package name */
    private a.b f45812e;

    /* renamed from: f  reason: collision with root package name */
    private a.d f45813f;

    /* renamed from: com.zhihu.matisse.internal.ui.a$a  reason: collision with other inner class name */
    public interface C0764a {
        c c();
    }

    public static a a(Album album) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_album", album);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof C0764a) {
            this.f45811d = (C0764a) context;
            if (context instanceof a.b) {
                this.f45812e = (a.b) context;
            }
            if (context instanceof a.d) {
                this.f45813f = (a.d) context;
                return;
            }
            return;
        }
        throw new IllegalStateException("Context must implement SelectionProvider.");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.chat_fragment_media_selection, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f45810c = (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Album album = (Album) getArguments().getParcelable("extra_album");
        this.f45808a = new com.zhihu.matisse.internal.ui.a.a(getContext(), this.f45811d.c(), this.f45810c);
        com.zhihu.matisse.internal.ui.a.a aVar = this.f45808a;
        aVar.f45814a = this;
        aVar.f45815b = this;
        int i2 = 1;
        this.f45810c.setHasFixedSize(true);
        com.zhihu.matisse.internal.entity.c a2 = c.a.f45787a;
        if (a2.n > 0) {
            int round = Math.round(((float) getContext().getResources().getDisplayMetrics().widthPixels) / ((float) a2.n));
            if (round != 0) {
                i2 = round;
            }
        } else {
            i2 = a2.m;
        }
        this.f45810c.setLayoutManager(new GridLayoutManager(getContext(), i2));
        this.f45810c.addItemDecoration(new d(i2, getResources().getDimensionPixelSize(R.dimen.media_grid_spacing)));
        this.f45810c.setAdapter(this.f45808a);
        b bVar = this.f45809b;
        FragmentActivity activity = getActivity();
        bVar.f45730a = new WeakReference<>(activity);
        bVar.f45731b = activity.getSupportLoaderManager();
        bVar.f45732c = this;
        b bVar2 = this.f45809b;
        boolean z = a2.k;
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("args_album", album);
        bundle2.putBoolean("args_enable_capture", z);
        bVar2.f45731b.a(2, bundle2, bVar2);
    }

    public void onDestroyView() {
        super.onDestroyView();
        b bVar = this.f45809b;
        if (bVar.f45731b != null) {
            bVar.f45731b.a(2);
        }
        bVar.f45732c = null;
    }

    public final void a(Cursor cursor) {
        this.f45808a.b(cursor);
    }

    public final void a() {
        this.f45808a.b((Cursor) null);
    }

    public final void b() {
        a.b bVar = this.f45812e;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void a(Item item, int i2) {
        a.d dVar = this.f45813f;
        if (dVar != null) {
            getArguments().getParcelable("extra_album");
            dVar.a(item, i2);
        }
    }
}
