package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.o;
import java.util.Locale;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f33579a;

    public a(Resources resources) {
        this.f33579a = (Resources) com.google.android.exoplayer2.g.a.a(resources);
    }

    private String b(Format format) {
        int i2 = format.f31065e;
        if (i2 == -1) {
            return "";
        }
        return this.f33579a.getString(R.string.exo_track_bitrate, new Object[]{Float.valueOf(((float) i2) / 1000000.0f)});
    }

    private String c(Format format) {
        String a2 = a(e(format), f(format));
        return TextUtils.isEmpty(a2) ? d(format) : a2;
    }

    private static String d(Format format) {
        return TextUtils.isEmpty(format.f31062b) ? "" : format.f31062b;
    }

    private static String e(Format format) {
        String str = format.A;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        return (ae.f32499a >= 21 ? Locale.forLanguageTag(str) : new Locale(str)).getDisplayName();
    }

    private String f(Format format) {
        String string = (format.f31064d & 2) != 0 ? this.f33579a.getString(R.string.exo_track_role_alternate) : "";
        if ((format.f31064d & 4) != 0) {
            string = a(string, this.f33579a.getString(R.string.exo_track_role_supplementary));
        }
        if ((format.f31064d & 8) != 0) {
            string = a(string, this.f33579a.getString(R.string.exo_track_role_commentary));
        }
        if ((format.f31064d & 1088) == 0) {
            return string;
        }
        return a(string, this.f33579a.getString(R.string.exo_track_role_closed_captions));
    }

    private String a(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.f33579a.getString(R.string.exo_item_list, new Object[]{str, str2});
                }
            }
        }
        return str;
    }

    public final String a(Format format) {
        String str;
        int g2 = o.g(format.f31069i);
        if (g2 == -1) {
            if (o.d(format.f31066f) == null) {
                if (o.e(format.f31066f) == null) {
                    if (format.n == -1 && format.o == -1) {
                        if (format.v == -1 && format.w == -1) {
                            g2 = -1;
                        }
                    }
                }
                g2 = 1;
            }
            g2 = 2;
        }
        String str2 = "";
        if (g2 == 2) {
            String[] strArr = new String[3];
            strArr[0] = f(format);
            int i2 = format.n;
            int i3 = format.o;
            if (!(i2 == -1 || i3 == -1)) {
                str2 = this.f33579a.getString(R.string.exo_track_resolution, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            strArr[1] = str2;
            strArr[2] = b(format);
            str = a(strArr);
        } else if (g2 == 1) {
            String[] strArr2 = new String[3];
            strArr2[0] = c(format);
            int i4 = format.v;
            if (i4 != -1 && i4 > 0) {
                str2 = i4 != 1 ? i4 != 2 ? (i4 == 6 || i4 == 7) ? this.f33579a.getString(R.string.exo_track_surround_5_point_1) : i4 != 8 ? this.f33579a.getString(R.string.exo_track_surround) : this.f33579a.getString(R.string.exo_track_surround_7_point_1) : this.f33579a.getString(R.string.exo_track_stereo) : this.f33579a.getString(R.string.exo_track_mono);
            }
            strArr2[1] = str2;
            strArr2[2] = b(format);
            str = a(strArr2);
        } else {
            str = c(format);
        }
        return str.length() == 0 ? this.f33579a.getString(R.string.exo_track_unknown) : str;
    }
}
