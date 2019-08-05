package alc4.udacity.com.androidphase2challenge;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DealAdapter extends  RecyclerView.Adapter<DealAdapter.DealViewHolder> {
    //ArrayList<TravelDeal1> deal1s = new ArrayList<TravelDeal1>();
    ArrayList<TravelDeal1> deal1s;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildtListener;

    public DealAdapter(){
        //FirebaseUtil.openFbReference("traveldeals");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;
        deal1s = FirebaseUtil.mDeals;
        mChildtListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //TextView travel2Deals=(TextView)findViewById(R.id.travel2Title);
                TravelDeal1 td =dataSnapshot.getValue(TravelDeal1.class);
                //travel2Deals.setText(travel2Deals.getText() + "\n" + td.getTitle());
                Log.d("Deal", td.getTitle());
                td.setId(dataSnapshot.getKey());
                deal1s.add(td);
                notifyItemInserted(deal1s.size()-1);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildtListener);
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.part, parent, false);
        return new DealViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {
        TravelDeal1 deal = deal1s.get(position);
        holder.bind(deal);
    }

    @Override
    public int getItemCount() {
        return deal1s.size();
    }

    public class DealViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener {

        TextView tvTitle;
        TextView tvdescription;
        TextView tvprice;

        public DealViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.travel2Title);
            tvdescription = (TextView) itemView.findViewById(R.id.travel2Description);
            tvprice = (TextView) itemView.findViewById(R.id.travel2Price);
            itemView.setOnClickListener(this);
        }

        public void bind(TravelDeal1 deal) {
            tvTitle.setText(deal.getTitle());
            tvdescription.setText(deal.getDescription());
            tvprice.setText(deal.getPrice());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Log.d("You Clicked", String.valueOf(position));
            TravelDeal1 selecteddeal = deal1s.get(position);
            Intent intent = new Intent(v.getContext(), Travelmantics1Activity.class);
            intent.putExtra("deal", selecteddeal);
            v.getContext().startActivity(intent);
        }

    }

}
