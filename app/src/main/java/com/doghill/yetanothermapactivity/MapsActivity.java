package com.doghill.yetanothermapactivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<LatLng> locationCoordinates = new ArrayList<LatLng>();
    private List<Marker> locationMarkers = new ArrayList<Marker>();
    private List<String> locationURLs = new ArrayList<String>();
    private List<String> locationStreetViews = new ArrayList<String>();

    private List<CharSequence> locationDescriptions = new ArrayList<CharSequence>();
    private List<String> imageURIs = new ArrayList<String>();


    private int currentLocation = 0;

    private LatLng trepHubCoords = new LatLng(28.079297, -80.609284);
    private LatLng apolloMemorialCoords = new LatLng(28.521837, -80.561022);
    private LatLng spaceCenterCoords = new LatLng(28.523273, -80.6837987);
    private LatLng cocoaPlayhouseCoords = new LatLng(28.355314, -80.725846);
    private LatLng henegarCenterCoords = new LatLng(28.0781009, -80.6103818);
    private LatLng ponceStatueCoords = new LatLng(28.011166, -80.530357);
    private LatLng lighthouseCoords = new LatLng(28.460311, -80.54348);
    private LatLng stLukesChurchCoords = new LatLng(28.4566942, -80.7166474);
    private LatLng oldBrevardCourthouseCoords = new LatLng(28.608566, -80.809531);
    private LatLng porcherHouseCoords = new LatLng(28.3537888, -80.725041);

    private String trepHubURL = "http://trephub.com/";
    private String apolloMemorialURL = "https://en.wikipedia.org/wiki/Apollo_1";
    private String spaceCenterURL = "https://www.kennedyspacecenter.com/";
    private String cocoaPlayhouseURL = "http://www.cocoavillageplayhouse.com";
    private String henegarCenterURL = "http://henegar.org/";
    private String ponceStatueURL = "http://www.brevardcounty.us/ParksRecreation/South/PonceDeLeon/Home";
    private String lighthouseURL = "http://canaverallight.org/";
    private String stLukesChurchURL = "http://stlukesmi.org";
    private String oldBrevardCourthouseURL = "https://en.wikipedia.org/wiki/Old_Brevard_County_Courthouse";
    private String porcherHouseURL = "https://en.wikipedia.org/wiki/Porcher_House";

    private String trepHubStreetView = "https://www.google.com/maps/@28.0793503,-80.6057026,3a,37.5y,228.18h,79.52t/data=!3m6!1e1!3m4!1sbZMaZ2KK9C7nKsr0i1aP_g!2e0!7i13312!8i6656";
    private String apolloMemorialStreetView = "https://www.google.com/maps/place/Apollo+1-+Grissom,+White+And+Chaffee+memorial./@28.5218217,-80.5611667,3a,75y,218.62h,90.18t/data=!3m8!1e1!3m6!1s-T-sLyE5HUgo%2FVTW94hJi24I%2FAAAAAAAACtE%2FyfXBgMxedCU!2e4!3e11!6s%2F%2Flh5.googleusercontent.com%2F-T-sLyE5HUgo%2FVTW94hJi24I%2FAAAAAAAACtE%2FyfXBgMxedCU%2Fw203-h101-n-k-no%2F!7i2508!8i1254!4m2!3m1!1s0x88e0a4b72614d13b:0xbcd0dbdf9b61517a!6m1!1e1";
    private String spaceCenterStreetView = "https://www.google.com/maps/place/Kennedy+Space+Center+Visitor+Complex/@28.522631,-80.681926,3a,75y,30.51h,89.39t/data=!3m8!1e1!3m6!1s-rxFrK0ul_OM%2FVJ8wi97XG1I%2FAAAAAAAAdlM%2FHQR5gD5liE8!2e4!3e11!6s%2F%2Flh4.googleusercontent.com%2F-rxFrK0ul_OM%2FVJ8wi97XG1I%2FAAAAAAAAdlM%2FHQR5gD5liE8%2Fw203-h101-n-k-no%2F!7i7168!8i3584!4m2!3m1!1s0x88e0b08ad0fe0ad1:0x4eb14063f30a478b!6m1!1e1";
    private String cocoaPlayhouseStreetView = "https://www.google.com/maps/@28.355306,-80.7262357,3a,75y,83.16h,90t/data=!3m6!1e1!3m4!1sx1RcqIdP-5HUA3C0heaHmg!2e0!7i13312!8i6656!6m1!1e1";
    private String henegarCenterStreetView = "https://www.google.com/maps/place/Henegar+Center+For+the+Arts/@28.0784856,-80.6101054,3a,75y,200.48h,89.2t/data=!3m7!1e1!3m5!1sV934FYENzdNew1CTCUAANA!2e0!6s%2F%2Fgeo3.ggpht.com%2Fcbk%3Fpanoid%3DV934FYENzdNew1CTCUAANA%26output%3Dthumbnail%26cb_client%3Dmaps_sv.tactile.gps%26thumb%3D2%26w%3D203%26h%3D100%26yaw%3D94.009354%26pitch%3D0!7i13312!8i6656!4m2!3m1!1s0x88de11f334afb97b:0x539bcd5bcd336191!6m1!1e1";
    private String ponceStatueStreetView = "https://www.google.com/maps/@28.0108005,-80.5305769,3a,75y,74.2h,95.55t/data=!3m6!1e1!3m4!1susOYRcKl0GM_NZByg01OVA!2e0!7i13312!8i6656";
    private String lighthouseStreetView = "https://www.google.com/maps/place/Cape+Canaveral+Lighthouse,+Lighthouse+Rd,+Florida/@28.4602871,-80.5434005,3a,75y,326.04h,139.87t/data=!3m8!1e1!3m6!1s-uqhuQkPu5fI%2FVZBEE8ZJ48I%2FAAAAAAABIdg%2FSBEQgD655aw!2e4!3e11!6s%2F%2Flh4.googleusercontent.com%2F-uqhuQkPu5fI%2FVZBEE8ZJ48I%2FAAAAAAABIdg%2FSBEQgD655aw%2Fw203-h101-n-k-no%2F!7i10000!8i5000!4m2!3m1!1s0x88e0a38aac7994c7:0x13e77392d7dd19ba!6m1!1e1";
    private String stLukesChurchStreetView = "https://www.google.com/maps/@28.4568283,-80.7164266,3a,75y,266.46h,91.17t/data=!3m6!1e1!3m4!1sFfb7x2-Yq9bzMjp6wnx-Cg!2e0!7i13312!8i6656!6m1!1e1";
    private String oldBrevardCourthouseStreetView = "https://www.google.com/maps/@28.6100322,-80.8091293,3a,75y,263.85h,92.34t/data=!3m6!1e1!3m4!1sySDKUsEHcKOiH1ei4UdCeA!2e0!7i13312!8i6656";
    private String porcherHouseStreetView = "https://www.google.com/maps/place/Porcher+House/@28.3537966,-80.7251224,3a,75y,88h,90t/data=!3m8!1e1!3m6!1sdtrTrgjuPX0AAAQIt__tbA!2e0!3e2!6s%2F%2Fgeo3.ggpht.com%2Fcbk%3Fpanoid%3DdtrTrgjuPX0AAAQIt__tbA%26output%3Dthumbnail%26cb_client%3Dmaps_sv.tactile.gps%26thumb%3D2%26w%3D203%26h%3D100%26yaw%3D88.242706%26pitch%3D0!7i13312!8i6656!4m2!3m1!1s0x88de01fef5fe7887:0x813ea742d8dbe913!6m1!1e1";

    private CharSequence trepHubDescription;
    private CharSequence apolloMemorialDescription;
    private CharSequence spaceCenterDescription;
    private CharSequence cocoaPlayhouseDescription;
    private CharSequence henegarCenterDescription;
    private CharSequence ponceStatueDescription;
    private CharSequence lighthouseDescription;
    private CharSequence stLukesChurchDescription;
    private CharSequence oldBrevardCourthouseDescription;
    private CharSequence porcherHouseDescription;

    private String trepHubImage = "@drawable/trephublogo";
    private String apolloMemorialImage = "@drawable/apollo1";
    private String spaceCenterImage = "@drawable/spacecenter";
    private String cocoaPlayhouseImage = "@drawable/playhouse";
    private String henegarCenterImage = "@drawable/henegar";
    private String ponceStatueImage = "@drawable/poncedeleon";
    private String lighthouseImage = "@drawable/lighthouse";
    private String stLukesChurchImage = "@drawable/stlukeschurch";
    private String oldBrevardCourthouseImage = "@drawable/courthouse";
    private String porcherHouseImage = "@drawable/porcherhouse";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        trepHubDescription = getText(R.string.trephubdescription);
        apolloMemorialDescription = getText(R.string.apollo1description);
        spaceCenterDescription = getText(R.string.spacecenterdescription);
        cocoaPlayhouseDescription = getText(R.string.playhousedescription);
        henegarCenterDescription = getText(R.string.henegardescription);
        ponceStatueDescription = getText(R.string.poncedeleondescription);
        lighthouseDescription = getText(R.string.lighthousedescription);
        stLukesChurchDescription = getText(R.string.stlukeschurchdescription);
        oldBrevardCourthouseDescription = getText(R.string.courthousedescription);
        porcherHouseDescription = getText(R.string.porcherhousedescription);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        Marker trepHubMarker = mMap.addMarker(new MarkerOptions()
                .position(trepHubCoords)
                .title("TrepHub")
                .snippet("TrepHub is the world's most kickass hackerspace!"));

        Marker spaceCenterMarker = mMap.addMarker(new MarkerOptions()
                .position(spaceCenterCoords)
                .title("Kennedy Space Center")
                .snippet("Kennedy Space Center is a NASA launch systems center."));

        Marker apolloMemorialMarker = mMap.addMarker(new MarkerOptions()
                .position(apolloMemorialCoords)
                .title("Apollo 1 Memorial")
                .snippet("Dedicated to the first manned mission of the lunar landing program."));

        Marker cocoaPlayhouseMarker = mMap.addMarker(new MarkerOptions()
                .position(cocoaPlayhouseCoords)
                .title("Historic Cocoa Playhouse Theater")
                .snippet("Opened in 1924, the Playhouse is a community theater."));

        Marker henegarCenterMarker = mMap.addMarker(new MarkerOptions()
                .position(henegarCenterCoords)
                .title("Henegar Center")
                .snippet("A community arts center providing cultural programs"));

        Marker ponceStatueMarker = mMap.addMarker(new MarkerOptions()
                .position(ponceStatueCoords)
                .title("Ponce de Leon Statue")
                .snippet("Commemorating Ponce De Leon's first landing in Florida."));

        Marker lighthouseMarker = mMap.addMarker(new MarkerOptions()
                .position(lighthouseCoords)
                .title("Cape Canaveral Lighthouse")
                .snippet("Built in 1848 to warn ships of dangerous shoals off the coast."));

        Marker stLukesChurchMarker = mMap.addMarker(new MarkerOptions()
                .position(stLukesChurchCoords)
                .title("St. Luke's Episcopal Church")
                .snippet("Historical church founded in the 1870s."));

        Marker oldBrevardCourthouseMarker = mMap.addMarker(new MarkerOptions()
                .position(oldBrevardCourthouseCoords)
                .title("Old Brevard County Courthouse")
                .snippet("A neoclassical Greek-style courthouse built in 1912."));

        Marker porcherHouseMarker = mMap.addMarker(new MarkerOptions()
                .position(porcherHouseCoords)
                .title("Porcher House")
                .snippet("The Porcher House is an example of 20th century classical revival architecture.")
        );

        locationCoordinates.add(trepHubCoords);
        locationCoordinates.add(spaceCenterCoords);
        locationCoordinates.add(apolloMemorialCoords);
        locationCoordinates.add(cocoaPlayhouseCoords);
        locationCoordinates.add(henegarCenterCoords);
        locationCoordinates.add(ponceStatueCoords);
        locationCoordinates.add(lighthouseCoords);
        locationCoordinates.add(stLukesChurchCoords);
        locationCoordinates.add(oldBrevardCourthouseCoords);
        locationCoordinates.add(porcherHouseCoords);

        locationMarkers.add(trepHubMarker);
        locationMarkers.add(spaceCenterMarker);
        locationMarkers.add(apolloMemorialMarker);
        locationMarkers.add(cocoaPlayhouseMarker);
        locationMarkers.add(henegarCenterMarker);
        locationMarkers.add(ponceStatueMarker);
        locationMarkers.add(lighthouseMarker);
        locationMarkers.add(stLukesChurchMarker);
        locationMarkers.add(oldBrevardCourthouseMarker);
        locationMarkers.add(porcherHouseMarker);

        locationDescriptions.add(trepHubDescription);
        locationDescriptions.add(spaceCenterDescription);
        locationDescriptions.add(apolloMemorialDescription);
        locationDescriptions.add(cocoaPlayhouseDescription);
        locationDescriptions.add(henegarCenterDescription);
        locationDescriptions.add(ponceStatueDescription);
        locationDescriptions.add(lighthouseDescription);
        locationDescriptions.add(stLukesChurchDescription);
        locationDescriptions.add(oldBrevardCourthouseDescription);
        locationDescriptions.add(porcherHouseDescription);

        locationURLs.add(trepHubURL);
        locationURLs.add(spaceCenterURL);
        locationURLs.add(apolloMemorialURL);
        locationURLs.add(cocoaPlayhouseURL);
        locationURLs.add(henegarCenterURL);
        locationURLs.add(ponceStatueURL);
        locationURLs.add(lighthouseURL);
        locationURLs.add(stLukesChurchURL);
        locationURLs.add(oldBrevardCourthouseURL);
        locationURLs.add(porcherHouseURL);

        imageURIs.add(trepHubImage);
        imageURIs.add(spaceCenterImage);
        imageURIs.add(apolloMemorialImage);
        imageURIs.add(cocoaPlayhouseImage);
        imageURIs.add(henegarCenterImage);
        imageURIs.add(ponceStatueImage);
        imageURIs.add(lighthouseImage);
        imageURIs.add(stLukesChurchImage);
        imageURIs.add(oldBrevardCourthouseImage);
        imageURIs.add(porcherHouseImage);

        locationStreetViews.add(trepHubStreetView);
        locationStreetViews.add(spaceCenterStreetView);
        locationStreetViews.add(apolloMemorialStreetView);
        locationStreetViews.add(cocoaPlayhouseStreetView);
        locationStreetViews.add(henegarCenterStreetView);
        locationStreetViews.add(ponceStatueStreetView);
        locationStreetViews.add(lighthouseStreetView);
        locationStreetViews.add(stLukesChurchStreetView);
        locationStreetViews.add(oldBrevardCourthouseStreetView);
        locationStreetViews.add(porcherHouseStreetView);



        trepHubMarker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationCoordinates.get(0)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20), 2000, null);
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker marker) {
                int markerIndex = locationMarkers.indexOf(marker);
                Marker clickedMarker = locationMarkers.get(locationMarkers.indexOf(marker));
                showLocationInfoDialog(markerIndex, clickedMarker, clickedMarker.getTitle());

            }
        });
    }

    public void goToNextLocation(View view) {
        currentLocation += 1;

        if (currentLocation == locationCoordinates.size()) {
            currentLocation = 0;
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLng(locationCoordinates.get(currentLocation)), 2000, null);
        Marker currentMarker = locationMarkers.get(currentLocation);
        currentMarker.showInfoWindow();
    }

    public void goToPreviousLocation(View view) {
        currentLocation -= 1;
        if (currentLocation < 0) {
            currentLocation = locationCoordinates.size() - 1;
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLng(locationCoordinates.get(currentLocation)), 2000, null);
        Marker currentMarker = locationMarkers.get(currentLocation);
        currentMarker.showInfoWindow();
    }

    public void showLocationInfoDialog(int markerIndex, Marker clickedMarker, String title) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.infodialog);
        dialog.setTitle(title);
        dialog.setCancelable(true);


        TextView moreInfoTextView = (TextView) dialog.findViewById(R.id.moreInfoTextView);

        moreInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationURL();
            }
        });

        TextView goToStreetTextView = (TextView) dialog.findViewById(R.id.goToStreetTextView);

       goToStreetTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStreetViewURL();
            }
        });

        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        text.setText(locationDescriptions.get(markerIndex));

        ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
        String uri = imageURIs.get(markerIndex);
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        img.setImageDrawable(res);

        dialog.show();
    }

    public void showLocationURL() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(locationURLs.get(currentLocation))));
    }
    public void showStreetViewURL() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(locationStreetViews.get(currentLocation))));
    }
}

