package sergeev.alexander.enums.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum KidsType implements SubCategory {
    PRIMER(""){
        @Override
        public List<SubCategory> getSubCategories() {
            return Collections.emptyList();
        }
    },
    FICTION(""){
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(FictionGenre.values());
        }
    };

    private String description;

    KidsType(String description) {
        this.description = description;
    }

}
