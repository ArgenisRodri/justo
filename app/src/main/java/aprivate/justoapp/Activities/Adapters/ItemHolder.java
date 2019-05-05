package aprivate.justoapp.Activities.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import aprivate.justoapp.Models.Item;
import aprivate.justoapp.R;

class ItemHolder extends RecyclerView.ViewHolder {

    ImageView ivItem;
    ImageButton ibRemove, ibAdd;
    TextView tvName, tvCount;

    public ItemHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        ibAdd = (ImageButton) itemView.findViewById(R.id.ibAdd);
        ibRemove = (ImageButton) itemView.findViewById(R.id.ibRemove);
        ivItem = (ImageView) itemView.findViewById(R.id.ivItem);
        tvCount = (TextView) itemView.findViewById(R.id.tvCount);





    }



}
