package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f32512a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f32513b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f32514c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Integer> f32515d;

    private static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    static {
        HashMap hashMap = new HashMap();
        f32515d = hashMap;
        hashMap.put("aliceblue", -984833);
        f32515d.put("antiquewhite", -332841);
        f32515d.put("aqua", -16711681);
        f32515d.put("aquamarine", -8388652);
        f32515d.put("azure", -983041);
        f32515d.put("beige", -657956);
        f32515d.put("bisque", -6972);
        f32515d.put("black", -16777216);
        f32515d.put("blanchedalmond", -5171);
        f32515d.put("blue", -16776961);
        f32515d.put("blueviolet", -7722014);
        f32515d.put("brown", -5952982);
        f32515d.put("burlywood", -2180985);
        f32515d.put("cadetblue", -10510688);
        f32515d.put("chartreuse", -8388864);
        f32515d.put("chocolate", -2987746);
        f32515d.put("coral", -32944);
        f32515d.put("cornflowerblue", -10185235);
        f32515d.put("cornsilk", -1828);
        f32515d.put("crimson", -2354116);
        f32515d.put("cyan", -16711681);
        f32515d.put("darkblue", -16777077);
        f32515d.put("darkcyan", -16741493);
        f32515d.put("darkgoldenrod", -4684277);
        f32515d.put("darkgray", -5658199);
        f32515d.put("darkgreen", -16751616);
        f32515d.put("darkgrey", -5658199);
        f32515d.put("darkkhaki", -4343957);
        f32515d.put("darkmagenta", -7667573);
        f32515d.put("darkolivegreen", -11179217);
        f32515d.put("darkorange", -29696);
        f32515d.put("darkorchid", -6737204);
        f32515d.put("darkred", -7667712);
        f32515d.put("darksalmon", -1468806);
        f32515d.put("darkseagreen", -7357297);
        f32515d.put("darkslateblue", -12042869);
        f32515d.put("darkslategray", -13676721);
        f32515d.put("darkslategrey", -13676721);
        f32515d.put("darkturquoise", -16724271);
        f32515d.put("darkviolet", -7077677);
        f32515d.put("deeppink", -60269);
        f32515d.put("deepskyblue", -16728065);
        f32515d.put("dimgray", -9868951);
        f32515d.put("dimgrey", -9868951);
        f32515d.put("dodgerblue", -14774017);
        f32515d.put("firebrick", -5103070);
        f32515d.put("floralwhite", -1296);
        f32515d.put("forestgreen", -14513374);
        f32515d.put("fuchsia", -65281);
        f32515d.put("gainsboro", -2302756);
        f32515d.put("ghostwhite", -460545);
        f32515d.put("gold", -10496);
        f32515d.put("goldenrod", -2448096);
        f32515d.put("gray", -8355712);
        f32515d.put("green", -16744448);
        f32515d.put("greenyellow", -5374161);
        f32515d.put("grey", -8355712);
        f32515d.put("honeydew", -983056);
        f32515d.put("hotpink", -38476);
        f32515d.put("indianred", -3318692);
        f32515d.put("indigo", -11861886);
        f32515d.put("ivory", -16);
        f32515d.put("khaki", -989556);
        f32515d.put("lavender", -1644806);
        f32515d.put("lavenderblush", -3851);
        f32515d.put("lawngreen", -8586240);
        f32515d.put("lemonchiffon", -1331);
        f32515d.put("lightblue", -5383962);
        f32515d.put("lightcoral", -1015680);
        f32515d.put("lightcyan", -2031617);
        f32515d.put("lightgoldenrodyellow", -329006);
        f32515d.put("lightgray", -2894893);
        f32515d.put("lightgreen", -7278960);
        f32515d.put("lightgrey", -2894893);
        f32515d.put("lightpink", -18751);
        f32515d.put("lightsalmon", -24454);
        f32515d.put("lightseagreen", -14634326);
        f32515d.put("lightskyblue", -7876870);
        f32515d.put("lightslategray", -8943463);
        f32515d.put("lightslategrey", -8943463);
        f32515d.put("lightsteelblue", -5192482);
        f32515d.put("lightyellow", -32);
        f32515d.put("lime", -16711936);
        f32515d.put("limegreen", -13447886);
        f32515d.put("linen", -331546);
        f32515d.put("magenta", -65281);
        f32515d.put("maroon", -8388608);
        f32515d.put("mediumaquamarine", -10039894);
        f32515d.put("mediumblue", -16777011);
        f32515d.put("mediumorchid", -4565549);
        f32515d.put("mediumpurple", -7114533);
        f32515d.put("mediumseagreen", -12799119);
        f32515d.put("mediumslateblue", -8689426);
        f32515d.put("mediumspringgreen", -16713062);
        f32515d.put("mediumturquoise", -12004916);
        f32515d.put("mediumvioletred", -3730043);
        f32515d.put("midnightblue", -15132304);
        f32515d.put("mintcream", -655366);
        f32515d.put("mistyrose", -6943);
        f32515d.put("moccasin", -6987);
        f32515d.put("navajowhite", -8531);
        f32515d.put("navy", -16777088);
        f32515d.put("oldlace", -133658);
        f32515d.put("olive", -8355840);
        f32515d.put("olivedrab", -9728477);
        f32515d.put("orange", -23296);
        f32515d.put("orangered", -47872);
        f32515d.put("orchid", -2461482);
        f32515d.put("palegoldenrod", -1120086);
        f32515d.put("palegreen", -6751336);
        f32515d.put("paleturquoise", -5247250);
        f32515d.put("palevioletred", -2396013);
        f32515d.put("papayawhip", -4139);
        f32515d.put("peachpuff", -9543);
        f32515d.put("peru", -3308225);
        f32515d.put("pink", -16181);
        f32515d.put("plum", -2252579);
        f32515d.put("powderblue", -5185306);
        f32515d.put("purple", -8388480);
        f32515d.put("rebeccapurple", -10079335);
        f32515d.put("red", -65536);
        f32515d.put("rosybrown", -4419697);
        f32515d.put("royalblue", -12490271);
        f32515d.put("saddlebrown", -7650029);
        f32515d.put("salmon", -360334);
        f32515d.put("sandybrown", -744352);
        f32515d.put("seagreen", -13726889);
        f32515d.put("seashell", -2578);
        f32515d.put("sienna", -6270419);
        f32515d.put("silver", -4144960);
        f32515d.put("skyblue", -7876885);
        f32515d.put("slateblue", -9807155);
        f32515d.put("slategray", -9404272);
        f32515d.put("slategrey", -9404272);
        f32515d.put("snow", -1286);
        f32515d.put("springgreen", -16711809);
        f32515d.put("steelblue", -12156236);
        f32515d.put("tan", -2968436);
        f32515d.put("teal", -16744320);
        f32515d.put("thistle", -2572328);
        f32515d.put("tomato", -40121);
        f32515d.put(H5Param.LONG_TRANSPARENT, 0);
        f32515d.put("turquoise", -12525360);
        f32515d.put("violet", -1146130);
        f32515d.put("wheat", -663885);
        f32515d.put("white", -1);
        f32515d.put("whitesmoke", -657931);
        f32515d.put("yellow", -256);
        f32515d.put("yellowgreen", -6632142);
    }

    public static int a(String str) {
        return a(str, false);
    }

    public static int b(String str) {
        return a(str, true);
    }

    private static int a(String str, boolean z) {
        int i2;
        a.a(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return -16777216 | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & PriceRangeSeekBar.INVALID_POINTER_ID) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? f32514c : f32513b).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    i2 = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                } else {
                    i2 = Integer.parseInt(matcher.group(4), 10);
                }
                return a(i2, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f32512a.matcher(replace);
            if (matcher2.matches()) {
                return a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = f32515d.get(ae.d(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int a(int i2, int i3, int i4) {
        return a(PriceRangeSeekBar.INVALID_POINTER_ID, i2, i3, i4);
    }
}
