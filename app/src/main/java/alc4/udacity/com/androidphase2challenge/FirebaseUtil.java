package alc4.udacity.com.androidphase2challenge;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseUtil {

    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    private static FirebaseUtil firebaseUtil;
    public static ArrayList<TravelDeal1> mDeals;

    private FirebaseUtil(){};

    public static void openFbReference(String ref) {
        if (firebaseUtil == null) {
            firebaseUtil = new FirebaseUtil();
            mFirebaseDatabase = FirebaseDatabase.getInstance();

        }
        mDeals = new ArrayList<TravelDeal1>();
        mDatabaseReference = mFirebaseDatabase.getReference().child(ref);
    }
}
