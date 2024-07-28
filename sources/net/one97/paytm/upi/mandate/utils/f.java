package net.one97.paytm.upi.mandate.utils;

import java.util.ArrayList;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Integer[] f67395a = {1, 1, 1, 2, 2, 3, 5, 5, 5, 5, 5, 5, 5};

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<String> f67396b = new a();

    public static final boolean a(int i2) {
        return i2 > 0;
    }

    public static final Integer[] a() {
        return f67395a;
    }

    public static final class a extends ArrayList<String> {
        a() {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return contains((String) obj);
        }

        public final /* bridge */ boolean contains(String str) {
            return super.contains(str);
        }

        public final int getSize() {
            return super.size();
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return indexOf((String) obj);
        }

        public final /* bridge */ int indexOf(String str) {
            return super.indexOf(str);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return lastIndexOf((String) obj);
        }

        public final /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf(str);
        }

        public final String remove(int i2) {
            return removeAt(i2);
        }

        public final /* bridge */ boolean remove(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return remove((String) obj);
        }

        public final /* bridge */ boolean remove(String str) {
            return super.remove(str);
        }

        public final String removeAt(int i2) {
            return (String) super.remove(i2);
        }

        public final int size() {
            return getSize();
        }
    }

    public static final ArrayList<String> b() {
        return f67396b;
    }
}
