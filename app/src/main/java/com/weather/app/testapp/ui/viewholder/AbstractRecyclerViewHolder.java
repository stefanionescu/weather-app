package com.weather.app.testapp.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * ViewHolder for inject views using ButterKnife
 *
 * @author stefan
 */
public abstract class AbstractRecyclerViewHolder extends RecyclerView.ViewHolder {

    public AbstractRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
