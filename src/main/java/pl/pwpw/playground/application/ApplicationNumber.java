package pl.pwpw.playground.application;

import javax.persistence.Embeddable;

/**
 *
 */
@Embeddable
class ApplicationNumber {
    private String applicationNumber;

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }
}
