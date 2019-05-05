package aprivate.justoapp.Services.Interfaces;

import java.util.ArrayList;
import java.util.List;

import aprivate.justoapp.Models.Item;

/**
 * Created by argrod on 02/05/19.
 */

public interface IServiceItemProduct {

    public void getPrices(ArrayList<Item> itemList);

    public void error(String message);
}
