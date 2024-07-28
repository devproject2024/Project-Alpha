package com.alipay.mobile.nebulacore.dev.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.wallet.H5WalletBaseActivity;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class H5DevConfigEditActivity extends H5WalletBaseActivity {
    private String TAG = "H5DevConfigEditActivity";
    private Object configService;
    private EditText et;
    private Method getConfig;
    private Handler handler;
    private Method saveConfig;
    private SharedPreferences sp;
    /* access modifiers changed from: private */
    public EditText tv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.h5_dev_config_edit_activity);
        this.tv = (EditText) findViewById(R.id.textView1);
        this.et = (EditText) findViewById(R.id.et1);
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                if (message != null && message.obj != null) {
                    H5DevConfigEditActivity.this.tv.setText(message.obj.toString());
                }
            }
        };
        b.a();
        this.configService = c.a("com.alipay.mobile.base.config.ConfigService");
        try {
            this.getConfig = this.configService.getClass().getDeclaredMethod("getConfig", new Class[]{String.class});
            this.saveConfig = this.configService.getClass().getDeclaredMethod("saveConfigs", new Class[]{Map.class});
        } catch (NoSuchMethodException e2) {
            H5Log.e(this.TAG, e2.getMessage());
        }
        this.sp = getSharedPreferences("xltest", 0);
        String string = this.sp.getString("configKey", (String) null);
        if (!TextUtils.isEmpty(string)) {
            this.et.setText(string);
            out(getConfig(string));
        }
    }

    public void queryBtn(View view) {
        String obj = this.et.getText().toString();
        String config = getConfig(obj);
        if (TextUtils.isEmpty(config)) {
            out(String.format("query key %s, value is empty ", new Object[]{obj}));
            return;
        }
        out(config);
        this.sp.edit().putString("configKey", obj).commit();
    }

    public void saveBtn(View view) {
        String obj = this.et.getText().toString();
        String obj2 = this.tv.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            out("key is empty, not saved");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(obj, obj2);
        saveConfigs(hashMap);
    }

    private String getConfig(String str) {
        try {
            return String.valueOf(this.getConfig.invoke(this.configService, new Object[]{str}));
        } catch (Throwable th) {
            String str2 = this.TAG;
            H5Log.e(str2, "get " + str + " error " + th.getMessage());
            return "";
        }
    }

    private void saveConfigs(Map<String, String> map) {
        try {
            this.saveConfig.invoke(this.configService, new Object[]{map});
        } catch (Throwable th) {
            String str = this.TAG;
            H5Log.e(str, "saveConfig error " + th.getMessage());
        }
    }

    private void out(String str) {
        H5Log.d(this.TAG, str);
        Message message = new Message();
        message.obj = str;
        this.handler.sendMessage(message);
    }
}
