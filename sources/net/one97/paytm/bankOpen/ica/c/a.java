package net.one97.paytm.bankOpen.ica.c;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankOpen.ica.model.ICALoanModel;
import net.one97.paytm.bankOpen.ica.model.Option;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0240a f16577a = new C0240a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<ICALoanModel> f16578b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, Option> f16579c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f16580d;

    /* renamed from: e  reason: collision with root package name */
    private static NomineeModel f16581e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static a f16582f;

    /* renamed from: g  reason: collision with root package name */
    private static String f16583g = "";

    /* renamed from: net.one97.paytm.bankOpen.ica.c.a$a  reason: collision with other inner class name */
    public static final class C0240a {
        private C0240a() {
        }

        public /* synthetic */ C0240a(byte b2) {
            this();
        }

        public static a a() {
            if (a.f16582f == null) {
                a.f16582f = new a();
                a.f16578b = new ArrayList();
                a.f16579c = new HashMap();
            }
            return a.f16582f;
        }
    }

    public static void a() {
        f16582f = null;
    }

    public static HashMap<String, Option> b() {
        HashMap<String, Option> hashMap = f16579c;
        if (hashMap == null) {
            k.a("questionMap");
        }
        return hashMap;
    }

    public static void a(String str, Option option) {
        k.c(str, "question");
        k.c(option, "selectedOption");
        HashMap<String, Option> hashMap = f16579c;
        if (hashMap == null) {
            k.a("questionMap");
        }
        hashMap.put(str, option);
    }

    public static Option a(String str) {
        k.c(str, "question");
        HashMap<String, Option> hashMap = f16579c;
        if (hashMap == null) {
            k.a("questionMap");
        }
        return hashMap.get(str);
    }

    public static void a(ICALoanModel iCALoanModel) {
        k.c(iCALoanModel, "loanModel");
        ArrayList<ICALoanModel> arrayList = f16578b;
        if (arrayList == null) {
            k.a("loanList");
        }
        arrayList.add(iCALoanModel);
    }

    public static void a(int i2, ICALoanModel iCALoanModel) {
        k.c(iCALoanModel, "loanModel");
        ArrayList<ICALoanModel> arrayList = f16578b;
        if (arrayList == null) {
            k.a("loanList");
        }
        arrayList.set(i2, iCALoanModel);
    }

    public static void a(int i2) {
        ArrayList<ICALoanModel> arrayList = f16578b;
        if (arrayList == null) {
            k.a("loanList");
        }
        arrayList.remove(i2);
    }

    public static ArrayList<ICALoanModel> c() {
        ArrayList<ICALoanModel> arrayList = f16578b;
        if (arrayList == null) {
            k.a("loanList");
        }
        return arrayList;
    }

    public static void a(boolean z) {
        f16580d = z;
    }

    public static void a(NomineeModel nomineeModel) {
        f16581e = nomineeModel;
    }

    public static NomineeModel d() {
        return f16581e;
    }

    public static void b(String str) {
        k.c(str, "pan");
        f16583g = str;
    }

    public static String e() {
        return f16583g;
    }

    public static boolean f() {
        return f16580d;
    }
}
