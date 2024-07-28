package net.one97.paytm.upi.mandate.p2p;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.mandate.data.a;
import net.one97.paytm.upi.mandate.utils.g;
import net.one97.paytm.upi.mandate.utils.n;
import net.one97.paytm.upi.mandate.utils.p;
import net.one97.paytm.upi.mandate.utils.q;
import net.one97.paytm.upi.profile.b.a;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    String f67314a = "EXACT";

    /* renamed from: b  reason: collision with root package name */
    BankAccountDetails.BankAccount f67315b;

    /* renamed from: c  reason: collision with root package name */
    p f67316c = p.MONTHLY;

    /* renamed from: d  reason: collision with root package name */
    q f67317d = q.ON;

    /* renamed from: e  reason: collision with root package name */
    n f67318e = n.RECURRING;

    /* renamed from: f  reason: collision with root package name */
    int f67319f = -1;

    /* renamed from: g  reason: collision with root package name */
    final p[] f67320g = p.values();

    /* renamed from: h  reason: collision with root package name */
    final q[] f67321h = q.values();

    /* renamed from: i  reason: collision with root package name */
    final n[] f67322i = n.values();
    /* access modifiers changed from: package-private */
    public UpiProfileModel j;
    String k = "";
    String l = "";
    /* access modifiers changed from: package-private */
    public final y<net.one97.paytm.upi.mandate.data.a<x>> m = new y<>();
    /* access modifiers changed from: package-private */
    public List<? extends UpiProfileDefaultBank> n;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank o;
    /* access modifiers changed from: private */
    public String p = "";
    private final net.one97.paytm.upi.profile.b.a q;

    public c(net.one97.paytm.upi.profile.b.a aVar) {
        k.c(aVar, "upiProfileRepository");
        this.q = aVar;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f67314a = str;
    }

    public final UpiProfileDefaultBank a() {
        UpiProfileDefaultBank upiProfileDefaultBank = this.o;
        if (upiProfileDefaultBank == null) {
            k.a("_primaryBank");
        }
        return upiProfileDefaultBank;
    }

    public static final class a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67323a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        a(c cVar) {
            this.f67323a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            Object obj;
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (upiProfileModel.getResponse() != null) {
                    UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                    k.a((Object) response, "response.response");
                    UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                    k.a((Object) profileDetail, "response.response.profileDetail");
                    Collection profileVpaList = profileDetail.getProfileVpaList();
                    boolean z = true;
                    if (!(profileVpaList == null || profileVpaList.isEmpty())) {
                        UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                        k.a((Object) response2, "response.response");
                        UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                        k.a((Object) profileDetail2, "response.response.profileDetail");
                        Collection bankAccountList = profileDetail2.getBankAccountList();
                        if (bankAccountList != null && !bankAccountList.isEmpty()) {
                            z = false;
                        }
                        if (!z) {
                            this.f67323a.j = upiProfileModel;
                            c cVar = this.f67323a;
                            UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                            k.a((Object) response3, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail3 = response3.getProfileDetail();
                            k.a((Object) profileDetail3, "response.response.profileDetail");
                            List<UpiProfileDefaultBank> profileVpaList2 = profileDetail3.getProfileVpaList();
                            k.a((Object) profileVpaList2, "response.response.profileDetail.profileVpaList");
                            Iterator it2 = profileVpaList2.iterator();
                            while (true) {
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
                            if (upiProfileDefaultBank2 == null) {
                                UpiProfileModel.AccountDetails response4 = upiProfileModel.getResponse();
                                k.a((Object) response4, "response.response");
                                UpiProfileModel.ProfileDetails profileDetail4 = response4.getProfileDetail();
                                k.a((Object) profileDetail4, "response.response.profileDetail");
                                UpiProfileDefaultBank upiProfileDefaultBank3 = profileDetail4.getProfileVpaList().get(0);
                                k.a((Object) upiProfileDefaultBank3, "response.response.profileDetail.profileVpaList[0]");
                                upiProfileDefaultBank2 = upiProfileDefaultBank3;
                            }
                            cVar.o = upiProfileDefaultBank2;
                            c cVar2 = this.f67323a;
                            String virtualAddress = cVar2.a().getVirtualAddress();
                            k.a((Object) virtualAddress, "primaryBank.virtualAddress");
                            cVar2.p = virtualAddress;
                            c cVar3 = this.f67323a;
                            UpiProfileModel.AccountDetails response5 = upiProfileModel.getResponse();
                            k.a((Object) response5, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail5 = response5.getProfileDetail();
                            k.a((Object) profileDetail5, "response.response.profileDetail");
                            ArrayList<BankAccountDetails.BankAccount> bankAccountList2 = profileDetail5.getBankAccountList();
                            k.a((Object) bankAccountList2, "response.response.profileDetail.bankAccountList");
                            Iterable<BankAccountDetails.BankAccount> iterable = bankAccountList2;
                            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
                            for (BankAccountDetails.BankAccount debitBank : iterable) {
                                UpiProfileDefaultBank upiProfileDefaultBank4 = new UpiProfileDefaultBank();
                                upiProfileDefaultBank4.setVirtualAddress(this.f67323a.p);
                                upiProfileDefaultBank4.setDebitBank(debitBank);
                                arrayList.add(upiProfileDefaultBank4);
                            }
                            cVar3.n = (List) arrayList;
                            y b2 = this.f67323a.m;
                            a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
                            b2.setValue(a.C1355a.a(x.f47997a, false));
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        y<net.one97.paytm.upi.mandate.data.a<x>> yVar = this.m;
        a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
        yVar.setValue(a.C1355a.a(false));
        this.q.a(new a(this), "", "");
    }

    public final String a(int i2, int i3, int i4, g gVar) {
        k.c(gVar, "mandateDateType");
        Calendar instance = Calendar.getInstance();
        instance.set(1, i2);
        instance.set(2, i3);
        instance.set(5, i4);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
        k.a((Object) instance, "calendar");
        String format = simpleDateFormat.format(Long.valueOf(instance.getTimeInMillis()));
        int i5 = d.f67324a[gVar.ordinal()];
        if (i5 == 1) {
            k.a((Object) format, "updatedDate");
            this.k = format;
        } else if (i5 == 2) {
            k.a((Object) format, "updatedDate");
            this.l = format;
        }
        String format2 = new SimpleDateFormat("dd MMM''yy", Locale.getDefault()).format(Long.valueOf(instance.getTimeInMillis()));
        k.a((Object) format2, "SimpleDateFormat(FORMAT_…at(calendar.timeInMillis)");
        return format2;
    }

    /* access modifiers changed from: package-private */
    public final Calendar c() {
        Date parse = new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).parse(this.k);
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "calendar");
        instance.setTime(parse);
        return instance;
    }

    public final List<UpiProfileDefaultBank> d() {
        if (this.f67318e == n.RECURRING) {
            List<? extends UpiProfileDefaultBank> list = this.n;
            if (list == null) {
                k.a("UpiDefaultBankMappedList");
            }
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                BankAccountDetails.BankAccount debitBank = ((UpiProfileDefaultBank) next).getDebitBank();
                k.a((Object) debitBank, "it.debitBank");
                List<String> bankFilterList = debitBank.getBankFilterList();
                if (bankFilterList != null ? bankFilterList.contains("SUBSCRIPTION") : false) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
        List<? extends UpiProfileDefaultBank> list2 = this.n;
        if (list2 == null) {
            k.a("UpiDefaultBankMappedList");
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : list2) {
            BankAccountDetails.BankAccount debitBank2 = ((UpiProfileDefaultBank) next2).getDebitBank();
            k.a((Object) debitBank2, "it.debitBank");
            List<String> bankFilterList2 = debitBank2.getBankFilterList();
            if (bankFilterList2 != null ? bankFilterList2.contains("OTM") : false) {
                arrayList2.add(next2);
            }
        }
        return (List) arrayList2;
    }
}
