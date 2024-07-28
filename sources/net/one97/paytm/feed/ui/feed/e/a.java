package net.one97.paytm.feed.ui.feed.e;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.b.aa;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.weather.FeedWeather;
import net.one97.paytm.feed.repository.models.weather.FeedWeatherDetails;
import net.one97.paytm.feed.ui.feed.FeedWebViewActivity;

public final class a extends net.one97.paytm.feed.ui.base.b<aa, FeedWeather, Object> {

    /* renamed from: b  reason: collision with root package name */
    public boolean f35041b;

    /* renamed from: c  reason: collision with root package name */
    public View f35042c;

    /* renamed from: d  reason: collision with root package name */
    public final b f35043d;

    public static final class b extends l implements kotlin.g.a.b<FeedWeatherDetails, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
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
                aVar.f35041b = true;
                TextView textView = ((aa) aVar.f34872a).f33807d;
                k.a((Object) textView, "dataBinding.feedMaxMin");
                textView.setText(feedWeatherDetails.getMaxMinTemperatureText());
                TextView textView2 = ((aa) this.this$0.f34872a).f33806c;
                k.a((Object) textView2, "dataBinding.feedDateText");
                textView2.setText(feedWeatherDetails.getDateText());
                TextView textView3 = ((aa) this.this$0.f34872a).f33805b;
                k.a((Object) textView3, "dataBinding.currTempText");
                textView3.setText(feedWeatherDetails.getTemperatureText());
                ImageView imageView = ((aa) this.this$0.f34872a).f33808e;
                k.a((Object) imageView, "dataBinding.feedWeatherIcon");
                net.one97.paytm.feed.utility.a.a(imageView, feedWeatherDetails.getWeatherIconUrl());
                final String clickUrl = feedWeatherDetails.getClickUrl();
                ((aa) this.this$0.f34872a).f33808e.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f35046a;

                    {
                        this.f35046a = r1;
                    }

                    public final void onClick(View view) {
                        this.f35046a.this$0.a(clickUrl);
                    }
                });
                ((aa) this.this$0.f34872a).f33807d.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f35048a;

                    {
                        this.f35048a = r1;
                    }

                    public final void onClick(View view) {
                        this.f35048a.this$0.a(clickUrl);
                    }
                });
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, b bVar) {
        super(view);
        k.c(view, "view");
        k.c(bVar, "locationProvider");
        this.f35042c = view;
        this.f35043d = bVar;
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.e.a$a  reason: collision with other inner class name */
    public static final class C0578a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35044a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35045b;

        public C0578a(a aVar, int i2) {
            this.f35044a = aVar;
            this.f35045b = i2;
        }

        public final void onClick(View view) {
            this.f35044a.f35043d.a(this.f35045b);
        }
    }

    public final void a(String str) {
        k.c(str, "urlToOpen");
        FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
        Context context = this.f35042c.getContext();
        k.a((Object) context, "view.context");
        FeedWebViewActivity.a.a(context, "Accuweather", str, (FeedItem) null);
    }
}
