package cal.one;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {
	int x,y,z;
	Button b1,b2,b3,b4;
	EditText e1,e2;
	TextView tv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1=(Button)findViewById(R.id.button2);      
        b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button4);
        b4=(Button)findViewById(R.id.button5);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        tv=(TextView)findViewById(R.id.textView1);
        //b1.setOnClickListener(new OnClickListener();
        //b2.setOnClickListener(new OnClickListener();
       // b3.setOnClickListener(new OnClickListener();
       b1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			super.onClick(arg0);
			try
			{
			int x,y,z;
			x=Integer.parseInt(e1.getText().toString());
			y=Integer.parseInt(e2.getText().toString());
			z=x+y;
			tv.setText("Result is:"+z);
			}
			catch(Exception e)
			{
				Toast.makeText(getBaseContext(), "invalid input", 4000).show();
		
			}
			
		}
    	   
       });
       b2.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			super.onClick(arg0);
			try
			{
			int x,y,z;
			x=Integer.parseInt(e1.getText().toString());
			y=Integer.parseInt(e2.getText().toString());
			z=x-y;
			tv.setText("Result is:"+z);
			}
			catch(Exception e)
			{
				Toast.makeText(getBaseContext(), "invalid input", 4000).show();
		
			
		}
		}
    	   
       });
       b3.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			super.onClick(arg0);
			try
			{
			int x,y,z;
			b3.setBackgroundResource(R.drawable.ic_launcher);
			x=Integer.parseInt(e1.getText().toString());
			y=Integer.parseInt(e2.getText().toString());
			z=x*y;
			tv.setText("Result is:"+z);
			}
			catch(Exception e)
			{
				Toast.makeText(getBaseContext(), "invalid input", 4000).show();
		}
			
		}}
       );
       b4.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			super.onClick(arg0);
			try
			{
			int x,y,z;
			x=Integer.parseInt(e1.getText().toString());
			y=Integer.parseInt(e2.getText().toString());
			z=x/y;
			tv.setText("Result is:"+z);
			}
			catch(Exception e)
			{
				Toast.makeText(getBaseContext(), "invalid input", 4000).show();
		
		}}
       });
        

			
    
}
}