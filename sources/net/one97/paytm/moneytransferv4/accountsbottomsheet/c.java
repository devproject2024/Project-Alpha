package net.one97.paytm.moneytransferv4.accountsbottomsheet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.profile.b.a;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final net.one97.paytm.upi.registration.b.a.a f55020a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<List<UpiProfileDefaultBank>>> f55021b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private final LiveData<net.one97.paytm.moneytransfer.model.c<List<UpiProfileDefaultBank>>> f55022c = this.f55021b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f55023d;

    /* renamed from: e  reason: collision with root package name */
    private final net.one97.paytm.upi.profile.b.a f55024e;

    public c(net.one97.paytm.upi.profile.b.a aVar, net.one97.paytm.upi.registration.b.a.a aVar2) {
        k.c(aVar, "profileRepository");
        k.c(aVar2, "registrationRepository");
        this.f55024e = aVar;
        this.f55020a = aVar2;
    }

    public final String a() {
        String str = this.f55023d;
        return str == null ? "" : str;
    }

    public static final class a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55025a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
        }

        a(c cVar) {
            this.f55025a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            String str;
            Object obj;
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (k.a((Object) upiProfileModel.getRespCode(), (Object) "0")) {
                    boolean z = true;
                    if (p.a(upiProfileModel.getStatus(), "SUCCESS", true) && upiProfileModel.getResponse() != null) {
                        UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                        k.a((Object) response, "response.response");
                        UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                        k.a((Object) profileDetail, "response.response.profileDetail");
                        Collection bankAccountList = profileDetail.getBankAccountList();
                        if (!(bankAccountList == null || bankAccountList.isEmpty())) {
                            UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                            k.a((Object) response2, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                            k.a((Object) profileDetail2, "response.response.profileDetail");
                            Collection profileVpaList = profileDetail2.getProfileVpaList();
                            if (profileVpaList != null && !profileVpaList.isEmpty()) {
                                z = false;
                            }
                            if (!z) {
                                c cVar = this.f55025a;
                                UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                                k.a((Object) response3, "response.response");
                                UpiProfileModel.ProfileDetails profileDetail3 = response3.getProfileDetail();
                                k.a((Object) profileDetail3, "response.response.profileDetail");
                                List<UpiProfileDefaultBank> profileVpaList2 = profileDetail3.getProfileVpaList();
                                k.a((Object) profileVpaList2, "response.response.profileDetail.profileVpaList");
                                Iterator it2 = profileVpaList2.iterator();
                                while (true) {
                                    str = null;
                                    if (!it2.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it2.next();
                                    UpiProfileDefaultBank upiProfileDefaultBank = (UpiProfileDefaultBank) obj;
                                    k.a((Object) upiProfileDefaultBank, "it");
                                    if (upiProfileDefaultBank.isPrimary()) {
                                        break;
                                    }
                                }
                                UpiProfileDefaultBank upiProfileDefaultBank2 = (UpiProfileDefaultBank) obj;
                                if (upiProfileDefaultBank2 != null) {
                                    str = upiProfileDefaultBank2.getVirtualAddress();
                                }
                                cVar.f55023d = str;
                                if (this.f55025a.f55023d == null) {
                                    c cVar2 = this.f55025a;
                                    UpiProfileModel.AccountDetails response4 = upiProfileModel.getResponse();
                                    k.a((Object) response4, "response.response");
                                    UpiProfileModel.ProfileDetails profileDetail4 = response4.getProfileDetail();
                                    k.a((Object) profileDetail4, "response.response.profileDetail");
                                    UpiProfileDefaultBank upiProfileDefaultBank3 = profileDetail4.getProfileVpaList().get(0);
                                    k.a((Object) upiProfileDefaultBank3, "response.response.profileDetail.profileVpaList[0]");
                                    cVar2.f55023d = upiProfileDefaultBank3.getVirtualAddress();
                                }
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                UpiProfileModel.AccountDetails response5 = upiProfileModel.getResponse();
                                k.a((Object) response5, "response.response");
                                UpiProfileModel.ProfileDetails profileDetail5 = response5.getProfileDetail();
                                k.a((Object) profileDetail5, "response.response.profileDetail");
                                for (UpiProfileDefaultBank next : profileDetail5.getProfileVpaList()) {
                                    k.a((Object) next, "upiProfileDefaultBank");
                                    if (next.getDebitBank() != null) {
                                        BankAccountDetails.BankAccount debitBank = next.getDebitBank();
                                        k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
                                        if (debitBank.getAccount() != null) {
                                            BankAccountDetails.BankAccount debitBank2 = next.getDebitBank();
                                            k.a((Object) debitBank2, "upiProfileDefaultBank.debitBank");
                                            String account = debitBank2.getAccount();
                                            k.a((Object) account, "upiProfileDefaultBank.debitBank.account");
                                            linkedHashMap.put(account, next);
                                        }
                                    }
                                }
                                UpiProfileModel.AccountDetails response6 = upiProfileModel.getResponse();
                                k.a((Object) response6, "response.response");
                                UpiProfileModel.ProfileDetails profileDetail6 = response6.getProfileDetail();
                                k.a((Object) profileDetail6, "response.response.profileDetail");
                                if (profileDetail6.getBankAccountList() != null) {
                                    UpiProfileModel.AccountDetails response7 = upiProfileModel.getResponse();
                                    k.a((Object) response7, "response.response");
                                    UpiProfileModel.ProfileDetails profileDetail7 = response7.getProfileDetail();
                                    k.a((Object) profileDetail7, "response.response.profileDetail");
                                    ArrayList<BankAccountDetails.BankAccount> bankAccountList2 = profileDetail7.getBankAccountList();
                                    k.a((Object) bankAccountList2, "response.response.profileDetail.bankAccountList");
                                    for (BankAccountDetails.BankAccount debitBank3 : bankAccountList2) {
                                        UpiProfileDefaultBank upiProfileDefaultBank4 = new UpiProfileDefaultBank();
                                        upiProfileDefaultBank4.setDebitBank(debitBank3);
                                        upiProfileDefaultBank4.setVirtualAddress(this.f55025a.f55023d);
                                        BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank4.getDebitBank();
                                        k.a((Object) debitBank4, "upiProfileDefaultBank.debitBank");
                                        String account2 = debitBank4.getAccount();
                                        k.a((Object) account2, "upiProfileDefaultBank.debitBank.account");
                                        linkedHashMap.put(account2, upiProfileDefaultBank4);
                                    }
                                }
                                ArrayList arrayList = new ArrayList();
                                for (Map.Entry value : linkedHashMap.entrySet()) {
                                    arrayList.add(value.getValue());
                                }
                                y b2 = this.f55025a.f55021b;
                                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                                b2.setValue(c.a.a(arrayList));
                            }
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        y<net.one97.paytm.moneytransfer.model.c<List<UpiProfileDefaultBank>>> yVar = this.f55021b;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        this.f55024e.a(new a(this), "", "");
    }

    public final boolean c() {
        return this.f55020a.e();
    }
}
