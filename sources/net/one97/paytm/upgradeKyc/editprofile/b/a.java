package net.one97.paytm.upgradeKyc.editprofile.b;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.paymentsbank.UADPincode;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;

public interface a {

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.b.a$a  reason: collision with other inner class name */
    public interface C1307a {
        void a();

        void b();

        void c();

        void d();
    }

    public interface b {
        void a();

        void a(String str);

        void a(String str, boolean z);

        void a(CersaiDetails cersaiDetails);

        void b();

        void b(String str);

        void b(CersaiDetails cersaiDetails);

        void c(String str);
    }

    public interface c {
        void a(String str);

        void a(UADPincode.SubPincode subPincode);
    }

    public interface d {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(IJRDataModel iJRDataModel);
    }

    public interface e {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(String str, String str2);

        void a(CJRAadharPanGet cJRAadharPanGet);

        void a(CJRUserInfo cJRUserInfo);

        void a(CJRUserInfoV2 cJRUserInfoV2);

        void b();

        void b(NetworkCustomError networkCustomError);

        void c();

        void d();
    }

    public interface f {
        void a();

        void a(CersaiDetails cersaiDetails);

        void b();
    }
}
