package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class MandateSupportedApp {
    @c(a = "handle")
    @a
    private List<String> handle = null;
    @c(a = "name")
    @a
    private String name;
    @c(a = "packageName")
    @a
    private String packageName;
    @c(a = "priority")
    @a
    private int priority;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<String> getHandle() {
        return this.handle;
    }

    public void setHandle(List<String> list) {
        this.handle = list;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }
}
