package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.doctor;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DoctorListAdapter extends FirebaseRecyclerAdapter<doctor,DoctorListAdapter.ViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public DoctorListAdapter(@NonNull FirebaseRecyclerOptions<doctor> options) {
        super(options);
    }

    @NonNull
    @Override
    public DoctorListAdapter.ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull doctor model) {
        holder.name.setText(model.getName());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }

}
