package aprivate.justoapp.Utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by argrod on 02/05/19.
 */

public class Utils {

    private static Gson gson = null;


    //URL for enviroments
    public static String BASE_URL_PRD = "https://api.myjson.com";
    public static String BASE_URL_DEV = "https://api.myjson.com";

    public static String URL_PRICES = "/bins/lttvc";

    //enum for choose service type
    public enum ServiceType {
        getPrices;
    }



    //for bussiness rules

    public static int MinimumItems = 3;

    //GSON for rebuild objects betwen activities

    public static Gson getGson() {
        if (gson == null)
            return new Gson();
        else return gson;
    }
}
