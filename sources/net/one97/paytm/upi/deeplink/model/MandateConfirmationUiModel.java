package net.one97.paytm.upi.deeplink.model;

import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.mandate.d.a;
import net.one97.paytm.upi.mandate.utils.m;

public final class MandateConfirmationUiModel implements UpiBaseDataModel {
    private final String accRefId;
    private final String amount;
    private final String amountRule;
    private String comment;
    private final String endDate;
    private final ExtraIntentParams extraIntentParams;
    private final String mandateName;
    private final String mcc;
    private final String payeeName;
    private final String payeeVpa;
    private final String purpose;
    private final String recurrencePattern;
    private final String recurrenceRule;
    private final String recurrenceType;
    private final String refUrl;
    private final String startDate;
    private final String transactionId;
    private final String umn;

    public MandateConfirmationUiModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ExtraIntentParams extraIntentParams2) {
        this.payeeVpa = str;
        this.payeeName = str2;
        this.amount = str3;
        this.startDate = str4;
        this.endDate = str5;
        this.mandateName = str6;
        this.comment = str7;
        this.amountRule = str8;
        this.recurrencePattern = str9;
        this.recurrenceRule = str10;
        this.recurrenceType = str11;
        this.transactionId = str12;
        this.mcc = str13;
        this.refUrl = str14;
        this.purpose = str15;
        this.accRefId = str16;
        this.umn = str17;
        this.extraIntentParams = extraIntentParams2;
    }

    public final String getPayeeVpa() {
        return this.payeeVpa;
    }

    public final String getPayeeName() {
        return this.payeeName;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getMandateName() {
        return this.mandateName;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    public final String getAmountRule() {
        return this.amountRule;
    }

    public final String getRecurrencePattern() {
        return this.recurrencePattern;
    }

    public final String getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public final String getRecurrenceType() {
        return this.recurrenceType;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getMcc() {
        return this.mcc;
    }

    public final String getRefUrl() {
        return this.refUrl;
    }

    public final String getPurpose() {
        return this.purpose;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final String getUmn() {
        return this.umn;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MandateConfirmationUiModel(java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, net.one97.paytm.upi.deeplink.model.ExtraIntentParams r39, int r40, kotlin.g.b.g r41) {
        /*
            r21 = this;
            r0 = r40
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "1"
            r12 = r1
            goto L_0x000c
        L_0x000a:
            r12 = r31
        L_0x000c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "ON"
            r13 = r1
            goto L_0x0016
        L_0x0014:
            r13 = r32
        L_0x0016:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            r2 = 0
            if (r1 == 0) goto L_0x0020
            r18 = r2
            goto L_0x0022
        L_0x0020:
            r18 = r37
        L_0x0022:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x002a
            r19 = r2
            goto L_0x002c
        L_0x002a:
            r19 = r38
        L_0x002c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0034
            r20 = r2
            goto L_0x0036
        L_0x0034:
            r20 = r39
        L_0x0036:
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r14 = r33
            r15 = r34
            r16 = r35
            r17 = r36
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.upi.deeplink.model.ExtraIntentParams, int, kotlin.g.b.g):void");
    }

    public final ExtraIntentParams getExtraIntentParams() {
        return this.extraIntentParams;
    }

    public final String getBankFilterType() {
        return getMandateTransactionType().getBankFilterType();
    }

    public final m getMandateTransactionType() {
        a aVar = a.f67112a;
        return a.a(this.recurrencePattern, this.mcc, this.purpose);
    }
}
