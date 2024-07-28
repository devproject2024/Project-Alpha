package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.q;
import java.lang.reflect.InvocationTargetException;
import net.one97.paytm.dynamic.module.fastag.helper.FastagImageCropHelper;
import net.one97.paytm.marketplace.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public class H5ActivityResultProvider implements PhoenixActivityResultProvider {
    public Object onActivityResult(Context context, int i2, int i3, Intent intent) {
        String stringExtra;
        Context context2 = context;
        int i4 = i2;
        int i5 = i3;
        Intent intent2 = intent;
        if (i4 == 201) {
            a.a(i2, i3, intent);
        } else if (i4 == 203) {
            a.a(i3, intent);
        } else if (i4 == 1010) {
            return intent2.getStringExtra("payload");
        } else {
            if (i4 == 1014) {
                return intent2.getStringExtra("docUrl");
            }
            if (i4 != 2112) {
                boolean z = false;
                if (i4 != 3001) {
                    if (i4 != 9901) {
                        if (i4 != 10021) {
                            if (i4 != 20022) {
                                if (i4 == 1221) {
                                    return t.b(context);
                                }
                                if (i4 == 1222) {
                                    return intent2.getStringExtra("uploadResponse");
                                }
                                switch (i4) {
                                    case 1224:
                                        if (!(intent2 == null || intent.getData() == null)) {
                                            Cursor query = context.getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
                                            if (query.moveToFirst() && "1".equalsIgnoreCase(query.getString(query.getColumnIndexOrThrow("has_phone_number")))) {
                                                String string = query.getString(query.getColumnIndex("data1"));
                                                String string2 = query.getString(query.getColumnIndex("display_name"));
                                                try {
                                                    JSONObject jSONObject = new JSONObject();
                                                    jSONObject.put("name", string2);
                                                    jSONObject.put("mobile", string);
                                                    query.close();
                                                    return jSONObject.toString();
                                                } catch (Exception e2) {
                                                    q.b(e2.getMessage());
                                                }
                                            }
                                            query.close();
                                        }
                                        return "";
                                    case 1225:
                                        return i5 == -1 ? "Success" : SDKConstants.GA_NATIVE_FAILED;
                                    case 1226:
                                    case 1227:
                                    case 1228:
                                        JSONObject jSONObject2 = new JSONObject();
                                        if (intent2 != null) {
                                            try {
                                                if (intent2.hasExtra("order_id")) {
                                                    jSONObject2.put("order_id", intent2.getStringExtra("order_id"));
                                                }
                                                if (intent2.hasExtra(AppConstants.IS_CANCEL)) {
                                                    jSONObject2.put(AppConstants.IS_CANCEL, intent2.getBooleanExtra(AppConstants.IS_CANCEL, false));
                                                }
                                                if (intent2.hasExtra(UpiConstants.FROM)) {
                                                    jSONObject2.put(UpiConstants.FROM, intent2.getStringExtra(UpiConstants.FROM));
                                                }
                                            } catch (Exception e3) {
                                                try {
                                                    jSONObject2.put("status", i5);
                                                } catch (JSONException unused) {
                                                    q.b(e3.getMessage());
                                                }
                                            }
                                        }
                                        return jSONObject2.toString();
                                    case 1229:
                                        JSONObject jSONObject3 = new JSONObject();
                                        if (!(intent2 == null || intent.getExtras() == null)) {
                                            Bundle extras = intent.getExtras();
                                            try {
                                                for (String str : extras.keySet()) {
                                                    if (Build.VERSION.SDK_INT >= 19) {
                                                        jSONObject3.put(str, JSONObject.wrap(extras.get(str)));
                                                    } else if (extras.get(str) instanceof String) {
                                                        jSONObject3.put(str, extras.getString(str));
                                                    } else if (extras.get(str) instanceof Boolean) {
                                                        jSONObject3.put(str, extras.getBoolean(str));
                                                    } else if (extras.get(str) instanceof Integer) {
                                                        jSONObject3.put(str, extras.getInt(str));
                                                    }
                                                }
                                                if (i5 == -1) {
                                                    jSONObject3.put("result", "Success");
                                                } else {
                                                    jSONObject3.put("result", SDKConstants.GA_NATIVE_FAILED);
                                                }
                                            } catch (Exception e4) {
                                                q.b(e4.getMessage());
                                            }
                                        }
                                        return jSONObject3.toString();
                                    case 1230:
                                        return FastagImageCropHelper.sendImagePickerResult(context, i5, intent2);
                                }
                            } else if (context2 instanceof Activity) {
                                a.a((Activity) context2);
                            }
                        }
                    } else if (intent2 != null) {
                        if (intent2.hasExtra("addmoney_status")) {
                            return intent2.getStringExtra("addmoney_status");
                        }
                        if (intent2.hasExtra(Payload.RESPONSE)) {
                            return intent2.getStringExtra(Payload.RESPONSE);
                        }
                        return "";
                    }
                } else if (intent2 != null && intent2.hasExtra("orderId")) {
                    return intent2.getStringExtra("orderId");
                }
                if (intent2 != null) {
                    z = intent2.getBooleanExtra("status", false);
                }
                return Boolean.valueOf(z);
            } else if (intent2 == null || (stringExtra = intent2.getStringExtra(Payload.RESPONSE)) == null) {
                return "";
            } else {
                return stringExtra;
            }
        }
        Object bankResult = getBankResult(context, i2, i3, intent);
        if (bankResult != null) {
            return bankResult;
        }
        Object kycResult = getKycResult(context, i2, i3, intent);
        if (kycResult != null) {
            return kycResult;
        }
        return null;
    }

    public Object getBankResult(Context context, int i2, int i3, Intent intent) {
        try {
            Class<?> cls = Class.forName("net.one97.paytm.payments.c.b.a");
            Object obj = cls.getField("INSTANCE").get(cls);
            return obj.getClass().getDeclaredMethods()[0].invoke(obj, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), intent});
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return null;
        } catch (IllegalAccessException e3) {
            q.b(e3.getMessage());
            return null;
        } catch (InvocationTargetException e4) {
            q.b(e4.getMessage());
            return null;
        } catch (NoSuchFieldException e5) {
            q.b(e5.getMessage());
            return null;
        }
    }

    public Object getKycResult(Context context, int i2, int i3, Intent intent) {
        try {
            Class<?> cls = Class.forName("net.one97.paytm.payments.c.b.d");
            Object obj = cls.getField("INSTANCE").get(cls);
            return obj.getClass().getDeclaredMethods()[0].invoke(obj, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), intent});
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return null;
        } catch (IllegalAccessException e3) {
            q.b(e3.getMessage());
            return null;
        } catch (InvocationTargetException e4) {
            q.b(e4.getMessage());
            return null;
        } catch (NoSuchFieldException e5) {
            q.b(e5.getMessage());
            return null;
        }
    }
}
