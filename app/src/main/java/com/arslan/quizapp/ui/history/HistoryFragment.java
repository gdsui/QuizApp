package com.arslan.quizapp.ui.history;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arslan.quizapp.R;
import com.arslan.quizapp.core.CoreFragment;
import com.arslan.quizapp.data.model.History;
import com.arslan.quizapp.recycler.HistoryAdapter;

import java.util.List;

public class HistoryFragment extends CoreFragment {

    private HistoryViewModel mViewModel;
    RecyclerView recyclerView;
    HistoryAdapter adapter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.history_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.history_recycler);
        adapter = new HistoryAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this)
                .get(HistoryViewModel.class);

//
        mViewModel.historyLiveData.observe(getActivity(), new Observer<List<History>>() {
            @Override
            public void onChanged(List<History> histories) {
                if (histories != null)
                    adapter.update(histories);
            }
        });

    }

}