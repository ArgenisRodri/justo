package aprivate.justoapp.Activities.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import aprivate.justoapp.R;

class ItemCartHolder extends RecyclerView.ViewHolder {

    ImageView ivItem;
    CardView cvItem;
    TextView tvName, tvCount, tvPromo, tvPrice, tvTotal;

    public ItemCartHolder(View itemView) {
        super(itemView);
        cvItem = (CardView) itemView.findViewById(R.id.cvItem);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        tvPromo = (TextView) itemView.findViewById(R.id.tvPromo);
        tvTotal = (TextView) itemView.findViewById(R.id.tvFinalPrice);


        ivItem = (ImageView) itemView.findViewById(R.id.ivItem);
        tvCount = (TextView) itemView.findViewById(R.id.tvCountitems);


    }


}
