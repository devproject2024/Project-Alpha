package net.one97.paytm.upgradeKyc.editprofile.e;

import android.text.TextUtils;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.j.d;
import kotlin.m.p;
import net.one97.paytm.common.entity.upgradeKyc.Address;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress;
import net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails;
import net.one97.paytm.upgradeKyc.editprofile.b.a;

public final class b implements a.d {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.d.a f65828a;

    /* renamed from: b  reason: collision with root package name */
    private a.b f65829b;

    public final void a() {
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
    }

    public b(a.b bVar, net.one97.paytm.upgradeKyc.editprofile.d.a aVar) {
        k.c(bVar, "view");
        k.c(aVar, "model");
        this.f65829b = bVar;
        this.f65828a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c9 A[Catch:{ Exception -> 0x01fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f1 A[Catch:{ Exception -> 0x01fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.IJRDataModel r12) {
        /*
            r11 = this;
            java.lang.String r0 = "aadharPanGet.cersaiInfo"
            java.lang.String r1 = "response"
            kotlin.g.b.k.c(r12, r1)
            net.one97.paytm.common.entity.CJRAadharPanGet r12 = (net.one97.paytm.common.entity.CJRAadharPanGet) r12
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r1 = r11.f65829b
            if (r1 == 0) goto L_0x0010
            r1.b()
        L_0x0010:
            java.lang.String r1 = "aadharPanGet"
            kotlin.g.b.k.c(r12, r1)     // Catch:{ Exception -> 0x01fd }
            java.lang.String r1 = r12.getStatus()     // Catch:{ Exception -> 0x01fd }
            java.lang.String r2 = "ERROR"
            r3 = 1
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = r12.getStatus()     // Catch:{ Exception -> 0x01fd }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = "961"
            java.lang.String r4 = r12.getResponseCode()     // Catch:{ Exception -> 0x01fd }
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x0038
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r1 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            goto L_0x01c3
        L_0x0038:
            java.lang.String r1 = r12.getStatus()     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r12.getStatus()     // Catch:{ Exception -> 0x01fd }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x0051
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r1 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x01c3
            r1.a()     // Catch:{ Exception -> 0x01fd }
            goto L_0x01c3
        L_0x0051:
            java.util.List r1 = r12.getDocuments()     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x01c3
            java.util.List r1 = r12.getDocuments()     // Catch:{ Exception -> 0x01fd }
            int r2 = r1.size()     // Catch:{ Exception -> 0x01fd }
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0062:
            if (r5 >= r2) goto L_0x010a
            java.lang.Object r7 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r7 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r7     // Catch:{ Exception -> 0x01fd }
            java.lang.String r7 = r7.getDocCode()     // Catch:{ Exception -> 0x01fd }
            java.lang.String r8 = "pan"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x01fd }
            java.lang.String r8 = "NON_EDITABLE_WAITING"
            java.lang.String r9 = "NON_EDITABLE_TICKED"
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r6 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r6 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r6     // Catch:{ Exception -> 0x01fd }
            java.lang.String r6 = r6.getEditableAction()     // Catch:{ Exception -> 0x01fd }
            boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x01fd }
            if (r6 == 0) goto L_0x009c
            java.lang.Object r6 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r6 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r6     // Catch:{ Exception -> 0x01fd }
            java.lang.String r6 = r6.getDocValue()     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r7 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r7 == 0) goto L_0x00bd
            r7.a(r6, r3)     // Catch:{ Exception -> 0x01fd }
            goto L_0x00bd
        L_0x009c:
            java.lang.Object r6 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r6 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r6     // Catch:{ Exception -> 0x01fd }
            java.lang.String r6 = r6.getEditableAction()     // Catch:{ Exception -> 0x01fd }
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x01fd }
            if (r6 == 0) goto L_0x00bd
            java.lang.Object r6 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r6 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r6     // Catch:{ Exception -> 0x01fd }
            java.lang.String r6 = r6.getDocValue()     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r7 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r7 == 0) goto L_0x00bd
            r7.a(r6, r4)     // Catch:{ Exception -> 0x01fd }
        L_0x00bd:
            r6 = 1
            goto L_0x0106
        L_0x00bf:
            java.lang.Object r7 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r7 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r7     // Catch:{ Exception -> 0x01fd }
            java.lang.String r7 = r7.getDocCode()     // Catch:{ Exception -> 0x01fd }
            java.lang.String r10 = "aadhar"
            boolean r7 = r7.equals(r10)     // Catch:{ Exception -> 0x01fd }
            if (r7 == 0) goto L_0x0106
            java.lang.Object r7 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r7 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r7     // Catch:{ Exception -> 0x01fd }
            java.lang.String r7 = r7.getEditableAction()     // Catch:{ Exception -> 0x01fd }
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x01fd }
            if (r7 == 0) goto L_0x00ed
            java.lang.Object r7 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r7 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r7     // Catch:{ Exception -> 0x01fd }
            r7.getDocValue()     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r7 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            goto L_0x0106
        L_0x00ed:
            java.lang.Object r7 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r7 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r7     // Catch:{ Exception -> 0x01fd }
            java.lang.String r7 = r7.getEditableAction()     // Catch:{ Exception -> 0x01fd }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x01fd }
            if (r7 == 0) goto L_0x0106
            java.lang.Object r7 = r1.get(r5)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.common.entity.CJRAadharPanDocList r7 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r7     // Catch:{ Exception -> 0x01fd }
            r7.getDocValue()     // Catch:{ Exception -> 0x01fd }
        L_0x0106:
            int r5 = r5 + 1
            goto L_0x0062
        L_0x010a:
            if (r6 != 0) goto L_0x0115
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r1 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x0115
            java.lang.String r2 = ""
            r1.a(r2, r4)     // Catch:{ Exception -> 0x01fd }
        L_0x0115:
            java.lang.String r1 = r12.getFirstname()     // Catch:{ Exception -> 0x01fd }
            java.lang.String r2 = r12.getLastname()     // Catch:{ Exception -> 0x01fd }
            java.lang.String r3 = r12.getDob()     // Catch:{ Exception -> 0x01fd }
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01fd }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01fd }
            if (r4 != 0) goto L_0x0136
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r4 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r4 == 0) goto L_0x0136
            java.lang.String r5 = "dob"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x01fd }
            r4.a((java.lang.String) r3)     // Catch:{ Exception -> 0x01fd }
        L_0x0136:
            java.lang.String r4 = r12.getGender()     // Catch:{ Exception -> 0x01fd }
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01fd }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01fd }
            java.lang.String r6 = "HomeHelper.getAppLaunchModuleInterface()"
            if (r5 != 0) goto L_0x0153
            net.one97.paytm.common.b.a r5 = net.one97.paytm.common.b.d.b()     // Catch:{ Exception -> 0x01fd }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01fd }
            android.content.Context r5 = r5.a()     // Catch:{ Exception -> 0x01fd }
            com.paytm.utility.b.o(r5, r1)     // Catch:{ Exception -> 0x01fd }
        L_0x0153:
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01fd }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01fd }
            if (r5 != 0) goto L_0x016a
            net.one97.paytm.common.b.a r5 = net.one97.paytm.common.b.d.b()     // Catch:{ Exception -> 0x01fd }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01fd }
            android.content.Context r5 = r5.a()     // Catch:{ Exception -> 0x01fd }
            com.paytm.utility.b.p(r5, r2)     // Catch:{ Exception -> 0x01fd }
        L_0x016a:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01fd }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01fd }
            if (r5 != 0) goto L_0x0181
            net.one97.paytm.common.b.a r5 = net.one97.paytm.common.b.d.b()     // Catch:{ Exception -> 0x01fd }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01fd }
            android.content.Context r5 = r5.a()     // Catch:{ Exception -> 0x01fd }
            com.paytm.utility.b.r(r5, r3)     // Catch:{ Exception -> 0x01fd }
        L_0x0181:
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x01fd }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01fd }
            if (r3 != 0) goto L_0x019f
            net.one97.paytm.common.b.a r3 = net.one97.paytm.common.b.d.b()     // Catch:{ Exception -> 0x01fd }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)     // Catch:{ Exception -> 0x01fd }
            android.content.Context r3 = r3.a()     // Catch:{ Exception -> 0x01fd }
            com.paytm.utility.b.q(r3, r4)     // Catch:{ Exception -> 0x01fd }
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r3 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r3 == 0) goto L_0x019f
            r3.c(r4)     // Catch:{ Exception -> 0x01fd }
        L_0x019f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fd }
            r3.<init>()     // Catch:{ Exception -> 0x01fd }
            r3.append(r1)     // Catch:{ Exception -> 0x01fd }
            r1 = 32
            r3.append(r1)     // Catch:{ Exception -> 0x01fd }
            r3.append(r2)     // Catch:{ Exception -> 0x01fd }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x01fd }
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01fd }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x01fd }
            if (r2 != 0) goto L_0x01c3
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r2 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r2 == 0) goto L_0x01c3
            r2.b((java.lang.String) r1)     // Catch:{ Exception -> 0x01fd }
        L_0x01c3:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r1 = r12.getCersaiInfo()     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x01f1
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r1 = r12.getCersaiInfo()     // Catch:{ Exception -> 0x01fd }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x01fd }
            boolean r1 = a((net.one97.paytm.common.entity.upgradeKyc.CersaiDetails) r1)     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x01e5
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r1 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r1 == 0) goto L_0x01e4
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r12.getCersaiInfo()     // Catch:{ Exception -> 0x01fd }
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)     // Catch:{ Exception -> 0x01fd }
            r1.a((net.one97.paytm.common.entity.upgradeKyc.CersaiDetails) r12)     // Catch:{ Exception -> 0x01fd }
        L_0x01e4:
            return
        L_0x01e5:
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r0 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r0 == 0) goto L_0x01f0
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r12.getCersaiInfo()     // Catch:{ Exception -> 0x01fd }
            r0.b((net.one97.paytm.common.entity.upgradeKyc.CersaiDetails) r12)     // Catch:{ Exception -> 0x01fd }
        L_0x01f0:
            return
        L_0x01f1:
            net.one97.paytm.upgradeKyc.editprofile.b.a$b r0 = r11.f65829b     // Catch:{ Exception -> 0x01fd }
            if (r0 == 0) goto L_0x01fc
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r12 = r12.getCersaiInfo()     // Catch:{ Exception -> 0x01fd }
            r0.b((net.one97.paytm.common.entity.upgradeKyc.CersaiDetails) r12)     // Catch:{ Exception -> 0x01fd }
        L_0x01fc:
            return
        L_0x01fd:
            r12 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x0209
            java.lang.String r12 = r12.getMessage()
            com.paytm.utility.q.b(r12)
        L_0x0209:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.e.b.a(net.one97.paytm.common.entity.IJRDataModel):void");
    }

    private static boolean a(CersaiDetails cersaiDetails) {
        RelationShipDetails relationShipDetails;
        RelationShipDetails relationShipDetails2;
        RelationShipDetails relationShipDetails3;
        if (cersaiDetails.getRelationships() != null) {
            ArrayList<RelationShipDetails> relationships = cersaiDetails.getRelationships();
            CorrespondenceAddress correspondenceAddress = null;
            Integer valueOf = relationships != null ? Integer.valueOf(relationships.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                ArrayList<RelationShipDetails> relationships2 = cersaiDetails.getRelationships();
                d a2 = relationships2 != null ? kotlin.a.k.a((Collection<?>) relationships2) : null;
                if (a2 == null) {
                    k.a();
                }
                int i2 = a2.f47939a;
                int i3 = a2.f47940b;
                boolean z = false;
                boolean z2 = false;
                if (i2 <= i3) {
                    while (true) {
                        ArrayList<RelationShipDetails> relationships3 = cersaiDetails.getRelationships();
                        String relationShip = (relationships3 == null || (relationShipDetails3 = relationships3.get(i2)) == null) ? null : relationShipDetails3.getRelationShip();
                        CharSequence charSequence = relationShip;
                        if (!TextUtils.isEmpty(charSequence) && p.a(relationShip, "FATHER", true)) {
                            ArrayList<RelationShipDetails> relationships4 = cersaiDetails.getRelationships();
                            if (!TextUtils.isEmpty((relationships4 == null || (relationShipDetails2 = relationships4.get(i2)) == null) ? null : relationShipDetails2.getFirstName())) {
                                z = true;
                            }
                        }
                        if (!TextUtils.isEmpty(charSequence) && p.a(relationShip, "MOTHER", true)) {
                            ArrayList<RelationShipDetails> relationships5 = cersaiDetails.getRelationships();
                            if (!TextUtils.isEmpty((relationships5 == null || (relationShipDetails = relationships5.get(i2)) == null) ? null : relationShipDetails.getFirstName())) {
                                z2 = true;
                            }
                        }
                        if (i2 == i3) {
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2 || !z || TextUtils.isEmpty(cersaiDetails.getProfession()) || TextUtils.isEmpty(cersaiDetails.getMaritalStatus()) || cersaiDetails.getAddress() == null) {
                    return false;
                }
                Address address = cersaiDetails.getAddress();
                if (address != null) {
                    correspondenceAddress = address.getCoresspondenceAddress();
                }
                if (correspondenceAddress == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
