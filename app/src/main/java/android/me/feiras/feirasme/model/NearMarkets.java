package android.me.feiras.feirasme.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by danielideriba on 8/4/15.
 */
public abstract class NearMarkets {
    private static final String TAG = NearMarkets.class.getSimpleName();

    //@SerializedName("nearMarkets")

    // Near Markets

    //Root lol
    public static final String MARKET_ROOT = "nearMarkets";

    //Obj ID
    public static final String MARKET_ID_DATE = "date";

    //Obj Address
    public static final String MARKET_ADDRESS = "address";
    public static final String MARKET_ADDRESS_CITY = "city";
    public static final String MARKET_ADDRESS_NUMBER = "number";
    public static final String MARKET_ADDRESS_QUARTER = "quarter";
    public static final String MARKET_ADDRESS_STATE = "state";
    public static final String MARKET_ADDRESS_STREET = "street";

    //Obj Location
    public static final String MARKET_LAT = "lat";
    public static final String MARKET_LNG = "lng";

    //Obj Area
    public static final String MARKET_AREA = "area";

    //Obj Location
    public static final String MARKET_LOCATION = "location";
    public static final String MARKET_LOCATION_X = "x";
    public static final String MARKET_LOCATION_Y = "y";

    //Obj Status
    public static final String MARKET_STATUS = "status";
    public static final String MARKET_STATUS_NAME = "name";

    //Obj Weekday
    public static final String MARKET_WEEKDAY = "weekday";

    private int mDate;
    private String mCity;
    private String mNumber;
    private String mQuarter;
    private String mState;
    private String mStreet;
    private boolean mArea;
    private String mLocationX;
    private String mLocationY;
    private String mStatusName;
    private String mWeekday;

    public void setmDate(int mDate) {
        this.mDate = mDate;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public void setmQuarter(String mQuarter) {
        this.mQuarter = mQuarter;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public void setmArea(boolean mArea) {
        this.mArea = mArea;
    }

    public void setmStreet(String mStreet) {
        this.mStreet = mStreet;
    }

    public void setmLocationX(String mLocationX) {
        this.mLocationX = mLocationX;
    }

    public void setmLocationY(String mLocationY) {
        this.mLocationY = mLocationY;
    }

    public void setmStatusName(String mStatusName) {
        this.mStatusName = mStatusName;
    }

    public void setmWeekday(String mWeekday) {
        this.mWeekday = mWeekday;
    }

    public int getmDate() {
        return mDate;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmNumber() {
        return mNumber;
    }

    public String getmQuarter() {
        return mQuarter;
    }

    public String getmState() {
        return mState;
    }

    public boolean ismArea() {
        return mArea;
    }

    public String getmStreet() {
        return mStreet;
    }

    public String getmLocationX() {
        return mLocationX;
    }

    public String getmLocationY() {
        return mLocationY;
    }

    public String getmStatusName() {
        return mStatusName;
    }

    public String getmWeekday() {
        return mWeekday;
    }
}
