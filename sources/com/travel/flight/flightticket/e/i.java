package com.travel.flight.flightticket.e;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImgNote;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final b f24904a = new b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f24905b;

    public interface c {
        void a();

        void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

        void a(IJRPaytmDataModel iJRPaytmDataModel, List<f> list);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
        com.travel.flight.c b2 = com.travel.flight.b.b();
        k.a((Object) b2, "FlightController.getInstance().flightEventListener");
        f24905b = b2.T();
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        private final c f24906a;

        public a(c cVar) {
            k.c(cVar, "listener");
            this.f24906a = cVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null || networkCustomError.getErrorType() == NetworkCustomError.ErrorType.NetworkError || networkCustomError.getErrorType() == NetworkCustomError.ErrorType.NoConnectionError) {
                this.f24906a.a();
            } else {
                this.f24906a.a(i2, iJRPaytmDataModel, networkCustomError);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            CJRFlightMBImportant important;
            CJRFlightMBRoute onwardItem;
            CJRFlightMBRoute onwardItem2;
            CJRFlightMBRoute onwardItem3;
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof CJRFlightMBChargesRoot) {
                c cVar = this.f24906a;
                List arrayList = new ArrayList();
                if (iJRPaytmDataModel != null) {
                    CJRFlightMBChargesRoot cJRFlightMBChargesRoot = (CJRFlightMBChargesRoot) iJRPaytmDataModel;
                    CJRFlightMBChargesBody body = cJRFlightMBChargesRoot.getBody();
                    List<CJRFlightMBImgNote> list = null;
                    Boolean is_modifiable = body != null ? body.is_modifiable() : null;
                    if (is_modifiable == null) {
                        k.a();
                    }
                    if (is_modifiable.booleanValue()) {
                        CJRFlightMBChargesBody body2 = cJRFlightMBChargesRoot.getBody();
                        if (((body2 == null || (onwardItem3 = body2.getOnwardItem()) == null) ? null : onwardItem3.getFlight()) != null) {
                            f fVar = new f();
                            fVar.a(g.Flight);
                            arrayList.add(fVar);
                        }
                        CJRFlightMBChargesBody body3 = cJRFlightMBChargesRoot.getBody();
                        if (((body3 == null || (onwardItem2 = body3.getOnwardItem()) == null) ? null : onwardItem2.getPassenger_info()) != null) {
                            f fVar2 = new f();
                            fVar2.a(g.Passengers);
                            arrayList.add(fVar2);
                        }
                        CJRFlightMBChargesBody body4 = cJRFlightMBChargesRoot.getBody();
                        if (((body4 == null || (onwardItem = body4.getOnwardItem()) == null) ? null : onwardItem.getModify_charges()) != null) {
                            f fVar3 = new f();
                            fVar3.a(g.Charges);
                            arrayList.add(fVar3);
                        }
                        CJRFlightMBChargesBody body5 = cJRFlightMBChargesRoot.getBody();
                        if ((body5 != null ? body5.getImportant() : null) != null) {
                            CJRFlightMBChargesBody body6 = cJRFlightMBChargesRoot.getBody();
                            if (!(body6 == null || (important = body6.getImportant()) == null)) {
                                list = important.getNotes();
                            }
                            Collection collection = list;
                            if (!(collection == null || collection.isEmpty())) {
                                f fVar4 = new f();
                                fVar4.a(g.Important);
                                arrayList.add(fVar4);
                            }
                        }
                    }
                    cVar.a(iJRPaytmDataModel, arrayList);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot");
            }
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.networkResponse = iJRPaytmDataModel.getNetworkResponse();
            this.f24906a.a(200, iJRPaytmDataModel, networkCustomError);
        }
    }
}
