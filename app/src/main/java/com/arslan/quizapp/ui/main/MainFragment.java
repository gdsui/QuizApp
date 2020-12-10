package com.arslan.quizapp.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.arslan.quizapp.R;
import com.arslan.quizapp.core.CoreFragment;
import com.arslan.quizapp.ui.quiz.QuizActivity;
import com.arslan.quizapp.util.SimpleOnSeekBarChangeListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends CoreFragment {

    private TextView seekBar_amount;
    private MainViewModel mViewModel;
    SeekBar seekBar;
    Spinner spinnercat, spinnerdif;
    String difficult;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders
                .of(getActivity()).get(MainViewModel.class);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinnercat = view.findViewById(R.id.spinner_category);
        spinnerdif = view.findViewById(R.id.spinner_difficulty);
        seekBar = view.findViewById(R.id.main_seekBar);
        seekBar_amount = view.findViewById(R.id.q_amount_number);

//Button start
        view.findViewById(R.id.main_start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer spinnerCategory = null;
                if (spinnercat.getSelectedItemPosition() != 0) {
                    spinnerCategory = spinnercat.getSelectedItemPosition() + 8;
                }
                QuizActivity.start(getActivity(), seekBar.getProgress(),
                        spinnerCategory,
                        getDifficulty());
            }
        });
        seekBar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                super.onProgressChanged(seekBar, progress, fromUser);
                seekBar_amount.setText(String.valueOf(progress));
            }
        });
    }
    public String getDifficulty() {
        switch (spinnerdif.getSelectedItemPosition()) {
            case 0:
                difficult = null;
                break;
            case 1:
                difficult = "easy";
                break;
            case 2:
                difficult = "medium";
                break;
            case 3:
                difficult = "hard";
                break;
        }
        return difficult;
    }

}