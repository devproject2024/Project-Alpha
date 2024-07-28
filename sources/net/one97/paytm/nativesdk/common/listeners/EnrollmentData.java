package net.one97.paytm.nativesdk.common.listeners;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Utils.CardData;

public final class EnrollmentData {
    private final CardData cardData;
    private final boolean isEligible;
    private final boolean isEnrolled;

    public static /* synthetic */ EnrollmentData copy$default(EnrollmentData enrollmentData, boolean z, boolean z2, CardData cardData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = enrollmentData.isEnrolled;
        }
        if ((i2 & 2) != 0) {
            z2 = enrollmentData.isEligible;
        }
        if ((i2 & 4) != 0) {
            cardData2 = enrollmentData.cardData;
        }
        return enrollmentData.copy(z, z2, cardData2);
    }

    public final boolean component1() {
        return this.isEnrolled;
    }

    public final boolean component2() {
        return this.isEligible;
    }

    public final CardData component3() {
        return this.cardData;
    }

    public final EnrollmentData copy(boolean z, boolean z2, CardData cardData2) {
        k.c(cardData2, "cardData");
        return new EnrollmentData(z, z2, cardData2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnrollmentData)) {
            return false;
        }
        EnrollmentData enrollmentData = (EnrollmentData) obj;
        return this.isEnrolled == enrollmentData.isEnrolled && this.isEligible == enrollmentData.isEligible && k.a((Object) this.cardData, (Object) enrollmentData.cardData);
    }

    public final int hashCode() {
        boolean z = this.isEnrolled;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.isEligible;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        CardData cardData2 = this.cardData;
        return i3 + (cardData2 != null ? cardData2.hashCode() : 0);
    }

    public final String toString() {
        return "EnrollmentData(isEnrolled=" + this.isEnrolled + ", isEligible=" + this.isEligible + ", cardData=" + this.cardData + ")";
    }

    public EnrollmentData(boolean z, boolean z2, CardData cardData2) {
        k.c(cardData2, "cardData");
        this.isEnrolled = z;
        this.isEligible = z2;
        this.cardData = cardData2;
    }

    public final CardData getCardData() {
        return this.cardData;
    }

    public final boolean isEligible() {
        return this.isEligible;
    }

    public final boolean isEnrolled() {
        return this.isEnrolled;
    }
}
