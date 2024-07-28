package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.adapter.FreebieSelectionAdapter;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieApplyListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoSelectListener;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoList;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;

public class FreebieSelectionActivity extends BaseMallPromoActivity implements IFreebieApplyListener, IPromoSelectListener {
    /* access modifiers changed from: private */
    public TextView confirmButton;
    private int currentFreebieListIndex;
    private ImageView freebieIcon;
    private int freebieListCount;
    private List<CJRPromoData> promoDatas;
    private RecyclerView rvFreebieList;
    /* access modifiers changed from: private */
    public Freebie selectedFreebie;
    private HashMap<Integer, Freebie> selectedFreebieData = new HashMap<>();
    private TextView viewMessage;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lyt_fb_list_screen);
        initViews();
        boolean booleanExtra = getIntent().getBooleanExtra(PromoUtils.VIEW_MODE, true);
        String string = getString(booleanExtra ? R.string.view_your_freebie : R.string.select_your_freebie);
        if (booleanExtra) {
            this.viewMessage.setVisibility(0);
            this.confirmButton.setVisibility(8);
            setFreebieList(getIntent().getParcelableArrayListExtra(PromoUtils.FREEBIE_LIST), booleanExtra);
        } else {
            getFreebieList();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().a((CharSequence) string);
            getSupportActionBar();
            getSupportActionBar().b(true);
            getSupportActionBar().a(true);
        }
        fireOnLoadGAEvent();
    }

    private void fireOnLoadGAEvent() {
        final String string = getString(Constants.KEY_DISCOVERABILITY);
        Utility.INSTANCE.sendBankOffersEvent(this, new HashMap<String, Object>() {
            {
                put("eventName", "freebie_screen_loaded");
                put("event_action", "freebie_screen_loaded");
                put("event_category", string);
                put("user_id", PromoUtils.getCustomerId());
                put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/cart");
                put("vertical_name", GAUtil.MARKET_PLACE);
            }
        });
    }

    private String getString(String str) {
        HashMap<String, Object> dataMap = getDataMap();
        return (dataMap == null || !dataMap.containsKey(str)) ? "" : String.valueOf(dataMap.get(str));
    }

    private HashMap<String, Object> getDataMap() {
        Intent intent = getIntent();
        HashMap<String, Object> hashMap = intent != null ? (HashMap) intent.getSerializableExtra(Constants.DATA_MAP) : null;
        PromoUtils.log(hashMap != null ? hashMap.toString() : "map not found");
        return hashMap;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    private void getFreebieList() {
        this.promoDatas = (List) getIntent().getSerializableExtra("PROMO_DATA");
        PromoUtils.log(String.valueOf(this.promoDatas.size()));
        List<CJRPromoData> list = this.promoDatas;
        if (list != null) {
            PromoUtils.log(String.valueOf(list.size()));
            this.freebieListCount = this.promoDatas.size();
            this.currentFreebieListIndex = getIntent().getIntExtra(PromoUtils.PROMO_FREEBIE_INDEX, 0);
            this.selectedFreebieData = (HashMap) getIntent().getSerializableExtra(PromoUtils.BULK_ADD_DATA);
            if (this.selectedFreebieData == null) {
                this.selectedFreebieData = new HashMap<>();
            }
            fetchFreebie(getPromoDataUrl());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.promoDatas.get(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getPromoDataUrl() {
        /*
            r2 = this;
            int r0 = r2.currentFreebieListIndex
            int r1 = r2.freebieListCount
            if (r0 >= r1) goto L_0x0015
            java.util.List<net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData> r1 = r2.promoDatas
            java.lang.Object r0 = r1.get(r0)
            net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData r0 = (net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData) r0
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = r0.getFreebieListUrl()
            return r0
        L_0x0015:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.FreebieSelectionActivity.getPromoDataUrl():java.lang.String");
    }

    private void fetchFreebie(String str) {
        showVerifyLoader();
        PromoUtils.log("freebieUrl = ".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str)) {
            PromoHelper.Companion.getInstance().getFreebies(str, (IFreebieResponseListener) new IFreebieResponseListener() {
                public void onFreebieResponse(Gratification gratification, PromoListItem promoListItem, String str) {
                }

                public void onFreebieResponse(PromoListItem promoListItem, String str) {
                }

                public void onFreebieResponse(String str) {
                    FreebieSelectionActivity.this.handleFreebieListResponse(str);
                    FreebieSelectionActivity.this.confirmButton.setVisibility(0);
                }

                public void onFreebieErrorResponse(String str) {
                    FreebieSelectionActivity.this.handleFreebieErrorResponse(str);
                }
            });
        } else {
            handleFreebieErrorResponse("Something went wrong !!");
        }
    }

    /* access modifiers changed from: private */
    public void handleFreebieErrorResponse(String str) {
        handleNoFreebieDataError(str);
    }

    /* access modifiers changed from: private */
    public void handleFreebieListResponse(String str) {
        List<Freebie> filteredList = getFilteredList(PromoList.Companion.updateFreebies(str));
        hideVerifyLoader();
        if (filteredList == null || filteredList.size() <= 0) {
            handleNoFreebieDataError(getString(R.string.promo_something_went_wrong));
        } else {
            setFreebieList(filteredList, false);
        }
    }

    private void handleNoFreebieDataError(String str) {
        DialogUtility.showDialog(this, str, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                    FreebieSelectionActivity.this.setResult(0);
                    FreebieSelectionActivity.this.finish();
                }
            }
        });
    }

    private void setFreebieList(List<Freebie> list, boolean z) {
        if (list != null) {
            this.rvFreebieList.setAdapter(new FreebieSelectionAdapter(this, list, z, this));
            this.rvFreebieList.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    private void initViews() {
        this.freebieIcon = (ImageView) findViewById(R.id.app_logo);
        setupToolbar((Toolbar) findViewById(R.id.toolbar));
        this.viewMessage = (TextView) findViewById(R.id.txv_fb_message);
        this.confirmButton = (TextView) findViewById(R.id.btn_confirm);
        this.rvFreebieList = (RecyclerView) findViewById(R.id.rv_fb_list);
        this.confirmButton.setEnabled(false);
        this.confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FreebieSelectionActivity.this.handleFreebieSelect();
            }
        });
    }

    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        Drawable drawable = getResources().getDrawable(R.drawable.freebie);
        if (drawable != null) {
            this.freebieIcon.setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: private */
    public void handleFreebieSelect() {
        handleSelectFreebieGA();
        this.selectedFreebieData.put(Integer.valueOf(this.currentFreebieListIndex), this.selectedFreebie);
        if (this.selectedFreebieData.size() < this.freebieListCount) {
            Intent intent = new Intent(this, FreebieSelectionActivity.class);
            intent.putExtra(Constants.DATA_MAP, getIntent().getSerializableExtra(Constants.DATA_MAP));
            intent.putExtra("PROMO_DATA", (ArrayList) this.promoDatas);
            intent.putExtra(PromoUtils.VIEW_MODE, false);
            intent.putExtra(PromoUtils.PROMO_FREEBIE_INDEX, this.currentFreebieListIndex + 1);
            intent.putExtra(PromoUtils.BULK_ADD_DATA, this.selectedFreebieData);
            startActivityForResult(intent, 1001);
            return;
        }
        showVerifyLoader();
        PromoHelper.Companion.getInstance().bulkAddFreebie(this.promoDatas, this.selectedFreebieData, this);
    }

    private void handleSelectFreebieGA() {
        final String string = getString(Constants.KEY_DISCOVERABILITY);
        Freebie freebie = this.selectedFreebie;
        final String brand = freebie != null ? freebie.getBrand() : "";
        final String string2 = getString(Constants.KEY_CATEGORY_MAP);
        Utility.INSTANCE.sendBankOffersEvent(this, new HashMap<String, Object>() {
            {
                put("eventName", "confirm_freebie_clicked");
                put("event_action", "confirm_freebie_clicked");
                put("event_category", string);
                put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/cart");
                FreebieSelectionActivity freebieSelectionActivity = FreebieSelectionActivity.this;
                put("event_label", freebieSelectionActivity.getEventLabel(string2, brand, freebieSelectionActivity.selectedFreebie != null ? FreebieSelectionActivity.this.selectedFreebie.getPid() : 0));
                put("vertical_name", GAUtil.MARKET_PLACE);
                put("user_id", PromoUtils.getCustomerId());
            }
        });
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> getEventLabel(String str, String str2, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("category", str);
        hashMap.put(CLPConstants.BRAND_PARAMS, str2);
        hashMap.put(com.appsflyer.share.Constants.URL_MEDIA_SOURCE, Integer.valueOf(i2));
        return hashMap;
    }

    public void onPromoSelect(Freebie freebie) {
        this.confirmButton.setEnabled(true);
        this.confirmButton.setVisibility(0);
        this.selectedFreebie = freebie;
    }

    public void onFreebieApplySuccess(String str) {
        handleFreebieApplyGA();
        hideVerifyLoader();
        setResult(-1);
        finish();
    }

    private void handleFreebieApplyGA() {
        final String str;
        final String string = getString(Constants.KEY_DISCOVERABILITY);
        Freebie freebie = this.selectedFreebie;
        final String name = freebie != null ? freebie.getName() : "";
        Freebie freebie2 = this.selectedFreebie;
        if (freebie2 != null) {
            str = freebie2.getBrand();
        } else {
            str = "";
        }
        final String string2 = getString(Constants.KEY_CATEGORY_MAP);
        Utility.INSTANCE.sendBankOffersEvent(this, new HashMap<String, Object>() {
            {
                put("eventName", "freebie_successfuly_added");
                put("event_action", "freebie_successfuly_added");
                put("event_category", string);
                FreebieSelectionActivity freebieSelectionActivity = FreebieSelectionActivity.this;
                put("event_label2", freebieSelectionActivity.getEventLabel(string2, str, freebieSelectionActivity.selectedFreebie != null ? FreebieSelectionActivity.this.selectedFreebie.getPid() : 0));
                put("user_id", PromoUtils.getCustomerId());
                put("event_label", FreebieSelectionActivity.this.getNewEventLabel("/cart", name));
            }
        });
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> getNewEventLabel(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("screen_name", str);
        hashMap.put("product", str2);
        hashMap.put("list_name", getPromoDataUrl());
        return hashMap;
    }

    public void onFreebieApplyFailure(String str) {
        hideVerifyLoader();
        DialogUtility.showDialog(this, "Error", str, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001 && i3 == -1) {
            setResult(i3, intent);
            finish();
        }
    }

    private List<Freebie> getFilteredList(List<Freebie> list) {
        if (list == null) {
            return new ArrayList();
        }
        for (Freebie next : list) {
            if (!next.isStock()) {
                list.remove(next);
            }
        }
        return list;
    }
}
