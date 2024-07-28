package com.travel.bus.busticket.a;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.n;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.CJRBusCancellationPolicy;
import java.util.ArrayList;

public final class k extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRBusCancellationPolicy> f21673a;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        CJRBusCancellationPolicy cJRBusCancellationPolicy = this.f21673a.get(i2);
        if (cJRBusCancellationPolicy != null) {
            aVar.f21674a.setText("");
            aVar.f21676c.setText("");
            if (cJRBusCancellationPolicy.getPolicyText() != null) {
                String policyText = cJRBusCancellationPolicy.getPolicyText();
                if (i2 == 0) {
                    aVar.f21674a.setText(Html.fromHtml(policyText));
                    aVar.f21674a.setTextSize(15.0f);
                } else {
                    aVar.f21674a.setText(Html.fromHtml(policyText));
                    aVar.f21674a.setTextColor(R.color.color_666666);
                    aVar.f21674a.setTextSize(13.0f);
                }
            }
            if (cJRBusCancellationPolicy.getCancellationTime() != null) {
                String cancellationTime = cJRBusCancellationPolicy.getCancellationTime();
                if (i2 == 0) {
                    aVar.f21674a.setText(Html.fromHtml(cancellationTime));
                    aVar.f21674a.setTextSize(15.0f);
                } else {
                    aVar.f21674a.setText(Html.fromHtml(cancellationTime));
                    aVar.f21674a.setTextColor(R.color.color_666666);
                    aVar.f21674a.setTextSize(13.0f);
                }
            }
            if (cJRBusCancellationPolicy.getRefundPercentage() != null) {
                String refundPercentage = cJRBusCancellationPolicy.getRefundPercentage();
                if (i2 == 0) {
                    aVar.f21676c.setText(Html.fromHtml(refundPercentage));
                    if (n.a().equalsIgnoreCase("ml")) {
                        aVar.f21676c.setTextSize(15.0f);
                    }
                } else {
                    aVar.f21676c.setText(Html.fromHtml(refundPercentage));
                    aVar.f21676c.setTextColor(R.color.color_666666);
                    aVar.f21676c.setTextSize(13.0f);
                }
            }
            if (cJRBusCancellationPolicy.getRefundAmount() != null) {
                String refundAmount = cJRBusCancellationPolicy.getRefundAmount();
                aVar.f21675b.setVisibility(0);
                if (i2 == 0) {
                    aVar.f21675b.setText(Html.fromHtml(refundAmount));
                    if (n.a().equalsIgnoreCase("ml")) {
                        aVar.f21675b.setTextSize(15.0f);
                        return;
                    }
                    return;
                }
                aVar.f21675b.setText(Html.fromHtml(refundAmount));
                aVar.f21675b.setTextColor(R.color.color_666666);
                aVar.f21675b.setTextSize(13.0f);
            }
        }
    }

    public k(ArrayList<CJRBusCancellationPolicy> arrayList) {
        this.f21673a = arrayList;
    }

    public final int getItemCount() {
        ArrayList<CJRBusCancellationPolicy> arrayList = this.f21673a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f21674a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f21675b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f21676c;

        public a(View view) {
            super(view);
            this.f21674a = (RoboTextView) view.findViewById(R.id.hours_before_departure);
            this.f21675b = (RoboTextView) view.findViewById(R.id.refund_amnt);
            this.f21676c = (RoboTextView) view.findViewById(R.id.refund_percentage);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_cancellation_item, viewGroup, false));
    }
}
