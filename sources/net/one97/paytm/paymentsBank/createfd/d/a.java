package net.one97.paytm.paymentsBank.createfd.d;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.createfd.c.c;
import net.one97.paytm.paymentsBank.createfd.model.CreateFdModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.createfd.utils.d;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;
import net.one97.paytm.paymentsBank.utils.j;

public final class a implements g.a, g.b<IJRPaytmDataModel>, c.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PBTncData> f18131a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f18132b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18133c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18134d;

    /* renamed from: e  reason: collision with root package name */
    private b.a.C0305a f18135e;

    /* renamed from: f  reason: collision with root package name */
    private String f18136f;

    /* renamed from: g  reason: collision with root package name */
    private String f18137g;

    /* renamed from: h  reason: collision with root package name */
    private SlfdMetaApiResponseModel f18138h;

    /* renamed from: i  reason: collision with root package name */
    private PBCJRAccountSummary f18139i;
    private String j;
    private final net.one97.paytm.paymentsBank.slfd.a.a.b k;
    private final c.b l;

    public a(net.one97.paytm.paymentsBank.slfd.a.a.b bVar, c.b bVar2) {
        k.c(bVar, "dataRepository");
        k.c(bVar2, "view");
        this.k = bVar;
        this.l = bVar2;
        b.a aVar = b.f18186a;
        this.f18136f = b.k;
        b.a aVar2 = b.f18186a;
        this.f18137g = b.k;
        if (j.a().equals("ISA")) {
            this.j = "isa";
        } else {
            this.j = "ica";
        }
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        Double d2 = null;
        if (iJRPaytmDataModel instanceof ValidateAmountLimit) {
            ValidateAmountLimit validateAmountLimit = (ValidateAmountLimit) iJRPaytmDataModel;
            if (!p.a(validateAmountLimit.getStatus(), "success", true)) {
                validateAmountLimit.getMessage();
                this.l.b(b.a.C0305a.FAILURE, validateAmountLimit.getMessage());
            } else if (validateAmountLimit.getLimitBreached()) {
                int responseCode = validateAmountLimit.getResponseCode();
                b.a aVar = b.f18186a;
                if (responseCode != b.w) {
                    int responseCode2 = validateAmountLimit.getResponseCode();
                    b.a aVar2 = b.f18186a;
                    if (responseCode2 != b.v) {
                        if (!TextUtils.isEmpty(validateAmountLimit.getMessage())) {
                            this.l.b(b.a.C0305a.FAILURE, validateAmountLimit.getMessage());
                            return;
                        } else {
                            this.l.b(b.a.C0305a.FAILURE, (String) null);
                            return;
                        }
                    }
                }
                this.l.b(b.a.C0305a.PAN_UPDATION_REQUIRED, validateAmountLimit.getMessage());
            } else {
                this.l.c();
            }
        } else if (iJRPaytmDataModel instanceof CreateFdModel) {
            this.l.a((CreateFdModel) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof PBCJRAccountSummary) {
            try {
                b.a.C0305a aVar3 = this.f18135e;
                if (aVar3 != null && aVar3 == b.a.C0305a.ADDMONEY_MODULE_RESPONSE) {
                    this.f18135e = null;
                    double effectiveBalance = ((PBCJRAccountSummary) iJRPaytmDataModel).getEffectiveBalance();
                    PBCJRAccountSummary pBCJRAccountSummary = this.f18139i;
                    if (pBCJRAccountSummary != null) {
                        d2 = Double.valueOf(pBCJRAccountSummary.getEffectiveBalance());
                    }
                    if (d2 == null) {
                        k.a();
                    }
                    double doubleValue = effectiveBalance - d2.doubleValue();
                    this.f18139i = (PBCJRAccountSummary) iJRPaytmDataModel;
                    if (doubleValue > 0.0d) {
                        c.b bVar = this.l;
                        b.a aVar4 = b.f18186a;
                        bVar.a(doubleValue, Integer.valueOf(b.f18187b));
                    } else {
                        c.b bVar2 = this.l;
                        b.a aVar5 = b.f18186a;
                        bVar2.a(doubleValue, Integer.valueOf(b.f18188c));
                    }
                }
            } catch (Exception unused) {
            }
            this.f18139i = (PBCJRAccountSummary) iJRPaytmDataModel;
            PBCJRAccountSummary pBCJRAccountSummary2 = this.f18139i;
            if (pBCJRAccountSummary2 != null) {
                double effectiveBalance2 = pBCJRAccountSummary2.getEffectiveBalance();
                try {
                    b.a aVar6 = b.f18186a;
                    this.f18136f = b.f18194i;
                    this.l.b(d.a(String.valueOf(effectiveBalance2)));
                } catch (Exception unused2) {
                    b.a aVar7 = b.f18186a;
                    this.f18136f = b.j;
                }
            } else {
                b.a aVar8 = b.f18186a;
                this.f18136f = b.j;
            }
            b.a.C0305a aVar9 = this.f18135e;
            if (aVar9 != null && aVar9 == b.a.C0305a.PROCESSING) {
                this.l.b();
            }
            g();
        } else if (iJRPaytmDataModel instanceof SlfdMetaApiResponseModel) {
            SlfdMetaApiResponseModel slfdMetaApiResponseModel = (SlfdMetaApiResponseModel) iJRPaytmDataModel;
            this.f18138h = slfdMetaApiResponseModel;
            b.a aVar10 = b.f18186a;
            this.f18137g = b.f18194i;
            this.l.a(slfdMetaApiResponseModel);
            b.a.C0305a aVar11 = this.f18135e;
            if (aVar11 != null && aVar11 == b.a.C0305a.PROCESSING) {
                this.l.b();
            }
            g();
        } else if (iJRPaytmDataModel instanceof FDProjectionListModel) {
            this.l.a((FDProjectionListModel) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof PBKYCFetchTnc) {
            this.l.a(false);
            PBKYCFetchTnc pBKYCFetchTnc = (PBKYCFetchTnc) iJRPaytmDataModel;
            if (pBKYCFetchTnc.getStatus() == null || !p.a(pBKYCFetchTnc.getStatus(), "error", true)) {
                if (pBKYCFetchTnc.getStatus() != null && p.a(pBKYCFetchTnc.getStatus(), "success", true) && pBKYCFetchTnc.getTncDataList() != null) {
                    this.f18131a.addAll(pBKYCFetchTnc.getTncDataList());
                    if (this.f18132b) {
                        this.l.a(this.f18131a);
                        this.f18132b = false;
                        return;
                    }
                    b(this.f18133c);
                }
            } else if (!TextUtils.isEmpty(pBKYCFetchTnc.getMessage())) {
                this.l.a("Error", pBKYCFetchTnc.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof PBKYCTncAccept) {
            this.l.a(false);
            PBKYCTncAccept pBKYCTncAccept = (PBKYCTncAccept) iJRPaytmDataModel;
            if (pBKYCTncAccept.getStatus() == null || !p.a(pBKYCTncAccept.getStatus(), "error", true)) {
                if (pBKYCTncAccept.getStatus() != null && p.a(pBKYCTncAccept.getStatus(), "success", true) && k.a((Object) pBKYCTncAccept.getResponseCode(), (Object) "2004")) {
                    this.f18134d = true;
                    this.l.b(this.f18133c);
                }
            } else if (!TextUtils.isEmpty(pBKYCTncAccept.getMessage())) {
                this.l.a("Error", pBKYCTncAccept.getMessage());
            }
        }
    }

    public final String e(String str) {
        k.c(str, "amount");
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        double parseDouble = Double.parseDouble(str);
        PBCJRAccountSummary pBCJRAccountSummary = this.f18139i;
        if (pBCJRAccountSummary == null) {
            return str;
        }
        if (pBCJRAccountSummary == null) {
            k.a();
        }
        double effectiveBalance = parseDouble - pBCJRAccountSummary.getEffectiveBalance();
        if (effectiveBalance <= 0.0d) {
            return str;
        }
        String ab = net.one97.paytm.bankCommon.mapping.a.ab(net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(effectiveBalance)));
        k.a((Object) ab, "CJRAppUtility.getCleanSt…lity.priceToString(diff))");
        return ab;
    }

    public final void a(boolean z) {
        this.f18132b = z;
        if (this.f18131a.size() > 0 && this.f18132b) {
            this.l.a(this.f18131a);
        } else if (this.f18131a.size() == 0) {
            this.l.a(true);
            this.k.d(this, this);
        }
    }

    public final void a(b.a.C0305a aVar) {
        k.c(aVar, "amtVAlidation");
        this.f18135e = aVar;
    }

    public final void b(boolean z) {
        try {
            this.f18133c = z;
            this.l.a(true);
            this.k.a((g.b<IJRPaytmDataModel>) this, (g.a) this, this.f18131a);
        } catch (Exception unused) {
        }
    }

    public final void f() {
        if (this.f18131a.size() > 0) {
            b(true);
            return;
        }
        this.f18133c = true;
        a(false);
    }

    public final SlfdMetaApiResponseModel e() {
        return this.f18138h;
    }

    public final String c() {
        Double fdFloorAmount;
        SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.f18138h;
        if (slfdMetaApiResponseModel == null || (fdFloorAmount = slfdMetaApiResponseModel.getFdFloorAmount()) == null) {
            return null;
        }
        return String.valueOf(fdFloorAmount.doubleValue());
    }

    public final String d() {
        Double fdCapAmount;
        Double fdCapAmount2;
        try {
            SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.f18138h;
            if (slfdMetaApiResponseModel == null || (fdCapAmount2 = slfdMetaApiResponseModel.getFdCapAmount()) == null) {
                return null;
            }
            return String.valueOf((long) fdCapAmount2.doubleValue());
        } catch (Exception unused) {
            SlfdMetaApiResponseModel slfdMetaApiResponseModel2 = this.f18138h;
            if (slfdMetaApiResponseModel2 == null || (fdCapAmount = slfdMetaApiResponseModel2.getFdCapAmount()) == null) {
                return null;
            }
            return String.valueOf(fdCapAmount.doubleValue());
        }
    }

    public final void b() {
        this.k.a(this, this);
    }

    public final void d(String str) {
        this.k.d(this.j, str, this, this);
    }

    public final void a() {
        this.k.c("", this, this);
    }

    public final void a(String str, String str2) {
        k.c(str, StringSet.token);
        k.c(str2, "amt");
        this.l.a(true);
        this.k.b(str, str2, this, this);
    }

    public final b.a.C0305a b(String str) {
        k.c(str, "amt");
        try {
            if (TextUtils.isEmpty(str)) {
                return b.a.C0305a.ZERO_AMOUNT;
            }
            if (this.f18138h == null) {
                b();
                this.f18135e = b.a.C0305a.PROCESSING;
                return b.a.C0305a.PROCESSING;
            } else if (this.f18139i == null) {
                a();
                this.f18135e = b.a.C0305a.PROCESSING;
                return b.a.C0305a.PROCESSING;
            } else {
                Double d2 = null;
                this.f18135e = null;
                double parseDouble = Double.parseDouble(str);
                SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.f18138h;
                if (!k.a(slfdMetaApiResponseModel != null ? slfdMetaApiResponseModel.getFdFloorAmount() : null, 0.0d)) {
                    SlfdMetaApiResponseModel slfdMetaApiResponseModel2 = this.f18138h;
                    Double fdFloorAmount = slfdMetaApiResponseModel2 != null ? slfdMetaApiResponseModel2.getFdFloorAmount() : null;
                    if (fdFloorAmount == null) {
                        k.a();
                    }
                    if (parseDouble < fdFloorAmount.doubleValue()) {
                        return b.a.C0305a.LESS_THEN_FLOOR_AMT;
                    }
                }
                SlfdMetaApiResponseModel slfdMetaApiResponseModel3 = this.f18138h;
                if (!k.a(slfdMetaApiResponseModel3 != null ? slfdMetaApiResponseModel3.getFdCapAmount() : null, 0.0d)) {
                    SlfdMetaApiResponseModel slfdMetaApiResponseModel4 = this.f18138h;
                    Double fdCapAmount = slfdMetaApiResponseModel4 != null ? slfdMetaApiResponseModel4.getFdCapAmount() : null;
                    if (fdCapAmount == null) {
                        k.a();
                    }
                    if (parseDouble > fdCapAmount.doubleValue()) {
                        return b.a.C0305a.GREATER_THEN_CAP_AMT;
                    }
                }
                PBCJRAccountSummary pBCJRAccountSummary = this.f18139i;
                if (pBCJRAccountSummary != null) {
                    d2 = Double.valueOf(pBCJRAccountSummary.getEffectiveBalance());
                }
                if (d2 == null) {
                    k.a();
                }
                if (parseDouble > d2.doubleValue()) {
                    return b.a.C0305a.ADDMONEY;
                }
                return b.a.C0305a.SUCCESS;
            }
        } catch (Exception unused) {
            return b.a.C0305a.SUCCESS;
        }
    }

    public final b.a.C0305a c(String str) {
        k.c(str, "amt");
        try {
            double parseDouble = Double.parseDouble(str);
            PBCJRAccountSummary pBCJRAccountSummary = this.f18139i;
            Double valueOf = pBCJRAccountSummary != null ? Double.valueOf(pBCJRAccountSummary.getEffectiveBalance()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (parseDouble > valueOf.doubleValue()) {
                return b.a.C0305a.ADDMONEY;
            }
            return b.a.C0305a.SUCCESS;
        } catch (Exception unused) {
            return b.a.C0305a.SUCCESS;
        }
    }

    public final void a(String str) {
        k.c(str, "amt");
        net.one97.paytm.paymentsBank.slfd.a.a.b bVar = this.k;
        String str2 = this.j;
        if (str2 == null) {
            k.a();
        }
        bVar.b(str, str2, "20263", this, this);
    }

    private void g() {
        String str = this.f18136f;
        b.a aVar = b.f18186a;
        if (!str.equals(b.j)) {
            String str2 = this.f18137g;
            b.a aVar2 = b.f18186a;
            if (!str2.equals(b.j)) {
                String str3 = this.f18136f;
                b.a aVar3 = b.f18186a;
                if (str3.equals(b.f18194i)) {
                    String str4 = this.f18137g;
                    b.a aVar4 = b.f18186a;
                    if (str4.equals(b.f18194i)) {
                        this.l.c(false);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.l.d();
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        System.out.println("errorrr");
        if (iJRPaytmDataModel instanceof SlfdMetaApiResponseModel) {
            b.a aVar = b.f18186a;
            this.f18137g = b.j;
        } else if (iJRPaytmDataModel instanceof PBCJRAccountSummary) {
            b.a aVar2 = b.f18186a;
            this.f18136f = b.j;
        }
        g();
        this.l.a(Integer.valueOf(i2), networkCustomError);
    }
}
