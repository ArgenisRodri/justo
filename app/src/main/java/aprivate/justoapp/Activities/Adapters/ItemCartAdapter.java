package aprivate.justoapp.Activities.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aprivate.justoapp.Models.Item;
import aprivate.justoapp.Models.Mug;
import aprivate.justoapp.Models.TShirt;
import aprivate.justoapp.Models.Voucher;
import aprivate.justoapp.R;
import aprivate.justoapp.Utils.BussinessRules;

/**
 * Created by argrod on 02/05/19.
 */

public class ItemCartAdapter extends RecyclerView.Adapter<ItemCartHolder> {
    List<Item> itemArrayList;
    public Context context;

    public ItemCartAdapter(List<Item> itemArrayList, Context context) {
        this.itemArrayList = itemArrayList;
        this.context = context;
    }

    @Override
    public ItemCartHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.card_cart, parent, false);

        return new ItemCartHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemCartHolder holder, final int position) {
        Item item = itemArrayList.get(position);
        if (item.getCount() <= 0)
            holder.cvItem.setVisibility(View.GONE);
        switch (item.getCode()) {
            case "VOUCHER":
                holder.ivItem.setImageResource(R.drawable.voucher_peppa);
                break;
            case "TSHIRT":
                holder.ivItem.setImageResource(R.drawable.tshirt);
                break;
            case "MUG":
                holder.ivItem.setImageResource(R.drawable.mug);
                break;
        }


        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(item.getTotal() + "");
        holder.tvCount.setText(item.getCount() + " X");
        if (item.getPromo() == BussinessRules.BulkPurchasesType)
            holder.tvPromo.setText(context.getString(R.string.builk));
        else if (item.getPromo() == BussinessRules.TwoForOneType)
            holder.tvPromo.setText(context.getString(R.string.twoforone));
        Double total = 0.0;
        if (item.getPromo() == BussinessRules.TwoForOneType) {
            total = item.getPrice() * BussinessRules.TwoForOneRule(item.getCount());
        } else if (item.getPromo() == BussinessRules.BulkPurchasesType) {
            if (BussinessRules.isBulkPurchases(item.getCount()))
                total = item.getTotal() - item.getCount();
            else
                total = item.getTotal();

        } else
            total = item.getTotal();
        holder.tvTotal.setText(total + "");

    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }


}
