package net.one97.paytm.upi.mandate.update;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.data.model.UpdateMandateRequestModel;
import net.one97.paytm.upi.mandate.utils.i;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.mandate.utils.v;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public final class d extends ai implements i.a {

    /* renamed from: a  reason: collision with root package name */
    MandateItem f67369a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final y<r<MandateDefaultResponseModel>> f67370b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    String f67371c;

    /* renamed from: d  reason: collision with root package name */
    String f67372d;

    /* renamed from: e  reason: collision with root package name */
    String f67373e;

    /* renamed from: f  reason: collision with root package name */
    String f67374f = "";

    /* renamed from: g  reason: collision with root package name */
    v f67375g;

    /* renamed from: h  reason: collision with root package name */
    public BankAccountDetails.BankAccount f67376h;

    /* renamed from: i  reason: collision with root package name */
    String f67377i;
    final net.one97.paytm.upi.profile.b.a j;
    final i k;
    /* access modifiers changed from: private */
    public MandateDefaultResponseModel l;
    private final Context m;
    private final net.one97.paytm.upi.mandate.data.b n;

    public d(Context context, net.one97.paytm.upi.profile.b.a aVar, net.one97.paytm.upi.mandate.data.b bVar, i iVar) {
        k.c(context, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(aVar, "upiProfileRepository");
        k.c(bVar, "mandateRepository");
        k.c(iVar, "mpinHelper");
        this.m = context;
        this.j = aVar;
        this.n = bVar;
        this.k = iVar;
        this.k.a((i.a) this);
    }

    public static String a(String str, String str2) {
        k.c(str, "resultFormat");
        k.c(str2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        String convertDateFromTo = UpiUtils.convertDateFromTo("ddMMyyyy", str, str2);
        k.a((Object) convertDateFromTo, "UpiUtils.convertDateFrom…yyyy, resultFormat, date)");
        return convertDateFromTo;
    }

    public static final class a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f67378a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f67379b;

        a(d dVar, String str) {
            this.f67378a = dVar;
            this.f67379b = str;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            Object obj;
            UpiBaseDataModel upiBaseDataModel2 = upiBaseDataModel;
            if (upiBaseDataModel2 instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel2;
                if (upiProfileModel.getResponse() != null) {
                    UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                    k.a((Object) response, "response.response");
                    UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                    k.a((Object) profileDetail, "response.response.profileDetail");
                    Collection profileVpaList = profileDetail.getProfileVpaList();
                    boolean z = false;
                    if (!(profileVpaList == null || profileVpaList.isEmpty())) {
                        UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                        k.a((Object) response2, "response.response");
                        UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                        k.a((Object) profileDetail2, "response.response.profileDetail");
                        Collection bankAccountList = profileDetail2.getBankAccountList();
                        if (bankAccountList == null || bankAccountList.isEmpty()) {
                            z = true;
                        }
                        if (!z) {
                            d dVar = this.f67378a;
                            UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                            k.a((Object) response3, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail3 = response3.getProfileDetail();
                            k.a((Object) profileDetail3, "response.response.profileDetail");
                            ArrayList<BankAccountDetails.BankAccount> bankAccountList2 = profileDetail3.getBankAccountList();
                            k.a((Object) bankAccountList2, "response.response.profileDetail.bankAccountList");
                            Iterator it2 = bankAccountList2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it2.next();
                                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) obj;
                                k.a((Object) bankAccount, "it");
                                if (k.a((Object) bankAccount.getAccount(), (Object) this.f67379b)) {
                                    break;
                                }
                            }
                            BankAccountDetails.BankAccount bankAccount2 = (BankAccountDetails.BankAccount) obj;
                            if (bankAccount2 != null) {
                                k.c(bankAccount2, "<set-?>");
                                dVar.f67376h = bankAccount2;
                                d dVar2 = this.f67378a;
                                String upiSequenceNo = UpiUtils.getUpiSequenceNo();
                                k.a((Object) upiSequenceNo, "UpiUtils.getUpiSequenceNo()");
                                dVar2.f67377i = upiSequenceNo;
                                String convertToTwoPlaces = UpiUtils.convertToTwoPlaces(dVar2.f67374f);
                                MandateItem mandateItem = dVar2.f67369a;
                                if (mandateItem == null) {
                                    k.a("mandateItem");
                                }
                                String vpa = mandateItem.getPayee().getVpa();
                                MandateItem mandateItem2 = dVar2.f67369a;
                                if (mandateItem2 == null) {
                                    k.a("mandateItem");
                                }
                                String vpa2 = mandateItem2.getPayer().getVpa();
                                MandateItem mandateItem3 = dVar2.f67369a;
                                if (mandateItem3 == null) {
                                    k.a("mandateItem");
                                }
                                String userName = mandateItem3.getPayee().getUserName();
                                MandateItem mandateItem4 = dVar2.f67369a;
                                if (mandateItem4 == null) {
                                    k.a("mandateItem");
                                }
                                String maskNumber = UpiUtils.maskNumber(mandateItem4.getPayer().getBankAccount());
                                String str = dVar2.f67377i;
                                if (str == null) {
                                    k.a(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
                                }
                                MandateItem mandateItem5 = dVar2.f67369a;
                                if (mandateItem5 == null) {
                                    k.a("mandateItem");
                                }
                                String mcc = mandateItem5.getPayee().getMcc();
                                if (mcc == null) {
                                    mcc = "";
                                }
                                String str2 = mcc;
                                BankAccountDetails.BankAccount bankAccount3 = dVar2.f67376h;
                                if (bankAccount3 == null) {
                                    k.a("selectedBankAcc");
                                }
                                BankAccountDetails.CredsAllowed credsAllowed = bankAccount3.getCredsAllowed();
                                k.a((Object) credsAllowed, "selectedBankAcc.credsAllowed");
                                List<BankAccountDetails.BankAccountCredentials> child = credsAllowed.getChild();
                                BankAccountDetails.BankAccount bankAccount4 = dVar2.f67376h;
                                if (bankAccount4 == null) {
                                    k.a("selectedBankAcc");
                                }
                                dVar2.k.a(new net.one97.paytm.upi.mandate.utils.a(convertToTwoPlaces, vpa, vpa2, userName, (String) null, maskNumber, str, str2, "", "https://paytm.com", child, bankAccount4.getBankName()));
                            }
                        }
                    }
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67378a.f67370b.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67378a.f67370b.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public final void a(String str) {
        k.c(str, PayUtility.MPIN);
        MandateItem mandateItem = this.f67369a;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        if (k.a((Object) mandateItem.getType(), (Object) "RECURRING")) {
            String str2 = this.f67377i;
            if (str2 == null) {
                k.a(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
            }
            String deviceId = UpiUtils.getDeviceId(this.m);
            k.a((Object) deviceId, "UpiUtils.getDeviceId(app)");
            MandateItem mandateItem2 = this.f67369a;
            if (mandateItem2 == null) {
                k.a("mandateItem");
            }
            String umn = mandateItem2.getUmn();
            v vVar = this.f67375g;
            if (vVar == null) {
                k.a("updateType");
            }
            String value = vVar.getValue();
            String str3 = this.f67372d;
            String str4 = this.f67373e;
            String str5 = this.f67371c;
            String str6 = this.f67374f;
            if (str6 == null) {
                str6 = "";
            }
            this.n.a(new UpdateMandateRequestBody(str2, deviceId, umn, value, str3, str4, str5, str6, str, "net.one97.paytm"), (b.a) new c(this));
            return;
        }
        String str7 = this.f67377i;
        if (str7 == null) {
            k.a(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        }
        String deviceId2 = UpiUtils.getDeviceId(this.m);
        k.a((Object) deviceId2, "UpiUtils.getDeviceId(app)");
        MandateItem mandateItem3 = this.f67369a;
        if (mandateItem3 == null) {
            k.a("mandateItem");
        }
        String umn2 = mandateItem3.getUmn();
        v vVar2 = this.f67375g;
        if (vVar2 == null) {
            k.a("updateType");
        }
        String value2 = vVar2.getValue();
        String str8 = this.f67371c;
        String str9 = this.f67374f;
        MandateItem mandateItem4 = this.f67369a;
        if (mandateItem4 == null) {
            k.a("mandateItem");
        }
        String refUrl = mandateItem4.getRefUrl();
        MandateItem mandateItem5 = this.f67369a;
        if (mandateItem5 == null) {
            k.a("mandateItem");
        }
        this.n.a(new UpdateMandateRequestModel(str7, deviceId2, str, umn2, value2, str8, str9, "", refUrl, mandateItem5.getRefCategory(), ""), (b.a) new b(this));
    }

    public static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f67380a;

        b(d dVar) {
            this.f67380a = dVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
                MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
                this.f67380a.l = mandateDefaultResponseModel;
                if (!k.a((Object) mandateDefaultResponseModel.getStatus(), (Object) "FAILURE")) {
                    this.f67380a.f67370b.setValue(new r(u.SUCCESS, upiBaseDataModel, (t) null, false, 12));
                } else {
                    this.f67380a.f67370b.setValue(new r(u.ERROR, (Object) null, new t.a(mandateDefaultResponseModel.getRespMessage()), false, 10));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67380a.f67370b.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67380a.f67370b.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public static final class c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f67381a;

        c(d dVar) {
            this.f67381a = dVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
                MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
                this.f67381a.l = mandateDefaultResponseModel;
                if (!k.a((Object) mandateDefaultResponseModel.getStatus(), (Object) "FAILURE")) {
                    this.f67381a.f67370b.setValue(new r(u.SUCCESS, upiBaseDataModel, (t) null, false, 12));
                } else {
                    this.f67381a.f67370b.setValue(new r(u.ERROR, (Object) null, new t.a(mandateDefaultResponseModel.getRespMessage()), false, 10));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67381a.f67370b.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67381a.f67370b.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public final void a(t tVar) {
        k.c(tVar, "error");
        this.f67370b.setValue(new r(u.ERROR, (Object) null, tVar, false, 10));
    }
}
