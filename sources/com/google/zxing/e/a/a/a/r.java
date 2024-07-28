package com.google.zxing.e.a.a.a;

import com.google.zxing.m;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.upi.util.UpiUtils;

final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f40331a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object[][] f40332b = {new Object[]{"00", 18}, new Object[]{WebLogin.RESPONSE_CODE_SUCCESS, 14}, new Object[]{"02", 14}, new Object[]{"10", f40331a, 20}, new Object[]{"11", 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{"17", 6}, new Object[]{"20", 2}, new Object[]{"21", f40331a, 20}, new Object[]{"22", f40331a, 29}, new Object[]{"30", f40331a, 8}, new Object[]{"37", f40331a, 8}, new Object[]{"90", f40331a, 30}, new Object[]{"91", f40331a, 30}, new Object[]{"92", f40331a, 30}, new Object[]{"93", f40331a, 30}, new Object[]{"94", f40331a, 30}, new Object[]{"95", f40331a, 30}, new Object[]{"96", f40331a, 30}, new Object[]{"97", f40331a, 30}, new Object[]{"98", f40331a, 30}, new Object[]{"99", f40331a, 30}};

    /* renamed from: c  reason: collision with root package name */
    private static final Object[][] f40333c = {new Object[]{"240", f40331a, 30}, new Object[]{"241", f40331a, 30}, new Object[]{"242", f40331a, 6}, new Object[]{"250", f40331a, 30}, new Object[]{"251", f40331a, 30}, new Object[]{"253", f40331a, 17}, new Object[]{"254", f40331a, 20}, new Object[]{"400", f40331a, 30}, new Object[]{UpiUtils.AUTHENTICATION_FAILURE_401, f40331a, 30}, new Object[]{"402", 17}, new Object[]{"403", f40331a, 30}, new Object[]{"410", 13}, new Object[]{"411", 13}, new Object[]{"412", 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", f40331a, 20}, new Object[]{"421", f40331a, 15}, new Object[]{"422", 3}, new Object[]{"423", f40331a, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};

    /* renamed from: d  reason: collision with root package name */
    private static final Object[][] f40334d = {new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{"320", 6}, new Object[]{"321", 6}, new Object[]{"322", 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{"326", 6}, new Object[]{"327", 6}, new Object[]{"328", 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{"360", 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", f40331a, 15}, new Object[]{"391", f40331a, 18}, new Object[]{"392", f40331a, 15}, new Object[]{"393", f40331a, 18}, new Object[]{"703", f40331a, 30}};

    /* renamed from: e  reason: collision with root package name */
    private static final Object[][] f40335e = {new Object[]{"7001", 13}, new Object[]{"7002", f40331a, 30}, new Object[]{"7003", 10}, new Object[]{"8001", 14}, new Object[]{"8002", f40331a, 20}, new Object[]{"8003", f40331a, 30}, new Object[]{"8004", f40331a, 30}, new Object[]{"8005", 6}, new Object[]{"8006", 18}, new Object[]{"8007", f40331a, 30}, new Object[]{"8008", f40331a, 12}, new Object[]{"8018", 18}, new Object[]{"8020", f40331a, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", f40331a, 70}, new Object[]{"8200", f40331a, 70}};

    static String a(String str) throws m {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() >= 2) {
            String substring = str.substring(0, 2);
            Object[][] objArr = f40332b;
            int length = objArr.length;
            int i2 = 0;
            while (i2 < length) {
                Object[] objArr2 = objArr[i2];
                if (!objArr2[0].equals(substring)) {
                    i2++;
                } else if (objArr2[1] == f40331a) {
                    return b(2, ((Integer) objArr2[2]).intValue(), str);
                } else {
                    return a(2, ((Integer) objArr2[1]).intValue(), str);
                }
            }
            if (str.length() >= 3) {
                String substring2 = str.substring(0, 3);
                Object[][] objArr3 = f40333c;
                int length2 = objArr3.length;
                int i3 = 0;
                while (i3 < length2) {
                    Object[] objArr4 = objArr3[i3];
                    if (!objArr4[0].equals(substring2)) {
                        i3++;
                    } else if (objArr4[1] == f40331a) {
                        return b(3, ((Integer) objArr4[2]).intValue(), str);
                    } else {
                        return a(3, ((Integer) objArr4[1]).intValue(), str);
                    }
                }
                Object[][] objArr5 = f40334d;
                int length3 = objArr5.length;
                int i4 = 0;
                while (i4 < length3) {
                    Object[] objArr6 = objArr5[i4];
                    if (!objArr6[0].equals(substring2)) {
                        i4++;
                    } else if (objArr6[1] == f40331a) {
                        return b(4, ((Integer) objArr6[2]).intValue(), str);
                    } else {
                        return a(4, ((Integer) objArr6[1]).intValue(), str);
                    }
                }
                if (str.length() >= 4) {
                    String substring3 = str.substring(0, 4);
                    Object[][] objArr7 = f40335e;
                    int length4 = objArr7.length;
                    int i5 = 0;
                    while (i5 < length4) {
                        Object[] objArr8 = objArr7[i5];
                        if (!objArr8[0].equals(substring3)) {
                            i5++;
                        } else if (objArr8[1] == f40331a) {
                            return b(4, ((Integer) objArr8[2]).intValue(), str);
                        } else {
                            return a(4, ((Integer) objArr8[1]).intValue(), str);
                        }
                    }
                    throw m.getNotFoundInstance();
                }
                throw m.getNotFoundInstance();
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private static String a(int i2, int i3, String str) throws m {
        if (str.length() >= i2) {
            String substring = str.substring(0, i2);
            int i4 = i3 + i2;
            if (str.length() >= i4) {
                String substring2 = str.substring(i2, i4);
                String str2 = "(" + substring + ')' + substring2;
                String a2 = a(str.substring(i4));
                if (a2 == null) {
                    return str2;
                }
                return str2 + a2;
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private static String b(int i2, int i3, String str) throws m {
        String substring = str.substring(0, i2);
        int i4 = i3 + i2;
        if (str.length() < i4) {
            i4 = str.length();
        }
        String substring2 = str.substring(i2, i4);
        String str2 = "(" + substring + ')' + substring2;
        String a2 = a(str.substring(i4));
        if (a2 == null) {
            return str2;
        }
        return str2 + a2;
    }
}
