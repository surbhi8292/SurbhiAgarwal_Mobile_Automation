package TestFactory;

import PageMethods.HomePageMethods;
import PageObjects.CategoryPageObjects;
import PageObjects.HomePageObjects;
import PageObjects.ProductDetailsPageObjects;
import PageObjects.SearchPageObjects;

public class TestPageObjectsFactory {
    public HomePageObjects homePageObjects()
    {
        //HomePageObjects ho=new HomePageObjects();
        //return ho;
        return new HomePageObjects();
    }
    public CategoryPageObjects categoryPageObjects(){
        return new CategoryPageObjects();
    }
public ProductDetailsPageObjects productDetailsPageObjects(){
        return new ProductDetailsPageObjects();
}
public SearchPageObjects searchPageObjects(){
        return new SearchPageObjects();
}
}

