package net.one97.paytm.moneytransferv4.home.presentation.viewmodel;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.MTBeneficiaryViewAll;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.PendingRequestsModel;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;

public final class d extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final w<net.one97.paytm.moneytransfer.model.c<ArrayList<e<RecyclerView.v>>>> f55627a = new w<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<ArrayList<ContactsResponse>> f55628b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<List<AccountProviderBody.AccountProvider>> f55629c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<ArrayList<BankAccountDetails.BankAccount>> f55630d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public String f55631e = "";

    /* renamed from: f  reason: collision with root package name */
    public final y<ArrayList<UpiPendingRequestModel>> f55632f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public final net.one97.paytm.upi.registration.b.a.a f55633g;

    /* renamed from: h  reason: collision with root package name */
    public final net.one97.paytm.upi.passbook.b.a.b.a f55634h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f55635i;
    /* access modifiers changed from: private */
    public final net.one97.paytm.moneytransferv4.a.b.a j;
    private final net.one97.paytm.moneytransferv4.c.a.a k;
    private final net.one97.paytm.upi.profile.b.a l;

    public d(net.one97.paytm.moneytransferv4.a.b.a aVar, net.one97.paytm.moneytransferv4.c.a.a aVar2, net.one97.paytm.upi.registration.b.a.a aVar3, net.one97.paytm.upi.profile.b.a aVar4, net.one97.paytm.upi.passbook.b.a.b.a aVar5, Context context) {
        k.c(aVar, "beneficiaryRepository");
        k.c(aVar2, "contactsRepository");
        k.c(aVar3, "registrationRepository");
        k.c(aVar4, "profileRepository");
        k.c(aVar5, "upiPassbookRemoteDataSource");
        k.c(context, "context");
        this.j = aVar;
        this.k = aVar2;
        this.f55633g = aVar3;
        this.l = aVar4;
        this.f55634h = aVar5;
        this.f55635i = context;
    }

    public final void a() {
        this.k.a(this.f55627a);
    }

    public final void b() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new a(this, (kotlin.d.d) null), 3, (Object) null);
    }

    public final boolean c() {
        return this.f55633g.e();
    }

    public final boolean d() {
        return this.f55633g.f();
    }

    public final boolean e() {
        return this.f55633g.h();
    }

    /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d$d  reason: collision with other inner class name */
    public static final class C1033d implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55638a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
        }

        C1033d(d dVar) {
            this.f55638a = dVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            String str;
            Object obj;
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (k.a((Object) upiProfileModel.getRespCode(), (Object) "0") && p.a(upiProfileModel.getStatus(), "SUCCESS", true) && upiProfileModel.getResponse() != null) {
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
                        if (!(profileVpaList == null || profileVpaList.isEmpty())) {
                            UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                            k.a((Object) response3, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail3 = response3.getProfileDetail();
                            k.a((Object) profileDetail3, "response.response.profileDetail");
                            ArrayList<BankAccountDetails.BankAccount> bankAccountList2 = profileDetail3.getBankAccountList();
                            d dVar = this.f55638a;
                            UpiProfileModel.AccountDetails response4 = upiProfileModel.getResponse();
                            k.a((Object) response4, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail4 = response4.getProfileDetail();
                            k.a((Object) profileDetail4, "response.response.profileDetail");
                            List<UpiProfileDefaultBank> profileVpaList2 = profileDetail4.getProfileVpaList();
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
                            dVar.f55631e = str;
                            CharSequence charSequence = this.f55638a.f55631e;
                            if (charSequence == null || charSequence.length() == 0) {
                                d dVar2 = this.f55638a;
                                UpiProfileModel.AccountDetails response5 = upiProfileModel.getResponse();
                                k.a((Object) response5, "response.response");
                                UpiProfileModel.ProfileDetails profileDetail5 = response5.getProfileDetail();
                                k.a((Object) profileDetail5, "response.response.profileDetail");
                                UpiProfileDefaultBank upiProfileDefaultBank3 = profileDetail5.getProfileVpaList().get(0);
                                k.a((Object) upiProfileDefaultBank3, "response.response.profileDetail.profileVpaList[0]");
                                dVar2.f55631e = upiProfileDefaultBank3.getVirtualAddress();
                            }
                            k.a((Object) bankAccountList2, "list");
                            Collection arrayList = new ArrayList();
                            for (Object next : bankAccountList2) {
                                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) next;
                                k.a((Object) bankAccount, "it");
                                if (!bankAccount.isMpinSet()) {
                                    arrayList.add(next);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList((List) arrayList);
                            if (!arrayList2.isEmpty()) {
                                this.f55638a.f55630d.setValue(arrayList2);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void f() {
        this.l.a(new C1033d(this), "SELF_ACCOUNTS_TAG", "");
    }

    public static final class b implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55636a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
        }

        public b(d dVar) {
            this.f55636a = dVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof AccountProviderBody.AccountProviderDetails) {
                AccountProviderBody.AccountProviderDetails accountProviderDetails = (AccountProviderBody.AccountProviderDetails) upiBaseDataModel;
                if (accountProviderDetails.getProviders() != null && accountProviderDetails.getProviders().size() > 0) {
                    d dVar = this.f55636a;
                    List<AccountProviderBody.AccountProvider> topProviders = accountProviderDetails.getTopProviders();
                    k.a((Object) topProviders, "accountProviderDetails.topProviders");
                    dVar.f55629c.setValue(topProviders);
                }
            }
        }
    }

    public static int g() {
        c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
        return net.one97.paytm.moneytransfer.d.c.b(c.a.a().w);
    }

    public static final class c implements a.C1379a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55637a;

        public c(d dVar) {
            this.f55637a = dVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof PendingRequestsModel.PendingRequests) {
                PendingRequestsModel.PendingRequests pendingRequests = (PendingRequestsModel.PendingRequests) upiBaseDataModel;
                if (pendingRequests.getPendingRequests().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<UpiPendingRequestModel> it2 = pendingRequests.getPendingRequests().iterator();
                    while (it2.hasNext()) {
                        UpiPendingRequestModel next = it2.next();
                        k.a((Object) next, "request");
                        if (!p.a(next.getDirection(), "INITIATED", true)) {
                            arrayList.add(next);
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.f55637a.f55632f.setValue(arrayList);
                    } else {
                        this.f55637a.f55632f.setValue(null);
                    }
                } else {
                    this.f55637a.f55632f.setValue(null);
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            this.f55637a.f55632f.setValue(null);
        }
    }

    @kotlin.d.b.a.f(b = "MoneyTransferV4ViewModel.kt", c = {73}, d = "invokeSuspend", e = "net.one97.paytm.moneytransferv4.home.presentation.viewmodel.MoneyTransferV4ViewModel$fetchBeneficiaries$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar, kotlin.d.d dVar2) {
            super(2, dVar2);
            this.this$0 = dVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                net.one97.paytm.moneytransferv4.a.b.a a2 = this.this$0.j;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = a2.a(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                try {
                    ResultKt.a(obj);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.this$0.f55628b.setValue(null);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList == null || arrayList.size() == 0) {
                this.this$0.f55628b.setValue(arrayList);
            } else {
                arrayList.add(new MTBeneficiaryViewAll());
                this.this$0.f55628b.setValue(arrayList);
            }
            return x.f47997a;
        }
    }
}
