package androidx.customview.a;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

final class b {

    public interface a<T> {
        void a(T t, Rect rect);
    }

    /* renamed from: androidx.customview.a.b$b  reason: collision with other inner class name */
    public interface C0053b<T, V> {
        int a(T t);

        V a(T t, int i2);
    }

    private static int a(int i2, int i3) {
        return (i2 * 13 * i2) + (i3 * i3);
    }

    public static <L, T> T a(L l, C0053b<L, T> bVar, a<T> aVar, T t, int i2, boolean z) {
        int a2 = bVar.a(l);
        ArrayList arrayList = new ArrayList(a2);
        for (int i3 = 0; i3 < a2; i3++) {
            arrayList.add(bVar.a(l, i3));
        }
        Collections.sort(arrayList, new c(z, aVar));
        if (i2 == 1) {
            return b(t, arrayList);
        }
        if (i2 == 2) {
            return a(t, arrayList);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T a(T t, ArrayList<T> arrayList) {
        int i2;
        int size = arrayList.size();
        if (t == null) {
            i2 = -1;
        } else {
            i2 = arrayList.lastIndexOf(t);
        }
        int i3 = i2 + 1;
        if (i3 < size) {
            return arrayList.get(i3);
        }
        return null;
    }

    private static <T> T b(T t, ArrayList<T> arrayList) {
        int size = arrayList.size();
        if (t != null) {
            size = arrayList.indexOf(t);
        }
        int i2 = size - 1;
        if (i2 >= 0) {
            return arrayList.get(i2);
        }
        return null;
    }

    static class c<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f3230a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final Rect f3231b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final boolean f3232c;

        /* renamed from: d  reason: collision with root package name */
        private final a<T> f3233d;

        c(boolean z, a<T> aVar) {
            this.f3232c = z;
            this.f3233d = aVar;
        }

        public final int compare(T t, T t2) {
            Rect rect = this.f3230a;
            Rect rect2 = this.f3231b;
            this.f3233d.a(t, rect);
            this.f3233d.a(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                if (this.f3232c) {
                    return 1;
                }
                return -1;
            } else if (rect.left > rect2.left) {
                if (this.f3232c) {
                    return -1;
                }
                return 1;
            } else if (rect.bottom < rect2.bottom) {
                return -1;
            } else {
                if (rect.bottom > rect2.bottom) {
                    return 1;
                }
                if (rect.right < rect2.right) {
                    if (this.f3232c) {
                        return 1;
                    }
                    return -1;
                } else if (rect.right <= rect2.right) {
                    return 0;
                } else {
                    if (this.f3232c) {
                        return -1;
                    }
                    return 1;
                }
            }
        }
    }

    public static <L, T> T a(L l, C0053b<L, T> bVar, a<T> aVar, T t, Rect rect, int i2) {
        boolean z;
        L l2 = l;
        C0053b<L, T> bVar2 = bVar;
        Rect rect2 = rect;
        int i3 = i2;
        Rect rect3 = new Rect(rect2);
        if (i3 == 17) {
            rect3.offset(rect.width() + 1, 0);
        } else if (i3 == 33) {
            rect3.offset(0, rect.height() + 1);
        } else if (i3 == 66) {
            rect3.offset(-(rect.width() + 1), 0);
        } else if (i3 == 130) {
            rect3.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int a2 = bVar2.a(l2);
        Rect rect4 = new Rect();
        T t2 = null;
        for (int i4 = 0; i4 < a2; i4++) {
            T a3 = bVar2.a(l2, i4);
            a<T> aVar2 = aVar;
            if (a3 != t) {
                aVar2.a(a3, rect4);
                if (!a(rect2, rect4, i3) || (a(rect2, rect3, i3) && !a(i3, rect2, rect4, rect3) && (a(i3, rect2, rect3, rect4) || a(c(i3, rect2, rect4), g(i3, rect2, rect4)) >= a(c(i3, rect2, rect3), g(i3, rect2, rect3))))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    rect3.set(rect4);
                    t2 = a3;
                }
            }
        }
        return t2;
    }

    private static boolean a(int i2, Rect rect, Rect rect2, Rect rect3) {
        boolean a2 = a(i2, rect, rect2);
        if (a(i2, rect, rect3) || !a2) {
            return false;
        }
        if (b(i2, rect, rect3) && i2 != 17 && i2 != 66 && c(i2, rect, rect2) >= e(i2, rect, rect3)) {
            return false;
        }
        return true;
    }

    private static boolean a(Rect rect, Rect rect2, int i2) {
        if (i2 == 17) {
            return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
        }
        if (i2 == 33) {
            return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
        }
        if (i2 == 66) {
            return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
        }
        if (i2 == 130) {
            return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean a(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    private static boolean b(int i2, Rect rect, Rect rect2) {
        if (i2 == 17) {
            return rect.left >= rect2.right;
        }
        if (i2 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i2 == 66) {
            return rect.right <= rect2.left;
        }
        if (i2 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int c(int i2, Rect rect, Rect rect2) {
        return Math.max(0, d(i2, rect, rect2));
    }

    private static int d(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.top;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int e(int i2, Rect rect, Rect rect2) {
        return Math.max(1, f(i2, rect, rect2));
    }

    private static int f(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.left;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.top;
        } else if (i2 == 66) {
            i3 = rect2.right;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.bottom;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int g(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
