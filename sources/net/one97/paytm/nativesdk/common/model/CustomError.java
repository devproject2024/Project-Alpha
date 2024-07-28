package net.one97.paytm.nativesdk.common.model;

import kotlin.g.b.k;

public final class CustomError {
    private final String message;

    public static /* synthetic */ CustomError copy$default(CustomError customError, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = customError.message;
        }
        return customError.copy(str);
    }

    public final String component1() {
        return this.message;
    }

    public final CustomError copy(String str) {
        k.c(str, "message");
        return new CustomError(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CustomError) && k.a((Object) this.message, (Object) ((CustomError) obj).message);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.message;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CustomError(message=" + this.message + ")";
    }

    public CustomError(String str) {
        k.c(str, "message");
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }
}
