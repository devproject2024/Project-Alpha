package net.one97.paytm.o2o.movies.one_pager.holders;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.one_pager.c;
import net.one97.paytm.o2o.movies.one_pager.e;

public final class e extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f75693a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75694b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f75695c;

    public e(View view) {
        super(view);
        this.f75693a = (TextView) view.findViewById(R.id.titleTv);
        this.f75694b = (TextView) view.findViewById(R.id.subtitleTv);
        this.f75695c = (LinearLayout) view.findViewById(R.id.backgroundLL);
    }

    public final void a(Context context, net.one97.paytm.o2o.movies.one_pager.e eVar, c.a aVar) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.f75660b)) {
                this.f75693a.setText(eVar.f75660b.toUpperCase());
            }
            this.f75694b.setText(eVar.f75661c);
            this.f75695c.setOnClickListener(new View.OnClickListener(aVar, eVar, context) {
                private final /* synthetic */ c.a f$1;
                private final /* synthetic */ e f$2;
                private final /* synthetic */ Context f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    e.this.a(this.f$1, this.f$2, this.f$3, view);
                }
            });
            if (eVar.f75662d) {
                this.f75695c.setBackground(context.getResources().getDrawable(R.drawable.shape_rectangle_blue_bg_rounded_corners));
                this.f75693a.setTextColor(context.getResources().getColor(R.color.white));
                this.f75694b.setTextColor(context.getResources().getColor(R.color.white));
                this.f75693a.setAlpha(0.7f);
                return;
            }
            this.f75695c.setBackground(context.getResources().getDrawable(R.drawable.shape_rectangle_round_edges_grey_border));
            this.f75693a.setTextColor(context.getResources().getColor(R.color.paytm_blue));
            this.f75693a.setAlpha(1.0f);
            this.f75694b.setTextColor(context.getResources().getColor(R.color.metalic_blue));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(c.a aVar, net.one97.paytm.o2o.movies.one_pager.e eVar, Context context, View view) {
        aVar.a(eVar.f75659a);
        if (!eVar.f75662d) {
            net.one97.paytm.o2o.movies.common.c.c cVar = b.f75032a.f75033b;
            String str = net.one97.paytm.o2o.movies.common.b.b.f75006a;
            String str2 = eVar.f75660b;
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/entertainment");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, "entertainment");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "date_selected");
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str2.toLowerCase());
            }
            if (com.paytm.utility.b.r(context)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(context));
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, "entertainment");
            cVar.sendCustomEventWithMap(str, hashMap, context);
        }
    }
}
