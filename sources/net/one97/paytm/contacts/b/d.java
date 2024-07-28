package net.one97.paytm.contacts.b;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final j f50088a;

    /* renamed from: b  reason: collision with root package name */
    private final c f50089b;

    public d(j jVar) {
        this.f50088a = jVar;
        this.f50089b = new c<BeneficiaryMetaDetails>(jVar) {
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
    }

    public final List<BeneficiaryMetaDetails> a(int i2) {
        m mVar;
        Integer valueOf;
        m a2 = m.a("Select * from beneficiary_meta_details where contact_type=?", 1);
        a2.a(1, (long) i2);
        Cursor query = this.f50088a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payeeInfoId");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("name");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("nickname");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("contact_status");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("contact_type");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("paymentInstrumentId");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("instrumentType");
            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("score");
            int columnIndexOrThrow10 = query.getColumnIndexOrThrow("instrumentStatus");
            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("contact_image_url");
            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("mobileNo");
            int columnIndexOrThrow13 = query.getColumnIndexOrThrow("custId");
            int columnIndexOrThrow14 = query.getColumnIndexOrThrow("bankName");
            mVar = a2;
            try {
                int columnIndexOrThrow15 = query.getColumnIndexOrThrow("instrument_meta_status");
                int columnIndexOrThrow16 = query.getColumnIndexOrThrow("accountNo");
                int columnIndexOrThrow17 = query.getColumnIndexOrThrow("ifsc");
                int columnIndexOrThrow18 = query.getColumnIndexOrThrow("vpa");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    long j = query.getLong(columnIndexOrThrow);
                    String string = query.getString(columnIndexOrThrow2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow6));
                    }
                    Integer num = valueOf;
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    String string7 = query.getString(columnIndexOrThrow9);
                    String string8 = query.getString(columnIndexOrThrow10);
                    String string9 = query.getString(columnIndexOrThrow11);
                    String string10 = query.getString(columnIndexOrThrow12);
                    String string11 = query.getString(columnIndexOrThrow13);
                    int i4 = i3;
                    String string12 = query.getString(i4);
                    int i5 = columnIndexOrThrow;
                    int i6 = columnIndexOrThrow15;
                    String string13 = query.getString(i6);
                    columnIndexOrThrow15 = i6;
                    int i7 = columnIndexOrThrow16;
                    String string14 = query.getString(i7);
                    columnIndexOrThrow16 = i7;
                    int i8 = columnIndexOrThrow17;
                    String string15 = query.getString(i8);
                    columnIndexOrThrow17 = i8;
                    int i9 = columnIndexOrThrow18;
                    columnIndexOrThrow18 = i9;
                    arrayList.add(new BeneficiaryMetaDetails(j, string, string2, string3, string4, num, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, query.getString(i9)));
                    columnIndexOrThrow = i5;
                    i3 = i4;
                }
                query.close();
                mVar.a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                mVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = a2;
            query.close();
            mVar.a();
            throw th;
        }
    }

    public final int a(String str) {
        m a2 = m.a("Select count(*) from beneficiary_meta_details where instrumentType=?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        Cursor query = this.f50088a.query(a2);
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
