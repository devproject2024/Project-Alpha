package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLandingPageMetaData implements IJRDataModel {
    @b(a = "buttons")
    private Buttons buttons;
    @b(a = "doc")
    private Doc doc;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "promocode")
    private Details promocode;
    @b(a = "subtitle")
    private String subtitle;
    @b(a = "title")
    private String title;

    public Buttons getButtons() {
        return this.buttons;
    }

    public void setButtons(Buttons buttons2) {
        this.buttons = buttons2;
    }

    public Doc getDoc() {
        return this.doc;
    }

    public void setDoc(Doc doc2) {
        this.doc = doc2;
    }

    public Details getPromocode() {
        return this.promocode;
    }

    public void setPromocode(Details details) {
        this.promocode = details;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public class Buttons implements IJRDataModel {
        @b(a = "1")
        private Details btnOne;
        @b(a = "2")
        private Details btnTwo;

        public Buttons() {
        }

        public Details getBtnOne() {
            return this.btnOne;
        }

        public void setBtnOne(Details details) {
            this.btnOne = details;
        }

        public Details getBtnTwo() {
            return this.btnTwo;
        }

        public void setBtnTwo(Details details) {
            this.btnTwo = details;
        }
    }

    public class Details implements IJRDataModel {
        @b(a = "text")
        private String text;
        @b(a = "url")
        private String url;
        @b(a = "visibility")
        private String visibility;

        public Details() {
        }

        public String getVisibility() {
            return this.visibility;
        }

        public void setVisibility(String str) {
            this.visibility = str;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public class Doc implements IJRDataModel {
        @b(a = "heading")
        private String heading;
        @b(a = "subheadings")
        private Subheadings subheadings;
        @b(a = "url")
        private String url;

        public Doc() {
        }

        public String getHeading() {
            return this.heading;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setHeading(String str) {
            this.heading = str;
        }

        public Subheadings getSubheadings() {
            return this.subheadings;
        }

        public void setSubheadings(Subheadings subheadings2) {
            this.subheadings = subheadings2;
        }
    }

    public class Subheadings implements IJRDataModel {
        @b(a = "1")
        private Details subHeading1;
        @b(a = "2")
        private Details subHeading2;
        @b(a = "3")
        private Details subHeading3;
        @b(a = "4")
        private Details subHeading4;
        @b(a = "5")
        private Details subHeading5;

        public Subheadings() {
        }

        public Details getSubHeading1() {
            return this.subHeading1;
        }

        public void setSubHeading1(Details details) {
            this.subHeading1 = details;
        }

        public Details getSubHeading2() {
            return this.subHeading2;
        }

        public void setSubHeading2(Details details) {
            this.subHeading2 = details;
        }

        public Details getSubHeading3() {
            return this.subHeading3;
        }

        public void setSubHeading3(Details details) {
            this.subHeading3 = details;
        }

        public Details getSubHeading4() {
            return this.subHeading4;
        }

        public void setSubHeading4(Details details) {
            this.subHeading4 = details;
        }

        public Details getSubHeading5() {
            return this.subHeading5;
        }

        public void setSubHeading5(Details details) {
            this.subHeading5 = details;
        }
    }
}
