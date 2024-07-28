package com.travel.flight.flightticket.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.a;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDetails;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillarySSRSBaggageDetails;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillarySSRSBaggageItem;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillarySSRSFoodDetails;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillarySSRSFoodItem;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.i.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    CJRAncillaryDetails f24931a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24932b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24933c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f24934d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f24935e = 1;

    /* renamed from: f  reason: collision with root package name */
    private Context f24936f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f24937g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f24938h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f24939i;
    /* access modifiers changed from: private */
    public int j = 0;
    private ArrayList<String> k;
    /* access modifiers changed from: private */
    public int l = 0;
    /* access modifiers changed from: private */
    public int m = -1;
    private TextView n;
    private a o;
    private CJRFlightAncillaryReqBody p;
    private CJRAncillaryItemDetail q;
    private double r = 0.0d;
    private ImageView s;
    private ImageView t;
    private LinearLayout u;
    private ImageView v;
    private TextView w;
    private int x = 0;
    private int y = 0;

    static /* synthetic */ int f(b bVar) {
        int i2 = bVar.x;
        bVar.x = i2 - 1;
        return i2;
    }

    static /* synthetic */ int g(b bVar) {
        int i2 = bVar.x;
        bVar.x = i2 + 1;
        return i2;
    }

    public b(a aVar) {
        this.o = aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("ancillary")) {
            this.f24931a = (CJRAncillaryDetails) getArguments().getSerializable("ancillary");
            this.k = (ArrayList) getArguments().getSerializable("paxinfo");
            this.m = getArguments().getInt("ancillaryType");
        }
        this.p = CJRFlightAncillaryReqBody.getInstance();
        this.q = new CJRAncillaryItemDetail();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_f_ancillary_add_bag_meal, (ViewGroup) null);
        this.f24936f = inflate.getContext();
        this.f24937g = (LinearLayout) inflate.findViewById(R.id.ancillary_add_bag_container);
        this.f24932b = (TextView) inflate.findViewById(R.id.source);
        this.f24933c = (TextView) inflate.findViewById(R.id.destination);
        this.f24939i = (LinearLayout) inflate.findViewById(R.id.single_hop_title_container);
        this.f24938h = (LinearLayout) inflate.findViewById(R.id.title_multiple_hops_container);
        this.n = (TextView) inflate.findViewById(R.id.select_passenger);
        this.u = (LinearLayout) inflate.findViewById(R.id.hop_noitem_msgLyt);
        this.w = (TextView) inflate.findViewById(R.id.hop_no_item_message);
        this.v = (ImageView) inflate.findViewById(R.id.hop_note_icon);
        if (this.f24931a.getBody() != null && this.f24931a.getBody().getOnwardjrnyList() != null && this.f24931a.getBody().getReturnJrnyList() != null) {
            this.f24938h.setVisibility(0);
            this.f24939i.setVisibility(8);
            for (int i2 = 0; i2 < this.f24931a.getBody().getOnwardjrnyList().size(); i2++) {
                this.f24931a.getBody().getOnwardjrnyList().get(i2).setHopsindex(i2);
                CJRAncillaryItemDetail cJRAncillaryItemDetail = this.f24931a.getBody().getOnwardjrnyList().get(i2);
                cJRAncillaryItemDetail.setIsonwardJrny(true);
                a(cJRAncillaryItemDetail, i2);
            }
            if (this.f24931a.getBody().getReturnJrnyList().size() > 0) {
                this.f24938h.addView(LayoutInflater.from(this.f24936f).inflate(R.layout.pre_f_ancillary_title_vertical_devider, (ViewGroup) null, false));
            }
            for (int i3 = 0; i3 < this.f24931a.getBody().getReturnJrnyList().size(); i3++) {
                this.f24931a.getBody().getReturnJrnyList().get(i3).setHopsindex(i3);
                CJRAncillaryItemDetail cJRAncillaryItemDetail2 = this.f24931a.getBody().getReturnJrnyList().get(i3);
                cJRAncillaryItemDetail2.setIsonwardJrny(false);
                a(cJRAncillaryItemDetail2, i3);
            }
        } else if (this.f24931a.getBody() == null || this.f24931a.getBody().getOnwardjrnyList() == null) {
            if (!(this.f24931a.getBody() == null || this.f24931a.getBody().getReturnJrnyList() == null)) {
                if (this.f24931a.getBody().getReturnJrnyList().size() == 1) {
                    this.f24938h.setVisibility(8);
                    this.f24939i.setVisibility(0);
                    a(this.f24931a.getBody().getReturnJrnyList().get(0));
                    CJRAncillaryItemDetail cJRAncillaryItemDetail3 = this.f24931a.getBody().getReturnJrnyList().get(0);
                    cJRAncillaryItemDetail3.setIsonwardJrny(false);
                    c(cJRAncillaryItemDetail3);
                } else {
                    this.f24938h.setVisibility(0);
                    this.f24939i.setVisibility(8);
                    for (int i4 = 0; i4 < this.f24931a.getBody().getReturnJrnyList().size(); i4++) {
                        this.f24931a.getBody().getReturnJrnyList().get(i4).setHopsindex(i4);
                        CJRAncillaryItemDetail cJRAncillaryItemDetail4 = this.f24931a.getBody().getReturnJrnyList().get(i4);
                        cJRAncillaryItemDetail4.setIsonwardJrny(false);
                        a(cJRAncillaryItemDetail4, i4);
                    }
                }
            }
        } else if (this.f24931a.getBody().getOnwardjrnyList().size() == 1) {
            this.f24938h.setVisibility(8);
            this.f24939i.setVisibility(0);
            a(this.f24931a.getBody().getOnwardjrnyList().get(0));
            CJRAncillaryItemDetail cJRAncillaryItemDetail5 = this.f24931a.getBody().getOnwardjrnyList().get(0);
            cJRAncillaryItemDetail5.setIsonwardJrny(true);
            c(cJRAncillaryItemDetail5);
        } else {
            this.f24938h.setVisibility(0);
            this.f24939i.setVisibility(8);
            for (int i5 = 0; i5 < this.f24931a.getBody().getOnwardjrnyList().size(); i5++) {
                this.f24931a.getBody().getOnwardjrnyList().get(i5).setHopsindex(i5);
                CJRAncillaryItemDetail cJRAncillaryItemDetail6 = this.f24931a.getBody().getOnwardjrnyList().get(i5);
                cJRAncillaryItemDetail6.setIsonwardJrny(true);
                a(cJRAncillaryItemDetail6, i5);
            }
        }
        return inflate;
    }

    private void a(CJRAncillaryItemDetail cJRAncillaryItemDetail) {
        this.f24932b.setText(cJRAncillaryItemDetail.getmOrigin());
        this.f24933c.setText(cJRAncillaryItemDetail.getDestination());
    }

    private void a(CJRAncillaryItemDetail cJRAncillaryItemDetail, int i2) {
        if (i2 == 0) {
            this.j = 0;
            if (this.m == this.f24934d) {
                b(cJRAncillaryItemDetail);
            } else {
                this.u.setVisibility(8);
            }
            View a2 = a(cJRAncillaryItemDetail.getmOrigin(), cJRAncillaryItemDetail.getDestination(), true);
            a2.setTag(cJRAncillaryItemDetail);
            this.f24938h.addView(a2);
            c(cJRAncillaryItemDetail);
            return;
        }
        View a3 = a(cJRAncillaryItemDetail.getmOrigin(), cJRAncillaryItemDetail.getDestination(), false);
        a3.setTag(cJRAncillaryItemDetail);
        this.f24938h.addView(a3);
    }

    private void b(CJRAncillaryItemDetail cJRAncillaryItemDetail) {
        if (cJRAncillaryItemDetail.getSsrsItem().getBaggage() != null && cJRAncillaryItemDetail.getSsrsItem().getBaggage().size() > 0) {
            this.u.setVisibility(0);
            ResourceUtils.loadFlightImagesFromCDN(this.v, "note_icon.png", false, false, n.a.V1);
            this.w.setText(cJRAncillaryItemDetail.getSsrsItem().getBaggage().get(0).getNotes());
        }
    }

    private void c(final CJRAncillaryItemDetail cJRAncillaryItemDetail) {
        this.f24937g.removeAllViews();
        ArrayList<String> arrayList = this.k;
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = this.m;
            if (i2 == this.f24934d) {
                if (cJRAncillaryItemDetail.getSsrsItem().getBaggage() == null) {
                    this.n.setVisibility(8);
                    return;
                } else if (cJRAncillaryItemDetail.getSsrsItem().getBaggage().size() == 0) {
                    this.n.setVisibility(8);
                    return;
                }
            } else if (i2 == this.f24935e) {
                if (cJRAncillaryItemDetail.getSsrsItem().getFood() == null) {
                    this.n.setVisibility(8);
                    return;
                } else if (cJRAncillaryItemDetail.getSsrsItem().getFood().size() == 0) {
                    this.n.setVisibility(8);
                    return;
                }
            }
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                View a2 = a(this.k.get(i3), i3);
                LinearLayout linearLayout = (LinearLayout) a2.findViewById(R.id.ancillary_pax_name_container);
                if (this.k.size() == 1) {
                    linearLayout.setVisibility(8);
                    this.n.setVisibility(8);
                } else {
                    linearLayout.setTag(Integer.valueOf(i3));
                }
                LinearLayout linearLayout2 = (LinearLayout) a2.findViewById(R.id.ancillary_pax_child_container);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* JADX WARNING: type inference failed for: r5v7, types: [android.view.View] */
                    /* JADX WARNING: type inference failed for: r5v9, types: [android.view.View] */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onClick(android.view.View r5) {
                        /*
                            r4 = this;
                            java.lang.Object r5 = r5.getTag()
                            java.lang.Integer r5 = (java.lang.Integer) r5
                            int r5 = r5.intValue()
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            int r0 = r0.l
                            r1 = -1
                            if (r0 == r5) goto L_0x00b7
                            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r0 = r9
                            r0.setPassengarId(r5)
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            int r0 = r0.l
                            if (r0 == r1) goto L_0x0066
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            android.widget.LinearLayout r0 = r0.f24937g
                            com.travel.flight.flightticket.fragment.b r1 = com.travel.flight.flightticket.fragment.b.this
                            int r1 = r1.l
                            android.view.View r0 = r0.getChildAt(r1)
                            int r1 = com.travel.flight.R.id.ancillary_pax_child_container
                            android.view.View r0 = r0.findViewById(r1)
                            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                            r0.removeAllViews()
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            android.widget.LinearLayout r0 = r0.f24937g
                            com.travel.flight.flightticket.fragment.b r1 = com.travel.flight.flightticket.fragment.b.this
                            int r1 = r1.l
                            android.view.View r0 = r0.getChildAt(r1)
                            int r1 = com.travel.flight.R.id.img_group_icon
                            android.view.View r0 = r0.findViewById(r1)
                            android.widget.ImageView r0 = (android.widget.ImageView) r0
                            com.travel.flight.flightticket.fragment.b r1 = com.travel.flight.flightticket.fragment.b.this
                            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                            android.content.res.Resources r1 = r1.getResources()
                            int r2 = com.travel.flight.R.drawable.pre_f_ancillary_group_open
                            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
                            r0.setBackground(r1)
                        L_0x0066:
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            int r0 = r0.m
                            com.travel.flight.flightticket.fragment.b r1 = com.travel.flight.flightticket.fragment.b.this
                            int r1 = r1.f24934d
                            if (r0 != r1) goto L_0x008c
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r1 = r9
                            android.widget.LinearLayout r2 = r0.f24937g
                            android.view.View r2 = r2.getChildAt(r5)
                            int r3 = com.travel.flight.R.id.ancillary_pax_child_container
                            android.view.View r2 = r2.findViewById(r3)
                            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                            r0.b((com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail) r1, (android.widget.LinearLayout) r2)
                            goto L_0x00b1
                        L_0x008c:
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            int r0 = r0.m
                            com.travel.flight.flightticket.fragment.b r1 = com.travel.flight.flightticket.fragment.b.this
                            int r1 = r1.f24935e
                            if (r0 != r1) goto L_0x00b1
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r1 = r9
                            android.widget.LinearLayout r2 = r0.f24937g
                            android.view.View r2 = r2.getChildAt(r5)
                            int r3 = com.travel.flight.R.id.ancillary_pax_child_container
                            android.view.View r2 = r2.findViewById(r3)
                            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                            r0.a((com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail) r1, (android.widget.LinearLayout) r2)
                        L_0x00b1:
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            int unused = r0.l = r5
                            return
                        L_0x00b7:
                            r0 = 0
                            com.travel.flight.flightticket.fragment.b r2 = com.travel.flight.flightticket.fragment.b.this
                            int r2 = r2.m
                            com.travel.flight.flightticket.fragment.b r3 = com.travel.flight.flightticket.fragment.b.this
                            int r3 = r3.f24934d
                            if (r2 != r3) goto L_0x00da
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            android.widget.LinearLayout r0 = r0.f24937g
                            android.view.View r5 = r0.getChildAt(r5)
                            int r0 = com.travel.flight.R.id.ancillary_pax_child_container
                            android.view.View r5 = r5.findViewById(r0)
                            r0 = r5
                            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                            goto L_0x00fb
                        L_0x00da:
                            com.travel.flight.flightticket.fragment.b r2 = com.travel.flight.flightticket.fragment.b.this
                            int r2 = r2.m
                            com.travel.flight.flightticket.fragment.b r3 = com.travel.flight.flightticket.fragment.b.this
                            int r3 = r3.f24935e
                            if (r2 != r3) goto L_0x00fb
                            com.travel.flight.flightticket.fragment.b r0 = com.travel.flight.flightticket.fragment.b.this
                            android.widget.LinearLayout r0 = r0.f24937g
                            android.view.View r5 = r0.getChildAt(r5)
                            int r0 = com.travel.flight.R.id.ancillary_pax_child_container
                            android.view.View r5 = r5.findViewById(r0)
                            r0 = r5
                            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                        L_0x00fb:
                            com.travel.flight.flightticket.fragment.b r5 = com.travel.flight.flightticket.fragment.b.this
                            int unused = r5.l = r1
                            com.travel.flight.flightticket.fragment.b r5 = com.travel.flight.flightticket.fragment.b.this
                            r1 = 0
                            r5.a((android.widget.LinearLayout) r0, (boolean) r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.fragment.b.AnonymousClass1.onClick(android.view.View):void");
                    }
                });
                this.l = -1;
                if (i3 == 0 && this.k.size() == 1) {
                    this.l = 0;
                    cJRAncillaryItemDetail.setPassengarId(this.l);
                    int i4 = this.m;
                    if (i4 == this.f24934d) {
                        b(cJRAncillaryItemDetail, linearLayout2);
                    } else if (i4 == this.f24935e) {
                        a(cJRAncillaryItemDetail, linearLayout2);
                    }
                }
                this.f24937g.addView(a2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRAncillaryItemDetail cJRAncillaryItemDetail, LinearLayout linearLayout) {
        d(cJRAncillaryItemDetail);
        a(linearLayout, false);
        this.x = cJRAncillaryItemDetail.getItemValidations().getFood().getMax().intValue();
        this.y = this.x;
        Iterator<CJRAncillarySSRSFoodDetails> it2 = cJRAncillaryItemDetail.getSsrsItem().getFood().iterator();
        while (it2.hasNext()) {
            CJRAncillarySSRSFoodDetails next = it2.next();
            a(next.getTitle(), linearLayout);
            Iterator<CJRAncillarySSRSFoodItem> it3 = next.getItems().iterator();
            while (it3.hasNext()) {
                CJRAncillarySSRSFoodItem next2 = it3.next();
                int selectedAncillaryCount = this.p.getSelectedAncillaryCount(cJRAncillaryItemDetail.isIsonwardJrny(), cJRAncillaryItemDetail.getPassengarId(), cJRAncillaryItemDetail.getFlightNumber(), cJRAncillaryItemDetail.getmOrigin(), cJRAncillaryItemDetail.getDestination(), next2.getCode());
                this.x -= selectedAncillaryCount;
                next2.setSelectedQuantity(selectedAncillaryCount);
                linearLayout.addView(a(next2.getCode(), true, next2.isVeg(), next2.getName(), next2.getAmount(), selectedAncillaryCount, "nouse", next2));
            }
        }
        a(linearLayout, true);
    }

    /* access modifiers changed from: private */
    public void b(CJRAncillaryItemDetail cJRAncillaryItemDetail, LinearLayout linearLayout) {
        d(cJRAncillaryItemDetail);
        a(linearLayout, false);
        this.x = cJRAncillaryItemDetail.getItemValidations().getBaggage().getMax().intValue();
        this.y = this.x;
        Iterator<CJRAncillarySSRSBaggageDetails> it2 = cJRAncillaryItemDetail.getSsrsItem().getBaggage().iterator();
        while (it2.hasNext()) {
            Iterator<CJRAncillarySSRSBaggageItem> it3 = it2.next().getItems().iterator();
            while (it3.hasNext()) {
                CJRAncillarySSRSBaggageItem next = it3.next();
                int selectedAncillaryCount = this.p.getSelectedAncillaryCount(cJRAncillaryItemDetail.isIsonwardJrny(), cJRAncillaryItemDetail.getPassengarId(), cJRAncillaryItemDetail.getFlightNumber(), cJRAncillaryItemDetail.getmOrigin(), cJRAncillaryItemDetail.getDestination(), next.getCode());
                this.x -= selectedAncillaryCount;
                next.setSelectedQuantity(selectedAncillaryCount);
                linearLayout.addView(a(next.getCode(), false, Boolean.FALSE, next.getName(), next.getAmount(), selectedAncillaryCount, next.getWeight() + next.getUnit(), next));
            }
        }
        a(linearLayout, true);
    }

    private View a(String str, int i2) {
        View inflate = LayoutInflater.from(this.f24936f).inflate(R.layout.pre_f_ancillary_pax_layout, (ViewGroup) null, false);
        inflate.findViewById(R.id.img_group_icon);
        ((TextView) inflate.findViewById(R.id.pax_name)).setText(str);
        inflate.setTag(Integer.valueOf(i2));
        return inflate;
    }

    private View a(String str, boolean z, Boolean bool, String str2, Double d2, int i2, String str3, Object obj) {
        String str4;
        String str5 = str;
        Boolean bool2 = bool;
        Double d3 = d2;
        final Object obj2 = obj;
        View inflate = LayoutInflater.from(this.f24936f).inflate(R.layout.pre_f_ancillary_item_layout, (ViewGroup) null, false);
        if (z) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.veg_nonveg_icon);
            if (bool2 != null) {
                imageView.setVisibility(0);
                if (bool.booleanValue()) {
                    imageView.setBackgroundResource(R.drawable.pre_f_veg_ancillary);
                } else {
                    imageView.setBackgroundResource(R.drawable.pre_f_non_veg_ancillary);
                }
            } else {
                imageView.setVisibility(4);
            }
            str4 = str2;
        } else {
            str4 = str3;
        }
        ((TextView) inflate.findViewById(R.id.item_name)).setText(str2);
        ((TextView) inflate.findViewById(R.id.item_price)).setText(this.f24936f.getResources().getString(R.string.rs_symbol) + d3);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.quantity_change_lyout);
        final TextView textView = (TextView) inflate.findViewById(R.id.add_option);
        textView.setTag(str5 + "|" + d3 + "|" + str4 + "|" + bool2);
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!b.this.a(obj2)) {
                    Object obj = obj2;
                    if (obj instanceof CJRAncillarySSRSFoodItem) {
                        CJRAncillarySSRSFoodItem cJRAncillarySSRSFoodItem = (CJRAncillarySSRSFoodItem) obj;
                        cJRAncillarySSRSFoodItem.setSelectedQuantity(cJRAncillarySSRSFoodItem.getSelectedQuantity() + 1);
                        b.f(b.this);
                    } else if (obj instanceof CJRAncillarySSRSBaggageItem) {
                        CJRAncillarySSRSBaggageItem cJRAncillarySSRSBaggageItem = (CJRAncillarySSRSBaggageItem) obj;
                        cJRAncillarySSRSBaggageItem.setSelectedQuantity(cJRAncillarySSRSBaggageItem.getSelectedQuantity() + 1);
                        b.f(b.this);
                    }
                    linearLayout.setVisibility(0);
                    textView.setVisibility(4);
                    b.a(b.this, (String) view.getTag(), 1);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.count);
        if (i2 > 0) {
            textView2.setText(String.valueOf(i2));
        }
        this.s = (ImageView) inflate.findViewById(R.id.imageview_minus_button);
        ImageView imageView2 = this.s;
        imageView2.setTag(str5 + "|" + (-d2.doubleValue()) + "|" + str4 + "|" + bool2);
        final TextView textView3 = textView2;
        final TextView textView4 = textView2;
        final LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = linearLayout;
        String str6 = "|";
        final TextView textView5 = textView;
        TextView textView6 = textView;
        final Object obj3 = obj;
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(textView3.getText())) {
                    if (Integer.parseInt(textView3.getText().toString()) == 1) {
                        linearLayout2.setVisibility(4);
                        textView5.setVisibility(0);
                        b.a(b.this, (String) view.getTag(), 0);
                    } else {
                        TextView textView = textView3;
                        StringBuilder sb = new StringBuilder();
                        sb.append(Integer.parseInt(textView3.getText().toString()) - 1);
                        textView.setText(sb.toString());
                        b.a(b.this, (String) view.getTag(), Integer.parseInt(textView3.getText().toString()));
                    }
                    Object obj = obj3;
                    if (obj instanceof CJRAncillarySSRSFoodItem) {
                        CJRAncillarySSRSFoodItem cJRAncillarySSRSFoodItem = (CJRAncillarySSRSFoodItem) obj;
                        cJRAncillarySSRSFoodItem.setSelectedQuantity(cJRAncillarySSRSFoodItem.getSelectedQuantity() - 1);
                        b.g(b.this);
                    } else if (obj instanceof CJRAncillarySSRSBaggageItem) {
                        CJRAncillarySSRSBaggageItem cJRAncillarySSRSBaggageItem = (CJRAncillarySSRSBaggageItem) obj;
                        cJRAncillarySSRSBaggageItem.setSelectedQuantity(cJRAncillarySSRSBaggageItem.getSelectedQuantity() - 1);
                        b.g(b.this);
                    }
                }
            }
        });
        View view = inflate;
        this.t = (ImageView) view.findViewById(R.id.imageview_plus_button);
        ImageView imageView3 = this.t;
        imageView3.setTag(str5 + str6 + d3 + str6 + str4 + str6 + bool2);
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!b.this.a(obj2)) {
                    Object obj = obj2;
                    if (obj instanceof CJRAncillarySSRSFoodItem) {
                        CJRAncillarySSRSFoodItem cJRAncillarySSRSFoodItem = (CJRAncillarySSRSFoodItem) obj;
                        cJRAncillarySSRSFoodItem.setSelectedQuantity(cJRAncillarySSRSFoodItem.getSelectedQuantity() + 1);
                        b.f(b.this);
                    } else if (obj instanceof CJRAncillarySSRSBaggageItem) {
                        CJRAncillarySSRSBaggageItem cJRAncillarySSRSBaggageItem = (CJRAncillarySSRSBaggageItem) obj;
                        cJRAncillarySSRSBaggageItem.setSelectedQuantity(cJRAncillarySSRSBaggageItem.getSelectedQuantity() + 1);
                        b.f(b.this);
                    }
                    TextView textView = textView4;
                    StringBuilder sb = new StringBuilder();
                    sb.append(Integer.parseInt(textView4.getText().toString()) + 1);
                    textView.setText(sb.toString());
                    b.a(b.this, (String) view.getTag(), Integer.parseInt(textView4.getText().toString()));
                }
            }
        });
        if (i2 <= 0) {
            linearLayout3.setVisibility(4);
            textView6.setVisibility(0);
        } else {
            linearLayout3.setVisibility(0);
            textView6.setVisibility(4);
        }
        return view;
    }

    /* access modifiers changed from: private */
    public boolean a(Object obj) {
        int i2 = 10;
        if (this.m == this.f24934d) {
            if (this.x <= 0) {
                FragmentActivity activity = getActivity();
                Toast.makeText(activity, "You can't add more than " + this.y + " Baggage(s)", 1).show();
                return true;
            }
            CJRAncillarySSRSBaggageItem cJRAncillarySSRSBaggageItem = (CJRAncillarySSRSBaggageItem) obj;
            if (!(this.q.getItemValidations() == null || this.q.getItemValidations().getFood() == null)) {
                this.q.getItemValidations().getBaggage().getMax().intValue();
            }
            try {
                i2 = Integer.parseInt(cJRAncillarySSRSBaggageItem.getAvailable_quantity());
            } catch (Exception unused) {
            }
            if (i2 > cJRAncillarySSRSBaggageItem.getSelectedQuantity()) {
                return false;
            }
            FragmentActivity activity2 = getActivity();
            Toast.makeText(activity2, "You can't add more than " + i2 + " Baggage(s)", 1).show();
            return true;
        } else if (this.x <= 0) {
            FragmentActivity activity3 = getActivity();
            Toast.makeText(activity3, "You can't add more than " + this.y + " Meal(s)", 1).show();
            return true;
        } else {
            CJRAncillarySSRSFoodItem cJRAncillarySSRSFoodItem = (CJRAncillarySSRSFoodItem) obj;
            try {
                i2 = Integer.parseInt(cJRAncillarySSRSFoodItem.getAvailable_quantity());
            } catch (Exception unused2) {
            }
            if (i2 > cJRAncillarySSRSFoodItem.getSelectedQuantity()) {
                return false;
            }
            FragmentActivity activity4 = getActivity();
            Toast.makeText(activity4, "You can't add more than " + i2 + " Meal(s)", 1).show();
            return true;
        }
    }

    private View a(String str, String str2, boolean z) {
        View inflate = LayoutInflater.from(this.f24936f).inflate(R.layout.pre_f_ancillary_hops_layout, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.source_hops);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.destination_hops);
        textView2.setText(str2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_arrow_hops);
        View findViewById = inflate.findViewById(R.id.blue_view);
        if (z) {
            findViewById.setVisibility(0);
            textView.setTextColor(this.f24936f.getResources().getColor(R.color.color_222222));
            textView2.setTextColor(this.f24936f.getResources().getColor(R.color.color_222222));
            imageView.setImageResource(R.drawable.pre_f_flight_arrow_right_black);
        } else {
            findViewById.setVisibility(4);
        }
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRAncillaryItemDetail cJRAncillaryItemDetail = (CJRAncillaryItemDetail) view.getTag();
                if (b.a(b.this, cJRAncillaryItemDetail) && b.this.j != cJRAncillaryItemDetail.getHopsindex()) {
                    b.b(b.this, cJRAncillaryItemDetail);
                }
            }
        });
        return inflate;
    }

    private void a(String str, LinearLayout linearLayout) {
        View inflate = LayoutInflater.from(this.f24936f).inflate(R.layout.pre_f_ancillary_food_category, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.food_category)).setText(str);
        linearLayout.addView(inflate);
    }

    private void d(CJRAncillaryItemDetail cJRAncillaryItemDetail) {
        this.q.setFlightNumber(cJRAncillaryItemDetail.getFlightNumber());
        this.q.setmOrigin(cJRAncillaryItemDetail.getmOrigin());
        this.q.setDestination(cJRAncillaryItemDetail.getDestination());
        this.q.setHopsindex(cJRAncillaryItemDetail.getHopsindex());
        this.q.setIsonwardJrny(cJRAncillaryItemDetail.isIsonwardJrny());
        this.q.setPassengarId(cJRAncillaryItemDetail.getPassengarId());
        this.q.setItemValidations(cJRAncillaryItemDetail.getItemValidations());
    }

    public final void a(LinearLayout linearLayout, boolean z) {
        ImageView imageView = (ImageView) ((LinearLayout) linearLayout.getParent()).findViewById(R.id.img_group_icon);
        if (z) {
            linearLayout.setVisibility(0);
            imageView.setBackground(getActivity().getResources().getDrawable(R.drawable.pre_f_ancillary_group_closed));
            return;
        }
        imageView.setBackground(getActivity().getResources().getDrawable(R.drawable.pre_f_ancillary_group_open));
        linearLayout.setVisibility(8);
        linearLayout.removeAllViews();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bc A[Catch:{ Exception -> 0x00e3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.travel.flight.flightticket.fragment.b r23, java.lang.String r24, int r25) {
        /*
            r0 = r23
            java.lang.String r1 = "\\|"
            r2 = r24
            java.lang.String[] r1 = r2.split(r1)     // Catch:{ Exception -> 0x00e3 }
            r2 = 0
            java.lang.Double r4 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x00e3 }
            int r5 = r0.m     // Catch:{ Exception -> 0x00e3 }
            int r6 = r0.f24934d     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r7 = ""
            r8 = 0
            r9 = 1
            if (r5 != r6) goto L_0x003c
            android.content.res.Resources r4 = r23.getResources()     // Catch:{ Exception -> 0x00e3 }
            int r5 = com.travel.flight.R.string.flight_additional_baggage_added_for     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r5 = r0.p     // Catch:{ Exception -> 0x00e3 }
            r6 = r1[r9]     // Catch:{ Exception -> 0x00e3 }
            double r10 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x00e3 }
            java.lang.Double r6 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x00e3 }
            r5.setmSelectedBaggageTotalAmount(r6)     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r5 = r0.p     // Catch:{ Exception -> 0x00e3 }
            java.lang.Double r5 = r5.getmSelectedBaggageTotalAmount()     // Catch:{ Exception -> 0x00e3 }
            r19 = 1
            goto L_0x0082
        L_0x003c:
            int r5 = r0.m     // Catch:{ Exception -> 0x00e3 }
            int r6 = r0.f24935e     // Catch:{ Exception -> 0x00e3 }
            if (r5 != r6) goto L_0x007e
            android.content.res.Resources r4 = r23.getResources()     // Catch:{ Exception -> 0x00e3 }
            int r5 = com.travel.flight.R.string.flight_meals_added_for     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r5 = r0.p     // Catch:{ Exception -> 0x00e3 }
            r6 = r1[r9]     // Catch:{ Exception -> 0x00e3 }
            double r10 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x00e3 }
            java.lang.Double r6 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x00e3 }
            r5.setmSelectedMealsTotalAmount(r6)     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r5 = r0.p     // Catch:{ Exception -> 0x00e3 }
            java.lang.Double r5 = r5.getmSelectedMealsTotalAmount()     // Catch:{ Exception -> 0x00e3 }
            if (r1 == 0) goto L_0x0078
            int r6 = r1.length     // Catch:{ Exception -> 0x00e3 }
            r10 = 3
            if (r6 <= r10) goto L_0x0078
            java.lang.String r6 = "null"
            r11 = r1[r10]     // Catch:{ Exception -> 0x00e3 }
            boolean r6 = r6.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x00e3 }
            if (r6 != 0) goto L_0x0078
            r6 = r1[r10]     // Catch:{ Exception -> 0x00e3 }
            boolean r6 = java.lang.Boolean.parseBoolean(r6)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x0079
        L_0x0078:
            r6 = 1
        L_0x0079:
            r22 = r6
            r19 = 0
            goto L_0x0084
        L_0x007e:
            r5 = r4
            r4 = r7
            r19 = 0
        L_0x0082:
            r22 = 1
        L_0x0084:
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r10 = r0.p     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r6 = r0.q     // Catch:{ Exception -> 0x00e3 }
            boolean r11 = r6.isIsonwardJrny()     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r6 = r0.q     // Catch:{ Exception -> 0x00e3 }
            int r12 = r6.getPassengarId()     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r6 = r0.q     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r13 = r6.getFlightNumber()     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r6 = r0.q     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r14 = r6.getmOrigin()     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryItemDetail r6 = r0.q     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r15 = r6.getDestination()     // Catch:{ Exception -> 0x00e3 }
            r16 = r1[r8]     // Catch:{ Exception -> 0x00e3 }
            r6 = 2
            r17 = r1[r6]     // Catch:{ Exception -> 0x00e3 }
            r1 = r1[r9]     // Catch:{ Exception -> 0x00e3 }
            double r20 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00e3 }
            r18 = r25
            r10.updateSelectedAncillary(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22)     // Catch:{ Exception -> 0x00e3 }
            double r10 = r5.doubleValue()     // Catch:{ Exception -> 0x00e3 }
            int r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c4
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00e3 }
            r1[r8] = r5     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r7 = java.lang.String.format(r4, r1)     // Catch:{ Exception -> 0x00e3 }
        L_0x00c4:
            com.travel.flight.flightticket.f.a r1 = r0.o     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r2 = r0.p     // Catch:{ Exception -> 0x00e3 }
            java.lang.Double r2 = r2.getmSelectedBaggageTotalAmount()     // Catch:{ Exception -> 0x00e3 }
            double r2 = r2.doubleValue()     // Catch:{ Exception -> 0x00e3 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r0 = r0.p     // Catch:{ Exception -> 0x00e3 }
            java.lang.Double r0 = r0.getmSelectedMealsTotalAmount()     // Catch:{ Exception -> 0x00e3 }
            double r4 = r0.doubleValue()     // Catch:{ Exception -> 0x00e3 }
            double r2 = r2 + r4
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x00e3 }
            r1.a(r7, r0)     // Catch:{ Exception -> 0x00e3 }
            return
        L_0x00e3:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.fragment.b.a(com.travel.flight.flightticket.fragment.b, java.lang.String, int):void");
    }

    static /* synthetic */ boolean a(b bVar, CJRAncillaryItemDetail cJRAncillaryItemDetail) {
        if (!(cJRAncillaryItemDetail == null || cJRAncillaryItemDetail.getSsrsItem() == null)) {
            if (bVar.m == bVar.f24934d) {
                if (cJRAncillaryItemDetail.getSsrsItem().getBaggage() == null || cJRAncillaryItemDetail.getSsrsItem().getBaggage().size() <= 0) {
                    return false;
                }
                return true;
            } else if (cJRAncillaryItemDetail.getSsrsItem().getFood() == null || cJRAncillaryItemDetail.getSsrsItem().getFood().size() <= 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void b(b bVar, CJRAncillaryItemDetail cJRAncillaryItemDetail) {
        int hopsindex = cJRAncillaryItemDetail.getHopsindex();
        bVar.f24938h.getChildAt(hopsindex).findViewById(R.id.blue_view).setVisibility(0);
        ((TextView) bVar.f24938h.getChildAt(hopsindex).findViewById(R.id.source_hops)).setTextColor(bVar.f24936f.getResources().getColor(R.color.color_222222));
        ((TextView) bVar.f24938h.getChildAt(hopsindex).findViewById(R.id.destination_hops)).setTextColor(bVar.f24936f.getResources().getColor(R.color.color_222222));
        ((ImageView) bVar.f24938h.getChildAt(hopsindex).findViewById(R.id.img_arrow_hops)).setImageResource(R.drawable.pre_f_flight_arrow_right_black);
        bVar.f24938h.getChildAt(bVar.j).findViewById(R.id.blue_view).setVisibility(4);
        ((TextView) bVar.f24938h.getChildAt(bVar.j).findViewById(R.id.source_hops)).setTextColor(bVar.f24936f.getResources().getColor(R.color.color_909090));
        ((TextView) bVar.f24938h.getChildAt(bVar.j).findViewById(R.id.destination_hops)).setTextColor(bVar.f24936f.getResources().getColor(R.color.color_909090));
        ((ImageView) bVar.f24938h.getChildAt(bVar.j).findViewById(R.id.img_arrow_hops)).setImageResource(R.drawable.pre_f_actionbar_right_arrow);
        bVar.j = hopsindex;
        bVar.c(cJRAncillaryItemDetail);
        bVar.d(cJRAncillaryItemDetail);
    }
}
