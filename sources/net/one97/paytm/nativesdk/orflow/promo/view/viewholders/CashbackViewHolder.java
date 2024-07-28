package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoViewHolderMaker;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;

public class CashbackViewHolder extends BasePromoViewHolder {
    /* access modifiers changed from: private */
    public View flashBackSale;
    private ImageView flashIcon;
    private String flashIconPath = "https://assetscdn1.paytm.com/dexter/weex/images/flash-fill-icon.png?placeholderRequired=false";
    private ImageView flashImage;
    private String flashTextPath = "https://assetscdn1.paytm.com/dexter/weex/images/flash-text-sale.png?placeholderRequired=false";
    private CountDownTimer timer;
    private TextView txvFlashHour;
    private TextView txvFlashMinute;
    private TextView txvFlashSecond;

    public CashbackViewHolder(View view, IPromoViewHolderMaker iPromoViewHolderMaker) {
        super(view, iPromoViewHolderMaker);
        initViews();
    }

    private void initViews() {
        this.flashBackSale = this.itemView.findViewById(R.id.lyt_flash_sale);
        this.txvFlashHour = (TextView) this.itemView.findViewById(R.id.txv_time_hour);
        this.txvFlashMinute = (TextView) this.itemView.findViewById(R.id.txv_time_minute);
        this.txvFlashSecond = (TextView) this.itemView.findViewById(R.id.txv_time_second);
        this.flashImage = (ImageView) this.itemView.findViewById(R.id.flash_sale_icon);
        this.flashIcon = (ImageView) this.itemView.findViewById(R.id.flash_icon);
    }

    /* access modifiers changed from: package-private */
    public void bindView(PromoListItem promoListItem) {
        handleFlashSale(promoListItem);
    }

    private void handleFlashSale(PromoListItem promoListItem) {
        if (PromoUtils.isFlashSale(promoListItem)) {
            Date date = getDate(promoListItem);
            if (date != null && this.promoViewHolderMaker != null) {
                long currentTime = getCurrentTime(this.promoViewHolderMaker.getResponseHeader());
                long time = date.getTime();
                PromoUtils.log("currentTime = " + currentTime + "validUpto = " + time);
                createCountDownTimer(time - currentTime);
                return;
            }
            return;
        }
        this.flashBackSale.setVisibility(8);
    }

    private void createCountDownTimer(long j) {
        if (j > 0) {
            CountDownTimer countDownTimer = this.timer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            updateTime(j / 1000);
            this.timer = new CountDownTimer(j, 1000) {
                public void onTick(long j) {
                    CashbackViewHolder.this.updateTime(j / 1000);
                }

                public void onFinish() {
                    if (CashbackViewHolder.this.flashBackSale != null) {
                        CashbackViewHolder.this.flashBackSale.setVisibility(8);
                    }
                }
            }.start();
            showImage(this.flashImage, this.flashTextPath);
            showImage(this.flashIcon, this.flashIconPath);
            this.flashBackSale.setVisibility(0);
            registerTimer(this.timer);
        }
    }

    private void registerTimer(CountDownTimer countDownTimer) {
        this.promoViewHolderMaker.registerTimer(countDownTimer);
    }

    /* access modifiers changed from: private */
    public void updateTime(long j) {
        setText(this.txvFlashHour, getTimeFormat((int) (j / 3600)));
        setText(this.txvFlashMinute, getTimeFormat((int) ((j % 3600) / 60)));
        setText(this.txvFlashSecond, getTimeFormat(((int) j) % 60));
    }

    private void setText(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
            textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getPaint().measureText(str), textView.getTextSize(), new int[]{Color.parseColor("#FF3E2B"), Color.parseColor("#FFA400")}, (float[]) null, Shader.TileMode.CLAMP));
        }
    }

    private String getTimeFormat(int i2) {
        return i2 >= 10 ? String.valueOf(i2) : "0".concat(String.valueOf(i2));
    }

    private Date getDate(PromoListItem promoListItem) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(promoListItem.getValidUpto());
        } catch (ParseException e2) {
            LogUtility.printStackTrace(e2);
            date = null;
        }
        return adjustDate(date);
    }

    private Date adjustDate(Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime() + Double.valueOf(1.98E7d).longValue());
    }

    private long getCurrentTime(HashMap<String, Object> hashMap) {
        return hashMap != null ? getServerTime(hashMap) : getSystemTime();
    }

    private long getServerTime(HashMap<String, Object> hashMap) {
        try {
            return Double.valueOf(Double.parseDouble(String.valueOf(hashMap.get(Constants.RESPONSE_TIME_KEY))) * 1000.0d).longValue();
        } catch (NumberFormatException e2) {
            LogUtility.printStackTrace(e2);
            return getSystemTime();
        }
    }

    private long getSystemTime() {
        return new Date().getTime();
    }
}
