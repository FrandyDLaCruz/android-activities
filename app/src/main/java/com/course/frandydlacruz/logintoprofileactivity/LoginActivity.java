package com.course.frandydlacruz.logintoprofileactivity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    User user;
    Map<String, User> allowedUsers = new HashMap<>();
    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        Button btnLogin = findViewById(R.id.btnLogin);
        name = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);

        allowedUsers = setUsers(allowedUsers);

        if(btnLogin != null){
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String userName = name.getText().toString().toLowerCase();
                    String userPassword = password.getText().toString();

                    if(allowedUsers.containsKey(userName)){
                        if(allowedUsers.get(userName).getPassword().equals(userPassword)){
                            goToProfileView(allowedUsers.get(userName));
                        }
                        else {
                            showErrorDialog();
                            cleanFields();
                        }
                    }
                    else {
                        showErrorDialog();
                        cleanFields();
                    }
                }
            });
        }
    }

    private Map setUsers(Map<String, User> users){
        if (users != null && users.isEmpty()) {
            users.put("frandy de la cruz", new User("Frandy De La Cruz", "fd2018", R.drawable.photo_frandydelacruz,  "I'm studying Android", 15, 30, 10));
            users.put("wilson reyes", new User("Wilson Reyes", "wr2018", R.drawable.photo_wilsonreyes, "I'm teaching Android", 100, 150, 200));
            users.put("jaimico", new User("Jaimico", "j2018", R.drawable.photo_jaimico, "I'm wasting my time", 1, 1, 0));
            users.put("minion", new User("Minion", "m2018", R.drawable.photo_minion, "Banana!", 5, 500, 1000));
            users.put("popeye", new User("Popeye", "p2018", R.drawable.photo_popeye, "I'm Oliva's man and i like spinach", 5, 2, 20));
        }

        return users;
    }

    private void goToProfileView(User user){
        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    private void showErrorDialog(){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setTitle(R.string.activity_login_error_dialog_title_message);
        dlgAlert.setMessage(R.string.activity_login_error_dialog_body_message);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    private void cleanFields(){
        name.setText("");
        password.setText("");
    }
}
