package com.google.firebase.messaging;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.regex.Pattern;

final class t {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f39028d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    final String f39029a;

    /* renamed from: b  reason: collision with root package name */
    final String f39030b;

    /* renamed from: c  reason: collision with root package name */
    final String f39031c;

    private t(String str, String str2) {
        String str3;
        if (str2 == null || !str2.startsWith("/topics/")) {
            str3 = str2;
        } else {
            String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str});
            str3 = str2.substring(8);
        }
        if (str3 == null || !f39028d.matcher(str3).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str3, "[a-zA-Z0-9-_.~%]{1,900}"}));
        }
        this.f39029a = str3;
        this.f39030b = str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("!");
        sb.append(str2);
        this.f39031c = sb.toString();
    }

    static t a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new t(split[0], split[1]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (!this.f39029a.equals(tVar.f39029a) || !this.f39030b.equals(tVar.f39030b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39030b, this.f39029a});
    }
}
