package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;

public final class k extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private Context f28147a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f28148b;

    public k(View view) {
        super(view);
        this.f28147a = view.getContext();
        this.f28148b = (LinearLayout) view.findViewById(R.id.promo_container);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.train.model.trainticket.CJRTrainBooking r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x00b7
            com.travel.train.model.trainticket.CJRTrainConfirmation r1 = r6.getmConfirmation()
            if (r1 == 0) goto L_0x00b7
            com.travel.train.model.trainticket.CJRTrainConfirmation r1 = r6.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainPromoMessageModel r1 = r1.getPromoMessageModel()
            if (r1 == 0) goto L_0x00b7
            com.travel.train.model.trainticket.CJRTrainConfirmation r1 = r6.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainPromoMessageModel r1 = r1.getPromoMessageModel()
            java.util.ArrayList r1 = r1.getPromoMessages()
            if (r1 == 0) goto L_0x00b7
            com.travel.train.model.trainticket.CJRTrainConfirmation r1 = r6.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainPromoMessageModel r1 = r1.getPromoMessageModel()
            java.util.ArrayList r1 = r1.getPromoMessages()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00b7
            com.travel.train.model.trainticket.CJRTrainConfirmation r6 = r6.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainPromoMessageModel r6 = r6.getPromoMessageModel()
            java.util.ArrayList r6 = r6.getPromoMessages()
            r1 = 0
        L_0x0040:
            int r2 = r6.size()
            if (r1 >= r2) goto L_0x0061
            java.lang.Object r2 = r6.get(r1)
            com.travel.train.model.trainticket.CJRTrainPromoMessage r2 = (com.travel.train.model.trainticket.CJRTrainPromoMessage) r2
            java.lang.String r3 = r2.getType()
            java.lang.String r4 = "text"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x005e
            java.lang.String r6 = r2.getMessage()
            goto L_0x0063
        L_0x005e:
            int r1 = r1 + 1
            goto L_0x0040
        L_0x0061:
            java.lang.String r6 = ""
        L_0x0063:
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x00b7
            android.widget.LinearLayout r1 = r5.f28148b
            int r2 = com.travel.train.R.id.tv_promo_text
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.widget.LinearLayout r2 = r5.f28148b
            android.content.Context r3 = r5.f28147a
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.travel.train.R.color.color_536e92
            int r3 = r3.getColor(r4)
            r2.setBackgroundColor(r3)
            android.content.Context r2 = r5.f28147a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.travel.train.R.color.color_ffffff
            int r2 = r2.getColor(r3)
            r1.setTextColor(r2)
            r2 = 1
            if (r1 == 0) goto L_0x009b
            r1.setText(r6)
            r6 = 1
            goto L_0x009c
        L_0x009b:
            r6 = 0
        L_0x009c:
            android.view.animation.TranslateAnimation r1 = new android.view.animation.TranslateAnimation
            r3 = 1109393408(0x42200000, float:40.0)
            r4 = 0
            r1.<init>(r4, r4, r3, r4)
            r3 = 200(0xc8, double:9.9E-322)
            r1.setDuration(r3)
            r1.setFillAfter(r2)
            android.widget.LinearLayout r2 = r5.f28148b
            r2.startAnimation(r1)
            android.widget.LinearLayout r1 = r5.f28148b
            r1.setVisibility(r0)
            goto L_0x00b8
        L_0x00b7:
            r6 = 0
        L_0x00b8:
            if (r6 != 0) goto L_0x00c1
            android.widget.LinearLayout r6 = r5.f28148b
            r0 = 8
            r6.setVisibility(r0)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.viewholder.k.a(com.travel.train.model.trainticket.CJRTrainBooking):void");
    }
}
