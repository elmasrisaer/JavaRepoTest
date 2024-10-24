package net.celitech.celitech.validation.validators.modelValidators;

import java.util.Arrays;
import net.celitech.celitech.validation.Violation;
import net.celitech.celitech.validation.validators.AbstractValidator;

public abstract class AbstractModelValidator<T> extends AbstractValidator<T> {

  public AbstractModelValidator(String fieldName) {
    super(fieldName);
  }

  public AbstractModelValidator() {}

  protected abstract Violation[] validateModel(T value);

  @Override
  public Violation[] validate(T value) {
    Violation requiredViolation = validateRequired(value);
    if (requiredViolation != null) {
      return new Violation[] { requiredViolation };
    }
    if (value == null) {
      return new Violation[0];
    }

    Violation[] violations = validateModel(value);
    if (violations.length == 0) {
      return violations;
    }

    return Arrays
      .stream(violations)
      .map(violation -> {
        String newPath = violation.getPath().isEmpty()
          ? getFieldName()
          : String.format("%s.%s", getFieldName(), violation.getPath());
        return new Violation(newPath, violation.getMessage());
      })
      .toArray(Violation[]::new);
  }
}
