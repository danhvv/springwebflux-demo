package dev.bluvolve.reactive.courseservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CategoryInitializer  {

//    private final ICategoryRepository repository;
//
//    public CategoryInitializer(ICategoryRepository repository) {
//        log.info("Run CategoryInitializer...");
//        this.repository = repository;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        if (this.repository.count() > 0){
//            log.info("Category items already created.");
//            return;
//        }
//
//        List<Category> categories = new ArrayList<>() {
//            {
//                add(new Category("Bootcamp"));
//                add(new Category("Circuit Training"));
//                add(new Category("Gymnastics"));
//                add(new Category("Outdoor"));
//                add(new Category("Weight Training"));
//            }
//        };
//
//        categories.forEach(category -> {
//            this.repository.save(category);
//            log.info("Category '{}' saved. ID: {}", category.getTitle(), category.getId());
//        });
//    }
}