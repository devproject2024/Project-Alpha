package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils;

import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {
    private final StringBuilder builder;

    public void close() {
    }

    public void flush() {
    }

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilderWriter(int i2) {
        this.builder = new StringBuilder(i2);
    }

    public StringBuilderWriter(StringBuilder sb) {
        this.builder = sb == null ? new StringBuilder() : sb;
    }

    public Writer append(char c2) {
        this.builder.append(c2);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i2, int i3) {
        this.builder.append(charSequence, i2, i3);
        return this;
    }

    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    public void write(char[] cArr, int i2, int i3) {
        if (cArr != null) {
            this.builder.append(cArr, i2, i3);
        }
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }
}
