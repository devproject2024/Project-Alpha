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
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.entity.events.Category;

public final class ay extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.o2o.movies.d.a f74500a;

    /* renamed from: b  reason: collision with root package name */
    private List<Category> f74501b;

    public ay(List<Category> list, net.one97.paytm.o2o.movies.d.a aVar) {
        k.c(list, "eventCategories");
        k.c(aVar, "h5ClickListener");
        this.f74501b = list;
        this.f74500a = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        Category category = this.f74501b.get(i2);
        w.a().a(category.getIcon()).a(aVar.f74502a, (e) null);
        TextView textView = aVar.f74503b;
        k.a((Object) textView, "holder.categoryTitleTv");
        textView.setText(category.getName());
        TextView textView2 = aVar.f74504c;
        k.a((Object) textView2, "holder.categoryCountTv");
        textView2.setText(String.valueOf(category.getEventCount()) + " events");
        aVar.f74502a.setOnClickListener(new b(category, this, i2, aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_category_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…tegory_item,parent,false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f74501b.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Category f74506a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ay f74507b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74508c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f74509d;

        b(Category category, ay ayVar, int i2, a aVar) {
            this.f74506a = category;
            this.f74507b = ayVar;
            this.f74508c = i2;
            this.f74509d = aVar;
        }

        public final void onClick(View view) {
            String h5url = this.f74506a.getH5url();
            if (h5url != null) {
                this.f74507b.f74500a.a(h5url);
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f74502a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74503b;

        /* renamed from: c  reason: collision with root package name */
        TextView f74504c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ay f74505d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ay ayVar, View view) {
            super(view);
            k.c(view, "view");
            this.f74505d = ayVar;
            this.f74502a = (ImageView) view.findViewById(R.id.event_category_iv);
            this.f74503b = (TextView) view.findViewById(R.id.event_category_title_tv);
            this.f74504c = (TextView) view.findViewById(R.id.event_category_count_tv);
        }
    }
}
