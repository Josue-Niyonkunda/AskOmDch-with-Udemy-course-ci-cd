package samePackage.constants;

public enum EndPoints {
// instead of enum class we may use class endPoint
    STORE("/store"),
    HOME("/home"),
        ACCOUNT("/account"),
    CART("/cart");
    public final String url;

    EndPoints(String url) {
        this.url=url;
    }


}
