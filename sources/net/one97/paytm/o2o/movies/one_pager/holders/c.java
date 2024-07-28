package net.one97.paytm.o2o.movies.one_pager.holders;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.g;
import net.one97.paytm.o2o.movies.one_pager.OpBrowseCategory;
import net.one97.paytm.o2o.movies.utils.n;

public final class c extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f75685a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75686b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f75687c;

    public c(View view) {
        super(view);
        this.f75685a = (ImageView) view.findViewById(R.id.featured_image);
        this.f75687c = (LinearLayout) view.findViewById(R.id.featuredImgLl);
        this.f75686b = (TextView) view.findViewById(R.id.categoryNameTv);
    }

    public final void a(Context context, OpBrowseCategory opBrowseCategory) {
        if (opBrowseCategory != null) {
            if (opBrowseCategory.drawableId != 0) {
                g.a();
                int i2 = opBrowseCategory.drawableId;
                w.a().a(i2).a(this.f75685a, (e) null);
            }
            if (!TextUtils.isEmpty(opBrowseCategory.deeplink)) {
                this.f75687c.setOnClickListener(new View.OnClickListener(opBrowseCategory, context) {
                    private final /* synthetic */ OpBrowseCategory f$1;
                    private final /* synthetic */ Context f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        c.this.a(this.f$1, this.f$2, view);
                    }
                });
            }
            n.a(this.f75686b, opBrowseCategory.displayName);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(OpBrowseCategory opBrowseCategory, Context context, View view) {
        b.f75032a.f75033b.launchDeeplink(opBrowseCategory.deeplink, context, (String) null);
        net.one97.paytm.o2o.movies.common.c.c cVar = b.f75032a.f75033b;
        String str = net.one97.paytm.o2o.movies.common.b.b.f75006a;
        String str2 = opBrowseCategory.displayName;
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/entertainment");
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, "entertainment");
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "genre_icon_clicked");
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str2);
        }
        if (com.paytm.utility.b.r(context)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(context));
        }
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, "entertainment");
        cVar.sendCustomEventWithMap(str, hashMap, context);
    }
}
