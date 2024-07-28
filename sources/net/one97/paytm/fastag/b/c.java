package net.one97.paytm.fastag.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.c.a;
import net.one97.paytm.fastag.dependencies.o;
import net.one97.paytm.fastag.dependencies.p;
import net.one97.paytm.fastag.f.h;
import net.one97.paytm.fastag.f.i;
import net.one97.paytm.fastag.model.CJRAadharPanSave;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.model.CJRAddresses;
import net.one97.paytm.fastag.model.CJRDetailProduct;
import net.one97.paytm.fastag.model.CJRPincode;
import net.one97.paytm.fastag.model.CJRRechargeCart;
import net.one97.paytm.fastag.model.CJRUploadDocument;
import net.one97.paytm.fastag.model.Contact;
import net.one97.paytm.fastag.model.ExpressCheckoutRequestModel;
import net.one97.paytm.fastag.model.RiskExtendedInfo;
import net.one97.paytm.fastag.model.TollAddress;
import net.one97.paytm.fastag.model.TollCartItemModel;
import net.one97.paytm.fastag.model.TollConfigurationModel;
import net.one97.paytm.fastag.model.TollMetaDataModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private ExpressCheckoutRequestModel f13557b;

    public c(Context context) {
        super(context);
    }

    public final void a(b bVar, String str, String str2, String str3, String str4, CJRAddress cJRAddress, String str5) {
        boolean z;
        String k = b.k();
        String str6 = (b.d(com.paytm.utility.c.b(a.a().f13559b.getCartVerify(), this.f13556a) + "&token_type=oauth&client_id=" + k + "&networktype=" + b.b(this.f13556a), "POST") + "&sso_token=" + com.paytm.utility.a.q(this.f13556a)) + "&child_site_id=1&site_id=1";
        if (str6 == null || !URLUtil.isValidUrl(str6)) {
            bVar.a((Throwable) new NetworkCustomError(this.f13556a.getString(R.string.invalid_url)));
        }
        this.f13557b = new ExpressCheckoutRequestModel();
        TollCartItemModel tollCartItemModel = new TollCartItemModel();
        tollCartItemModel.setProductId(Integer.valueOf((int) Long.parseLong(str)));
        tollCartItemModel.setQty(1);
        TollConfigurationModel tollConfigurationModel = new TollConfigurationModel();
        tollConfigurationModel.setPrice(str5);
        tollConfigurationModel.setTotalamount(str5);
        tollCartItemModel.setConfiguration(tollConfigurationModel);
        TollMetaDataModel tollMetaDataModel = new TollMetaDataModel();
        tollMetaDataModel.setVehicle_registrtion_number(str2);
        tollMetaDataModel.setFront_rc_id(str3);
        tollMetaDataModel.setBack_rc_id(str4);
        tollCartItemModel.setMeta_data(tollMetaDataModel);
        this.f13557b.getCart_items().add(tollCartItemModel);
        this.f13557b.setPromocode("");
        if (cJRAddress != null) {
            TollAddress tollAddress = new TollAddress();
            tollAddress.setAddress1(cJRAddress.getAddress1());
            tollAddress.setAddress2(cJRAddress.getAddress2());
            tollAddress.setCity(cJRAddress.getCity());
            tollAddress.setPin(cJRAddress.getPin());
            tollAddress.setState(cJRAddress.getState());
            this.f13557b.setAddress(tollAddress);
            this.f13557b.setBilling_address(tollAddress);
        }
        if (this.f13557b != null) {
            String a2 = new f().a((Object) this.f13557b, (Type) ExpressCheckoutRequestModel.class);
            HashMap<String, String> a3 = b.a((HashMap<String, String>) new HashMap(), this.f13556a);
            a3.put("Content-Type", "application/json");
            p.a().b();
            p a4 = p.a();
            Context context = this.f13556a;
            try {
                Contact ao = !TextUtils.isEmpty((CharSequence) null) ? h.ao(context) : null;
                RiskExtendedInfo riskExtendedInfo = p.a().f13755a;
                riskExtendedInfo.setDeviceAccounts(o.a().f13751e);
                riskExtendedInfo.setDisplayName((String) null);
                riskExtendedInfo.setContactCreateTime(ao != null ? ao.getUpdatedTime() : null);
                if (ao == null) {
                    z = false;
                } else {
                    z = ao.isContactExits();
                }
                riskExtendedInfo.setIsContact(z);
                riskExtendedInfo.setIsRooted(o.a().f13749c);
                riskExtendedInfo.setLci(o.a().f13747a);
                riskExtendedInfo.setLco(o.a().f13748b);
                riskExtendedInfo.setOtpReadFlag(false);
                riskExtendedInfo.setWifissid(o.a().f13750d);
                riskExtendedInfo.setLatitude(b.s(context));
                riskExtendedInfo.setLongitude(b.t(context));
                riskExtendedInfo.setTranscationType((String) null);
                riskExtendedInfo.setLcic(o.a().f13752f);
                a4.f13756b = true;
            } catch (Exception unused) {
            }
            String c2 = p.a().c();
            if (!TextUtils.isEmpty(c2)) {
                a3.put("risk_extended_info", c2);
            }
            p.a().b();
            b(str6, new CJRRechargeCart(), a3, a2.toString(), bVar);
        }
    }

    public final void b(b bVar, String str) {
        if (str == null || !URLUtil.isValidUrl(str)) {
            bVar.a((Throwable) new NetworkCustomError("Invalid URL"));
        }
        a(str, new CJRPincode(), a.a().f13559b.getHeader(this.f13556a), bVar);
    }

    public final void a(b bVar, String str, Map map, JSONObject jSONObject) {
        b(str, new CJRAddress(), map, jSONObject.toString(), bVar);
    }

    public final void b(b bVar, String str, Map map, JSONObject jSONObject) {
        if (str == null || !URLUtil.isValidUrl(str)) {
            bVar.a((Throwable) new NetworkCustomError(this.f13556a.getString(R.string.invalid_url)));
        }
        a(str, new CJRAddress(), map, jSONObject.toString(), bVar);
    }

    public final void c(b bVar, String str, Map map, JSONObject jSONObject) {
        if (str == null || !URLUtil.isValidUrl(str)) {
            bVar.a((Throwable) new NetworkCustomError(this.f13556a.getString(R.string.invalid_url)));
        }
        a(str, new CJRAddress(), map, jSONObject.toString(), bVar);
    }

    public final void a(Uri uri, b bVar) {
        String format = String.format(a.a().f13559b.getUploadDocuemntUrl(), new Object[]{b.n(this.f13556a)});
        if (format == null || !URLUtil.isValidUrl(format)) {
            bVar.a((Throwable) new NetworkCustomError(this.f13556a.getString(R.string.invalid_url)));
        }
        String str = format + "?device=android";
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(this.f13556a.getContentResolver().openInputStream(uri));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            try {
                String name = new File(i.a(this.f13556a, uri)).getName();
                String substring = name.contains(AppUtility.CENTER_DOT) ? name.substring(name.indexOf(46) + 1) : "";
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("application", "paytmapp");
                    jSONObject.put("custId", b.n(this.f13556a));
                    jSONObject.put("agentId", "123");
                    jSONObject2.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, name);
                    jSONObject2.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, CommunityPostActivity.TYPE_IMAGE.concat(String.valueOf(substring)));
                    jSONObject2.put(ImagePickerUtils.IMAGE_PICKER_KEY_EXT, substring);
                    jSONObject2.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_STREAM, encodeToString);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    jSONObject.put("documentDetailList", jSONArray);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", com.paytm.utility.a.q(this.f13556a));
                hashMap.put("Content-Type", "application/json");
                b(str, new CJRUploadDocument(), hashMap, jSONObject.toString(), bVar);
            } catch (URISyntaxException unused) {
                bVar.a((Throwable) new NetworkCustomError(this.f13556a.getString(R.string.invalid_file_path)));
            }
        } catch (FileNotFoundException unused2) {
            bVar.a((Throwable) new NetworkCustomError("No file found"));
        }
    }

    public final void a(b bVar) {
        String addressUrl = a.a().f13559b.getAddressUrl();
        if (addressUrl == null || !URLUtil.isValidUrl(addressUrl)) {
            bVar.a((Throwable) new NetworkCustomError("Invalid URL"));
        }
        String str = addressUrl + com.paytm.utility.c.a(this.f13556a, false);
        try {
            new JSONObject().put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(str, new CJRAddresses(), a.a().f13559b.getHeader(this.f13556a), bVar);
    }

    public final void a(b bVar, String str) {
        String utilityProdDetailsURL = a.a().f13559b.getUtilityProdDetailsURL();
        if (utilityProdDetailsURL == null || !URLUtil.isValidUrl(utilityProdDetailsURL)) {
            bVar.a((Throwable) new NetworkCustomError("Invalid URL"));
        }
        String str2 = utilityProdDetailsURL + str;
        HashMap hashMap = new HashMap();
        hashMap.put("request_Type", "s2s");
        a(b.b(this.f13556a, str2), new CJRDetailProduct(), hashMap, bVar);
    }

    public final void a(b bVar, String str, String str2, String str3, String str4) {
        String str5;
        String e2 = b.e(this.f13556a, a.a().f13559b.getKYCProfileSaveURL());
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", a.a().f13559b.getSSOToken(this.f13556a));
        hashMap.put("Content-Type", "application/json");
        String e3 = b.e();
        String f2 = b.f();
        try {
            hashMap.put("x-keyiv", net.one97.paytm.common.utility.f.a("1k9fbjvjknqhxoikaesrvdi6vanz05n8hd3zzzomeku37snlwpfvmwg3nrpb96fav8x8ylsfrthkc3g121td3mcoemirju47k17nwz19y6inw4jh77avjl9s44r96w8obv3x8j20aikyl9w35xsk0ji7ru345djgyiznx7owxgdox6mt9i1l3oj2xa9jd15r5ironfnwsahomu8vs0lfb2mx6i7d31ep5gmuyvuklea7sh1oz0h0tew323c0p2xwfkfoj6n0y8y82zha9cw6wyc15o44vhyf8dgv8iynh1jd6o55kwg8c0d76kon953miztjg619zcprxovkl2b5wlwkeh8i8c3bt06egtjiv4hms72snrwuovaafpbxst3izw9wscf6fpt1hqqb3vgq0934blwdbclhb7h20omvlm91awdlcylmychylg3xauk4a3x4o8pbyddlwqs54q9nk17m16emj6i1kzv6fxygdke829wxwhq9dpo0hcb378tzs5lq0eus7w4scsu1g7qhtlhmybiz8fkfne6721ncry4s05qtmetmabet904a42o55ksoufeofym418ke3wtdz32gdt691upgp4j4ufe0wmgdczlue4ml2l4yl52wt54econ40fun2ynlmocks1wrq5vzg00ewm5btvmhmosmd6fm0fbvxerhhuxc66lzqe7ag4xutzu6fae8yg6czxcsfptxas01xiyfevdeq20h5bii4en98a76ifjqu1wdnqdhcsvxd64d65l4lgadyktsm66ij94orc4yemlr9n8kle0f41meezetawkkjdx5eoki4qeurw7tdvkoeqpwghdt", e3 + ':' + f2));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        CJRAadharPanSave cJRAadharPanSave = new CJRAadharPanSave();
        cJRAadharPanSave.setIv(f2);
        cJRAadharPanSave.setKey(e3);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("vehicleNumber", str);
            jSONObject2.put("ownerName", str4);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("dmsId", str2);
            jSONObject3.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_TYPE, "VehicleRCFront");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dmsId", str3);
            jSONObject4.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_TYPE, "VehicleRCBack");
            jSONArray2.put(jSONObject3);
            jSONArray2.put(jSONObject4);
            jSONArray.put(jSONObject2);
            jSONObject2.put("images", jSONArray2);
            jSONObject.put("vehicles", jSONArray);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        String jSONObject5 = jSONObject.toString();
        try {
            str5 = net.one97.paytm.common.utility.f.a(f2, e3, jSONObject5);
        } catch (Exception e6) {
            e6.printStackTrace();
            str5 = jSONObject5;
        }
        b(e2, cJRAadharPanSave, hashMap, str5, bVar);
    }
}
