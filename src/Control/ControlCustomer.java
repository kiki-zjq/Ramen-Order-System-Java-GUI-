package Control;

import Entity.Customer;

public class ControlCustomer {

    public Customer chkCustomer(Customer customer) {
        // Get the message from customer.
        String firname = customer.getFirname().toLowerCase();
        String surname = customer.getSurname().toLowerCase();
        String email = customer.getEmail();
        String mobile = customer.getMobile();
        // Judge whether the input is null.
        if (firname.isEmpty() || surname.isEmpty()) {
            // JudgeCode = 001 indicates that the information is incomplete.
            customer.setJudgeCode("111");
            return customer;
        } else if (email.isEmpty() && mobile.isEmpty()) {
            // JudgeCode = 001 indicates that the information is incomplete.
            customer.setJudgeCode("001");
            return customer;
        }
        // Judge whether the firname is incorrect.
        for (int i = 0; i < firname.length(); i++) {
            char ch = firname.charAt(i);
            if (ch < 'a' || ch > 'z') {
                // JudgeCode = 010 indicates the firname is incorrect.
                customer.setJudgeCode("010");
                return customer;
            }
        }
        // First letter of firname uppercase to adjust format.
        firname = firname.substring(0, 1).toUpperCase() + firname.substring(1);
        // Judge whether the firname is incorrect.
        for (int i = 0; i < surname.length(); i++) {
            char ch = surname.charAt(i);
            if (ch < 'a' || ch > 'z') {
                // JudgeCode = 011 indicates the surname is incorrect.
                customer.setJudgeCode("011");
                return customer;
            }
        }
        // First letter of firname uppercase to adjust format.
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        // Judge whether the E-mail is incorrect.
        if (!email.isEmpty()) {
            int countAt = 0;    // Save the number of '@'
            int indexAt = 0;    // Save the position of '@'
            int indexPoint = 0; // Save the position of '.'
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (ch == '@') {
                    countAt++;
                    indexAt = i;
                }
                if (ch == '.') {
                    indexPoint = i;
                }
            }
            if (countAt != 1 || indexAt >= indexPoint - 1
                    || indexAt == 0 || indexPoint == email.length() - 1) {
                // JudgeCode = 100 indicates the E-mail is incorrect.
                customer.setJudgeCode("100");
                return customer;
            } else {
            }
        }
        // Judge whether the mobile number is incorrect.
        if (!mobile.isEmpty()) {
            for (int i = 0; i < mobile.length(); i++) {
                char ch = mobile.charAt(i);
                if (ch < '0' || ch > '9') {
                    // JudgeCode = 101 indicates the mobile number is incorrect.
                    customer.setJudgeCode("101");
                    return customer;
                }
            }
        }
        // JudgeCode = 000 indicates the input is correct.
        customer.setJudgeCode("000");
        if(mobile.isEmpty()) {
            customer.setMobile("null");
        }
        if (email.isEmpty()) {
            customer.setEmail("null");
        }
        customer.setFirname(firname);
        customer.setSurname(surname);
        return customer;
    }
}
