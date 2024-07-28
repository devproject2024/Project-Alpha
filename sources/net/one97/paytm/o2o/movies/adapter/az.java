package net.one97.paytm.o2o.movies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.entity.events.CategoryId;
import net.one97.paytm.o2o.movies.entity.events.Event;

public final class az extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.o2o.movies.d.a f74510a;

    /* renamed from: b  reason: collision with root package name */
    private List<Event> f74511b;

    public az(List<Event> list, net.one97.paytm.o2o.movies.d.a aVar) {
        k.c(list, EventsModuleManager.MODULE_NAME);
        k.c(aVar, "h5ClickListener");
        this.f74511b = list;
        this.f74510a = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String name;
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        Event event = this.f74511b.get(i2);
        String str = null;
        w.a().a(String.valueOf(event.getVerticalCoverImage())).a(aVar.f74512a, (e) null);
        TextView textView = aVar.f74513b;
        k.a((Object) textView, "holder.eventTitleTv");
        textView.setText(event.getName());
        TextView textView2 = aVar.f74514c;
        k.a((Object) textView2, "holder.eventDateDescTv");
        textView2.setText(event.getVenueDateString());
        TextView textView3 = aVar.f74515d;
        k.a((Object) textView3, "holder.eventVenueTv");
        textView3.setText(event.getVenueName());
        TextView textView4 = aVar.f74516e;
        k.a((Object) textView4, "holder.eventPricingTv");
        textView4.setText("₹ " + event.getPriceDisplayString());
        if (event.getVerticalCoverImage() == null) {
            w.a().a(String.valueOf(event.getHorizontalCoverImage())).a(aVar.f74512a, (e) null);
        }
        aVar.f74512a.setOnClickListener(new b(event, this, i2, aVar));
        TextView textView5 = aVar.f74517f;
        k.a((Object) textView5, "holder.eventCategoryTv");
        CategoryId categoryId = event.getCategoryId();
        if (!(categoryId == null || (name = categoryId.getName()) == null)) {
            if (name != null) {
                str = name.toUpperCase();
                k.a((Object) str, "(this as java.lang.String).toUpperCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        textView5.setText(str);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_carousel_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…rousel_item,parent,false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f74511b.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Event f74519a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ az f74520b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74521c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f74522d;

        b(Event event, az azVar, int i2, a aVar) {
            this.f74519a = event;
            this.f74520b = azVar;
            this.f74521c = i2;
            this.f74522d = aVar;
        }

        public final void onClick(View view) {
            String h5url = this.f74519a.getH5url();
            if (h5url != null) {
                this.f74520b.f74510a.a(h5url);
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f74512a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74513b;

        /* renamed from: c  reason: collision with root package name */
        TextView f74514c;

        /* renamed from: d  reason: collision with root package name */
        TextView f74515d;

        /* renamed from: e  reason: collision with root package name */
        TextView f74516e;

        /* renamed from: f  reason: collision with root package name */
        TextView f74517f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ az f74518g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(az azVar, View view) {
            super(view);
            k.c(view, "view");
            this.f74518g = azVar;
            this.f74512a = (ImageView) view.findViewById(R.id.event_poster_iv);
            this.f74513b = (TextView) view.findViewById(R.id.event_title_tv);
            this.f74514c = (TextView) view.findViewById(R.id.event_date_desc_tv);
            this.f74515d = (TextView) view.findViewById(R.id.event_venue_tv);
            this.f74516e = (TextView) view.findViewById(R.id.event_pricing_tv);
            this.f74517f = (TextView) view.findViewById(R.id.event_category_tv);
        }
    }
}
