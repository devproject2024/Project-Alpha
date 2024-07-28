package net.one97.paytm.contacts.b;

import android.database.Cursor;
import androidx.room.b.e;
import androidx.room.c;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails;

public final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.room.j f50099a;

    /* renamed from: b  reason: collision with root package name */
    private final c f50100b;

    /* renamed from: c  reason: collision with root package name */
    private final q f50101c;

    public j(androidx.room.j jVar) {
        this.f50099a = jVar;
        this.f50100b = new c<PayeeInfoDetails>(jVar) {
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
        this.f50101c = new q(jVar) {
            public final String createQuery() {
                return "update payee_info_table set isDirty=? where payeeInfoId=? and type=?";
            }
        };
    }

    public final void b(int i2, String str) {
        f acquire = this.f50101c.acquire();
        this.f50099a.beginTransaction();
        try {
            acquire.a(1, 0);
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a(3, (long) i2);
            acquire.a();
            this.f50099a.setTransactionSuccessful();
        } finally {
            this.f50099a.endTransaction();
            this.f50101c.release(acquire);
        }
    }

    public final int a(int i2, String str) {
        m a2 = m.a("Select count(*) from payee_info_table where type=? and payeeInfoId like ?", 2);
        a2.a(1, (long) i2);
        if (str == null) {
            a2.f4477f[2] = 1;
        } else {
            a2.a(2, str);
        }
        Cursor query = this.f50099a.query(a2);
        try {
            int i3 = 0;
            if (query.moveToFirst()) {
                i3 = query.getInt(0);
            }
            return i3;
        } finally {
            query.close();
            a2.a();
        }
    }

    public final int a(List<Integer> list) {
        StringBuilder a2 = e.a();
        a2.append("Select count(*) from payee_info_table where type in (");
        int size = list.size();
        e.a(a2, size);
        a2.append(")");
        int i2 = 0;
        m a3 = m.a(a2.toString(), size + 0);
        int i3 = 1;
        for (Integer next : list) {
            if (next == null) {
                a3.f4477f[i3] = 1;
            } else {
                a3.a(i3, (long) next.intValue());
            }
            i3++;
        }
        Cursor query = this.f50099a.query(a3);
        try {
            if (query.moveToFirst()) {
                i2 = query.getInt(0);
            }
            return i2;
        } finally {
            query.close();
            a3.a();
        }
    }

    public final List<PayeeInfoDetails> a(int i2) {
        Integer valueOf;
        m a2 = m.a("Select id,payeeInfoId,type,version from payee_info_table  where type=? and isDeleted=0 order by payeeInfoId", 1);
        a2.a(1, (long) i2);
        Cursor query = this.f50099a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payeeInfoId");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("type");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("version");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j = query.getLong(columnIndexOrThrow);
                String string = query.getString(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow3));
                }
                arrayList.add(new PayeeInfoDetails(j, string, (Boolean) null, (Boolean) null, valueOf, (String) null, query.getString(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            query.close();
            a2.a();
        }
    }

    public final int b(List<Integer> list) {
        StringBuilder a2 = e.a();
        a2.append("Select count(*) from payee_info_table where type in (");
        int size = list.size();
        e.a(a2, size);
        a2.append(") and isDirty=1 and isDeleted=0");
        int i2 = 0;
        m a3 = m.a(a2.toString(), size + 0);
        int i3 = 1;
        for (Integer next : list) {
            if (next == null) {
                a3.f4477f[i3] = 1;
            } else {
                a3.a(i3, (long) next.intValue());
            }
            i3++;
        }
        Cursor query = this.f50099a.query(a3);
        try {
            if (query.moveToFirst()) {
                i2 = query.getInt(0);
            }
            return i2;
        } finally {
            query.close();
            a3.a();
        }
    }

    public final int c(List<Integer> list) {
        StringBuilder a2 = e.a();
        a2.append("Select count(*) from payee_info_table where type in (");
        int size = list.size();
        e.a(a2, size);
        a2.append(") and isDeleted=1");
        int i2 = 0;
        m a3 = m.a(a2.toString(), size + 0);
        int i3 = 1;
        for (Integer next : list) {
            if (next == null) {
                a3.f4477f[i3] = 1;
            } else {
                a3.a(i3, (long) next.intValue());
            }
            i3++;
        }
        Cursor query = this.f50099a.query(a3);
        try {
            if (query.moveToFirst()) {
                i2 = query.getInt(0);
            }
            return i2;
        } finally {
            query.close();
            a3.a();
        }
    }

    public final List<PayeeInfoDetails> b(int i2) {
        Integer num;
        Boolean bool;
        Integer num2;
        Boolean bool2;
        Object obj;
        m a2 = m.a("Select * from payee_info_table where  type=? and isDeleted=1", 1);
        a2.a(1, (long) i2);
        Cursor query = this.f50099a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payeeInfoId");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("isDirty");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("isDeleted");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("type");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("newContactVisibility");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("version");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j = query.getLong(columnIndexOrThrow);
                String string = query.getString(columnIndexOrThrow2);
                Integer num3 = null;
                if (query.isNull(columnIndexOrThrow3)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow3));
                }
                boolean z = false;
                if (num == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(num.intValue() != 0);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(query.getInt(columnIndexOrThrow4));
                }
                if (num2 == null) {
                    bool2 = null;
                } else {
                    if (num2.intValue() != 0) {
                        z = true;
                    }
                    bool2 = Boolean.valueOf(z);
                }
                if (!query.isNull(columnIndexOrThrow5)) {
                    num3 = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                }
                new PayeeInfoDetails(j, string, bool, bool2, num3, query.getString(columnIndexOrThrow6), query.getString(columnIndexOrThrow7));
                arrayList.add(obj);
            }
            return arrayList;
        } finally {
            query.close();
            a2.a();
        }
    }

    public final PayeeInfoDetails a(String str, int i2) {
        PayeeInfoDetails payeeInfoDetails;
        Integer num;
        Boolean bool;
        Integer num2;
        Boolean bool2;
        String str2 = str;
        m a2 = m.a("Select * from payee_info_table where type=? and  payeeInfoId =?", 2);
        a2.a(1, (long) i2);
        if (str2 == null) {
            a2.f4477f[2] = 1;
        } else {
            a2.a(2, str2);
        }
        Cursor query = this.f50099a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payeeInfoId");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("isDirty");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("isDeleted");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("type");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("newContactVisibility");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("version");
            Integer num3 = null;
            if (query.moveToFirst()) {
                long j = query.getLong(columnIndexOrThrow);
                String string = query.getString(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow3));
                }
                boolean z = false;
                if (num == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(num.intValue() != 0);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(query.getInt(columnIndexOrThrow4));
                }
                if (num2 == null) {
                    bool2 = null;
                } else {
                    if (num2.intValue() != 0) {
                        z = true;
                    }
                    bool2 = Boolean.valueOf(z);
                }
                if (!query.isNull(columnIndexOrThrow5)) {
                    num3 = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                }
                payeeInfoDetails = new PayeeInfoDetails(j, string, bool, bool2, num3, query.getString(columnIndexOrThrow6), query.getString(columnIndexOrThrow7));
            } else {
                payeeInfoDetails = null;
            }
            return payeeInfoDetails;
        } finally {
            query.close();
            a2.a();
        }
    }

    public final List<PayeeInfoDetails> c(int i2) {
        Integer num;
        Boolean bool;
        Integer num2;
        Boolean bool2;
        Object obj;
        m a2 = m.a("Select * from payee_info_table where type=?  and isDirty=?  and isDeleted=0 order by id ", 2);
        a2.a(1, (long) i2);
        a2.a(2, 1);
        Cursor query = this.f50099a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payeeInfoId");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("isDirty");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("isDeleted");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("type");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("newContactVisibility");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("version");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j = query.getLong(columnIndexOrThrow);
                String string = query.getString(columnIndexOrThrow2);
                Integer num3 = null;
                if (query.isNull(columnIndexOrThrow3)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow3));
                }
                boolean z = false;
                if (num == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(num.intValue() != 0);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(query.getInt(columnIndexOrThrow4));
                }
                if (num2 == null) {
                    bool2 = null;
                } else {
                    if (num2.intValue() != 0) {
                        z = true;
                    }
                    bool2 = Boolean.valueOf(z);
                }
                if (!query.isNull(columnIndexOrThrow5)) {
                    num3 = Integer.valueOf(query.getInt(columnIndexOrThrow5));
                }
                new PayeeInfoDetails(j, string, bool, bool2, num3, query.getString(columnIndexOrThrow6), query.getString(columnIndexOrThrow7));
                arrayList.add(obj);
            }
            return arrayList;
        } finally {
            query.close();
            a2.a();
        }
    }

    public final void a(int i2, List<String> list) {
        StringBuilder a2 = e.a();
        a2.append("update payee_info_table set isDeleted=");
        a2.append("?");
        a2.append(" where payeeInfoId in (");
        int size = list.size();
        e.a(a2, size);
        a2.append(") and type=");
        a2.append("?");
        f compileStatement = this.f50099a.compileStatement(a2.toString());
        compileStatement.a(1, 1);
        int i3 = 2;
        for (String next : list) {
            if (next == null) {
                compileStatement.a(i3);
            } else {
                compileStatement.a(i3, next);
            }
            i3++;
        }
        compileStatement.a(size + 2, (long) i2);
        this.f50099a.beginTransaction();
        try {
            compileStatement.a();
            this.f50099a.setTransactionSuccessful();
        } finally {
            this.f50099a.endTransaction();
        }
    }
}
