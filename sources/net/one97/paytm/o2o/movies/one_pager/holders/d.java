package net.one97.paytm.o2o.movies.one_pager.holders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import com.squareup.picasso.aa;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.c.c;
import net.one97.paytm.o2o.movies.one_pager.OpFeaturedModel;
import net.one97.paytm.o2o.movies.one_pager.f;
import net.one97.paytm.o2o.movies.utils.n;

public final class d extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f75688a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75689b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75690c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75691d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75692e;

    public d(View view) {
        super(view);
        this.f75688a = (ImageView) view.findViewById(R.id.featured_image);
        this.f75690c = (TextView) view.findViewById(R.id.showCostTv);
        this.f75691d = (TextView) view.findViewById(R.id.showNameTv);
        this.f75692e = (TextView) view.findViewById(R.id.showDateTv);
        this.f75689b = (TextView) view.findViewById(R.id.showLocationTv);
    }

    public final void a(Context context, OpFeaturedModel opFeaturedModel, f fVar) {
        if (opFeaturedModel != null) {
            if (!TextUtils.isEmpty(opFeaturedModel.horizontal_cover_image)) {
                try {
                    Drawable b2 = a.b(context, R.drawable.moive_op_landscape_placeholder);
                    t.a(b.f75032a.f75033b.getPicassoIsInMemory());
                    t.a(opFeaturedModel.horizontal_cover_image, 18, b2, b2, this.f75688a, true);
                } catch (Exception unused) {
                    t.a(b.f75032a.f75033b.getPicassoIsInMemory());
                    String str = opFeaturedModel.horizontal_cover_image;
                    ImageView imageView = this.f75688a;
                    aa a2 = w.a().a(str).a((ah) new t.b(18, 0, true));
                    a2.f45353b = true;
                    a2.a(imageView, (e) null);
                }
            }
            n.a(this.f75691d, opFeaturedModel.name);
            n.a(this.f75692e, opFeaturedModel.venue_date_string);
            n.a(this.f75689b, opFeaturedModel.venue_name);
            n.a(this.f75690c, net.one97.paytm.o2o.movies.common.d.a(opFeaturedModel.price_display_string, context));
            this.f75688a.setOnClickListener(new View.OnClickListener(opFeaturedModel, context, fVar) {
                private final /* synthetic */ OpFeaturedModel f$1;
                private final /* synthetic */ Context f$2;
                private final /* synthetic */ f f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    d.this.a(this.f$1, this.f$2, this.f$3, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(OpFeaturedModel opFeaturedModel, Context context, f fVar, View view) {
        b.f75032a.f75033b.launchDeeplink("paytmmp://events?insiderH5Url=https://h5.insider.in/" + opFeaturedModel.slug + "/event", context, (String) null);
        c cVar = b.f75032a.f75033b;
        String str = net.one97.paytm.o2o.movies.common.b.b.f75006a;
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/entertainment");
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, "entertainment");
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "listing_card_clicked");
        if (fVar != null && !TextUtils.isEmpty(fVar.f75667e)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, fVar.f75667e.toLowerCase());
        }
        if (!TextUtils.isEmpty(opFeaturedModel.name)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75010e, opFeaturedModel.name.toLowerCase());
        }
        if (com.paytm.utility.b.r(context)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(context));
        }
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, "entertainment");
        cVar.sendCustomEventWithMap(str, hashMap, context);
    }
}
