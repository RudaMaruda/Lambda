package pl.sda.zdjavapol73.tasks.regularexpression;

import pl.sda.zdjavapol73.api.Task;

import java.util.regex.Pattern;

public class RegularExpressions implements Task {
    @Override
    public void run() {
        // PESEL validator 99071800012
        String peselFromUser = "990718000122";

        final PeselStringValidator peselStringvalidator = new PeselStringValidator();

        if (peselStringvalidator.isPeselValid(peselFromUser)) {
            System.out.println("Pesel is valid");
        } else {
            System.out.println("Pesel is invalid");
        }

        final PeselRegularExpressionValidator peselRegularExpressionValidator = new PeselRegularExpressionValidator();

        if (peselRegularExpressionValidator.isPeselValid(peselFromUser)) {
            System.out.println("Pesel is valid");
        } else {
            System.out.println("Pesel is invalid");
        }

        // check if mail is valid
        String mail = "sadfk_.j34@test.eu";
        String invalidMail = "t@t";
        MailValidator mailValidator = new MailRegexValidator();

        try {
            if (mailValidator.isMailValid(invalidMail)) {
                System.out.println("mail is valid");
            }
        } catch (MailInvalidException e) {
            System.out.println("mail is invalid");
        }
    }
}

class PeselStringValidator implements PeselValidator {

    @Override
    public boolean isPeselValid(String pesel) {
        if (pesel.length() == 11) {
            for (char c : pesel.toCharArray()) {
                if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' &&
                        c != '9' && c != '0') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

class PeselRegularExpressionValidator implements PeselValidator {

    @Override
    public boolean isPeselValid(String pesel) {
        Pattern pattern = Pattern.compile("[0-9]{11}");
        return pattern.matcher(pesel).matches();
    }
}

// implement MailValidator interface
// use regex to check if string is valid mail ^([\w\.-]+)@([\w\.-]+)\.(\w+)$
class MailRegexValidator implements MailValidator {

    @Override
    public boolean isMailValid(String mail) throws MailInvalidException {
        Pattern pattern = Pattern.compile("^" +
                "([\\w.-]+)" + // word, dot, - one or more times
                "@" +
                "([\\w.-]+)" +
                "\\." +
                "(\\w+)" +
                "$");
        if (pattern.matcher(mail).matches()) {
            return true;
        }
        throw new MailInvalidException();
    }
}
