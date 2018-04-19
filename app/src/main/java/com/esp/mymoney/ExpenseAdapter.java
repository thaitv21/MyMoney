package com.esp.mymoney;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.Arrays;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> implements StickyRecyclerHeadersAdapter<ExpenseAdapter.HeaderViewHolder>{

    private Context context;
    private List<Expense> expenses;

    public ExpenseAdapter(Context context, List<Expense> expenses) {
        this.context = context;
        this.expenses = expenses;
    }

    @Override
    public long getHeaderId(int position) {
        return expenses.get(position).id;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View header = LayoutInflater.from(context).inflate(R.layout.header, parent, false);
        return new HeaderViewHolder(header);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {
        int id = expenses.get(position).id;
        int sum = 0;
        for (Expense e : expenses) {
            if (e.id == id) {
                sum -= e.cost;
            }
        }
        holder.total.setText(sum + " đ");
    }

    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {
        if (position < expenses.size() - 1 && expenses.get(position).id != expenses.get(position + 1).id) {
            holder.space.setVisibility(View.VISIBLE);
        } else {
            holder.space.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    class ExpenseViewHolder extends RecyclerView.ViewHolder {

        ImageView space;

        public ExpenseViewHolder(View itemView) {
            super(itemView);
            space = itemView.findViewById(R.id.space);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView day;
        TextView dayName;
        TextView monthYear;
        TextView total;


        public HeaderViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            dayName = itemView.findViewById(R.id.dayName);
            monthYear = itemView.findViewById(R.id.month_year);
            total = itemView.findViewById(R.id.total_expense);
        }
    }
}
