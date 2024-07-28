package com.travel.flight.flightorder.j;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gsonhtcfix.f;
import com.travel.flight.R;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    public CJROrderSummaryCancellation f24504a;

    /* renamed from: b  reason: collision with root package name */
    private List<LinearLayout> f24505b;

    /* renamed from: c  reason: collision with root package name */
    private List<TextView> f24506c;

    /* renamed from: d  reason: collision with root package name */
    private List<TextView> f24507d;

    /* renamed from: e  reason: collision with root package name */
    private List<LinearLayout> f24508e;

    /* renamed from: f  reason: collision with root package name */
    private List<LinearLayout> f24509f;

    /* renamed from: g  reason: collision with root package name */
    private List<TextView> f24510g;

    /* renamed from: h  reason: collision with root package name */
    private List<TextView> f24511h;

    /* renamed from: i  reason: collision with root package name */
    private List<LinearLayout> f24512i;
    private List<ImageView> j;
    private List<ImageView> k;
    private List<ImageView> l;
    private List<TextView> m;
    private List<TextView> n;
    private List<TextView> o;

    public final void a(b.C0467b bVar) {
        JSONObject jSONObject;
        List<CJROrderSummaryCancellation.CJROrderSummaryCancellationTimeline> list;
        CJROrderSummaryCancellation cJROrderSummaryCancellation = this.f24504a;
        if (cJROrderSummaryCancellation != null && cJROrderSummaryCancellation.getBody() != null && this.f24504a.getBody().getTimeLine() != null) {
            try {
                List<CJROrderSummaryCancellation.CJROrderSummaryCancellationTimeline> timeLine = this.f24504a.getBody().getTimeLine();
                JSONObject jSONObject2 = new JSONObject(new f().a(this.f24504a.getBody().getItems()));
                Drawable a2 = androidx.core.content.b.a(this.itemView.getContext(), R.drawable.pre_f_order_summary_payment_success);
                Drawable a3 = androidx.core.content.b.a(this.itemView.getContext(), R.drawable.pre_f_order_summary_idle_state);
                int i2 = 0;
                while (i2 < list.size()) {
                    this.f24508e.get(i2).removeAllViews();
                    this.f24512i.get(i2).removeAllViews();
                    CJROrderSummaryCancellation.CJROrderSummaryCancellationTimeline cJROrderSummaryCancellationTimeline = list.get(i2);
                    List<String> itemIds = cJROrderSummaryCancellationTimeline.getItemIds();
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    String str = null;
                    String str2 = null;
                    boolean z = false;
                    String str3 = null;
                    String str4 = null;
                    boolean z2 = false;
                    String str5 = null;
                    String str6 = null;
                    for (String string : itemIds) {
                        List<CJROrderSummaryCancellation.CJROrderSummaryCancellationTimeline> list2 = list;
                        JSONObject jSONObject3 = jSONObject;
                        CJROrderSummaryCancellation.CJROrderSummaryCancellationItem cJROrderSummaryCancellationItem = (CJROrderSummaryCancellation.CJROrderSummaryCancellationItem) new f().a(jSONObject.getString(string), CJROrderSummaryCancellation.CJROrderSummaryCancellationItem.class);
                        if (!TextUtils.isEmpty(cJROrderSummaryCancellationItem.getDirection())) {
                            if (cJROrderSummaryCancellationItem.getDirection().equals("onward")) {
                                str3 = cJROrderSummaryCancellationItem.getDeparture_date();
                                str4 = cJROrderSummaryCancellationItem.getOrigin();
                                str2 = cJROrderSummaryCancellationItem.getDestination();
                                arrayList.add(a(cJROrderSummaryCancellationItem.getPassenger_details()));
                                list = list2;
                                jSONObject = jSONObject3;
                                z = true;
                            } else if (cJROrderSummaryCancellationItem.getDirection().equals("return")) {
                                String departure_date = cJROrderSummaryCancellationItem.getDeparture_date();
                                String origin = cJROrderSummaryCancellationItem.getOrigin();
                                String destination = cJROrderSummaryCancellationItem.getDestination();
                                arrayList2.add(a(cJROrderSummaryCancellationItem.getPassenger_details()));
                                str6 = departure_date;
                                str5 = destination;
                                z2 = true;
                                str = origin;
                            }
                        }
                        list = list2;
                        jSONObject = jSONObject3;
                    }
                    List<CJROrderSummaryCancellation.CJROrderSummaryCancellationTimeline> list3 = list;
                    JSONObject jSONObject4 = jSONObject;
                    if (z) {
                        this.f24505b.get(i2).setVisibility(0);
                        this.itemView.getContext();
                        this.f24507d.get(i2).setText(com.paytm.utility.b.f(str3, "yyyy-MM-dd", "E, dd MMM"));
                        this.f24506c.get(i2).setText(str4 + " - " + str2);
                        for (String a4 : arrayList) {
                            this.f24508e.get(i2).addView(a(a4));
                        }
                    } else {
                        this.f24505b.get(i2).setVisibility(8);
                    }
                    if (z2) {
                        this.f24509f.get(i2).setVisibility(0);
                        this.itemView.getContext();
                        this.f24511h.get(i2).setText(com.paytm.utility.b.f(str6, "yyyy-MM-dd", "E, dd MMM"));
                        this.f24510g.get(i2).setText(str + " - " + str5);
                        for (String a5 : arrayList2) {
                            this.f24512i.get(i2).addView(a(a5));
                        }
                    } else {
                        this.f24509f.get(i2).setVisibility(8);
                    }
                    if (cJROrderSummaryCancellationTimeline.getStates() != null) {
                        ImageView imageView = null;
                        TextView textView = null;
                        for (int i3 = 0; i3 < cJROrderSummaryCancellationTimeline.getStates().size(); i3++) {
                            CJROrderSummaryCancellation.CJROrderSummaryCancellationState cJROrderSummaryCancellationState = cJROrderSummaryCancellationTimeline.getStates().get(i3);
                            if (i3 == 0) {
                                imageView = this.j.get(i2);
                                textView = this.m.get(i2);
                            } else if (i3 == 1) {
                                imageView = this.k.get(i2);
                                textView = this.n.get(i2);
                            } else if (i3 == 2) {
                                imageView = this.l.get(i2);
                                textView = this.o.get(i2);
                            }
                            if (!cJROrderSummaryCancellationState.isDone() || imageView == null) {
                                imageView.setImageDrawable(a3);
                                imageView.setScaleX(0.5f);
                                imageView.setScaleY(0.5f);
                            } else {
                                imageView.setImageDrawable(a2);
                            }
                            if (!TextUtils.isEmpty(cJROrderSummaryCancellationState.getCompletedAt())) {
                                textView.setText(cJROrderSummaryCancellationState.getCompletedAt());
                            } else if (!TextUtils.isEmpty(cJROrderSummaryCancellationState.getEta())) {
                                textView.setText(cJROrderSummaryCancellationState.getEta());
                            }
                        }
                    }
                    i2++;
                    timeLine = list3;
                    jSONObject2 = jSONObject4;
                }
            } catch (Exception unused) {
            }
        }
    }

    private TextView a(String str) {
        TextView textView = new TextView(this.itemView.getContext());
        textView.setTextColor(androidx.core.content.b.c(this.itemView.getContext(), R.color.color_222222));
        textView.setTextSize(14.0f);
        textView.setGravity(3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 20, 0, 20);
        textView.setLayoutParams(layoutParams);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setText(str);
        return textView;
    }

    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(new f().a(obj));
            return "" + jSONObject.getString("title") + " " + jSONObject.getString("firstname") + " " + jSONObject.getString("lastname");
        } catch (JSONException unused) {
            return "";
        }
    }
}
