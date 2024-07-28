package com.google.firebase.ml.common;

import com.google.android.gms.common.internal.s;
import com.google.firebase.e;

public final class a extends e {
    public static final int ABORTED = 10;
    public static final int ALREADY_EXISTS = 6;
    public static final int CANCELLED = 1;
    public static final int DATA_LOSS = 15;
    public static final int DEADLINE_EXCEEDED = 4;
    public static final int FAILED_PRECONDITION = 9;
    public static final int INTERNAL = 13;
    public static final int INVALID_ARGUMENT = 3;
    public static final int MODEL_HASH_MISMATCH = 102;
    public static final int MODEL_INCOMPATIBLE_WITH_TFLITE = 100;
    public static final int NOT_ENOUGH_SPACE = 101;
    public static final int NOT_FOUND = 5;
    public static final int OK = 0;
    public static final int OUT_OF_RANGE = 11;
    public static final int PERMISSION_DENIED = 7;
    public static final int RESOURCE_EXHAUSTED = 8;
    public static final int UNAUTHENTICATED = 16;
    public static final int UNAVAILABLE = 14;
    public static final int UNIMPLEMENTED = 12;
    public static final int UNKNOWN = 2;
    private final int code;

    public a(String str, int i2) {
        super(s.a(str, (Object) "Provided message must not be empty."));
        s.b(i2 != 0, "A FirebaseMLException should never be thrown for OK");
        this.code = i2;
    }

    public a(String str, int i2, Throwable th) {
        super(s.a(str, (Object) "Provided message must not be empty."), th);
        s.b(i2 != 0, "A FirebaseMLException should never be thrown for OK");
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }
}
