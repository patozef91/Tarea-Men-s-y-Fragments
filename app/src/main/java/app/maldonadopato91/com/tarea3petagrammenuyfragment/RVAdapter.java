package app.maldonadopato91.com.tarea3petagrammenuyfragment;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/*import com.cristian.fragment.R;
import com.cristian.fragment.pojo.Mascota;*/

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MascotaViewHolder>{



    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        CardView cvMascota;
        TextView mascotaName;
        TextView mascotaLike;
        ImageView mascotaPhoto;
        ImageView iconoHueso;

        MascotaViewHolder(View itemView) {
            super(itemView);
            cvMascota = (CardView)itemView.findViewById(R.id.cvMascota);
            mascotaName = (TextView)itemView.findViewById(R.id.tvNombreMascota);
            mascotaLike = (TextView)itemView.findViewById(R.id.tvNum);
            mascotaPhoto = (ImageView)itemView.findViewById(R.id.ivMascotaFoto);
            iconoHueso =(ImageView)itemView.findViewById(R.id.ivHuesoBlanco);
        }

    }



    ArrayList<Mascota> mascotas;

    public RVAdapter(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_mascota, viewGroup, false);
        MascotaViewHolder mvh = new MascotaViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int i) {
        final Mascota masco=mascotas.get(i);
        mascotaViewHolder.mascotaName.setText(masco.getNombreMasco());
        mascotaViewHolder.mascotaPhoto.setImageResource(masco.getFotoMascota());
        mascotaViewHolder.mascotaLike.setText(String.valueOf(masco.getLikeMasco()));
        mascotaViewHolder.iconoHueso.setTag(mascotaViewHolder);

        if (masco.getLikeMasco()==0)
            mascotaViewHolder.iconoHueso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MascotaViewHolder mH = (MascotaViewHolder) v.getTag();
                    mH.mascotaLike.setText(String.valueOf(1 + Integer.parseInt(mH.mascotaLike.getText().toString())));

                }
            });

    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
