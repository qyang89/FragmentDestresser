package com.example.fragmentdestresser;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentdestresser.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

public class DynamicFragment extends Fragment {

    //for the PUSH ME fragment page
    //variable long and duration
    int count = 0;
    long timePressed;

    Button stressBtn;
    TextView tvCount;

    public void numberClicks(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            timePressed = System.currentTimeMillis();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            long pressDuration = System.currentTimeMillis() - timePressed;
            if (pressDuration > 2) {
                count = 0;
                tvCount.setText(String.valueOf(count)); //reset count to 0
            } else {
                count++;
                tvCount.append(" " + String.valueOf(count));
            }
            timePressed = 0;
        }


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        stressBtn = view.findViewById(R.id.stress_btn);
        tvCount = getActivity().findViewById(R.id.tv_count);
        stressBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    timePressed = System.currentTimeMillis();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    long pressDuration = (System.currentTimeMillis() - timePressed) / 1000;      //convert mill to seconds by division of 1000
                    if (pressDuration > 2) {
                        count = 0;
                        tvCount.setText(String.valueOf(count)); //reset count to 0
                        Log.d("pressDuration", "more than 3");
                    } else {
                        count++;
                        tvCount.setText(" " + String.valueOf(count));
                        Log.d("pressDuration", "less than 3");
                    }
                    Log.d("StressBtn", "tvCount:"+tvCount.getText()+"count:"+count+",pressDuration"+pressDuration/1000);
                    timePressed = 0;
                }
                return false;
            }
        });
        return view;

    }
}
