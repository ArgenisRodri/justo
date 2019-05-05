package aprivate.justoapp.Models;


import aprivate.justoapp.Utils.BussinessRules;
import aprivate.justoapp.Utils.Utils;

/**
 * Created by argrod on 02/05/19.
 */

public class Voucher extends Item {

    public Voucher() {

        setPromo(BussinessRules.TwoForOneType);
    }


}