/* Attributions:
    Kennedy Space Center Photo By NASA - NASA, Public Domain, https://commons.wikimedia.org/w/index.php?curid=28870542
    Apollo 1 Memorial photo By RadioFan at English Wikipedia, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=30434185
    Cocoa Playhouse Theater photo By Fl295 at English Wikipedia - Transferred from en.wikipedia to Commons., Public Domain, https://commons.wikimedia.org/w/index.php?curid=2611726
    Henegar Center Photo By Leonard J. DeFrancisci - Own work, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=9938990
    Old Brevard County Courthouse photo By Organizedchaos02 at the English language Wikipedia, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=7126148
    Porcher House Photo By Smallbones - Own work, Public Domain, https://commons.wikimedia.org/w/index.php?curid=8893928
    St Lukes Episcopal Church Photo By Fl295 at English Wikipedia - Transferred from en.wikipedia to Commons., Public Domain, https://commons.wikimedia.org/w/index.php?curid=2611883
    Cape Canaveral Lighthouse photo by James Humphreys - SalopianJamesPostprocessing by Liberal Freemason (talk) - Own work by SalopianJames & Liberal Freemason, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=7806620
    Ponce De Leon portrait By Unknown - http://whtime.cloudapp.net/EventDetails.aspx?e=75a51aad-303a-4158-9394-4a99267fdf71&t=/tl/chut/Juan_Ponce_de_Leon/, Public Domain, https://commons.wikimedia.org/w/index.php?curid=45533914
 */
