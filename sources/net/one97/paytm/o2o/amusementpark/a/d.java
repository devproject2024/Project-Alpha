package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.util.ArrayList;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel;
import net.one97.paytm.o2o.amusementpark.a.e;

public final class d extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f73097a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRAmParkDetailModel> f73098b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    e.d f73099c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f73100d;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        return i2;
    }

    public d(Context context, ArrayList<CJRAmParkDetailModel> arrayList, e.d dVar) {
        this.f73097a = context;
        this.f73098b = arrayList;
        this.f73099c = dVar;
        Context context2 = this.f73097a;
        if (context2 != null) {
            this.f73100d = (LayoutInflater) context2.getSystemService("layout_inflater");
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            CJRAmParkDetailModel cJRAmParkDetailModel = d.this.f73098b.get(i2);
            String imageURL = cJRAmParkDetailModel.getImageURL();
            String name = cJRAmParkDetailModel.getName();
            aVar.f73101a.setVisibility(0);
            if (!TextUtils.isEmpty(imageURL)) {
                String trim = imageURL.trim();
                Drawable b2 = androidx.appcompat.a.a.a.b(d.this.f73097a, R.drawable.android_amusement_park_placeholder_bg);
                t.a(net.one97.paytm.o2o.amusementpark.a.a().getPicassoIsInMemory());
                t.a(trim, 0, b2, b2, aVar.f73101a);
            }
            aVar.f73105e.setTag(cJRAmParkDetailModel.getProviderId());
            aVar.f73105e.setOnClickListener(new View.OnClickListener(i2, cJRAmParkDetailModel) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ int f73107a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ CJRAmParkDetailModel f73108b;

                {
                    this.f73107a = r2;
                    this.f73108b = r3;
                }

                public final void onClick(View view) {
                    d.this.f73099c.a((String) a.this.f73102b.getTag(), a.this.f73102b.getText().toString(), (String) view.getTag(), this.f73108b.getmId());
                }
            });
            aVar.f73102b.setText(name);
            if (cJRAmParkDetailModel.getCategories().size() > 0) {
                aVar.f73102b.setTag(cJRAmParkDetailModel.getCategories().get(0).getCategory());
            }
            aVar.f73104d.setText(cJRAmParkDetailModel.getmCity());
            TextView textView = aVar.f73103c;
            textView.setText("Rs. " + cJRAmParkDetailModel.getPrice() + " " + d.this.f73097a.getResources().getString(net.one97.paytm.o2o.amusementpark.R.string.onwards));
        }
    }

    public final int getItemCount() {
        return this.f73098b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f73101a;

        /* renamed from: b  reason: collision with root package name */
        TextView f73102b;

        /* renamed from: c  reason: collision with root package name */
        TextView f73103c;

        /* renamed from: d  reason: collision with root package name */
        TextView f73104d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f73105e;

        public a(View view) {
            super(view);
            this.f73105e = (LinearLayout) view.findViewById(net.one97.paytm.o2o.amusementpark.R.id.container_linear_lyt);
            this.f73101a = (ImageView) view.findViewById(net.one97.paytm.o2o.amusementpark.R.id.park_thumb_nail);
            this.f73102b = (TextView) view.findViewById(net.one97.paytm.o2o.amusementpark.R.id.park_name);
            this.f73103c = (TextView) view.findViewById(net.one97.paytm.o2o.amusementpark.R.id.park_price);
            this.f73104d = (TextView) view.findViewById(net.one97.paytm.o2o.amusementpark.R.id.park_address);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = this.f73100d.inflate(net.one97.paytm.o2o.amusementpark.R.layout.am_park_home_grid_item, viewGroup, false);
        if (Build.VERSION.SDK_INT >= 21) {
            inflate.setClipToOutline(true);
        }
        return new a(inflate);
    }
}
