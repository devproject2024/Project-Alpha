package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import in.org.npci.commonlibrary.e;
import in.org.npci.commonlibrary.f;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class v {
    private static ResultReceiver k;

    /* renamed from: a  reason: collision with root package name */
    private String f73005a;

    /* renamed from: b  reason: collision with root package name */
    private String f73006b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f73007c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f73008d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f73009e;

    /* renamed from: f  reason: collision with root package name */
    private JSONArray f73010f;

    /* renamed from: g  reason: collision with root package name */
    private Locale f73011g;

    /* renamed from: h  reason: collision with root package name */
    private e f73012h;

    /* renamed from: i  reason: collision with root package name */
    private String f73013i;
    private i j;

    private void a(Context context) {
        String optString = this.f73009e.optString("txnId");
        String optString2 = this.f73009e.optString("txnAmount");
        String optString3 = this.f73009e.optString("appId");
        String optString4 = this.f73009e.optString("deviceId");
        String optString5 = this.f73009e.optString("mobileNumber");
        String optString6 = this.f73009e.optString(CLConstants.SALT_FIELD_PAYER_ADDR);
        String optString7 = this.f73009e.optString(CLConstants.SALT_FIELD_PAYEE_ADDR);
        try {
            StringBuilder sb = new StringBuilder(100);
            if (optString2 != null) {
                if (!optString2.isEmpty()) {
                    sb.append(optString2);
                    sb.append("|");
                }
            }
            if (optString != null && !optString.isEmpty()) {
                sb.append(optString);
                sb.append("|");
            }
            if (optString6 != null && !optString6.isEmpty()) {
                sb.append(optString6);
                sb.append("|");
            }
            if (optString7 != null && !optString7.isEmpty()) {
                sb.append(optString7);
                sb.append("|");
            }
            if (optString3 != null && !optString3.isEmpty()) {
                sb.append(optString3);
                sb.append("|");
            }
            if (optString5 != null && !optString5.isEmpty()) {
                sb.append(optString5);
                sb.append("|");
            }
            if (optString4 != null && !optString4.isEmpty()) {
                sb.append(optString4);
            }
            int lastIndexOf = sb.lastIndexOf("|");
            if (lastIndexOf != -1 && lastIndexOf == sb.length() - 1) {
                sb.deleteCharAt(lastIndexOf);
            }
            String b2 = this.j.b();
            ad.b("CL Trust Token", b2);
            ad.b("CL Trust Param Message", sb.toString());
            this.f73012h.a(this.f73013i, sb.toString(), b2);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new d(context, CLConstants.ERROR_KEY_TRUST_NOT_VALID, CLConstants.ERROR_MSG_KEY_TRUST_NOT_VALID);
        }
    }

    public static void a(CLServerResultReceiver cLServerResultReceiver) {
        k = cLServerResultReceiver;
    }

    public String a() {
        return this.f73005a;
    }

    public void a(Bundle bundle, Context context) {
        this.j = new i(context);
        try {
            this.f73005a = bundle.getString(CLConstants.INPUT_KEY_KEY_CODE);
            if (this.f73005a == null || this.f73005a.isEmpty()) {
                throw new d(context, CLConstants.ERROR_KEY_CODE_MISSING, CLConstants.ERROR_MSG_KEY_CODE_MISSING);
            }
            ad.b("Common Library", this.f73005a);
            try {
                this.f73006b = bundle.getString(CLConstants.INPUT_KEY_XML_PAYLOAD);
                if (this.f73006b == null || this.f73006b.isEmpty()) {
                    throw new d(context, CLConstants.ERROR_KEY_XML_PAYLOAD_MISSING, CLConstants.ERROR_MSG_KEY_XML_PAYLOAD_MISSING);
                }
                ad.b("Common Library", this.f73006b);
                this.f73012h = new e(this.f73006b);
                try {
                    String string = bundle.getString(CLConstants.INPUT_KEY_CONTROLS);
                    if (string == null || string.isEmpty()) {
                        ad.b("Common Library", "Controls is not received. Setting MPIN as default. ");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", "PIN");
                        jSONObject.put(CLConstants.FIELD_SUBTYPE, "MPIN");
                        jSONObject.put(CLConstants.FIELD_DTYPE, "NUM|ALPH");
                        jSONObject.put(CLConstants.FIELD_DLENGTH, 6);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.f73007c = new JSONObject();
                        this.f73007c.put(CLConstants.FIELD_CRED_ALLOWED, jSONArray);
                    } else {
                        ad.b("Common Library", "Controls received: ".concat(String.valueOf(string)));
                        this.f73007c = new JSONObject(string);
                    }
                    try {
                        String string2 = bundle.getString(CLConstants.INPUT_KEY_CONFIGURATION);
                        if (string2 == null || string2.isEmpty()) {
                            ad.b("Common Library", "Configuration is not received");
                        } else {
                            ad.b("Common Library", "Configuration received: ".concat(String.valueOf(string2)));
                            this.f73008d = new JSONObject(string2);
                        }
                        try {
                            String string3 = bundle.getString(CLConstants.INPUT_KEY_SALT);
                            if (string3 == null || string3.isEmpty()) {
                                throw new d(context, CLConstants.ERROR_SALT_MISSING, CLConstants.ERROR_MSG_SALT_MISSING);
                            }
                            ad.b("Common Library", string3);
                            this.f73009e = new JSONObject(string3);
                            try {
                                this.f73013i = bundle.getString(CLConstants.INPUT_KEY_TRUST);
                                if (this.f73013i == null || this.f73013i.isEmpty()) {
                                    throw new d(context, CLConstants.ERROR_KEY_TRUST_MISSING, CLConstants.ERROR_MSG_KEY_TRUST_MISSING);
                                }
                                ad.b("Common Library", this.f73013i);
                                a(context);
                                try {
                                    String string4 = bundle.getString(CLConstants.INPUT_KEY_PAY_INFO);
                                    if (string4 == null || string4.isEmpty()) {
                                        ad.b("Common Library", "Pay Info not received");
                                    } else {
                                        ad.b("Common Library", "Pay Info Received".concat(String.valueOf(string4)));
                                        this.f73010f = new JSONArray(string4);
                                    }
                                    try {
                                        String string5 = bundle.getString(CLConstants.INPUT_KEY_LANGUAGE_PREFERENCE);
                                        this.f73011g = new Locale((string5 == null || string5.isEmpty()) ? CLConstants.DEFAULT_LANGUAGE_PREFERENCE : string5);
                                        ad.b("Common Library", string5);
                                    } catch (Exception unused) {
                                        throw new d(context, CLConstants.ERROR_LOCALE_PARSE, CLConstants.ERROR_MSG_LOCALE_PARSE);
                                    }
                                } catch (Exception unused2) {
                                    throw new d(context, CLConstants.ERROR_PAY_INFO_PARSE, CLConstants.ERROR_MSG_PAY_INFO_PARSE);
                                }
                            } catch (d e2) {
                                throw e2;
                            } catch (Exception e3) {
                                throw new d(context, CLConstants.ERROR_XML_PAYLOAD_PARSE, CLConstants.ERROR_MSG_XML_PAYLOAD_PARSE, e3);
                            }
                        } catch (d e4) {
                            throw e4;
                        } catch (Exception e5) {
                            throw new d(context, CLConstants.ERROR_SALT_PARSE, CLConstants.ERROR_MSG_SALT_PARSE, e5);
                        }
                    } catch (Exception e6) {
                        throw new d(context, CLConstants.ERROR_CONFIG_PARSE, CLConstants.ERROR_MSG_CONFIG_PARSE, e6);
                    }
                } catch (Exception e7) {
                    throw new d(context, CLConstants.ERROR_CONTROLS_PARSE, CLConstants.ERROR_MSG_CONTROLS_PARSE, e7);
                }
            } catch (f e8) {
                ad.a("CommonLibraryException", e8.getMessage());
                throw new d(context, CLConstants.ERROR_XMLPAYLOAD_VALIDATE, CLConstants.ERROR_MSG_XMLPAYLOAD_VALIDATE, e8);
            } catch (d e9) {
                throw e9;
            } catch (Exception e10) {
                throw new d(context, CLConstants.ERROR_XML_PAYLOAD_PARSE, CLConstants.ERROR_MSG_XML_PAYLOAD_PARSE, e10);
            }
        } catch (d e11) {
            throw e11;
        } catch (Exception e12) {
            throw new d(context, CLConstants.ERROR_KEY_CODE_PARSE, CLConstants.ERROR_MSG_KEY_CODE_PARSE, e12);
        }
    }

    public Locale b() {
        return this.f73011g;
    }

    public e c() {
        return this.f73012h;
    }

    public i d() {
        return this.j;
    }

    public ResultReceiver e() {
        return k;
    }
}
