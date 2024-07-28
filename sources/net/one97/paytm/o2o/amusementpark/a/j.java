package net.one97.paytm.o2o.amusementpark.a;

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
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.o2o.amusementpark.R;

public final class j extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f73189a;

    /* renamed from: b  reason: collision with root package name */
    private a f73190b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRSelectCityModel> f73191c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private androidx.core.graphics.drawable.b f73192d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f73193e = false;

    public interface a {
        void b(CJRSelectCityModel cJRSelectCityModel);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        CJRSelectCityModel cJRSelectCityModel = this.f73191c.get(i2);
        String str = cJRSelectCityModel.getmCityImageUrl();
        bVar.f73197d.setText(cJRSelectCityModel.getLabel());
        bVar.f73195b.setBackgroundColor(androidx.core.content.b.c(this.f73189a, R.color.white));
        bVar.f73198e.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            t.a(net.one97.paytm.o2o.amusementpark.a.a().getPicassoIsInMemory()).a(str.replace(" ", "%20"), bVar.f73194a, this.f73192d);
        } else {
            bVar.f73194a.setImageDrawable(androidx.appcompat.a.a.a.b(this.f73189a, this.f73193e ? net.one97.paytm.common.assets.R.drawable.ic_city_icon_01_dummy : net.one97.paytm.common.assets.R.drawable.ic_city_icon_02_dummy));
            this.f73193e = !this.f73193e;
        }
        bVar.f73196c.setOnClickListener(new View.OnClickListener(cJRSelectCityModel) {
            private final /* synthetic */ CJRSelectCityModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                j.this.a(this.f$1, view);
            }
        });
    }

    public j(Context context, a aVar, List<CJRSelectCityModel> list) {
        this.f73189a = context;
        this.f73190b = aVar;
        this.f73191c = list;
        Drawable a2 = androidx.core.content.b.a(this.f73189a, net.one97.paytm.common.assets.R.drawable.bg_circle);
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(a2.getIntrinsicWidth(), a2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
        a2.draw(canvas);
        this.f73192d = d.a(this.f73189a.getResources(), createBitmap);
        this.f73192d.b();
        this.f73192d.a(((float) Math.max(createBitmap.getWidth(), createBitmap.getHeight())) / 2.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRSelectCityModel cJRSelectCityModel, View view) {
        a aVar = this.f73190b;
        if (aVar != null) {
            aVar.b(cJRSelectCityModel);
        }
    }

    public final int getItemCount() {
        return this.f73191c.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f73194a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f73195b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f73196c;

        /* renamed from: d  reason: collision with root package name */
        TextView f73197d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f73198e;

        public b(View view) {
            super(view);
            this.f73196c = (RelativeLayout) view.findViewById(R.id.artist_rel_lyt);
            this.f73195b = (RelativeLayout) view.findViewById(R.id.city_img_container);
            this.f73194a = (ImageView) view.findViewById(R.id.thumb_item);
            this.f73197d = (TextView) view.findViewById(R.id.name_item);
            this.f73198e = (ImageView) view.findViewById(R.id.city_selected);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f73189a).inflate(R.layout.park_item_select_top_cities, viewGroup, false));
    }
}
