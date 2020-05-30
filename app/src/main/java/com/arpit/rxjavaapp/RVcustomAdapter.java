package com.arpit.rxjavaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVcustomAdapter extends RecyclerView.Adapter<RVcustomAdapter.MyViewHolder> {

    private final List<Entries> entries = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rx_java,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

//        holder.txtName.setText(entries.get(position));
        Entries entry  = entries.get(position);
        holder.setTxtName(entry.getEntryName());
        holder.setTxtDate(entry.getEntryDate());
        holder.setTxtPrice(entry.getEntryprice());
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void addEntry(Entries entry)
    {
        entries.add(entry);
        notifyItemInserted(entries.size() - 1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtName)
        TextView txtName;

        @BindView(R.id.txtPrice)
        TextView txtPrice;

        @BindView(R.id.txtDate)
        TextView txtDate;

        private final NumberFormat ENTRY_PRICE_FORMAT = new DecimalFormat("$#0.00");
        private final DateFormat ENTRY_DATE_FORMAT = new DateFormat() {
            @NonNull
            @Override
            public StringBuffer format(@NonNull Date date, @NonNull StringBuffer toAppendTo, @NonNull FieldPosition fieldPosition) {
                return null;
            }

            @Nullable
            @Override
            public Date parse(@NonNull String source, @NonNull ParsePosition pos) {
                return null;
            }
        };

        public void setTxtName(String en) {
            this.txtName.setText(en);
        }

        public void setTxtPrice(BigDecimal ep) {
            this.txtPrice.setText(ENTRY_PRICE_FORMAT.format(ep.doubleValue()));
        }

        public void setTxtDate(Date ed) {
            this.txtDate.setText(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm",ed));
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

}