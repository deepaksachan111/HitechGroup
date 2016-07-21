package net.hitechgroupindia.hitechgroup.Fragment;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;

import net.hitechgroupindia.hitechgroup.HomeActivity;
import net.hitechgroupindia.hitechgroup.NetworkConnectionChecker;
import net.hitechgroupindia.hitechgroup.R;
import net.hitechgroupindia.hitechgroup.SessionManager;


public class LoginWebView extends Fragment {

    private WebView webView;
    private LinearLayout linear_nointernet;
    SessionManager sessionManager ;
    public LoginWebView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login_web_view, container, false);

        webView = (WebView)v. findViewById(R.id.webView1);
        linear_nointernet =(LinearLayout)v.findViewById(R.id.linear_nointernet);

        NetworkConnectionChecker  connectionchecker = new NetworkConnectionChecker(getActivity());
       boolean isInternetPresent = connectionchecker.isConnectingToInternet();

        if (isInternetPresent) {

          SessionManager  sessionManager = new SessionManager(getActivity());
            sessionManager.createLoginemail("Deepak");
          //  startActivity(new Intent(getActivity(), HomeActivity.class));
            startWebView("http://hitechgroupindia.net/default.aspx");

        }
        else
        {
            new AlertDialog.Builder(getActivity())
                    .setTitle("Connection Failed !")
                    .setMessage("Unable to connect.Please check your network settings.")
                    .setPositiveButton("OK", null).show();
            linear_nointernet.setVisibility(View.VISIBLE);
        }
        return v;
    }


    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog = null;

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(getActivity());
                    progressDialog.getWindow().setGravity(Gravity.TOP);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();

                      /*  EditText edit_te =(EditText)findViewById(R.id.edit_te);
                        edit_te.setText(url);*/
                      //  progressDialog = null;
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });

        // Javascript inabled on webview
        webView.getSettings().setJavaScriptEnabled(true);

        // Other webview options
	    /*
	    webView.getSettings().setLoadWithOverviewMode(true);
	    webView.getSettings().setUseWideViewPort(true);
	    webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
	    webView.setScrollbarFadingEnabled(false);
	    webView.getSettings().setBuiltInZoomControls(true);
	    */

	    /*
	     String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         webview.loadData(summary, "text/html", null);
	     */

        //Load url in webview
        webView.loadUrl(url);


    }

    @Override
    public void onStop() {
        super.onStop();
     /*  sessionManager = new SessionManager(getActivity());
        sessionManager.logoutUser();*/
    }
}
