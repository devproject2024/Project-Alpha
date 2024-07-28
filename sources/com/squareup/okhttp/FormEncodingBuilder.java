package com.squareup.okhttp;

import i.c;

public final class FormEncodingBuilder {
    private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
    private final c content = new c();

    public final FormEncodingBuilder add(String str, String str2) {
        if (this.content.f46277b > 0) {
            this.content.j(38);
        }
        HttpUrl.canonicalize(this.content, str, 0, str.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, true);
        this.content.j(61);
        HttpUrl.canonicalize(this.content, str2, 0, str2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, true);
        return this;
    }

    public final FormEncodingBuilder addEncoded(String str, String str2) {
        if (this.content.f46277b > 0) {
            this.content.j(38);
        }
        HttpUrl.canonicalize(this.content, str, 0, str.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, true);
        this.content.j(61);
        HttpUrl.canonicalize(this.content, str2, 0, str2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, true);
        return this;
    }

    public final RequestBody build() {
        return RequestBody.create(CONTENT_TYPE, this.content.w());
    }
}
