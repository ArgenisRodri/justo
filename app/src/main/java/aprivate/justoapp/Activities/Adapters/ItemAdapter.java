package aprivate.justoapp.Activities.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aprivate.justoapp.Models.Item;
import aprivate.justoapp.Models.Mug;
import aprivate.justoapp.Models.TShirt;
import aprivate.justoapp.Models.Voucher;
import aprivate.justoapp.R;

/**
 * Created by argrod on 02/05/19.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
    List<Item> itemArrayList;
    public Context context;

    public ItemAdapter(List<Item> itemArrayList, Context context) {
        this.itemArrayList = itemArrayList;
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.card_item, parent, false);

        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, final int position) {
        Item item = itemArrayList.get(position);
        if (item instanceof Voucher) {
            holder.ivItem.setImageResource(R.drawable.voucher_peppa);

        } else if (itemArrayList.get(position) instanceof TShirt) {
            holder.ivItem.setImageResource(R.drawable.tshirt);
        } else if (itemArrayList.get(position) instanceof Mug) {
            holder.ivItem.setImageResource(R.drawable.mug);
        }

        holder.tvName.setText(item.getName());
        holder.ibRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAccount(-1, holder.tvCount, position);

            }
        });

        holder.ibAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAccount(1, holder.tvCount, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public void changeAccount(int count, TextView tvCount, int position) {
        int actualCount = Integer.parseInt(tvCount.getText().toString());
        actualCount = actualCount + count;
        if (actualCount < 0)
            actualCount = 0;
        tvCount.setText("" + actualCount);

        itemArrayList.get(position).setCount(actualCount);


    }


}
