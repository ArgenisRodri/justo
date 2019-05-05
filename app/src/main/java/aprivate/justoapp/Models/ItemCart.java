package aprivate.justoapp.Models;

import aprivate.justoapp.Utils.Utils;

/**
 * Created by argrod on 02/05/19.
 */

public class ItemCart {
    int Count;
    Double UnitPrice;
    int idImage;
    int promoType;
    Double Total;

    public Double getTotal() {
        return UnitPrice * getCount();
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

}
