package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRFastForward;
import java.util.HashMap;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class e extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private Context f28078a;

    /* renamed from: b  reason: collision with root package name */
    private com.travel.train.i.e f28079b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f28080c;

    /* renamed from: d  reason: collision with root package name */
    private View f28081d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f28082e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f28083f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f28084g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f28085h;

    public e(View view, com.travel.train.i.e eVar) {
        super(view);
        this.f28078a = view.getContext();
        this.f28079b = eVar;
        this.f28081d = view.findViewById(R.id.fast_forward_view);
        this.f28081d.setVisibility(8);
        this.f28082e = (CheckBox) view.findViewById(R.id.fast_forward_checkbox);
        this.f28080c = (RelativeLayout) view.findViewById(R.id.ff_msg_title_container);
        this.f28083f = (RoboTextView) view.findViewById(R.id.ff_forward_title_view);
        this.f28084g = (RelativeLayout) view.findViewById(R.id.ff_message_view);
        this.f28085h = (RoboTextView) view.findViewById(R.id.ff_message_text);
        this.f28082e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                e.this.a(compoundButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put(d.dc, H5AppHandler.CHECK_VALUE);
        } else {
            hashMap.put(d.dc, CommonPayParams.Builder.NO);
        }
        o.a("train_review_itinerary", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "fast_forward_checked", "/trains/review-itinerary", this.f28078a, hashMap);
        if (z) {
            this.f28079b.a(this.f28078a.getResources().getString(R.string.train_itinerary_proceed_btn));
        } else {
            this.f28079b.a(this.f28078a.getResources().getString(R.string.train_itinerary_proceed_btn));
            if (!(this.f28079b.d() == null || this.f28079b.d().getmConfirmation() == null || this.f28079b.d().getmConfirmation().getPaymentTipMessage() == null || this.f28079b.d().getmConfirmation().getPaymentTipMessage().trim().length() == 0)) {
                this.f28079b.a(0);
                return;
            }
        }
        this.f28079b.a(8);
    }

    public final void a(CJRFastForward cJRFastForward) {
        if (cJRFastForward != null && cJRFastForward.isEnabled()) {
            this.f28081d.setVisibility(0);
            String checkBoxText = cJRFastForward.getCheckBoxText();
            if (checkBoxText != null && !TextUtils.isEmpty(checkBoxText.trim())) {
                this.f28080c.setVisibility(0);
                this.f28083f.setText(checkBoxText);
            }
            this.f28082e.setChecked(cJRFastForward.isDefaultChecked());
            String tip = cJRFastForward.getTip();
            if (tip != null && !TextUtils.isEmpty(tip.trim())) {
                this.f28084g.setVisibility(0);
                this.f28085h.setText(tip);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004c, code lost:
        r0 = r1.f28082e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r1 = this;
            com.travel.train.i.e r0 = r1.f28079b
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r0.d()
            if (r0 == 0) goto L_0x0058
            com.travel.train.i.e r0 = r1.f28079b
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r0.d()
            com.travel.train.model.trainticket.CJRTrainConfirmation r0 = r0.getmConfirmation()
            if (r0 == 0) goto L_0x0058
            com.travel.train.i.e r0 = r1.f28079b
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r0.d()
            com.travel.train.model.trainticket.CJRTrainConfirmation r0 = r0.getmConfirmation()
            com.travel.train.model.trainticket.CJRFastForward r0 = r0.getFastForward()
            if (r0 == 0) goto L_0x0058
            com.travel.train.i.e r0 = r1.f28079b
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r0.d()
            com.travel.train.model.trainticket.CJRTrainConfirmation r0 = r0.getmConfirmation()
            com.travel.train.model.trainticket.CJRFastForward r0 = r0.getFastForward()
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x0058
            com.travel.train.i.e r0 = r1.f28079b
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r0.d()
            com.travel.train.model.trainticket.CJRTrainConfirmation r0 = r0.getmConfirmation()
            com.travel.train.model.trainticket.CJRFastForward r0 = r0.getFastForward()
            boolean r0 = r0.isDefaultChecked()
            if (r0 == 0) goto L_0x0058
            android.widget.CheckBox r0 = r1.f28082e
            if (r0 == 0) goto L_0x0058
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L_0x0058
            r0 = 1
            return r0
        L_0x0058:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.viewholder.e.a():boolean");
    }
}
