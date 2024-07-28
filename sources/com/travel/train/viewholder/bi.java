package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainPromotionalBanner;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import net.one97.paytm.common.entity.IJRDataModel;

public final class bi extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f27978a;

    /* renamed from: b  reason: collision with root package name */
    ProgressBar f27979b;

    /* renamed from: c  reason: collision with root package name */
    CJRTrainPromotionalBanner f27980c;

    /* renamed from: d  reason: collision with root package name */
    ab f27981d;

    /* renamed from: e  reason: collision with root package name */
    private Context f27982e;

    /* renamed from: f  reason: collision with root package name */
    private View f27983f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f27984g;

    /* renamed from: h  reason: collision with root package name */
    private CJRTrainSummaryItem f27985h;

    /* renamed from: i  reason: collision with root package name */
    private String f27986i = "CJRTrainPromotionalBannersViewHolder";

    public bi(View view, ab abVar) {
        super(view);
        this.f27983f = view;
        this.f27978a = (RelativeLayout) this.f27983f.findViewById(R.id.rv_container);
        this.f27984g = (ImageView) this.f27983f.findViewById(R.id.iv_banner_image);
        this.f27979b = (ProgressBar) this.f27983f.findViewById(R.id.progress_bar);
        this.f27981d = abVar;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27982e = context;
        this.f27985h = (CJRTrainSummaryItem) iJRDataModel;
        this.f27980c = (CJRTrainPromotionalBanner) this.f27985h.getItem();
        CJRTrainPromotionalBanner cJRTrainPromotionalBanner = this.f27980c;
        if (cJRTrainPromotionalBanner != null) {
            if (!TextUtils.isEmpty(cJRTrainPromotionalBanner.getUrl())) {
                try {
                    if (URLUtil.isValidUrl(this.f27980c.getUrl())) {
                        this.f27979b.setVisibility(0);
                        b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f27982e);
                        a2.f43753a = this.f27980c.getUrl();
                        a2.a(this.f27984g, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
                            public final void onError(Exception exc) {
                                bi.this.f27979b.setVisibility(8);
                                bi.this.f27978a.setVisibility(8);
                            }

                            public final /* synthetic */ void onSuccess(Object obj, c cVar) {
                                bi.this.f27979b.setVisibility(8);
                            }
                        });
                    }
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
            this.f27978a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!TextUtils.isEmpty(bi.this.f27980c.getUrl())) {
                        bi.this.f27981d.a(bi.this.f27980c, ah.INTERNAL_PROMOTION_DEEPLINK_CLICK);
                    }
                }
            });
        }
    }
}
