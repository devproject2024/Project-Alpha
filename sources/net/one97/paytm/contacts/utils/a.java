package net.one97.paytm.contacts.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.d.f;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.o;
import kotlin.p;
import kotlin.s;
import kotlin.u;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.contacts.db.ContactDatabase;
import net.one97.paytm.contacts.entities.beans.ContactBeneficiaryBean;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.ContactInfo;
import net.one97.paytm.contacts.entities.beans.Contacts;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.contacts.entities.beans.DetailReqt;
import net.one97.paytm.contacts.entities.beans.GroupBean;
import net.one97.paytm.contacts.entities.beans.Meta;
import net.one97.paytm.contacts.entities.beans.PaymentInstrument;
import net.one97.paytm.contacts.entities.beans.PaymentInstrumentsReqt;
import net.one97.paytm.contacts.entities.beans.PhoneDTO;
import net.one97.paytm.contacts.entities.beans.PhoneDetails;
import net.one97.paytm.contacts.entities.beans.Response;
import net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails;
import net.one97.paytm.contacts.entities.db_entities.Configuration;
import net.one97.paytm.contacts.entities.db_entities.NonExistedContacts;
import net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails;
import net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo;
import net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.utils.af;
import net.one97.paytm.utils.x;
import net.one97.paytm.wallet.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50218a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f50219b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f50220c = {ContactColumn.CONTACT_ID, "has_phone_number", "display_name", "data1", "version"};

    /* renamed from: d  reason: collision with root package name */
    private static Comparator<ContactDetail> f50221d = k.f50243a;

    /* renamed from: e  reason: collision with root package name */
    private static Comparator<PayeeInfoDetails> f50222e = m.f50244a;

    /* renamed from: f  reason: collision with root package name */
    private static final CoroutineExceptionHandler f50223f = new C0903a(CoroutineExceptionHandler.Key);

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f50229a = "";

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f50230b = new ArrayList<>();
    }

    static final class k<T> implements Comparator<ContactDetail> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f50243a = new k();

        k() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            ContactDetail contactDetail = (ContactDetail) obj2;
            String contactName = ((ContactDetail) obj).getContactName();
            if (contactName == null) {
                kotlin.g.b.k.a();
            }
            String contactName2 = contactDetail.getContactName();
            if (contactName2 == null) {
                kotlin.g.b.k.a();
            }
            return contactName.compareTo(contactName2);
        }
    }

    static final class m<T> implements Comparator<PayeeInfoDetails> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f50244a = new m();

        m() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            PayeeInfoDetails payeeInfoDetails = (PayeeInfoDetails) obj2;
            String payeeInfoId = ((PayeeInfoDetails) obj).getPayeeInfoId();
            if (payeeInfoId == null) {
                kotlin.g.b.k.a();
            }
            String payeeInfoId2 = payeeInfoDetails.getPayeeInfoId();
            if (payeeInfoId2 == null) {
                kotlin.g.b.k.a();
            }
            return payeeInfoId.compareTo(payeeInfoId2);
        }
    }

    private a() {
    }

    /* renamed from: net.one97.paytm.contacts.utils.a$a  reason: collision with other inner class name */
    public static final class C0903a extends kotlin.d.a implements CoroutineExceptionHandler {
        public C0903a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            sb.append(" handled !");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x03a3, code lost:
        if (kotlin.m.p.a("0", r21.getContactNewTime(), true) == false) goto L_0x03ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.LinkedHashSet<net.one97.paytm.contacts.entities.beans.ContactDetail> a(android.content.Context r36, int r37) {
        /*
            r0 = r36
            r1 = r37
            java.lang.String r2 = "context"
            kotlin.g.b.k.c(r0, r2)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String.valueOf(r2)
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            net.one97.paytm.contacts.utils.e$b r3 = net.one97.paytm.contacts.utils.e.b.TRANSFER_BENEFICIARY
            int r3 = r3.getType()
            if (r1 != r3) goto L_0x0264
            net.one97.paytm.contacts.db.ContactDatabase$a r3 = net.one97.paytm.contacts.db.ContactDatabase.f50139a
            net.one97.paytm.contacts.db.ContactDatabase r3 = r3.a(r0)
            net.one97.paytm.contacts.b.c r3 = r3.g()
            java.util.List r1 = r3.a((int) r1)
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x03db
            java.util.Iterator r1 = r1.iterator()
        L_0x0038:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x03db
            java.lang.Object r3 = r1.next()
            net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails r3 = (net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails) r3
            net.one97.paytm.contacts.entities.beans.ContactDetail r15 = new net.one97.paytm.contacts.entities.beans.ContactDetail
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 4095(0xfff, float:5.738E-42)
            r20 = 0
            r5 = r15
            r4 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.lang.String r5 = r3.getPayeeInfoId()
            r4.setContactId(r5)
            java.lang.String r5 = r3.getName()
            r4.setContactName(r5)
            java.lang.String r5 = r3.getName()
            r4.setContactNickName(r5)
            java.lang.String r5 = r3.getPaymentInstrumentId()
            r4.setPaymentInstrumentId(r5)
            java.lang.String r5 = r3.getImageUrl()
            r4.setImageUrl(r5)
            java.lang.Integer r5 = r3.getContact_type()
            if (r5 != 0) goto L_0x0094
            kotlin.g.b.k.a()
        L_0x0094:
            int r5 = r5.intValue()
            r4.setContactType(r5)
            java.lang.String r5 = r3.getMobileNo()
            r4.setPrimaryPhoneNumber(r5)
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            net.one97.paytm.contacts.entities.beans.PaymentInstrument r12 = new net.one97.paytm.contacts.entities.beans.PaymentInstrument
            java.lang.String r7 = r3.getPaymentInstrumentId()
            java.lang.String r8 = r3.getInstrumentType()
            java.lang.String r9 = r3.getScore()
            java.lang.String r10 = r3.getInstrumentStatus()
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            java.lang.String r6 = r3.getAccountNo()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00db
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r13 = r3.getAccountNo()
            java.lang.String r14 = "accountNo"
            r6.put(r14, r13)
        L_0x00db:
            java.lang.String r6 = r3.getBankName()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r13 = "bankName"
            if (r6 != 0) goto L_0x00f3
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getBankName()
            r6.put(r13, r14)
        L_0x00f3:
            java.lang.String r6 = r3.getCustId()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x010b
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getCustId()
            java.lang.String r15 = "custId"
            r6.put(r15, r14)
        L_0x010b:
            java.lang.String r6 = r3.getIfsc()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0123
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getIfsc()
            java.lang.String r15 = "ifsc"
            r6.put(r15, r14)
        L_0x0123:
            java.lang.String r6 = r3.getVpa()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013c
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getVpa()
            java.lang.String r15 = "vpa"
            r6.put(r15, r14)
        L_0x013c:
            java.lang.String r6 = r3.getName()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0154
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getName()
            java.lang.String r15 = "name"
            r6.put(r15, r14)
        L_0x0154:
            java.lang.String r6 = r3.getNickname()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x016c
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getNickname()
            java.lang.String r15 = "nickName"
            r6.put(r15, r14)
        L_0x016c:
            java.lang.String r6 = r3.getMobileNo()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0184
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getMobileNo()
            java.lang.String r15 = "mobileNo"
            r6.put(r15, r14)
        L_0x0184:
            java.lang.String r6 = r3.getBankName()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x019a
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r14 = r3.getBankName()
            r6.put(r13, r14)
        L_0x019a:
            java.lang.String r6 = r3.getInstrument_meta_status()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01b3
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r13 = r3.getInstrument_meta_status()
            java.lang.String r14 = "type"
            r6.put(r14, r13)
        L_0x01b3:
            r6 = r12
            r6.<init>(r7, r8, r9, r10, r11)
            r5.add(r12)
            r4.setPaymentInstrument(r5)
            java.lang.String r5 = r3.getInstrumentType()
            r4.setMode(r5)
            java.lang.String r5 = r3.getInstrumentType()
            java.lang.String r6 = "BANK"
            r7 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r7)
            if (r5 == 0) goto L_0x021d
            java.lang.String r5 = r3.getAccountNo()
            java.lang.String r6 = r3.getBankName()
            java.lang.String r3 = r3.getIfsc()
            r4.setIfsc(r3)
            r3 = r5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x025a
            r3 = r6
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0211
            java.lang.String r3 = "null"
            r7 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r7)
            if (r3 != 0) goto L_0x0211
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = net.one97.paytm.utils.af.b(r6)
            r3.append(r6)
            java.lang.String r6 = " a/c "
            r3.append(r6)
            java.lang.String r5 = net.one97.paytm.wallet.utility.a.B(r5)
            goto L_0x0252
        L_0x0211:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "a/c "
            r3.<init>(r6)
            java.lang.String r5 = net.one97.paytm.wallet.utility.a.B(r5)
            goto L_0x0252
        L_0x021d:
            java.lang.String r5 = r3.getInstrumentType()
            java.lang.String r6 = "UPI"
            r7 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r7)
            if (r5 == 0) goto L_0x025a
            java.lang.String r5 = r3.getVpa()
            r4.setIfsc(r6)
            r3 = r5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x025a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r6 = net.one97.paytm.wallet.R.string.p2p_upi_id_string
            java.lang.String r6 = r0.getString(r6)
            r3.append(r6)
            java.lang.String r6 = " "
            r3.append(r6)
            if (r5 != 0) goto L_0x0252
            kotlin.g.b.k.a()
        L_0x0252:
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            goto L_0x025c
        L_0x025a:
            java.lang.String r3 = "Dummy"
        L_0x025c:
            r4.setContactDisplayDetail(r3)
            r2.add(r4)
            goto L_0x0038
        L_0x0264:
            net.one97.paytm.contacts.utils.e$b r3 = net.one97.paytm.contacts.utils.e.b.PHONEBOOK
            int r3 = r3.getType()
            if (r1 != r3) goto L_0x03db
            r1 = 0
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            net.one97.paytm.contacts.db.ContactDatabase$a r5 = net.one97.paytm.contacts.db.ContactDatabase.f50139a     // Catch:{ Exception -> 0x0286 }
            net.one97.paytm.contacts.db.ContactDatabase r5 = r5.a(r0)     // Catch:{ Exception -> 0x0286 }
            net.one97.paytm.contacts.b.k r5 = r5.a()     // Catch:{ Exception -> 0x0286 }
            java.util.List r1 = r5.a()     // Catch:{ Exception -> 0x0286 }
            goto L_0x0287
        L_0x0286:
        L_0x0287:
            r5 = r1
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x0295
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0293
            goto L_0x0295
        L_0x0293:
            r5 = 0
            goto L_0x0296
        L_0x0295:
            r5 = 1
        L_0x0296:
            if (r5 == 0) goto L_0x02b6
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r5 < r6) goto L_0x02aa
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r6) goto L_0x02b6
            java.lang.String r5 = "android.permission.READ_CONTACTS"
            int r5 = androidx.core.content.b.a((android.content.Context) r0, (java.lang.String) r5)
            if (r5 != 0) goto L_0x02b6
        L_0x02aa:
            r1 = 1
            java.util.LinkedHashSet r0 = a((android.content.Context) r0, (boolean) r1)
            java.util.Collection r0 = (java.util.Collection) r0
            r2.addAll(r0)
            goto L_0x03db
        L_0x02b6:
            if (r1 == 0) goto L_0x03b5
            java.util.Iterator r1 = r1.iterator()
        L_0x02bc:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x03b5
            java.lang.Object r5 = r1.next()
            net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo r5 = (net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo) r5
            java.lang.String r6 = r5.getPhoneNumber()
            java.lang.String r6 = net.one97.paytm.wallet.utility.a.h(r0, r6)
            net.one97.paytm.utils.x$a r7 = net.one97.paytm.utils.x.f69805a
            java.lang.String r7 = "phn"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            boolean r6 = net.one97.paytm.utils.x.a.a((java.lang.String) r6)
            if (r6 == 0) goto L_0x03b2
            net.one97.paytm.contacts.entities.beans.ContactDetail r6 = new net.one97.paytm.contacts.entities.beans.ContactDetail
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 4095(0xfff, float:5.738E-42)
            r35 = 0
            r21 = r6
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            java.lang.String r7 = r5.getPayeeInfoId()
            r6.setContactId(r7)
            java.lang.String r7 = r5.getNickName()
            r6.setContactNickName(r7)
            int r7 = r5.getType()
            r6.setContactType(r7)
            java.lang.String r7 = r5.getImageUrl()
            r6.setImageUrl(r7)
            java.lang.String r7 = r5.getPhoneNumber()
            r6.setPrimaryPhoneNumber(r7)
            java.lang.String r7 = r5.getName()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0337
            java.lang.String r7 = r5.getName()
            r6.setContactName(r7)
            goto L_0x033e
        L_0x0337:
            java.lang.String r7 = r5.getPhoneNumber()
            r6.setContactName(r7)
        L_0x033e:
            java.lang.String r7 = r5.getName()
            r6.setContactNickName(r7)
            java.lang.String r7 = r5.getNewExpiryTime()
            r6.setContactNewTime(r7)
            java.lang.String r7 = r5.getPhoneNumber()
            r6.setContactDisplayDetail(r7)
            net.one97.paytm.wallet.communicator.c r7 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r8 = "newContactVisiblityHrsV1"
            int r7 = r7.getIntegerFromGTM((android.content.Context) r0, (java.lang.String) r8)
            if (r7 <= 0) goto L_0x0366
            java.lang.String r7 = r5.getNewContactVisiblity()
            r6.setContactNewAddedTimeLocal(r7)
        L_0x0366:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r5.getPayeeInfoId()
            r7.append(r8)
            java.lang.String r5 = r5.getPhoneNumber()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.setUId(r5)
            java.lang.String r5 = r6.getContactNewAddedTimeLocal()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x03ac
            java.lang.String r5 = r6.getContactNewTime()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x03a6
            java.lang.String r5 = r6.getContactNewTime()
            java.lang.String r7 = "0"
            r8 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r5, (boolean) r8)
            if (r5 != 0) goto L_0x03a7
            goto L_0x03ad
        L_0x03a6:
            r8 = 1
        L_0x03a7:
            r4.add(r6)
            goto L_0x02bc
        L_0x03ac:
            r8 = 1
        L_0x03ad:
            r3.add(r6)
            goto L_0x02bc
        L_0x03b2:
            r8 = 1
            goto L_0x02bc
        L_0x03b5:
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x03c5
            java.util.List r3 = (java.util.List) r3
            java.util.Comparator<net.one97.paytm.contacts.entities.beans.ContactDetail> r1 = f50221d
            java.util.Collections.sort(r3, r1)
        L_0x03c5:
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L_0x03d5
            java.util.List r4 = (java.util.List) r4
            java.util.Comparator<net.one97.paytm.contacts.entities.beans.ContactDetail> r3 = f50221d
            java.util.Collections.sort(r4, r3)
        L_0x03d5:
            r2.addAll(r0)
            r2.addAll(r1)
        L_0x03db:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String.valueOf(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.utils.a.a(android.content.Context, int):java.util.LinkedHashSet");
    }

    private static LinkedHashSet<ContactDetail> a(Context context, boolean z) {
        Context context2 = context;
        LinkedHashSet<ContactDetail> linkedHashSet = new LinkedHashSet<>();
        Cursor cursor = null;
        ContentResolver contentResolver = context2 != null ? context.getContentResolver() : null;
        if (contentResolver != null) {
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, f50220c, (String) null, (String[]) null, "display_name ASC");
        }
        int i2 = 0;
        if (cursor != null) {
            linkedHashSet = new LinkedHashSet<>(cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    i2++;
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    String string = cursor.getString(cursor.getColumnIndex(ContactColumn.CONTACT_ID));
                    String string2 = cursor.getString(cursor.getColumnIndex("data1"));
                    CharSequence charSequence = string2;
                    if (!TextUtils.isEmpty(charSequence) && string2.length() >= 10) {
                        if (z) {
                            String h2 = net.one97.paytm.wallet.utility.a.h(context2, string2);
                            x.a aVar = x.f69805a;
                            kotlin.g.b.k.a((Object) h2, "phn");
                            if (x.a.a(h2)) {
                                hashSet.add(h2);
                            }
                        } else {
                            e eVar = e.f50261a;
                            kotlin.g.b.k.a((Object) string2, "phoneNo");
                            hashSet.add(e.a(string2));
                        }
                    }
                    if (!z || hashSet.size() != 0) {
                        String string3 = cursor.getString(cursor.getColumnIndex("display_name"));
                        String string4 = cursor.getString(cursor.getColumnIndex("version"));
                        if (!TextUtils.isEmpty(charSequence)) {
                            e eVar2 = e.f50261a;
                            kotlin.g.b.k.a((Object) string2, "phoneNo");
                            string2 = e.a(string2);
                        }
                        ContactDetail contactDetail = new ContactDetail((String) null, (String) null, (HashSet) null, (HashSet) null, (String) null, (String) null, (String) null, 0, (HashSet) null, (String) null, (String) null, (Boolean) null, 4095, (kotlin.g.b.g) null);
                        contactDetail.setContactName(string3);
                        contactDetail.setContactNickName(string3);
                        contactDetail.setAllPhoneNumberList(hashSet);
                        contactDetail.setEmailIdList(hashSet2);
                        contactDetail.setContactId(string);
                        contactDetail.setPrimaryPhoneNumber(string2);
                        contactDetail.setContactType(e.b.PHONEBOOK.getType());
                        contactDetail.setVersion(string4);
                        contactDetail.setDirty(Boolean.TRUE);
                        contactDetail.setEmailIdList(hashSet2);
                        contactDetail.setUId(string + string2);
                        linkedHashSet.add(contactDetail);
                    }
                } while (cursor.moveToNext());
            }
        }
        String.valueOf(i2);
        if (cursor != null) {
            af.a(cursor);
        }
        return linkedHashSet;
    }

    public static void a(Activity activity, x.d dVar, int i2) {
        kotlin.g.b.k.c(activity, "context");
        kotlin.g.b.k.c(dVar, "listener");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(f50223f)), (kotlin.d.f) null, (CoroutineStart) null, new h(i2, activity, dVar, (kotlin.d.d) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.LinkedHashSet<net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails> e(android.content.Context r14) {
        /*
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Comparator<net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails> r1 = f50222e
            r0.<init>(r1)
            r1 = 0
            if (r14 == 0) goto L_0x0010
            android.content.ContentResolver r14 = r14.getContentResolver()
            r2 = r14
            goto L_0x0011
        L_0x0010:
            r2 = r1
        L_0x0011:
            if (r2 == 0) goto L_0x001f
            android.net.Uri r3 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            java.lang.String[] r4 = f50220c
            r5 = 0
            r6 = 0
            java.lang.String r7 = "contact_id ASC"
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)
        L_0x001f:
            r14 = 0
            if (r1 == 0) goto L_0x006b
            boolean r2 = r1.moveToFirst()
            if (r2 == 0) goto L_0x006b
        L_0x0028:
            int r14 = r14 + 1
            java.lang.String r2 = "contact_id"
            int r2 = r1.getColumnIndex(r2)
            java.lang.String r6 = r1.getString(r2)
            java.lang.String r2 = "version"
            int r2 = r1.getColumnIndex(r2)
            java.lang.String r11 = r1.getString(r2)
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r2 = new net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails
            r4 = 0
            java.lang.String r3 = "contactId"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            net.one97.paytm.contacts.utils.e$b r3 = net.one97.paytm.contacts.utils.e.b.PHONEBOOK
            int r3 = r3.getType()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r10 = 0
            r12 = 1
            r13 = 0
            r3 = r2
            r7 = r8
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r3 = r0.contains(r2)
            if (r3 != 0) goto L_0x0065
            r0.add(r2)
        L_0x0065:
            boolean r2 = r1.moveToNext()
            if (r2 != 0) goto L_0x0028
        L_0x006b:
            java.lang.String.valueOf(r14)
            if (r1 == 0) goto L_0x0073
            r1.close()
        L_0x0073:
            java.util.LinkedHashSet r14 = new java.util.LinkedHashSet
            java.util.Collection r0 = (java.util.Collection) r0
            r14.<init>(r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.utils.a.e(android.content.Context):java.util.LinkedHashSet");
    }

    private static List<ContactDetail> a(Context context, String str, boolean z) {
        HashSet hashSet;
        List<ContactDetail> list;
        Context context2 = context;
        List<ContactDetail> list2 = null;
        ContentResolver contentResolver = context2 != null ? context.getContentResolver() : null;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet2 = new HashSet();
        Cursor query = contentResolver != null ? contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, f50220c, "contact_id = ".concat(String.valueOf(str)), (String[]) null, (String) null) : null;
        if (query != null && query.moveToFirst()) {
            while (true) {
                String string = query.getString(query.getColumnIndex("display_name"));
                String string2 = query.getString(query.getColumnIndex("data1"));
                HashSet hashSet3 = new HashSet();
                String string3 = query.getString(query.getColumnIndex("version"));
                if (!TextUtils.isEmpty(string2) && string2.length() >= 10) {
                    e eVar = e.f50261a;
                    kotlin.g.b.k.a((Object) string2, "phoneNo");
                    hashSet2.add(e.a(string2));
                }
                if (hashSet2.isEmpty()) {
                    return list2;
                }
                if (!arrayList.isEmpty()) {
                    ((ContactDetail) arrayList.get(0)).setAllPhoneNumberList(hashSet2);
                    list = list2;
                    hashSet = hashSet2;
                } else {
                    e eVar2 = e.f50261a;
                    kotlin.g.b.k.a((Object) string2, "phoneNo");
                    ContactDetail contactDetail = r4;
                    hashSet = hashSet2;
                    ContactDetail contactDetail2 = new ContactDetail(string, string, hashSet2, hashSet3, (String) null, str, e.a(string2), e.b.PHONEBOOK.getType(), (HashSet) null, (String) null, string3, Boolean.TRUE, 784, (kotlin.g.b.g) null);
                    if (z) {
                        int integerFromGTM = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context2, "newContactVisiblityHrsV1");
                        if (integerFromGTM > 0) {
                            contactDetail.setContactNewAddedTimeLocal(String.valueOf(System.currentTimeMillis() + ((long) (integerFromGTM * 60 * 60 * 1000))));
                        } else {
                            list = null;
                            contactDetail.setContactNewAddedTimeLocal((String) null);
                            arrayList.add(contactDetail);
                        }
                    }
                    list = null;
                    arrayList.add(contactDetail);
                }
                if (!query.moveToNext()) {
                    break;
                }
                list2 = list;
                hashSet2 = hashSet;
            }
        }
        if (query != null) {
            af.a(query);
        }
        return arrayList;
    }

    private static void a(Context context, HashSet<PayeeInfoDetails> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator<PayeeInfoDetails> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            List<ContactDetail> a2 = a(context, it2.next().getPayeeInfoId(), true);
            if (a2 != null) {
                hashSet2.addAll(a2);
            }
        }
        if (!hashSet2.isEmpty()) {
            a(context, (HashSet<ContactDetail>) hashSet2, true);
        }
    }

    private static void b(Context context, HashSet<PayeeInfoDetails> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator<PayeeInfoDetails> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            List<ContactDetail> a2 = a(context, it2.next().getPayeeInfoId(), false);
            if (a2 != null) {
                hashSet2.addAll(a2);
            }
        }
        if (!hashSet2.isEmpty()) {
            a(context, (HashSet<ContactDetail>) hashSet2, false);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0035 A[LOOP:0: B:1:0x0035->B:72:0x0035, LOOP_END, SYNTHETIC] */
    private static kotlin.s<java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails>, java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails>, java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails>> a(java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails> r10, java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails> r11) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = " phnn book id  "
            r0.<init>(r1)
            r0.append(r10)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = " db book id  "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.Object[] r0 = r10.toArray()
            java.lang.Object[] r1 = r11.toArray()
            int r10 = r10.size()
            int r11 = r11.size()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
            r6 = 0
        L_0x0035:
            if (r5 >= r10) goto L_0x00ee
            java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails"
            if (r6 < r11) goto L_0x004d
            r8 = r0[r5]
            if (r8 == 0) goto L_0x0047
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r8 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r8
            r2.add(r8)
        L_0x0044:
            int r5 = r5 + 1
            goto L_0x004d
        L_0x0047:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x004d:
            if (r6 >= r11) goto L_0x0035
            if (r5 < r10) goto L_0x0063
            r8 = r1[r6]
            if (r8 == 0) goto L_0x005d
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r8 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r8
            r3.add(r8)
        L_0x005a:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x005d:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x0063:
            r8 = r0[r5]
            if (r8 == 0) goto L_0x00e8
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r8 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r8
            java.lang.String r8 = r8.getPayeeInfoId()
            int r8 = java.lang.Integer.parseInt(r8)
            r9 = r1[r6]
            if (r9 == 0) goto L_0x00e2
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r9 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r9
            java.lang.String r9 = r9.getPayeeInfoId()
            int r9 = java.lang.Integer.parseInt(r9)
            if (r8 != r9) goto L_0x00bc
            r8 = r0[r5]
            if (r8 == 0) goto L_0x00b6
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r8 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r8
            java.lang.String r8 = r8.getVersion()
            r9 = r1[r6]
            if (r9 == 0) goto L_0x00b0
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r9 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r9
            java.lang.String r9 = r9.getVersion()
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r9)
            r8 = r8 ^ 1
            if (r8 == 0) goto L_0x00ad
            r8 = r0[r5]
            if (r8 == 0) goto L_0x00a7
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r8 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r8
            r4.add(r8)
            goto L_0x00ad
        L_0x00a7:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x00ad:
            int r5 = r5 + 1
            goto L_0x005a
        L_0x00b0:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x00b6:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x00bc:
            if (r8 >= r9) goto L_0x00cf
            r8 = r0[r5]
            if (r8 == 0) goto L_0x00c9
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r8 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r8
            r2.add(r8)
            goto L_0x0044
        L_0x00c9:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x00cf:
            if (r8 <= r9) goto L_0x004d
            r8 = r1[r6]
            if (r8 == 0) goto L_0x00dc
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r8 = (net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r8
            r3.add(r8)
            goto L_0x005a
        L_0x00dc:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x00e2:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x00e8:
            kotlin.u r10 = new kotlin.u
            r10.<init>(r7)
            throw r10
        L_0x00ee:
            kotlin.s r10 = new kotlin.s
            java.util.HashSet r11 = new java.util.HashSet
            java.util.Collection r3 = (java.util.Collection) r3
            r11.<init>(r3)
            java.util.HashSet r0 = new java.util.HashSet
            java.util.Collection r2 = (java.util.Collection) r2
            r0.<init>(r2)
            java.util.HashSet r1 = new java.util.HashSet
            java.util.Collection r4 = (java.util.Collection) r4
            r1.<init>(r4)
            r10.<init>(r11, r0, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.utils.a.a(java.util.HashSet, java.util.HashSet):kotlin.s");
    }

    private static void a(Context context, HashSet<ContactDetail> hashSet, boolean z) {
        Context context2 = context;
        if (z) {
            Iterator<ContactDetail> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ContactDetail next = it2.next();
                String contactId = next.getContactId();
                if (contactId == null) {
                    kotlin.g.b.k.a();
                }
                PayeeInfoDetails payeeInfoDetails = new PayeeInfoDetails(0, contactId, next.isDirty(), Boolean.FALSE, Integer.valueOf(next.getContactType()), next.getContactNewAddedTimeLocal(), next.getVersion(), 1, (kotlin.g.b.g) null);
                kotlin.g.b.k.a((Object) next, "contact");
                ContactDatabase.f50139a.a(context2).c().a(new b(payeeInfoDetails, a(next), next.getContactType()));
            }
            return;
        }
        Iterator<ContactDetail> it3 = hashSet.iterator();
        while (it3.hasNext()) {
            ContactDetail next2 = it3.next();
            ArrayList arrayList = new ArrayList();
            HashSet hashSet2 = new HashSet();
            new HashSet();
            if (!TextUtils.isEmpty(next2.getContactId())) {
                String contactId2 = next2.getContactId();
                if (contactId2 == null) {
                    kotlin.g.b.k.a();
                }
                arrayList.add(contactId2);
                String contactId3 = next2.getContactId();
                if (contactId3 == null) {
                    kotlin.g.b.k.a();
                }
                PayeeInfoDetails payeeInfoDetails2 = new PayeeInfoDetails(0, contactId3, next2.isDirty(), Boolean.FALSE, Integer.valueOf(next2.getContactType()), next2.getContactNewAddedTimeLocal(), next2.getVersion(), 1, (kotlin.g.b.g) null);
                hashSet2.add(payeeInfoDetails2);
                kotlin.g.b.k.a((Object) next2, "contact");
                PayeeInfoDetails payeeInfoDetails3 = payeeInfoDetails2;
                ContactDatabase.f50139a.a(context2).c().b(new f(payeeInfoDetails3, a(next2), new HashSet(), arrayList, (Configuration) null));
            }
        }
    }

    private static HashSet<PayeeMetaInfo> a(ContactDetail contactDetail) {
        HashSet<PayeeMetaInfo> hashSet = new HashSet<>();
        Collection allPhoneNumberList = contactDetail.getAllPhoneNumberList();
        if (!(allPhoneNumberList == null || allPhoneNumberList.isEmpty())) {
            HashSet<String> allPhoneNumberList2 = contactDetail.getAllPhoneNumberList();
            if (allPhoneNumberList2 == null) {
                kotlin.g.b.k.a();
            }
            Iterator<String> it2 = allPhoneNumberList2.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                String contactId = contactDetail.getContactId();
                if (contactId == null) {
                    kotlin.g.b.k.a();
                }
                hashSet.add(new PayeeMetaInfo(0, contactId, kotlin.g.b.k.a(contactDetail.getContactId(), (Object) next), next, contactDetail.getContactName(), contactDetail.getContactNickName(), contactDetail.getImageUrl(), contactDetail.getContactType(), contactDetail.getContactStatus(), true, Boolean.FALSE, contactDetail.getContactNewAddedTimeLocal(), contactDetail.getContactNewTime(), 1, (kotlin.g.b.g) null));
            }
        } else {
            String contactId2 = contactDetail.getContactId();
            if (contactId2 == null) {
                kotlin.g.b.k.a();
            }
            hashSet.add(new PayeeMetaInfo(0, contactId2, kotlin.g.b.k.a(contactDetail.getContactId(), (Object) contactDetail.getPrimaryPhoneNumber()), contactDetail.getPrimaryPhoneNumber(), contactDetail.getContactName(), contactDetail.getContactNickName(), contactDetail.getImageUrl(), contactDetail.getContactType(), contactDetail.getContactStatus(), true, Boolean.FALSE, contactDetail.getContactNewAddedTimeLocal(), contactDetail.getContactNewTime(), 1, (kotlin.g.b.g) null));
        }
        return hashSet;
    }

    public static void a(Context context) {
        kotlin.g.b.k.c(context, "context");
        new StringBuilder("Starting from Phone Book Sync ").append(System.currentTimeMillis());
        LinkedHashSet<ContactDetail> a2 = a(context, false);
        new StringBuilder("Ending from Phone Book Sync ").append(System.currentTimeMillis());
        new StringBuilder("Starting from App local db  ").append(System.currentTimeMillis());
        if (!a2.isEmpty()) {
            a(context, (HashSet<ContactDetail>) a2, true);
        }
        new StringBuilder("Ending from App local db").append(System.currentTimeMillis());
    }

    public static void a(Context context, ContactBeneficiaryBean contactBeneficiaryBean, e.f fVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(contactBeneficiaryBean, "contactBeneficiaryBean");
        kotlin.g.b.k.c(fVar, "listerer");
        x.d dVar = new x.d();
        Response responseObject = contactBeneficiaryBean.getResponseObject();
        kotlin.g.b.k.a((Object) responseObject, "contactBeneficiaryBean.responseObject");
        dVar.element = responseObject.getLastTimestamp();
        x.c cVar = new x.c();
        cVar.element = 0;
        x.e eVar = new x.e();
        Response responseObject2 = contactBeneficiaryBean.getResponseObject();
        kotlin.g.b.k.a((Object) responseObject2, "contactBeneficiaryBean.responseObject");
        eVar.element = Boolean.valueOf(responseObject2.getUsePaymentInstruments());
        x.e eVar2 = new x.e();
        Response responseObject3 = contactBeneficiaryBean.getResponseObject();
        kotlin.g.b.k.a((Object) responseObject3, "contactBeneficiaryBean.responseObject");
        eVar2.element = new LinkedHashSet(responseObject3.getContacts());
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(f50223f)), (kotlin.d.f) null, (CoroutineStart) null, new j(eVar2, cVar, context, dVar, eVar, fVar, (kotlin.d.d) null), 3, (Object) null);
    }

    public static o<HashSet<PayeeMetaInfo>, HashSet<PaymentInstrumentDetails>> a(HashSet<PaymentInstrument> hashSet, ContactsResponse contactsResponse) {
        long j2;
        kotlin.g.b.k.c(hashSet, "instuments");
        kotlin.g.b.k.c(contactsResponse, "contact");
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        if (contactsResponse.getContactInfo() != null) {
            ContactInfo contactInfo = contactsResponse.getContactInfo();
            kotlin.g.b.k.a((Object) contactInfo, "contact.contactInfo");
            if (contactInfo.getMeta() != null) {
                ContactInfo contactInfo2 = contactsResponse.getContactInfo();
                kotlin.g.b.k.a((Object) contactInfo2, "contact.contactInfo");
                Meta meta = contactInfo2.getMeta();
                kotlin.g.b.k.a((Object) meta, "contact.contactInfo.meta");
                if (meta.getPhoneDto() != null) {
                    ContactInfo contactInfo3 = contactsResponse.getContactInfo();
                    kotlin.g.b.k.a((Object) contactInfo3, "contact.contactInfo");
                    Meta meta2 = contactInfo3.getMeta();
                    kotlin.g.b.k.a((Object) meta2, "contact.contactInfo.meta");
                    if (meta2.getPhoneDto() != null) {
                        String contactId = contactsResponse.getContactId();
                        String str = contactId;
                        kotlin.g.b.k.a((Object) contactId, "contact.contactId");
                        ContactInfo contactInfo4 = contactsResponse.getContactInfo();
                        kotlin.g.b.k.a((Object) contactInfo4, "contact.contactInfo");
                        Meta meta3 = contactInfo4.getMeta();
                        kotlin.g.b.k.a((Object) meta3, "contact.contactInfo.meta");
                        PhoneDTO phoneDto = meta3.getPhoneDto();
                        kotlin.g.b.k.a((Object) phoneDto, "contact.contactInfo.meta.phoneDto");
                        PhoneDetails primaryMobile = phoneDto.getPrimaryMobile();
                        kotlin.g.b.k.a((Object) primaryMobile, "contact.contactInfo.meta.phoneDto.primaryMobile");
                        String phoneNo = primaryMobile.getPhoneNo();
                        String nickName = contactsResponse.getNickName();
                        ContactInfo contactInfo5 = contactsResponse.getContactInfo();
                        kotlin.g.b.k.a((Object) contactInfo5, "contact.contactInfo");
                        Meta meta4 = contactInfo5.getMeta();
                        kotlin.g.b.k.a((Object) meta4, "contact.contactInfo.meta");
                        String image = meta4.getImage();
                        StringBuilder sb = new StringBuilder();
                        sb.append(contactsResponse.getContactId());
                        ContactInfo contactInfo6 = contactsResponse.getContactInfo();
                        kotlin.g.b.k.a((Object) contactInfo6, "contact.contactInfo");
                        Meta meta5 = contactInfo6.getMeta();
                        kotlin.g.b.k.a((Object) meta5, "contact.contactInfo.meta");
                        PhoneDTO phoneDto2 = meta5.getPhoneDto();
                        kotlin.g.b.k.a((Object) phoneDto2, "contact.contactInfo.meta.phoneDto");
                        PhoneDetails primaryMobile2 = phoneDto2.getPrimaryMobile();
                        kotlin.g.b.k.a((Object) primaryMobile2, "contact.contactInfo.meta.phoneDto.primaryMobile");
                        sb.append(primaryMobile2.getPhoneNo());
                        hashSet2.add(new PayeeMetaInfo(0, str, sb.toString(), phoneNo, contactsResponse.getName(), nickName, image, e.b.PHONEBOOK.getType(), contactsResponse.getStatus(), true, Boolean.FALSE, (String) null, (String) null, 1, (kotlin.g.b.g) null));
                    }
                    ContactInfo contactInfo7 = contactsResponse.getContactInfo();
                    kotlin.g.b.k.a((Object) contactInfo7, "contact.contactInfo");
                    Meta meta6 = contactInfo7.getMeta();
                    kotlin.g.b.k.a((Object) meta6, "contact.contactInfo.meta");
                    PhoneDTO phoneDto3 = meta6.getPhoneDto();
                    kotlin.g.b.k.a((Object) phoneDto3, "contact.contactInfo.meta.phoneDto");
                    Collection secondaryMobile = phoneDto3.getSecondaryMobile();
                    if (!(secondaryMobile == null || secondaryMobile.isEmpty())) {
                        ContactInfo contactInfo8 = contactsResponse.getContactInfo();
                        kotlin.g.b.k.a((Object) contactInfo8, "contact.contactInfo");
                        Meta meta7 = contactInfo8.getMeta();
                        kotlin.g.b.k.a((Object) meta7, "contact.contactInfo.meta");
                        PhoneDTO phoneDto4 = meta7.getPhoneDto();
                        kotlin.g.b.k.a((Object) phoneDto4, "contact.contactInfo.meta.phoneDto");
                        ArrayList<PhoneDetails> secondaryMobile2 = phoneDto4.getSecondaryMobile();
                        kotlin.g.b.k.a((Object) secondaryMobile2, "contact.contactInfo.meta.phoneDto.secondaryMobile");
                        Iterator<PhoneDetails> it2 = secondaryMobile2.iterator();
                        while (it2.hasNext()) {
                            PhoneDetails next = it2.next();
                            String contactId2 = contactsResponse.getContactId();
                            String str2 = contactId2;
                            kotlin.g.b.k.a((Object) contactId2, "contact.contactId");
                            kotlin.g.b.k.a((Object) next, "phn");
                            String phoneNo2 = next.getPhoneNo();
                            String nickName2 = contactsResponse.getNickName();
                            ContactInfo contactInfo9 = contactsResponse.getContactInfo();
                            kotlin.g.b.k.a((Object) contactInfo9, "contact.contactInfo");
                            Meta meta8 = contactInfo9.getMeta();
                            kotlin.g.b.k.a((Object) meta8, "contact.contactInfo.meta");
                            hashSet2.add(new PayeeMetaInfo(0, str2, contactsResponse.getContactId() + next.getPhoneNo(), phoneNo2, contactsResponse.getName(), nickName2, meta8.getImage(), e.b.PHONEBOOK.getType(), contactsResponse.getStatus(), true, Boolean.FALSE, (String) null, (String) null, 1, (kotlin.g.b.g) null));
                        }
                    }
                }
            }
        }
        Iterator<PaymentInstrument> it3 = hashSet.iterator();
        while (it3.hasNext()) {
            PaymentInstrument next2 = it3.next();
            HashMap hashMap = new HashMap();
            kotlin.g.b.k.a((Object) next2, "instrument");
            if (next2.getMeta() != null) {
                Object meta9 = next2.getMeta();
                if (meta9 != null) {
                    hashMap.putAll((Map) meta9);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<out kotlin.String, kotlin.String>");
                }
            }
            if (p.a("ACTIVE", next2.getStatus(), true)) {
                hashSet3.add(new PaymentInstrumentDetails(0, next2.getPaymentInstrumentRefId(), next2.getType(), next2.getStatus(), next2.getScore(), contactsResponse.getContactId(), contactsResponse.getContactId() + next2.getPaymentInstrumentId(), (String) hashMap.get("mobileNo"), (String) hashMap.get("custId"), (String) hashMap.get("bankName"), (String) hashMap.get("type"), (String) hashMap.get("accountNo"), (String) hashMap.get("ifsc"), (String) hashMap.get("vpa"), next2.getRecentNewValidityExpiryTime(), 1, (kotlin.g.b.g) null));
            }
        }
        HashMap hashMap2 = new HashMap();
        Iterator it4 = hashSet3.iterator();
        while (it4.hasNext()) {
            PaymentInstrumentDetails paymentInstrumentDetails = (PaymentInstrumentDetails) it4.next();
            Iterator it5 = hashSet2.iterator();
            while (it5.hasNext()) {
                PayeeMetaInfo payeeMetaInfo = (PayeeMetaInfo) it5.next();
                if (paymentInstrumentDetails.getPayeeMetaId().equals(paymentInstrumentDetails.getPayeeMetaId())) {
                    if (hashMap2.containsKey(payeeMetaInfo.getPayeeMetaId())) {
                        String str3 = (String) hashMap2.get(payeeMetaInfo.getPayeeMetaId());
                        long j3 = 0;
                        if (!TextUtils.isEmpty(str3)) {
                            if (str3 == null) {
                                kotlin.g.b.k.a();
                            }
                            j2 = Long.parseLong(str3);
                        } else {
                            j2 = 0;
                        }
                        if (!TextUtils.isEmpty(paymentInstrumentDetails.getExpiryTime())) {
                            String expiryTime = paymentInstrumentDetails.getExpiryTime();
                            if (expiryTime == null) {
                                kotlin.g.b.k.a();
                            }
                            j3 = Long.parseLong(expiryTime);
                        }
                        if (j3 > j2) {
                            hashMap2.put(payeeMetaInfo.getPayeeMetaId(), String.valueOf(j3));
                        }
                    } else {
                        hashMap2.put(payeeMetaInfo.getPayeeMetaId(), paymentInstrumentDetails.getExpiryTime());
                    }
                }
            }
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            String str4 = (String) entry.getKey();
            String str5 = (String) entry.getValue();
            Iterator it6 = hashSet2.iterator();
            while (it6.hasNext()) {
                PayeeMetaInfo payeeMetaInfo2 = (PayeeMetaInfo) it6.next();
                if (p.a(payeeMetaInfo2.getPayeeMetaId(), str4, true)) {
                    payeeMetaInfo2.setNewExpiryTime(str5);
                }
            }
        }
        return new o<>(hashSet2, hashSet3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0085, code lost:
        r5 = r5.getMeta();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.LinkedHashSet<net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails> a(net.one97.paytm.contacts.entities.beans.ContactsResponse r28) {
        /*
            java.lang.String r0 = "contact"
            r1 = r28
            kotlin.g.b.k.c(r1, r0)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.HashSet r2 = r28.getPaymentInstruments()
            if (r2 == 0) goto L_0x00f1
            java.util.Iterator r2 = r2.iterator()
        L_0x0016:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00f1
            java.lang.Object r3 = r2.next()
            net.one97.paytm.contacts.entities.beans.PaymentInstrument r3 = (net.one97.paytm.contacts.entities.beans.PaymentInstrument) r3
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r5 = "paymentInstrument"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.Object r5 = r3.getMeta()
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r3.getMeta()
            if (r5 == 0) goto L_0x003e
            java.util.Map r5 = (java.util.Map) r5
            r4.putAll(r5)
            goto L_0x0046
        L_0x003e:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.Map<out kotlin.String, kotlin.String>"
            r0.<init>(r1)
            throw r0
        L_0x0046:
            net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails r15 = new net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails
            r6 = 0
            java.lang.String r8 = r28.getContactId()
            java.lang.String r5 = "contact.contactId"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            java.lang.String r5 = "name"
            java.lang.Object r5 = r4.get(r5)
            r9 = r5
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r5 = "nickName"
            java.lang.Object r5 = r4.get(r5)
            r10 = r5
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r11 = r28.getStatus()
            net.one97.paytm.contacts.utils.e$b r5 = net.one97.paytm.contacts.utils.e.b.TRANSFER_BENEFICIARY
            int r5 = r5.getType()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
            java.lang.String r13 = r3.getPaymentInstrumentId()
            java.lang.String r14 = r3.getType()
            java.lang.String r17 = r3.getScore()
            net.one97.paytm.contacts.entities.beans.ContactInfo r5 = r28.getContactInfo()
            if (r5 == 0) goto L_0x0090
            net.one97.paytm.contacts.entities.beans.Meta r5 = r5.getMeta()
            if (r5 == 0) goto L_0x0090
            java.lang.String r5 = r5.getImage()
            goto L_0x0091
        L_0x0090:
            r5 = 0
        L_0x0091:
            r27 = r5
            java.lang.String r5 = "mobileNo"
            java.lang.Object r5 = r4.get(r5)
            r18 = r5
            java.lang.String r18 = (java.lang.String) r18
            java.lang.String r5 = "custId"
            java.lang.Object r5 = r4.get(r5)
            r19 = r5
            java.lang.String r19 = (java.lang.String) r19
            java.lang.String r5 = "bankName"
            java.lang.Object r5 = r4.get(r5)
            r20 = r5
            java.lang.String r20 = (java.lang.String) r20
            java.lang.String r5 = "type"
            java.lang.Object r5 = r4.get(r5)
            r21 = r5
            java.lang.String r21 = (java.lang.String) r21
            java.lang.String r5 = "accountNo"
            java.lang.Object r5 = r4.get(r5)
            r22 = r5
            java.lang.String r22 = (java.lang.String) r22
            java.lang.String r5 = "ifsc"
            java.lang.Object r5 = r4.get(r5)
            r23 = r5
            java.lang.String r23 = (java.lang.String) r23
            java.lang.String r5 = "vpa"
            java.lang.Object r4 = r4.get(r5)
            r24 = r4
            java.lang.String r24 = (java.lang.String) r24
            java.lang.String r16 = r3.getStatus()
            r25 = 1
            r26 = 0
            r5 = r15
            r3 = r15
            r15 = r17
            r17 = r27
            r5.<init>(r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r0.add(r3)
            goto L_0x0016
        L_0x00f1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.utils.a.a(net.one97.paytm.contacts.entities.beans.ContactsResponse):java.util.LinkedHashSet");
    }

    public static void a(Context context, String str, int i2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "id");
        ContactDatabase.f50139a.a(context).f().b(i2, str);
    }

    private static void c(Context context, HashSet<PayeeInfoDetails> hashSet) {
        int size = hashSet.size();
        if (size != 0) {
            double ceil = Math.ceil((double) (size / 100));
            if (ceil == 0.0d) {
                ceil = (double) size;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<PayeeInfoDetails> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getPayeeInfoId());
            }
            while (((int) ceil) != 0) {
                if (100 >= arrayList.size()) {
                    List subList = new ArrayList(arrayList).subList(0, arrayList.size());
                    kotlin.g.b.k.a((Object) subList, "ArrayList(list).subList(0, list.size)");
                    arrayList.removeAll(subList);
                    ContactDatabase.f50139a.a(context).f().a(e.b.PHONEBOOK.getType(), (List<String>) subList);
                    ContactDatabase.f50139a.a(context).a().a((List<String>) subList);
                } else {
                    List subList2 = new ArrayList(arrayList).subList(0, 100);
                    kotlin.g.b.k.a((Object) subList2, "ArrayList(list).subList(0, batchLimit)");
                    arrayList.removeAll(subList2);
                    ContactDatabase.f50139a.a(context).f().a(e.b.PHONEBOOK.getType(), (List<String>) subList2);
                    ContactDatabase.f50139a.a(context).a().a((List<String>) subList2);
                }
                ceil -= 4.0d;
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "id");
        kotlin.g.b.k.c(str2, "contactType");
        String str3 = (!p.a(e.b.PHONEBOOK.name(), str2, true) && !p.a(e.b.TRANSFER_BENEFICIARY.name(), str2, true)) ? null : str;
        if (!TextUtils.isEmpty(str3)) {
            d dVar = new d();
            int i2 = -1;
            if (p.a(e.b.PHONEBOOK.name(), str2, true)) {
                i2 = e.b.PHONEBOOK.getType();
            } else if (p.a(e.b.TRANSFER_BENEFICIARY.name(), str2, true)) {
                i2 = e.b.TRANSFER_BENEFICIARY.getType();
            }
            if (i2 == e.b.PHONEBOOK.getType()) {
                net.one97.paytm.contacts.b.i f2 = ContactDatabase.f50139a.a(context).f();
                if (str3 == null) {
                    kotlin.g.b.k.a();
                }
                PayeeInfoDetails a2 = f2.a(str3, i2);
                if (a2 != null) {
                    String payeeInfoId = a2.getPayeeInfoId();
                    kotlin.g.b.k.c(payeeInfoId, "<set-?>");
                    dVar.f50229a = payeeInfoId;
                    ContactDatabase.f50139a.a(context).c().a(dVar);
                }
            } else if (i2 == e.b.TRANSFER_BENEFICIARY.getType()) {
                net.one97.paytm.contacts.b.a c2 = ContactDatabase.f50139a.a(context).c();
                if (str3 == null) {
                    kotlin.g.b.k.a();
                }
                c2.a(new c(str3, i2));
            }
        } else {
            ContactDatabase.f50139a.a(context).d().a(str);
        }
    }

    public static void b(Context context) {
        kotlin.g.b.k.c(context, "context");
        Collection a2 = ContactDatabase.f50139a.a(context).f().a(e.b.PHONEBOOK.getType());
        if (a2.isEmpty()) {
            a(context);
            return;
        }
        new StringBuilder("  Starting contact id ").append(System.currentTimeMillis());
        HashSet e2 = e(context);
        new StringBuilder("  ending contact id ").append(System.currentTimeMillis());
        if (!e2.isEmpty()) {
            new StringBuilder("  Start filter id ").append(System.currentTimeMillis());
            s<HashSet<PayeeInfoDetails>, HashSet<PayeeInfoDetails>, HashSet<PayeeInfoDetails>> a3 = a((HashSet<PayeeInfoDetails>) e2, (HashSet<PayeeInfoDetails>) new LinkedHashSet(a2));
            new StringBuilder("  ending filter id ").append(System.currentTimeMillis());
            new StringBuilder(" Delete Starting ").append(System.currentTimeMillis());
            boolean z = false;
            if (!f50218a) {
                Collection first = a3.getFirst();
                f50218a = !(first == null || first.isEmpty());
            }
            c(context, a3.getFirst());
            new StringBuilder(" Delete Ending ").append(System.currentTimeMillis());
            new StringBuilder(" Add new Starting ").append(System.currentTimeMillis());
            if (!f50218a) {
                Collection second = a3.getSecond();
                f50218a = !(second == null || second.isEmpty());
            }
            a(context, a3.getSecond());
            new StringBuilder(" Add New Ending ").append(System.currentTimeMillis());
            new StringBuilder(" update Stating ").append(System.currentTimeMillis());
            if (!f50218a) {
                Collection third = a3.getThird();
                if (third == null || third.isEmpty()) {
                    z = true;
                }
                f50218a = !z;
            }
            b(context, a3.getThird());
            new StringBuilder(" update Ending ").append(System.currentTimeMillis());
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public PayeeInfoDetails f50239a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedHashSet<BeneficiaryMetaDetails> f50240b;

        /* renamed from: c  reason: collision with root package name */
        public String f50241c;

        /* renamed from: d  reason: collision with root package name */
        public int f50242d;

        public g(PayeeInfoDetails payeeInfoDetails, LinkedHashSet<BeneficiaryMetaDetails> linkedHashSet, String str, int i2) {
            kotlin.g.b.k.c(payeeInfoDetails, "payee");
            kotlin.g.b.k.c(linkedHashSet, "beneficiaryMetaDetails");
            kotlin.g.b.k.c(str, "contactId");
            this.f50239a = payeeInfoDetails;
            this.f50240b = linkedHashSet;
            this.f50241c = str;
            this.f50242d = i2;
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public PayeeInfoDetails f50231a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedHashSet<BeneficiaryMetaDetails> f50232b;

        /* renamed from: c  reason: collision with root package name */
        private int f50233c;

        public e(PayeeInfoDetails payeeInfoDetails, LinkedHashSet<BeneficiaryMetaDetails> linkedHashSet, int i2) {
            kotlin.g.b.k.c(payeeInfoDetails, "payee");
            kotlin.g.b.k.c(linkedHashSet, "beneficiaryMetaDetails");
            this.f50231a = payeeInfoDetails;
            this.f50232b = linkedHashSet;
            this.f50233c = i2;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public String f50227a;

        /* renamed from: b  reason: collision with root package name */
        public int f50228b;

        public c(String str, int i2) {
            kotlin.g.b.k.c(str, "contactId");
            this.f50227a = str;
            this.f50228b = i2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public PayeeInfoDetails f50224a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<PayeeMetaInfo> f50225b;

        /* renamed from: c  reason: collision with root package name */
        private int f50226c;

        public b(PayeeInfoDetails payeeInfoDetails, HashSet<PayeeMetaInfo> hashSet, int i2) {
            kotlin.g.b.k.c(payeeInfoDetails, "payee");
            kotlin.g.b.k.c(hashSet, "metaList");
            this.f50224a = payeeInfoDetails;
            this.f50225b = hashSet;
            this.f50226c = i2;
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public PayeeInfoDetails f50234a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<PayeeMetaInfo> f50235b;

        /* renamed from: c  reason: collision with root package name */
        public HashSet<PaymentInstrumentDetails> f50236c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f50237d;

        /* renamed from: e  reason: collision with root package name */
        public final Configuration f50238e;

        public f(PayeeInfoDetails payeeInfoDetails, HashSet<PayeeMetaInfo> hashSet, HashSet<PaymentInstrumentDetails> hashSet2, List<String> list, Configuration configuration) {
            kotlin.g.b.k.c(payeeInfoDetails, "payee");
            kotlin.g.b.k.c(hashSet, "metaList");
            kotlin.g.b.k.c(hashSet2, "instrumentList");
            kotlin.g.b.k.c(list, "deletedId");
            this.f50234a = payeeInfoDetails;
            this.f50235b = hashSet;
            this.f50236c = hashSet2;
            this.f50237d = list;
            this.f50238e = configuration;
        }
    }

    public static LinkedHashSet<ContactDetail> c(Context context) {
        kotlin.g.b.k.c(context, "context");
        b bVar = b.f50245a;
        LinkedHashSet<ContactDetail> a2 = b.a();
        Collection collection = a2;
        if (!(collection == null || collection.isEmpty())) {
            return a2;
        }
        LinkedHashSet<ContactDetail> linkedHashSet = new LinkedHashSet<>();
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(context, "isPhoneSyncEnableV2", true)) {
            linkedHashSet = a(context, e.b.PHONEBOOK.getType());
        }
        if (linkedHashSet.isEmpty() && (Build.VERSION.SDK_INT < 23 || (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a(context, "android.permission.READ_CONTACTS") == 0))) {
            linkedHashSet = a(context, true);
        }
        b bVar2 = b.f50245a;
        b.a(linkedHashSet);
        return linkedHashSet;
    }

    public static void a(Context context, int i2, x.b bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(bVar, "listner");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(f50223f)), (kotlin.d.f) null, (CoroutineStart) null, new l(context, i2, bVar, (kotlin.d.d) null), 3, (Object) null);
    }

    public static void a(Context context, x.c cVar, int i2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cVar, "healthListner");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(f50223f)), (kotlin.d.f) null, (CoroutineStart) null, new i(i2, context, cVar, (kotlin.d.d) null), 3, (Object) null);
    }

    @kotlin.d.b.a.f(b = "ContactDBOperation.kt", c = {231, 253}, d = "invokeSuspend", e = "net/one97/paytm/contacts/utils/ContactDBOperation$getCompleteContactList$1")
    static final class h extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ Activity $context;
        final /* synthetic */ int $launchFrom;
        final /* synthetic */ x.d $listener;
        Object L$0;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(int i2, Activity activity, x.d dVar, kotlin.d.d dVar2) {
            super(2, dVar2);
            this.$launchFrom = i2;
            this.$context = activity;
            this.$listener = dVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            h hVar = new h(this.$launchFrom, this.$context, this.$listener, dVar);
            hVar.p$ = (CoroutineScope) obj;
            return hVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((h) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                final x.e eVar = new x.e();
                eVar.element = new ArrayList();
                if (this.$launchFrom == e.C0905e.PAY.getType()) {
                    Collection b2 = net.one97.paytm.wallet.p2p.b.b(this.$context);
                    if (!b2.isEmpty()) {
                        GroupBean groupBean = new GroupBean();
                        groupBean.setTitle(this.$context.getString(R.string.p2p_mt_recent_saved_ac_new));
                        e eVar2 = e.f50261a;
                        groupBean.setGroupId(e.c());
                        ((ArrayList) eVar.element).add(groupBean);
                        ((ArrayList) eVar.element).addAll(b2);
                    }
                } else if (this.$launchFrom == e.C0905e.MONEY_TRANSFER_VIEW_ALL.getType() || this.$launchFrom == e.C0905e.MONEY_TRANSFER.getType()) {
                    a aVar2 = a.f50219b;
                    eVar.element = a.d(this.$context);
                }
                a aVar3 = a.f50219b;
                ((ArrayList) eVar.element).addAll(a.b((Context) this.$context, this.$launchFrom));
                this.L$0 = eVar;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ h this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                        kotlin.g.b.k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        @kotlin.d.b.a.f(b = "ContactDBOperation.kt", c = {947}, d = "invokeSuspend", e = "net/one97/paytm/contacts/utils/ContactDBOperation$getContactHealth$1")
                        static final class i extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                            final /* synthetic */ int $contactType;
                            final /* synthetic */ Context $context;
                            final /* synthetic */ x.c $healthListner;
                            int label;
                            private CoroutineScope p$;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            i(int i2, Context context, x.c cVar, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.$contactType = i2;
                                this.$context = context;
                                this.$healthListner = cVar;
                            }

                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                kotlin.g.b.k.c(dVar, "completion");
                                i iVar = new i(this.$contactType, this.$context, this.$healthListner, dVar);
                                iVar.p$ = (CoroutineScope) obj;
                                return iVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((i) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else if (!(obj instanceof p.b)) {
                                    Contacts contacts = new Contacts();
                                    Contacts contacts2 = new Contacts();
                                    final x.e eVar = new x.e();
                                    eVar.element = new ArrayList();
                                    if (this.$contactType == e.b.PHONEBOOK.getType()) {
                                        int a2 = ContactDatabase.f50139a.a(this.$context).f().a((List<Integer>) kotlin.a.k.d(Integer.valueOf(e.b.PHONEBOOK.getType())));
                                        net.one97.paytm.contacts.b.m b2 = ContactDatabase.f50139a.a(this.$context).b();
                                        e eVar2 = e.f50261a;
                                        int a3 = b2.a(e.l());
                                        net.one97.paytm.contacts.b.m b3 = ContactDatabase.f50139a.a(this.$context).b();
                                        e eVar3 = e.f50261a;
                                        int a4 = b3.a(e.n());
                                        net.one97.paytm.contacts.b.m b4 = ContactDatabase.f50139a.a(this.$context).b();
                                        e eVar4 = e.f50261a;
                                        int a5 = b4.a(e.m());
                                        contacts.setContactType(e.b.PHONEBOOK.name());
                                        contacts.setCount(a2);
                                        PaymentInstrumentsReqt paymentInstrumentsReqt = new PaymentInstrumentsReqt();
                                        paymentInstrumentsReqt.setCount(a4 + a3 + a5);
                                        paymentInstrumentsReqt.setLastTimestamp(kotlin.d.b.a.b.a(ContactDatabase.f50139a.a(this.$context).e().a(e.b.PHONEBOOK.getType())));
                                        a aVar2 = a.f50219b;
                                        Long lastTimestamp = paymentInstrumentsReqt.getLastTimestamp();
                                        kotlin.g.b.k.a((Object) lastTimestamp, "payInstrument.lastTimestamp");
                                        paymentInstrumentsReqt.setDetails(a.a(a3, a5, a4, lastTimestamp.longValue()));
                                        contacts.setPaymentInstruments(paymentInstrumentsReqt);
                                        ((ArrayList) eVar.element).add(contacts);
                                    } else {
                                        int a6 = ContactDatabase.f50139a.a(this.$context).f().a((List<Integer>) kotlin.a.k.d(Integer.valueOf(e.b.TRANSFER_BENEFICIARY.getType())));
                                        net.one97.paytm.contacts.b.c g2 = ContactDatabase.f50139a.a(this.$context).g();
                                        e eVar5 = e.f50261a;
                                        int a7 = g2.a(e.l());
                                        net.one97.paytm.contacts.b.c g3 = ContactDatabase.f50139a.a(this.$context).g();
                                        e eVar6 = e.f50261a;
                                        int a8 = g3.a(e.n());
                                        net.one97.paytm.contacts.b.c g4 = ContactDatabase.f50139a.a(this.$context).g();
                                        e eVar7 = e.f50261a;
                                        int a9 = g4.a(e.m());
                                        contacts2.setContactType(e.b.TRANSFER_BENEFICIARY.name());
                                        contacts2.setCount(a6);
                                        PaymentInstrumentsReqt paymentInstrumentsReqt2 = new PaymentInstrumentsReqt();
                                        paymentInstrumentsReqt2.setCount(a7 + a8 + a9);
                                        paymentInstrumentsReqt2.setLastTimestamp(kotlin.d.b.a.b.a(ContactDatabase.f50139a.a(this.$context).e().a(e.b.TRANSFER_BENEFICIARY.getType())));
                                        a aVar3 = a.f50219b;
                                        Long lastTimestamp2 = paymentInstrumentsReqt2.getLastTimestamp();
                                        kotlin.g.b.k.a((Object) lastTimestamp2, "benInstrument.lastTimestamp");
                                        paymentInstrumentsReqt2.setDetails(a.a(a7, a9, a8, lastTimestamp2.longValue()));
                                        contacts2.setPaymentInstruments(paymentInstrumentsReqt2);
                                        ((ArrayList) eVar.element).add(contacts2);
                                    }
                                    Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                        int label;
                                        private CoroutineScope p$;
                                        final /* synthetic */ i this$0;

                                        {
                                            this.this$0 = r1;
                                        }

                                        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                            kotlin.g.b.k.c(dVar, "completion");
                                            AnonymousClass1 r0 = 

                                            @kotlin.d.b.a.f(b = "ContactDBOperation.kt", c = {558}, d = "invokeSuspend", e = "net/one97/paytm/contacts/utils/ContactDBOperation$insertServerDataIntoDBN$1")
                                            static final class j extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                                final /* synthetic */ x.c $contactType;
                                                final /* synthetic */ x.e $contacts;
                                                final /* synthetic */ Context $context;
                                                final /* synthetic */ x.e $fallBackFlag;
                                                final /* synthetic */ e.f $listerer;
                                                final /* synthetic */ x.d $timestamp;
                                                int label;
                                                private CoroutineScope p$;

                                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                                j(x.e eVar, x.c cVar, Context context, x.d dVar, x.e eVar2, e.f fVar, kotlin.d.d dVar2) {
                                                    super(2, dVar2);
                                                    this.$contacts = eVar;
                                                    this.$contactType = cVar;
                                                    this.$context = context;
                                                    this.$timestamp = dVar;
                                                    this.$fallBackFlag = eVar2;
                                                    this.$listerer = fVar;
                                                }

                                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                    kotlin.g.b.k.c(dVar, "completion");
                                                    j jVar = new j(this.$contacts, this.$contactType, this.$context, this.$timestamp, this.$fallBackFlag, this.$listerer, dVar);
                                                    jVar.p$ = (CoroutineScope) obj;
                                                    return jVar;
                                                }

                                                public final Object invoke(Object obj, Object obj2) {
                                                    return ((j) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                                                }

                                                public final Object invokeSuspend(Object obj) {
                                                    Object obj2 = obj;
                                                    kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                                    if (this.label != 0) {
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    } else if (!(obj2 instanceof p.b)) {
                                                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                                        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                                                        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                                                        Iterator it2 = ((LinkedHashSet) this.$contacts.element).iterator();
                                                        while (it2.hasNext()) {
                                                            ContactsResponse contactsResponse = (ContactsResponse) it2.next();
                                                            String name = e.b.PHONEBOOK.name();
                                                            kotlin.g.b.k.a((Object) contactsResponse, "contact");
                                                            if (kotlin.m.p.a(name, contactsResponse.getContactType(), true)) {
                                                                this.$contactType.element = e.b.PHONEBOOK.getType();
                                                                a aVar2 = a.f50219b;
                                                                Context context = this.$context;
                                                                String contactId = contactsResponse.getContactId();
                                                                kotlin.g.b.k.a((Object) contactId, "contact.contactId");
                                                                ContactDetail a2 = a.a(context, contactId);
                                                                if (a2 != null && !TextUtils.isEmpty(a2.getContactId())) {
                                                                    net.one97.paytm.contacts.b.i f2 = ContactDatabase.f50139a.a(this.$context).f();
                                                                    String contactId2 = a2.getContactId();
                                                                    if (contactId2 == null) {
                                                                        kotlin.g.b.k.a();
                                                                    }
                                                                    PayeeInfoDetails a3 = f2.a(contactId2, e.b.PHONEBOOK.getType());
                                                                    if (a3 != null) {
                                                                        if (kotlin.g.b.k.a((Object) "INACTIVE", (Object) contactsResponse.getStatus())) {
                                                                            net.one97.paytm.contacts.b.a c2 = ContactDatabase.f50139a.a(this.$context).c();
                                                                            String contactId3 = contactsResponse.getContactId();
                                                                            kotlin.g.b.k.a((Object) contactId3, "contact.contactId");
                                                                            c2.e(contactId3);
                                                                        } else {
                                                                            String payeeInfoId = a3.getPayeeInfoId();
                                                                            Boolean bool = Boolean.FALSE;
                                                                            PayeeInfoDetails payeeInfoDetails = new PayeeInfoDetails(0, payeeInfoId, bool, bool, Integer.valueOf(e.b.PHONEBOOK.getType()), a3.getNewContactVisiblity(), a3.getVersion(), 1, (kotlin.g.b.g) null);
                                                                            a aVar3 = a.f50219b;
                                                                            HashSet<PaymentInstrument> paymentInstruments = contactsResponse.getPaymentInstruments();
                                                                            kotlin.g.b.k.a((Object) paymentInstruments, "contact.paymentInstruments");
                                                                            o<HashSet<PayeeMetaInfo>, HashSet<PaymentInstrumentDetails>> a4 = a.a(paymentInstruments, contactsResponse);
                                                                            ArrayList arrayList = new ArrayList();
                                                                            arrayList.add(contactsResponse.getContactId());
                                                                            PayeeInfoDetails payeeInfoDetails2 = payeeInfoDetails;
                                                                            ContactDatabase.f50139a.a(this.$context).c().a(new f(payeeInfoDetails2, a4.getFirst(), a4.getSecond(), arrayList, new Configuration(0, this.$timestamp.element, Integer.valueOf(e.b.PHONEBOOK.getType()), (Boolean) this.$fallBackFlag.element, 1, (kotlin.g.b.g) null)));
                                                                        }
                                                                    }
                                                                }
                                                            } else if (kotlin.m.p.a(e.b.TRANSFER_BENEFICIARY.name(), contactsResponse.getContactType(), true)) {
                                                                this.$contactType.element = e.b.TRANSFER_BENEFICIARY.getType();
                                                                net.one97.paytm.contacts.b.i f3 = ContactDatabase.f50139a.a(this.$context).f();
                                                                int type = e.b.TRANSFER_BENEFICIARY.getType();
                                                                String contactId4 = contactsResponse.getContactId();
                                                                kotlin.g.b.k.a((Object) contactId4, "contact.contactId");
                                                                if (f3.a(type, contactId4) == 0) {
                                                                    String contactId5 = contactsResponse.getContactId();
                                                                    kotlin.g.b.k.a((Object) contactId5, "contact.contactId");
                                                                    Boolean bool2 = Boolean.FALSE;
                                                                    PayeeInfoDetails payeeInfoDetails3 = new PayeeInfoDetails(0, contactId5, bool2, bool2, Integer.valueOf(this.$contactType.element), (String) null, H5BridgeContext.INVALID_ID, 1, (kotlin.g.b.g) null);
                                                                    a aVar4 = a.f50219b;
                                                                    linkedHashSet4.add(new e(payeeInfoDetails3, a.a(contactsResponse), e.b.TRANSFER_BENEFICIARY.getType()));
                                                                } else {
                                                                    Collection paymentInstruments2 = contactsResponse.getPaymentInstruments();
                                                                    if (!(paymentInstruments2 == null || paymentInstruments2.isEmpty())) {
                                                                        HashSet<PaymentInstrument> paymentInstruments3 = contactsResponse.getPaymentInstruments();
                                                                        kotlin.g.b.k.a((Object) paymentInstruments3, "contact.paymentInstruments");
                                                                        Object a5 = kotlin.a.k.a(paymentInstruments3, 0);
                                                                        kotlin.g.b.k.a(a5, "contact.paymentInstruments.elementAt(0)");
                                                                        if (kotlin.m.p.a("INACTIVE", ((PaymentInstrument) a5).getStatus(), true)) {
                                                                            String contactId6 = contactsResponse.getContactId();
                                                                            kotlin.g.b.k.a((Object) contactId6, "contact.contactId");
                                                                            linkedHashSet2.add(new c(contactId6, e.b.TRANSFER_BENEFICIARY.getType()));
                                                                        }
                                                                    }
                                                                    String contactId7 = contactsResponse.getContactId();
                                                                    kotlin.g.b.k.a((Object) contactId7, "contact.contactId");
                                                                    Boolean bool3 = Boolean.FALSE;
                                                                    PayeeInfoDetails payeeInfoDetails4 = new PayeeInfoDetails(0, contactId7, bool3, bool3, Integer.valueOf(e.b.TRANSFER_BENEFICIARY.getType()), (String) null, H5BridgeContext.INVALID_ID, 1, (kotlin.g.b.g) null);
                                                                    a aVar5 = a.f50219b;
                                                                    LinkedHashSet<BeneficiaryMetaDetails> a6 = a.a(contactsResponse);
                                                                    String contactId8 = contactsResponse.getContactId();
                                                                    kotlin.g.b.k.a((Object) contactId8, "contact.contactId");
                                                                    linkedHashSet3.add(new g(payeeInfoDetails4, a6, contactId8, e.b.TRANSFER_BENEFICIARY.getType()));
                                                                }
                                                            }
                                                        }
                                                        if (!linkedHashSet4.isEmpty()) {
                                                            ContactDatabase.f50139a.a(this.$context).c().a((LinkedHashSet<e>) linkedHashSet4, new Configuration(0, this.$timestamp.element, Integer.valueOf(this.$contactType.element), (Boolean) this.$fallBackFlag.element, 1, (kotlin.g.b.g) null));
                                                        }
                                                        if (!linkedHashSet3.isEmpty()) {
                                                            ContactDatabase.f50139a.a(this.$context).c().b((LinkedHashSet<g>) linkedHashSet3, new Configuration(0, this.$timestamp.element, Integer.valueOf(this.$contactType.element), (Boolean) this.$fallBackFlag.element, 1, (kotlin.g.b.g) null));
                                                        }
                                                        if (!linkedHashSet2.isEmpty()) {
                                                            ContactDatabase.f50139a.a(this.$context).c().a((LinkedHashSet<c>) linkedHashSet2);
                                                        }
                                                        Iterator it3 = linkedHashSet.iterator();
                                                        while (it3.hasNext()) {
                                                            it3.next();
                                                            ContactDatabase.f50139a.a(this.$context).d().a((List<NonExistedContacts>) new ArrayList(linkedHashSet));
                                                        }
                                                        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                                            int label;
                                                            private CoroutineScope p$;
                                                            final /* synthetic */ j this$0;

                                                            {
                                                                this.this$0 = r1;
                                                            }

                                                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                                kotlin.g.b.k.c(dVar, "completion");
                                                                AnonymousClass1 r0 = 

                                                                @kotlin.d.b.a.f(b = "ContactDBOperation.kt", c = {936}, d = "invokeSuspend", e = "net/one97/paytm/contacts/utils/ContactDBOperation$onConfigurationFetch$1")
                                                                static final class l extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                                                    final /* synthetic */ int $contactType;
                                                                    final /* synthetic */ Context $context;
                                                                    final /* synthetic */ x.b $listner;
                                                                    int label;
                                                                    private CoroutineScope p$;

                                                                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                                                    l(Context context, int i2, x.b bVar, kotlin.d.d dVar) {
                                                                        super(2, dVar);
                                                                        this.$context = context;
                                                                        this.$contactType = i2;
                                                                        this.$listner = bVar;
                                                                    }

                                                                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                                        kotlin.g.b.k.c(dVar, "completion");
                                                                        l lVar = new l(this.$context, this.$contactType, this.$listner, dVar);
                                                                        lVar.p$ = (CoroutineScope) obj;
                                                                        return lVar;
                                                                    }

                                                                    public final Object invoke(Object obj, Object obj2) {
                                                                        return ((l) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                                                                    }

                                                                    public final Object invokeSuspend(Object obj) {
                                                                        kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                                                        if (this.label != 0) {
                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                        } else if (!(obj instanceof p.b)) {
                                                                            final x.d dVar = new x.d();
                                                                            dVar.element = ContactDatabase.f50139a.a(this.$context).e().a(this.$contactType);
                                                                            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                                                                int label;
                                                                                private CoroutineScope p$;
                                                                                final /* synthetic */ l this$0;

                                                                                {
                                                                                    this.this$0 = r1;
                                                                                }

                                                                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                                                    kotlin.g.b.k.c(dVar, "completion");
                                                                                    AnonymousClass1 r0 = 

                                                                                    public static ArrayList<IJRDataModel> d(Context context) {
                                                                                        kotlin.g.b.k.c(context, "context");
                                                                                        LinkedHashSet<ContactDetail> a2 = a(context, e.b.TRANSFER_BENEFICIARY.getType());
                                                                                        ArrayList<IJRDataModel> arrayList = new ArrayList<>();
                                                                                        if (a2.size() > 0) {
                                                                                            GroupBean groupBean = new GroupBean();
                                                                                            groupBean.setTitle(context.getString(R.string.p2p_mt_recent_saved_ac_new));
                                                                                            e eVar = e.f50261a;
                                                                                            groupBean.setGroupId(e.c());
                                                                                            arrayList.add(groupBean);
                                                                                            arrayList.addAll(a2);
                                                                                        }
                                                                                        return arrayList;
                                                                                    }

                                                                                    public static ArrayList<IJRDataModel> b(Context context, int i2) {
                                                                                        LinkedHashSet<ContactDetail> c2;
                                                                                        kotlin.g.b.k.c(context, "context");
                                                                                        ArrayList<IJRDataModel> arrayList = new ArrayList<>();
                                                                                        if ((Build.VERSION.SDK_INT < 23 || (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a(context, "android.permission.READ_CONTACTS") == 0)) && (c2 = c(context)) != null && c2.size() > 0) {
                                                                                            GroupBean groupBean = new GroupBean();
                                                                                            if (i2 == e.C0905e.CONTACT_ONLY_WITH_RESULT.getType()) {
                                                                                                groupBean.setTitle(context.getString(R.string.mt_contacts_only_p2p));
                                                                                            } else {
                                                                                                groupBean.setTitle(context.getString(R.string.p2p_mt_contact_header_new));
                                                                                            }
                                                                                            e eVar = e.f50261a;
                                                                                            groupBean.setGroupId(e.b());
                                                                                            arrayList.add(groupBean);
                                                                                            arrayList.addAll(c2);
                                                                                        }
                                                                                        return arrayList;
                                                                                    }

                                                                                    public static ArrayList<IJRDataModel> c(Context context, int i2) {
                                                                                        kotlin.g.b.k.c(context, "context");
                                                                                        ArrayList<IJRDataModel> arrayList = new ArrayList<>();
                                                                                        if (i2 == e.C0905e.PAY.getType()) {
                                                                                            kotlin.g.b.k.c(context, "context");
                                                                                            ArrayList arrayList2 = new ArrayList();
                                                                                            Collection b2 = net.one97.paytm.wallet.p2p.b.b(context);
                                                                                            if (!b2.isEmpty()) {
                                                                                                GroupBean groupBean = new GroupBean();
                                                                                                groupBean.setTitle(context.getString(R.string.p2p_mt_recent_saved_ac_new));
                                                                                                e eVar = e.f50261a;
                                                                                                groupBean.setGroupId(e.c());
                                                                                                arrayList2.add(groupBean);
                                                                                                arrayList2.addAll(b2);
                                                                                            }
                                                                                            Collection collection = arrayList2;
                                                                                            if (!collection.isEmpty()) {
                                                                                                arrayList.addAll(collection);
                                                                                            }
                                                                                        } else if (i2 == e.C0905e.MONEY_TRANSFER.getType() || i2 == e.C0905e.MONEY_TRANSFER_VIEW_ALL.getType()) {
                                                                                            Collection d2 = d(context);
                                                                                            if (!d2.isEmpty()) {
                                                                                                arrayList.addAll(d2);
                                                                                            }
                                                                                        }
                                                                                        Collection b3 = b(context, i2);
                                                                                        if (!b3.isEmpty()) {
                                                                                            arrayList.addAll(b3);
                                                                                        }
                                                                                        return arrayList;
                                                                                    }

                                                                                    public static final /* synthetic */ ContactDetail a(Context context, String str) {
                                                                                        String str2 = str;
                                                                                        ContentResolver contentResolver = context != null ? context.getContentResolver() : null;
                                                                                        Cursor query = contentResolver != null ? contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, f50220c, "contact_id=?", new String[]{str2}, (String) null) : null;
                                                                                        if (query == null || !query.moveToFirst()) {
                                                                                            if (query != null) {
                                                                                                query.close();
                                                                                            }
                                                                                            return null;
                                                                                        }
                                                                                        ContactDetail contactDetail = new ContactDetail((String) null, (String) null, (HashSet) null, (HashSet) null, (String) null, (String) null, (String) null, 0, (HashSet) null, (String) null, (String) null, (Boolean) null, 4095, (kotlin.g.b.g) null);
                                                                                        String string = query.getString(query.getColumnIndex("display_name"));
                                                                                        String string2 = query.getString(query.getColumnIndex("data1"));
                                                                                        String string3 = query.getString(query.getColumnIndex("version"));
                                                                                        HashSet hashSet = new HashSet();
                                                                                        hashSet.add(string2);
                                                                                        contactDetail.setContactName(string);
                                                                                        contactDetail.setContactNickName(string);
                                                                                        contactDetail.setAllPhoneNumberList(hashSet);
                                                                                        contactDetail.setContactId(str2);
                                                                                        e eVar = e.f50261a;
                                                                                        kotlin.g.b.k.a((Object) string2, "phoneNo");
                                                                                        contactDetail.setPrimaryPhoneNumber(e.a(string2));
                                                                                        contactDetail.setContactType(e.b.PHONEBOOK.getType());
                                                                                        contactDetail.setVersion(string3);
                                                                                        return contactDetail;
                                                                                    }

                                                                                    public static final /* synthetic */ ArrayList a(int i2, int i3, int i4, long j2) {
                                                                                        ArrayList arrayList = new ArrayList();
                                                                                        DetailReqt detailReqt = new DetailReqt();
                                                                                        detailReqt.setCount(i3);
                                                                                        detailReqt.setLastTimestamp(Long.valueOf(j2));
                                                                                        e eVar = e.f50261a;
                                                                                        detailReqt.setType(e.m());
                                                                                        arrayList.add(detailReqt);
                                                                                        DetailReqt detailReqt2 = new DetailReqt();
                                                                                        detailReqt2.setCount(i2);
                                                                                        detailReqt2.setLastTimestamp(Long.valueOf(j2));
                                                                                        e eVar2 = e.f50261a;
                                                                                        detailReqt2.setType(e.l());
                                                                                        arrayList.add(detailReqt2);
                                                                                        DetailReqt detailReqt3 = new DetailReqt();
                                                                                        detailReqt3.setCount(i4);
                                                                                        detailReqt3.setLastTimestamp(Long.valueOf(j2));
                                                                                        e eVar3 = e.f50261a;
                                                                                        detailReqt3.setType(e.n());
                                                                                        arrayList.add(detailReqt3);
                                                                                        return arrayList;
                                                                                    }
                                                                                }
