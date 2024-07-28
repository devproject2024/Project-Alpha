package com.paytmmall.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.paytm.utility.q;
import com.paytmmall.artifact.d.p;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.y;
import java.util.HashMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static String f15371a = "H5GetImagePlugin";

    /* renamed from: b  reason: collision with root package name */
    private static H5Event f15372b;

    /* renamed from: c  reason: collision with root package name */
    private static b f15373c;

    public f() {
        super("mpGetImageEvents");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        if (!(h5Event == null || h5Event.getActivity() == null)) {
            f15373c = bVar;
            f15372b = h5Event;
            Activity activity = h5Event.getActivity();
            if (y.a()) {
                boolean z = false;
                if (androidx.core.app.a.a((Context) activity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                    if (androidx.core.app.a.a((Context) activity, "android.permission.CAMERA") == 0) {
                        z = true;
                    }
                    if (z) {
                        t.e().openImageCropActivity(activity, true, true);
                    }
                }
            }
        }
        return super.a(h5Event, bVar);
    }

    public static void a(int i2, Bundle bundle) {
        JSONObject jSONObject;
        b bVar = f15373c;
        if (bVar != null) {
            H5Event h5Event = f15372b;
            if (bundle == null) {
                jSONObject = null;
            } else {
                Object a2 = p.a(i2, bundle);
                jSONObject = new JSONObject();
                if (a2 instanceof HashMap) {
                    HashMap hashMap = (HashMap) a2;
                    if (hashMap.get("status").equals("success")) {
                        if (hashMap.get("status").equals("success")) {
                            jSONObject = a(hashMap);
                        }
                    }
                }
                if (a2 instanceof JSONObject) {
                    jSONObject = a((JSONObject) a2);
                }
            }
            bVar.a(h5Event, jSONObject);
            f15373c = null;
        }
    }

    private static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("status", ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            jSONObject2.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, jSONObject.get(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT));
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject2;
    }

    private static JSONObject a(HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_TYPE, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE));
            jSONObject.put("status", hashMap.get("status"));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_BASE_64, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_STREAM));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_EXT, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_EXT));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_SIZE, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
