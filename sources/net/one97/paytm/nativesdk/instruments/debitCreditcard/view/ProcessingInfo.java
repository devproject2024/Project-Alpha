package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class ProcessingInfo {
    private final int rightImageUrl;
    private final String text;

    public static /* synthetic */ ProcessingInfo copy$default(ProcessingInfo processingInfo, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = processingInfo.text;
        }
        if ((i3 & 2) != 0) {
            i2 = processingInfo.rightImageUrl;
        }
        return processingInfo.copy(str, i2);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.rightImageUrl;
    }

    public final ProcessingInfo copy(String str, int i2) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        return new ProcessingInfo(str, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessingInfo)) {
            return false;
        }
        ProcessingInfo processingInfo = (ProcessingInfo) obj;
        return k.a((Object) this.text, (Object) processingInfo.text) && this.rightImageUrl == processingInfo.rightImageUrl;
    }

    public final int hashCode() {
        String str = this.text;
        return ((str != null ? str.hashCode() : 0) * 31) + this.rightImageUrl;
    }

    public final String toString() {
        return "ProcessingInfo(text=" + this.text + ", rightImageUrl=" + this.rightImageUrl + ")";
    }

    public ProcessingInfo(String str, int i2) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        this.text = str;
        this.rightImageUrl = i2;
    }

    public final int getRightImageUrl() {
        return this.rightImageUrl;
    }

    public final String getText() {
        return this.text;
    }
}
