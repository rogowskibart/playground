package pl.pwpw.playground.application;

import pl.pwpw.playground.application.Application;

public interface ApplicationService {

    public Application getContactByApplicationNumber(String number);
    public Application getApplicationByEmail(String email);
}
