package pl.sda.zdjavapol73.tasks.regularexpression;

public interface MailValidator {

    boolean isMailValid(String mail) throws MailInvalidException;
}
