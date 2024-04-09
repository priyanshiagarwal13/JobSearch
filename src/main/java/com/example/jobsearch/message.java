package com.example.jobsearch;
import android.content.Context;
import android.widget.Toast;

public class message {
    public static void Message ( Context context, String msg){

        Toast.makeText(context, msg,Toast.LENGTH_SHORT ).show();


    }
}
