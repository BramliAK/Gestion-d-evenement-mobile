package com.example.ahmed.andoidapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class datepickerClass extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this,year,month,day);
        return datepickerdialog;

    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
        // TODO Auto-generated method stub


        TextView textview = (TextView) getActivity().findViewById(R.id.textView1);

        Calendar calander2 = Calendar.getInstance();

        calander2.setTimeInMillis(0);

        calander2.set(year, monthOfYear, dayOfMonth, 0, 0, 0);

        Date SelectedDate = calander2.getTime();

        DateFormat dateformat_US = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        String StringDateformat_US = dateformat_US.format(SelectedDate);
        textview.setText(StringDateformat_US + "\n");

      /*  DateFormat dateformat_UK = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
        String StringDateformat_UK = dateformat_UK.format(SelectedDate);
        textview.setText( textview.getText() + StringDateformat_UK + "\n");*/



    }
}
