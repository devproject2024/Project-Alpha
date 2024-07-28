package com.google.gsonhtcfix;

public enum w {
    DEFAULT {
        public final l serialize(Long l) {
            return new s((Number) l);
        }
    },
    STRING {
        public final l serialize(Long l) {
            return new s(String.valueOf(l));
        }
    };

    public abstract l serialize(Long l);
}
