package net.one97.paytm.dynamic.module.fastag.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.landingpage.utils.croptool.CropImage;
import net.one97.paytm.landingpage.utils.croptool.CropImageActivity;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class FastagImageCropHelper {
    public static Intent getCropImageIntent(Activity activity) {
        Intent a2 = CropImage.a((Uri) null).a(CropImageView.c.ON).a(activity, CropImageActivity.class);
        a2.putExtra("is_camera_needed", true);
        a2.putExtra("is_gallery_neeedd", true);
        return a2;
    }

    public static JSONObject sendImagePickerResult(Context context, int i2, Intent intent) {
        return handleCropImageResult(context, i2, intent);
    }

    private static JSONObject handleCropImageResult(Context context, int i2, Intent intent) {
        if (intent == null) {
            return null;
        }
        Object handleCropImageResult = ImagePickerUtils.handleCropImageResult(context, i2, intent);
        JSONObject jSONObject = new JSONObject();
        if (handleCropImageResult instanceof HashMap) {
            HashMap hashMap = (HashMap) handleCropImageResult;
            if (hashMap.get("status").equals("success")) {
                return getSuccessH5Data(hashMap);
            }
        }
        return handleCropImageResult instanceof JSONObject ? getErrorH5Data((JSONObject) handleCropImageResult) : jSONObject;
    }

    private static JSONObject getErrorH5Data(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("status", ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            jSONObject2.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, jSONObject.get(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject2;
    }

    private static JSONObject getSuccessH5Data(HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_TYPE, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE));
            jSONObject.put("status", hashMap.get("status"));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_BASE_64, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_STREAM));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_EXT, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_EXT));
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_SIZE, hashMap.get(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE));
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }
}
