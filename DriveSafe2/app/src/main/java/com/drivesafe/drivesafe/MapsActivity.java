package com.drivesafe.drivesafe;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    
    
    private static final LatLng CHANDLER = new LatLng(33.455,-112.0668);

    private static final StoreLocation[] ALLRESTURANTLOCATIONS = new StoreLocation[] {
            new StoreLocation(new LatLng(33.455,-112.0668), new String("Phoenix, AZ")),
            new StoreLocation(new LatLng(33.5123,-111.9336), new String("SCOTTSDALE, AZ")),
            new StoreLocation(new LatLng(33.3333,-111.8335), new String("Chandler, AZ")),
            new StoreLocation(new LatLng(33.4296,-111.9436), new String("Tempe, AZ")),
            new StoreLocation(new LatLng(33.4152,-111.8315), new String("Mesa, AZ")),
            new StoreLocation(new LatLng(33.3525,-111.7896), new String("Gilbert, AZ"))
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CHANDLER, ZOOM_LEVEL));
        Drawable iconDrawable = getResources().getDrawable(R.drawable.ic_launcher);
        Bitmap iconBmp = ((BitmapDrawable) iconDrawable).getBitmap();
        for(int ix = 0; ix < ALLRESTURANTLOCATIONS.length; ix++) {
            mMap.addMarker(new MarkerOptions()
                    .position(ALLRESTURANTLOCATIONS[ix].mLatLng)
                    .icon(BitmapDescriptorFactory.fromBitmap(iconBmp)));
        }

}
