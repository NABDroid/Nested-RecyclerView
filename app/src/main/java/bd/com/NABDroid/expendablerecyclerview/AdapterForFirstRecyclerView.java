package bd.com.NABDroid.expendablerecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForFirstRecyclerView extends RecyclerView.Adapter<AdapterForFirstRecyclerView.ViewHolder> {

    private AdapterForSecondRecyclerView adapterForSecondRecyclerView;
    int currentLawId;


    private ArrayList<Data> dataForFirstRecyclerView;
    private Context context;

    public AdapterForFirstRecyclerView(ArrayList<Data> dataForFirstRecyclerView, Context context) {
        this.dataForFirstRecyclerView = dataForFirstRecyclerView;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_recycler_view_ui, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Data data = dataForFirstRecyclerView.get(position);
        holder.lawIdTV.setText(Integer.toString(data.getLawID()));
        holder.lawTV.setText(data.getLaw());
        currentLawId = position + 1;
        ArrayList<Data> dataFromFunction = getDataFromDB(currentLawId);
        adapterForSecondRecyclerView = new AdapterForSecondRecyclerView(dataFromFunction, context);
        holder.secondRecyclerView.setAdapter(adapterForSecondRecyclerView);

        boolean expendCondition = data.isExpanded();
        if (expendCondition == false){
            holder.expendableLayout.setVisibility(View.GONE);
        } else{
            holder.expendableLayout.setVisibility(View.VISIBLE);
        }


        holder.clickToExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean expendCondition = data.isExpanded();
                if (expendCondition == false){
                    data.setExpanded(true);
                } else if (expendCondition == true){
                    data.setExpanded(false);
                }



                if (expendCondition == false){
                    holder.expandIndicator.setImageResource(R.drawable.arrow_right);
                    holder.expendableLayout.setVisibility(View.GONE);
                } else {
                    holder.expandIndicator.setImageResource(R.drawable.arrow_down);
                    holder.expendableLayout.setVisibility(View.VISIBLE);
                }

                notifyItemChanged(position);




            }
        });











    }


    @Override
    public int getItemCount() {
        return dataForFirstRecyclerView.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lawTV, lawIdTV;
        ImageView expandIndicator;
        RecyclerView secondRecyclerView;
        RelativeLayout expendableLayout;
        LinearLayout clickToExpand;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lawTV = itemView.findViewById(R.id.lawTV);
            lawIdTV = itemView.findViewById(R.id.lawID);
            expandIndicator = itemView.findViewById(R.id.expandListIV);
            expendableLayout = itemView.findViewById(R.id.secondRecyclerViewRL);
            secondRecyclerView = itemView.findViewById(R.id.secondRecyclerView);
            secondRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            clickToExpand = itemView.findViewById(R.id.clickToExpandFirstLL);


        }


    }





























    private ArrayList<Data> getDataFromDB(int currentLawId) {

        ArrayList<Data> arrayList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Data data = new Data("Data of " + currentLawId + " th law will be showed here", currentLawId);
            arrayList.add(data);
        }

        return arrayList;


    }


}
