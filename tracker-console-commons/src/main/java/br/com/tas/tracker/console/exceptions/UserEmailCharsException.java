package br.com.tas.tracker.console.exceptions;

import br.com.tas.tracker.console.Util.MessageUtil;
import br.com.tas.tracker.console.enums.ResourceBundles;

public class UserEmailCharsException extends RuntimeException {
    @Override
    public String getMessage() {
        return MessageUtil.loadProperties(ResourceBundles.MESSAGES.getDesc())
                .getProperty("error.user.validation.email.chars");
    }
}
