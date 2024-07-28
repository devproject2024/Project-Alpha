package net.one97.paytm.upi.d;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.util.UpiContract;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f66656a;

    /* renamed from: b  reason: collision with root package name */
    private final c<AccountProviderBody.AccountProvider> f66657b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.b<AccountProviderBody.AccountProvider> f66658c;

    public b(j jVar) {
        this.f66656a = jVar;
        this.f66657b = new c<AccountProviderBody.AccountProvider>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `account_providers` (`id`,`_id`,`regMobFormat`,`iin`,`accountProvider`,`ifsc`,`bankLogoUrl`) VALUES (?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) obj;
                if (accountProvider.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, accountProvider.getId());
                }
                if (accountProvider.get_id() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, (long) accountProvider.get_id().intValue());
                }
                if (accountProvider.getRegMobFormat() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, accountProvider.getRegMobFormat());
                }
                if (accountProvider.getIin() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, accountProvider.getIin());
                }
                if (accountProvider.getAccountProvider() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, accountProvider.getAccountProvider());
                }
                if (accountProvider.getIfsc() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, accountProvider.getIfsc());
                }
                if (accountProvider.getBankLogoUrl() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, accountProvider.getBankLogoUrl());
                }
            }
        };
        this.f66658c = new androidx.room.b<AccountProviderBody.AccountProvider>(jVar) {
            public final String createQuery() {
                return "DELETE FROM `account_providers` WHERE `_id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) obj;
                if (accountProvider.get_id() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, (long) accountProvider.get_id().intValue());
                }
            }
        };
    }

    public final void a(List<? extends AccountProviderBody.AccountProvider> list) {
        this.f66656a.assertNotSuspendingTransaction();
        this.f66656a.beginTransaction();
        try {
            this.f66657b.insert(list);
            this.f66656a.setTransactionSuccessful();
        } finally {
            this.f66656a.endTransaction();
        }
    }

    public final List<AccountProviderBody.AccountProvider> a() {
        Integer num;
        m a2 = m.a("SELECT * FROM account_providers ORDER BY accountProvider", 0);
        this.f66656a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f66656a, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, "id");
            int b3 = androidx.room.b.b.b(a3, "_id");
            int b4 = androidx.room.b.b.b(a3, UpiContract.UPI_ACCOUNT_PROVIDER.REG_MOB_FORMAT);
            int b5 = androidx.room.b.b.b(a3, UpiContract.UPI_ACCOUNT_PROVIDER.IIN);
            int b6 = androidx.room.b.b.b(a3, UpiContract.UPI_ACCOUNT_PROVIDER.ACCOUNT_PROVIDER);
            int b7 = androidx.room.b.b.b(a3, "ifsc");
            int b8 = androidx.room.b.b.b(a3, UpiContract.UPI_ACCOUNT_PROVIDER.BANK_LOGO_URL);
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                AccountProviderBody.AccountProvider accountProvider = new AccountProviderBody.AccountProvider();
                accountProvider.setId(a3.getString(b2));
                if (a3.isNull(b3)) {
                    num = null;
                } else {
                    num = Integer.valueOf(a3.getInt(b3));
                }
                accountProvider.set_id(num);
                accountProvider.setRegMobFormat(a3.getString(b4));
                accountProvider.setIin(a3.getString(b5));
                accountProvider.setAccountProvider(a3.getString(b6));
                accountProvider.setIfsc(a3.getString(b7));
                accountProvider.setBankLogoUrl(a3.getString(b8));
                arrayList.add(accountProvider);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
