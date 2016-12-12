package cat.tecnocampus.webController;

import cat.tecnocampus.exception.UserDoesNotExistsException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by roure on 12/12/2016.
 */
@ControllerAdvice
public class ControllersAdvice {
    /*
    This method is called whenever a UserLabUsernameAlreadyExistsException is signalled
    We can have Advising Controllers that handle exceptions from all the controllers (no just one).
    The advising controllers must be annotated with @ControllerAdvice and have one or more methods annotated
    with @ExceptionHandler
     */
    @ExceptionHandler
    public String handleUserDoesNotExist(UserDoesNotExistsException exception, Model model) {
        model.addAttribute("username", exception.getUsername());

        return "/error/userDoesNotExist";
    }


}
