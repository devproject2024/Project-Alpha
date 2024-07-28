package com.airbnb.lottie.d;

import com.airbnb.lottie.f.d;

public enum a {
    JSON(".json"),
    ZIP(".zip");
    
    public final String extension;

    private a(String str) {
        this.extension = str;
    }

    public final String tempExtension() {
        return ".temp" + this.extension;
    }

    public final String toString() {
        return this.extension;
    }

    public static a forFile(String str) {
        for (a aVar : values()) {
            if (str.endsWith(aVar.extension)) {
                return aVar;
            }
        }
        d.a("Unable to find correct extension for ".concat(String.valueOf(str)));
        return JSON;
    }
}
