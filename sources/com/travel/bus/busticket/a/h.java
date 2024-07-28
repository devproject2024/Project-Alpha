package com.travel.bus.busticket.a;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.CJRBusCancellationPolicy;
import java.util.ArrayList;

public final class h extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRBusCancellationPolicy> f21657a;

    /* renamed from: b  reason: collision with root package name */
    private Context f21658b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        CJRBusCancellationPolicy cJRBusCancellationPolicy = this.f21657a.get(i2);
        if (cJRBusCancellationPolicy != null) {
            aVar.f21659a.setText("");
            aVar.f21661c.setText("");
            if (cJRBusCancellationPolicy.getPolicyText() != null) {
                String policyText = cJRBusCancellationPolicy.getPolicyText();
                if (i2 == 0) {
                    aVar.f21659a.setTextColor(b.c(this.f21658b, R.color.color_222222));
                    aVar.f21659a.setTextSize(2, 13.0f);
                    aVar.f21659a.setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    aVar.f21659a.setTextColor(b.c(this.f21658b, R.color.color_666666));
                    aVar.f21659a.setTextSize(2, 14.0f);
                    aVar.f21659a.setTypeface(Typeface.create("sans-serif-medium", 0));
                }
                aVar.f21659a.setText(Html.fromHtml(policyText));
            }
            if (cJRBusCancellationPolicy.getCancellationTime() != null) {
                String cancellationTime = cJRBusCancellationPolicy.getCancellationTime();
                if (i2 == 0) {
                    aVar.f21659a.setText(Html.fromHtml(cancellationTime));
                    aVar.f21659a.setTextColor(b.c(this.f21658b, R.color.color_222222));
                    aVar.f21659a.setTextSize(2, 13.0f);
                    aVar.f21659a.setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    aVar.f21659a.setText(Html.fromHtml(cancellationTime));
                    aVar.f21659a.setTextColor(b.c(this.f21658b, R.color.color_666666));
                    aVar.f21659a.setTypeface(Typeface.create("sans-serif-medium", 0));
                    aVar.f21659a.setTextSize(2, 14.0f);
                }
            }
            if (cJRBusCancellationPolicy.getRefundPercentage() != null) {
                String refundPercentage = cJRBusCancellationPolicy.getRefundPercentage();
                if (i2 == 0) {
                    aVar.f21661c.setText(Html.fromHtml(refundPercentage));
                    aVar.f21661c.setTextColor(b.c(this.f21658b, R.color.color_222222));
                    aVar.f21661c.setTextSize(2, 13.0f);
                    aVar.f21661c.setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    aVar.f21661c.setText(Html.fromHtml(refundPercentage));
                    aVar.f21661c.setTextColor(b.c(this.f21658b, R.color.color_666666));
                    aVar.f21661c.setTextSize(2, 14.0f);
                    aVar.f21661c.setTypeface(Typeface.create("sans-serif-medium", 0));
                }
            }
            if (cJRBusCancellationPolicy.getRefundAmount() != null) {
                String refundAmount = cJRBusCancellationPolicy.getRefundAmount();
                aVar.f21660b.setVisibility(0);
                if (i2 == 0) {
                    aVar.f21660b.setText(Html.fromHtml(refundAmount));
                    aVar.f21660b.setTextColor(b.c(this.f21658b, R.color.color_222222));
                    aVar.f21660b.setTextSize(2, 13.0f);
                    aVar.f21660b.setTypeface(Typeface.create("sans-serif", 0));
                    return;
                }
                aVar.f21660b.setText(Html.fromHtml(refundAmount));
                aVar.f21660b.setTextColor(b.c(this.f21658b, R.color.color_666666));
                aVar.f21660b.setTextSize(2, 14.0f);
                aVar.f21660b.setTypeface(Typeface.create("sans-serif-medium", 0));
            }
        }
    }

    public h(ArrayList<CJRBusCancellationPolicy> arrayList, Context context) {
        this.f21657a = arrayList;
        this.f21658b = context;
    }

    public final int getItemCount() {
        ArrayList<CJRBusCancellationPolicy> arrayList = this.f21657a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f21659a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f21660b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f21661c;

        a(View view) {
            super(view);
            this.f21659a = (RoboTextView) view.findViewById(R.id.hours_before_departure);
            this.f21660b = (RoboTextView) view.findViewById(R.id.refund_amnt);
            this.f21661c = (RoboTextView) view.findViewById(R.id.refund_percentage);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_cancellation_item_revamp, viewGroup, false));
    }
}
