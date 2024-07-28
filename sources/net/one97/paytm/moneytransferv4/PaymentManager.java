package net.one97.paytm.moneytransferv4;

import android.content.Intent;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.f;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.InstrumentMeta;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.PaymentInstrument;
import net.one97.paytm.contacts.entities.beans.VPADetails;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransferv4.PaymentFlow;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import org.json.JSONObject;

public final class PaymentManager {

    /* renamed from: a  reason: collision with root package name */
    public static final PaymentManager f54783a = new PaymentManager();

    public interface a {
        void a(String str, String str2);

        void a(PaymentFlow paymentFlow);

        void a(BaseUpiResponse baseUpiResponse, String str, boolean z);

        void b(PaymentFlow paymentFlow);
    }

    public static PaymentUiModel a(String str, String str2) {
        return a(str, str2, (String) null, (String) null, (String) null, (String) null, (String) null, 252);
    }

    private PaymentManager() {
    }

    public static void a(PaymentCombinationAPIResponse paymentCombinationAPIResponse, a aVar) {
        k.c(paymentCombinationAPIResponse, Payload.RESPONSE);
        k.c(aVar, "listener");
        List<PaymentOptionItem> paymentOptionList = paymentCombinationAPIResponse.getPaymentOptionList();
        if (!k.a((Object) "SUCCESS", (Object) paymentCombinationAPIResponse.getStatus()) || paymentOptionList == null || !(!paymentOptionList.isEmpty())) {
            PaymentCombinationAPIResponse data = new PaymentFlow.PaymentCombination(paymentCombinationAPIResponse).getData();
            ReceiverInfo receiverInfo = data != null ? data.getReceiverInfo() : null;
            if (receiverInfo != null && !TextUtils.isEmpty(receiverInfo.getContactName())) {
                aVar.a(receiverInfo.getContactName(), receiverInfo.getContactName());
                return;
            }
            return;
        }
        c.a aVar2 = c.C;
        if (!c.a(c.a.a().B, false) || !k.a((Object) Boolean.TRUE, (Object) paymentCombinationAPIResponse.isIntermediateScreenEnabled())) {
            aVar.a(new PaymentFlow.PaymentCombination(paymentCombinationAPIResponse));
        } else {
            aVar.b(new PaymentFlow.PaymentCombination(paymentCombinationAPIResponse));
        }
    }

    public static PaymentUiModel a(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        String customerName = bankAccount.getCustomerName();
        k.a((Object) customerName, "bankAccount.customerName");
        String bankName = bankAccount.getBankName();
        if (bankName == null) {
            bankName = "";
        }
        String account = bankAccount.getAccount();
        k.a((Object) account, "bankAccount.account");
        String ifsc = bankAccount.getIfsc();
        k.a((Object) ifsc, "bankAccount.ifsc");
        return new PaymentUiModel(customerName, bankName, account, ifsc, true, bankAccount.getBankLogoUrl(), (String) null, (String) null, (String) null, (String) null, 960, (g) null);
    }

