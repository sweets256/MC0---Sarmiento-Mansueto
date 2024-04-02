import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleController {
    private TitleScreenView view;
    private Navigation model;

    public TitleController(TitleScreenView view, Navigation model) {
        this.view = view;
        this.model = model;

        view.addStartButtonListener(new StartButtonListener());
        view.addExitButtonListener(new ExitButtonListener());
    }

    // ActionListener for the Start button
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.titleScreen();
        }
    }

    // ActionListener for the Exit button
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
