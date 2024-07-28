package com.paytmmall.clpartifact.utils;

import com.google.gson.a.c;
import com.google.gson.f;
import com.paytmmall.clpartifact.ga.GaEvent;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddToCartGaObject implements GaEvent {
    @c(a = "add")
    private AddObj addObj;
    @c(a = "'currencyCode'")
    private String currencyCode;

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public AddObj getAddObj() {
        return this.addObj;
    }

    public void setAddObj(AddObj addObj2) {
        this.addObj = addObj2;
    }

    public String toJson() {
        return new f().a((Object) this, (Type) AddToCartGaObject.class);
    }

    public static class AddObj {
        @c(a = "'products'")
        private ArrayList<Product> products;

        public ArrayList<Product> getProducts() {
            return this.products;
        }

        public void setProducts(ArrayList<Product> arrayList) {
            this.products = arrayList;
        }
    }

    public static class Product {
        @c(a = "brand")
        private String brand;
        @c(a = "category")
        private String category;
        @c(a = "dimension25")
        private String dimension25;
        @c(a = "dimension31")
        private String dimension31;
        @c(a = "dimension38")
        private String dimension38;
        @c(a = "dimension39")
        private String dimension39;
        @c(a = "dimension40")
        private String dimension40;
        @c(a = "dimension41")
        private String dimension41;
        @c(a = "dimension43")
        private String dimension43;
        @c(a = "dimension79")
        private String dimension79;
        @c(a = "dimension80")
        private String dimension80;
        @c(a = "dimension24")
        private String dimention24;
        @c(a = "id")
        private String id;
        @c(a = "name")
        private String name;
        @c(a = "position")
        private String position;
        @c(a = "price")
        private String price;
        @c(a = "'quantity'")
        private String quantity;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getPrice() {
            return this.price;
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public String getBrand() {
            return this.brand;
        }

        public void setBrand(String str) {
            this.brand = str;
        }

        public String getCategory() {
            return this.category;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public String getQuantity() {
            return this.quantity;
        }

        public void setQuantity(String str) {
            this.quantity = str;
        }

        public String getPosition() {
            return this.position;
        }

        public void setPosition(String str) {
            this.position = str;
        }

        public String getDimention24() {
            return this.dimention24;
        }

        public void setDimention24(String str) {
            this.dimention24 = str;
        }

        public String getDimension25() {
            return this.dimension25;
        }

        public void setDimension25(String str) {
            this.dimension25 = str;
        }

        public String getDimension31() {
            return this.dimension31;
        }

        public void setDimension31(String str) {
            this.dimension31 = str;
        }

        public String getDimension38() {
            return this.dimension38;
        }

        public void setDimension38(String str) {
            this.dimension38 = str;
        }

        public String getDimension39() {
            return this.dimension39;
        }

        public void setDimension39(String str) {
            this.dimension39 = str;
        }

        public String getDimension40() {
            return this.dimension40;
        }

        public void setDimension40(String str) {
            this.dimension40 = str;
        }

        public String getDimension41() {
            return this.dimension41;
        }

        public void setDimension41(String str) {
            this.dimension41 = str;
        }

        public String getDimension43() {
            return this.dimension43;
        }

        public void setDimension43(String str) {
            this.dimension43 = str;
        }

        public String getDimension79() {
            return this.dimension79;
        }

        public void setDimension79(String str) {
            this.dimension79 = str;
        }

        public String getDimension80() {
            return this.dimension80;
        }

        public void setDimension80(String str) {
            this.dimension80 = str;
        }
    }
}
