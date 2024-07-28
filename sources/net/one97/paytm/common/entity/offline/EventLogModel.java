package net.one97.paytm.common.entity.offline;

public class EventLogModel {
    private String param1;
    private String param2;
    private String time;
    private String type;

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getParam1() {
        return this.param1;
    }

    public void setParam1(String str) {
        this.param1 = str;
    }

    public String getParam2() {
        return this.param2;
    }

    public void setParam2(String str) {
        this.param2 = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
