package aprivate.justoapp.Utils;

public class BussinessRules {
    //Types
    public static int TwoForOneType = 100;
    public static int BulkPurchasesType = 200;

    public static int TwoForOneRule(int items) {

        int rest = items % 2;
        if (rest > 0)
            return (items / 2) + 1;
        else
            return items / 2;

    }


    public static boolean isBulkPurchases(int items) {

        return items >= Utils.MinimumItems;

    }
}
