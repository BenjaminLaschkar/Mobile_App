package com.example.benjamin.youtubefinder;



        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;



public class MainActivity extends AppCompatActivity
{

    private Button hellobutton ;
    private EditText textbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hellobutton = (Button) findViewById(R.id.bouton) ;
        textbox = (EditText) findViewById(R.id.editText) ;
        hellobutton.setText("Chercher sur youtube !");
        hellobutton.setOnClickListener(new MyOnClickListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            textbox.setText(data.getStringExtra("editText2"));
        }
    }
    private class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            int REQUEST_CODE=1;
            Intent nextScreen = new Intent(MainActivity.this, SecondActivity.class);
            nextScreen.putExtra("editText", textbox.getText().toString());
            startActivityForResult(nextScreen,REQUEST_CODE);
        }

    }

}