package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class CardRequestModel extends PaymentRequestModel {
    private final String authMode;
    private final String bankCode;
    private final String cardCvv;
    private final String cardExpiry;
    private final String channelCode;
    private final String emiPlanId;
    private final boolean isSingleClickEnable;
    private final String newCardNumber;
    private final String paymentMode;
    private final String savedCardId;
    private final boolean shouldSaveCard;

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getNewCardNumber() {
        return this.newCardNumber;
    }

    public final String getSavedCardId() {
        return this.savedCardId;
    }

    public final String getCardCvv() {
        return this.cardCvv;
    }

    public final String getCardExpiry() {
        return this.cardExpiry;
    }

    public final String getBankCode() {
        return this.bankCode;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final String getAuthMode() {
        return this.authMode;
    }

    public final String getEmiPlanId() {
        return this.emiPlanId;
    }

    public final boolean getShouldSaveCard() {
        return this.shouldSaveCard;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2) {
        super(str2);
        k.c(str, "paymentMode");
        k.c(str2, PayUtility.PAYMENT_FLOW);
        k.c(str5, "cardCvv");
        k.c(str9, PayUtility.AUTH_MODE);
        this.paymentMode = str;
        this.newCardNumber = str3;
        this.savedCardId = str4;
        this.cardCvv = str5;
        this.cardExpiry = str6;
        this.bankCode = str7;
        this.channelCode = str8;
        this.authMode = str9;
        this.emiPlanId = str10;
        this.shouldSaveCard = z;
        this.isSingleClickEnable = z2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardRequestModel(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, boolean r27, boolean r28, int r29, kotlin.g.b.g r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r14 = 0
            goto L_0x000b
        L_0x0009:
            r14 = r27
        L_0x000b:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0011
            r15 = 0
            goto L_0x0013
        L_0x0011:
            r15 = r28
        L_0x0013:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.dataSource.models.CardRequestModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean isSingleClickEnable() {
        return this.isSingleClickEnable;
    }
}
