package com.example.imageloader.data;

import com.example.imageloader.R;
import com.example.imageloader.model.ViewModelData;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static int[] gambarSaja = {
            R.drawable.thinkpad,
            R.drawable.ktm,
            R.drawable.thinkpad,
            R.drawable.ktm
    };

    public static List<ViewModelData> getListData() {
        List<ViewModelData> list = new ArrayList<>();
        for (int position = 0; position < gambarSaja.length; position++) {
            ViewModelData model = new ViewModelData();
            model.setImage(gambarSaja[position]);
            list.add(model);
        }
        return list;
    }
}
