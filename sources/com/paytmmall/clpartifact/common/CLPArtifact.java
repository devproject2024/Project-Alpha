package com.paytmmall.clpartifact.common;

import android.content.Context;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import java.lang.reflect.InvocationTargetException;

public class CLPArtifact {
    public static boolean isDebug;
    private static volatile CLPArtifact mInstance;
    private static Object mutex = new Object();
    private ICLPCommunicationListener mCommunicationListener;
    private Context mContext;

    private CLPArtifact(Context context, ICLPCommunicationListener iCLPCommunicationListener) {
        this.mCommunicationListener = iCLPCommunicationListener;
        this.mContext = context;
    }

    public static CLPArtifact init(Context context, ICLPCommunicationListener iCLPCommunicationListener) {
        if (mInstance == null) {
            mInstance = new CLPArtifact(context, iCLPCommunicationListener);
            isDebug = iCLPCommunicationListener.isDebug();
        }
        return mInstance;
    }

    public static boolean isCLPListenerAvailable() {
        return (getInstance() == null || getInstance().getCommunicationListener() == null) ? false : true;
    }

    public ICLPCommunicationListener getCommunicationListener() {
        if (this.mCommunicationListener == null) {
            try {
                this.mCommunicationListener = recoverCommListener();
                throw showNotInitException();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        return this.mCommunicationListener;
    }

    public static CLPArtifact getInstance() {
        if (mInstance == null) {
            synchronized (mutex) {
                try {
                    if (mInstance == null) {
                        recoverInstance();
                    }
                    throw showNotInitException();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return mInstance;
    }

    private static void recoverInstance() {
        init(recoverAppContext(), recoverCommListener());
    }

    private static ICLPCommunicationListener recoverCommListener() {
        ICLPCommunicationListener recoverListener = recoverListener("net.one97.paytm.storefront.CLPCommunicationListenerImpl");
        if (recoverListener == null) {
            recoverListener = recoverListener("com.paytm.business.homepage.view.listener.StorefrontCommunicationImpl");
        }
        return recoverListener == null ? recoverListener("com.paytm.storefrontsdkApp.ClpCommunicationListener") : recoverListener;
    }

    private static ICLPCommunicationListener recoverListener(String str) {
        try {
            return (ICLPCommunicationListener) Class.forName(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static Context recoverAppContext() {
        Context recoverContext = recoverContext("net.one97.paytm.app.CJRJarvisApplication");
        if (recoverContext == null) {
            recoverContext = recoverContext("com.paytm.business.homepage.view.listener.StorefrontCommunicationImpl");
        }
        return recoverContext == null ? recoverContext("com.paytm.storefrontsdkApp.SFApplication") : recoverContext;
    }

    private static Context recoverContext(String str) {
        try {
            return (Context) Class.forName(str).getDeclaredMethod("getAppContext", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        } catch (ClassCastException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static IllegalAccessException showNotInitException() {
        return new IllegalAccessException("CLPArtifact init is not called");
    }

    public Context getContext() {
        return this.mContext;
    }
}
