package net.one97.paytm.nativesdk.transcation.viewmodel;

public final class DirectFormItemType {
    public static final String CANCEL = "cancel";
    public static final DirectFormItemType INSTANCE = new DirectFormItemType();
    public static final String PAYONBANK = "payonbank";
    public static final String RESEND = "resend";
    public static final String SUBMIT = "submit";

    private DirectFormItemType() {
    }
}
