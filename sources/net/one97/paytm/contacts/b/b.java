package net.one97.paytm.contacts.b;

import androidx.room.c;
import androidx.room.j;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails;
import net.one97.paytm.contacts.entities.db_entities.Configuration;
import net.one97.paytm.contacts.entities.db_entities.PayeeInfo;
import net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails;
import net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo;
import net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails;
import net.one97.paytm.contacts.utils.a;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f50058a;

    /* renamed from: b  reason: collision with root package name */
    private final c f50059b;

    /* renamed from: c  reason: collision with root package name */
    private final c f50060c;

    /* renamed from: d  reason: collision with root package name */
    private final c f50061d;

    /* renamed from: e  reason: collision with root package name */
    private final c f50062e;

    /* renamed from: f  reason: collision with root package name */
    private final c f50063f;

    /* renamed from: g  reason: collision with root package name */
    private final c f50064g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.room.b f50065h;

    /* renamed from: i  reason: collision with root package name */
    private final q f50066i;
    private final q j;
    private final q k;
    private final q l;
    private final q m;
    private final q n;
    private final q o;
    private final q p;
    private final q q;
    private final q r;
    private final q s;
    private final q t;
    private final q u;
    private final q v;

    public b(j jVar) {
        this.f50058a = jVar;
        this.f50059b = new c<PayeeInfo>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `payee_info`(`id`,`payeeInfoId`,`name`,`nickName`,`isDirty`,`isDeleted`,`type`,`version`,`imageUrl`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                PayeeInfo payeeInfo = (PayeeInfo) obj;
                fVar.a(1, payeeInfo.getId());
                if (payeeInfo.getPayeeInfoId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, payeeInfo.getPayeeInfoId());
                }
                if (payeeInfo.getName() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, payeeInfo.getName());
                }
                if (payeeInfo.getNickName() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, payeeInfo.getNickName());
                }
                Integer num = null;
                Integer valueOf = payeeInfo.isDirty() == null ? null : Integer.valueOf(payeeInfo.isDirty().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, (long) valueOf.intValue());
                }
                if (payeeInfo.isDeleted() != null) {
                    num = Integer.valueOf(payeeInfo.isDeleted().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, (long) num.intValue());
                }
                if (payeeInfo.getType() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, (long) payeeInfo.getType().intValue());
                }
                if (payeeInfo.getVersion() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, payeeInfo.getVersion());
                }
                if (payeeInfo.getImageUrl() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, payeeInfo.getImageUrl());
                }
            }
        };
        this.f50060c = new c<PayeeMetaInfo>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `payee_meta_info`(`row_id`,`payeeInfoId`,`payeeMetaId`,`phoneNumber`,`name`,`nickName`,`imageUrl`,`type`,`status`,`isPrimary`,`isDeleted`,`newContactVisibility`,`newVisibilityExpiryTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                PayeeMetaInfo payeeMetaInfo = (PayeeMetaInfo) obj;
                fVar.a(1, payeeMetaInfo.getId());
                if (payeeMetaInfo.getPayeeInfoId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, payeeMetaInfo.getPayeeInfoId());
                }
                if (payeeMetaInfo.getPayeeMetaId() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, payeeMetaInfo.getPayeeMetaId());
                }
                if (payeeMetaInfo.getPhoneNumber() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, payeeMetaInfo.getPhoneNumber());
                }
                if (payeeMetaInfo.getName() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, payeeMetaInfo.getName());
                }
                if (payeeMetaInfo.getNickName() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, payeeMetaInfo.getNickName());
                }
                if (payeeMetaInfo.getImageUrl() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, payeeMetaInfo.getImageUrl());
                }
                fVar.a(8, (long) payeeMetaInfo.getType());
                if (payeeMetaInfo.getStatus() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, payeeMetaInfo.getStatus());
                }
                fVar.a(10, payeeMetaInfo.isPrimary() ? 1 : 0);
                Integer valueOf = payeeMetaInfo.isDeleted() == null ? null : Integer.valueOf(payeeMetaInfo.isDeleted().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, (long) valueOf.intValue());
                }
                if (payeeMetaInfo.getNewContactVisiblity() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, payeeMetaInfo.getNewContactVisiblity());
                }
                if (payeeMetaInfo.getNewExpiryTime() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, payeeMetaInfo.getNewExpiryTime());
                }
            }
        };
        this.f50061d = new c<PaymentInstrumentDetails>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `payment_instrument_details`(`row_id`,`paymentInstrumentId`,`type`,`status`,`score`,`payeeInfoId`,`payeeMetaId`,`mobileNo`,`custId`,`bankName`,`instrument_meta_status`,`accountNo`,`ifsc`,`vpa`,`expiryTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                PaymentInstrumentDetails paymentInstrumentDetails = (PaymentInstrumentDetails) obj;
                fVar.a(1, paymentInstrumentDetails.getId());
                if (paymentInstrumentDetails.getPaymentInstrumentId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, paymentInstrumentDetails.getPaymentInstrumentId());
                }
                if (paymentInstrumentDetails.getType() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, paymentInstrumentDetails.getType());
                }
                if (paymentInstrumentDetails.getStatus() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, paymentInstrumentDetails.getStatus());
                }
                if (paymentInstrumentDetails.getScore() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, paymentInstrumentDetails.getScore());
                }
                if (paymentInstrumentDetails.getPayeeInfoId() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, paymentInstrumentDetails.getPayeeInfoId());
                }
                if (paymentInstrumentDetails.getPayeeMetaId() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, paymentInstrumentDetails.getPayeeMetaId());
                }
                if (paymentInstrumentDetails.getMobileNo() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, paymentInstrumentDetails.getMobileNo());
                }
                if (paymentInstrumentDetails.getCustId() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, paymentInstrumentDetails.getCustId());
                }
                if (paymentInstrumentDetails.getBankName() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, paymentInstrumentDetails.getBankName());
                }
                if (paymentInstrumentDetails.getInstrument_meta_status() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, paymentInstrumentDetails.getInstrument_meta_status());
                }
                if (paymentInstrumentDetails.getAccountNo() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, paymentInstrumentDetails.getAccountNo());
                }
                if (paymentInstrumentDetails.getIfsc() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, paymentInstrumentDetails.getIfsc());
                }
                if (paymentInstrumentDetails.getVpa() == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, paymentInstrumentDetails.getVpa());
                }
                if (paymentInstrumentDetails.getExpiryTime() == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, paymentInstrumentDetails.getExpiryTime());
                }
            }
        };
        this.f50062e = new c<Configuration>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `configuration_table`(`id`,`timestamp`,`type`,`fallbackEnabled`) VALUES (nullif(?, 0),?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                Configuration configuration = (Configuration) obj;
                fVar.a(1, configuration.getId());
                fVar.a(2, configuration.getTimestamp());
                if (configuration.getType() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, (long) configuration.getType().intValue());
                }
                Integer valueOf = configuration.getFallbackEnabled() == null ? null : Integer.valueOf(configuration.getFallbackEnabled().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, (long) valueOf.intValue());
                }
            }
        };
        this.f50063f = new c<PayeeInfoDetails>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `payee_info_table`(`id`,`payeeInfoId`,`isDirty`,`isDeleted`,`type`,`newContactVisibility`,`version`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                PayeeInfoDetails payeeInfoDetails = (PayeeInfoDetails) obj;
                fVar.a(1, payeeInfoDetails.getId());
                if (payeeInfoDetails.getPayeeInfoId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, payeeInfoDetails.getPayeeInfoId());
                }
                Integer num = null;
                Integer valueOf = payeeInfoDetails.isDirty() == null ? null : Integer.valueOf(payeeInfoDetails.isDirty().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, (long) valueOf.intValue());
                }
                if (payeeInfoDetails.isDeleted() != null) {
                    num = Integer.valueOf(payeeInfoDetails.isDeleted().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, (long) num.intValue());
                }
                if (payeeInfoDetails.getType() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, (long) payeeInfoDetails.getType().intValue());
                }
                if (payeeInfoDetails.getNewContactVisiblity() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, payeeInfoDetails.getNewContactVisiblity());
                }
                if (payeeInfoDetails.getVersion() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, payeeInfoDetails.getVersion());
                }
            }
        };
        this.f50064g = new c<BeneficiaryMetaDetails>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `beneficiary_meta_details`(`id`,`payeeInfoId`,`name`,`nickname`,`contact_status`,`contact_type`,`paymentInstrumentId`,`instrumentType`,`score`,`instrumentStatus`,`contact_image_url`,`mobileNo`,`custId`,`bankName`,`instrument_meta_status`,`accountNo`,`ifsc`,`vpa`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                BeneficiaryMetaDetails beneficiaryMetaDetails = (BeneficiaryMetaDetails) obj;
                fVar.a(1, beneficiaryMetaDetails.getId());
                if (beneficiaryMetaDetails.getPayeeInfoId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, beneficiaryMetaDetails.getPayeeInfoId());
                }
                if (beneficiaryMetaDetails.getName() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, beneficiaryMetaDetails.getName());
                }
                if (beneficiaryMetaDetails.getNickname() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, beneficiaryMetaDetails.getNickname());
                }
                if (beneficiaryMetaDetails.getContactStatus() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, beneficiaryMetaDetails.getContactStatus());
                }
                if (beneficiaryMetaDetails.getContact_type() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, (long) beneficiaryMetaDetails.getContact_type().intValue());
                }
                if (beneficiaryMetaDetails.getPaymentInstrumentId() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, beneficiaryMetaDetails.getPaymentInstrumentId());
                }
                if (beneficiaryMetaDetails.getInstrumentType() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, beneficiaryMetaDetails.getInstrumentType());
                }
                if (beneficiaryMetaDetails.getScore() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, beneficiaryMetaDetails.getScore());
                }
                if (beneficiaryMetaDetails.getInstrumentStatus() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, beneficiaryMetaDetails.getInstrumentStatus());
                }
                if (beneficiaryMetaDetails.getImageUrl() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, beneficiaryMetaDetails.getImageUrl());
                }
                if (beneficiaryMetaDetails.getMobileNo() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, beneficiaryMetaDetails.getMobileNo());
                }
                if (beneficiaryMetaDetails.getCustId() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, beneficiaryMetaDetails.getCustId());
                }
                if (beneficiaryMetaDetails.getBankName() == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, beneficiaryMetaDetails.getBankName());
                }
                if (beneficiaryMetaDetails.getInstrument_meta_status() == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, beneficiaryMetaDetails.getInstrument_meta_status());
                }
                if (beneficiaryMetaDetails.getAccountNo() == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, beneficiaryMetaDetails.getAccountNo());
                }
                if (beneficiaryMetaDetails.getIfsc() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, beneficiaryMetaDetails.getIfsc());
                }
                if (beneficiaryMetaDetails.getVpa() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, beneficiaryMetaDetails.getVpa());
                }
            }
        };
        this.f50065h = new androidx.room.b<PayeeInfo>(jVar) {
            public final String createQuery() {
                return "DELETE FROM `payee_info` WHERE `id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                fVar.a(1, ((PayeeInfo) obj).getId());
            }
        };
        this.f50066i = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_meta_info where payeeInfoId =?";
            }
        };
        this.j = new q(jVar) {
            public final String createQuery() {
                return "Delete from payment_instrument_details where payeeInfoId  =?";
            }
        };
        this.k = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_meta_info where payeeInfoId=?";
            }
        };
        this.l = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_info where payeeInfoId=?";
            }
        };
        this.m = new q(jVar) {
            public final String createQuery() {
                return "Delete from beneficiary_meta_details where payeeInfoId=? and contact_type = ?";
            }
        };
        this.n = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_info_table where payeeInfoId=? and type=?";
            }
        };
        this.o = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_info_table where payeeInfoId=?";
            }
        };
        this.p = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_info_table";
            }
        };
        this.q = new q(jVar) {
            public final String createQuery() {
                return "Delete from beneficiary_meta_details";
            }
        };
        this.r = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_meta_info";
            }
        };
        this.s = new q(jVar) {
            public final String createQuery() {
                return "Delete from configuration_table";
            }
        };
        this.t = new q(jVar) {
            public final String createQuery() {
                return "Delete from payment_instrument_details";
            }
        };
        this.u = new q(jVar) {
            public final String createQuery() {
                return "update payee_meta_info set  imageUrl=?,  newVisibilityExpiryTime =?  where payeeMetaId=?";
            }
        };
        this.v = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_info_table where type='2'";
            }
        };
    }

    public final void a(List<PayeeMetaInfo> list) {
        this.f50058a.beginTransaction();
        try {
            this.f50060c.insert(list);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void b(List<PaymentInstrumentDetails> list) {
        this.f50058a.beginTransaction();
        try {
            this.f50061d.insert(list);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(Configuration configuration) {
        this.f50058a.beginTransaction();
        try {
            this.f50062e.insert(configuration);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(PayeeInfoDetails payeeInfoDetails) {
        this.f50058a.beginTransaction();
        try {
            this.f50063f.insert(payeeInfoDetails);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void c(List<BeneficiaryMetaDetails> list) {
        this.f50058a.beginTransaction();
        try {
            this.f50064g.insert(list);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void b(PayeeInfoDetails payeeInfoDetails) {
        this.f50058a.beginTransaction();
        try {
            this.f50063f.insert(payeeInfoDetails);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(LinkedHashSet<a.e> linkedHashSet, Configuration configuration) {
        this.f50058a.beginTransaction();
        try {
            k.c(linkedHashSet, "dbuNewBeneficiaryData");
            k.c(configuration, CLConstants.INPUT_KEY_CONFIGURATION);
            Iterator it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                a.e eVar = (a.e) it2.next();
                a(eVar.f50231a);
                c((List<BeneficiaryMetaDetails>) new ArrayList(eVar.f50232b));
            }
            a(configuration);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void b(LinkedHashSet<a.g> linkedHashSet, Configuration configuration) {
        this.f50058a.beginTransaction();
        try {
            k.c(linkedHashSet, "dbUpdateBeneficiaryData");
            k.c(configuration, CLConstants.INPUT_KEY_CONFIGURATION);
            Iterator it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                a.g gVar = (a.g) it2.next();
                a(gVar.f50241c, gVar.f50242d);
                a(gVar.f50239a);
                c((List<BeneficiaryMetaDetails>) new ArrayList(gVar.f50240b));
            }
            a(configuration);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(a.b bVar) {
        this.f50058a.beginTransaction();
        try {
            k.c(bVar, "dbAddPhoneBook");
            a(bVar.f50224a);
            a((List<PayeeMetaInfo>) new ArrayList(bVar.f50225b));
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(LinkedHashSet<a.c> linkedHashSet) {
        this.f50058a.beginTransaction();
        try {
            k.c(linkedHashSet, "dbDeleteBeneficiary");
            Iterator it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                a.c cVar = (a.c) it2.next();
                b(cVar.f50227a, cVar.f50228b);
                a(cVar.f50227a, cVar.f50228b);
            }
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(a.c cVar) {
        this.f50058a.beginTransaction();
        try {
            k.c(cVar, "beneficiary");
            b(cVar.f50227a, cVar.f50228b);
            a(cVar.f50227a, cVar.f50228b);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(a.d dVar) {
        this.f50058a.beginTransaction();
        try {
            k.c(dVar, "data");
            d(dVar.f50229a);
            c(dVar.f50229a);
            b(dVar.f50229a);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A[Catch:{ all -> 0x007d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.contacts.utils.a.f r5) {
        /*
            r4 = this;
            androidx.room.j r0 = r4.f50058a
            r0.beginTransaction()
            java.lang.String r0 = "data"
            kotlin.g.b.k.c(r5, r0)     // Catch:{ all -> 0x007d }
            java.util.List<java.lang.String> r0 = r5.f50237d     // Catch:{ all -> 0x007d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007d }
        L_0x0010:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x007d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x007d }
            r4.b((java.lang.String) r1)     // Catch:{ all -> 0x007d }
            goto L_0x0010
        L_0x0020:
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r0 = r5.f50234a     // Catch:{ all -> 0x007d }
            r4.b((net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r0)     // Catch:{ all -> 0x007d }
            java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo> r0 = r5.f50235b     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0049
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007d }
        L_0x002d:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0049
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x007d }
            net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo r1 = (net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo) r1     // Catch:{ all -> 0x007d }
            java.lang.String r2 = r1.getNewExpiryTime()     // Catch:{ all -> 0x007d }
            java.lang.String r3 = r1.getImageUrl()     // Catch:{ all -> 0x007d }
            java.lang.String r1 = r1.getPayeeMetaId()     // Catch:{ all -> 0x007d }
            r4.a(r2, r3, r1)     // Catch:{ all -> 0x007d }
            goto L_0x002d
        L_0x0049:
            java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails> r0 = r5.f50236c     // Catch:{ all -> 0x007d }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0058
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r0 = 0
            goto L_0x0059
        L_0x0058:
            r0 = 1
        L_0x0059:
            if (r0 != 0) goto L_0x0069
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x007d }
            java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails> r1 = r5.f50236c     // Catch:{ all -> 0x007d }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x007d }
            r0.<init>(r1)     // Catch:{ all -> 0x007d }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x007d }
            r4.b((java.util.List<net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails>) r0)     // Catch:{ all -> 0x007d }
        L_0x0069:
            net.one97.paytm.contacts.entities.db_entities.Configuration r0 = r5.f50238e     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0072
            net.one97.paytm.contacts.entities.db_entities.Configuration r5 = r5.f50238e     // Catch:{ all -> 0x007d }
            r4.a((net.one97.paytm.contacts.entities.db_entities.Configuration) r5)     // Catch:{ all -> 0x007d }
        L_0x0072:
            androidx.room.j r5 = r4.f50058a     // Catch:{ all -> 0x007d }
            r5.setTransactionSuccessful()     // Catch:{ all -> 0x007d }
            androidx.room.j r5 = r4.f50058a
            r5.endTransaction()
            return
        L_0x007d:
            r5 = move-exception
            androidx.room.j r0 = r4.f50058a
            r0.endTransaction()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.b.b.a(net.one97.paytm.contacts.utils.a$f):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[Catch:{ all -> 0x007d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(net.one97.paytm.contacts.utils.a.f r3) {
        /*
            r2 = this;
            androidx.room.j r0 = r2.f50058a
            r0.beginTransaction()
            java.lang.String r0 = "data"
            kotlin.g.b.k.c(r3, r0)     // Catch:{ all -> 0x007d }
            java.util.List<java.lang.String> r0 = r3.f50237d     // Catch:{ all -> 0x007d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007d }
        L_0x0010:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x007d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x007d }
            r2.a((java.lang.String) r1)     // Catch:{ all -> 0x007d }
            goto L_0x0010
        L_0x0020:
            java.util.List<java.lang.String> r0 = r3.f50237d     // Catch:{ all -> 0x007d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007d }
        L_0x0026:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x007d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x007d }
            r2.b((java.lang.String) r1)     // Catch:{ all -> 0x007d }
            goto L_0x0026
        L_0x0036:
            net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails r0 = r3.f50234a     // Catch:{ all -> 0x007d }
            r2.b((net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails) r0)     // Catch:{ all -> 0x007d }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x007d }
            java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo> r1 = r3.f50235b     // Catch:{ all -> 0x007d }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x007d }
            r0.<init>(r1)     // Catch:{ all -> 0x007d }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x007d }
            r2.a((java.util.List<net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo>) r0)     // Catch:{ all -> 0x007d }
            java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails> r0 = r3.f50236c     // Catch:{ all -> 0x007d }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0058
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r0 = 0
            goto L_0x0059
        L_0x0058:
            r0 = 1
        L_0x0059:
            if (r0 != 0) goto L_0x0069
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x007d }
            java.util.HashSet<net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails> r1 = r3.f50236c     // Catch:{ all -> 0x007d }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x007d }
            r0.<init>(r1)     // Catch:{ all -> 0x007d }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x007d }
            r2.b((java.util.List<net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails>) r0)     // Catch:{ all -> 0x007d }
        L_0x0069:
            net.one97.paytm.contacts.entities.db_entities.Configuration r0 = r3.f50238e     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0072
            net.one97.paytm.contacts.entities.db_entities.Configuration r3 = r3.f50238e     // Catch:{ all -> 0x007d }
            r2.a((net.one97.paytm.contacts.entities.db_entities.Configuration) r3)     // Catch:{ all -> 0x007d }
        L_0x0072:
            androidx.room.j r3 = r2.f50058a     // Catch:{ all -> 0x007d }
            r3.setTransactionSuccessful()     // Catch:{ all -> 0x007d }
            androidx.room.j r3 = r2.f50058a
            r3.endTransaction()
            return
        L_0x007d:
            r3 = move-exception
            androidx.room.j r0 = r2.f50058a
            r0.endTransaction()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.b.b.b(net.one97.paytm.contacts.utils.a$f):void");
    }

    public final void e(String str) {
        this.f50058a.beginTransaction();
        try {
            k.c(str, "contactId");
            d(str);
            c(str);
            b(str);
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void g() {
        this.f50058a.beginTransaction();
        try {
            c();
            a();
            e();
            d();
            b();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void h() {
        this.f50058a.beginTransaction();
        try {
            b();
            f();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
        }
    }

    public final void a(String str) {
        f acquire = this.f50066i.acquire();
        this.f50058a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50058a.endTransaction();
                this.f50066i.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f50058a.setTransactionSuccessful();
        this.f50058a.endTransaction();
        this.f50066i.release(acquire);
    }

    public final void b(String str) {
        f acquire = this.j.acquire();
        this.f50058a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50058a.endTransaction();
                this.j.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f50058a.setTransactionSuccessful();
        this.f50058a.endTransaction();
        this.j.release(acquire);
    }

    public final void c(String str) {
        f acquire = this.k.acquire();
        this.f50058a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50058a.endTransaction();
                this.k.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f50058a.setTransactionSuccessful();
        this.f50058a.endTransaction();
        this.k.release(acquire);
    }

    public final void a(String str, int i2) {
        f acquire = this.m.acquire();
        this.f50058a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50058a.endTransaction();
                this.m.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a(2, (long) i2);
        acquire.a();
        this.f50058a.setTransactionSuccessful();
        this.f50058a.endTransaction();
        this.m.release(acquire);
    }

    public final void b(String str, int i2) {
        f acquire = this.n.acquire();
        this.f50058a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50058a.endTransaction();
                this.n.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a(2, (long) i2);
        acquire.a();
        this.f50058a.setTransactionSuccessful();
        this.f50058a.endTransaction();
        this.n.release(acquire);
    }

    public final void d(String str) {
        f acquire = this.o.acquire();
        this.f50058a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50058a.endTransaction();
                this.o.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f50058a.setTransactionSuccessful();
        this.f50058a.endTransaction();
        this.o.release(acquire);
    }

    public final void a() {
        f acquire = this.p.acquire();
        this.f50058a.beginTransaction();
        try {
            acquire.a();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
            this.p.release(acquire);
        }
    }

    public final void b() {
        f acquire = this.q.acquire();
        this.f50058a.beginTransaction();
        try {
            acquire.a();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
            this.q.release(acquire);
        }
    }

    public final void c() {
        f acquire = this.r.acquire();
        this.f50058a.beginTransaction();
        try {
            acquire.a();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
            this.r.release(acquire);
        }
    }

    public final void d() {
        f acquire = this.s.acquire();
        this.f50058a.beginTransaction();
        try {
            acquire.a();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
            this.s.release(acquire);
        }
    }

    public final void e() {
        f acquire = this.t.acquire();
        this.f50058a.beginTransaction();
        try {
            acquire.a();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
            this.t.release(acquire);
        }
    }

    public final void a(String str, String str2, String str3) {
        f acquire = this.u.acquire();
        this.f50058a.beginTransaction();
        if (str2 == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50058a.endTransaction();
                this.u.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str2);
        }
        if (str == null) {
            acquire.a(2);
        } else {
            acquire.a(2, str);
        }
        if (str3 == null) {
            acquire.a(3);
        } else {
            acquire.a(3, str3);
        }
        acquire.a();
        this.f50058a.setTransactionSuccessful();
        this.f50058a.endTransaction();
        this.u.release(acquire);
    }

    public final void f() {
        f acquire = this.v.acquire();
        this.f50058a.beginTransaction();
        try {
            acquire.a();
            this.f50058a.setTransactionSuccessful();
        } finally {
            this.f50058a.endTransaction();
            this.v.release(acquire);
        }
    }
}
