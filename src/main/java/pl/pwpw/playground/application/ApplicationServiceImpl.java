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
            if (a.getApplicationNumber().getApplicationNumber().equals(number)) {
                found = Optional.of(a);
                break;
            }
        }
        Application application = found.get();
        return application;
    }

    @Override
    public Application getApplicationByEmail(String email) {
        String sql = "SELECT * FROM APPLICATION WHERE EMAIL_ADDRESS=?";
        Application application = jtm.queryForObject(sql, new Object[]{email},
                new BeanPropertyRowMapper<>(Application.class));
        return application;
    }
}
