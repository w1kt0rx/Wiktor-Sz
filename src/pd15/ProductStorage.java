package pd15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductStorage {
    private final List<Product> productList = new ArrayList<>();

    public void add(Product product){
        productList.add(product);
    }

    public void remove(Product product){
        productList.remove(product);
    }

    public List<Product> getProductList(){
        return Collections.unmodifiableList(productList);
    }

}
