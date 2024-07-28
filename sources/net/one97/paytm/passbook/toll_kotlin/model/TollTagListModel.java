package net.one97.paytm.passbook.toll_kotlin.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.core.content.b;
import com.paytm.network.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.TollTagDeActivateModel;
import net.one97.paytm.passbook.beans.TollTagResponseDataModel;
import net.one97.paytm.passbook.beans.TollTagResponseEntryModel;
import net.one97.paytm.passbook.beans.TolltagActivateModal;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import org.json.JSONObject;

public final class TollTagListModel {
    public static final Companion Companion = new Companion((g) null);
    private final Context applicationContext;
    private final Context context;

    public final boolean isaddmoneyWalletVisible(int i2) {
        return i2 == 13 || i2 == 19;
    }

    public TollTagListModel(Context context2) {
        k.c(context2, "context");
        this.context = context2;
        Context applicationContext2 = this.context.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        this.applicationContext = applicationContext2;
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final Bitmap getImageBitMap() {
        return Companion.getCircularBitmapWithWhiteBorder(BitmapFactory.decodeResource(this.applicationContext.getResources(), R.drawable.pass_car), 5);
    }

    public final String getSuccessString() {
        String string = this.applicationContext.getResources().getString(R.string.success);
        k.a((Object) string, "applicationContext.resou…tString(R.string.success)");
        return string;
    }

    public final String getTagBarcodeFormattedString(String str) {
        k.c(str, "tagBarcode");
        aa aaVar = aa.f47921a;
        String string = this.applicationContext.getResources().getString(R.string.tag_barcode);
        k.a((Object) string, "applicationContext.resou…ing(R.string.tag_barcode)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final String getVehRegNoFormattedString(String str) {
        k.c(str, "tagId");
        String string = this.applicationContext.getResources().getString(R.string.veh_reg_no);
        aa aaVar = aa.f47921a;
        k.a((Object) string, "rawString");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final String getSuccessMessageString(boolean z) {
        if (z) {
            String string = this.applicationContext.getString(R.string.msg_tool_activate_responsedelay);
            k.a((Object) string, "applicationContext.getSt…l_activate_responsedelay)");
            return string;
        }
        String string2 = this.applicationContext.getString(R.string.msg_tool_deactivate_responsedelay);
        k.a((Object) string2, "applicationContext.getSt…deactivate_responsedelay)");
        return string2;
    }

    public final int getStatusColor(int i2) {
        int i3 = R.color.toll_orange;
        if (i2 == 0) {
            i3 = R.color.toll_green;
        } else if (i2 == 1 || i2 == 2 || i2 == 13 || i2 == 19) {
            i3 = R.color.toll_red;
        } else if (i2 == 16 || i2 == 17) {
            i3 = R.color.toll_orange;
        }
        return b.c(this.context, i3);
    }

    public final void eventviewTxn() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "wallet_toll_tag_list");
        hashMap.put("event_action", "view_transaction_clicked");
        hashMap.put("user_id", Boolean.valueOf(new ArrayList().add(com.paytm.utility.b.n(this.applicationContext))));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "manage toll tag screen");
        hashMap.put("vertical_name", "fastag");
    }

    public final void eventToggleBtnClick(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "wallet_toll_tag_list");
        if (z) {
            hashMap.put("event_action", "toggle_button_on");
        } else {
            hashMap.put("event_action", "toggle_button_off");
        }
        hashMap.put("user_id", Boolean.valueOf(new ArrayList().add(com.paytm.utility.b.n(this.applicationContext))));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "manage toll tag screen");
        hashMap.put("vertical_name", "fastag");
    }

    public final net.one97.paytm.passbook.mapping.a.b getTolltaglistRequest(int i2, i.a<IJRDataModel> aVar, net.one97.paytm.passbook.mapping.a.g gVar) {
        k.c(aVar, "successListener");
        k.c(gVar, "errorListener");
        e.a();
        String s = e.s();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", net.one97.paytm.passbook.mapping.b.a(this.context));
        new HashMap();
        hashMap.put("screen_name", "TollTagActivity");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", i2);
            jSONObject2.put("startIndex", 0);
            jSONObject.put("request", jSONObject2);
            return new net.one97.paytm.passbook.mapping.a.b(s, aVar, gVar, new TollTagResponseDataModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, getClass().getSimpleName());
        } catch (Exception unused) {
            return null;
        }
    }

    public final net.one97.paytm.passbook.mapping.a.b activatetag(i.a<IJRDataModel> aVar, net.one97.paytm.passbook.mapping.a.g gVar, TollTagResponseEntryModel tollTagResponseEntryModel) {
        k.c(aVar, "successListener");
        k.c(gVar, "errorListener");
        k.c(tollTagResponseEntryModel, "tolltag");
        e.a();
        String q = e.q();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", net.one97.paytm.passbook.mapping.b.a(this.context));
        new HashMap();
        hashMap.put("screen_name", "TollTagActivity");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("tagId", tollTagResponseEntryModel.getTagId());
            jSONObject.put("request", jSONObject2);
            return new net.one97.paytm.passbook.mapping.a.b(q, aVar, gVar, new TolltagActivateModal(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, getClass().getSimpleName());
        } catch (Exception unused) {
            return null;
        }
    }

    public final net.one97.paytm.passbook.mapping.a.b deActivatetag(i.a<IJRDataModel> aVar, net.one97.paytm.passbook.mapping.a.g gVar, TollTagResponseEntryModel tollTagResponseEntryModel) {
        k.c(aVar, "successListener");
        k.c(gVar, "errorListener");
        k.c(tollTagResponseEntryModel, "tolltag");
        e.a();
        String p = e.p();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", net.one97.paytm.passbook.mapping.b.a(this.context));
        new HashMap();
        hashMap.put("screen_name", "TollTagActivity");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("tagId", tollTagResponseEntryModel.getTagId());
            jSONObject.put("request", jSONObject2);
            return new net.one97.paytm.passbook.mapping.a.b(p, aVar, gVar, new TollTagDeActivateModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, getClass().getSimpleName());
        } catch (Exception unused) {
            return null;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Bitmap getCircularBitmapWithWhiteBorder(Bitmap bitmap, int i2) {
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            int width = bitmap.getWidth() + i2;
            int height = bitmap.getHeight() + i2;
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            Canvas canvas = new Canvas(createBitmap);
            float f2 = (width > height ? (float) height : (float) width) / 2.0f;
            float f3 = (float) (width / 2);
            float f4 = (float) (height / 2);
            canvas.drawCircle(f3, f4, f2, paint);
            paint.setShader((Shader) null);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.rgb(240, 240, 240));
            paint.setStrokeWidth((float) i2);
            canvas.drawCircle(f3, f4, f2 - ((float) (i2 / 2)), paint);
            return createBitmap;
        }
    }

    public final Bitmap getCircularBitmapWithWhiteBorderInMoneyTransfer(Bitmap bitmap, int i2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth() + i2;
        int height = bitmap.getHeight() + i2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        float f2 = ((width > height ? (float) height : (float) width) * 3.0f) / 4.0f;
        float f3 = (float) ((width * 3) / 4);
        float f4 = (float) ((height * 3) / 4);
        canvas.drawCircle(f3, f4, f2, paint);
        paint.setShader((Shader) null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.rgb(240, 240, 240));
        paint.setStrokeWidth((float) i2);
        canvas.drawCircle(f3, f4, f2 - ((float) (i2 / 2)), paint);
        return createBitmap;
    }
}
