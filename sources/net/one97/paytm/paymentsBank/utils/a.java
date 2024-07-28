package net.one97.paytm.paymentsBank.utils;

import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.h.b;
import net.one97.paytm.bankCommon.h.c;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.utils.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19494a = new a();

    private a() {
    }

    public static boolean a(CustProductList custProductList) {
        k.c(custProductList, "custProductList");
        return j.a().equals("ISA") ? !TextUtils.isEmpty(custProductList.getIsaStatus()) && p.a("ISSUED", custProductList.getIsaStatus(), true) : !TextUtils.isEmpty(custProductList.getIcaStatus()) && p.a("ISSUED", custProductList.getIcaStatus(), true);
    }

    public static boolean b(CustProductList custProductList) {
        k.c(custProductList, "custProductList");
        if (j.a().equals("ISA")) {
            return !TextUtils.isEmpty(custProductList.getIsaStatus()) && (p.a(custProductList.getIsaStatus(), "NOT_APPLIED", true) || p.a(custProductList.getIsaStatus(), "LEAD", true));
        }
        CustProductList.Ica ica = custProductList.getIca();
        String str = null;
        if (!TextUtils.isEmpty(ica != null ? ica.getAccountStatus() : null)) {
            CustProductList.Ica ica2 = custProductList.getIca();
            if (!p.a("NOT_APPLIED", ica2 != null ? ica2.getAccountStatus() : null, true)) {
                CustProductList.Ica ica3 = custProductList.getIca();
                if (ica3 != null) {
                    str = ica3.getAccountStatus();
                }
                if (p.a("LEAD", str, true)) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c(CustProductList custProductList) {
        k.c(custProductList, "custProductList");
        if (j.a().equals("ISA")) {
            return !TextUtils.isEmpty(custProductList.getIsaStatus()) && p.a(custProductList.getIsaStatus(), "CLOSED", true);
        }
        CustProductList.Ica ica = custProductList.getIca();
        String str = null;
        if (!TextUtils.isEmpty(ica != null ? ica.getAccountStatus() : null)) {
            CustProductList.Ica ica2 = custProductList.getIca();
            if (ica2 != null) {
                str = ica2.getAccountStatus();
            }
            if (p.a("CLOSED", str, true)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(CustProductList custProductList) {
        k.c(custProductList, "custProductList");
        if (!j.a().equals("ISA")) {
            return false;
        }
        if (custProductList.getIsaAccountStatus() == null || net.one97.paytm.passbook.beans.CustProductList.ISA_CREDIT_FREEZED.equals(custProductList.getIsaAccountStatus()) || net.one97.paytm.passbook.beans.CustProductList.ISA_DEBIT_FREEZED.equals(custProductList.getIsaAccountStatus()) || net.one97.paytm.passbook.beans.CustProductList.ISA_TOTAL_FREEZED.equals(custProductList.getIsaAccountStatus()) || p.a(net.one97.paytm.passbook.beans.CustProductList.ISA_DORMANT, custProductList.getIsa().txnActivityStatus, true)) {
            return true;
        }
        return false;
    }

    public static boolean e(CustProductList custProductList) {
        k.c(custProductList, "custProductList");
        if (!j.a().equals("ISA") || custProductList.getIsaAccountStatus() == null || !p.a(net.one97.paytm.passbook.beans.CustProductList.ISA_DORMANT, custProductList.getIsa().txnActivityStatus, true)) {
            return false;
        }
        return true;
    }

    public static String a(CustProductList custProductList, boolean z) {
        CustProductList.Ica ica;
        String a2 = z ? j.a() : i(custProductList);
        if (a2.equals("ISA")) {
            if (custProductList != null) {
                return custProductList.getIsaAccNum();
            }
            return null;
        } else if (!a2.equals("ICA") || custProductList == null || (ica = custProductList.getIca()) == null) {
            return null;
        } else {
            return ica.getAccountNumber();
        }
    }

    public static String b(CustProductList custProductList, boolean z) {
        CustProductList.Ica ica;
        String a2 = z ? j.a() : i(custProductList);
        if (a2.equals("ISA")) {
            if (custProductList != null) {
                return custProductList.getIsaIfsc();
            }
            return null;
        } else if (!a2.equals("ICA") || custProductList == null || (ica = custProductList.getIca()) == null) {
            return null;
        } else {
            return ica.getIfscCode();
        }
    }

    public static String h(CustProductList custProductList) {
        CustProductList.Ica ica;
        if (!j.a().equals("ICA") || custProductList == null || (ica = custProductList.getIca()) == null) {
            return null;
        }
        return ica.getCaId();
    }

    public static String i(CustProductList custProductList) {
        CustProductList.Ica ica = null;
        if ((custProductList != null ? custProductList.getIsa() : null) != null) {
            return "ISA";
        }
        if (custProductList != null) {
            ica = custProductList.getIca();
        }
        return ica != null ? "ICA" : "";
    }

    public static void j(CustProductList custProductList) {
        if (custProductList == null) {
            return;
        }
        if (j.a().equals("ISA")) {
            if ("NOT_APPLIED".equals(custProductList.getIsaStatus()) || "LEAD".equals(custProductList.getIsaStatus())) {
                net.one97.paytm.paymentsBank.h.a a2 = o.a();
                k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
                b.j(a2.getApplicationContext());
            } else if ("FAILED".equals(custProductList.getIsaStatus()) || "IN_PROGRESS".equals(custProductList.getIsaStatus()) || "INITIATED".equals(custProductList.getIsaStatus()) || "PENDING".equals(custProductList.getIsaStatus())) {
                net.one97.paytm.paymentsBank.h.a a3 = o.a();
                k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
                b.k(a3.getApplicationContext());
            } else if ("ISSUED".equals(custProductList.getIsaStatus())) {
                net.one97.paytm.paymentsBank.h.a a4 = o.a();
                k.a((Object) a4, "PaymentsBankHelper.getImplListener()");
                b.l(a4.getApplicationContext());
            }
        } else if ("NOT_APPLIED".equals(custProductList.getIcaStatus()) || "LEAD".equals(custProductList.getIcaStatus())) {
            net.one97.paytm.paymentsBank.h.a a5 = o.a();
            k.a((Object) a5, "PaymentsBankHelper.getImplListener()");
            c.a(a5.getApplicationContext());
        } else if ("FAILED".equals(custProductList.getIcaStatus()) || "IN_PROGRESS".equals(custProductList.getIcaStatus()) || "INITIATED".equals(custProductList.getIcaStatus()) || "PENDING".equals(custProductList.getIcaStatus())) {
            net.one97.paytm.paymentsBank.h.a a6 = o.a();
            k.a((Object) a6, "PaymentsBankHelper.getImplListener()");
            c.b(a6.getApplicationContext());
        } else if ("ISSUED".equals(custProductList.getIcaStatus())) {
            net.one97.paytm.paymentsBank.h.a a7 = o.a();
            k.a((Object) a7, "PaymentsBankHelper.getImplListener()");
            c.c(a7.getApplicationContext());
        }
    }

    public static String a() {
        "ISA".equals(j.a());
        k.a((Object) g.b(), "GTMLoader.getInstance()");
        String g2 = d.g();
        k.a((Object) g2, "GTMLoader.getInstance().savingAccInterest");
        return g2;
    }

    public static boolean b() {
        if (!j.b()) {
            return false;
        }
        g.b();
        return true;
    }

    public static boolean c() {
        if (!j.a().equals("ISA")) {
            return true;
        }
        k.a((Object) g.b(), "GTMLoader.getInstance()");
        return d.i();
    }

    public static String d() {
        j.a().equals("ISA");
        k.a((Object) g.b(), "GTMLoader.getInstance()");
        String j = d.j();
        k.a((Object) j, "GTMLoader.getInstance().totalBalanceDesc");
        return j;
    }

    public static String e() {
        j.a().equals("ISA");
        k.a((Object) g.b(), "GTMLoader.getInstance()");
        String k = d.k();
        k.a((Object) k, "GTMLoader.getInstance().walletDesc");
        return k;
    }

    public static boolean f() {
        if (!j.a().equals("ISA")) {
            return true;
        }
        g.b();
        return d.x();
    }

    public static boolean g() {
        if (!j.a().equals("ISA")) {
            return false;
        }
        g.b();
        return d.w();
    }

    public static boolean h() {
        j.a().equals("ISA");
        k.a((Object) g.b(), "GTMLoader.getInstance()");
        return d.f();
    }

    public static boolean i() {
        if (!j.a().equals("ISA")) {
            return true;
        }
        k.a((Object) g.b(), "GTMLoader.getInstance()");
        return d.h();
    }

    public static ArrayList<Integer> j() {
        boolean z;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (j.b()) {
            arrayList.add(3);
            arrayList.add(2);
            arrayList.add(5);
            arrayList.add(10);
            boolean z2 = false;
            if (j.a().equals("ISA")) {
                k.a((Object) g.b(), "GTMLoader.getInstance()");
                z = d.z();
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(7);
            }
            if (j.a().equals("ISA")) {
                k.a((Object) g.b(), "GTMLoader.getInstance()");
                z2 = d.B();
            }
            if (z2) {
                arrayList.add(Integer.valueOf(AppConstants.START_OTP_FLOW));
            }
        } else {
            arrayList.add(2);
            arrayList.add(5);
        }
        return arrayList;
    }
}
