package net.one97.paytm.o2o.movies.one_pager;

public enum b {
    FEATURED(1),
    DATE_FILTER(2),
    CATEGORY_ITEMS(3),
    BROWSE(4),
    OFFERS(5),
    MOVIE(6);
    
    public int id;

    private b(int i2) {
        this.id = i2;
    }
}
