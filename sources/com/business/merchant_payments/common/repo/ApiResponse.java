package com.business.merchant_payments.common.repo;

import androidx.a.a;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.Response;

public class ApiResponse<T> {
    public static final Pattern LINK_PATTERN = Pattern.compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"");
    public static final String NEXT_LINK = "next";
    public static final Pattern PAGE_PATTERN = Pattern.compile("\\bpage=(\\d+)");
    public final T body;
    public final int code;
    public final String errorMessage;
    public final Map<String, String> links;
    public final Response<T> mResponse;
    public final Throwable throwable;

    public ApiResponse(Throwable th) {
        this.code = 500;
        this.body = null;
        this.mResponse = null;
        this.throwable = th;
        this.errorMessage = th.getMessage();
        this.links = Collections.emptyMap();
    }

    public ApiResponse(String str) {
        this.code = 500;
        this.body = null;
        this.mResponse = null;
        this.throwable = null;
        this.errorMessage = str;
        this.links = Collections.emptyMap();
    }

    public ApiResponse(Response<T> response) {
        String str;
        this.mResponse = response;
        this.throwable = null;
        this.code = response.code();
        if (response.isSuccessful()) {
            this.body = response.body();
            this.errorMessage = null;
        } else {
            if (response.errorBody() != null) {
                try {
                    str = response.errorBody().string();
                } catch (IOException unused) {
                }
                this.errorMessage = (str == null || str.trim().length() == 0) ? response.message() : str;
                this.body = null;
            }
            str = null;
            this.errorMessage = (str == null || str.trim().length() == 0) ? response.message() : str;
            this.body = null;
        }
        String str2 = response.headers().get("link");
        if (str2 == null) {
            this.links = Collections.emptyMap();
            return;
        }
        this.links = new a();
        Matcher matcher = LINK_PATTERN.matcher(str2);
        while (matcher.find()) {
            if (matcher.groupCount() == 2) {
                this.links.put(matcher.group(2), matcher.group(1));
            }
        }
    }

    public boolean isSuccessful() {
        int i2 = this.code;
        return i2 >= 200 && i2 < 300;
    }

    public Integer getNextPage() {
        String str = this.links.get("next");
        if (str == null) {
            return null;
        }
        Matcher matcher = PAGE_PATTERN.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            try {
                return Integer.valueOf(Integer.parseInt(matcher.group(1)));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
