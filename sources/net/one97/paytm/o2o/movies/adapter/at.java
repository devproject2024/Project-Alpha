package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.a.a.i;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRAmenity;

public final class at extends RecyclerView.a<a.C1482a> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f74472b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<CJRAmenity> f74473a = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        Drawable drawable;
        a.C1482a aVar = (a.C1482a) vVar;
        k.c(aVar, "holder");
        if (i2 != -1) {
            CJRAmenity cJRAmenity = this.f74473a.get(i2);
            k.a((Object) cJRAmenity, "cinemaAmenities.get(position)");
            CJRAmenity cJRAmenity2 = cJRAmenity;
            k.c(cJRAmenity2, "amenity");
            aVar.f74474a.setText(cJRAmenity2.getAmenity());
            ImageView imageView = aVar.f74475b;
            Context context = aVar.f74474a.getContext();
            k.a((Object) context, "amenityName.context");
            int amenityId = cJRAmenity2.getAmenityId();
            k.c(context, "context");
            switch (amenityId) {
                case 1:
                    drawable = i.a(context.getResources(), R.drawable.ic_movie_cinema_amenity_mticket, (Resources.Theme) null);
                    break;
                case 2:
                    drawable = i.a(context.getResources(), R.drawable.ic_parking, (Resources.Theme) null);
                    break;
                case 3:
                    drawable = i.a(context.getResources(), R.drawable.ic_movie_cinema_amenity_fb, (Resources.Theme) null);
                    break;
                case 4:
                    drawable = i.a(context.getResources(), R.drawable.ic_movie_cinema_amenity_wheelchair, (Resources.Theme) null);
                    break;
                case 5:
                    drawable = i.a(context.getResources(), R.drawable.ic_movie_cinema_amenity_recliner, (Resources.Theme) null);
                    break;
                case 6:
                    drawable = i.a(context.getResources(), R.drawable.ic_movie_cinema_amenity_pay_with_paytm, (Resources.Theme) null);
                    break;
                default:
                    drawable = i.a(context.getResources(), R.drawable.ic_movie_cinema_amenity_misc, (Resources.Theme) null);
                    break;
            }
            imageView.setImageDrawable(drawable);
            if (cJRAmenity2.getStatus() == 0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    aVar.f74474a.setTextColor(b.c(aVar.f74474a.getContext(), R.color.color_gray));
                } else {
                    TextView textView = aVar.f74474a;
                    Context context2 = aVar.f74474a.getContext();
                    k.a((Object) context2, "amenityName.context");
                    textView.setTextColor(context2.getResources().getColor(R.color.color_gray));
                }
                aVar.f74474a.setPaintFlags(aVar.f74474a.getPaintFlags() | 16);
                aVar.f74475b.setAlpha(70);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cinema_amenity, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…a_amenity, parent, false)");
        return new a.C1482a(inflate);
    }

    public final int getItemCount() {
        return this.f74473a.size();
    }

    public static final class a {

        /* renamed from: net.one97.paytm.o2o.movies.adapter.at$a$a  reason: collision with other inner class name */
        public static final class C1482a extends RecyclerView.v {

            /* renamed from: a  reason: collision with root package name */
            final TextView f74474a;

            /* renamed from: b  reason: collision with root package name */
            final ImageView f74475b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1482a(View view) {
                super(view);
                k.c(view, "itemView");
                View findViewById = view.findViewById(R.id.amenityName);
                k.a((Object) findViewById, "itemView.findViewById(R.id.amenityName)");
                this.f74474a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.amenityLogo);
                k.a((Object) findViewById2, "itemView.findViewById(R.id.amenityLogo)");
                this.f74475b = (ImageView) findViewById2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
