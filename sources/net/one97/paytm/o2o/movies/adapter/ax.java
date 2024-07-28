package net.one97.paytm.o2o.movies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.entity.events.DigitalEvent;

public final class ax extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.o2o.movies.d.a f74492a;

    /* renamed from: b  reason: collision with root package name */
    private List<DigitalEvent> f74493b;

    public ax(List<DigitalEvent> list, net.one97.paytm.o2o.movies.d.a aVar) {
        k.c(list, "digitalEvents");
        k.c(aVar, "h5ClickListener");
        this.f74493b = list;
        this.f74492a = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        DigitalEvent digitalEvent = this.f74493b.get(i2);
        w.a().a(digitalEvent.getThumbnailUrl()).a(aVar.f74494a, (e) null);
        aVar.f74494a.setOnClickListener(new b(digitalEvent, this, i2, aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.digital_event_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…_event_item,parent,false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f74493b.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DigitalEvent f74496a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ax f74497b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74498c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f74499d;

        b(DigitalEvent digitalEvent, ax axVar, int i2, a aVar) {
            this.f74496a = digitalEvent;
            this.f74497b = axVar;
            this.f74498c = i2;
            this.f74499d = aVar;
        }

        public final void onClick(View view) {
            String h5url = this.f74496a.getH5url();
            if (h5url != null) {
                this.f74497b.f74492a.a(h5url);
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f74494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ax f74495b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ax axVar, View view) {
            super(view);
            k.c(view, "view");
            this.f74495b = axVar;
            this.f74494a = (ImageView) view.findViewById(R.id.digital_event_thumbnail_iv);
        }
    }
}
