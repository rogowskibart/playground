package pl.pwpw.playground.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.pwpw.playground.application.ApplicationService;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    private JdbcTemplate jtm;

    @Override
    public Application getContactByApplicationNumber(String number) {
        List<Application> list = applicationRepository.findAll();
        Optional<Application> found = Optional.empty();
        for (Application a : list) {
            if (number.equals(a.getApplicationNumber().getApplicationNumber())) {
                found = Optional.of(a);
                break;
            }
        }
        Application application = found.get();
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
