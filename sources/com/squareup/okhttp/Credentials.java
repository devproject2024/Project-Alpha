package com.squareup.okhttp;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import i.f;
import java.io.UnsupportedEncodingException;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        try {
            return "Basic ".concat(String.valueOf(f.of((str + AppConstants.COLON + str2).getBytes("ISO-8859-1")).base64()));
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
