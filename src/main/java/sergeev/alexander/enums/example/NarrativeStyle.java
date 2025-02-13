package sergeev.alexander.enums.example;

import java.util.Arrays;
import java.util.List;

public enum NarrativeStyle implements SubCategory {
    ANY {
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(BookSize.values());
        }
    },
    LIGHT {
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(BookSize.values());
        }
    },

    LITERARY {
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(BookSize.values());
        }
    },

    DYNAMIC {
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(BookSize.values());
        }
    }
}