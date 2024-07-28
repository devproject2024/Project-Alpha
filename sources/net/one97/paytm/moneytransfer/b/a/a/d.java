package net.one97.paytm.moneytransfer.b.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.model.ContactItemModel;
import net.one97.paytm.moneytransfer.model.b;
import net.one97.paytm.moneytransfer.utils.j;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.UpiConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class d implements a {

    /* renamed from: b  reason: collision with root package name */
    private static d f53539b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f53540a;

    public final void a(String str) {
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, CLRemoteResultReceiver cLRemoteResultReceiver, String str7, String str8, String str9, String str10, String str11, List<BankAccountDetails.BankAccountCredentials> list, String str12) {
    }

    public final void a(a.C0960a aVar, String str) {
    }

    public final void a(a.C0960a aVar, String str, String str2) {
    }

    public final void a(a.C0960a aVar, String str, String str2, String str3, String str4) {
    }

    public final void a(a.C0960a aVar, String str, String str2, boolean z) {
    }

    public final void a(a.C0960a aVar, a.c cVar) {
    }

    public final void a(a.C0960a aVar, PaymentManager.PaymentUiModel paymentUiModel) {
    }

    public final void a(a.C1382a aVar, String str) {
    }

    public final void a(a.C1382a aVar, String str, String str2) {
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UpiProfileDefaultBank upiProfileDefaultBank, String str12, boolean z, String str13, CommonPayParams commonPayParams, String str14, String str15) {
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UpiProfileDefaultBank upiProfileDefaultBank, String str11, String str12, CommonPayParams commonPayParams, String str13, String str14) {
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9, String str10) {
    }

    public final void b(a.C0960a aVar, String str, String str2) {
    }

    public final void b(a.C0960a aVar, a.c cVar) {
    }

    public final void c(a.C0960a aVar, a.c cVar) {
    }

    private d(Context context) {
        this.f53540a = context;
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f53539b == null) {
                f53539b = new d(context);
            }
            dVar = f53539b;
        }
        return dVar;
    }

    public final boolean a() {
        return l.a(this.f53540a.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    public final boolean b() {
        return l.a(this.f53540a.getApplicationContext()).b("is_upi_user", false, true);
    }

    public final void a(a.C0960a aVar, a.b bVar) {
        new c(this.f53540a, bVar).execute(new String[0]);
    }

    public final void a(a.C0960a aVar, a.b bVar, int i2, int i3) {
        new c(this.f53540a, bVar).execute(new String[0]);
    }

    public final void a(String str, String str2) {
        new b(this.f53540a, str, str2).execute(new Object[0]);
    }

    public final String c() {
        String b2 = l.a(this.f53540a.getApplicationContext()).b(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final void a(final net.one97.paytm.moneytransfer.a.a aVar) {
        y.a(new Callable<b>() {
            public final /* synthetic */ Object call() throws Exception {
                AnonymousClass2 r0 = this;
                b bVar = new b();
                Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                ArrayList<ContactItemModel> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<ContactItemModel> arrayList3 = new ArrayList<>();
                Cursor query = d.this.f53540a.getContentResolver().query(uri, new String[]{"display_name", "data1", "photo_uri"}, (String) null, (String[]) null, "display_name COLLATE NOCASE ASC");
                ArrayList arrayList4 = new ArrayList();
                query.moveToFirst();
                String str = "";
                while (query != null && !query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("display_name"));
                    String string2 = query.getString(query.getColumnIndex("data1"));
                    String string3 = query.getString(query.getColumnIndex("photo_uri"));
                    Context unused = d.this.f53540a;
                    String c2 = m.c(string2);
                    if (c2.length() > 10) {
                        c2 = m.a(d.this.f53540a, c2);
                    }
                    if (m.d(c2) && !arrayList4.contains(c2)) {
                        arrayList4.add(c2);
                        if (m.e(string)) {
                            String a2 = m.a(string);
                            if (TextUtils.isEmpty(str) || !a2.equalsIgnoreCase(str)) {
                                ContactItemModel contactItemModel = new ContactItemModel(a2, (String) null, (String) null, true);
                                arrayList.add(contactItemModel);
                                arrayList3.add(contactItemModel);
                                str = a2;
                            }
                            arrayList.add(new ContactItemModel(string, c2, string3, false));
                        } else {
                            arrayList2.add(new ContactItemModel(string, c2, string3, false));
                        }
                    }
                    if (query != null) {
                        query.moveToNext();
                    }
                    r0 = this;
                }
                if (query != null) {
                    query.close();
                }
                if (arrayList2.size() > 0) {
                    ContactItemModel contactItemModel2 = new ContactItemModel("#", (String) null, (String) null, true);
                    arrayList.add(contactItemModel2);
                    arrayList3.add(contactItemModel2);
                    arrayList.addAll(arrayList2);
                }
                bVar.f54029a = arrayList;
                bVar.f54030b = arrayList3;
                return bVar;
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<b>() {
            public final void onSubscribe(c cVar) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                aVar.a((b) obj);
            }

            public final void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    public final void a(ArrayList<BeneficiaryEntity> arrayList) {
        new a(this.f53540a, arrayList).execute(new Object[0]);
    }

    public final void a(a.b bVar) {
        new c(this.f53540a, bVar).execute(new String[0]);
    }

    public final void b(String str) {
        y.a(new Callable(str) {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return d.this.c(this.f$1);
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a($$Lambda$d$BcUAhKlsuW5JO45dsKc7XmseVI4.INSTANCE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer c(String str) throws Exception {
        SQLiteDatabase sQLiteDatabase;
        new j();
        net.one97.paytm.upi.database.a a2 = net.one97.paytm.upi.database.a.a(this.f53540a);
        if (!a2.b()) {
            sQLiteDatabase = a2.a();
        } else {
            sQLiteDatabase = a2.f66667a;
        }
        sQLiteDatabase.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(new Date().getTime()));
        try {
            sQLiteDatabase.update("mt_saved_beneficiaries", contentValues, "beneficiary_value LIKE ? ", new String[]{str + "%"});
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            sQLiteDatabase.close();
            throw th;
        }
        sQLiteDatabase.endTransaction();
        sQLiteDatabase.close();
        return 1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Integer num, Throwable th) throws Throwable {
        if (th != null) {
            th.printStackTrace();
        }
    }
}
