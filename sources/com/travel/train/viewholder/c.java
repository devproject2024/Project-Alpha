package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.e;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainAddOn;
import com.travel.train.model.trainticket.CJRTrainConfirmation;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class c extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    Context f28062a;

    /* renamed from: b  reason: collision with root package name */
    e f28063b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f28064c;

    /* renamed from: d  reason: collision with root package name */
    String f28065d = "CJRIternaryAdditionalOffersViewHolder";

    public c(View view, e eVar) {
        super(view);
        this.f28062a = view.getContext();
        this.f28063b = eVar;
        this.f28064c = (LinearLayout) view.findViewById(R.id.additional_offer_container);
    }

    public final void a(final CJRTrainConfirmation cJRTrainConfirmation, final ArrayList<CJRTrainFareDetail> arrayList) {
        if (cJRTrainConfirmation == null || cJRTrainConfirmation.getmAddOns() == null || cJRTrainConfirmation.getmAddOns().size() <= 0) {
            this.f28064c.setVisibility(8);
            return;
        }
        this.f28064c.setVisibility(0);
        for (int i2 = 0; i2 < cJRTrainConfirmation.getmAddOns().size(); i2++) {
            final CJRTrainAddOn cJRTrainAddOn = cJRTrainConfirmation.getmAddOns().get(i2);
            if (cJRTrainAddOn != null && cJRTrainAddOn.getEnabled().booleanValue()) {
                View inflate = LayoutInflater.from(this.f28062a).inflate(R.layout.pre_t_trains_cancel_pro_layout, (ViewGroup) null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.cancel_insurance_checkbox);
                checkBox.setId(i2);
                TextView textView = (TextView) inflate.findViewById(R.id.description_view);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.tip_container);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tip_message_view);
                TextView textView3 = (TextView) inflate.findViewById(R.id.view_txt);
                if (cJRTrainAddOn.getDefaultChecked().booleanValue()) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (cJRTrainAddOn.getMandatoryOptIn().booleanValue()) {
                    checkBox.setChecked(true);
                    checkBox.setClickable(false);
                } else {
                    checkBox.setClickable(true);
                }
                if (!TextUtils.isEmpty(cJRTrainAddOn.getTitle())) {
                    checkBox.setText(cJRTrainAddOn.getTitle());
                }
                if (!TextUtils.isEmpty(cJRTrainAddOn.getTip())) {
                    linearLayout.setVisibility(0);
                    textView2.setText(cJRTrainAddOn.getTip());
                } else {
                    linearLayout.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cJRTrainAddOn.getDescription())) {
                    textView.setVisibility(0);
                    textView.setText(cJRTrainAddOn.getDescription());
                } else {
                    textView.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cJRTrainAddOn.getTncText())) {
                    textView3.setVisibility(0);
                    textView3.setText(cJRTrainAddOn.getTncText());
                }
                textView3.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c cVar = c.this;
                        String str = d.ds;
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("user_id", b.n(cVar.f28062a) != null ? b.n(cVar.f28062a) : "");
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/review-itinerary");
                            com.travel.train.b.a();
                            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, cVar.f28062a);
                        } catch (Exception e2) {
                            q.c(e2.getMessage());
                        }
                        c.this.f28063b.a(cJRTrainAddOn.getTncText(), cJRTrainAddOn.getTncUrl());
                    }
                });
                this.f28064c.addView(inflate, i2);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        Double valueOf = Double.valueOf(0.0d);
                        if (z) {
                            List<Integer> toBeToggled = cJRTrainAddOn.getToBeToggled();
                            if (toBeToggled != null) {
                                CJRTrainFareDetail a2 = c.a(toBeToggled.get(0).intValue(), cJRTrainConfirmation);
                                if (!TextUtils.isEmpty(cJRTrainAddOn.getQueryParam()) && cJRTrainAddOn.getQueryParam() != null) {
                                    c.this.f28063b.e().put(toBeToggled.get(0), cJRTrainAddOn.getQueryParam());
                                }
                                if (a2 != null) {
                                    c cVar = c.this;
                                    ArrayList arrayList = arrayList;
                                    Double.valueOf(0.0d);
                                    String a3 = o.a(a2.getValue());
                                    if (!TextUtils.isEmpty(a3)) {
                                        valueOf = Double.valueOf(Double.parseDouble(a3));
                                    }
                                    cVar.f28063b.c(Double.valueOf(cVar.f28063b.l().doubleValue() + valueOf.doubleValue()));
                                    Iterator it2 = arrayList.iterator();
                                    while (it2.hasNext()) {
                                        CJRTrainFareDetail cJRTrainFareDetail = (CJRTrainFareDetail) it2.next();
                                        if (cJRTrainFareDetail.getKey() == a2.getKey()) {
                                            cJRTrainFareDetail.setVisibility(true);
                                        }
                                    }
                                    cVar.f28063b.a(cVar.f28063b.l());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        List<Integer> toBeToggled2 = cJRTrainAddOn.getToBeToggled();
                        if (toBeToggled2 != null) {
                            c.this.f28063b.e().remove(toBeToggled2.get(0));
                            CJRTrainFareDetail a4 = c.a(toBeToggled2.get(0).intValue(), cJRTrainConfirmation);
                            c cVar2 = c.this;
                            toBeToggled2.get(0);
                            ArrayList arrayList2 = arrayList;
                            Double.valueOf(0.0d);
                            String a5 = o.a(a4.getValue());
                            if (!TextUtils.isEmpty(a5)) {
                                valueOf = Double.valueOf(Double.parseDouble(a5));
                            }
                            cVar2.f28063b.c(Double.valueOf(cVar2.f28063b.l().doubleValue() + valueOf.doubleValue()));
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                CJRTrainFareDetail cJRTrainFareDetail2 = (CJRTrainFareDetail) it3.next();
                                if (cJRTrainFareDetail2.getKey() == a4.getKey()) {
                                    cJRTrainFareDetail2.setVisibility(false);
                                }
                            }
                            cVar2.f28063b.a(cVar2.f28063b.l());
                        }
                    }
                });
            }
        }
    }

    public static CJRTrainFareDetail a(int i2, CJRTrainConfirmation cJRTrainConfirmation) {
        if (cJRTrainConfirmation == null || cJRTrainConfirmation.getFareDetails() == null || cJRTrainConfirmation.getFareDetails().size() <= 0) {
            return null;
        }
        for (CJRTrainFareDetail next : cJRTrainConfirmation.getFareDetails()) {
            if (next.getKey() == i2) {
                return next;
            }
        }
        return null;
    }
}
