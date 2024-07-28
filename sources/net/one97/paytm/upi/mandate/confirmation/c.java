package net.one97.paytm.upi.mandate.confirmation;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.l;
import kotlin.m.p;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.deeplink.model.ExtraIntentParams;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.mandate.data.a;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.AuthMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.CreateMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.CreateRecurringMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.utils.i;
import net.one97.paytm.upi.mandate.utils.k;
import net.one97.paytm.upi.mandate.utils.m;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.mandate.utils.w;
import net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel;
import net.one97.paytm.upi.mandate.view.model.UpdateInfo;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class c extends ai implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.upi.mandate.data.a<List<UpiProfileDefaultBank>>> f67096a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public UpiProfileDefaultBank f67097b;

    /* renamed from: c  reason: collision with root package name */
    public final y<r<MandateDefaultResponseModel>> f67098c = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public UpiProfileModel f67099d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f67100e;

    /* renamed from: f  reason: collision with root package name */
    private String f67101f = "";

    /* renamed from: g  reason: collision with root package name */
    private MandateConfirmationUiModel f67102g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f67103h = "";

    /* renamed from: i  reason: collision with root package name */
    private k f67104i;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank j;
    private final Context k;
    private final net.one97.paytm.upi.profile.b.a l;
    private final net.one97.paytm.upi.mandate.data.b m;
    private final i n;

    static final class d extends l implements kotlin.g.a.b<BankAccountDetails.BankAccount, Boolean> {
        final /* synthetic */ m $mandateTransactionType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(m mVar) {
            super(1);
            this.$mandateTransactionType = mVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((BankAccountDetails.BankAccount) obj));
        }

        public final boolean invoke(BankAccountDetails.BankAccount bankAccount) {
            kotlin.g.b.k.c(bankAccount, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
            List<String> bankFilterList = bankAccount.getBankFilterList();
            m mVar = this.$mandateTransactionType;
            if (mVar == null) {
                return true;
            }
            int i2 = d.f67111a[mVar.ordinal()];
            if (i2 == 1) {
                return bankFilterList != null && bankFilterList.contains("SUBSCRIPTION");
            }
            if (i2 == 2) {
                return bankAccount.isAsbaEnabled();
            }
            if (i2 == 3) {
                return bankFilterList != null && bankFilterList.contains("OTM");
            }
            throw new kotlin.m();
        }
    }

    public c(Context context, net.one97.paytm.upi.profile.b.a aVar, net.one97.paytm.upi.mandate.data.b bVar, i iVar) {
        kotlin.g.b.k.c(context, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        kotlin.g.b.k.c(aVar, "upiProfileRepository");
        kotlin.g.b.k.c(bVar, "upiMandateRepository");
        kotlin.g.b.k.c(iVar, "mpinHelper");
        this.k = context;
        this.l = aVar;
        this.m = bVar;
        this.n = iVar;
        this.n.a((i.a) this);
    }

    public final UpiProfileDefaultBank a() {
        UpiProfileDefaultBank upiProfileDefaultBank = this.j;
        if (upiProfileDefaultBank == null) {
            kotlin.g.b.k.a("_primaryBank");
        }
        return upiProfileDefaultBank;
    }

    public final void a(k kVar) {
        kotlin.g.b.k.c(kVar, "mandateSource");
        this.f67104i = kVar;
    }

    public final void a(m mVar, String str) {
        a(str, (kotlin.g.a.b<? super BankAccountDetails.BankAccount, Boolean>) new d(mVar));
    }

    public static final class e implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67108a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f67109b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f67110c;

        e(c cVar, kotlin.g.a.b bVar, String str) {
            this.f67108a = cVar;
            this.f67109b = bVar;
            this.f67110c = str;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            Object obj;
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (upiProfileModel.getResponse() != null) {
                    UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                    kotlin.g.b.k.a((Object) response, "response.response");
                    UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                    kotlin.g.b.k.a((Object) profileDetail, "response.response.profileDetail");
                    Collection profileVpaList = profileDetail.getProfileVpaList();
                    if (!(profileVpaList == null || profileVpaList.isEmpty())) {
                        UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                        kotlin.g.b.k.a((Object) response2, "response.response");
                        UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                        kotlin.g.b.k.a((Object) profileDetail2, "response.response.profileDetail");
                        Collection bankAccountList = profileDetail2.getBankAccountList();
                        if (!(bankAccountList == null || bankAccountList.isEmpty())) {
                            this.f67108a.f67099d = upiProfileModel;
                            c cVar = this.f67108a;
                            UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                            kotlin.g.b.k.a((Object) response3, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail3 = response3.getProfileDetail();
                            kotlin.g.b.k.a((Object) profileDetail3, "response.response.profileDetail");
                            List<UpiProfileDefaultBank> profileVpaList2 = profileDetail3.getProfileVpaList();
                            kotlin.g.b.k.a((Object) profileVpaList2, "response.response.profileDetail.profileVpaList");
                            Iterator it2 = profileVpaList2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it2.next();
                                UpiProfileDefaultBank upiProfileDefaultBank = (UpiProfileDefaultBank) obj;
                                kotlin.g.b.k.a((Object) upiProfileDefaultBank, "it");
                                if (upiProfileDefaultBank.isPrimary()) {
                                    break;
                                }
                            }
                            UpiProfileDefaultBank upiProfileDefaultBank2 = (UpiProfileDefaultBank) obj;
                            if (upiProfileDefaultBank2 == null) {
                                UpiProfileModel.AccountDetails response4 = upiProfileModel.getResponse();
                                kotlin.g.b.k.a((Object) response4, "response.response");
                                UpiProfileModel.ProfileDetails profileDetail4 = response4.getProfileDetail();
                                kotlin.g.b.k.a((Object) profileDetail4, "response.response.profileDetail");
                                UpiProfileDefaultBank upiProfileDefaultBank3 = profileDetail4.getProfileVpaList().get(0);
                                kotlin.g.b.k.a((Object) upiProfileDefaultBank3, "response.response.profileDetail.profileVpaList[0]");
                                upiProfileDefaultBank2 = upiProfileDefaultBank3;
                            }
                            cVar.j = upiProfileDefaultBank2;
                            c cVar2 = this.f67108a;
                            String virtualAddress = cVar2.a().getVirtualAddress();
                            kotlin.g.b.k.a((Object) virtualAddress, "primaryBank.virtualAddress");
                            cVar2.f67103h = virtualAddress;
                            UpiProfileModel.AccountDetails response5 = upiProfileModel.getResponse();
                            kotlin.g.b.k.a((Object) response5, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail5 = response5.getProfileDetail();
                            kotlin.g.b.k.a((Object) profileDetail5, "response.response.profileDetail");
                            ArrayList<BankAccountDetails.BankAccount> bankAccountList2 = profileDetail5.getBankAccountList();
                            kotlin.g.b.k.a((Object) bankAccountList2, "response.response.profileDetail.bankAccountList");
                            Collection arrayList = new ArrayList();
                            for (Object next : bankAccountList2) {
                                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) next;
                                kotlin.g.a.b bVar = this.f67109b;
                                kotlin.g.b.k.a((Object) bankAccount, "it");
                                boolean booleanValue = ((Boolean) bVar.invoke(bankAccount)).booleanValue();
                                CharSequence charSequence = this.f67110c;
                                if (!(charSequence == null || p.a(charSequence))) {
                                    booleanValue = kotlin.g.b.k.a((Object) bankAccount.getAccRefId(), (Object) this.f67110c) && ((Boolean) this.f67109b.invoke(bankAccount)).booleanValue();
                                }
                                if (booleanValue) {
                                    arrayList.add(next);
                                }
                            }
                            Iterable<BankAccountDetails.BankAccount> iterable = (List) arrayList;
                            Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
                            for (BankAccountDetails.BankAccount debitBank : iterable) {
                                UpiProfileDefaultBank upiProfileDefaultBank4 = new UpiProfileDefaultBank();
                                upiProfileDefaultBank4.setVirtualAddress(this.f67108a.f67103h);
                                upiProfileDefaultBank4.setDebitBank(debitBank);
                                arrayList2.add(upiProfileDefaultBank4);
                            }
                            List list = (List) arrayList2;
                            if (list.isEmpty()) {
                                this.f67108a.f67097b = null;
                            } else {
                                this.f67108a.f67097b = (UpiProfileDefaultBank) list.get(0);
                            }
                            y b2 = this.f67108a.f67096a;
                            a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
                            b2.setValue(a.C1355a.a(list, false));
                            return;
                        }
                    }
                }
            }
            y b3 = this.f67108a.f67096a;
            a.C1355a aVar2 = net.one97.paytm.upi.mandate.data.a.f67116e;
            b3.setValue(a.C1355a.a(new UpiCustomVolleyError(), false));
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError != null) {
                upiCustomVolleyError.printStackTrace();
            }
            y b2 = this.f67108a.f67096a;
            a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
            b2.setValue(a.C1355a.a(upiCustomVolleyError, false));
        }
    }

    private final void a(String str, kotlin.g.a.b<? super BankAccountDetails.BankAccount, Boolean> bVar) {
        y<net.one97.paytm.upi.mandate.data.a<List<UpiProfileDefaultBank>>> yVar = this.f67096a;
        a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
        yVar.setValue(a.C1355a.a(false));
        this.l.a(new e(this, bVar, str), "", "");
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        kotlin.g.b.k.c(upiProfileDefaultBank, "bankAccount");
        this.f67097b = upiProfileDefaultBank;
    }

    private final void a(MandateConfirmationUiModel mandateConfirmationUiModel) {
        UpiProfileDefaultBank upiProfileDefaultBank;
        String str;
        if (this.f67099d != null && (upiProfileDefaultBank = this.f67097b) != null) {
            String convertToTwoPlaces = UpiUtils.convertToTwoPlaces(mandateConfirmationUiModel.getAmount());
            String payeeVpa = mandateConfirmationUiModel.getPayeeVpa();
            String virtualAddress = upiProfileDefaultBank.getVirtualAddress();
            String payeeName = mandateConfirmationUiModel.getPayeeName();
            String comment = mandateConfirmationUiModel.getComment();
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "defaultBank.debitBank");
            String maskNumber = UpiUtils.maskNumber(debitBank.getMaskedAccountNumber());
            k kVar = this.f67104i;
            if (kVar == null) {
                kotlin.g.b.k.a("mandateSource");
            }
            String str2 = "";
            if (kVar == k.INTENT) {
                str = UpiUtils.getUpiSequenceNo();
                kotlin.g.b.k.a((Object) str, "UpiUtils.getUpiSequenceNo()");
            } else {
                str = mandateConfirmationUiModel.getTransactionId();
                if (str == null) {
                    str = str2;
                }
            }
            this.f67101f = str;
            String mcc = mandateConfirmationUiModel.getMcc();
            if (mcc != null) {
                str2 = mcc;
            }
            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank2, "defaultBank.debitBank");
            BankAccountDetails.CredsAllowed credsAllowed = debitBank2.getCredsAllowed();
            kotlin.g.b.k.a((Object) credsAllowed, "defaultBank.debitBank.credsAllowed");
            List<BankAccountDetails.BankAccountCredentials> child = credsAllowed.getChild();
            BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank3, "defaultBank.debitBank");
            this.n.a(new net.one97.paytm.upi.mandate.utils.a(convertToTwoPlaces, payeeVpa, virtualAddress, payeeName, comment, maskNumber, this.f67101f, str2, "", "https://paytm.com", child, debitBank3.getBankName()));
        }
    }

    public final void a(String str) {
        String str2 = str;
        kotlin.g.b.k.c(str2, PayUtility.MPIN);
        if (this.f67100e) {
            k kVar = this.f67104i;
            if (kVar == null) {
                kotlin.g.b.k.a("mandateSource");
            }
            if (kVar == k.INTENT) {
                kotlin.g.b.k.c(str2, PayUtility.MPIN);
                this.f67098c.setValue(new r(u.LOADING, (Object) null, (t) null, false, 14));
                UpiProfileDefaultBank upiProfileDefaultBank = this.f67097b;
                if (upiProfileDefaultBank == null) {
                    kotlin.g.b.k.a();
                }
                String str3 = this.f67101f;
                String deviceId = UpiUtils.getDeviceId(this.k.getApplicationContext());
                kotlin.g.b.k.a((Object) deviceId, "UpiUtils.getDeviceId(app.applicationContext)");
                String str4 = this.f67103h;
                BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank, "defaultBank.debitBank");
                String ifsc = debitBank.getIfsc();
                if (ifsc == null) {
                    kotlin.g.b.k.a();
                }
                BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank2, "defaultBank.debitBank");
                String account = debitBank2.getAccount();
                if (account == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel = this.f67102g;
                if (mandateConfirmationUiModel == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String payeeVpa = mandateConfirmationUiModel.getPayeeVpa();
                if (payeeVpa == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel2 = this.f67102g;
                if (mandateConfirmationUiModel2 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String payeeName = mandateConfirmationUiModel2.getPayeeName();
                MandateConfirmationUiModel mandateConfirmationUiModel3 = this.f67102g;
                if (mandateConfirmationUiModel3 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String mcc = mandateConfirmationUiModel3.getMcc();
                if (mcc == null) {
                    mcc = "";
                }
                MandateConfirmationUiModel mandateConfirmationUiModel4 = this.f67102g;
                if (mandateConfirmationUiModel4 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String convertToTwoPlaces = UpiUtils.convertToTwoPlaces(mandateConfirmationUiModel4.getAmount());
                String str5 = "";
                kotlin.g.b.k.a((Object) convertToTwoPlaces, "UpiUtils.convertToTwoPla…nfirmationUiModel.amount)");
                MandateConfirmationUiModel mandateConfirmationUiModel5 = this.f67102g;
                if (mandateConfirmationUiModel5 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String startDate = mandateConfirmationUiModel5.getStartDate();
                if (startDate == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel6 = this.f67102g;
                if (mandateConfirmationUiModel6 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String endDate = mandateConfirmationUiModel6.getEndDate();
                if (endDate == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel7 = this.f67102g;
                if (mandateConfirmationUiModel7 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String comment = mandateConfirmationUiModel7.getComment();
                MandateConfirmationUiModel mandateConfirmationUiModel8 = this.f67102g;
                if (mandateConfirmationUiModel8 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String amountRule = mandateConfirmationUiModel8.getAmountRule();
                if (amountRule == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel9 = this.f67102g;
                if (mandateConfirmationUiModel9 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String recurrencePattern = mandateConfirmationUiModel9.getRecurrencePattern();
                if (recurrencePattern == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel10 = this.f67102g;
                if (mandateConfirmationUiModel10 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String recurrenceRule = mandateConfirmationUiModel10.getRecurrenceRule();
                if (recurrenceRule == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel11 = this.f67102g;
                if (mandateConfirmationUiModel11 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String recurrenceType = mandateConfirmationUiModel11.getRecurrenceType();
                if (recurrenceType == null) {
                    kotlin.g.b.k.a();
                }
                BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank3, "defaultBank.debitBank");
                String accRefId = debitBank3.getAccRefId();
                kotlin.g.b.k.a((Object) accRefId, "defaultBank.debitBank.accRefId");
                MandateConfirmationUiModel mandateConfirmationUiModel12 = this.f67102g;
                if (mandateConfirmationUiModel12 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String purpose = mandateConfirmationUiModel12.getPurpose();
                String str6 = purpose == null ? str5 : purpose;
                MandateConfirmationUiModel mandateConfirmationUiModel13 = this.f67102g;
                if (mandateConfirmationUiModel13 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                String transactionId = mandateConfirmationUiModel13.getTransactionId();
                if (transactionId == null) {
                    kotlin.g.b.k.a();
                }
                MandateConfirmationUiModel mandateConfirmationUiModel14 = this.f67102g;
                if (mandateConfirmationUiModel14 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                ExtraIntentParams extraIntentParams = mandateConfirmationUiModel14.getExtraIntentParams();
                String qrExpire = extraIntentParams != null ? extraIntentParams.getQrExpire() : null;
                MandateConfirmationUiModel mandateConfirmationUiModel15 = this.f67102g;
                if (mandateConfirmationUiModel15 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                ExtraIntentParams extraIntentParams2 = mandateConfirmationUiModel15.getExtraIntentParams();
                String qrTs = extraIntentParams2 != null ? extraIntentParams2.getQrTs() : null;
                MandateConfirmationUiModel mandateConfirmationUiModel16 = this.f67102g;
                if (mandateConfirmationUiModel16 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                ExtraIntentParams extraIntentParams3 = mandateConfirmationUiModel16.getExtraIntentParams();
                String query = extraIntentParams3 != null ? extraIntentParams3.getQuery() : null;
                MandateConfirmationUiModel mandateConfirmationUiModel17 = this.f67102g;
                if (mandateConfirmationUiModel17 == null) {
                    kotlin.g.b.k.a("confirmationUiModel");
                }
                ExtraIntentParams extraIntentParams4 = mandateConfirmationUiModel17.getExtraIntentParams();
                CreateRecurringMandateRequestModel createRecurringMandateRequestModel = r1;
                CreateRecurringMandateRequestModel createRecurringMandateRequestModel2 = new CreateRecurringMandateRequestModel(str3, deviceId, str, str4, ifsc, account, payeeVpa, payeeName, mcc, convertToTwoPlaces, startDate, endDate, amountRule, comment, recurrenceType, recurrenceRule, recurrencePattern, accRefId, str6, "00", transactionId, qrExpire, qrTs, query, extraIntentParams4 != null ? extraIntentParams4.getMinAmount() : null);
                this.m.a(createRecurringMandateRequestModel, (b.a) new C1353c(this));
                return;
            }
        }
        String str7 = "";
        k kVar2 = this.f67104i;
        if (kVar2 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar2 == k.INTENT) {
            kotlin.g.b.k.c(str2, PayUtility.MPIN);
            this.f67098c.setValue(new r(u.LOADING, (Object) null, (t) null, false, 14));
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.f67097b;
            if (upiProfileDefaultBank2 == null) {
                kotlin.g.b.k.a();
            }
            String str8 = this.f67101f;
            String deviceId2 = UpiUtils.getDeviceId(this.k);
            kotlin.g.b.k.a((Object) deviceId2, "UpiUtils.getDeviceId(app)");
            String virtualAddress = upiProfileDefaultBank2.getVirtualAddress();
            kotlin.g.b.k.a((Object) virtualAddress, "defaultBank.virtualAddress");
            BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank2.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank4, "defaultBank.debitBank");
            String ifsc2 = debitBank4.getIfsc();
            kotlin.g.b.k.a((Object) ifsc2, "defaultBank.debitBank.ifsc");
            BankAccountDetails.BankAccount debitBank5 = upiProfileDefaultBank2.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank5, "defaultBank.debitBank");
            String account2 = debitBank5.getAccount();
            kotlin.g.b.k.a((Object) account2, "defaultBank.debitBank.account");
            MandateConfirmationUiModel mandateConfirmationUiModel18 = this.f67102g;
            if (mandateConfirmationUiModel18 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String payeeVpa2 = mandateConfirmationUiModel18.getPayeeVpa();
            if (payeeVpa2 == null) {
                kotlin.g.b.k.a();
            }
            MandateConfirmationUiModel mandateConfirmationUiModel19 = this.f67102g;
            if (mandateConfirmationUiModel19 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String payeeName2 = mandateConfirmationUiModel19.getPayeeName();
            MandateConfirmationUiModel mandateConfirmationUiModel20 = this.f67102g;
            if (mandateConfirmationUiModel20 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String mcc2 = mandateConfirmationUiModel20.getMcc();
            String str9 = mcc2 == null ? str7 : mcc2;
            MandateConfirmationUiModel mandateConfirmationUiModel21 = this.f67102g;
            if (mandateConfirmationUiModel21 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String amount = mandateConfirmationUiModel21.getAmount();
            if (amount == null) {
                kotlin.g.b.k.a();
            }
            MandateConfirmationUiModel mandateConfirmationUiModel22 = this.f67102g;
            if (mandateConfirmationUiModel22 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String startDate2 = mandateConfirmationUiModel22.getStartDate();
            if (startDate2 == null) {
                kotlin.g.b.k.a();
            }
            MandateConfirmationUiModel mandateConfirmationUiModel23 = this.f67102g;
            if (mandateConfirmationUiModel23 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String endDate2 = mandateConfirmationUiModel23.getEndDate();
            if (endDate2 == null) {
                kotlin.g.b.k.a();
            }
            MandateConfirmationUiModel mandateConfirmationUiModel24 = this.f67102g;
            if (mandateConfirmationUiModel24 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String amountRule2 = mandateConfirmationUiModel24.getAmountRule();
            if (amountRule2 == null) {
                kotlin.g.b.k.a();
            }
            MandateConfirmationUiModel mandateConfirmationUiModel25 = this.f67102g;
            if (mandateConfirmationUiModel25 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String comment2 = mandateConfirmationUiModel25.getComment();
            MandateConfirmationUiModel mandateConfirmationUiModel26 = this.f67102g;
            if (mandateConfirmationUiModel26 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String transactionId2 = mandateConfirmationUiModel26.getTransactionId();
            MandateConfirmationUiModel mandateConfirmationUiModel27 = this.f67102g;
            if (mandateConfirmationUiModel27 == null) {
                kotlin.g.b.k.a("confirmationUiModel");
            }
            String purpose2 = mandateConfirmationUiModel27.getPurpose();
            CreateMandateRequestModel createMandateRequestModel = r1;
            CreateMandateRequestModel createMandateRequestModel2 = new CreateMandateRequestModel(str8, deviceId2, str, virtualAddress, ifsc2, account2, payeeVpa2, payeeName2, str9, "ENTITY", "Y", amount, UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, startDate2, endDate2, amountRule2, comment2, transactionId2, purpose2 == null ? str7 : purpose2);
            this.m.a(createMandateRequestModel, (b.a) new b(this));
            return;
        }
        kotlin.g.b.k.c(str2, PayUtility.MPIN);
        this.f67098c.setValue(new r(u.LOADING, (Object) null, (t) null, false, 14));
        String str10 = this.f67100e ? "RECURRING" : "ONETIME";
        MandateConfirmationUiModel mandateConfirmationUiModel28 = this.f67102g;
        if (mandateConfirmationUiModel28 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String transactionId3 = mandateConfirmationUiModel28.getTransactionId();
        if (transactionId3 == null) {
            kotlin.g.b.k.a();
        }
        String deviceId3 = UpiUtils.getDeviceId(this.k);
        kotlin.g.b.k.a((Object) deviceId3, "UpiUtils.getDeviceId(app)");
        String type = net.one97.paytm.upi.mandate.utils.d.APPROVE.getType();
        MandateConfirmationUiModel mandateConfirmationUiModel29 = this.f67102g;
        if (mandateConfirmationUiModel29 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String umn = mandateConfirmationUiModel29.getUmn();
        if (umn == null) {
            kotlin.g.b.k.a();
        }
        UpiProfileDefaultBank upiProfileDefaultBank3 = this.f67097b;
        if (upiProfileDefaultBank3 == null) {
            kotlin.g.b.k.a();
        }
        BankAccountDetails.BankAccount debitBank6 = upiProfileDefaultBank3.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank6, "defaultBank!!.debitBank");
        String ifsc3 = debitBank6.getIfsc();
        if (ifsc3 == null) {
            kotlin.g.b.k.a();
        }
        UpiProfileDefaultBank upiProfileDefaultBank4 = this.f67097b;
        if (upiProfileDefaultBank4 == null) {
            kotlin.g.b.k.a();
        }
        BankAccountDetails.BankAccount debitBank7 = upiProfileDefaultBank4.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank7, "defaultBank!!.debitBank");
        String account3 = debitBank7.getAccount();
        if (account3 == null) {
            kotlin.g.b.k.a();
        }
        UpiProfileDefaultBank upiProfileDefaultBank5 = this.f67097b;
        if (upiProfileDefaultBank5 == null) {
            kotlin.g.b.k.a();
        }
        BankAccountDetails.BankAccount debitBank8 = upiProfileDefaultBank5.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank8, "defaultBank!!.debitBank");
        String accRefId2 = debitBank8.getAccRefId();
        if (accRefId2 != null) {
            str7 = accRefId2;
        }
        this.m.a(new AuthMandateRequestModel(transactionId3, deviceId3, type, str, umn, ifsc3, account3, str7, str10), (b.a) new a(this));
    }

    public static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67106a;

        b(c cVar) {
            this.f67106a = cVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
                MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
                if (kotlin.g.b.k.a((Object) net.one97.paytm.upi.mandate.utils.c.FAILURE.getType(), (Object) mandateDefaultResponseModel.getStatus())) {
                    this.f67106a.f67098c.setValue(new r(u.ERROR, (Object) null, new t.a(mandateDefaultResponseModel.getRespMessage()), false, 10));
                } else {
                    this.f67106a.f67098c.setValue(new r(u.SUCCESS, upiBaseDataModel, (t) null, false, 12));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67106a.f67098c.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67106a.f67098c.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public static final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67105a;

        a(c cVar) {
            this.f67105a = cVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
                MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
                if (kotlin.g.b.k.a((Object) net.one97.paytm.upi.mandate.utils.c.FAILURE.getType(), (Object) mandateDefaultResponseModel.getStatus())) {
                    this.f67105a.f67098c.setValue(new r(u.ERROR, (Object) null, new t.a(mandateDefaultResponseModel.getRespMessage()), false, 10));
                } else {
                    this.f67105a.f67098c.setValue(new r(u.SUCCESS, upiBaseDataModel, (t) null, false, 12));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67105a.f67098c.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67105a.f67098c.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    /* renamed from: net.one97.paytm.upi.mandate.confirmation.c$c  reason: collision with other inner class name */
    public static final class C1353c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67107a;

        C1353c(c cVar) {
            this.f67107a = cVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
                MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
                if (kotlin.g.b.k.a((Object) net.one97.paytm.upi.mandate.utils.c.FAILURE.getType(), (Object) mandateDefaultResponseModel.getStatus())) {
                    this.f67107a.f67098c.setValue(new r(u.ERROR, (Object) null, new t.a(mandateDefaultResponseModel.getRespMessage()), false, 10));
                } else {
                    this.f67107a.f67098c.setValue(new r(u.SUCCESS, upiBaseDataModel, (t) null, false, 12));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67107a.f67098c.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67107a.f67098c.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public final void a(t tVar) {
        kotlin.g.b.k.c(tVar, "error");
        this.f67098c.setValue(new r(u.ERROR, (Object) null, tVar, false, 10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r0 = (r0 = (r0 = r0.getResponse()).getProfileDetail()).getBankAccountList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> c() {
        /*
            r1 = this;
            net.one97.paytm.upi.common.upi.UpiProfileModel r0 = r1.f67099d
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r0.getResponse()
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x0019
            java.util.ArrayList r0 = r0.getBankAccountList()
            if (r0 == 0) goto L_0x0019
            java.util.List r0 = (java.util.List) r0
            return r0
        L_0x0019:
            kotlin.a.w r0 = kotlin.a.w.INSTANCE
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.confirmation.c.c():java.util.List");
    }

    public final void a(MandateConfirmationUiModel mandateConfirmationUiModel, k kVar) {
        kotlin.g.b.k.c(mandateConfirmationUiModel, "confirmationUiModel");
        kotlin.g.b.k.c(kVar, "source");
        if (this.f67097b != null) {
            this.f67100e = mandateConfirmationUiModel.getMandateTransactionType() == m.RECURRING;
            this.f67102g = mandateConfirmationUiModel;
            this.f67104i = kVar;
            a(mandateConfirmationUiModel);
        }
    }

    public final CreateMandateUiModel b() {
        UpiProfileDefaultBank upiProfileDefaultBank = this.f67097b;
        if (upiProfileDefaultBank == null) {
            kotlin.g.b.k.a();
        }
        MandateConfirmationUiModel mandateConfirmationUiModel = this.f67102g;
        if (mandateConfirmationUiModel == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String amount = mandateConfirmationUiModel.getAmount();
        MandateConfirmationUiModel mandateConfirmationUiModel2 = this.f67102g;
        if (mandateConfirmationUiModel2 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String payeeVpa = mandateConfirmationUiModel2.getPayeeVpa();
        MandateConfirmationUiModel mandateConfirmationUiModel3 = this.f67102g;
        if (mandateConfirmationUiModel3 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String payeeName = mandateConfirmationUiModel3.getPayeeName();
        MandateConfirmationUiModel mandateConfirmationUiModel4 = this.f67102g;
        if (mandateConfirmationUiModel4 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String comment = mandateConfirmationUiModel4.getComment();
        MandateConfirmationUiModel mandateConfirmationUiModel5 = this.f67102g;
        if (mandateConfirmationUiModel5 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String mcc = mandateConfirmationUiModel5.getMcc();
        String virtualAddress = upiProfileDefaultBank.getVirtualAddress();
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank, "defaultBank.debitBank");
        String ifsc = debitBank.getIfsc();
        BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank2, "defaultBank.debitBank");
        String bankName = debitBank2.getBankName();
        BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank3, "defaultBank.debitBank");
        String account = debitBank3.getAccount();
        BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank4, "defaultBank.debitBank");
        BankAccountDetails.CredsAllowed credsAllowed = debitBank4.getCredsAllowed();
        List<BankAccountDetails.BankAccountCredentials> child = credsAllowed != null ? credsAllowed.getChild() : null;
        MandateConfirmationUiModel mandateConfirmationUiModel6 = this.f67102g;
        if (mandateConfirmationUiModel6 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String startDate = mandateConfirmationUiModel6.getStartDate();
        MandateConfirmationUiModel mandateConfirmationUiModel7 = this.f67102g;
        if (mandateConfirmationUiModel7 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String endDate = mandateConfirmationUiModel7.getEndDate();
        MandateConfirmationUiModel mandateConfirmationUiModel8 = this.f67102g;
        if (mandateConfirmationUiModel8 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String umn = mandateConfirmationUiModel8.getUmn();
        MandateConfirmationUiModel mandateConfirmationUiModel9 = this.f67102g;
        if (mandateConfirmationUiModel9 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        String transactionId = mandateConfirmationUiModel9.getTransactionId();
        BankAccountDetails.BankAccount debitBank5 = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank5, "defaultBank.debitBank");
        String accRefId = debitBank5.getAccRefId();
        MandateConfirmationUiModel mandateConfirmationUiModel10 = this.f67102g;
        if (mandateConfirmationUiModel10 == null) {
            kotlin.g.b.k.a("confirmationUiModel");
        }
        return new CreateMandateUiModel(amount, payeeVpa, payeeName, comment, mcc, (String) null, "P2M", virtualAddress, ifsc, bankName, account, child, startDate, endDate, umn, transactionId, "", "", accRefId, (w.a) null, (w.b) null, mandateConfirmationUiModel10, (UpdateInfo) null, (String) null, 12582912, (g) null);
    }
}
