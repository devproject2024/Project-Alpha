package com.paytm.android.chat.contact;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.SendContactBean;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.ContactsBeansHolder;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.i.a;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class f {

    /* renamed from: d  reason: collision with root package name */
    private static volatile f f41877d;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f41878a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f41879b = true;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f41880c = true;

    private f(Context context) {
        this.f41878a = context;
    }

    public static f a(Context context) {
        if (f41877d == null) {
            synchronized (f.class) {
                if (f41877d == null) {
                    f41877d = new f(context);
                }
            }
        }
        return f41877d;
    }

    public final y<c> a() {
        return y.a(new Callable() {
            public final Object call() {
                return f.this.c();
            }
        }).b(new h() {
            public final Object apply(Object obj) {
                return f.this.a((c) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ c c() throws Exception {
        String str;
        c cVar = new c();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        ArrayList<SelectContactsBean> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<a> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        String str2 = ContactColumn.CONTACT_ID;
        String str3 = "photo_uri";
        String str4 = "data1";
        String str5 = "display_name";
        SendContactBean sendContactBean = null;
        Cursor query = this.f41878a.getContentResolver().query(uri, new String[]{str5, str4, str3, str2}, (String) null, (String[]) null, "display_name COLLATE NOCASE ASC");
        ArrayList arrayList5 = new ArrayList();
        query.moveToFirst();
        String str6 = "";
        String str7 = str6;
        while (query != null && !query.isAfterLast()) {
            String string = query.getString(query.getColumnIndex(str5));
            String str8 = str5;
            String string2 = query.getString(query.getColumnIndex(str4));
            String str9 = str4;
            String string3 = query.getString(query.getColumnIndex(str3));
            String str10 = str3;
            String string4 = query.getString(query.getColumnIndex(str2));
            if (string == null || str6.equals(string)) {
                str = str6;
                string = string2;
            } else {
                str = str6;
            }
            String str11 = str2;
            if (string.length() > 79) {
                string = string.substring(0, 79);
            }
            String b2 = b(string2);
            if (b2.length() > 10) {
                b2 = c(b2);
            }
            if (e(b2) && !a(b2) && !arrayList5.contains(b2)) {
                arrayList5.add(b2);
                int compareTo = str7.compareTo(string4);
                if (compareTo != 0) {
                    if (sendContactBean != null) {
                        if (d(sendContactBean.getContactName())) {
                            arrayList3.add(new a(string, b2, string3, string4, false));
                            arrayList.add(new SelectContactsBean(sendContactBean, false));
                        } else {
                            arrayList4.add(new a(string, b2, string3, string4, false));
                            arrayList2.add(new SelectContactsBean(sendContactBean, false));
                        }
                    }
                    sendContactBean = new SendContactBean(string, b2, string3, string4);
                    str7 = string4;
                } else if (compareTo == 0) {
                    sendContactBean.setContactPhone(sendContactBean.getContactPhone() + AppConstants.COMMA + b2);
                }
            }
            if (query != null) {
                query.moveToNext();
            }
            str5 = str8;
            str4 = str9;
            str3 = str10;
            str6 = str;
            str2 = str11;
        }
        if (sendContactBean != null) {
            arrayList.add(new SelectContactsBean(sendContactBean, false));
        }
        if (query != null) {
            query.close();
        }
        if (arrayList2.size() > 0) {
            arrayList.addAll(arrayList2);
        }
        if (arrayList4.size() > 0) {
            arrayList3.addAll(arrayList4);
        }
        cVar.f41851c = arrayList;
        cVar.f41849a = arrayList3;
        return cVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ c a(c cVar) throws Throwable {
        a(cVar.f41849a);
        return cVar;
    }

    public final void a(final b bVar) {
        a().b(a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<c>() {
            public final void onSubscribe(c cVar) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                try {
                    bVar.a((c) obj);
                } catch (Throwable unused) {
                    q.a();
                }
            }

            public final void onError(Throwable th) {
                q.a();
            }
        });
    }

    public final void b(final b bVar) {
        y.a(new Callable<c>() {
            public final /* synthetic */ Object call() throws Exception {
                c cVar = new c();
                Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                ArrayList<a> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<a> arrayList3 = new ArrayList<>();
                Cursor query = f.this.f41878a.getContentResolver().query(uri, new String[]{"display_name", "data1", "photo_uri", ContactColumn.CONTACT_ID}, (String) null, (String[]) null, "display_name COLLATE NOCASE ASC");
                ArrayList arrayList4 = new ArrayList();
                if (query != null) {
                    query.moveToFirst();
                }
                String str = "";
                String str2 = str;
                while (query != null && !query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("display_name"));
                    String string2 = query.getString(query.getColumnIndex("data1"));
                    String string3 = query.getString(query.getColumnIndex("photo_uri"));
                    String string4 = query.getString(query.getColumnIndex(ContactColumn.CONTACT_ID));
                    if (string == null || str.equals(string)) {
                        string = string2;
                    }
                    String str3 = str;
                    String substring = string.length() > 79 ? string.substring(0, 79) : string;
                    Context unused = f.this.f41878a;
                    String b2 = f.b(string2);
                    if (b2.length() > 10) {
                        Context unused2 = f.this.f41878a;
                        b2 = f.c(b2);
                    }
                    if (f.e(b2) && !f.a(b2) && !arrayList4.contains(b2)) {
                        arrayList4.add(b2);
                        if (f.d(substring)) {
                            String f2 = f.f(substring);
                            if (TextUtils.isEmpty(str2) || !f2.equalsIgnoreCase(str2)) {
                                a aVar = new a(f2, (String) null, (String) null, (String) null, true);
                                arrayList.add(aVar);
                                arrayList3.add(aVar);
                                str2 = f2;
                            }
                            arrayList.add(new a(substring, b2, string3, string4, false));
                        } else {
                            arrayList2.add(new a(substring, b2, string3, string4, false));
                        }
                    }
                    if (query != null) {
                        query.moveToNext();
                    }
                    str = str3;
                }
                if (query != null) {
                    query.close();
                }
                if (arrayList2.size() > 0) {
                    a aVar2 = new a("#", (String) null, (String) null, (String) null, true);
                    arrayList.add(aVar2);
                    arrayList3.add(aVar2);
                    arrayList.addAll(arrayList2);
                }
                cVar.f41849a = arrayList;
                cVar.f41850b = arrayList3;
                return cVar;
            }
        }).b(a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<c>() {
            public final void onError(Throwable th) {
            }

            public final void onSubscribe(c cVar) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                c cVar = (c) obj;
                bVar.a(cVar);
                f.this.a(cVar.f41849a);
            }
        });
    }

    public final void b() {
        if (this.f41880c) {
            this.f41880c = false;
            y.a(new Callable<c>() {
                public final /* synthetic */ Object call() throws Exception {
                    c cVar = new c();
                    Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                    ArrayList<a> arrayList = new ArrayList<>();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<a> arrayList3 = new ArrayList<>();
                    Cursor query = f.this.f41878a.getContentResolver().query(uri, new String[]{"display_name", "data1", "photo_uri", ContactColumn.CONTACT_ID}, (String) null, (String[]) null, "display_name COLLATE NOCASE ASC");
                    ArrayList arrayList4 = new ArrayList();
                    query.moveToFirst();
                    String str = "";
                    String str2 = str;
                    while (query != null && !query.isAfterLast()) {
                        String string = query.getString(query.getColumnIndex("display_name"));
                        String string2 = query.getString(query.getColumnIndex("data1"));
                        String string3 = query.getString(query.getColumnIndex("photo_uri"));
                        String string4 = query.getString(query.getColumnIndex(ContactColumn.CONTACT_ID));
                        if (string == null || str.equals(string)) {
                            string = string2;
                        }
                        String str3 = str;
                        String substring = string.length() > 79 ? string.substring(0, 79) : string;
                        Context unused = f.this.f41878a;
                        String b2 = f.b(string2);
                        if (b2.length() > 10) {
                            Context unused2 = f.this.f41878a;
                            b2 = f.c(b2);
                        }
                        if (f.e(b2) && !f.a(b2) && !arrayList4.contains(b2)) {
                            arrayList4.add(b2);
                            if (f.d(substring)) {
                                String f2 = f.f(substring);
                                if (TextUtils.isEmpty(str2) || !f2.equalsIgnoreCase(str2)) {
                                    a aVar = new a(f2, (String) null, (String) null, (String) null, true);
                                    arrayList.add(aVar);
                                    arrayList3.add(aVar);
                                    str2 = f2;
                                }
                                arrayList.add(new a(substring, b2, string3, string4, false));
                            } else {
                                arrayList2.add(new a(substring, b2, string3, string4, false));
                            }
                        }
                        if (query != null) {
                            query.moveToNext();
                        }
                        str = str3;
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (arrayList2.size() > 0) {
                        a aVar2 = new a("#", (String) null, (String) null, (String) null, true);
                        arrayList.add(aVar2);
                        arrayList3.add(aVar2);
                        arrayList.addAll(arrayList2);
                    }
                    cVar.f41849a = arrayList;
                    cVar.f41850b = arrayList3;
                    return cVar;
                }
            }).b(a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<c>() {
                public final void onError(Throwable th) {
                }

                public final void onSubscribe(c cVar) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    c cVar = (c) obj;
                    ContactsBeansHolder.getInstance().setData(cVar.f41849a);
                    ContactsBeansHolder.getInstance().setHeanList(cVar.f41850b);
                    boolean unused = f.this.f41880c = true;
                    f.this.a(cVar.f41849a);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final ArrayList<a> arrayList) {
        if (this.f41879b) {
            this.f41879b = false;
            p.create(new s<String>() {
                public final void subscribe(r<String> rVar) throws Exception {
                    ContactManager instance = ContactManager.getInstance();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        a aVar = (a) arrayList.get(i2);
                        if (aVar.getPhnNo() != null && !"".equals(aVar.getPhnNo()) && !f.a(aVar.getPhnNo())) {
                            instance.addContact(new SyncContactBean(aVar.getName(), aVar.getPhnNo(), aVar.getPhotoUri(), aVar.getContactId()));
                        }
                    }
                    rVar.onComplete();
                }
            }).subscribeOn(a.d()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new w<String>() {
                public final void onError(Throwable th) {
                }

                public final /* bridge */ /* synthetic */ void onNext(Object obj) {
                }

                public final void onSubscribe(c cVar) {
                }

                public final void onComplete() {
                    boolean unused = f.this.f41879b = true;
                }
            });
        }
    }

    public static boolean a(String str) {
        String mobileNumber = SharedPreferencesUtil.getMobileNumber();
        if ("".equals(mobileNumber) || str == null || "".equals(str)) {
            return false;
        }
        return mobileNumber.equals(str);
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.trim().replaceAll("[^\\d+]", "").replaceAll(" ", "");
        }
        return "";
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i2 = 0;
        String replaceAll = str.trim().replaceAll("[^\\d+]", "");
        if (replaceAll.startsWith("+91")) {
            i2 = 3;
        } else if (replaceAll.startsWith("91")) {
            i2 = 2;
        } else if (replaceAll.startsWith("0")) {
            i2 = 1;
        }
        return replaceAll.substring(i2).trim().replaceAll(" ", "");
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && Character.isLetter(str.charAt(0));
    }

    public static boolean e(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public static String f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                return String.valueOf(trim.toUpperCase().charAt(0));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
