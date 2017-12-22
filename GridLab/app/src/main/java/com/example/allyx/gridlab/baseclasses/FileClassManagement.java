package com.example.allyx.gridlab.baseclasses;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by allyx on 2016-05-12.
 */
public class FileClassManagement {
    public static ArrayList<Numbers>
    readFile(Context context,String fileName){

        ArrayList<Numbers> listOfNumbers
                = new ArrayList<Numbers>();
        AssetManager assManager =
                context.getResources().getAssets();

        try {
            InputStreamReader isr
                    = new InputStreamReader(assManager.open(fileName));

            BufferedReader br = new BufferedReader(isr);
            String oneLine;
            while ((oneLine=br.readLine())!=null){
                StringTokenizer st =
                        new StringTokenizer(oneLine,",");
                while (st.hasMoreTokens()){
                    String str=st.nextToken();
                    Numbers oneNumber = new Numbers(str);
                    listOfNumbers.add(oneNumber);
                }
            }
            br.close();
            isr.close();
            return listOfNumbers;
        } catch (IOException e) {
            return null;
        }

    }
}
