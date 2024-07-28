package okhttp3;

import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Headers {
    private final String[] namesAndValues;

    Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final String get(String str) {
        return get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final String name(int i2) {
        return this.namesAndValues[i2 * 2];
    }

    public final String value(int i2) {
        return this.namesAndValues[(i2 * 2) + 1];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            treeSet.add(name(i2));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public final List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase(name(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = (long) (strArr.length * 2);
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            length += (long) this.namesAndValues[i2].length();
        }
        return length;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(name(i2));
            sb.append(": ");
            sb.append(value(i2));
            sb.append(StringUtility.NEW_LINE);
        }
        return sb.toString();
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String lowerCase = name(i2).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i2));
        }
        return treeMap;
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static Headers of(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i2 = 0;
            while (i2 < strArr2.length) {
                if (strArr2[i2] != null) {
                    strArr2[i2] = strArr2[i2].trim();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                String str = strArr2[i3];
                String str2 = strArr2[i3 + 1];
                checkName(str);
                checkValue(str2, str);
            }
            return new Headers(strArr2);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }

    public static Headers of(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[(map.size() * 2)];
            int i2 = 0;
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() == null || next.getValue() == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                String trim = ((String) next.getKey()).trim();
                String trim2 = ((String) next.getValue()).trim();
                checkName(trim);
                checkValue(trim2, trim);
                strArr[i2] = trim;
                strArr[i2 + 1] = trim2;
                i2 += 2;
            }
            return new Headers(strArr);
        }
        throw new NullPointerException("headers == null");
    }

    static void checkName(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    static void checkValue(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i2++;
                } else {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

        /* access modifiers changed from: package-private */
        public final Builder addLenient(String str) {
            int indexOf = str.indexOf(AppConstants.COLON, 1);
            if (indexOf != -1) {
                return addLenient(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(AppConstants.COLON)) {
                return addLenient("", str.substring(1));
            }
            return addLenient("", str);
        }

        public final Builder add(String str) {
            int indexOf = str.indexOf(AppConstants.COLON);
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: ".concat(String.valueOf(str)));
        }

        public final Builder add(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            return addLenient(str, str2);
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            Headers.checkName(str);
            return addLenient(str, str2);
        }

        public final Builder addAll(Headers headers) {
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                addLenient(headers.name(i2), headers.value(i2));
            }
            return this;
        }

        public final Builder add(String str, Date date) {
            if (date != null) {
                add(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        public final Builder set(String str, Date date) {
            if (date != null) {
                set(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        /* access modifiers changed from: package-private */
        public final Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public final Builder removeAll(String str) {
            int i2 = 0;
            while (i2 < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i2))) {
                    this.namesAndValues.remove(i2);
                    this.namesAndValues.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public final Builder set(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public final String get(String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                    return this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public final Headers build() {
            return new Headers(this);
        }
    }
}
