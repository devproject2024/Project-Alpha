package net.one97.paytm.upgradeKyc.editprofile.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.landingpage.R;

public final class a extends RecyclerView.a<C1309a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f65845a;

    /* renamed from: b  reason: collision with root package name */
    final kotlin.g.a.b<g, x> f65846b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<g> f65847c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1309a aVar = (C1309a) vVar;
        k.c(aVar, "holder");
        g gVar = this.f65847c.get(i2);
        k.a((Object) gVar, "mAlbumList[position]");
        g gVar2 = gVar;
        aVar.f65848a.setText(gVar2.f65865b);
        aVar.f65849b.setOnClickListener(new b(this, gVar2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        Context context = viewGroup.getContext();
        k.a((Object) context, "parent.context");
        this.f65845a = context;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…lbum_item, parent, false)");
        return new C1309a(inflate);
    }

    public a(ArrayList<g> arrayList, kotlin.g.a.b<? super g, x> bVar) {
        k.c(arrayList, "mAlbumList");
        k.c(bVar, "onAlbumClicked");
        this.f65847c = arrayList;
        this.f65846b = bVar;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65850a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f65851b;

        b(a aVar, g gVar) {
            this.f65850a = aVar;
            this.f65851b = gVar;
        }

        public final void onClick(View view) {
            this.f65850a.f65846b.invoke(this.f65851b);
        }
    }

    public final int getItemCount() {
        return this.f65847c.size();
    }

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.gallery.a$a  reason: collision with other inner class name */
    public static final class C1309a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f65848a;

        /* renamed from: b  reason: collision with root package name */
        ConstraintLayout f65849b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1309a(View view) {
            super(view);
            k.c(view, "view");
            TextView textView = (TextView) view.findViewById(R.id.albumTitleTv);
            k.a((Object) textView, "view.albumTitleTv");
            this.f65848a = textView;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.albumCl);
            k.a((Object) constraintLayout, "view.albumCl");
            this.f65849b = constraintLayout;
        }
    }
}
