package aprivate.justoapp.Services;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aprivate.justoapp.Models.Item;
import aprivate.justoapp.Models.Mug;
import aprivate.justoapp.Models.TShirt;
import aprivate.justoapp.Models.Voucher;
import aprivate.justoapp.Services.Interfaces.IServiceItemProduct;
import aprivate.justoapp.Utils.Utils;

/**
 * Created by argrod on 02/05/19.
 */

public class ServiceItemProduct {
    Context context;
    IServiceItemProduct iServiceItemProduct;


    public ServiceItemProduct(Context context, IServiceItemProduct iServiceItemProduct) {
        this.context = context;
        this.iServiceItemProduct = iServiceItemProduct;
    }

    public void getItemsPrice(JSONArray jsonArrayResponse) throws JSONException {
        ArrayList<Item> itemList = new ArrayList<Item>();

        for (int i = 0; i < jsonArrayResponse.length(); i++) {
            JSONObject jsonItem = null;


            try {
                jsonItem = jsonArrayResponse.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Double Price;

            String Name;
            String code;

            String strItemCode = null;
            try {
                if (jsonItem != null)
                    strItemCode = jsonItem.getString("code");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (strItemCode != null)

                switch (strItemCode) {

                    case "VOUCHER":
                        Voucher voucher = new Voucher();
                        voucher.setName(jsonItem.getString("name"));
                        voucher.setCode(strItemCode);
                        voucher.setPrice(jsonItem.getDouble("price"));

                        itemList.add(voucher);

                        break;
                    case "TSHIRT":
                        TShirt tshirt = new TShirt();
                        tshirt.setName(jsonItem.getString("name"));
                        tshirt.setCode(strItemCode);
                        tshirt.setPrice(jsonItem.getDouble("price"));

                        itemList.add(tshirt);
                        break;
                    case "MUG":
                        Mug mug = new Mug();
                        mug.setName(jsonItem.getString("name"));
                        mug.setCode(strItemCode);
                        mug.setPrice(jsonItem.getDouble("price"));

                        itemList.add(mug);
                        break;
                }

        }

        iServiceItemProduct.getPrices(itemList);


    }

    public JSONArray VolleyConnect(final Utils.ServiceType type) {


        String responseStrJson = "";
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);
        final JSONArray jsonArray = new JSONArray();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                Utils.BASE_URL_DEV + Utils.URL_PRICES, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                if (type == Utils.ServiceType.getPrices)
                    try {
                        getItemsPrice(response.getJSONArray("products"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        iServiceItemProduct.error(error.getMessage());

                    }
                }


        );


        requestQueue.add(jsonObjectRequest);

        return jsonArray;

    }
}
