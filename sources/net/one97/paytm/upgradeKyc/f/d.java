package net.one97.paytm.upgradeKyc.f;

import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;

public interface d {
    void a();

    void a(NetworkCustomError networkCustomError);

    void a(ArrayList<PayTMPartnerListModal.Response> arrayList);

    void b();
}
