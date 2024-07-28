package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.c;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.one_pager.OpBrowseCategory;
import net.one97.paytm.o2o.movies.one_pager.OpFeaturedModel;
import net.one97.paytm.o2o.movies.one_pager.b;
import net.one97.paytm.o2o.movies.one_pager.c;
import net.one97.paytm.o2o.movies.one_pager.e;
import net.one97.paytm.o2o.movies.one_pager.f;
import net.one97.paytm.o2o.movies.one_pager.holders.a;
import net.one97.paytm.o2o.movies.one_pager.holders.d;
import net.one97.paytm.o2o.movies.one_pager.holders.g;
import net.one97.paytm.o2o.movies.utils.n;

public final class bd extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private final List<OpFeaturedModel> f74571a;

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f74572b;

    /* renamed from: c  reason: collision with root package name */
    private final List<OpBrowseCategory> f74573c;

    /* renamed from: d  reason: collision with root package name */
    private final List<CJRHomePageItem> f74574d;

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f74575e;

    /* renamed from: f  reason: collision with root package name */
    private final c.a f74576f;

    /* renamed from: g  reason: collision with root package name */
    private Context f74577g;

    /* renamed from: h  reason: collision with root package name */
    private f f74578h;

    public bd(Context context, f fVar, c.a aVar) {
        this.f74577g = context;
        this.f74578h = fVar;
        this.f74571a = fVar.f75665c;
        this.f74572b = fVar.f75664b;
        this.f74573c = fVar.f75668f;
        this.f74574d = fVar.f75669g;
        this.f74575e = fVar.f75670h;
        this.f74576f = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (b.FEATURED.id == i2) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.op_featured_item, viewGroup, false));
        }
        if (b.CATEGORY_ITEMS.id == i2) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.op_comedy_item, viewGroup, false));
        }
        if (b.BROWSE.id == i2) {
            return new net.one97.paytm.o2o.movies.one_pager.holders.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.op_browse_item, viewGroup, false));
        }
        if (b.OFFERS.id == i2) {
            return new g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.op_offers_item, viewGroup, false));
        }
        if (b.MOVIE.id == i2) {
            return new net.one97.paytm.o2o.movies.one_pager.holders.f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.op_movie_item, viewGroup, false));
        }
        return new net.one97.paytm.o2o.movies.one_pager.holders.e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.op_date_filter_item, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar != null) {
            if (vVar instanceof a) {
                ((a) vVar).a(this.f74577g, this.f74571a.get(i2), i2, this.f74578h);
            } else if (vVar instanceof d) {
                ((d) vVar).a(this.f74577g, this.f74571a.get(i2), this.f74578h);
            } else if (vVar instanceof net.one97.paytm.o2o.movies.one_pager.holders.e) {
                ((net.one97.paytm.o2o.movies.one_pager.holders.e) vVar).a(this.f74577g, this.f74572b.get(i2), this.f74576f);
            } else if (vVar instanceof net.one97.paytm.o2o.movies.one_pager.holders.c) {
                ((net.one97.paytm.o2o.movies.one_pager.holders.c) vVar).a(this.f74577g, this.f74573c.get(i2));
            } else if (vVar instanceof g) {
                ((g) vVar).a(this.f74577g, this.f74574d.get(i2), this.f74576f);
            } else if (vVar instanceof net.one97.paytm.o2o.movies.one_pager.holders.f) {
                net.one97.paytm.o2o.movies.one_pager.holders.f fVar = (net.one97.paytm.o2o.movies.one_pager.holders.f) vVar;
                Context context = this.f74577g;
                net.one97.paytm.o2o.movies.activity.c cVar = this.f74575e.get(i2);
                f fVar2 = this.f74578h;
                if (cVar != null) {
                    CJRMovieHomeListItem cJRMovieHomeListItem = cVar.f74225a;
                    if (!TextUtils.isEmpty(cJRMovieHomeListItem.getAppImgPath())) {
                        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_op_movies_placeholder);
                        t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory());
                        t.a(cJRMovieHomeListItem.getAppImgPath(), 18, drawable, drawable, fVar.f75696a, true);
                    }
                    fVar.f75696a.setOnClickListener(new View.OnClickListener(cVar, context, fVar2) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ net.one97.paytm.o2o.movies.activity.c f75699a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ Context f75700b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ net.one97.paytm.o2o.movies.one_pager.f f75701c;

                        {
                            this.f75699a = r2;
                            this.f75700b = r3;
                            this.f75701c = r4;
                        }

                        public final void onClick(View view) {
                            net.one97.paytm.o2o.movies.common.c.c.getInstance().launchDeeplink(this.f75699a.f74226b, this.f75700b, (String) null);
                            net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
                            String str = net.one97.paytm.o2o.movies.common.b.b.f75006a;
                            Context context = this.f75700b;
                            net.one97.paytm.o2o.movies.activity.c cVar2 = this.f75699a;
                            net.one97.paytm.o2o.movies.one_pager.f fVar = this.f75701c;
                            HashMap hashMap = new HashMap();
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/entertainment");
                            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, "entertainment");
                            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "listing_card_clicked");
                            if (fVar != null && !TextUtils.isEmpty(fVar.f75667e)) {
                                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, fVar.f75667e.toLowerCase());
                            }
                            if (cVar2.f74225a != null && !TextUtils.isEmpty(cVar2.f74225a.getLabel())) {
                                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75010e, cVar2.f74225a.getLabel().toLowerCase());
                            }
                            if (com.paytm.utility.b.r(context)) {
                                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(context));
                            }
                            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, "entertainment");
                            cVar.sendCustomEventWithMap(str, hashMap, this.f75700b);
                        }
                    });
                    CJRMovieHomeListItem cJRMovieHomeListItem2 = cVar.f74225a;
                    if (!TextUtils.isEmpty(cJRMovieHomeListItem2.getLabel())) {
                        fVar.f75697b.setText(cJRMovieHomeListItem2.getLabel());
                    }
                    String a2 = n.a(cVar.f74225a);
                    if (!TextUtils.isEmpty(a2)) {
                        fVar.f75698c.setText(a2);
                    }
                }
            }
        }
    }

    public final int getItemViewType(int i2) {
        return this.f74578h.f75663a.id;
    }

    public final int getItemCount() {
        List<net.one97.paytm.o2o.movies.activity.c> list;
        List<CJRHomePageItem> list2;
        List<OpBrowseCategory> list3;
        List<e> list4;
        List<OpFeaturedModel> list5;
        if ((this.f74578h.f75663a == b.FEATURED || this.f74578h.f75663a == b.CATEGORY_ITEMS) && (list5 = this.f74571a) != null) {
            return list5.size();
        }
        if (this.f74578h.f75663a == b.DATE_FILTER && (list4 = this.f74572b) != null) {
            return list4.size();
        }
        if (this.f74578h.f75663a == b.BROWSE && (list3 = this.f74573c) != null) {
            return list3.size();
        }
        if (this.f74578h.f75663a == b.OFFERS && (list2 = this.f74574d) != null) {
            return list2.size();
        }
        if (this.f74578h.f75663a != b.MOVIE || (list = this.f74575e) == null) {
            return 0;
        }
        return list.size();
    }
}
