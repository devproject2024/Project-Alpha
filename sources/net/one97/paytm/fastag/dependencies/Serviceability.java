package net.one97.paytm.fastag.dependencies;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.replacement.CJRCustomTextModel;
import net.one97.paytm.fastag.model.CJRImpsRefundConsultView;

public class Serviceability extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "benchmark_price")
    private int benchmark_price;
    @b(a = "custom_texts")
    private CJRCustomTextModel custom_texts;
    @b(a = "lmd")
    private int lmd;
    private String mConsultViewJsonObjectString;
    @b(a = "refundConsultInfo")
    private CJRImpsRefundConsultView refundConsultInfo;
    @b(a = "seller_info")
    private SellerAddress seller_info;
    @b(a = "isServiceable")
    private int serviceable;
    @b(a = "template")
    public ArrayList<ReturnResponseTitle> template;
    @b(a = "type")
    private int type;

    public static class ReturnResponseSubTitle extends IJRPaytmDataModel {
        private static final long serialVersionUID = 1;
        @b(a = "deeplink")
        public String deeplink;
        @b(a = "heading")
        public String heading;
        @b(a = "__highlightedText")
        public String highlightedText;
    }

    public static class ReturnResponseTitle extends IJRPaytmDataModel {
        private static final long serialVersionUID = 1;
        @b(a = "Subtitles")
        public ArrayList<ReturnResponseSubTitle> Subtitles;
        @b(a = "title")
        public String title;
    }

    public CJRCustomTextModel getCustom_text() {
        return this.custom_texts;
    }

    public void setCustom_text(CJRCustomTextModel cJRCustomTextModel) {
        this.custom_texts = cJRCustomTextModel;
    }

    public int getBenchmark_price() {
        return this.benchmark_price;
    }

    public void setBenchmark_price(int i2) {
        this.benchmark_price = i2;
    }

    public int getServiceable() {
        return this.serviceable;
    }

    public int getLmd() {
        return this.lmd;
    }

    public int getType() {
        return this.type;
    }

    public SellerAddress getSeller_info() {
        return this.seller_info;
    }

    public CJRImpsRefundConsultView getmImpsRefundConsultView() {
        return this.refundConsultInfo;
    }

    public void setmImpsRefundConsultView(CJRImpsRefundConsultView cJRImpsRefundConsultView) {
        this.refundConsultInfo = cJRImpsRefundConsultView;
    }

    public String getmConsultViewJsonObjectString() {
        return this.mConsultViewJsonObjectString;
    }

    public void setmConsultViewJsonObjectString(String str) {
        this.mConsultViewJsonObjectString = str;
    }
}
