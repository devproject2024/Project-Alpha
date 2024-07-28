package net.one97.paytm.common.entity.upgradeKyc;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConsentSaveObject {
    private boolean biometricConsent;
    private boolean fastagKycConsent;
    private boolean fatca;
    private ConsentSaveForm60 form60;
    private boolean form60Consent;
    private boolean nonMinorConsent;
    private String pan;
    private String productSelected;

    public ConsentSaveObject() {
        this(false, false, (String) null, (String) null, (ConsentSaveForm60) null, false, false, false, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ ConsentSaveObject copy$default(ConsentSaveObject consentSaveObject, boolean z, boolean z2, String str, String str2, ConsentSaveForm60 consentSaveForm60, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        ConsentSaveObject consentSaveObject2 = consentSaveObject;
        int i3 = i2;
        return consentSaveObject.copy((i3 & 1) != 0 ? consentSaveObject2.biometricConsent : z, (i3 & 2) != 0 ? consentSaveObject2.form60Consent : z2, (i3 & 4) != 0 ? consentSaveObject2.pan : str, (i3 & 8) != 0 ? consentSaveObject2.productSelected : str2, (i3 & 16) != 0 ? consentSaveObject2.form60 : consentSaveForm60, (i3 & 32) != 0 ? consentSaveObject2.nonMinorConsent : z3, (i3 & 64) != 0 ? consentSaveObject2.fatca : z4, (i3 & 128) != 0 ? consentSaveObject2.fastagKycConsent : z5);
    }

    public final boolean component1() {
        return this.biometricConsent;
    }

    public final boolean component2() {
        return this.form60Consent;
    }

    public final String component3() {
        return this.pan;
    }

    public final String component4() {
        return this.productSelected;
    }

    public final ConsentSaveForm60 component5() {
        return this.form60;
    }

    public final boolean component6() {
        return this.nonMinorConsent;
    }

    public final boolean component7() {
        return this.fatca;
    }

    public final boolean component8() {
        return this.fastagKycConsent;
    }

    public final ConsentSaveObject copy(boolean z, boolean z2, String str, String str2, ConsentSaveForm60 consentSaveForm60, boolean z3, boolean z4, boolean z5) {
        return new ConsentSaveObject(z, z2, str, str2, consentSaveForm60, z3, z4, z5);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ConsentSaveObject) {
                ConsentSaveObject consentSaveObject = (ConsentSaveObject) obj;
                if (this.biometricConsent == consentSaveObject.biometricConsent) {
                    if ((this.form60Consent == consentSaveObject.form60Consent) && k.a((Object) this.pan, (Object) consentSaveObject.pan) && k.a((Object) this.productSelected, (Object) consentSaveObject.productSelected) && k.a((Object) this.form60, (Object) consentSaveObject.form60)) {
                        if (this.nonMinorConsent == consentSaveObject.nonMinorConsent) {
                            if (this.fatca == consentSaveObject.fatca) {
                                if (this.fastagKycConsent == consentSaveObject.fastagKycConsent) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.biometricConsent;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.form60Consent;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        String str = this.pan;
        int i4 = 0;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.productSelected;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ConsentSaveForm60 consentSaveForm60 = this.form60;
        if (consentSaveForm60 != null) {
            i4 = consentSaveForm60.hashCode();
        }
        int i5 = (hashCode2 + i4) * 31;
        boolean z4 = this.nonMinorConsent;
        if (z4) {
            z4 = true;
        }
        int i6 = (i5 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.fatca;
        if (z5) {
            z5 = true;
        }
        int i7 = (i6 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.fastagKycConsent;
        if (!z6) {
            z2 = z6;
        }
        return i7 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "ConsentSaveObject(biometricConsent=" + this.biometricConsent + ", form60Consent=" + this.form60Consent + ", pan=" + this.pan + ", productSelected=" + this.productSelected + ", form60=" + this.form60 + ", nonMinorConsent=" + this.nonMinorConsent + ", fatca=" + this.fatca + ", fastagKycConsent=" + this.fastagKycConsent + ")";
    }

    public ConsentSaveObject(boolean z, boolean z2, String str, String str2, ConsentSaveForm60 consentSaveForm60, boolean z3, boolean z4, boolean z5) {
        this.biometricConsent = z;
        this.form60Consent = z2;
        this.pan = str;
        this.productSelected = str2;
        this.form60 = consentSaveForm60;
        this.nonMinorConsent = z3;
        this.fatca = z4;
        this.fastagKycConsent = z5;
    }

    public final boolean getBiometricConsent() {
        return this.biometricConsent;
    }

    public final boolean getForm60Consent() {
        return this.form60Consent;
    }

    public final void setBiometricConsent(boolean z) {
        this.biometricConsent = z;
    }

    public final void setForm60Consent(boolean z) {
        this.form60Consent = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConsentSaveObject(boolean r11, boolean r12, java.lang.String r13, java.lang.String r14, net.one97.paytm.common.entity.upgradeKyc.ConsentSaveForm60 r15, boolean r16, boolean r17, boolean r18, int r19, kotlin.g.b.g r20) {
        /*
            r10 = this;
            r0 = r19
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0018
            r4 = r5
            goto L_0x0019
        L_0x0018:
            r4 = r13
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = r5
            goto L_0x0020
        L_0x001f:
            r6 = r14
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r5 = r15
        L_0x0026:
            r7 = r0 & 32
            r8 = 1
            if (r7 == 0) goto L_0x002d
            r7 = 1
            goto L_0x002f
        L_0x002d:
            r7 = r16
        L_0x002f:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r18
        L_0x003d:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r6
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.upgradeKyc.ConsentSaveObject.<init>(boolean, boolean, java.lang.String, java.lang.String, net.one97.paytm.common.entity.upgradeKyc.ConsentSaveForm60, boolean, boolean, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean getFastagKycConsent() {
        return this.fastagKycConsent;
    }

    public final boolean getFatca() {
        return this.fatca;
    }

    public final ConsentSaveForm60 getForm60() {
        return this.form60;
    }

    public final boolean getNonMinorConsent() {
        return this.nonMinorConsent;
    }

    public final String getPan() {
        return this.pan;
    }

    public final String getProductSelected() {
        return this.productSelected;
    }

    public final void setFastagKycConsent(boolean z) {
        this.fastagKycConsent = z;
    }

    public final void setFatca(boolean z) {
        this.fatca = z;
    }

    public final void setForm60(ConsentSaveForm60 consentSaveForm60) {
        this.form60 = consentSaveForm60;
    }

    public final void setNonMinorConsent(boolean z) {
        this.nonMinorConsent = z;
    }

    public final void setPan(String str) {
        this.pan = str;
    }

    public final void setProductSelected(String str) {
        this.productSelected = str;
    }
}
