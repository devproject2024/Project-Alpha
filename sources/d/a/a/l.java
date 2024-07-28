package d.a.a;

import com.business.merchant_payments.common.utility.AppUtility;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, List<k>> f45988a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Class<?>> f45989b = new ConcurrentHashMap();

    l(List<Class<?>> list) {
        if (list != null) {
            for (Class next : list) {
                this.f45989b.put(next, next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final List<k> a(Class<?> cls) {
        List<k> list;
        n nVar;
        String name = cls.getName();
        synchronized (f45988a) {
            list = f45988a.get(name);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name2 = cls2.getName();
            if (name2.startsWith("java.") || name2.startsWith("javax.") || name2.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name3 = method.getName();
                if (name3.startsWith("onEvent")) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                        Class[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            String substring = name3.substring(7);
                            if (substring.length() == 0) {
                                nVar = n.PostThread;
                            } else if (substring.equals("MainThread")) {
                                nVar = n.MainThread;
                            } else if (substring.equals("BackgroundThread")) {
                                nVar = n.BackgroundThread;
                            } else if (substring.equals("Async")) {
                                nVar = n.Async;
                            } else if (!this.f45989b.containsKey(cls2)) {
                                throw new e("Illegal onEvent method, check for typos: ".concat(String.valueOf(method)));
                            }
                            Class cls3 = parameterTypes[0];
                            sb.setLength(0);
                            sb.append(name3);
                            sb.append('>');
                            sb.append(cls3.getName());
                            if (hashSet.add(sb.toString())) {
                                arrayList.add(new k(method, nVar, cls3));
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f45989b.containsKey(cls2)) {
                        String str = c.f45942a;
                        StringBuilder sb2 = new StringBuilder("Skipping method (not public, static or abstract): ");
                        sb2.append(cls2);
                        sb2.append(AppUtility.CENTER_DOT);
                        sb2.append(name3);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (f45988a) {
                f45988a.put(name, arrayList);
            }
            return arrayList;
        }
        throw new e("Subscriber " + cls + " has no public methods called onEvent");
    }
}
