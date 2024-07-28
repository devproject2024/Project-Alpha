package com.sendbird.android.shadow.com.google.gson.internal.reflect;

import com.sendbird.android.shadow.com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance = (JavaVersion.getMajorJavaVersion() < 9 ? new a() : new b());

    public abstract void makeAccessible(AccessibleObject accessibleObject);

    public static ReflectionAccessor getInstance() {
        return instance;
    }
}
