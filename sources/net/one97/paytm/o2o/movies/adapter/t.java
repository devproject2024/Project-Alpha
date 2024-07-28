package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytm.utility.t;
import com.squareup.picasso.aa;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Items;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.utils.n;

public final class t extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final List<CJRMovieSummaryCatalogV2Items> f74766a;

    /* renamed from: b  reason: collision with root package name */
    final y.i f74767b;

    /* renamed from: c  reason: collision with root package name */
    private int f74768c = (n.b(this.f74771f) - n.a(45, this.f74771f));

    /* renamed from: d  reason: collision with root package name */
    private int f74769d = ((int) (((double) this.f74768c) / 1.69d));

    /* renamed from: e  reason: collision with root package name */
    private final CJRHomePageItem f74770e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f74771f;

    public t(List<CJRMovieSummaryCatalogV2Items> list, Context context, y.i iVar) {
        k.c(context, "mContext");
        k.c(iVar, "mClickListener");
        this.f74766a = list;
        this.f74771f = context;
        this.f74767b = iVar;
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setName("/movies-order-summary");
        this.f74770e = cJRHomePageItem;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CJRMovieSummaryCatalogV2Items cJRMovieSummaryCatalogV2Items;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f74768c, this.f74769d);
        if (i2 == 0) {
            layoutParams.setMargins(n.a(20, this.f74771f), 0, 0, 0);
        }
        aVar.f74772a.setLayoutParams(layoutParams);
        List<CJRMovieSummaryCatalogV2Items> list = this.f74766a;
        if (list != null && (cJRMovieSummaryCatalogV2Items = (CJRMovieSummaryCatalogV2Items) kotlin.a.k.a(list, i2)) != null) {
            this.f74771f.getApplicationContext();
            String a2 = b.a(cJRMovieSummaryCatalogV2Items.getImageUrl(), this.f74768c, this.f74769d);
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f74771f, R.drawable.movie_home_top_banner_placeholder);
            if (b2 != null) {
                aa a3 = w.a().a(a2);
                a3.f45353b = true;
                a3.b(b2).a(b2).a((ah) new t.b(n.a(6, this.f74771f), 0, true)).a(aVar.f74772a, (e) null);
            }
            try {
                if (!(cJRMovieSummaryCatalogV2Items instanceof CJRHomePageItem)) {
                    cJRMovieSummaryCatalogV2Items = null;
                }
                CJRHomePageItem cJRHomePageItem = cJRMovieSummaryCatalogV2Items;
                if (cJRHomePageItem != null) {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendMoviePromotionImpression(this.f74770e, this.f74771f, i2, net.one97.paytm.o2o.movies.common.b.b.U, cJRHomePageItem.getName());
                    x xVar = x.f47997a;
                }
            } catch (Exception unused) {
                x xVar2 = x.f47997a;
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f74771f).inflate(R.layout.movie_summary_catalog_cell, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(mCon…           parent, false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        List<CJRMovieSummaryCatalogV2Items> list = this.f74766a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f74772a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f74773b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(t tVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f74773b = tVar;
            View findViewById = view.findViewById(R.id.iv_catalog_item_image);
            k.a((Object) findViewById, "itemView.findViewById(R.id.iv_catalog_item_image)");
            this.f74772a = (ImageView) findViewById;
            this.f74772a.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f74774a;

                {
                    this.f74774a = r1;
                }

                public final void onClick(View view) {
                    CJRMovieSummaryCatalogV2Items cJRMovieSummaryCatalogV2Items;
                    try {
                        List<CJRMovieSummaryCatalogV2Items> list = this.f74774a.f74773b.f74766a;
                        if (list != null && (cJRMovieSummaryCatalogV2Items = (CJRMovieSummaryCatalogV2Items) kotlin.a.k.a(list, this.f74774a.getAdapterPosition())) != null) {
                            y.i iVar = this.f74774a.f74773b.f74767b;
                            String uRLType = cJRMovieSummaryCatalogV2Items.getURLType();
                            IJRDataModel iJRDataModel = cJRMovieSummaryCatalogV2Items;
                            String simpleName = AJRMovieOrderSummary.class.getSimpleName();
                            int adapterPosition = this.f74774a.getAdapterPosition();
                            List<CJRMovieSummaryCatalogV2Items> list2 = this.f74774a.f74773b.f74766a;
                            if (list2 != null) {
                                iVar.a(uRLType, iJRDataModel, simpleName, adapterPosition, (ArrayList) list2, true, "");
                                return;
                            }
                            throw new u("null cannot be cast to non-null type java.util.ArrayList<out net.one97.paytm.common.entity.CJRItem>");
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }
}
