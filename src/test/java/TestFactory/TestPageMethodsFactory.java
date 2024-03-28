package TestFactory;

import PageMethods.CategoryPageMethods;
import PageMethods.HomePageMethods;
import PageMethods.ProductDetailsPageMethods;
import PageMethods.SearchPageMethods;

public class TestPageMethodsFactory {
    public HomePageMethods homePageMethods()
    {
        //HomePageMethods hm=new HomePageMethods();
        //return hm;
        return new HomePageMethods();};
    public CategoryPageMethods categoryPageMethods()
    {
        return new CategoryPageMethods();
    }
public ProductDetailsPageMethods productDetailsPageMethods(){
        return new ProductDetailsPageMethods();
}
public SearchPageMethods searchPageMethods(){
        return new SearchPageMethods();
}

}
