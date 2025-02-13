package sergeev.alexander.enums.example;

import java.util.Arrays;
import java.util.List;

public enum BookSize implements SubCategory {
    ANY{
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(PlotTempo.values());
        }
    },
    SMALL{
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(PlotTempo.values());
        }
    },
    MEDIUM{
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(PlotTempo.values());
        }
    },
    BIG{
        @Override
        public List<SubCategory> getSubCategories() {
            return Arrays.asList(PlotTempo.values());
        }
    }
}
