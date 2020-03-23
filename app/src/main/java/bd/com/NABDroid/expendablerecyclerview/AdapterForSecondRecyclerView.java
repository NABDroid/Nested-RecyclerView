package bd.com.NABDroid.expendablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForSecondRecyclerView extends RecyclerView.Adapter<AdapterForSecondRecyclerView.ViewHolder> {
    private AdapterForThirdRecyclerView adapterForThirdRecyclerView;

    private ArrayList<Data> dataForSecondRecyclerView;
    int currentLawId;

    private Context context;

    public AdapterForSecondRecyclerView(ArrayList<Data> dataForSecondRecyclerView, Context context) {
        this.dataForSecondRecyclerView = dataForSecondRecyclerView;
        this.context = context;
    }

    //-------------------------------------------------------------------------------------------------------------------------------
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.secound_recycler_view_ui, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //-------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Data data = dataForSecondRecyclerView.get(position);
        holder.lawIdTV2.setText(Integer.toString(data.getLawID()));
        holder.lawTV2.setText(data.getLaw());
        currentLawId = position+1;
        ArrayList<Data> dataFromFunction = getDataFromDB(currentLawId);
        adapterForThirdRecyclerView = new AdapterForThirdRecyclerView(dataFromFunction, context);
        holder.thirdRecyclerView.setAdapter(adapterForThirdRecyclerView);


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

    //-------------------------------------------------------------------------------------------------------------------------------
    @Override
    public int getItemCount() {
        return dataForSecondRecyclerView.size();
    }

    //------------------------------------------------------------------------------------------------------------------------------
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lawTV2, lawIdTV2;

        ImageView expandIndicator;
        RecyclerView thirdRecyclerView;
        RelativeLayout expendableLayout;
        LinearLayout clickToExpand;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lawTV2 = itemView.findViewById(R.id.secondLawTV);
            lawIdTV2 = itemView.findViewById(R.id.secondLawID);
            thirdRecyclerView = itemView.findViewById(R.id.thirdRecyclerView);
            expandIndicator = itemView.findViewById(R.id.expandSecondRecyclerViewIV);
            expendableLayout = itemView.findViewById(R.id.thirdRecyclerViewRL);
            thirdRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            clickToExpand = itemView.findViewById(R.id.clickToExpandSecondLL);



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
