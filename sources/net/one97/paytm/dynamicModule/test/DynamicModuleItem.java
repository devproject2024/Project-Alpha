package net.one97.paytm.dynamicModule.test;

public class DynamicModuleItem {
    private boolean isInstalled;
    private String name;

    public DynamicModuleItem(String str, boolean z) {
        this.name = str;
        this.isInstalled = z;
    }

    public DynamicModuleItem(String str) {
        this.name = str;
        this.isInstalled = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isInstalled() {
        return this.isInstalled;
    }

    public void setInstalled(boolean z) {
        this.isInstalled = z;
    }
}
