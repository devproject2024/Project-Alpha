package com.google.a.a.c;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i implements Serializable {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final Pattern RFC3339_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private static final long serialVersionUID = 1;
    private final boolean dateOnly;
    private final int tzShift;
    private final long value;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i(Date date, TimeZone timeZone) {
        this(false, date.getTime(), timeZone == null ? null : Integer.valueOf(timeZone.getOffset(date.getTime()) / 60000));
    }

    public i(long j) {
        this(false, j, (Integer) null);
    }

    public i(Date date) {
        this(date.getTime());
    }

    public i(long j, int i2) {
        this(false, j, Integer.valueOf(i2));
    }

    public i(boolean z, long j, Integer num) {
        int i2;
        this.dateOnly = z;
        this.value = j;
        if (z) {
            i2 = 0;
        } else {
            i2 = num == null ? TimeZone.getDefault().getOffset(j) / 60000 : num.intValue();
        }
        this.tzShift = i2;
    }

    public i(String str) {
        i parseRfc3339 = parseRfc3339(str);
        this.dateOnly = parseRfc3339.dateOnly;
        this.value = parseRfc3339.value;
        this.tzShift = parseRfc3339.tzShift;
    }

    public final long getValue() {
        return this.value;
    }

    public final boolean isDateOnly() {
        return this.dateOnly;
    }

    public final int getTimeZoneShift() {
        return this.tzShift;
    }

    public final String toStringRfc3339() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT);
        gregorianCalendar.setTimeInMillis(this.value + (((long) this.tzShift) * 60000));
        appendInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        appendInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        appendInt(sb, gregorianCalendar.get(5), 2);
        if (!this.dateOnly) {
            sb.append('T');
            appendInt(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            appendInt(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            appendInt(sb, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb.append('.');
                appendInt(sb, gregorianCalendar.get(14), 3);
            }
            int i2 = this.tzShift;
            if (i2 == 0) {
                sb.append('Z');
            } else {
                if (i2 > 0) {
                    sb.append('+');
                } else {
                    sb.append('-');
                    i2 = -i2;
                }
                appendInt(sb, i2 / 60, 2);
                sb.append(':');
                appendInt(sb, i2 % 60, 2);
            }
        }
        return sb.toString();
    }

    public final String toString() {
        return toStringRfc3339();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.dateOnly == iVar.dateOnly && this.value == iVar.value && this.tzShift == iVar.tzShift;
    }

    public final int hashCode() {
        long[] jArr = new long[3];
        jArr[0] = this.value;
        jArr[1] = this.dateOnly ? 1 : 0;
        jArr[2] = (long) this.tzShift;
        return Arrays.hashCode(jArr);
    }

    public static i parseRfc3339(String str) throws NumberFormatException {
        int i2;
        int i3;
        int i4;
        int i5;
        Matcher matcher = RFC3339_PATTERN.matcher(str);
        if (matcher.matches()) {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2)) - 1;
            int parseInt3 = Integer.parseInt(matcher.group(3));
            int i6 = 0;
            boolean z = matcher.group(4) != null;
            String group = matcher.group(9);
            boolean z2 = group != null;
            Integer num = null;
            if (!z2 || z) {
                if (z) {
                    int parseInt4 = Integer.parseInt(matcher.group(5));
                    int parseInt5 = Integer.parseInt(matcher.group(6));
                    int parseInt6 = Integer.parseInt(matcher.group(7));
                    if (matcher.group(8) != null) {
                        i3 = parseInt6;
                        i5 = parseInt4;
                        i2 = Integer.parseInt(matcher.group(8).substring(1));
                        i4 = parseInt5;
                    } else {
                        i4 = parseInt5;
                        i3 = parseInt6;
                        i5 = parseInt4;
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                    i5 = 0;
                    i4 = 0;
                    i3 = 0;
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT);
                gregorianCalendar.set(parseInt, parseInt2, parseInt3, i5, i4, i3);
                gregorianCalendar.set(14, i2);
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (z && z2) {
                    if (Character.toUpperCase(group.charAt(0)) != 'Z') {
                        int parseInt7 = (Integer.parseInt(matcher.group(11)) * 60) + Integer.parseInt(matcher.group(12));
                        if (matcher.group(10).charAt(0) == '-') {
                            parseInt7 = -parseInt7;
                        }
                        i6 = parseInt7;
                        timeInMillis -= ((long) i6) * 60000;
                    }
                    num = Integer.valueOf(i6);
                }
                return new i(!z, timeInMillis, num);
            }
            throw new NumberFormatException("Invalid date/time format, cannot specify time zone shift without specifying time: ".concat(String.valueOf(str)));
        }
        throw new NumberFormatException("Invalid date/time format: ".concat(String.valueOf(str)));
    }

    private static void appendInt(StringBuilder sb, int i2, int i3) {
        if (i2 < 0) {
            sb.append('-');
            i2 = -i2;
        }
        int i4 = i3;
        int i5 = i2;
        while (i5 > 0) {
            i5 /= 10;
            i4--;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            sb.append('0');
        }
        if (i2 != 0) {
            sb.append(i2);
        }
    }
}
