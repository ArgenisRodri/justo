package aprivate.justoapp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import aprivate.justoapp.Activities.Adapters.ItemAdapter;
import aprivate.justoapp.Models.Item;
import aprivate.justoapp.Models.Voucher;
import aprivate.justoapp.R;
import aprivate.justoapp.Services.Interfaces.IServiceItemProduct;
import aprivate.justoapp.Services.ServiceItemProduct;
import aprivate.justoapp.Utils.BussinessRules;
import aprivate.justoapp.Utils.Utils;

public class ListItemsActivity extends AppCompatActivity implements IServiceItemProduct {
    ImageButton ibNext;
    RecyclerView rvItems;
    ArrayList<Item> arrayList;
    ProgressBar pbLoading;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        initView();
        ServiceItemProduct serviceItemProduct = new ServiceItemProduct(ListItemsActivity.this, this);
        serviceItemProduct.VolleyConnect(Utils.ServiceType.getPrices);


    }

    private void initView() {
        //initviews
        ibNext = (ImageButton) findViewById(R.id.ibNext);
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        mLayoutManager = new GridLayoutManager(getBaseContext(), 2);
        rvItems.setLayoutManager(mLayoutManager);
        //clicklistener

        ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CartActivity.class);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String str = gson.toJson(arrayList);

                intent.putExtra("list", str);

                startActivity(intent);
            }
        });

    }

    @Override
    public void getPrices(ArrayList<Item> itemList) {
        pbLoading.setVisibility(View.GONE);
        arrayList = itemList;
        rvItems.setAdapter(new ItemAdapter(itemList, getBaseContext()));
    }

    @Override
    public void error(String message) {
        pbLoading.setVisibility(View.GONE);
        AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);

        builder.setTitle("ERROR")
                .setMessage(message)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        builder.create().show();
    }
}
