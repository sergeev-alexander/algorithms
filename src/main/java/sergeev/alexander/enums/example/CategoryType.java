package sergeev.alexander.enums.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CategoryType {
    KIDS("") {
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(KidsType.values());
        }
    },
    ADULTS("") {
        @Override
        public List<SubCategory> getSubCategories() {
            return Collections.emptyList();
        }
    };

    private String description;

    CategoryType(String description) {
        this.description = description;
    }

    public abstract List<SubCategory> getSubCategories();
}