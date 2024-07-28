package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryStatus;
import com.travel.train.model.trainticket.CJRTrainPromoInfoStatusAction;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import com.travel.train.viewholder.be;
import com.travel.utils.n;
import net.one97.paytm.common.entity.IJRDataModel;

public final class be extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    ab f27947a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f27948b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27949c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final int f27950d = 2;

    /* renamed from: e  reason: collision with root package name */
    private final int f27951e = 5;

    /* renamed from: f  reason: collision with root package name */
    private final int f27952f = 6;

    /* renamed from: g  reason: collision with root package name */
    private final int f27953g = 7;

    /* renamed from: h  reason: collision with root package name */
    private final int f27954h = 8;

    /* renamed from: i  reason: collision with root package name */
    private final int f27955i = 9;
    private final int j = 17;
    private final int k = 18;
    private final int l = 19;
    private Context m;
    private final int n = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
    private CJRTrainOrderSummaryStatus o;
    private LinearLayout p;
    private TextView q;
    private TextView r;
    private LinearLayout s;

    public be(View view, ab abVar) {
        super(view);
        this.f27947a = abVar;
        this.p = (LinearLayout) view;
        this.f27948b = (ImageView) view.findViewById(R.id.status_image_view);
        this.q = (TextView) view.findViewById(R.id.booking_confirmation_text);
        this.r = (TextView) view.findViewById(R.id.booking_confirmation_text_desc);
        this.s = (LinearLayout) view.findViewById(R.id.lv_action_container);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.m = context;
        this.o = (CJRTrainOrderSummaryStatus) ((CJRTrainSummaryItem) iJRDataModel).getItem();
        String statusIcon = this.o.getStatusIcon();
        if (statusIcon == null || !URLUtil.isValidUrl(statusIcon)) {
            a();
        } else {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this.m);
            a2.f43753a = statusIcon;
            a2.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
                public final /* synthetic */ void onSuccess(Object obj, c cVar) {
                    be.this.f27948b.setImageDrawable((Drawable) obj);
                }

                public final void onError(Exception exc) {
                    be.this.a();
                }
            });
        }
        this.q.setText(this.o.getStatusText());
        this.r.setText(this.o.getStatusDescription());
        this.s.removeAllViews();
        if (this.o.getStatusActions() == null || this.o.getStatusActions().size() <= 0) {
            this.s.setVisibility(8);
            return;
        }
        for (int i3 = 0; i3 < this.o.getStatusActions().size(); i3++) {
            final CJRTrainPromoInfoStatusAction cJRTrainPromoInfoStatusAction = this.o.getStatusActions().get(i3);
            if (cJRTrainPromoInfoStatusAction != null && !TextUtils.isEmpty(cJRTrainPromoInfoStatusAction.getLabel())) {
                this.s.setVisibility(0);
                final TextView textView = (TextView) LayoutInflater.from(this.s.getContext()).inflate(R.layout.pre_t_train_order_header_action_layout, this.s, false);
                textView.setText(cJRTrainPromoInfoStatusAction.getLabel());
                this.s.addView(textView);
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        textView.setEnabled(false);
                        textView.setClickable(false);
                        be.this.f27947a.a(cJRTrainPromoInfoStatusAction, ah.ORDER_STATUS_TEXT_ACTION);
                        new Handler().postDelayed(new Runnable(textView) {
                            private final /* synthetic */ TextView f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final void run() {
                                be.AnonymousClass2.a(this.f$0);
                            }
                        }, 2000);
                    }

                    /* access modifiers changed from: private */
                    public static /* synthetic */ void a(TextView textView) {
                        if (textView != null) {
                            try {
                                textView.setEnabled(true);
                                textView.setClickable(true);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.o.getStatus() == 7) {
            ResourceUtils.loadTrainImagesFromCDN(this.f27948b, "success.png", false, true, n.a.V1);
        } else if (this.o.getStatus() == 5 || this.o.getStatus() == 1) {
            this.f27948b.setImageDrawable(androidx.core.content.b.a(this.itemView.getContext(), R.drawable.pre_t_rnr_error));
        } else {
            ResourceUtils.loadTrainImagesFromCDN(this.f27948b, "ic_failed.png", false, false, n.a.V1);
        }
    }
}
