package androidx.room.b;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f4387a = new String[0];

    public static StringBuilder a() {
        return new StringBuilder();
    }

    public static void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("?");
            if (i3 < i2 - 1) {
                sb.append(AppConstants.COMMA);
            }
        }
    }
}
