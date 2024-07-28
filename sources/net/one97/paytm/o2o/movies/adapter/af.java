package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.d;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.utils.h;

public final class af extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f74301a;

    /* renamed from: b  reason: collision with root package name */
    private a f74302b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRSelectCityModel> f74303c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private androidx.core.graphics.drawable.b f74304d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f74305e = false;

    public interface a {
        void b(CJRSelectCityModel cJRSelectCityModel);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        CJRSelectCityModel cJRSelectCityModel = this.f74303c.get(i2);
        String str = cJRSelectCityModel.getmCityImageUrl();
        TextView textView = bVar.f74309d;
        h hVar = h.f75928a;
        textView.setText(h.a(cJRSelectCityModel));
        bVar.f74306a.setBackgroundColor(androidx.core.content.b.c(this.f74301a, R.color.white));
        bVar.f74310e.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory()).a(str.replace(" ", "%20"), bVar.f74307b, this.f74304d);
        } else {
            w.a().a(this.f74305e ? net.one97.paytm.common.assets.R.drawable.ic_city_icon_01_dummy : net.one97.paytm.common.assets.R.drawable.ic_city_icon_02_dummy).a(this.f74301a.getResources().getDrawable(this.f74305e ? net.one97.paytm.common.assets.R.drawable.ic_city_icon_01_dummy : net.one97.paytm.common.assets.R.drawable.ic_city_icon_02_dummy)).a(bVar.f74307b, (e) null);
            this.f74305e = !this.f74305e;
        }
        bVar.f74308c.setOnClickListener(new View.OnClickListener(cJRSelectCityModel) {
            private final /* synthetic */ CJRSelectCityModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                af.this.a(this.f$1, view);
            }
        });
    }

    public af(Context context, a aVar, List<CJRSelectCityModel> list) {
        this.f74301a = context;
        this.f74302b = aVar;
        this.f74303c = list;
        Drawable a2 = androidx.core.content.b.a(this.f74301a, net.one97.paytm.common.assets.R.drawable.bg_circle);
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(a2.getIntrinsicWidth(), a2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
        a2.draw(canvas);
        this.f74304d = d.a(this.f74301a.getResources(), createBitmap);
        this.f74304d.b();
        this.f74304d.a(((float) Math.max(createBitmap.getWidth(), createBitmap.getHeight())) / 2.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRSelectCityModel cJRSelectCityModel, View view) {
        a aVar = this.f74302b;
        if (aVar != null) {
            aVar.b(cJRSelectCityModel);
        }
    }

    public final int getItemCount() {
        return this.f74303c.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f74306a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f74307b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f74308c;

        /* renamed from: d  reason: collision with root package name */
        TextView f74309d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f74310e;

        public b(View view) {
            super(view);
            this.f74308c = (RelativeLayout) view.findViewById(R.id.artist_rel_lyt);
            this.f74306a = (RelativeLayout) view.findViewById(R.id.city_img_container);
            this.f74307b = (ImageView) view.findViewById(R.id.thumb_item);
            this.f74309d = (TextView) view.findViewById(R.id.name_item);
            this.f74310e = (ImageView) view.findViewById(R.id.city_selected);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f74301a).inflate(R.layout.item_select_top_cities, viewGroup, false));
    }
}
