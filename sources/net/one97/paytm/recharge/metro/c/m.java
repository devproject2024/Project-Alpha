package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.a.e;
import net.one97.paytm.recharge.model.metro.CJRMetroPassengerDataModel;
import net.one97.paytm.recharge.model.metro.CJRMetroPriceModel;
import net.one97.paytm.recharge.model.metro.CJRMetroPriceResponse;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroStationDataModel;
import net.one97.paytm.recharge.model.metro.CJRMetroStationListResponse;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;
import org.json.JSONObject;

public final class m extends i implements e.a {
    private CJRMetroPriceModel u;
    private ArrayList<CJRMetroPriceModel> v;
    private e w;
    private int x = -1;
    private int y = -1;
    private HashMap z;

    public final View b(int i2) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        View view = (View) this.z.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.z.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public final void g() {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        s();
    }

    public final void s() {
        HashMap hashMap = this.z;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        RecyclerView recyclerView;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        f().setVisibility(4);
        RecyclerView recyclerView2 = (RecyclerView) b(R.id.trip_pass_rc_view);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        }
        RecyclerView recyclerView3 = (RecyclerView) b(R.id.trip_pass_rc_view);
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
        }
        if (!(getContext() == null || (recyclerView = (RecyclerView) b(R.id.trip_pass_rc_view)) == null)) {
            f b2 = f.b();
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            recyclerView.addItemDecoration(new g(b2.a(context, R.drawable.metro_trip_pass_divider)));
        }
        a((CJRMetroPriceModel) null);
    }

    /* access modifiers changed from: protected */
    public final void h() {
        View.OnClickListener onClickListener = this;
        c().setOnClickListener(onClickListener);
        d().setOnClickListener(onClickListener);
        b().setOnClickListener(onClickListener);
        if (this.f63369d == null) {
            c().performClick();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(CJRMetroPriceResponse cJRMetroPriceResponse) {
        LinearLayout linearLayout;
        ArrayList<CJRMetroPriceModel> arrayList;
        LinearLayout linearLayout2;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout3;
        k.c(cJRMetroPriceResponse, Payload.RESPONSE);
        if (cJRMetroPriceResponse.getTripPassFare() != null) {
            RecyclerView recyclerView = (RecyclerView) b(R.id.trip_pass_rc_view);
            if (recyclerView != null) {
                ai.b(recyclerView);
            }
            LinearLayout linearLayout4 = (LinearLayout) b(R.id.single_trip_pass);
            if (linearLayout4 != null) {
                ai.a(linearLayout4);
            }
            this.u = cJRMetroPriceResponse.getTripPassFare();
            View view = getView();
            if (!(view == null || (linearLayout3 = (LinearLayout) view.findViewById(R.id.tpt_detail_container)) == null)) {
                linearLayout3.setVisibility(0);
            }
            View view2 = getView();
            if (!(view2 == null || (textView2 = (TextView) view2.findViewById(R.id.txt_number_of_trips)) == null)) {
                CJRMetroPriceModel cJRMetroPriceModel = this.u;
                if (cJRMetroPriceModel == null) {
                    k.a();
                }
                textView2.setText(String.valueOf(cJRMetroPriceModel.getNoOfTrips()));
            }
            View view3 = getView();
            if (!(view3 == null || (textView = (TextView) view3.findViewById(R.id.txt_valid_for)) == null)) {
                CJRMetroPriceModel cJRMetroPriceModel2 = this.u;
                if (cJRMetroPriceModel2 == null) {
                    k.a();
                }
                textView.setText(cJRMetroPriceModel2.getValidFor());
            }
            CJRMetroPriceModel cJRMetroPriceModel3 = this.u;
            if (cJRMetroPriceModel3 == null) {
                k.a();
            }
            b(cJRMetroPriceModel3);
            return;
        }
        if (cJRMetroPriceResponse.getTripPassArray() != null) {
            ArrayList<CJRMetroPriceModel> tripPassArray = cJRMetroPriceResponse.getTripPassArray();
            k.a((Object) tripPassArray, "response.tripPassArray");
            if (!tripPassArray.isEmpty()) {
                TextView textView3 = (TextView) b(R.id.txt_trip_pass_heading);
                if (textView3 != null) {
                    textView3.setText(getString(R.string.title_select_trip_pass));
                }
                LinearLayout linearLayout5 = (LinearLayout) b(R.id.single_trip_pass);
                if (linearLayout5 != null) {
                    ai.b(linearLayout5);
                }
                View view4 = getView();
                if (!(view4 == null || (linearLayout2 = (LinearLayout) view4.findViewById(R.id.tpt_detail_container)) == null)) {
                    linearLayout2.setVisibility(0);
                }
                RecyclerView recyclerView2 = (RecyclerView) b(R.id.trip_pass_rc_view);
                if (recyclerView2 != null) {
                    recyclerView2.setNestedScrollingEnabled(true);
                }
                RecyclerView recyclerView3 = (RecyclerView) b(R.id.trip_pass_rc_view);
                if (recyclerView3 != null) {
                    ai.a(recyclerView3);
                }
                this.v = cJRMetroPriceResponse.getTripPassArray();
                if (this.y >= 0) {
                    CJRMetroPriceModel cJRMetroPriceModel4 = cJRMetroPriceResponse.getTripPassArray().get(this.y);
                    k.a((Object) cJRMetroPriceModel4, "response.tripPassArray[mSelectedTPPlan]");
                    cJRMetroPriceModel4.setSelected(true);
                    this.u = cJRMetroPriceResponse.getTripPassArray().get(this.y);
                    this.x = this.y;
                    CJRMetroPriceModel cJRMetroPriceModel5 = this.u;
                    if (cJRMetroPriceModel5 == null) {
                        k.a();
                    }
                    b(cJRMetroPriceModel5);
                } else if (this.f63369d != null) {
                    CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder = this.f63369d;
                    if (cJRMetroQRFrequentOrder == null) {
                        k.a();
                    }
                    if (!TextUtils.isEmpty(cJRMetroQRFrequentOrder.getProductType()) && (arrayList = this.v) != null) {
                        if (arrayList == null) {
                            k.a();
                        }
                        Iterator<CJRMetroPriceModel> it2 = arrayList.iterator();
                        int i2 = -1;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            CJRMetroPriceModel next = it2.next();
                            k.a((Object) next, "priceModel");
                            if (!TextUtils.isEmpty(next.getReqType())) {
                                String reqType = next.getReqType();
                                CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder2 = this.f63369d;
                                if (cJRMetroQRFrequentOrder2 == null) {
                                    k.a();
                                }
                                if (p.a(reqType, cJRMetroQRFrequentOrder2.getProductType(), true)) {
                                    i2++;
                                    break;
                                }
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            this.y = i2;
                            this.x = this.y;
                            CJRMetroPriceModel cJRMetroPriceModel6 = cJRMetroPriceResponse.getTripPassArray().get(this.y);
                            k.a((Object) cJRMetroPriceModel6, "response.tripPassArray[mSelectedTPPlan]");
                            cJRMetroPriceModel6.setSelected(true);
                            this.u = cJRMetroPriceResponse.getTripPassArray().get(this.y);
                            CJRMetroPriceModel cJRMetroPriceModel7 = this.u;
                            if (cJRMetroPriceModel7 == null) {
                                k.a();
                            }
                            b(cJRMetroPriceModel7);
                        }
                    }
                }
                ArrayList<CJRMetroPriceModel> tripPassArray2 = cJRMetroPriceResponse.getTripPassArray();
                k.a((Object) tripPassArray2, "response.tripPassArray");
                this.w = new e(tripPassArray2, this);
                RecyclerView recyclerView4 = (RecyclerView) b(R.id.trip_pass_rc_view);
                if (recyclerView4 != null) {
                    recyclerView4.setAdapter(this.w);
                    return;
                }
                return;
            }
        }
        View view5 = getView();
        if (view5 != null && (linearLayout = (LinearLayout) view5.findViewById(R.id.tpt_detail_container)) != null) {
            linearLayout.setVisibility(8);
        }
    }

    private final void b(CJRMetroPriceModel cJRMetroPriceModel) {
        TextView textView;
        double fare = cJRMetroPriceModel.getFare() + ((double) cJRMetroPriceModel.getRegistrationFee());
        View view = getView();
        if (!(view == null || (textView = (TextView) view.findViewById(R.id.txt_price)) == null)) {
            textView.setText(getString(R.string.rupee, ba.a(String.valueOf(fare), true)));
        }
        b().setText(getString(R.string.cart_proceed_to_pay, ba.a(String.valueOf(fare), true)));
        b().setTag(ba.a(String.valueOf(fare), true));
    }

    /* access modifiers changed from: protected */
    public final void a(CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder) {
        CJRMetroStationModel cJRMetroStationModel;
        CJRMetroStationModel cJRMetroStationModel2 = null;
        if (cJRMetroQRFrequentOrder != null) {
            cJRMetroStationModel = cJRMetroQRFrequentOrder.getSource();
        } else {
            cJRMetroStationModel = null;
        }
        this.n = cJRMetroStationModel;
        if (cJRMetroQRFrequentOrder != null) {
            cJRMetroStationModel2 = cJRMetroQRFrequentOrder.getDestination();
        }
        this.o = cJRMetroStationModel2;
        if (this.n != null && this.o != null) {
            i();
            j();
            CJRMetroStationModel cJRMetroStationModel3 = this.n;
            if (cJRMetroStationModel3 == null) {
                k.a();
            }
            String id = cJRMetroStationModel3.getId();
            k.a((Object) id, "mSourceStation!!.id");
            CJRMetroStationModel cJRMetroStationModel4 = this.o;
            if (cJRMetroStationModel4 == null) {
                k.a();
            }
            String id2 = cJRMetroStationModel4.getId();
            k.a((Object) id2, "mDestinationStation!!.id");
            a(id, id2);
        }
    }

    /* access modifiers changed from: protected */
    public final JSONObject l() {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject = new JSONObject();
        if (this.l != null) {
            CJRMetroStationListResponse cJRMetroStationListResponse = this.l;
            if (cJRMetroStationListResponse == null) {
                k.a();
            }
            CJRMetroStationDataModel source = cJRMetroStationListResponse.getSource();
            k.a((Object) source, "stationListResponse!!.source");
            String key = source.getKey();
            CJRMetroStationModel cJRMetroStationModel = this.n;
            String str4 = null;
            if (cJRMetroStationModel != null) {
                str = cJRMetroStationModel.getId();
            } else {
                str = null;
            }
            jSONObject.put(key, str);
            CJRMetroStationListResponse cJRMetroStationListResponse2 = this.l;
            if (cJRMetroStationListResponse2 == null) {
                k.a();
            }
            CJRMetroStationDataModel destination = cJRMetroStationListResponse2.getDestination();
            k.a((Object) destination, "stationListResponse!!.destination");
            String key2 = destination.getKey();
            CJRMetroStationModel cJRMetroStationModel2 = this.o;
            if (cJRMetroStationModel2 != null) {
                str2 = cJRMetroStationModel2.getId();
            } else {
                str2 = null;
            }
            jSONObject.put(key2, str2);
            CJRMetroStationListResponse cJRMetroStationListResponse3 = this.l;
            if (cJRMetroStationListResponse3 == null) {
                k.a();
            }
            CJRMetroPassengerDataModel passengers = cJRMetroStationListResponse3.getPassengers();
            k.a((Object) passengers, "stationListResponse!!.passengers");
            jSONObject.put(passengers.getKey(), 1);
            CJRMetroStationModel cJRMetroStationModel3 = this.n;
            if (cJRMetroStationModel3 != null) {
                str3 = cJRMetroStationModel3.getName();
            } else {
                str3 = null;
            }
            jSONObject.put("source", str3);
            CJRMetroStationModel cJRMetroStationModel4 = this.o;
            if (cJRMetroStationModel4 != null) {
                str4 = cJRMetroStationModel4.getName();
            }
            jSONObject.put("destination", str4);
        }
        CJRMetroPriceModel cJRMetroPriceModel = this.u;
        if (cJRMetroPriceModel == null) {
            k.a();
        }
        jSONObject.put("tokenType", cJRMetroPriceModel.getCode());
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public final String m() {
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        String string = context.getString(R.string.select_station1);
        k.a((Object) string, "context!!.getString(R.string.select_station1)");
        return string;
    }

    /* access modifiers changed from: protected */
    public final String n() {
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        String string = context.getString(R.string.select_station2);
        k.a((Object) string, "context!!.getString(R.string.select_station2)");
        return string;
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        if (cJRFrequentOrder != null) {
            a((CJRMetroQRFrequentOrder) cJRFrequentOrder);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder");
    }

    public final void a(int i2) {
        ArrayList<CJRMetroPriceModel> arrayList = this.v;
        if (arrayList != null) {
            if (arrayList == null) {
                k.a();
            }
            if (!arrayList.isEmpty()) {
                ArrayList<CJRMetroPriceModel> arrayList2 = this.v;
                if (arrayList2 == null) {
                    k.a();
                }
                this.u = arrayList2.get(i2);
                this.y = i2;
                int i3 = this.x;
                if (i3 == -1 || i3 == i2) {
                    this.x = i2;
                    CJRMetroPriceModel cJRMetroPriceModel = this.u;
                    if (cJRMetroPriceModel == null) {
                        k.a();
                    }
                    b(cJRMetroPriceModel);
                    return;
                }
                ArrayList<CJRMetroPriceModel> arrayList3 = this.v;
                if (arrayList3 == null) {
                    k.a();
                }
                CJRMetroPriceModel cJRMetroPriceModel2 = arrayList3.get(this.x);
                k.a((Object) cJRMetroPriceModel2, "tripPassArrayList!![mLastSelectedTripPass]");
                cJRMetroPriceModel2.setSelected(false);
                this.x = i2;
                e eVar = this.w;
                if (eVar != null) {
                    eVar.notifyDataSetChanged();
                }
                CJRMetroPriceModel cJRMetroPriceModel3 = this.u;
                if (cJRMetroPriceModel3 == null) {
                    k.a();
                }
                b(cJRMetroPriceModel3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean k() {
        return super.k() && (this.u != null);
    }

    public final String a(String str) {
        k.c(str, "formatedDate");
        if (this.f63366a != null) {
            CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63366a;
            if (cJRUtilityVariantV2 == null) {
                k.a();
            }
            if ("Delhi Metro".equals(cJRUtilityVariantV2.getFilterName())) {
                String string = getString(R.string.delhi_metro_trip_pass_validity_message);
                k.a((Object) string, "getString(R.string.delhi…ip_pass_validity_message)");
                return string;
            }
        }
        if (this.f63366a == null) {
            return "";
        }
        CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63366a;
        if (cJRUtilityVariantV22 == null) {
            k.a();
        }
        if (!"Mumbai Metro".equals(cJRUtilityVariantV22.getFilterName())) {
            return "";
        }
        String string2 = getString(R.string.trip_pass_disclaimer);
        k.a((Object) string2, "getString(R.string.trip_pass_disclaimer)");
        return string2;
    }
}
