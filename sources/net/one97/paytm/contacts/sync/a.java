package net.one97.paytm.contacts.sync;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.paytm.contactsSdk.database.Tables;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.contacts.entities.beans.ContactBeneficiaryBean;
import net.one97.paytm.contacts.entities.beans.ContactDelete;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.ContactHealthResponse;
import net.one97.paytm.contacts.entities.beans.Contacts;
import net.one97.paytm.contacts.utils.ContactUpload;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.network.b;
import net.one97.paytm.network.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50159a = new a();

    private a() {
    }

    public static LiveData<f> a(Context context, String str, int i2, int i3, int i4, long j) throws IllegalArgumentException {
        String name;
        k.c(context, "context");
        k.c(str, "url");
        if (i3 > 0) {
            if (i4 == e.b.PHONEBOOK.getType()) {
                name = e.b.PHONEBOOK.name();
            } else if (i4 == e.b.TRANSFER_BENEFICIARY.getType()) {
                name = e.b.TRANSFER_BENEFICIARY.name();
            } else if (i4 == e.b.BENEFICIARY.getType()) {
                name = e.b.BENEFICIARY.name();
            } else {
                throw new IllegalArgumentException("Contact Type is not supported");
            }
            String str2 = name;
            g gVar = g.f50203a;
            g gVar2 = g.f50203a;
            b bVar = new b(str, new ContactBeneficiaryBean(), (Map<String, String>) null, g.a(context), g.a(str2, i3, i2, j, context));
            bVar.e();
            bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
            return bVar.a();
        }
        throw new IllegalArgumentException("Invalid limit value");
    }

    public static LiveData<f> a(Context context, ContactUpload contactUpload) {
        k.c(context, "context");
        k.c(contactUpload, "contactUpload");
        g gVar = g.f50203a;
        b bVar = new b(com.paytm.utility.b.e(context, net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "addPhoneBookContactUrl_V2")), new ContactBeneficiaryBean(), (Map<String, String>) null, g.a(context), new com.google.gsonhtcfix.f().a((Object) contactUpload));
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        return bVar.a();
    }

    public static LiveData<f> a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deleteContact");
        g gVar = g.f50203a;
        b bVar = new b(com.paytm.utility.b.e(context, net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "deletePhonebookContactUrl_V2")), new ContactDelete(), (Map<String, String>) null, g.a(context), str);
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        return bVar.a();
    }

    public static LiveData<f> a(Context context, ContactDetail contactDetail) {
        k.c(context, "context");
        k.c(contactDetail, "item");
        g gVar = g.f50203a;
        g gVar2 = g.f50203a;
        b bVar = new b(com.paytm.utility.b.e(context, net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "deleteBeneficiaryUrl_V2")), new ContactBeneficiaryBean(), (Map<String, String>) null, g.a(context), g.a(context, contactDetail));
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        return bVar.a();
    }

    public static LiveData<f> a(Context context, ArrayList<Contacts> arrayList, int i2) {
        String str;
        k.c(context, "context");
        k.c(arrayList, Tables.CONTACTS);
        if (i2 == e.b.TRANSFER_BENEFICIARY.getType()) {
            str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "benfHealthAPIUrl_V2");
            k.a((Object) str, "WalletCommManager.getWal…t, \"benfHealthAPIUrl_V2\")");
        } else {
            str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "contactHealthAPIUrl_V2");
            k.a((Object) str, "WalletCommManager.getWal…\"contactHealthAPIUrl_V2\")");
        }
        String e2 = com.paytm.utility.b.e(context, str);
        k.a((Object) e2, "CJRAppCommonUtility.addA…faultParams(context, url)");
        g gVar = g.f50203a;
        g gVar2 = g.f50203a;
        b bVar = new b(e2, new ContactHealthResponse(), (Map<String, String>) null, g.a(context), g.a(context, arrayList));
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        return bVar.a();
    }
}
