package com.weather.app.testapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weather.app.testapp.R;
import com.weather.app.testapp.ui.viewholder.AbstractRecyclerViewHolder;
import com.weather.app.testapp.ui.viewmodel.Model;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author stefan
 */
public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    private List<Model> models;

    public ModelAdapter() {
        models = new ArrayList<Model>();
    }

    public ModelAdapter(List<Model> models) {
        this.models = models;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View modelView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model, viewGroup, false);
        return new ViewHolder(modelView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Model model = models.get(position);

        viewHolder.modelTitle.setText(model.getTitle());

        Picasso.with(viewHolder.view.getContext())
                .load("https://c1.staticflickr.com/9/8379/8646735272_b861ab505f_b.jpg")
                .into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void add(Model model) {
        models.add(model);
        notifyDataSetChanged();
    }

    public void add(List<Model> models) {
        this.models.addAll(models);
        notifyDataSetChanged();
    }

    public class ViewHolder extends AbstractRecyclerViewHolder {

        View view;

        @BindView(R.id.model_title)
        TextView modelTitle;
        @BindView(R.id.model_image)
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
