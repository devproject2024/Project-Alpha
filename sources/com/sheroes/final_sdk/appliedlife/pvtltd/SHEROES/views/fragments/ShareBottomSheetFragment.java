package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.google.android.material.bottomsheet.b;
import com.google.android.play.core.splitcompat.a;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Config;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class ShareBottomSheetFragment extends b implements View.OnClickListener {
    private static final String EVENT_NAME = "Event name";
    private static final String IS_APP_LINK = "Is App Link";
    private static final String IS_CHALLENGE = "Is Challenge";
    private static final String IS_IMAGE_SHARE = "Is Image Share";
    private static final String PROPERTY = "Property";
    private static final String SCREEN_LABEL = "ShareBottomSheetFragment";
    private static final String SHARE_COPYLINK = "copy link";
    private static final String SHARE_DEEPLINK = "share deep link";
    private static final String SHARE_DIALOG_TITLE = "Share Dialog Title";
    private static final String SHARE_IMAGE = "share image";
    private static final String SHARE_TEXT = "share text";
    private static final String SHOW_TITLE = "Show Title";
    private boolean isUserShareBitmap;
    Preference<Configuration> mConfiguration;
    private Event mEventName;
    private boolean mIsAppLink;
    private boolean mIsChallenge;
    private boolean mIsImageShare;
    private HashMap<String, Object> mProperties;
    private String mShareCopyLink;
    private String mShareDeepLinkUrl;
    private String mShareDialogTitle;
    private String mShareImageUrl;
    private String mShareText;
    private boolean mShowTitle;
    private String mSourceScreen;
    private ClipData myClip;
    private ClipboardManager myClipboard;
    TextView title;
    private Bitmap userShareBitmap;

    public Dialog onCreateDialog(Bundle bundle) {
        SheroesSdk.getAppComponent(getContext()).inject(this);
        this.myClipboard = (ClipboardManager) getContext().getSystemService("clipboard");
        if (getArguments() != null) {
            if (getArguments().getParcelable(AppConstants.CHALLENGE_GRATIFICATION_OBJ) != null) {
                getArguments().getParcelable(AppConstants.CHALLENGE_GRATIFICATION_OBJ);
                byte[] byteArray = getArguments().getByteArray(H5ResourceHandlerUtil.IMAGE);
                this.userShareBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                this.isUserShareBitmap = true;
            }
            this.mShareDeepLinkUrl = getArguments().getString(SHARE_DEEPLINK);
            this.mShareImageUrl = getArguments().getString(SHARE_IMAGE);
            this.mShareText = getArguments().getString(SHARE_TEXT);
            this.mShareCopyLink = getArguments().getString(SHARE_COPYLINK);
            this.mShareDialogTitle = getArguments().getString(SHARE_DIALOG_TITLE);
            this.mSourceScreen = getArguments().getString(BaseActivity.SOURCE_SCREEN);
            this.mIsImageShare = getArguments().getBoolean(IS_IMAGE_SHARE, false);
            this.mIsChallenge = getArguments().getBoolean(IS_CHALLENGE, false);
            this.mShowTitle = getArguments().getBoolean(SHOW_TITLE, false);
            this.mIsAppLink = getArguments().getBoolean(IS_APP_LINK, false);
            if (getArguments().getSerializable(PROPERTY) != null) {
                this.mProperties = (HashMap) getArguments().getSerializable(PROPERTY);
            } else {
                this.mProperties = null;
            }
            if (getArguments().getSerializable(EVENT_NAME) != null) {
                this.mEventName = (Event) getArguments().getSerializable(EVENT_NAME);
            } else {
                this.mEventName = null;
            }
        }
        return super.onCreateDialog(bundle);
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.dialog_sheroes_share, (ViewGroup) null);
        dialog.setContentView(inflate);
        ((LinearLayout) inflate.findViewById(R.id.sheroes_layout_copy_link)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.sheroes_image_copy_link)).setOnClickListener(this);
        ((LinearLayout) inflate.findViewById(R.id.sheroes_layout_whatsapp)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.sheroes_image_whatsapp)).setOnClickListener(this);
        ((TextView) inflate.findViewById(R.id.sheroes_text_whatsapp)).setOnClickListener(this);
        this.title = (TextView) inflate.findViewById(R.id.sheroes_title);
        if (this.mShowTitle) {
            this.title.setVisibility(0);
        } else {
            this.title.setVisibility(8);
        }
        if (CommonUtil.isNotEmpty(this.mShareDialogTitle)) {
            this.title.setVisibility(0);
            this.title.setText(this.mShareDialogTitle);
            return;
        }
        this.title.setVisibility(8);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sheroes_layout_whatsapp || id == R.id.sheroes_image_whatsapp || id == R.id.sheroes_text_whatsapp) {
            onWhatsAppClick();
        }
        if (id == R.id.sheroes_layout_copy_link || id == R.id.sheroes_image_copy_link || id == R.id.sheroes_text_copy_link) {
            onCopyLinkClick();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public static ShareBottomSheetFragment showDialog(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, boolean z3, boolean z4, String str6) {
        ShareBottomSheetFragment shareBottomSheetFragment = new ShareBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SHARE_TEXT, str);
        bundle.putString(SHARE_DEEPLINK, str3);
        bundle.putString(SHARE_IMAGE, str2);
        bundle.putString(SHARE_COPYLINK, str5);
        bundle.putBoolean(IS_IMAGE_SHARE, z);
        bundle.putBoolean(IS_CHALLENGE, z2);
        bundle.putBoolean(SHOW_TITLE, z3);
        bundle.putBoolean(IS_APP_LINK, z4);
        bundle.putString(SHARE_DIALOG_TITLE, str6);
        shareBottomSheetFragment.setArguments(bundle);
        bundle.putString(BaseActivity.SOURCE_SCREEN, str4);
        shareBottomSheetFragment.show(appCompatActivity.getSupportFragmentManager(), SCREEN_LABEL);
        return shareBottomSheetFragment;
    }

    public static ShareBottomSheetFragment showDialog(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, boolean z3, boolean z4, Event event, HashMap<String, Object> hashMap) {
        ShareBottomSheetFragment shareBottomSheetFragment = new ShareBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SHARE_TEXT, str);
        bundle.putString(SHARE_DEEPLINK, str3);
        bundle.putString(SHARE_IMAGE, str2);
        bundle.putString(SHARE_COPYLINK, str5);
        bundle.putBoolean(IS_IMAGE_SHARE, z);
        bundle.putBoolean(IS_CHALLENGE, z2);
        bundle.putBoolean(SHOW_TITLE, z3);
        bundle.putBoolean(IS_APP_LINK, z4);
        bundle.putSerializable(PROPERTY, hashMap);
        bundle.putSerializable(EVENT_NAME, event);
        shareBottomSheetFragment.setArguments(bundle);
        bundle.putString(BaseActivity.SOURCE_SCREEN, str4);
        shareBottomSheetFragment.show(appCompatActivity.getSupportFragmentManager(), SCREEN_LABEL);
        return shareBottomSheetFragment;
    }

    public void onWhatsAppClick() {
        if (this.isUserShareBitmap) {
            Config.getConfig();
        } else if (!this.mIsImageShare) {
            if (this.mShowTitle && this.mIsAppLink) {
                Preference<Configuration> preference = this.mConfiguration;
                String str = (preference == null || !preference.isSet() || this.mConfiguration.get() == null || this.mConfiguration.get().configData == null || !CommonUtil.isNotEmpty(this.mConfiguration.get().configData.appInviteMessageWhatsApp)) ? "" : this.mConfiguration.get().configData.appInviteMessageWhatsApp;
                this.mShareText = str + this.mShareDeepLinkUrl;
            }
            CommonUtil.shareLinkToWhatsApp(getContext(), this.mShareText);
            new EventProperty.Builder().sharedTo(BaseActivity.SHARE_WHATSAPP);
            if (this.mProperties == null) {
                this.mProperties = new HashMap<>();
            }
            this.mProperties.put(EventProperty.SHARED_TO.getString(), BaseActivity.SHARE_WHATSAPP);
            AnalyticsManager.trackEvent(this.mEventName, this.mSourceScreen, (Map<String, Object>) this.mProperties);
        }
    }

    public void onCopyLinkClick() {
        if (CommonUtil.isNotEmpty(this.mShareCopyLink)) {
            this.myClip = ClipData.newPlainText("copy_link", this.mShareCopyLink);
            this.myClipboard.setPrimaryClip(this.myClip);
            if (StringUtil.isNotNullOrEmptyString(this.mSourceScreen) && this.mSourceScreen.equalsIgnoreCase(AppConstants.CHALLENGE_GRATIFICATION_SCREEN)) {
                HashMap<String, Object> build = new EventProperty.Builder().sharedTo("Copy Link").build();
                build.put(EventProperty.URL.getString(), this.mShareImageUrl);
                AnalyticsManager.trackEvent(Event.CHALLENGE_SHARED, this.mSourceScreen, (Map<String, Object>) build);
            } else if (StringUtil.isNotNullOrEmptyString(this.mShareImageUrl)) {
                AnalyticsManager.trackEvent(Event.IMAGE_COPY_LINK, this.mSourceScreen, (Map<String, Object>) new EventProperty.Builder().id(this.mShareImageUrl).build());
            } else {
                AnalyticsManager.trackEvent(Event.FRIEND_INVITED, this.mSourceScreen, (Map<String, Object>) new EventProperty.Builder().sharedTo("Copy Link").build());
            }
            dismiss();
            Toast.makeText(getContext(), "Link Copied!", 0).show();
        }
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }
}
