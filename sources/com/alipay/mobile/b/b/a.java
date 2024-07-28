package com.alipay.mobile.b.b;

public class a extends RuntimeException {
    private static final long serialVersionUID = -2875437994101380406L;
    private final int mCode;
    private String mControl;
    private final String mMsg;
    private String mOperationType;

    public a(Integer num, String str) {
        super(format(num, str));
        this.mCode = num.intValue();
        this.mMsg = str == null ? "" : str;
    }

    public a(Integer num, Throwable th) {
        super(th);
        this.mCode = num.intValue();
        this.mMsg = (th == null || th.getMessage() == null) ? "" : th.getMessage();
    }

    public a(String str) {
        super(str);
        this.mCode = 0;
        this.mMsg = str == null ? "" : str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Exception exc) {
        super(exc == null ? null : exc.getMessage());
        this.mCode = 0;
        this.mMsg = (exc == null || exc.getMessage() == null) ? "" : exc.getMessage();
    }

    public String getOperationType() {
        return this.mOperationType;
    }

    public void setOperationType(String str) {
        this.mOperationType = str;
    }

    public String getControl() {
        return this.mControl;
    }

    public void setControl(String str) {
        this.mControl = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    protected static String format(Integer num, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("RPCException: ");
        if (num != null) {
            sb.append("[");
            sb.append(num);
            sb.append("]");
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }
}
