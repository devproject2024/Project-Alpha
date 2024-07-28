package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.aa;
import com.squareup.picasso.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ad;
import net.one97.paytm.o2o.movies.common.a.d;
import net.one97.paytm.o2o.movies.common.c.b;

public final class ab extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends CJRHomePageItem> f74247a = w.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    final CJRHomePageItem f74248b;

    /* renamed from: c  reason: collision with root package name */
    final ad.a f74249c;

    /* renamed from: d  reason: collision with root package name */
    private final int f74250d;

    public ab(ad.a aVar, int i2) {
        k.c(aVar, "mCarouselClickedListener");
        this.f74249c = aVar;
        this.f74250d = i2;
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setName("/movies-offers");
        this.f74248b = cJRHomePageItem;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) this.f74247a.get(i2);
        k.c(cJRHomePageItem, "mBannerMovies");
        Context context = aVar.f74251a.getContext();
        if (context != null) {
            com.squareup.picasso.w a2 = com.squareup.picasso.w.a();
            String imageUrl = cJRHomePageItem.getImageUrl();
            k.a((Object) imageUrl, "mBannerMovies.imageUrl");
            aa a3 = a2.a(d.a(imageUrl));
            a3.f45353b = true;
            a3.b(context.getResources().getDrawable(R.drawable.img_offer_placeholder_130_x_130_dp)).a(context.getResources().getDrawable(R.drawable.img_offer_placeholder_130_x_130_dp)).a(aVar.f74251a, (e) null);
            b.f75032a.f75033b.sendMoviePromotionImpression(aVar.f74252b.f74248b, context, i2, "/movies", cJRHomePageItem.getName());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new a(this, viewGroup);
    }

    public final void a(List<? extends CJRHomePageItem> list) {
        k.c(list, "value");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            CharSequence imageUrl = ((CJRHomePageItem) next).getImageUrl();
            if (!(imageUrl == null || p.a(imageUrl))) {
                arrayList.add(next);
            }
        }
        this.f74247a = (List) arrayList;
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        return this.f74247a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f74251a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ab f74252b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ab abVar, ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.banner_grid_view, viewGroup, false));
            k.c(viewGroup, "parent");
            this.f74252b = abVar;
            View view = this.itemView;
            if (view != null) {
                this.f74251a = (ImageView) view;
                this.f74251a.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f74253a;

                    {
                        this.f74253a = r1;
                    }

                    public final void onClick(View view) {
                        net.one97.paytm.o2o.movies.common.a.e.b(this.f74253a.f74251a);
                        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) kotlin.a.k.a(this.f74253a.f74252b.f74247a, this.f74253a.getAdapterPosition());
                        if (cJRHomePageItem != null) {
                            b.f75032a.f75033b.sendMoviePromotionImpressionClick(this.f74253a.f74252b.f74248b, this.f74253a.f74251a.getContext(), this.f74253a.getAdapterPosition(), "/movies", cJRHomePageItem.getName());
                            this.f74253a.getAdapterPosition();
                            this.f74253a.f74252b.f74249c.a(cJRHomePageItem);
                        }
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }
}
