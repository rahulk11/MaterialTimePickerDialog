package com.rahulk11.timepickermaterialdialog;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rahulk11.timepickermaterialdialog.TimePickerView.Dialog;
import com.rahulk11.timepickermaterialdialog.TimePickerView.DialogFragment;

import java.text.SimpleDateFormat;

public class MainActivity extends FragmentActivity {
    Context mActivity;
    TextView tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        tvTime = (TextView) findViewById(R.id.textView);
    }

    public void showTimePicker(View view){
        Dialog.Builder builder = null;
        builder = new Dialog.Builder(R.style.Material_App_Dialog_TimePicker_Light, 0, 0){
            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
                Dialog dialog = (Dialog) fragment.getDialog();
                tvTime.setText("Time is " + dialog.getFormattedTime(SimpleDateFormat.getTimeInstance()));
                super.onPositiveActionClicked(fragment);
            }

            @Override
            public void onNegativeActionClicked(DialogFragment fragment) {
                Toast.makeText(mActivity, "Cancelled" , Toast.LENGTH_SHORT).show();
                super.onNegativeActionClicked(fragment);
            }

            @Override
            public void onNeutralActionClicked(DialogFragment fragment) {
                Toast.makeText(mActivity, "Neutral" , Toast.LENGTH_SHORT).show();
                super.onNeutralActionClicked(fragment);
            }
        };

        builder.positiveAction("OK")
                .negativeAction("CANCEL")
                .neutralAction("");
        DialogFragment fragment = DialogFragment.newInstance(builder);
        fragment.show(getSupportFragmentManager(), null);
    }
}
