package com.travel.flight.flightticket.e;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.flightticket.e.g;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImgNote;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute;
import kotlin.g.b.k;
import kotlin.m;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f24900a = new d();

    private d() {
    }

    public static RecyclerView.v a(g gVar, ViewGroup viewGroup) {
        int i2;
        k.c(gVar, "cardType");
        k.c(viewGroup, "parent");
        switch (e.f24901a[gVar.ordinal()]) {
            case 1:
                i2 = R.layout.flights_mb_flight_item;
                break;
            case 2:
                i2 = R.layout.flights_mb_travelers_item;
                break;
            case 3:
                i2 = R.layout.flights_mb_charges_item;
                break;
            case 4:
                i2 = R.layout.flights_mb_imp_notes;
                break;
            case 5:
                i2 = R.layout.flights_mb_notes_with_icon;
                break;
            case 6:
                i2 = R.layout.flights_mb_traveler_item;
                break;
            case 7:
                i2 = R.layout.flights_mb_notes_text_item;
                break;
            case 8:
                throw new IllegalArgumentException("Please define the type");
            default:
                throw new m();
        }
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), i2, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(… layoutId, parent, false)");
        return new com.travel.flight.flightticket.j.m(a2);
    }

    public static void a(CJRFlightMBChargesBody cJRFlightMBChargesBody, Object obj, int i2, com.travel.flight.flightticket.j.m mVar) {
        CJRFlightMBRoute onwardItem;
        CJRFlightMBRoute onwardItem2;
        CJRFlightMBRoute onwardItem3;
        k.c(obj, "selectedObj");
        k.c(mVar, "holder");
        g.a aVar = g.Companion;
        Object obj2 = null;
        switch (e.f24902b[g.a.a(i2).ordinal()]) {
            case 1:
                if (!(cJRFlightMBChargesBody == null || (onwardItem = cJRFlightMBChargesBody.getOnwardItem()) == null)) {
                    obj2 = onwardItem.getFlight();
                }
                if (obj2 == null) {
                    k.a();
                }
                k.c(obj2, "flight");
                mVar.f25183a.setVariable(a.f23482f, obj2);
                return;
            case 2:
                if (!(cJRFlightMBChargesBody == null || (onwardItem2 = cJRFlightMBChargesBody.getOnwardItem()) == null)) {
                    obj2 = onwardItem2.getPassenger_info();
                }
                if (obj2 == null) {
                    k.a();
                }
                k.c(obj2, "passengerInfo");
                mVar.f25183a.setVariable(a.E, obj2);
                return;
            case 3:
                if (!(cJRFlightMBChargesBody == null || (onwardItem3 = cJRFlightMBChargesBody.getOnwardItem()) == null)) {
                    obj2 = onwardItem3.getModify_charges();
                }
                if (obj2 == null) {
                    k.a();
                }
                k.c(obj2, "chargesInfo");
                mVar.f25183a.setVariable(a.L, obj2);
                mVar.f25183a.setVariable(a.w, cJRFlightMBChargesBody);
                return;
            case 4:
                if (cJRFlightMBChargesBody != null) {
                    obj2 = cJRFlightMBChargesBody.getImportant();
                }
                if (obj2 == null) {
                    k.a();
                }
                k.c(obj2, "important");
                mVar.f25183a.setVariable(a.I, obj2);
                return;
            case 5:
                CJRFlightMBPassenger cJRFlightMBPassenger = (CJRFlightMBPassenger) obj;
                k.c(cJRFlightMBPassenger, "passenger");
                mVar.f25183a.setVariable(a.P, cJRFlightMBPassenger);
                return;
            case 6:
                String str = (String) obj;
                k.c(str, "note");
                mVar.f25183a.setVariable(a.f23481e, str);
                return;
            case 7:
                CJRFlightMBImgNote cJRFlightMBImgNote = (CJRFlightMBImgNote) obj;
                k.c(cJRFlightMBImgNote, "imgNote");
                mVar.f25183a.setVariable(a.F, cJRFlightMBImgNote);
                return;
            case 8:
                throw new IllegalArgumentException("Please define the type");
            default:
                return;
        }
    }
}
