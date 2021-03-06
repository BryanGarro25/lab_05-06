package com.example.prac_admin_pos.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac_admin_pos.R;
import com.example.prac_admin_pos.model.JobApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JobAppAdapter extends RecyclerView.Adapter<JobAppAdapter.MyViewHolder> implements Filterable  {
    private List<JobApp> jobAppList;
    private List<JobApp> jobAppListFiltered;
    private JobAppAdapterListener listener;
    private JobApp deletedItem;

    public JobAppAdapter(List<JobApp> jobAppList, JobAppAdapterListener listener) {
        this.jobAppList = jobAppList;
        this.listener = listener;
        //init filter
        this.jobAppListFiltered = jobAppList;
    }
    @Override
    public JobAppAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(JobAppAdapter.MyViewHolder holder, int position) {
        final JobApp jobApp = jobAppListFiltered.get(position);
        holder.titulo1.setText(jobApp.getName());
        holder.titulo2.setText(jobApp.getEmailAddress());
        holder.description.setText("Position " + jobApp.getPosition());
    }
    @Override
    public int getItemCount() {
        return jobAppListFiltered.size();
    }
    public void removeItem(int position) {
        deletedItem = jobAppListFiltered.remove(position);
        Iterator<JobApp> iter = jobAppList.iterator();
        while (iter.hasNext()) {
            JobApp aux = iter.next();
            if (deletedItem.equals(aux))
                iter.remove();
        }
        // notify item removed
        notifyItemRemoved(position);
    }
    public void restoreItem(int position) {

        if (jobAppListFiltered.size() == jobAppList.size()) {
            jobAppListFiltered.add(position, deletedItem);
        } else {
            jobAppListFiltered.add(position, deletedItem);
            jobAppList.add(deletedItem);
        }
        notifyDataSetChanged();
        // notify item added by position
        notifyItemInserted(position);
    }
    public JobApp getSwipedItem(int index) {
        if (this.jobAppList.size() == this.jobAppListFiltered.size()) { //not filtered yet
            return jobAppList.get(index);
        } else {
            return jobAppListFiltered.get(index);
        }
    }
    public void onItemMove(int fromPosition, int toPosition) {
        if (jobAppList.size() == jobAppListFiltered.size()) { // without filter
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(jobAppList, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(jobAppList, i, i - 1);
                }
            }
        } else {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(jobAppListFiltered, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(jobAppListFiltered, i, i - 1);
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    jobAppListFiltered = jobAppList;
                } else {
                    List<JobApp> filteredList = new ArrayList<>();
                    for (JobApp row : jobAppList) {
                        // filter use two parameters
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getEmailAddress().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    jobAppListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = jobAppListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                jobAppListFiltered = (ArrayList<JobApp>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo1, titulo2, description;
        //two layers
        public RelativeLayout viewForeground, viewBackgroundDelete, viewBackgroundEdit;


        public MyViewHolder(View view) {
            super(view);
            titulo1 = view.findViewById(R.id.titleFirstLbl);
            titulo2 = view.findViewById(R.id.titleSecLbl);
            description = view.findViewById(R.id.descriptionLbl);
            viewBackgroundDelete = view.findViewById(R.id.view_background_delete);
            viewBackgroundEdit = view.findViewById(R.id.view_background_edit);
            viewForeground = view.findViewById(R.id.view_foreground);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onContactSelected(jobAppListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }
    public interface JobAppAdapterListener {
        void onContactSelected(JobApp profesor);
    }
}
