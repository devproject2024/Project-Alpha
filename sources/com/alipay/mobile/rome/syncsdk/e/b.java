package com.alipay.mobile.rome.syncsdk.e;

public enum b {
    BACKGROUND("b"),
    FOREGROUND("f");
    
    private String value;

    private b(String str) {
        this.value = str;
    }

    public static String getValue(b bVar) {
        for (b bVar2 : values()) {
            if (bVar2 == bVar) {
                return bVar.value;
            }
        }
        return null;
    }
}
