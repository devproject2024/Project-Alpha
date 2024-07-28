package net.one97.paytm.contacts.b;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.b.e;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo;

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final j f50104a;

    /* renamed from: b  reason: collision with root package name */
    private final c f50105b;

    /* renamed from: c  reason: collision with root package name */
    private final b f50106c;

    /* renamed from: d  reason: collision with root package name */
    private final q f50107d;

    /* renamed from: e  reason: collision with root package name */
    private final q f50108e;

    public l(j jVar) {
        this.f50104a = jVar;
        this.f50105b = new c<PayeeMetaInfo>(jVar) {
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
        this.f50106c = new b<PayeeMetaInfo>(jVar) {
            public final String createQuery() {
                return "UPDATE OR REPLACE `payee_meta_info` SET `row_id` = ?,`payeeInfoId` = ?,`payeeMetaId` = ?,`phoneNumber` = ?,`name` = ?,`nickName` = ?,`imageUrl` = ?,`type` = ?,`status` = ?,`isPrimary` = ?,`isDeleted` = ?,`newContactVisibility` = ?,`newVisibilityExpiryTime` = ? WHERE `row_id` = ?";
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
                fVar.a(14, payeeMetaInfo.getId());
            }
        };
        this.f50107d = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_meta_info";
            }
        };
        this.f50108e = new q(jVar) {
            public final String createQuery() {
                return "Delete from payee_meta_info where payeeInfoId=?";
            }
        };
    }

    public final List<PayeeMetaInfo> a(String str) {
        m mVar;
        Integer num;
        String str2 = str;
        m a2 = m.a("Select * from payee_meta_info where  payeeInfoId =?", 1);
        if (str2 == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str2);
        }
        Cursor query = this.f50104a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("row_id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payeeInfoId");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("payeeMetaId");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("phoneNumber");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("name");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("nickName");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("imageUrl");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("type");
            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("status");
            int columnIndexOrThrow10 = query.getColumnIndexOrThrow(ContactColumn.IS_PRIMARY);
            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("isDeleted");
            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("newContactVisibility");
            int columnIndexOrThrow13 = query.getColumnIndexOrThrow("newVisibilityExpiryTime");
            mVar = a2;
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    long j = query.getLong(columnIndexOrThrow);
                    String string = query.getString(columnIndexOrThrow2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    int i2 = query.getInt(columnIndexOrThrow8);
                    String string7 = query.getString(columnIndexOrThrow9);
                    boolean z = false;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    Boolean bool = null;
                    if (query.isNull(columnIndexOrThrow11)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                    }
                    if (num != null) {
                        if (num.intValue() != 0) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    }
                    arrayList.add(new PayeeMetaInfo(j, string, string2, string3, string4, string5, string6, i2, string7, z2, bool, query.getString(columnIndexOrThrow12), query.getString(columnIndexOrThrow13)));
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

    public final List<PayeeMetaInfo> a() {
        m mVar;
        Integer num;
        m a2 = m.a("Select * from payee_meta_info where isDeleted=0  order by name", 0);
        Cursor query = this.f50104a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("row_id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payeeInfoId");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("payeeMetaId");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("phoneNumber");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("name");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("nickName");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("imageUrl");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("type");
            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("status");
            int columnIndexOrThrow10 = query.getColumnIndexOrThrow(ContactColumn.IS_PRIMARY);
            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("isDeleted");
            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("newContactVisibility");
            int columnIndexOrThrow13 = query.getColumnIndexOrThrow("newVisibilityExpiryTime");
            mVar = a2;
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    long j = query.getLong(columnIndexOrThrow);
                    String string = query.getString(columnIndexOrThrow2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    int i2 = query.getInt(columnIndexOrThrow8);
                    String string7 = query.getString(columnIndexOrThrow9);
                    boolean z = true;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    Boolean bool = null;
                    if (query.isNull(columnIndexOrThrow11)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                    }
                    if (num != null) {
                        if (num.intValue() == 0) {
                            z = false;
                        }
                        bool = Boolean.valueOf(z);
                    }
                    arrayList.add(new PayeeMetaInfo(j, string, string2, string3, string4, string5, string6, i2, string7, z2, bool, query.getString(columnIndexOrThrow12), query.getString(columnIndexOrThrow13)));
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

    public final void a(List<String> list) {
        StringBuilder a2 = e.a();
        a2.append("Delete from payee_meta_info where payeeInfoId in (");
        e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.f50104a.compileStatement(a2.toString());
        int i2 = 1;
        for (String next : list) {
            if (next == null) {
                compileStatement.a(i2);
            } else {
                compileStatement.a(i2, next);
            }
            i2++;
        }
        this.f50104a.beginTransaction();
        try {
            compileStatement.a();
            this.f50104a.setTransactionSuccessful();
        } finally {
            this.f50104a.endTransaction();
        }
    }
}
