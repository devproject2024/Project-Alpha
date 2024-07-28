package net.one97.paytm.i;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.util.f;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.landingpage.R;

public class d extends h {

    /* renamed from: a  reason: collision with root package name */
    LayoutInflater f50566a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRHomePageItem> f50567b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f50568c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CirclePageIndicator f50569d;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f50566a = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.lyt_home_thin_banner, viewGroup, false);
        this.f50568c = (ViewPager) inflate.findViewById(R.id.imageviewPager);
        this.f50569d = (CirclePageIndicator) inflate.findViewById(R.id.deals_banner_nearby_view_page_indicator);
        if (getArguments() != null) {
            this.f50567b = (ArrayList) getArguments().getSerializable("banner_item_list");
        }
        this.f50568c.setAdapter(new a(this, (byte) 0));
        this.f50569d.setViewPager(this.f50568c);
        return inflate;
    }

    public class a extends androidx.viewpager.widget.a {
        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        private a() {
        }

        public final int getCount() {
            if (f.a(d.this.f50567b)) {
                return 0;
            }
            return d.this.f50567b.size();
        }

        public final Object instantiateItem(ViewGroup viewGroup, final int i2) {
            View inflate = d.this.f50566a.inflate(R.layout.homepage_image_widget_viewpager_item, viewGroup, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.viewpager_image);
            if (d.this.f50567b != null && d.this.f50567b.size() > i2) {
                FragmentActivity activity = d.this.getActivity();
                if (activity != null && (activity.getClass().getSimpleName().equalsIgnoreCase("AJRTravelsHomeActivity") || activity.getClass().getSimpleName().equalsIgnoreCase("FlightOrderSummary") || activity.getClass().getSimpleName().equalsIgnoreCase("BusOrderSummary"))) {
                    b.a((Context) d.this.getActivity(), imageView, d.this.f50567b.get(i2).getImageUrl(), net.one97.paytm.landingpage.utils.d.a((Context) d.this.getActivity()));
                } else {
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(d.this.getActivity());
                    a2.f43753a = d.this.f50567b.get(i2).getImageUrl();
                    b.a.C0750a.a(b.a.C0750a.a(a2, a.c.HOME.name()), imageView, (com.paytm.utility.b.b.b) null, 2);
                }
                if (d.this.f50567b.size() < 2) {
                    d.this.f50569d.setVisibility(8);
                } else {
                    d.this.f50569d.setVisibility(0);
                }
            }
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a aVar = a.this;
                    CJRHomePageItem cJRHomePageItem = d.this.f50567b.get(i2);
                    String uRLType = cJRHomePageItem.getURLType();
                    if (TextUtils.isEmpty(cJRHomePageItem.getDeeplink())) {
                        cJRHomePageItem.setDeeplink(cJRHomePageItem.getURL());
                    }
                    String deeplink = cJRHomePageItem.getDeeplink();
                    if (!(!TextUtils.isEmpty(deeplink) && (deeplink.startsWith("paytmmp") || deeplink.startsWith("paytmmall")))) {
                        String url = cJRHomePageItem.getURL();
                        StringBuilder sb = new StringBuilder();
                        sb.append("paytmmp://");
                        sb.append(uRLType);
                        sb.append(!TextUtils.isEmpty(url) ? "?url=".concat(String.valueOf(url)) : "");
                        cJRHomePageItem.setDeeplink(sb.toString());
                    }
                    net.one97.paytm.common.b.d.a().a(d.this.getActivity(), uRLType, cJRHomePageItem, "", -1, (ArrayList<? extends CJRItem>) null, false, "", (String) null);
                }
            });
            viewGroup.addView(inflate);
            return inflate;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }
    }
}
