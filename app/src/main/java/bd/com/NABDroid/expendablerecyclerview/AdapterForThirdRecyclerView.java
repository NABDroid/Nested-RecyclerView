package bd.com.NABDroid.expendablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForThirdRecyclerView extends RecyclerView.Adapter<AdapterForThirdRecyclerView.ViewHolder> {
    private ArrayList<Data> dataForThirdRecyclerView;

    private Context context;

    public AdapterForThirdRecyclerView(ArrayList<Data> dataForThirdRecyclerView, Context context) {
        this.dataForThirdRecyclerView = dataForThirdRecyclerView;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.third_recycler_view_ui, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = dataForThirdRecyclerView.get(position);
        holder.lawTV.setText(data.getLaw().toString());
        holder.lawId.setText(Integer.toString(data.getLawID()));
        holder.lastElementCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "End of the list", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataForThirdRecyclerView.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lawTV, lawId;
        CardView lastElementCV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lawTV = itemView.findViewById(R.id.thirdLawTV);
            lawId = itemView.findViewById(R.id.thirdLawID);
            lastElementCV = itemView.findViewById(R.id.lastElementCV);
        }
    }



}
