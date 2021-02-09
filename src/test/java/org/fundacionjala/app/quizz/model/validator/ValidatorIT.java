package org.fundacionjala.app.quizz.model.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorIT {

    @Test
    public void testDateValidator() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("24/12/2021", null, errors);

        Assert.assertEquals(DateValidator.class, dateValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }
    @Test
    public void testMaxLengthValidator(){
        List<String> errors = new ArrayList<>();
        Validator maxLengthValidator = ValidatorType.MAX_LENGTH.getValidator();
        String conditionValue = "5";
        maxLengthValidator.validate("esto es el mensaje",conditionValue, errors);
        Assert.assertEquals(MaxLengthValidator.class, maxLengthValidator.getClass());
        Assert.assertEquals(errors.get(0),"The value length must not exceed "+conditionValue);
    }

    @Test
    public void testMaxValidator(){
        List<String> errors = new ArrayList<>();
        Validator maxValidator = ValidatorType.MAX.getValidator();
        String conditionValue = "5";
        maxValidator.validate("8",conditionValue, errors);
        Assert.assertEquals(MaxValidator.class, maxValidator.getClass());
        Assert.assertFalse(errors.isEmpty());
    }
    //OnlyUpperCaseTextValidator
    @Test
    public void testOnlyUpperCaseTextValidator(){
        List<String> errors = new ArrayList<>();
        Validator onlyUpperCaseTextValidator = ValidatorType.ONLY_UPPERCASE_TEXT.getValidator();
        onlyUpperCaseTextValidator.validate("HOLA",null, errors);
        Assert.assertEquals(OnlyUpperCaseTextValidator.class, onlyUpperCaseTextValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }
}
