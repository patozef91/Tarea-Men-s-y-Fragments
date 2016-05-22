package app.maldonadopato91.com.tarea3petagrammenuyfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment {

    ArrayList mascotas;
    RecyclerView rvMascotas;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);


        //ADAPTER
        //---------------------------------------------------------------------------------
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.ax,0, "Armani"));
        mascotas.add(new Mascota(R.drawable.dior,0, "Dior"));
        mascotas.add(new Mascota(R.drawable.gray_puppy,0, "Crystal"));
        mascotas.add(new Mascota(R.drawable.lambo, 0,"Lamborghini"));
        mascotas.add(new Mascota(R.drawable.nacho,0, "Nacho"));
        mascotas.add(new Mascota(R.drawable.prada,0, "Prada"));
        mascotas.add(new Mascota(R.drawable.vidal, 0,"Vidal"));


        rvMascotas = (RecyclerView) v.findViewById(R.id.rv);
        rvMascotas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(mascotas);
        rvMascotas.setAdapter(adapter);

        //FIN ADAPTER
        //-------------------------------------------------------------------------------------

        return  v;

    }

}
