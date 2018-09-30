package Enums;

public enum ErrorsEnum {
    INVALID_FIELD("Поле неправильно заполнено"), NOT_CORRECT_FIELD("Поле заполнено некорректно"),WRONG_FIELD("Поле заполнено неверно"),AMOUNT_WRONG_FIELD("Сумма добровольного страхования не может быть больше итоговой суммы."), MIN_FIELD("Минимум — 10 \u20BD"),MAX_FIELD("Максимум — 15 000 \u20BD");
    String value;

    ErrorsEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

