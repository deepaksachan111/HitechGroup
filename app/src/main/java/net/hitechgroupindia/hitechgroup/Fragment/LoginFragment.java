package net.hitechgroupindia.hitechgroup.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import net.hitechgroupindia.hitechgroup.DashboardFragment;
import net.hitechgroupindia.hitechgroup.HomeActivity;
import net.hitechgroupindia.hitechgroup.NavigationDrawerActivity;
import net.hitechgroupindia.hitechgroup.R;
import net.hitechgroupindia.hitechgroup.SessionManager;


public class LoginFragment extends Fragment {
    private  SessionManager sessionManager;

    public LoginFragment() {
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText edt_loginame =(EditText)view.findViewById(R.id.edt_login_name);
        final EditText password =(EditText)view.findViewById(R.id.edt_login_password);


        String st_password =  edt_loginame.getText().toString();

        sessionManager = new SessionManager(getActivity());



        Button btn_login =(Button)view.findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginname = edt_loginame.getText().toString();
                    sessionManager.createLoginemail(loginname);

                 // getFragmentManager().beginTransaction().replace(R.id.viewpager,new DashboardFragment()).commit();
               startActivity(new Intent(getActivity(), HomeActivity.class));
                getActivity().finish();
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        hideKeyboard(getActivity());
    }

    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        hideKeyboard(getActivity());
    }
}
