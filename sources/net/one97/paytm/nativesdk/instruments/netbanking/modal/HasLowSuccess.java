package net.one97.paytm.nativesdk.instruments.netbanking.modal;

public class HasLowSuccess {
    private String msg;
    private boolean status;

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "ClassPojo [status = " + this.status + ", msg = " + this.msg + "]";
    }
}
