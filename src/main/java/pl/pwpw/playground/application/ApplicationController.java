package pl.pwpw.playground.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    private static Logger LOGGER = Logger.getLogger(ApplicationController.class.getName());
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/number/{applicationNumber}")
    public Application getApplicationByNumber(@PathVariable String applicationNumber) {
        LOGGER.log(Level.INFO, "Application number is: " + applicationNumber);
        return applicationService.getContactByApplicationNumber(applicationNumber);
    }

    @GetMapping("/email/{email}")
    public Application getApplicationByEmail(@PathVariable String email) {
        LOGGER.log(Level.INFO, "Application email is: " + email);
        return applicationService.getApplicationByEmail(email);
    }
}
