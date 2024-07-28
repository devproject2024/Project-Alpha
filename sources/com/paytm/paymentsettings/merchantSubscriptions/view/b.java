package com.paytm.paymentsettings.merchantSubscriptions.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.common.widget.CircularImageView;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem;
import com.paytm.utility.RoboTextView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;

final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<ActiveSubscriptionDetailsItem> f43481a;

    /* renamed from: b  reason: collision with root package name */
    private Context f43482b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        a aVar = (a) vVar;
        aVar.f43483a.setText(this.f43481a.get(i2).getMerchantName());
        ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem = this.f43481a.get(i2);
        aVar.f43484b.setText(this.f43482b.getResources().getString(R.string.id, new Object[]{this.f43481a.get(i2).getSubscriptionId()}));
        if (activeSubscriptionDetailsItem != null) {
            String T = com.paytm.utility.b.T(this.f43481a.get(i2).getSubscriptionAmount());
            String nextRenewalDate = this.f43481a.get(i2).getNextRenewalDate();
            if (!TextUtils.isEmpty(nextRenewalDate)) {
                String b2 = com.paytm.utility.b.b(nextRenewalDate, this.f43482b.getString(R.string.date_output_format_details), this.f43482b.getString(R.string.date_output_format));
                if (activeSubscriptionDetailsItem.getSubscriptionAmountType().equals("VARIABLE")) {
                    str = this.f43482b.getResources().getString(R.string.subscription_payment_date_upto, new Object[]{T, b2});
                } else {
                    str = this.f43482b.getResources().getString(R.string.subscription_payment_date, new Object[]{T, b2});
                }
                aVar.f43485c.setText(str);
            } else {
                aVar.f43485c.setText(this.f43482b.getResources().getString(R.string.subscription_payment) + " " + this.f43482b.getResources().getString(R.string.rupees) + com.paytm.utility.b.T(this.f43481a.get(i2).getSubscriptionAmount()));
            }
            if (URLUtil.isValidUrl(this.f43481a.get(i2).getMerchantLogo()) && this.f43481a.get(i2).getMerchantLogo() != null) {
                aVar.f43486d.setVisibility(0);
                w.a().a(this.f43481a.get(i2).getMerchantLogo()).a(this.f43482b.getResources().getDrawable(R.drawable.profile_logout)).a((ImageView) aVar.f43486d, (e) null);
            }
        }
    }

    public b(List<ActiveSubscriptionDetailsItem> list, Context context) {
        this.f43481a = list;
        this.f43482b = context;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f43483a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f43484b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f43485c;

        /* renamed from: d  reason: collision with root package name */
        CircularImageView f43486d;

        a(View view) {
            super(view);
            this.f43483a = (RoboTextView) view.findViewById(R.id.tv_merchant_title);
            this.f43484b = (RoboTextView) view.findViewById(R.id.tv_merchant_subscription_id);
            this.f43485c = (RoboTextView) view.findViewById(R.id.tv_merchant_payment_status);
            this.f43486d = (CircularImageView) view.findViewById(R.id.iv_merchant_logo_dummy);
        }
    }

    public final int getItemCount() {
        List<ActiveSubscriptionDetailsItem> list = this.f43481a;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.f43481a.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_active_subscription_item, viewGroup, false));
    }
}
