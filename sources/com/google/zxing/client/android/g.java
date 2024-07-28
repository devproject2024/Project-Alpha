package com.google.zxing.client.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.zxing.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40225a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f40226b = Pattern.compile(AppConstants.COMMA);

    private g() {
    }

    public static Map<e, ?> a(Uri uri) {
        String str;
        String str2;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null || encodedQuery.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (true) {
            if (i2 >= encodedQuery.length()) {
                break;
            } else if (encodedQuery.charAt(i2) == '&') {
                i2++;
            } else {
                int indexOf = encodedQuery.indexOf(38, i2);
                int indexOf2 = encodedQuery.indexOf(61, i2);
                String str3 = "";
                if (indexOf < 0) {
                    if (indexOf2 < 0) {
                        str2 = Uri.decode(encodedQuery.substring(i2).replace('+', ' '));
                    } else {
                        String decode = Uri.decode(encodedQuery.substring(i2, indexOf2).replace('+', ' '));
                        str3 = Uri.decode(encodedQuery.substring(indexOf2 + 1).replace('+', ' '));
                        str2 = decode;
                    }
                    if (!hashMap.containsKey(str2)) {
                        hashMap.put(str2, str3);
                    }
                } else {
                    if (indexOf2 < 0 || indexOf2 > indexOf) {
                        String decode2 = Uri.decode(encodedQuery.substring(i2, indexOf).replace('+', ' '));
                        if (!hashMap.containsKey(decode2)) {
                            hashMap.put(decode2, str3);
                        }
                    } else {
                        String decode3 = Uri.decode(encodedQuery.substring(i2, indexOf2).replace('+', ' '));
                        String decode4 = Uri.decode(encodedQuery.substring(indexOf2 + 1, indexOf).replace('+', ' '));
                        if (!hashMap.containsKey(decode3)) {
                            hashMap.put(decode3, decode4);
                        }
                    }
                    i2 = indexOf + 1;
                }
            }
        }
        EnumMap enumMap = new EnumMap(e.class);
        for (e eVar : e.values()) {
            if (!(eVar == e.CHARACTER_SET || eVar == e.NEED_RESULT_POINT_CALLBACK || eVar == e.POSSIBLE_FORMATS || (str = (String) hashMap.get(eVar.name())) == null)) {
                if (eVar.getValueType().equals(Object.class)) {
                    enumMap.put(eVar, str);
                } else if (eVar.getValueType().equals(Void.class)) {
                    enumMap.put(eVar, Boolean.TRUE);
                } else if (eVar.getValueType().equals(String.class)) {
                    enumMap.put(eVar, str);
                } else if (eVar.getValueType().equals(Boolean.class)) {
                    if (str.isEmpty()) {
                        enumMap.put(eVar, Boolean.TRUE);
                    } else if ("0".equals(str) || "false".equalsIgnoreCase(str) || "no".equalsIgnoreCase(str)) {
                        enumMap.put(eVar, Boolean.FALSE);
                    } else {
                        enumMap.put(eVar, Boolean.TRUE);
                    }
                } else if (eVar.getValueType().equals(int[].class)) {
                    if (!str.isEmpty() && str.charAt(str.length() - 1) == ',') {
                        str = str.substring(0, str.length() - 1);
                    }
                    String[] split = f40226b.split(str);
                    int[] iArr = new int[split.length];
                    int i3 = 0;
                    while (i3 < split.length) {
                        try {
                            iArr[i3] = Integer.parseInt(split[i3]);
                            i3++;
                        } catch (NumberFormatException unused) {
                            StringBuilder sb = new StringBuilder("Skipping array of integers hint ");
                            sb.append(eVar);
                            sb.append(" due to invalid numeric value: '");
                            sb.append(split[i3]);
                            sb.append('\'');
                            iArr = null;
                        }
                    }
                    if (iArr != null) {
                        enumMap.put(eVar, iArr);
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder("Unsupported hint type '");
                    sb2.append(eVar);
                    sb2.append("' of type ");
                    sb2.append(eVar.getValueType());
                }
            }
        }
        new StringBuilder("Hints from the URI: ").append(enumMap);
        return enumMap;
    }

    static Map<e, Object> a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(e.class);
        for (e eVar : e.values()) {
            if (!(eVar == e.CHARACTER_SET || eVar == e.NEED_RESULT_POINT_CALLBACK || eVar == e.POSSIBLE_FORMATS)) {
                String name = eVar.name();
                if (extras.containsKey(name)) {
                    if (eVar.getValueType().equals(Void.class)) {
                        enumMap.put(eVar, Boolean.TRUE);
                    } else {
                        Object obj = extras.get(name);
                        if (eVar.getValueType().isInstance(obj)) {
                            enumMap.put(eVar, obj);
                        } else {
                            StringBuilder sb = new StringBuilder("Ignoring hint ");
                            sb.append(eVar);
                            sb.append(" because it is not assignable from ");
                            sb.append(obj);
                        }
                    }
                }
            }
        }
        new StringBuilder("Hints from the Intent: ").append(enumMap);
        return enumMap;
    }
}
