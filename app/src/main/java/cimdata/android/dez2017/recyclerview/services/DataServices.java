package cimdata.android.dez2017.recyclerview.services;

import cimdata.android.dez2017.recyclerview.models.AnimalImages;

/**
 * Created by Student on 13.12.2017.
 */

public class DataServices {
    public static AnimalImages[] animalImages;
    static {
        animalImages = new AnimalImages[]{
                new AnimalImages("Camelatz", "camelatz"),
                new AnimalImages("Delfund", "delfund"),
                new AnimalImages("Elefalter", "elefalter")

        };




    }


}
