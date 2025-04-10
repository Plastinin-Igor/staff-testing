package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class QuestionUpdateDto {
    private Long questionId;
    private Long theme;
    private int curNumber;
    private String content;
    private String helpText;

    public boolean hasTheme() {
        return (theme != 0);
    }

    public boolean hasCurNumber() {
        return (curNumber != 0);
    }

    public boolean hasContent() {
        return !(content == null || content.isBlank());
    }

    public boolean hasHelpText() {
        return !(helpText == null || helpText.isBlank());
    }


}
