package net.one97.paytm.moneytransfer.b.a;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.b.a;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f53544a;

    /* renamed from: b  reason: collision with root package name */
    private final a f53545b;

    /* renamed from: c  reason: collision with root package name */
    private final a f53546c;

    private b(a aVar, a aVar2) {
        this.f53545b = aVar;
        this.f53546c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f53544a == null) {
            f53544a = new b(aVar, aVar2);
        }
        return f53544a;
    }

    public static void d() {
        f53544a = null;
    }

    public final void a(a.C0960a aVar, a.c cVar) {
        this.f53546c.a(aVar, cVar);
    }

    public final void a(a.C1382a aVar, String str) {
        this.f53546c.a(aVar, str);
    }

    public final void a(a.C1382a aVar, String str, String str2) {
        this.f53546c.a(aVar, str, str2);
    }

    public final void b(a.C0960a aVar, a.c cVar) {
        this.f53546c.b(aVar, cVar);
    }

    public final void a(a.C0960a aVar, String str, String str2) {
        this.f53546c.a(aVar, str, str2);
    }

    public final boolean a() {
        return this.f53545b.a();
    }

    public final boolean b() {
        return this.f53545b.b();
    }

    public final void a(String str) {
        this.f53546c.a(str);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, CLRemoteResultReceiver cLRemoteResultReceiver, String str7, String str8, String str9, String str10, String str11, List<BankAccountDetails.BankAccountCredentials> list, String str12) {
        this.f53546c.a(str, str2, str3, str4, str5, str6, cLRemoteResultReceiver, str7, str8, str9, str10, str11, list, str12);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UpiProfileDefaultBank upiProfileDefaultBank, String str11, String str12, CommonPayParams commonPayParams, String str13, String str14) {
        a.C1382a aVar2 = aVar;
        this.f53546c.a(aVar, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, upiProfileDefaultBank, str11, str12, commonPayParams, str13, str14);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UpiProfileDefaultBank upiProfileDefaultBank, String str12, boolean z, String str13, CommonPayParams commonPayParams, String str14, String str15) {
        a.C1382a aVar2 = aVar;
        this.f53546c.a(aVar, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, upiProfileDefaultBank, str12, z, str13, commonPayParams, str14, str15);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9, String str10) {
        this.f53546c.a(aVar, str, str2, str3, str4, str5, str6, str7, str8, upiProfileDefaultBank, str9, str10);
    }

    public final void a(a.C0960a aVar, a.b bVar) {
        this.f53545b.a(aVar, bVar);
        this.f53546c.a(aVar, bVar);
    }

    public final void a(a.C0960a aVar, a.b bVar, int i2, int i3) {
        if (i2 == 0) {
            this.f53545b.a(aVar, bVar, i2, i3);
        }
        this.f53546c.a(aVar, bVar, i2, i3);
    }

    public final void a(String str, String str2) {
        this.f53545b.a(str, str2);
    }

    public final void a(a.C0960a aVar, String str, String str2, String str3, String str4) {
        this.f53546c.a(aVar, str, str2, str3, str4);
    }

    public final void a(a.C0960a aVar, String str) {
        this.f53546c.a(aVar, str);
    }

    public final void a(a.C0960a aVar, String str, String str2, boolean z) {
        this.f53546c.a(aVar, str, str2, z);
    }

    public final String c() {
        return this.f53545b.c();
    }

    public final void a(net.one97.paytm.moneytransfer.a.a aVar) {
        this.f53545b.a(aVar);
    }

    public final void a(a.b bVar) {
        this.f53545b.a(bVar);
    }

    public final void a(ArrayList<BeneficiaryEntity> arrayList) {
        this.f53545b.a(arrayList);
    }

    public final void b(a.C0960a aVar, String str, String str2) {
        this.f53546c.b(aVar, str, str2);
    }

    public final void c(a.C0960a aVar, a.c cVar) {
        this.f53546c.c(aVar, cVar);
    }

    public final void b(String str) {
        this.f53545b.b(str);
    }

    public final void a(a.C0960a aVar, PaymentManager.PaymentUiModel paymentUiModel) {
        this.f53546c.a(aVar, paymentUiModel);
    }
}
