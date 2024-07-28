package com.travel.flight.seatancillary.b;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatAvailability;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatAncillaryCombinedModel;
import java.util.HashMap;

public interface a {

    /* renamed from: com.travel.flight.seatancillary.b.a$a  reason: collision with other inner class name */
    public interface C0476a {
        void a(com.travel.flight.pojo.seatancillaryentity.b bVar);

        void a(String str, String str2, String str3);

        void b(com.travel.flight.pojo.seatancillaryentity.b bVar);
    }

    public interface b {

        /* renamed from: com.travel.flight.seatancillary.b.a$b$a  reason: collision with other inner class name */
        public interface C0477a {
            void a(IJRPaytmDataModel iJRPaytmDataModel);

            void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);
        }

        void a();

        boolean a(HashMap<String, String> hashMap);

        boolean b(HashMap<String, String> hashMap);
    }

    public interface c {
        void a();

        void a(HashMap<String, String> hashMap);
    }

    public interface d {
        void a(NetworkCustomError networkCustomError);

        void a(CJRSeatAvailability cJRSeatAvailability);

        void a(CJRSeatAncillaryCombinedModel cJRSeatAncillaryCombinedModel);

        void b(NetworkCustomError networkCustomError);

        void g();

        void h();
    }
}
