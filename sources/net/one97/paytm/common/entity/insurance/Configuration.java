package net.one97.paytm.common.entity.insurance;

import kotlin.g.b.k;

public final class Configuration {
    private String insuranceProduct;
    private Integer insurance_type;
    private String price;

    public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, Integer num, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = configuration.price;
        }
        if ((i2 & 2) != 0) {
            num = configuration.insurance_type;
        }
        if ((i2 & 4) != 0) {
            str2 = configuration.insuranceProduct;
        }
        return configuration.copy(str, num, str2);
    }

    public final String component1() {
        return this.price;
    }

    public final Integer component2() {
        return this.insurance_type;
    }

    public final String component3() {
        return this.insuranceProduct;
    }

    public final Configuration copy(String str, Integer num, String str2) {
        return new Configuration(str, num, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return k.a((Object) this.price, (Object) configuration.price) && k.a((Object) this.insurance_type, (Object) configuration.insurance_type) && k.a((Object) this.insuranceProduct, (Object) configuration.insuranceProduct);
    }

    public final int hashCode() {
        String str = this.price;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.insurance_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.insuranceProduct;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Configuration(price=" + this.price + ", insurance_type=" + this.insurance_type + ", insuranceProduct=" + this.insuranceProduct + ")";
    }

    public Configuration(String str, Integer num, String str2) {
        this.price = str;
        this.insurance_type = num;
        this.insuranceProduct = str2;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final Integer getInsurance_type() {
        return this.insurance_type;
    }

    public final void setInsurance_type(Integer num) {
        this.insurance_type = num;
    }

    public final String getInsuranceProduct() {
        return this.insuranceProduct;
    }

    public final void setInsuranceProduct(String str) {
        this.insuranceProduct = str;
    }
}
