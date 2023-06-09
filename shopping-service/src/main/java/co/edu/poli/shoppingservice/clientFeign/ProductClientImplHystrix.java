package co.edu.poli.shoppingservice.clientFeign;

import co.edu.poli.shoppingservice.helpers.Response;
import co.edu.poli.shoppingservice.helpers.ResponseBuild;
import co.edu.poli.shoppingservice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductClientImplHystrix implements ProductClient{

    private final ResponseBuild build;

    @Override
    public Response findById(Long id) {
        return build.success(new Product());
    }
}
