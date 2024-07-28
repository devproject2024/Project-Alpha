package net.one97.paytm.feed.ui.feed.p;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.b.cy;
import net.one97.paytm.feed.repository.models.weather.FeedWeather;
import net.one97.paytm.feed.repository.models.weather.FeedWeatherDetails;
import net.one97.paytm.feed.ui.base.b;

public final class a extends b<cy, FeedWeather, Object> {

    /* renamed from: b  reason: collision with root package name */
    public boolean f35172b;

    /* renamed from: c  reason: collision with root package name */
    public View f35173c;

    /* renamed from: net.one97.paytm.feed.ui.feed.p.a$a  reason: collision with other inner class name */
    public static final class C0584a extends l implements kotlin.g.a.b<FeedWeatherDetails, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0584a(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedWeatherDetails) obj);
            return x.f47997a;
        }

        public final void invoke(FeedWeatherDetails feedWeatherDetails) {
            if (feedWeatherDetails != null) {
                a aVar = this.this$0;
                aVar.f35172b = true;
                TextView textView = ((cy) aVar.f34872a).f34116b;
                k.a((Object) textView, "dataBinding.feedMaxMin");
                textView.setText(feedWeatherDetails.getMaxMinTemperatureText());
                TextView textView2 = ((cy) this.this$0.f34872a).f34115a;
                k.a((Object) textView2, "dataBinding.feedDateText");
                textView2.setText(feedWeatherDetails.getDateText());
                TextView textView3 = ((cy) this.this$0.f34872a).f34118d;
                k.a((Object) textView3, "dataBinding.feedWeatherTemp");
                textView3.setText(feedWeatherDetails.getTemperatureText());
                TextView textView4 = ((cy) this.this$0.f34872a).f34119e;
                k.a((Object) textView4, "dataBinding.feedWeatherText");
                textView4.setText(feedWeatherDetails.getWeatherText());
                ImageView imageView = ((cy) this.this$0.f34872a).f34117c;
                k.a((Object) imageView, "dataBinding.feedWeatherIcon");
                net.one97.paytm.feed.utility.a.a(imageView, feedWeatherDetails.getWeatherIconUrl());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
        this.f35173c = view;
    }
}
