package boot;

import controller.Controller;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args) {
		MyView ui = new MyView();
		MyModel m = new MyModel();
		//Creating the contact between the view and the model to the controller
		//Controller c = new Controller(ui,m);
		//ui.addObserver(c);
		//m.addObserver(c);
		
		
	}

}
