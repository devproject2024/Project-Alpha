package net.one97.paytm.h5paytmsdk.b;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.io.File;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.h5paytmsdk.c.a.c;
import net.one97.paytm.h5paytmsdk.c.a.d;
import net.one97.paytm.phoenix.provider.download.FileDownloadErrorCodesKt;

public final class m extends ad {
    public m() {
        super("paytmDownloadFile", "paytmGetFilePath", "paytmRemoveFile");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (a(h5Event)) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            String str = null;
            d dVar = (d) (providerManager != null ? providerManager.getProvider(d.class.getName()) : null);
            if (dVar != null) {
                if (h5Event == null) {
                    k.a();
                }
                String action = h5Event.getAction();
                String string = h5Event.getParam().getString(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                Boolean bool = h5Event.getParam().getBoolean("useExternalStorage");
                boolean booleanValue = bool != null ? bool.booleanValue() : false;
                Context activity = h5Event.getActivity();
                if (string == null || activity == null) {
                    if (h5BridgeContext != null) {
                        h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
                    }
                } else if (action != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1959423658) {
                        if (hashCode != 991648801) {
                            if (hashCode == 1836355045 && action.equals("paytmDownloadFile")) {
                                String string2 = h5Event.getParam().getString("fileDownloadUrl");
                                if (string2 == null) {
                                    if (h5BridgeContext != null) {
                                        h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
                                    }
                                    return true;
                                }
                                Context context = activity;
                                d.c aVar = new a(this, h5Event, h5BridgeContext);
                                k.c(context, "context");
                                k.c(string, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                                k.c(string2, "fileDownloadUrl");
                                k.c(aVar, "downloadHandler");
                                if (booleanValue && !d.a(context)) {
                                    aVar.a(string, string2, (String) null, d.b());
                                } else if (!booleanValue || d.a()) {
                                    String absolutePath = d.a(context, booleanValue, string).getAbsolutePath();
                                    c.a dVar2 = new d.C0258d(absolutePath, aVar, string, string2);
                                    k.a((Object) absolutePath, "outputFilePath");
                                    new c(string2, absolutePath, dVar2).execute(new Void[0]);
                                } else {
                                    aVar.a(string, string2, (String) null, d.c());
                                }
                            }
                        } else if (action.equals("paytmRemoveFile")) {
                            Context context2 = activity;
                            d.b bVar = new b(this, h5Event, h5BridgeContext);
                            k.c(context2, "context");
                            k.c(string, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                            k.c(bVar, "deletionHandler");
                            AsyncTask.execute(new d.e(dVar, context2, string, booleanValue, bVar));
                        }
                    } else if (action.equals("paytmGetFilePath")) {
                        Context context3 = activity;
                        k.c(context3, "context");
                        k.c(string, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                        File a2 = d.a(context3, booleanValue, string);
                        if (a2.exists()) {
                            str = a2.getAbsolutePath();
                        }
                        e eVar = new e();
                        if (str != null) {
                            Map map = eVar;
                            map.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, str);
                            map.put("success", Boolean.TRUE);
                        } else {
                            e eVar2 = new e();
                            eVar2.put("code", (Object) 6);
                            eVar2.put("message", (Object) FileDownloadErrorCodesKt.FILE_NOT_FOUND_ERR_MSG);
                            eVar.put("error", (Object) eVar2);
                            eVar.put("success", (Object) Boolean.FALSE);
                        }
                        b(h5BridgeContext, eVar);
                    }
                }
            }
        }
        return true;
    }

    public static final class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f17027a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f17028b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f17029c;

        a(m mVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f17027a = mVar;
            this.f17028b = h5Event;
            this.f17029c = h5BridgeContext;
        }

        public final void a(String str, String str2, String str3, net.one97.paytm.h5paytmsdk.c.a.a aVar) {
            k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            k.c(str2, "fileDownloadUrl");
            m.a(this.f17029c, str, str3, str2, aVar);
        }
    }

    public static final class b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f17030a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f17031b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f17032c;

        b(m mVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f17030a = mVar;
            this.f17031b = h5Event;
            this.f17032c = h5BridgeContext;
        }

        public final void a(String str, net.one97.paytm.h5paytmsdk.c.a.a aVar) {
            k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            e eVar = new e();
            if (aVar == null) {
                eVar.put("success", (Object) "true");
            } else {
                eVar.put("success", (Object) "false");
                e eVar2 = new e();
                eVar2.put("code", (Object) Integer.valueOf(aVar.f17072a));
                eVar2.put("message", (Object) aVar.f17073b);
                eVar.put("error", (Object) eVar2);
            }
            m.b(this.f17032c, eVar);
        }
    }

    /* access modifiers changed from: private */
    public static void b(H5BridgeContext h5BridgeContext, e eVar) {
        e eVar2 = new e();
        eVar2.put("data", eVar);
        if (h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult(eVar2);
        }
    }

    public static final /* synthetic */ void a(H5BridgeContext h5BridgeContext, String str, String str2, String str3, net.one97.paytm.h5paytmsdk.c.a.a aVar) {
        e eVar = new e();
        if (str != null) {
            eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, (Object) str);
        }
        if (str3 != null) {
            eVar.put("fileDownloadUrl", (Object) str3);
        }
        if (str2 != null) {
            eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, (Object) str2);
        }
        if (aVar != null) {
            e eVar2 = new e();
            eVar2.put("code", (Object) Integer.valueOf(aVar.f17072a));
            eVar2.put("message", (Object) aVar.f17073b);
            eVar.put("error", (Object) eVar2);
            eVar.put("success", (Object) Boolean.FALSE);
        } else {
            eVar.put("success", (Object) Boolean.TRUE);
        }
        b(h5BridgeContext, eVar);
    }
}
