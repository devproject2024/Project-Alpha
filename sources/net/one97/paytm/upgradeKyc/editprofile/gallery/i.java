package net.one97.paytm.upgradeKyc.editprofile.gallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.landingpage.R;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f65873a;

    /* renamed from: b  reason: collision with root package name */
    final kotlin.g.a.b<String, x> f65874b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<GalleryData> f65875c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        String str = this.f65875c.get(i2).f65838c;
        if (i2 == 0) {
            aVar.f65877b.setVisibility(0);
            aVar.f65876a.setVisibility(8);
            aVar.f65877b.setImageResource(R.drawable.ic_camera_background);
        } else {
            aVar.f65876a.setVisibility(0);
            aVar.f65877b.setVisibility(8);
            try {
                b.a aVar2 = com.paytm.utility.b.b.f43744a;
                Context context = this.f65873a;
                if (context == null) {
                    k.a("context");
                }
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = str;
                b.a.C0750a a3 = b.a.C0750a.a(a2, a.c.HOME.name());
                a3.l = true;
                b.a.C0750a a4 = a3.a(160, Integer.MIN_VALUE);
                a4.H = Boolean.TRUE;
                a4.I = Boolean.TRUE;
                a4.J = 300;
                a4.K = 0;
                a4.a(aVar.f65876a, (com.paytm.utility.b.b.b<?>) new b(aVar));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        aVar.f65876a.setOnClickListener(new c(this, str));
        aVar.f65877b.setOnClickListener(new d(this, str));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        Context context = viewGroup.getContext();
        k.a((Object) context, "parent.context");
        this.f65873a = context;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_grid_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…grid_item, parent, false)");
        return new a(inflate);
    }

    public i(ArrayList<GalleryData> arrayList, kotlin.g.a.b<? super String, x> bVar) {
        k.c(arrayList, "imageList");
        k.c(bVar, "onImageClicked");
        this.f65875c = arrayList;
        this.f65874b = bVar;
    }

    public static final class b implements com.paytm.utility.b.b.b<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65878a;

        public final /* bridge */ /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
        }

        b(a aVar) {
            this.f65878a = aVar;
        }

        public final void onError(Exception exc) {
            this.f65878a.f65876a.setAlpha(0.3f);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f65879a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f65880b;

        c(i iVar, String str) {
            this.f65879a = iVar;
            this.f65880b = str;
        }

        public final void onClick(View view) {
            this.f65879a.f65874b.invoke(this.f65880b);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f65881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f65882b;

        d(i iVar, String str) {
            this.f65881a = iVar;
            this.f65882b = str;
        }

        public final void onClick(View view) {
            this.f65881a.f65874b.invoke(this.f65882b);
        }
    }

    public final int getItemCount() {
        return this.f65875c.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f65876a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f65877b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "view");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.image);
            k.a((Object) appCompatImageView, "view.image");
            this.f65876a = appCompatImageView;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.imagecamera);
            k.a((Object) appCompatImageView2, "view.imagecamera");
            this.f65877b = appCompatImageView2;
        }
    }
}
