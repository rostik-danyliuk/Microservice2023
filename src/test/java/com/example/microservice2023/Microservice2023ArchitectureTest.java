package com.example.microservice2023;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
@SpringBootTest
class Microservice2023ArchitectureTest {
    private JavaClasses importedClasses;

    @BeforeEach
    void init(){
        importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.example.microservice2023");
    }

    @Test
    void testArchitectureThisProject(){
        layeredArchitecture()
                .consideringAllDependencies()
                .layer("ControllerRest").definedBy("..rest")
                .layer("ControllerGui").definedBy("..gui")
                .layer("Service").definedBy("..interfaces")
                .layer("ServiceImpl").definedBy("..impl")
                .layer("Repository").definedBy("..repository")
                .whereLayer("ControllerRest").mayNotBeAccessedByAnyLayer()
                .whereLayer("ControllerGui").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("ControllerRest", "Service",
                        "ServiceImpl", "ControllerGui")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service", "ServiceImpl")
                .check(importedClasses);
    }

    @Test
    void controllerClassesShouldHaveNamesController(){
        classes()
                .that()
                .resideInAPackage("..rest")
                .and()
                .resideInAPackage("..gui")
                .should()
                .haveSimpleNameEndingWith("Controller")
                .allowEmptyShould(true)
                .check(importedClasses);
    }

    @Test
    void serviceClassesShouldHaveNamesService(){
        classes()
                .that()
                .resideInAPackage("..interfaces")
                .should()
                .haveSimpleNameEndingWith("Service")
                .check(importedClasses);
    }

    @Test
    void serviceImplClassesShouldHaveNamesImpl(){
        classes()
                .that()
                .resideInAPackage("..impl")
                .should()
                .haveSimpleNameEndingWith("ServiceImpl")
                .check(importedClasses);
    }

    @Test
    void repositoryClassesShouldHaveNamesRepository(){
        classes()
                .that()
                .resideInAPackage("..repository")
                .should()
                .haveSimpleNameEndingWith("Repository")
                .check(importedClasses);
    }

    @Test
    void checkControllersAnnotations(){
        classes()
                .that()
                .resideInAPackage("..rest")
                .and()
                .resideInAPackage("..gui")
                .should()
                .beAnnotatedWith(RestController.class)
                .orShould()
                .beAnnotatedWith(Controller.class)
                .allowEmptyShould(true)
                .check(importedClasses);

    }

    @Test
    void checkRepositoryAnnotation(){
        classes()
                .that()
                .resideInAPackage("..repository")
                .should()
                .beAnnotatedWith(Repository.class)
                .check(importedClasses);
    }

    @Test
    void checkServiceImplAnnotation(){
        classes()
                .that()
                .resideInAPackage("..impl")
                .should()
                .beAnnotatedWith(Service.class)
                .check(importedClasses);
    }

    @Test
    void checkControllersRequestMapping(){
        classes()
                .that()
                .resideInAPackage("..rest")
                .and()
                .resideInAPackage("..gui")
                .should()
                .beAnnotatedWith(RequestMapping.class)
                .allowEmptyShould(true)
                .check(importedClasses);

    }

    @Test
    void testAutowiredAnnotation(){
        noFields()
                .should()
                .beAnnotatedWith(Autowired.class)
                .check(importedClasses);
    }
}