package net.hitechgroupindia.hitechgroup;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;


public class LoginFragment extends Fragment {
    SessionManager sessionManager;
private  Button btn_login,btn_logout;
    private EditText edt_login_name, login_pass;
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
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        edt_login_name =(EditText) view.findViewById(R.id.edt_login_name);
         login_pass   =(EditText) view.findViewById(R.id.edt_login_password);
         btn_login =(Button)view.findViewById(R.id.btn_login);
         btn_logout =(Button)view.findViewById(R.id.btn_logoutss);

        sessionManager = new SessionManager(getActivity());
        HashMap<String, String> map = sessionManager.getUserDetails();
       final String  login_name  = map.get(SessionManager.KEY_EMAIL);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_login_name.getText().toString();
                if(!login_name.equals("")){
                     sessionManager.createLoginemail(name);
                    startActivity(new Intent(getActivity(),NavigationDrawerActivity.class));
                }
            }
        });
/*
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // sessionManager.logoutUser();

               // startActivity(new Intent(getActivity(), HomeActivity.class));
               // getActivity().finish();
            }
        });*/
        return view;
    }



}
