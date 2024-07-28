package com.google.gson;

public enum v {
    DEFAULT {
        public final l serialize(Long l) {
            return new r((Number) l);
        }
    },
    STRING {
        public final l serialize(Long l) {
            return new r(String.valueOf(l));
        }
    };

    public abstract l serialize(Long l);
}
