package com.paytm.pai.network.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EventResponse<T> {
    private String errorMessage;
    private Boolean isDiscard;
    private Boolean isDoNotRetry;
    private Boolean isSuccess;
    private T response;
    private Integer responseCode;

    public EventResponse() {
        this((Object) null, (Integer) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, 63, (g) null);
    }

    public static /* synthetic */ EventResponse copy$default(EventResponse eventResponse, T t, Integer num, Boolean bool, String str, Boolean bool2, Boolean bool3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            t = eventResponse.response;
        }
        if ((i2 & 2) != 0) {
            num = eventResponse.responseCode;
        }
        Integer num2 = num;
        if ((i2 & 4) != 0) {
            bool = eventResponse.isSuccess;
        }
        Boolean bool4 = bool;
        if ((i2 & 8) != 0) {
            str = eventResponse.errorMessage;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            bool2 = eventResponse.isDoNotRetry;
        }
        Boolean bool5 = bool2;
        if ((i2 & 32) != 0) {
            bool3 = eventResponse.isDiscard;
        }
        return eventResponse.copy(t, num2, bool4, str2, bool5, bool3);
    }

    public final T component1() {
        return this.response;
    }

    public final Integer component2() {
        return this.responseCode;
    }

    public final Boolean component3() {
        return this.isSuccess;
    }

    public final String component4() {
        return this.errorMessage;
    }

    public final Boolean component5() {
        return this.isDoNotRetry;
    }

    public final Boolean component6() {
        return this.isDiscard;
    }

    public final EventResponse<T> copy(T t, Integer num, Boolean bool, String str, Boolean bool2, Boolean bool3) {
        return new EventResponse(t, num, bool, str, bool2, bool3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventResponse)) {
            return false;
        }
        EventResponse eventResponse = (EventResponse) obj;
        return k.a((Object) this.response, (Object) eventResponse.response) && k.a((Object) this.responseCode, (Object) eventResponse.responseCode) && k.a((Object) this.isSuccess, (Object) eventResponse.isSuccess) && k.a((Object) this.errorMessage, (Object) eventResponse.errorMessage) && k.a((Object) this.isDoNotRetry, (Object) eventResponse.isDoNotRetry) && k.a((Object) this.isDiscard, (Object) eventResponse.isDiscard);
    }

    public final int hashCode() {
        T t = this.response;
        int i2 = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        Integer num = this.responseCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.isSuccess;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str = this.errorMessage;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool2 = this.isDoNotRetry;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isDiscard;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "EventResponse(response=" + this.response + ", responseCode=" + this.responseCode + ", isSuccess=" + this.isSuccess + ", errorMessage=" + this.errorMessage + ", isDoNotRetry=" + this.isDoNotRetry + ", isDiscard=" + this.isDiscard + ")";
    }

    public EventResponse(T t, Integer num, Boolean bool, String str, Boolean bool2, Boolean bool3) {
        this.response = t;
        this.responseCode = num;
        this.isSuccess = bool;
        this.errorMessage = str;
        this.isDoNotRetry = bool2;
        this.isDiscard = bool3;
    }

    public final T getResponse() {
        return this.response;
    }

    public final void setResponse(T t) {
        this.response = t;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EventResponse(java.lang.Object r5, java.lang.Integer r6, java.lang.Boolean r7, java.lang.String r8, java.lang.Boolean r9, java.lang.Boolean r10, int r11, kotlin.g.b.g r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x0011
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
        L_0x0011:
            r1 = r6
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0018
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
        L_0x0018:
            r2 = r7
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r0 = r8
        L_0x001f:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0025
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
        L_0x0025:
            r3 = r9
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002c
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
        L_0x002c:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r0
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pai.network.model.EventResponse.<init>(java.lang.Object, java.lang.Integer, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final Boolean isDoNotRetry() {
        return this.isDoNotRetry;
    }

    public final void setDoNotRetry(Boolean bool) {
        this.isDoNotRetry = bool;
    }

    public final Boolean isDiscard() {
        return this.isDiscard;
    }

    public final void setDiscard(Boolean bool) {
        this.isDiscard = bool;
    }
}
