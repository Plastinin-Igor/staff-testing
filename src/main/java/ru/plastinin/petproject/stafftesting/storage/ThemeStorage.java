package ru.plastinin.petproject.stafftesting.storage;

import ru.plastinin.petproject.stafftesting.model.Theme;

import java.util.Collection;

public interface ThemeStorage {
    Theme addTheme(Theme theme);

    Theme updateTheme(Theme theme);

    void deleteTheme(Long themeId);

    Collection<Theme> allTheme();

    Theme themeById(Long themeId);
}
