package ngingrich.dota2quiz;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import ngingrich.dota2quiz.model.abilities.Abilities;
import ngingrich.dota2quiz.model.heroes.Heroes;
import ngingrich.dota2quiz.model.items.Items;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String TAG = "MainActivityFragment";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            Abilities abilities = gson.fromJson(getJsonReader("abilities.json"), Abilities.class);
            Heroes heroes = gson.fromJson(getJsonReader("herodata.json"), Heroes.class);
            Items items = gson.fromJson(getJsonReader("items.json"), Items.class);
            Log.i(TAG, abilities.toString());
            Log.i(TAG, heroes.toString());
            Log.i(TAG, items.toString());
        } catch (IOException e) {
            Log.e(TAG, "Failed to parse JSON: " + e);
        }

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @NonNull
    private Reader getJsonReader(String filename) throws IOException {
        return new InputStreamReader(getActivity().getAssets().open("json/"+filename));
    }
}
