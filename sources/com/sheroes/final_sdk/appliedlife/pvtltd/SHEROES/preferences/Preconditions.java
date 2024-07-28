package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

final class Preconditions {
    static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    private Preconditions() {
        throw new AssertionError("No instances");
    }
}
