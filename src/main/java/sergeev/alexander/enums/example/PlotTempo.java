package sergeev.alexander.enums.example;

import java.util.Collections;
import java.util.List;

public enum PlotTempo implements SubCategory {
    ANY,
    SLOW,
    FAST,
    BALANCE;
    @Override
    public List<SubCategory> getSubCategories() {
        return Collections.emptyList();
    }
}
