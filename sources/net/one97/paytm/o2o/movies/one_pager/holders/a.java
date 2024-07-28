package net.one97.paytm.o2o.movies.one_pager.holders;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.c.c;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.one_pager.OpFeaturedModel;
import net.one97.paytm.o2o.movies.one_pager.f;
import net.one97.paytm.o2o.movies.utils.n;

public final class a extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f75680a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75681b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75682c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75683d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75684e;

    public a(View view) {
        super(view);
        this.f75680a = (ImageView) view.findViewById(R.id.featured_image);
        this.f75682c = (TextView) view.findViewById(R.id.showCostTv);
        this.f75683d = (TextView) view.findViewById(R.id.showNameTv);
        this.f75684e = (TextView) view.findViewById(R.id.showTypeTv);
        this.f75681b = (TextView) view.findViewById(R.id.showLocationTv);
    }

    public final void a(Context context, OpFeaturedModel opFeaturedModel, int i2, f fVar) {
        if (opFeaturedModel != null) {
            if (!TextUtils.isEmpty(opFeaturedModel.vertical_cover_image)) {
                Drawable drawable = context.getResources().getDrawable(R.drawable.ic_movie_portrait_placeholder);
                t.a(b.f75032a.f75033b.getPicassoIsInMemory());
                t.a(opFeaturedModel.vertical_cover_image, 30, drawable, drawable, this.f75680a, true);
            }
            n.a(this.f75683d, opFeaturedModel.name);
            if (opFeaturedModel.category_id != null) {
                n.b(this.f75684e, opFeaturedModel.category_id.name);
                this.f75684e.setTextColor(Color.parseColor(d.f75112a.get(Integer.valueOf(i2 % 5))));
            }
            n.a(this.f75681b, opFeaturedModel.venue_name);
            n.a(this.f75682c, d.a(opFeaturedModel.price_display_string, context));
            if (!TextUtils.isEmpty(opFeaturedModel.deeplink)) {
                this.f75680a.setOnClickListener(new View.OnClickListener(opFeaturedModel, context, fVar) {
                    private final /* synthetic */ OpFeaturedModel f$1;
                    private final /* synthetic */ Context f$2;
                    private final /* synthetic */ f f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onClick(View view) {
                        a.this.a(this.f$1, this.f$2, this.f$3, view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(OpFeaturedModel opFeaturedModel, Context context, f fVar, View view) {
        c.getInstance().launchDeeplink(opFeaturedModel.deeplink, context, (String) null);
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
