import controller.Controller;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final Controller controller = new Controller(new InputView(scanner), new OutputView());
            controller.initialize();
            controller.play();
            controller.showResult();
        }
    }
}
