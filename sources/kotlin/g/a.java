package kotlin.g;

import kotlin.g.b.d;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.k.c;

public final class a {
    public static final <T> Class<T> a(c<T> cVar) {
        k.d(cVar, "$this$java");
        Class<?> a2 = ((d) cVar).a();
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static final <T> Class<T> b(c<T> cVar) {
        k.d(cVar, "$this$javaObjectType");
        Class a2 = ((d) cVar).a();
        if (a2.isPrimitive()) {
            String name = a2.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            a2 = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            a2 = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            a2 = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            a2 = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            a2 = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            a2 = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            a2 = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            a2 = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            a2 = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (a2 != null) {
                return a2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        } else if (a2 != null) {
            return a2;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    public static final <T> c<T> a(Class<T> cls) {
        k.d(cls, "$this$kotlin");
        return y.b(cls);
    }

    public static final <T> Class<T> a(T t) {
        k.d(t, "$this$javaClass");
        Class<?> cls = t.getClass();
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
    }
}
