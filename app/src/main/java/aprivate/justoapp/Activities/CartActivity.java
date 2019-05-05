package aprivate.justoapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import aprivate.justoapp.Activities.Adapters.ItemCartAdapter;
import aprivate.justoapp.Models.Item;
import aprivate.justoapp.Models.ItemCart;
import aprivate.justoapp.R;
import aprivate.justoapp.Utils.BussinessRules;
import aprivate.justoapp.Utils.Utils;

public class CartActivity extends AppCompatActivity {

    public ArrayList<Item> itemArrayList;
    TextView tvTotal;
    RecyclerView rvItems;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        String js = getIntent().getExtras().getString("list");
        Type founderListType = new TypeToken<ArrayList<Item>>() {
        }.getType();
        Gson gson = new GsonBuilder().create();



        itemArrayList = gson.fromJson(getIntent().getExtras().getString("list"), founderListType);
        initViews();
        CalculeTotal();
    }

    private void initViews() {
        tvTotal = (TextView) findViewById(R.id.tvtotal);
        rvItems = (RecyclerView) findViewById(R.id.rvCart);
        mLayoutManager = new LinearLayoutManager(getBaseContext());
        rvItems.setLayoutManager(mLayoutManager);
        rvItems.setAdapter(new ItemCartAdapter(itemArrayList, getBaseContext()));
    }

    private void CalculeTotal() {
        Double Grandtotal = 0.0;
        for (Item itemCart : itemArrayList) {

            Double total = 0.0;
            if (itemCart.getPromo() == BussinessRules.TwoForOneType) {
                total = itemCart.getPrice() * BussinessRules.TwoForOneRule(itemCart.getCount());
            } else if (itemCart.getPromo() == BussinessRules.BulkPurchasesType) {
                if (BussinessRules.isBulkPurchases(itemCart.getCount()))
                    total = itemCart.getTotal() - itemCart.getCount();
                else
                    total = itemCart.getTotal();

            } else
                total = itemCart.getTotal();


            Grandtotal = Grandtotal + total;
        }
        tvTotal.setText("Grand total $ " + Grandtotal);
    }
}
