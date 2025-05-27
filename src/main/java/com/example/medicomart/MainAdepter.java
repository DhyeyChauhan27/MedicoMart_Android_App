package com.example.medicomart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class MainAdepter extends FirebaseRecyclerAdapter<MainModel, MainAdepter.ViewHolder> {

    private OnItemClickListener listener;

    public MainAdepter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull MainModel model) {
        holder.mname.setText(model.getMname());
        holder.mprice.setText(model.getMprice());
        holder.mdeliver.setText(model.getMdeliver());

        Picasso.get().load(model.getImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        // Set click listener for the item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(model);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.musthaves_item, parent, false));
    }

    // Interface for handling click events
    public interface OnItemClickListener {
        void onItemClick(MainModel model);
    }

    // Method to set the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mname, mprice, mdeliver;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            mname = itemView.findViewById(R.id.mname);
            mprice = itemView.findViewById(R.id.mprice);
            mdeliver=itemView.findViewById(R.id.mdeliver);
        }
    }
}
