package sergeev.alexander.enums.example;

import java.util.ArrayList;
import java.util.List;

public class Controller {

//    @RateLimit(maxRequests = 5)
//    @PostMapping("get/{params}")
//    public Object get(@PathVariable String[] params) {
//        List<SubCategory> subCategories = new ArrayList<>();
//
//        CategoryType categoryType = CategoryType.valueOf(params[0].toUpperCase());
//        subCategories = categoryType.getSubCategories();
//
//        for (int i = 1; i < params.length; i++) {
//            String subCategory = params[i];
//            subCategories = subCategories.stream()
//                    .filter(sub -> (sub instanceof Enum) && ((Enum<?>) sub).name().equalsIgnoreCase(subCategory))
//                    .findFirst()
//                    .map(SubCategory::getSubCategories)
//                    .orElseThrow(() -> new IllegalArgumentException("Unknown subcategory: " + subCategory));
//        }
//
//        return subCategories;
}
