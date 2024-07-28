package net.one97.paytm.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.Contacts;
import net.one97.paytm.contacts.utils.e;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final a f69805a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f69806b = {ContactColumn.CONTACT_ID, "display_name", "data1"};

    public interface b {
        void a(long j);
    }

    public interface c {
        void a(ArrayList<Contacts> arrayList);
    }

    public interface d {
        void a(ArrayList<IJRDataModel> arrayList);
    }

    public interface e {

        public static final class a {
            public static void a(e.h hVar, Context context) {
                k.c(hVar, "sycing");
                k.c(context, "context");
            }

            public static void b(e.h hVar, Context context) {
                k.c(hVar, "sycing");
                k.c(context, "context");
            }
        }

        void a(ArrayList<ContactDetail> arrayList);

        void a(LinkedHashSet<IJRDataModel> linkedHashSet);

        void a(e.h hVar, Context context, int i2, boolean z);

        void b(e.h hVar, Context context, int i2);

        void d();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Activity activity, d dVar) {
            k.c(dVar, "listener");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new C1409a(activity, arrayList2, arrayList3, arrayList, dVar, (kotlin.d.d) null), 3, (Object) null);
        }

        public static boolean a(String str) {
            k.c(str, "mobile");
            if (!TextUtils.isEmpty(str)) {
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

        public static String b(String str) {
            k.c(str, "query");
            Pattern compile = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
            Pattern compile2 = Pattern.compile("\\d{3}/\\d{3}/\\d{4}");
            Pattern compile3 = Pattern.compile("\\d{5}-\\d{5}");
            Pattern compile4 = Pattern.compile("\\d{5}/\\d{5}");
            Pattern compile5 = Pattern.compile("\\d{4}/\\d{4}/\\d{2}");
            Pattern compile6 = Pattern.compile("\\d{4}-\\d{4}-\\d{2}");
            CharSequence charSequence = str;
            Matcher matcher = compile.matcher(charSequence);
            Matcher matcher2 = compile2.matcher(charSequence);
            Matcher matcher3 = compile3.matcher(charSequence);
            Matcher matcher4 = compile4.matcher(charSequence);
            Matcher matcher5 = compile5.matcher(charSequence);
            Matcher matcher6 = compile6.matcher(charSequence);
            if (matcher.find() || matcher2.find()) {
                StringBuilder sb = new StringBuilder();
                String substring = str.substring(0, 3);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                String substring2 = str.substring(4, 7);
                k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
                String substring3 = str.substring(8);
                k.a((Object) substring3, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring3);
                return sb.toString();
            } else if (matcher3.find() || matcher4.find()) {
                StringBuilder sb2 = new StringBuilder();
                String substring4 = str.substring(0, 5);
                k.a((Object) substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb2.append(substring4);
                String substring5 = str.substring(6);
                k.a((Object) substring5, "(this as java.lang.String).substring(startIndex)");
                sb2.append(substring5);
                return sb2.toString();
            } else if (!matcher5.find() && !matcher6.find()) {
                return str;
            } else {
                StringBuilder sb3 = new StringBuilder();
                String substring6 = str.substring(0, 4);
                k.a((Object) substring6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb3.append(substring6);
                String substring7 = str.substring(5, 9);
                k.a((Object) substring7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb3.append(substring7);
                String substring8 = str.substring(10);
                k.a((Object) substring8, "(this as java.lang.String).substring(startIndex)");
                sb3.append(substring8);
                return sb3.toString();
            }
        }

        public static ArrayList<net.one97.paytm.contacts.b> a(HashMap<Character, List<IJRDataModel>> hashMap) {
            k.c(hashMap, "mDataMap");
            ArrayList<net.one97.paytm.contacts.b> arrayList = new ArrayList<>();
            for (Character next : hashMap.keySet()) {
                if (next == null || next.charValue() != '#') {
                    net.one97.paytm.contacts.c cVar = new net.one97.paytm.contacts.c();
                    k.a((Object) next, "key");
                    cVar.a(next.charValue());
                    arrayList.add(cVar);
                    List<IJRDataModel> list = hashMap.get(next);
                    if (list == null) {
                        k.a();
                    }
                    for (IJRDataModel a2 : list) {
                        net.one97.paytm.contacts.a aVar = new net.one97.paytm.contacts.a();
                        aVar.a(a2);
                        arrayList.add(aVar);
                    }
                }
            }
            if (hashMap.containsKey('#')) {
                net.one97.paytm.contacts.c cVar2 = new net.one97.paytm.contacts.c();
                cVar2.a('#');
                arrayList.add(cVar2);
                List<IJRDataModel> list2 = hashMap.get(Character.valueOf(cVar2.a()));
                if (list2 == null) {
                    k.a();
                }
                for (IJRDataModel a3 : list2) {
                    net.one97.paytm.contacts.a aVar2 = new net.one97.paytm.contacts.a();
                    aVar2.a(a3);
                    arrayList.add(aVar2);
                }
            }
            return arrayList;
        }

        public static String[] a() {
            String[] strArr = new String[27];
            int i2 = 0;
            for (char c2 = 'A'; c2 <= 'Z'; c2 = (char) (c2 + 1)) {
                strArr[i2] = String.valueOf(c2);
                i2++;
            }
            strArr[i2] = "#";
            return strArr;
        }

        @kotlin.d.b.a.f(b = "ContactsUtil.kt", c = {59, 87}, d = "invokeSuspend", e = "net/one97/paytm/utils/ContactsUtil$Companion$loadContacts$1")
        /* renamed from: net.one97.paytm.utils.x$a$a  reason: collision with other inner class name */
        static final class C1409a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
            final /* synthetic */ ArrayList $contactList;
            final /* synthetic */ Activity $context;
            final /* synthetic */ d $listener;
            final /* synthetic */ ArrayList $nameList;
            final /* synthetic */ ArrayList $numberList;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1409a(Activity activity, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, d dVar, kotlin.d.d dVar2) {
                super(2, dVar2);
                this.$context = activity;
                this.$nameList = arrayList;
                this.$numberList = arrayList2;
                this.$contactList = arrayList3;
                this.$listener = dVar;
            }

            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                C1409a aVar = new C1409a(this.$context, this.$nameList, this.$numberList, this.$contactList, this.$listener, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C1409a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
            }

            @kotlin.d.b.a.f(b = "ContactsUtil.kt", c = {84}, d = "invokeSuspend", e = "net/one97/paytm/utils/ContactsUtil$Companion$loadContacts$1$1$1")
            /* renamed from: net.one97.paytm.utils.x$a$a$a  reason: collision with other inner class name */
            static final class C1410a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                int label;
                private CoroutineScope p$;
                final /* synthetic */ C1409a this$0;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1410a(kotlin.d.d dVar, C1409a aVar) {
                    super(2, dVar);
                    this.this$0 = aVar;
                }

                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                    k.c(dVar, "completion");
                    C1410a aVar = new C1410a(dVar, this.this$0);
                    aVar.p$ = (CoroutineScope) obj;
                    return aVar;
                }

                public final Object invoke(Object obj, Object obj2) {
                    return ((C1410a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                }

                public final Object invokeSuspend(Object obj) {
                    kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else if (!(obj instanceof p.b)) {
                        this.this$0.$listener.a(this.this$0.$contactList);
                        return kotlin.x.f47997a;
                    } else {
                        throw ((p.b) obj).exception;
                    }
                }
            }

            public final Object invokeSuspend(Object obj) {
                Cursor cursor;
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        Cursor cursor2 = (Cursor) this.L$1;
                        if (!(obj instanceof p.b)) {
                            cursor = cursor2;
                        } else {
                            throw ((p.b) obj).exception;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (!(obj instanceof p.b)) {
                    Activity activity = this.$context;
                    ContentResolver contentResolver = activity != null ? activity.getContentResolver() : null;
                    cursor = contentResolver != null ? contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, x.f69806b, (String) null, (String[]) null, "display_name ASC") : null;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("display_name"));
                            String a2 = net.one97.paytm.wallet.utility.a.a(cursor.getString(cursor.getColumnIndex("data1")));
                            if (a2.length() > 10) {
                                a2 = net.one97.paytm.wallet.utility.a.a(this.$context, a2);
                            }
                            a aVar2 = x.f69805a;
                            k.a((Object) a2, "phoneNo");
                            if (a.a(a2)) {
                                if (!this.$nameList.contains(string)) {
                                    this.$nameList.add(string);
                                    this.$numberList.add(a2);
                                    this.$contactList.add(new RecentSendMoney(string, a2));
                                } else if (!this.$numberList.contains(a2)) {
                                    this.$numberList.add(a2);
                                    this.$contactList.add(new RecentSendMoney(string, a2));
                                }
                            }
                        }
                        this.L$0 = contentResolver;
                        this.L$1 = cursor;
                        this.L$2 = cursor;
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C1410a((kotlin.d.d) null, this), this) == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    throw ((p.b) obj).exception;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return kotlin.x.f47997a;
            }
        }
    }
}
