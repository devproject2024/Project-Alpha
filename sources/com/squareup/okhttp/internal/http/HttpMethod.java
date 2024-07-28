package com.squareup.okhttp.internal.http;

import com.android.volley.toolbox.HttpClientStack;

public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        return str.equals("POST") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PUT") || str.equals("DELETE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME);
    }

    public static boolean permitsRequestBody(String str) {
        return requiresRequestBody(str) || str.equals("DELETE");
    }

    private HttpMethod() {
    }
}
