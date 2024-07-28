package net.one97.paytm.contacts.b;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails;

public final class n implements m {

    /* renamed from: a  reason: collision with root package name */
    private final j f50113a;

    /* renamed from: b  reason: collision with root package name */
    private final c f50114b;

    /* renamed from: c  reason: collision with root package name */
    private final b f50115c;

    /* renamed from: d  reason: collision with root package name */
    private final q f50116d;

    /* renamed from: e  reason: collision with root package name */
    private final q f50117e;

    public n(j jVar) {
        this.f50113a = jVar;
        this.f50114b = new c<PaymentInstrumentDetails>(jVar) {
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
        this.f50115c = new b<PaymentInstrumentDetails>(jVar) {
            public final String createQuery() {
                return "UPDATE OR REPLACE `payment_instrument_details` SET `row_id` = ?,`paymentInstrumentId` = ?,`type` = ?,`status` = ?,`score` = ?,`payeeInfoId` = ?,`payeeMetaId` = ?,`mobileNo` = ?,`custId` = ?,`bankName` = ?,`instrument_meta_status` = ?,`accountNo` = ?,`ifsc` = ?,`vpa` = ?,`expiryTime` = ? WHERE `row_id` = ?";
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
                fVar.a(16, paymentInstrumentDetails.getId());
            }
        };
        this.f50116d = new q(jVar) {
            public final String createQuery() {
                return "Delete from payment_instrument_details";
            }
        };
        this.f50117e = new q(jVar) {
            public final String createQuery() {
                return "Delete from payment_instrument_details where paymentInstrumentId=?";
            }
        };
    }

    public final int a(String str) {
        m a2 = m.a("Select * from payment_instrument_details where type=?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        Cursor query = this.f50113a.query(a2);
        try {
            int i2 = 0;
            if (query.moveToFirst()) {
                i2 = query.getInt(0);
            }
            return i2;
        } finally {
            query.close();
            a2.a();
        }
    }
}
