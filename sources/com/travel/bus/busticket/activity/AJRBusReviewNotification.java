package com.travel.bus.busticket.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.g.h;
import com.travel.bus.pojo.busticket.CJRBusRating;
import com.travel.bus.pojo.busticket.rnr.CJRRnRDetailsModel;

public class AJRBusReviewNotification extends AJRBusBaseActivity implements View.OnClickListener, b {
    private String mChannel;
    private String mContentTitle;
    private String mDescription;
    private TextView mDescriptionView;
    /* access modifiers changed from: private */
    public Dialog mDialog;
    private String mOrderID;
    private String mRatingUrl;
    private String mSecretKey;
    private int mStarCount = 0;
    private Button mSubmitButton;
    private TextView mTitleView;
    private TextView mTvBusName;
    private ImageView starFive;
    private ImageView starFour;
    private ImageView starOne;
    private ImageView starThree;
    private ImageView starTwo;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_bus_notification_review_layout);
        this.mDescription = getIntent().getStringExtra(RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        this.mContentTitle = getIntent().getStringExtra("contentTitle");
        this.mRatingUrl = getIntent().getStringExtra("ratingUrl");
        this.mSecretKey = getIntent().getStringExtra("secretKey");
        this.mOrderID = getIntent().getStringExtra("orderID");
        this.mChannel = getIntent().getStringExtra("channel");
        showModal();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void showModal() {
        this.mDialog = new Dialog(this);
        this.mDialog.requestWindowFeature(1);
        this.mDialog.setContentView(R.layout.pre_b_push_notification_dialog);
        this.mDialog.getWindow().setFlags(32, 32);
        this.mTvBusName = (TextView) this.mDialog.findViewById(R.id.tv_bus_name_notification);
        this.starOne = (ImageView) this.mDialog.findViewById(R.id.star1);
        this.starTwo = (ImageView) this.mDialog.findViewById(R.id.star2);
        this.starThree = (ImageView) this.mDialog.findViewById(R.id.star3);
        this.starFour = (ImageView) this.mDialog.findViewById(R.id.star4);
        this.starFive = (ImageView) this.mDialog.findViewById(R.id.star5);
        this.mSubmitButton = (Button) this.mDialog.findViewById(R.id.submit_button);
        this.mTitleView = (TextView) this.mDialog.findViewById(R.id.title);
        this.mDescriptionView = (TextView) this.mDialog.findViewById(R.id.description);
        this.mTitleView.setText(this.mContentTitle);
        this.mDescriptionView.setText(this.mDescription);
        this.starOne.setOnClickListener(this);
        this.starTwo.setOnClickListener(this);
        this.starThree.setOnClickListener(this);
        this.starFour.setOnClickListener(this);
        this.starFive.setOnClickListener(this);
        this.mSubmitButton.setOnClickListener(this);
        this.mDialog.show();
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return true;
                }
                AJRBusReviewNotification.this.finish();
                AJRBusReviewNotification.this.mDialog.dismiss();
                return true;
            }
        });
        callOperatorName();
    }

    private void callOperatorName() {
        String rnRDetailsAPI = getRnRDetailsAPI();
        if (rnRDetailsAPI != null && URLUtil.isValidUrl(rnRDetailsAPI)) {
            h.a(Uri.parse(rnRDetailsAPI).buildUpon().appendQueryParameter("s", this.mSecretKey).appendQueryParameter(ContactsConstant.LOCALE, com.paytm.utility.b.g()).build().toString(), this, this);
        }
    }

    private String getRnRDetailsAPI() {
        a.a();
        return a.b().f("RNRDetails");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.star1) {
            this.mStarCount = 1;
            this.starOne.setImageResource(R.drawable.bus_rating_star_blue);
            this.starTwo.setImageResource(R.drawable.bus_rating_star_normal);
            this.starThree.setImageResource(R.drawable.bus_rating_star_normal);
            this.starFour.setImageResource(R.drawable.bus_rating_star_normal);
            this.starFive.setImageResource(R.drawable.bus_rating_star_normal);
        } else if (id == R.id.star2) {
            this.mStarCount = 2;
            this.starOne.setImageResource(R.drawable.bus_rating_star_blue);
            this.starTwo.setImageResource(R.drawable.bus_rating_star_blue);
            this.starThree.setImageResource(R.drawable.bus_rating_star_normal);
            this.starFour.setImageResource(R.drawable.bus_rating_star_normal);
            this.starFive.setImageResource(R.drawable.bus_rating_star_normal);
        } else if (id == R.id.star3) {
            this.mStarCount = 3;
            this.starOne.setImageResource(R.drawable.bus_rating_star_blue);
            this.starTwo.setImageResource(R.drawable.bus_rating_star_blue);
            this.starThree.setImageResource(R.drawable.bus_rating_star_blue);
            this.starFour.setImageResource(R.drawable.bus_rating_star_normal);
            this.starFive.setImageResource(R.drawable.bus_rating_star_normal);
        } else if (id == R.id.star4) {
            this.mStarCount = 4;
            this.starOne.setImageResource(R.drawable.bus_rating_star_blue);
            this.starTwo.setImageResource(R.drawable.bus_rating_star_blue);
            this.starThree.setImageResource(R.drawable.bus_rating_star_blue);
            this.starFour.setImageResource(R.drawable.bus_rating_star_blue);
            this.starFive.setImageResource(R.drawable.bus_rating_star_normal);
        } else if (id == R.id.star5) {
            this.mStarCount = 5;
            this.starOne.setImageResource(R.drawable.bus_rating_star_blue);
            this.starTwo.setImageResource(R.drawable.bus_rating_star_blue);
            this.starThree.setImageResource(R.drawable.bus_rating_star_blue);
            this.starFour.setImageResource(R.drawable.bus_rating_star_blue);
            this.starFive.setImageResource(R.drawable.bus_rating_star_blue);
        } else if (id == R.id.submit_button && this.mStarCount != 0) {
            this.mDialog.dismiss();
            this.mRatingUrl = Uri.parse(this.mRatingUrl).buildUpon().appendQueryParameter("r", String.valueOf(this.mStarCount)).appendQueryParameter("action", "true").appendQueryParameter("secret", this.mSecretKey).build().toString();
            getBusRnRNotificationApiCall();
            Intent intent = new Intent(this, AJRBusRatingScreenActivity.class);
            intent.putExtra("url", this.mRatingUrl);
            intent.putExtra("star_count", this.mStarCount);
            intent.putExtra("secretKey", this.mSecretKey);
            intent.putExtra("orderID", this.mOrderID);
            intent.putExtra("channel", this.mChannel);
            startActivity(intent);
            finish();
        }
    }

    private void getBusRnRNotificationApiCall() {
        a.a();
        this.mRatingUrl = a.b().f("busRatings");
        this.mRatingUrl = Uri.parse(this.mRatingUrl).buildUpon().appendQueryParameter("r", String.valueOf(this.mStarCount)).appendQueryParameter("s", this.mSecretKey).appendQueryParameter(ContactsConstant.LOCALE, com.paytm.utility.b.g()).build().toString();
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.BUS;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = this.mRatingUrl;
        bVar.f42881e = null;
        bVar.f42882f = null;
        bVar.f42883g = null;
        bVar.f42885i = new CJRBusRating();
        bVar.j = this;
        bVar.n = a.b.SILENT;
        bVar.o = "bus-rating-page";
        bVar.l().a();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!isFinishing() && (iJRPaytmDataModel instanceof CJRRnRDetailsModel)) {
            CJRRnRDetailsModel cJRRnRDetailsModel = (CJRRnRDetailsModel) iJRPaytmDataModel;
            if (cJRRnRDetailsModel.getBody() != null && cJRRnRDetailsModel.getBody().getData() != null) {
                String travelsName = cJRRnRDetailsModel.getBody().getData().getTravelsName();
                if (this.mTvBusName != null && !TextUtils.isEmpty(travelsName)) {
                    this.mTvBusName.setText(travelsName);
                    this.mTvBusName.setVisibility(0);
                }
            }
        }
    }
}
