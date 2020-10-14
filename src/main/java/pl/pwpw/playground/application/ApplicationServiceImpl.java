package pl.pwpw.playground.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application getContactByApplicationNumber(String number) {
        Application application = new Application();
        List<Application> list = applicationRepository.findAll();
        Optional<Application> found = Optional.empty();
        for (Application a : list) {
            if (number.equals(a.getApplicationNumber().getApplicationNumber())) {
                found = Optional.of(a);
                break;
            }
        }
        if (found.isPresent()) {
            application = found.get();
        }
        return application;
    }

    @Override
    public Application getApplicationByEmail(String email) {
        Application application = new Application();
        List<Application> list = applicationRepository.findAll();
        Optional<Application> found = Optional.empty();
        for (Application a : list) {
            if (email.equals(a.getContactDetails().getEmailAddress().getEmailAddress())) {
                found = Optional.of(a);
                break;
            }
        }
        if (found.isPresent()) {
            application = found.get();
        }
        return application;
    }
}
