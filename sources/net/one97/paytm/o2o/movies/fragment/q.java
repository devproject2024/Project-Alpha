package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieICancelProtectModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodBeveragesResponse;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodData;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodVoucherItem;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem;
import net.one97.paytm.o2o.movies.utils.CJRMoviePaymentSummaryItem;
import net.one97.paytm.o2o.movies.utils.m;
import net.one97.paytm.o2o.movies.utils.n;

public class q extends b {

    /* renamed from: a  reason: collision with root package name */
    private View f75421a;

    /* renamed from: b  reason: collision with root package name */
    private Context f75422b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f75423c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f75424d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f75425e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f75426f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f75427g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f75428h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f75429i;
    private TextView j;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f75421a = layoutInflater.inflate(R.layout.movie_summary_payment_fragment, (ViewGroup) null);
        View view = this.f75421a;
        this.f75427g = (LinearLayout) view.findViewById(R.id.paymentItemsLl);
        this.f75423c = (TextView) view.findViewById(R.id.movie_promo_text);
        this.f75423c.setTextSize(12.0f);
        this.f75424d = (TextView) view.findViewById(R.id.movie_promo_code_badge_text);
        this.f75425e = (RelativeLayout) view.findViewById(R.id.success_movie_promo_lyt);
        this.f75426f = (LinearLayout) view.findViewById(R.id.movie_promo_lyt);
        this.f75428h = (RoboTextView) view.findViewById(R.id.id_movie_payment_order_id);
        this.f75429i = (TextView) view.findViewById(R.id.totalValueTv);
        this.j = (TextView) view.findViewById(R.id.paymentMethodValue);
        ((ImageView) view.findViewById(R.id.back_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                q.this.a(view);
            }
        });
        this.f75422b = getActivity();
        CJRSummaryMoviePaymentItem cJRSummaryMoviePaymentItem = (CJRSummaryMoviePaymentItem) getArguments().getSerializable("payment_data");
        Context context = getContext();
        if (cJRSummaryMoviePaymentItem != null) {
            String orderId = cJRSummaryMoviePaymentItem.getOrderId();
            if (!TextUtils.isEmpty(orderId)) {
                this.f75428h.setVisibility(0);
                this.f75428h.setText(getContext().getResources().getString(R.string.paytm_order_id) + " : " + orderId);
            }
            CJROrderSummaryMetadataResponseV2 metaDataResponse = cJRSummaryMoviePaymentItem.getMetaDataResponse();
            if (metaDataResponse != null) {
                if (metaDataResponse.getTicketCount() != 0) {
                    int ticketCount = metaDataResponse.getTicketCount();
                    double totalTicketPrice = metaDataResponse.getTotalTicketPrice() / ((double) ticketCount);
                    String string = this.f75422b.getResources().getString(ticketCount == 1 ? R.string.ticket : R.string.tickets);
                    this.f75427g.addView(a(context, "Tickets Subtotal", (String) null, true));
                    LinearLayout linearLayout = this.f75427g;
                    linearLayout.addView(a(context, ticketCount + " " + string + " @ " + n.b(Double.valueOf(totalTicketPrice)) + " each", n.a(Double.valueOf(metaDataResponse.getTotalTicketPrice())), false));
                }
                CJRMovieICancelProtectModel insurance = metaDataResponse.getInsurance();
                if (metaDataResponse.getIsInsurancePresentV2() == 1 && insurance != null) {
                    this.f75427g.addView(a(context, "Additional Charges", (String) null, true));
                    this.f75427g.addView(a(context, "Cancellation Protect Charges", n.a(Double.valueOf((double) insurance.getTotalInsurancePrice().floatValue())), false));
                }
            }
            if (!TextUtils.isEmpty(cJRSummaryMoviePaymentItem.getmTotal3Dprice())) {
                if (!(metaDataResponse == null || metaDataResponse.getIsInsurancePresentV2() == 1) || metaDataResponse.getInsurance() == null) {
                    this.f75427g.addView(a(context, "Additional Charges", (String) null, true));
                }
                this.f75427g.addView(a(context, "3D glasses", n.a(Double.valueOf(cJRSummaryMoviePaymentItem.getmTotal3Dprice())), false));
            }
            a(context, cJRSummaryMoviePaymentItem);
            b(context, cJRSummaryMoviePaymentItem);
            a(context, m.a(cJRSummaryMoviePaymentItem.getMetaDataObject()));
            if (cJRSummaryMoviePaymentItem.getDiscountAmount() != 0.0d) {
                this.f75427g.addView(a(context, "Discount", (String) null, true));
                LinearLayout linearLayout2 = this.f75427g;
                linearLayout2.addView(a(context, "Discount by Promocode", "- " + n.a(Double.valueOf(cJRSummaryMoviePaymentItem.getDiscountAmount())), false));
            }
            this.f75429i.setText(n.a(Double.valueOf(cJRSummaryMoviePaymentItem.getGrandTotal())));
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < cJRSummaryMoviePaymentItem.getPaymentInfo().size(); i2++) {
                String paymentMethod = cJRSummaryMoviePaymentItem.getPaymentInfo().get(i2).getPaymentMethod();
                if (!d.b(paymentMethod)) {
                    arrayList.add(paymentMethod);
                }
            }
            this.j.setText(TextUtils.join(AppConstants.COMMA, arrayList));
            String promoText = cJRSummaryMoviePaymentItem.getPromoText();
            String promoCode = cJRSummaryMoviePaymentItem.getPromoCode();
            if (TextUtils.isEmpty(promoText) || TextUtils.isEmpty(promoText.trim()) || promoCode == null || TextUtils.isEmpty(promoCode)) {
                this.f75425e.setVisibility(8);
                this.f75426f.setVisibility(8);
            } else {
                this.f75424d.setText(promoCode);
                this.f75423c.setText(promoText);
                this.f75425e.setVisibility(0);
                this.f75426f.setVisibility(0);
            }
        }
        return this.f75421a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().getSupportFragmentManager().d();
    }

    private static CJRMoviePaymentSummaryItem a(Context context, String str, String str2, boolean z) {
        CJRMoviePaymentSummaryItem cJRMoviePaymentSummaryItem = new CJRMoviePaymentSummaryItem(context, z);
        cJRMoviePaymentSummaryItem.setData(str, str2);
        return cJRMoviePaymentSummaryItem;
    }

    private void a(Context context, CJRSummaryMoviePaymentItem cJRSummaryMoviePaymentItem) {
        CJRSummaryFoodBeveragesResponse foodBeveragesResponse = cJRSummaryMoviePaymentItem.getFoodBeveragesResponse();
        if (foodBeveragesResponse == null && cJRSummaryMoviePaymentItem.getMetaDataResponse().getFoodAndBeverages() != null) {
            foodBeveragesResponse = cJRSummaryMoviePaymentItem.getMetaDataResponse().getFoodAndBeverages();
        }
        if (foodBeveragesResponse != null && !d.a((List) foodBeveragesResponse.getData())) {
            this.f75427g.addView(a(context, "Food & Beverages", (String) null, true));
            for (CJRSummaryFoodData next : foodBeveragesResponse.getData()) {
                Double valueOf = Double.valueOf(Double.valueOf(next.getTotalChargedPrice()).doubleValue() / ((double) next.getQuantity()));
                LinearLayout linearLayout = this.f75427g;
                linearLayout.addView(a(context, next.getQuantity() + " " + next.getItemName() + " @ " + n.b(valueOf) + " each", n.a(Double.valueOf(next.getTotalChargedPrice())), false));
            }
        }
    }

    private void b(Context context, CJRSummaryMoviePaymentItem cJRSummaryMoviePaymentItem) {
        List<CJRFoodVoucherItem> allFoodVoucher = cJRSummaryMoviePaymentItem.getAllFoodVoucher();
        if (allFoodVoucher != null && allFoodVoucher.size() > 0) {
            this.f75427g.addView(a(context, "Food Vouchers", (String) null, true));
            for (CJRFoodVoucherItem next : allFoodVoucher) {
                Double valueOf = Double.valueOf(Double.parseDouble(next.getUnitPrice()));
                LinearLayout linearLayout = this.f75427g;
                linearLayout.addView(a(context, next.getQuantity() + " " + next.getVoucherName() + " @ " + n.b(valueOf) + " each", n.a(Double.valueOf(next.getTotalChargedPrice())), false));
            }
        }
    }

    private void a(Context context, ArrayList<CJRTaxInfo> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f75427g.addView(a(context, "Fee & Taxes", (String) null, true));
            Iterator<CJRTaxInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRTaxInfo next = it2.next();
                if (!"Booking Charge".equalsIgnoreCase(next.getLabel()) || Double.valueOf(next.getValue()).doubleValue() != 0.0d) {
                    this.f75427g.addView(a(context, next.getLabel(), n.a(Double.valueOf(next.getValue())), false));
                }
            }
        }
    }
}
