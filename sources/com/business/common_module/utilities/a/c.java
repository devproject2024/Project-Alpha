package com.business.common_module.utilities.a;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import java.lang.reflect.InvocationTargetException;

public abstract class c extends androidx.lifecycle.a {
    public Application mAppInstance;

    public abstract void initDefaultParams();

    public c(Application application) {
        super(application);
        this.mAppInstance = application;
        initDefaultParams();
    }

    public Context getContext() {
        return this.mAppInstance.getApplicationContext();
    }

    public static class a extends al.d {

        /* renamed from: a  reason: collision with root package name */
        private final Application f7361a;

        public a(Application application) {
            this.f7361a = application;
        }

        public final <T extends ai> T create(Class<T> cls) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ai) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f7361a});
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e5);
            }
        }
    }
}
