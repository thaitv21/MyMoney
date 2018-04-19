package com.esp.mymoney;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MainFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private List<Expense> expenses = new ArrayList<>();
    private ExpenseAdapter adapter;
    private LinearLayoutManager layoutManager;
    private StickyRecyclerHeadersDecoration stickyRecyclerHeadersDecoration;

    private String title;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        expenses.add(new Expense(0));
        expenses.add(new Expense(0));
        expenses.add(new Expense(0));
        expenses.add(new Expense(1));
        expenses.add(new Expense(1));
        expenses.add(new Expense(1));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        expenses.add(new Expense(2));
        adapter = new ExpenseAdapter(getContext(), expenses);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        stickyRecyclerHeadersDecoration = new StickyRecyclerHeadersDecoration(adapter);
        recyclerView.addItemDecoration(stickyRecyclerHeadersDecoration);
        recyclerView.addItemDecoration(new DividerDecoration(getContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    public String getTitle() {
        return title;
    }
}
