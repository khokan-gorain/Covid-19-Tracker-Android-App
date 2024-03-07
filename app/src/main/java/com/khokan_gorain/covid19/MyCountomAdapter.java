package com.khokan_gorain.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.khokan_gorain.covid19.R;

import java.util.ArrayList;
import java.util.List;

public class MyCountomAdapter extends ArrayAdapter<countryModel> {
    private Context context;
    private List<countryModel> countryModelsList;
    private List<countryModel> countryModelsListFiltered;
    private Object FilterResults;

    public MyCountomAdapter(Context context, List<countryModel> countryModelsList) {
        super(context, R.layout.list_countem_item, countryModelsList);
        this.context = context;
        this.countryModelsList = countryModelsList;
        this.countryModelsListFiltered = countryModelsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_countem_item, null, true);
        TextView tvCountryname = view.findViewById(R.id.tvCountryname);
        ImageView imageView = view.findViewById(R.id.imagesFlag);
        tvCountryname.setText(countryModelsListFiltered.get(position).getCountry());
        Glide.with(context).load(countryModelsListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countryModelsListFiltered.size();
    }

    @Nullable
    @Override
    public countryModel getItem(int position) {
        return countryModelsListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = countryModelsList.size();
                    filterResults.values = countryModelsList;
                } else {
                    List<countryModel> resultModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (countryModel itemModel : countryModelsList) {
                        if (itemModel.getCountry().toLowerCase().contains(searchStr)){
                        resultModel.add(itemModel);
                    }
                    filterResults.count = resultModel.size();
                    filterResults.values = resultModel;
                }
                }
                return filterResults;
            }

            @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                countryModelsListFiltered = (List<countryModel>) results.values;
                    affected_countries_activity.countryModelList = (List<countryModel>) results.values;
            }

        };

            return filter;
    }

}

