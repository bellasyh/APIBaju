package pnj.ac.bajuapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pnj.ac.bajuapi.Model.Baju;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<Baju> dataList = new ArrayList<>();
    private onViewClick listener;


    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder( RecycleViewAdapter.ViewHolder holder, int position) {
        Baju data = dataList.get(position);
        holder.tvnama.setText(data.getNama());
        holder.tvmerek.setText(data.getMerek());
        holder.tvjenis_baju.setText(data.getJenis_baju());
//       holder.tvharga.setText(data.getHarga());
        holder.tvjumlah_beli.setText(data.getJumlah_beli());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvnama, tvmerek, tvjenis_baju, tvharga, tvjumlah_beli;

        public ViewHolder( View itemView){
            super(itemView);
            tvnama = itemView.findViewById(R.id.tvMainNama);
            tvmerek = itemView.findViewById(R.id.tvMainMerek);
            tvjenis_baju = itemView.findViewById(R.id.tvMainJenis);
            tvharga = itemView.findViewById(R.id.tvMainHarga);
            tvjumlah_beli = itemView.findViewById(R.id.tvMainJumlah);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onViewClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(List<Baju> list ){
        this.dataList = list;
        notifyDataSetChanged();
    }

    public void clearDataList(List<Baju> list ){
        this.dataList = list;
        dataList.clear();
    }

    public interface onViewClick{
        void onViewClick(int position);
    }

    public void setOnClickListener(onViewClick listener){
        this.listener = listener;
    }
}
