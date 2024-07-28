package net.one97.paytm.p2b.e;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import io.reactivex.rxjava3.a.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.P2B.P2bLimitStatusModel;
import net.one97.paytm.P2B.SendMoneyP2PLimitStatusResponseObjectModel;
import net.one97.paytm.cashback.posttxn.CashbackBaseTagOfferListModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2b.data.Bean.BannerTypes;
import net.one97.paytm.p2b.data.a;
import net.one97.paytm.p2b.data.a.a;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.p2b.data.a.a f12767a;

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.paytm.p2b.data.a<Integer>> f12768b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<net.one97.paytm.p2b.data.a<ArrayList<BeneficiaryEntity>>> f12769c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<net.one97.paytm.p2b.data.a<ArrayList<BeneficiaryEntity>>> f12770d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<Boolean> f12771e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public Boolean f12772f = Boolean.FALSE;

    /* renamed from: g  reason: collision with root package name */
    public y<Boolean> f12773g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<Boolean> f12774h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<o<Boolean, String>> f12775i = new y<>();
    public y<NetworkCustomError> j = new y<>();
    public final y<o<List<View>, StoreFrontGAHandler>> k = new y<>();
    public final y<o<List<View>, StoreFrontGAHandler>> l = new y<>();
    public y<CJRAddBeneficiary.CJRAddBeneficiarySubError> m = new y<>();
    public BeneficiaryEntity n;
    public String o;
    public String p;
    public final y<String> q = new y<>();
    public CJRP2BStatus r;
    /* access modifiers changed from: private */
    public y<Integer> s = new y<>();
    /* access modifiers changed from: private */
    public BannerTypes t;
    private final String u = getClass().getName();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
        this.f12767a = net.one97.paytm.p2b.data.a.b.a((Context) application);
    }

    public final void a(BannerTypes bannerTypes, String str, String str2) {
        k.c(bannerTypes, "bannerTypes");
        k.c(str, "url");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.t = bannerTypes;
        net.one97.paytm.p2b.data.a.a aVar = this.f12767a;
        if (aVar != null) {
            aVar.a(str, (Context) getApplication(), (com.paytm.network.listener.b) new c(this, str2), "P2b");
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12778a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12779b;

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }

        c(a aVar, String str) {
            this.f12778a = aVar;
            this.f12779b = str;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            HomeResponse homeResponse;
            BannerTypes a2;
            try {
                if ((iJRPaytmDataModel instanceof StringResponseModel) && (homeResponse = (HomeResponse) net.one97.paytm.p2b.d.k.a(((StringResponseModel) iJRPaytmDataModel).getRawResponse(), HomeResponse.class)) != null) {
                    SanitizedResponseModel sanitizedResponse$default = SFInterface.getSanitizedResponse$default(SFInterface.INSTANCE, homeResponse, false, this.f12779b, 0, (IGAEnableListener) null, 26, (Object) null);
                    List<View> rvWidgets = sanitizedResponse$default.getRvWidgets();
                    if ((!rvWidgets.isEmpty()) && (a2 = this.f12778a.t) != null) {
                        int i2 = b.f12784a[a2.ordinal()];
                        if (i2 == 1) {
                            this.f12778a.k.setValue(new o(rvWidgets, sanitizedResponse$default.getGaListener()));
                        } else if (i2 == 2) {
                            this.f12778a.l.setValue(new o(rvWidgets, sanitizedResponse$default.getGaListener()));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12777a;

        public b(a aVar) {
            this.f12777a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f12777a.q.setValue("");
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            try {
                if (iJRPaytmDataModel instanceof CashbackBaseTagOfferListModel) {
                    this.f12777a.q.setValue(a.a((CashbackBaseTagOfferListModel) iJRPaytmDataModel));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final class d implements a.C0169a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12780a;

        d(a aVar) {
            this.f12780a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0043, code lost:
            if (kotlin.m.p.a(r2.getErrorCode(), "B-1003", true) != false) goto L_0x0045;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.paytm.network.model.IJRPaytmDataModel r6) {
            /*
                r5 = this;
                java.lang.String r0 = "kycBeneficiaryBase.error"
                r1 = 0
                if (r6 == 0) goto L_0x0091
                net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase r6 = (net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase) r6     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.p2b.e.a r2 = r5.f12780a     // Catch:{ Exception -> 0x0099 }
                androidx.lifecycle.y r2 = r2.s     // Catch:{ Exception -> 0x0099 }
                int r3 = r6.getTotalCount()     // Catch:{ Exception -> 0x0099 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0099 }
                r2.setValue(r3)     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase$CJRKYCBeneficiaryError r2 = r6.getError()     // Catch:{ Exception -> 0x0099 }
                if (r2 == 0) goto L_0x0055
                net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase$CJRKYCBeneficiaryError r2 = r6.getError()     // Catch:{ Exception -> 0x0099 }
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0099 }
                java.lang.String r2 = r2.getErrorCode()     // Catch:{ Exception -> 0x0099 }
                java.lang.String r3 = "B-1002"
                r4 = 1
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)     // Catch:{ Exception -> 0x0099 }
                if (r2 != 0) goto L_0x0045
                net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase$CJRKYCBeneficiaryError r2 = r6.getError()     // Catch:{ Exception -> 0x0099 }
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = r2.getErrorCode()     // Catch:{ Exception -> 0x0099 }
                java.lang.String r2 = "B-1003"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r4)     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x0055
            L_0x0045:
                net.one97.paytm.p2b.e.a r6 = r5.f12780a     // Catch:{ Exception -> 0x0099 }
                androidx.lifecycle.y r6 = r6.f12768b     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.p2b.data.a$a r0 = net.one97.paytm.p2b.data.a.f12728d     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.p2b.data.a r0 = net.one97.paytm.p2b.data.a.C0168a.a((com.paytm.network.model.NetworkCustomError) r1)     // Catch:{ Exception -> 0x0099 }
                r6.setValue(r0)     // Catch:{ Exception -> 0x0099 }
                return
            L_0x0055:
                net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase$CJRKYCBeneficiaryError r0 = r6.getError()     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x006b
                net.one97.paytm.p2b.e.a r6 = r5.f12780a     // Catch:{ Exception -> 0x0099 }
                androidx.lifecycle.y r6 = r6.f12768b     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.p2b.data.a$a r0 = net.one97.paytm.p2b.data.a.f12728d     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.p2b.data.a r0 = net.one97.paytm.p2b.data.a.C0168a.a((com.paytm.network.model.NetworkCustomError) r1)     // Catch:{ Exception -> 0x0099 }
                r6.setValue(r0)     // Catch:{ Exception -> 0x0099 }
                return
            L_0x006b:
                java.util.ArrayList r0 = r6.getBeneficiariesList()     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x0081
                java.util.ArrayList r0 = r6.getBeneficiariesList()     // Catch:{ Exception -> 0x0099 }
                int r0 = r0.size()     // Catch:{ Exception -> 0x0099 }
                if (r0 <= 0) goto L_0x0081
                net.one97.paytm.p2b.e.a r0 = r5.f12780a     // Catch:{ Exception -> 0x0099 }
                r0.a((net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase) r6)     // Catch:{ Exception -> 0x0099 }
                return
            L_0x0081:
                net.one97.paytm.p2b.e.a r6 = r5.f12780a     // Catch:{ Exception -> 0x0099 }
                androidx.lifecycle.y r6 = r6.f12768b     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.p2b.data.a$a r0 = net.one97.paytm.p2b.data.a.f12728d     // Catch:{ Exception -> 0x0099 }
                net.one97.paytm.p2b.data.a r0 = net.one97.paytm.p2b.data.a.C0168a.a((com.paytm.network.model.NetworkCustomError) r1)     // Catch:{ Exception -> 0x0099 }
                r6.setValue(r0)     // Catch:{ Exception -> 0x0099 }
                return
            L_0x0091:
                kotlin.u r6 = new kotlin.u     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase"
                r6.<init>(r0)     // Catch:{ Exception -> 0x0099 }
                throw r6     // Catch:{ Exception -> 0x0099 }
            L_0x0099:
                net.one97.paytm.p2b.e.a r6 = r5.f12780a
                androidx.lifecycle.y r6 = r6.f12768b
                net.one97.paytm.p2b.data.a$a r0 = net.one97.paytm.p2b.data.a.f12728d
                net.one97.paytm.p2b.data.a r0 = net.one97.paytm.p2b.data.a.C0168a.a((com.paytm.network.model.NetworkCustomError) r1)
                r6.setValue(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.e.a.d.a(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f12780a.s.setValue(0);
            y c2 = this.f12780a.f12768b;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            c2.setValue(a.C0168a.a(networkCustomError));
        }
    }

    public final void a() {
        y<net.one97.paytm.p2b.data.a<Integer>> yVar = this.f12768b;
        a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
        yVar.setValue(a.C0168a.a());
        net.one97.paytm.p2b.data.a.a aVar2 = this.f12767a;
        if (aVar2 != null) {
            aVar2.a(new d(this), this.u);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void a(CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase) {
        ArrayList arrayList = new ArrayList();
        Iterator<BeneficiaryEntity> it2 = cJRKYCBeneficiaryBase.getBeneficiariesList().iterator();
        while (it2.hasNext()) {
            BeneficiaryEntity next = it2.next();
            if (next.instrumentPreferences.otherBank != null) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            io.reactivex.rxjava3.a.y.a(new e(arrayList)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new f(this, arrayList));
        }
    }

    public static final class e implements Callable<ArrayList<BeneficiaryEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f12781a;

        e(ArrayList arrayList) {
            this.f12781a = arrayList;
        }

        public final /* synthetic */ Object call() {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.f12781a.iterator();
            while (it2.hasNext()) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) it2.next();
                if (beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).self) {
                    arrayList.add(beneficiaryEntity);
                }
            }
            return arrayList;
        }
    }

    public static final class f implements aa<ArrayList<BeneficiaryEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12782a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f12783b;

        public final void onError(Throwable th) {
            k.c(th, "e");
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            k.c(cVar, "d");
        }

        f(a aVar, ArrayList arrayList) {
            this.f12782a = aVar;
            this.f12783b = arrayList;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                this.f12783b.removeAll(arrayList);
            }
            int size = this.f12783b.size();
            if (arrayList != null) {
                size += arrayList.size();
            }
            y c2 = this.f12782a.f12768b;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            c2.setValue(a.C0168a.a((Object) Integer.valueOf(size)));
            y d2 = this.f12782a.f12769c;
            a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
            d2.setValue(a.C0168a.a((Object) arrayList));
            y e2 = this.f12782a.f12770d;
            a.C0168a aVar3 = net.one97.paytm.p2b.data.a.f12728d;
            e2.setValue(a.C0168a.a((Object) this.f12783b));
        }
    }

    public final void a(Boolean bool) {
        if (bool != null) {
            this.f12773g.setValue(Boolean.valueOf(bool.booleanValue()));
        }
    }

    public final void b(Boolean bool) {
        if (bool != null) {
            this.f12771e.setValue(Boolean.valueOf(bool.booleanValue()));
        }
    }

    /* renamed from: net.one97.paytm.p2b.e.a$a  reason: collision with other inner class name */
    public static final class C0170a implements a.C0169a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12776a;

        public C0170a(a aVar) {
            this.f12776a = aVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            boolean z;
            P2bLimitStatusModel p2bLimitStatusModel = (P2bLimitStatusModel) iJRPaytmDataModel;
            if (p2bLimitStatusModel == null || p2bLimitStatusModel.getResponse() == null) {
                this.f12776a.f12775i.postValue(new o(Boolean.FALSE, null));
                return;
            }
            Iterator<SendMoneyP2PLimitStatusResponseObjectModel> it2 = p2bLimitStatusModel.getResponse().iterator();
            String str = null;
            loop0:
            while (true) {
                z = false;
                while (true) {
                    if (!it2.hasNext()) {
                        break loop0;
                    }
                    SendMoneyP2PLimitStatusResponseObjectModel next = it2.next();
                    if (next.isLimitApplicable()) {
                        str = next.getMessage();
                    }
                    if (z || next.isLimitApplicable()) {
                        z = true;
                    }
                }
            }
            if (z) {
                this.f12776a.f12775i.postValue(new o(Boolean.FALSE, str));
            } else {
                this.f12776a.f12774h.postValue(Boolean.TRUE);
            }
        }

        public final void a(NetworkCustomError networkCustomError) {
            this.f12776a.j.postValue(networkCustomError);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r2 = (r2 = (r2 = (r2 = (r2 = (r2 = r2.getData()).getMyOffers()).get(0)).getInfo()).getCampaign()).getShortDescription();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.String a(net.one97.paytm.cashback.posttxn.CashbackBaseTagOfferListModel r2) {
        /*
            if (r2 == 0) goto L_0x0037
            int r0 = r2.getStatus()
            r1 = 1
            if (r0 != r1) goto L_0x0037
            net.one97.paytm.cashback.posttxn.CashbackTagOffersListModel r2 = r2.getData()
            if (r2 == 0) goto L_0x0037
            java.util.ArrayList r2 = r2.getMyOffers()
            if (r2 == 0) goto L_0x0037
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x0037
            r0 = 0
            java.lang.Object r2 = r2.get(r0)
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r2 = (net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4) r2
            if (r2 == 0) goto L_0x0037
            net.one97.paytm.cashback.posttxn.InfoV4 r2 = r2.getInfo()
            if (r2 == 0) goto L_0x0037
            net.one97.paytm.cashback.posttxn.Campaign r2 = r2.getCampaign()
            if (r2 == 0) goto L_0x0037
            java.lang.String r2 = r2.getShortDescription()
            if (r2 == 0) goto L_0x0037
            return r2
        L_0x0037:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.e.a.a(net.one97.paytm.cashback.posttxn.CashbackBaseTagOfferListModel):java.lang.String");
    }
}
