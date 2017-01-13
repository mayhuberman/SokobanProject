package boot;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args) {
		MyView ui = new MyView();
		MyModel m = new MyModel();
		//Creating the contact between the view and the model to the controller
		MyController c = new MyController(ui,m);
		ui.addObserver(c);
		m.addObserver(c);
		
		
	}

}
