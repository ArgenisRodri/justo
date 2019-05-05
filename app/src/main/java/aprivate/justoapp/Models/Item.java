package aprivate.justoapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import aprivate.justoapp.Utils.Utils;

/**
 * Created by argrod on 02/05/19.
 */

public class Item  {
    Double Price;
    int Promo;
    String Name;
    String code;
    int count = 0;

    public int getPromo() {
        return Promo;
    }

    public void setPromo(int promo) {
        Promo = promo;
    }


    public Item() {
    }





    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getTotal() {
        return Price * getCount();
    }


}
