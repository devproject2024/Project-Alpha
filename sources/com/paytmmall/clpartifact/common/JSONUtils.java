package com.paytmmall.clpartifact.common;

import android.text.TextUtils;
import com.google.gson.f;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.ItemCTA;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.clpCommon.ViewDataSource;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    public static View getView(String str, CLPBaseViewHolder.IParentListProvider iParentListProvider) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        View view = new View();
        try {
            view.setId(Long.valueOf(jSONObject.optLong("id")));
            view.setImageUrl(jSONObject.optString("image_url"));
            view.setType(jSONObject.optString("type"));
            view.setItems(getItemList(jSONObject.optJSONArray("items"), view.getType(), jSONObject.optJSONArray("datasources"), jSONObject.optString(Item.KEY_CLASS)));
            view.setLandingPageMetaFlag(Long.valueOf(jSONObject.optLong(View.KEY_LANDING_PAGE_META_FLAG)));
            view.setManageByEngage(Long.valueOf(jSONObject.optLong(View.KEY_MANAGE_BY_ENGAGE)));
            view.setPriority(Long.valueOf(jSONObject.optLong("priority")));
            view.setSeourl(jSONObject.optString("seourl"));
            view.setStartTime(jSONObject.optString("start_time"));
            view.setSubtitle(jSONObject.optString("subtitle"));
            view.setTitle(jSONObject.optString("title"));
            view.setmSeeAllUrl(jSONObject.optString(View.KEY_ALL_SEOURL));
            view.setmSeeAllSeoUrl(jSONObject.optString(View.KEY_ALL_SEO_SEOURL));
            view.setUrlType(jSONObject.optString("url_type"));
            view.setMax_items_shown(jSONObject.optInt(View.KEY_MAX_ITEMS));
            view.setShow_more_image_url(jSONObject.optString(View.KEY_SHOW_MORE_IMAGE_URL));
            view.setShow_less_image_url(jSONObject.optString(View.KEY_SHOW_LESS_IMAGE_URL));
            view.setShow_more_label(jSONObject.optString(View.KEY_SHOW_MORE_TEXT));
            view.setShow_less_label(jSONObject.optString(View.KEY_SHOW_LESS_TEXT));
            view.setDataSources(getDataSouces(jSONObject.optJSONArray("datasources")));
            return view;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage());
        }
    }

    private static List<String> getViewStrings(List<Page> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Page next : list) {
            if (next != null) {
                String b2 = new f().b(next.getViews().get(0));
                if (!TextUtils.isEmpty(b2)) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    private static List<Item> getItemList(JSONArray jSONArray, String str, JSONArray jSONArray2, String str2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject != null) {
                arrayList.add(getItem(jSONObject, str, jSONArray2, str2));
            }
        }
        return arrayList;
    }

    public static Item getItem(String str) throws JSONException {
        return getItem(new JSONObject(str), "", new JSONArray(), "");
    }

    private static ItemCTA getCTA(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new ItemCTA(jSONObject.optString("label"), jSONObject.optString("url"), jSONObject.optString("url_type"));
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage());
        }
    }

    private static Item getItem(JSONObject jSONObject, String str, JSONArray jSONArray, String str2) throws JSONException {
        Item item = new Item();
        try {
            item.setParentType(str);
            item.setAltImageUrl(jSONObject.optString(Item.KEY_ALT_IMAGE_URL));
            item.setEndTime(jSONObject.optString(Item.KEY_END_TIME));
            item.setGaCategory(jSONObject.optString(Item.KEY_GA_CATEGORY));
            item.setId(jSONObject.optString("id"));
            item.setImageUrl(jSONObject.optString("image_url"));
            item.setItemId(Long.valueOf(jSONObject.optLong("item_id")));
            item.setName(jSONObject.optString("name"));
            item.setmClassName(str2);
            item.setItemSubtitle(jSONObject.optString("subtitle"));
            item.setText1(jSONObject.optString(Item.KEY_TEXT1));
            item.setSubTitleColor(jSONObject.optString(Item.KEY_SUB_TITLE_COLOR));
            item.setCta(getCTA(jSONObject.optJSONObject(Item.KEY_CTA)));
            item.setNewurl(jSONObject.optString(Item.KEY_NEWURL));
            item.setPriority(Long.valueOf(jSONObject.optLong("priority")));
            item.setReason(jSONObject.optString(Item.KEY_REASON));
            item.setSeourl(jSONObject.optString("seourl"));
            item.setSource(jSONObject.optString("source"));
            item.setStartTime(jSONObject.optString("start_time"));
            item.setItemSubtitle(jSONObject.optString("subtitle"));
            item.setTitle(jSONObject.optString("title"));
            item.setUrl(jSONObject.optString("url"));
            item.setUrlInfo(jSONObject.optString(Item.KEY_URL_INFO));
            item.setUrlKey(jSONObject.optString(Item.KEY_URL_KEY));
            item.setUrlType(jSONObject.optString("url_type"));
            item.setOfferPrice(jSONObject.optString(Item.KEY_OFFER_PRICE));
            item.setActualPrice(jSONObject.optString(Item.KEY_ACTUAL_PRICE));
            item.setTag(jSONObject.optString("tag"));
            item.setDiscount(jSONObject.optString(Item.KEY_DISCOUNT));
            item.setContainerinstatnceid(getContainerinstanceid(jSONArray));
            item.setLayout(getLayout(jSONObject.optJSONObject(Item.KEY_LAYOUT)));
            item.setVariantInstanceId(jSONObject.optString("variant_instance_id"));
            if (!TextUtils.isEmpty(jSONObject.optString("items"))) {
                item.setItems(getItemList(new JSONArray(jSONObject.optString("items")), str, jSONArray, str2));
            }
            item.setmGroupViewId(getGroupGrid(jSONObject.optJSONObject(Item.KEY_GROUP_ID)));
            item.setImage_bg_color(jSONObject.optString(Item.KEY_IMAGE_COLOR));
            item.setName_intial(jSONObject.optString(Item.KEY_INTIAL_NAME));
            item.setMdisplaymetadata(getDisplayMetaData(jSONObject.optJSONObject("display_metadata")));
            return item;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage());
        }
    }

    private static Item.Displaymetadata getDisplayMetaData(JSONObject jSONObject) {
        Item.Displaymetadata displaymetadata = new Item.Displaymetadata();
        if (jSONObject == null) {
            return null;
        }
        displaymetadata.setCreated_at(getJsonString(jSONObject, "created_at"));
        displaymetadata.setId(getJsonString(jSONObject, "id"));
        displaymetadata.setImage2_url(getJsonString(jSONObject, "image2_url"));
        displaymetadata.setImage_url(getJsonString(jSONObject, "image_url"));
        displaymetadata.setVideo_url(getJsonString(jSONObject, "video_url"));
        displaymetadata.setMmetadata(getMetaData(jSONObject.optJSONObject("metadata")));
        return displaymetadata;
    }

    private static ArrayList<ViewDataSource> getDataSouces(JSONArray jSONArray) throws JSONException {
        ArrayList<ViewDataSource> arrayList = new ArrayList<>();
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject != null) {
                arrayList.add(getDatasoureDontainer(jSONObject));
            }
        }
        return arrayList;
    }

    private static ViewDataSource getDatasoureDontainer(JSONObject jSONObject) {
        ViewDataSource viewDataSource = new ViewDataSource();
        if (jSONObject != null) {
            viewDataSource.setContainerId(getJsonString(jSONObject, "container_id"));
            viewDataSource.setContainerInstanceId(getJsonString(jSONObject, "container_instance_id"));
            viewDataSource.setType(getJsonString(jSONObject, "type"));
            viewDataSource.setListId(getJsonString(jSONObject, "list_id"));
        }
        return viewDataSource;
    }

    private static String getContainerinstanceid(JSONArray jSONArray) throws JSONException {
        ArrayList<ViewDataSource> dataSouces = getDataSouces(jSONArray);
        return (dataSouces == null || dataSouces.size() <= 0 || dataSouces.get(0) == null) ? "" : dataSouces.get(0).getContainerInstanceId();
    }

    private static String getJsonString(JSONObject jSONObject, String str) {
        return (jSONObject == null || jSONObject.optString(str) == null) ? "" : jSONObject.optString(str);
    }

    private static Item.Displaymetadata.Metadata getMetaData(JSONObject jSONObject) {
        Item.Displaymetadata.Metadata metadata = new Item.Displaymetadata.Metadata();
        if (jSONObject == null) {
            return null;
        }
        metadata.setClick_pixel_url(getJsonString(jSONObject, "click_pixel_url"));
        metadata.setImpression_pixel1(getJsonString(jSONObject, "impression_pixel1"));
        metadata.setImpression_pixel2(getJsonString(jSONObject, "impression_pixel2"));
        metadata.setImpression_pixel3(getJsonString(jSONObject, "impression_pixel3"));
        metadata.setImpression_pixel_url(getJsonString(jSONObject, "impression_pixel_url"));
        metadata.setJavascript_resource_url(getJsonString(jSONObject, "javascript_resource_url"));
        metadata.setVendor_key(getJsonString(jSONObject, "vendor_key"));
        metadata.setVerification_parameters(getJsonString(jSONObject, "verification_parameters"));
        return metadata;
    }

    private static Object getJson(JSONObject jSONObject) {
        if (jSONObject.optJSONObject(Item.KEY_GROUP_ID) == null) {
            return "";
        }
        return Boolean.valueOf(jSONObject.optJSONObject(Item.KEY_GROUP_ID) != null);
    }

    private static Item.LayoutData getLayout(JSONObject jSONObject) {
        Item.LayoutData layoutData = new Item.LayoutData();
        if (jSONObject != null) {
            layoutData.setmLabel(jSONObject.optString("label"));
            layoutData.setLabelBgColor(jSONObject.optString("label_bgcolor"));
            layoutData.setLabelColor(jSONObject.optString("label_text_color"));
        }
        return layoutData;
    }

    private static Item.GroupViewId getGroupGrid(JSONObject jSONObject) throws JSONException {
        Item.GroupViewId groupViewId = new Item.GroupViewId();
        if (jSONObject != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("icon_view_id");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.getString(i2));
                }
            }
            groupViewId.setIcon_view_id(arrayList);
            ArrayList arrayList2 = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ticker_view_id");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    arrayList2.add(optJSONArray2.getString(i3));
                }
            }
            groupViewId.setTicker_view_id(arrayList2);
        }
        return groupViewId;
    }
}
