package sergeev.alexander.enums.example;

import java.util.Arrays;
import java.util.List;

public enum FictionGenre implements SubCategory {

    ANY,
    FAIRY_TALES,
    CHILDRENS_POEMS,
    CHILDRENS_PROSE,
    CHILDRENS_DETECTIVES,
    CHILDRENS_FANTASY,
    CHILDRENS_ADVENTURES,
    BOOKS_FOR_TEENAGERS;
    @Override
    public List<SubCategory> getSubCategories() {
        return Arrays.asList(NarrativeStyle.values());
    }
}
