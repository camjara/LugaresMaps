package com.example.mismapas;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String lugar = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        lugar = getIntent().getExtras().get("lugar").toString();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {
        Drawable background = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        background.setBounds(0, 0, background.getIntrinsicWidth(), background.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(background.getIntrinsicWidth(), background.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        background.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng catedral = new LatLng(5.0674155, -75.5175074);
        LatLng fundadores = new LatLng(5.0689208,-75.5107455);
        LatLng cable = new LatLng(5.0674936,-75.5115476);
        LatLng torre = new LatLng(5.0728229,-75.5256051);
        if(lugar.equals("catedral"))
        {
            mMap.addMarker(new MarkerOptions().position(catedral).title("Catedral Basílica")
                .icon(bitmapDescriptorFromVector(this,R.drawable.ic_marker1)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(catedral,15));
        }else if(lugar.equals("fundadores"))
        {
            mMap.addMarker(new MarkerOptions().position(fundadores).title("Centro Comercial Fundadores")
                    .icon(bitmapDescriptorFromVector(this,R.drawable.ic_marker2)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fundadores,15));
        }else if(lugar.equals("cable"))
        {
            mMap.addMarker(new MarkerOptions().position(cable).title("Cable Aereo")
                    .icon(bitmapDescriptorFromVector(this,R.drawable.ic_marker3)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cable,15));
        }else if(lugar.equals("torre"))
        {
            mMap.addMarker(new MarkerOptions().position(torre).title("Torre de Chipre")
                    .icon(bitmapDescriptorFromVector(this,R.drawable.ic_marker4)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(torre,15));
        }

    }
}