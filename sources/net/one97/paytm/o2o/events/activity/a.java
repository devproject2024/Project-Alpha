package net.one97.paytm.o2o.events.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.common.entity.events.CJREventCancellationProtectDetail;
import net.one97.paytm.common.entity.events.CJREventsConvenienceFee;
import net.one97.paytm.common.entity.events.CJREventsPricesModel;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.o2o.events.R;
import net.one97.paytm.o2o.events.d.a.b.c;
import net.one97.paytm.o2o.events.fragment.booksummary.EventOrderSummaryPriceView;

public class a extends h implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private View f73717a;

    /* renamed from: b  reason: collision with root package name */
    private EventOrderSummaryPriceView f73718b;

    /* renamed from: c  reason: collision with root package name */
    private CJREventsPricesModel f73719c;

    /* renamed from: d  reason: collision with root package name */
    private String f73720d;

    /* renamed from: e  reason: collision with root package name */
    private String f73721e;

    /* renamed from: f  reason: collision with root package name */
    private CJREventCancellationProtectDetail f73722f;

    /* renamed from: g  reason: collision with root package name */
    private String f73723g;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        try {
            if (R.layout.event_summary_payment_fragment == 0) {
                getActivity().getSupportFragmentManager().d();
                Toast.makeText(getContext(), "Come back and try again later", 0).show();
            } else {
                this.f73717a = layoutInflater.inflate(R.layout.event_summary_payment_fragment, (ViewGroup) null);
            }
        } catch (Exception unused) {
            getActivity().getSupportFragmentManager().d();
            Toast.makeText(getContext(), "Come back and try again later", 0).show();
        }
        View view = this.f73717a;
        if (view != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.id_scroll_base_ll);
            Bundle arguments = getArguments();
            this.f73719c = (CJREventsPricesModel) arguments.getSerializable("price_model");
            this.f73721e = arguments.getString(PayUtility.PROMO_CODE);
            this.f73720d = arguments.getString("promo_text");
            this.f73723g = arguments.getString("order_id");
            if (arguments.containsKey("cancellation_detail")) {
                this.f73722f = (CJREventCancellationProtectDetail) arguments.getSerializable("cancellation_detail");
            }
            this.f73718b = EventOrderSummaryPriceView.a(getActivity(), this, this.f73723g);
            this.f73718b.setHideButtons();
            linearLayout.addView(this.f73718b, 0);
            CJREventsConvenienceFee cJREventsConvenienceFee = new CJREventsConvenienceFee();
            cJREventsConvenienceFee.setPrices(this.f73719c);
            EventOrderSummaryPriceView eventOrderSummaryPriceView = this.f73718b;
            eventOrderSummaryPriceView.f73773c = cJREventsConvenienceFee;
            RoboTextView roboTextView = eventOrderSummaryPriceView.f73774d;
            roboTextView.setText(eventOrderSummaryPriceView.f73771a.getString(R.string.paytm_booking_id) + ": " + eventOrderSummaryPriceView.f73772b);
            eventOrderSummaryPriceView.a(cJREventsConvenienceFee);
            CJREventCancellationProtectDetail cJREventCancellationProtectDetail = this.f73722f;
            if (cJREventCancellationProtectDetail != null) {
                this.f73718b.a(cJREventCancellationProtectDetail);
            }
            ((LinearLayout.LayoutParams) ((TextView) this.f73718b.findViewById(R.id.id_event_paytment_summary_title)).getLayoutParams()).setMargins(0, (int) ((getActivity().getResources().getDisplayMetrics().density * 5.0f) + 0.5f), 0, 0);
            View view2 = this.f73717a;
            TextView textView = (TextView) view2.findViewById(R.id.movie_promo_text);
            textView.setTextSize(12.0f);
            TextView textView2 = (TextView) view2.findViewById(R.id.movie_promo_code_badge_text);
            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.movie_promo_lyt);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.success_movie_promo_lyt);
            if (TextUtils.isEmpty(this.f73720d) || TextUtils.isEmpty(this.f73720d.trim()) || (str = this.f73721e) == null || TextUtils.isEmpty(str)) {
                relativeLayout.setVisibility(8);
                linearLayout2.setVisibility(8);
            } else {
                textView2.setText(this.f73721e);
                textView.setText(this.f73720d);
                relativeLayout.setVisibility(0);
                linearLayout2.setVisibility(0);
            }
            this.f73717a.findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.a(view);
                }
            });
        } else {
            getActivity().getSupportFragmentManager().d();
            Toast.makeText(getContext(), "Come back and try again late", 0).show();
        }
        return this.f73717a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().getSupportFragmentManager().d();
    }
}
