package com.example.application;

import android.app.Dialog;
import android.content.Context;
import android.content.*;
import android.view.*;
import android.view.Window;
import android.widget.*;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.LinearLayout;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;

public class CustomDialog {

    private static Dialog dialog;
    private static final String titleDialog = "CustomDialog";
    private static final String messageDialog = "This is Custom Dialog!";
    private static final String buttonOk = "OK";
    private static final int bgColors = 0xffffffff;
   
    
    public static void showDialogs(Context context) {
        
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(8,8,8,8);
        final LinearLayout root = new LinearLayout(context);
        root.setOrientation(1);
        root.setBackgroundColor(bgColors);
        
        final LinearLayout ContentRoot = new LinearLayout(context);
        ContentRoot.setOrientation(1);
        ContentRoot.setBackgroundColor(Color.TRANSPARENT);
        root.addView(ContentRoot,640,ViewGroup.LayoutParams.WRAP_CONTENT);
    
        final LinearLayout Contents = new LinearLayout(context);
        Contents.setOrientation(1);
        Contents.setBackgroundColor(Color.TRANSPARENT);
        ContentRoot.addView(Contents,params);
        
        final TextView title = new TextView(context);
        title.setText(titleDialog);
        title.setShadowLayer(3,4,0,Color.GRAY);
        title.setTextColor(0xff000000);
        title.setTextSize(25);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        Contents.addView(title,params);
        
        final TextView message = new TextView(context);
        message.setText(messageDialog);
        message.setShadowLayer(3,4,0,Color.GRAY);
        message.setTextColor(0xff000000);
        message.setTextSize(15);
        message.setTypeface(Typeface.DEFAULT_BOLD);
        message.setGravity(1);
        Contents.addView(message,params);
        
        final Button button_ok = new Button(context);
        button_ok.setHint(buttonOk);
        button_ok.setHintTextColor(0xff000000);
        button_ok.setShadowLayer(3,4,0,Color.GRAY);
        Contents.addView(button_ok,params);
         setCornerRadius(button_ok,10); 
        
        dialog.setContentView(root);
        dialog.setCancelable(false);
        
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
              
            }
        });

        dialog.show();
    }
    private static View setCornerRadius(View view,float radius){
        // Create a GradientDrawable
        final GradientDrawable gradientDrawable = new GradientDrawable();

        // Set the corner radius (in pixels, convert dp to pixels if needed)
        //float cornerRadius = 10f; // 10dp
        float cornerRadius = radius; // get float Radius
        gradientDrawable.setCornerRadius(cornerRadius);
        int[] Colors = new int[]{0xff3298f2,0xff6742d7};

        // Set the background color
        gradientDrawable.setColors(new int[]{0xff3298f2,0xff6742d7}); // Replace with your color

        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);

        // Set the gradient direction (orientation)
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR); // Top-Left to Bottom-Right
        // Apply the GradientDrawable as the view's background
         view.setBackground(gradientDrawable);
         view.setElevation(10);
        return view;
    }
}


/* onCreate Java Code For ShowDialogs context is equal to activity*/
// CustomDialog.showDialogs(context.this); && showDialogs(this);