package com.google.firebase.b;

public interface c {
    a a(String str);

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int code;

        private a(int i2) {
            this.code = i2;
        }

        public final int getCode() {
            return this.code;
        }
    }
}
