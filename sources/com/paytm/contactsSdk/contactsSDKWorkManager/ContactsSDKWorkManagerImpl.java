package com.paytm.contactsSdk.contactsSDKWorkManager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.w;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.contactsSDKWorkManager.workerParameters.ContactsSDKWorkerParameters;
import com.paytm.utility.q;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upi.util.GAConstants;

public final class ContactsSDKWorkManagerImpl extends Thread implements ContactsSDKWorkManagerHelper {
    public static final Companion Companion = new Companion((g) null);
    public static final int MESSAGE_TYPE = 12;
    public static final String TAG = "ContactsSDKWorkManager";
    /* access modifiers changed from: private */
    public Context appContext;
    /* access modifiers changed from: private */
    public ContactsSDKWorkManagerHandler contactsSDKWorkManagerHandler;
    private boolean isManagerInitDone;

    public static final /* synthetic */ Context access$getAppContext$p(ContactsSDKWorkManagerImpl contactsSDKWorkManagerImpl) {
        Context context = contactsSDKWorkManagerImpl.appContext;
        if (context == null) {
            k.a("appContext");
        }
        return context;
    }

    public static final /* synthetic */ ContactsSDKWorkManagerHandler access$getContactsSDKWorkManagerHandler$p(ContactsSDKWorkManagerImpl contactsSDKWorkManagerImpl) {
        ContactsSDKWorkManagerHandler contactsSDKWorkManagerHandler2 = contactsSDKWorkManagerImpl.contactsSDKWorkManagerHandler;
        if (contactsSDKWorkManagerHandler2 == null) {
            k.a("contactsSDKWorkManagerHandler");
        }
        return contactsSDKWorkManagerHandler2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void initManager(Context context) {
        k.c(context, "appContext");
        if (!this.isManagerInitDone) {
            this.isManagerInitDone = true;
            this.appContext = context;
            start();
        }
    }

    public final void run() {
        StringBuilder sb = new StringBuilder("Running ContactsSDKWorkManager Thread -> ");
        Thread currentThread = Thread.currentThread();
        k.a((Object) currentThread, "currentThread()");
        sb.append(currentThread.getId());
        q.d(sb.toString());
        Looper.prepare();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            k.a((Object) myLooper, "it");
            Context context = this.appContext;
            if (context == null) {
                k.a("appContext");
            }
            this.contactsSDKWorkManagerHandler = new ContactsSDKWorkManagerHandler(myLooper, context);
        }
        Looper.loop();
    }

    private final void sendMessage(w wVar) {
        ContactsSDKWorkManagerImpl contactsSDKWorkManagerImpl = this;
        if (contactsSDKWorkManagerImpl.appContext == null) {
            q.b("ContactsSDKWorkManager init not called.");
        } else if (contactsSDKWorkManagerImpl.contactsSDKWorkManagerHandler == null) {
            q.b("ContactsSDKWorkManager handler not ready.");
        } else {
            ContactsSDKWorkManagerHandler contactsSDKWorkManagerHandler2 = this.contactsSDKWorkManagerHandler;
            if (contactsSDKWorkManagerHandler2 == null) {
                k.a("contactsSDKWorkManagerHandler");
            }
            Message obtain = Message.obtain(contactsSDKWorkManagerHandler2);
            obtain.what = 12;
            obtain.obj = wVar;
            ContactsSDKWorkManagerHandler contactsSDKWorkManagerHandler3 = this.contactsSDKWorkManagerHandler;
            if (contactsSDKWorkManagerHandler3 == null) {
                k.a("contactsSDKWorkManagerHandler");
            }
            contactsSDKWorkManagerHandler3.sendMessage(obtain);
        }
    }

    public final void enqueue(w wVar) {
        k.c(wVar, "workRequest");
        List singletonList = Collections.singletonList(wVar);
        k.a((Object) singletonList, "Collections.singletonList(workRequest)");
        enqueue((List<? extends w>) singletonList);
    }

    public final void enqueue(List<? extends w> list) {
        k.c(list, "workRequests");
        for (w sendMessage : list) {
            sendMessage(sendMessage);
        }
    }

    public static final class ContactsSDKWorkManagerHandler extends Handler {
        private final Context context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ContactsSDKWorkManagerHandler(Looper looper, Context context2) {
            super(looper);
            k.c(looper, "looper");
            k.c(context2, "context");
            this.context = context2;
        }

        public final void handleMessage(Message message) {
            String str;
            k.c(message, "msg");
            if (message.what == 12) {
                Object obj = message.obj;
                if (obj != null) {
                    w wVar = (w) obj;
                    if (wVar != null) {
                        String str2 = wVar.f5517b.f5182c;
                        k.a((Object) str2, "workerRequest.workSpec.workerClassName");
                        q.d("Parsing worker ".concat(String.valueOf(str2)));
                        Class<?> cls = Class.forName(str2);
                        k.a((Object) cls, "Class.forName(workerClassName)");
                        int i2 = 0;
                        Constructor<?> constructor = cls.getConstructor(new Class[]{Context.class, WorkerParameters.class});
                        k.a((Object) constructor, "workerClass.getConstruct…erParameters::class.java)");
                        Object newInstance = constructor.newInstance(new Object[]{this.context, ContactsSDKWorkerParameters.INSTANCE.getDefaultWorkerParameters()});
                        if (newInstance instanceof Worker) {
                            Object bVar = new ListenableWorker.a.b();
                            k.a(bVar, "ListenableWorker.Result.retry()");
                            while (k.a(bVar, (Object) new ListenableWorker.a.b()) && i2 < ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().workManagerRetryCount()) {
                                bVar = ((Worker) newInstance).doWork();
                                k.a(bVar, "worker.doWork()");
                                i2++;
                                StringBuilder sb = new StringBuilder("Work Completed Class(");
                                sb.append(str2);
                                sb.append(") with result = ");
                                if (k.a(bVar, (Object) new ListenableWorker.a.c())) {
                                    str = "success";
                                } else {
                                    str = k.a(bVar, (Object) new ListenableWorker.a.C0076a()) ? ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE : GAConstants.ACTION.RETRY;
                                }
                                sb.append(str);
                                q.d(sb.toString());
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.work.WorkRequest");
            }
        }
    }
}
