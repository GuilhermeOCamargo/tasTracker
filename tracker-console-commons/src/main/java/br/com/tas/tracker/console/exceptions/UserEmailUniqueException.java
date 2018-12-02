package br.com.tas.tracker.console.exceptions;

import br.com.tas.tracker.console.util.MessageUtil;
import br.com.tas.tracker.console.enums.ResourceBundles;

public class UserEmailUniqueException extends RuntimeException {
    @Override
    public String getMessage() {
        return MessageUtil.loadProperties(ResourceBundles.MESSAGES.getDesc())
                .getProperty("error.user.validation.email.unique");
    }
}
