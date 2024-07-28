package net.one97.paytm.wallet.newdesign.nearby.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.paytm.utility.b;
import com.paytm.utility.t;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyOffersBannerModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public final class a extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    C1437a f71003a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<NearbyOffersBannerModal.Item> f71004b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f71005c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f71006d;

    /* renamed from: net.one97.paytm.wallet.newdesign.nearby.a.a$a  reason: collision with other inner class name */
    public interface C1437a {
        void a(IJRDataModel iJRDataModel);
    }

    public a(Context context, ArrayList<NearbyOffersBannerModal.Item> arrayList, C1437a aVar) {
        this.f71006d = LayoutInflater.from(context);
        this.f71005c = context;
        this.f71004b = arrayList;
        this.f71003a = aVar;
    }

    public final int getCount() {
        ArrayList<NearbyOffersBannerModal.Item> arrayList = this.f71004b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = this.f71006d.inflate(R.layout.nb_banner_nearby, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.viewpager_image);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.loading);
        int a2 = b.a((Activity) this.f71005c);
        int b2 = (int) (((double) a2) / (((double) b.b(360, this.f71005c)) / ((double) b.b(168, this.f71005c))));
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = b2;
        layoutParams.width = a2;
        imageView.setLayoutParams(layoutParams);
        NearbyOffersBannerModal.Item item = this.f71004b.get(i2);
        this.f71005c.getApplicationContext();
        String a3 = b.a(item.getImageUrl(), a2, b2);
        if (item != null && !TextUtils.isEmpty(a3) && URLUtil.isValidUrl(a3)) {
            t.a(false).a(a3, imageView, progressBar);
        }
        viewGroup.addView(inflate);
        inflate.setTag(item);
        inflate.setOnClickListener(new View.OnClickListener(item, i2) {
            private final /* synthetic */ NearbyOffersBannerModal.Item f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                a.this.a(this.f$1, this.f$2, view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(NearbyOffersBannerModal.Item item, int i2, View view) {
        if (this.f71003a != null) {
            d.a aVar = d.f71130b;
            d.a.b().a(item, this.f71005c, i2, "/nearby-C1");
            this.f71003a.a((NearbyOffersBannerModal.Item) view.getTag());
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).removeAllViews();
        }
        viewGroup.removeView(view);
    }
}
