package net.one97.paytm.games.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGameInfo extends IJRPaytmDataModel {
    @b(a = "attributes")
    public CJRGameAttribute attributes;
    @b(a = "category_id")
    private String category_id;
    @b(a = "gameBattleId")
    public String gameBattleId;
    @b(a = "image_url")
    public String image_url;
    @b(a = "name")
    public String name;
    @b(a = "product_id")
    public int product_id;

    public int getProduct_id() {
        return this.product_id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public CJRGameAttribute getAttributes() {
        return this.attributes;
    }

    public void setCategory_id(String str) {
        this.category_id = str;
    }

    public static class CJRGameAttribute implements IJRDataModel {
        @b(a = "content_provider")
        public String content_provider;
        @b(a = "delivery_mode")
        private String delivery_mode;
        @b(a = "exit_page_api_paytm")
        private String exit_page_api_paytm;
        @b(a = "exit_page_id_paytm")
        private int exit_page_id_paytm;
        @b(a = "hide_in_game_header")
        private boolean hide_in_game_header;
        @b(a = "html_5_link")
        public String html_5_link;
        @b(a = "image_4")
        private String image_4;
        @b(a = "operator")
        public String operator;
        @b(a = "orientation")
        public String orientation;
        @b(a = "recent_tab_icon")
        public String recent_tab_icon;
        @b(a = "share_gamepindpro")
        private String share_gamepindpro;
        @b(a = "short_description")
        private String short_description;

        public void setRecentTabIcon(String str) {
            this.recent_tab_icon = str;
        }

        public String getRecentTabIcon() {
            return this.recent_tab_icon;
        }

        public String getImage4() {
            return this.image_4;
        }

        public String getDeliveryMode() {
            return this.delivery_mode;
        }

        public String getShortDescription() {
            return this.short_description;
        }

        public void setExitPageId(int i2) {
            this.exit_page_id_paytm = i2;
        }

        public int getExitPageId() {
            return this.exit_page_id_paytm;
        }

        public void setExitPageApi(String str) {
            this.exit_page_api_paytm = str;
        }

        public String getExitPageApi() {
            return this.exit_page_api_paytm;
        }

        public void setHideInGameHeader(boolean z) {
            this.hide_in_game_header = z;
        }

        public boolean getHideInGameHeader() {
            return this.hide_in_game_header;
        }

        public String getShareGamepindPro() {
            return this.share_gamepindpro;
        }

        public void setShareGamepindPro(String str) {
            this.share_gamepindpro = str;
        }
    }
}