    public static /* synthetic */ PaymentUiModel a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2) {
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int i3 = i2;
        String str13 = (i3 & 4) != 0 ? "" : str3;
        String str14 = (i3 & 8) != 0 ? "" : str4;
        String str15 = (i3 & 16) != 0 ? "" : str5;
        String str16 = (i3 & 64) != 0 ? "" : str6;
        String str17 = (i3 & 128) != 0 ? "" : str7;
        k.c(str16, "beneficiaryId");
        k.c(str17, "payeeMobile");
        if (str2 == null) {
            str8 = "";
        } else {
            str8 = str2;
        }
        if (str == null) {
            str9 = "";
        } else {
            str9 = str;
        }
        if (str13 == null) {
            str10 = "";
        } else {
            str10 = str13;
        }
        if (str14 == null) {
            str11 = "";
        } else {
            str11 = str14;
        }
        if (str15 == null) {
            str12 = "";
        } else {
            str12 = str15;
        }
        return new PaymentUiModel(str8, str10, str9, str11, false, str12, str17, "", (String) null, (String) null, 768, (g) null);
    }

    public static PaymentUiModel a(VPADetails vPADetails) {
        k.c(vPADetails, "vpaDetails");
        return a(vPADetails.getVpa(), vPADetails.getName(), (String) null, (String) null, (String) null, (String) null, (String) null, 252);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.moneytransferv4.PaymentManager.PaymentUiModel a(net.one97.paytm.contacts.entities.beans.ContactsResponse r20) {
        /*
            java.lang.String r0 = "contactsResponse"
            r1 = r20
            kotlin.g.b.k.c(r1, r0)
            java.util.HashSet r0 = r20.getPaymentInstruments()
            java.util.Collection r0 = (java.util.Collection) r0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = 0
            goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.moneytransferv4.PaymentManager$PaymentUiModel r0 = new net.one97.paytm.moneytransferv4.PaymentManager$PaymentUiModel
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 1023(0x3ff, float:1.434E-42)
            r16 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x0032:
            java.util.HashSet r0 = r20.getPaymentInstruments()
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            net.one97.paytm.contacts.entities.beans.PaymentInstrument r0 = (net.one97.paytm.contacts.entities.beans.PaymentInstrument) r0
            java.lang.String r4 = "instrument"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.Object r4 = r0.getMeta()
            if (r4 == 0) goto L_0x010c
            java.util.Map r4 = (java.util.Map) r4
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>(r4)
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f
            r4.<init>()
            java.lang.String r5 = r5.toString()
            java.lang.Class<net.one97.paytm.common.entity.InstrumentMeta> r6 = net.one97.paytm.common.entity.InstrumentMeta.class
            java.lang.Object r4 = r4.a((java.lang.String) r5, r6)
            net.one97.paytm.common.entity.InstrumentMeta r4 = (net.one97.paytm.common.entity.InstrumentMeta) r4
            net.one97.paytm.contacts.entities.beans.ContactInfo r5 = r20.getContactInfo()
            r6 = 0
            if (r5 == 0) goto L_0x006f
            net.one97.paytm.contacts.entities.beans.Meta r5 = r5.getMeta()
            goto L_0x0070
        L_0x006f:
            r5 = r6
        L_0x0070:
            boolean r7 = r5 instanceof java.util.Map
            if (r7 != 0) goto L_0x0075
            r5 = r6
        L_0x0075:
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0088
            java.lang.String r7 = "image"
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x0086
            goto L_0x0088
        L_0x0086:
            r13 = r5
            goto L_0x0089
        L_0x0088:
            r13 = r6
        L_0x0089:
            java.lang.String r5 = r4.getName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x009a
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r5 = 0
            goto L_0x009b
        L_0x009a:
            r5 = 1
        L_0x009b:
            if (r5 != 0) goto L_0x00a3
            java.lang.String r2 = r4.getName()
        L_0x00a1:
            r8 = r2
            goto L_0x00ba
        L_0x00a3:
            java.lang.String r5 = r20.getName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x00b1
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00b2
        L_0x00b1:
            r2 = 1
        L_0x00b2:
            if (r2 != 0) goto L_0x00b9
            java.lang.String r2 = r20.getName()
            goto L_0x00a1
        L_0x00b9:
            r8 = r6
        L_0x00ba:
            net.one97.paytm.moneytransferv4.PaymentManager$PaymentUiModel r2 = new net.one97.paytm.moneytransferv4.PaymentManager$PaymentUiModel
            if (r8 != 0) goto L_0x00c1
            kotlin.g.b.k.a()
        L_0x00c1:
            java.lang.String r3 = r4.getBankName()
            if (r3 != 0) goto L_0x00c9
            r9 = r6
            goto L_0x00ca
        L_0x00c9:
            r9 = r3
        L_0x00ca:
            java.lang.String r3 = r4.getVpa()
            if (r3 != 0) goto L_0x00d4
            java.lang.String r3 = r4.getAccountNo()
        L_0x00d4:
            if (r3 != 0) goto L_0x00d8
            r10 = r6
            goto L_0x00d9
        L_0x00d8:
            r10 = r3
        L_0x00d9:
            java.lang.String r3 = r4.getIfsc()
            if (r3 != 0) goto L_0x00e1
            r11 = r6
            goto L_0x00e2
        L_0x00e1:
            r11 = r3
        L_0x00e2:
            r12 = 0
            r14 = 0
            java.lang.String r15 = r20.getContactId()
            java.lang.String r1 = "contactsResponse.contactId"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            java.lang.String r1 = r0.getPaymentInstrumentId()
            java.lang.String r3 = "instrument.paymentInstrumentId"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r0 = r0.getType()
            java.lang.String r3 = "instrument.type"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r18 = 64
            r19 = 0
            r7 = r2
            r16 = r1
            r17 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r2
        L_0x010c:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.PaymentManager.a(net.one97.paytm.contacts.entities.beans.ContactsResponse):net.one97.paytm.moneytransferv4.PaymentManager$PaymentUiModel");
    }

    public static PaymentUiModel a(ContactDetail contactDetail) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        k.c(contactDetail, "contactsResponse");
        Collection paymentInstrument = contactDetail.getPaymentInstrument();
        if (paymentInstrument == null || paymentInstrument.isEmpty()) {
            return new PaymentUiModel((String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (g) null);
        }
        HashSet<PaymentInstrument> paymentInstrument2 = contactDetail.getPaymentInstrument();
        if (paymentInstrument2 == null) {
            k.a();
        }
        PaymentInstrument paymentInstrument3 = (PaymentInstrument) kotlin.a.k.a(paymentInstrument2, 0);
        Object meta = paymentInstrument3.getMeta();
        if (meta != null) {
            InstrumentMeta instrumentMeta = (InstrumentMeta) new f().a(new JSONObject((Map) meta).toString(), InstrumentMeta.class);
            String imageUrl = contactDetail.getImageUrl();
            String str6 = imageUrl == null ? "" : imageUrl;
            String contactName = contactDetail.getContactName();
            if (contactName == null) {
                str = "";
            } else {
                str = contactName;
            }
            String bankName = instrumentMeta.getBankName();
            if (bankName == null) {
                str2 = "";
            } else {
                str2 = bankName;
            }
            String vpa = instrumentMeta.getVpa();
            if (vpa == null) {
                vpa = instrumentMeta.getAccountNo();
            }
            if (vpa == null) {
                str3 = "";
            } else {
                str3 = vpa;
            }
            String ifsc = instrumentMeta.getIfsc();
            if (ifsc == null) {
                str4 = "";
            } else {
                str4 = ifsc;
            }
            String contactId = contactDetail.getContactId();
            if (contactId == null) {
                str5 = "";
            } else {
                str5 = contactId;
            }
            String type = paymentInstrument3.getType();
            k.a((Object) type, "instrument.type");
            String paymentInstrumentId = paymentInstrument3.getPaymentInstrumentId();
            k.a((Object) paymentInstrumentId, "instrument.paymentInstrumentId");
            return new PaymentUiModel(str, str2, str3, str4, false, str6, (String) null, str5, paymentInstrumentId, type, 64, (g) null);
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
    }

    public static final class PaymentUiModel implements IJRDataModel {
        private final String accNoOrVpa;
        private final String bankName;
        private final String beneficiaryId;
        private final String ifsc;
        private final String imageUrl;
        private final boolean isSelfAccount;
        private final String payeeMobile;
        private final String paymentInstrumentId;
        private final String paymentInstrumentType;
        private final String userName;

        public PaymentUiModel() {
            this((String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (g) null);
        }

        public static /* synthetic */ PaymentUiModel copy$default(PaymentUiModel paymentUiModel, String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, int i2, Object obj) {
            PaymentUiModel paymentUiModel2 = paymentUiModel;
            int i3 = i2;
            return paymentUiModel.copy((i3 & 1) != 0 ? paymentUiModel2.userName : str, (i3 & 2) != 0 ? paymentUiModel2.bankName : str2, (i3 & 4) != 0 ? paymentUiModel2.accNoOrVpa : str3, (i3 & 8) != 0 ? paymentUiModel2.ifsc : str4, (i3 & 16) != 0 ? paymentUiModel2.isSelfAccount : z, (i3 & 32) != 0 ? paymentUiModel2.imageUrl : str5, (i3 & 64) != 0 ? paymentUiModel2.payeeMobile : str6, (i3 & 128) != 0 ? paymentUiModel2.beneficiaryId : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentUiModel2.paymentInstrumentId : str8, (i3 & 512) != 0 ? paymentUiModel2.paymentInstrumentType : str9);
        }

        public final String component1() {
            return this.userName;
        }

        public final String component10() {
            return this.paymentInstrumentType;
        }

        public final String component2() {
            return this.bankName;
        }

        public final String component3() {
            return this.accNoOrVpa;
        }

        public final String component4() {
            return this.ifsc;
        }

        public final boolean component5() {
            return this.isSelfAccount;
        }

        public final String component6() {
            return this.imageUrl;
        }

        public final String component7() {
            return this.payeeMobile;
        }

        public final String component8() {
            return this.beneficiaryId;
        }

        public final String component9() {
            return this.paymentInstrumentId;
        }

        public final PaymentUiModel copy(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9) {
            k.c(str, "userName");
            k.c(str3, "accNoOrVpa");
            String str10 = str4;
            k.c(str10, "ifsc");
            String str11 = str6;
            k.c(str11, "payeeMobile");
            String str12 = str7;
            k.c(str12, "beneficiaryId");
            String str13 = str8;
            k.c(str13, "paymentInstrumentId");
            String str14 = str9;
            k.c(str14, "paymentInstrumentType");
            return new PaymentUiModel(str, str2, str3, str10, z, str5, str11, str12, str13, str14);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaymentUiModel)) {
                return false;
            }
            PaymentUiModel paymentUiModel = (PaymentUiModel) obj;
            return k.a((Object) this.userName, (Object) paymentUiModel.userName) && k.a((Object) this.bankName, (Object) paymentUiModel.bankName) && k.a((Object) this.accNoOrVpa, (Object) paymentUiModel.accNoOrVpa) && k.a((Object) this.ifsc, (Object) paymentUiModel.ifsc) && this.isSelfAccount == paymentUiModel.isSelfAccount && k.a((Object) this.imageUrl, (Object) paymentUiModel.imageUrl) && k.a((Object) this.payeeMobile, (Object) paymentUiModel.payeeMobile) && k.a((Object) this.beneficiaryId, (Object) paymentUiModel.beneficiaryId) && k.a((Object) this.paymentInstrumentId, (Object) paymentUiModel.paymentInstrumentId) && k.a((Object) this.paymentInstrumentType, (Object) paymentUiModel.paymentInstrumentType);
        }

        public final int hashCode() {
            String str = this.userName;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.bankName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.accNoOrVpa;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.ifsc;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            boolean z = this.isSelfAccount;
            if (z) {
                z = true;
            }
            int i3 = (hashCode4 + (z ? 1 : 0)) * 31;
            String str5 = this.imageUrl;
            int hashCode5 = (i3 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.payeeMobile;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.beneficiaryId;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.paymentInstrumentId;
            int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.paymentInstrumentType;
            if (str9 != null) {
                i2 = str9.hashCode();
            }
            return hashCode8 + i2;
        }

        public final String toString() {
            return "PaymentUiModel(userName=" + this.userName + ", bankName=" + this.bankName + ", accNoOrVpa=" + this.accNoOrVpa + ", ifsc=" + this.ifsc + ", isSelfAccount=" + this.isSelfAccount + ", imageUrl=" + this.imageUrl + ", payeeMobile=" + this.payeeMobile + ", beneficiaryId=" + this.beneficiaryId + ", paymentInstrumentId=" + this.paymentInstrumentId + ", paymentInstrumentType=" + this.paymentInstrumentType + ")";
        }

        public PaymentUiModel(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9) {
            k.c(str, "userName");
            k.c(str3, "accNoOrVpa");
            k.c(str4, "ifsc");
            k.c(str6, "payeeMobile");
            k.c(str7, "beneficiaryId");
            k.c(str8, "paymentInstrumentId");
            k.c(str9, "paymentInstrumentType");
            this.userName = str;
            this.bankName = str2;
            this.accNoOrVpa = str3;
            this.ifsc = str4;
            this.isSelfAccount = z;
            this.imageUrl = str5;
            this.payeeMobile = str6;
            this.beneficiaryId = str7;
            this.paymentInstrumentId = str8;
            this.paymentInstrumentType = str9;
        }

        public final String getUserName() {
            return this.userName;
        }

        public final String getBankName() {
            return this.bankName;
        }

        public final String getAccNoOrVpa() {
            return this.accNoOrVpa;
        }

        public final String getIfsc() {
            return this.ifsc;
        }

        public final boolean isSelfAccount() {
            return this.isSelfAccount;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getPayeeMobile() {
            return this.payeeMobile;
        }

        public final String getBeneficiaryId() {
            return this.beneficiaryId;
        }

        public final String getPaymentInstrumentId() {
            return this.paymentInstrumentId;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ PaymentUiModel(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, boolean r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.g.b.g r23) {
            /*
                r11 = this;
                r0 = r22
                r1 = r0 & 1
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x000a
                r1 = r2
                goto L_0x000b
            L_0x000a:
                r1 = r12
            L_0x000b:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0011
                r3 = r2
                goto L_0x0012
            L_0x0011:
                r3 = r13
            L_0x0012:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0018
                r4 = r2
                goto L_0x0019
            L_0x0018:
                r4 = r14
            L_0x0019:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x001f
                r5 = r2
                goto L_0x0020
            L_0x001f:
                r5 = r15
            L_0x0020:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0026
                r6 = 0
                goto L_0x0028
            L_0x0026:
                r6 = r16
            L_0x0028:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x002e
                r7 = r2
                goto L_0x0030
            L_0x002e:
                r7 = r17
            L_0x0030:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0036
                r8 = r2
                goto L_0x0038
            L_0x0036:
                r8 = r18
            L_0x0038:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x003e
                r9 = r2
                goto L_0x0040
            L_0x003e:
                r9 = r19
            L_0x0040:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0046
                r10 = r2
                goto L_0x0048
            L_0x0046:
                r10 = r20
            L_0x0048:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x004d
                goto L_0x004f
            L_0x004d:
                r2 = r21
            L_0x004f:
                r12 = r11
                r13 = r1
                r14 = r3
                r15 = r4
                r16 = r5
                r17 = r6
                r18 = r7
                r19 = r8
                r20 = r9
                r21 = r10
                r22 = r2
                r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.PaymentManager.PaymentUiModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
        }

        public final String getPaymentInstrumentType() {
            return this.paymentInstrumentType;
        }

        public final boolean isVpa() {
            return p.a((CharSequence) this.accNoOrVpa, (CharSequence) "@", false);
        }
    }

    public static final class PaymentUICollectRequestModel implements IJRDataModel {
        private final String amount;
        private final UpiProfileDefaultBank bank;
        private final String comments;
        private final String imageUrl;
        private final String name;
        private final String payeeVpa;
        private final String payerVpa;
        private final String txnId;
        private final String txnLogId;

        public static /* synthetic */ PaymentUICollectRequestModel copy$default(PaymentUICollectRequestModel paymentUICollectRequestModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, int i2, Object obj) {
            PaymentUICollectRequestModel paymentUICollectRequestModel2 = paymentUICollectRequestModel;
            int i3 = i2;
            return paymentUICollectRequestModel.copy((i3 & 1) != 0 ? paymentUICollectRequestModel2.name : str, (i3 & 2) != 0 ? paymentUICollectRequestModel2.payeeVpa : str2, (i3 & 4) != 0 ? paymentUICollectRequestModel2.payerVpa : str3, (i3 & 8) != 0 ? paymentUICollectRequestModel2.amount : str4, (i3 & 16) != 0 ? paymentUICollectRequestModel2.imageUrl : str5, (i3 & 32) != 0 ? paymentUICollectRequestModel2.comments : str6, (i3 & 64) != 0 ? paymentUICollectRequestModel2.txnId : str7, (i3 & 128) != 0 ? paymentUICollectRequestModel2.txnLogId : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentUICollectRequestModel2.bank : upiProfileDefaultBank);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.payeeVpa;
        }

        public final String component3() {
            return this.payerVpa;
        }

        public final String component4() {
            return this.amount;
        }

        public final String component5() {
            return this.imageUrl;
        }

        public final String component6() {
            return this.comments;
        }

        public final String component7() {
            return this.txnId;
        }

        public final String component8() {
            return this.txnLogId;
        }

        public final UpiProfileDefaultBank component9() {
            return this.bank;
        }

        public final PaymentUICollectRequestModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank) {
            k.c(str, "name");
            k.c(str2, "payeeVpa");
            k.c(str3, UpiRequestBuilder.KEY_PAYER_VPA);
            k.c(str4, "amount");
            return new PaymentUICollectRequestModel(str, str2, str3, str4, str5, str6, str7, str8, upiProfileDefaultBank);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaymentUICollectRequestModel)) {
                return false;
            }
            PaymentUICollectRequestModel paymentUICollectRequestModel = (PaymentUICollectRequestModel) obj;
            return k.a((Object) this.name, (Object) paymentUICollectRequestModel.name) && k.a((Object) this.payeeVpa, (Object) paymentUICollectRequestModel.payeeVpa) && k.a((Object) this.payerVpa, (Object) paymentUICollectRequestModel.payerVpa) && k.a((Object) this.amount, (Object) paymentUICollectRequestModel.amount) && k.a((Object) this.imageUrl, (Object) paymentUICollectRequestModel.imageUrl) && k.a((Object) this.comments, (Object) paymentUICollectRequestModel.comments) && k.a((Object) this.txnId, (Object) paymentUICollectRequestModel.txnId) && k.a((Object) this.txnLogId, (Object) paymentUICollectRequestModel.txnLogId) && k.a((Object) this.bank, (Object) paymentUICollectRequestModel.bank);
        }

        public final int hashCode() {
            String str = this.name;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.payeeVpa;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.payerVpa;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.amount;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.imageUrl;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.comments;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.txnId;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.txnLogId;
            int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            UpiProfileDefaultBank upiProfileDefaultBank = this.bank;
            if (upiProfileDefaultBank != null) {
                i2 = upiProfileDefaultBank.hashCode();
            }
            return hashCode8 + i2;
        }

        public final String toString() {
            return "PaymentUICollectRequestModel(name=" + this.name + ", payeeVpa=" + this.payeeVpa + ", payerVpa=" + this.payerVpa + ", amount=" + this.amount + ", imageUrl=" + this.imageUrl + ", comments=" + this.comments + ", txnId=" + this.txnId + ", txnLogId=" + this.txnLogId + ", bank=" + this.bank + ")";
        }

        public PaymentUICollectRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank) {
            k.c(str, "name");
            k.c(str2, "payeeVpa");
            k.c(str3, UpiRequestBuilder.KEY_PAYER_VPA);
            k.c(str4, "amount");
            this.name = str;
            this.payeeVpa = str2;
            this.payerVpa = str3;
            this.amount = str4;
            this.imageUrl = str5;
            this.comments = str6;
            this.txnId = str7;
            this.txnLogId = str8;
            this.bank = upiProfileDefaultBank;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPayeeVpa() {
            return this.payeeVpa;
        }

        public final String getPayerVpa() {
            return this.payerVpa;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PaymentUICollectRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, int i2, g gVar) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, str5, str6, str7, str8, upiProfileDefaultBank);
        }

        public final String getAmount() {
            return this.amount;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getComments() {
            return this.comments;
        }

        public final String getTxnId() {
            return this.txnId;
        }

        public final String getTxnLogId() {
            return this.txnLogId;
        }

        public final UpiProfileDefaultBank getBank() {
            return this.bank;
        }
    }

    public static PaymentUICollectRequestModel a(Intent intent) {
        k.c(intent, "intent");
        String stringExtra = intent.getStringExtra("payee_name");
        String stringExtra2 = intent.getStringExtra("payee_vpa");
        String stringExtra3 = intent.getStringExtra(UpiConstants.EXTRA_PAYER_VPA);
        String stringExtra4 = intent.getStringExtra("amount");
        String stringExtra5 = intent.getStringExtra(UpiConstants.EXTRA_KEY_COMMENTS);
        String stringExtra6 = intent.getStringExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID);
        String stringExtra7 = intent.getStringExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID);
        Serializable serializableExtra = intent.getSerializableExtra("user_upi_details");
        if (serializableExtra != null) {
            k.a((Object) stringExtra, "name");
            k.a((Object) stringExtra2, "payeeVpa");
            k.a((Object) stringExtra3, UpiRequestBuilder.KEY_PAYER_VPA);
            k.a((Object) stringExtra4, "amount");
            return new PaymentUICollectRequestModel(stringExtra, stringExtra2, stringExtra3, stringExtra4, "", stringExtra5, stringExtra6, stringExtra7, (UpiProfileDefaultBank) serializableExtra);
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiProfileDefaultBank");
    }
}
